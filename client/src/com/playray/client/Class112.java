package com.playray.client;

import com.playray.client.Class113;
import com.playray.client.HtmlText;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Vector;

class Class112 {

    private int anInt1797;
    private boolean aBoolean1798;
    private Vector aVector1799;
    private int anInt1800;
    private int anInt1801;
    private final HtmlText aHtmlText1802;
    private static final String[] aStringArray1803 = new String[3];


    protected Class112(HtmlText var1, Graphics var2, int var3, boolean var4) {
        this.aHtmlText1802 = var1;
        this.anInt1797 = var3;
        this.aBoolean1798 = var4;
        this.aVector1799 = new Vector();
        this.anInt1800 = 0;
        this.anInt1801 = var2.getFont().getSize();
    }

    public String toString() {
        int var1 = this.aVector1799.size();
        String var2 = "[HtmlLine: words.size=" + var1 + "\n";

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = var2 + " " + ((Class113) ((Class113) this.aVector1799.elementAt(var3))).toString() + "\n";
        }

        var2 = var2 + "\'relatx\'=" + this.anInt1800 + " \'height\'=" + this.anInt1801 + "]";
        return var2;
    }

    protected boolean method1921(int var1) {
        return this.anInt1800 + var1 <= this.anInt1797;
    }

    protected void method1922(String var1, Font var2, int var3) {
        if (!this.method1923() || var1.trim().length() != 0) {
            Class113 var4 = new Class113(this, var1, var2, this.anInt1800, var3);
            this.aVector1799.addElement(var4);
            this.anInt1800 += var3;
            int var5 = var2.getSize();
            if (var5 > this.anInt1801) {
                this.anInt1801 = var5;
            }

        }
    }

    protected boolean method1923() {
        return this.aVector1799.isEmpty();
    }

    protected int method1924() {
        return this.anInt1801;
    }

    protected void method1925(Graphics var1, int var2, int var3) {
        int var4 = this.aVector1799.size();
        Class113 var5;
        int var6;
        if (this.aBoolean1798) {
            var6 = 0;

            for (int var7 = 0; var7 < var4; ++var7) {
                var5 = (Class113) ((Class113) this.aVector1799.elementAt(var7));
                var6 += var5.method1937();
            }

            var2 += (this.anInt1797 - var6) / 2;
        }

        for (var6 = 0; var6 < var4; ++var6) {
            var5 = (Class113) ((Class113) this.aVector1799.elementAt(var6));
            var5.method1938(var1, var2, var3);
        }

    }

    static {
        aStringArray1803[0] = "\'relatx\'=";
        aStringArray1803[1] = "[HtmlLine: words.size=";
        aStringArray1803[2] = " \'height\'=";
    }
}
