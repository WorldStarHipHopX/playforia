package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.NeedAccountFrame;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.GlossyButton;
import com.playray.tools.DelayRepaint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SPanel_Sub40 extends SPanel implements ActionListener {

    private static final Color aColor4287;
    private static final Color aColor4288;
    private static final Color aColor4289;
    private static final Color aColor4290;
    private static final Color aColor4291;
    private static final Color aColor4292;
    private static final Font aFont4293;
    private static final Font aFont4294;
    private AApplet anAApplet4295;
    private NeedAccountFrame aNeedAccountFrame4296;
    private GlossyButton aGlossyButton4297;
    private GlossyButton aGlossyButton4298;
    private GlossyButton aGlossyButton4299;
    private Object anObject4300;
    private static final String[] aStringArray4301 = new String[8];


    protected SPanel_Sub40(AApplet var1, NeedAccountFrame var2) {
        this.anAApplet4295 = var1;
        this.aNeedAccountFrame4296 = var2;
        this.anObject4300 = new Object();
        this.setSize(500, 265);
        this.setBackground(aColor4287);
        this.method2814();
    }

    public void paintContent(Graphics2D var1) {
        boolean var2 = false;
        Image var3 = this.anAApplet4295.anImageManager3822.getShared("background-light.png", true);
        if (var3 != null) {
            var1.drawImage(var3, 0, 0, this);
        } else {
            var1.setColor(aColor4287);
            var1.fillRect(0, 0, 500, 265);
            var2 = true;
        }

        var1.setColor(aColor4288);
        var1.setFont(aFont4293);
        StringDraw.drawStringWithMaxWidth(var1, this.anAApplet4295.aTextManager3821.getShared("NeedAccount_Info1"), 10, 35, -1, 480);
        StringDraw.drawStringWithMaxWidth(var1, this.anAApplet4295.aTextManager3821.getShared("NeedAccount_Info2"), 10, 97, -1, 480);
        var1.setFont(aFont4294);
        StringDraw.drawStringWithMaxWidth(var1, this.anAApplet4295.aTextManager3821.getShared("NeedAccount_NotLoggedIn"), 10, 215, -1, 480);
        var1.setColor(aColor4289);
        var1.drawLine(5, 192, 495, 192);
        if (var2) {
            new DelayRepaint(this);
        }

    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = this.anObject4300;
        synchronized (this.anObject4300) {
            this.aNeedAccountFrame4296.close();
            Object var3 = var1.getSource();
            if (var3 == this.aGlossyButton4297) {
                this.anAApplet4295.setEndState(7);
                this.anAApplet4295.param.showRegisterPage();
            } else if (var3 == this.aGlossyButton4299) {
                this.anAApplet4295.setEndState(5);
                this.anAApplet4295.param.showQuitPage();
            }

        }
    }

    private void method2814() {
        this.aGlossyButton4297 = new GlossyButton(this.anAApplet4295.aTextManager3821.getShared("NeedAccount_CreateButton"), 1);
        this.aGlossyButton4297.setBounds(10, 134, 200, 35);
        this.aGlossyButton4297.setBackground(aColor4290);
        this.aGlossyButton4297.addActionListener(this);
        this.add(this.aGlossyButton4297);
        this.aGlossyButton4298 = new GlossyButton(this.anAApplet4295.aTextManager3821.getShared("NeedAccount_LaterButton"), 4);
        this.aGlossyButton4298.setBounds(360, 144, 125, 25);
        this.aGlossyButton4298.setBackground(aColor4291);
        this.aGlossyButton4298.addActionListener(this);
        this.add(this.aGlossyButton4298);
        this.aGlossyButton4299 = new GlossyButton(this.anAApplet4295.aTextManager3821.getShared("NeedAccount_LoginButton"), 6);
        this.aGlossyButton4299.setBounds(10, 233, 125, 20);
        this.aGlossyButton4299.setBackground(aColor4292);
        this.aGlossyButton4299.addActionListener(this);
        this.add(this.aGlossyButton4299);
    }

    static {
        aStringArray4301[0] = "NeedAccount_NotLoggedIn";
        aStringArray4301[1] = "background-light.png";
        aStringArray4301[2] = "NeedAccount_Info1";
        aStringArray4301[3] = "NeedAccount_Info2";
        aStringArray4301[4] = "NeedAccount_CreateButton";
        aStringArray4301[5] = "NeedAccount_LaterButton";
        aStringArray4301[6] = "NeedAccount_LoginButton";
        aStringArray4301[7] = "Dialog";
        aColor4287 = new Color(240, 240, 240);
        aColor4288 = new Color(0, 0, 0);
        aColor4289 = new Color(64, 64, 64);
        aColor4290 = new Color(128, 255, 128);
        aColor4291 = new Color(224, 224, 128);
        aColor4292 = new Color(144, 208, 144);
        aFont4293 = new Font("Dialog", 0, 14);
        aFont4294 = new Font("Dialog", 0, 11);
    }
}
