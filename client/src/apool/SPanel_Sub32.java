package apool;

import com.playray.client.SPanel;
import com.playray.tools.DelayTimer;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public abstract class SPanel_Sub32 extends SPanel implements Runnable, MouseMotionListener, MouseListener {

    private static final Cursor aCursor4118;
    private static final Cursor aCursor4119;
    private static final Cursor aCursor4120;
    protected static final Color aColor4121;
    private static final Font aFont4122;
    protected int anInt4123;
    protected int anInt4124;
    protected int anInt4125;
    protected int anInt4126;
    protected int anInt4127;
    protected int anInt4128;
    protected int anInt4129;
    protected int[] anIntArray4130;
    protected int[] anIntArray4131;
    protected double aDouble4132;
    protected double aDouble4133;
    protected double aDouble4134;
    protected double aDouble4135;
    protected double aDouble4136;
    protected Class60 aClass60_4137;
    private SPanel_Sub20 aSPanel_Sub20_4138;
    private GameReplay aGameReplay_4139;
    private Class71 aClass71_4140;
    private Class68 aClass68_4141;
    private Class69 aClass69_4142;
    protected Image anImage4143;
    protected Image anImage4144;
    protected Image anImage4145;
    private Image anImage4146;
    protected Image[][] anImageArrayArray4147;
    private Area anArea4148;
    private byte[][] aByteArrayArray4149;
    private byte[][] aByteArrayArray4150;
    private byte[][] aByteArrayArray4151;
    private byte[][] aByteArrayArray4152;
    protected Class65[] aClass65Array4153;
    private int anInt4154;
    private int anInt4155;
    private int anInt4156;
    private int anInt4157;
    private int anInt4158;
    private int anInt4159;
    private int anInt4160;
    private int anInt4161;
    protected int anInt4162;
    private SynchronizedInt aSynchronizedInt_4163;
    private boolean aBoolean4164;
    private boolean aBoolean4165;
    private boolean aBoolean4166;
    private boolean aBoolean4167;
    protected boolean aBoolean4168;
    private double aDouble4169;
    private double aDouble4170;
    private boolean aBoolean4171;
    private boolean aBoolean4172;
    private Object anObject4173;
    private long aLong4174;
    private String aString4175;
    private String aString4176;
    private Thread aThread4177;
    private boolean aBoolean4178;
    private BufferedImage aBufferedImage4179;
    private Graphics2D aGraphics2D4180;
    private Graphics aGraphics4181;
    private SynchronizedBool aSynchronizedBool_4182;
    private double aDouble4183;
    private double aDouble4184;
    private boolean aBoolean4185;
    private Class65 aClass65_4186;
    private Object anObject4187;
    private static final String[] aStringArray4188 = new String[9];


    protected SPanel_Sub32(Class60 var1, SPanel_Sub20 var2, GameReplay var3) {
        this.aClass60_4137 = var1;
        this.aSPanel_Sub20_4138 = var2;
        this.aGameReplay_4139 = var3;
        this.anObject4187 = new Object();
        this.method2650();
        this.setSize(this.anInt4123, this.anInt4124);
        this.method2651();
        this.anImage4146 = this.anImage4143;
        this.anArea4148 = this.method2652();
        this.aClass68_4141 = new Class68(var1);
        this.aClass69_4142 = new Class69(var1);
        this.aClass65Array4153 = new Class65[this.anInt4127];

        for (int var4 = 0; var4 < this.anInt4127; ++var4) {
            this.aClass65Array4153[var4] = new Class65(var4, var4 == 0 ? 1.2D : 1.0D);
        }

        this.aLong4174 = 0L;
        this.aString4175 = this.aString4176 = null;
        this.anInt4155 = this.anInt4156 = this.anInt4161 = -1;
        this.aSynchronizedInt_4163 = new SynchronizedInt();
        this.anInt4154 = 0;
        this.aBoolean4172 = false;
        this.anObject4173 = new Object();
        this.aSynchronizedBool_4182 = new SynchronizedBool();
        this.aBoolean4185 = false;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void method2649(Class71 var1) {
        this.aClass71_4140 = var1;
    }

    public void paintContent(Graphics2D var1) {
        int var3;
        if (this.aBufferedImage4179 != null) {
            var1.drawImage(this.aBufferedImage4179, 0, 0, this);
        } else {
            var1.drawImage(this.anImage4146, 0, 0, this);
            this.method2697(var1);
            this.method2693(var1);
            this.method2692(var1);
            this.method2694(var1);
            if (this.aSynchronizedBool_4182.method1460() && this.aBoolean4185) {
                var1.setColor(new Color(0, 0, 0, 32));

                for (int var2 = 40; var2 >= 10; var2 /= 2) {
                    for (var3 = var2 + 4 - 40; var3 < this.anInt4124; var3 += var2) {
                        var1.drawLine(0, var3, this.anInt4123 - 1, var3);
                    }

                    for (var3 = var2 + 9 - 40; var3 < this.anInt4123; var3 += var2) {
                        var1.drawLine(var3, 0, var3, this.anInt4124 - 1);
                    }
                }
            }
        }

        if (this.aString4175 != null || this.aString4176 != null) {
            String var6 = this.aString4176 != null ? this.aString4176 : this.aString4175;
            var3 = this.getFontMetrics(aFont4122).stringWidth(var6);
            int var4 = this.anInt4123 / 2 - var3 / 2;
            int var5 = this.anInt4124 / 2 + 5;
            var1.setColor(Color.white);
            var1.fillRoundRect(var4 - 10, var5 - 20, var3 + 20, 30, 10, 10);
            var1.setColor(Color.black);
            var1.drawRoundRect(var4 - 10, var5 - 20, var3 + 20 - 1, 29, 10, 10);
            var1.setColor(Color.red);
            var1.setFont(aFont4122);
            var1.drawString(var6, var4, var5);
        }

    }

    public void mouseMoved(MouseEvent var1) {
        if (this.aGameReplay_4139 == null) {
            if (this.anInt4154 >= 1 && this.anInt4154 <= 3) {
                this.anInt4155 = var1.getX();
                this.anInt4156 = var1.getY();
                if (this.aSynchronizedBool_4182.method1460()) {
                    this.method2720(this.anInt4155, this.anInt4156);
                } else {
                    if (this.anInt4154 == 3) {
                        this.aClass71_4140.method1534(this.anInt4155, this.anInt4156);
                    }

                    if (this.aBoolean4164 && this.anInt4160 > -1 && (double) this.anInt4155 > this.aClass65Array4153[this.anInt4160].method1483() - (double) this.anInt4126 && (double) this.anInt4155 <= this.aClass65Array4153[this.anInt4160].method1483() + (double) this.anInt4126 && (double) this.anInt4156 > this.aClass65Array4153[this.anInt4160].method1484() - (double) this.anInt4126 && (double) this.anInt4156 <= this.aClass65Array4153[this.anInt4160].method1484() + (double) this.anInt4126) {
                        this.anInt4160 = -1;
                    }

                    if (this.anInt4154 == 2) {
                        this.anInt4161 = this.method2711(this.anInt4155, this.anInt4156);
                    }
                }

                this.repaint();
            }
        }
    }

    public void mouseDragged(MouseEvent var1) {
        if (this.aSynchronizedBool_4182.method1460()) {
            this.method2723(var1.getX(), var1.getY());
        }

    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
        Object var2 = this.anObject4187;
        synchronized (this.anObject4187) {
            if (this.anInt4154 < 1 || this.anInt4154 > 3) {
                return;
            }

            this.anInt4155 = this.anInt4156 = -1;
            if (this.aSynchronizedBool_4182.method1460()) {
                this.method2724();
            } else {
                if (this.anInt4154 == 3) {
                    this.aClass71_4140.method1534(this.anInt4155, this.anInt4156);
                }

                if (this.anInt4154 < 3) {
                    this.anInt4161 = -1;
                }
            }
        }

        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        Object var2 = this.anObject4187;
        synchronized (this.anObject4187) {
            this.aBoolean4171 = var1.isMetaDown();
            int var3 = var1.getX();
            int var4 = var1.getY();
            if (this.aGameReplay_4139 != null && this.anInt4154 != 6) {
                this.method2659(1, this.aGameReplay_4139.method1522(), false);
                this.anInt4154 = this.aGameReplay_4139.method1524();
                if (this.anInt4154 != 0) {
                    String var5 = this.aGameReplay_4139.method1525();
                    if (this.anInt4154 == 1) {
                        this.method2661(var5);
                    } else if (this.anInt4154 == 3) {
                        this.method2664(var5);
                    }

                }
            } else {
                this.anInt4155 = var3;
                this.anInt4156 = var4;
                if (this.anInt4154 == 3) {
                    this.aClass71_4140.method1534(this.anInt4155, this.anInt4156);
                }

                this.method2689(this.anInt4155, this.anInt4156);
            }
        }
    }

    public void mouseReleased(MouseEvent var1) {
        Object var2 = this.anObject4187;
        synchronized (this.anObject4187) {
            if (this.aSynchronizedBool_4182.method1460()) {
                this.method2724();
            } else if (this.anInt4154 == 4 && !this.aBoolean4167) {
                this.aBoolean4167 = true;
                this.setCursor(aCursor4118);
                if (var1 != null) {
                    var1.consume();
                }
            }

        }
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void run() {
        this.aSPanel_Sub20_4138.method2530();
        this.anInt4162 = this.method2691();
        this.aBufferedImage4179 = new BufferedImage(this.anInt4123, this.anInt4124, 1);
        this.aGraphics2D4180 = this.aBufferedImage4179.createGraphics();
        this.aGraphics2D4180.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        this.drawBackground(this.aGraphics2D4180);
        this.aGraphics4181 = this.getGraphics();
        this.anInt4160 = -1;
        this.aClass71_4140.method1536();
        if (this.anInt4154 == 4) {
            this.method2700();
            if (this.aBoolean4178) {
                return;
            }
        }

        if (this.anInt4154 == 6) {
            this.method2719();
            this.method2717();
            this.repaint();
        } else {
            this.aSPanel_Sub20_4138.method2531();
            this.method2701();
            if (!this.aBoolean4178) {
                int var1 = 0;

                int var2;
                for (var2 = 1; var2 < this.anInt4127; ++var2) {
                    if (this.aClass65Array4153[var2].method1482()) {
                        ++var1;
                    }
                }

                this.aSPanel_Sub20_4138.method2536(var1);
                var2 = this.aSPanel_Sub20_4138.method2538();
                if (var2 > 0) {
                    this.aClass65Array4153[0].method1492(false);
                    this.aBoolean4165 = var2 == 2;
                    if (var2 == 3) {
                        this.method2710();
                    }
                }

                int var3 = this.method2691();
                this.method2719();
                if (this.anInt4154 != 6) {
                    this.anInt4154 = 0;
                }

                this.anInt4160 = -1;
                this.method2709(this.aSPanel_Sub20_4138.method2539(), this.aSPanel_Sub20_4138.method2540(), this.anInt4162 - var3, var3);
                this.method2717();
                this.aSPanel_Sub20_4138.method2537();
                this.repaint();
            }
        }
    }

    protected abstract void method2650();

    protected abstract void method2651();

    protected abstract Area method2652();

    protected void method2653(int[] var1) {
        this.aByteArrayArray4149 = new byte[this.anInt4123][45];
        this.aByteArrayArray4150 = new byte[this.anInt4123][45];
        this.aByteArrayArray4151 = new byte[45][this.anInt4124 - 90];
        this.aByteArrayArray4152 = new byte[45][this.anInt4124 - 90];

        for (int var2 = 0; var2 < this.anInt4124; ++var2) {
            for (int var3 = 0; var3 < this.anInt4123; ++var3) {
                if (var2 < 45 || var2 >= this.anInt4124 - 45 || var3 < 45 || var3 >= this.anInt4123 - 45) {
                    int var4 = (var1[var2 * this.anInt4123 + var3] & 16711680) >> 16;
                    int var5 = (var1[var2 * this.anInt4123 + var3] & '\uff00') >> 8;
                    int var6 = var1[var2 * this.anInt4123 + var3] & 255;
                    byte var7 = -1;
                    if (var4 < 64 && var5 < 64 && var6 < 64) {
                        var7 = 2;
                    }

                    if (var4 > 192 && var5 < 64 && var6 < 64) {
                        var7 = 1;
                    }

                    if (var4 < 64 && var5 > 192 && var6 < 64) {
                        var7 = 0;
                    }

                    if (var2 < 45) {
                        this.aByteArrayArray4149[var3][var2] = var7;
                    } else if (var2 >= this.anInt4124 - 45) {
                        this.aByteArrayArray4150[var3][var2 - this.anInt4124 + 45] = var7;
                    } else if (var3 < 45) {
                        this.aByteArrayArray4151[var3][var2 - 45] = var7;
                    } else if (var3 >= this.anInt4123 - 45) {
                        this.aByteArrayArray4152[var3 - this.anInt4123 + 45][var2 - 45] = var7;
                    }
                }
            }
        }

    }

    protected abstract boolean method2654();

    protected void method2655() {
        if (this.anInt4154 != 4 && this.anInt4154 != 5) {
            this.repaint();
        }
    }

    protected void method2656(int var1, int var2, Class66 var3) {
        for (int var4 = 0; var4 < this.anInt4127; ++var4) {
            this.aClass65Array4153[var4].method1492(false);
        }

        this.aBoolean4165 = this.aBoolean4164 = false;
        this.method2657(var1, var2, var3);
        this.anInt4154 = 0;
        this.repaint();
    }

    protected abstract void method2657(int var1, int var2, Class66 var3);

    protected void method2658() {
        for (int var1 = 0; var1 < this.anInt4127; ++var1) {
            this.aClass65Array4153[var1].method1495();
        }

    }

    protected int method2659(int var1, int var2, boolean var3) {
        this.aSynchronizedInt_4163.method1463(this.method2699());
        if (var1 == 1 && var2 == 2 || var1 == 2 && (var2 == 1 || var2 == 3)) {
            this.anInt4160 = this.aSynchronizedInt_4163.method1467();
            this.aBoolean4164 = true;
        }

        this.aClass71_4140.method1532();
        this.anInt4161 = -1;
        this.anInt4155 = this.anInt4156 = -1;
        this.aDouble4169 = this.aDouble4170 = 0.0D;
        this.anInt4159 = 0;
        this.aBoolean4168 = true;
        if (!var3) {
            this.repaint();
            return this.aSynchronizedInt_4163.method1467();
        } else {
            this.aBoolean4166 = this.aSPanel_Sub20_4138.method2528();
            this.anInt4154 = this.aClass65Array4153[0].method1482() ? (this.aBoolean4166 ? 2 : 3) : 1;
            if (this.anInt4154 == 3) {
                this.method2690();
            }

            this.setCursor(aCursor4119);
            this.repaint();
            return this.aSynchronizedInt_4163.method1467();
        }
    }

    protected boolean method2660(double var1, double var3) {
        if (this.anInt4154 != 3) {
            var3 = 0.0D;
            var1 = 0.0D;
            return false;
        } else {
            this.aDouble4169 = var1;
            this.aDouble4170 = var3;
            return true;
        }
    }

    protected void method2661(String var1) {
        int[] var2 = this.method2713(var1);
        this.method2716();
        this.aClass65Array4153[0].method1492(true);
        this.aClass65Array4153[0].method1493((double) var2[0], (double) var2[1]);
        this.aSPanel_Sub20_4138.method2529();
        this.method2717();
        this.repaint();
    }

    protected void method2662(int var1) {
        this.method2716();
        this.anInt4161 = var1;
        this.method2717();
        this.repaint();
    }

    protected void method2663(int var1, int var2) {
        this.aClass71_4140.method1535(var1, var2);
        this.repaint();
    }

    protected void method2664(String var1) {
        int[] var2 = this.method2715(var1);
        this.method2716();
        this.anInt4157 = var2[0];
        this.anInt4158 = var2[1];
        this.anInt4159 = var2[2];
        this.aDouble4169 = (double) var2[3] / 100.0D;
        this.aDouble4170 = (double) var2[4] / 100.0D;
        this.aBoolean4178 = false;
        this.aThread4177 = new Thread(this);
        this.aThread4177.start();
    }

    protected void method2665(String var1) {
        if (this.anInt4154 >= 1 && this.anInt4154 <= 3) {
            this.method2666();
        }

        this.aString4175 = var1;
        this.repaint();
        new Class70(this, this, 1);
    }

    protected void method2666() {
        this.anInt4154 = 0;
        this.setCursor(aCursor4118);
        this.repaint();
    }

    protected void method2667() {
        this.method2666();
        this.anInt4154 = 6;
        this.repaint();
    }

    protected void method2668() {
        this.method2666();
        if (this.aThread4177 != null) {
            this.aBoolean4178 = true;
            this.aThread4177.interrupt();
            this.aThread4177 = null;
        }

        this.method2719();
        this.aSPanel_Sub20_4138 = null;
        this.aByteArrayArray4149 = (byte[][]) null;
        this.aByteArrayArray4150 = (byte[][]) null;
        this.aByteArrayArray4151 = (byte[][]) null;
        this.aByteArrayArray4152 = (byte[][]) null;
    }

    protected void method2669() {
        this.aString4176 = this.aClass60_4137.textManager.method2039("Game_ResultError");
        this.repaint();
        new Class70(this, this, 2);
    }

    protected void method2670(String var1) {
        for (int var2 = 0; var2 < this.anInt4127; ++var2) {
            boolean var3 = var1.charAt(0) != 108;
            this.aClass65Array4153[var2].method1492(var3);
            if (var3) {
                int var4 = Integer.parseInt(var1.substring(0, 4), 22);
                this.aClass65Array4153[var2].method1493((double) (var4 % this.anInt4123), (double) (var4 / this.anInt4123));
                var1 = var1.substring(4);
            } else {
                var1 = var1.substring(1);
            }
        }

        this.repaint();
    }

    protected boolean method2671(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.anInt4127; ++var4) {
            if (this.aClass65Array4153[var4].method1482()) {
                double var5 = (double) var2 - this.aClass65Array4153[var4].method1483();
                double var7 = (double) var3 - this.aClass65Array4153[var4].method1484();
                double var9 = Math.sqrt(var5 * var5 + var7 * var7);
                if (var9 < (double) (this.anInt4125 + 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    protected boolean method2672(int var1, int var2) {
        if (var1 >= 0 && var2 >= 0) {
            double var3 = (double) var1 - this.aClass65Array4153[0].method1483();
            double var5 = (double) var2 - this.aClass65Array4153[0].method1484();
            double var7 = Math.sqrt(var3 * var3 + var5 * var5);
            if (var7 < (double) (this.anInt4126 + 1)) {
                return false;
            } else if (this.aBoolean4168) {
                return true;
            } else if ((double) var1 <= this.aClass65Array4153[0].method1483()) {
                return false;
            } else {
                double var9 = this.aClass65Array4153[0].method1483() / var3;
                double var11 = this.aClass65Array4153[0].method1484() + (this.aClass65Array4153[0].method1484() - (double) var2) * var9;
                return var11 >= 0.0D && var11 < (double) this.anInt4124;
            }
        } else {
            return false;
        }
    }

    protected void method2673() {
        this.aClass65Array4153[0].method1492(false);
        this.repaint();
    }

    protected void method2674(Graphics var1) {
    }

    protected abstract void method2675(Graphics var1, int var2, int var3);

    protected abstract void method2676(Graphics var1, int var2);

    protected abstract void method2677(Graphics var1, double var2, double var4);

    protected abstract boolean method2678(int var1, int var2);

    protected void method2679(int var1) {
    }

    protected boolean method2680(int var1, boolean[][] var2) {
        return false;
    }

    protected void method2681(Graphics var1, Color var2, double var3, double var5, double var7, double var9) {
        double var11 = var7 - var3;
        double var13 = var9 - var5;
        double var15 = var11 >= 0.0D ? var11 : -var11;
        double var17 = var13 >= 0.0D ? var13 : -var13;
        double var19 = (var15 > var17 ? var15 : var17) / 10.0D;
        double var21 = 1.0D * var11 / (var19 * 2.0D);
        double var23 = 1.0D * var13 / (var19 * 2.0D);
        double var25 = var3;
        double var27 = var5;
        var1.setColor(var2);

        for (int var29 = 0; (double) var29 < var19; ++var29) {
            var1.drawLine((int) var25, (int) var27, (int) (var25 + var21), (int) (var27 + var23));
            var25 += var21 * 2.0D;
            var27 += var23 * 2.0D;
        }

    }

    protected boolean method2682() {
        return this.aBoolean4172;
    }

    protected void method2683(int var1, int var2) {
        int var3 = this.anImage4143.getWidth(this);
        int var4 = this.anImage4143.getHeight(this);
        BufferedImage var5 = new BufferedImage(var3, var4, 1);
        Graphics2D var6 = var5.createGraphics();
        this.drawBackground(var6);
        var6.drawImage(this.anImage4143, 0, 0, this);
        Image var7 = this.aClass60_4137.imageManager.method1983("coin-icon");
        this.method2718(var6, var7, var1, 50, 1);
        this.method2718(var6, var7, var2, this.anInt4123 - 50 - 11, -1);
        this.anImage4146 = var5;
        this.repaint();
    }

    protected int method2684() {
        return this.anInt4154;
    }

    protected void method2685(int var1) {
        this.anInt4154 = var1;
        if (var1 == 3) {
            this.setCursor(aCursor4119);
        }

    }

    protected boolean method2686() {
        if (this.aSynchronizedBool_4182.method1459(!this.aSynchronizedBool_4182.method1460())) {
            this.setCursor(aCursor4118);
        } else {
            this.setCursor(aCursor4119);
            this.anInt4155 = this.anInt4156 = -1;
        }

        this.repaint();
        return this.aSynchronizedBool_4182.method1460();
    }

    protected void method2687(boolean var1) {
        this.aBoolean4185 = var1;
        this.repaint();
    }

    protected Class65[] method2688() {
        return this.aClass65Array4153;
    }

    private void method2689(int var1, int var2) {
        if (this.aClass60_4137.gameApplet.aSynchronizedBool_4803.method1460() && var1 >= 0 && var1 < this.anInt4123 && var2 >= 0 && var2 < this.anInt4124 && System.currentTimeMillis() >= this.aLong4174) {
            if (this.anInt4154 == 1) {
                if (this.method2698(var1, var2)) {
                    String var3 = this.method2712(var1, var2);
                    this.aSPanel_Sub20_4138.method2524("setwhiteball\t" + var3);
                    this.method2661(var3);
                    if (this.aBoolean4166) {
                        this.anInt4154 = 2;
                    } else {
                        this.anInt4154 = 3;
                        this.method2690();
                    }

                    this.anInt4155 = var1;
                    this.anInt4156 = var2;
                    this.repaint();
                }
            } else if (this.anInt4154 == 2) {
                this.aLong4174 = System.currentTimeMillis() + 400L;
                this.anInt4154 = 3;
                this.method2690();
                this.anInt4161 = this.method2711(var1, var2);
                this.aSPanel_Sub20_4138.method2524("setpainted\t" + this.anInt4161);
                this.repaint();
            } else {
                if (this.anInt4154 == 3) {
                    if (this.aSynchronizedBool_4182.method1460()) {
                        this.method2721(var1, var2);
                    } else if (this.method2672(var1, var2)) {
                        if (!this.aSPanel_Sub20_4138.method2527(true)) {
                            return;
                        }

                        this.anInt4154 = 4;
                        this.method2716();
                        this.anInt4157 = var1;
                        this.anInt4158 = var2;
                        this.aBoolean4167 = false;
                        this.aBoolean4178 = false;
                        this.aThread4177 = new Thread(this);
                        this.aThread4177.start();
                    }
                }

            }
        }
    }

    private void method2690() {
        this.aClass71_4140.method1533();
        if (this.aSPanel_Sub20_4138 instanceof SPanel_Sub20_Sub2) {
            ((SPanel_Sub20_Sub2) ((SPanel_Sub20_Sub2) this.aSPanel_Sub20_4138)).method2565();
        }

    }

    private int method2691() {
        int var1 = 0;

        for (int var2 = 1; var2 < this.anInt4127; ++var2) {
            if (this.aClass65Array4153[var2].method1482()) {
                ++var1;
            }
        }

        return var1;
    }

    private void method2692(Graphics2D var1) {
        boolean var2 = this.anInt4154 != 6;
        boolean var3 = var2 && this.aClass60_4137.aClass61_1207.showShadows;
        int var4 = var3 ? 1 : 0;
        if (var3) {
            Shape var5 = var1.getClip();
            var1.setClip(this.anArea4148);

            for (int var6 = 0; var6 < this.anInt4127; ++var6) {
                if (this.aClass65Array4153[var6].method1482()) {
                    this.method2676(var1, var6);
                }
            }

            var1.setClip(var5);
        }

        for (int var7 = 0; var7 < this.anInt4127; ++var7) {
            if (this.aClass65Array4153[var7].method1482()) {
                this.method2695(var1, var2, var7, var4, this.aBoolean4164 && var7 == this.anInt4160 ? 1 : 0);
            }
        }

    }

    private void method2693(Graphics2D var1) {
        if (this.anInt4154 == 1 && !this.aBoolean4165) {
            this.method2674(var1);
        }

        if (this.anInt4155 != -1 && this.anInt4156 != -1 && !this.aSynchronizedBool_4182.method1460()) {
            if (this.anInt4154 == 3 && this.method2672(this.anInt4155, this.anInt4156)) {
                this.method2675(var1, this.anInt4155, this.anInt4156);
            }

        }
    }

    private void method2694(Graphics2D var1) {
        if ((this.anInt4154 == 0 || this.anInt4154 == 3) && !this.aSynchronizedBool_4182.method1460()) {
            this.aClass71_4140.method1537(var1, this.aDouble4169, this.anInt4159, false);
        } else if (this.anInt4155 != -1 && this.anInt4156 != -1) {
            if (this.anInt4154 == 1 && this.method2698(this.anInt4155, this.anInt4156)) {
                this.method2696(var1, true, 0, (double) this.anInt4155, (double) this.anInt4156, 1, 0);
            }

        }
    }

    private void method2695(Graphics2D var1, boolean var2, int var3, int var4, int var5) {
        this.method2696(var1, var2, var3, this.aClass65Array4153[var3].method1483(), this.aClass65Array4153[var3].method1484(), var4, var5);
    }

    private void method2696(Graphics2D var1, boolean var2, int var3, double var4, double var6, int var8, int var9) {
        if (var8 == 2) {
            Shape var10 = var1.getClip();
            var1.setClip(this.anArea4148);
            this.method2676(var1, var3);
            var1.setClip(var10);
        }

        int var12 = (int) (var4 - (double) this.anInt4126 + 0.5D);
        int var11 = (int) (var6 - (double) this.anInt4126 + 0.5D);
        var1.drawImage(this.anImageArrayArray4147[var2 ? 0 : 1][var3], var12, var11, this);
        if (var8 > 0) {
            this.method2677(var1, var4, var6);
        }

        if (var9 != 0) {
            var1.drawImage(var9 > 0 ? this.anImage4144 : this.anImage4145, var12, var11, this);
        }

    }

    private void method2697(Graphics2D var1) {
        int var2 = this.anInt4161;
        if (var2 >= 0) {
            var1.setColor(Color.red);
            var1.fillOval(this.anIntArray4130[var2] - 3, this.anIntArray4131[var2] - 3, 6, 6);
        }

    }

    private boolean method2698(int var1, int var2) {
        return var1 - this.anInt4126 >= this.anInt4128 && var1 + this.anInt4126 < this.anInt4123 - this.anInt4128 && var2 - this.anInt4126 >= this.anInt4128 && var2 + this.anInt4126 < this.anInt4124 - this.anInt4128 ? (!this.method2671(0, var1, var2) ? false : (this.aBoolean4165 ? true : this.method2678(var1, var2))) : false;
    }

    private int method2699() {
        for (int var1 = 1; var1 < this.anInt4127; ++var1) {
            if (this.aClass65Array4153[var1].method1482()) {
                return var1;
            }
        }

        return 0;
    }

    private void method2700() {
        int var1 = 0;
        int var2 = this.method2654() ? 35 : 25;
        this.anInt4159 = this.aBoolean4171 ? 100 : 5;

        do {
            Tools.sleep((long) var2);
            if (this.aBoolean4178) {
                return;
            }

            if (this.anInt4159 < 100) {
                ++this.anInt4159;
            }

            this.aGraphics2D4180.drawImage(this.anImage4146, 0, 0, this);
            this.method2697(this.aGraphics2D4180);
            this.method2692(this.aGraphics2D4180);
            this.aClass71_4140.method1537(this.aGraphics2D4180, this.aDouble4169, this.anInt4159, true);
            this.method2703();
            ++var1;
            if (var1 == 200) {
                this.mouseReleased((MouseEvent) null);
            }

            if (this.anInt4154 == 6) {
                return;
            }
        } while (!this.aBoolean4167);

        this.anInt4154 = 5;
        int var3 = (int) (this.aDouble4169 * 100.0D + 0.5D);
        int var4 = (int) (this.aDouble4170 * 100.0D + 0.5D);
        this.aSPanel_Sub20_4138.method2524("beginstroke\t" + this.method2714(this.anInt4157, this.anInt4158, this.anInt4159, var3, var4));
        this.aDouble4169 = (double) var3 / 100.0D;
        this.aDouble4170 = (double) var4 / 100.0D;
    }

    private void method2701() {
        double var1 = (double) this.anInt4157 - this.aClass65Array4153[0].method1483();
        double var3 = (double) this.anInt4158 - this.aClass65Array4153[0].method1484();
        double var5 = Math.sqrt(var1 * var1 + var3 * var3);
        double var7 = (double) (this.anInt4159 * this.anInt4129) / (var5 * 100.0D);
        double var9 = 1.0D - Math.sqrt(this.aDouble4169 * this.aDouble4169 + this.aDouble4170 * this.aDouble4170) * 0.45D;
        var7 *= var9;
        this.aClass65Array4153[0].method1494(var1 * var7, var3 * var7);
        if (this.aClass60_4137.aClass61_1207.playSounds) {
            int var11 = (int) (var5 * var7 / 2.5D);
            if (var11 >= 4) {
                var11 = 3;
            }

            this.aClass60_4137.soundManager.play("strike-" + var11);
        }

        double var12 = -this.aClass65Array4153[0].method1487() * this.aDouble4170 * 0.006D;
        double var14 = -this.aClass65Array4153[0].method1488() * this.aDouble4170 * 0.006D;

        for (int var16 = 0; var16 < this.anInt4127; ++var16) {
            this.aClass65Array4153[var16].method1505(var16 == 0);
        }

        boolean var31 = false;
        boolean var17 = false;
        int var18 = this.aClass60_4137.aClass61_1207.showShadows ? 2 : 0;
        DelayTimer var19 = new DelayTimer(200);

        int var21;
        do {
            this.aClass68_4141.method1526();
            this.aClass69_4142.method1529();

            int var20;
            for (var20 = 0; var20 < this.anInt4127; ++var20) {
                this.aClass65Array4153[var20].method1506();
                this.aClass65Array4153[var20].method1507();
            }

            for (var20 = 0; var20 < 50; ++var20) {
                for (var21 = 0; var21 < this.anInt4127; ++var21) {
                    this.aClass65Array4153[var21].method1497(var21 == 0, var12, var14, 50.0D);
                }

                for (var21 = 0; var21 < this.anInt4127 - 1; ++var21) {
                    if (this.aClass65Array4153[var21].method1511()) {
                        for (int var22 = var21 + 1; var22 < this.anInt4127; ++var22) {
                            if (this.aClass65Array4153[var22].method1511() && (this.aClass65Array4153[var21].method1509() || this.aClass65Array4153[var22].method1509()) && this.method2704(var21, var22)) {
                                if (this.aClass60_4137.aClass61_1207.playSounds) {
                                    double var23 = this.aClass65Array4153[var21].method1487() - this.aClass65Array4153[var22].method1487();
                                    double var25 = this.aClass65Array4153[var21].method1488() - this.aClass65Array4153[var22].method1488();
                                    double var27 = Math.sqrt(var23 * var23 + var25 * var25);
                                    this.aClass68_4141.method1527((int) var27);
                                }

                                this.aClass65Array4153[var21].method1498();
                                this.aClass65Array4153[var22].method1498();
                                if (!var31 && var21 == 0) {
                                    boolean var29 = var22 == this.aSynchronizedInt_4163.method1467();
                                    this.aSPanel_Sub20_4138.method2533(var22, var29);
                                    if (this.aBoolean4164) {
                                        this.anInt4160 = var29 ? -1 : var22;
                                    }

                                    var31 = true;
                                }

                                this.aClass65Array4153[var21].method1508();
                                this.aClass65Array4153[var22].method1508();
                            }
                        }
                    }
                }

                for (var21 = 0; var21 < this.anInt4127; ++var21) {
                    if (this.aClass65Array4153[var21].method1510() && !this.aClass65Array4153[var21].method1515() && (this.aClass65Array4153[var21].method1483() - (double) this.anInt4126 < 45.0D || this.aClass65Array4153[var21].method1483() + (double) this.anInt4126 >= (double) (this.anInt4123 - 45) || this.aClass65Array4153[var21].method1484() - (double) this.anInt4126 < 45.0D || this.aClass65Array4153[var21].method1484() + (double) this.anInt4126 >= (double) (this.anInt4124 - 45))) {
                        boolean[] var30 = this.method2705(var21);
                        this.aClass65Array4153[var21].method1499(var30);
                        if (var30[1] || var30[2] || var30[3] || var30[4] || var30[5] || var30[6] || var30[7] || var30[8]) {
                            if (this.aClass60_4137.aClass61_1207.playSounds) {
                                this.aClass69_4142.method1530((int) (this.aClass65Array4153[var21].method1489() * 0.4D));
                            }

                            this.aClass65Array4153[var21].method1500(var30);
                            if (var21 == 0) {
                                var12 *= 0.5D;
                                var14 *= 0.5D;
                                if (this.aDouble4169 <= -0.01D || this.aDouble4169 >= 0.01D) {
                                    this.aClass65Array4153[0].method1504(this.aDouble4169, var30);
                                }

                                this.aDouble4169 *= 0.3D;
                            }

                            this.aSPanel_Sub20_4138.method2532(var21);
                        }
                    }
                }
            }

            for (var20 = 0; var20 < this.anInt4127; ++var20) {
                this.aClass65Array4153[var20].method1501(this.aDouble4134, 10.0D);
            }

            if (!var31) {
                var12 *= 0.9989D;
                var14 *= 0.9989D;
            } else {
                var12 *= 0.988D;
                var14 *= 0.988D;
            }

            this.aDouble4169 *= 0.999D;
            this.method2706();
            if (this.aClass65Array4153[0].method1515()) {
                var14 = 0.0D;
                var12 = 0.0D;
            }

            for (var20 = 0; var20 < this.anInt4127; ++var20) {
                this.aClass65Array4153[var20].method1517(this.aDouble4132);
            }

            var17 = Math.sqrt(var12 * var12 + var14 * var14) < this.aDouble4135;
            if (var17) {
                for (var20 = 0; var20 < this.anInt4127; ++var20) {
                    if (this.aClass65Array4153[var20].method1518(this.aDouble4132, this.aDouble4135)) {
                        var17 = false;
                    }
                }
            }

            if (var19.doDelay() && !this.aBoolean4178) {
                this.aGraphics2D4180.drawImage(this.anImage4146, 0, 0, (ImageObserver) null);
                this.method2702(var18);
                this.method2703();
            }

            if (this.aBoolean4178) {
                return;
            }
        } while (!var17);

        if (!var31) {
            this.aSPanel_Sub20_4138.method2534();
        }

        boolean var32 = false;

        for (var21 = 0; var21 < this.anInt4127; ++var21) {
            if (this.aClass65Array4153[var21].method1482() && this.aClass65Array4153[var21].method1515()) {
                var32 = true;
                this.aClass65Array4153[var21].method1492(false);
            }
        }

        if (var32) {
            Tools.sleep(750L);
        }

    }

    private void method2702(int var1) {
        for (int var2 = 0; var2 < 2; ++var2) {
            for (int var3 = 0; var3 < this.anInt4127; ++var3) {
                if (this.aClass65Array4153[var3].method1482()) {
                    if (var2 == 0 && this.aClass65Array4153[var3].method1515()) {
                        double var4 = this.aClass65Array4153[var3].method1516();
                        int var6 = (int) (this.aClass65Array4153[var3].method1483() - (double) this.anInt4126 + var4 + 0.5D);
                        int var7 = (int) (this.aClass65Array4153[var3].method1484() - (double) this.anInt4126 + var4 + 0.5D);
                        int var8 = (int) (this.aClass65Array4153[var3].method1483() + (double) this.anInt4126 - var4 + 0.5D);
                        int var9 = (int) (this.aClass65Array4153[var3].method1484() + (double) this.anInt4126 - var4 + 0.5D);
                        if (var8 - var6 > var9 - var7) {
                            var8 = var6 + var9 - var7;
                        } else if (var8 - var6 < var9 - var7) {
                            var9 = var7 + var8 - var6;
                        }

                        this.aGraphics2D4180.drawImage(this.anImageArrayArray4147[0][var3], var6, var7, var8, var9, 0, 0, this.anInt4125, this.anInt4125, this);
                        double var10 = var4 / this.aDouble4132;
                        this.aGraphics2D4180.setColor(new Color(0, 0, 0, (int) (var10 * 128.0D)));
                        this.aGraphics2D4180.fillOval(var6 - 1, var7 - 1, var8 - var6 + 2, var9 - var7 + 2);
                    } else if (var2 == 1 && !this.aClass65Array4153[var3].method1515()) {
                        this.method2695(this.aGraphics2D4180, true, var3, var1, this.aBoolean4164 && var3 == this.anInt4160 ? -1 : 0);
                    }
                }
            }
        }

    }

    private void method2703() {
        if (this.aGraphics4181 != null) {
            this.aGraphics4181.drawImage(this.aBufferedImage4179, 0, 0, this);
        } else {
            this.repaint();
        }

    }

    private boolean method2704(int var1, int var2) {
        double var3 = this.aClass65Array4153[var2].method1483() - this.aClass65Array4153[var1].method1483();
        double var5 = this.aClass65Array4153[var2].method1484() - this.aClass65Array4153[var1].method1484();
        double var7 = Math.sqrt(var3 * var3 + var5 * var5);
        if (var7 > (double) this.anInt4125) {
            return false;
        } else {
            if (var7 == 0.0D) {
                var5 = 0.01D;
                var3 = 0.01D;
                this.aClass65Array4153[var2].method1493(this.aClass65Array4153[var2].method1483() + var3, this.aClass65Array4153[var2].method1484() + var5);
                var7 = Math.sqrt(var3 * var3 + var5 * var5);
            }

            double var9 = var3 / var7;
            double var11 = var5 / var7;
            double var13 = this.aClass65Array4153[var1].method1512() * var9 + this.aClass65Array4153[var1].method1513() * var11;
            double var15 = this.aClass65Array4153[var2].method1512() * var9 + this.aClass65Array4153[var2].method1513() * var11;
            if (var13 - var15 <= 0.0D) {
                return false;
            } else {
                double var17 = -this.aClass65Array4153[var1].method1512() * var11 + this.aClass65Array4153[var1].method1513() * var9;
                double var19 = -this.aClass65Array4153[var2].method1512() * var11 + this.aClass65Array4153[var2].method1513() * var9;
                double var21 = var13;
                double var25 = this.aClass65Array4153[var1].method1490() + this.aClass65Array4153[var2].method1490();
                var13 = var13 * (this.aClass65Array4153[var1].method1490() - this.aClass65Array4153[var2].method1490()) / var25 + var15 * 2.0D * this.aClass65Array4153[var2].method1490() / var25;
                var15 = var21 * 2.0D * this.aClass65Array4153[var1].method1490() / var25 + var15 * (this.aClass65Array4153[var2].method1490() - this.aClass65Array4153[var1].method1490()) / var25;
                this.aClass65Array4153[var1].method1494(var13 * var9 - var17 * var11, var13 * var11 + var17 * var9);
                this.aClass65Array4153[var2].method1494(var15 * var9 - var19 * var11, var15 * var11 + var19 * var9);
                return true;
            }
        }
    }

    private boolean[] method2705(int var1) {
        double var2 = this.aClass65Array4153[var1].method1483();
        double var4 = this.aClass65Array4153[var1].method1484();
        boolean[] var6 = new boolean[]{false, this.method2708(var2 - 0.5D, var4 - (double) this.anInt4126, 1), this.method2708(var2 + this.aDouble4136 - 1.0D, var4 - this.aDouble4136, 1), this.method2708(var2 + (double) this.anInt4126 - 1.0D, var4 - 0.5D, 1), this.method2708(var2 + this.aDouble4136 - 1.0D, var4 + this.aDouble4136 - 1.0D, 1), this.method2708(var2 - 0.5D, var4 + (double) this.anInt4126 - 1.0D, 1), this.method2708(var2 - this.aDouble4136, var4 + this.aDouble4136 - 1.0D, 1), this.method2708(var2 - (double) this.anInt4126, var4 - 0.5D, 1), this.method2708(var2 - this.aDouble4136, var4 - this.aDouble4136, 1)};
        return var6;
    }

    private void method2706() {
        for (int var1 = 0; var1 < this.anInt4127; ++var1) {
            if (this.aClass65Array4153[var1].method1510() && (this.aClass65Array4153[var1].method1483() - (double) this.anInt4126 < 45.0D || this.aClass65Array4153[var1].method1483() + (double) this.anInt4126 >= (double) (this.anInt4123 - 45) || this.aClass65Array4153[var1].method1484() - (double) this.anInt4126 < 45.0D || this.aClass65Array4153[var1].method1484() + (double) this.anInt4126 >= (double) (this.anInt4124 - 45))) {
                boolean[] var2 = this.method2707(var1);
                if (var2[9]) {
                    int var3 = this.method2711(this.aClass65Array4153[var1].method1485(), this.aClass65Array4153[var1].method1486());
                    this.aClass65Array4153[var1].method1503(this.anIntArray4130[var3], this.anIntArray4131[var3]);
                    if (var2[0] && !this.aClass65Array4153[var1].method1515()) {
                        if (this.aClass60_4137.aClass61_1207.playSounds) {
                            this.aClass60_4137.soundManager.play("pocket");
                        }

                        this.aClass65Array4153[var1].method1514();
                        this.aSPanel_Sub20_4138.method2535(var1, var3 == this.anInt4161);
                    }
                }
            }
        }

    }

    private boolean[] method2707(int var1) {
        double var2 = this.aClass65Array4153[var1].method1483();
        double var4 = this.aClass65Array4153[var1].method1484();
        double var6 = Math.sqrt(this.aDouble4133 * this.aDouble4133 / 2.0D);
        boolean[] var8 = new boolean[]{this.method2708(var2, var4, 2), this.method2708(var2, var4 - this.aDouble4133, 2), this.method2708(var2 + var6, var4 - var6, 2), this.method2708(var2 + this.aDouble4133, var4, 2), this.method2708(var2 + var6, var4 + var6, 2), this.method2708(var2, var4 + this.aDouble4133, 2), this.method2708(var2 - var6, var4 + var6, 2), this.method2708(var2 - this.aDouble4133, var4, 2), this.method2708(var2 - var6, var4 - var6, 2), false};
        var8[9] = var8[0] || var8[1] || var8[2] || var8[3] || var8[4] || var8[5] || var8[6] || var8[7] || var8[8];
        return var8;
    }

    private boolean method2708(double var1, double var3, int var5) {
        int var6 = (int) (var1 + 0.5D);
        int var7 = (int) (var3 + 0.5D);
        return var7 >= 45 && var7 < this.anInt4124 - 45 && var6 >= 45 && var6 < this.anInt4123 - 45 ? var5 == 0 : (var7 < 45 ? var5 == this.aByteArrayArray4149[var6][var7] : (var7 >= this.anInt4124 - 45 ? var5 == this.aByteArrayArray4150[var6][var7 - this.anInt4124 + 45] : (var6 < 45 ? var5 == this.aByteArrayArray4151[var6][var7 - 45] : (var6 >= this.anInt4123 - 45 ? var5 == this.aByteArrayArray4152[var6 - this.anInt4123 + 45][var7 - 45] : var5 == -1))));
    }

    private void method2709(int var1, String var2, int var3, int var4) {
        String var5 = "endstroke\t" + (var1 + 2) + "\t" + this.aSPanel_Sub20_4138.method2541() + (var2 != null ? "\t" : "");

        for (int var6 = 0; var6 < this.anInt4127; ++var6) {
            if (this.aClass65Array4153[var6].method1482()) {
                int[] var7 = this.aClass65Array4153[var6].method1502();
                if (var2 != null) {
                    String var8;
                    for (var8 = Integer.toString(var7[1] * this.anInt4123 + var7[0], 22); var8.length() < 4; var8 = "0" + var8) {
                        ;
                    }

                    var5 = var5 + var8;
                }
            } else if (var2 != null) {
                var5 = var5 + "l";
            }
        }

        if (var2 != null) {
            var5 = var5 + "\t" + (var2.length() == 0 ? "-" : var2);
            var5 = var5 + "\t" + ((SPanel_Sub20_Sub1) ((SPanel_Sub20_Sub1) this.aSPanel_Sub20_4138)).method2550();
        } else {
            var5 = var5 + "\t" + var3 + "\t" + var4;
        }

        if (this.aGameReplay_4139 == null) {
            this.aSPanel_Sub20_4138.method2524(var5);
        }

    }

    private void method2710() {
        for (int var1 = 0; var1 < this.anInt4127; ++var1) {
            this.aClass65Array4153[var1].method1496();
        }

    }

    private int method2711(int var1, int var2) {
        if (var1 >= 0 && var2 >= 0) {
            int var3 = var2 / (this.anInt4124 / 2) * 3 + var1 / (this.anInt4123 / 3);
            return var3 >= 0 && var3 < 6 ? var3 : -1;
        } else {
            return -1;
        }
    }

    private String method2712(int var1, int var2) {
        int var3 = var1 * 330 + var2;
        int var4 = var3 / 59 / 59;
        int var5 = var3 / 59 % 59;
        int var6 = var3 % 59;
        return "" + (char) (65 + var4) + (char) (65 + var5) + (char) (65 + var6);
    }

    private int[] method2713(String var1) {
        int var2 = var1.charAt(0) - 65;
        int var3 = var1.charAt(1) - 65;
        int var4 = var1.charAt(2) - 65;
        int var5 = var2 * 59 * 59 + var3 * 59 + var4;
        int[] var6 = new int[]{var5 / 330, var5 % 330};
        return var6;
    }

    private String method2714(int var1, int var2, int var3, int var4, int var5) {
        if (var1 >= 0 && var1 < this.anInt4123 && var2 >= 0 && var2 < this.anInt4124 && var3 >= 5 && var3 <= 100 && var4 > -100 && var4 < 100 && var5 > -100 && var5 < 100) {
            int var6 = var1 * 330 * 100 + var2 * 100 + (var3 - 1);
            int var7 = var6 / 68 / 68 / 68;
            int var8 = var6 / 68 / 68 % 68;
            int var9 = var6 / 68 % 68;
            int var10 = var6 % 68;
            int var11 = (var4 + 100) * 200 + var5 + 100;
            int var12 = var11 / 35 / 35;
            int var13 = var11 / 35 % 35;
            int var14 = var11 % 35;
            String var15 = "" + (char) (48 + var7) + (char) (48 + var8) + (char) (48 + var9) + (char) (48 + var10);
            String var16 = "" + (char) (65 + var12) + (char) (65 + var13) + (char) (65 + var14);
            return var15 + var16;
        } else {
            return "-";
        }
    }

    private int[] method2715(String var1) {
        String var2 = var1.substring(0, 4);
        String var3 = var1.substring(4, 7);
        int var4 = var2.charAt(0) - 48;
        int var5 = var2.charAt(1) - 48;
        int var6 = var2.charAt(2) - 48;
        int var7 = var2.charAt(3) - 48;
        int var8 = var4 * 68 * 68 * 68 + var5 * 68 * 68 + var6 * 68 + var7;
        int var9 = var3.charAt(0) - 65;
        int var10 = var3.charAt(1) - 65;
        int var11 = var3.charAt(2) - 65;
        int var12 = var9 * 35 * 35 + var10 * 35 + var11;
        int[] var13 = new int[]{var8 / '\u80e8', var8 % '\u80e8' / 100, var8 % 100 + 1, var12 / 200 - 100, var12 % 200 - 100};
        return var13;
    }

    private void method2716() {
        while (true) {
            Object var1 = this.anObject4173;
            synchronized (this.anObject4173) {
                if (!this.aBoolean4172) {
                    this.aBoolean4172 = true;
                    return;
                }
            }

            Tools.sleep(100L);
        }
    }

    private void method2717() {
        this.aBoolean4172 = false;
    }

    private void method2718(Graphics var1, Image var2, int var3, int var4, int var5) {
        byte var6;
        byte var7;
        if (var3 >= 40) {
            var6 = 4;
            var7 = 1;
        } else if (var3 >= 35) {
            var6 = 5;
            var7 = 2;
        } else if (var3 >= 20) {
            var6 = 9;
            var7 = 3;
        } else if (var3 >= 10) {
            var6 = 11;
            var7 = 4;
        } else {
            var6 = 13;
            var7 = 5;
        }

        byte var8 = 7;
        byte var9 = 6;
        if (this.method2654()) {
            var8 = 4;
            var9 = 4;
        }

        for (int var10 = 0; var10 < var3; ++var10) {
            var1.drawImage(var2, var4, (int) ((double) var8 + Math.random() * (double) var9), this);
            var4 += var5 * (var6 + (int) (Math.random() * (double) var7));
        }

    }

    private void method2719() {
        if (this.aGraphics2D4180 != null) {
            this.aGraphics2D4180.dispose();
            this.aGraphics2D4180 = null;
        }

        if (this.aBufferedImage4179 != null) {
            this.aBufferedImage4179.flush();
            this.aBufferedImage4179 = null;
        }

    }

    private void method2720(int var1, int var2) {
        this.setCursor(this.method2722(var1, var2, false) != null ? aCursor4120 : aCursor4118);
    }

    private void method2721(int var1, int var2) {
        this.aClass65_4186 = this.method2722(var1, var2, true);
        if (this.aClass65_4186 != null) {
            this.aDouble4183 = this.aClass65_4186.method1483() - (double) var1;
            this.aDouble4184 = this.aClass65_4186.method1484() - (double) var2;
        }

    }

    private Class65 method2722(int var1, int var2, boolean var3) {
        Class65 var4 = null;
        double var5 = 0.0D;

        for (int var7 = 0; var7 < this.anInt4127; ++var7) {
            if (this.aClass65Array4153[var7].method1482()) {
                double var8 = this.aClass65Array4153[var7].method1483();
                double var10 = this.aClass65Array4153[var7].method1484();
                double var12 = (double) var1 - var8;
                double var14 = (double) var2 - var10;
                double var16 = Math.sqrt(var12 * var12 + var14 * var14);
                if (var16 <= (double) this.anInt4125) {
                    if (!var3) {
                        return this.aClass65Array4153[var7];
                    }

                    if (var4 == null) {
                        var4 = this.aClass65Array4153[var7];
                        var5 = var16;
                    } else if (var16 < var5) {
                        var4 = this.aClass65Array4153[var7];
                        var5 = var16;
                    }
                }
            }
        }

        return var4;
    }

    private void method2723(int var1, int var2) {
        if (this.aClass65_4186 != null) {
            double var3;
            double var5;
            if (this.aBoolean4185) {
                var1 = (int) ((double) var1 + this.aDouble4183);
                var2 = (int) ((double) var2 + this.aDouble4184);
                var1 = var1 / 5 * 5;
                var2 = var2 / 5 * 5;
                var3 = (double) var1 - 0.5D;
                var5 = (double) var2 - 0.5D;
            } else {
                var3 = (double) var1 + this.aDouble4183;
                var5 = (double) var2 + this.aDouble4184;
            }

            double var7 = (double) this.anInt4128 / 2.0D + (double) this.anInt4125 / 2.0D - 2.0D;
            if (var3 < var7) {
                var3 = var7;
            } else if (var3 >= (double) this.anInt4123 - var7) {
                var3 = (double) this.anInt4123 - var7 - 1.0D;
            }

            if (var5 < var7) {
                var5 = var7;
            } else if (var5 >= (double) this.anInt4124 - var7) {
                var5 = (double) this.anInt4124 - var7 - 1.0D;
            }

            this.aClass65_4186.method1493(var3, var5);
            this.repaint();
        }
    }

    private void method2724() {
        if (this.aClass65_4186 != null) {
            int var1 = this.aClass65_4186.method1481();
            if (var1 > 0) {
                double var2 = this.aClass65_4186.method1483();
                double var4 = this.aClass65_4186.method1484();
                if (this.method2708(var2, var4, 2)) {
                    this.aClass65_4186.method1492(false);
                    this.aSPanel_Sub20_4138.method2535(var1, false);
                }
            }

            this.aClass65_4186 = null;
        }
    }

    protected void method2725(int var1) {
        if (var1 == 1) {
            this.aString4175 = null;
        } else if (var1 == 2) {
            this.aString4176 = null;
        }

        this.repaint();
    }

    static {
        aStringArray4188[0] = "beginstroke\t";
        aStringArray4188[1] = "strike-";
        aStringArray4188[2] = "pocket";
        aStringArray4188[3] = "endstroke\t";
        aStringArray4188[4] = "setwhiteball\t";
        aStringArray4188[5] = "setpainted\t";
        aStringArray4188[6] = "coin-icon";
        aStringArray4188[7] = "Game_ResultError";
        aStringArray4188[8] = "Dialog";
        aCursor4118 = new Cursor(0);
        aCursor4119 = new Cursor(1);
        aCursor4120 = new Cursor(12);
        aColor4121 = new Color(128, 0, 0);
        aFont4122 = new Font("Dialog", 0, 16);
    }
}
