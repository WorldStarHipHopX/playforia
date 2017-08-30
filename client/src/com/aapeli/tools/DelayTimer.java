package com.aapeli.tools;

public class DelayTimer {

    private double aDouble1713;
    private int delayCount;
    private int anInt1715;
    private long aLong1716;
    private long aLong1717;
    private long aLong1718;
    private long aLong1719;
    private boolean debug;


    public DelayTimer(int var1) {
        this(var1, false);
    }

    public DelayTimer(int var1, boolean var2) {
        this.aDouble1713 = 1000.0D / (double) var1;
        this.delayCount = this.anInt1715 = 0;
        this.aLong1716 = this.aLong1719 = this.aLong1718 = 0L;
        this.aLong1717 = System.currentTimeMillis();
        this.debug = var2;
    }

    public synchronized boolean doDelay() {
        if (this.aLong1718 > 0L) {
            return false;
        } else {
            ++this.delayCount;
            int delay = (int) ((double) (this.aLong1717 + this.aLong1719) + (double) this.delayCount * this.aDouble1713 - (double) System.currentTimeMillis());
            if ((double) delay < (double) (this.aLong1716 / (long) this.delayCount) - this.aDouble1713 * 5.0D) {
                if (this.debug) {
                    System.out.println("DelayTimer.doDelay(): Delay skipped (delay=" + delay + ")");
                }

                this.aLong1719 -= (long) delay;
                delay = 0;
            }

            double var2 = this.aDouble1713 * 10.0D;
            if ((double) delay > var2) {
                if (this.debug) {
                    System.out.println("DelayTimer.doDelay(): Delay limited (delay=" + delay + ")");
                }

                this.aLong1719 -= (long) ((double) delay - var2);
                delay = (int) (var2 + 0.5D);
            }

            this.anInt1715 = delay;
            this.aLong1716 += (long) delay;
            if (delay > 0) {
                Tools.sleep((long) delay);
                return true;
            } else {
                return false;
            }
        }
    }

    public synchronized void startPause() {
        if (this.debug) {
            System.out.println("DelayTimer.startPause()");
        }

        if (this.aLong1718 <= 0L) {
            this.aLong1718 = System.currentTimeMillis();
        }
    }

    public synchronized void endPause() {
        if (this.debug) {
            System.out.println("DelayTimer.endPause()");
        }

        if (this.aLong1718 > 0L) {
            this.aLong1719 += System.currentTimeMillis() - this.aLong1718;
            this.aLong1718 = 0L;
        }
    }

    public int getLastDelay() {
        return this.delayCount == 0 ? 0 : this.anInt1715;
    }

    public int getAverageDelay() {
        return this.delayCount == 0 ? 0 : (int) (this.aLong1716 / (long) this.delayCount);
    }
}
