package com.playray.colorgui;

import com.playray.client.SPanel;
import com.playray.colorgui.LightTabBarItem;
import com.playray.colorgui.LightTabBarListener;
import com.playray.colorgui.SPanel_Sub42;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Enumeration;
import java.util.Vector;

public class LightTabBar extends SPanel implements ComponentListener {

    private Vector aVector4472 = new Vector();
    private Vector aVector4473 = new Vector();
    private int anInt4474 = 255;
    private Object anObject4475 = new Object();


    public LightTabBar() {
        super(false);
        this.addComponentListener(this);
    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        this.method2894();
        this.repaint();
    }

    public void addTab(LightTabBarItem var1) {
        Object var2 = this.anObject4475;
        synchronized (this.anObject4475) {
            this.aVector4472.addElement(var1);
            var1.method2085(this);
            this.method2894();
            SPanel_Sub42 var3 = var1.getButton();
            var3.method2889(this.anInt4474);
            this.add(var3);
            if (this.aVector4472.size() == 1) {
                var1.method2087(true);
                this.method2896((LightTabBarItem) null, var1);
            }
        }

        this.repaint();
    }

    public LightTabBarItem getTabByIndex(int var1) {
        return (LightTabBarItem) ((LightTabBarItem) this.aVector4472.elementAt(var1));
    }

    public LightTabBarItem getTabByID(int var1) {
        Object var2 = this.anObject4475;
        synchronized (this.anObject4475) {
            int var3 = this.aVector4472.size();

            for (int var4 = 0; var4 < var3; ++var4) {
                LightTabBarItem var5 = this.getTabByIndex(var4);
                if (var5.getTabID() == var1) {
                    return var5;
                }
            }

            return null;
        }
    }

    public LightTabBarItem[] getTabs() {
        Object var1 = this.anObject4475;
        synchronized (this.anObject4475) {
            int var2 = this.aVector4472.size();
            LightTabBarItem[] var3 = new LightTabBarItem[var2];
            this.aVector4472.copyInto(var3);
            return var3;
        }
    }

    public LightTabBarItem getSelectedTab() {
        Object var1 = this.anObject4475;
        synchronized (this.anObject4475) {
            int var2 = this.aVector4472.size();

            for (int var3 = 0; var3 < var2; ++var3) {
                LightTabBarItem var4 = this.getTabByIndex(var3);
                if (var4.getButton().method2888()) {
                    return var4;
                }
            }

            return null;
        }
    }

    public void setAlpha(int var1) {
        Object var2 = this.anObject4475;
        synchronized (this.anObject4475) {
            int var3 = this.aVector4472.size();

            for (int var4 = 0; var4 < var3; ++var4) {
                this.getTabByIndex(var4).getButton().method2889(var1);
            }

            this.anInt4474 = var1;
        }
    }

    protected void method2893(LightTabBarItem var1) {
        Object var2 = this.anObject4475;
        synchronized (this.anObject4475) {
            LightTabBarItem var3 = null;

            for (int var4 = 0; var4 < this.aVector4472.size(); ++var4) {
                LightTabBarItem var5 = this.getTabByIndex(var4);
                if (var5.getButton().method2888()) {
                    var5.method2087(false);
                    var3 = var5;
                }
            }

            var1.method2087(true);
            this.method2896(var3, var1);
        }
    }

    public void addLightTabBarListener(LightTabBarListener var1) {
        Object var2 = this.anObject4475;
        synchronized (this.anObject4475) {
            this.aVector4473.addElement(var1);
        }
    }

    public void removeLightTabBarListener(LightTabBarListener var1) {
        Object var2 = this.anObject4475;
        synchronized (this.anObject4475) {
            this.aVector4473.removeElement(var1);
        }
    }

    private void method2894() {
        Object var1 = this.anObject4475;
        synchronized (this.anObject4475) {
            Dimension var2 = this.getSize();
            int var3 = this.aVector4472.size();

            for (int var4 = 0; var4 < var3; ++var4) {
                this.method2897(var4).method2885();
            }

            int var5;
            boolean var14;
            do {
                var14 = false;
                var5 = this.method2895(var3);
                if (var5 > var2.width) {
                    for (int var6 = 0; var6 < var3; ++var6) {
                        var14 = this.method2897(var6).method2886();
                    }
                }
            } while (var14);

            double var15 = 1.0D * (double) var2.width / (double) var5;
            if (var15 > 1.2D) {
                var15 = 1.2D;
            }

            int var8 = 0;

            for (int var9 = 0; var9 < var3; ++var9) {
                SPanel_Sub42 var10 = this.method2897(var9);
                int var11 = (int) ((double) var10.getPreferredSize().width * var15 + 0.5D);
                var10.setBounds(var8, 0, var11, var2.height);
                var8 += var11 + 2;
            }

        }
    }

    private int method2895(int var1) {
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            SPanel_Sub42 var4 = this.method2897(var3);
            var2 += 2 + var4.getPreferredSize().width + 2;
        }

        return var2;
    }

    private void method2896(LightTabBarItem var1, LightTabBarItem var2) {
        Object var3 = this.anObject4475;
        synchronized (this.anObject4475) {
            if (this.aVector4473.size() != 0) {
                Enumeration var4 = this.aVector4473.elements();

                while (var4.hasMoreElements()) {
                    ((LightTabBarListener) ((LightTabBarListener) var4.nextElement())).selectedTabChanged(var1, var2);
                }

            }
        }
    }

    private SPanel_Sub42 method2897(int var1) {
        return this.getTabByIndex(var1).getButton();
    }
}
