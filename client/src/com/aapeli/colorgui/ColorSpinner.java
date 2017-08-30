package com.aapeli.colorgui;

import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.Class92;

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
import java.awt.event.MouseMotionListener;
import java.util.Enumeration;
import java.util.Vector;

public final class ColorSpinner extends IPanel implements MouseListener, MouseMotionListener, ItemSelectable {

    private Vector aVector3310 = new Vector();
    private int anInt3311 = -1;
    private int anInt3312 = 0;
    private boolean aBoolean3313;
    private boolean aBoolean3314;
    private boolean aBoolean3315;
    private Font aFont3316;
    private int anInt3317;
    private Vector aVector3318;
    private Image anImage3319;
    private Graphics aGraphics3320;
    private int anInt3321;
    private int anInt3322;
    private Class92 aClass92_3323;
    private int anInt3324;
    private Object anObject3325;
    private static final String aString3326 = "Dialog";


    public ColorSpinner() {
        this.aBoolean3313 = this.aBoolean3314 = false;
        this.aBoolean3315 = false;
        this.aFont3316 = null;
        this.anInt3317 = -1;
        this.aClass92_3323 = null;
        this.anInt3324 = 0;
        this.anObject3325 = new Object();
        this.aVector3318 = new Vector();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.anInt3321 = this.anInt3322 = -1;
    }

    public void update(Graphics var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (var3 > 0 && var4 > 0) {
            if (this.anImage3319 == null || var3 != this.anInt3321 || var4 != this.anInt3322) {
                this.anImage3319 = this.createImage(var3, var4);
                this.aGraphics3320 = this.anImage3319.getGraphics();
                this.anInt3321 = var3;
                this.anInt3322 = var4;
            }

            this.drawBackground(this.aGraphics3320);
            Color var5 = this.getBackground();
            this.aGraphics3320.setColor(var5);
            this.aGraphics3320.fillRect(0, 0, var3, var4);
            Color var6 = this.getForeground();
            if (this.aBoolean3313) {
                this.aGraphics3320.setColor(var5);
                this.aGraphics3320.drawLine(0, var4 - 1, var3 - 1, var4 - 1);
                this.aGraphics3320.setColor(this.method844(var5, var6));
                double var7 = 1.0D * (double) (var3 - var4 * 2) / (double) this.aVector3310.size();
                this.aGraphics3320.drawLine((int) ((double) var4 + (double) this.anInt3311 * var7 + 0.5D), var4 - 2, (int) ((double) var4 + (double) (this.anInt3311 + 1) * var7 + 0.5D), var4 - 2);
            }

            this.aGraphics3320.setColor(this.method842(var5, 24));
            this.aGraphics3320.drawLine(0, 0, var3 - 1, 0);
            this.aGraphics3320.setColor(this.method842(var5, -36));
            this.aGraphics3320.drawLine(0, var4 - 1, var3 - 1, var4 - 1);
            this.method841(this.aGraphics3320, 0, 0, var4, var4, true, this.anInt3312 == -1);
            this.method841(this.aGraphics3320, var3 - var4, 0, var4, var4, false, this.anInt3312 == 1);
            this.aGraphics3320.setColor(var6);
            String var9 = this.getSelectedItem();
            if (var9 != null) {
                Font var8 = this.getFont();
                this.aGraphics3320.setFont(var8);
                StringDraw.drawString(this.aGraphics3320, var9, var3 / 2, var4 / 2 + var8.getSize() * 3 / 8 + 1, 0);
            }

            var1.drawImage(this.anImage3319, 0, 0, this);
        }
    }

    public void setFont(Font var1) {
        this.aBoolean3315 = true;
        super.setFont(var1);
        this.repaint();
    }

