package com.playray.colorgui;

import com.playray.client.SPanel;
import com.playray.colorgui.Class125;
import com.playray.colorgui.Class128;
import com.playray.colorgui.ColorCheckboxGroup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.ItemSelectable;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;

public class ColorCheckbox extends SPanel implements ComponentListener, ItemSelectable, MouseListener {

    public static final int ALIGN_LEFT = -1;
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_RIGHT = 1;
    private static final Color aColor4379 = new Color(248, 248, 248);
    private static final Color aColor4380 = Color.black;
    private Color aColor4381;
    private Color aColor4382;
    private String aString4383;
    private int anInt4384;
    private boolean aBoolean4385;
    private ColorCheckboxGroup aColorCheckboxGroup4386;
    private boolean aBoolean4387;
    private Vector aVector4388;
    private Class125 aClass125_4389;
    private int anInt4390;
    private Object anObject4391;


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
        this.aString4383 = var1;
        this.aBoolean4385 = var2;
        this.aVector4388 = new Vector();
        this.anInt4384 = -1;
        this.anInt4390 = 255;
        this.anObject4391 = new Object();
        this.setFont(Class128.aFont1998);
        this.setForeground(Class128.aColor1999);
        this.setBoxBackground(aColor4379);
        this.setBoxForeground(aColor4380);
        this.addComponentListener(this);
        this.addMouseListener(this);
        this.aColorCheckboxGroup4386 = null;
        this.aBoolean4387 = false;
    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        Font var5 = this.aString4383 != null ? this.method2831(this.getFont(), this.aString4383, var3 - (var4 + 4)) : null;
        int var6 = 0;
        int var7;
        if (this.anInt4384 == 0 || this.anInt4384 == 1) {
            var7 = var4 + 4 + (var5 != null ? this.getFontMetrics(var5).stringWidth(this.aString4383) : 0);
            if (this.anInt4384 == 0) {
                var6 = var3 / 2 - var7 / 2;
            } else {
                var6 = var3 - 2 - var7;
            }
        }

        var7 = var4 - 4;
        Color var8 = this.method2833(this.aColor4381);
        var1.setColor(var8);
        if (this.aColorCheckboxGroup4386 == null) {
            var1.fillRoundRect(var6 + 2, 2, var7, var7, 6, 6);
            if (this.aBoolean4387) {
                var1.setColor(var8.darker());
                var1.drawRoundRect(var6 + 2, 2, var7 - 1, var7 - 1, 6, 6);
            }
        } else {
            var1.fillRoundRect(var6 + 2, 2, var7, var7, 12, 12);
            if (this.aBoolean4387) {
                var1.setColor(var8.darker());
                var1.drawRoundRect(var6 + 2, 2, var7 - 1, var7 - 1, 12, 12);
            }
        }

        if (this.aBoolean4385) {
            var1.setColor(this.method2833(this.aColor4382));
            if (this.aColorCheckboxGroup4386 == null) {
                var7 -= 4;
                int var9 = var7 / 3;
                int var10 = var9 - 1;
                int var11 = var7 - var9 - 2;
                var1.drawLine(var6 + 4 + var9, 4 + var7 - 2, var6 + 4 + var9 - var10, 4 + var7 - 2 - var10);
                var1.drawLine(var6 + 4 + var9, 4 + var7 - 2 - 1, var6 + 4 + var9 - var10, 4 + var7 - 2 - var10 - 1);
                var1.drawLine(var6 + 4 + var9, 4 + var7 - 2 - 2, var6 + 4 + var9 - var10, 4 + var7 - 2 - var10 - 2);
                var1.drawLine(var6 + 4 + var9, 4 + var7 - 2, var6 + 4 + var9 + var11, 4 + var7 - 2 - var11);
                var1.drawLine(var6 + 4 + var9, 4 + var7 - 2 - 1, var6 + 4 + var9 + var11, 4 + var7 - 2 - var11 - 1);
                var1.drawLine(var6 + 4 + var9, 4 + var7 - 2 - 2, var6 + 4 + var9 + var11, 4 + var7 - 2 - var11 - 2);
            } else {
                var7 -= 6;
                var1.fillRect(var6 + 6, 5, var7 - 2, var7);
                var1.fillRect(var6 + 5, 6, var7, var7 - 2);
            }
        }

