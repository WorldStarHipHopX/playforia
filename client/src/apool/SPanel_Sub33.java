package apool;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Graphics2D;

class SPanel_Sub33 extends SPanel {

    private Class60 aClass60_4189;
    private SPanel_Sub20 aSPanel_Sub20_4190;
    private SPanel_Sub30 aSPanel_Sub30_4191;
    private SynchronizedInt aSynchronizedInt_4192;
    private SynchronizedInt aSynchronizedInt_4193;
    private Class73 aClass73_4194;
    private SynchronizedBool aSynchronizedBool_4195;
    private boolean aBoolean4196;
    private boolean aBoolean4197;
    private static final String[] aStringArray4198 = new String[5];


    protected SPanel_Sub33(Class60 var1, SPanel_Sub20 var2, SPanel_Sub30 var3, int var4) {
        this.aClass60_4189 = var1;
        this.aSPanel_Sub20_4190 = var2;
        this.aSPanel_Sub30_4191 = var3;
        this.setSize(150, 68);
        this.aSynchronizedInt_4192 = new SynchronizedInt(var4);
        this.aSynchronizedInt_4193 = new SynchronizedInt(0);
        this.aSynchronizedBool_4195 = new SynchronizedBool();
        this.aBoolean4197 = false;
    }

    public void paintContent(Graphics2D var1) {
        if (!this.aBoolean4197) {
            Tools.setBestRendering(var1);
            this.aBoolean4197 = true;
        }

        int var2 = this.aSPanel_Sub30_4191.method2633();
        if (var2 == 0) {
            var1.drawImage(this.aClass60_4189.imageManager.method1983("game_timer_box-turn"), -2, 28, 120, 68, 0, 0, 150, 40, this);
        } else if (var2 == 1) {
            var1.drawImage(this.aClass60_4189.imageManager.method1983("game_timer_box-turn"), 152, 28, 30, 68, 0, 0, 150, 40, this);
        }

        var1.drawImage(this.aClass60_4189.imageManager.method1983("game_timer_box-bg"), 30, 0, this);
        var1.setFont(GameApplet.aFont4815);
        var1.setColor(new Color(8136458));
        StringDraw.drawString(var1, this.aClass60_4189.textManager.method2039("GameTimer_Time"), 75, 15, 0);
        if (var2 >= 0) {
            int var3 = this.aSynchronizedInt_4193.method1467();
            if (var3 > 0 || this.aSynchronizedBool_4195.method1460()) {
                int var4 = var3 / 60;
                int var5 = var3 % 60;
                byte var6 = 61;
                byte var7 = 28;
                int var8 = var6 + this.method2734(var1, var6, var7, var4) + 1;
                var8 += this.method2735(var1, var8, var7);
                var8 += this.method2734(var1, var8, var7, var5 / 10);
                this.method2734(var1, var8, var7, var5 % 10);
            }
        }

    }

    protected void method2732() {
        this.aSynchronizedInt_4193.method1463(this.aSynchronizedInt_4192.method1467());
        this.aSynchronizedBool_4195.method1459(this.aSPanel_Sub30_4191.method2633() == this.aSPanel_Sub30_4191.method2632());
        this.aBoolean4196 = true;
        this.repaint();
        if (this.aSynchronizedInt_4193.method1467() > 0) {
            this.method2733();
            this.aClass73_4194 = new Class73(this);
        }

    }

    protected void method2733() {
        if (this.aClass73_4194 != null) {
            this.aClass73_4194.method1544();
        }

        this.repaint();
    }

    private int method2734(Graphics2D var1, int var2, int var3, int var4) {
        var1.drawImage(this.aClass60_4189.imageManager.method1983("game_timer_" + var4), var2, var3, this);
        return 15;
    }

    private int method2735(Graphics2D var1, int var2, int var3) {
        if (this.aBoolean4196) {
            var1.drawImage(this.aClass60_4189.imageManager.method1983("game_timer_sep"), var2, var3, this);
        }

        return 5;
    }

    protected void method2736() {
        if (this.aSynchronizedBool_4195.method1460()) {
            this.aBoolean4196 = !this.aBoolean4196;
            this.repaint();
        }

    }

    protected boolean method2737() {
        this.aSynchronizedInt_4193.method1465();
        this.repaint();
        if (this.aSynchronizedBool_4195.method1460()) {
            if (this.aClass60_4189.aClass61_1207.playSounds) {
                int var1 = this.aSynchronizedInt_4192.method1467() / 3;
                if (var1 > 10) {
                    var1 = 10;
                }

                if (this.aSynchronizedInt_4193.method1467() > 0 && this.aSynchronizedInt_4193.method1467() <= var1) {
                    this.aClass60_4189.soundManager.playTimeLow();
                }
            }

            if (this.aSynchronizedInt_4193.method1467() <= 0) {
                this.aSPanel_Sub20_4190.method2527(false);
            }
        }

        return this.aSynchronizedInt_4193.method1467() <= 0;
    }

    static {
        aStringArray4198[0] = "game_timer_box-turn";
        aStringArray4198[1] = "game_timer_box-bg";
        aStringArray4198[2] = "GameTimer_Time";
        aStringArray4198[3] = "game_timer_sep";
        aStringArray4198[4] = "game_timer_";
    }
}
