package apool;

import com.playray.client.SPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

abstract class SPanel_Sub34 extends SPanel {

    protected static final Font aFont4199;
    protected static final Font aFont4200;
    protected static final Color aColor4201;
    protected Class60 aClass60_4202;
    protected int anInt4203;
    protected int anInt4204;
    private boolean aBoolean4205;
    private static final String[] aStringArray4206 = new String[2];


    protected SPanel_Sub34(Class60 var1, int var2, int var3) {
        this.aClass60_4202 = var1;
        this.anInt4203 = var2;
        this.anInt4204 = var3;
        this.setSize(var2, var3);
        this.aBoolean4205 = true;
    }

    public void paintContent(Graphics2D var1) {
        if (this.aBoolean4205) {
            Image var2 = this.aClass60_4202.imageManager.method1983("game_bg-top");
            var1.drawImage(var2, 0, 0, 10, this.anInt4204, 0, 0, 10, this.anInt4204, this);
            var1.drawImage(var2, this.anInt4203 - 10, 0, this.anInt4203, this.anInt4204, 20, 0, 30, this.anInt4204, this);
            var1.drawImage(var2, 10, 0, this.anInt4203 - 10, this.anInt4204, 10, 0, 20, this.anInt4204, this);
            this.aBoolean4205 = false;
            this.useCurrentBufferAsBackground();
        } else {
            this.method2738(var1);
        }
    }

    protected abstract void method2738(Graphics2D var1);

    static {
        aStringArray4206[0] = "game_bg-top";
        aStringArray4206[1] = "Dialog";
        aFont4199 = new Font("Dialog", 1, 16);
        aFont4200 = new Font("Dialog", 0, 14);
        aColor4201 = new Color(255, 255, 255);
    }
}
