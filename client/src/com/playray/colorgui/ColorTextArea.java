package com.playray.colorgui;

import com.playray.client.SPanel;
import com.playray.colorgui.Class127;
import com.playray.colorgui.Class128;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JScrollBar;

public class ColorTextArea extends SPanel implements ComponentListener, AdjustmentListener {

    public static final int COLOR_BLACK = 0;
    public static final int COLOR_RED = 1;
    public static final int COLOR_GREEN = 2;
    public static final int COLOR_BLUE = 3;
    public static final int COLOR_YELLOW = 4;
    public static final int COLOR_MAGENTA = 5;
    public static final int COLOR_CYAN = 6;
    public static final int COLOR_GRAY = 7;
    public static final int COLOR_WHITE = 8;
    private static final Color[] aColorArray4415;
    private JScrollBar aJScrollBar4416;
    private boolean aBoolean4417;
    private Font aFont4418;
    private Font aFont4419;
    private FontMetrics aFontMetrics4420;
    private int anInt4421;
    private int anInt4422;
    private int anInt4423;
    private int anInt4424;
    private int anInt4425;
    private int anInt4426;
    private int anInt4427;
    private Vector aVector4428;
    private Vector aVector4429;
    private Object anObject4430;
    private static final String[] aStringArray4431 = new String[2];


    public ColorTextArea(int var1, int var2) {
        this(var1, var2, (Font) null);
    }

    public ColorTextArea(int var1, int var2, Font var3) {
        this.anObject4430 = new Object();
        this.anInt4422 = var1;
        this.anInt4423 = var2;
        this.setSize(var1, var2);
        if (var3 == null) {
            var3 = Class128.aFont1998;
        }

        this.aFont4418 = var3;
        this.aFontMetrics4420 = this.getFontMetrics(var3);
        this.anInt4421 = var3.getSize();
        this.aFont4419 = new Font(var3.getName(), 1, var3.getSize());
        this.aVector4428 = new Vector();
        this.aVector4429 = new Vector();
        this.anInt4425 = this.anInt4421 + 3;
        this.method2853();
        this.anInt4427 = 255;
        this.addComponentListener(this);
        this.aJScrollBar4416 = new JScrollBar(1);
        this.method2857();
        this.aJScrollBar4416.setUnitIncrement(1);
        this.aBoolean4417 = false;
    }

    public void paintContent(Graphics2D var1) {
        if (!this.aBoolean4417) {
            var1.setColor(new Color(255, 255, 255, this.anInt4427));
            var1.fillRoundRect(0, 0, this.anInt4422, this.anInt4423, 10, 10);
        } else {
            Shape var2 = var1.getClip();
            var1.setClip(this.anInt4422 - 16, 0, 16, this.anInt4423);
            var1.setColor(new Color(255, 255, 255, 192 * this.anInt4427 / 255));
            var1.fillRoundRect(0, 0, this.anInt4422, this.anInt4423, 10, 10);
            var1.setClip(0, 0, this.anInt4422 - 16, this.anInt4423);
            var1.setColor(new Color(255, 255, 255, this.anInt4427));
            var1.fillRoundRect(0, 0, this.anInt4422, this.anInt4423, 10, 10);
            var1.setClip(var2);
        }

        Object var10 = this.anObject4430;
        synchronized (this.anObject4430) {
            int var3 = this.aVector4428.size();
            if (var3 > 0) {
                int var4 = this.anInt4421;
                int var5 = this.aBoolean4417 ? this.aJScrollBar4416.getValue() : 0;

                for (int var7 = 0; var7 <= this.anInt4426 && var5 < var3; ++var7) {
                    Class127 var6 = (Class127) ((Class127) this.aVector4428.elementAt(var5));
                    if (!var6.method2081()) {
                        var1.setFont(var6.method2080() ? this.aFont4419 : this.aFont4418);
                        var1.setColor(var6.method2078());
                        var1.drawString(var6.method2079(), 3, var4);
                    }

                    var4 += this.anInt4425;
                    ++var5;
                }
            }

        }
    }

    public void updateUI(Object var1) {
        Object[] var2 = (Object[]) ((Object[]) var1);
        boolean var3 = ((Boolean) ((Boolean) var2[0])).booleanValue();
        boolean var4 = ((Boolean) ((Boolean) var2[1])).booleanValue();
        boolean var5 = ((Boolean) ((Boolean) var2[2])).booleanValue();
        if (var3) {
            this.method2857();
        }

        if (var4 && this.aBoolean4417) {
            this.remove(this.aJScrollBar4416);
            this.aBoolean4417 = false;
        }

        if (var5) {
            int var6 = ((Integer) ((Integer) var2[3])).intValue();
            boolean var7 = ((Boolean) ((Boolean) var2[4])).booleanValue();
            this.method2858(var6, var7);
        }

        this.repaint();
    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Dimension var2 = this.getSize();
        this.anInt4422 = var2.width;
        this.anInt4423 = var2.height;
        this.method2852();
    }

    public void adjustmentValueChanged(AdjustmentEvent var1) {
        this.repaint();
    }

    public void clear() {
        this.method2851(true);
        this.callUpdateUI(new Object[]{new Boolean(false), new Boolean(true), new Boolean(false)});
    }

    public void addLine() {
        this.addLine((Color) null, (String) null, false);
    }

    public void addLine(int var1, String var2) {
        this.addLine(aColorArray4415[var1], var2, false);
    }

    public void addLine(Color var1, String var2) {
        this.addLine(var1, var2, false);
    }

    public void addLine(int var1, String var2, boolean var3) {
        this.addLine(aColorArray4415[var1], var2, var3);
    }

