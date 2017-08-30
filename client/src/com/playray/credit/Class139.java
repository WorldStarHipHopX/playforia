package com.playray.credit;

import com.playray.credit.PurchaseFrame;

class Class139 {

    private long aLong2075;
    private int anInt2076;
    private final PurchaseFrame aPurchaseFrame2077;


    public Class139(PurchaseFrame var1, int var2) {
        this.aPurchaseFrame2077 = var1;
        this.method2139(var2);
    }

    protected synchronized void method2139(int var1) {
        if ((long) var1 % 2L == 0L) {
            this.aLong2075 = 2558601322649768L - (long) var1 * 23L;
        } else {
            this.aLong2075 = -194632254967778L + (long) var1 * 11L;
        }

        this.anInt2076 = var1;
    }

    protected synchronized int method2140() {
        return this.aLong2075 > 0L ? (int) ((2558601322649768L - this.aLong2075) / 23L) : (int) ((this.aLong2075 + 194632254967778L) / 11L);
    }

    protected int method2141() {
        return this.anInt2076;
    }
}
