package com.aapeli.colorgui;

import com.aapeli.colorgui.Class91;
import com.aapeli.colorgui.Class94;
import com.aapeli.colorgui.ColorListItem;
import com.aapeli.colorgui.ColorListItemGroup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ItemSelectable;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;

public final class ColorList extends Panel implements ComponentListener, AdjustmentListener, MouseListener, ItemSelectable {

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
    protected static final Color aColor650 = new Color(255, 255, 255);
    private static final Color aColor651 = new Color(192, 192, 192);
    private static final Color aColor652 = new Color(64, 64, 64);
    private Scrollbar aScrollbar653;
    private boolean aBoolean654;
    private Image anImage655;
    private int anInt656;
    private int anInt657;
    private Font aFont658;
    private Font aFont659;
    private int anInt660;
    private int anInt661;
    private int anInt662;
    private int anInt663;
    private int anInt664;
    private int anInt665;
    private int anInt666;
    private String aString667;
    private Color aColor668;
    private Vector aVector669;
    private Vector aVector670;
    private int anInt671;
    private int anInt672;
    private int anInt673;
    private int anInt674;
    private int anInt675;
    private Image anImage676;
    private Graphics aGraphics677;
    private int anInt678;
    private int anInt679;
    private Vector aVector680;


    public ColorList(int var1, int var2) {
        this(var1, var2, Class94.aFont1575, 0, 0);
    }

    public ColorList(int var1, int var2, Font var3) {
        this(var1, var2, var3, 0, 0);
    }

    public ColorList(int var1, int var2, int var3, int var4) {
        this(var1, var2, Class94.aFont1575, var3, var4);
    }

    public ColorList(int var1, int var2, Font var3, int var4, int var5) {
        this.anInt661 = var1;
        this.anInt662 = var2;
        this.setSize(var1, var2);
        this.aFont658 = var3;
        int var6 = var3.getSize();
        this.aFont659 = new Font(var3.getName(), 1, var6);
        this.anInt660 = var4;
        this.aVector669 = new Vector();
        this.anInt665 = 0;
        this.anInt666 = 0;
        this.anInt663 = (var6 > var5 ? var6 : var5) + 4;
        this.anInt664 = var2 / this.anInt663;
        this.anInt671 = this.anInt672 = this.anInt678 = this.anInt679 = -1;
        this.anInt673 = -1;
        this.anInt675 = 0;
        this.setLayout((LayoutManager) null);
        this.aScrollbar653 = new Scrollbar(1);
        this.aScrollbar653.setBounds(var1 - 16 - 1, 1, 16, var2 - 2);
        this.aScrollbar653.setBlockIncrement(this.anInt664 - 1);
        this.aScrollbar653.setUnitIncrement(1);
        this.aBoolean654 = false;
        this.addComponentListener(this);
        this.addMouseListener(this);
        this.aVector680 = new Vector();
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.anImage676 == null || this.anInt661 != this.anInt678 || this.anInt662 != this.anInt679) {
            this.anImage676 = this.createImage(this.anInt661, this.anInt662);
            this.aGraphics677 = this.anImage676.getGraphics();
            this.anInt678 = this.anInt661;
            this.anInt679 = this.anInt662;
        }

        if (this.anImage655 == null) {
            this.aGraphics677.setColor(aColor650);
            this.aGraphics677.fillRect(0, 0, this.anInt661, this.anInt662);
        } else {
            this.aGraphics677.drawImage(this.anImage655, 0, 0, this.anInt661, this.anInt662, this.anInt656, this.anInt657, this.anInt656 + this.anInt661, this.anInt657 + this.anInt662, this);
        }

