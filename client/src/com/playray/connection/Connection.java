package com.playray.connection;

import com.playray.applet.AApplet;
import com.playray.client.Parameters;
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
import java.util.LinkedList;

public final class Connection implements Runnable {

    public static final int DCR_UNDEFINED = 0;
    public static final int DCR_BYUSER = 1;
    public static final int DCR_NORETRY = 2;
    public static final int DCR_RETRYFAIL = 3;
    public static final int DCR_VERSION = 4;
    public static final int DCR_HANDLEFAILED = 5;
    private static final String aString2042 = "UTF-8";
    private AApplet anAApplet2043;
    private Parameters aParameters2044;
    private ConnListener aConnListener2045;
    private Class135 gameCrypto;
    private int anInt2047;
    private int anInt2048;
    private boolean aBoolean2049;
    private boolean aBoolean2050;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private long aLong2054;
    private int anInt2055;
    private Class134 aClass134_2056;
    private Class132 aClass132_2057;
    private LinkedList aLinkedList2058;
    private long aLong2059;
    private long aLong2060;
    private Class133 connCrypto;
    private Thread aThread2062;
    public static int anInt2063;
    private static final String[] aStringArray2064 = new String[20];


    public Connection(AApplet var1, ConnListener var2, String[] var3) {
        this(var1, var1.param, var2, var3);
    }

    public Connection(Parameters var1, ConnListener var2, String[] var3) {
        this((AApplet) null, var1, var2, var3);
    }

    private Connection(AApplet var1, Parameters var2, ConnListener var3, String[] var4) {
        this.anAApplet2043 = var1;
        this.aParameters2044 = var2;
        this.aConnListener2045 = var3;
        if (var1 != null) {
            var1.setConnectionReference(this);
        }

        int var5 = 4;
        if (var4 != null) {
            this.gameCrypto = new Class135(var4);
            var5 = this.gameCrypto.method2124();
        }

        this.aLong2054 = -1L;
        this.anInt2055 = 25;
        this.aClass134_2056 = new Class134();
        this.aLinkedList2058 = new LinkedList();
        this.aLong2059 = -1L;
        this.anInt2047 = 0;
        this.anInt2048 = 0;
        this.aBoolean2049 = this.aBoolean2050 = false;
        this.connCrypto = new Class133(var5);
    }

    public void run() {
        this.aClass132_2057 = new Class132(this, this.aConnListener2045);

        try {
            do {
                if (this.anInt2047 == 1) {
                    this.method2109();
                } else if (this.anInt2047 == 2) {
                    this.method2108();
                } else if (this.anInt2047 == 3) {
                    this.method2122();
                }

                if (this.aBoolean2049) {
                    if (this.method2113()) {
                        this.writeLineC("end");
                    }

                    this.anInt2047 = 4;
                    this.anInt2048 = 1;
                }

                if (this.aBoolean2050) {
                    this.anInt2047 = 4;
                    this.anInt2048 = 5;
                }
            } while (this.anInt2047 != 4);
        } catch (Exception var2) {
            ;
        } catch (Error var3) {
            ;
        }

        this.method2123();
        this.aClass132_2057.method2092();
        this.aConnListener2045.connectionLost(this.anInt2048);
    }

    public boolean connect() {
        if (this.anInt2047 != 0) {
            throw new IllegalStateException("Connection already opened");
        } else if (!this.method2107()) {
            this.anInt2047 = 4;
            return false;
        } else {
            this.anInt2047 = 1;
            this.aThread2062 = new Thread(this);
            this.aThread2062.start();
            return true;
        }
    }

    public void writeData(String var1) {
        if (this.anInt2047 == 0) {
            throw new IllegalStateException("Connection not yet open");
        } else if (this.anInt2047 != 4) {
            if(Launcher.debug())
                System.out.println("CLIENT> WRITE \"d " + aClass134_2056.aLong2041 + " " + var1 + "\"");
            if (this.gameCrypto != null) {
                var1 = this.gameCrypto.method2125(var1);
            }

            this.aClass134_2056.method2103(var1);
        }
    }

