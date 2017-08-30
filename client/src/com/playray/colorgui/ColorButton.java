package com.playray.colorgui;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.Class124;
import com.playray.colorgui.Class128;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.util.Enumeration;
import java.util.Vector;

public class ColorButton extends SPanel implements MouseMotionListener, MouseListener {

    public static final int BORDER_NONE = 0;
    public static final int BORDER_NORMAL = 1;
    public static final int BORDER_THICK = 2;
    private static final Color aColor4346;
    private Color aColor4347;
    private Color aColor4348;
    private Color aColor4349;
    private Color aColor4350;
    private Color aColor4351;
    private Color aColor4352;
    private Color aColor4353;
    private Image anImage4354;
    private Image anImage4355;
    private Image anImage4356;
    private Image anImage4357;
    private Image anImage4358;
    private int anInt4359;
    private int anInt4360;
    private int anInt4361;
    private int anInt4362;
    private int anInt4363;
    private int anInt4364;
    private boolean aBoolean4365;
    private String aString4366;
    private String aString4367;
    private Font aFont4368;
    private Font aFont4369;
    private boolean aBoolean4370;
    private boolean aBoolean4371;
    private boolean aBoolean4372;
    private int anInt4373;
    private Vector aVector4374;
    private Class124 aClass124_4375;
    private boolean aBoolean4376;
    private Object anObject4377;
    private static final String[] aStringArray4378 = new String[2];


    public ColorButton() {
        this((String) null);
    }

