package com.playray.colorgui;

import com.playray.client.SPanel;
import com.playray.colorgui.Class128;
import com.playray.colorgui.RadioButton;
import com.playray.colorgui.RadioButtonGroup;
import com.playray.colorgui.TabBarItem;
import com.playray.colorgui.TabBarListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Enumeration;
import java.util.Vector;

public class TabBar extends SPanel implements ComponentListener, ActionListener {

    private static final Color aColor4528 = Color.lightGray;
    private static final Color aColor4529 = Color.black;
    private static final Color aColor4530 = Color.blue;
    private static final Color aColor4531 = Color.white;
    private static final Font aFont4532 = Class128.aFont1998;
    private int anInt4533;
    private int anInt4534;
    private Color aColor4535;
    private Color aColor4536;
    private Color aColor4537;
    private Color aColor4538;
    private Font aFont4539;
    private RadioButtonGroup aRadioButtonGroup4540;
    private Vector aVector4541;
    private int anInt4542;
    private int anInt4543;
    private int anInt4544;
    private int anInt4545;
    private Vector aVector4546;
    private Object anObject4547;


    public TabBar(int var1, int var2) {
        this.anInt4533 = var1;
        this.anInt4534 = var2;
        this.setSize(var1, var2);
        this.anObject4547 = new Object();
        this.setBackground(aColor4528);
        this.setBorderColor(aColor4529);
        this.setButtonFont(aFont4532);
        this.setButtonBackground(aColor4530);
        this.setButtonForeground(aColor4531);
        this.anInt4544 = 2;
        this.aRadioButtonGroup4540 = new RadioButtonGroup();
        this.aVector4541 = new Vector();
        this.anInt4542 = 0;
        this.anInt4543 = -1;
        this.addComponentListener(this);
        this.aVector4546 = new Vector();
        this.anInt4545 = 0;
    }

    public void paintContent(Graphics2D var1) {
        if (this.anInt4544 != 0) {
            var1.setColor(this.aColor4536);
            if (this.anInt4544 == 2) {
                var1.drawRect(0, this.anInt4545 - 2, this.anInt4533 - 1, this.anInt4534 - this.anInt4545 + 1);
                var1.drawRect(1, this.anInt4545 - 1, this.anInt4533 - 3, this.anInt4534 - this.anInt4545 - 1);
            } else {
                var1.drawRect(0, this.anInt4545 - 1, this.anInt4533 - 1, this.anInt4534 - this.anInt4545);
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
        this.anInt4533 = var2.width;
        this.anInt4534 = var2.height;
        this.method2923();
        this.repaint();
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            int var3 = this.method2924(var1);
            this.setSelectedIndex(var3);
            this.method2925(this.anInt4543);
        }
    }

    public void setBorderColor(Color var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            this.aColor4536 = var1;

            for (int var3 = 0; var3 < this.anInt4542; ++var3) {
                this.method2926(var3).setBorderColor(var1);
            }

            this.repaint();
        }
    }