    public void writeThriftLog(int var1, String var2, String var3) {
        String var4 = "tlog\t" + var1 + "\t" + var2;
        if (var3 != null) {
            var4 = var4 + "\t" + var3;
        }

        this.aLinkedList2058.addLast(var4);
    }

    public void disconnect() {
        if (this.anInt2047 == 0) {
            throw new IllegalStateException("Connection not yet even opened");
        } else if (this.anInt2047 != 4 || this.aThread2062 != null) {
            this.aBoolean2049 = true;
            this.anInt2047 = 4;
            this.aThread2062.interrupt();
        }
    }

    public String getLocalIP() {
        return null;
    }

    protected void method2106() {
        this.aBoolean2050 = true;
        this.anInt2047 = 4;
        this.aThread2062.interrupt();
    }

    private boolean method2107() {
        try {
            String var1 = this.aParameters2044.getServerIp();
            int var2 = this.aParameters2044.getServerPort();
            this.socket = new Socket(var1, var2);
            InputStream var3 = this.socket.getInputStream();
            OutputStream var4 = this.socket.getOutputStream();

            InputStreamReader in;
            OutputStreamWriter out;
            try {
                in = new InputStreamReader(var3, "UTF-8");
                out = new OutputStreamWriter(var4, "UTF-8");
            } catch (UnsupportedEncodingException var8) {
                in = new InputStreamReader(var3);
                out = new OutputStreamWriter(var4);
            }

            this.in = new BufferedReader(in);
            this.out = new BufferedWriter(out);
            this.socket.setSoTimeout(250);
            this.aLong2060 = System.currentTimeMillis();
            return true;
        } catch (Exception var9) {
            return false;
        }
    }

    private void method2108() {
        this.method2110();
        if (this.anInt2047 == 2) {
            this.method2109();
        }

    }

    private void method2109() {
        this.method2119();
        if (this.anInt2047 == 2) {
            this.method2121();
        }

    }

    private void method2110() {
        this.method2111();
        if (this.anInt2047 == 2) {
            this.method2112();
        }

    }

    private void method2111() {
        do {
            String var1 = this.aClass134_2056.method2104();
            if (var1 == null) {
                return;
            }

            if (!this.writeLineD(var1)) {
                this.method2114();
            }
        } while (this.anInt2047 == 2);

    }

    private void method2112() {
        while (true) {
            if (this.anInt2047 == 2 && !this.aLinkedList2058.isEmpty()) {
                String var1 = (String) ((String) this.aLinkedList2058.removeFirst());
                if (this.writeLineS(var1)) {
                    continue;
                }

                this.method2114();
                return;
            }

            return;
        }
    }

    private boolean method2113() {
        String var1;
        do {
            var1 = this.aClass134_2056.method2104();
            if (var1 == null) {
                return true;
            }
        } while (this.writeLineD(var1));

        return false;
    }

    private void method2114() {
        if (this.anInt2047 == 2 && this.anInt2055 > 0) {
            this.method2123();
            this.anInt2047 = 3;
            this.aConnListener2045.notifyConnectionDown();
        } else {
            this.anInt2047 = 4;
            this.anInt2048 = 2;
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
            var1 = this.connCrypto.method2097(var1);
            this.out.write(var1);
            this.out.newLine();
            this.out.flush();
            return true;
        } catch (IOException var3) {
            return false;
        }
    }

