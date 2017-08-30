package com.aapeli.client;

import com.aapeli.applet.AApplet;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

public final class SoundManager implements Runnable {

    private static final String[] aStringArray1484 = {"stop", "play", "loop"};
    private Applet anApplet1485;
    private URL anURL1486;
    private boolean aBoolean1487;
    private boolean aBoolean1488;
    private Hashtable aHashtable1489;
    private Hashtable aHashtable1490;
    private boolean aBoolean1491;
    private AApplet anAApplet1492;


    public SoundManager(Applet var1) {
        this(var1, true, false);
    }

    public SoundManager(Applet var1, boolean var2) {
        this(var1, true, var2);
    }

    public SoundManager(Applet var1, boolean var2, boolean var3) {
        this.anApplet1485 = var1;
        this.aBoolean1487 = var2;
        this.aBoolean1488 = var3;
        this.method1688();
        this.anURL1486 = var1.getCodeBase();

        try {
            this.anURL1486 = new URL(this.anURL1486, "sound/");
        } catch (MalformedURLException var5) {
            ;
        }

        this.aHashtable1490 = new Hashtable();
        this.aBoolean1491 = false;
        this.anAApplet1492 = null;
        if (var2) {
            this.method1690();
        }

    }

    public void run() {
        if (this.aBoolean1488) {
            System.out.println("SoundManager.run(): Thread started");
        }

        boolean var3;
        do {
            var3 = false;
            Enumeration var1 = this.aHashtable1489.elements();

            Class86 var2;
            while (var1.hasMoreElements()) {
                var2 = (Class86) ((Class86) var1.nextElement());
                if (!var2.method1682()) {
                    var2.method1683();
                    var3 = true;
                }
            }

            var1 = this.aHashtable1490.elements();

            while (var1.hasMoreElements()) {
                var2 = (Class86) ((Class86) var1.nextElement());
                if (!var2.method1682()) {
                    var2.method1683();
                    var3 = true;
                }
            }
        } while (var3);

        this.aBoolean1491 = false;
        if (this.aBoolean1488) {
            System.out.println("SoundManager.run(): Thread finished");
        }

    }

    public void defineSound(String var1) {
        int var2 = var1.lastIndexOf(46);
        String var3 = var1.substring(0, var2);
        this.defineSound(var3, var1);
    }

    public void defineSound(String var1, String var2) {
        if (this.aBoolean1488) {
            System.out.println("SoundManager.defineSound(\"" + var1 + "\",\"" + var2 + "\")");
        }

        if (this.anAApplet1492 != null) {
            this.anAApplet1492.printSUD("SoundManager: Defining sound \"" + var2 + "\"");
        }

        Class86 var3 = new Class86(this.anApplet1485, this.anURL1486, var2, this.aBoolean1488);
        this.aHashtable1490.put(var1, var3);
        if (this.aBoolean1487) {
            this.method1690();
        }

    }

    public void startLoading() {
        this.method1690();
    }

    public void play(String var1) {
        this.method1692(var1, 1);
    }

    public void loop(String var1) {
        this.method1692(var1, 2);
    }

    public void stop(String var1) {
        this.method1692(var1, 0);
    }

    public void playChallenge() {
        if (this.aBoolean1488) {
            System.out.println("SoundManager.playChallenge()");
        }

        this.method1691(1);
    }

    public void playGameMove() {
        if (this.aBoolean1488) {
            System.out.println("SoundManager.playGameMove()");
        }

        this.method1691(2);
    }

    public void playNotify() {
        if (this.aBoolean1488) {
            System.out.println("SoundManager.playNotify()");
        }

        this.method1691(3);
    }

    public void playIllegal() {
        if (this.aBoolean1488) {
            System.out.println("SoundManager.playIllegal()");
        }

        this.method1691(4);
    }

    public void playTimeLow() {
        if (this.aBoolean1488) {
            System.out.println("SoundManager.playTimeLow()");
        }

        this.method1691(5);
    }

    public void playGameWinner() {
        if (this.aBoolean1488) {
            System.out.println("SoundManager.playGameWinner()");
        }

        this.method1691(6);
    }

    public void playGameLoser() {
        if (this.aBoolean1488) {
            System.out.println("SoundManager.playGameLoser()");
        }

        this.method1691(7);
    }

    public void playGameDraw() {
        if (this.aBoolean1488) {
            System.out.println("SoundManager.playGameDraw()");
        }

        this.method1691(8);
    }

    public void destroy() {
        this.aHashtable1490.clear();
        this.aHashtable1490 = null;
        this.aHashtable1489.clear();
        this.aHashtable1489 = null;
        this.anURL1486 = null;
        this.anApplet1485 = null;
    }

    public void enableSUD(AApplet var1) {
        this.anAApplet1492 = var1;
    }

    protected boolean method1687() {
        return this.aBoolean1488;
    }

    private void method1688() {
        URL var1 = this.anApplet1485.getCodeBase();

        try {
            if (FileUtil.isFileUrl(var1)) {
                var1 = new URL(var1, FileUtil.RESOURCE_DIR + "sound/");
            } else {
                var1 = new URL(var1, "../Shared/sound/");
            }
        } catch (MalformedURLException var3) {
            ;
        }

        this.aHashtable1489 = new Hashtable();
        this.method1689(1, var1, "challenge");
        this.method1689(2, var1, "gamemove");
        this.method1689(3, var1, "notify");
        this.method1689(4, var1, "illegal");
        this.method1689(5, var1, "timelow");
        this.method1689(6, var1, "game-winner");
        this.method1689(7, var1, "game-loser");
        this.method1689(8, var1, "game-draw");
    }

    private void method1689(int var1, URL var2, String var3) {
        this.aHashtable1489.put(new Integer(var1), new Class86(this.anApplet1485, var2, var3 + ".au", this.aBoolean1488));
    }

    private synchronized void method1690() {
        if (!this.aBoolean1491) {
            this.aBoolean1491 = true;
            Thread var1 = new Thread(this);
            var1.setDaemon(true);
            var1.start();
        }
    }

    private void method1691(int var1) {
        Class86 var2 = (Class86) ((Class86) this.aHashtable1489.get(new Integer(var1)));
        if (var2 != null) {
            AudioClip var3 = var2.method1684();
            if (var3 != null) {
                var3.play();
            }
        }
    }

    private void method1692(String var1, int var2) {
        try {
            if (this.aBoolean1488) {
                System.out.println("SoundManager." + aStringArray1484[var2] + "(\"" + var1 + "\")");
            }

            Class86 var3 = (Class86) ((Class86) this.aHashtable1490.get(var1));
            if (var3 != null) {
                AudioClip var4 = var3.method1684();
                if (var4 != null) {
                    if (var2 == 0) {
                        var4.stop();
                    } else if (var2 == 1) {
                        var4.play();
                    } else if (var2 == 2) {
                        var4.loop();
                    }
                } else if (this.aBoolean1488) {
                    System.out.println("SoundManager." + aStringArray1484[var2] + "(\"" + var1 + "\"): AudioClip not ready!");
                }
            } else if (this.aBoolean1488) {
                System.out.println("SoundManager." + aStringArray1484[var2] + "(\"" + var1 + "\"): SoundClip not found!");
                Thread.dumpStack();
            }
        } catch (Exception var5) {
            System.out.println("SoundManager: Unexpected exception \"" + var5 + "\" when playing \"" + var1 + "\"");
        } catch (Error var6) {
            System.out.println("SoundManager: Unexpected error \"" + var6 + "\" when playing \"" + var1 + "\"");
        }

    }
}
