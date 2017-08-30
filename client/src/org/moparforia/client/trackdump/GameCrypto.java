package org.moparforia.client.trackdump;


class GameCrypto {

    private String[] aStringArray1631;


    protected GameCrypto(String[] var1) {
        this.aStringArray1631 = this.method1796(var1);
    }

    protected int method1793() {
        int var1 = this.aStringArray1631.length;
        int var2 = var1 % 19;

        for (int var4 = 0; var4 < var1; ++var4) {
            int var3 = this.aStringArray1631[var4].length();

            for (int var5 = 0; var5 < var3; ++var5) {
                var2 = (var2 + this.aStringArray1631[var4].charAt(var5) * (var4 + 1) * (var5 + 2)) % 19;
            }
        }

        return var2;
    }

    protected String encrypt(String var1) {
        char var2 = this.method1797(var1);
        if (var2 == 0) {
            return " " + var1;
        } else {
            int var3 = this.aStringArray1631.length;

            for (int var5 = 0; var5 < var3; ++var5) {
                int var4 = 0;

                while ((var4 = var1.indexOf(this.aStringArray1631[var5], var4)) >= 0) {
                    if (!this.method1798(var1, var4, var2)) {
                        var1 = var1.substring(0, var4) + var2 + (char) (' ' + var5) + var1.substring(var4 + this.aStringArray1631[var5].length());
                        var4 += 2;
                    } else {
                        ++var4;
                    }
                }
            }

            var1 = var2 + var1;
            return var1;
        }
    }

    protected String decrypt(String var1) {
        char var2 = var1.charAt(0);
        var1 = var1.substring(1);
        if (var2 == 0) {
            return var1;
        } else {
            int var3;
            while ((var3 = var1.indexOf(var2)) >= 0) {
                var1 = var1.substring(0, var3) + this.aStringArray1631[var1.charAt(var3 + 1) - ' '] + var1.substring(var3 + 2);
            }

            return var1;
        }
    }

    private String[] method1796(String[] var1) {
        int var2 = var1.length;
        int var3 = 0;
        int[] var4 = new int[var2];

        for (int var5 = 0; var5 < var2; ++var5) {
            var4[var5] = var1[var5].length();
            if (var4[var5] > var3) {
                var3 = var4[var5];
            }
        }

        String[] var10 = new String[var2];
        int var6 = 0;

        for (int var8 = 0; var8 < var2; ++var8) {
            int var7 = 0;

            for (int var9 = 0; var9 < var2; ++var9) {
                if (var4[var9] == var3) {
                    var10[var6] = var1[var9];
                    ++var6;
                } else if (var4[var9] < var3 && var4[var9] > var7) {
                    var7 = var4[var9];
                }
            }

            var3 = var7;
        }

        return var10;
    }

    private char method1797(String var1) {
        for (char var2 = 1; var2 < 32; ++var2) {
            if (var1.indexOf(var2) == -1) {
                return var2;
            }
        }

        return '\u0000';
    }

    private boolean method1798(String var1, int var2, char var3) {
        return var2 == 0 ? false : var1.charAt(var2 - 1) == var3;
    }
}
