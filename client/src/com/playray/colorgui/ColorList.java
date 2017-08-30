package com.playray.colorgui;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.Class126;
import com.playray.colorgui.Class128;
import com.playray.colorgui.ColorListItem;
import com.playray.colorgui.ColorListItemGroup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.ItemSelectable;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D.Float;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JScrollBar;

public final class ColorList extends SPanel implements ComponentListener, AdjustmentListener, MouseListener, ItemSelectable {

    public static final int SELECTABLE_NONE = 0;
    public static final int SELECTABLE_ONE = 1;
    public static final int SELECTABLE_MULTI = 2;
    public static final int ID_CLICKED = 0;
    public static final int ID_RIGHTCLICKED = 1;
    public static final int ID_DOUBLECLICKED = 2;
    public static final int SORT_NONE = 0;
    public static final int SORT_TEXT_ABC = 1;
    public static final int SORT_TEXT_CBA = 2;
    public static final int SORT_VALUE_123 = 3;
    public static final int SORT_VALUE_321 = 4;
    private static final Font aFont4392 = new Font("Dialog", 0, 10);
    private JScrollBar aJScrollBar4393;
    private boolean aBoolean4394;
    private int anInt4395;
    private int anInt4396;
    private int anInt4397;
    private int anInt4398;
    private int anInt4399;
    private int anInt4400;
    private int anInt4401;
    private String aString4402;
    private boolean aBoolean4403;
    private Vector aVector4404;
    private Vector aVector4405;
    private int anInt4406;
    private int anInt4407;
    private int anInt4408;
    private int anInt4409;
    private int anInt4410;
    private int anInt4411;
    private Vector aVector4412;
    private Object anObject4413;
    private static final String aString4414 = "Dialog";


    public ColorList(int var1, int var2) {
        this(var1, var2, Class128.aFont1998, 0, 0);
    }

    public ColorList(int var1, int var2, Font var3) {
        this(var1, var2, var3, 0, 0);
    }

    public ColorList(int var1, int var2, int var3, int var4) {
        this(var1, var2, Class128.aFont1998, var3, var4);
    }

    public ColorList(int var1, int var2, Font var3, int var4, int var5) {
        this.anObject4413 = new Object();
        this.anInt4396 = var1;
        this.anInt4397 = var2;
        this.setSize(var1, var2);
        this.setFont(var3);
        this.anInt4395 = var4;
        this.aVector4404 = new Vector();
        this.anInt4400 = 0;
        this.anInt4401 = 0;
        int var6 = var3.getSize();
        this.anInt4398 = (var6 > var5 ? var6 : var5) + 4;
        this.anInt4406 = this.anInt4407 = -1;
        this.anInt4408 = -1;
        this.anInt4410 = 0;
        this.aBoolean4403 = false;
        this.method2848();
        this.anInt4411 = 255;
        this.aJScrollBar4393 = new JScrollBar(1);
        this.method2838();
        this.aJScrollBar4393.setUnitIncrement(1);
        this.aBoolean4394 = false;
        this.addComponentListener(this);
        this.addMouseListener(this);
        this.aVector4412 = new Vector();
    }

