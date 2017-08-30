package com.aapeli.colorgui;

import com.aapeli.colorgui.ColorSpinner;
import com.aapeli.tools.Tools;

class Class92 implements Runnable {

    private ColorSpinner aColorSpinner1549;
    private int anInt1550;
    private boolean aBoolean1551;
    private final ColorSpinner aColorSpinner1552;


    protected Class92(ColorSpinner var1, ColorSpinner var2, int var3) {
        this.aColorSpinner1552 = var1;
        this.aColorSpinner1549 = var2;
        this.anInt1550 = var3;
        this.aBoolean1551 = true;
        Thread var4 = new Thread(this);
        var4.setDaemon(true);
        var4.start();
    }

    public void run() {
        Tools.sleep((long) this.anInt1550);
        if (this.aBoolean1551) {
            this.aColorSpinner1549.method846();
        }

    }

    protected void method1746() {
        this.aBoolean1551 = false;
    }
}
