package com.playray.client;

import com.playray.client.TextManager;
import com.playray.tools.Tools;

import java.util.StringTokenizer;

public final class BadWordFilter {

    private static final String aString1784 = "0123456789 l |¦!¡( @¤× ª°º¹²³ ©® ¥ßµ¢ àáâãåçèéêëìíîïñòóôõøùúûüýÿæ";
    private static final String aString1785 = "oizeasgtbp i iiiic aox aooize cr ybuc aaaäoceeeeiiiinooooouuuuyye";
    private static final String aString1786 = "¦!¡ []{}() ~ ª°º¹²³* `´\"";
    private static final String aString1787 = "||| |||||| - \'\'\'\'\'\'\' \'\'\'";
    private static final String[] aStringArray1788;
    private static final String[] aStringArray1789;
    private static final String[] aStringArray1790;
    private String aString1791;
    private String aString1792;
    private String[] aStringArray1793;
    private String[] aStringArray1794;
    private char[] aCharArray1795;
    private static final String[] aStringArray1796 = new String[7];


    public BadWordFilter(TextManager var1) {
        this(var1, true, (String) null);
    }

    protected BadWordFilter(TextManager var1, boolean var2) {
        this(var1, var2, (String) null);
    }

    protected BadWordFilter(TextManager var1, boolean var2, String var3) {
        String var4 = var1.getShared(var2 ? "BadWords" : "BadNicks");
        String var5 = var1.getShared("GoodWords");
        if (var3 == null) {
            var3 = var1.getShared("CurseChars");
        }

        this.aString1791 = aString1784;
        this.aString1792 = aString1785;
        if (var1.method2049().equalsIgnoreCase("fi")) {
            this.aString1791 = this.aString1791 + "bdgw";
            this.aString1792 = this.aString1792 + "ptkv";
        }

        StringTokenizer var6 = new StringTokenizer(var4, ",");
        int var7 = var6.countTokens();
        this.aStringArray1793 = new String[var7];

        int var8;
        for (var8 = 0; var8 < var7; ++var8) {
            this.aStringArray1793[var8] = this.method1913(var6.nextToken(), this.aString1791, this.aString1792);
        }

        var6 = new StringTokenizer(var5, ",");
        var7 = var6.countTokens();
        this.aStringArray1794 = new String[var7];

        for (var8 = 0; var8 < var7; ++var8) {
            this.aStringArray1794[var8] = this.method1913(var6.nextToken(), this.aString1791, this.aString1792);
        }

        this.aCharArray1795 = new char[var3.length()];

        for (var8 = 0; var8 < this.aCharArray1795.length; ++var8) {
            this.aCharArray1795[var8] = var3.charAt(var8);
        }

    }

    public boolean containsBadWords(String var1) {
        int[] var2 = this.method1909(var1);
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            if (var2[var4] < 0) {
                return true;
            }
        }

