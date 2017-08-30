package com.playray.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Vector;

public class StringDraw {

    public static final int ALIGN_LEFT = -1;
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_RIGHT = 1;
    private static final String aString1942 = "...";


    public static int drawString(Graphics var0, String var1, int var2, int var3, int var4) {
        return drawOutlinedString(var0, (Color) null, var1, var2, var3, var4);
    }

    public static int drawOutlinedString(Graphics var0, Color var1, String var2, int var3, int var4, int var5) {
        int var6 = getStringWidth(var0, var2);
        if (var5 == 0) {
            var3 -= var6 / 2;
        }

        if (var5 == 1) {
            var3 -= var6;
        }

        if (var1 != null) {
            Color var7 = var0.getColor();
            var0.setColor(var1);
            var0.drawString(var2, var3 - 1, var4);
            var0.drawString(var2, var3 + 1, var4);
            var0.drawString(var2, var3, var4 - 1);
            var0.drawString(var2, var3, var4 + 1);
            var0.setColor(var7);
        }

        var0.drawString(var2, var3, var4);
        return var6;
    }

    public static int[] drawStringWithMaxWidth(Graphics var0, String var1, int var2, int var3, int var4, int var5) {
        return drawOutlinedStringWithMaxWidth(var0, (Color) null, var1, var2, var3, var4, var5, -1);
    }

    public static int[] drawStringWithMaxWidth(Graphics var0, String var1, int var2, int var3, int var4, int var5, int var6) {
        return drawOutlinedStringWithMaxWidth(var0, (Color) null, var1, var2, var3, var4, var5, var6);
    }

    public static int[] drawOutlinedStringWithMaxWidth(Graphics var0, Color var1, String var2, int var3, int var4, int var5, int var6) {
        return drawOutlinedStringWithMaxWidth(var0, var1, var2, var3, var4, var5, var6, -1);
    }

    public static int[] drawOutlinedStringWithMaxWidth(Graphics var0, Color var1, String var2, int var3, int var4, int var5, int var6, int var7) {
        Font var8 = var0.getFont();
        FontMetrics var9 = var0.getFontMetrics(var8);
        Vector var10 = createLines(var9, var2, var6, var7);
        int var11 = var8.getSize();
        int var12 = var11 + (var11 + 4) / 5;
        if (var1 != null) {
            var12 += 2;
        }

        int[] var13 = new int[]{var10.size(), 0, 0};
        var13[1] = var13[0] * var12;
        var13[2] = 0;

        for (int var15 = 0; var15 < var13[0]; ++var15) {
            int var14 = drawOutlinedString(var0, var1, (String) ((String) var10.elementAt(var15)), var3, var4, var5);
            if (var14 > var13[2]) {
                var13[2] = var14;
            }

            var4 += var12;
        }

        return var13;
    }

    public static int getStringWidth(Graphics var0, String var1) {
        return getStringWidth(var0, var0.getFont(), var1);
    }

    public static int getStringWidth(Graphics var0, Font var1, String var2) {
        return getStringWidth(var0.getFontMetrics(var1), var2);
    }

    public static int getStringWidth(Component var0, Font var1, String var2) {
        return getStringWidth(var0.getFontMetrics(var1), var2);
    }

    public static int getStringWidth(FontMetrics var0, String var1) {
        return var0.stringWidth(var1);
    }

    public static Vector createLines(Graphics var0, String var1, int var2) {
        return createLines(var0, var0.getFont(), var1, var2);
    }

    public static Vector createLines(Graphics var0, Font var1, String var2, int var3) {
        return createLines(var0.getFontMetrics(var1), var2, var3, -1);
    }

    public static Vector createLines(Component var0, Font var1, String var2, int var3) {
        return createLines(var0.getFontMetrics(var1), var2, var3, -1);
    }

    public static Vector createLines(FontMetrics var0, String var1, int var2, int var3) {
        Vector var4 = new Vector();
        method2036(var4, var1, var0, var2, var3);
        return var4;
    }

    private static void method2036(Vector var0, String var1, FontMetrics var2, int var3, int var4) {
        String var5 = var1;
        int var7 = var1.indexOf(10);
        if (var7 >= 0) {
            var5 = var1.substring(0, var7);
        }

        boolean var8 = false;

        while (!var8 && getStringWidth(var2, var5) > var3) {
            String var6 = var5;
            var5 = method2037(var5);
            if (var5.length() == 0) {
                var5 = var6;
                var8 = true;
            }
        }

        var0.addElement(var5);
        int var9 = var5.length();
        if (var9 < var1.length()) {
            String var10 = var1.substring(var9);
            if (Character.isWhitespace(var10.charAt(0))) {
                var10 = var10.substring(1);
            }

            if (var10.length() > 0) {
                if (var4 > 0 && var0.size() >= var4) {
                    var0.removeElementAt(var0.size() - 1);
                    var5 = method2038(var5, var2, var3);
                    var0.addElement(var5);
                } else {
                    method2036(var0, var10, var2, var3, var4);
                }
            }
        }

    }

    private static String method2037(String var0) {
        int var1 = var0.lastIndexOf(32);
        if (var1 == -1) {
            var1 = var0.length() - 1;
        }

        return var0.substring(0, var1);
    }

    private static String method2038(String var0, FontMetrics var1, int var2) {
        while (true) {
            int var3 = var0.length();
            if (var3 == 0 || var1.stringWidth(var0 + "...") <= var2) {
                return var0 + "...";
            }

            var0 = var0.substring(0, var3 - 1);
        }
    }

}
