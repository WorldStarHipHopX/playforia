package com.playray.colorgui;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.Class128;
import com.playray.colorgui.MultiColorListItem;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.ItemSelectable;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D.Float;
import java.awt.image.ImageObserver;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JScrollBar;

public class MultiColorList extends SPanel implements AdjustmentListener, MouseListener, ItemSelectable {

    public static final int SELECTABLE_NONE = 0;
    public static final int SELECTABLE_ONE = 1;
    public static final int SELECTABLE_MULTI = 2;
    public static final int ID_CLICKED = 0;
    public static final int ID_RIGHTCLICKED = 1;
    public static final int ID_DOUBLECLICKED = 2;
    public static final int ORDER_ABC = 0;
    public static final int ORDER_CBA = 1;
    public static final int ORDER_123_FIRST = 2;
    public static final int ORDER_321_FIRST = 3;
    public static final int ORDER_123_ALL = 4;
    public static final int ORDER_321_ALL = 5;
    private static final Font aFont4476;
    private static final Color aColor4477;
    private static final Color aColor4478;
    private JScrollBar aJScrollBar4479;
    private boolean aBoolean4480;
    private Color aColor4481;
    private Color aColor4482;
    private FontMetrics aFontMetrics4483;
    private String aString4484;
    private char aChar4485;
    private String[] aStringArray4486;
    private int[] anIntArray4487;
    private int anInt4488;
    private int anInt4489;
    private int anInt4490;
    private int anInt4491;
    private int anInt4492;
    private int anInt4493;
    private boolean aBoolean4494;
    private int[] anIntArray4495;
    private int anInt4496;
    private Vector aVector4497;
    private int anInt4498;
    private int anInt4499;
    private int anInt4500;
    private int anInt4501;
    private int anInt4502;
    private Vector aVector4503;
    private Object anObject4504;
    private static final String[] aStringArray4505 = new String[4];


    public MultiColorList(String[] var1, int[] var2, int var3, int var4, int var5) {
        this.aStringArray4486 = var1;
        this.anIntArray4487 = var2;
        this.anInt4489 = var3;
        this.aBoolean4494 = false;
        this.anObject4504 = new Object();
        this.anInt4490 = var4;
        this.anInt4491 = var5;
        this.setSize(var4, var5);
        this.aString4484 = null;
        this.aChar4485 = 46;
        this.anInt4488 = var1 != null ? var1.length : 0;
        this.aVector4497 = new Vector();
        this.anInt4496 = 0;
        this.anInt4492 = var4 - 6 - 16;
        this.anInt4493 = var5 / 16 - 1;
        this.aColor4482 = aColor4478;
        this.anInt4498 = this.anInt4499 = -1;
        this.anInt4500 = -1;
        this.aColor4481 = aColor4477;
        this.anInt4502 = 255;
        this.aJScrollBar4479 = new JScrollBar(1);
        this.aJScrollBar4479.setBounds(var4 - 16, 4, 16, var5 - 8);
        this.aJScrollBar4479.setBlockIncrement(this.anInt4493 - 1);
        this.aJScrollBar4479.setUnitIncrement(1);
        this.aBoolean4480 = false;
        this.addMouseListener(this);
        this.aVector4503 = new Vector();
    }

