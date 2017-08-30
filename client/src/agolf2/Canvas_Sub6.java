package agolf2;

import com.aapeli.tools.Tools;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.Raster;

public abstract class Canvas_Sub6 extends Canvas {

    private static final double[] aDoubleArray101 = new double[]{0.875D, 0.0D, 0.125D, 0.75D, -1.0D, 0.25D, 0.625D, 0.5D, 0.375D};
    private Class52 aClass52_102;
    private boolean aBoolean103;
    private boolean aBoolean104;
    private boolean aBoolean105;
    private int anInt106;
    private int anInt107;
    protected BufferedImage aBufferedImage108;
    protected BufferedImage buffer;
    private Image image;
    private Graphics graphics;
    public static int anInt112;
    private static final String aString113 = "AGolf2: Track effects disabled due to unexpected exception or error that occured";


    protected Canvas_Sub6(Class52 var1, boolean var2, boolean var3, boolean var4) {
        this.aClass52_102 = var1;
        this.aBoolean103 = var2;
        this.aBoolean104 = var3;
        this.aBoolean105 = var4;
        if (var2) {
            int[] var5 = var1.method1407(390, 210);
            this.anInt106 = var5[0];
            this.anInt107 = var5[1];
        }

        this.setSize(780, 420);
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.image == null || this.graphics == null) {
            this.image = this.createImage(780, 420);
            this.graphics = this.image.getGraphics();
        }

