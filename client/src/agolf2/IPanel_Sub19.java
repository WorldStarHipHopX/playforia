package agolf2;

import com.aapeli.client.IPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class IPanel_Sub19 extends IPanel implements MouseListener {

    private static final Color aColor3017 = new Color(0, 128, 0);
    private int anInt3018;
    private int anInt3019;
    private int anInt3020;
    private Block[] aBlockArray3021;
    private Interface2 anInterface2_3022;


    protected IPanel_Sub19(int var1, int var2, Interface2 var3) {
        this.anInt3018 = var1;
        this.anInt3019 = var2;
        this.anInterface2_3022 = var3;
        this.setSize(1 + var1 * 16, 1 + var2 * 16);
        this.anInt3020 = var1 * var2;
        this.aBlockArray3021 = new Block[this.anInt3020];
        this.addMouseListener(this);
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);

        for (int var2 = 0; var2 < this.anInt3020; ++var2) {
            int var3 = 1 + var2 % this.anInt3018 * 16;
            int var4 = 1 + (this.anInt3020 - 1 - var2) / this.anInt3018 * 16;
            if (this.aBlockArray3021[var2] != null) {
                var1.drawImage(this.aBlockArray3021[var2].method1207(), var3, var4, this);
            } else {
                var1.setColor(aColor3017);
                var1.drawRect(var3, var4, 14, 14);
            }
        }

    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        int var2 = var1.getX();
        int var3 = var1.getY();
        var2 /= 16;
        var3 /= 16;
        if (var2 < this.anInt3018 && var3 < this.anInt3019) {
            int var4 = (this.anInt3019 - 1 - var3) * this.anInt3018 + var2;
            if (this.aBlockArray3021[var4] != null) {
                this.anInterface2_3022.method2(this.aBlockArray3021[var4], var1.isMetaDown());
            }
        }
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    protected void method618(Block var1) {
        int var2;
        for (var2 = 0; var2 < this.anInt3020; ++var2) {
            if (this.aBlockArray3021[var2] != null) {
                if (var1.equals(this.aBlockArray3021[var2])) {
                    return;
                }
            } else {
                var2 = this.anInt3020;
            }
        }

        for (var2 = this.anInt3020 - 1; var2 >= 1; --var2) {
            this.aBlockArray3021[var2] = this.aBlockArray3021[var2 - 1];
        }

        this.aBlockArray3021[0] = var1;
        this.repaint();
    }

}
