package com.aapeli.multiuser;


public class FloodProtection {

    private static final int[] anIntArray1659 = new int[]{200, 1500, 4500, 10000, 18000};
    private static final int anInt1660 = anIntArray1659.length;
    private double aDouble1661;
    private String[] aStringArray1662;
    private long[] aLongArray1663;


    public FloodProtection() {
        this(1.0D);
    }

    public FloodProtection(double var1) {
        this.aDouble1661 = var1;
        this.aStringArray1662 = new String[anInt1660];
        this.aLongArray1663 = new long[anInt1660];

        for (int var3 = 0; var3 < anInt1660; ++var3) {
            this.aStringArray1662[var3] = null;
            this.aLongArray1663[var3] = 0L;
        }

    }

    public boolean isOkToSay(String var1) {
        long var2 = System.currentTimeMillis();
        var1 = this.method1813(var1);
        synchronized (this) {
            int var7;
            for (var7 = 0; var7 < anInt1660; ++var7) {
                double var4 = (double) anIntArray1659[var7] * this.aDouble1661;
                if (var1 != null && this.aStringArray1662[var7] != null && (this.aStringArray1662[var7].startsWith(var1) || var1.startsWith(this.aStringArray1662[var7]))) {
                    var4 *= 2.0D;
                }

                if ((double) var2 < (double) this.aLongArray1663[var7] + var4) {
                    return false;
                }
            }

            for (var7 = anInt1660 - 1; var7 >= 1; --var7) {
                this.aStringArray1662[var7] = this.aStringArray1662[var7 - 1];
                this.aLongArray1663[var7] = this.aLongArray1663[var7 - 1];
            }

            this.aStringArray1662[0] = var1;
            this.aLongArray1663[0] = var2;
            return true;
        }
    }

    private String method1813(String var1) {
        var1 = var1.trim().toLowerCase();
        int var2 = var1.length();
        int var3 = 0;
        StringBuffer var4 = new StringBuffer(var2);

        for (int var6 = 0; var6 < var2; ++var6) {
            char var5 = var1.charAt(var6);
            if (var5 >= 97 && var5 <= 122) {
                var4.append(var5);
                ++var3;
            }
        }

        if (var3 < 3) {
            return null;
        } else {
            return var4.toString();
        }
    }

}
