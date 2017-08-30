package com.aapeli.connection;

import com.aapeli.applet.AApplet;
import com.aapeli.client.Parameters;
import org.moparforia.client.Launcher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Vector;

public final class Connection implements Runnable {

    public static final int DCR_UNDEFINED = 0;
    public static final int DCR_BYUSER = 1;
    public static final int DCR_NORETRY = 2;
    public static final int DCR_RETRYFAIL = 3;
    public static final int DCR_VERSION = 4;
    public static final int DCR_HANDLEFAILED = 5;
    private static final String aString1608 = "UTF-8";
    private AApplet gameApplet;
    private Parameters params;
    private ConnListener connListener;
    private GameCipher gameCipher;
    private int state;
    private int disconnectReason;
    private boolean closed;
    private boolean aBoolean1616;
    private Socket socket;
    private BufferedReader sockIn;
    private BufferedWriter sockOut;
    private long clientId;
    private int anInt1621;
    private GameQueue gameQueue;
    private GamePacketQueue gamePacketQueue;
    private Vector thriftLogs;
    private long numReceivedGamePackets;
    private long connActivityTime;
    private ConnCipher connCipher;
    private Thread thread;


    public Connection(AApplet var1, ConnListener var2, String[] var3) {
        this(var1, var1.param, var2, var3);
    }

    public Connection(Parameters var1, ConnListener var2, String[] var3) {
        this((AApplet) null, var1, var2, var3);
    }

    private Connection(AApplet var1, Parameters var2, ConnListener var3, String[] gameCipherCmds) {
        this.gameApplet = var1;
        this.params = var2;
        this.connListener = var3;
        if (var1 != null) {
            var1.setConnectionReference(this);
        }

        int connCipherMagic = 4;
        if(Launcher.isUsingCustomServer())
            gameCipherCmds = null;
        if (gameCipherCmds != null) {
            this.gameCipher = new GameCipher(gameCipherCmds);
            connCipherMagic = this.gameCipher.getConnCipherMagic();
        }

        this.clientId = -1L;
        this.anInt1621 = 25;
        this.gameQueue = new GameQueue();
        this.thriftLogs = new Vector();
        this.numReceivedGamePackets = -1L;
        this.state = 0;
        this.disconnectReason = DCR_UNDEFINED;
        this.closed = this.aBoolean1616 = false;
        this.connCipher = new ConnCipher(connCipherMagic);
    }

    public void run() {
        this.gamePacketQueue = new GamePacketQueue(this, this.connListener);

        try {
            do {
                if (this.state == 1) {
                    this.method1778();
                } else if (this.state == 2) {
                    this.method1777();
                } else if (this.state == 3) {
                    this.method1791();
                }

                if (this.closed) {
                    if (this.processGameQueue()) {
                        this.writeLineC("end");
                    }

                    this.state = 4;
                    this.disconnectReason = DCR_BYUSER;
                }

                if (this.aBoolean1616) {
                    this.state = 4;
                    this.disconnectReason = DCR_HANDLEFAILED;
                }
            } while (this.state != 4);
        } catch (Exception var2) {
            ;
        } catch (Error var3) {
            ;
        }

        this.close();
        this.gamePacketQueue.stop();
        this.connListener.connectionLost(this.disconnectReason);
    }

    public boolean openConnection() {
        if (this.state != 0) {
            throw new IllegalStateException("Connection already opened");
        } else if (!this.connect()) {
            this.state = 4;
            return false;
        } else {
            this.state = 1;
            this.thread = new Thread(this);
            this.thread.start();
            return true;
        }
    }

    public void writeData(String var1) {
        if (this.state == 0) {
            throw new IllegalStateException("Connection not yet open");
        } else if (this.state != 4) {
            if(Launcher.debug())
                System.out.println("CLIENT> WRITE \"d " + gameQueue.sendSeqNum + " " + var1 + "\"");
            if (this.gameCipher != null) {
                var1 = this.gameCipher.encrypt(var1);
            }

            this.gameQueue.add(var1);
        }
    }

    public void writeThriftLog(int var1, String var2, String var3) {
        String var4 = "tlog\t" + var1 + "\t" + var2;
        if (var3 != null) {
            var4 = var4 + "\t" + var3;
        }

        this.thriftLogs.addElement(var4);
    }

