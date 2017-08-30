package com.playray.bigtext;

import com.playray.client.ImageManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.JApplet;

public class BigText {

    public static final int ALIGN_LEFT = -1;
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_RIGHT = 1;
    public static final int VALIGN_TOP = -1;
    public static final int VALIGN_MIDDLE = 0;
    public static final int VALIGN_BOTTOM = 1;
    protected static final Color aColor1757 = Color.white;
    public static final int IMAGE_WIDTH = 1432;
    public static final int IMAGE_HEIGHT = 50;
    private static final String aString1758 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ 1234567890:!?/&Ü+-*%<>()ÁÉÑ\'\"¿¡ÍÓÚØ";
    protected static final int[] anIntArray1759 = new int[]{0, 23, 47, 71, 95, 116, 136, 160, 183, 195, 219, 243, 264, 299, 323, 347, 370, 394, 418, 442, 465, 489, 513, 542, 566, 590, 614, 637, 661, 685, 700, 714, 736, 756, 777, 798, 819, 839, 859, 881, 901, 913, 924, 949, 972, 1002, 1027, 1051, 1071, 1097, 1126, 1149, 1172, 1186, 1200, 1225, 1246, 1270, 1281, 1303, 1328, 1339, 1354, 1378, 1402};
    protected static final int anInt1760 = anIntArray1759.length;
    private ImageManager anImageManager1761;
    private String aString1762;
    private boolean[] aBooleanArray1763;
    private int[] anIntArray1764;
    private Image anImage1765;
    private int anInt1766;
    private int anInt1767;
    private int anInt1768;
    public static boolean aBoolean1769;
    private static final String aString1770 = "Dialog";


    protected BigText(ImageManager var1) {
        this.anImageManager1761 = var1;
    }

    public BigText(ImageManager var1, String var2) {
        this(var1);
        this.method1886(var2, aColor1757, 255);
    }

    public BigText(ImageManager var1, String var2, Color var3) {
        this(var1);
        this.method1886(var2, var3, 255);
    }

    public BigText(ImageManager var1, String var2, Color var3, int var4) {
        this(var1);
        this.method1886(var2, var3, var4);
    }

    protected void method1885(String var1, Color var2, int var3, int[] var4, int[] var5, int var6) {
        this.aString1762 = var1;
        int var7 = var1.length();
        if (var7 != 0) {
            var1 = var1.toUpperCase();
            if (var4 != null && this.method1887(var1)) {
                this.method1888(var1, var2, var4, var5, var6);
            } else {
                this.method1891(var1, var2, var6);
            }

            this.anInt1768 = -1;
            this.setAlpha(var3);
        }
    }

    public void setAlpha(int var1) {
        if (this.anIntArray1764 != null) {
            if (var1 < 0) {
                var1 = 0;
            } else if (var1 > 255) {
                var1 = 255;
            }

            if (var1 != this.anInt1768) {
                this.anInt1768 = var1;
                long var2 = (long) var1 << 24;
                int var4 = this.anIntArray1764.length;

                for (int var5 = 0; var5 < var4; ++var5) {
                    this.anIntArray1764[var5] = (int) ((this.aBooleanArray1763[var5] ? var2 : 0L) + ((long) this.anIntArray1764[var5] & 16777215L));
                }

                this.anImage1765 = this.anImageManager1761.createImage(this.anIntArray1764, this.anInt1766, this.anInt1767);
            }
        }
    }

    public void drawText(Graphics var1, int var2, int var3, int var4, int var5) {
        this.drawText(var1, var2, var3, var4, var5, this.anImageManager1761.getApplet());
    }

    public void drawText(Graphics var1, int var2, int var3, int var4, int var5, ImageObserver var6) {
        if (this.anImage1765 != null) {
            if (var4 == 0) {
                var2 -= this.anInt1766 / 2;
            } else if (var4 == 1) {
                var2 -= this.anInt1766;
            }

            if (var5 == 0) {
                var3 -= this.anInt1767 / 2;
            } else if (var5 == 1) {
                var3 -= this.anInt1767;
            }

            var1.drawImage(this.anImage1765, var2, var3, var6);
        }
    }

    public int getWidth() {
        return this.anInt1766;
    }

    public int getHeight() {
        return this.anInt1767;
    }

    public Image getImage() {
        return this.anImage1765;
    }

    public String getOriginalText() {
        return this.aString1762;
    }

    private void method1886(String var1, Color var2, int var3) {
        int[] var4 = this.anImageManager1761.getBigTextPixels();
        int[] var5 = new int[anInt1760];

        for (int var6 = 0; var6 < anInt1760 - 1; ++var6) {
            var5[var6] = anIntArray1759[var6 + 1] - anIntArray1759[var6];
        }

        var5[anInt1760 - 1] = 1432 - anIntArray1759[anInt1760 - 1];
        this.method1885(var1, var2, var3, var4, var5, 1);
    }

    private boolean method1887(String var1) {
        int var2 = var1.length();

        for (int var3 = 0; var3 < var2; ++var3) {
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ 1234567890:!?/&Ü+-*%<>()ÁÉÑ\'\"¿¡ÍÓÚØ".indexOf(var1.charAt(var3)) == -1) {
                return false;
            }
        }