    public void paintContent(Graphics2D var1) {
        Shape var2 = var1.getClip();
        if (this.aString4402 == null) {
            if (!this.aBoolean4394) {
                var1.setColor(new Color(255, 255, 255, this.anInt4411));
                if (!this.aBoolean4403) {
                    var1.fillRoundRect(0, 0, this.anInt4396, this.anInt4397, 10, 10);
                } else {
                    var1.fillRoundRect(0, -20, this.anInt4396, this.anInt4397 + 20, 10, 10);
                }
            } else {
                var1.setClip(this.anInt4396 - 16, 0, 16, this.anInt4397);
                var1.setColor(new Color(255, 255, 255, 192 * this.anInt4411 / 255));
                var1.fillRoundRect(0, this.aBoolean4403 ? -20 : 0, this.anInt4396, this.aBoolean4403 ? this.anInt4397 + 20 : this.anInt4397, 10, 10);
                var1.setClip(0, 0, this.anInt4396 - 16, this.anInt4397);
                var1.setColor(new Color(255, 255, 255, this.anInt4411));
                var1.fillRoundRect(0, this.aBoolean4403 ? -20 : 0, this.anInt4396, this.aBoolean4403 ? this.anInt4397 + 20 : this.anInt4397, 10, 10);
            }
        } else {
            var1.setClip(0, 15, this.anInt4396, this.anInt4397 - 15);
            var1.setColor(new Color(255, 255, 255, this.anInt4411));
            var1.fillRoundRect(0, 0, this.anInt4396, this.anInt4397, 10, 10);
            var1.setClip(0, 0, this.anInt4396, 15);
            var1.setColor(new Color(0, 0, 0, 96 * this.anInt4411 / 255));
            var1.fillRoundRect(0, 0, this.anInt4396, this.anInt4397, 10, 10);
            var1.setClip(var2);
            var1.setFont(aFont4392);
            var1.setColor(new Color(255, 255, 255, this.anInt4411));
            StringDraw.drawString(var1, this.aString4402, this.anInt4396 / 2, 11, 0);
        }

        Area var3 = new Area(new Float(0.0F, 0.0F, (float) this.anInt4396, (float) this.anInt4397, 10.0F, 10.0F));
        if (this.aString4402 != null || this.aBoolean4403) {
            var3.add(new Area(new Rectangle(0, 0, this.anInt4396, this.anInt4397 / 2)));
        }

        if (this.aBoolean4394) {
            var3.subtract(new Area(new Rectangle(this.anInt4396 - 16, 0, 16, this.anInt4397)));
        }

        var1.setClip(var3);
        ColorListItemGroup var5 = null;
        Font var7 = this.getFont();
        Font var8 = new Font(var7.getName(), 1, var7.getSize());
        Object var9 = this.anObject4413;
        synchronized (this.anObject4413) {
            this.aVector4405 = new Vector();
            int var10 = this.method2849();
            int var11 = this.aVector4404.size();
            int var12 = 0;
            if (var11 > 0) {
                int var13 = this.aString4402 != null ? this.anInt4399 - 1 : this.anInt4399;
                int var14 = var13;
                int var15 = this.aBoolean4394 ? this.aJScrollBar4393.getValue() : 0;
                boolean var16 = this.method2837();

                for (int var18 = 0; var18 < var14 + 1 && var15 < var11; ++var18) {
                    ColorListItem var17 = this.getItem(var15);
                    Class126 var4;
                    if (var16) {
                        ColorListItemGroup var6 = var17.getGroup();
                        if (var6 != var5) {
                            var4 = new Class126(1, var10, this.anInt4396 - 2, this.anInt4398, this.anInt4395, var8, Color.darkGray, var6.getText(), var6.getIcon());
                            this.aVector4405.addElement(var4);
                            var4.method2067(var1, this);
                            var5 = var6;
                            var10 += this.anInt4398;
                            --var14;
                            ++var12;
                        }
                    }

                    var4 = new Class126(1, var10, this.anInt4396 - 2, this.anInt4398, this.anInt4395, var7, var8, var17);
                    this.aVector4405.addElement(var4);
                    var4.method2067(var1, this);
                    var10 += this.anInt4398;
                    ++var15;
                }

                if (var12 != this.anInt4410) {
                    this.anInt4410 = var12;
                    if (this.aJScrollBar4393 != null) {
                        this.aJScrollBar4393.setValues(this.aJScrollBar4393.getValue(), var13 - var12, 0, var11);
                    }
                }
            }
        }

        var1.setClip(var2);
    }

    private boolean method2837() {
        ColorListItemGroup var1 = null;
        Enumeration var4 = this.aVector4404.elements();

        while (var4.hasMoreElements()) {
            ColorListItem var3 = (ColorListItem) ((ColorListItem) var4.nextElement());
            ColorListItemGroup var2 = var3.getGroup();
            if (var2 != null) {
                if (var1 != null && var2 != var1) {
                    return true;
                }

                var1 = var2;
            }
        }

        return false;
    }

