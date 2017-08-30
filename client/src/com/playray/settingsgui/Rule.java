package com.playray.settingsgui;

import com.playray.settingsgui.Unit;

public final class Rule {

    private int anInt2188;
    private Unit anUnit2189;
    private Unit anUnit2190;
    private int anInt2191;
    private int anInt2192;
    private boolean aBoolean2193;


    public Rule(Unit var1, int var2, Unit var3, int var4) {
        this.anInt2188 = 0;
        this.anUnit2189 = var1;
        this.anInt2191 = var2;
        this.anUnit2190 = var3;
        this.anInt2192 = var4;
    }

    public Rule(Unit var1, int var2, Unit var3, boolean var4) {
        this.anInt2188 = 1;
        this.anUnit2189 = var1;
        this.anInt2191 = var2;
        this.anUnit2190 = var3;
        this.aBoolean2193 = var4;
    }

    protected boolean method2219() {
        return this.method2220(this.anUnit2189);
    }

    protected boolean method2220(Unit var1) {
        return var1 != this.anUnit2189 ? false : (var1.getItemState() != this.anInt2191 ? false : (this.anInt2188 == 0 ? this.anUnit2190.setItemState(this.anInt2192) : this.anUnit2190.setVisible(this.aBoolean2193)));
    }
}
