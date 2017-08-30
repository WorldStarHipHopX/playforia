package com.playray.client;

import com.playray.client.HtmlText;

import java.awt.Font;
import java.awt.Graphics;

class Class114 {

    private String aString1810;
    private Graphics aGraphics1811;
    private final HtmlText aHtmlText1812;
    private static final String[] aStringArray1813 = new String[15];


    protected Class114(HtmlText var1, String var2, Graphics var3) {
        this.aHtmlText1812 = var1;
        this.aString1810 = var2.trim();
        this.aGraphics1811 = var3;
    }

    protected String method1939() {
        if (this.aString1810.length() == 0) {
            return null;
        } else {
            char var1 = this.aString1810.charAt(0);
            this.aString1810 = this.aString1810.trim();
            if (this.method1941(var1)) {
                return " ";
            } else {
                Font var4;
                if (this.method1943("strong", "b")) {
                    var4 = this.aGraphics1811.getFont();
                    this.aGraphics1811.setFont(new Font(var4.getName(), 1, var4.getSize()));
                    return this.method1939();
                } else if (this.method1943("/strong", "/b")) {
                    var4 = this.aGraphics1811.getFont();
                    this.aGraphics1811.setFont(new Font(var4.getName(), 0, var4.getSize()));
                    return this.method1939();
                } else if (this.method1942("big")) {
                    var4 = this.aGraphics1811.getFont();
                    this.aGraphics1811.setFont(new Font(var4.getName(), var4.getStyle(), var4.getSize() + 5));
                    return this.method1939();
                } else if (this.method1942("/big")) {
                    var4 = this.aGraphics1811.getFont();
                    this.aGraphics1811.setFont(new Font(var4.getName(), var4.getStyle(), var4.getSize() - 5));
                    return this.method1939();
                } else if (this.method1942("small")) {
                    var4 = this.aGraphics1811.getFont();
                    this.aGraphics1811.setFont(new Font(var4.getName(), var4.getStyle(), var4.getSize() - 3));
                    return this.method1939();
                } else if (this.method1942("/small")) {
                    var4 = this.aGraphics1811.getFont();
                    this.aGraphics1811.setFont(new Font(var4.getName(), var4.getStyle(), var4.getSize() + 3));
                    return this.method1939();
                } else if (this.method1944("br", "br/", "br /")) {
                    return "<br>";
                } else if (this.method1942("center")) {
                    return "<center>";
                } else if (this.method1942("/center")) {
                    return "</center>";
                } else {
                    int var2 = this.method1940();
                    String var3 = this.aString1810.substring(0, var2);
                    this.aString1810 = this.aString1810.substring(var2);
                    return var3;
                }
            }
        }
    }

    private int method1940() {
        int var1 = this.aString1810.length();

        for (int var3 = 1; var3 < var1; ++var3) {
            char var2 = this.aString1810.charAt(var3);
            if (this.method1941(var2) || var2 == 60) {
                return var3;
            }
        }

        return var1;
    }

    private boolean method1941(char var1) {
        return var1 == 32 || var1 == 9 || var1 == 10 || var1 == 13;
    }

    private boolean method1942(String var1) {
        return this.method1945(new String[]{"<" + var1 + ">"});
    }

    private boolean method1943(String var1, String var2) {
        return this.method1945(new String[]{"<" + var1 + ">", "<" + var2 + ">"});
    }

    private boolean method1944(String var1, String var2, String var3) {
        return this.method1945(new String[]{"<" + var1 + ">", "<" + var2 + ">", "<" + var3 + ">"});
    }

    private boolean method1945(String[] var1) {
        String var2 = this.aString1810.toLowerCase();

        for (int var3 = 0; var3 < var1.length; ++var3) {
            if (var2.startsWith(var1[var3])) {
                int var4 = var1[var3].length();
                this.aString1810 = this.aString1810.substring(var4);
                return true;
            }
        }

        return false;
    }

    static {
        aStringArray1813[0] = "strong";
        aStringArray1813[1] = "center";
        aStringArray1813[2] = "/b";
        aStringArray1813[3] = "br /";
        aStringArray1813[4] = "<center>";
        aStringArray1813[5] = "/center";
        aStringArray1813[6] = "big";
        aStringArray1813[7] = "/small";
        aStringArray1813[8] = "br";
        aStringArray1813[9] = "</center>";
        aStringArray1813[10] = "small";
        aStringArray1813[11] = "<br>";
        aStringArray1813[12] = "/strong";
        aStringArray1813[13] = "/big";
        aStringArray1813[14] = "br/";
    }
}