        ColorListItemGroup var3 = null;
        synchronized (this) {
            this.aVector670 = new Vector();
            int var6 = 0;
            Class91 var2;
            if (this.aString667 != null) {
                var2 = new Class91(1, var6, this.anInt661 - 2, this.anInt663, this.anInt660, this.anImage655 != null, this.aFont659, this.aColor668, this.aString667, (Image) null);
                this.aVector670.addElement(var2);
                var2.method1739(this.aGraphics677, this);
                var6 += this.anInt663;
            }

            int var7 = this.aVector669.size();
            int var8 = 0;
            if (var7 > 0) {
                int var9 = this.aString667 != null ? this.anInt664 - 1 : this.anInt664;
                int var10 = var9;
                int var11 = this.aBoolean654 ? this.aScrollbar653.getValue() : 0;
                boolean var12 = this.method944();

                for (int var14 = 0; var14 < var10 + 1 && var11 < var7; ++var14) {
                    ColorListItem var13 = this.getItem(var11);
                    if (var12) {
                        ColorListItemGroup var4 = var13.getGroup();
                        if (var4 != var3) {
                            var2 = new Class91(1, var6, this.anInt661 - 2, this.anInt663, this.anInt660, this.anImage655 != null, this.aFont659, Color.darkGray, var4.getText(), var4.getIcon());
                            this.aVector670.addElement(var2);
                            var2.method1739(this.aGraphics677, this);
                            var3 = var4;
                            var6 += this.anInt663;
                            --var10;
                            ++var8;
                        }
                    }

                    var2 = new Class91(1, var6, this.anInt661 - 2, this.anInt663, this.anInt660, this.anImage655 != null, this.aFont658, this.aFont659, var13);
                    this.aVector670.addElement(var2);
                    var2.method1739(this.aGraphics677, this);
                    var6 += this.anInt663;
                    ++var11;
                }

                if (var8 != this.anInt675) {
                    this.anInt675 = var8;
                    if (this.aScrollbar653 != null) {
                        this.aScrollbar653.setValues(this.aScrollbar653.getValue(), var9 - var8, 0, var7);
                    }
                }
            }
        }

