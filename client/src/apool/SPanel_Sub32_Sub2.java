package apool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;

public class SPanel_Sub32_Sub2 extends SPanel_Sub32 implements KeyListener {

    private static final int[] anIntArray4880;
    private static final int[] anIntArray4881;
    private static final double aDouble4882;
    private static final int[] anIntArray4883;
    private static final int[] anIntArray4884;
    private static final double aDouble4885;
    private static final double aDouble4886;
    private static final int[] anIntArray4887;
    private static final Color aColor4888;
    private static final Color aColor4889;
    private static Image anImage4890;
    private static Image anImage4891;
    private static Image anImage4892;
    private int[][] anIntArrayArray4893;
    private boolean aBoolean4894 = true;
    private static final String[] aStringArray4895 = new String[3];


    protected SPanel_Sub32_Sub2(Class60 var1, SPanel_Sub20 var2) {
        super(var1, var2, (GameReplay) null);
        this.addKeyListener(this);
    }

    public void keyPressed(KeyEvent var1) {
        if (var1.getKeyCode() == 32) {
            this.aBoolean4894 = !this.aBoolean4894;
            this.repaint();
        }

    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyTyped(KeyEvent var1) {
    }

    protected void method2650() {
        super.anInt4123 = 600;
        super.anInt4124 = 330;
        super.anInt4125 = 12;
        super.anInt4126 = 6;
        super.aDouble4136 = aDouble4882;
        super.anInt4127 = 22;
        super.anInt4128 = 30;
        super.anInt4129 = 9;
        super.anIntArray4130 = anIntArray4880;
        super.anIntArray4131 = anIntArray4881;
        super.aDouble4132 = 2.0D;
        super.aDouble4133 = 1.5D;
        super.aDouble4134 = 0.995D;
        super.aDouble4135 = 0.08D;
    }

    protected void method2651() {
        super.anImage4143 = super.aClass60_4137.imageManager.method1983("game_snooker-table");
        super.anImageArrayArray4147 = super.aClass60_4137.gameApplet.method2315();
        super.anImage4144 = super.anImage4145 = null;
        this.method2653(super.aClass60_4137.imageManager.getPixels(super.aClass60_4137.imageManager.method1983("game_snooker-table-mask"), 600, 330));
        if (anImage4890 == null) {
            anImage4890 = super.aClass60_4137.imageManager.createImage(anIntArray4887, 7, 7);
        }

        if (anImage4891 == null) {
            anImage4891 = super.aClass60_4137.imageManager.setTransparency(super.aClass60_4137.imageManager.method1983("game_snooker-ballshadow"), 0.25D);
        }

        if (anImage4892 == null) {
            anImage4892 = super.aClass60_4137.imageManager.setTransparency(super.anImageArrayArray4147[0][0], 0.85D);
        }

    }

    protected Area method2652() {
        Area var1 = new Area(new Rectangle(30, 30, 540, 270));
        var1.add(new Area(new Rectangle(0, 0, 44, 44)));
        var1.add(new Area(new Rectangle(284, 0, 31, 30)));
        var1.add(new Area(new Rectangle(555, 0, 45, 44)));
        var1.add(new Area(new Rectangle(0, 284, 44, 46)));
        var1.add(new Area(new Rectangle(286, 300, 27, 30)));
        var1.add(new Area(new Rectangle(556, 285, 44, 45)));
        return var1;
    }

    protected boolean method2654() {
        return true;
    }

    protected int method2659(int var1, int var2, boolean var3) {
        int var4 = super.method2659(var1, var2, var3);
        super.aBoolean4168 = true;
        return var4;
    }

    protected void method2657(int var1, int var2, Class66 var3) {
        super.aClass65Array4153[0].method1492(false);

        for (int var4 = 1; var4 < 22; ++var4) {
            super.aClass65Array4153[var4].method1492(true);
        }

        double var5 = 300.0D;
        double var7 = 435.0D;
        double var9 = var7 + 2.0D + 12.0D;
        double var11 = 524.0896664844178D;
        double var13 = 0.4D;
        double var15 = 12.0D + var13;
        double var17 = 6.0D + var13 * 0.5D;
        double var19 = Math.sqrt(var15 * var15 - var17 * var17);
        int var21 = 1;
        boolean var22 = true;
        double var23 = var9;

        int var25;
        for (var25 = 0; var25 < 5; ++var25) {
            int var29 = var25 + 1;
            double var26 = 165.0D - (double) ((var29 - 1) / 2 * 12) - (double) var29 / 2.0D * var13;
            if (var29 % 2 == 0) {
                var26 -= 6.0D;
            }

            for (int var28 = 0; var28 < var29; ++var28) {
                super.aClass65Array4153[var21].method1493(var23, var26);
                ++var21;
                var26 += 12.0D + var13;
            }

            var23 += var19;
        }

        super.aClass65Array4153[16].method1493(138.79715691634772D, 208.12910284463896D);
        super.aClass65Array4153[17].method1493(138.79715691634772D, 121.87089715536105D);
        super.aClass65Array4153[18].method1493(138.79715691634772D, 165.0D);
        super.aClass65Array4153[19].method1493(var5, 165.0D);
        super.aClass65Array4153[20].method1493(var7, 165.0D);
        super.aClass65Array4153[21].method1493(var11, 165.0D);
        this.method2658();
        this.anIntArrayArray4893 = new int[22][2];

        for (var25 = 0; var25 < 22; ++var25) {
            this.anIntArrayArray4893[var25][0] = super.aClass65Array4153[var25].method1485();
            this.anIntArrayArray4893[var25][1] = super.aClass65Array4153[var25].method1486();
        }

    }

    protected void method2675(Graphics var1, int var2, int var3) {
        if (this.aBoolean4894) {
            double var4 = (double) var2 - super.aClass65Array4153[0].method1483();
            double var6 = (double) var3 - super.aClass65Array4153[0].method1484();
            double var8 = Math.sqrt(var4 * var4 + var6 * var6);
            double var10 = 0.1D / var8;
            double var12 = super.aClass65Array4153[0].method1483();
            double var14 = super.aClass65Array4153[0].method1484();
            double var16 = var4 * var10;
            double var18 = var6 * var10;
            double var20 = -1.0D;
            double var22 = -1.0D;
            boolean var24 = false;

            double var25;
            int var27;
            do {
                var25 = var8;
                var12 += var16;
                var14 += var18;

                for (var27 = 1; var27 < 22; ++var27) {
                    if (super.aClass65Array4153[var27].method1482()) {
                        var4 = super.aClass65Array4153[var27].method1483() - var12;
                        var6 = super.aClass65Array4153[var27].method1484() - var14;
                        var8 = Math.sqrt(var4 * var4 + var6 * var6);
                        if (var8 < 12.0D) {
                            var20 = var12;
                            var22 = var14;
                            var24 = true;
                        }
                    }
                }

                var4 = (double) var2 - var12;
                var6 = (double) var3 - var14;
                var8 = Math.sqrt(var4 * var4 + var6 * var6);
                if (var12 - 6.0D < 30.0D || var12 + 6.0D >= 570.0D || var14 - 6.0D < 30.0D || var14 + 6.0D >= 300.0D) {
                    var8 = Double.MAX_VALUE;
                }
            } while (var8 < var25 && !var24);

            if (var24) {
                this.method2681(var1, aColor4889, (double) var2, (double) var3, var20, var22);
                this.method2681(var1, aColor4888, var20, var22, super.aClass65Array4153[0].method1483(), super.aClass65Array4153[0].method1484());
                var27 = (int) (var20 - 6.0D + 0.5D);
                int var28 = (int) (var22 - 6.0D + 0.5D);
                var1.drawImage(anImage4892, var27, var28, this);
                return;
            }
        }

        this.method2681(var1, aColor4888, (double) var2, (double) var3, super.aClass65Array4153[0].method1483(), super.aClass65Array4153[0].method1484());
    }

    protected void method2676(Graphics var1, int var2) {
        double var3 = ((double) anIntArray4883[0] - super.aClass65Array4153[var2].method1483()) * aDouble4886;
        double var5 = ((double) anIntArray4883[1] - super.aClass65Array4153[var2].method1484()) * aDouble4886;
        int var7 = (int) (super.aClass65Array4153[var2].method1483() - var3 - 6.0D + 0.5D);
        int var8 = (int) (super.aClass65Array4153[var2].method1484() - var5 - 6.0D + 0.5D);
        byte var9 = 4;
        var1.drawImage(anImage4891, var7 - var9, var8 - var9, this);
        var3 = ((double) anIntArray4884[0] - super.aClass65Array4153[var2].method1483()) * aDouble4886;
        var5 = ((double) anIntArray4884[1] - super.aClass65Array4153[var2].method1484()) * aDouble4886;
        var7 = (int) (super.aClass65Array4153[var2].method1483() - var3 - 6.0D + 0.5D);
        var8 = (int) (super.aClass65Array4153[var2].method1484() - var5 - 6.0D + 0.5D);
        var1.drawImage(anImage4891, var7 - var9, var8 - var9, this);
    }

    protected void method2677(Graphics var1, double var2, double var4) {
        double var6 = ((double) anIntArray4883[0] - var2) * aDouble4885;
        double var8 = ((double) anIntArray4883[1] - var4) * aDouble4885;
        int var10 = (int) (var2 + var6 - 3.5D + 0.5D);
        int var11 = (int) (var4 + var8 - 3.5D + 0.5D);
        var1.drawImage(anImage4890, var10, var11, this);
        var6 = ((double) anIntArray4884[0] - var2) * aDouble4885;
        var8 = ((double) anIntArray4884[1] - var4) * aDouble4885;
        var10 = (int) (var2 + var6 - 3.5D + 0.5D);
        var11 = (int) (var4 + var8 - 3.5D + 0.5D);
        var1.drawImage(anImage4890, var10, var11, this);
    }

    protected boolean method2678(int var1, int var2) {
        if ((double) var1 > 138.79715691634772D) {
            return false;
        } else {
            double var3 = 138.79715691634772D - (double) var1;
            double var5 = 165.0D - (double) var2;
            double var7 = Math.sqrt(var3 * var3 + var5 * var5);
            return var7 <= 43.12910284463895D;
        }
    }

    protected void method2679(int var1) {
        if (var1 >= 16 && var1 <= 21) {
            if (!this.method2729(var1)) {
                this.method2730(var1);
            }
        } else {
            int var2;
            if (super.aClass65Array4153[var1].method1482()) {
                for (var2 = 1; var2 < 16; ++var2) {
                    if (!super.aClass65Array4153[var2].method1482()) {
                        var1 = var2;
                        var2 = 16;
                    }
                }
            }

            var2 = 449;

            short var3;
            for (var3 = 165; !this.method2671(var1, var2, var3); var2 -= 5) {
                ;
            }

            super.aClass65Array4153[var1].method1491((double) var2, (double) var3);
        }

        this.repaint();
    }

    protected void method2728(boolean[] var1) {
        boolean var2 = false;

        int var3;
        for (var3 = 16; var3 < 22 && !var2; ++var3) {
            if (var1[var3]) {
                var2 = true;
            }
        }

        if (var2) {
            for (var3 = 16; var3 < 22; ++var3) {
                if (var1[var3] && this.method2729(var3)) {
                    var1[var3] = false;
                }
            }

            for (var3 = 21; var3 >= 16; --var3) {
                if (var1[var3]) {
                    this.method2730(var3);
                }
            }

        }
    }

    private boolean method2729(int var1) {
        return this.method2731(var1, this.anIntArrayArray4893[var1][0], this.anIntArrayArray4893[var1][1]);
    }

    private void method2730(int var1) {
        int var2;
        for (var2 = 21; var2 >= 16; --var2) {
            if (this.method2731(var1, this.anIntArrayArray4893[var2][0], this.anIntArrayArray4893[var2][1])) {
                return;
            }
        }

        var2 = this.anIntArrayArray4893[var1][0];

        do {
            ++var2;
            if (this.method2731(var1, var2, this.anIntArrayArray4893[var1][1])) {
                return;
            }
        } while (var2 < 562);

        var2 = this.anIntArrayArray4893[var1][0];

        do {
            --var2;
        } while (!this.method2731(var1, var2, this.anIntArrayArray4893[var1][1]));

    }

    private boolean method2731(int var1, int var2, int var3) {
        if (this.method2671(var1, var2, var3)) {
            super.aClass65Array4153[var1].method1491((double) var2, (double) var3);
            return true;
        } else {
            return false;
        }
    }

    static {
        aStringArray4895[0] = "game_snooker-table-mask";
        aStringArray4895[1] = "game_snooker-ballshadow";
        aStringArray4895[2] = "game_snooker-table";
        anIntArray4880 = new int[]{23, 300, 576, 23, 300, 576};
        anIntArray4881 = new int[]{24, 19, 24, 306, 311, 306};
        aDouble4882 = Math.sqrt(18.0D) + 0.5D;
        anIntArray4883 = new int[]{175, 165};
        anIntArray4884 = new int[]{425, 165};
        aDouble4885 = 6.0D / Math.sqrt(468900.0D);
        aDouble4886 = aDouble4885 * 1.5D;
        anIntArray4887 = new int[]{16777215, 16777215, 150994943, 285212671, 150994943, 16777215, 16777215, 16777215, 285212671, 419430399, 553648127, 419430399, 285212671, 16777215, 150994943, 419430399, 687865855, 956301311, 687865855, 419430399, 150994943, 285212671, 553648127, 956301311, 1358954495, 956301311, 553648127, 285212671, 150994943, 419430399, 687865855, 956301311, 687865855, 419430399, 150994943, 16777215, 285212671, 419430399, 553648127, 419430399, 285212671, 16777215, 16777215, 16777215, 150994943, 285212671, 150994943, 16777215, 16777215};
        aColor4888 = new Color(224, 224, 255);
        aColor4889 = new Color(192, 192, 255);
    }
}
