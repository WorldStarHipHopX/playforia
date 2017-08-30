package com.playray.client;

import com.playray.client.TextManager;
import com.playray.tools.Tools;
import com.playray.tools.XmlUnit;

class Class123 {

    private String aString1873;
    private String aString1874;
    private String aString1875;
    private String aString1876;
    private final TextManager aTextManager1877;
    private static final String[] aStringArray1878 = new String[4];


    protected Class123(TextManager var1, String var2, XmlUnit var3, boolean var4) {
        this.aTextManager1877 = var1;
        this.aString1873 = var2.substring(0, 2).toLowerCase();
        this.aString1874 = var3.getChildValue("singular");
        this.aString1875 = var3.getChildValue("plural");
        this.aString1876 = var3.getChildValue("zero");
        if (var4) {
            this.aString1874 = Tools.reverse(this.aString1874);
            this.aString1875 = Tools.reverse(this.aString1875);
            this.aString1876 = Tools.reverse(this.aString1876);
        }

    }

    protected String method2001(int var1) {
        if (var1 == 0) {
            if (this.aString1876 != null) {
                return this.aString1876;
            }

            if (this.aString1875 != null && !this.aString1873.equals("fr")) {
                return this.aString1875;
            }
        } else if ((var1 < 0 || var1 > 1) && this.aString1875 != null) {
            return this.aString1875;
        }

        return this.aString1874;
    }

    static {
        aStringArray1878[0] = "fr";
        aStringArray1878[1] = "plural";
        aStringArray1878[2] = "singular";
        aStringArray1878[3] = "zero";
    }
}