        if (var5 != null) {
            var1.setFont(var5);
            var1.setColor(this.method2833(this.getForeground()));
            this.drawText(var1, this.aString4383, var6 + var4 + 4, var4 / 2 + var5.getSize() * 3 / 8 + 1);
        }

    }

    public Dimension getPreferredSize() {
        Font var1 = this.getFont();
        int var2 = 3 + var1.getSize() + 3;
        return new Dimension(var2 + 4 + this.getFontMetrics(var1).stringWidth(this.aString4383) + 4, var2);
    }

    public void setEnabled(boolean var1) {
        if (this.isEnabled() != var1) {
            super.setEnabled(var1);
            if (this.isVisible()) {
                this.method2834();
            }

        }
    }

    public void componentShown(ComponentEvent var1) {
        this.componentHidden((ComponentEvent) null);
    }

    public void componentHidden(ComponentEvent var1) {
        this.method2835();
        this.anInt4390 = this.isEnabled() ? 255 : 128;
        this.repaint();
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
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
        if (this.isEnabled()) {
            boolean var2 = !this.aBoolean4385;
            if (this.aColorCheckboxGroup4386 == null || this.aColorCheckboxGroup4386.method2075(var2)) {
                this.realSetState(var2);
                this.method2832();
            }
        }
    }

    public void addItemListener(ItemListener var1) {
        Object var2 = this.anObject4391;
        synchronized (this.anObject4391) {
            this.aVector4388.addElement(var1);
        }
    }

    public void removeItemListener(ItemListener var1) {
        Object var2 = this.anObject4391;
        synchronized (this.anObject4391) {
            this.aVector4388.removeElement(var1);
        }
    }

    public Object[] getSelectedObjects() {
        if (!this.aBoolean4385) {
            return null;
        } else {
            Object[] var1 = new Object[]{this};
            return var1;
        }
    }

    public void setLabel(String var1) {
        this.aString4383 = var1;
        this.repaint();
    }

    public String getLabel() {
        return this.aString4383;
    }

    public void setAlign(int var1) {
        this.anInt4384 = var1;
        this.repaint();
    }

    public void setBoxBackground(Color var1) {
        this.aColor4381 = var1;
        this.repaint();
    }

    public void setBoxForeground(Color var1) {
        this.aColor4382 = var1;
        this.repaint();
    }

    public void setState(boolean var1) {
        if (this.aBoolean4385 != var1) {
            if (this.aColorCheckboxGroup4386 == null || this.aColorCheckboxGroup4386.method2075(var1)) {
                this.realSetState(var1);
            }
        }
    }

    public boolean getState() {
        return this.aBoolean4385;
    }

    public void click() {
        this.mouseReleased((MouseEvent) null);
    }

    public void setGroup(ColorCheckboxGroup var1) {
        this.aColorCheckboxGroup4386 = var1;
        var1.method2074(this);
        this.repaint();
    }

    public void setDrawBoxBorders(boolean var1) {
        this.aBoolean4387 = var1;
    }

    public void drawText(Graphics2D var1, String var2, int var3, int var4) {
        var1.drawString(var2, var3, var4);
    }

    public void realSetState(boolean var1) {
        this.aBoolean4385 = var1;
        this.repaint();
    }

    private Font method2831(Font var1, String var2, int var3) {
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

    private void method2832() {
        Object var1 = this.anObject4391;
        synchronized (this.anObject4391) {
            if (this.aVector4388.size() != 0) {
                ItemEvent var2 = new ItemEvent(this, 0, this, 701);
                Enumeration var3 = this.aVector4388.elements();

                while (var3.hasMoreElements()) {
                    ((ItemListener) ((ItemListener) var3.nextElement())).itemStateChanged(var2);
                }

            }
        }
    }

    private Color method2833(Color var1) {
        return this.isEnabled() && this.anInt4390 == 255 ? var1 : new Color(var1.getRed(), var1.getGreen(), var1.getBlue(), this.anInt4390);
    }

    private void method2834() {
        Object var1 = this.anObject4391;
        synchronized (this.anObject4391) {
            this.method2835();
            this.aClass125_4389 = new Class125(this, this);
        }
    }

    private void method2835() {
        Object var1 = this.anObject4391;
        synchronized (this.anObject4391) {
            if (this.aClass125_4389 != null) {
                this.aClass125_4389.method2066();
                this.aClass125_4389 = null;
            }

        }
    }

    protected void method2836() {
        if (this.isEnabled()) {
            this.anInt4390 += 20;
            if (this.anInt4390 >= 255) {
                this.anInt4390 = 255;
                this.method2835();
            }

            this.repaint();
        } else {
            this.anInt4390 -= 20;
            if (this.anInt4390 <= 128) {
                this.anInt4390 = 128;
                this.method2835();
            }

            this.repaint();
        }

    }

}
