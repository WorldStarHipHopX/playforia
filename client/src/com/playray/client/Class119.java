package com.playray.client;

import com.playray.client.ImageManager;
import com.playray.client.SPanel;

import java.awt.Image;

class Class119 implements Runnable {

    private SPanel aSPanel1852;
    private ImageManager anImageManager1853;
    private String aString1854;
    private int anInt1855;
    private int anInt1856;
    private boolean aBoolean1857;
    private boolean aBoolean1858;
    private final SPanel aSPanel1859;


    protected Class119(SPanel var1, SPanel var2, ImageManager var3, String var4, int var5, int var6, boolean var7) {
        this.aSPanel1859 = var1;
        this.aSPanel1852 = var2;
        this.anImageManager1853 = var3;
        this.aString1854 = var4;
        this.anInt1855 = var5;
        this.anInt1856 = var6;
        this.aBoolean1857 = var7;
        this.aBoolean1858 = true;
        Thread var8 = new Thread(this);
        var8.setDaemon(true);
        var8.start();
    }

    public void run() {
        Image var1;
        if (!this.aBoolean1857) {
            var1 = this.anImageManager1853.method1983(this.aString1854);
        } else {
            var1 = this.anImageManager1853.getShared(this.aString1854);
        }

        if (this.aBoolean1858) {
            this.aSPanel1852.setBackground(var1, this.anInt1855, this.anInt1856);
        }

    }

    protected void method1990() {
        this.aBoolean1858 = false;
    }
}