    public void paintContent(Graphics2D var1) {
        Object var2 = this.anObject4504;
        synchronized (this.anObject4504) {
            Shape var3 = var1.getClip();
            if (this.aBoolean4480) {
                var1.setClip(this.anInt4490 - 16, 0, 16, this.anInt4491);
                var1.setColor(new Color(this.aColor4481.getRed(), this.aColor4481.getGreen(), this.aColor4481.getBlue(), 192 * this.anInt4502 / 255));
                var1.fillRoundRect(0, 0, this.anInt4490, this.anInt4491, 10, 10);
                var1.setClip(0, 0, this.anInt4490 - 16, this.anInt4491);
                var1.setColor(this.anInt4502 == 255 ? this.aColor4481 : new Color(this.aColor4481.getRed(), this.aColor4481.getGreen(), this.aColor4481.getBlue(), this.anInt4502));
                var1.fillRoundRect(0, 0, this.anInt4490, this.anInt4491, 10, 10);
            } else {
                var1.setColor(this.anInt4502 == 255 ? this.aColor4481 : new Color(this.aColor4481.getRed(), this.aColor4481.getGreen(), this.aColor4481.getBlue(), this.anInt4502));
                var1.fillRoundRect(0, 0, this.anInt4490, this.anInt4491, 10, 10);
            }

            Area var4 = new Area(new Float(0.0F, 0.0F, (float) this.anInt4490, (float) this.anInt4491, 10.0F, 10.0F));
            if (this.aBoolean4480) {
                var4.subtract(new Area(new Rectangle(this.anInt4490 - 16, 0, 16, this.anInt4491)));
            }

            var1.setClip(var4);
            this.anIntArray4495 = null;
            int var5 = this.aVector4497.size();
            byte var6 = 14;
            byte var7 = var6;
            var1.setFont(aFont4476);
            var1.setColor(this.aColor4482);
            int var9;
            if (var5 == 0) {
                String[][] var8 = new String[1][this.anInt4488];

                for (var9 = 0; var9 < this.anInt4488; ++var9) {
                    var8[0][var9] = this.aStringArray4486[var9];
                }

                this.anIntArray4495 = this.method2903(var8);

                for (var9 = 0; var9 < this.anInt4488; ++var9) {
                    var1.drawString(this.aStringArray4486[var9], 3 + this.anIntArray4495[var9], var7);
                }

                if (this.aString4484 != null) {
                    var1.setFont(Class128.aFont1998);
                    StringDraw.drawStringWithMaxWidth(var1, this.aString4484, this.anInt4490 / 2, this.anInt4491 / 2, 0, this.anInt4490 * 9 / 10);
                }
            } else {
                int var19 = this.aBoolean4480 ? this.aJScrollBar4479.getValue() : 0;
                var9 = var19;
                String[][] var10 = new String[this.anInt4493 + 1][this.anInt4488];

                int var11;
                MultiColorListItem var12;
                for (var11 = 0; var11 < this.anInt4493 + 1 && var9 < var5; ++var11) {
                    var12 = this.getItem(var9);
                    var10[var11] = var12.getStrings();
                    ++var9;
                }

                this.anIntArray4495 = this.method2903(var10);

                for (var11 = 0; var11 < this.anInt4488; ++var11) {
                    var1.drawString(this.aStringArray4486[var11], 3 + this.anIntArray4495[var11], var7);
                }

                int var18 = var7 + 16;
                var9 = var19;

                for (var11 = 0; var11 < this.anInt4493 + 1 && var9 < var5; ++var11) {
                    var12 = this.getItem(var9);
                    var1.setFont(var12.isBold() ? aFont4476 : Class128.aFont1998);
                    if (var12.isSelected()) {
                        var1.setColor(var12.getColor());
                        var1.fillRect(1, var18 - 12 - 1, this.anInt4490 - 2, 16);
                        var1.setColor(this.aColor4481);
                    } else {
                        Color var13 = var12.getBackgroundColor();
                        if (var13 != null) {
                            var1.setColor(var13);
                            var1.fillRect(1, var18 - 12 - 1, this.anInt4490 - 2, 16);
                        }

                        var1.setColor(var12.getColor());
                    }

                    for (int var20 = 0; var20 < this.anInt4488; ++var20) {
                        Image[] var14 = var12.getImages();
                        if (var14[var20] != null) {
                            var1.drawImage(var14[var20], 3 + this.anIntArray4495[var20] + 1, var18 - var6 + (8 - var14[var20].getHeight((ImageObserver) null) / 2) + 1, this);
                        } else {
                            String[] var15 = var12.getStrings();
                            if (var15[var20] != null) {
                                var1.drawString(var15[var20], 3 + this.anIntArray4495[var20], var18);
                            }
                        }
                    }

                    var18 += 16;
                    ++var9;
                }
            }

            var1.setClip(var3);
        }
    }

