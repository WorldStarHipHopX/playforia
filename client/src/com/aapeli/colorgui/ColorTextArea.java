package com.aapeli.colorgui;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.Class93;
import com.aapeli.colorgui.Class94;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class ColorTextArea extends IPanel implements ComponentListener, AdjustmentListener {

    public static final int COLOR_BLACK = 0;
    public static final int COLOR_RED = 1;
    public static final int COLOR_GREEN = 2;
    public static final int COLOR_BLUE = 3;
    public static final int COLOR_YELLOW = 4;
    public static final int COLOR_MAGENTA = 5;
    public static final int COLOR_CYAN = 6;
    public static final int COLOR_GRAY = 7;
    public static final int COLOR_WHITE = 8;
    public static final int BORDER_NONE = 0;
    public static final int BORDER_BEVELED = 1;
    public static final int BORDER_NONE_ROUNDCORNER = 2;
    private static final Color[] aColorArray3327;
    private static final Color aColor3328;
    private static final Color aColor3329;
    private static final Color aColor3330;
    private Scrollbar aScrollbar3331;
    private boolean aBoolean3332;
    private Image anImage3333;
    private int anInt3334;
    private int anInt3335;
    private Font aFont3336;
    private Font aFont3337;
    private FontMetrics aFontMetrics3338;
    private int anInt3339;
    private int anInt3340;
    private int anInt3341;
    private int anInt3342;
    private int anInt3343;
    private int anInt3344;
    private Vector aVector3345;
    private Vector aVector3346;
    private Image anImage3347;
    private Graphics aGraphics3348;
    private int anInt3349;
    private int anInt3350;
    private int anInt3351;
    private Object anObject3352;
    private static final String[] aStringArray3353 = new String[2];


    public ColorTextArea(int var1, int var2) {
        this(var1, var2, (Font) null);
    }

    public ColorTextArea(int var1, int var2, Font var3) {
        this.anObject3352 = new Object();
        this.anInt3340 = var1;
        this.anInt3341 = var2;
        this.setSize(var1, var2);
        if (var3 == null) {
            var3 = Class94.aFont1575;
        }

        this.aFont3336 = var3;
        this.aFontMetrics3338 = this.getFontMetrics(var3);
        this.anInt3339 = var3.getSize();
        this.aFont3337 = new Font(var3.getName(), 1, var3.getSize());
        this.aVector3345 = new Vector();
        this.aVector3346 = new Vector();
        this.anImage3333 = null;
        this.anInt3343 = this.anInt3339 + 3;
        this.method849();
        this.anInt3351 = 1;
        this.addComponentListener(this);
        this.setLayout((LayoutManager) null);
        this.aScrollbar3331 = new Scrollbar(1);
        this.method850();
        this.aScrollbar3331.setUnitIncrement(1);
        this.aBoolean3332 = false;
    }

    public void update(Graphics var1) {
        if (this.anImage3347 == null || this.anInt3340 != this.anInt3349 || this.anInt3341 != this.anInt3350) {
            this.anImage3347 = this.createImage(this.anInt3340, this.anInt3341);
            this.aGraphics3348 = this.anImage3347.getGraphics();
            this.anInt3349 = this.anInt3340;
            this.anInt3350 = this.anInt3341;
        }

        if (this.anImage3333 == null) {
            this.aGraphics3348.setColor(aColor3328);
            if (this.anInt3351 == 2) {
                this.drawBackground(this.aGraphics3348);
                this.aGraphics3348.fillRect(4, 0, this.anInt3340 - 8, this.anInt3341);
                this.aGraphics3348.fillRect(2, 1, this.anInt3340 - 4, this.anInt3341 - 2);
                this.aGraphics3348.fillRect(1, 2, this.anInt3340 - 2, this.anInt3341 - 4);
                this.aGraphics3348.fillRect(0, 4, this.anInt3340, this.anInt3341 - 8);
            } else {
                this.aGraphics3348.fillRect(0, 0, this.anInt3340, this.anInt3341);
            }
        } else {
            this.drawBackground(this.aGraphics3348);
            this.aGraphics3348.drawImage(this.anImage3333, 0, 0, this.anInt3340, this.anInt3341, this.anInt3334, this.anInt3335, this.anInt3334 + this.anInt3340, this.anInt3335 + this.anInt3341, this);
        }

        Object var2 = this.anObject3352;
        synchronized (this.anObject3352) {
            int var3 = this.aVector3345.size();
            if (var3 > 0) {
                int var4 = this.anInt3339;
                int var5 = this.aBoolean3332 ? this.aScrollbar3331.getValue() : 0;

                for (int var7 = 0; var7 <= this.anInt3344 && var5 < var3; ++var7) {
                    Class93 var6 = (Class93) ((Class93) this.aVector3345.elementAt(var5));
                    if (!var6.method1754()) {
                        this.aGraphics3348.setFont(var6.method1753() ? this.aFont3337 : this.aFont3336);
                        this.aGraphics3348.setColor(var6.method1751());
                        this.aGraphics3348.drawString(var6.method1752(), 3, var4);
                    }

                    var4 += this.anInt3343;
                    ++var5;
                }
            }
        }

        if (this.anInt3351 == 1) {
            this.aGraphics3348.setColor(aColor3329);
            this.aGraphics3348.drawRect(0, 0, this.anInt3340 - 1, this.anInt3341 - 1);
            this.aGraphics3348.setColor(aColor3330);
            this.aGraphics3348.drawLine(0, 0, this.anInt3340 - 1, 0);
            this.aGraphics3348.drawLine(0, 0, 0, this.anInt3341 - 1);
        }

        var1.drawImage(this.anImage3347, 0, 0, this);
    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Dimension var2 = this.getSize();
        this.anInt3340 = var2.width;
        this.anInt3341 = var2.height;
        this.method848();
    }

    public void adjustmentValueChanged(AdjustmentEvent var1) {
        this.repaint();
    }

    public void setBackgroundImage(Image var1) {
        this.setBackgroundImage(var1, 0, 0);
    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        this.anImage3333 = var1;
        this.anInt3334 = var2;
        this.anInt3335 = var3;
        this.repaint();
    }

    public void clear() {
        this.method847(true);
    }

    public void addLine() {
        this.addLine((Color) null, (String) null, false);
    }

    public void addLine(int var1, String var2) {
        this.addLine(aColorArray3327[var1], var2, false);
    }

    public void addLine(Color var1, String var2) {
        this.addLine(var1, var2, false);
    }

    public void addLine(int var1, String var2, boolean var3) {
        this.addLine(aColorArray3327[var1], var2, var3);
    }

    public void addLine(Color var1, String var2, boolean var3) {
        this.method851(var1, var2, false, var3);
    }

    public void addBoldLine(int var1, String var2) {
        this.method851(aColorArray3327[var1], var2, true, true);
    }

    public String[] getTimeStampedCache() {
        Object var1 = this.anObject3352;
        synchronized (this.anObject3352) {
            int var2 = this.aVector3346.size();
            String[] var3 = new String[var2];
            if (var2 > 0) {
                String var4 = "";

                for (int var9 = 0; var9 < var2; ++var9) {
                    Class93 var5 = (Class93) ((Class93) this.aVector3346.elementAt(var9));
                    if (var5.method1754()) {
                        var3[var9] = var4;
                    } else {
                        Calendar var6 = Calendar.getInstance();
                        var6.setTime(new Date(var5.method1750()));
                        int var7 = var6.get(11);
                        int var8 = var6.get(12);
                        var3[var9] = "[" + (var7 < 10 ? "0" : "") + var7 + ":" + (var8 < 10 ? "0" : "") + var8 + "] " + var5.method1752();
                    }
                }
            }

            return var3;
        }
    }

    public void drawBorders(boolean var1) {
        this.setBorder(var1 ? 1 : 0);
    }

    public void setBorder(int var1) {
        this.anInt3351 = var1;
        this.repaint();
    }

    public Font getFont() {
        return this.aFont3336;
    }

    private void method847(boolean var1) {
        Object var2 = this.anObject3352;
        synchronized (this.anObject3352) {
            this.aVector3345.removeAllElements();
            if (var1) {
                this.aVector3346.removeAllElements();
            }

            this.remove(this.aScrollbar3331);
            this.aBoolean3332 = false;
        }

        this.repaint();
    }

    private void method848() {
        Object var1 = this.anObject3352;
        synchronized (this.anObject3352) {
            this.method849();
            this.method850();
            this.method847(false);
            int var2 = this.aVector3346.size();
            if (var2 == 0) {
                return;
            }

            int var4 = 0;

            while (true) {
                if (var4 >= var2) {
                    this.method854(0, true);
                    break;
                }

                Class93 var3 = (Class93) ((Class93) this.aVector3346.elementAt(var4));
                this.method852(var3.method1751(), var3.method1752(), var3.method1753());
                ++var4;
            }
        }

        this.repaint();
    }

    private void method849() {
        this.anInt3342 = this.anInt3340 - 6 - 16;
        this.anInt3344 = this.anInt3341 / this.anInt3343;
    }

    private void method850() {
        this.aScrollbar3331.setBounds(this.anInt3340 - 16 - 1, 1, 16, this.anInt3341 - 2);
        this.aScrollbar3331.setBlockIncrement(this.anInt3344 - 1);
    }

    private void method851(Color var1, String var2, boolean var3, boolean var4) {
        Object var5 = this.anObject3352;
        synchronized (this.anObject3352) {
            this.aVector3346.addElement(new Class93(this, var1, var2, var3));
            int var6 = this.aVector3345.size();
            this.method852(var1, var2, var3);
            this.method854(var6, var4);
        }

        this.repaint();
    }

    private void method852(Color var1, String var2, boolean var3) {
        Object var4 = this.anObject3352;
        synchronized (this.anObject3352) {
            int var5 = var2 != null ? this.aFontMetrics3338.stringWidth(var2) : 0;
            if (var5 <= this.anInt3342) {
                this.method853(var1, var2, var3);
            } else {
                int var6 = var2.length();
                int var7 = var6 - 1;

                while (this.aFontMetrics3338.stringWidth(var2.substring(0, var7)) > this.anInt3342) {
                    --var7;
                    if (var7 <= 5) {
                        this.method853(var1, var2, var3);
                        return;
                    }
                }

                int var8;
                for (var8 = var7; var8 > 3 && var2.charAt(var8) != 32; --var8) {
                    ;
                }

                if (var8 == 3) {
                    var8 = var7;
                }

                this.method853(var1, var2.substring(0, var8), var3);
                this.method852(var1, (var2.charAt(var8) == 32 ? " " : "  ") + var2.substring(var8), var3);
            }
        }
    }

    private void method853(Color var1, String var2, boolean var3) {
        Object var4 = this.anObject3352;
        synchronized (this.anObject3352) {
            this.aVector3345.addElement(new Class93(this, var1, var2, var3));
        }
    }

    private void method854(int var1, boolean var2) {
        Object var3 = this.anObject3352;
        synchronized (this.anObject3352) {
            int var4 = this.aVector3345.size();
            if (var4 > this.anInt3344) {
                int var5 = var4 - this.anInt3344;
                if (!this.aBoolean3332) {
                    this.add(this.aScrollbar3331);
                    this.aScrollbar3331.addAdjustmentListener(this);
                    this.aBoolean3332 = true;
                } else {
                    int var6 = this.aScrollbar3331.getValue();
                    if (!var2 && var6 + this.anInt3344 < var1) {
                        var5 = var6;
                    }
                }

                this.aScrollbar3331.setValues(var5, this.anInt3344, 0, var4);
            }
        }
    }

    static {
        aStringArray3353[0] = "  ";
        aStringArray3353[1] = "] ";
        aColorArray3327 = new Color[]{new Color(0, 0, 0), new Color(224, 0, 0), new Color(0, 160, 0), new Color(0, 0, 240), new Color(160, 128, 0), new Color(160, 0, 160), new Color(0, 144, 160), new Color(112, 112, 112), new Color(255, 255, 255)};
        aColor3328 = new Color(255, 255, 255);
        aColor3329 = new Color(192, 192, 192);
        aColor3330 = new Color(64, 64, 64);
    }
}
