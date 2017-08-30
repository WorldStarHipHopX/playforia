package com.playray.applet;

import com.playray.applet.AApplet;

class Class107 implements Runnable {

    private final int anInt1742;
    private final AApplet anAApplet1743;


    Class107(AApplet var1, int var2) {
        this.anAApplet1743 = var1;
        this.anInt1742 = var2;
    }

    public void run() {
        this.anAApplet1743.internalChangeUIsync(this.anInt1742);
    }
}
