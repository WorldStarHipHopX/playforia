package com.playray.credit;

import com.playray.credit.Product;

class Class137 {

    private long aLong2067;
    private int anInt2068;
    private final Product aProduct2069;


    protected Class137(Product var1, int var2) {
        this.aProduct2069 = var1;
        this.method2133(var2);
    }

    protected synchronized void method2133(int var1) {
        if ((long) var1 % 2L == 0L) {
            this.aLong2067 = 5169408336892311L - (long) var1 * 11L;
        } else {
            this.aLong2067 = -316683490563199L + (long) var1 * 7L;
        }

        this.anInt2068 = var1;
    }

    protected synchronized int method2134() {
        return this.aLong2067 > 0L ? (int) ((5169408336892311L - this.aLong2067) / 11L) : (int) ((this.aLong2067 + 316683490563199L) / 7L);
    }

    protected int method2135() {
        return this.anInt2068;
    }
}
