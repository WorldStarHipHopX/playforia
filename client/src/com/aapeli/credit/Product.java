package com.aapeli.credit;

import com.aapeli.credit.Class101;
import com.aapeli.credit.Class102;

public final class Product {

    private String aString1644;
    private String aString1645;
    private Class101 aClass101_1646;
    private Class101 aClass101_1647;
    private Class102 aClass102_1648;
    private Class102 aClass102_1649;
    private Class102 aClass102_1650;
    private long aLong1651;
    public static int anInt1652;


    public Product(String var1, String var2, int var3, int var4, int var5, int var6) {
        this.aString1644 = var1;
        this.aString1645 = var2;
        this.aClass101_1646 = new Class101(this, var3);
        this.aClass101_1647 = new Class101(this, var4);
        this.aClass102_1648 = new Class102(this, System.currentTimeMillis());
        this.aClass102_1649 = new Class102(this, this.aClass102_1648.method1806() + (long) var6 * 1000L);
        this.aClass102_1650 = new Class102(this, 0L);
        this.aLong1651 = (long) this.aClass101_1646.method1804() * this.aClass102_1648.method1807();
    }

    public Product(String var1, int var2, int var3, int var4, int var5) {
        this(var1, (String) null, var2, var3, var4, var5);
    }

    public Product(String var1, int var2, int var3, int var4) {
        this.aString1644 = var1;
        this.aClass101_1646 = new Class101(this, var2);
        this.aClass101_1647 = new Class101(this, var3);
        this.aClass102_1648 = new Class102(this, System.currentTimeMillis());
        this.aClass102_1649 = new Class102(this, this.aClass102_1648.method1806() + (long) var4 * 1000L);
        this.aClass102_1650 = new Class102(this, 0L);
        this.aLong1651 = (long) this.aClass101_1646.method1804() * this.aClass102_1648.method1807();
    }

    public String getProductName() {
        return this.aString1644;
    }

    public String getProductDescription() {
        return this.aString1645;
    }

    public int getProductPrice() {
        return this.aClass101_1646.method1803();
    }

    public int getProductDuration() {
        return this.aClass101_1647.method1803();
    }

    public int getType() {
        return 3;
    }

    public boolean userHaveProduct() {
        this.method1811();
        if (this.aClass102_1650.method1806() > 300000L) {
            this.aClass102_1649.method1805(0L);
        }

        return this.aClass102_1648.method1806() < this.aClass102_1649.method1806();
    }

    public void userBoughtProduct() {
        this.aClass102_1648.method1805(System.currentTimeMillis());
        this.aClass102_1649.method1805(this.aClass102_1648.method1806() + (long) this.aClass101_1647.method1803() * 60L * 1000L);
    }

    protected void method1811() {
        long var1 = System.currentTimeMillis();
        long var3 = this.aClass102_1648.method1806() - var1;
        if (var3 > 0L) {
            this.aClass102_1650.method1805(this.aClass102_1650.method1806() + var3);
        }

        this.aClass102_1648.method1805(var1);
    }
}
