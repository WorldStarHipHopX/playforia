package apool;

import com.playray.colorgui.GlossyButton;

abstract class GlossyButton_Sub2 extends GlossyButton {

    private int anInt4955;


    protected GlossyButton_Sub2(String var1, int var2) {
        super(var1);
        this.anInt4955 = var2;
    }

    protected abstract boolean method2880();

    protected abstract boolean method2881();

    protected int method2882() {
        return this.anInt4955;
    }
}
