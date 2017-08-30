package com.playray.tools;

import com.playray.tools.Tools;

public class DelayTimer {

    private double aDouble2216;
    private int anInt2217;
    private int anInt2218;
    private long aLong2219;
    private long aLong2220;
    private long aLong2221;
    private long aLong2222;
    private boolean aBoolean2223;


    public DelayTimer(int var1) {
        this(var1, false);
    }

    public DelayTimer(int var1, boolean var2) {
        this.aDouble2216 = 1000.0D / (double) var1;
        this.anInt2217 = this.anInt2218 = 0;
        this.aLong2219 = this.aLong2222 = this.aLong2221 = 0L;
        this.aLong2220 = System.currentTimeMillis();
        this.aBoolean2223 = var2;
    }

    public synchronized boolean doDelay() {
        if (this.aLong2221 > 0L) {
            return false;
        } else {
            ++this.anInt2217;
            int var1 = (int) ((double) (this.aLong2220 + this.aLong2222) + (double) this.anInt2217 * this.aDouble2216 - (double) System.currentTimeMillis());
            if ((double) var1 < (double) (this.aLong2219 / (long) this.anInt2217) - this.aDouble2216 * 5.0D) {
                if (this.aBoolean2223) {
                    System.out.println("DelayTimer.doDelay(): Delay skipped (delay=" + var1 + ")");
                }

                this.aLong2222 -= (long) var1;
                var1 = 0;
            }

            double var2 = this.aDouble2216 * 10.0D;
            if ((double) var1 > var2) {
                if (this.aBoolean2223) {
                    System.out.println("DelayTimer.doDelay(): Delay limited (delay=" + var1 + ")");
                }

                this.aLong2222 -= (long) ((double) var1 - var2);
                var1 = (int) (var2 + 0.5D);
            }

            this.anInt2218 = var1;
            this.aLong2219 += (long) var1;
            if (var1 > 0) {
                Tools.sleep((long) var1);
                return true;
            } else {
                return false;
            }
        }
    }

    public synchronized void startPause() {
        if (this.aBoolean2223) {
            System.out.println("DelayTimer.startPause()");
        }

        if (this.aLong2221 <= 0L) {
            this.aLong2221 = System.currentTimeMillis();
        }
    }

    public synchronized void endPause() {
        if (this.aBoolean2223) {
            System.out.println("DelayTimer.endPause()");
        }

        if (this.aLong2221 > 0L) {
            this.aLong2222 += System.currentTimeMillis() - this.aLong2221;
            this.aLong2221 = 0L;
        }
    }

    public int getLastDelay() {
        return this.anInt2217 == 0 ? 0 : this.anInt2218;
    }

    public int getAverageDelay() {
        return this.anInt2217 == 0 ? 0 : (int) (this.aLong2219 / (long) this.anInt2217);
    }
}
