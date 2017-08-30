package acannons;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D.Double;
import java.awt.image.ImageObserver;
import java.util.LinkedList;

class Class13 {

    private ClientSettings aClientSettings_832;
    private GameAreaPanel aSPanel__833;
    private int anInt834;
    private int anInt835;
    private int anInt836;
    private int anInt837;
    private int anInt838;
    private int anInt839;
    private int anInt840;
    private double aDouble841;


    protected Class13(ClientSettings var1, GameAreaPanel var2, int var3, double var4, int var6, int var7, int var8, int var9, int var10, int var11, boolean var12) {
        this.aClientSettings_832 = var1;
        this.aSPanel__833 = var2;
        this.anInt834 = var3;
        this.aDouble841 = var4;
        this.anInt835 = var6;
        this.anInt836 = var7;
        this.anInt837 = var8;
        this.anInt838 = var9;
        this.anInt839 = var10;
        this.anInt840 = var11;
        if (var12) {
            var1.aSoundManager_770.method977((double) this.anInt835, (double) this.anInt836, var3);
        }

    }

    protected boolean method1036(Class3 var1, LinkedList var2, LinkedList var3, Graphics2D var4) {
        if (this.anInt838 != 0 && var1.method991(1, 2) == 1) {
            return true;
        } else {
            ++this.anInt837;
            this.aSPanel__833.method2371(this.anInt835, this.anInt836, this.anInt837, (byte) (this.anInt838 == 1 ? 1 : 0));
            if (this.anInt838 == -1) {
                double var5 = this.aDouble841;

                do {
                    if (var1.method992() < var5) {
                        this.aSPanel__833.method2369(var2, var3, (double) this.anInt835, (double) this.anInt836, (double) this.anInt837, 1, this.anInt840);
                    }

                    --var5;
                } while (var5 > 0.0D);
            }

            if (this.anInt838 == 0) {
                this.aSPanel__833.method2369(var2, var3, (double) this.anInt835, (double) this.anInt836, (double) this.anInt837, 0, this.anInt840);
            }

            if (this.anInt837 >= this.anInt834) {
                if (this.anInt838 == 1) {
                    var4.setColor(GameAreaPanel.aColorArray2700[this.aClientSettings_832.useWinterGraphics]);
                    var4.fillOval(this.anInt835 - this.anInt837, this.anInt836 - this.anInt837, this.anInt837 * 2, this.anInt837 * 2);
                } else {
                    Shape var7 = var4.getClip();
                    var4.setClip(new Double((double) (this.anInt835 - this.anInt837), (double) (this.anInt836 - this.anInt837), (double) this.anInt837 * 2.0D, (double) this.anInt837 * 2.0D));
                    var4.drawImage(this.aSPanel__833.method2373(), 0, 0, (ImageObserver) null);
                    var4.setClip(var7);
                }

                this.aSPanel__833.method2372(var4);
                if (this.anInt838 != 1) {
                    this.aSPanel__833.method2371(this.anInt835, this.anInt836, this.anInt837, (byte) -1);
                }

                if (this.anInt839 != 0) {
                    this.aSPanel__833.method2367(this.anInt835, this.anInt836, this.anInt837 - 10, this.anInt839, this.anInt840);
                }

                return false;
            } else {
                return true;
            }
        }
    }

    protected void method1037(Graphics2D var1) {
        if (this.anInt838 == -1) {
            int var2 = 255 - this.anInt834 + this.anInt837;
            if (var2 < 0) {
                var2 = 0;
            } else if (var2 > 255) {
                var2 = 255;
            }

            var1.setColor(new Color(255, var2, 0));
        }

        if (this.anInt838 == 0) {
            var1.setColor(GameAreaPanel.aColorArray2699[this.aClientSettings_832.useWinterGraphics]);
        } else if (this.anInt838 == 1) {
            var1.setColor(GameAreaPanel.aColorArray2700[this.aClientSettings_832.useWinterGraphics]);
        }

        var1.fillOval(this.anInt835 - this.anInt837, this.anInt836 - this.anInt837, this.anInt837 * 2, this.anInt837 * 2);
    }
}
