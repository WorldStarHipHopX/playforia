package com.aapeli.colorgui;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.Class94;
import com.aapeli.colorgui.ColorCheckboxGroup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;

public class ColorCheckbox extends IPanel implements ItemSelectable, MouseListener {

    public static final int ALIGN_LEFT = -1;
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_RIGHT = 1;
    private static final Color aColor3289 = new Color(248, 248, 248);
    private static final Color aColor3290 = Color.black;
    private Font aFont3291;
    private Color aColor3292;
    private Color aColor3293;
    private Color aColor3294;
    private Color aColor3295;
    private Color aColor3296;
    private Image anImage3297;
    private int anInt3298;
    private int anInt3299;
    private String aString3300;
    private int anInt3301;
    private boolean aBoolean3302;
    private boolean aBoolean3303;
    private ColorCheckboxGroup aColorCheckboxGroup3304;
    private Vector aVector3305;
    private Image anImage3306;
    private Graphics aGraphics3307;
    private int anInt3308;
    private int anInt3309;


    public ColorCheckbox() {
        this((String) null, false);
    }

    public ColorCheckbox(boolean var1) {
        this((String) null, var1);
    }

    public ColorCheckbox(String var1) {
        this(var1, false);
    }

    public ColorCheckbox(String var1, boolean var2) {
        this.aString3300 = var1;
        this.aBoolean3302 = var2;
        this.aVector3305 = new Vector();
        this.anInt3301 = -1;
        this.aBoolean3303 = false;
        this.setFont(Class94.aFont1575);
        this.setForeground(Class94.aColor1576);
        this.setBoxBackground(aColor3289);
        this.setBoxForeground(aColor3290);
        this.addMouseListener(this);
        this.aColorCheckboxGroup3304 = null;
    }

