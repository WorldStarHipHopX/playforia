package com.aapeli.multiuser;


public class ChallengeFloodProtection {

    private static final int[] anIntArray1655 = new int[]{1500, 4750, 14500, 30000};
    private static final int anInt1656 = anIntArray1655.length;
    private String[] aStringArray1657;
    private long[] aLongArray1658;


    public ChallengeFloodProtection() {
        this.aStringArray1657 = new String[anInt1656];
        this.aLongArray1658 = new long[anInt1656];

        for (int var1 = 0; var1 < anInt1656; ++var1) {
            this.aStringArray1657[var1] = null;
            this.aLongArray1658[var1] = 0L;
        }

    }

    public boolean isOkToChallenge(String var1) {
        long var2 = System.currentTimeMillis();
        synchronized (this) {
            int var5;
            for (var5 = 0; var5 < anInt1656; ++var5) {
                if (this.aStringArray1657[var5] != null && this.aStringArray1657[var5].equals(var1) && var2 < this.aLongArray1658[var5] + (long) anIntArray1655[var5]) {
                    return false;
                }
            }

            for (var5 = anInt1656 - 1; var5 >= 1; --var5) {
                this.aStringArray1657[var5] = this.aStringArray1657[var5 - 1];
                this.aLongArray1658[var5] = this.aLongArray1658[var5 - 1];
            }

            this.aStringArray1657[0] = var1;
            this.aLongArray1658[0] = var2;
            return true;
        }
    }

}
