package com.aapeli.settingsgui;

import com.aapeli.settingsgui.Unit;

public final class Rule {

    private int anInt1685;
    private Unit anUnit1686;
    private Unit anUnit1687;
    private int anInt1688;
    private int anInt1689;
    private boolean aBoolean1690;


    public Rule(Unit var1, int var2, Unit var3, int var4) {
        this.anInt1685 = 0;
        this.anUnit1686 = var1;
        this.anInt1688 = var2;
        this.anUnit1687 = var3;
        this.anInt1689 = var4;
    }

    public Rule(Unit var1, int var2, Unit var3, boolean var4) {
        this.anInt1685 = 1;
        this.anUnit1686 = var1;
        this.anInt1688 = var2;
        this.anUnit1687 = var3;
        this.aBoolean1690 = var4;
    }

    protected boolean method1827() {
        return this.method1828(this.anUnit1686);
    }

    protected boolean method1828(Unit var1) {
        return var1 != this.anUnit1686 ? false : (var1.getItemState() != this.anInt1688 ? false : (this.anInt1685 == 0 ? this.anUnit1687.setItemState(this.anInt1689) : this.anUnit1687.method1830(this.aBoolean1690)));
    }
}
