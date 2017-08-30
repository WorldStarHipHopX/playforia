package com.aapeli.bigtext;

import com.aapeli.bigtext.MediumText;
import com.aapeli.client.ImageManager;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class BigText {

    public static final int ALIGN_LEFT = -1;
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_RIGHT = 1;
    public static final int VALIGN_TOP = -1;
    public static final int VALIGN_MIDDLE = 0;
    public static final int VALIGN_BOTTOM = 1;
    protected static final Color aColor1312;
    private static final String aString1313 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ 1234567890:!?/&Ü+-*%<>()ÁÉÑ\'\"¿¡ÍÓÚØ";
    protected static final int[] anIntArray1314;
    protected static final int anInt1315;
    private static ImageManager anImageManager1316;
    private static int[] anIntArray1317;
    private static int[] anIntArray1318;
    private boolean[] aBooleanArray1319;
    private int[] anIntArray1320;
    private Image anImage1321;
    private int anInt1322;
    private int anInt1323;
    private int anInt1324;
    public static boolean aBoolean1325;
    private static final String[] aStringArray1326 = new String[2];


    public static void initialize(ImageManager var0) {
        anImageManager1316 = var0;
        if (anIntArray1317 == null || anIntArray1318 == null) {
            Image var1 = var0.getShared("bigtext.gif");
            anIntArray1317 = var0.getPixels(var1);
            anIntArray1318 = new int[anInt1315];

            for (int var2 = 0; var2 < anInt1315 - 1; ++var2) {
                anIntArray1318[var2] = anIntArray1314[var2 + 1] - anIntArray1314[var2];
            }

            anIntArray1318[anInt1315 - 1] = 1432 - anIntArray1314[anInt1315 - 1];
            MediumText.method1559(anIntArray1317);
        }
    }

    public BigText(String var1) {
        this(var1, aColor1312, 255);
    }

    public BigText(String var1, Color var2) {
        this(var1, var2, 255);
    }

    public BigText(String var1, Color var2, int var3) {
        this(var1, var2, var3, anIntArray1317, anIntArray1318, 1, (Component) null);
    }

    public BigText(String var1, Color var2, int var3, Component var4) {
        this(var1, var2, var3, anIntArray1317, anIntArray1318, 1, var4);
    }

    protected BigText(String var1, Color var2, int var3, int[] var4, int[] var5, int var6, Component var7) {
        int var8 = var1.length();
        if (var8 != 0) {
            var1 = var1.toUpperCase();
            if (this.method1550(var1)) {
                this.method1551(var1, var2, var4, var5, var6);
            } else {
                this.method1554(var1, var2, var6, var7);
            }

            this.anInt1324 = -1;
            this.method1558(var3, var7);
        }
    }

    public void setAlpha(int var1) {
        this.method1558(var1, (Component) null);
    }

    public void drawText(Graphics var1, int var2, int var3, int var4, int var5) {
        this.drawText(var1, var2, var3, var4, var5, anImageManager1316.getApplet());
    }

    public void drawText(Graphics var1, int var2, int var3, int var4, int var5, ImageObserver var6) {
        if (this.anImage1321 != null) {
            if (var4 == 0) {
                var2 -= this.anInt1322 / 2;
            } else if (var4 == 1) {
                var2 -= this.anInt1322;
            }

            if (var5 == 0) {
                var3 -= this.anInt1323 / 2;
            } else if (var5 == 1) {
                var3 -= this.anInt1323;
            }

            var1.drawImage(this.anImage1321, var2, var3, var6);
        }
    }

    public int getWidth() {
        return this.anInt1322;
    }

    public int getHeight() {
        return this.anInt1323;
    }

    public Image getImage() {
        return this.anImage1321;
    }

    private boolean method1550(String var1) {
        int var2 = var1.length();

        for (int var3 = 0; var3 < var2; ++var3) {
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ 1234567890:!?/&Ü+-*%<>()ÁÉÑ\'\"¿¡ÍÓÚØ".indexOf(var1.charAt(var3)) == -1) {
                return false;
            }
        }

        return true;
    }

    private void method1551(String var1, Color var2, int[] var3, int[] var4, int var5) {
        int var6 = var1.length();
        int[] var7 = new int[var6];
        int[] var8 = new int[var6];
        this.anInt1322 = 0;

        for (int var10 = 0; var10 < var6; ++var10) {
            int var9 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ 1234567890:!?/&Ü+-*%<>()ÁÉÑ\'\"¿¡ÍÓÚØ".indexOf(var1.charAt(var10));
            var7[var10] = anIntArray1314[var9] / var5;
            var8[var10] = var4[var9];
            this.anInt1322 += var8[var10];
        }

        this.anInt1323 = 50 / var5;
        this.aBooleanArray1319 = new boolean[this.anInt1322 * this.anInt1323];
        this.anIntArray1320 = new int[this.anInt1322 * this.anInt1323];
        double var18 = (double) var2.getRed() / 255.0D;
        double var12 = (double) var2.getGreen() / 255.0D;
        double var14 = (double) var2.getBlue() / 255.0D;
        int var16 = 0;

        for (int var17 = 0; var17 < var6; ++var17) {
            this.method1552(var7[var17], var7[var17] + var8[var17], var16, var18, var12, var14, var3, var5);
            var16 += var8[var17];
        }

    }

    private void method1552(int var1, int var2, int var3, double var4, double var6, double var8, int[] var10, int var11) {
        int var14 = var1;

        for (int var15 = var3; var14 < var2; ++var15) {
            for (int var16 = 0; var16 < 50 / var11; ++var16) {
                int var12 = var10[var16 * 1432 / var11 + var14];
                int var13 = (int) (((long) var12 & 4278190080L) >> 24);
                this.aBooleanArray1319[var16 * this.anInt1322 + var15] = var13 > 0;
                this.anIntArray1320[var16 * this.anInt1322 + var15] = this.method1553(var12, var13, var4, var6, var8);
            }

            ++var14;
        }

    }

    private int method1553(int var1, int var2, double var3, double var5, double var7) {
        return (var2 << 24) + ((int) ((double) ((var1 & 16711680) >> 16) * var3) << 16) + ((int) ((double) ((var1 & '\uff00') >> 8) * var5) << 8) + (int) ((double) (var1 & 255) * var7);
    }

    private void method1554(String var1, Color var2, int var3, Component var4) {
        this.anInt1323 = 50 / var3;
        Font var5 = new Font("Dialog", 1, this.anInt1323 * 6 / 8);
        Applet var6 = anImageManager1316.getApplet();
        this.anInt1322 = var6.getFontMetrics(var5).stringWidth(var1) + 2;
        Image var7 = null;
        if (var4 != null) {
            var7 = var4.createImage(this.anInt1322, this.anInt1323);
        }

        if (var7 == null) {
            var7 = var6.createImage(this.anInt1322, this.anInt1323);
        }

        Graphics var8 = var7.getGraphics();
        var8.setColor(Color.black);
        var8.fillRect(0, 0, this.anInt1322, this.anInt1323);
        var8.setFont(var5);
        var8.setColor(Color.white);
        var8.drawString(var1, 1, this.anInt1323 * 13 / 16);
        this.anIntArray1320 = anImageManager1316.getPixels(var7);
        int var9 = this.anInt1322 * this.anInt1323;
        this.aBooleanArray1319 = new boolean[var9];

        int var10;
        for (var10 = 0; var10 < var9; ++var10) {
            this.aBooleanArray1319[var10] = (this.anIntArray1320[var10] & 255) > 0;
        }

        int var12;
        for (var12 = 0; var12 < this.anInt1323; ++var12) {
            for (int var13 = 0; var13 < this.anInt1322; ++var13) {
                var10 = var12 * this.anInt1322 + var13;
                int var11 = -1;
                if (this.aBooleanArray1319[var10]) {
                    var11 = 255 - var12 * (var3 == 1 ? 3 : 5);
                } else if (this.method1555(var13, var12)) {
                    var11 = 64;
                }

                if (var11 >= 0) {
                    this.anIntArray1320[var10] = -16777216 + (var11 << 16) + (var11 << 8) + var11;
                }
            }
        }

        for (var12 = 0; var12 < var9; ++var12) {
            this.aBooleanArray1319[var12] = (this.anIntArray1320[var12] & 255) > 0;
        }

        double var18 = (double) var2.getRed() / 255.0D;
        double var14 = (double) var2.getGreen() / 255.0D;
        double var16 = (double) var2.getBlue() / 255.0D;
        this.method1557(var18, var14, var16);
    }

    private boolean method1555(int var1, int var2) {
        return this.method1556(var1 - 1, var2 - 2) ? true : (this.method1556(var1, var2 - 2) ? true : (this.method1556(var1 + 1, var2 - 2) ? true : (this.method1556(var1 - 2, var2 - 1) ? true : (this.method1556(var1 - 1, var2 - 1) ? true : (this.method1556(var1, var2 - 1) ? true : (this.method1556(var1 + 1, var2 - 1) ? true : (this.method1556(var1 + 2, var2 - 1) ? true : (this.method1556(var1 - 2, var2) ? true : (this.method1556(var1 - 1, var2) ? true : (this.method1556(var1 + 1, var2) ? true : (this.method1556(var1 + 2, var2) ? true : (this.method1556(var1 - 2, var2 + 1) ? true : (this.method1556(var1 - 1, var2 + 1) ? true : (this.method1556(var1, var2 + 1) ? true : (this.method1556(var1 + 1, var2 + 1) ? true : (this.method1556(var1 + 2, var2 + 1) ? true : (this.method1556(var1 - 1, var2 + 2) ? true : (this.method1556(var1, var2 + 2) ? true : this.method1556(var1 + 1, var2 + 2)))))))))))))))))));
    }

    private boolean method1556(int var1, int var2) {
        return var1 >= 0 && var1 < this.anInt1322 && var2 >= 0 && var2 < this.anInt1323 ? this.aBooleanArray1319[var2 * this.anInt1322 + var1] : false;
    }

    private void method1557(double var1, double var3, double var5) {
        int var7 = this.anInt1322 * this.anInt1323;

        for (int var10 = 0; var10 < var7; ++var10) {
            int var8 = this.anIntArray1320[var10];
            int var9 = (int) (((long) var8 & 4278190080L) >> 24);
            this.anIntArray1320[var10] = this.method1553(var8, var9, var1, var3, var5);
        }

    }

    private void method1558(int var1, Component var2) {
        if (this.anIntArray1320 != null) {
            if (var1 < 0) {
                var1 = 0;
            } else if (var1 > 255) {
                var1 = 255;
            }

            if (var1 != this.anInt1324) {
                this.anInt1324 = var1;
                long var3 = (long) var1 << 24;
                int var5 = this.anIntArray1320.length;

                for (int var6 = 0; var6 < var5; ++var6) {
                    this.anIntArray1320[var6] = (int) ((this.aBooleanArray1319[var6] ? var3 : 0L) + ((long) this.anIntArray1320[var6] & 16777215L));
                }

                this.anImage1321 = anImageManager1316.createImage(this.anIntArray1320, this.anInt1322, this.anInt1323, var2);
            }
        }
    }

    static {
        aStringArray1326[0] = "bigtext.gif";
        aStringArray1326[1] = "Dialog";
        aColor1312 = Color.white;
        anIntArray1314 = new int[]{0, 23, 47, 71, 95, 116, 136, 160, 183, 195, 219, 243, 264, 299, 323, 347, 370, 394, 418, 442, 465, 489, 513, 542, 566, 590, 614, 637, 661, 685, 700, 714, 736, 756, 777, 798, 819, 839, 859, 881, 901, 913, 924, 949, 972, 1002, 1027, 1051, 1071, 1097, 1126, 1149, 1172, 1186, 1200, 1225, 1246, 1270, 1281, 1303, 1328, 1339, 1354, 1378, 1402};
        anInt1315 = anIntArray1314.length;
    }
}
