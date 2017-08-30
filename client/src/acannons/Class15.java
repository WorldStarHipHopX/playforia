package acannons;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class Class15 {

    private ClientSettings aClientSettings_848;
    private GameAreaPanel aSPanel__849;
    private int anInt850;
    private int anInt851;
    private int anInt852;
    private int anInt853;


    protected Class15(ClientSettings var1, GameAreaPanel var2, int var3, int var4) {
        this.aClientSettings_848 = var1;
        this.aSPanel__849 = var2;
        this.anInt850 = var3;
        this.anInt851 = var4;
    }

    protected static Class15 method1040(ClientSettings var0, GameAreaPanel var1, Class3 var2, int var3) {
        int var4 = 0;
        int var5 = -1;
        if (var3 != -1) {
            if (var3 == 1) {
                var4 = var2.method991(1, 5);
            } else if (var2.method991(0, 1) == 1) {
                var4 = var2.method991(1, 5);
            }
        }

        if (var4 == 0) {
            if (var2.method991(0, 10) == 1) {
                var5 = var2.method991(20, 35);
            } else {
                var5 = var2.method991(7, 10);
            }
        }

        return new Class15(var0, var1, var4, var5);
    }

    protected void method1041(int var1, int var2) {
        this.anInt852 = var1;
        this.anInt853 = var2;
    }

    protected int method1042() {
        return this.aClientSettings_848.aGameSpriteManager_771.widthsObjects[this.anInt850];
    }

    protected int method1043() {
        return this.aClientSettings_848.aGameSpriteManager_771.heightsObjects[this.anInt850];
    }

    protected boolean[][] method1044() {
        return this.aClientSettings_848.aGameSpriteManager_771.aBooleanArrayArrayArray858[this.anInt850];
    }

    protected boolean method1045() {
        return this.anInt850 == 0;
    }

    protected boolean method1046(Class3 var1, LinkedList var2, LinkedList var3, double var4, double var6, double var8, int var10) {
        double var11 = var4 - (double) this.anInt852;
        double var13 = var6 - (double) this.anInt853;
        double var15 = (double) ((this.aClientSettings_848.aGameSpriteManager_771.widthsObjects[this.anInt850] / 2 + this.aClientSettings_848.aGameSpriteManager_771.heightsObjects[this.anInt850] / 2) / 2);
        if (Math.sqrt(var11 * var11 + var13 * var13) >= var8 + var15) {
            return true;
        } else {
            this.aSPanel__849.method2366(var3, 40, 1.0D, this.anInt852, this.anInt853, (int) (var15 + 0.5D), -1, 0, var10, true);

            for (int var17 = 0; var17 < this.anInt851; ++var17) {
                this.aSPanel__849.method2365(var2, 18, (double) this.anInt852, (double) this.anInt853, (0.5D - var1.method992()) * 2.0D, -var1.method992(), var1.method991(400, 500), var10);
            }

            return false;
        }
    }

    protected void method1047(Graphics2D var1) {
        var1.drawImage(this.aClientSettings_848.aGameSpriteManager_771.imagesObjects[this.anInt850], this.anInt852 - this.aClientSettings_848.aGameSpriteManager_771.widthsObjects[this.anInt850] / 2, this.anInt853 - this.aClientSettings_848.aGameSpriteManager_771.heightsObjects[this.anInt850] / 2, this.aSPanel__849);
    }
}