        return false;
    }

    public String filter(String var1) {
        try {
            int[] var2 = this.method1909(var1);
            int var3 = var2.length;
            StringBuffer var4 = new StringBuffer(var3);

            for (int var5 = 0; var5 < var3; ++var5) {
                if (var2[var5] != 0 && var2[var5] != 1) {
                    var4.append(this.method1918());
                } else {
                    var4.append(var1.charAt(var5));
                }
            }

            return var4.toString();
        } catch (Exception var6) {
            return var1;
        }
    }

    private int[] method1909(String var1) {
        int var2 = var1.length();
        int[] var3 = new int[var2];

        for (int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = this.method1910(var1.charAt(var4));
        }

        int[] var6 = new int[var2];

        for (int var5 = 0; var5 < var2; ++var5) {
            var6[var5] = 0;
        }

        this.method1911(var1, var6);
        this.method1912(var1, var6, var3, this.aStringArray1794, 1);
        this.method1912(var1, var6, var3, this.aStringArray1793, -1);
        return var6;
    }

    private int method1910(char var1) {
        return Character.isUpperCase(var1) ? 1 : (Character.isLowerCase(var1) ? -1 : 0);
    }

    private void method1911(String var1, int[] var2) {
        for (int var3 = 0; var3 < aStringArray1790.length; ++var3) {
            int var4 = aStringArray1790[var3].length();

            for (int var5 = 0; (var5 = var1.indexOf(aStringArray1790[var3], var5)) >= 0; var5 += var4) {
                for (int var6 = 0; var6 < var4; ++var6) {
                    var2[var5 + var6] = 1;
                }
            }
        }

    }

    private void method1912(String var1, int[] var2, int[] var3, String[] var4, int var5) {
        String var6 = var1.toLowerCase();
        this.method1915(var6, var2, var3, var4, var5);
        var6 = this.method1913(var6, this.aString1791, this.aString1792);
        this.method1915(var6, var2, var3, var4, var5);
        var6 = var1.toLowerCase();
        var6 = this.method1913(var6, "¦!¡ []{}() ~ ª°º¹²³* `´\"", "||| |||||| - \'\'\'\'\'\'\' \'\'\'");
        var6 = this.method1914(var6, aStringArray1788, aStringArray1789);
        this.method1915(var6, var2, var3, var4, var5);
        var6 = this.method1913(var6, this.aString1791, this.aString1792);
        this.method1915(var6, var2, var3, var4, var5);
    }

    private String method1913(String var1, String var2, String var3) {
        int var4 = var2.length();

        for (int var5 = 0; var5 < var4; ++var5) {
            char var6 = var2.charAt(var5);
            if (var6 != 32) {
                var1 = var1.replace(var6, var3.charAt(var5));
            }
        }

        return var1;
    }

    private String method1914(String var1, String[] var2, String[] var3) {
        int var4 = var2.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            var1 = Tools.replaceAll(var1, var2[var5], var3[var5]);
        }

        return var1;
    }

    private void method1915(String var1, int[] var2, int[] var3, String[] var4, int var5) {
        int var6 = var1.length();

        for (int var7 = 0; var7 < var4.length; ++var7) {
            for (int var8 = 0; var8 < var6; ++var8) {
                this.method1916(var1, var8, var2, var3, var4[var7], var5);
            }
        }

    }

    private void method1916(String var1, int var2, int[] var3, int[] var4, String var5, int var6) {
        int var7 = this.method1917(var1, var2, var3);
        if (var7 == var2) {
            int var8 = var1.length();
            int var9 = var5.length();
            int var10 = 1;
            int var11 = var7;
            char var13 = var5.charAt(0);
            boolean var14 = true;
            int var15 = 0;
            int var16 = 0;

            while (true) {
                char var17 = var1.charAt(var7);
                if (var17 == var13 && var10 < var9 && var5.charAt(var10) == var13) {
                    ++var10;
                }

                int var18;
                if (var17 != var13) {
                    if (var14) {
                        return;
                    }

                    if (var10 == var9) {
                        for (var18 = var2; var18 < var11; ++var18) {
                            var3[var18] = var6;
                        }

                        return;
                    }

                    var13 = var5.charAt(var10);
                    if (var17 != var13) {
                        return;
                    }

                    ++var10;
                }

                var14 = false;
                if (var6 == 1) {
                    if (var4[var7] == 0) {
                        return;
                    }

                    ++var15;
                    if (var15 == 2) {
                        var16 = var4[var7];
                    } else if (var15 > 2 && var4[var7] != var16) {
                        return;
                    }
                }

                ++var7;
                if (var7 == var8) {
                    if (var10 != var9) {
                        return;
                    }

                    for (var18 = var2; var18 < var7; ++var18) {
                        var3[var18] = var6;
                    }

                    return;
                }

                var11 = var7;
                int var12 = this.method1917(var1, var7, var3);
                if (var12 == -1) {
                    if (var10 != var9) {
                        return;
                    }

                    for (var18 = var2; var18 < var7; ++var18) {
                        var3[var18] = var6;
                    }

                    return;
                }

                if (var6 == 1 && var12 > var7) {
                    if (var10 != var9) {
                        return;
                    }

                    for (var18 = var2; var18 < var11; ++var18) {
                        var3[var18] = var6;
                    }

                    return;
                }

                var7 = var12;
            }
        }
    }

    private int method1917(String var1, int var2, int[] var3) {
        int var4 = var1.length();

        do {
            if (var3[var2] != 0) {
                return -1;
            }

            char var5 = var1.charAt(var2);
            if (var5 >= 97 && var5 <= 122 || var5 == 228 || var5 == 246) {
                return var2;
            }

            ++var2;
        } while (var2 < var4);

        return -1;
    }

    private char method1918() {
        int var1 = (int) (Math.random() * (double) this.aCharArray1795.length);
        return this.aCharArray1795[var1];
    }

    static {
        aStringArray1796[0] = "BadWords";
        aStringArray1796[1] = "bdgw";
        aStringArray1796[2] = "BadNicks";
        aStringArray1796[3] = "CurseChars";
        aStringArray1796[4] = "ptkv";
        aStringArray1796[5] = "fi";
        aStringArray1796[6] = "GoodWords";
        aStringArray1788 = new String[25];
        aStringArray1788[0] = "|<";
        aStringArray1788[1] = "<>";
        aStringArray1788[2] = "><";
        aStringArray1788[3] = "/\\/\\";
        aStringArray1788[4] = "\\/\\/";
        aStringArray1788[5] = "/\\/";
        aStringArray1788[6] = "/\\";
        aStringArray1788[7] = "\\/";
        aStringArray1788[8] = "/-\\";
        aStringArray1788[9] = "|-|";
        aStringArray1788[10] = "|\\/|";
        aStringArray1788[11] = "|/\\|";
        aStringArray1788[12] = "|\\|";
        aStringArray1788[13] = "|/|";
        aStringArray1788[14] = "|_|";
        aStringArray1788[15] = "_|";
        aStringArray1788[16] = "|_";
        aStringArray1788[17] = "(_)";
        aStringArray1788[18] = "_)";
        aStringArray1788[19] = "(_";
        aStringArray1788[20] = "||";
        aStringArray1788[21] = "\'|\'";
        aStringArray1788[22] = "|3";
        aStringArray1788[23] = "|)";
        aStringArray1788[24] = "|\'";
        aStringArray1789 = new String[25];
        aStringArray1789[0] = "kk";
        aStringArray1789[1] = "46";
        aStringArray1789[2] = "xx";
        aStringArray1789[3] = "64_f";
        aStringArray1789[4] = ",.E|";
        aStringArray1789[5] = "nnn";
        aStringArray1789[6] = "aa";
        aStringArray1789[7] = "vv";
        aStringArray1789[8] = "aaa";
        aStringArray1789[9] = "hhh";
        aStringArray1789[10] = "64_f";
        aStringArray1789[11] = ",.E|";
        aStringArray1789[12] = "nnn";
        aStringArray1789[13] = "nnn";
        aStringArray1789[14] = ".,G";
        aStringArray1789[15] = "13";
        aStringArray1789[16] = "75";
        aStringArray1789[17] = ".,G";
        aStringArray1789[18] = "13";
        aStringArray1789[19] = "75";
        aStringArray1789[20] = "46";
        aStringArray1789[21] = "ttt";
        aStringArray1789[22] = "bb";
        aStringArray1789[23] = "dd";
        aStringArray1789[24] = "pp";
        aStringArray1790 = new String[2];
        aStringArray1790[0] = "He\'ll";
        aStringArray1790[1] = "he\'ll";
    }

    private static char[] method1919(String var0) {
        char[] var10000 = var0.toCharArray();
        char[] var10001 = var10000;

        while (true) {
            int var10002 = var10001.length;
            var10001 = var10000;
            int var4 = var10002;
            if (var10002 >= 2) {
                break;
            }

            char[] var1 = var10001;
            int var2 = var4;
            var10000 = var1;
            char[] var10003 = var1;
            var10002 = var2;
            var10001 = var10003;
            if (var10002 != 0) {
                var10001 = var10000;
                boolean var3 = false;
                var10003[0] = (char) (var10003[0] ^ 60);
                break;
            }
        }

        return var10001;
    }

    private static String method1920(char[] var0) {
        int var10000 = var0.length;
        int var1 = 0;
        char[] var10001 = var0;
        if (var10000 > 1) {
            var10001 = var0;
            if (var10000 <= var1) {
                return (new String(var0)).intern();
            }
        }

        do {
            char[] var10002 = var10001;
            int var10003 = var1;

            while (true) {
                char var10004 = var10002[var10003];
                byte var10005;
                switch (var1 % 5) {
                    case 0:
                        var10005 = 91;
                        break;
                    case 1:
                        var10005 = 89;
                        break;
                    case 2:
                        var10005 = 50;
                        break;
                    case 3:
                        var10005 = 11;
                        break;
                    default:
                        var10005 = 60;
                }

                var10002[var10003] = (char) (var10004 ^ var10005);
                ++var1;
                if (var10000 != 0) {
                    break;
                }

                var10003 = var10000;
                var10002 = var10001;
            }
        } while (var10000 > var1);

        return (new String(var10001)).intern();
    }
}