    public void setButtonFont(Font var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            this.aFont4539 = var1;

            for (int var3 = 0; var3 < this.anInt4542; ++var3) {
                this.method2926(var3).setFont(var1);
            }

        }
    }

    public void setButtonBackground(Color var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            this.aColor4537 = var1;

            for (int var3 = 0; var3 < this.anInt4542; ++var3) {
                this.method2926(var3).setBackground(var1);
            }

        }
    }

    public void setButtonForeground(Color var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            this.aColor4538 = var1;

            for (int var3 = 0; var3 < this.anInt4542; ++var3) {
                this.method2926(var3).setForeground(var1);
            }

        }
    }

    public void setBackground(Color var1) {
        this.aColor4535 = var1;
        super.setBackground(this.aColor4535);
        this.repaint();
    }

    public void setBorder(int var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            this.anInt4544 = var1;

            for (int var3 = 0; var3 < this.anInt4542; ++var3) {
                this.method2926(var3).setBorderType(var1);
            }

        }
    }

    public void addTab(String var1, Component var2) {
        Object var3 = this.anObject4547;
        synchronized (this.anObject4547) {
            TabBarItem var4 = new TabBarItem(this, var1, var2);
            this.addTab(var4);
        }
    }

    public void addTab(TabBarItem var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            this.aVector4541.addElement(var1);
            ++this.anInt4542;
            this.method2923();
            RadioButton var3 = var1.getButton();
            this.add(var3);
            if (this.anInt4542 == 1) {
                var3.setState(true);
                this.add(var1.getComponent());
                this.anInt4543 = 0;
            }
        }

        this.repaint();
    }

    public TabBarItem getTabBarItemByIndex(int var1) {
        TabBarItem var2 = (TabBarItem) ((TabBarItem) this.aVector4541.elementAt(var1));
        return var2;
    }

    public TabBarItem getTabBarItemByID(int var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            for (int var3 = 0; var3 < this.anInt4542; ++var3) {
                TabBarItem var4 = this.getTabBarItemByIndex(var3);
                if (var4.getTabID() == var1) {
                    return var4;
                }
            }

            return null;
        }
    }

    public TabBarItem[] getTabBarItems() {
        Object var1 = this.anObject4547;
        synchronized (this.anObject4547) {
            TabBarItem[] var2 = new TabBarItem[this.anInt4542];
            this.aVector4541.copyInto(var2);
            return var2;
        }
    }

    public void setTabTitle(int var1, String var2) {
        this.method2926(var1).setLabel(var2);
        this.method2923();
    }

    public int getSelectedIndex() {
        Object var1 = this.anObject4547;
        synchronized (this.anObject4547) {
            for (int var2 = 0; var2 < this.anInt4542; ++var2) {
                if (this.method2926(var2).getState()) {
                    return var2;
                }
            }

            return -1;
        }
    }

    public void setSelectedIndex(int var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            if (var1 != this.anInt4543) {
                TabBarItem var3 = this.getTabBarItemByIndex(var1);
                TabBarItem var4 = this.getTabBarItemByIndex(this.anInt4543);
                var3.getButton().setState(true);
                this.remove(var4.getComponent());
                this.add(var3.getComponent());
                this.anInt4543 = var1;
            }
        }
    }

    public void addTabBarListener(TabBarListener var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            this.aVector4546.addElement(var1);
        }
    }

    public void removeTabBarListener(TabBarListener var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            this.aVector4546.removeElement(var1);
        }
    }

    protected RadioButton method2922(Image var1, String var2) {
        RadioButton var3 = new RadioButton(var2, this.aRadioButtonGroup4540, false);
        var3.setIconImage(var1);
        var3.setFont(this.aFont4539);
        var3.setBackground(this.aColor4537);
        var3.setForeground(this.aColor4538);
        var3.setBorderColor(this.aColor4536);
        var3.setBorderType(this.anInt4544);
        var3.addActionListener(this);
        return var3;
    }

    private void method2923() {
        int var1 = 0;

        RadioButton var2;
        for (int var3 = 0; var3 < this.anInt4542; ++var3) {
            var2 = this.method2926(var3);
            var1 += 2 + var2.getPreferredSize().width + 2;
        }

        double var13 = 1.0D * (double) this.anInt4533 / (double) var1;
        if (var13 > 1.2D) {
            var13 = 1.2D;
        }

        int var5 = 0;

        int var7;
        for (var7 = 0; var7 < this.anInt4542; ++var7) {
            int var6 = this.getTabBarItemByIndex(var7).getComponent().getSize().height;
            if (var6 > var5) {
                var5 = var6;
            }
        }

        this.anInt4545 = this.anInt4534 - 1 - 1 - var5;
        if (this.anInt4545 < 15) {
            this.anInt4545 = 15;
        }

        if (this.anInt4545 > 30) {
            this.anInt4545 = 30;
        }

        var7 = 2;

        int var9;
        for (var9 = 0; var9 < this.anInt4542; ++var9) {
            var2 = this.method2926(var9);
            int var8 = (int) ((double) var2.getPreferredSize().width * var13 + 0.5D);
            var2.setBounds(var7, 0, var8, this.anInt4545);
            var7 += var8 + 2;
        }

        var9 = this.anInt4544 == 0 ? 0 : (this.anInt4544 == 1 ? 1 : 2);

        for (int var10 = 0; var10 < this.anInt4542; ++var10) {
            TabBarItem var11 = this.getTabBarItemByIndex(var10);
            Component var12 = var11.getComponent();
            var12.setLocation(var9, this.anInt4545);
            if (var11.isComponentAutoSize()) {
                var12.setSize(this.anInt4533 - var9 - var9, this.anInt4534 - this.anInt4545 - var9);
            }
        }

    }

    private int method2924(ActionEvent var1) {
        Object var2 = var1.getSource();

        for (int var3 = 0; var3 < this.anInt4542; ++var3) {
            if (var2 == this.method2926(var3)) {
                return var3;
            }
        }

        return -1;
    }

    private void method2925(int var1) {
        Object var2 = this.anObject4547;
        synchronized (this.anObject4547) {
            if (this.aVector4546.size() != 0) {
                Enumeration var3 = this.aVector4546.elements();

                while (var3.hasMoreElements()) {
                    ((TabBarListener) ((TabBarListener) var3.nextElement())).selectedTabChanged(var1);
                }

            }
        }
    }

    private RadioButton method2926(int var1) {
        return this.getTabBarItemByIndex(var1).getButton();
    }

}
