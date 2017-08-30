package com.playray.multiuser;


public class ChallengeFloodProtection {

    private static final int[] anIntArray2158 = new int[]{1500, 4750, 14500, 30000};
    private static final int anInt2159 = anIntArray2158.length;
    private String[] aStringArray2160;
    private long[] aLongArray2161;


    public ChallengeFloodProtection() {
        this.aStringArray2160 = new String[anInt2159];
        this.aLongArray2161 = new long[anInt2159];

        for (int var1 = 0; var1 < anInt2159; ++var1) {
            this.aStringArray2160[var1] = null;
            this.aLongArray2161[var1] = 0L;
        }

    }

    public boolean isOkToChallenge(String var1) {
        long var2 = System.currentTimeMillis();
        synchronized (this) {
            int var5;
            for (var5 = 0; var5 < anInt2159; ++var5) {
                if (this.aStringArray2160[var5] != null && this.aStringArray2160[var5].equals(var1) && var2 < this.aLongArray2161[var5] + (long) anIntArray2158[var5]) {
                    return false;
                }
            }

            for (var5 = anInt2159 - 1; var5 >= 1; --var5) {
                this.aStringArray2160[var5] = this.aStringArray2160[var5 - 1];
                this.aLongArray2161[var5] = this.aLongArray2161[var5 - 1];
            }

            this.aStringArray2160[0] = var1;
            this.aLongArray2161[0] = var2;
            return true;
        }
    }

}
