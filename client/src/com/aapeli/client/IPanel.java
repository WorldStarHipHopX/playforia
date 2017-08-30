package com.aapeli.client;

import com.aapeli.client.Class84;
import com.aapeli.client.ImageManager;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.awt.image.ImageObserver;

public class IPanel extends Panel {

    private Image anImage644;
    private int anInt645;
    private int anInt646;
    private Class84 aClass84_647;
    private Object anObject648 = new Object();
    public static int anInt649;


    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
    }

    public void setBackground(Image var1) {
        this.setBackground(var1, 0, 0);
    }

    public void setBackground(Image var1, int var2, int var3) {
        this.anImage644 = var1;
        this.anInt645 = var2;
        this.anInt646 = var3;
        this.recursiveRepaint();
    }

    public void setBackground(ImageManager var1, String var2) {
        this.setBackground(var1, var2, 0, 0);
    }

    public void setBackground(ImageManager var1, String var2, int var3, int var4) {
        Image var5 = var1.getIfAvailable(var2);
        if (var5 != null) {
            this.setBackground(var5, var3, var4);
        } else {
            Object var6 = this.anObject648;
            synchronized (this.anObject648) {
                if (this.aClass84_647 != null) {
                    this.aClass84_647.method1653();
                }

                this.aClass84_647 = new Class84(this, this, var1, var2, var3, var4, false);
            }
        }

    }

    public void setSharedBackground(ImageManager var1, String var2, int var3, int var4) {
        Object var5 = this.anObject648;
        synchronized (this.anObject648) {
            if (this.aClass84_647 != null) {
                this.aClass84_647.method1653();
            }

            this.aClass84_647 = new Class84(this, this, var1, var2, var3, var4, true);
        }
    }

    public void drawBackground(Graphics var1) {
        if (!this.drawBackgroundImage(var1)) {
            Object var2 = this.getParent();
            if (var2 == null) {
                var2 = this;
            }

            Dimension var3 = this.getSize();
            var1.setColor(((Component) var2).getBackground());
            var1.fillRect(0, 0, var3.width, var3.height);
        }

    }

    public boolean drawBackgroundImage(Graphics var1) {
        Object[] var2 = this.getBackgroundAndLocation(0, 0);
        if (var2 == null) {
            return false;
        } else {
            Image var3 = (Image) ((Image) var2[0]);
            int var4 = ((Integer) ((Integer) var2[1])).intValue();
            int var5 = ((Integer) ((Integer) var2[2])).intValue();
            Dimension var6 = this.getSize();
            var1.drawImage(var3, 0, 0, var6.width, var6.height, -var4, -var5, -var4 + var6.width, -var5 + var6.height, (ImageObserver) null);
            return true;
        }
    }

    public void recursiveRepaint() {
        this.repaint();
        Component[] var1 = this.getComponents();
        if (var1 != null) {
            int var2 = var1.length;
            if (var2 != 0) {
                for (int var3 = 0; var3 < var2; ++var3) {
                    if (var1[var3] instanceof IPanel) {
                        ((IPanel) ((IPanel) var1[var3])).recursiveRepaint();
                    } else {
                        var1[var3].repaint();
                    }
                }

            }
        }
    }

    public Object[] getBackgroundAndLocation(int var1, int var2) {
        if (this.anImage644 != null) {
            return new Object[]{this.anImage644, new Integer(this.anInt645 + var1), new Integer(this.anInt646 + var2)};
        } else {
            Container var3 = this.getParent();
            if (var3 == null) {
                return null;
            } else if (!(var3 instanceof IPanel)) {
                return null;
            } else {
                Point var4 = this.getLocation();
                var1 -= var4.x;
                var2 -= var4.y;
                IPanel var5 = (IPanel) ((IPanel) var3);
                return var5.getBackgroundAndLocation(var1, var2);
            }
        }
    }
}
