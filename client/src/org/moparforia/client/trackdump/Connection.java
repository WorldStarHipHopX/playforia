package org.moparforia.client.trackdump;

import java.io.*;
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
    private ConnListener aConnListener1611;
    private GameCrypto aGameCrypto_1612;
    private int anInt1613;
    private int disconnectReason;
    private boolean aBoolean1615;
    private boolean aBoolean1616;
    private Socket aSocket1617;
    private BufferedReader in;
    private BufferedWriter out;
    private long aLong1620;
    private int anInt1621;
    private Class98 aClass98_1622;
    private GamePacketQueue aGamePacketQueue_1623;
    private Vector aVector1624;
    private long numReceivedGamePackets;
    private long lastCmdReceived;
    private ConnCrypto connCrypto;
    private Thread aThread1628;
    public static int anInt1629;

    public Connection(ConnListener var3, String[] var4) {
        this.aConnListener1611 = var3;

        int cryptoseedmaybe = 4;
        if (var4 != null) {
            this.aGameCrypto_1612 = new GameCrypto(var4);
            cryptoseedmaybe = this.aGameCrypto_1612.method1793();
        }

        this.aLong1620 = -1L;
        this.anInt1621 = 25;
        this.aClass98_1622 = new Class98();
        this.aVector1624 = new Vector();
        this.numReceivedGamePackets = -1L;
        this.anInt1613 = 0;
        this.disconnectReason = 0;
        this.aBoolean1615 = this.aBoolean1616 = false;
        this.connCrypto = new ConnCrypto(cryptoseedmaybe);
    }

    public void run() {
        this.aGamePacketQueue_1623 = new GamePacketQueue(this, this.aConnListener1611);

        try {
            do {
                if (this.anInt1613 == 1) {
                    this.method1778();
                } else if (this.anInt1613 == 2) {
                    this.method1777();
                } else if (this.anInt1613 == 3) {
                    this.method1791();
                }

                if (this.aBoolean1615) {
                    if (this.method1782()) {
                        this.writeLineC("end");
                    }

                    this.anInt1613 = 4;
                    this.disconnectReason = 1;
                }

                if (this.aBoolean1616) {
                    this.anInt1613 = 4;
                    this.disconnectReason = 5;
                }
            } while (this.anInt1613 != 4);
        } catch (Exception var2) {
            ;
        } catch (Error var3) {
            ;
        }

        this.method1792();
        this.aGamePacketQueue_1623.stop();
        this.aConnListener1611.connectionLost(this.disconnectReason);
    }

    public boolean connect() {
        if (this.anInt1613 != 0) {
            throw new IllegalStateException("Connection already opened");
        } else if (!this.method1776()) {
            this.anInt1613 = 4;
            return false;
        } else {
            this.anInt1613 = 1;
            this.aThread1628 = new Thread(this);
            this.aThread1628.start();
            return true;
        }
    }

    public void writeData(String var1) {
        if (this.anInt1613 == 0) {
            throw new IllegalStateException("Connection not yet open");
        } else if (this.anInt1613 != 4) {
            //System.out.println("CLIENT> WRITE \"d " + aClass98_1622.sendSeqNum + " " + var1 + "\"");
            if (this.aGameCrypto_1612 != null) {
                var1 = this.aGameCrypto_1612.encrypt(var1);
            }

            this.aClass98_1622.method1772(var1);
        }
    }

    public void writeThriftLog(int var1, String var2, String var3) {
        String var4 = "tlog\t" + var1 + "\t" + var2;
        if (var3 != null) {
            var4 = var4 + "\t" + var3;
        }

        this.aVector1624.addElement(var4);
    }

    public void disconnect() {
        if (this.anInt1613 == 0) {
            throw new IllegalStateException("Connection not yet even opened");
        } else if (this.anInt1613 != 4 || this.aThread1628 != null) {
            this.aBoolean1615 = true;
            this.anInt1613 = 4;
            this.aThread1628.interrupt();
        }
    }

    public String getLocalIP() {
        return null;
    }

    protected void method1775() {
        this.aBoolean1616 = true;
        this.anInt1613 = 4;
        this.aThread1628.interrupt();
    }

    private boolean method1776() {
        try {
            this.aSocket1617 = new Socket("game05.playforia.net", 4242);
            InputStream var3 = this.aSocket1617.getInputStream();
            OutputStream var4 = this.aSocket1617.getOutputStream();

            InputStreamReader var5;
            OutputStreamWriter var6;
            try {
                var5 = new InputStreamReader(var3, "UTF-8");
                var6 = new OutputStreamWriter(var4, "UTF-8");
            } catch (UnsupportedEncodingException var8) {
                var5 = new InputStreamReader(var3);
                var6 = new OutputStreamWriter(var4);
            }

            this.in = new BufferedReader(var5);
            this.out = new BufferedWriter(var6);
            this.aSocket1617.setSoTimeout(250);
            this.lastCmdReceived = System.currentTimeMillis();
            return true;
        } catch (Exception var9) {
            var9.printStackTrace();
            return false;
        }
    }

    private void method1777() {
        this.method1779();
        if (this.anInt1613 == 2) {
            this.method1778();
        }

    }

    private void method1778() {
        this.method1788();
        if (this.anInt1613 == 2) {
            this.method1790();
        }

    }

    private void method1779() {
        this.method1780();
        if (this.anInt1613 == 2) {
            this.method1781();
        }

    }

    private void method1780() {
        do {
            String var1 = this.aClass98_1622.method1773();
            if (var1 == null) {
                return;
            }

            if (!this.writeLineD(var1)) {
                this.method1783();
            }
        } while (this.anInt1613 == 2);

    }

    private void method1781() {
        while (true) {
            if (this.anInt1613 == 2 && !this.aVector1624.isEmpty()) {
                String var1 = (String) ((String) this.aVector1624.firstElement());
                this.aVector1624.removeElementAt(0);
                if (this.writeLineS(var1)) {
                    continue;
                }

                this.method1783();
                return;
            }

            return;
        }
    }

    private boolean method1782() {
        String var1;
        do {
            var1 = this.aClass98_1622.method1773();
            if (var1 == null) {
                return true;
            }
        } while (this.writeLineD(var1));

        return false;
    }

    private void method1783() {
        if (this.anInt1613 == 2 && this.anInt1621 > 0) {
            this.method1792();
            this.anInt1613 = 3;
            this.aConnListener1611.notifyConnectionDown();
        } else {
            this.anInt1613 = 4;
            this.disconnectReason = 2;
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
            //if(!var1.startsWith("d "))
                //System.out.println("CLIENT> WRITE \"" + var1 + "\"");
            var1 = this.connCrypto.encrypt(var1);
            this.out.write(var1);
            this.out.newLine();
            this.out.flush();
            return true;
        } catch (IOException var3) {
            return false;
        }
    }

    private void method1788() {
        String cmd = this.readLine();
        if (cmd != null) {
            this.lastCmdReceived = System.currentTimeMillis();
            char cmdtype = cmd.charAt(0);
            cmd = cmd.substring(2);
            int firstSpace;
            if (cmdtype == 'h') {// not sure what
                firstSpace = Integer.parseInt(cmd);// it's always 1... ALWAYS
                if (firstSpace != 1) {
                    this.anInt1613 = 4;
                    this.disconnectReason = 4;
                }
            } else if (cmdtype == 'c') {// connection related
                if (cmd.startsWith("io ")) {
                    this.connCrypto.setKey(Integer.parseInt(cmd.substring(3)));
                } else if (cmd.startsWith("crt ")) {
                    this.anInt1621 = Integer.parseInt(cmd.substring(4));
                } else if (cmd.equals("ctr")) {
                    if (this.aLong1620 == -1L) {
                        this.writeLineC("new");
                    } else {
                        this.writeLineC("old " + this.aLong1620);
                    }
                } else if (cmd.startsWith("id ")) {
                    long var6 = Long.parseLong(cmd.substring(3));
                    this.aLong1620 = var6;
                    this.anInt1613 = 2;
                    writeData("version\t35");
                    writeThriftLog(1, "clientconnect", "loadtime:i:664^loadertime:i:1366");
                } else if (cmd.equals("rcok")) {
                    this.anInt1613 = 2;
                    this.aConnListener1611.notifyConnectionUp();
                } else if (cmd.equals("rcf")) {
                    this.anInt1613 = 4;
                    this.disconnectReason = 3;
                } else if (cmd.equals("ping")) {
                    this.writeLineC("pong");
                }
            } else if (cmdtype == 'p') {
                if (cmd.startsWith("kickban ")) {
                    firstSpace = Integer.parseInt(cmd.substring(8));

                }
            } else if (cmdtype == 's') {
                if (cmd.startsWith("json ")) {
                    String var7 = cmd.substring(5);

                }
            } else if (cmdtype == 'd') {
                firstSpace = cmd.indexOf(' ');
                long numServerSentPaketz = Long.parseLong(cmd.substring(0, firstSpace));
                if (numServerSentPaketz > this.numReceivedGamePackets) {
                    if (numServerSentPaketz > this.numReceivedGamePackets + 1L) {
                        this.anInt1613 = 4;
                        this.disconnectReason = 3;
                    } else {
                        cmd = cmd.substring(firstSpace + 1);
                        if (this.aGameCrypto_1612 != null) {
                            cmd = this.aGameCrypto_1612.decrypt(cmd);
                        }

                        //System.out.println("CLIENT> READ \"d " + numServerSentPaketz + " " + cmd + "\"");

                        this.aGamePacketQueue_1623.addGamePacket(cmd);
                        ++this.numReceivedGamePackets;
                    }
                }
            }

        }
    }

    private String readLine() {
        try {
            String var1 = this.in.readLine();
            if (var1 != null) {
                var1 = this.connCrypto.decrypt(var1);
                //if(!var1.startsWith("d "))
                    //System.out.println("CLIENT> READ \"" + var1 + "\"");
                return var1;
            }
        } catch (InterruptedIOException var2) {
            return null;
        } catch (IOException var3) {
            ;
        }

        this.method1783();
        return null;
    }

    private void method1790() {
        long var1 = System.currentTimeMillis();
        if (var1 > this.lastCmdReceived + 20000L) {
            this.method1783();
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

            if (this.anInt1613 != 3) {
                return;
            }

            if (this.method1776()) {
                this.connCrypto.resetKey();
                this.aClass98_1622.method1774();
                this.anInt1613 = 1;
                return;
            }
        } while (System.currentTimeMillis() < var1);

        this.anInt1613 = 4;
        this.disconnectReason = 3;
    }

    private void method1792() {
        if (this.in != null) {
            try {
                this.in.close();
            } catch (IOException var4) {
                ;
            }

            this.in = null;
        }

        if (this.out != null) {
            try {
                this.out.close();
            } catch (IOException var3) {
                ;
            }

            this.out = null;
        }

        if (this.aSocket1617 != null) {
            try {
                this.aSocket1617.close();
            } catch (IOException var2) {
                ;
            }

            this.aSocket1617 = null;
        }

    }
}
