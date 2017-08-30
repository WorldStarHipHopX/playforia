package agolf2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Canvas_Sub6_Sub1 extends Canvas_Sub6 implements MouseListener, MouseMotionListener, KeyListener {

    private static final Color aColor2845 = new Color(0, 128, 0);
    private static final Color aColor2846 = Color.RED;
    private static final Color aColor2847 = new Color(0, 32, 0);
    private static final Color aColor2848 = Color.BLACK;
    private static final Color aColor2849 = aColor2846;
    private Interface4 anInterface4_2850;
    private int anInt2851;
    private int anInt2852;
    private boolean aBoolean2853;
    private boolean aBoolean2854;
    private int anInt2855;
    private int anInt2856;
    private int anInt2857;
    private int anInt2858;
    private int anInt2859;
    private int anInt2860;
    private int anInt2861;
    private Block[] aBlockArray2862;
    private boolean aBoolean2863;
    private boolean aBoolean2864;


    public Canvas_Sub6_Sub1(Class52 var1, Interface4 var2) {
        super(var1, false, false, false);
        this.anInterface4_2850 = var2;
        this.method165();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.aBoolean2853 = this.aBoolean2854 = false;
        this.aBoolean2863 = this.aBoolean2864 = false;
        this.setCursor(Cursor.getPredefinedCursor(1));
        this.anInt2851 = this.anInt2852 = -1;
    }

    public void mouseEntered(MouseEvent var1) {
        this.method198(var1);
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean2853 = this.aBoolean2854 = false;
        this.anInt2851 = this.anInt2852 = -1;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.method198(var1);
        int[] var2 = this.method169(this.anInt2851, this.anInt2852);
        if (var2 != null) {
            this.anInterface4_2850.method6(this.anInt2851, this.anInt2852, var2[0], var2[1], var1.isMetaDown());
        }

    }

    public void mouseReleased(MouseEvent var1) {
        this.method198(var1);
        int[] var2 = this.method169(this.anInt2851, this.anInt2852);
        if (var2 != null) {
            this.anInterface4_2850.method8(this.anInt2851, this.anInt2852, var2[0], var2[1], var1.isMetaDown());
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
        this.method198(var1);
        int[] var2 = this.method169(this.anInt2851, this.anInt2852);
        if (var2 != null) {
            this.anInterface4_2850.method5(this.anInt2851, this.anInt2852, var2[0], var2[1]);
        }

    }

    public void mouseDragged(MouseEvent var1) {
        this.method198(var1);
        int[] var2 = this.method169(this.anInt2851, this.anInt2852);
        if (var2 != null) {
            this.anInterface4_2850.method7(this.anInt2851, this.anInt2852, var2[0], var2[1], var1.isMetaDown());
        }

    }

    public void keyPressed(KeyEvent var1) {
        this.anInterface4_2850.method9(var1.getKeyCode(), var1.isControlDown());
    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyTyped(KeyEvent var1) {
    }

    protected void method175(Graphics var1) {
        int var2;
        int var3;
        int var4;
        int var5;
        if (this.aBoolean2853) {
            var2 = Math.min(this.anInt2855, this.anInt2857);
            var3 = Math.min(this.anInt2856, this.anInt2858);
            var4 = Math.max(this.anInt2855, this.anInt2857);
            var5 = Math.max(this.anInt2856, this.anInt2858);
            var1.setColor(aColor2849);
            var1.drawRect(var2 * 15, var3 * 15, (var4 + 1) * 15 - 1 - var2 * 15, (var5 + 1) * 15 - 1 - var3 * 15);
        }

        if (this.aBoolean2854) {
            var2 = this.aBlockArray2862.length;
            var3 = var2 / this.anInt2861;
            var4 = 0;
            var5 = this.anInt2859 - this.anInt2861 / 2;
            int var6 = this.anInt2860 - var3 / 2;

            for (int var7 = var6; var7 < var6 + var3; ++var7) {
                for (int var8 = var5; var8 < var5 + this.anInt2861; ++var8) {
                    if (var8 >= 0 && var8 < 52 && var7 >= 0 && var7 < 28) {
                        var1.drawImage(this.aBlockArray2862[var4].method1207(), var8 * 15, var7 * 15, this);
                    }

                    ++var4;
                }
            }

            var1.setColor(aColor2849);
            var1.drawRect(var5 * 15, var6 * 15, (var5 + this.anInt2861) * 15 - 1 - var5 * 15, (var6 + var3) * 15 - 1 - var6 * 15);
        }

        if (this.aBoolean2863) {
            var1.setColor(aColor2848);

            for (var2 = 4; var2 < 52; var2 += 4) {
                var1.drawLine(var2 * 15, 0, var2 * 15, 420);
            }

            for (var2 = 4; var2 < 28; var2 += 4) {
                var1.drawLine(0, var2 * 15, 780, var2 * 15);
            }
        }

        if (this.anInt2851 >= 0 && this.anInt2852 >= 0) {
            var2 = this.anInt2851 / 15 * 15;
            var3 = this.anInt2852 / 15 * 15;
            if (!this.aBoolean2853 && !this.aBoolean2854) {
                var4 = this.anInterface4_2850.method10();
                var1.setColor(var4 == 2 ? aColor2846 : aColor2845);
                var1.drawRect(var2, var3, 14, 14);
                if (var4 == 1) {
                    var1.drawLine(var2, var3, var2 - 4, var3 - 4);
                    var1.drawLine(var2 + 15 - 1, var3, var2 + 15 - 1 + 4, var3 - 4);
                    var1.drawLine(var2, var3 + 15 - 1, var2 - 4, var3 + 15 - 1 + 4);
                    var1.drawLine(var2 + 15 - 1, var3 + 15 - 1, var2 + 15 - 1 + 4, var3 + 15 - 1 + 4);
                }
            }

            if (this.aBoolean2864) {
                var1.setColor(aColor2847);

                for (var2 = this.anInt2851 + 15; var2 < 780; var2 += 30) {
                    var1.drawLine(var2, this.anInt2852, var2 + 15, this.anInt2852);
                }

                for (var2 = this.anInt2851 - 15; var2 >= 0; var2 -= 30) {
                    var1.drawLine(var2, this.anInt2852, var2 - 15, this.anInt2852);
                }

                for (var3 = this.anInt2852 + 15; var3 < 420; var3 += 30) {
                    var1.drawLine(this.anInt2851, var3, this.anInt2851, var3 + 15);
                }

                for (var3 = this.anInt2852 - 15; var3 >= 0; var3 -= 30) {
                    var1.drawLine(this.anInt2851, var3, this.anInt2851, var3 - 15);
                }
            }
        }

    }

    public void method193(int var1, int var2, int var3, int var4) {
        this.anInt2855 = var1;
        this.anInt2856 = var2;
        this.anInt2857 = var3;
        this.anInt2858 = var4;
        this.aBoolean2853 = true;
        this.repaint();
    }

    public void method194() {
        this.aBoolean2853 = false;
        this.repaint();
    }

    public void method195(int var1, int var2, Block[] var3, int var4) {
        this.anInt2859 = var1;
        this.anInt2860 = var2;
        this.aBlockArray2862 = var3;
        this.anInt2861 = var4;
        this.aBoolean2854 = true;
        this.repaint();
    }

    public void method196(boolean var1) {
        this.aBoolean2863 = var1;
        this.repaint();
    }

    public void method197(boolean var1) {
        this.aBoolean2864 = var1;
        this.repaint();
    }

    private void method198(MouseEvent var1) {
        this.anInt2851 = var1.getX();
        this.anInt2852 = var1.getY();
        this.repaint();
    }

}
