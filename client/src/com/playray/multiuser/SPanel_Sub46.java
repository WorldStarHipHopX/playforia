package com.playray.multiuser;

import com.playray.client.SPanel;
import com.playray.colorgui.LightTabBar;
import com.playray.colorgui.LightTabBarItem;
import com.playray.colorgui.LightTabBarListener;
import com.playray.multiuser.ChatBase;
import com.playray.multiuser.ChatTextArea;
import com.playray.multiuser.Languages;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

final class SPanel_Sub46 extends SPanel implements ComponentListener, LightTabBarListener {

    private ChatBase aChatBase2616;
    private Languages aLanguages2617;
    private int anInt2618;
    private int anInt2619;
    private ChatTextArea aChatTextArea2620;
    private int anInt2621;
    private LightTabBar aLightTabBar2622;
    private int anInt2623;
    private Object anObject2624;


    protected SPanel_Sub46(ChatBase var1, ChatTextArea var2, int var3) {
        super(false);
        this.aChatBase2616 = var1;
        this.aLanguages2617 = new Languages(var1.aTextManager3809, var1.anImageManager3810);
        this.anInt2623 = 255;
        this.anObject2624 = new Object();
        Dimension var4 = var2.getSize();
        this.anInt2618 = var4.width;
        this.anInt2619 = var4.height;
        this.setSize(this.anInt2618, this.anInt2619);
        var2.setLocation(0, 0);
        this.add(var2);
        this.aChatTextArea2620 = var2;
        this.anInt2621 = var3;
        this.addComponentListener(this);
    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Object var2 = this.anObject2624;
        synchronized (this.anObject2624) {
            Dimension var3 = this.getSize();
            this.anInt2618 = var3.width;
            this.anInt2619 = var3.height;
            if (this.aLightTabBar2622 == null) {
                this.aChatTextArea2620.setSize(this.anInt2618, this.anInt2619);
            } else {
                this.aLightTabBar2622.setSize(this.anInt2618 - 5 - 5, 15);
                this.aChatBase2616.gui_output.setBounds(0, 15, this.anInt2618, this.anInt2619 - 15);
            }

        }
    }

    public void selectedTabChanged(LightTabBarItem var1, LightTabBarItem var2) {
        ChatTextArea var3;
        if (var1 != null) {
            var3 = (ChatTextArea) ((ChatTextArea) var1.getComponent());
            var3.setVisible(false);
            var3.destroyBuffer();
        }

        var3 = (ChatTextArea) ((ChatTextArea) var2.getComponent());
        var3.setBounds(0, 15, this.anInt2618, this.anInt2619 - 15);
        var3.setAlpha(this.anInt2623);
        var3.setVisible(true);
        this.aChatBase2616.setCurrentOutput(var3);
    }

    protected int method2969() {
        Object var1 = this.anObject2624;
        synchronized (this.anObject2624) {
            if (this.aLightTabBar2622 == null) {
                return this.anInt2621;
            } else {
                LightTabBarItem var2 = this.aLightTabBar2622.getSelectedTab();
                return var2.getTabID();
            }
        }
    }

    protected void method2970(int var1) {
        this.method2978(var1);
    }

    protected void method2971(int var1) {
        this.anInt2623 = var1;
        if (this.aLightTabBar2622 != null) {
            this.aLightTabBar2622.setAlpha(var1);
        }

    }

    protected void method2972(int var1, String var2, String var3) {
        ChatTextArea var4 = this.method2978(var1);
        var4.addSay(var2, var3);
    }

    protected void method2973(int var1, String var2) {
        ChatTextArea var3 = this.method2978(var1);
        var3.addMessage(var2);
    }

    protected void method2974(String var1) {
        ChatTextArea[] var2 = this.method2980();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3].addSheriffSay(var1);
        }

    }

    protected void method2975(String var1) {
        ChatTextArea[] var2 = this.method2980();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3].addServerSay(var1);
        }

    }

    protected void method2976(String var1) {
        ChatTextArea[] var2 = this.method2980();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3].addLocalizedServerSay(var1);
        }

    }

    protected void method2977(String var1) {
        ChatTextArea[] var2 = this.method2980();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3].addBroadcastMessage(var1);
        }

    }

    public void clear() {
        ChatTextArea[] var1 = this.method2980();

        for (int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2].clear();
        }

    }

    private ChatTextArea method2978(int var1) {
        Object var2 = this.anObject2624;
        synchronized (this.anObject2624) {
            if (this.aLightTabBar2622 == null) {
                if (var1 == this.anInt2621) {
                    return this.aChatTextArea2620;
                }

                this.removeAll();
                this.aLightTabBar2622 = new LightTabBar();
                this.aLightTabBar2622.setBounds(5, 0, this.anInt2618 - 5 - 5, 15);
                this.aLightTabBar2622.setBackground(super.getBackground());
                this.add(this.aLightTabBar2622);
                this.aLightTabBar2622.addLightTabBarListener(this);
                this.method2979(this.anInt2621, this.aChatTextArea2620);
                this.aChatTextArea2620 = null;
            }

            LightTabBarItem var3 = this.aLightTabBar2622.getTabByID(var1);
            if (var3 != null) {
                return (ChatTextArea) ((ChatTextArea) var3.getComponent());
            } else {
                ChatTextArea var4 = (ChatTextArea) ((ChatTextArea) this.aLightTabBar2622.getTabByIndex(0).getComponent());
                var4 = new ChatTextArea(var4.getTextManager(), var4.getBadWordFilter(), this.anInt2618, this.anInt2619 - 15, var4.getFont());
                this.method2979(var1, var4);
                return var4;
            }
        }
    }

    private void method2979(int var1, ChatTextArea var2) {
        String[] var3 = new String[]{this.aLanguages2617.getName(var1), this.aLanguages2617.get2charID(var1), null};
        LightTabBarItem var4 = new LightTabBarItem(this.aLanguages2617.getFlag(var1), var3, var2);
        var4.setTabID(var1);
        var2.setVisible(false);
        this.add(var2);
        var2.destroyBuffer();
        this.aLightTabBar2622.addTab(var4);
    }

    private ChatTextArea[] method2980() {
        Object var1 = this.anObject2624;
        synchronized (this.anObject2624) {
            if (this.aLightTabBar2622 == null) {
                return new ChatTextArea[]{this.aChatTextArea2620};
            } else {
                LightTabBarItem[] var2 = this.aLightTabBar2622.getTabs();
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
