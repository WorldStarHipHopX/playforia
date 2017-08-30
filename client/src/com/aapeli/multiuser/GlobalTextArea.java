package com.aapeli.multiuser;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.TabBar;
import com.aapeli.colorgui.TabBarItem;
import com.aapeli.colorgui.TabBarListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

final class GlobalTextArea extends IPanel implements ComponentListener, TabBarListener {

    private ChatBase aChatBase2361;
    private Languages aLanguages2362;
    private int anInt2363;
    private int anInt2364;
    private ChatTextArea aChatTextArea2365;
    private int anInt2366;
    private TabBar aTabBar2367;
    private Object anObject2368;


    protected GlobalTextArea(ChatBase var1, ChatTextArea var2, int var3) {
        this.aChatBase2361 = var1;
        this.anObject2368 = new Object();
        this.aLanguages2362 = new Languages(var1.textManager, var1.imageManager);
        Dimension var4 = var2.getSize();
        this.anInt2363 = var4.width;
        this.anInt2364 = var4.height;
        this.setSize(this.anInt2363, this.anInt2364);
        this.setLayout((LayoutManager) null);
        var2.setLocation(0, 0);
        this.add(var2);
        this.aChatTextArea2365 = var2;
        this.anInt2366 = var3;
        this.addComponentListener(this);
    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Object var2 = this.anObject2368;
        synchronized (this.anObject2368) {
            Dimension var3 = this.getSize();
            this.anInt2363 = var3.width;
            this.anInt2364 = var3.height;
            if (this.aTabBar2367 == null) {
                this.aChatTextArea2365.setSize(this.anInt2363, this.anInt2364);
            } else {
                this.aTabBar2367.setSize(this.anInt2363, this.anInt2364);
            }

        }
    }

    public void selectedTabChanged(int var1) {
        TabBarItem var2 = this.aTabBar2367.getTabBarItemByIndex(var1);
        ChatTextArea var3 = (ChatTextArea) ((ChatTextArea) var2.getComponent());
        this.aChatBase2361.setCurrentOutput(var3);
    }

    protected int method914() {
        Object var1 = this.anObject2368;
        synchronized (this.anObject2368) {
            if (this.aTabBar2367 == null) {
                return this.anInt2366;
            } else {
                TabBarItem var2 = this.aTabBar2367.getTabBarItemByIndex(this.aTabBar2367.getSelectedIndex());
                return var2.getTabID();
            }
        }
    }

    protected void method915(int var1) {
        this.method922(var1);
    }

    protected void method916(int var1, String var2, String var3) {
        ChatTextArea var4 = this.method922(var1);
        var4.addSay(var2, var3);
    }

    protected void method917(int var1, String var2) {
        ChatTextArea var3 = this.method922(var1);
        var3.addMessage(var2);
    }

    protected void method918(String var1) {
        ChatTextArea[] var2 = this.method924();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3].addSheriffSay(var1);
        }

    }

    protected void method919(String var1) {
        ChatTextArea[] var2 = this.method924();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3].addServerSay(var1);
        }

    }

    protected void method920(String var1) {
        ChatTextArea[] var2 = this.method924();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3].addLocalizedServerSay(var1);
        }

    }

    protected void method921(String var1) {
        ChatTextArea[] var2 = this.method924();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3].addBroadcastMessage(var1);
        }

    }

    public void clear() {
        ChatTextArea[] var1 = this.method924();

        for (int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2].clear();
        }

    }

    private ChatTextArea method922(int var1) {
        Object var2 = this.anObject2368;
        synchronized (this.anObject2368) {
            if (this.aTabBar2367 == null) {
                if (var1 == this.anInt2366) {
                    return this.aChatTextArea2365;
                }

                this.removeAll();
                this.aTabBar2367 = new TabBar(this.anInt2363, this.anInt2364);
                this.aTabBar2367.setLocation(0, 0);
                this.aTabBar2367.setBackground(super.getBackground());
                this.aTabBar2367.setButtonBackground(Color.lightGray);
                this.aTabBar2367.setButtonForeground(Color.black);
                this.aTabBar2367.setBorder(1);
                this.add(this.aTabBar2367);
                this.aTabBar2367.addTabBarListener(this);
                this.method923(this.anInt2366, this.aChatTextArea2365);
                this.aChatTextArea2365 = null;
            }

            TabBarItem var3 = this.aTabBar2367.getTabBarItemByID(var1);
            if (var3 != null) {
                return (ChatTextArea) ((ChatTextArea) var3.getComponent());
            } else {
                ChatTextArea var4 = (ChatTextArea) ((ChatTextArea) this.aTabBar2367.getTabBarItemByIndex(0).getComponent());
                var4 = new ChatTextArea(var4.getTextManager(), var4.getBadWordFilter(), this.anInt2363, this.anInt2364 - 15, var4.getFont());
                var4.setLocation(0, 15);
                this.method923(var1, var4);
                return var4;
            }
        }
    }

    private void method923(int var1, ChatTextArea var2) {
        var2.setBorder(0);
        TabBarItem var3 = new TabBarItem(this.aTabBar2367, this.aLanguages2362.getFlag(var1), this.aLanguages2362.getName(var1), var2);
        var3.setTabID(var1);
        var3.setComponentAutoSize(true);
        this.aTabBar2367.addTab(var3);
    }

    private ChatTextArea[] method924() {
        Object var1 = this.anObject2368;
        synchronized (this.anObject2368) {
            if (this.aTabBar2367 == null) {
                return new ChatTextArea[]{this.aChatTextArea2365};
            } else {
                TabBarItem[] var2 = this.aTabBar2367.getTabBarItems();
                int var3 = var2.length;
                ChatTextArea[] var4 = new ChatTextArea[var3];

                for (int var5 = 0; var5 < var3; ++var5) {
                    var4[var5] = (ChatTextArea) ((ChatTextArea) var2[var5].getComponent());
                }

                return var4;
            }
        }
    }
}
