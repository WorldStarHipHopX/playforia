package com.aapeli.client;

import com.aapeli.client.TextManager;
import com.aapeli.tools.Tools;
import com.aapeli.tools.XmlUnit;

class Class89 {

    private String aString1527;
    private String aString1528;
    private String aString1529;
    private String aString1530;
    private final TextManager aTextManager1531;
    private static final String[] aStringArray1532 = new String[4];


    protected Class89(TextManager var1, String var2, XmlUnit var3, boolean var4) {
        this.aTextManager1531 = var1;
        this.aString1527 = var2.substring(0, 2).toLowerCase();
        this.aString1528 = var3.getChildValue("singular");
        this.aString1529 = var3.getChildValue("plural");
        this.aString1530 = var3.getChildValue("zero");
        if (var4) {
            this.aString1528 = Tools.reverse(this.aString1528);
            this.aString1529 = Tools.reverse(this.aString1529);
            this.aString1530 = Tools.reverse(this.aString1530);
        }

    }

    protected String method1737(int var1) {
        if (var1 == 0) {
            if (this.aString1530 != null) {
                return this.aString1530;
            }

            if (this.aString1529 != null && !this.aString1527.equals("fr")) {
                return this.aString1529;
            }
        } else if ((var1 < 0 || var1 > 1) && this.aString1529 != null) {
            return this.aString1529;
        }

        return this.aString1528;
    }

    static {
        aStringArray1532[0] = "plural";
        aStringArray1532[1] = "singular";
        aStringArray1532[2] = "zero";
        aStringArray1532[3] = "fr";
    }
}
