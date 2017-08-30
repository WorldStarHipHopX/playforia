package com.playray.applet;

import com.playray.client.StringDraw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.StringTokenizer;

final class Class109 {

    private int anInt1748;
    private int anInt1749;
    private int anInt1750;
    private Color aColor1751;
    private Color aColor1752;
    private String aString1753;
    private Font aFont1754;
    private int anInt1755;
    private static final String[] aStringArray1756 = new String[3];


    private Class109(int var1, int var2, int var3, int var4, Color var5, Color var6, int var7, boolean var8, String var9) {
        this.anInt1748 = var1;
        this.anInt1749 = var2;
        this.anInt1750 = var4;
        this.aColor1751 = var5;
        this.aColor1752 = var6;
        this.aString1753 = var9;
        this.aFont1754 = new Font("Dialog", var8 ? 1 : 0, var7);
        this.anInt1755 = -1;
        if (var3 > 0) {
            this.anInt1755 = 1;
        } else if (var3 == 0) {
            this.anInt1755 = 0;
        }

    }

    protected static Class109 method1882(String var0) {
        try {
            int var1 = var0.indexOf(58);
            String var2 = var0.substring(var1 + 1);
            StringTokenizer var3 = new StringTokenizer(var0.substring(0, var1), ",");
            int var4 = Integer.parseInt(var3.nextToken());
            int var5 = Integer.parseInt(var3.nextToken());
            int var6 = Integer.parseInt(var3.nextToken());
            int var7 = Integer.parseInt(var3.nextToken());
            Color var8 = method1884(var3.nextToken(), false);
            Color var9 = method1884(var3.nextToken(), true);
            int var10 = Integer.parseInt(var3.nextToken());
            boolean var11 = var3.nextToken().equalsIgnoreCase("bold");
            Class109 var12 = new Class109(var4, var5, var6, var7, var8, var9, var10, var11, var2);
            return var12;
        } catch (Exception var13) {
            return null;
        }
    }

    protected void method1883(Graphics var1) {
        var1.setFont(this.aFont1754);
        var1.setColor(this.aColor1751);
        if (this.anInt1750 > 0) {
            StringDraw.drawOutlinedStringWithMaxWidth(var1, this.aColor1752, this.aString1753, this.anInt1748, this.anInt1749, this.anInt1755, this.anInt1750);
        } else {
            StringDraw.drawOutlinedString(var1, this.aColor1752, this.aString1753, this.anInt1748, this.anInt1749, this.anInt1755);
        }

    }

    private static Color method1884(String var0, boolean var1) throws Exception {
        try {
            if (var0.startsWith("#")) {
                var0 = var0.substring(1);
            } else if (var0.startsWith("0x")) {
                var0 = var0.substring(2);
            }

            int var2 = Integer.parseInt(var0, 16);
            if (var2 < 0) {
                throw new Exception();
            } else {
                Color var3 = new Color(var2);
                return var3;
            }
        } catch (Exception var4) {
            if (!var1) {
                throw var4;
            } else {
                return null;
            }
        }
    }

    static {
        aStringArray1756[0] = "bold";
        aStringArray1756[1] = "0x";
        aStringArray1756[2] = "Dialog";
    }
}
