package com.playray.colorgui;

import com.playray.client.SPanel;
import com.playray.colorgui.LightTabBarItem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;

final class SPanel_Sub42 extends SPanel implements MouseMotionListener, MouseListener {

    private LightTabBarItem aLightTabBarItem4455;
    private Image anImage4456;
    private String[] aStringArray4457;
    private int anInt4458;
    private boolean aBoolean4459;
    private boolean aBoolean4460;
    private boolean aBoolean4461;
    private int anInt4462;


    protected SPanel_Sub42(LightTabBarItem var1, Image var2, String[] var3) {
        this.aLightTabBarItem4455 = var1;
        this.anImage4456 = var2;
        this.aStringArray4457 = var3;
        this.anInt4458 = 0;
        this.aBoolean4459 = this.aBoolean4460 = this.aBoolean4461 = false;
        this.anInt4462 = 255;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean4459 = this.aBoolean4460 = false;
        this.repaint();
    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (this.aBoolean4461) {
            var1.setColor(new Color(255, 255, 255, 224 * this.anInt4462 / 255));
            var1.fillRoundRect(0, 0, var3, var4 + 10, 8, 8);
        } else {
            var1.setColor(new Color(255, 255, 255, (128 + (this.aBoolean4459 ? 64 : 0)) * this.anInt4462 / 255));
            var1.fillRoundRect(0, 1, var3, var4 + 10, 8, 8);
        }

        int var5 = this.anImage4456 != null ? this.anImage4456.getWidth((ImageObserver) null) : 0;
        int var6 = this.anImage4456 != null ? this.anImage4456.getHeight((ImageObserver) null) : 0;
        if (this.anImage4456 != null && this.aStringArray4457[this.anInt4458] == null) {
            var1.drawImage(this.anImage4456, var3 / 2 - var5 / 2, var4 / 2 - var6 / 2 + 1, this);
        } else {
            int var7 = 3;
            if (this.anImage4456 != null) {
                var1.drawImage(this.anImage4456, 3, var4 / 2 - var6 / 2 + 1, this);
                var7 += var5 + 3;
            }

            if (this.aStringArray4457[this.anInt4458] != null) {
                Font var8 = var1.getFont();
                var1.setColor(Color.black);
                var1.drawString(this.aStringArray4457[this.anInt4458], var7, var8.getSize() * 7 / 8 + 2);
            }

        }
    }

    public Dimension getPreferredSize() {
        Font var1 = this.getFont();
        int var2 = 0;
        if (this.aStringArray4457[this.anInt4458] != null) {
            var2 = this.getFontMetrics(var1).stringWidth(this.aStringArray4457[this.anInt4458]);
        }

        return new Dimension(4 + (this.anImage4456 != null ? this.anImage4456.getWidth((ImageObserver) null) + 3 : 0) + var2 + 3 + 1, 4 + var1.getSize() + 4);
    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean4459 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean4459 = this.aBoolean4460 = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean4460 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean4460;
        this.aBoolean4460 = false;
        this.repaint();
        if (var2 && !this.aBoolean4461) {
            this.aLightTabBarItem4455.method2086();
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
    }

    protected void method2885() {
        this.anInt4458 = 0;
    }

    protected boolean method2886() {
        if (this.anInt4458 >= this.aStringArray4457.length - 1) {
            return false;
        } else {
            ++this.anInt4458;
            return true;
        }
    }

    protected void method2887(boolean var1) {
        this.aBoolean4461 = var1;
        this.repaint();
    }

    protected boolean method2888() {
        return this.aBoolean4461;
    }

    protected void method2889(int var1) {
        this.anInt4462 = var1;
    }
}
