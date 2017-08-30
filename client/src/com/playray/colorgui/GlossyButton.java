package com.playray.colorgui;

import com.playray.client.SPanel;
import com.playray.colorgui.Class129;
import com.playray.colorgui.Class130;
import com.playray.colorgui.Glossy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D.Float;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.LinkedList;

public class GlossyButton extends SPanel implements ComponentListener, MouseMotionListener, MouseListener {

    private static final Font aFont4432 = new Font("Dialog", 1, 13);
    private int anInt4433;
    private String aString4434;
    private Image anImage4435;
    private Image anImage4436;
    private boolean aBoolean4437;
    private boolean aBoolean4438;
    private boolean aBoolean4439;
    private LinkedList aLinkedList4440;
    private BufferedImage aBufferedImage4441;
    private Graphics2D aGraphics2D4442;
    private int anInt4443;
    private int anInt4444;
    private boolean aBoolean4445;
    private Color aColor4446;
    private double aDouble4447;
    private Class130 aClass130_4448;
    private int anInt4449;
    private Class129 aClass129_4450;
    private int anInt4451;
    private Object anObject4452;
    public static int anInt4453;
    private static final String aString4454 = "Dialog";


    public GlossyButton() {
        this((String) null, 0);
    }

    public GlossyButton(int var1) {
        this((String) null, var1);
    }

    public GlossyButton(String var1) {
        this(var1, 0);
    }

    public GlossyButton(String var1, int var2) {
        this.anObject4452 = new Object();
        this.setColor(var2);
        this.setFont(aFont4432);
        this.setLabel(var1);
        this.aBoolean4437 = this.aBoolean4438 = this.aBoolean4439 = false;
        this.aClass130_4448 = null;
        this.anInt4449 = 0;
        this.anInt4451 = 255;
        this.aLinkedList4440 = new LinkedList();
        this.addComponentListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        this.aBoolean4437 = this.aBoolean4438 = false;
        super.addNotify();
    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        boolean var5 = this.isEnabled();
        if (!var5) {
            this.aBoolean4437 = this.aBoolean4438 = false;
        }

        this.method2867(var3, var4);
        if (this.anInt4451 < 255) {
            this.method2873();
        }

        if (!this.aBoolean4438) {
            var1.drawImage(this.aBufferedImage4441, 0, 0, this);
        } else {
            int var6 = var3 / 50;
            int var7 = var4 / 50;
            var6 = Math.max(var6, 1);
            var7 = Math.max(var7, 1);
            var1.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            var1.drawImage(this.aBufferedImage4441, var6, var7, var3 - var6 * 2, var4 - var7 * 2, this);
        }

    }

    public void componentShown(ComponentEvent var1) {
        this.componentHidden((ComponentEvent) null);
    }

