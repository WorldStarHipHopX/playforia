package com.aapeli.colorgui;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.Class94;
import com.aapeli.colorgui.RadioButton;
import com.aapeli.colorgui.RadioButtonGroup;
import com.aapeli.colorgui.TabBarItem;
import com.aapeli.colorgui.TabBarListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Enumeration;
import java.util.Vector;

public class TabBar extends IPanel implements ComponentListener, ActionListener {

    private static final Color aColor3403 = Color.lightGray;
    private static final Color aColor3404 = Color.black;
    private static final Color aColor3405 = Color.blue;
    private static final Color aColor3406 = Color.white;
    private static final Font aFont3407 = Class94.aFont1575;
    private int anInt3408;
    private int anInt3409;
    private Color aColor3410;
    private Color aColor3411;
    private Color aColor3412;
    private Color aColor3413;
    private Font aFont3414;
    private Image anImage3415;
    private int anInt3416;
    private int anInt3417;
    private RadioButtonGroup aRadioButtonGroup3418;
    private Vector aVector3419;
    private int anInt3420;
    private int anInt3421;
    private int anInt3422;
    private int anInt3423;
    private Vector aVector3424;
    private Object anObject3425 = new Object();


    public TabBar(int var1, int var2) {
        this.anInt3408 = var1;
        this.anInt3409 = var2;
        this.setSize(var1, var2);
        this.setBackground(aColor3403);
        this.setBorderColor(aColor3404);
        this.setButtonFont(aFont3407);
        this.setButtonBackground(aColor3405);
        this.setButtonForeground(aColor3406);
        this.anInt3422 = 2;
        this.aRadioButtonGroup3418 = new RadioButtonGroup();
        this.aVector3419 = new Vector();
        this.anInt3420 = 0;
        this.anInt3421 = -1;
        this.addComponentListener(this);
        this.aVector3424 = new Vector();
        this.setLayout((LayoutManager) null);
        this.anInt3423 = 0;
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.anImage3415 == null) {
            this.drawBackground(var1);
        } else if (this.anInt3416 == 0 && this.anInt3417 == 0) {
            var1.drawImage(this.anImage3415, 0, 0, this);
        } else {
            var1.drawImage(this.anImage3415, 0, 0, this.anInt3408, this.anInt3409, this.anInt3416, this.anInt3417, this.anInt3416 + this.anInt3408, this.anInt3417 + this.anInt3409, this);
        }

