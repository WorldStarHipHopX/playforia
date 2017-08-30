package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.HtmlText;
import com.playray.client.JFrame_Sub4_Sub1;
import com.playray.client.SPanel;
import com.playray.colorgui.GlossyButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SPanel_Sub39 extends SPanel implements ActionListener {

    private static final Color aColor4275;
    private static final Color aColor4276;
    private static final Font aFont4277;
    private AApplet anAApplet4278;
    private JFrame_Sub4_Sub1 aJFrame_Sub4_Sub1_4279;
    private int anInt4280;
    private int anInt4281;
    private HtmlText aHtmlText4282;
    private GlossyButton aGlossyButton4283;
    private GlossyButton aGlossyButton4284;
    private GlossyButton aGlossyButton4285;
    private static final String[] aStringArray4286 = new String[12];


    protected SPanel_Sub39(AApplet var1, JFrame_Sub4_Sub1 var2, int var3, int var4) {
        this.anAApplet4278 = var1;
        this.aJFrame_Sub4_Sub1_4279 = var2;
        this.anInt4280 = var3;
        this.anInt4281 = var4;
        this.setSize(450, 275);
        this.setBackground(aColor4275);
        this.setForeground(aColor4276);
        this.method2813();
        this.setSharedBackground(var1.anImageManager3822, "background-light.png", 0, 0);
    }

    public void paintContent(Graphics2D var1) {
        var1.setFont(aFont4277);
        if (this.aHtmlText4282 == null) {
            String var2 = null;
            if (this.anInt4280 == 0) {
                if (this.anInt4281 == 1) {
                    var2 = "WS_ScoreNotSaved";
                } else if (this.anInt4281 == 2) {
                    var2 = "WM_StatsNotSaved";
                }
            } else if (this.anInt4280 == 1) {
                if (this.anInt4281 == 1) {
                    var2 = "RS_PersonalRecord";
                } else if (this.anInt4281 == 2) {
                    var2 = "RM_FirstRanking";
                }
            }

            var2 = this.anAApplet4278.aTextManager3821.getShared("GameFin_" + var2);
            this.aHtmlText4282 = new HtmlText(var1, 410, var2);
        }

        var1.setColor(aColor4276);
        this.aHtmlText4282.print(var1, 20, 45);
    }

    public void actionPerformed(ActionEvent var1) {
        this.aJFrame_Sub4_Sub1_4279.close();
        if (var1.getSource() == this.aGlossyButton4283) {
            this.anAApplet4278.setEndState(7);
            this.anAApplet4278.param.showRegisterPage();
        }

    }

    protected String method2812() {
        return this.anInt4280 == 0 ? this.anAApplet4278.aTextManager3821.getShared("GameFin_W_GameOver") : (this.anInt4280 == 1 ? this.anAApplet4278.aTextManager3821.getShared("GameFin_R_Congratulations") : "-");
    }

    private void method2813() {
        if (this.anInt4280 == 0) {
            this.aGlossyButton4283 = new GlossyButton(this.anAApplet4278.aTextManager3821.getShared("GameFin_W_CreateAccount"), 1);
            this.aGlossyButton4283.setBounds(210, 230, 220, 30);
            this.aGlossyButton4283.addActionListener(this);
            this.add(this.aGlossyButton4283);
            this.aGlossyButton4284 = new GlossyButton(this.anAApplet4278.aTextManager3821.getShared("GameFin_W_Continue"), 4);
            this.aGlossyButton4284.setBounds(20, 233, 160, 27);
            this.aGlossyButton4284.addActionListener(this);
            this.add(this.aGlossyButton4284);
        } else if (this.anInt4280 == 1) {
            this.aGlossyButton4285 = new GlossyButton(this.anAApplet4278.aTextManager3821.getShared("GameFin_R_OK"), 1);
            this.aGlossyButton4285.setBounds(330, 233, 100, 27);
            this.aGlossyButton4285.addActionListener(this);
            this.add(this.aGlossyButton4285);
        }

    }

    static {
        aStringArray4286[0] = "GameFin_W_CreateAccount";
        aStringArray4286[1] = "GameFin_W_Continue";
        aStringArray4286[2] = "GameFin_R_OK";
        aStringArray4286[3] = "GameFin_W_GameOver";
        aStringArray4286[4] = "GameFin_R_Congratulations";
        aStringArray4286[5] = "background-light.png";
        aStringArray4286[6] = "GameFin_";
        aStringArray4286[7] = "RM_FirstRanking";
        aStringArray4286[8] = "RS_PersonalRecord";
        aStringArray4286[9] = "WS_ScoreNotSaved";
        aStringArray4286[10] = "WM_StatsNotSaved";
        aStringArray4286[11] = "Dialog";
        aColor4275 = new Color(240, 240, 240);
        aColor4276 = Color.black;
        aFont4277 = new Font("Dialog", 0, 16);
    }
}
