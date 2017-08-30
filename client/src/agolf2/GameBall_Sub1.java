package agolf2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class GameBall_Sub1 extends GameBall {

    private static final int[] anIntArray3550 = new int[]{7, 9, 5};
    private static final int[] anIntArray3551 = new int[]{16777215, 16777215, 553648127, 822083583, 553648127, 16777215, 16777215, 16777215, 822083583, 1358954495, 1627389951, 1358954495, 822083583, 16777215, 553648127, 1358954495, -2130706433, -1593835521, -2130706433, 1358954495, 553648127, 822083583, 1627389951, -1593835521, -1056964609, -1593835521, 1627389951, 822083583, 553648127, 1358954495, -2130706433, -1593835521, -2130706433, 1358954495, 553648127, 16777215, 822083583, 1358954495, 1627389951, 1358954495, 822083583, 16777215, 16777215, 16777215, 553648127, 822083583, 553648127, 16777215, 16777215};
    private static final int[] anIntArray3552 = new int[]{16777215, 16777215, 16777215, 553648127, 553648127, 553648127, 16777215, 16777215, 16777215, 16777215, 285212671, 553648127, 1090519039, 1358954495, 1090519039, 553648127, 285212671, 16777215, 16777215, 553648127, 1358954495, 1895825407, -2130706433, 1895825407, 1358954495, 553648127, 16777215, 553648127, 1090519039, 1895825407, -1593835521, -1056964609, -1593835521, 1895825407, 1090519039, 553648127, 553648127, 1358954495, -2130706433, -1056964609, -251658241, -1056964609, -2130706433, 1358954495, 553648127, 553648127, 1090519039, 1895825407, -1593835521, -1056964609, -1593835521, 1895825407, 1090519039, 553648127, 16777215, 553648127, 1358954495, 1895825407, -2130706433, 1895825407, 1358954495, 553648127, 16777215, 16777215, 285212671, 553648127, 1090519039, 1358954495, 1090519039, 553648127, 285212671, 16777215, 16777215, 16777215, 16777215, 553648127, 553648127, 553648127, 16777215, 16777215, 16777215};
    private static final int[] anIntArray3553 = new int[]{16777215, 285212671, 822083583, 285212671, 16777215, 285212671, 1358954495, 1627389951, 1358954495, 285212671, 822083583, 1627389951, -1862270977, 1627389951, 822083583, 285212671, 1358954495, 1627389951, 1358954495, 285212671, 16777215, 285212671, 822083583, 285212671, 16777215};
    private static Image[] anImageArray3554;
    private static Image[] anImageArray3555;
    private TrackOverlays aTrackOverlays_3556;
    private Image[] anImageArray3557;
    private int anInt3558;
    private int anInt3559;
    private int anInt3560;
    private int anInt3561;
    private int anInt3562;
    private int anInt3563;
    private int anInt3564;
    private int anInt3565;


    protected GameBall_Sub1(Class43_Sub1 var1, int var2, int var3, TrackOverlays var4) {
        super(var1, var2, var3);
        this.aTrackOverlays_3556 = var4;
    }

    protected void method1280(int var1, int var2) {
        if (anImageArray3554 == null) {
            anImageArray3554 = new Image[3];
            anImageArray3554[0] = this.aTrackOverlays_3556.method1232(anIntArray3551, anIntArray3550[0], anIntArray3550[0]);
            anImageArray3554[1] = this.aTrackOverlays_3556.method1232(anIntArray3552, anIntArray3550[1], anIntArray3550[1]);
            anImageArray3554[2] = this.aTrackOverlays_3556.method1232(anIntArray3553, anIntArray3550[2], anIntArray3550[2]);
        }

        this.anImageArray3557 = this.aTrackOverlays_3556.getImagesBalls(this.anInt1031);
        this.anInt3558 = var1;
        this.anInt3559 = var2;
        this.method1284();
    }

    protected void method1281(Graphics var1, Image var2, Class54 var3) {
        int var4 = this.anInt3560 + this.anInt3562;
        int var5 = this.anInt3561 + this.anInt3562;
        var1.drawImage(var2, this.anInt3560, this.anInt3561, var4, var5, this.anInt3560, this.anInt3561, var4, var5, (ImageObserver) null);
        var3.method1417(this.anInt3560, this.anInt3561, var4, var5);
    }

    protected void method1282(Graphics var1, Class54 var2, boolean var3, boolean var4) {
        this.method1283(var1, var2, var3, var4, true);
        this.method1283(var1, var2, var3, var4, false);
    }

    protected void method1283(Graphics var1, Class54 var2, boolean var3, boolean var4, boolean var5) {
        if (this.aBoolean1070 && this.anImageArray3557 != null) {
            boolean var6 = this.anInt1057 >= 0 || this.aBoolean1069;
            boolean var7 = this.anInt1058 >= 0;
            if (!var6 && !var7) {
                if (var5) {
                    return;
                }
            } else if (!var5) {
                return;
            }

            this.anInt3565 = -1;
            double var11;
            if (this.anInt1062 >= 0) {
                var1.setColor(Color.WHITE);

                for (int var8 = 0; var8 < 10; ++var8) {
                    double var9 = Math.random() * 9.0D;
                    var11 = Math.random() * 18.0D;
                    if (!var4) {
                        var1.drawLine((int) (this.locationX + var9 + 0.5D), (int) (this.locationY - 9.0D + var11 + 0.5D), (int) (this.locationX - var9 + 0.5D), (int) (this.locationY + 9.0D - var11 + 0.5D));
                    }
                }

                this.anInt3560 = (int) (this.locationX - 11.0D);
                this.anInt3561 = (int) (this.locationY - 11.0D);
                this.anInt3562 = 22;
            } else {
                boolean var13 = this.anInt1060 >= 0;
                boolean var14 = this.aBoolean1054;
                if (!var6 && !var7 && !var13 && !var14) {
                    this.anInt3560 = (int) (this.locationX - (double) anIntArray1017[this.anInt1048] * 0.5D + 0.5D);
                    this.anInt3561 = (int) (this.locationY - (double) anIntArray1017[this.anInt1048] * 0.5D + 0.5D);
                    this.anInt3562 = anIntArray1017[this.anInt1048];
                    this.anInt3563 = this.anInt3560;
                    this.anInt3564 = this.anInt3561;
                    this.anInt3565 = this.anInt1048;
                    if (!var4) {
                        if (var3) {
                            this.method1286(var1, anIntArray1017[this.anInt1048]);
                        }

                        var1.drawImage(this.anImageArray3557[this.anInt1048], this.anInt3560, this.anInt3561, (ImageObserver) null);
                        if (var3) {
                            this.method1287(var1, anIntArray1017[this.anInt1048]);
                        }
                    }
                } else {
                    if (var6) {
                        if (this.aBoolean1069) {
                            this.anInt3562 = anIntArray1017[this.anInt1048] / 2;
                        } else {
                            this.anInt3562 = (int) ((double) anIntArray1017[this.anInt1048] * (1.0D - 0.5D * (double) this.anInt1057 / 500.0D));
                        }
                    } else if (var7) {
                        int var15 = this.method1268() ? 500 : 1200;
                        this.anInt3562 = (int) ((double) anIntArray1017[this.anInt1048] * (1.0D - 1.0D * (double) this.anInt1058 / (double) var15));
                        if (this.anInt3562 < 1) {
                            this.anInt3562 = 1;
                        }
                    } else if (var13) {
                        var11 = 0.5D + 0.5D * (double) this.anInt1061 / (double) anIntArray1029[this.anInt1048];
                        this.anInt3562 = (int) ((double) anIntArray1017[this.anInt1048] + (double) anIntArray1017[this.anInt1048] * var11 * Math.sin(3.141592653589793D * (double) this.anInt1060 / (double) this.anInt1061));
                    } else {
                        this.anInt3562 = anIntArray1017[this.anInt1048] + 2;
                    }

                    this.anInt3560 = (int) (this.locationX - (double) this.anInt3562 * 0.5D + 0.5D);
                    this.anInt3561 = (int) (this.locationY - (double) this.anInt3562 * 0.5D + 0.5D);
                    if (!var4) {
                        if (var3 && this.anInt3562 >= anIntArray1017[this.anInt1048]) {
                            this.method1286(var1, this.anInt3562);
                        }

                        var1.drawImage(this.anImageArray3557[this.anInt1048], this.anInt3560, this.anInt3561, this.anInt3560 + this.anInt3562, this.anInt3561 + this.anInt3562, 0, 0, anIntArray1017[this.anInt1048], anIntArray1017[this.anInt1048], (ImageObserver) null);
                        if (var3) {
                            this.method1287(var1, this.anInt3562);
                        }
                    }
                }

                if (var3) {
                    this.anInt3560 -= this.anInt3562 / 2;
                    this.anInt3561 -= this.anInt3562 / 2;
                    this.anInt3562 *= 2;
                }
            }

            if (var2 != null) {
                var2.method1417(this.anInt3560, this.anInt3561, this.anInt3560 + this.anInt3562, this.anInt3561 + this.anInt3562);
            }

        }
    }

    private void method1284() {
        anImageArray3555 = new Image[3];

        for (int var1 = 0; var1 < 3; ++var1) {
            anImageArray3555[var1] = this.method1285(var1);
        }

    }

    private Image method1285(int var1) {
        int[] var2 = this.aTrackOverlays_3556.method1231(this.anImageArray3557[var1], anIntArray1017[var1], anIntArray1017[var1]);
        int[] var3 = new int[anIntArray1017[var1] * anIntArray1017[var1]];

        for (int var4 = 0; var4 < anIntArray1017[var1]; ++var4) {
            for (int var5 = 0; var5 < anIntArray1017[var1]; ++var5) {
                var3[var4 * anIntArray1017[var1] + var5] = ((long) var2[var4 * anIntArray1017[var1] + var5] & 4278190080L) != 0L ? 855638016 : 0;
            }
        }

        return this.aTrackOverlays_3556.method1232(var3, anIntArray1017[var1], anIntArray1017[var1]);
    }

    protected void method1286(Graphics var1, int var2) {
        double var3 = 2.0D * (double) var2 * 0.25D / Class50.aDouble1141;
        double var5 = ((double) this.anInt3558 - this.locationX) * var3;
        double var7 = ((double) this.anInt3559 - this.locationY) * var3;
        int var9 = (int) (this.locationX - var5 - (double) var2 * 0.5D + 0.5D);
        int var10 = (int) (this.locationY - var7 - (double) var2 * 0.5D + 0.5D);
        var1.drawImage(anImageArray3555[this.anInt1048], var9, var10, (ImageObserver) null);
    }

    private void method1287(Graphics var1, int var2) {
        double var3 = (double) var2 * 0.25D / Class50.aDouble1141;
        double var5 = ((double) this.anInt3558 - this.locationX) * var3;
        double var7 = ((double) this.anInt3559 - this.locationY) * var3;
        int var9 = (int) (this.locationX + var5 - (double) anIntArray3550[this.anInt1048] * 0.5D + 0.5D);
        int var10 = (int) (this.locationY + var7 - (double) anIntArray3550[this.anInt1048] * 0.5D + 0.5D);
        var1.drawImage(anImageArray3554[this.anInt1048], var9, var10, (ImageObserver) null);
    }

}
