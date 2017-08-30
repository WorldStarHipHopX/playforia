package agolf2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Canvas_Sub6_Sub2 extends Canvas_Sub6 implements MouseListener, MouseMotionListener {

    private static final Color aColor2865 = new Color(160, 0, 0);
    private Class43_Sub1 aClass43_Sub1_2866;
    private Interface5 anInterface5_2867;
    private IPanel_Sub36 anIPanel_Sub36_2868;
    private int anInt2869;
    private int anInt2870;
    private int anInt2871;
    private boolean aBoolean2872;
    private int anInt2873;
    private int anInt2874;
    private int anInt2875;
    private int anInt2876;
    private boolean aBoolean2877;
    private Class54 aClass54_2878;
    private boolean[][] aBooleanArrayArray2879;
    private boolean aBoolean2880;
    private boolean aBoolean2881;


    public Canvas_Sub6_Sub2(Class52 var1, boolean var2, boolean var3, boolean var4, Class43_Sub1 var5, Interface5 var6, IPanel_Sub36 var7) {
        super(var1, true, var2, var3);
        this.aBoolean2877 = var4;
        this.aClass43_Sub1_2866 = var5;
        this.anInterface5_2867 = var6;
        this.anIPanel_Sub36_2868 = var7;
        this.method165();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.anInt2869 = -1;
        this.aBoolean2872 = false;
        this.aBoolean2881 = false;
    }

    public void mouseEntered(MouseEvent var1) {
        this.method210(var1);
    }

    public void mouseExited(MouseEvent var1) {
        this.anInt2870 = this.anInt2871 = -1;
        if (!this.aBoolean2881) {
            this.anInterface5_2867.method12();
        }

    }

    public void mousePressed(MouseEvent var1) {
    }

    public void mouseReleased(MouseEvent var1) {
        this.method210(var1);
        if (!this.aBoolean2881) {
            this.anInterface5_2867.method13(this.anInt2870, this.anInt2871, var1.isMetaDown());
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
        this.method210(var1);
        if (!this.aBoolean2881) {
            this.anInterface5_2867.method11(this.anInt2870, this.anInt2871);
        }

    }

    public void mouseDragged(MouseEvent var1) {
        this.method210(var1);
        if (!this.aBoolean2881) {
            this.anInterface5_2867.method11(this.anInt2870, this.anInt2871);
        }

    }

    protected void method175(Graphics var1) {
        if (this.aClass54_2878 == null) {
            if (!this.aBoolean2881) {
                GameBall_Sub1[] var2 = this.aClass43_Sub1_2866.method1325();
                if (var2 != null) {
                    if (this.aBoolean2872) {
                        var1.setColor(aColor2865);
                        var1.drawLine(this.anInt2873, this.anInt2874, this.anInt2875, this.anInt2876);
                    }

                    int var3;
                    for (var3 = 0; var3 < var2.length; ++var3) {
                        var2[var3].method1283(var1, (Class54) null, this.aBoolean2877, this.anIPanel_Sub36_2868.method777(), true);
                        this.anIPanel_Sub36_2868.method778(var1, var3, var2[var3]);
                    }

                    for (var3 = 0; var3 < var2.length; ++var3) {
                        var2[var3].method1283(var1, (Class54) null, this.aBoolean2877, this.anIPanel_Sub36_2868.method777(), false);
                        this.anIPanel_Sub36_2868.method778(var1, var3, var2[var3]);
                    }

                    if (this.anInt2869 >= 0) {
                        var2[this.anInt2869].method1282(var1, (Class54) null, this.aBoolean2877, this.anIPanel_Sub36_2868.method777());
                        this.anIPanel_Sub36_2868.method778(var1, this.anInt2869, var2[this.anInt2869]);
                    }

                    this.anIPanel_Sub36_2868.method779(var1);
                }
            }
        }
    }

    protected void method167(BufferedImage var1, int var2, int var3, int var4, int var5) {
        this.anIPanel_Sub36_2868.method773(var1, var2, var3, var4, var5);
    }

    protected double method168() {
        return this.anIPanel_Sub36_2868.method774();
    }

    public void method199(boolean var1) {
        this.aBoolean2877 = var1;
    }

    public void method200() {
        IPanel_Sub36 var1 = this.anIPanel_Sub36_2868;
        if (var1 != null) {
            this.anInt2870 = this.anInt2871 = -1;
            this.setCursor(Cursor.getPredefinedCursor(1));
            var1.method775();
        }
    }

    public void method201() {
        IPanel_Sub36 var1 = this.anIPanel_Sub36_2868;
        if (var1 != null) {
            this.setCursor(Cursor.getPredefinedCursor(0));
            var1.method776();
        }
    }

    public void method202(int var1) {
        this.anInt2869 = var1;
        this.repaint();
    }

    public void method203(int var1, int var2, int var3, int var4) {
        this.anInt2873 = var1;
        this.anInt2874 = var2;
        this.anInt2875 = var3;
        this.anInt2876 = var4;
        this.aBoolean2872 = true;
        this.repaint();
    }

    public void method204() {
        this.aBoolean2872 = false;
        this.repaint();
    }

    public void method205() {
        this.method201();
        this.aClass54_2878 = new Class54(this);
        this.aClass54_2878.method1415().drawImage(this.buffer, 0, 0, (ImageObserver) null);
        this.aBooleanArrayArray2879 = new boolean[28][52];

        for (int var1 = 0; var1 < 28; ++var1) {
            for (int var2 = 0; var2 < 52; ++var2) {
                this.aBooleanArrayArray2879[var1][var2] = false;
            }
        }

        this.aBoolean2880 = false;
    }

    public void method206(int var1, int var2) {
        this.aBooleanArrayArray2879[var2][var1] = true;
        this.aBoolean2880 = true;
    }

    public void method207() {
        this.aClass54_2878.method1416();
        int var5;
        if (this.aBoolean2880) {
            this.method172(this.aBooleanArrayArray2879);

            for (int var1 = 0; var1 < 28; ++var1) {
                for (int var2 = 0; var2 < 52; ++var2) {
                    if (this.aBooleanArrayArray2879[var1][var2]) {
                        int var3 = (var2 - 1) * 15;
                        int var4 = (var1 - 1) * 15;
                        var5 = var3 + 45;
                        int var6 = var4 + 45;
                        this.aClass54_2878.method1415().drawImage(this.buffer, var3, var4, var5, var6, var3, var4, var5, var6, (ImageObserver) null);
                        this.aBooleanArrayArray2879[var1][var2] = false;
                        this.aClass54_2878.method1417(var3, var4, var5, var6);
                    }
                }
            }

            this.aBoolean2880 = false;
        }

        GameBall_Sub1[] var7 = this.aClass43_Sub1_2866.method1325();
        Graphics var8 = this.aClass54_2878.method1415();

        for (var5 = 0; var5 < var7.length; ++var5) {
            var7[var5].method1281(var8, this.buffer, this.aClass54_2878);
        }

        for (var5 = 0; var5 < var7.length; ++var5) {
            var7[var5].method1282(var8, this.aClass54_2878, this.aBoolean2877, false);
        }

        this.aClass54_2878.method1418();
    }

    public void method208() {
        this.aClass54_2878 = null;
        this.aBooleanArrayArray2879 = (boolean[][]) null;
        this.repaint();
    }

    public Image method209() {
        return this.buffer;
    }

    public void method174() {
        this.aBoolean2881 = true;
        this.method201();
        this.removeMouseMotionListener(this);
        this.removeMouseListener(this);
        super.method174();
        this.aClass43_Sub1_2866 = null;
        this.anInterface5_2867 = null;
        this.anIPanel_Sub36_2868 = null;
        this.aClass54_2878 = null;
        this.aBooleanArrayArray2879 = (boolean[][]) null;
    }

    private void method210(MouseEvent var1) {
        this.anInt2870 = var1.getX();
        this.anInt2871 = var1.getY();
        if (this.aClass54_2878 == null) {
            this.repaint();
        }

    }

}
