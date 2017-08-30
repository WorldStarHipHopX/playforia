package com.playray.client;

import com.playray.client.Class115;

import java.awt.Image;

class Class116 {

    private String aString1824;
    private Image anImage1825;
    private int anInt1826;
    private final Class115 aClass115_1827;


    protected Class116(Class115 var1, String var2, Image var3) {
        this.aClass115_1827 = var1;
        this.aString1824 = var2;
        this.anImage1825 = var3;
        this.anInt1826 = 0;
    }

    protected String method1970() {
        return this.aString1824;
    }

    protected Image method1971() {
        return this.anImage1825;
    }

    protected void method1972() {
        ++this.anInt1826;
    }

    protected boolean method1973() {
        return this.anInt1826 >= 3;
    }

    protected void method1974() {
        this.anImage1825.flush();
        this.anImage1825 = null;
        this.aString1824 = null;
    }
}
