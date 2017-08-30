package adraw.game;


class GameFloodProtection {

    private static final int[] delays = new int[]{150, 1000, 3000, 6000};
    private static final int delaysLen = delays.length;
    private long[] aLongArray931;


    protected GameFloodProtection() {
        this.aLongArray931 = new long[delaysLen];

        for (int var1 = 0; var1 < delaysLen; ++var1) {
            this.aLongArray931[var1] = 0L;
        }

    }

    protected boolean canSend() {
        long time = System.currentTimeMillis();
        synchronized (this) {
            for (int var4 = 0; var4 < delaysLen; ++var4) {
                if (time < this.aLongArray931[var4] + (long) delays[var4]) {
                    return false;
                }
            }

            for (int var6 = delaysLen - 1; var6 >= 1; --var6) {
                this.aLongArray931[var6] = this.aLongArray931[var6 - 1];
            }

            this.aLongArray931[0] = time;
            return true;
        }
    }

}
