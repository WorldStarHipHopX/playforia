package adraw;


class ConnCrypto {

    private static final String[] cryptoCmds;
    private static final int anInt933;
    private static final String aString934;
    private static final String aString935;
    private static final int anInt936;
    protected Object syncObjectOut = new Object();
    protected Object syncObjectIn = new Object();
    private int anInt939;
    private int anInt940;
    private int anInt941;
    private int anInt942;
    private int anInt943;
    private static final String[] aStringArray944 = new String[3];


    protected ConnCrypto() {
        this.anInt939 = this.anInt940 = this.anInt941 = this.anInt942 = this.anInt943 = -1;
    }

    protected void setKey(int var1) {
        this.anInt939 = anInt936;

        for (int var2 = 0; var2 < 9; ++var2) {
            this.anInt939 += var1 % 10 * (var2 + 1);
            var1 /= 10;
        }

        this.anInt942 = 1;
        this.anInt943 = 0;
    }

    protected boolean method1109() {
        return this.anInt939 > 0;
    }

    protected String encrypt(String var1) {
        if (this.anInt939 == -1) {
            return var1;
        } else {
            var1 = this.method1112(var1);
            var1 = this.method1113(var1);
            var1 = this.method1114(var1);
            var1 = this.method1115(var1);
            var1 = this.method1117(var1);
            return var1;
        }
    }

    protected String decrypt(String var1) {
        if (this.anInt939 == -1) {
            return var1;
        } else {
            var1 = this.method1118(var1);
            var1 = this.method1119(var1);
            var1 = this.method1120(var1);
            var1 = this.method1121(var1);
            return var1;
        }
    }

    private String method1112(String var1) {
        int var2 = var1.length();
        StringBuffer var3 = new StringBuffer(var2);

        for (int var4 = 0; var4 < var2; ++var4) {
            char var5 = var1.charAt(var4);
            if (var5 > 255) {
                var5 = '?';
            }

            var3.append(var5);
        }

        return var3.toString();
    }

    private String method1113(String var1) {
        var1 = Integer.toString(this.anInt942, 36) + "\t" + var1;
        ++this.anInt942;
        return var1;
    }

    private String method1114(String var1) {
        for (int var2 = 0; var2 < anInt933; ++var2) {
            int var3 = 0;

            while ((var3 = var1.indexOf(cryptoCmds[var2], var3)) >= 0) {
                label26:
                {
                    boolean var10000;
                    if (var3 == 0) {
                        var10000 = false;
                    } else {
                        if (var1.charAt(var3 - 1) == 11) {
                            break label26;
                        }

                        var10000 = false;
                    }

                    if (!var10000) {
                        var1 = var1.substring(0, var3) + '\u000b' + ("B/sÅ}6x\"A\\h´wT[yp>Jö-t@PLäÖ]g0f#G½&H" + '\u000b' + "XC|*n,q4iZ`NjUbO~Y7(IvMu?_e§E=år%lKWc\t9:$QSzD8;<a¤\'Ä+R{ko3£m^2!1V)F5.d").charAt(var2) + var1.substring(var3 + cryptoCmds[var2].length());
                        var3 += 2;
                        continue;
                    }
                }

                ++var3;
            }
        }

        return var1;
    }

    private String method1115(String var1) {
        int var2 = var1.length();
        StringBuffer var3 = new StringBuffer(var2 + 2);
        char var4 = this.method1116();
        var3.append(var4);
        int var5 = this.anInt939 + var4;
        int var6 = (int) (Math.random() * (double) anInt936);
        var4 = ("B/sÅ}6x\"A\\h´wT[yp>Jö-t@PLäÖ]g0f#G½&H" + '\u000b' + "XC|*n,q4iZ`NjUbO~Y7(IvMu?_e§E=år%lKWc\t9:$QSzD8;<a¤\'Ä+R{ko3£m^2!1V)F5.d").charAt(var6);
        var3.append(var4);
        var5 -= var6;
        boolean var7 = false;
        char var8 = 0;

        for (int var9 = 0; var9 < var2; ++var9) {
            var4 = var1.charAt(var9);
            char var10 = var8;
            var8 = var4;
            var6 = ("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^" + '\u000b').indexOf(var4);
            if (var6 > -1) {
                for (var6 += var5 * (var9 + 1) + var9 / 3; var6 >= anInt936 * 100; var6 -= anInt936 * 100) {
                    ;
                }

                while (var6 >= anInt936 * 10) {
                    var6 -= anInt936 * 10;
                }

                while (var6 >= anInt936) {
                    var6 -= anInt936;
                }

                var4 = ("B/sÅ}6x\"A\\h´wT[yp>Jö-t@PLäÖ]g0f#G½&H" + '\u000b' + "XC|*n,q4iZ`NjUbO~Y7(IvMu?_e§E=år%lKWc\t9:$QSzD8;<a¤\'Ä+R{ko3£m^2!1V)F5.d").charAt(var6);
            }

            var3.append(var4);
            if (var10 == 11 && var8 == 47) {
                return var3.toString() + var1.substring(var9 + 1);
            }
        }

        return var3.toString();
    }

