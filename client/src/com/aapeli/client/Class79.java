package com.aapeli.client;

import com.aapeli.client.Class80;
import com.aapeli.client.HtmlText;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Vector;

class Class79 {

    private int anInt1366;
    private boolean aBoolean1367;
    private Vector aVector1368;
    private int anInt1369;
    private int anInt1370;
    private final HtmlText aHtmlText1371;
    private static final String[] aStringArray1372 = new String[3];


    protected Class79(HtmlText var1, Graphics var2, int var3, boolean var4) {
        this.aHtmlText1371 = var1;
        this.anInt1366 = var3;
        this.aBoolean1367 = var4;
        this.aVector1368 = new Vector();
        this.anInt1369 = 0;
        this.anInt1370 = var2.getFont().getSize();
    }

    public String toString() {
        int var1 = this.aVector1368.size();
        String var2 = "[HtmlLine: words.size=" + var1 + "\n";

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = var2 + " " + ((Class80) ((Class80) this.aVector1368.elementAt(var3))).toString() + "\n";
        }

        var2 = var2 + "\'relatx\'=" + this.anInt1369 + " \'height\'=" + this.anInt1370 + "]";
        return var2;
    }

    protected boolean method1604(int var1) {
        return this.anInt1369 + var1 <= this.anInt1366;
    }

    protected void method1605(String var1, Font var2, int var3) {
        if (!this.method1606() || var1.trim().length() != 0) {
            Class80 var4 = new Class80(this, var1, var2, this.anInt1369, var3);
            this.aVector1368.addElement(var4);
            this.anInt1369 += var3;
            int var5 = var2.getSize();
            if (var5 > this.anInt1370) {
                this.anInt1370 = var5;
            }

        }
    }

    protected boolean method1606() {
        return this.aVector1368.isEmpty();
    }

    protected int method1607() {
        return this.anInt1370;
    }

    protected void method1608(Graphics var1, int var2, int var3) {
        int var4 = this.aVector1368.size();
        Class80 var5;
        int var6;
        if (this.aBoolean1367) {
            var6 = 0;

            for (int var7 = 0; var7 < var4; ++var7) {
                var5 = (Class80) ((Class80) this.aVector1368.elementAt(var7));
                var6 += var5.method1609();
            }

            var2 += (this.anInt1366 - var6) / 2;
        }

        for (var6 = 0; var6 < var4; ++var6) {
            var5 = (Class80) ((Class80) this.aVector1368.elementAt(var6));
            var5.method1610(var1, var2, var3);
        }

    }

    static {
        aStringArray1372[0] = " \'height\'=";
        aStringArray1372[1] = "\'relatx\'=";
        aStringArray1372[2] = "[HtmlLine: words.size=";
    }
}
