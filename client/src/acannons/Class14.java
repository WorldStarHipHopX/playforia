package acannons;

import java.awt.Graphics;

public class Class14 {

    private ClientSettings aClientSettings_842;
    private GameAreaPanel aSPanel__843;
    private double aDouble844;
    private double aDouble845;
    private boolean aBoolean846;
    private int anInt847;


    protected Class14(ClientSettings var1, GameAreaPanel var2) {
        this.aClientSettings_842 = var1;
        this.aSPanel__843 = var2;
        this.aBoolean846 = false;
    }

    protected boolean method1038(Class3 var1, int var2) {
        if (!this.aBoolean846) {
            this.aDouble844 = -45.0D - var1.method992() * 10.0D;
            if (var2 < 0) {
                this.aDouble844 = 805.0D + var1.method992() * 10.0D;
            }

            this.aDouble845 = 21.0D + var1.method992() * 10.0D;
            this.anInt847 = var2 < 0 ? 0 : 1;
            this.aBoolean846 = true;
        }

        this.aDouble844 += 0.0015D * (double) var2 * (0.5D + var1.method992());
        int var3 = (int) (this.aDouble844 + 0.5D);
        boolean var4 = true;
        if (var3 < -40 && var2 < 0 || var3 >= 800 && var2 > 0) {
            var4 = false;
        }

        return var4;
    }

    protected void method1039(Graphics var1) {
        if (this.aBoolean846) {
            var1.drawImage(this.aClientSettings_842.aGameSpriteManager_771.imageAds[this.anInt847], (int) (this.aDouble844 + 0.5D) - 40, (int) (this.aDouble845 + 0.5D) - 20, this.aSPanel__843);
        }

    }
}