    private char method1116() {
        int var1;
        do {
            var1 = (int) (Math.random() * (double) anInt936);
        } while (var1 == this.anInt940);

        this.anInt940 = var1;
        return ("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^" + '\u000b').charAt(var1);
    }

    private String method1117(String var1) {
        int var2 = var1.length();
        StringBuffer var3 = new StringBuffer(var2 * 2);

        for (int var4 = 0; var4 < var2; ++var4) {
            char var5 = var1.charAt(var4);
            if (var5 >= '$' && var5 <= '~') {
                var3.append(var5);
            }

            if (var5 <= '#') {
                var3.append('#');
                var3.append((char) ('#' + var5));
            }

            if (var5 >= 127) {// del
                var3.append('!');
                var3.append((char) ('#' + var5 / 16));
                var3.append((char) ('#' + var5 % 16));
            }
        }

        return var3.toString();
    }

    private String method1118(String var1) {
        int var2 = var1.length();
        StringBuffer var3 = new StringBuffer(var2);

        for (int var4 = 0; var4 < var2; ++var4) {
            char var5 = var1.charAt(var4);
            if (var5 >= '$' && var5 <= '~') {
                var3.append(var5);
            }

            if (var5 == '#') {
                var3.append((char) (var1.charAt(var4 + 1) - '#'));
                ++var4;
            }

            if (var5 == '!') {
                var3.append((char) ((var1.charAt(var4 + 1) - '#') * 16 + (var1.charAt(var4 + 2) - '#')));
                var4 += 2;
            }
        }

        return var3.toString();
    }

    private String method1119(String var1) {
        int var2 = this.anInt939;
        char var3 = var1.charAt(0);
        if (var3 == this.anInt941) {
            return null;
        } else {
            this.anInt941 = var3;
            var2 += var3;
            var3 = var1.charAt(1);
            int var4 = ("B/sÅ}6x\"A\\h´wT[yp>Jö-t@PLäÖ]g0f#G½&H" + '\u000b' + "XC|*n,q4iZ`NjUbO~Y7(IvMu?_e§E=år%lKWc\t9:$QSzD8;<a¤\'Ä+R{ko3£m^2!1V)F5.d").indexOf(var3);
            var2 -= var4;
            int var5 = var1.length();
            StringBuffer var6 = new StringBuffer(var5 - 2);
            boolean var7 = false;
            char var8 = 0;

            for (int var9 = 0; var9 < var5 - 2; ++var9) {
                var3 = var1.charAt(var9 + 2);
                var4 = ("B/sÅ}6x\"A\\h´wT[yp>Jö-t@PLäÖ]g0f#G½&H" + '\u000b' + "XC|*n,q4iZ`NjUbO~Y7(IvMu?_e§E=år%lKWc\t9:$QSzD8;<a¤\'Ä+R{ko3£m^2!1V)F5.d").indexOf(var3);
                if (var4 > -1) {
                    for (var4 -= var2 * (var9 + 1) + var9 / 3; var4 < -anInt936 * 100; var4 += anInt936 * 100) {
                        ;
                    }

                    while (var4 < -anInt936 * 10) {
                        var4 += anInt936 * 10;
                    }

                    while (var4 < 0) {
                        var4 += anInt936;
                    }

                    var3 = ("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^" + '\u000b').charAt(var4);
                }

                var6.append(var3);
                char var10 = var8;
                var8 = var3;
                if (var10 == 11 && var3 == 47) {
                    return var6.toString() + var1.substring(var9 + 3);
                }
            }

            return var6.toString();
        }
    }

    private String method1120(String var1) {
        int var2;
        while ((var2 = var1.indexOf(11)) >= 0) {
            var1 = var1.substring(0, var2) + cryptoCmds[("B/sÅ}6x\"A\\h´wT[yp>Jö-t@PLäÖ]g0f#G½&H" + '\u000b' + "XC|*n,q4iZ`NjUbO~Y7(IvMu?_e§E=år%lKWc\t9:$QSzD8;<a¤\'Ä+R{ko3£m^2!1V)F5.d").indexOf(var1.charAt(var2 + 1))] + var1.substring(var2 + 2);
        }

        return var1;
    }

