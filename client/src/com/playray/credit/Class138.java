package com.playray.credit;

import com.playray.credit.Class137;
import com.playray.credit.Product;

class Class138 {

    private Class137 aClass137_2070;
    private Class137 aClass137_2071;
    private Class137 aClass137_2072;
    private long aLong2073;
    private final Product aProduct2074;


    protected Class138(Product var1, long var2) {
        this.aProduct2074 = var1;
        this.aClass137_2070 = new Class137(var1, 0);
        this.aClass137_2071 = new Class137(var1, 0);
        this.aClass137_2072 = new Class137(var1, 0);
        this.method2136(var2);
    }

    protected synchronized void method2136(long var1) {
        long var3 = var1 % 947213L;
        long var5 = var1 / 947213L % 1086521L;
        long var7 = var1 / 947213L / 1086521L;
        this.aClass137_2070.method2133((int) var3);
        this.aClass137_2071.method2133((int) var5);
        this.aClass137_2072.method2133((int) var7);
        this.aLong2073 = var1;
    }

    protected synchronized long method2137() {
        long var1 = (long) this.aClass137_2070.method2134();
        long var3 = (long) this.aClass137_2071.method2134();
        long var5 = (long) this.aClass137_2072.method2134();
        long var7 = var5 * 947213L * 1086521L + var3 * 947213L + var1;
        return var7;
    }

    protected long method2138() {
        return this.aLong2073;
    }
}
