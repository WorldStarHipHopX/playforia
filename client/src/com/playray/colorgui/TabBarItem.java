package com.playray.colorgui;

import com.playray.colorgui.RadioButton;
import com.playray.colorgui.TabBar;

import java.awt.Component;
import java.awt.Image;

public final class TabBarItem {

    private RadioButton aRadioButton2025;
    private Component aComponent2026;
    private int anInt2027;
    private boolean aBoolean2028;


    public TabBarItem(TabBar var1, String var2, Component var3) {
        this(var1, (Image) null, var2, var3);
    }

    public TabBarItem(TabBar var1, Image var2, String var3, Component var4) {
        this.aRadioButton2025 = var1.method2922(var2, var3);
        this.aComponent2026 = var4;
        this.anInt2027 = 0;
        this.aBoolean2028 = false;
    }

    public void setTabID(int var1) {
        this.anInt2027 = var1;
    }

    public int getTabID() {
        return this.anInt2027;
    }

    public void setComponentAutoSize(boolean var1) {
        this.aBoolean2028 = var1;
    }

    public boolean isComponentAutoSize() {
        return this.aBoolean2028;
    }

    public RadioButton getButton() {
        return this.aRadioButton2025;
    }

    public Component getComponent() {
        return this.aComponent2026;
    }
}