        this.aGraphics677.setColor(aColor651);
        this.aGraphics677.drawRect(0, 0, this.anInt661 - 1, this.anInt662 - 1);
        this.aGraphics677.setColor(aColor652);
        this.aGraphics677.drawLine(0, 0, this.anInt661 - 1, 0);
        this.aGraphics677.drawLine(0, 0, 0, this.anInt662 - 1);
        var1.drawImage(this.anImage676, 0, 0, this);
    }

    private boolean method944() {
        ColorListItemGroup var1 = null;
        Enumeration var4 = this.aVector669.elements();

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

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Dimension var2 = this.getSize();
        this.anInt661 = var2.width;
        this.anInt662 = var2.height;
        this.anInt664 = this.anInt662 / this.anInt663;
        this.aScrollbar653.setBounds(this.anInt661 - 16 - 1, 1, 16, this.anInt662 - 2);
        this.aScrollbar653.setBlockIncrement(this.anInt664 - 1);
        this.method945(false, 0);
        this.repaint();
    }

    public void adjustmentValueChanged(AdjustmentEvent var1) {
        this.repaint();
    }

    public synchronized void mousePressed(MouseEvent var1) {
        this.anInt671 = var1.getX();
        this.anInt672 = var1.getY();
        ColorListItem var2 = this.method946(this.anInt672);
        if (var2 != null) {
            boolean var3 = var1.isMetaDown();
            boolean var4 = var1.getClickCount() == 2;
            int var5 = var3 ? 1 : (var4 ? 2 : 0);
            short var6 = 701;
            if (!var2.isSelected()) {
                if (this.anInt665 == 0) {
                    return;
                }

                if (this.anInt665 == 1) {
                    this.removeAllSelections();
                }

                var2.setSelected(true);
                var6 = 1;
            } else if (!var3) {
                var2.setSelected(false);
                var6 = 2;
            }

            if (this.anInt665 == 2) {
                int var7 = this.aVector669.indexOf(var2);
                if (var5 == 0 && (var6 == 1 || var6 == 2)) {
                    if (this.anInt673 >= 0 && var1.isShiftDown()) {
                        int var8 = Math.min(this.anInt673, var7);
                        int var9 = Math.max(this.anInt673, var7);

                        for (int var10 = var8; var10 <= var9; ++var10) {
                            this.getItem(var10).setSelected(this.anInt674 == 1);
                        }
                    }

                    this.anInt673 = var7;
                    this.anInt674 = var6;
                } else {
                    this.anInt673 = -1;
                }
            }

            if (var3) {
                this.update(this.getGraphics());
            }

            this.method954(var2, var5, var6);
            this.repaint();
        }
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public synchronized void addItemListener(ItemListener var1) {
        this.aVector680.addElement(var1);
    }

    public synchronized void removeItemListener(ItemListener var1) {
        this.aVector680.removeElement(var1);
    }

    public Object[] getSelectedObjects() {
        return this.getSelectedItems();
    }

    public void setSelectable(int var1) {
        this.anInt665 = var1;
        if (var1 == 0) {
            this.removeAllSelections();
        } else if (var1 == 1 && this.getSelectedItemCount() > 1) {
            this.removeAllSelections();
        }

    }

    public void setSorted(boolean var1) {
        this.setSorting(var1 ? 1 : 0);
    }

    public void setSorting(int var1) {
        if (var1 != this.anInt666) {
            this.anInt666 = var1;
            if (var1 != 0) {
                this.reSort();
            }
        }
    }

    public synchronized void reSort() {
        int var1 = this.aVector669.size();
        if (var1 != 0) {
            ColorListItem[] var2 = new ColorListItem[var1];

            int var3;
            for (var3 = 0; var3 < var1; ++var3) {
                var2[var3] = this.getItem(var3);
            }

            this.aVector669.removeAllElements();

            for (var3 = 0; var3 < var1; ++var3) {
                this.aVector669.insertElementAt(var2[var3], this.method948(var2[var3]));
            }

            this.repaint();
        }
    }

    public int getSorting() {
        return this.anInt666;
    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        this.anImage655 = var1;
        this.anInt656 = var2;
        this.anInt657 = var3;
        this.repaint();
    }

    public void setTitle(String var1, Color var2) {
        this.aString667 = var1;
        this.aColor668 = var2;
        this.repaint();
    }

    public int getItemCount() {
        return this.aVector669.size();
    }

    public synchronized int getSelectedItemCount() {
        int var1 = this.aVector669.size();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.getItem(var3).isSelected()) {
                ++var2;
            }
        }

        return var2;
    }

    public void addItem(String var1) {
        this.addItem(new ColorListItem(var1));
    }

    public synchronized void addItem(ColorListItem var1) {
        var1.setColorListReference(this);
        int var2 = this.method948(var1);
        this.aVector669.insertElementAt(var1, var2);
        int var3 = this.aScrollbar653.getValue();
        int var4 = var2 < var3 ? 1 : 0;
        if (var4 == 0 && var3 > 0 && var3 + this.aScrollbar653.getVisibleAmount() == this.aScrollbar653.getMaximum()) {
            var4 = 1;
        }

        this.method945(this.anInt666 == 0, var4);
        this.repaint();
    }

    public synchronized ColorListItem getItem(int var1) {
        return (ColorListItem) ((ColorListItem) this.aVector669.elementAt(var1));
    }

    public synchronized ColorListItem getItem(String var1) {
        int var2 = this.aVector669.size();
        if (var2 == 0) {
            return null;
        } else {
            for (int var4 = 0; var4 < var2; ++var4) {
                ColorListItem var3 = this.getItem(var4);
                if (var1.equals(var3.getString())) {
                    return var3;
                }
            }

            return null;
        }
    }

    public synchronized ColorListItem getSelectedItem() {
        ColorListItem[] var1 = this.getSelectedItems();
        return var1 == null ? null : (var1.length != 1 ? null : var1[0]);
    }

    public synchronized ColorListItem[] getSelectedItems() {
        return this.method947(true);
    }

    public synchronized ColorListItem[] getAllItems() {
        return this.method947(false);
    }

    public synchronized ColorListItem removeItem(String var1) {
        ColorListItem var2 = this.getItem(var1);
        return var2 == null ? null : this.removeItem(var2);
    }

    public synchronized ColorListItem removeItem(ColorListItem var1) {
        int var2 = this.aVector669.indexOf(var1);
        if (var2 >= 0) {
            this.aVector669.removeElementAt(var2);
            int var3 = var2 < this.aScrollbar653.getValue() ? -1 : 0;
            this.method945(false, var3);
            this.repaint();
        }

        return var1;
    }

    public synchronized void removeAllItems() {
        if (this.aVector669.size() != 0) {
            this.aVector669.removeAllElements();
            this.method945(false, 0);
            this.repaint();
        }
    }

    public synchronized void removeAllSelections() {
        int var1 = this.aVector669.size();

        for (int var2 = 0; var2 < var1; ++var2) {
            this.getItem(var2).setSelected(false);
        }

        this.repaint();
    }

    public int[] getLastClickedMouseXY() {
        int[] var1 = new int[]{this.anInt671, this.anInt672};
        return var1;
    }

    private synchronized void method945(boolean var1, int var2) {
        int var3 = this.aVector669.size();
        int var4 = this.anInt664;
        if (this.aString667 != null) {
            --var4;
        }

        var4 -= this.anInt675;
        if (var3 <= var4) {
            if (this.aBoolean654) {
                this.aScrollbar653.removeAdjustmentListener(this);
                this.remove(this.aScrollbar653);
                this.aBoolean654 = false;
            }

        } else {
            int var5;
            if (!this.aBoolean654) {
                this.add(this.aScrollbar653);
                this.aScrollbar653.addAdjustmentListener(this);
                this.aBoolean654 = true;
                var5 = 0;
            } else {
                var5 = this.aScrollbar653.getValue();
                if (var5 > var3 || var1) {
                    var5 = var3;
                }
            }

            var5 += var2;
            this.aScrollbar653.setValues(var5, var4, 0, var3);
        }
    }

    private ColorListItem method946(int var1) {
        int var2 = this.aVector670.size();
        if (var2 == 0) {
            return null;
        } else {
            for (int var4 = 0; var4 < var2; ++var4) {
                Class91 var3 = (Class91) ((Class91) this.aVector670.elementAt(var4));
                if (var3.method1740(var1)) {
                    return var3.method1741();
                }
            }

            return null;
        }
    }

    private synchronized ColorListItem[] method947(boolean var1) {
        int var2 = var1 ? this.getSelectedItemCount() : this.getItemCount();
        if (var2 == 0) {
            return null;
        } else {
            ColorListItem[] var3 = new ColorListItem[var2];
            int var4 = this.aVector669.size();
            int var5 = 0;

            for (int var7 = 0; var7 < var4; ++var7) {
                ColorListItem var6 = this.getItem(var7);
                if (!var1 || var6.isSelected()) {
                    var3[var5] = var6;
                    ++var5;
                }
            }

            return var3;
        }
    }

    private synchronized int method948(ColorListItem var1) {
        int var2 = this.aVector669.size();
        if (var2 == 0) {
            return 0;
        } else {
            int var3 = this.method949(var1);
            int var4 = this.method950(var3, var2);
            return var4 == var2 ? var2 : this.method952(var1, var3, var4, var2);
        }
    }

    private int method949(ColorListItem var1) {
        ColorListItemGroup var2 = var1.getGroup();
        return var2 != null ? var2.getSortValue() : Integer.MAX_VALUE;
    }

    private int method950(int var1, int var2) {
        for (int var4 = 0; var4 < var2; ++var4) {
            int var3 = this.method949((ColorListItem) ((ColorListItem) this.aVector669.elementAt(var4)));
            if (var1 <= var3) {
                return var4;
            }
        }

        return var2;
    }

    private int method951(int var1, int var2, int var3) {
        for (int var5 = var2; var5 < var3; ++var5) {
            int var4 = this.method949((ColorListItem) ((ColorListItem) this.aVector669.elementAt(var5)));
            if (var4 > var1) {
                return var5;
            }
        }

        return var3;
    }

    private int method952(ColorListItem var1, int var2, int var3, int var4) {
        int var5 = this.method951(var2, var3, var4);
        if (var5 == var3) {
            return var3;
        } else {
            boolean var6 = var1.isSortOverride();
            int var8;
            ColorListItem var9;
            boolean var10;
            if (this.anInt666 != 1 && this.anInt666 != 2) {
                int var12 = var1.getValue();

                for (var8 = var3; var8 < var5; ++var8) {
                    var9 = this.getItem(var8);
                    var10 = var9.isSortOverride();
                    if (var6 && !var10) {
                        return var8;
                    }

                    if (var6 == var10) {
                        int var13 = var9.getValue();
                        if (this.anInt666 == 3) {
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
                String var7 = this.method953(var1.getString());

                for (var8 = var3; var8 < var5; ++var8) {
                    var9 = this.getItem(var8);
                    var10 = var9.isSortOverride();
                    if (var6 && !var10) {
                        return var8;
                    }

                    if (var6 == var10) {
                        String var11 = this.method953(var9.getString());
                        if (this.anInt666 == 1) {
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

    private String method953(String var1) {
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

    private synchronized void method954(ColorListItem var1, int var2, int var3) {
        if (this.aVector680.size() != 0) {
            ItemEvent var4 = new ItemEvent(this, var2, var1, var3);
            Enumeration var5 = this.aVector680.elements();

            while (var5.hasMoreElements()) {
                ((ItemListener) ((ItemListener) var5.nextElement())).itemStateChanged(var4);
            }

        }
    }

}
