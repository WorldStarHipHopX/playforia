package com.playray.client;

import com.playray.client.Class112;
import com.playray.client.Class114;

import java.awt.Graphics;
import java.util.Vector;

public class HtmlText {

    private Vector aVector1835;
    private static final String[] aStringArray1836 = new String[4];


    public HtmlText(Graphics var1, int var2, String var3) {
        this.aVector1835 = this.method1978(var1, var2, var3);
    }

    public String toString() {
        int var1 = this.aVector1835.size();
        String var2 = "[HtmlText: lines.size=" + var1 + "\n";

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = var2 + " " + ((Class112) ((Class112) this.aVector1835.elementAt(var3))).toString() + "\n";
        }

        var2 = var2 + "]";
        return var2;
    }

    public int print(Graphics var1, int var2, int var3) {
        int var4 = this.aVector1835.size();
        int var5 = 0;

        for (int var7 = 0; var7 < var4; ++var7) {
            Class112 var6 = (Class112) ((Class112) this.aVector1835.elementAt(var7));
            var5 = var6.method1924() + 5;
            if (var7 > 0) {
                var3 += var5;
            }

            var6.method1925(var1, var2, var3);
        }

        return var3 + var5;
    }

    private Vector method1978(Graphics var1, int var2, String var3) {
        Class114 var4 = new Class114(this, var3, var1);
        Vector var5 = new Vector();
        boolean var6 = false;
        Class112 var7 = new Class112(this, var1, var2, var6);

        String var8;
        while ((var8 = var4.method1939()) != null) {
            if (var8.equals("<br>")) {
                var5.addElement(var7);
                var7 = new Class112(this, var1, var2, var6);
            } else if (var8.equals("<center>")) {
                var6 = true;
                var7 = this.method1979(var7, var5, var1, var2, var6);
            } else if (var8.equals("</center>")) {
                var6 = false;
                var7 = this.method1979(var7, var5, var1, var2, var6);
            } else {
                int var9 = var1.getFontMetrics().stringWidth(var8);
                if (!var7.method1921(var9)) {
                    var5.addElement(var7);
                    var7 = new Class112(this, var1, var2, var6);
                }

                var7.method1922(var8, var1.getFont(), var9);
            }
        }

        this.method1980(var7, var5);
        return var5;
    }

    private Class112 method1979(Class112 var1, Vector var2, Graphics var3, int var4, boolean var5) {
        this.method1980(var1, var2);
        return new Class112(this, var3, var4, var5);
    }

    private void method1980(Class112 var1, Vector var2) {
        if (!var1.method1923()) {
            var2.addElement(var1);
        }

    }

    static {
        aStringArray1836[0] = "<br>";
        aStringArray1836[1] = "</center>";
        aStringArray1836[2] = "<center>";
        aStringArray1836[3] = "[HtmlText: lines.size=";
    }
}