    public void update(Graphics var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (this.anImage3306 == null || var3 != this.anInt3308 || var4 != this.anInt3309) {
            this.anImage3306 = this.createBuffer(var3, var4);
            this.aGraphics3307 = this.getGraphics(this.anImage3306);
            this.anInt3308 = var3;
            this.anInt3309 = var4;
        }

        if (this.anImage3297 != null) {
            this.aGraphics3307.drawImage(this.anImage3297, 0, 0, var3, var4, this.anInt3298, this.anInt3299, this.anInt3298 + var3, this.anInt3299 + var4, this);
        } else {
            this.drawBackground(this.aGraphics3307);
        }

        Font var5 = this.aString3300 != null ? this.method837(this.aFont3291, this.aString3300, var3 - (var4 + 4)) : null;
        int var6 = 0;
        int var7;
        if (this.anInt3301 == 0 || this.anInt3301 == 1) {
            var7 = var4 + 4 + (var5 != null ? this.getFontMetrics(var5).stringWidth(this.aString3300) : 0);
            if (this.anInt3301 == 0) {
                var6 = var3 / 2 - var7 / 2;
            } else {
                var6 = var3 - 2 - var7;
            }
        }

        var7 = var4 - 4;
        if (this.aColorCheckboxGroup3304 == null) {
            this.method840(this.aGraphics3307, var6 + 2, 2, var7, var7, this.method839(this.aColor3293), this.method839(this.aColor3295), this.method839(this.aColor3296));
        } else {
            this.aGraphics3307.setColor(this.method839(this.aColor3293));
            this.aGraphics3307.fillRect(var6 + 3, 3, var7 - 2, var7 - 2);
            this.aGraphics3307.setColor(this.method839(this.aColor3295));
            this.aGraphics3307.drawLine(var6 + 3, var7 + 1, var6 + var7, var7 + 1);
            this.aGraphics3307.drawLine(var6 + var7 + 1, 3, var6 + var7 + 1, var7);
            this.aGraphics3307.fillRect(var6 + var7, 3, 1, 1);
            this.aGraphics3307.fillRect(var6 + var7, var7, 1, 1);
            this.aGraphics3307.setColor(this.method839(this.aColor3296));
            this.aGraphics3307.drawLine(var6 + 3, 2, var6 + var7, 2);
            this.aGraphics3307.drawLine(var6 + 2, 3, var6 + 2, var7);
            this.aGraphics3307.fillRect(var6 + 3, 3, 1, 1);
            this.aGraphics3307.fillRect(var6 + 3, var7, 1, 1);
        }

        if (this.aBoolean3302) {
            this.aGraphics3307.setColor(this.method839(this.aColor3294));
            if (this.aColorCheckboxGroup3304 == null) {
                var7 -= 4;
                int var8 = var7 / 3;
                int var9 = var8 - 1;
                int var10 = var7 - var8 - 2;
                this.aGraphics3307.drawLine(var6 + 4 + var8, 4 + var7 - 2, var6 + 4 + var8 - var9, 4 + var7 - 2 - var9);
                this.aGraphics3307.drawLine(var6 + 4 + var8, 4 + var7 - 2 - 1, var6 + 4 + var8 - var9, 4 + var7 - 2 - var9 - 1);
                this.aGraphics3307.drawLine(var6 + 4 + var8, 4 + var7 - 2 - 2, var6 + 4 + var8 - var9, 4 + var7 - 2 - var9 - 2);
                this.aGraphics3307.drawLine(var6 + 4 + var8, 4 + var7 - 2, var6 + 4 + var8 + var10, 4 + var7 - 2 - var10);
                this.aGraphics3307.drawLine(var6 + 4 + var8, 4 + var7 - 2 - 1, var6 + 4 + var8 + var10, 4 + var7 - 2 - var10 - 1);
                this.aGraphics3307.drawLine(var6 + 4 + var8, 4 + var7 - 2 - 2, var6 + 4 + var8 + var10, 4 + var7 - 2 - var10 - 2);
            } else {
                var7 -= 6;
                this.aGraphics3307.fillRect(var6 + 6, 5, var7 - 2, var7);
                this.aGraphics3307.fillRect(var6 + 5, 6, var7, var7 - 2);
            }
        }

        if (var5 != null) {
            this.aGraphics3307.setFont(var5);
            this.aGraphics3307.setColor(this.method839(this.aColor3292));
            this.drawText(this.aGraphics3307, this.aString3300, var6 + var4 + 4, var4 / 2 + var5.getSize() * 3 / 8 + 1);
        }

        var1.drawImage(this.anImage3306, 0, 0, this);
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = !this.aBoolean3302;
        if (this.aColorCheckboxGroup3304 == null || this.aColorCheckboxGroup3304.method1748(var2)) {
            this.realSetState(var2);
            this.method838();
        }
    }

    public void addItemListener(ItemListener var1) {
        Vector var2 = this.aVector3305;
        synchronized (this.aVector3305) {
            this.aVector3305.addElement(var1);
        }
    }

    public void removeItemListener(ItemListener var1) {
        Vector var2 = this.aVector3305;
        synchronized (this.aVector3305) {
            this.aVector3305.removeElement(var1);
        }
    }

    public Object[] getSelectedObjects() {
        if (!this.aBoolean3302) {
            return null;
        } else {
            Object[] var1 = new Object[]{this};
            return var1;
        }
    }

    public void setLabel(String var1) {
        this.aString3300 = var1;
        this.repaint();
    }

    public String getLabel() {
        return this.aString3300;
    }

    public void setFont(Font var1) {
        this.aFont3291 = var1;
        this.repaint();
    }

    public void setAlign(int var1) {
        this.anInt3301 = var1;
        this.repaint();
    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        this.anImage3297 = var1;
        this.anInt3298 = var2;
        this.anInt3299 = var3;
        this.repaint();
    }

    public void setForeground(Color var1) {
        this.aColor3292 = var1;
        this.repaint();
    }

    public void setBoxBackground(Color var1) {
        this.aColor3293 = var1;
        this.aColor3295 = this.method835(var1, 32);
        this.aColor3296 = this.method835(var1, -48);
        this.repaint();
    }

    public void setBoxForeground(Color var1) {
        this.aColor3294 = var1;
        this.repaint();
    }

