package com.aapeli.client;

import java.awt.Image;

class Class84 implements Runnable {

    private IPanel anIPanel1408;
    private ImageManager anImageManager1409;
    private String aString1410;
    private int anInt1411;
    private int anInt1412;
    private boolean aBoolean1413;
    private boolean aBoolean1414;
    private final IPanel anIPanel1415;


    protected Class84(IPanel var1, IPanel var2, ImageManager var3, String var4, int var5, int var6, boolean var7) {
        this.anIPanel1415 = var1;
        this.anIPanel1408 = var2;
        this.anImageManager1409 = var3;
        this.aString1410 = var4;
        this.anInt1411 = var5;
        this.anInt1412 = var6;
        this.aBoolean1413 = var7;
        this.aBoolean1414 = true;
        Thread var8 = new Thread(this);
        var8.setDaemon(true);
        var8.start();
    }

    public void run() {
        Image var1;
        if (!this.aBoolean1413) {
            var1 = this.anImageManager1409.getImage(this.aString1410);
        } else {
            var1 = this.anImageManager1409.getShared(this.aString1410);
        }

        if (this.aBoolean1414) {
            this.anIPanel1408.setBackground(var1, this.anInt1411, this.anInt1412);
        }

    }

    protected void method1653() {
        this.aBoolean1414 = false;
    }
}
