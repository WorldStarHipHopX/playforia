package com.playray.client;

import com.playray.client.Class112;

import java.awt.Font;
import java.awt.Graphics;

class Class113 {

    private String aString1804;
    private Font aFont1805;
    private int anInt1806;
    private int anInt1807;
    private final Class112 aClass112_1808;
    private static final String[] aStringArray1809 = new String[3];


    protected Class113(Class112 var1, String var2, Font var3, int var4, int var5) {
        this.aClass112_1808 = var1;
        this.aString1804 = var2;
        this.aFont1805 = var3;
        this.anInt1806 = var4;
        this.anInt1807 = var5;
    }

    public String toString() {
        return "[HtmlWord: \'word\'=\"" + this.aString1804 + "\" \'font\'=\"" + this.aFont1805.toString() + "\" \'relx\'=" + this.anInt1806 + "]";
    }

    protected int method1937() {
        return this.anInt1807;
    }

    protected void method1938(Graphics var1, int var2, int var3) {
        var1.setFont(this.aFont1805);
        var1.drawString(this.aString1804, var2 + this.anInt1806, var3);
    }

    static {
        aStringArray1809[0] = "\" \'relx\'=";
        aStringArray1809[1] = "\" \'font\'=\"";
        aStringArray1809[2] = "[HtmlWord: \'word\'=\"";
    }
}