    public void closeConnection() {
        if (this.state == 0) {
            throw new IllegalStateException("Connection not yet even opened");
        } else if (this.state != 4 || this.thread != null) {
            this.closed = true;
            this.state = 4;
            this.thread.interrupt();
        }
    }

    public String getLocalIP() {
        return null;
    }

    protected void method1775() {
        this.aBoolean1616 = true;
        this.state = 4;
        this.thread.interrupt();
    }

    private boolean connect() {
        try {
            String var1 = this.params.getServerIp();
            int var2 = this.params.getServerPort();
            this.socket = new Socket(var1, var2);
            InputStream var3 = this.socket.getInputStream();
            OutputStream var4 = this.socket.getOutputStream();

            InputStreamReader var5;
            OutputStreamWriter var6;
            try {
                var5 = new InputStreamReader(var3, "UTF-8");
                var6 = new OutputStreamWriter(var4, "UTF-8");
            } catch (UnsupportedEncodingException var8) {
                var5 = new InputStreamReader(var3);
                var6 = new OutputStreamWriter(var4);
            }

            this.sockIn = new BufferedReader(var5);
            this.sockOut = new BufferedWriter(var6);
            this.socket.setSoTimeout(250);
            this.connActivityTime = System.currentTimeMillis();
            return true;
        } catch (Exception var9) {
            return false;
        }
    }

    private void method1777() {
        this.method1779();
        if (this.state == 2) {
            this.method1778();
        }

    }

    private void method1778() {
        this.readInput();
        if (this.state == 2) {
            this.checkConnActivity();
        }

    }

    private void method1779() {
        this.processGameQueueDisconnect();
        if (this.state == 2) {
            this.processThriftLogs();
        }

    }

    private void processGameQueueDisconnect() {
        do {
            String var1 = this.gameQueue.pop();
            if (var1 == null) {
                return;
            }

            if (!this.writeLineD(var1)) {
                this.disconnect();
            }
        } while (this.state == 2);

    }

    private void processThriftLogs() {
        while (true) {
            if (this.state == 2 && !this.thriftLogs.isEmpty()) {
                String var1 = (String) ((String) this.thriftLogs.firstElement());
                this.thriftLogs.removeElementAt(0);
                if (this.writeLineS(var1)) {
                    continue;
                }

                this.disconnect();
                return;
            }

            return;
        }
    }

    private boolean processGameQueue() {
        String var1;
        do {
            var1 = this.gameQueue.pop();
            if (var1 == null) {
                return true;
            }
        } while (this.writeLineD(var1));

        return false;
    }

    private void disconnect() {
        if (this.state == 2 && this.anInt1621 > 0) {
            this.close();
            this.state = 3;
            this.connListener.notifyConnectionDown();
        } else {
            this.state = 4;
            this.disconnectReason = DCR_NORETRY;
        }

    }

    private boolean writeLineC(String var1) {
        return this.writeLine("c " + var1);
    }

    private boolean writeLineD(String var1) {
        return this.writeLine("d " + var1);
    }

    private boolean writeLineS(String var1) {
        return this.writeLine("s " + var1);
    }

    private boolean writeLine(String var1) {
        try {
            if(!var1.startsWith("d ") && Launcher.debug())
                System.out.println("CLIENT> WRITE \"" + var1 + "\"");
            if(!Launcher.isUsingCustomServer())
                var1 = this.connCipher.encrypt(var1);
            this.sockOut.write(var1);
            this.sockOut.newLine();
            this.sockOut.flush();
            return true;
        } catch (IOException var3) {
            return false;
        }
    }

