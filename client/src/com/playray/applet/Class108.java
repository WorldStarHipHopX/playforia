package com.playray.applet;

import com.playray.applet.AApplet;
import com.playray.tools.Tools;

class Class108 implements Runnable {

    private AApplet anAApplet1744;
    private int anInt1745;
    private boolean aBoolean1746;
    private final AApplet anAApplet1747;


    protected Class108(AApplet var1, AApplet var2, int var3) {
        this.anAApplet1747 = var1;
        this.anAApplet1744 = var2;
        this.anInt1745 = var3;
        this.aBoolean1746 = false;
        Thread var4 = new Thread(this);
        var4.setDaemon(true);
        var4.start();
    }

    public void run() {
        Tools.sleep((long) this.anInt1745);
        if (!this.aBoolean1746) {
            this.anAApplet1744.allowExternalPopups();
        }
    }

    public void stop() {
        this.aBoolean1746 = true;
    }
}
