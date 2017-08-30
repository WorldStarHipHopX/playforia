package com.aapeli.credit;

import com.aapeli.credit.Class101;
import com.aapeli.credit.Product;

class Class102 {

    private Class101 aClass101_1636;
    private Class101 aClass101_1637;
    private Class101 aClass101_1638;
    private long aLong1639;
    private final Product aProduct1640;


    protected Class102(Product var1, long var2) {
        this.aProduct1640 = var1;
        this.aClass101_1636 = new Class101(var1, 0);
        this.aClass101_1637 = new Class101(var1, 0);
        this.aClass101_1638 = new Class101(var1, 0);
        this.method1805(var2);
    }

    protected synchronized void method1805(long var1) {
        long var3 = var1 % 947213L;
        long var5 = var1 / 947213L % 1086521L;
        long var7 = var1 / 947213L / 1086521L;
        this.aClass101_1636.method1802((int) var3);
        this.aClass101_1637.method1802((int) var5);
        this.aClass101_1638.method1802((int) var7);
        this.aLong1639 = var1;
    }

    protected synchronized long method1806() {
        long var1 = (long) this.aClass101_1636.method1803();
        long var3 = (long) this.aClass101_1637.method1803();
        long var5 = (long) this.aClass101_1638.method1803();
        long var7 = var5 * 947213L * 1086521L + var3 * 947213L + var1;
        return var7;
    }

    protected long method1807() {
        return this.aLong1639;
    }
}