    private void readInput() {
        String cmd = this.readLine();
        if (cmd != null) {
            this.connActivityTime = System.currentTimeMillis();
            char cmdtype = cmd.charAt(0);
            cmd = cmd.substring(2);
            int firstSpace;
            if (cmdtype == 'h') {// not sure what
                firstSpace = Integer.parseInt(cmd);// it's always 1... ALWAYS
                if (firstSpace != 1) {
                    this.state = 4;
                    this.disconnectReason = DCR_VERSION;
                }
            } else if (cmdtype == 'c') {// connection related
                if (cmd.startsWith("io ")) {
                    this.connCipher.initialise(Integer.parseInt(cmd.substring(3)));
                } else if (cmd.startsWith("crt ")) {
                    this.anInt1621 = Integer.parseInt(cmd.substring(4));
                } else if (cmd.equals("ctr")) {
                    if (this.clientId == -1L) {
                        this.writeLineC("new");
                    } else {
                        this.writeLineC("old " + this.clientId);
                    }
                } else if (cmd.startsWith("id ")) {
                    long var6 = Long.parseLong(cmd.substring(3));
                    this.clientId = var6;
                    this.state = 2;
                } else if (cmd.equals("rcok")) {
                    this.state = 2;
                    this.connListener.notifyConnectionUp();
                } else if (cmd.equals("rcf")) {
                    this.state = 4;
                    this.disconnectReason = DCR_RETRYFAIL;
                } else if (cmd.equals("ping")) {
                    this.writeLineC("pong");
                }
            } else if (cmdtype == 'p') {
                if (cmd.startsWith("kickban ") && this.gameApplet != null) {
                    firstSpace = Integer.parseInt(cmd.substring(8));
                    this.gameApplet.setEndState(firstSpace == 1 ? AApplet.END_ERROR_KICK_NOW
                            : (firstSpace == 2 ? AApplet.END_ERROR_KICKBAN_NOW
                            : (firstSpace == 3 ? AApplet.END_ERROR_BAN_INIT
                            : AApplet.END_ERROR_TOOMANYIP_INIT)));
                }
            } else if (cmdtype == 's') {
                if (cmd.startsWith("json ")) {
                    String var7 = cmd.substring(5);
                    this.params.callJavaScriptJSON(var7);
                }
            } else if (cmdtype == 'd') {
                firstSpace = cmd.indexOf(' ');
                long numServerSentPaketz = Long.parseLong(cmd.substring(0, firstSpace));
                if (numServerSentPaketz > this.numReceivedGamePackets) {
                    if (numServerSentPaketz > this.numReceivedGamePackets + 1L) {
                        this.state = 4;
                        this.disconnectReason = DCR_RETRYFAIL;
                    } else {
                        cmd = cmd.substring(firstSpace + 1);
                        if (this.gameCipher != null) {
                            cmd = this.gameCipher.decrypt(cmd);
                        }

                        if(Launcher.debug())
                            System.out.println("CLIENT> READ \"d " + numServerSentPaketz + " " + cmd + "\"");
                        this.gamePacketQueue.addGamePacket(cmd);
                        ++this.numReceivedGamePackets;
                    }
                }
            }

        }
    }

    private String readLine() {
        try {
            String var1 = this.sockIn.readLine();
            if (var1 != null) {
                if(!Launcher.isUsingCustomServer())
                    var1 = this.connCipher.decrypt(var1);
                if(!var1.startsWith("d ") && Launcher.debug())
                    System.out.println("CLIENT> READ \"" + var1 + "\"");
                return var1;
            }
        } catch (InterruptedIOException var2) {
            return null;
        } catch (IOException var3) {
            ;
        }

        this.disconnect();
        return null;
    }

    private void checkConnActivity() {
        long time = System.currentTimeMillis();
        if (time > this.connActivityTime + 20000L) {
            this.disconnect();
        }

    }

    private void method1791() {
        long var1 = System.currentTimeMillis() + (long) ((this.anInt1621 + 12) * 1000);

        do {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException var4) {
                ;
            }

            if (this.state != 3) {
                return;
            }

            if (this.connect()) {
                this.connCipher.reset();
                this.gameQueue.clear();
                this.state = 1;
                return;
            }
        } while (System.currentTimeMillis() < var1);

        this.state = 4;
        this.disconnectReason = DCR_RETRYFAIL;
    }

    private void close() {
        if (this.sockIn != null) {
            try {
                this.sockIn.close();
            } catch (IOException var4) {
                ;
            }

            this.sockIn = null;
        }

        if (this.sockOut != null) {
            try {
                this.sockOut.close();
            } catch (IOException var3) {
                ;
            }

            this.sockOut = null;
        }

        if (this.socket != null) {
            try {
                this.socket.close();
            } catch (IOException var2) {
                ;
            }

            this.socket = null;
        }

    }
}
