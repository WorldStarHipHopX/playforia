package com.playray.multiuser;


public class FloodProtection {

    private static final int[] anIntArray2162 = new int[]{200, 1500, 4500, 10000, 18000};
    private static final int anInt2163 = anIntArray2162.length;
    private double aDouble2164;
    private String[] aStringArray2165;
    private long[] aLongArray2166;


    public FloodProtection() {
        this(1.0D);
    }

    public FloodProtection(double var1) {
        this.aDouble2164 = var1;
        this.aStringArray2165 = new String[anInt2163];
        this.aLongArray2166 = new long[anInt2163];

        for (int var3 = 0; var3 < anInt2163; ++var3) {
            this.aStringArray2165[var3] = null;
            this.aLongArray2166[var3] = 0L;
        }

    }

    public boolean isOkToSay(String var1) {
        long var2 = System.currentTimeMillis();
        var1 = this.method2205(var1);
        synchronized (this) {
            int var7;
            for (var7 = 0; var7 < anInt2163; ++var7) {
                double var4 = (double) anIntArray2162[var7] * this.aDouble2164;
                if (var1 != null && this.aStringArray2165[var7] != null && (this.aStringArray2165[var7].startsWith(var1) || var1.startsWith(this.aStringArray2165[var7]))) {
                    var4 *= 2.0D;
                }

                if ((double) var2 < (double) this.aLongArray2166[var7] + var4) {
                    return false;
                }
            }

            for (var7 = anInt2163 - 1; var7 >= 1; --var7) {
                this.aStringArray2165[var7] = this.aStringArray2165[var7 - 1];
                this.aLongArray2166[var7] = this.aLongArray2166[var7 - 1];
            }

            this.aStringArray2165[0] = var1;
            this.aLongArray2166[0] = var2;
            return true;
        }
    }

    private String method2205(String var1) {
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
