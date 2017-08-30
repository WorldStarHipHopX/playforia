package com.aapeli.tools;

import com.aapeli.tools.Sortable;

import java.util.Vector;

public class Sort {

    public static Vector quickSort(Vector var0) {
        int var1 = var0.size();
        Sortable[] var2 = new Sortable[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = (Sortable) ((Sortable) var0.elementAt(var3));
        }

        quickSort(var2, 0, var1 - 1);
        Vector var5 = new Vector();

        for (int var4 = 0; var4 < var1; ++var4) {
            var5.addElement(var2[var4]);
        }

        return var5;
    }

    public static void quickSort(Sortable[] var0) {
        quickSort(var0, 0, var0.length - 1);
    }

    public static void quickSort(Sortable[] var0, int var1, int var2) {
        if (var1 < var2) {
            Sortable var3;
            if (var1 == var2 - 1) {
                if (var0[var1].compareTo(var0[var2]) > 0) {
                    var3 = var0[var1];
                    var0[var1] = var0[var2];
                    var0[var2] = var3;
                }

            } else {
                int var4 = var1;
                int var5 = var2;
                int var6 = (var1 + var2) / 2;
                Sortable var7 = var0[var6];
                var0[var6] = var0[var2];
                var0[var2] = var7;

                while (var4 < var5) {
                    while (var0[var4].compareTo(var7) <= 0 && var4 < var5) {
                        ++var4;
                    }

                    while (var7.compareTo(var0[var5]) <= 0 && var4 < var5) {
                        --var5;
                    }

                    if (var4 < var5) {
                        var3 = var0[var4];
                        var0[var4] = var0[var5];
                        var0[var5] = var3;
                    }
                }

                var0[var2] = var0[var5];
                var0[var5] = var7;
                quickSort(var0, var1, var4 - 1);
                quickSort(var0, var5 + 1, var2);
            }
        }
    }
}
