package com.aapeli.credit;

import com.aapeli.credit.Product;

class Class101 {

    private long aLong1633;
    private int anInt1634;
    private final Product aProduct1635;


    protected Class101(Product var1, int var2) {
        this.aProduct1635 = var1;
        this.method1802(var2);
    }

    protected synchronized void method1802(int var1) {
        if (var1 % 2 == 0) {
            this.aLong1633 = 5169408336892311L - (long) var1 * 11L;
        } else {
            this.aLong1633 = -316683490563199L + (long) var1 * 7L;
        }

        this.anInt1634 = var1;
    }

    protected synchronized int method1803() {
        return this.aLong1633 > 0L ? (int) ((5169408336892311L - this.aLong1633) / 11L) : (int) ((this.aLong1633 + 316683490563199L) / 7L);
    }

    protected int method1804() {
        return this.anInt1634;
    }
}
