package com.aapeli.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Vector;

public class StringDraw {

    public static final int ALIGN_LEFT = -1;
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_RIGHT = 1;
    public static final int ALIGN_CENTER_LEFT_ALWAYS_VISIBLE = -2;
    public static final int ALIGN_CENTER_RIGHT_ALWAYS_VISIBLE = 2;


    public static int drawString(Graphics g, String colour, int x, int y, int alignment) {
        return drawOutlinedString(g, (Color) null, colour, x, y, alignment);
    }

    public static int drawOutlinedString(Graphics g, Color colour, String text, int x, int y, int alignment) {
        int textWidth = getStringWidth(g, text);
        if (alignment == ALIGN_CENTER || alignment == ALIGN_CENTER_LEFT_ALWAYS_VISIBLE || alignment == ALIGN_CENTER_RIGHT_ALWAYS_VISIBLE) {
            x -= textWidth / 2;
        }

        if (alignment == ALIGN_RIGHT) {
            x -= textWidth;
        }

        if (alignment == ALIGN_CENTER_LEFT_ALWAYS_VISIBLE || alignment == ALIGN_CENTER_RIGHT_ALWAYS_VISIBLE) {
            Rectangle bounds = g.getClipBounds();
            if (bounds != null) {
                if (alignment == ALIGN_CENTER_LEFT_ALWAYS_VISIBLE) {
                    if (colour == null && x < 0) {
                        x = 0;
                    } else if (colour != null && x < 1) {
                        x = 1;
                    }
                } else if (colour == null && x + textWidth >= bounds.width) {
                    x = bounds.width - 1 - textWidth;
                } else if (colour != null && x + textWidth >= bounds.width - 1) {
                    x = bounds.width - 2 - textWidth;
                }
            }
        }

        if (colour != null) {
            Color oldColour = g.getColor();
            g.setColor(colour);
            g.drawString(text, x - 1, y);
            g.drawString(text, x + 1, y);
            g.drawString(text, x, y - 1);
            g.drawString(text, x, y + 1);
            g.setColor(oldColour);
        }

        g.drawString(text, x, y);
        return textWidth;
    }

    public static int[] drawStringWithMaxWidth(Graphics g, String text, int var2, int var3, int var4, int var5) {
        return drawOutlinedStringWithMaxWidth(g, (Color) null, text, var2, var3, var4, var5);
    }

    public static int[] drawOutlinedStringWithMaxWidth(Graphics g, Color colour, String text, int var3, int var4, int var5, int var6) {
        Font font = g.getFont();
        FontMetrics fontMetrics = g.getFontMetrics(font);
        Vector vector = createLines(fontMetrics, text, var6);
        int fontSize = font.getSize();
        int var11 = fontSize + (fontSize + 4) / 5;
        if (colour != null) {
            var11 += 2;
        }

        int[] var12 = new int[]{vector.size(), 0, 0};
        var12[1] = var12[0] * var11;
        var12[2] = 0;

        for (int var14 = 0; var14 < var12[0]; ++var14) {
            int var13 = drawOutlinedString(g, colour, (String) ((String) vector.elementAt(var14)), var3, var4, var5);
            if (var13 > var12[2]) {
                var12[2] = var13;
            }

            var4 += var11;
        }

        return var12;
    }

    public static int drawString(Graphics var0, String var1, int var2, int var3, int var4, int var5) {
        int[] var6 = drawOutlinedStringWithMaxWidth(var0, (Color) null, var1, var2, var3, var4, var5);
        return var6[2];
    }

    public static int drawOutlinedString(Graphics var0, Color var1, String var2, int var3, int var4, int var5, int var6) {
        int[] var7 = drawOutlinedStringWithMaxWidth(var0, var1, var2, var3, var4, var5, var6);
        return var7[2];
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
        return createLines(var0.getFontMetrics(var1), var2, var3);
    }

    public static Vector createLines(Component var0, Font var1, String var2, int var3) {
        return createLines(var0.getFontMetrics(var1), var2, var3);
    }

    public static Vector createLines(FontMetrics var0, String var1, int var2) {
        Vector var3 = new Vector();
        method1697(var3, var1, var0, var2);
        return var3;
    }

    private static void method1697(Vector var0, String var1, FontMetrics var2, int var3) {
        String var4 = var1;
        int var6 = var1.indexOf(10);
        if (var6 >= 0) {
            var4 = var1.substring(0, var6);
        }

        boolean var7 = false;

        while (!var7 && getStringWidth(var2, var4) > var3) {
            String var5 = var4;
            var4 = method1698(var4);
            if (var4.length() == 0) {
                var4 = var5;
                var7 = true;
            }
        }

        var0.addElement(var4);
        int var8 = var4.length();
        if (var8 < var1.length()) {
            String var9 = var1.substring(var8);
            if (Character.isWhitespace(var9.charAt(0))) {
                var9 = var9.substring(1);
            }

            if (var9.length() > 0) {
                method1697(var0, var9, var2, var3);
            }
        }

    }

    private static String method1698(String var0) {
        int var1 = var0.lastIndexOf(32);
        if (var1 == -1) {
            var1 = var0.length() - 1;
        }

        return var0.substring(0, var1);
    }
}
