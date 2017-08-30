package apool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.util.Random;

public class SPanel_Sub32_Sub1 extends SPanel_Sub32 {

    private static final int[] anIntArray4866;
    private static final int[] anIntArray4867;
    private static final double aDouble4868;
    private static final double aDouble4869;
    private static final Color aColor4870;
    private static final int[] anIntArray4871;
    private static final double aDouble4872;
    private static final double aDouble4873;
    private static final int[] anIntArray4874;
    private static Image anImage4875;
    private static Image anImage4876;
    private boolean aBoolean4877;
    private long aLong4878;
    private static final String[] aStringArray4879 = new String[5];


    protected SPanel_Sub32_Sub1(Class60 var1, SPanel_Sub20 var2, GameReplay var3, boolean var4) {
        super(var1, var2, var3);
        this.aBoolean4877 = var4;
        this.aLong4878 = 0L;
    }

    public void mouseEntered(MouseEvent var1) {
        if (this.aBoolean4877) {
            long var2 = System.currentTimeMillis();
            if (var2 > this.aLong4878 + 100L) {
                this.requestFocus();
            }

            this.aLong4878 = var2;
        }

    }

    protected void method2650() {
        super.anInt4123 = 620;
        super.anInt4124 = 330;
        super.anInt4125 = 20;
        super.anInt4126 = 10;
        super.aDouble4136 = aDouble4868;
        super.anInt4127 = 16;
        super.anInt4128 = 30;
        super.anInt4129 = 10;
        super.anIntArray4130 = anIntArray4866;
        super.anIntArray4131 = anIntArray4867;
        super.aDouble4132 = 3.0D;
        super.aDouble4133 = 2.1D;
        super.aDouble4134 = 0.9935D;
        super.aDouble4135 = 0.09D;
    }

    protected void method2651() {
        super.anImage4143 = super.aClass60_4137.imageManager.method1983("game_pool-table");
        super.anImageArrayArray4147 = super.aClass60_4137.gameApplet.method2314();
        super.anImage4144 = super.aClass60_4137.imageManager.method1983("game_pool-cgreen");
        super.anImage4145 = super.aClass60_4137.imageManager.method1983("game_pool-cred");
        this.method2653(super.aClass60_4137.imageManager.getPixels(super.aClass60_4137.imageManager.method1983("game_pool-table-mask"), 620, 330));
        if (anImage4875 == null) {
            anImage4875 = super.aClass60_4137.imageManager.createImage(anIntArray4874, 9, 9);
        }

        if (anImage4876 == null) {
            anImage4876 = super.aClass60_4137.imageManager.setTransparency(super.aClass60_4137.imageManager.method1983("game_pool-ballshadow"), 0.4D);
        }

    }

    protected Area method2652() {
        Area var1 = new Area(new Rectangle(30, 30, 560, 270));
        var1.add(new Area(new Rectangle(0, 0, 52, 55)));
        var1.add(new Area(new Rectangle(285, 0, 51, 30)));
        var1.add(new Area(new Rectangle(565, 0, 55, 56)));
        var1.add(new Area(new Rectangle(0, 275, 54, 55)));
        var1.add(new Area(new Rectangle(285, 300, 51, 30)));
        var1.add(new Area(new Rectangle(563, 274, 57, 56)));
        return var1;
    }

    protected boolean method2654() {
        return false;
    }

    protected int method2659(int var1, int var2, boolean var3) {
        int var4 = super.method2659(var1, var2, var3);
        if (this.aBoolean4877) {
            this.requestFocus();
        }

        return var4;
    }

    protected void method2657(int var1, int var2, Class66 var3) {
        int[] var4 = this.method2726(var1, var2, var3);
        int var5 = 0;
        boolean var6 = true;
        double var7 = 445.0D;

        for (int var9 = 0; var9 < 5; ++var9) {
            int var13;
            if (var1 == 2 && var2 == 1) {
                var13 = var9 <= 2 ? var9 + 1 : 5 - var9;
            } else {
                var13 = var9 + 1;
            }

            double var10 = (double) (165 - (var13 - 1) / 2 * 20) - (double) var13 / 2.0D * 0.9D;
            if (var13 % 2 == 0) {
                var10 -= 10.0D;
            }

            for (int var12 = 0; var12 < var13; ++var12) {
                super.aClass65Array4153[var4[var5]].method1491(var7, var10);
                ++var5;
                var10 += 20.9D;
            }

            var7 += aDouble4869 + 0.9D;
        }

        this.method2658();
    }

