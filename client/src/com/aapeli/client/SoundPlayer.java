package com.aapeli.client;

import com.aapeli.client.Class87;
import com.aapeli.client.SoundManager;
import com.aapeli.tools.Tools;

import java.util.Vector;

public final class SoundPlayer implements Runnable {

    private SoundManager aSoundManager1494;
    private Vector[] aVectorArray1495;
    private boolean aBoolean1496;
    private Thread aThread1497;
    private static final String[] aStringArray1498 = new String[4];


    public SoundPlayer(SoundManager var1) {
        this.aSoundManager1494 = var1;
        this.aVectorArray1495 = new Vector[10];

        for (int var2 = 0; var2 < 10; ++var2) {
            this.aVectorArray1495[var2] = new Vector();
        }

        this.aBoolean1496 = true;
        this.aThread1497 = new Thread(this);
        this.aThread1497.setDaemon(true);
        this.aThread1497.start();
    }

    public void run() {
        if (this.aSoundManager1494.method1687()) {
            System.out.println("SoundPlayer: Started");
        }

        do {
            Tools.sleep(1000L);
            String var1;
            if (this.aBoolean1496) {
                while ((var1 = this.method1695()) != null) {
                    this.aSoundManager1494.play(var1);
                }
            }
        } while (this.aBoolean1496);

        if (this.aSoundManager1494.method1687()) {
            System.out.println("SoundPlayer: Stopped");
        }

    }

    public void play(String var1) {
        this.play(var1, 5, 1000);
    }

    public void play(String var1, int var2) {
        this.play(var1, var2, 1000);
    }

    public void play(String var1, int var2, int var3) {
        if (var2 < 0) {
            var2 = 0;
        }

        if (var2 >= 10) {
            var2 = 9;
        }

        if (var3 < 0) {
            var3 = 0;
        }

        Class87 var4 = new Class87(this, var1, var3);
        synchronized (this.aVectorArray1495[var2]) {
            this.aVectorArray1495[var2].addElement(var4);
        }

        this.aThread1497.interrupt();
    }

    public void stop() {
        this.aBoolean1496 = false;
    }

    private String method1695() {
        for (int var2 = 9; var2 >= 0; --var2) {
            String var1 = this.method1696(this.aVectorArray1495[var2]);
            if (var1 != null) {
                return var1;
            }
        }

        return null;
    }

    private String method1696(Vector var1) {
        Class87 var2;
        synchronized (var1) {
            if (var1.size() == 0) {
                return null;
            }

            var2 = (Class87) ((Class87) var1.elementAt(0));
            var1.removeElementAt(0);
        }

        String var3 = var2.method1685();
        if (System.currentTimeMillis() > var2.method1686()) {
            if (this.aSoundManager1494.method1687()) {
                System.out.println("SoundPlayer: \"" + var3 + "\" timed out");
            }

            return this.method1696(var1);
        } else {
            return var3;
        }
    }

    static {
        aStringArray1498[0] = "SoundPlayer: Started";
        aStringArray1498[1] = "SoundPlayer: Stopped";
        aStringArray1498[2] = "\" timed out";
        aStringArray1498[3] = "SoundPlayer: \"";
    }
}
