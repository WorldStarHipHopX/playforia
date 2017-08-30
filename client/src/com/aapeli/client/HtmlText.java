package com.aapeli.client;

import com.aapeli.client.Class79;
import com.aapeli.client.Class81;

import java.awt.Graphics;
import java.util.Vector;

public class HtmlText {

    private Vector aVector1348;
    private static final String[] aStringArray1349 = new String[4];


    public HtmlText(Graphics var1, int var2, String var3) {
        this.aVector1348 = this.method1589(var1, var2, var3);
    }

    public String toString() {
        int var1 = this.aVector1348.size();
        String var2 = "[HtmlText: lines.size=" + var1 + "\n";

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = var2 + " " + ((Class79) ((Class79) this.aVector1348.elementAt(var3))).toString() + "\n";
        }

        var2 = var2 + "]";
        return var2;
    }

    public int print(Graphics var1, int var2, int var3) {
        int var4 = this.aVector1348.size();
        int var5 = 0;

        for (int var7 = 0; var7 < var4; ++var7) {
            Class79 var6 = (Class79) ((Class79) this.aVector1348.elementAt(var7));
            var5 = var6.method1607() + 5;
            if (var7 > 0) {
                var3 += var5;
            }

            var6.method1608(var1, var2, var3);
        }

        return var3 + var5;
    }

    private Vector method1589(Graphics var1, int var2, String var3) {
        Class81 var4 = new Class81(this, var3, var1);
        Vector var5 = new Vector();
        boolean var6 = false;
        Class79 var7 = new Class79(this, var1, var2, var6);

        String var8;
        while ((var8 = var4.method1611()) != null) {
            if (var8.equals("<br>")) {
                var5.addElement(var7);
                var7 = new Class79(this, var1, var2, var6);
            } else if (var8.equals("<center>")) {
                var6 = true;
                var7 = this.method1590(var7, var5, var1, var2, var6);
            } else if (var8.equals("</center>")) {
                var6 = false;
                var7 = this.method1590(var7, var5, var1, var2, var6);
            } else {
                int var9 = var1.getFontMetrics().stringWidth(var8);
                if (!var7.method1604(var9)) {
                    var5.addElement(var7);
                    var7 = new Class79(this, var1, var2, var6);
                }

                var7.method1605(var8, var1.getFont(), var9);
            }
        }

        this.method1591(var7, var5);
        return var5;
    }

    private Class79 method1590(Class79 var1, Vector var2, Graphics var3, int var4, boolean var5) {
        this.method1591(var1, var2);
        return new Class79(this, var3, var4, var5);
    }

    private void method1591(Class79 var1, Vector var2) {
        if (!var1.method1606()) {
            var2.addElement(var1);
        }

    }

    static {
        aStringArray1349[0] = "<br>";
        aStringArray1349[1] = "<center>";
        aStringArray1349[2] = "</center>";
        aStringArray1349[3] = "[HtmlText: lines.size=";
    }
}
