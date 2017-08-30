package com.aapeli.client;

import com.aapeli.client.Class79;

import java.awt.Font;
import java.awt.Graphics;

class Class80 {

    private String aString1373;
    private Font aFont1374;
    private int anInt1375;
    private int anInt1376;
    private final Class79 aClass79_1377;
    private static final String[] aStringArray1378 = new String[3];


    protected Class80(Class79 var1, String var2, Font var3, int var4, int var5) {
        this.aClass79_1377 = var1;
        this.aString1373 = var2;
        this.aFont1374 = var3;
        this.anInt1375 = var4;
        this.anInt1376 = var5;
    }

    public String toString() {
        return "[HtmlWord: \'word\'=\"" + this.aString1373 + "\" \'font\'=\"" + this.aFont1374.toString() + "\" \'relx\'=" + this.anInt1375 + "]";
    }

    protected int method1609() {
        return this.anInt1376;
    }

    protected void method1610(Graphics var1, int var2, int var3) {
        var1.setFont(this.aFont1374);
        var1.drawString(this.aString1373, var2 + this.anInt1375, var3);
    }

    static {
        aStringArray1378[0] = "\" \'relx\'=";
        aStringArray1378[1] = "\" \'font\'=\"";
        aStringArray1378[2] = "[HtmlWord: \'word\'=\"";
    }
}
