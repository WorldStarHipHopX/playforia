package acannons;

import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class GameLogic {//todo probably

    private static final int[] anIntArray799 = new int[]{10, 20, 40, 30, 30, -1, 30, 10, 30, 50, -1, 60, 80, 200, 80, 50, 30, 30, -1};
    private static final int[] anIntArray800 = new int[]{90, 91, 92, 93, 85, -1, 95, 96, 86, 86, -1, 97, 97, 98, 94, 94, 95, 95, -1};
    private static final double[] aDoubleArray801 = new double[]{1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.3D, 1.3D, 0.8D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D};
    private static final double[] aDoubleArray802 = new double[]{1.0D, 1.1D, 1.2D, 1.0D, 1.3D, 1.3D, 1.3D, 1.4D, 1.4D, 1.6D, 1.3D, 1.0D, 1.5D, 1.0D, 1.0D, 1.8D, 1.3D, 1.3D, 0.9D};
    private static final boolean[] aBooleanArray803 = new boolean[]{true, true, true, true, false, false, false, true, true, true, true, true, true, true, true, true, true, false, false};
    private static final int[] anIntArray804 = new int[]{1, 2, 4, 3, 3, 3, 3, 5, 5, 6, 4, 4, 6, 7, 3, 5, 3, 3, 1};
    private static final Color[] aColorArray805 = new Color[]{new Color(0, 0, 0), new Color(204, 204, 204)};
    private ClientSettings aClientSettings_806;
    private GameAreaPanel aSPanel__807;
    private int anInt808;
    private double aDouble809;
    private double aDouble810;
    private double aDouble811;
    private double aDouble812;
    private double aDouble813;
    private double aDouble814;
    private int anInt815;
    private int anInt816;
    private int anInt817;
    private int anInt818;
    private int anInt819;
    private boolean aBoolean820;
    private boolean aBoolean821;


    protected GameLogic(ClientSettings var1, GameAreaPanel var2, int var3, double var4, double var6, double var8, double var10, int var12, int var13, int var14, boolean var15, int var16) {
        this.aClientSettings_806 = var1;
        this.aSPanel__807 = var2;
        this.anInt808 = var3;
        this.aDouble809 = var4;
        this.aDouble810 = var6;
        this.aDouble811 = var8;
        this.aDouble812 = var10;
        this.anInt815 = var12;
        this.anInt816 = var13;
        this.anInt817 = var14;
        this.aBoolean820 = var15;
        this.anInt819 = var16;
        this.aBoolean821 = false;
        this.anInt818 = var3 == 18 ? 4 : 0;
        if (var3 == 18) {
            var1.aSoundManager_770.method978();
        }

    }

    protected void method1029(Graphics2D var1) {
        int var2 = (int) (this.aDouble809 + 0.5D);
        if (this.aDouble810 >= 1.0D) {
            int var3 = (int) (this.aDouble810 + 0.5D);
            int var4;
            if (this.anInt808 == 18) {
                var4 = (int) (Math.random() * 3.0D);
                var1.drawImage(this.aClientSettings_806.aGameSpriteManager_771.imagesNapalm[var4], var2 - 3, var3 - 3, this.aSPanel__807);
            } else if (this.anInt808 == 13) {
                if (this.aDouble812 < 0.0D) {
                    var4 = (int) (Math.random() * 3.0D);
                    var1.drawImage(this.aClientSettings_806.aGameSpriteManager_771.imagesSS20Up[var4], var2 - 2, var3 - 9, this.aSPanel__807);
                } else {
                    var1.drawImage(this.aClientSettings_806.aGameSpriteManager_771.imageSS20Down, var2 - 2, var3 - 9, this.aSPanel__807);
                }
            } else {
                var1.setColor(aColorArray805[this.aClientSettings_806.useWinterGraphics]);
                if (anIntArray804[this.anInt808] == 1) {
                    if (Math.abs(this.aDouble811) < Math.abs(this.aDouble812)) {
                        var1.fillRect(var2, var3, 1, 2);
                    } else {
                        var1.fillRect(var2, var3, 2, 1);
                    }
                } else {
                    var1.fillOval(var2 - anIntArray804[this.anInt808] / 2, var3 - anIntArray804[this.anInt808] / 2, anIntArray804[this.anInt808], anIntArray804[this.anInt808]);
                }
            }
        } else if (this.anInt808 != 13) {
            var1.setColor(aColorArray805[this.aClientSettings_806.useWinterGraphics]);
            var1.drawLine(var2, 1, var2 - 2, 5);
            var1.drawLine(var2, 1, var2 + 2, 5);
        }

    }

    protected boolean method1030(Class3 var1, LinkedList var2, LinkedList var3, int var4) {
        if (this.anInt808 == 0 || this.anInt808 == 1 || this.anInt808 == 2 || this.anInt808 == 3 || this.anInt808 == 4 || this.anInt808 == 5 || this.anInt808 == 7 || this.anInt808 == 8 || this.anInt808 == 9 || this.anInt808 == 10 || this.anInt808 == 11 || this.anInt808 == 12 || this.anInt808 == 14 || this.anInt808 == 15 || this.anInt808 == 16 || this.anInt808 == 18) {
            this.aDouble813 = this.aDouble809;
            this.aDouble814 = this.aDouble810;
            this.aDouble809 += this.aDouble811;
            this.aDouble810 += this.aDouble812;
            this.aDouble812 += 0.007D * aDoubleArray802[this.anInt808];
            double var5;
            if (aBooleanArray803[this.anInt808] && !this.aBoolean821 && this.aDouble812 > 0.0D) {
                var5 = this.method1032(var4);
                if (var5 >= 0.0D) {
                    this.aClientSettings_806.aSoundManager_770.method976(var5);
                }

                this.aBoolean821 = true;
            }

            if (this.anInt808 != 3) {
                this.aDouble811 += 1.5E-5D * (double) var4;
            }

            this.aDouble811 *= 0.9985D;
            this.aDouble812 *= 0.9985D;
            double var7;
            if (this.anInt808 == 16 && this.anInt817 == 1) {
                var5 = (double) this.anInt815 - this.aDouble809;
                var7 = (double) this.anInt816 - this.aDouble810;
                double var9 = Math.sqrt(var5 * var5 + var7 * var7);
                if (var9 > 10.0D) {
                    var9 = 3.25D / var9;
                    this.aDouble811 = var5 * var9;
                    this.aDouble812 = var7 * var9;
                } else {
                    this.anInt817 = 0;
                }
            }

            int var12;
            if ((this.anInt808 == 8 || this.anInt808 == 9) && this.aDouble812 > 0.0D) {
                int var16 = this.anInt808 == 8 ? 5 : 7;
                var12 = 2;
                var7 = 0.0D;

                for (int var13 = 0; var13 < var16; ++var13) {
                    if (var13 <= 4) {
                        var7 = this.aDouble811 - 0.6D + (double) var13 * 0.3D;
                    } else if (var13 == 5) {
                        var7 = this.aDouble811 - 0.9D;
                    } else if (var13 == 6) {
                        var7 = this.aDouble811 + 0.9D;
                    }

                    if (this.anInt808 == 8) {
                        var12 = var1.method991(0, 1) == 0 ? 1 : 2;
                    }

                    this.aSPanel__807.method2365(var2, var12, this.aDouble809, this.aDouble810, var7, this.aDouble812, 0, this.anInt819);
                }

                return false;
            }

            if (this.anInt808 == 10) {
                boolean var11 = false;
                var12 = (int) (this.aDouble809 + this.aDouble811 * 35.0D + 0.5D);
                int var14 = (int) (this.aDouble810 + this.aDouble812 * 35.0D + 0.5D);
                if (var12 >= 0 && var12 < 760 && var14 >= 0 && var14 < 400 && this.aSPanel__807.method2370(var12, var14)) {
                    var11 = true;
                }

                if (!var11) {
                    var12 = (int) (this.aDouble809 + this.aDouble811 + 0.5D);
                    var14 = (int) (this.aDouble810 + this.aDouble812 + 0.5D);
                    if (var12 >= 0 && var12 < 760 && var14 >= 0 && var14 < 400 && this.aSPanel__807.method2370(var12, var14)) {
                        var11 = true;
                    }
                }

                if (var11) {
                    for (int var15 = 0; var15 < 9; ++var15) {
                        this.aSPanel__807.method2365(var2, 18, this.aDouble809, this.aDouble810, this.aDouble811 - 0.5D + (double) var15 * 0.25D, this.aDouble812, var1.method991(500, 600), this.anInt819);
                    }

                    return false;
                }
            }

            if (this.anInt808 == 4 && this.aDouble812 >= 0.0D) {
                this.anInt808 = 16;
                this.anInt817 = 1;
            }
        }

        if (this.anInt808 == 13) {
            if (this.aDouble812 < 0.0D) {
                this.aDouble810 += this.aDouble812;
                this.aDouble812 -= 0.0015D;
                if (this.aDouble810 < -500.0D) {
                    this.aDouble809 = (double) this.anInt815;
                    this.aDouble812 = 3.5D;
                }
            } else {
                this.aDouble810 += this.aDouble812;
            }
        }

        if (this.anInt808 == 18) {
            --this.anInt817;
            if (this.anInt817 == 0) {
                this.aSPanel__807.method2366(var3, 4, 1.0D, (int) (this.aDouble809 + 0.5D), (int) (this.aDouble810 + 0.5D), 2, 0, 0, this.anInt819, false);
                return false;
            }
        }

        return true;
    }

    protected boolean method1031(Class3 var1, LinkedList var2, LinkedList var3, boolean var4) {
        --this.anInt818;
        boolean var5 = false;
        int var6 = (int) (this.aDouble809 + 0.5D);
        int var7 = (int) (this.aDouble810 + 0.5D);
        if (var6 >= 1 && var6 < 759 && var7 < 399) {
            int var8;
            if (this.anInt808 == 6) {
                var7 += 2;
                if (!this.aSPanel__807.method2370(var6, var7 + 1)) {
                    ++var7;
                } else {
                    var6 += (int) this.aDouble811;
                    var5 = true;

                    for (var8 = 1; var8 < 5 && var5; ++var8) {
                        if (!this.aSPanel__807.method2370(var6, var7 + var8)) {
                            var7 += var8;
                            var5 = false;
                        }
                    }

                    for (var8 = 1; var8 < 5 && var5; ++var8) {
                        if (!this.aSPanel__807.method2370(var6, var7 - var8)) {
                            var7 -= var8;
                            var5 = false;
                        }
                    }
                }

                var7 -= 2;
                this.aDouble809 = (double) var6;
                this.aDouble810 = (double) var7;
            }

            boolean var20;
            if (this.anInt808 == 17) {
                var7 += 2;
                if (this.aSPanel__807.method2370(var6 - 1, var7 + 1) && this.aSPanel__807.method2370(var6, var7 + 1) && this.aSPanel__807.method2370(var6 + 1, var7 + 1)) {
                    if (!this.aSPanel__807.method2370(var6 - 1, var7) && this.aDouble811 < 0.0D) {
                        --var6;
                    } else if (!this.aSPanel__807.method2370(var6 + 1, var7) && this.aDouble811 > 0.0D) {
                        ++var6;
                    } else {
                        var5 = true;
                    }
                } else {
                    ++var7;
                    if (this.aSPanel__807.method2370(var6, var7)) {
                        var20 = false;
                        if (!this.aSPanel__807.method2370(var6 - 1, var7) && !this.aSPanel__807.method2370(var6 + 1, var7)) {
                            var8 = var1.method991(0, 1) * 2 - 1;
                        } else {
                            var8 = !this.aSPanel__807.method2370(var6 - 1, var7) ? -1 : 1;
                        }

                        var6 += var8;
                        this.aDouble811 = (double) var8;
                    }
                }

                var7 -= 2;
                this.aDouble809 = (double) var6;
                this.aDouble810 = (double) var7;
            }

            if (var6 >= 0 && var6 < 760 && var7 >= 0 && var7 < 400) {
                var20 = this.aSPanel__807.method2370(var6, var7) && this.anInt818 <= 0;
                int var9 = this.aSPanel__807.method2368(var6, var7);
                if (var9 >= 0) {
                    if (this.aBoolean820) {
                        var20 = true;
                    }
                } else {
                    this.aBoolean820 = true;
                }

                if (var20 || var5) {
                    int var10;
                    if (this.anInt808 == 5) {
                        this.anInt808 = 17;
                        var10 = (int) (this.aDouble809 - this.aDouble811 * 3.0D + 0.5D);
                        int var22 = (int) (this.aDouble810 - this.aDouble812 * 3.0D - 2.0D + 0.5D);
                        this.aDouble809 = (double) var10;

                        for (this.aDouble810 = (double) var22; !this.aSPanel__807.method2370(var10, var22); ++var22) {
                            ;
                        }

                        byte var23 = 0;
                        int var13 = 0;

                        do {
                            ++var13;
                            if (this.aDouble811 < 0.0D) {
                                if (!this.aSPanel__807.method2370(var10 - var13, var22)) {
                                    var23 = -1;
                                } else if (!this.aSPanel__807.method2370(var10 + var13, var22)) {
                                    var23 = 1;
                                }
                            } else if (!this.aSPanel__807.method2370(var10 + var13, var22)) {
                                var23 = 1;
                            } else if (!this.aSPanel__807.method2370(var10 - var13, var22)) {
                                var23 = -1;
                            }
                        } while (var23 == 0);

                        this.aDouble811 = (double) var23;
                        this.aDouble812 = 0.0D;
                        return true;
                    }

                    if (this.anInt808 == 7) {
                        this.aDouble810 -= 2.0D;
                        var10 = var1.method991(0, 99);
                        if (!var4 || var10 < anIntArray800[this.anInt808]) {
                            this.aSPanel__807.method2366(var3, anIntArray799[7], aDoubleArray801[7], var6, var7, 3, 0, 0, this.anInt819, false);
                        }

                        double var14 = 0.0D;
                        double var16 = 0.0D;

                        for (int var18 = 0; var18 < 5; ++var18) {
                            if (var18 == 0) {
                                var14 = 0.0D;
                                var16 = -1.0D;
                            }

                            if (var18 == 1) {
                                var14 = -0.2857142857142857D;
                                var16 = -0.8571428571428571D;
                            }

                            if (var18 == 2) {
                                var14 = 0.2857142857142857D;
                                var16 = -0.8571428571428571D;
                            }

                            if (var18 == 3) {
                                var14 = -0.5714285714285714D;
                                var16 = -0.5714285714285714D;
                            }

                            if (var18 == 4) {
                                var14 = 0.5714285714285714D;
                                var16 = -0.5714285714285714D;
                            }

                            int var19 = var1.method991(0, 1) == 0 ? 1 : 2;
                            this.aSPanel__807.method2365(var2, var19, this.aDouble809, this.aDouble810 - 1.0D, var14, var16, 0, this.anInt819);
                        }
                    } else {
                        if (this.anInt808 == 18) {
                            this.aDouble809 = this.aDouble813;
                            this.aDouble810 = this.aDouble814;
                            this.aDouble811 = this.aDouble812 = 0.0D;
                            if (var1.method991(0, 25) == 0) {
                                this.aSPanel__807.method2369(var2, var3, this.aDouble809, this.aDouble810, 5.0D, 1, this.anInt819);
                            }

                            return true;
                        }

                        byte var21 = -1;
                        byte var11 = 0;
                        if (this.anInt808 == 14) {
                            var21 = 0;
                        } else if (this.anInt808 == 15) {
                            var21 = 1;
                        }

                        if (this.anInt808 == 11) {
                            var11 = 1;
                        } else if (this.anInt808 == 12) {
                            var11 = 2;
                        }

                        int var12 = var1.method991(0, 99);
                        if (var4 && var12 >= anIntArray800[this.anInt808]) {
                            this.aClientSettings_806.aSoundManager_770.method979();
                        } else {
                            this.aSPanel__807.method2366(var3, anIntArray799[this.anInt808], aDoubleArray801[this.anInt808], var6, var7, 1, var21, var11, this.anInt819, true);
                        }
                    }

                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private double method1032(int var1) {
        int[] var2 = this.aSPanel__807.method2374();
        double var3 = Tools.getDistance((double) var2[0], (double) var2[1], this.aDouble809, this.aDouble810);
        boolean var5 = true;
        double var6 = this.aDouble809;
        double var8 = this.aDouble810;
        double var10 = this.aDouble811;
        double var12 = this.aDouble812;

        while (true) {
            var6 += var10;
            var8 += var12;
            var12 += 0.007D * aDoubleArray802[this.anInt808];
            if (this.anInt808 != 3) {
                var10 += 1.5E-5D * (double) var1;
            }

            var10 *= 0.9985D;
            var12 *= 0.9985D;
            double var14 = Tools.getDistance((double) var2[0], (double) var2[1], var6, var8);
            if (var14 > var3) {
                if (var5) {
                    return -1.0D;
                }

                return var3;
            }

            var5 = false;
            var3 = var14;
        }
    }

}
