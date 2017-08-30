package com.aapeli.bigtext;

import com.aapeli.bigtext.BigText;

import java.awt.Color;
import java.awt.Component;

public class MediumText extends BigText {

    private static int[] anIntArray3591;
    private static int[] anIntArray3592;


    protected static void method1559(int[] var0) {
        anIntArray3591 = new int[17900];

        int var1;
        for (var1 = 0; var1 < 25; ++var1) {
            for (int var2 = 0; var2 < 716; ++var2) {
                anIntArray3591[var1 * 716 + var2] = method1560(var0, var2 * 2, var1 * 2);
            }
        }

        anIntArray3592 = new int[BigText.anInt1315];

        for (var1 = 0; var1 < BigText.anInt1315 - 1; ++var1) {
            anIntArray3592[var1] = (BigText.anIntArray1314[var1 + 1] - BigText.anIntArray1314[var1]) / 2;
        }

        anIntArray3592[BigText.anInt1315 - 1] = (1432 - BigText.anIntArray1314[BigText.anInt1315 - 1]) / 2;
    }

    public MediumText(String var1) {
        this(var1, BigText.aColor1312, 255);
    }

    public MediumText(String var1, Color var2) {
        this(var1, var2, 255);
    }

    public MediumText(String var1, Color var2, int var3) {
        super(var1, var2, var3, anIntArray3591, anIntArray3592, 2, (Component) null);
    }

    private static int method1560(int[] var0, int var1, int var2) {
        long var3 = (long) var0[var2 * 1432 + var1];
        long var5 = (long) var0[var2 * 1432 + var1 + 1];
        long var7 = (long) var0[(var2 + 1) * 1432 + var1];
        long var9 = (long) var0[(var2 + 1) * 1432 + var1 + 1];
        long var11 = ((var3 & 4278190080L) >> 24) + ((var5 & 4278190080L) >> 24) + ((var7 & 4278190080L) >> 24) + ((var9 & 4278190080L) >> 24);
        long var13 = ((var3 & 16711680L) >> 16) + ((var5 & 16711680L) >> 16) + ((var7 & 16711680L) >> 16) + ((var9 & 16711680L) >> 16);
        long var15 = ((var3 & 65280L) >> 8) + ((var5 & 65280L) >> 8) + ((var7 & 65280L) >> 8) + ((var9 & 65280L) >> 8);
        long var17 = (var3 & 255L) + (var5 & 255L) + (var7 & 255L) + (var9 & 255L);
        long var19 = (var11 + 2L) / 4L;
        long var21 = (var13 + 2L) / 4L;
        long var23 = (var15 + 2L) / 4L;
        long var25 = (var17 + 2L) / 4L;
        return (int) ((var19 << 24) + (var21 << 16) + (var23 << 8) + var25);
    }
}
