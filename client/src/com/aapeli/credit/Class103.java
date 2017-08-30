package com.aapeli.credit;

import com.aapeli.credit.PurchaseFrame;

class Class103 {

    private long aLong1641;
    private int anInt1642;
    private final PurchaseFrame aPurchaseFrame1643;


    public Class103(PurchaseFrame var1, int var2) {
        this.aPurchaseFrame1643 = var1;
        this.method1808(var2);
    }

    protected synchronized void method1808(int var1) {
        if ((long) var1 % 2L == 0L) {
            this.aLong1641 = 2558601322649768L - (long) var1 * 23L;
        } else {
            this.aLong1641 = -194632254967778L + (long) var1 * 11L;
        }

        this.anInt1642 = var1;
    }

    protected synchronized int method1809() {
        return this.aLong1641 > 0L ? (int) ((2558601322649768L - this.aLong1641) / 23L) : (int) ((this.aLong1641 + 194632254967778L) / 11L);
    }

    protected int method1810() {
        return this.anInt1642;
    }
}