    public void addLine(Color var1, String var2, boolean var3) {
        this.method2854(var1, var2, false, var3);
    }

    public void addBoldLine(int var1, String var2) {
        this.method2854(aColorArray4415[var1], var2, true, true);
    }

    public void setAlpha(int var1) {
        this.anInt4427 = var1;
        this.repaint();
    }

    public String[] getTimeStampedCache() {
        Object var1 = this.anObject4430;
        synchronized (this.anObject4430) {
            int var2 = this.aVector4429.size();
            String[] var3 = new String[var2];
            if (var2 > 0) {
                String var4 = "";

                for (int var5 = 0; var5 < var2; ++var5) {
                    Class127 var6 = (Class127) ((Class127) this.aVector4429.elementAt(var5));
                    if (var6.method2081()) {
                        var3[var5] = var4;
                    } else {
                        Calendar var7 = Calendar.getInstance();
                        var7.setTime(new Date(var6.method2077()));
                        int var8 = var7.get(11);
                        int var9 = var7.get(12);
                        var3[var5] = "[" + (var8 < 10 ? "0" : "") + var8 + ":" + (var9 < 10 ? "0" : "") + var9 + "] " + var6.method2079();
                    }
                }
            }

            return var3;
        }
    }

    public Font getFont() {
        return this.aFont4418;
    }

    private void method2851(boolean var1) {
        Object var2 = this.anObject4430;
        synchronized (this.anObject4430) {
            this.aVector4428.removeAllElements();
            if (var1) {
                this.aVector4429.removeAllElements();
            }

        }
    }

    private void method2852() {
        this.method2853();
        this.callUpdateUI(new Object[]{new Boolean(true), new Boolean(false), new Boolean(false)});
        Object var1 = this.anObject4430;
        synchronized (this.anObject4430) {
            this.method2851(false);
            int var2 = this.aVector4429.size();
            if (var2 == 0) {
                return;
            }

            int var4 = 0;

            while (true) {
                if (var4 >= var2) {
                    break;
                }

                Class127 var3 = (Class127) ((Class127) this.aVector4429.elementAt(var4));
                this.method2855(var3.method2078(), var3.method2079(), var3.method2080());
                ++var4;
            }
        }

        this.callUpdateUI(new Object[]{new Boolean(false), new Boolean(true), new Boolean(true), new Integer(0), new Boolean(true)});
    }

    private void method2853() {
        this.anInt4424 = this.anInt4422 - 6 - 16;
        if (this.anInt4424 <= 0) {
            this.anInt4424 = 1;
        }

        this.anInt4426 = this.anInt4423 / this.anInt4425;
        if (this.anInt4426 <= 0) {
            this.anInt4426 = 1;
        }

    }

    private void method2854(Color var1, String var2, boolean var3, boolean var4) {
        Object var6 = this.anObject4430;
        int var5;
        synchronized (this.anObject4430) {
            this.aVector4429.addElement(new Class127(this, var1, var2, var3));
            var5 = this.aVector4428.size();
            this.method2855(var1, var2, var3);
        }

        this.callUpdateUI(new Object[]{new Boolean(false), new Boolean(false), new Boolean(true), new Integer(var5), new Boolean(var4)});
    }

    private void method2855(Color var1, String var2, boolean var3) {
        Object var4 = this.anObject4430;
        synchronized (this.anObject4430) {
            int var5 = var2 != null ? this.aFontMetrics4420.stringWidth(var2) : 0;
            if (var5 <= this.anInt4424) {
                this.method2856(var1, var2, var3);
            } else {
                int var6 = var2.length();
                int var7 = var6 - 1;

                while (this.aFontMetrics4420.stringWidth(var2.substring(0, var7)) > this.anInt4424) {
                    --var7;
                    if (var7 <= 5) {
                        this.method2856(var1, var2, var3);
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

                this.method2856(var1, var2.substring(0, var8), var3);
                this.method2855(var1, (var2.charAt(var8) == 32 ? " " : "  ") + var2.substring(var8), var3);
            }
        }
    }

    private void method2856(Color var1, String var2, boolean var3) {
        Object var4 = this.anObject4430;
        synchronized (this.anObject4430) {
            this.aVector4428.addElement(new Class127(this, var1, var2, var3));
        }
    }

    private void method2857() {
        this.aJScrollBar4416.setBounds(this.anInt4422 - 16, 4, 16, this.anInt4423 - 8);
        this.aJScrollBar4416.setBlockIncrement(this.anInt4426 - 1);
    }

    private void method2858(int var1, boolean var2) {
        int var3 = this.aVector4428.size();
        if (var3 > this.anInt4426) {
            int var4 = var3 - this.anInt4426;
            if (!this.aBoolean4417) {
                this.add(this.aJScrollBar4416);
                this.aJScrollBar4416.addAdjustmentListener(this);
                this.aBoolean4417 = true;
            } else {
                int var5 = this.aJScrollBar4416.getValue();
                if (!var2 && var5 + this.anInt4426 < var1) {
                    var4 = var5;
                }
            }

            this.aJScrollBar4416.setValues(var4, this.anInt4426, 0, var3);
        }
    }

    static {
        aStringArray4431[0] = "  ";
        aStringArray4431[1] = "] ";
        aColorArray4415 = new Color[]{new Color(0, 0, 0), new Color(224, 0, 0), new Color(0, 160, 0), new Color(0, 0, 240), new Color(160, 128, 0), new Color(160, 0, 160), new Color(0, 144, 160), new Color(112, 112, 112), new Color(255, 255, 255)};
    }
}