    public Font getFont() {
        if (this.aBoolean3315) {
            return super.getFont();
        } else {
            int var1 = this.getSize().height - 9;
            if (var1 < 9) {
                var1 = 9;
            }

            if (this.aFont3316 == null || var1 != this.anInt3317) {
                this.aFont3316 = new Font("Dialog", 0, var1);
                this.anInt3317 = var1;
            }

            return this.aFont3316;
        }
    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean3313 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean3313 = false;
        this.anInt3312 = 0;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        Object var2 = this.anObject3325;
        synchronized (this.anObject3325) {
            Dimension var3 = this.getSize();
            int var4 = var3.width;
            int var5 = var3.height;
            int var6 = var1.getX();
            int var7 = this.aVector3310.size();
            if (var6 < var5) {
                --this.anInt3311;
                if (this.anInt3311 < 0) {
                    this.anInt3311 = var7 - 1;
                }

                this.anInt3312 = -1;
                this.aBoolean3314 = false;
            } else if (var6 >= var4 - var5) {
                ++this.anInt3311;
                if (this.anInt3311 >= var7) {
                    this.anInt3311 = 0;
                }

                this.anInt3312 = 1;
                this.aBoolean3314 = false;
            } else {
                int var8 = (var6 - var5) * var7 / (var4 - var5 * 2);
                this.aBoolean3314 = true;
                if (var8 == this.anInt3311) {
                    return;
                }

                this.anInt3311 = var8;
            }
        }

        this.repaint();
        this.method845();
    }

    public void mouseReleased(MouseEvent var1) {
        if (this.anInt3312 != 0) {
            this.anInt3312 = 0;
            this.repaint();
        }

        this.aBoolean3314 = false;
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
        Object var2 = this.anObject3325;
        synchronized (this.anObject3325) {
            if (this.aBoolean3314) {
                Dimension var3 = this.getSize();
                int var4 = this.aVector3310.size();
                int var5 = (var1.getX() - var3.height) * var4 / (var3.width - var3.height * 2);
                if (var5 < 0) {
                    var5 = 0;
                } else if (var5 >= var4) {
                    var5 = var4 - 1;
                }

                if (var5 != this.anInt3311) {
                    this.anInt3311 = var5;
                    this.repaint();
                    this.method845();
                }

            }
        }
    }

    public Object[] getSelectedObjects() {
        String var1 = this.getSelectedItem();
        return var1 == null ? null : new Object[]{var1};
    }

    public int addItem(String var1) {
        Vector var2 = this.aVector3310;
        synchronized (this.aVector3310) {
            this.aVector3310.addElement(var1);
            if (this.anInt3311 == -1) {
                this.anInt3311 = 0;
                this.repaint();
            }

            return this.aVector3310.size() - 1;
        }
    }

    public String getItem(int var1) {
        Vector var2 = this.aVector3310;
        synchronized (this.aVector3310) {
            return (String) ((String) this.aVector3310.elementAt(var1));
        }
    }

    public String removeItem(int var1) {
        Vector var2 = this.aVector3310;
        synchronized (this.aVector3310) {
            String var3 = (String) ((String) this.aVector3310.elementAt(var1));
            this.aVector3310.removeElementAt(var1);
            if (this.anInt3311 >= var1) {
                --this.anInt3311;
                if (this.anInt3311 == -1 && !this.aVector3310.isEmpty()) {
                    this.anInt3311 = 0;
                }

                this.repaint();
            }

            return var3;
        }
    }