    protected void method2674(Graphics var1) {
        double var2 = 32.0D;
        double var4 = 298.0D - var2;
        Random var6 = new Random(System.currentTimeMillis() / 10000L);
        double var7 = var4 / (8.0D + var6.nextDouble() * 4.0D);
        double var9 = var6.nextDouble() * 2.0D;
        double var11 = var6.nextDouble() * 2.0D - 1.0D;
        short var13 = 180;
        double var14 = 1.0D * var4 / (var7 * 2.0D);
        var2 -= var9;
        var1.setColor(SPanel_Sub32.aColor4121);

        for (int var16 = 0; (double) var16 < var7; ++var16) {
            var1.drawLine(var13, (int) (var2 + 0.5D), var13, (int) (var2 + var14 + var11 + 0.5D));
            var2 += var14 * 2.0D;
        }

    }

    protected void method2675(Graphics var1, int var2, int var3) {
        this.method2681(var1, aColor4870, (double) var2, (double) var3, super.aClass65Array4153[0].method1483(), super.aClass65Array4153[0].method1484());
    }

    protected void method2676(Graphics var1, int var2) {
        double var3 = ((double) anIntArray4871[0] - super.aClass65Array4153[var2].method1483()) * aDouble4873;
        double var5 = ((double) anIntArray4871[1] - super.aClass65Array4153[var2].method1484()) * aDouble4873;
        int var7 = (int) (super.aClass65Array4153[var2].method1483() - var3 - 10.0D + 0.5D);
        int var8 = (int) (super.aClass65Array4153[var2].method1484() - var5 - 10.0D + 0.5D);
        byte var9 = 4;
        var1.drawImage(anImage4876, var7 - var9, var8 - var9, this);
    }

    protected void method2677(Graphics var1, double var2, double var4) {
        double var6 = ((double) anIntArray4871[0] - var2) * aDouble4872;
        double var8 = ((double) anIntArray4871[1] - var4) * aDouble4872;
        int var10 = (int) (var2 + var6 - 4.5D + 0.5D);
        int var11 = (int) (var4 + var8 - 4.5D + 0.5D);
        var1.drawImage(anImage4875, var10, var11, this);
    }

    protected boolean method2678(int var1, int var2) {
        return var1 < 170;
    }

    protected void method2679(int var1) {
        int var2;
        for (var2 = 445; !this.method2671(var1, var2, 165); var2 -= 5) {
            ;
        }

        super.aClass65Array4153[var1].method1491((double) var2, 165.0D);
        this.repaint();
    }

    protected boolean method2680(int var1, boolean[][] var2) {
        int[] var3 = new int[]{-1, -1, -1};
        int var4 = 0;

        int var5;
        for (var5 = 1; var5 < 16; ++var5) {
            if (super.aClass65Array4153[var5].method1482()) {
                var3[var4] = var5;
                ++var4;
            }
        }

        var5 = 15 - var4;
        var4 = 0;
        super.anInt4162 += var5;
        int[] var6 = new int[15];
        int var7;
        if (var1 == 1 || var1 == 2) {
            for (var7 = 0; var7 < 15; ++var7) {
                if (var7 == 0 && var3[0] >= 0) {
                    var6[var7] = -1;
                } else if (var1 == 1) {
                    while (!var2[var4 / 16][var4 % 16]) {
                        ++var4;
                    }

                    var6[var7] = var4 % 16;
                    ++var4;
                } else {
                    do {
                        do {
                            do {
                                ++var4;
                            } while (var3[0] == var4);
                        } while (var3[1] == var4);
                    } while (var3[2] == var4);

                    var6[var7] = var4;
                }
            }
        }

        if (var1 == 3) {
            for (var7 = 0; var7 < 15; ++var7) {
                if ((var5 != 12 || var7 != 0 && var7 != 10 && var7 != 14) && (var5 != 13 || var7 != 10 && var7 != 14) && (var5 != 14 || var7 != 0)) {
                    do {
                        do {
                            do {
                                ++var4;
                            } while (var3[0] == var4);
                        } while (var3[1] == var4);
                    } while (var3[2] == var4);

                    var6[var7] = var4;
                } else {
                    var6[var7] = -1;
                }
            }
        }

        var7 = 0;
        double var8 = 445.0D;

        int var14;
        for (int var10 = 0; var10 < 5; ++var10) {
            int var11 = var10 + 1;
            double var12 = (double) (165 - (var11 - 1) / 2 * 20) - (double) var11 / 2.0D * 0.9D;
            if (var11 % 2 == 0) {
                var12 -= 10.0D;
            }

            for (var14 = 0; var14 < var11; ++var14) {
                if (var6[var7] >= 0) {
                    super.aClass65Array4153[var6[var7]].method1491(var8, var12);
                }

                ++var7;
                var12 += 20.9D;
            }

            var8 += aDouble4869 + 0.9D;
        }

        boolean var17 = false;
        if (super.aClass65Array4153[0].method1482() && !this.method2727(0)) {
            super.aClass65Array4153[0].method1492(false);
            var17 = true;
        }

        var14 = var3.length;

        for (int var15 = 0; var15 < var14; ++var15) {
            if (var3[var15] >= 0 && !this.method2727(var3[var15])) {
                int var16;
                for (var16 = 175; !this.method2671(var3[var15], var16, 165); var16 += 5) {
                    ;
                }

                super.aClass65Array4153[var3[var15]].method1493((double) var16, 165.0D);
            }
        }

        return var17;
    }

