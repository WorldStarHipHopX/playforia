package com.playray.client;

import com.playray.client.Class118;
import com.playray.client.SoundManager;
import com.playray.tools.Tools;

import java.util.Vector;

public final class SoundPlayer implements Runnable {

    private SoundManager aSoundManager1937;
    private Vector[] aVectorArray1938;
    private boolean aBoolean1939;
    private Thread aThread1940;
    private static final String[] aStringArray1941 = new String[4];


    public SoundPlayer(SoundManager var1) {
        this.aSoundManager1937 = var1;
        this.aVectorArray1938 = new Vector[10];

        for (int var2 = 0; var2 < 10; ++var2) {
            this.aVectorArray1938[var2] = new Vector();
        }

        this.aBoolean1939 = true;
        this.aThread1940 = new Thread(this);
        this.aThread1940.setDaemon(true);
        this.aThread1940.start();
    }

    public void run() {
        if (this.aSoundManager1937.method2026()) {
            System.out.println("SoundPlayer: Started");
        }

        do {
            Tools.sleep(1000L);
            String var1;
            if (this.aBoolean1939) {
                while ((var1 = this.method2034()) != null) {
                    this.aSoundManager1937.play(var1);
                }
            }
        } while (this.aBoolean1939);

        if (this.aSoundManager1937.method2026()) {
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

        Class118 var4 = new Class118(this, var1, var3);
        synchronized (this.aVectorArray1938[var2]) {
            this.aVectorArray1938[var2].addElement(var4);
        }

        this.aThread1940.interrupt();
    }

    public void stop() {
        this.aBoolean1939 = false;
    }

    private String method2034() {
        for (int var2 = 9; var2 >= 0; --var2) {
            String var1 = this.method2035(this.aVectorArray1938[var2]);
            if (var1 != null) {
                return var1;
            }
        }

        return null;
    }

    private String method2035(Vector var1) {
        Class118 var2;
        synchronized (var1) {
            if (var1.size() == 0) {
                return null;
            }

            var2 = (Class118) ((Class118) var1.elementAt(0));
            var1.removeElementAt(0);
        }

        String var3 = var2.method1981();
        if (System.currentTimeMillis() > var2.method1982()) {
            if (this.aSoundManager1937.method2026()) {
                System.out.println("SoundPlayer: \"" + var3 + "\" timed out");
            }

            return this.method2035(var1);
        } else {
            return var3;
        }
    }

    static {
        aStringArray1941[0] = "SoundPlayer: \"";
        aStringArray1941[1] = "\" timed out";
        aStringArray1941[2] = "SoundPlayer: Started";
        aStringArray1941[3] = "SoundPlayer: Stopped";
    }
}
