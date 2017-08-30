package com.aapeli.client;

import java.awt.*;

class ImageResource {

    private String aString1404;
    private Image anImage1405;
    private int anInt1406;
    private final ImageTracker aImageTracker_1407;


    protected ImageResource(ImageTracker var1, String var2, Image var3) {
        this.aImageTracker_1407 = var1;
        this.aString1404 = var2;
        this.anImage1405 = var3;
        this.anInt1406 = 0;
    }

    protected String method1648() {
        return this.aString1404;
    }

    protected Image method1649() {
        return this.anImage1405;
    }

    protected void method1650() {
        ++this.anInt1406;
    }

    protected boolean method1651() {
        return this.anInt1406 >= 3;
    }

    protected void method1652() {
        this.anImage1405.flush();
        this.anImage1405 = null;
        this.aString1404 = null;
    }
}
