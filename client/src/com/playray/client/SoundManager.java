package com.playray.client;

import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JApplet;

public final class SoundManager implements Runnable {

    private static final String aString1927 = "sound/";
    private static final String[] aStringArray1928;
    private JApplet aJApplet1929;
    private URL codebaseURL;
    private boolean aBoolean1931;
    private boolean aBoolean1932;
    private Hashtable aHashtable1933;
    private Hashtable aHashtable1934;
    private boolean aBoolean1935;
    private static final String[] aStringArray1936 = new String[31];


    public SoundManager(JApplet var1) {
        this(var1, true, false);
    }

    public SoundManager(JApplet var1, boolean var2) {
        this(var1, true, var2);
    }

    public SoundManager(JApplet var1, boolean var2, boolean var3) {
        this.aJApplet1929 = var1;
        this.aBoolean1931 = var2;
        this.aBoolean1932 = var3;
        this.method2027();
        String host = var1.getCodeBase().getHost();
        String URL = var1.getCodeBase().toString().replace("http://" + host, "res");
        try {
            codebaseURL = new File(URL).toURI().toURL();
        } catch(Exception ex) {
            System.err.println("playery.ImageManger: " + ex);
        }
        try {
            this.codebaseURL = new URL(this.codebaseURL, "sound/");
        } catch (MalformedURLException var5) {
            ;
        }

        this.aHashtable1934 = new Hashtable();
        this.aBoolean1935 = false;
        if (var2) {
            this.method2029();
        }

    }

    public void run() {
        if (this.aBoolean1932) {
            System.out.println("SoundManager.run(): Thread started");
        }

        boolean var3;
        do {
            var3 = false;
            Enumeration var1 = this.aHashtable1933.elements();

            SoundClip var2;
            while (var1.hasMoreElements()) {
                var2 = (SoundClip) ((SoundClip) var1.nextElement());
                if (!var2.method1975()) {
                    var2.defineClip();
                    var3 = true;
                }
            }

            var1 = this.aHashtable1934.elements();

            while (var1.hasMoreElements()) {
                var2 = (SoundClip) ((SoundClip) var1.nextElement());
                if (!var2.method1975()) {
                    var2.defineClip();
                    var3 = true;
                }
            }
        } while (var3);

        this.aBoolean1935 = false;
        if (this.aBoolean1932) {
            System.out.println("SoundManager.run(): Thread finished");
        }

    }

    public void defineSound(String var1) {
        int var2 = var1.lastIndexOf(46);
        String var3 = var1.substring(0, var2);
        this.defineSound(var3, var1);
    }

    public void defineSound(String var1, String var2) {
        if (this.aBoolean1932) {
            System.out.println("SoundManager.defineSound(\"" + var1 + "\",\"" + var2 + "\")");
        }

        SoundClip var3 = new SoundClip(this.aJApplet1929, this.codebaseURL, var2, this.aBoolean1932);
        this.aHashtable1934.put(var1, var3);
        if (this.aBoolean1931) {
            this.method2029();
        }

    }

    public void startLoading() {
        this.method2029();
    }

    public void play(String var1) {
        this.method2031(var1, 1);
    }

    public void loop(String var1) {
        this.method2031(var1, 2);
    }

    public void stop(String var1) {
        this.method2031(var1, 0);
    }

    public void playChallenge() {
        if (this.aBoolean1932) {
            System.out.println("SoundManager.playChallenge()");
        }

        this.method2030(1);
    }

    public void playGameMove() {
        if (this.aBoolean1932) {
            System.out.println("SoundManager.playGameMove()");
        }

        this.method2030(2);
    }

    public void playNotify() {
        if (this.aBoolean1932) {
            System.out.println("SoundManager.playNotify()");
        }

        this.method2030(3);
    }

    public void playIllegal() {
        if (this.aBoolean1932) {
            System.out.println("SoundManager.playIllegal()");
        }

        this.method2030(4);
    }

