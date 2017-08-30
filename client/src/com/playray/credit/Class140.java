package com.playray.credit;

import com.playray.credit.PurchaseFrame;
import com.playray.credit.SPanel_Sub43;

class Class140 implements Runnable {

    private PurchaseFrame aPurchaseFrame2078;
    private SPanel_Sub43 aSPanel_Sub43_2079;
    private int anInt2080;
    private final SPanel_Sub43 aSPanel_Sub43_2081;


    protected Class140(SPanel_Sub43 var1, PurchaseFrame var2, SPanel_Sub43 var3, int var4) {
        this.aSPanel_Sub43_2081 = var1;
        this.aPurchaseFrame2078 = var2;
        this.aSPanel_Sub43_2079 = var3;
        this.anInt2080 = var4;
        Thread var5 = new Thread(this);
        var5.start();
    }

    public void run() {
        if (this.anInt2080 == 1) {
            this.aSPanel_Sub43_2079.method2932();
        } else if (this.anInt2080 == 2) {
            this.aSPanel_Sub43_2079.method2933();
        } else if (this.anInt2080 == 3) {
            this.aSPanel_Sub43_2079.method2934();
        } else if (this.anInt2080 == 4) {
            this.aPurchaseFrame2078.method2351();
        }

    }
}
