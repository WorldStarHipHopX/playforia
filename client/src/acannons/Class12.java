package acannons;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

public class Class12 {

    private static final double[] aDoubleArray824 = new double[]{0.0D, 0.017D, 0.009D};
    private ClientSettings aClientSettings_825;
    private GameAreaPanel aSPanel__826;
    private double aDouble827;
    private double aDouble828;
    private int anInt829;
    private int anInt830;
    private int anInt831;


    protected Class12(ClientSettings var1, GameAreaPanel var2, double var3, double var5, int var7, int var8, int var9) {
        this.aClientSettings_825 = var1;
        this.aSPanel__826 = var2;
        this.aDouble827 = var3;
        this.aDouble828 = var5;
        this.anInt829 = var7;
        this.anInt830 = var8;
        this.anInt831 = var9;
    }

    protected boolean method1034(Class3 var1, int[] var2, int var3) {
        this.aDouble827 += 0.002D * (double) var3 * (0.5D + var1.method992() * 1.2D);
        if (this.anInt829 == 1) {
            this.aDouble828 -= 0.01D * (0.5D + var1.method992() * 1.2D);
        } else {
            this.aDouble828 += 0.02D * (0.5D + var1.method992() * 1.2D);
        }

        int var4 = (int) (this.aDouble827 + 0.5D);
        int var5 = (int) (this.aDouble828 + 0.5D);
        if (var3 < 0 && this.aSPanel__826.method2370(var4 - 20, var5)) {
            if (this.aSPanel__826.method2370(var4 - 20, var5 + 2) && this.aSPanel__826.method2370(var4 - 20, var5 + 4) && this.aSPanel__826.method2370(var4 - 20, var5 + 8)) {
                if (this.aSPanel__826.method2370(var4 - 20, var5 - 2) && this.aSPanel__826.method2370(var4 - 20, var5 - 4) && this.aSPanel__826.method2370(var4 - 20, var5 - 8)) {
                    this.aDouble827 -= 0.002D * (double) var3;
                } else {
                    --this.aDouble828;
                }
            } else {
                ++this.aDouble828;
            }
        }

        if (var3 > 0 && this.aSPanel__826.method2370(var4 + 20, var5)) {
            if (this.aSPanel__826.method2370(var4 + 20, var5 + 2) && this.aSPanel__826.method2370(var4 + 20, var5 + 4) && this.aSPanel__826.method2370(var4 + 20, var5 + 8)) {
                if (this.aSPanel__826.method2370(var4 + 20, var5 - 2) && this.aSPanel__826.method2370(var4 + 20, var5 - 4) && this.aSPanel__826.method2370(var4 + 20, var5 - 8)) {
                    this.aDouble827 -= 0.002D * (double) var3;
                } else {
                    --this.aDouble828;
                }
            } else {
                ++this.aDouble828;
            }
        }

        var4 = (int) (this.aDouble827 + 0.5D);
        if (var4 < 0) {
            var4 = 0;
        } else if (var4 >= 760) {
            var4 = 759;
        }

        while (this.aDouble828 + 10.0D >= (double) var2[var4]) {
            --this.aDouble828;
        }

        var4 = (int) (this.aDouble827 + 0.5D);
        var5 = (int) (this.aDouble828 + 0.5D);
        if (var4 < -20 || var4 >= 780 || var5 < -10) {
            this.anInt830 = 0;
        }

        --this.anInt830;
        if (var1.method992() < aDoubleArray824[this.anInt829]) {
            this.aSPanel__826.method2369((LinkedList) null, (LinkedList) null, this.aDouble827, this.aDouble828, 40.0D, 1, this.anInt831);
        }

        return this.anInt830 > 0;
    }

    protected void method1035(Graphics var1) {
        Image var2 = this.anInt829 == 1 ? this.aClientSettings_825.aGameSpriteManager_771.imageCloudPoison : this.aClientSettings_825.aGameSpriteManager_771.imageCloudFallout;
        var1.drawImage(var2, (int) (this.aDouble827 + 0.5D) - 20, (int) (this.aDouble828 + 0.5D) - 10, this.aSPanel__826);
    }

}
