package com.aapeli.singleclient;

class Class105 {

    private static final String aString1698 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^ ";
    private static final String aString1699 = "S]gL\\vm>xö-1Yo#OA4;<E`3+äu?_e§iZrV)FR{ktI:\"6Å½&8\tXU 0^2!dW%J,q5pM=å7(c9Q@PzDG.Hj£C|*n~lb$Öh´wT[ya¤\'Ä}NKfB/s";
    private static final int anInt1700 = aString1698.length();
    private Class106 aClass106_1701 = new Class106();
    private int anInt1702 = 17;
    private boolean aBoolean1703;


    protected Class105(String var1) {
        int var2 = var1.length();

        for (int var4 = 0; var4 < var2; ++var4) {
            char var3 = var1.charAt(var4);
            this.anInt1702 += var3 * (var4 % 2 == 0 ? 1 : -1);
        }

        this.aBoolean1703 = false;
    }

    protected void method1850() {
        this.aBoolean1703 = true;
    }

    protected String method1851(String var1) {
        if (!this.aBoolean1703) {
            return var1;
        } else {
            var1 = this.aClass106_1701.method1854(var1);
            int var2 = (int) (Math.random() * (double) anInt1700);
            int var3 = var1.length();
            StringBuffer var5 = new StringBuffer(var3 + 1);
            var5.append(aString1699.charAt(var2));

            for (int var7 = 0; var7 < var3; ++var7) {
                char var6 = var1.charAt(var7);
                int var4 = aString1698.indexOf(var6);
                if (var4 >= 0) {
                    var4 = method1853(var4 + var2 - this.anInt1702 + var7);
                    var6 = aString1699.charAt(var4);
                }

                var5.append(var6);
            }

            return var5.toString();
        }
    }

    protected String method1852(String var1) {
        if (!this.aBoolean1703) {
            return var1;
        } else {
            int var2 = aString1699.indexOf(var1.charAt(0));
            int var3 = var1.length();
            StringBuffer var5 = new StringBuffer(var3 - 1);

            for (int var7 = 1; var7 < var3; ++var7) {
                char var6 = var1.charAt(var7);
                int var4 = aString1699.indexOf(var6);
                if (var4 >= 0) {
                    var4 = method1853(var4 - var2 + this.anInt1702 - var7 + 1);
                    var6 = aString1698.charAt(var4);
                }

                var5.append(var6);
            }

            return this.aClass106_1701.method1855(var5.toString());
        }
    }

    private static int method1853(int var0) {
        if (var0 >= anInt1700) {
            return var0 % anInt1700;
        } else if (var0 < 0) {
            int var1 = (-var0 - 1) / anInt1700 + 1;
            return var0 + var1 * anInt1700;
        } else {
            return var0;
        }
    }

}
