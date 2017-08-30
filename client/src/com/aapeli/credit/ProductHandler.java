package com.aapeli.credit;

import com.aapeli.credit.Product;
import com.aapeli.tools.Tools;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

public class ProductHandler implements Runnable {

    private Hashtable aHashtable1653 = new Hashtable();
    private static final String[] aStringArray1654 = new String[2];


    public ProductHandler() {
        this.method1812();
    }

    public ProductHandler(String var1) {
        StringTokenizer var2 = new StringTokenizer(var1, "^");
        int var3 = Integer.parseInt(var2.nextToken());
        if (var3 != 2 && var3 != 3) {
            System.out.println("ProductHandler: Unknown version of productdata!");
        } else {
            int var4 = Integer.parseInt(var2.nextToken());

            for (int var6 = 0; var6 < var4; ++var6) {
                Product var5;
                if (var3 == 2) {
                    var5 = new Product(Tools.changeFromSaveable(var2.nextToken()), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()));
                } else {
                    var5 = new Product(Tools.changeFromSaveable(var2.nextToken()), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()));
                }

                this.addProduct(var5);
            }

            this.method1812();
        }
    }

    public void run() {
        while (true) {
            Tools.sleep(5000L);
            Enumeration var2 = this.aHashtable1653.elements();

            while (var2.hasMoreElements()) {
                Product var1 = (Product) ((Product) var2.nextElement());
                if (var1 != null) {
                    var1.method1811();
                }
            }
        }
    }

    public void addProduct(Product var1) {
        this.aHashtable1653.put(var1.getProductName().toLowerCase(), var1);
    }

    public Product getProduct(String var1) {
        return var1 == null ? null : (Product) ((Product) this.aHashtable1653.get(var1.toLowerCase()));
    }

    public Product[] getMultipleProducts(String var1) {
        String var2 = var1.toLowerCase();
        Product var3 = (Product) ((Product) this.aHashtable1653.get(var2));
        if (var3 == null) {
            return null;
        } else {
            Vector var4 = new Vector();
            var4.addElement(var3);
            var2 = var2 + "__";
            Enumeration var5 = this.aHashtable1653.elements();

            while (var5.hasMoreElements()) {
                var3 = (Product) ((Product) var5.nextElement());
                if (var3 != null && var3.getProductName().toLowerCase().startsWith(var2)) {
                    var4.addElement(var3);
                }
            }

            int var6 = var4.size();
            Product[] var7 = new Product[var6];

            for (int var8 = 0; var8 < var6; ++var8) {
                var7[var8] = (Product) ((Product) var4.elementAt(var8));
            }

            return var7;
        }
    }

    public boolean userHaveAnyProduct(String var1) {
        String var2 = var1.toLowerCase();
        Enumeration var4 = this.aHashtable1653.elements();

        Product var3;
        do {
            if (!var4.hasMoreElements()) {
                return false;
            }

            var3 = (Product) ((Product) var4.nextElement());
        } while (var3 == null || !var3.getProductName().toLowerCase().startsWith(var2) || !var3.userHaveProduct());

        return true;
    }

    private void method1812() {
        Thread var1 = new Thread(this);
        var1.setDaemon(true);
        var1.start();
    }

    static {
        aStringArray1654[0] = "ProductHandler: Unknown version of productdata!";
        aStringArray1654[1] = "__";
    }
}
