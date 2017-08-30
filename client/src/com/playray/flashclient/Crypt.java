package com.playray.flashclient;

import com.playray.flashclient.Exception_Sub1;

public class Crypt {

    private int anInt2101;
    private int anInt2102;
    private int anInt2103;
    private Object anObject2104;
    private Object anObject2105;
    private static final String[] aStringArray2106 = new String[3];


    public Crypt(int var1) {
        this.anInt2101 = var1;
        this.anInt2102 = 1;
        this.anInt2103 = 0;
        this.anObject2104 = new Object();
        this.anObject2105 = new Object();
    }

    public String encrypt(String var1) {
        Object var3 = this.anObject2104;
        int var2;
        synchronized (this.anObject2104) {
            var2 = this.anInt2102++;
        }

        char[] var7 = var1.toCharArray();
        int var4 = var7.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            var7[var5] = this.method2157(var7[var5], var2, var5, 1);
        }

        StringBuffer var8 = new StringBuffer(10 + var4);
        var8.append(var2);
        var8.append(',');
        var8.append(var7);
        return var8.toString();
    }

    public String decrypt(String var1) throws Exception_Sub1 {
        int var2 = var1.indexOf(44);
        if (var2 == -1) {
            throw new Exception_Sub1("No ID separator character");
        } else {
            int var3;
            try {
                var3 = Integer.parseInt(var1.substring(0, var2));
            } catch (NumberFormatException var7) {
                throw new Exception_Sub1("Invalid ID number format");
            }

            Object var4 = this.anObject2105;
            synchronized (this.anObject2105) {
                if (var3 <= this.anInt2103) {
                    throw new Exception_Sub1("Received string have duplicate or old ID");
                }

                this.anInt2103 = var3;
            }

            char[] var9 = var1.substring(var2 + 1).toCharArray();
            int var5 = var9.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                var9[var6] = this.method2157(var9[var6], var3, var6, -1);
            }

            return new String(var9);
        }
    }

    private char method2157(char var1, int var2, int var3, int var4) {
        int var5 = this.method2158(var2, var3);
        int var6;
        if (var1 < 32) {
            var6 = var1;
        } else if (var1 < 127) {
            var5 = (var5 % 252 - 125) * var4;
            var6 = method2159(var1, var5, 32, 127);
        } else {
            var5 = (var5 % 1124 - 500) * var4;
            var6 = method2159(var1, var5, 127, 65536);
        }

        return (char) var6;
    }

    private int method2158(int var1, int var2) {
        short var3 = 314;
        int var4 = var3 + this.anInt2101 / 1000;
        var4 += this.anInt2101 % 1000 * 3;
        var4 -= this.anInt2101 % 10 * 7;
        var1 %= 1000000;
        var4 += var1 / 100;
        var4 -= var1 % 100 * 5;
        var4 += var1 % 10 * 11;
        var4 += var1 % 5 == 0 ? -159 : 265;
        var2 %= 1000;
        var4 += var2 / 10 * 13;
        var4 -= var2 % 10;
        var4 += var2 % 3 == 0 ? 17 : (var2 % 2 == 0 ? -19 : 23);
        return var4;
    }

    private static int method2159(char var0, int var1, int var2, int var3) {
        int var4 = var0 - var2;
        var3 -= var2;
        var4 += var1;
        if (var4 < 0) {
            var4 = -var4;
            var4 %= var3;
            var4 = var3 - var4;
        }

        var4 %= var3;
        return var2 + var4;
    }

    static {
        aStringArray2106[0] = "No ID separator character";
        aStringArray2106[1] = "Received string have duplicate or old ID";
        aStringArray2106[2] = "Invalid ID number format";
    }
}