        return true;
    }

    private void method1888(String var1, Color var2, int[] var3, int[] var4, int var5) {
        int var6 = var1.length();
        int[] var7 = new int[var6];
        int[] var8 = new int[var6];
        this.anInt1766 = 0;

        for (int var10 = 0; var10 < var6; ++var10) {
            int var9 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ 1234567890:!?/&Ü+-*%<>()ÁÉÑ\'\"¿¡ÍÓÚØ".indexOf(var1.charAt(var10));
            var7[var10] = anIntArray1759[var9] / var5;
            var8[var10] = var4[var9];
            this.anInt1766 += var8[var10];
        }

        this.anInt1767 = 50 / var5;
        this.aBooleanArray1763 = new boolean[this.anInt1766 * this.anInt1767];
        this.anIntArray1764 = new int[this.anInt1766 * this.anInt1767];
        double var18 = (double) var2.getRed() / 255.0D;
        double var12 = (double) var2.getGreen() / 255.0D;
        double var14 = (double) var2.getBlue() / 255.0D;
        int var16 = 0;

        for (int var17 = 0; var17 < var6; ++var17) {
            this.method1889(var7[var17], var7[var17] + var8[var17], var16, var18, var12, var14, var3, var5);
            var16 += var8[var17];
        }

    }

    private void method1889(int var1, int var2, int var3, double var4, double var6, double var8, int[] var10, int var11) {
        int var14 = var1;

        for (int var15 = var3; var14 < var2; ++var15) {
            for (int var16 = 0; var16 < 50 / var11; ++var16) {
                int var12 = var10[var16 * 1432 / var11 + var14];
                int var13 = (int) (((long) var12 & 4278190080L) >> 24);
                this.aBooleanArray1763[var16 * this.anInt1766 + var15] = var13 > 0;
                this.anIntArray1764[var16 * this.anInt1766 + var15] = this.method1890(var12, var13, var4, var6, var8);
            }

            ++var14;
        }

    }

    private int method1890(int var1, int var2, double var3, double var5, double var7) {
        return (var2 << 24) + ((int) ((double) ((var1 & 16711680) >> 16) * var3) << 16) + ((int) ((double) ((var1 & '\uff00') >> 8) * var5) << 8) + (int) ((double) (var1 & 255) * var7);
    }

    private void method1891(String var1, Color var2, int var3) {
        this.anInt1767 = 50 / var3;
        Font var4 = new Font("Dialog", 1, this.anInt1767 * 6 / 8);
        JApplet var5 = this.anImageManager1761.getApplet();
        this.anInt1766 = var5.getFontMetrics(var4).stringWidth(var1) + 2;
        Image var6 = var5.createImage(this.anInt1766, this.anInt1767);
        Graphics var7 = var6.getGraphics();
        var7.setColor(Color.black);
        var7.fillRect(0, 0, this.anInt1766, this.anInt1767);
        var7.setFont(var4);
        var7.setColor(Color.white);
        var7.drawString(var1, 1, this.anInt1767 * 13 / 16);
        this.anIntArray1764 = this.anImageManager1761.getPixels(var6);
        int var8 = this.anInt1766 * this.anInt1767;
        this.aBooleanArray1763 = new boolean[var8];

        int var9;
        for (var9 = 0; var9 < var8; ++var9) {
            this.aBooleanArray1763[var9] = (this.anIntArray1764[var9] & 255) > 0;
        }

        int var11;
        for (var11 = 0; var11 < this.anInt1767; ++var11) {
            for (int var12 = 0; var12 < this.anInt1766; ++var12) {
                var9 = var11 * this.anInt1766 + var12;
                int var10 = -1;
                if (this.aBooleanArray1763[var9]) {
                    var10 = 255 - var11 * (var3 == 1 ? 3 : 5);
                } else if (this.method1892(var12, var11)) {
                    var10 = 64;
                }

                if (var10 >= 0) {
                    this.anIntArray1764[var9] = -16777216 + (var10 << 16) + (var10 << 8) + var10;
                }
            }
        }

        for (var11 = 0; var11 < var8; ++var11) {
            this.aBooleanArray1763[var11] = (this.anIntArray1764[var11] & 255) > 0;
        }

        double var17 = (double) var2.getRed() / 255.0D;
        double var13 = (double) var2.getGreen() / 255.0D;
        double var15 = (double) var2.getBlue() / 255.0D;
        this.method1894(var17, var13, var15);
    }

    private boolean method1892(int var1, int var2) {
        return this.method1893(var1 - 1, var2 - 2) ? true : (this.method1893(var1, var2 - 2) ? true : (this.method1893(var1 + 1, var2 - 2) ? true : (this.method1893(var1 - 2, var2 - 1) ? true : (this.method1893(var1 - 1, var2 - 1) ? true : (this.method1893(var1, var2 - 1) ? true : (this.method1893(var1 + 1, var2 - 1) ? true : (this.method1893(var1 + 2, var2 - 1) ? true : (this.method1893(var1 - 2, var2) ? true : (this.method1893(var1 - 1, var2) ? true : (this.method1893(var1 + 1, var2) ? true : (this.method1893(var1 + 2, var2) ? true : (this.method1893(var1 - 2, var2 + 1) ? true : (this.method1893(var1 - 1, var2 + 1) ? true : (this.method1893(var1, var2 + 1) ? true : (this.method1893(var1 + 1, var2 + 1) ? true : (this.method1893(var1 + 2, var2 + 1) ? true : (this.method1893(var1 - 1, var2 + 2) ? true : (this.method1893(var1, var2 + 2) ? true : this.method1893(var1 + 1, var2 + 2)))))))))))))))))));
    }

    private boolean method1893(int var1, int var2) {
        return var1 >= 0 && var1 < this.anInt1766 && var2 >= 0 && var2 < this.anInt1767 ? this.aBooleanArray1763[var2 * this.anInt1766 + var1] : false;
    }

    private void method1894(double var1, double var3, double var5) {
        int var7 = this.anInt1766 * this.anInt1767;

        for (int var10 = 0; var10 < var7; ++var10) {
            int var8 = this.anIntArray1764[var10];
            int var9 = (int) (((long) var8 & 4278190080L) >> 24);
            this.anIntArray1764[var10] = this.method1890(var8, var9, var1, var3, var5);
        }

    }

}