    public void playTimeLow() {
        if (this.aBoolean1932) {
            System.out.println("SoundManager.playTimeLow()");
        }

        this.method2030(5);
    }

    public void playGameWinner() {
        if (this.aBoolean1932) {
            System.out.println("SoundManager.playGameWinner()");
        }

        this.method2030(6);
    }

    public void playGameLoser() {
        if (this.aBoolean1932) {
            System.out.println("SoundManager.playGameLoser()");
        }

        this.method2030(7);
    }

    public void playGameDraw() {
        if (this.aBoolean1932) {
            System.out.println("SoundManager.playGameDraw()");
        }

        this.method2030(8);
    }

    public void destroy() {
        this.aHashtable1934.clear();
        this.aHashtable1934 = null;
        this.aHashtable1933.clear();
        this.aHashtable1933 = null;
        this.codebaseURL = null;
        this.aJApplet1929 = null;
    }

    protected boolean method2026() {
        return this.aBoolean1932;
    }

    private void method2027() {
        String host = aJApplet1929.getCodeBase().getHost();
        String URL = aJApplet1929.getCodeBase().toString().replace("http://" + host, "res");
        URL var1 = null;
        try {
            var1 = new File(URL).toURI().toURL();
        } catch(Exception ex) {
            System.err.println("playray.SoundManager: " + ex);
            var1 = aJApplet1929.getCodeBase();
        }

        try {
            /*if (Class110.method1896(var1)) {
                var1 = new URL(var1, "/Shared/Client2/src/sound/");
            } else {*/
                var1 = new URL(var1, "../Shared/sound/");
            //}
        } catch (MalformedURLException var3) {
            ;
        }

        this.aHashtable1933 = new Hashtable();
        this.method2028(1, var1, "challenge");
        this.method2028(2, var1, "gamemove");
        this.method2028(3, var1, "notify");
        this.method2028(4, var1, "illegal");
        this.method2028(5, var1, "timelow");
        this.method2028(6, var1, "game-winner");
        this.method2028(7, var1, "game-loser");
        this.method2028(8, var1, "game-draw");
    }

    private void method2028(int var1, URL var2, String var3) {
        this.aHashtable1933.put(new Integer(var1), new SoundClip(this.aJApplet1929, var2, var3 + ".au", this.aBoolean1932));
    }

    private synchronized void method2029() {
        if (!this.aBoolean1935) {
            this.aBoolean1935 = true;
            Thread var1 = new Thread(this);
            var1.setDaemon(true);
            var1.start();
        }
    }

    private void method2030(int var1) {
        SoundClip var2 = (SoundClip) ((SoundClip) this.aHashtable1933.get(new Integer(var1)));
        if (var2 != null) {
            AudioClip var3 = var2.method1977();
            if (var3 != null) {
                var3.play();
            }
        }
    }

    private void method2031(String var1, int var2) {
        try {
            if (this.aBoolean1932) {
                System.out.println("SoundManager." + aStringArray1928[var2] + "(\"" + var1 + "\")");
            }

            SoundClip var3 = (SoundClip) ((SoundClip) this.aHashtable1934.get(var1));
            if (var3 != null) {
                AudioClip var4 = var3.method1977();
                if (var4 != null) {
                    if (var2 == 0) {
                        var4.stop();
                    } else if (var2 == 1) {
                        var4.play();
                    } else if (var2 == 2) {
                        var4.loop();
                    }
                } else if (this.aBoolean1932) {
                    System.out.println("SoundManager." + aStringArray1928[var2] + "(\"" + var1 + "\"): AudioClip not ready!");
                }
            } else if (this.aBoolean1932) {
                System.out.println("SoundManager." + aStringArray1928[var2] + "(\"" + var1 + "\"): SoundClip not found!");
                Thread.dumpStack();
            }
        } catch (Exception var5) {
            System.out.println("SoundManager: Unexpected exception \"" + var5 + "\" when playing \"" + var1 + "\"");
        } catch (Error var6) {
            System.out.println("SoundManager: Unexpected error \"" + var6 + "\" when playing \"" + var1 + "\"");
        }

    }

