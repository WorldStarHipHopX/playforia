package com.playray.singleclient;

import com.playray.singleclient.Class148;

class Class147 {

    private static final String aString2201 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^ ";
    private static final String aString2202 = "S]gL\\vm>xö-1Yo#OA4;<E`3+äu?_e§iZrV)FR{ktI:\"6Å½&8\tXU 0^2!dW%J,q5pM=å7(c9Q@PzDG.Hj£C|*n~lb$Öh´wT[ya¤\'Ä}NKfB/s";
    private static final int anInt2203 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^ ".length();
    private Class148 aClass148_2204 = new Class148();
    private int anInt2205 = 17;
    private boolean aBoolean2206;


    protected Class147(String var1) {
        int var2 = var1.length();

        for (int var4 = 0; var4 < var2; ++var4) {
            char var3 = var1.charAt(var4);
            this.anInt2205 += var3 * (var4 % 2 == 0 ? 1 : -1);
        }

        this.aBoolean2206 = false;
    }

    protected void method2240() {
        this.aBoolean2206 = true;
    }

    protected String method2241(String var1) {
        if (!this.aBoolean2206) {
            return var1;
        } else {
            var1 = this.aClass148_2204.method2244(var1);
            int var2 = (int) (Math.random() * (double) anInt2203);
            int var3 = var1.length();
            StringBuffer var5 = new StringBuffer(var3 + 1);
            var5.append("S]gL\\vm>xö-1Yo#OA4;<E`3+äu?_e§iZrV)FR{ktI:\"6Å½&8\tXU 0^2!dW%J,q5pM=å7(c9Q@PzDG.Hj£C|*n~lb$Öh´wT[ya¤\'Ä}NKfB/s".charAt(var2));

            for (int var7 = 0; var7 < var3; ++var7) {
                char var6 = var1.charAt(var7);
                int var4 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^ ".indexOf(var6);
                if (var4 >= 0) {
                    var4 = method2243(var4 + var2 - this.anInt2205 + var7);
                    var6 = "S]gL\\vm>xö-1Yo#OA4;<E`3+äu?_e§iZrV)FR{ktI:\"6Å½&8\tXU 0^2!dW%J,q5pM=å7(c9Q@PzDG.Hj£C|*n~lb$Öh´wT[ya¤\'Ä}NKfB/s".charAt(var4);
                }

                var5.append(var6);
            }

            return var5.toString();
        }
    }

    protected String method2242(String var1) {
        if (!this.aBoolean2206) {
            return var1;
        } else {
            int var2 = "S]gL\\vm>xö-1Yo#OA4;<E`3+äu?_e§iZrV)FR{ktI:\"6Å½&8\tXU 0^2!dW%J,q5pM=å7(c9Q@PzDG.Hj£C|*n~lb$Öh´wT[ya¤\'Ä}NKfB/s".indexOf(var1.charAt(0));
            int var3 = var1.length();
            StringBuffer var5 = new StringBuffer(var3 - 1);

            for (int var7 = 1; var7 < var3; ++var7) {
                char var6 = var1.charAt(var7);
                int var4 = "S]gL\\vm>xö-1Yo#OA4;<E`3+äu?_e§iZrV)FR{ktI:\"6Å½&8\tXU 0^2!dW%J,q5pM=å7(c9Q@PzDG.Hj£C|*n~lb$Öh´wT[ya¤\'Ä}NKfB/s".indexOf(var6);
                if (var4 >= 0) {
                    var4 = method2243(var4 - var2 + this.anInt2205 - var7 + 1);
                    var6 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789§+\t\'<,.-½!\"#¤%&/()=?*>;:_@£${[]}\\|~`´^ ".charAt(var4);
                }

                var5.append(var6);
            }

            return this.aClass148_2204.method2245(var5.toString());
        }
    }

    private static int method2243(int var0) {
        if (var0 >= anInt2203) {
            return var0 % anInt2203;
        } else if (var0 < 0) {
            int var1 = (-var0 - 1) / anInt2203 + 1;
            return var0 + var1 * anInt2203;
        } else {
            return var0;
        }
    }

}
