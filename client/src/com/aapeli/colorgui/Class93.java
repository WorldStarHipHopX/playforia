package com.aapeli.colorgui;

import com.aapeli.colorgui.ColorTextArea;

import java.awt.Color;

class Class93 {

    private long aLong1569;
    private Color aColor1570;
    private String aString1571;
    private boolean aBoolean1572;
    private final ColorTextArea aColorTextArea1573;


    public Class93(ColorTextArea var1, Color var2, String var3, boolean var4) {
        this.aColorTextArea1573 = var1;
        this.aLong1569 = System.currentTimeMillis();
        this.aColor1570 = var2;
        this.aString1571 = var3;
        this.aBoolean1572 = var4;
    }

    protected long method1750() {
        return this.aLong1569;
    }

    protected Color method1751() {
        return this.aColor1570;
    }

    protected String method1752() {
        return this.aString1571;
    }

    protected boolean method1753() {
        return this.aBoolean1572;
    }

    protected boolean method1754() {
        return this.aString1571 == null;
    }
}