        this.graphics.drawImage(this.buffer, 0, 0, (ImageObserver) null);
        this.method175(this.graphics);
        var1.drawImage(this.image, 0, 0, (ImageObserver) null);
    }

    protected void method165() {
        if (this.aBufferedImage108 == null) {
            this.aBufferedImage108 = new BufferedImage(780, 420, 1);
        }

        this.aClass52_102.method1393();
        Graphics var1 = this.aBufferedImage108.getGraphics();

        for (int var2 = 0; var2 < 28; ++var2) {
            for (int var3 = 0; var3 < 52; ++var3) {
                var1.drawImage(this.aClass52_102.method1394(var3, var2).method1208(this.aBoolean103, this.aBoolean105), var3 * 15, var2 * 15, (ImageObserver) null);
            }
        }

        this.method166(this.aBufferedImage108);
        this.method177();
    }

    protected void method166(BufferedImage var1) {
        this.method167(var1, 0, 0, 780, 420);
    }

    protected void method167(BufferedImage var1, int var2, int var3, int var4, int var5) {
    }

    protected double method168() {
        return 1.0D;
    }

    protected int[] method169(int var1, int var2) {
        if (var1 >= 0 && var2 >= 0) {
            var1 /= 15;
            var2 /= 15;
            return var1 < 52 && var2 < 28 ? new int[]{var1, var2} : null;
        } else {
            return null;
        }
    }

    public void method170() {
        this.method165();
        this.repaint();
    }

    public void method171(int var1, int var2) {
        this.method176(var1, var2);
        this.repaint(var1 * 15, var2 * 15, 15, 15);
    }

    protected void method172(boolean[][] var1) {
        Graphics var2 = this.aBufferedImage108.getGraphics();

        for (int var3 = 0; var3 < 28; ++var3) {
            for (int var4 = 0; var4 < 52; ++var4) {
                if (var1[var3][var4]) {
                    var2.drawImage(this.aClass52_102.method1394(var4, var3).method1208(this.aBoolean103, this.aBoolean105), var4 * 15, var3 * 15, (ImageObserver) null);
                    this.method167(this.aBufferedImage108, var4 * 15, var3 * 15, 15, 15);
                    this.method178(var4, var3);
                }
            }
        }

    }

    protected int[] method173() {
        return new int[]{this.anInt106, this.anInt107};
    }

    protected void method174() {
        this.aClass52_102 = null;
        this.buffer = null;
        this.aBufferedImage108 = null;
        this.image = null;
        Graphics var1 = this.graphics;
        if (var1 != null) {
            var1.dispose();
        }

        this.graphics = null;
    }

    protected abstract void method175(Graphics var1);

    private void method176(int var1, int var2) {
        if (this.aBufferedImage108 == null) {
            this.method165();
        } else {
            Graphics var3 = this.aBufferedImage108.getGraphics();
            var3.drawImage(this.aClass52_102.method1394(var1, var2).method1208(this.aBoolean103, this.aBoolean105), var1 * 15, var2 * 15, (ImageObserver) null);
            this.method166(this.aBufferedImage108);
            this.method177();
        }
    }

    private void method177() {
        if (!this.aBoolean104 && !this.aBoolean105) {
            this.buffer = this.aBufferedImage108;
        } else {
            try {
                if (this.buffer == null) {
                    this.buffer = new BufferedImage(780, 420, 1);
                }

                this.buffer.setData(this.aBufferedImage108.getData());
                if (this.aBoolean105) {
                    this.method185(0, 0, 780, 420);
                    this.method186(0, 0, 780, 420);
                    this.method187(0, 0, 780, 420);
                }

                if (this.aBoolean104) {
                    this.method180(0, 0, 780, 420);
                    this.method183(0, 0, 780, 420);
                }
            } catch (Exception var2) {
                this.method179();
            } catch (Error var3) {
                this.method179();
            }

        }
    }

    private void method178(int var1, int var2) {
        try {
            int var3 = (var1 - 1) * 15;
            int var4 = (var2 - 1) * 15;
            int var5 = (var1 + 2) * 15;
            int var6 = (var2 + 2) * 15;
            if (var3 < 0) {
                var3 = 0;
            }

            if (var4 < 0) {
                var4 = 0;
            }

            if (var5 >= 780) {
                var5 = 779;
            }

            if (var6 >= 420) {
                var6 = 419;
            }

            int var7 = var5 - var3;
            int var8 = var6 - var4;
            Raster var9 = this.aBufferedImage108.getData(new Rectangle(var3, var4, var7, var8));
            this.buffer.setData(var9);
            if (this.aBoolean104) {
                this.method180(var3, var4, var5, var6);
                this.method183(var3, var4, var5, var6);
            }

            if (this.aBoolean105) {
                this.method185(var3, var4, var5, var6);
                this.method186(var3, var4, var5, var6);
                this.method187(var3, var4, var5, var6);
            }
        } catch (Exception var10) {
            this.method179();
        } catch (Error var11) {
            this.method179();
        }

    }

    private void method179() {
        System.out.println("AGolf2: Track effects disabled due to unexpected exception or error that occured");
        this.aBoolean104 = this.aBoolean105 = false;
        this.buffer = this.aBufferedImage108;
    }

    private void method180(int var1, int var2, int var3, int var4) {
        for (int var5 = var2; var5 < var4; ++var5) {
            for (int var6 = var1; var6 < var3; ++var6) {
                Pixel var7 = this.aClass52_102.method1395(var6, var5);
                if (var7 != null && this.method182(var7)) {
                    this.method181(var6, var5, 1, 0, var7, 0.3D);
                    this.method181(var6, var5, 0, 1, var7, 0.3D);
                    this.method181(var6, var5, 1, 1, var7, 0.15D);
                    this.method181(var6, var5, -1, 1, var7, 0.15D);
                }
            }
        }

    }

    private void method181(int var1, int var2, int var3, int var4, Pixel var5, double var6) {
        Pixel var8 = this.aClass52_102.method1395(var1 + var3, var2 + var4);
        if (var8 != null) {
            if (this.method182(var8) && (var8.getElement() != var5.getElement() || var8.getSlope() != var5.getSlope())) {
                int var9 = this.buffer.getRGB(var1, var2);
                int var10 = this.buffer.getRGB(var1 + var3, var2 + var4);
                if (Math.random() < var6) {
                    this.buffer.setRGB(var1, var2, var10);
                }

                if (Math.random() < var6) {
                    this.buffer.setRGB(var1 + var3, var2 + var4, var9);
                }
            }

        }
    }

    private boolean method182(Pixel var1) {
        if (var1.getObject() != -1) {
            return false;
        } else {
            int var2 = var1.getElement();
            return var2 == 0 || var2 == 1 || var2 == 2 || var2 == 3 || var2 == 4 || var2 == 8 || var2 == 10;
        }
    }

    private void method183(int var1, int var2, int var3, int var4) {
        for (int var5 = var2; var5 < var4; ++var5) {
            for (int var6 = var1; var6 < var3; ++var6) {
                if (Math.random() < 0.1D) {
                    Pixel var7 = this.aClass52_102.method1395(var6, var5);
                    Pixel var8 = this.aClass52_102.method1395(var6, var5 + 1);
                    Pixel var9 = this.aClass52_102.method1395(var6 - 1, var5);
                    Pixel var10 = this.aClass52_102.method1395(var6 + 1, var5);
                    Pixel var11 = this.aClass52_102.method1395(var6 + 1, var5 + 1);
                    if (var7 != null && var8 != null && var9 != null && var10 != null && var11 != null) {
                        int var12 = var7.getElement();
                        int var13 = var8.getElement();
                        int var14 = var9.getElement();
                        int var15 = var10.getElement();
                        int var16 = var11.getElement();
                        int var17;
                        if (var12 == 0 && var13 == var12) {
                            var17 = Math.random() < 0.5D ? 1 : -1;
                            this.method192(var6, var5, 8 * var17);
                            this.method192(var6, var5 + 1, 8 * var17);
                        } else if (var12 == 4 && var14 == var12 && var15 == var12) {
                            if (this.method184(var7)) {
                                this.method192(var6, var5, 32);
                                this.method192(var6 - 1, var5, 32);
                                this.method192(var6 + 1, var5, 32);
                            }
                        } else if (var12 == 3 && var14 == var12 && var15 == var12) {
                            this.method192(var6, var5, 8);
                            this.method192(var6 - 1, var5, 8);
                            this.method192(var6 + 1, var5, 8);
                        } else if (var12 == 1 && var13 == var12 && var15 == var12 && var16 == var12) {
                            var17 = (int) (Math.random() * 4.0D);
                            if (var17 != 0) {
                                this.method192(var6, var5, 6);
                            }

                            if (var17 != 1) {
                                this.method192(var6, var5 + 1, 6);
                            }

                            if (var17 != 2) {
                                this.method192(var6 + 1, var5, 6);
                            }

                            if (var17 != 3) {
                                this.method192(var6 + 1, var5 + 1, 6);
                            }
                        } else if (var12 == 2) {
                            this.method192(var6, var5, -16);
                        } else if (var12 == 8) {
                            var17 = Math.random() < 0.75D ? 32 : 24;
                            this.method192(var6, var5, var17);
                        }
                    }
                }
            }
        }

    }

    private boolean method184(Pixel var1) {
        Block var2 = this.aClass52_102.method1394(var1.getBaseX(), var1.getBaseY());
        if (var2 instanceof BlockBasic) {
            return true;
        } else {
            int var3 = var2.method1206();
            return var3 != 1 && (var3 < 54 || var3 > 59) ? var3 != 42 && var3 != 43 : false;
        }
    }

    private void method185(int var1, int var2, int var3, int var4) {
        for (int var5 = var2; var5 < var4; ++var5) {
            for (int var6 = var1; var6 < var3; ++var6) {
                double var7 = 1.1D - 0.7D * Tools.getDistance((double) var6, (double) var5, (double) this.anInt106, (double) this.anInt107) / Class50.aDouble1141;
                this.method190(var6, var5, var7);
            }
        }

    }

    private void method186(int var1, int var2, int var3, int var4) {
        for (int var5 = var2; var5 < var4; ++var5) {
            for (int var6 = var1; var6 < var3; ++var6) {
                Pixel var7 = this.aClass52_102.method1395(var6, var5);
                if (var7.method1378() && Block.aBooleanArray1007[var7.getElement()]) {
                    double var8 = aDoubleArray101[var7.getSlope()];
                    double var10 = Class50.method1381((double) (this.anInt106 - var6), (double) (this.anInt107 - var5));
                    double var12 = 1.0D - Class50.method1382(var8, var10) * 4.0D;
                    double var14 = Tools.getDistance((double) var6, (double) var5, (double) this.anInt106, (double) this.anInt107);
                    if (var14 <= 5.0D) {
                        var12 *= 0.2D + var14 / 10.0D;
                    }

                    this.method191(var6, var5, var12, 48);
                }
            }
        }

    }

    private void method187(int var1, int var2, int var3, int var4) {
        for (int var5 = var2; var5 < var4; ++var5) {
            for (int var6 = var1; var6 < var3; ++var6) {
                Pixel var7 = this.aClass52_102.method1395(var6, var5);
                double var8 = 1.0D;
                double var10 = Tools.getDistance((double) var6, (double) var5, (double) this.anInt106, (double) this.anInt107);
                if (!var7.method1375()) {
                    int var12 = (int) (5.0D + 7.0D * var10 / Class50.aDouble1141 + 0.5D);
                    int var13 = this.method188(var6, var5, this.anInt106, this.anInt107, var12);
                    if (var13 > 0 && var13 <= var12) {
                        var8 = 0.8D + 0.15D * (double) (var13 - 1) / (double) var12;
                    }
                } else if (this.method189(var6, var5, this.anInt106, this.anInt107)) {
                    var8 = 1.3D - 0.3D * var10 / Class50.aDouble1141;
                }

                if (var8 != 1.0D) {
                    this.method190(var6, var5, var8);
                }
            }
        }

    }

    private int method188(int var1, int var2, int var3, int var4, int var5) {
        double var6 = (double) (var3 - var1);
        double var8 = (double) (var4 - var2);
        double var10 = Math.sqrt(var6 * var6 + var8 * var8);
        var6 /= var10;
        var8 /= var10;

        for (int var12 = 1; var12 <= var5; ++var12) {
            int var13 = (int) ((double) var1 + var6 * (double) var12 + 0.5D);
            int var14 = (int) ((double) var2 + var8 * (double) var12 + 0.5D);
            Pixel var15 = this.aClass52_102.method1395(var13, var14);
            if (var15 == null) {
                return -1;
            }

            if (var15.method1375()) {
                return var12;
            }
        }

        return -1;
    }

    private boolean method189(int var1, int var2, int var3, int var4) {
        int var5 = var1 == var3 ? 0 : (var1 < var3 ? 1 : -1);
        int var6 = var2 == var4 ? 0 : (var2 < var4 ? 1 : -1);
        Pixel var7 = this.aClass52_102.method1395(var1 + var5, var2 + var6);
        return var7 != null && !var7.method1375();
    }

    private void method190(int var1, int var2, double var3) {
        double var5 = this.method168();
        var3 = (var3 - 1.0D) * var5 + 1.0D;
        int var7 = this.buffer.getRGB(var1, var2);
        int var8 = (var7 & 16711680) >> 16;
        int var9 = (var7 & '\uff00') >> 8;
        int var10 = var7 & 255;
        var8 = Class50.method1384(var8, var3);
        var9 = Class50.method1384(var9, var3);
        var10 = Class50.method1384(var10, var3);
        var7 = (int) (4278190080L + (long) var8 * 256L * 256L + (long) var9 * 256L + (long) var10);
        this.buffer.setRGB(var1, var2, var7);
    }

    private void method191(int var1, int var2, double var3, int var5) {
        this.method192(var1, var2, (int) (var3 * (double) var5 + 0.5D));
    }

    private void method192(int var1, int var2, int var3) {
        double var4 = this.method168();
        var3 = (int) ((double) var3 * var4 + 0.5D);
        int var6 = this.buffer.getRGB(var1, var2);
        int var7 = (var6 & 16711680) >> 16;
        int var8 = (var6 & '\uff00') >> 8;
        int var9 = var6 & 255;
        var7 = Class50.method1385(var7, var3);
        var8 = Class50.method1385(var8, var3);
        var9 = Class50.method1385(var9, var3);
        var6 = (int) (4278190080L + (long) var7 * 256L * 256L + (long) var8 * 256L + (long) var9);
        this.buffer.setRGB(var1, var2, var6);
    }

}
