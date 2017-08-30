package com.playray.singleclient;


class Class148 {

    private static final String[] aStringArray2207 = new String[48];
    private static final int anInt2208;


    protected String method2244(String var1) {
        char var2 = this.method2246(var1);
        if (var2 == 0) {
            return " " + var1;
        } else {
            for (int var4 = 0; var4 < anInt2208; ++var4) {
                int var3 = 0;

                while ((var3 = var1.indexOf(aStringArray2207[var4], var3)) >= 0) {
                    if (!this.method2247(var1, var3, var2)) {
                        var1 = var1.substring(0, var3) + var2 + (char) (32 + var4) + var1.substring(var3 + aStringArray2207[var4].length());
                        var3 += 2;
                    } else {
                        ++var3;
                    }
                }
            }

            var1 = var2 + var1;
            return var1;
        }
    }

    protected String method2245(String var1) {
        char var2 = var1.charAt(0);
        var1 = var1.substring(1);
        if (var2 == 0) {
            return var1;
        } else {
            int var3;
            while ((var3 = var1.indexOf(var2)) >= 0) {
                var1 = var1.substring(0, var3) + aStringArray2207[var1.charAt(var3 + 1) - 32] + var1.substring(var3 + 2);
            }

            return var1;
        }
    }

    private char method2246(String var1) {
        for (char var2 = 33; var2 < 127; ++var2) {
            if (var1.indexOf(var2) == -1) {
                return var2;
            }
        }

        return '\u0000';
    }

    private boolean method2247(String var1, int var2, char var3) {
        return var2 == 0 ? false : var1.charAt(var2 - 1) == var3;
    }

    static {
        aStringArray2207[0] = "error-debug\t";
        aStringArray2207[1] = "localip\t";
        aStringArray2207[2] = "gamename\t";
        aStringArray2207[3] = "logintype\treg";
        aStringArray2207[4] = "logintype\tnr";
        aStringArray2207[5] = "reglogin\t";
        aStringArray2207[6] = "login\t";
        aStringArray2207[7] = "userdata\t";
        aStringArray2207[8] = "badges\t";
        aStringArray2207[9] = "products";
        aStringArray2207[10] = "ps\t";
        aStringArray2207[11] = "bitmaps\t";
        aStringArray2207[12] = "started";
        aStringArray2207[13] = "finished\ttime";
        aStringArray2207[14] = "finished";
        aStringArray2207[15] = "score\t";
        aStringArray2207[16] = "toplist\t";
        aStringArray2207[17] = "ok\t";
        aStringArray2207[18] = "ok";
        aStringArray2207[19] = "serverfull";
        aStringArray2207[20] = "failed";
        aStringArray2207[21] = "tooshort";
        aStringArray2207[22] = "toolong";
        aStringArray2207[23] = "forbidden";
        aStringArray2207[24] = "inuse";
        aStringArray2207[25] = "notstarted";
        aStringArray2207[26] = "overflow";
        aStringArray2207[27] = "nolist";
        aStringArray2207[28] = "ab\t";
        aStringArray2207[29] = "credits";
        aStringArray2207[30] = "buy\t";
        aStringArray2207[31] = "nobalance";
        aStringArray2207[32] = "quit";
        aStringArray2207[33] = "http://java.";
        aStringArray2207[34] = "playray.";
        aStringArray2207[35] = "aapeli.com";
        aStringArray2207[36] = "/var/bitmap/";
        aStringArray2207[37] = "occreate\t";
        aStringArray2207[38] = "noproduct";
        aStringArray2207[39] = "ocpoll\t";
        aStringArray2207[40] = "unpaid";
        aStringArray2207[41] = "paid";
        aStringArray2207[42] = "error";
        aStringArray2207[43] = "occancel\t";
        aStringArray2207[44] = "reqpd";
        aStringArray2207[45] = "endpd";
        aStringArray2207[46] = "savepd\t";
        aStringArray2207[47] = "pd\t";
        anInt2208 = aStringArray2207.length;
    }
}