    public boolean removeAllItems() {
        Vector var1 = this.aVector3310;
        synchronized (this.aVector3310) {
            if (!this.aVector3310.isEmpty()) {
                this.aVector3310.removeAllElements();
                this.anInt3311 = -1;
                this.repaint();
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean setSelectedIndex(int var1) {
        Vector var2 = this.aVector3310;
        synchronized (this.aVector3310) {
            if (var1 >= 0 && var1 < this.aVector3310.size()) {
                if (var1 != this.anInt3311) {
                    this.anInt3311 = var1;
                    this.repaint();
                    return true;
                } else {
                    return false;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public int getSelectedIndex() {
        return this.anInt3311;
    }

    public String getSelectedItem() {
        Vector var1 = this.aVector3310;
        synchronized (this.aVector3310) {
            return this.anInt3311 == -1 ? null : this.getItem(this.anInt3311);
        }
    }

    public int getItemCount() {
        return this.aVector3310.size();
    }

    public void addItemListener(ItemListener var1) {
        Vector var2 = this.aVector3318;
        synchronized (this.aVector3318) {
            this.aVector3318.addElement(var1);
        }
    }

    public void removeItemListener(ItemListener var1) {
        Vector var2 = this.aVector3318;
        synchronized (this.aVector3318) {
            this.aVector3318.removeElement(var1);
        }
    }

    public void setItemEventProcessDelay(int var1) {
        if (var1 < 0) {
            throw new IllegalArgumentException();
        } else {
            this.anInt3324 = var1;
        }
    }

    private void method841(Graphics var1, int var2, int var3, int var4, int var5, boolean var6, boolean var7) {
        Color var8 = this.method842(this.getBackground(), -32);
        var1.setColor(var8);
        var1.fillRect(var2, var3, var4, var5);
        double var9 = (double) var2 + (double) var4 / 3.0D + 0.5D;
        double var11 = (double) var2 + (double) var4 * 2.0D / 3.0D - 0.5D;
        int[] var13 = new int[]{(int) (var6 ? var11 : var9), (int) (var6 ? var11 : var9), (int) (var6 ? var9 : var11)};
        int[] var14 = new int[]{(int) ((double) var3 + (double) var5 / 3.0D), (int) ((double) var3 + (double) var5 * 2.0D / 3.0D), (int) ((double) var3 + (double) var5 / 2.0D)};
        int[] var15 = new int[]{var13[0] + (var6 ? 1 : -1), var13[1] + (var6 ? 1 : -1), var13[2] + (var6 ? -1 : 1)};
        int[] var16 = new int[]{var14[0] - 1, var14[1] + 1, var14[2]};
        Color var17 = this.getForeground();
        var1.setColor(this.method844(var8, var17));
        var1.fillPolygon(var15, var16, 3);
        var1.setColor(var17);
        var1.fillPolygon(var13, var14, 3);
        Color var18 = this.method842(var8, 24);
        Color var19 = this.method842(var8, -36);
        var1.setColor(var7 ? var19 : var18);
        var1.drawRect(var2, var3, var4 - 1, var5 - 1);
        var1.drawRect(var2 + 1, var3 + 1, var4 - 3, var5 - 3);
        var1.setColor(var7 ? var18 : var19);
        var1.drawLine(var2 + 1, var3 + var5 - 1, var2 + var4 - 1, var3 + var5 - 1);
        var1.drawLine(var2 + 2, var3 + var5 - 2, var2 + var4 - 1, var3 + var5 - 2);
        var1.drawLine(var2 + var4 - 1, var3, var2 + var4 - 1, var3 + var5 - 1);
        var1.drawLine(var2 + var4 - 2, var3 + 1, var2 + var4 - 2, var3 + var5 - 1);
    }

    private Color method842(Color var1, int var2) {
        int var3 = var1.getRed();
        int var4 = var1.getGreen();
        int var5 = var1.getBlue();
        if (var3 == 0 && var4 == 0 && var5 == 0 && var2 < 0) {
            return new Color(16, 16, 16);
        } else if (var3 == 255 && var4 == 255 && var5 == 255 && var2 > 0) {
            return new Color(240, 240, 240);
        } else {
            var3 = this.method843(var3, var2);
            var4 = this.method843(var4, var2);
            var5 = this.method843(var5, var2);
            return new Color(var3, var4, var5);
        }
    }

    private int method843(int var1, int var2) {
        var1 += var2;
        if (var1 < 0) {
            var1 = 0;
        } else if (var1 > 255) {
            var1 = 255;
        }

        return var1;
    }

    private Color method844(Color var1, Color var2) {
        int var3 = (var1.getRed() * 2 + var2.getRed()) / 3;
        int var4 = (var1.getGreen() * 2 + var2.getGreen()) / 3;
        int var5 = (var1.getBlue() * 2 + var2.getBlue()) / 3;
        return new Color(var3, var4, var5);
    }

    private void method845() {
        Vector var1 = this.aVector3318;
        synchronized (this.aVector3318) {
            if (!this.aVector3318.isEmpty()) {
                if (this.aClass92_3323 != null) {
                    this.aClass92_3323.method1746();
                    this.aClass92_3323 = null;
                }

                if (this.anInt3324 == 0) {
                    this.method846();
                } else {
                    this.aClass92_3323 = new Class92(this, this, this.anInt3324);
                }

            }
        }
    }

    protected void method846() {
        String var1 = this.getSelectedItem();
        if (var1 != null) {
            ItemEvent var2 = new ItemEvent(this, 701, var1, 1);
            Enumeration var3 = this.aVector3318.elements();

            while (var3.hasMoreElements()) {
                ((ItemListener) ((ItemListener) var3.nextElement())).itemStateChanged(var2);
            }

        }
    }

}