        if (this.anInt3422 != 0) {
            var1.setColor(this.aColor3411);
            if (this.anInt3422 == 2) {
                var1.drawRect(0, this.anInt3423 - 2, this.anInt3408 - 1, this.anInt3409 - this.anInt3423 + 1);
                var1.drawRect(1, this.anInt3423 - 1, this.anInt3408 - 3, this.anInt3409 - this.anInt3423 - 1);
            } else {
                var1.drawRect(0, this.anInt3423 - 1, this.anInt3408 - 1, this.anInt3409 - this.anInt3423);
            }
        }

    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Dimension var2 = this.getSize();
        this.anInt3408 = var2.width;
        this.anInt3409 = var2.height;
        this.method877();
        this.repaint();
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            int var3 = this.method878(var1);
            this.setSelectedIndex(var3);
            this.method879(this.anInt3421);
        }
    }

    public void setBorderColor(Color var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            this.aColor3411 = var1;
            int var3 = 0;

            while (true) {
                if (var3 >= this.anInt3420) {
                    break;
                }

                this.method880(var3).setBorderColor(var1);
                ++var3;
            }
        }

        this.repaint();
    }

    public void setButtonFont(Font var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            this.aFont3414 = var1;

            for (int var3 = 0; var3 < this.anInt3420; ++var3) {
                this.method880(var3).setFont(var1);
            }

        }
    }

    public void setButtonBackground(Color var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            this.aColor3412 = var1;

            for (int var3 = 0; var3 < this.anInt3420; ++var3) {
                this.method880(var3).setBackground(var1);
            }

        }
    }

    public void setButtonForeground(Color var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            this.aColor3413 = var1;

            for (int var3 = 0; var3 < this.anInt3420; ++var3) {
                this.method880(var3).setForeground(var1);
            }

        }
    }

    public void setBackground(Color var1) {
        this.aColor3410 = var1;
        super.setBackground(this.aColor3410);
        this.repaint();
    }

    public void setBorder(int var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            this.anInt3422 = var1;

            for (int var3 = 0; var3 < this.anInt3420; ++var3) {
                this.method880(var3).setBorder(var1);
            }

        }
    }

    public void addTab(String var1, Component var2) {
        Object var3 = this.anObject3425;
        synchronized (this.anObject3425) {
            this.addTab(new TabBarItem(this, var1, var2));
        }
    }

    public void addTab(TabBarItem var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            this.aVector3419.addElement(var1);
            ++this.anInt3420;
            this.method877();
            RadioButton var3 = var1.getButton();
            this.add(var3);
            if (this.anInt3420 == 1) {
                var3.setState(true);
                this.add(var1.getComponent());
                this.anInt3421 = 0;
            }
        }

        this.repaint();
    }

    public TabBarItem getTabBarItemByIndex(int var1) {
        TabBarItem var2 = (TabBarItem) ((TabBarItem) this.aVector3419.elementAt(var1));
        return var2;
    }

    public TabBarItem getTabBarItemByID(int var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            for (int var3 = 0; var3 < this.anInt3420; ++var3) {
                TabBarItem var4 = this.getTabBarItemByIndex(var3);
                if (var4.getTabID() == var1) {
                    return var4;
                }
            }

            return null;
        }
    }

    public TabBarItem[] getTabBarItems() {
        Object var1 = this.anObject3425;
        synchronized (this.anObject3425) {
            TabBarItem[] var2 = new TabBarItem[this.anInt3420];
            this.aVector3419.copyInto(var2);
            return var2;
        }
    }

    public void setTabTitle(int var1, String var2) {
        this.method880(var1).setLabel(var2);
        this.method877();
    }

    public int getSelectedIndex() {
        Object var1 = this.anObject3425;
        synchronized (this.anObject3425) {
            for (int var2 = 0; var2 < this.anInt3420; ++var2) {
                if (this.method880(var2).getState()) {
                    return var2;
                }
            }

            return -1;
        }
    }

    public void setSelectedIndex(int var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            if (var1 != this.anInt3421) {
                TabBarItem var3 = this.getTabBarItemByIndex(var1);
                TabBarItem var4 = this.getTabBarItemByIndex(this.anInt3421);
                var3.getButton().setState(true);
                this.remove(var4.getComponent());
                this.add(var3.getComponent());
                this.anInt3421 = var1;
            }
        }
    }

    public void setBackgroundImage(Image var1) {
        this.setBackgroundImage(var1, 0, 0);
    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        this.anImage3415 = var1;
        this.anInt3416 = var2;
        this.anInt3417 = var3;
        this.repaint();
    }

    public void addTabBarListener(TabBarListener var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            this.aVector3424.addElement(var1);
        }
    }

    public void removeTabBarListener(TabBarListener var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            this.aVector3424.removeElement(var1);
        }
    }

    protected RadioButton method876(Image var1, String var2) {
        RadioButton var3 = new RadioButton(var2, this.aRadioButtonGroup3418, false);
        var3.setIconImage(var1);
        var3.setFont(this.aFont3414);
        var3.setBackground(this.aColor3412);
        var3.setForeground(this.aColor3413);
        var3.setBorderColor(this.aColor3411);
        var3.setBorder(this.anInt3422);
        var3.addActionListener(this);
        return var3;
    }

    private void method877() {
        int var1 = 0;

        for (int var2 = 0; var2 < this.anInt3420; ++var2) {
            RadioButton var3 = this.method880(var2);
            var1 += 2 + var3.getPreferredSize().width + 2;
        }

        double var10 = 1.0D * (double) this.anInt3408 / (double) var1;
        if (var10 > 1.2D) {
            var10 = 1.2D;
        }

        int var4 = 0;

        int var5;
        int var6;
        for (var5 = 0; var5 < this.anInt3420; ++var5) {
            var6 = this.getTabBarItemByIndex(var5).getComponent().getSize().height;
            if (var6 > var4) {
                var4 = var6;
            }
        }

        this.anInt3423 = this.anInt3409 - 1 - 1 - var4;
        if (this.anInt3423 < 15) {
            this.anInt3423 = 15;
        } else if (this.anInt3423 > 30) {
            this.anInt3423 = 30;
        }

        var5 = 2;

        for (var6 = 0; var6 < this.anInt3420; ++var6) {
            RadioButton var7 = this.method880(var6);
            int var8 = (int) ((double) var7.getPreferredSize().width * var10 + 0.5D);
            var7.setBounds(var5, 0, var8, this.anInt3423);
            var5 += var8 + 2;
        }

        var6 = this.anInt3422 == 0 ? 0 : (this.anInt3422 == 1 ? 1 : 2);

        for (int var11 = 0; var11 < this.anInt3420; ++var11) {
            TabBarItem var12 = this.getTabBarItemByIndex(var11);
            Component var9 = var12.getComponent();
            var9.setLocation(var6, this.anInt3423);
            if (var12.isComponentAutoSize()) {
                var9.setSize(this.anInt3408 - var6 - var6, this.anInt3409 - this.anInt3423 - var6);
            }
        }

    }

    private int method878(ActionEvent var1) {
        Object var2 = var1.getSource();

        for (int var3 = 0; var3 < this.anInt3420; ++var3) {
            if (var2 == this.method880(var3)) {
                return var3;
            }
        }

        return -1;
    }

    private void method879(int var1) {
        Object var2 = this.anObject3425;
        synchronized (this.anObject3425) {
            if (this.aVector3424.size() != 0) {
                Enumeration var3 = this.aVector3424.elements();

                while (var3.hasMoreElements()) {
                    ((TabBarListener) ((TabBarListener) var3.nextElement())).selectedTabChanged(var1);
                }

            }
        }
    }

    private RadioButton method880(int var1) {
        return this.getTabBarItemByIndex(var1).getButton();
    }

}