    public ColorButton(String var1) {
        this.anObject4377 = new Object();
        this.setBackground(aColor4346);
        this.setForeground(Class128.aColor1999);
        this.setFont(Class128.aFont1998);
        this.setLabel(var1);
        this.setSecondaryFont(new Font("Dialog", 0, 11));
        this.setSecondaryLabel((String) null);
        this.aBoolean4370 = true;
        this.aBoolean4371 = this.aBoolean4372 = false;
        this.anInt4373 = 1;
        this.aVector4374 = new Vector();
        this.aClass124_4375 = null;
        this.aBoolean4376 = false;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean4371 = this.aBoolean4372 = false;
        this.repaint();
    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        boolean var5 = this.isHighlighted();
        if (this.anImage4354 != null && this.anImage4355 != null) {
            Image var17 = var5 ? this.anImage4355 : this.anImage4354;
            if (!this.aBoolean4365) {
                var1.drawImage(var17, 0, 0, var3, var4, this.anInt4359, this.anInt4360, this.anInt4359 + var3, this.anInt4360 + var4, this);
            } else {
                var1.drawImage(var17, 0, 0, var3, var4, this);
            }
        } else {
            Color var6 = var5 ? this.aColor4350 : this.aColor4347;
            if (this.aBoolean4370) {
                this.method2823(var1, var6, var3, var4);
            } else {
                var1.setColor(var6);
                this.clearBackground(var1, var3, var4);
            }
        }

        if (this.aColor4353 != null) {
            var1.setColor(this.aColor4353);
        }

        this.drawBorder(var1, var3, var4);
        if (this.anImage4356 != null) {
            var1.drawImage(this.isNormalState() ? this.anImage4356 : this.anImage4357, this.anInt4361 > 0 ? var3 / 2 - this.anInt4361 / 2 : 0, this.anInt4362 > 0 ? var4 / 2 - this.anInt4362 / 2 : 0, this);
        }

        int var16 = var3 / 2;
        int var7 = 0;
        int var8;
        int var9;
        if (this.anImage4358 != null) {
            var8 = (var4 - this.anInt4364) / 2;
            var9 = this.drawIcon(var1, this.anImage4358, var8);
            var16 = var3 / 2 + var8 + this.anInt4363 / 2 - 1;
            var7 = var9 + this.anInt4363 + 1;
        }

        if (this.aString4366 != null) {
            var1.setColor(this.aColor4348);
            if (this.aString4367 == null) {
                Font var18 = this.method2826(this.method2825(this.aFont4368), this.aString4366, var3 - 2);
                var1.setFont(var18);
                var9 = var16 - this.getFontMetrics(var18).stringWidth(this.aString4366) / 2;
                if (var9 < var7) {
                    var9 = var7;
                }

                StringDraw.drawOutlinedString(var1, this.aColor4349, this.aString4366, var9, var4 / 2 + var18.getSize() * 3 / 8 + 1, -1);
            } else {
                var8 = this.aFont4368.getSize();
                var9 = this.aFont4369.getSize();
                if (var9 > var8) {
                    var8 = var9;
                }

                String var10 = this.aString4366 + "  ";
                String var11 = "  " + this.aString4367;
                Font var12 = this.method2826(this.method2825(this.aFont4368), var10 + var11, var3 - 2);
                Font var13 = this.method2826(this.method2825(this.aFont4369), var10 + var11, var3 - 2);
                int var14 = this.getFontMetrics(var12).stringWidth(var10);
                int var15 = this.getFontMetrics(var13).stringWidth(var11);
                var1.setFont(var12);
                StringDraw.drawOutlinedString(var1, this.aColor4349, var10, var16 - (var14 + var15) / 2, var4 / 2 + var8 * 3 / 8 + 1, -1);
                var1.setFont(var13);
                StringDraw.drawOutlinedString(var1, this.aColor4349, var11, var16 - (var14 + var15) / 2 + var14, var4 / 2 + var8 * 3 / 8 + 1, -1);
            }
        }

    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean4371 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean4371 = this.aBoolean4372 = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean4372 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean4372;
        this.aBoolean4372 = false;
        this.repaint();
        if (var2) {
            this.processActionEvent();
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
    }

    public void setBackground(Color var1) {
        if (var1 == null) {
            var1 = aColor4346;
        }

        super.setBackground(var1);
        this.aColor4347 = var1;
        this.aColor4350 = this.method2822(var1, 32);
        this.aColor4351 = this.method2822(var1, 48);
        this.aColor4352 = this.method2822(var1, -48);
        this.repaint();
    }

    public void setBackgroundFade(boolean var1) {
        this.aBoolean4370 = var1;
    }

    public void setForeground(Color var1) {
        if (var1 == null) {
            var1 = Class128.aColor1999;
        }

        this.aColor4348 = var1;
        this.repaint();
    }

    public void setOutline(Color var1) {
        this.aColor4349 = var1;
        this.repaint();
    }

    public void setBackgroundImage(Image var1) {
        this.setBackgroundImage(var1, var1, 0, 0);
    }

    public void setBackgroundImage(Image var1, Image var2) {
        this.setBackgroundImage(var1, var2, 0, 0);
    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        this.setBackgroundImage(var1, var1, var2, var3);
    }

    public void setBackgroundImage(Image var1, Image var2, int var3, int var4) {
        this.anImage4354 = var1;
        this.anImage4355 = var2;
        this.anInt4359 = var3;
        this.anInt4360 = var4;
        this.aBoolean4365 = false;

        try {
            this.setSize(var1.getWidth((ImageObserver) null), var1.getHeight((ImageObserver) null));
        } catch (Exception var6) {
            ;
        }

        this.setBorderType(0);
    }

    public void setFittedBackgroundImage(Image var1, Image var2) {
        this.anImage4354 = var1;
        this.anImage4355 = var2;
        this.aBoolean4365 = true;
        this.repaint();
    }

    public void setForegroundImage(Image var1) {
        this.setForegroundImage(var1, var1, 0, 0);
    }

    public void setForegroundImage(Image var1, Image var2) {
        this.setForegroundImage(var1, var2, 0, 0);
    }

    public void setForegroundImage(Image var1, int var2, int var3) {
        this.setForegroundImage(var1, var1, var2, var3);
    }

    public void setForegroundImage(Image var1, Image var2, int var3, int var4) {
        this.anImage4356 = var1;
        this.anImage4357 = var2;
        this.anInt4361 = var3;
        this.anInt4362 = var4;
        this.repaint();
    }

    public void setIconImage(Image var1) {
        if (var1 != null) {
            this.setIconImage(var1, var1.getWidth((ImageObserver) null), var1.getHeight((ImageObserver) null));
        } else {
            this.setIconImage((Image) null, -1, -1);
        }

    }

    public void setIconImage(Image var1, int var2, int var3) {
        this.anImage4358 = var1;
        this.anInt4363 = var2;
        this.anInt4364 = var3;
        this.repaint();
    }

    public void setFont(Font var1) {
        this.aFont4368 = var1;
        this.repaint();
    }

    public void setLabel(String var1) {
        this.aString4366 = var1;
        this.repaint();
    }

    public String getLabel() {
        return this.aString4366;
    }

    public void setSecondaryFont(Font var1) {
        this.aFont4369 = var1;
        this.repaint();
    }

    public void setSecondaryLabel(String var1) {
        if (var1 != this.aString4367) {
            this.aString4367 = var1;
            this.repaint();
        }
    }

    public String getSecondaryLabel() {
        return this.aString4367;
    }

    public void setBorderType(int var1) {
        this.anInt4373 = var1;
        this.repaint();
    }

    public int getBorderType() {
        return this.anInt4373;
    }

    public void setBorderColor(Color var1) {
        this.aColor4353 = var1;
        this.repaint();
    }

    public void click() {
        this.aBoolean4372 = true;
        this.mouseReleased((MouseEvent) null);
    }

    public Dimension getPreferredSize() {
        return new Dimension(13 + this.getFontMetrics(this.aFont4368).stringWidth(this.aString4366) + 13, 5 + this.aFont4368.getSize() + 5);
    }

    public void addActionListener(ActionListener var1) {
        Object var2 = this.anObject4377;
        synchronized (this.anObject4377) {
            this.aVector4374.addElement(var1);
        }
    }

    public void removeActionListener(ActionListener var1) {
        Object var2 = this.anObject4377;
        synchronized (this.anObject4377) {
            this.aVector4374.removeElement(var1);
        }
    }

    public void setFlashing(boolean var1) {
        if (var1) {
            if (this.aClass124_4375 != null) {
                return;
            }

            this.aClass124_4375 = new Class124(this, this);
            Thread var2 = new Thread(this.aClass124_4375);
            var2.setDaemon(true);
            var2.start();
        } else {
            if (this.aClass124_4375 == null) {
                return;
            }

            this.aClass124_4375.method2065();
            this.aClass124_4375 = null;
            this.aBoolean4376 = false;
            this.repaint();
        }

    }

    public Image createBuffer(int var1, int var2) {
        return this.createImage(var1, var2);
    }

    public void graphicsCreated(Graphics var1) {
    }

    public void baseBackgroundDrawn(Graphics var1) {
    }

    public boolean isNormalState() {
        return !this.aBoolean4372;
    }

    public void processActionEvent() {
        Object var1 = this.anObject4377;
        synchronized (this.anObject4377) {
            if (this.aVector4374.size() != 0) {
                ActionEvent var2 = new ActionEvent(this, 1001, this.aString4366);
                Enumeration var3 = this.aVector4374.elements();

                while (var3.hasMoreElements()) {
                    ((ActionListener) ((ActionListener) var3.nextElement())).actionPerformed(var2);
                }

            }
        }
    }

    public boolean isHighlighted() {
        boolean var1 = this.aBoolean4371;
        if (this.aClass124_4375 != null && this.aBoolean4376) {
            var1 = !var1;
        }

        return var1;
    }

    public boolean isBolded() {
        return false;
    }

    public void clearBackground(Graphics var1, int var2, int var3) {
        var1.fillRect(0, 0, var2, var3);
    }

    public void drawBorder(Graphics var1, int var2, int var3) {
        if (this.anInt4373 != 0) {
            boolean var4 = this.isNormalState();
            boolean var5 = this.anInt4373 == 1;
            if (this.aColor4353 == null) {
                var1.setColor(var4 ? this.aColor4352 : this.aColor4351);
            }

            if (var5) {
                var1.drawRect(0, 0, var2 - 1, var3 - 1);
            } else {
                var1.drawRect(0, 0, var2 - 1, var3 - 1);
                var1.drawRect(1, 1, var2 - 3, var3 - 3);
            }

            if (this.aColor4353 == null) {
                var1.setColor(var4 ? this.aColor4351 : this.aColor4352);
            }

            if (var5) {
                var1.drawLine(0, 0, var2 - 1, 0);
                var1.drawLine(0, 0, 0, var3 - 1);
            } else {
                var1.drawLine(0, 0, var2 - 2, 0);
                var1.drawLine(0, 1, var2 - 3, 1);
                var1.drawLine(0, 0, 0, var3 - 1);
                var1.drawLine(1, 0, 1, var3 - 2);
            }

        }
    }

    public int drawIcon(Graphics var1, Image var2, int var3) {
        var1.drawImage(var2, var3, var3, this);
        return var3;
    }

    public Color[] getLightAndDarkBorderColors() {
        return new Color[]{this.aColor4351, this.aColor4352};
    }

    private Color method2822(Color var1, int var2) {
        int var3 = var1.getRed() + var2;
        int var4 = var1.getGreen() + var2;
        int var5 = var1.getBlue() + var2;
        if (var3 < 0) {
            var3 = 0;
        }

        if (var3 > 255) {
            var3 = 255;
        }

        if (var4 < 0) {
            var4 = 0;
        }

        if (var4 > 255) {
            var4 = 255;
        }

        if (var5 < 0) {
            var5 = 0;
        }

        if (var5 > 255) {
            var5 = 255;
        }

        return new Color(var3, var4, var5);
    }

    private void method2823(Graphics var1, Color var2, int var3, int var4) {
        byte var5 = 0;
        if (this.anInt4373 != 0) {
            var5 = 1;
        }

        int var6 = var2.getRed();
        int var7 = var2.getGreen();
        int var8 = var2.getBlue();
        int var9 = var6;
        int var10 = var7;
        int var11 = var8;

        int var12;
        for (var12 = var4 / 2; var12 >= var5; --var12) {
            var1.setColor(new Color(var9, var10, var11));
            var1.drawLine(var5, var12, var3 - 1 - var5, var12);
            var9 = this.method2824(var9, 3);
            var10 = this.method2824(var10, 3);
            var11 = this.method2824(var11, 3);
        }

        var9 = var6;
        var10 = var7;
        var11 = var8;

        for (var12 = var4 / 2 + 1; var12 < var4 - var5; ++var12) {
            var9 = this.method2824(var9, -3);
            var10 = this.method2824(var10, -3);
            var11 = this.method2824(var11, -3);
            var1.setColor(new Color(var9, var10, var11));
            var1.drawLine(var5, var12, var3 - 1 - var5, var12);
        }

    }

    private int method2824(int var1, int var2) {
        var1 += var2;
        if (var1 < 0) {
            var1 = 0;
        }

        if (var1 > 255) {
            var1 = 255;
        }

        return var1;
    }

    private Font method2825(Font var1) {
        return this.isBolded() ? new Font(var1.getName(), 1, var1.getSize()) : var1;
    }

    private Font method2826(Font var1, String var2, int var3) {
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

    public void innerSetFlashState(boolean var1) {
        this.aBoolean4376 = var1;
        this.repaint();
    }

    static {
        aStringArray4378[0] = "  ";
        aStringArray4378[1] = "Dialog";
        aColor4346 = new Color(192, 192, 192);
    }
}
