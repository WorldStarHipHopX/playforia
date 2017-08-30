package apool;

import com.playray.client.StringDraw;
import com.playray.colorgui.GlossyButton;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SPanel_Sub34_Sub3 extends SPanel_Sub34 implements ActionListener {

    private SPanel_Sub20_Sub1_Sub2 aSPanel_Sub20_Sub1_Sub2_4920;
    private Image[][] anImageArrayArray4921;
    private boolean aBoolean4922;
    private boolean aBoolean4923;
    private int anInt4924;
    private int anInt4925;
    private int anInt4926;
    private int anInt4927;
    private int anInt4928;
    private GlossyButton aGlossyButton4929;
    private static final String[] aStringArray4930 = new String[5];


    protected SPanel_Sub34_Sub3(Class60 var1, SPanel_Sub20_Sub1_Sub2 var2, int var3, int var4) {
        super(var1, var3, var4);
        this.aSPanel_Sub20_Sub1_Sub2_4920 = var2;
        this.anImageArrayArray4921 = var1.gameApplet.method2315();
        this.aBoolean4922 = false;
        this.method2774();
    }

    public void method2738(Graphics2D var1) {
        if (this.aBoolean4922) {
            var1.setColor(SPanel_Sub34.aColor4201);
            var1.setFont(SPanel_Sub34.aFont4200);
            byte var2 = 10;
            int var4 = var2 + StringDraw.drawString(var1, super.aClass60_4202.textManager.method2039("GameSnookerInfo_Next"), var2, 60, -1) + 10;
            if (this.anInt4924 == 1) {
                var1.drawImage(this.anImageArrayArray4921[0][1], var4, 49, this);
                var4 += 12;
            } else if (this.anInt4924 == 2) {
                for (int var3 = 16; var3 <= 21; ++var3) {
                    var1.drawImage(this.anImageArrayArray4921[0][var3], var4, 49, this);
                    var4 += 5;
                }

                var4 += 7;
            } else {
                var1.drawImage(this.anImageArrayArray4921[0][this.anInt4924], var4, 49, this);
                var4 += 12;
            }

            if (this.anInt4925 > 0 && !this.aBoolean4923) {
                var4 += 20;
                var1.drawString("= " + this.anInt4925, var4, 60);
            }

            var1.setFont(SPanel_Sub34.aFont4199);
            var4 = 10;
            if (this.anInt4926 > 0) {
                var4 += StringDraw.drawString(var1, super.aClass60_4202.textManager.method2045("GameSnookerInfo_Break", this.anInt4926), var4, 28, -1);
                var4 += 30;
            }

            if (this.aBoolean4923) {
                var1.drawString(super.aClass60_4202.textManager.method2039("GameSnookerInfo_Fault"), var4, 28);
            }

        }
    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aGlossyButton4929 && this.method2773()) {
            this.aSPanel_Sub20_Sub1_Sub2_4920.method2563();
        }

    }

    protected void method2762(int var1, boolean var2) {
        this.anInt4924 = var1;
        if (!var2) {
            this.anInt4926 = 0;
        }

        this.anInt4925 = 0;
        this.aBoolean4923 = false;
        this.anInt4927 = this.anInt4928 = -1;
        this.aBoolean4922 = true;
        this.repaint();
    }

    protected void method2763(int var1) {
        this.anInt4925 += var1;
        this.repaint();
    }

    protected void method2764(int var1, int var2) {
        this.aBoolean4923 = true;
        if (var2 > this.anInt4928) {
            this.anInt4927 = var1;
            this.anInt4928 = var2;
        }

        this.repaint();
    }

    protected int method2765() {
        return this.anInt4925;
    }

    protected boolean method2766() {
        return this.aBoolean4923;
    }

    protected int[] method2767() {
        int[] var1 = new int[]{this.anInt4927, this.anInt4928 < 4 ? 4 : this.anInt4928};
        return var1;
    }

    protected void method2768() {
        this.aBoolean4922 = false;
        if (!this.aBoolean4923) {
            this.anInt4926 += this.anInt4925;
        }

        this.repaint();
    }

    protected String method2769() {
        return (this.anInt4926 < 13 ? "0" : "") + Integer.toString(this.anInt4926, 13);
    }

    protected void method2770(String var1) {
        this.anInt4926 = Integer.parseInt(var1, 13);
        this.repaint();
    }

    protected int method2771() {
        return this.anInt4926;
    }

    protected void method2772() {
        this.aGlossyButton4929.setVisible(true);
    }

    protected boolean method2773() {
        if (!this.aGlossyButton4929.isVisible()) {
            return false;
        } else {
            this.aGlossyButton4929.setVisible(false);
            return true;
        }
    }

    private void method2774() {
        this.aGlossyButton4929 = new GlossyButton(super.aClass60_4202.textManager.method2039("GameSnookerInfo_Pass"), 4);
        this.aGlossyButton4929.setBounds(super.anInt4203 / 2 - 50, 8, 100, 22);
        this.aGlossyButton4929.addActionListener(this);
        this.aGlossyButton4929.setVisible(false);
        this.add(this.aGlossyButton4929);
    }

    static {
        aStringArray4930[0] = "GameSnookerInfo_Pass";
        aStringArray4930[1] = "= ";
        aStringArray4930[2] = "GameSnookerInfo_Next";
        aStringArray4930[3] = "GameSnookerInfo_Break";
        aStringArray4930[4] = "GameSnookerInfo_Fault";
    }
}