    static {
        aStringArray1936[0] = "SoundManager: Unexpected error \"";
        aStringArray1936[1] = "\"): SoundClip not found!";
        aStringArray1936[2] = "\" when playing \"";
        aStringArray1936[3] = "SoundManager.";
        aStringArray1936[4] = "\")";
        aStringArray1936[5] = "\"): AudioClip not ready!";
        aStringArray1936[6] = "SoundManager: Unexpected exception \"";
        aStringArray1936[7] = "(\"";
        aStringArray1936[8] = ".au";
        aStringArray1936[9] = "SoundManager.playGameDraw()";
        aStringArray1936[10] = "SoundManager.playTimeLow()";
        aStringArray1936[11] = "SoundManager.playGameWinner()";
        aStringArray1936[12] = "SoundManager.playIllegal()";
        aStringArray1936[13] = "SoundManager.playGameMove()";
        aStringArray1936[14] = "SoundManager.playChallenge()";
        aStringArray1936[15] = "\",\"";
        aStringArray1936[16] = "SoundManager.defineSound(\"";
        aStringArray1936[17] = "game-draw";
        aStringArray1936[18] = "/Shared/Client2/src/sound/";
        aStringArray1936[19] = "challenge";
        aStringArray1936[20] = "../Shared/sound/";
        aStringArray1936[21] = "gamemove";
        aStringArray1936[22] = "game-winner";
        aStringArray1936[23] = "notify";
        aStringArray1936[24] = "game-loser";
        aStringArray1936[25] = "illegal";
        aStringArray1936[26] = "timelow";
        aStringArray1936[27] = "SoundManager.playNotify()";
        aStringArray1936[28] = "SoundManager.run(): Thread started";
        aStringArray1936[29] = "SoundManager.run(): Thread finished";
        aStringArray1936[30] = "SoundManager.playGameLoser()";
        aStringArray1928 = new String[3];
        aStringArray1928[0] = "stop";
        aStringArray1928[1] = "play";
        aStringArray1928[2] = "loop";
    }

    private static char[] method2032(String var0) {
        char[] var10000 = var0.toCharArray();
        char[] var10001 = var10000;

        while (true) {
            int var10002 = var10001.length;
            var10001 = var10000;
            int var4 = var10002;
            if (var10002 >= 2) {
                break;
            }

            char[] var1 = var10001;
            int var2 = var4;
            var10000 = var1;
            char[] var10003 = var1;
            var10002 = var2;
            var10001 = var10003;
            if (var10002 != 0) {
                var10001 = var10000;
                boolean var3 = false;
                var10003[0] = (char) (var10003[0] ^ 46);
                break;
            }
        }

        return var10001;
    }

    private static String method2033(char[] var0) {
        int var10000 = var0.length;
        int var1 = 0;
        char[] var10001 = var0;
        if (var10000 > 1) {
            var10001 = var0;
            if (var10000 <= var1) {
                return (new String(var0)).intern();
            }
        }

        do {
            char[] var10002 = var10001;
            int var10003 = var1;

            while (true) {
                char var10004 = var10002[var10003];
                byte var10005;
                switch (var1 % 5) {
                    case 0:
                        var10005 = 49;
                        break;
                    case 1:
                        var10005 = 109;
                        break;
                    case 2:
                        var10005 = 60;
                        break;
                    case 3:
                        var10005 = 25;
                        break;
                    default:
                        var10005 = 46;
                }

                var10002[var10003] = (char) (var10004 ^ var10005);
                ++var1;
                if (var10000 != 0) {
                    break;
                }

                var10003 = var10000;
                var10002 = var10001;
            }
        } while (var10000 > var1);

        return (new String(var10001)).intern();
    }
}
