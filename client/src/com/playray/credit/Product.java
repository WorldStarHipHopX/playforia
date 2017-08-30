package com.playray.credit;

import com.playray.credit.Class137;
import com.playray.credit.Class138;

public final class Product {

    private String aString2082;
    private Class137 aClass137_2083;
    private Class137 aClass137_2084;
    private Class138 aClass138_2085;
    private Class138 aClass138_2086;
    private long aLong2087;
    public static boolean aBoolean2088;


    public Product(String var1, int var2, int var3, int var4, int var5) {
        this.aString2082 = var1;
        this.aClass137_2083 = new Class137(this, var2);
        this.aClass137_2084 = new Class137(this, var3);
        this.aClass138_2085 = new Class138(this, System.currentTimeMillis());
        this.aClass138_2086 = new Class138(this, this.aClass138_2085.method2137() + (long) var5 * 1000L);
        this.aLong2087 = (long) this.aClass137_2083.method2135() * this.aClass138_2085.method2138();
    }

    public Product(String var1, int var2, int var3, int var4) {
        this.aString2082 = var1;
        this.aClass137_2083 = new Class137(this, var2);
        this.aClass137_2084 = new Class137(this, var3);
        this.aClass138_2085 = new Class138(this, System.currentTimeMillis());
        this.aClass138_2086 = new Class138(this, this.aClass138_2085.method2137() + (long) var4 * 1000L);
        this.aLong2087 = (long) this.aClass137_2083.method2135() * this.aClass138_2085.method2138();
    }

    public String getProductName() {
        return this.aString2082;
    }

    public int getProductPrice() {
        return this.aClass137_2083.method2134();
    }

    public int getProductDuration() {
        return this.aClass137_2084.method2134();
    }

    public int getType() {
        return 3;
    }

    public boolean userHaveProduct() {
        this.method2142();
        return this.aClass138_2085.method2137() < this.aClass138_2086.method2137();
    }

    public synchronized void userBoughtProduct() {
        this.aClass138_2085.method2136(System.currentTimeMillis());
        this.aClass138_2086.method2136(this.aClass138_2085.method2137() + (long) this.aClass137_2084.method2134() * 60L * 1000L);
    }

    protected synchronized void method2142() {
        long var1 = System.currentTimeMillis();
        if (var1 < this.aClass138_2085.method2137()) {
            long var3 = this.aClass138_2085.method2137() - var1;
            this.aClass138_2086.method2136(this.aClass138_2086.method2137() - var3);
        }

        this.aClass138_2085.method2136(var1);
    }
}
