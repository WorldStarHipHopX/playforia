package com.playray.colorgui;

import com.playray.colorgui.ColorTextArea;

import java.awt.Color;

class Class127 {

    private long aLong1992;
    private Color aColor1993;
    private String aString1994;
    private boolean aBoolean1995;
    private final ColorTextArea aColorTextArea1996;


    public Class127(ColorTextArea var1, Color var2, String var3, boolean var4) {
        this.aColorTextArea1996 = var1;
        this.aLong1992 = System.currentTimeMillis();
        this.aColor1993 = var2;
        this.aString1994 = var3;
        this.aBoolean1995 = var4;
    }

    protected long method2077() {
        return this.aLong1992;
    }

    protected Color method2078() {
        return this.aColor1993;
    }

    protected String method2079() {
        return this.aString1994;
    }

    protected boolean method2080() {
        return this.aBoolean1995;
    }

    protected boolean method2081() {
        return this.aString1994 == null;
    }
}