    public void componentHidden(ComponentEvent var1) {
        this.method2875();
        this.aBoolean4437 = this.aBoolean4438 = false;
        this.anInt4451 = this.isEnabled() ? 255 : 128;
        this.repaint();
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean4437 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean4437 = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean4438 = this.aBoolean4437 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean4438 && this.aBoolean4437;
        this.aBoolean4438 = false;
        this.repaint();
        if (var2) {
            this.processActionEvent();
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
        if (!this.aBoolean4437) {
            this.aBoolean4437 = true;
            this.repaint();
        }

    }

    public Dimension getPreferredSize() {
        Font var1 = this.getFont();
        return new Dimension(14 + this.getFontMetrics(var1).stringWidth(this.aString4434) + 14, 6 + var1.getSize() + 6);
    }

    public void setEnabled(boolean var1) {
        if (this.isEnabled() != var1) {
            super.setEnabled(var1);
            this.aBoolean4437 = this.aBoolean4438 = false;
            if (this.isVisible()) {
                this.method2874();
            }

        }
    }

    public void setColor(int var1) {
        this.anInt4433 = var1;
        this.repaint();
    }

    public void setLabel(String var1) {
        this.aString4434 = var1;
        this.repaint();
    }

    public String getLabel() {
        return this.aString4434;
    }

    public void setIconImage(Image var1) {
        this.anImage4435 = var1;
        this.repaint();
    }

    public void setFrontImage(Image var1) {
        this.anImage4436 = var1;
        this.repaint();
    }

    public void setTextGlow(boolean var1) {
        this.aBoolean4439 = var1;
        this.repaint();
    }

    public void addActionListener(ActionListener var1) {
        Object var2 = this.anObject4452;
        synchronized (this.anObject4452) {
            this.aLinkedList4440.addLast(var1);
        }
    }

    public void removeActionListener(ActionListener var1) {
        Object var2 = this.anObject4452;
        synchronized (this.anObject4452) {
            this.aLinkedList4440.addLast(var1);
        }
    }

    public void setFlashing(boolean var1) {
        if (var1) {
            if (this.aClass130_4448 != null) {
                return;
            }

            this.aClass130_4448 = new Class130(this, this);
            Thread var2 = new Thread(this.aClass130_4448);
            var2.setDaemon(true);
            var2.start();
        } else {
            if (this.aClass130_4448 == null) {
                return;
            }

            this.aClass130_4448.method2083();
            this.aClass130_4448 = null;
            this.anInt4449 = 0;
            this.repaint();
        }

    }

    public void setCombinedProgressBar(boolean var1, Color var2, double var3) {
        if (!var1) {
            if (this.aBoolean4445) {
                this.aBoolean4445 = false;
                this.repaint();
            }

        } else {
            this.aBoolean4445 = true;
            this.aColor4446 = var2;
            this.aDouble4447 = var3;
            this.repaint();
        }
    }

    public void processActionEvent() {
        Object var1 = this.anObject4452;
        synchronized (this.anObject4452) {
            if (!this.aLinkedList4440.isEmpty()) {
                ActionEvent var2 = new ActionEvent(this, 1001, this.aString4434);
                Iterator var3 = this.aLinkedList4440.iterator();

                while (var3.hasNext()) {
                    ((ActionListener) ((ActionListener) var3.next())).actionPerformed(var2);
                }

            }
        }
    }

    private void method2867(int var1, int var2) {
        if (this.aBufferedImage4441 == null || var1 != this.anInt4443 || var2 != this.anInt4444) {
            this.aBufferedImage4441 = new BufferedImage(var1, var2, 2);
            this.aGraphics2D4442 = this.aBufferedImage4441.createGraphics();
            this.aGraphics2D4442.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            this.aGraphics2D4442.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            this.anInt4443 = var1;
            this.anInt4444 = var2;
        }

        boolean var3 = this.isEnabled();
        this.drawBackground(this.aGraphics2D4442);
        int var4 = this.method2868(this.aGraphics2D4442, var1, var2, var3);
        if (this.anImage4436 != null) {
            this.aGraphics2D4442.drawImage(this.anImage4436, var1 / 2 - this.anImage4436.getWidth((ImageObserver) null) / 2, var2 / 2 - this.anImage4436.getHeight((ImageObserver) null) / 2, this);
        } else {
            int var5 = var1 / 2;
            int var6 = 0;
            int var8;
            if (this.anImage4435 != null) {
                int var7 = (var2 - this.anImage4435.getHeight((ImageObserver) null)) / 2;
                this.aGraphics2D4442.drawImage(this.anImage4435, var7, var7, this);
                var8 = this.anImage4435.getWidth((ImageObserver) null);
                var5 = var1 / 2 + var7 + var8 / 2 - 1;
                var6 = var7 + var8 + 1;
            }

            if (this.aString4434 != null) {
                Font var12 = this.method2872(this.getFont(), this.aString4434, var1 - (var4 + 1) * 2);
                this.aGraphics2D4442.setFont(var12);
                var8 = var5 - this.getFontMetrics(var12).stringWidth(this.aString4434) / 2;
                if (var8 < var6) {
                    var8 = var6;
                }

                int var9 = var12.getSize();
                int var10 = var2 / 2 + var9 * 2 / 5;
                int var11;
                if (this.aBoolean4439) {
                    this.aGraphics2D4442.setColor(new Color(255, 255, 255, 24));
                    this.aGraphics2D4442.drawString(this.aString4434, var8, var10 - 3);
                    this.aGraphics2D4442.drawString(this.aString4434, var8, var10 + 3);

                    for (var11 = -2; var11 <= 2; ++var11) {
                        this.aGraphics2D4442.drawString(this.aString4434, var8 + var11, var10 - 2);
                        this.aGraphics2D4442.drawString(this.aString4434, var8 + var11, var10 + 2);
                    }

                    for (var11 = -4; var11 <= 4; ++var11) {
                        this.aGraphics2D4442.drawString(this.aString4434, var8 + var11, var10 - 1);
                        this.aGraphics2D4442.drawString(this.aString4434, var8 + var11, var10 + 1);
                    }

                    for (var11 = -5; var11 <= 5; ++var11) {
                        this.aGraphics2D4442.drawString(this.aString4434, var8 + var11, var10);
                    }
                }

                this.aGraphics2D4442.setColor(new Color(0, 0, 0, 48));
                this.aGraphics2D4442.drawString(this.aString4434, var8 - 1, var10);
                this.aGraphics2D4442.drawString(this.aString4434, var8 + 1, var10);
                this.aGraphics2D4442.drawString(this.aString4434, var8, var10 - 1);
                this.aGraphics2D4442.drawString(this.aString4434, var8, var10 + 1);
                if (this.aClass130_4448 != null && this.anInt4449 > 0 && !this.aBoolean4437 && !this.aBoolean4438) {
                    var11 = Math.min(this.anInt4449 * 40, 255);
                    this.aGraphics2D4442.setColor(new Color(var11, var11, var11, 160));
                } else {
                    this.aGraphics2D4442.setColor(Color.white);
                }

                this.aGraphics2D4442.drawString(this.aString4434, var8, var10);
            }

        }
    }

    private int method2868(Graphics2D var1, int var2, int var3, boolean var4) {
        int var5 = (int) (10.0D + (double) (var3 - 20) / 4.0D + 0.5D);
        int var6 = (int) ((double) var5 * 1.4D);
        int var7 = var3 >= 30 ? 2 : 1;
        var1.setColor(this.method2870(Glossy.COLOR_NORMAL[this.anInt4433]));
        var1.fillRoundRect(0, 0, var2, var3, var6, var5);
        var1.setColor(this.method2869(Glossy.COLOR_NORMAL[this.anInt4433]));
        var1.fillRoundRect(0, 0, var2 - var7, var3 * 3 / 4, var6, var5);
        var1.fillRoundRect(0, var3 / 3, var2 / 2, var3 - var7 - var3 / 3, var6, var5);
        var1.setColor(Glossy.COLOR_NORMAL[this.anInt4433]);
        var1.fillRoundRect(var7, var7, var2 - var7 * 2 - 1, var3 - var7 * 2 - 1, var6, var5);
        Shape var8 = var1.getClip();
        var1.setColor(Glossy.COLOR_GLOSSY[this.anInt4433]);
        var1.setClip(0, 0, var2, var3 / 4);
        var1.fillRoundRect(var7, var7, var2 - var7 * 2 - 1, var3 - var7 * 2 - 1, var6, var5);
        var1.setClip(1, var3 / 4, var2 - 2, var3 / 2 + 1 - var3 / 4);
        var1.fillRoundRect(var7, 1 - var3 / 2 + 2, var2 - var7 * 2 - 1, var3 - 3, var2 / 3, var3 / 4);
        var1.setClip(new Float(0.0F, 0.0F, (float) var2, (float) var3, (float) var6, (float) var5));
        int var9 = var3 / 2;
        double var10 = 48.0D;
        double var12 = var10 / (double) var9;

        for (int var14 = 0; var14 < var9; ++var14) {
            var1.setColor(new Color(255, 255, 255, (int) (var10 + 0.5D)));
            var1.drawLine(0, var14, var2, var14);
            var10 -= var12;
        }

        var1.setClip(var8);
        if (this.aBoolean4445) {
            var1.setColor(this.aColor4446);
            var1.fillRoundRect(var7, var7, (int) ((double) (var2 - var7 * 2) * this.aDouble4447 + 0.5D) - 1, var3 - var7 * 2 - 1, var6, var5);
        }

        var1.setColor(Color.white);
        var1.drawRoundRect(var7, var7, var2 - var7 * 2 - 1, var3 - var7 * 2 - 1, var6, var5);
        if (this.aBoolean4437 || this.aBoolean4438) {
            var1.setColor(new Color(255, 255, 255, 96));
            Stroke var15 = var1.getStroke();
            var1.setStroke(new BasicStroke(2.0F));
            var1.drawRoundRect(var7, var7, var2 - var7 * 2 - 1, var3 - var7 * 2 - 1, var6, var5);
            var1.setStroke(new BasicStroke(4.0F));
            var1.drawRoundRect(var7, var7, var2 - var7 * 2 - 1, var3 - var7 * 2 - 1, var6, var5);
            var1.setStroke(var15);
        }

        return var7 + 1;
    }

    private Color method2869(Color var1) {
        Color var2 = var1.brighter();
        return var2.equals(Color.white) ? this.method2871(var1, Color.white) : var2;
    }

    private Color method2870(Color var1) {
        Color var2 = var1.darker();
        return var2.equals(Color.black) ? this.method2871(var1, Color.black) : var2;
    }

    private Color method2871(Color var1, Color var2) {
        int var3 = var1.getRed();
        int var4 = var1.getGreen();
        int var5 = var1.getBlue();
        int var6 = var2.getRed();
        int var7 = var2.getGreen();
        int var8 = var2.getBlue();
        int var9 = (var3 + var6) / 2;
        int var10 = (var4 + var7) / 2;
        int var11 = (var5 + var8) / 2;
        return new Color(var9, var10, var11);
    }

    private Font method2872(Font var1, String var2, int var3) {
        int var4 = this.getFontMetrics(var1).stringWidth(var2);
        if (var4 <= var3) {
            return var1;
        } else {
            int var7 = var1.getSize();

            do {
                Font var5 = var1;
                int var6 = var4;
                --var7;
                var1 = new Font(var1.getName(), var1.getStyle(), var7);
                var4 = this.getFontMetrics(var1).stringWidth(var2);
                if (var4 >= var6) {
                    return var5;
                }
            } while (var4 > var3 && var7 > 9);

            return var1;
        }
    }

    private void method2873() {
        int[] var1 = new int[this.anInt4443 * this.anInt4444];
        this.aBufferedImage4441.getRGB(0, 0, this.anInt4443, this.anInt4444, var1, 0, this.anInt4443);

        for (int var2 = 0; var2 < var1.length; ++var2) {
            long var3 = (long) var1[var2] & 16777215L;
            long var5 = ((long) var1[var2] & 4278190080L) >> 24;
            var5 = (long) ((double) var5 * ((double) this.anInt4451 / 255.0D));
            var1[var2] = (int) ((var5 << 24) + var3);
        }

        this.aBufferedImage4441.setRGB(0, 0, this.anInt4443, this.anInt4444, var1, 0, this.anInt4443);
    }

    private void method2874() {
        Object var1 = this.anObject4452;
        synchronized (this.anObject4452) {
            this.method2875();
            this.aClass129_4450 = new Class129(this, this);
        }
    }

    private void method2875() {
        Object var1 = this.anObject4452;
        synchronized (this.anObject4452) {
            if (this.aClass129_4450 != null) {
                this.aClass129_4450.method2082();
                this.aClass129_4450 = null;
            }

        }
    }

    protected void method2876() {
        if (this.isEnabled()) {
            this.anInt4451 += 20;
            if (this.anInt4451 >= 255) {
                this.anInt4451 = 255;
                this.method2875();
            }

            this.repaint();
        } else {
            this.anInt4451 -= 20;
            if (this.anInt4451 <= 128) {
                this.anInt4451 = 128;
                this.method2875();
            }

            this.repaint();
        }

    }

    protected void method2877(int var1) {
        this.anInt4449 = var1;
        this.repaint();
    }

}