    public void setEnabled(boolean var1) {
        super.setEnabled(var1);
        this.repaint();
    }

    public void setState(boolean var1) {
        if (this.aBoolean3302 != var1) {
            if (this.aColorCheckboxGroup3304 == null || this.aColorCheckboxGroup3304.method1748(var1)) {
                this.realSetState(var1);
            }
        }
    }

    public boolean getState() {
        return this.aBoolean3302;
    }

    public void click() {
        this.mouseReleased((MouseEvent) null);
    }

    public Dimension getPreferredSize() {
        int var1 = 3 + this.aFont3291.getSize() + 3;
        return new Dimension(var1 + 4 + this.getFontMetrics(this.aFont3291).stringWidth(this.aString3300) + 4, var1);
    }

    public void setGroup(ColorCheckboxGroup var1) {
        this.aColorCheckboxGroup3304 = var1;
        var1.method1747(this);
        this.repaint();
    }

    public void setBoxPixelRoundedCorners(boolean var1) {
        this.aBoolean3303 = var1;
        this.repaint();
    }

    public Image createBuffer(int var1, int var2) {
        return this.createImage(var1, var2);
    }

    public Graphics getGraphics(Image var1) {
        return var1.getGraphics();
    }

    public void drawText(Graphics var1, String var2, int var3, int var4) {
        var1.drawString(var2, var3, var4);
    }

    public void realSetState(boolean var1) {
        this.aBoolean3302 = var1;
        this.repaint();
    }

    private Color method835(Color var1, int var2) {
        return new Color(this.method836(var1.getRed(), var2), this.method836(var1.getGreen(), var2), this.method836(var1.getBlue(), var2));
    }

    private int method836(int var1, int var2) {
        var1 += var2;
        if (var1 < 0) {
            var1 = 0;
        }

        if (var1 > 255) {
            var1 = 255;
        }

        return var1;
    }

    private Font method837(Font var1, String var2, int var3) {
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

    private void method838() {
        Vector var1 = this.aVector3305;
        synchronized (this.aVector3305) {
            if (this.aVector3305.size() != 0) {
                ItemEvent var2 = new ItemEvent(this, 0, this, 701);
                Enumeration var3 = this.aVector3305.elements();

                while (var3.hasMoreElements()) {
                    ((ItemListener) ((ItemListener) var3.nextElement())).itemStateChanged(var2);
                }

            }
        }
    }

    private Color method839(Color var1) {
        if (this.isEnabled()) {
            return var1;
        } else {
            Color var2 = this.getBackground();
            int var3 = (var1.getRed() + var2.getRed() * 2) / 3;
            int var4 = (var1.getGreen() + var2.getGreen() * 2) / 3;
            int var5 = (var1.getBlue() + var2.getBlue() * 2) / 3;
            return new Color(var3, var4, var5);
        }
    }

    private void method840(Graphics var1, int var2, int var3, int var4, int var5, Color var6, Color var7, Color var8) {
        if (this.aBoolean3303) {
            var1.setColor(var6);
            var1.fillRect(var2 + 1, var3 + 1, var4 - 2, var5 - 2);
            var1.setColor(var8);
            var1.drawLine(var2 + 1, var3, var2 + var4 - 2, var3);
            var1.drawLine(var2, var3 + 1, var2, var3 + var5 - 2);
            var1.setColor(var7);
            var1.drawLine(var2 + 1, var3 + var5 - 1, var2 + var4 - 2, var3 + var5 - 1);
            var1.drawLine(var2 + var4 - 1, var3 + 1, var2 + var4 - 1, var3 + var5 - 2);
        } else {
            var1.setColor(var6);
            var1.fillRect(var2, var3, var4, var5);
            var1.setColor(var7);
            var1.drawRect(var2, var3, var4 - 1, var5 - 1);
            var1.setColor(var8);
            var1.drawLine(var2, var3, var2 + var4 - 2, var3);
            var1.drawLine(var2, var3, var2, var3 + var5 - 1);
        }

    }

}