    public void updateUI(Object var1) {
        int var2 = ((Integer) ((Integer) var1)).intValue();
        this.method2898(var2);
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        Object var2 = this.anObject4504;
        synchronized (this.anObject4504) {
            int var3 = this.aVector4497.size();
            if (var3 == 0) {
                return;
            }

            this.anInt4498 = var1.getX();
            this.anInt4499 = var1.getY();
            int var4 = this.anInt4499 - 12 - 4;
            int var5;
            if (var4 < 0) {
                if (this.anIntArray4495 != null) {
                    var5 = -1;
                    int var16 = var1.getX();

                    for (int var17 = 0; var17 < this.anInt4488 - 1 && var5 == -1; ++var17) {
                        if (var16 >= this.anIntArray4495[var17] && var16 < this.anIntArray4495[var17 + 1]) {
                            var5 = var17;
                        }
                    }

                    if (var5 == -1 && var16 >= this.anIntArray4495[this.anInt4488 - 1]) {
                        var5 = this.anInt4488 - 1;
                    }

                    if (var5 >= 0) {
                        this.method2900(var5);
                    }
                }

                return;
            }

            var5 = this.method2904(var4);
            if (var5 == -1) {
                return;
            }

            MultiColorListItem var6 = this.getItem(var5);
            boolean var7 = var1.isMetaDown();
            boolean var8 = var1.getClickCount() == 2;
            int var9 = var7 ? 1 : (var8 ? 2 : 0);
            short var10 = 701;
            if (!var6.isSelected()) {
                if (this.anInt4496 == 0) {
                    return;
                }

                if (this.anInt4496 == 1) {
                    this.unselectAll();
                }

                var6.setSelected(true);
                var10 = 1;
            } else if (!var7) {
                var6.setSelected(false);
                var10 = 2;
            }

            if (this.anInt4496 == 2) {
                if (var9 == 0 && (var10 == 1 || var10 == 2)) {
                    if (this.anInt4500 >= 0 && var1.isShiftDown()) {
                        int var11 = Math.min(this.anInt4500, var5);
                        int var12 = Math.max(this.anInt4500, var5);

                        for (int var13 = var11; var13 <= var12; ++var13) {
                            this.getItem(var13).setSelected(this.anInt4501 == 1);
                        }
                    }

                    this.anInt4500 = var5;
                    this.anInt4501 = var10;
                } else {
                    this.anInt4500 = -1;
                }
            }

            if (var7) {
                this.update(this.getGraphics());
            }

            this.method2906(var6, var9, var10);
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

    public void adjustmentValueChanged(AdjustmentEvent var1) {
        this.repaint();
    }

    public void addItemListener(ItemListener var1) {
        Object var2 = this.anObject4504;
        synchronized (this.anObject4504) {
            this.aVector4503.addElement(var1);
        }
    }

    public void removeItemListener(ItemListener var1) {
        Object var2 = this.anObject4504;
        synchronized (this.anObject4504) {
            this.aVector4503.removeElement(var1);
        }
    }

    public Object[] getSelectedObjects() {
        return this.getSelectedItems();
    }

    public void setSelectable(int var1) {
        this.anInt4496 = var1;
        if (var1 == 0) {
            this.unselectAll();
        } else if (var1 == 1 && this.getSelectedItemCount() > 1) {
            this.unselectAll();
        }

    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        this.aColor4481 = var1;
        this.repaint();
    }

    public void setForeground(Color var1) {
        super.setForeground(var1);
        this.aColor4482 = var1;
        this.repaint();
    }

    public void setEmptyListText(String var1) {
        this.aString4484 = var1;
        this.repaint();
    }

    public void setDecimalSeparator(char var1) {
        this.aChar4485 = var1;
    }

    public int getItemCount() {
        return this.aVector4497.size();
    }

    public int getSelectedItemCount() {
        Object var1 = this.anObject4504;
        synchronized (this.anObject4504) {
            int var2 = this.aVector4497.size();
            int var3 = 0;

            for (int var4 = 0; var4 < var2; ++var4) {
                if (this.getItem(var4).isSelected()) {
                    ++var3;
                }
            }

            return var3;
        }
    }

    public void addItem(String[] var1) {
        this.addItem(new MultiColorListItem(var1));
    }

    public void addItem(MultiColorListItem var1) {
        Object var3 = this.anObject4504;
        int var2;
        synchronized (this.anObject4504) {
            int var4 = var1.getColumnCount();
            if (this.anInt4488 == 0) {
                this.anInt4488 = var4;
            } else if (var4 != this.anInt4488) {
                System.out.println("Error: MultiColorList.addItem(...): ccount = " + var4 + " != " + this.anInt4488 + " = noc");
                return;
            }

            int var5 = this.method2901(var1);
            this.aVector4497.insertElementAt(var1, var5);
            int var6 = this.aJScrollBar4479.getValue();
            var2 = var5 < var6 ? 1 : 0;
            if (var2 == 0 && var6 + this.aJScrollBar4479.getVisibleAmount() == this.aJScrollBar4479.getMaximum()) {
                var2 = 1;
            }
        }

        this.callUpdateUI(new Integer(var2));
    }

    public MultiColorListItem getItem(int var1) {
        Object var2 = this.anObject4504;
        synchronized (this.anObject4504) {
            return (MultiColorListItem) ((MultiColorListItem) this.aVector4497.elementAt(var1));
        }
    }

    public MultiColorListItem getItem(int var1, String var2) {
        Object var3 = this.anObject4504;
        synchronized (this.anObject4504) {
            int var4 = this.aVector4497.size();
            if (var4 == 0) {
                return null;
            } else {
                for (int var6 = 0; var6 < var4; ++var6) {
                    MultiColorListItem var5 = this.getItem(var6);
                    if (var2.equals(var5.getString(var1))) {
                        return var5;
                    }
                }

                return null;
            }
        }
    }

    public MultiColorListItem getSelectedItem() {
        Object var1 = this.anObject4504;
        synchronized (this.anObject4504) {
            MultiColorListItem[] var2 = this.getSelectedItems();
            return var2 == null ? null : (var2.length != 1 ? null : var2[0]);
        }
    }

    public MultiColorListItem[] getSelectedItems() {
        Object var1 = this.anObject4504;
        synchronized (this.anObject4504) {
            return this.method2899(true);
        }
    }

    public MultiColorListItem[] getAllItems() {
        Object var1 = this.anObject4504;
        synchronized (this.anObject4504) {
            return this.method2899(false);
        }
    }

    public void removeItem(int var1, String var2) {
        Object var3 = this.anObject4504;
        synchronized (this.anObject4504) {
            this.removeItem(this.getItem(var1, var2));
        }
    }

    public void removeItem(MultiColorListItem var1) {
        int var2 = Integer.MIN_VALUE;
        Object var3 = this.anObject4504;
        synchronized (this.anObject4504) {
            int var4 = this.aVector4497.indexOf(var1);
            if (var4 >= 0) {
                this.aVector4497.removeElementAt(var4);
                var2 = var4 < this.aJScrollBar4479.getValue() ? -1 : 0;
            }
        }

        if (var2 > Integer.MIN_VALUE) {
            this.callUpdateUI(new Integer(var2));
        }

    }

    public void removeAllItems() {
        Object var1 = this.anObject4504;
        synchronized (this.anObject4504) {
            if (this.aVector4497.size() == 0) {
                return;
            }

            this.aVector4497.removeAllElements();
        }

        this.callUpdateUI(new Integer(0));
    }

    public void removeAllSelections() {
        Object var1 = this.anObject4504;
        synchronized (this.anObject4504) {
            int var2 = this.aVector4497.size();

            for (int var3 = 0; var3 < var2; ++var3) {
                this.getItem(var3).setSelected(false);
            }

            this.repaint();
        }
    }

    public void selectAll() {
        this.method2905(true);
    }

    public void unselectAll() {
        this.method2905(false);
    }

    public void setSortColumnIndex(int var1) {
        Object var2 = this.anObject4504;
        synchronized (this.anObject4504) {
            if (var1 != this.anInt4489) {
                this.anInt4489 = var1;
                this.aBoolean4494 = false;
                this.reSort();
            }
        }
    }

    public void reSort() {
        Object var1 = this.anObject4504;
        synchronized (this.anObject4504) {
            int var2 = this.aVector4497.size();
            if (var2 != 0) {
                MultiColorListItem[] var3 = this.getAllItems();
                this.aVector4497.removeAllElements();

                for (int var4 = 0; var4 < var2; ++var4) {
                    this.aVector4497.insertElementAt(var3[var4], this.method2901(var3[var4]));
                }

                this.repaint();
            }
        }
    }

    public int[] getLastClickedMouseXY() {
        int[] var1 = new int[]{this.anInt4498, this.anInt4499};
        return var1;
    }

    public void setTitle(String var1, int var2) {
        this.aStringArray4486[var2] = var1;
        this.repaint();
    }

    public void setSortOrder(int var1, int var2) {
        this.anIntArray4487[var2] = var1;
        if (var2 == this.anInt4489) {
            this.reSort();
        }

    }

    public void setAlpha(int var1) {
        this.anInt4502 = var1;
        this.repaint();
    }

    public int getAlpha() {
        return this.anInt4502;
    }

    private void method2898(int var1) {
        int var2 = this.aVector4497.size();
        if (var2 <= this.anInt4493) {
            if (this.aBoolean4480) {
                this.aJScrollBar4479.removeAdjustmentListener(this);
                this.remove(this.aJScrollBar4479);
                this.aBoolean4480 = false;
            }

        } else {
            int var3;
            if (!this.aBoolean4480) {
                this.add(this.aJScrollBar4479);
                this.aJScrollBar4479.addAdjustmentListener(this);
                this.aBoolean4480 = true;
                var3 = 0;
            } else {
                var3 = this.aJScrollBar4479.getValue();
                if (var3 > var2) {
                    var3 = var2;
                }
            }

            var3 += var1;
            if (var3 + this.anInt4493 > var2) {
                var3 = var2 - this.anInt4493;
            }

            this.aJScrollBar4479.setValues(var3, this.anInt4493, 0, var2);
        }
    }

    private MultiColorListItem[] method2899(boolean var1) {
        Object var2 = this.anObject4504;
        synchronized (this.anObject4504) {
            int var3 = var1 ? this.getSelectedItemCount() : this.getItemCount();
            if (var3 == 0) {
                return null;
            } else {
                MultiColorListItem[] var4 = new MultiColorListItem[var3];
                int var5 = this.aVector4497.size();
                int var6 = 0;

                for (int var7 = 0; var7 < var5; ++var7) {
                    MultiColorListItem var8 = this.getItem(var7);
                    if (!var1 || var8.isSelected()) {
                        var4[var6] = var8;
                        ++var6;
                    }
                }

                return var4;
            }
        }
    }

    private void method2900(int var1) {
        Object var2 = this.anObject4504;
        synchronized (this.anObject4504) {
            if (var1 == this.anInt4489) {
                this.aBoolean4494 = !this.aBoolean4494;
            } else {
                this.aBoolean4494 = false;
            }

            this.anInt4489 = var1;
            this.reSort();
        }
    }

    private int method2901(MultiColorListItem var1) {
        Object var2 = this.anObject4504;
        synchronized (this.anObject4504) {
            int var3 = this.aVector4497.size();
            if (var3 == 0) {
                return 0;
            } else if (this.anInt4489 < 0) {
                return var3;
            } else {
                String var4 = var1.getString(this.anInt4489);
                var4 = var4 != null ? var4.toLowerCase() : "";

                for (int var5 = 0; var5 < var3; ++var5) {
                    String var6 = this.getItem(var5).getString(this.anInt4489);
                    var6 = var6 != null ? var6.toLowerCase() : "";
                    if (this.anIntArray4487[this.anInt4489] != 0 && this.anIntArray4487[this.anInt4489] != 1) {
                        double var13 = this.method2902(var4, this.anIntArray4487[this.anInt4489]);
                        double var9 = this.method2902(var6, this.anIntArray4487[this.anInt4489]);
                        if (this.anIntArray4487[this.anInt4489] != 2 && this.anIntArray4487[this.anInt4489] != 4) {
                            if (!this.aBoolean4494) {
                                if (var13 > var9) {
                                    return var5;
                                }
                            } else if (var13 < var9) {
                                return var5;
                            }
                        } else if (!this.aBoolean4494) {
                            if (var13 < var9) {
                                return var5;
                            }
                        } else if (var13 > var9) {
                            return var5;
                        }
                    } else {
                        int var7 = var4.compareTo(var6);
                        if (this.anIntArray4487[this.anInt4489] == 0) {
                            if (!this.aBoolean4494) {
                                if (var7 < 0) {
                                    return var5;
                                }
                            } else if (var7 > 0) {
                                return var5;
                            }
                        } else if (!this.aBoolean4494) {
                            if (var7 > 0) {
                                return var5;
                            }
                        } else if (var7 < 0) {
                            return var5;
                        }
                    }
                }

                return var3;
            }
        }
    }

    private double method2902(String var1, int var2) {
        int var3 = var1.length();
        if (var3 == 0) {
            return Double.MAX_VALUE;
        } else {
            StringBuffer var4 = new StringBuffer(var3);
            boolean var5 = false;

            for (int var7 = 0; var7 < var3; ++var7) {
                char var6 = var1.charAt(var7);
                if (var6 == 45 && var4.length() == 0) {
                    var4.append(var6);
                } else if (var6 == this.aChar4485 && var5) {
                    var4.append('.');
                    var5 = true;
                } else if (var6 >= 48 && var6 <= 57) {
                    var4.append(var6);
                    if (!var5) {
                        var5 = true;
                    }
                } else if (var2 == 2 || var2 == 3) {
                    var7 = var3;
                }
            }

            var1 = var4.toString();
            if (var1.length() == 0) {
                return -1.7976931348623157E308D;
            } else if (var1.equals("-")) {
                return -1.7976931348623157E308D;
            } else {
                return (new Double(var1)).doubleValue();
            }
        }
    }

    private int[] method2903(String[][] var1) {
        if (this.aFontMetrics4483 == null) {
            this.aFontMetrics4483 = this.getFontMetrics(Class128.aFont1998);
        }

        int var2 = var1.length;
        int var3 = var1[0].length;
        int[] var4 = new int[var3];

        int var5;
        for (var5 = 0; var5 < var3; ++var5) {
            var4[var5] = this.aFontMetrics4483.stringWidth(this.aStringArray4486[var5]);
        }

        int var6;
        for (var5 = 0; var5 < var2; ++var5) {
            for (var6 = 0; var6 < var3; ++var6) {
                int var7 = var1[var5][var6] != null ? this.aFontMetrics4483.stringWidth(var1[var5][var6]) : 0;
                if (var7 > var4[var6]) {
                    var4[var6] = var7;
                }
            }
        }

        var5 = 0;

        for (var6 = 0; var6 < var3; ++var6) {
            var5 += var4[var6];
        }

        double var10 = 1.0D * (double) this.anInt4492 / (double) var5;
        var5 = 0;
        int[] var8 = new int[var3];

        for (int var9 = 0; var9 < var3; ++var9) {
            var8[var9] = var5;
            var5 += (int) ((double) var4[var9] * var10);
        }

        return var8;
    }

    private int method2904(int var1) {
        int var2 = this.aVector4497.size();
        if (var2 == 0) {
            return -1;
        } else {
            int var3 = this.aBoolean4480 ? this.aJScrollBar4479.getValue() : 0;

            for (int var4 = 0; var4 < this.anInt4493 + 1 && var3 < var2; ++var3) {
                if (var1 >= var4 * 16 && var1 < (var4 + 1) * 16) {
                    return var3;
                }

                ++var4;
            }

            return -1;
        }
    }

    private void method2905(boolean var1) {
        Object var2 = this.anObject4504;
        synchronized (this.anObject4504) {
            int var3 = this.aVector4497.size();
            int var4 = 0;

            while (true) {
                if (var4 >= var3) {
                    break;
                }

                this.getItem(var4).setSelected(var1);
                ++var4;
            }
        }

        this.repaint();
    }

    private void method2906(MultiColorListItem var1, int var2, int var3) {
        Object var4 = this.anObject4504;
        synchronized (this.anObject4504) {
            if (this.aVector4503.size() != 0) {
                ItemEvent var5 = new ItemEvent(this, var2, var1, var3);
                Enumeration var6 = this.aVector4503.elements();

                while (var6.hasMoreElements()) {
                    ((ItemListener) ((ItemListener) var6.nextElement())).itemStateChanged(var5);
                }

            }
        }
    }

    static {
        aStringArray4505[0] = " != ";
        aStringArray4505[1] = "Error: MultiColorList.addItem(...): ccount = ";
        aStringArray4505[2] = " = noc";
        aStringArray4505[3] = "Dialog";
        aFont4476 = new Font("Dialog", 1, 12);
        aColor4477 = new Color(255, 255, 255);
        aColor4478 = new Color(192, 192, 192);
    }
}
