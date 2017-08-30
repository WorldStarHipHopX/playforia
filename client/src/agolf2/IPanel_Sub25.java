package agolf2;

import agolf2.Interface3;
import com.aapeli.client.IPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class IPanel_Sub25 extends IPanel implements MouseMotionListener, MouseListener {

    private Image anImage3069;
    private int anInt3070;
    private int anInt3071;
    private Interface3 anInterface3_3072;
    private boolean aBoolean3073;
    private int anInt3074;
    private int anInt3075;
    private int anInt3076;
    private int anInt3077;
    private int[] anIntArray3078;
    private Image anImage3079;
    private Graphics aGraphics3080;


    protected IPanel_Sub25(Image var1, int var2, int var3, Interface3 var4, boolean var5) {
        this.anImage3069 = var1;
        this.anInt3070 = var2;
        this.anInt3071 = var3;
        this.anInterface3_3072 = var4;
        this.aBoolean3073 = var5;
        this.anInt3074 = var1.getWidth(this);
        this.anInt3075 = var1.getHeight(this);
        this.setSize(this.anInt3074, this.anInt3075);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void update(Graphics var1) {
        if (this.anImage3079 == null || this.aGraphics3080 == null) {
            Dimension var2 = this.getSize();
            if (var2.width <= 0 || var2.height <= 0) {
                return;
            }

            this.anImage3079 = this.createImage(var2.width, var2.height);
            this.aGraphics3080 = this.anImage3079.getGraphics();
        }

        this.drawBackground(this.aGraphics3080);
        if (this.anIntArray3078 == null) {
            this.aGraphics3080.drawImage(this.anImage3069, 0, 0, this);
        }

        if (this.anIntArray3078 != null) {
            for (int var3 = 0; var3 < this.anInt3071; ++var3) {
                for (int var4 = 0; var4 < this.anInt3070; ++var4) {
                    int var7 = var3 * this.anInt3070 + var4;
                    if (this.method665(var7)) {
                        int var5 = 1 + var4 * 16;
                        int var6 = 1 + var3 * 16;
                        this.aGraphics3080.drawImage(this.anImage3069, var5, var6, var5 + 15, var6 + 15, var5, var6, var5 + 15, var6 + 15, this);
                    }
                }
            }
        }

        if (this.anInt3076 >= 0 && this.anInt3077 >= 0) {
            if (this.anInt3076 == this.anInt3077) {
                if (this.aBoolean3073) {
                    this.method663(this.aGraphics3080, Color.BLACK, Color.WHITE, this.anInt3076 % this.anInt3070, this.anInt3076 / this.anInt3070);
                } else {
                    this.method662(this.aGraphics3080, Color.RED, this.anInt3076 % this.anInt3070, this.anInt3076 / this.anInt3070);
                }
            } else {
                this.method662(this.aGraphics3080, Color.BLACK, this.anInt3076 % this.anInt3070, this.anInt3076 / this.anInt3070);
                this.method662(this.aGraphics3080, Color.WHITE, this.anInt3077 % this.anInt3070, this.anInt3077 / this.anInt3070);
            }
        }

        var1.drawImage(this.anImage3079, 0, 0, this);
    }

    public void mouseMoved(MouseEvent var1) {
        this.anInterface3_3072.method3(this, this.method664(var1));
    }

    public void mouseDragged(MouseEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
        this.anInterface3_3072.method3(this, -1);
    }

    public void mousePressed(MouseEvent var1) {
        int var2 = this.method664(var1);
        if (var2 != -1) {
            boolean var3 = var1.isMetaDown();
            if (!this.aBoolean3073) {
                this.anInt3076 = this.anInt3077 = var2;
            } else if (!var3) {
                this.anInt3076 = var2;
            } else {
                this.anInt3077 = var2;
            }

            this.repaint();
            this.anInterface3_3072.method4(this, var2, var3);
        }
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    protected void method656(int[] var1) {
        this.anIntArray3078 = var1;
    }

    protected int method657() {
        return this.method658();
    }

    protected int method658() {
        return this.anInt3076;
    }

    protected int method659() {
        return this.anInt3077;
    }

    protected void method660(int var1) {
        this.method661(var1, var1);
    }

    protected void method661(int var1, int var2) {
        this.anInt3076 = var1;
        this.anInt3077 = var2;
        this.repaint();
    }

    private void method662(Graphics var1, Color var2, int var3, int var4) {
        var1.setColor(var2);
        var1.drawRect(1 + var3 * 16 - 1, 1 + var4 * 16 - 1, 16, 16);
    }

    private void method663(Graphics var1, Color var2, Color var3, int var4, int var5) {
        int var6 = 1 + var4 * 16 - 1;
        int var7 = 1 + var5 * 16 - 1;
        byte var8 = 16;
        byte var9 = 16;
        var1.setColor(var2);
        var1.drawRect(var6, var7, var8, var9);
        var1.setColor(var3);
        var1.drawLine(var6, var7, var6 + var8 / 2 - 1, var7);
        var1.drawLine(var6 + var8, var7, var6 + var8, var7 + var9 / 2 - 1);
        var1.drawLine(var6 + var8, var7 + var9, var6 + var8 / 2 + 1, var7 + var9);
        var1.drawLine(var6, var7 + var9, var6, var7 + var9 / 2 + 1);
    }

    private int method664(MouseEvent var1) {
        int var2 = var1.getX();
        int var3 = var1.getY();
        var2 /= 16;
        var3 /= 16;
        if (var2 < this.anInt3070 && var3 < this.anInt3071) {
            int var4 = var3 * this.anInt3070 + var2;
            return this.anIntArray3078 != null && !this.method665(var4) ? -1 : var4;
        } else {
            return -1;
        }
    }

    private boolean method665(int var1) {
        for (int var2 = 0; var2 < this.anIntArray3078.length; ++var2) {
            if (var1 == this.anIntArray3078[var2]) {
                return false;
            }
        }

        return true;
    }
}