    private String method1121(String var1) {
        int var2 = var1.indexOf(9);
        int var3 = Integer.parseInt(var1.substring(0, var2), 36);
        if (var3 <= this.anInt943) {
            return null;
        } else {
            this.anInt943 = var3;
            return var1.substring(var2 + 1);
        }
    }

    static {
        aStringArray944[0] = "B/sÅ}6x\"A\\h´wT[yp>Jö-t@PLäÖ]g0f#G½&H";
        aStringArray944[1] = "XC|*n,q4iZ`NjUbO~Y7(IvMu?_e§E=år%lKWc\t9:$QSzD8;<a¤\'Ä+R{ko3£m^2!1V)F5.d";
        aStringArray944[2] = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^";
        cryptoCmds = new String[57];
        cryptoCmds[0] = "basicinfo\t";
        cryptoCmds[1] = "game\td\t";
        cryptoCmds[2] = "game\tgameinfo\t";
        cryptoCmds[3] = "game\tgpart\t";
        cryptoCmds[4] = "game\thint\t-\t";
        cryptoCmds[5] = "game\thint\t";
        cryptoCmds[6] = "game\tjoin\tq,~";
        cryptoCmds[7] = "game\tjoin\t";
        cryptoCmds[8] = "game\tnodrawer";
        cryptoCmds[9] = "game\tnoplayers\t";
        cryptoCmds[10] = "game\towninfo\tq,~";
        cryptoCmds[11] = "game\towninfo\t";
        cryptoCmds[12] = "game\tpart\t";
        cryptoCmds[13] = "game\tplayers\tq,~";
        cryptoCmds[14] = "game\tplayers\t";
        cryptoCmds[15] = "game\tplayers";
        cryptoCmds[16] = "game\tqueue\tcancel";
        cryptoCmds[17] = "game\tqueue\tenter";
        cryptoCmds[18] = "game\tqueue\t";
        cryptoCmds[19] = "game\tqueue";
        cryptoCmds[20] = "game\tquit";
        cryptoCmds[21] = "game\troundend\t";
        cryptoCmds[22] = "game\troundrun\t";
        cryptoCmds[23] = "game\troundstart\t";
        cryptoCmds[24] = "game\tsay\t";
        cryptoCmds[25] = "game\tscore\t";
        cryptoCmds[26] = "game\tvkd";
        cryptoCmds[27] = "lobby\tcreate\t-\t-\t";
        cryptoCmds[28] = "lobby\tcreate\t-\t";
        cryptoCmds[29] = "lobby\tcreate\t";
        cryptoCmds[30] = "lobby\tgamelist\tadd\t";
        cryptoCmds[31] = "lobby\tgamelist\tfull\t0";
        cryptoCmds[32] = "lobby\tgamelist\tfull\t";
        cryptoCmds[33] = "lobby\tgamelist\tremove\t";
        cryptoCmds[34] = "lobby\tjoin\tq,~";
        cryptoCmds[35] = "lobby\tjoin\t";
        cryptoCmds[36] = "lobby\tjoinfromgame\tq,~";
        cryptoCmds[37] = "lobby\tjoinfromgame\t";
        cryptoCmds[38] = "lobby\tnumberofusers\t";
        cryptoCmds[39] = "lobby\townjoin\tq,~";
        cryptoCmds[40] = "lobby\townjoin\t";
        cryptoCmds[41] = "lobby\tpart\t";
        cryptoCmds[42] = "lobby\tquit";
        cryptoCmds[43] = "lobby\tsay\t";
        cryptoCmds[44] = "lobby\tsayp\t";
        cryptoCmds[45] = "lobby\tusers\tq,~";
        cryptoCmds[46] = "lobby\tusers\t";
        cryptoCmds[47] = "login\t";
        cryptoCmds[48] = "logintype\treg";
        cryptoCmds[49] = "logintype\tnr";
        cryptoCmds[50] = "ping";
        cryptoCmds[51] = "pong";
        cryptoCmds[52] = "status\tgame";
        cryptoCmds[53] = "status\tlobby";
        cryptoCmds[54] = "status\tlogin";
        cryptoCmds[55] = "http://static.playray.";
        cryptoCmds[56] = "http://static.aapeli.com/var/bitmap/";
        anInt933 = cryptoCmds.length;
        aString934 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^" + '\u000b';
        aString935 = "B/sÅ}6x\"A\\h´wT[yp>Jö-t@PLäÖ]g0f#G½&H" + '\u000b' + "XC|*n,q4iZ`NjUbO~Y7(IvMu?_e§E=år%lKWc\t9:$QSzD8;<a¤\'Ä+R{ko3£m^2!1V)F5.d";
        anInt936 = ("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^" + '\u000b').length();
    }
}
