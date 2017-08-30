package com.playray.bigtext;

import com.playray.bigtext.BigText;
import com.playray.client.ImageManager;

import java.awt.Color;

public class MediumText extends BigText {

    public MediumText(ImageManager var1, String var2) {
        super(var1);
        this.method1895(var1, var2, aColor1757, 255);
    }

    public MediumText(ImageManager var1, String var2, Color var3) {
        super(var1);
        this.method1895(var1, var2, var3, 255);
    }

    public MediumText(ImageManager var1, String var2, Color var3, int var4) {
        super(var1);
        this.method1895(var1, var2, var3, var4);
    }

    private void method1895(ImageManager var1, String var2, Color var3, int var4) {
        int[] var5 = var1.getMediumTextPixels();
        int[] var6 = new int[anInt1760];

        for (int var7 = 0; var7 < anInt1760 - 1; ++var7) {
            var6[var7] = (BigText.anIntArray1759[var7 + 1] - BigText.anIntArray1759[var7]) / 2;
        }

        var6[anInt1760 - 1] = (1432 - anIntArray1759[anInt1760 - 1]) / 2;
        this.method1885(var2, var3, var4, var5, var6, 2);
    }
}
