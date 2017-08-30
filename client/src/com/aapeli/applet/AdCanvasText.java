package com.aapeli.applet;

import com.aapeli.client.StringDraw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.StringTokenizer;

class AdCanvasText {

    private int anInt1303;
    private int anInt1304;
    private int anInt1305;
    private Color aColor1306;
    private Color aColor1307;
    private String aString1308;
    private Font fontDialog;
    private int anInt1310;


    private AdCanvasText(int var1, int var2, int var3, int var4, Color var5, Color var6, int size, boolean bold, String var9) {
        this.anInt1303 = var1;
        this.anInt1304 = var2;
        this.anInt1305 = var4;
        this.aColor1306 = var5;
        this.aColor1307 = var6;
        this.aString1308 = var9;
        this.fontDialog = new Font("Dialog", bold ? 1 : 0, size);
        this.anInt1310 = -1;
        if (var3 > 0) {
            this.anInt1310 = 1;
        } else if (var3 == 0) {
            this.anInt1310 = 0;
        }

    }

    protected static AdCanvasText method1547(String var0) {
        try {
            int var1 = var0.indexOf(58);
            String var2 = var0.substring(var1 + 1);
            StringTokenizer var3 = new StringTokenizer(var0.substring(0, var1), ",");
            int var4 = Integer.parseInt(var3.nextToken());
            int var5 = Integer.parseInt(var3.nextToken());
            int var6 = Integer.parseInt(var3.nextToken());
            int var7 = Integer.parseInt(var3.nextToken());
            Color var8 = hex2Color(var3.nextToken(), false);
            Color var9 = hex2Color(var3.nextToken(), true);
            int var10 = Integer.parseInt(var3.nextToken());
            boolean var11 = var3.nextToken().equalsIgnoreCase("bold");
            AdCanvasText var12 = new AdCanvasText(var4, var5, var6, var7, var8, var9, var10, var11, var2);
            return var12;
        } catch (Exception var13) {
            return null;
        }
    }

    protected void method1548(Graphics var1) {
        var1.setFont(this.fontDialog);
        var1.setColor(this.aColor1306);
        if (this.anInt1305 > 0) {
            StringDraw.drawOutlinedStringWithMaxWidth(var1, this.aColor1307, this.aString1308, this.anInt1303, this.anInt1304, this.anInt1310, this.anInt1305);
        } else {
            StringDraw.drawOutlinedString(var1, this.aColor1307, this.aString1308, this.anInt1303, this.anInt1304, this.anInt1310);
        }

    }

    private static Color hex2Color(String hex, boolean noThrow) throws Exception {
        try {
            if (hex.startsWith("#")) {
                hex = hex.substring(1);
            } else if (hex.startsWith("0x")) {
                hex = hex.substring(2);
            }

            int var2 = Integer.parseInt(hex, 16);
            if (var2 < 0) {
                throw new Exception();
            } else {
                Color var3 = new Color(var2);
                return var3;
            }
        } catch (Exception var4) {
            if (!noThrow) {
                throw var4;
            } else {
                return null;
            }
        }
    }
}
