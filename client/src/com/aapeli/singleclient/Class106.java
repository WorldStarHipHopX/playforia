package com.aapeli.singleclient;


class Class106 {

    private static final String[] aStringArray1704 = new String[48];
    private static final int anInt1705;


    protected String method1854(String var1) {
        char var2 = this.method1856(var1);
        if (var2 == 0) {
            return " " + var1;
        } else {
            for (int var4 = 0; var4 < anInt1705; ++var4) {
                int var3 = 0;

                while ((var3 = var1.indexOf(aStringArray1704[var4], var3)) >= 0) {
                    if (!this.method1857(var1, var3, var2)) {
                        var1 = var1.substring(0, var3) + var2 + (char) (32 + var4) + var1.substring(var3 + aStringArray1704[var4].length());
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

    protected String method1855(String var1) {
        char var2 = var1.charAt(0);
        var1 = var1.substring(1);
        if (var2 == 0) {
            return var1;
        } else {
            int var3;
            while ((var3 = var1.indexOf(var2)) >= 0) {
                var1 = var1.substring(0, var3) + aStringArray1704[var1.charAt(var3 + 1) - 32] + var1.substring(var3 + 2);
            }

            return var1;
        }
    }

    private char method1856(String var1) {
        for (char var2 = 33; var2 < 127; ++var2) {
            if (var1.indexOf(var2) == -1) {
                return var2;
            }
        }

        return '\u0000';
    }

    private boolean method1857(String var1, int var2, char var3) {
        return var2 == 0 ? false : var1.charAt(var2 - 1) == var3;
    }

    static {
        aStringArray1704[0] = "error-debug\t";
        aStringArray1704[1] = "localip\t";
        aStringArray1704[2] = "gamename\t";
        aStringArray1704[3] = "logintype\treg";
        aStringArray1704[4] = "logintype\tnr";
        aStringArray1704[5] = "reglogin\t";
        aStringArray1704[6] = "login\t";
        aStringArray1704[7] = "userdata\t";
        aStringArray1704[8] = "badges\t";
        aStringArray1704[9] = "products";
        aStringArray1704[10] = "ps\t";
        aStringArray1704[11] = "bitmaps\t";
        aStringArray1704[12] = "started";
        aStringArray1704[13] = "finished\ttime";
        aStringArray1704[14] = "finished";
        aStringArray1704[15] = "score\t";
        aStringArray1704[16] = "toplist\t";
        aStringArray1704[17] = "ok\t";
        aStringArray1704[18] = "ok";
        aStringArray1704[19] = "serverfull";
        aStringArray1704[20] = "failed";
        aStringArray1704[21] = "tooshort";
        aStringArray1704[22] = "toolong";
        aStringArray1704[23] = "forbidden";
        aStringArray1704[24] = "inuse";
        aStringArray1704[25] = "notstarted";
        aStringArray1704[26] = "overflow";
        aStringArray1704[27] = "nolist";
        aStringArray1704[28] = "ab\t";
        aStringArray1704[29] = "credits";
        aStringArray1704[30] = "buy\t";
        aStringArray1704[31] = "nobalance";
        aStringArray1704[32] = "quit";
        aStringArray1704[33] = "http://java.";
        aStringArray1704[34] = "playray.";
        aStringArray1704[35] = "aapeli.com";
        aStringArray1704[36] = "/var/bitmap/";
        aStringArray1704[37] = "occreate\t";
        aStringArray1704[38] = "noproduct";
        aStringArray1704[39] = "ocpoll\t";
        aStringArray1704[40] = "unpaid";
        aStringArray1704[41] = "paid";
        aStringArray1704[42] = "error";
        aStringArray1704[43] = "occancel\t";
        aStringArray1704[44] = "reqpd";
        aStringArray1704[45] = "endpd";
        aStringArray1704[46] = "savepd\t";
        aStringArray1704[47] = "pd\t";
        anInt1705 = aStringArray1704.length;
    }
}