    public void updateUI(Object var1) {
        Object[] var2 = (Object[]) ((Object[]) var1);
        boolean var3 = ((Boolean) ((Boolean) var2[0])).booleanValue();
        boolean var4 = ((Boolean) ((Boolean) var2[1])).booleanValue();
        if (var3) {
            this.method2838();
        }

        if (var4) {
            boolean var5 = ((Boolean) ((Boolean) var2[2])).booleanValue();
            int var6 = ((Integer) ((Integer) var2[3])).intValue();
            this.method2839(var5, var6);
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
        this.anInt4396 = var2.width;
        this.anInt4397 = var2.height;
        this.method2848();
        this.callUpdateUI(new Object[]{new Boolean(true), new Boolean(true), new Boolean(false), new Integer(0)});
    }

    public void adjustmentValueChanged(AdjustmentEvent var1) {
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        Object var2 = this.anObject4413;
        synchronized (this.anObject4413) {
            this.anInt4406 = var1.getX();
            this.anInt4407 = var1.getY();
            ColorListItem var3 = this.method2840(this.anInt4407);
            if (var3 == null) {
                return;
            }

            boolean var4 = var1.isMetaDown();
            boolean var5 = var1.getClickCount() == 2;
            int var6 = var4 ? 1 : (var5 ? 2 : 0);
            short var7 = 701;
            if (!var3.isSelected()) {
                if (this.anInt4400 == 0) {
                    return;
                }

                if (this.anInt4400 == 1) {
                    this.removeAllSelections();
                }

                var3.setSelected(true);
                var7 = 1;
            } else if (!var4) {
                var3.setSelected(false);
                var7 = 2;
            }

            if (this.anInt4400 == 2) {
                int var8 = this.aVector4404.indexOf(var3);
                if (var6 == 0 && (var7 == 1 || var7 == 2)) {
                    if (this.anInt4408 >= 0 && var1.isShiftDown()) {
                        int var9 = Math.min(this.anInt4408, var8);
                        int var10 = Math.max(this.anInt4408, var8);

                        for (int var11 = var9; var11 <= var10; ++var11) {
                            this.getItem(var11).setSelected(this.anInt4409 == 1);
                        }
                    }

                    this.anInt4408 = var8;
                    this.anInt4409 = var7;
                } else {
                    this.anInt4408 = -1;
                }
            }

            if (var4) {
                this.update(this.getGraphics());
            }

            this.method2850(var3, var6, var7);
        }

        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void addItemListener(ItemListener var1) {
        Object var2 = this.anObject4413;
        synchronized (this.anObject4413) {
            this.aVector4412.addElement(var1);
        }
    }

    public void removeItemListener(ItemListener var1) {
        Object var2 = this.anObject4413;
        synchronized (this.anObject4413) {
            this.aVector4412.removeElement(var1);
        }
    }

    public Object[] getSelectedObjects() {
        return this.getSelectedItems();
    }

    public void setSelectable(int var1) {
        this.anInt4400 = var1;
        if (var1 == 0) {
            this.removeAllSelections();
        } else if (var1 == 1 && this.getSelectedItemCount() > 1) {
            this.removeAllSelections();
        }

    }

    public void setSorting(int var1) {
        if (var1 != this.anInt4401) {
            this.anInt4401 = var1;
            if (var1 != 0) {
                this.reSort();
            }
        }
    }

    public void reSort() {
        Object var1 = this.anObject4413;
        synchronized (this.anObject4413) {
            int var2 = this.aVector4404.size();
            if (var2 == 0) {
                return;
            }

            ColorListItem[] var3 = new ColorListItem[var2];
            int var4 = 0;

            while (true) {
                if (var4 >= var2) {
                    this.aVector4404.removeAllElements();

                    for (var4 = 0; var4 < var2; ++var4) {
                        this.aVector4404.insertElementAt(var3[var4], this.method2842(var3[var4]));
                    }
                    break;
                }

                var3[var4] = this.getItem(var4);
                ++var4;
            }
        }

        this.repaint();
    }

    public int getSorting() {
        return this.anInt4401;
    }

    public void setTitle(String var1) {
        this.aString4402 = var1;
        this.method2848();
        this.callUpdateUI(new Object[]{new Boolean(true), new Boolean(false)});
    }

    public int getItemCount() {
        return this.aVector4404.size();
    }

    public int getSelectedItemCount() {
        Object var1 = this.anObject4413;
        synchronized (this.anObject4413) {
            int var2 = this.aVector4404.size();
            int var3 = 0;

            for (int var4 = 0; var4 < var2; ++var4) {
                if (this.getItem(var4).isSelected()) {
                    ++var3;
                }
            }

            return var3;
        }
    }

    public void addItem(String var1) {
        this.addItem(new ColorListItem(var1));
    }

    public void addItem(ColorListItem var1) {
        Object var3 = this.anObject4413;
        int var2;
        synchronized (this.anObject4413) {
            var1.setColorListReference(this);
            int var4 = this.method2842(var1);
            this.aVector4404.insertElementAt(var1, var4);
            int var5 = this.aJScrollBar4393.getValue();
            var2 = var4 < var5 ? 1 : 0;
            if (var2 == 0 && var5 > 0 && var5 + this.aJScrollBar4393.getVisibleAmount() == this.aJScrollBar4393.getMaximum()) {
                var2 = 1;
            }
        }

        this.callUpdateUI(new Object[]{new Boolean(false), new Boolean(true), new Boolean(this.anInt4401 == 0), new Integer(var2)}, true);
    }

    public void addItems(ColorListItem[] var1) {
        Object var2 = this.anObject4413;
        synchronized (this.anObject4413) {
            int var3 = 0;

            while (true) {
                if (var3 >= var1.length) {
                    this.reSort();
                    break;
                }

                var1[var3].setColorListReference(this);
                this.aVector4404.add(var1[var3]);
                ++var3;
            }
        }

        this.callUpdateUI(new Object[]{new Boolean(false), new Boolean(true), new Boolean(this.anInt4401 == 0), new Integer(0)});
    }

    public void replaceItems(ColorListItem[] var1) {
        Object var2 = this.anObject4413;
        synchronized (this.anObject4413) {
            this.aVector4404.removeAllElements();
            int var3 = 0;

            while (true) {
                if (var3 >= var1.length) {
                    this.reSort();
                    break;
                }

                var1[var3].setColorListReference(this);
                this.aVector4404.add(var1[var3]);
                ++var3;
            }
        }

        this.callUpdateUI(new Object[]{new Boolean(false), new Boolean(true), new Boolean(false), new Integer(0)});
    }

    public ColorListItem getItem(int var1) {
        Object var2 = this.anObject4413;
        synchronized (this.anObject4413) {
            return (ColorListItem) ((ColorListItem) this.aVector4404.elementAt(var1));
        }
    }

    public ColorListItem getItem(String var1) {
        Object var2 = this.anObject4413;
        synchronized (this.anObject4413) {
            int var3 = this.aVector4404.size();
            if (var3 == 0) {
                return null;
            } else {
                for (int var5 = 0; var5 < var3; ++var5) {
                    ColorListItem var4 = this.getItem(var5);
                    if (var1.equals(var4.getString())) {
                        return var4;
                    }
                }

                return null;
            }
        }
    }

    public ColorListItem getSelectedItem() {
        Object var1 = this.anObject4413;
        synchronized (this.anObject4413) {
            ColorListItem[] var2 = this.getSelectedItems();
            return var2 == null ? null : (var2.length != 1 ? null : var2[0]);
        }
    }

    public ColorListItem[] getSelectedItems() {
        Object var1 = this.anObject4413;
        synchronized (this.anObject4413) {
            return this.method2841(true);
        }
    }

    public ColorListItem[] getAllItems() {
        Object var1 = this.anObject4413;
        synchronized (this.anObject4413) {
            return this.method2841(false);
        }
    }

    public ColorListItem removeItem(String var1) {
        Object var2 = this.anObject4413;
        synchronized (this.anObject4413) {
            ColorListItem var3 = this.getItem(var1);
            return var3 == null ? null : this.removeItem(var3);
        }
    }

    public ColorListItem removeItem(ColorListItem var1) {
        int var2 = Integer.MIN_VALUE;
        Object var3 = this.anObject4413;
        synchronized (this.anObject4413) {
            int var4 = this.aVector4404.indexOf(var1);
            if (var4 >= 0) {
                this.aVector4404.removeElementAt(var4);
                var2 = var4 < this.aJScrollBar4393.getValue() ? -1 : 0;
            }
        }

        if (var2 > Integer.MIN_VALUE) {
            this.callUpdateUI(new Object[]{new Boolean(false), new Boolean(true), new Boolean(false), new Integer(var2)}, true);
        }

        return var1;
    }

    public void removeAllItems() {
        Object var1 = this.anObject4413;
        synchronized (this.anObject4413) {
            if (this.aVector4404.size() == 0) {
                return;
            }

            this.aVector4404.removeAllElements();
        }

        this.callUpdateUI(new Object[]{new Boolean(false), new Boolean(true), new Boolean(false), new Integer(0)});
    }

    public void removeAllSelections() {
        Object var1 = this.anObject4413;
        synchronized (this.anObject4413) {
            int var2 = this.aVector4404.size();
            int var3 = 0;

            while (true) {
                if (var3 >= var2) {
                    break;
                }

                this.getItem(var3).setSelected(false);
                ++var3;
            }
        }

        this.repaint();
    }

    public void setAlpha(int var1) {
        this.anInt4411 = var1;
        this.repaint();
    }

    public int getAlpha() {
        return this.anInt4411;
    }

    public int[] getLastClickedMouseXY() {
        int[] var1 = new int[]{this.anInt4406, this.anInt4407};
        return var1;
    }

    public void setNoUpperRounding() {
        this.aBoolean4403 = true;
        this.method2848();
        this.callUpdateUI(new Object[]{new Boolean(true), new Boolean(false)});
    }

    private void method2838() {
        int var1 = this.method2849();
        this.aJScrollBar4393.setBounds(this.anInt4396 - 16, var1, 16, this.anInt4397 - var1 - 4);
        this.aJScrollBar4393.setBlockIncrement(this.anInt4399 - 1);
    }

    private void method2839(boolean var1, int var2) {
        int var3 = this.aVector4404.size();
        int var4 = this.anInt4399;
        if (this.aString4402 != null) {
            --var4;
        }

        var4 -= this.anInt4410;
        if (var3 <= var4) {
            if (this.aBoolean4394) {
                this.aJScrollBar4393.removeAdjustmentListener(this);
                this.remove(this.aJScrollBar4393);
                this.aBoolean4394 = false;
            }

        } else {
            int var5;
            if (!this.aBoolean4394) {
                this.add(this.aJScrollBar4393);
                this.aJScrollBar4393.addAdjustmentListener(this);
                this.aBoolean4394 = true;
                var5 = 0;
            } else {
                var5 = this.aJScrollBar4393.getValue();
                if (var5 > var3 || var1) {
                    var5 = var3;
                }
            }

            var5 += var2;
            if (var5 + var4 > var3 + 1) {
                var5 = var3 + 1 - var4;
            }

            this.aJScrollBar4393.setValues(var5, var4, 0, var3);
        }
    }

    private ColorListItem method2840(int var1) {
        int var2 = this.aVector4405.size();
        if (var2 == 0) {
            return null;
        } else {
            for (int var4 = 0; var4 < var2; ++var4) {
                Class126 var3 = (Class126) ((Class126) this.aVector4405.elementAt(var4));
                if (var3.method2068(var1)) {
                    return var3.method2069();
                }
            }

            return null;
        }
    }

    private ColorListItem[] method2841(boolean var1) {
        Object var2 = this.anObject4413;
        synchronized (this.anObject4413) {
            int var3 = var1 ? this.getSelectedItemCount() : this.getItemCount();
            if (var3 == 0) {
                return null;
            } else {
                ColorListItem[] var4 = new ColorListItem[var3];
                int var5 = this.aVector4404.size();
                int var6 = 0;

                for (int var7 = 0; var7 < var5; ++var7) {
                    ColorListItem var8 = this.getItem(var7);
                    if (!var1 || var8.isSelected()) {
                        var4[var6] = var8;
                        ++var6;
                    }
                }

                return var4;
            }
        }
    }

    private int method2842(ColorListItem var1) {
        Object var2 = this.anObject4413;
        synchronized (this.anObject4413) {
            int var3 = this.aVector4404.size();
            if (var3 == 0) {
                return 0;
            } else {
                int var4 = this.method2843(var1);
                int var5 = this.method2844(var4, var3);
                return var5 == var3 ? var3 : this.method2846(var1, var4, var5, var3);
            }
        }
    }

    private int method2843(ColorListItem var1) {
        ColorListItemGroup var2 = var1.getGroup();
        return var2 != null ? var2.getSortValue() : Integer.MAX_VALUE;
    }

    private int method2844(int var1, int var2) {
        for (int var4 = 0; var4 < var2; ++var4) {
            int var3 = this.method2843((ColorListItem) ((ColorListItem) this.aVector4404.elementAt(var4)));
            if (var1 <= var3) {
                return var4;
            }
        }

        return var2;
    }

    private int method2845(int var1, int var2, int var3) {
        for (int var5 = var2; var5 < var3; ++var5) {
            int var4 = this.method2843((ColorListItem) ((ColorListItem) this.aVector4404.elementAt(var5)));
            if (var4 > var1) {
                return var5;
            }
        }

        return var3;
    }

    private int method2846(ColorListItem var1, int var2, int var3, int var4) {
        int var5 = this.method2845(var2, var3, var4);
        if (var5 == var3) {
            return var3;
        } else {
            boolean var6 = var1.isSortOverride();
            int var8;
            ColorListItem var9;
            boolean var10;
            if (this.anInt4401 != 1 && this.anInt4401 != 2) {
                int var12 = var1.getValue();

                for (var8 = var3; var8 < var5; ++var8) {
                    var9 = this.getItem(var8);
                    var10 = var9.isSortOverride();
                    if (var6 && !var10) {
                        return var8;
                    }

                    if (var6 == var10) {
                        int var13 = var9.getValue();
                        if (this.anInt4401 == 3) {
                            if (var12 < var13) {
                                return var8;
                            }
                        } else if (var12 > var13) {
                            return var8;
                        }
                    }
                }

                return var5;
            } else {
                String var7 = this.method2847(var1.getString());

                for (var8 = var3; var8 < var5; ++var8) {
                    var9 = this.getItem(var8);
                    var10 = var9.isSortOverride();
                    if (var6 && !var10) {
                        return var8;
                    }

                    if (var6 == var10) {
                        String var11 = this.method2847(var9.getString());
                        if (this.anInt4401 == 1) {
                            if (var7.compareTo(var11) < 0) {
                                return var8;
                            }
                        } else if (var7.compareTo(var11) > 0) {
                            return var8;
                        }
                    }
                }

                return var5;
            }
        }
    }

    private String method2847(String var1) {
        var1 = var1.toLowerCase().trim();
        int var2 = var1.length();
        StringBuffer var3 = new StringBuffer(var2);

        for (int var5 = 0; var5 < var2; ++var5) {
            char var4 = var1.charAt(var5);
            if (var4 >= 97 && var4 <= 122 || var4 >= 48 && var4 <= 57 || var4 == 228 || var4 == 246 || var4 == 229) {
                var3.append(var4);
            }

            if (var4 == 126) {
                var3.append('\u00ff');
            }
        }

        return var3.toString().trim();
    }

    private void method2848() {
        int var1 = this.anInt4397;
        var1 -= this.method2849();
        var1 -= 4;
        this.anInt4399 = var1 / this.anInt4398;
    }

    private int method2849() {
        return this.aString4402 != null ? 15 : (this.aBoolean4403 ? 0 : 4);
    }

    private void method2850(ColorListItem var1, int var2, int var3) {
        Object var4 = this.anObject4413;
        synchronized (this.anObject4413) {
            if (this.aVector4412.size() != 0) {
                ItemEvent var5 = new ItemEvent(this, var2, var1, var3);
                Enumeration var6 = this.aVector4412.elements();

                while (var6.hasMoreElements()) {
                    ((ItemListener) ((ItemListener) var6.nextElement())).itemStateChanged(var5);
                }

            }
        }
    }

}
