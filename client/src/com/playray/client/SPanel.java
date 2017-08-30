package com.playray.client;

import com.playray.client.Class119;
import com.playray.client.ImageManager;
import com.playray.client.SwingUpdateTarget;
import com.playray.client.SwingUpdateUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

public class SPanel extends JPanel implements SwingUpdateTarget {

    private Color aColor2604;
    private Image anImage2605;
    private int anInt2606;
    private int anInt2607;
    private Class119 aClass119_2608;
    private boolean aBoolean2609;
    private boolean aBoolean2610;
    private BufferedImage aBufferedImage2611;
    private Graphics2D aGraphics2D2612;
    private int anInt2613;
    private int anInt2614;
    public static boolean aBoolean2615;


    public SPanel() {
        this(true);
    }

    public SPanel(boolean var1) {
        super((LayoutManager) null, false);
        this.setOpaque(true);
        this.aBoolean2609 = var1;
        this.aBoolean2610 = false;
        this.aColor2604 = null;
    }

    public void paintComponent(Graphics var1) {
        if (!this.aBoolean2609) {
            this.drawBackground(var1);
            this.method2358(var1);
        } else {
            Dimension var2 = this.getSize();
            if (var2.width > 0 && var2.height > 0) {
                if (this.aBufferedImage2611 == null || var2.width != this.anInt2613 || var2.height != this.anInt2614) {
                    this.destroyBuffer();
                    this.anInt2613 = var2.width;
                    this.anInt2614 = var2.height;
                    this.aBufferedImage2611 = new BufferedImage(var2.width, var2.height, 1);
                    this.aGraphics2D2612 = this.aBufferedImage2611.createGraphics();
                    this.aGraphics2D2612.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                    this.aGraphics2D2612.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                }

                this.drawBackground(this.aGraphics2D2612);
                this.aGraphics2D2612.setColor(this.getForeground());
                this.paintContent(this.aGraphics2D2612);
                var1.drawImage(this.aBufferedImage2611, 0, 0, this);
                this.method2358(var1);
            }
        }
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public boolean isOpaque() {
        return true;
    }

    public void paintContent(Graphics2D var1) {
    }

    public void updateUI(Object var1) {
    }

    public void setMainBackgroundColor(Color var1) {
        this.aColor2604 = var1;
        this.recursiveRepaint();
    }

    public void setBackground(Image var1) {
        this.setBackground(var1, 0, 0);
    }

    public void setBackground(Image var1, int var2, int var3) {
        if (var1 != this.anImage2605 || var2 != this.anInt2606 || var3 != this.anInt2607) {
            this.anImage2605 = var1;
            this.anInt2606 = var2;
            this.anInt2607 = var3;
            this.recursiveRepaint();
        }
    }

    public void useCurrentBufferAsBackground() {
        this.setBackground(this.getBufferImage());
        this.destroyBuffer();
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
            synchronized (this) {
                if (this.aClass119_2608 != null) {
                    this.aClass119_2608.method1990();
                }

                this.aClass119_2608 = new Class119(this, this, var1, var2, var3, var4, false);
            }
        }

    }

    public void setSharedBackground(ImageManager var1, String var2, int var3, int var4) {
        synchronized (this) {
            if (this.aClass119_2608 != null) {
                this.aClass119_2608.method1990();
            }

            this.aClass119_2608 = new Class119(this, this, var1, var2, var3, var4, true);
        }
    }

    public void drawBackground(Graphics var1) {
        if (!this.drawBackgroundImage(var1)) {
            var1.setColor(this.getMainBackgroundColor());
            Dimension var2 = this.getSize();
            var1.fillRect(0, 0, var2.width, var2.height);
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
                    if (var1[var3] instanceof SPanel) {
                        ((SPanel) ((SPanel) var1[var3])).recursiveRepaint();
                    } else {
                        var1[var3].repaint();
                    }
                }

            }
        }
    }

    public void callUpdateUI(Object var1) {
        SwingUpdateUI.callUpdateUI(this, var1);
    }

    public void callUpdateUI(Object var1, boolean var2) {
        SwingUpdateUI.callUpdateUI(this, var1, var2);
    }

    public BufferedImage getBufferImage() {
        return this.aBufferedImage2611;
    }

    public void destroyBuffer() {
        if (this.aGraphics2D2612 != null) {
            this.aGraphics2D2612.dispose();
            this.aGraphics2D2612 = null;
        }

        if (this.aBufferedImage2611 != null) {
            this.aBufferedImage2611.flush();
            this.aBufferedImage2611 = null;
        }

    }

    public Object[] getBackgroundAndLocation(int var1, int var2) {
        if (this.anImage2605 != null) {
            return new Object[]{this.anImage2605, new Integer(this.anInt2606 + var1), new Integer(this.anInt2607 + var2)};
        } else {
            Container var3 = this.getParent();
            if (var3 == null) {
                return null;
            } else if (!(var3 instanceof SPanel)) {
                return null;
            } else {
                Point var4 = this.getLocation();
                var1 -= var4.x;
                var2 -= var4.y;
                SPanel var5 = (SPanel) ((SPanel) var3);
                return var5.getBackgroundAndLocation(var1, var2);
            }
        }
    }

    public Color getMainBackgroundColor() {
        if (this.aColor2604 != null) {
            return this.aColor2604;
        } else {
            Container var1 = this.getParent();
            if (var1 == null) {
                return Color.white;
            } else if (!(var1 instanceof SPanel)) {
                return var1.getBackground();
            } else {
                SPanel var2 = (SPanel) ((SPanel) var1);
                return var2.getMainBackgroundColor();
            }
        }
    }

    public void debug_drawBorder() {
        this.aBoolean2610 = true;
        this.repaint();
    }

    private void method2358(Graphics var1) {
        Dimension var2 = this.getSize();
        if (this.aBoolean2610) {
            var1.setColor(new Color(255, 0, 0, 128));
            var1.drawRect(0, 0, var2.width - 1, var2.height - 1);
        }

    }
}