    private int[] method2726(int var1, int var2, Class66 var3) {
        boolean[] var4 = new boolean[16];

        for (int var5 = 1; var5 < 16; ++var5) {
            var4[var5] = false;
        }

        byte var12 = 15;
        int var6 = -1;
        if (var1 == 2 && var2 == 1) {
            var12 = 9;
        }

        int[] var7 = new int[]{-1, 8, 0, 0, -1, 8, 8, 0, 8, 0, 0, 8, 8, 0, 8};
        int[] var8 = new int[]{-1, 0, 8, 8, -1, 0, 0, 8, 0, 8, 8, 0, 8, 8, 0};
        int[] var9 = new int[var12];
        int[] var10 = var3.method1520() % 2 == 0 ? var7 : var8;

        for (int var11 = 0; var11 < var12; ++var11) {
            do {
                if (var1 == 2 && var2 == 0) {
                    if (var11 > 0 && var11 != 4) {
                        var6 = var10[var11] + 1 + var3.method1520() % 7;
                    } else {
                        var6 = var11 == 0 ? 1 : 8;
                    }
                }

                if (var1 == 2 && var2 == 1) {
                    if (var11 > 0 && var11 != 4) {
                        var6 = var3.method1520() % 7 + 2;
                    } else {
                        var6 = var11 == 0 ? 1 : 9;
                    }
                }

                if (var1 == 1 && var2 != 0 || var1 == 2 && (var2 == 2 || var2 == 3)) {
                    if (var11 > 0) {
                        var6 = var3.method1520() % 14 + 2;
                    } else {
                        var6 = 1;
                    }
                }

                if (var1 == 1 && var2 == 0) {
                    var6 = var11 + 1;
                }
            } while (var4[var6]);

            var9[var11] = var6;
            var4[var6] = true;
        }

        return var9;
    }

    private boolean method2727(int var1) {
        for (int var2 = 0; var2 < 16; ++var2) {
            if (var2 != var1 && super.aClass65Array4153[var2].method1482()) {
                double var3 = super.aClass65Array4153[var1].method1483() - super.aClass65Array4153[var2].method1483();
                double var5 = super.aClass65Array4153[var1].method1484() - super.aClass65Array4153[var2].method1484();
                double var7 = Math.sqrt(var3 * var3 + var5 * var5);
                if (var7 < 21.0D) {
                    return false;
                }
            }
        }

        return true;
    }

    static {
        aStringArray4879[0] = "game_pool-cred";
        aStringArray4879[1] = "game_pool-cgreen";
        aStringArray4879[2] = "game_pool-table-mask";
        aStringArray4879[3] = "game_pool-table";
        aStringArray4879[4] = "game_pool-ballshadow";
        anIntArray4866 = new int[]{26, 310, 593, 26, 310, 593};
        anIntArray4867 = new int[]{26, 21, 26, 305, 310, 305};
        aDouble4868 = Math.sqrt(50.0D) + 0.5D;
        aDouble4869 = Math.sqrt(300.0D);
        aColor4870 = new Color(160, 255, 160);
        anIntArray4871 = new int[]{310, 165};
        aDouble4872 = 10.0D / Math.sqrt(493300.0D);
        aDouble4873 = aDouble4872 * 1.5D;
        anIntArray4874 = new int[]{16777215, 16777215, 16777215, 553648127, 553648127, 553648127, 16777215, 16777215, 16777215, 16777215, 285212671, 553648127, 1090519039, 1358954495, 1090519039, 553648127, 285212671, 16777215, 16777215, 553648127, 1358954495, 1895825407, -2130706433, 1895825407, 1358954495, 553648127, 16777215, 553648127, 1090519039, 1895825407, -1593835521, -1056964609, -1593835521, 1895825407, 1090519039, 553648127, 553648127, 1358954495, -2130706433, -1056964609, -251658241, -1056964609, -2130706433, 1358954495, 553648127, 553648127, 1090519039, 1895825407, -1593835521, -1056964609, -1593835521, 1895825407, 1090519039, 553648127, 16777215, 553648127, 1358954495, 1895825407, -2130706433, 1895825407, 1358954495, 553648127, 16777215, 16777215, 285212671, 553648127, 1090519039, 1358954495, 1090519039, 553648127, 285212671, 16777215, 16777215, 16777215, 16777215, 553648127, 553648127, 553648127, 16777215, 16777215, 16777215};
    }
}