    private void method2119() {
        String cmd = this.readLine();
        if (cmd != null) {
            this.aLong2060 = System.currentTimeMillis();
            char var2 = cmd.charAt(0);
            cmd = cmd.substring(2);
            int var3;
            if (var2 == 'h') {
                var3 = Integer.parseInt(cmd);
                if (var3 != 1) {
                    this.anInt2047 = 4;
                    this.anInt2048 = 4;
                }
            } else if (var2 == 'c') {
                if (cmd.startsWith("io ")) {
                    this.connCrypto.method2095(Integer.parseInt(cmd.substring(3)));
                } else if (cmd.startsWith("crt ")) {
                    this.anInt2055 = Integer.parseInt(cmd.substring(4));
                } else if (cmd.equals("ctr")) {
                    if (this.aLong2054 == -1L) {
                        this.writeLineC("new");
                    } else {
                        this.writeLineC("old " + this.aLong2054);
                    }
                } else if (cmd.startsWith("id ")) {
                    long var6 = Long.parseLong(cmd.substring(3));
                    this.aLong2054 = var6;
                    this.anInt2047 = 2;
                } else if (cmd.equals("rcok")) {
                    this.anInt2047 = 2;
                    this.aConnListener2045.notifyConnectionUp();
                } else if (cmd.equals("rcf")) {
                    this.anInt2047 = 4;
                    this.anInt2048 = 3;
                } else if (cmd.equals("ping")) {
                    this.writeLineC("pong");
                }
            } else if (var2 == 'p') {
                if (cmd.startsWith("kickban ") && this.anAApplet2043 != null) {
                    var3 = Integer.parseInt(cmd.substring(8));
                    this.anAApplet2043.setEndState(var3 == 1 ? 9 : (var3 == 2 ? 10 : (var3 == 3 ? 11 : 13)));
                }
            } else if (var2 == 's') {
                if (cmd.startsWith("json ")) {
                    String var7 = cmd.substring(5);
                    this.aParameters2044.callJavaScriptJSON(var7);
                }
            } else if (var2 == 'd') {
                var3 = cmd.indexOf(' ');
                long var4 = Long.parseLong(cmd.substring(0, var3));
                if (var4 > this.aLong2059) {
                    if (var4 > this.aLong2059 + 1L) {
                        this.anInt2047 = 4;
                        this.anInt2048 = 3;
                    } else {
                        cmd = cmd.substring(var3 + 1);
                        if (this.gameCrypto != null) {
                            cmd = this.gameCrypto.decrypt(cmd);
                        }

                        if(Launcher.debug())
                            System.out.println("CLIENT> READ \"d " + aLong2059 + " " + cmd + "\"");
                        this.aClass132_2057.method2091(cmd);
                        ++this.aLong2059;
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
                if(!var1.startsWith("d ") && Launcher.debug())
                    System.out.println("CLIENT> READ \"" + var1 + "\"");
                return var1;
            }
        } catch (InterruptedIOException var2) {
            return null;
        } catch (IOException var3) {
            ;
        }

        this.method2114();
        return null;
    }

    private void method2121() {
        long var1 = System.currentTimeMillis();
        if (var1 > this.aLong2060 + 20000L) {
            this.method2114();
        }

    }

    private void method2122() {
        long var1 = System.currentTimeMillis() + (long) ((this.anInt2055 + 12) * 1000);

        do {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException var4) {
                ;
            }

            if (this.anInt2047 != 3) {
                return;
            }

            if (this.method2107()) {
                this.connCrypto.method2096();
                this.aClass134_2056.method2105();
                this.anInt2047 = 1;
                return;
            }
        } while (System.currentTimeMillis() < var1);

        this.anInt2047 = 4;
        this.anInt2048 = 3;
    }

    private void method2123() {
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

        if (this.socket != null) {
            try {
                this.socket.close();
            } catch (IOException var2) {
                ;
            }

            this.socket = null;
        }

    }

    static {
        aStringArray2064[0] = "Connection not yet open";
        aStringArray2064[1] = "tlog\t";
        aStringArray2064[2] = "s ";
        aStringArray2064[3] = "d ";
        aStringArray2064[4] = "end";
        aStringArray2064[5] = "ping";
        aStringArray2064[6] = "crt ";
        aStringArray2064[7] = "io ";
        aStringArray2064[8] = "pong";
        aStringArray2064[9] = "rcf";
        aStringArray2064[10] = "ctr";
        aStringArray2064[11] = "json ";
        aStringArray2064[12] = "rcok";
        aStringArray2064[13] = "old ";
        aStringArray2064[14] = "id ";
        aStringArray2064[15] = "kickban ";
        aStringArray2064[16] = "new";
        aStringArray2064[17] = "Connection not yet even opened";
        aStringArray2064[18] = "c ";
        aStringArray2064[19] = "Connection already opened";
    }
}
