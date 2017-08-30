package apool;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

class Class71 {

    protected SPanel_Sub20 aSPanel_Sub20_1267;
    private SPanel_Sub32 aSPanel_Sub32_1268;
    private boolean aBoolean1269;
    private int anInt1270;
    private double aDouble1271;
    private int anInt1272;
    private int anInt1273;
    private Image anImage1274;
    private Image anImage1275;
    private Class72 aClass72_1276;
    private Object anObject1277;


    protected Class71(Class60 var1, SPanel_Sub20 var2, SPanel_Sub32 var3, boolean var4, boolean snooker) {
        this.aSPanel_Sub20_1267 = var2;
        this.aSPanel_Sub32_1268 = var3;
        this.aBoolean1269 = var4;
        String var6 = snooker ? "snooker" : "pool";
        this.anImage1274 = var1.imageManager.method1983("game_" + var6 + "-stick-1");
        this.anImage1275 = var1.imageManager.method1983("game_" + var6 + "-stick-0");
        this.aDouble1271 = snooker ? 0.7D : 1.0D;
        this.anInt1270 = 3;
        this.anObject1277 = new Object();
    }

    protected void method1532() {
        this.anInt1270 = 0;
    }

    protected void method1533() {
        if (this.anInt1270 == 0) {
            this.anInt1270 = 1;
            Object var1 = this.anObject1277;
            synchronized (this.anObject1277) {
                this.method1540();
                this.aClass72_1276 = new Class72(this);
            }

            this.anInt1272 = this.anInt1273 = -1;
        }
    }

    protected void method1534(int var1, int var2) {
        if (this.anInt1270 == 1) {
            this.anInt1272 = var1;
            this.anInt1273 = var2;
            if (this.aBoolean1269) {
                double[][] var3 = this.method1538(0);
                Object var4 = this.anObject1277;
                synchronized (this.anObject1277) {
                    if (this.aClass72_1276 != null) {
                        this.aClass72_1276.method1542(var3[1][0], var3[1][1], var1, var2);
                    }
                }
            }

        }
    }

    protected void method1535(int var1, int var2) {
        if (this.aBoolean1269) {
            if (this.anInt1270 == 0) {
                this.anInt1270 = 2;
            }

            if (this.anInt1270 == 2) {
                this.anInt1272 = var1;
                this.anInt1273 = var2;
            }
        }
    }

    protected void method1536() {
        this.anInt1270 = 3;
        Object var1 = this.anObject1277;
        synchronized (this.anObject1277) {
            this.method1540();
        }
    }

    protected void method1537(Graphics2D var1, double var2, int var4, boolean var5) {
        if (!var5) {
            if (this.anInt1270 != 1 && this.anInt1270 != 2) {
                return;
            }

            if (!this.aSPanel_Sub32_1268.method2672(this.anInt1272, this.anInt1273)) {
                return;
            }
        }

        var1.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        Image var6 = this.anInt1270 != 2 ? this.anImage1274 : this.anImage1275;
        AffineTransform var7 = new AffineTransform();
        double[][] var8 = this.method1538(var4);
        double var9 = var8[0][0];
        double var11 = var8[0][1];
        var7.translate(var9, var11);
        if (var2 != 0.0D) {
            double[][] var13 = this.method1539(this.aSPanel_Sub32_1268.aClass65Array4153[0].method1483() + var9, this.aSPanel_Sub32_1268.aClass65Array4153[0].method1484() + var11, this.aSPanel_Sub32_1268.aClass65Array4153[0].method1483(), this.aSPanel_Sub32_1268.aClass65Array4153[0].method1484(), var2 * (double) this.aSPanel_Sub32_1268.anInt4125 / 2.0D);
            double var14 = this.aSPanel_Sub32_1268.aClass65Array4153[0].method1483() + var9 - var13[1][0];
            double var16 = this.aSPanel_Sub32_1268.aClass65Array4153[0].method1484() + var11 - var13[1][1];
            var7.translate(var14, var16);
        }

        var7.translate(this.aSPanel_Sub32_1268.aClass65Array4153[0].method1483(), this.aSPanel_Sub32_1268.aClass65Array4153[0].method1484());
        double var18 = var8[1][0];
        double var20 = var8[1][1];
        double var22 = var18 - var9;
        double var24 = var20 - var11;
        var7.rotate(Math.atan2(var24, var22) - 1.5707963267948966D);
        var7.translate((double) (-var6.getWidth((ImageObserver) null)) * 0.5D, -0.0D);
        var1.drawImage(var6, var7, (ImageObserver) null);
    }

    private double[][] method1538(int var1) {
        if (this.anInt1272 >= 0 && this.anInt1273 >= 0) {
            double var2 = this.aSPanel_Sub32_1268.aClass65Array4153[0].method1483() - (double) this.anInt1272;
            double var4 = this.aSPanel_Sub32_1268.aClass65Array4153[0].method1484() - (double) this.anInt1273;
            double var6 = Math.sqrt(var2 * var2 + var4 * var4);
            double var8 = (double) (this.aSPanel_Sub32_1268.anInt4125 / 2) + (5.0D + (double) var1 * 0.5D) * this.aDouble1271;
            double var10 = var8 + 65.0D * this.aDouble1271;
            double var12 = var8 / var6;
            double var14 = var10 / var6;
            return new double[][]{{var2 * var12, var4 * var12}, {var2 * var14, var4 * var14}};
        } else {
            return new double[][]{{0.0D, 0.0D}, {0.0D, 0.0D}};
        }
    }

    private double[][] method1539(double var1, double var3, double var5, double var7, double var9) {
        double var11 = var1 - var5;
        double var13 = var3 - var7;
        double var15 = Math.sqrt(var11 * var11 + var13 * var13);
        double var17 = var9 * this.aDouble1271 / var15;
        double var19 = var11;
        var11 = var13;
        var13 = -var19;
        double[][] var21 = new double[2][2];
        var21[0][0] = var1 + var11 * var17;
        var21[0][1] = var3 + var13 * var17;
        var21[1][0] = var1 - var11 * var17;
        var21[1][1] = var3 - var13 * var17;
        return var21;
    }

    private void method1540() {
        if (this.aClass72_1276 != null) {
            this.aClass72_1276.method1541();
            this.aClass72_1276 = null;
        }

    }
}
