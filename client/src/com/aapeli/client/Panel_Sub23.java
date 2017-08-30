package com.aapeli.client;

import com.aapeli.applet.AApplet;
import com.aapeli.colorgui.RoundButton;
import com.aapeli.tools.DelayRepaint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Panel_Sub23 extends Panel implements ActionListener {

    private static final Color aColor600;
    private static final Color aColor601;
    private static final Color aColor602;
    private static final Color aColor603;
    private static final Color aColor604;
    private static final Color aColor605;
    private static final Font aFont606;
    private static final Font aFont607;
    private AApplet anAApplet608;
    private NeedAccountFrame aNeedAccountFrame609;
    private RoundButton aRoundButton610;
    private RoundButton aRoundButton611;
    private RoundButton aRoundButton612;
    private Image anImage613;
    private Graphics aGraphics614;
    private static final String[] aStringArray615 = new String[8];


    protected Panel_Sub23(AApplet var1, NeedAccountFrame var2) {
        this.anAApplet608 = var1;
        this.aNeedAccountFrame609 = var2;
        this.setSize(500, 265);
        this.setBackground(aColor600);
        this.method479();
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.anImage613 == null) {
            this.anImage613 = this.createImage(500, 265);
            this.aGraphics614 = this.anImage613.getGraphics();
        }

        boolean var2 = false;
        Image var3 = this.anAApplet608.imageManager.getShared("tf-background.gif", true);
        if (var3 != null) {
            this.aGraphics614.drawImage(var3, 0, 0, this);
        } else {
            this.aGraphics614.setColor(aColor600);
            this.aGraphics614.fillRect(0, 0, 500, 265);
            var2 = true;
        }

        this.aGraphics614.setColor(aColor601);
        this.aGraphics614.setFont(aFont606);
        StringDraw.drawStringWithMaxWidth(this.aGraphics614, this.anAApplet608.textManager.getShared("NeedAccount_Info1"), 10, 35, -1, 480);
        StringDraw.drawStringWithMaxWidth(this.aGraphics614, this.anAApplet608.textManager.getShared("NeedAccount_Info2"), 10, 97, -1, 480);
        this.aGraphics614.setFont(aFont607);
        StringDraw.drawStringWithMaxWidth(this.aGraphics614, this.anAApplet608.textManager.getShared("NeedAccount_NotLoggedIn"), 10, 215, -1, 480);
        this.aGraphics614.setColor(aColor602);
        this.aGraphics614.drawLine(5, 192, 495, 192);
        var1.drawImage(this.anImage613, 0, 0, this);
        if (var2) {
            new DelayRepaint(this);
        }

    }

    public synchronized void actionPerformed(ActionEvent var1) {
        this.aNeedAccountFrame609.close();
        Object var2 = var1.getSource();
        if (var2 == this.aRoundButton610) {
            this.anAApplet608.setEndState(AApplet.END_QUIT_REGISTER);
            this.anAApplet608.param.showRegisterPage();
        } else if (var2 == this.aRoundButton612) {
            this.anAApplet608.setEndState(AApplet.END_QUIT);
            this.anAApplet608.param.showQuitPage();
        }

    }

    private void method479() {
        this.setLayout((LayoutManager) null);
        this.aRoundButton610 = new RoundButton(this.anAApplet608.textManager.getShared("NeedAccount_CreateButton"));
        this.aRoundButton610.setBounds(10, 134, 200, 35);
        this.aRoundButton610.setBackground(aColor603);
        this.aRoundButton610.addActionListener(this);
        this.add(this.aRoundButton610);
        this.aRoundButton611 = new RoundButton(this.anAApplet608.textManager.getShared("NeedAccount_LaterButton"));
        this.aRoundButton611.setBounds(360, 144, 125, 25);
        this.aRoundButton611.setBackground(aColor604);
        this.aRoundButton611.addActionListener(this);
        this.add(this.aRoundButton611);
        this.aRoundButton612 = new RoundButton(this.anAApplet608.textManager.getShared("NeedAccount_LoginButton"));
        this.aRoundButton612.setBounds(10, 233, 125, 20);
        this.aRoundButton612.setBackground(aColor605);
        this.aRoundButton612.addActionListener(this);
        this.add(this.aRoundButton612);
    }

    static {
        aStringArray615[0] = "NeedAccount_CreateButton";
        aStringArray615[1] = "NeedAccount_LoginButton";
        aStringArray615[2] = "NeedAccount_LaterButton";
        aStringArray615[3] = "NeedAccount_NotLoggedIn";
        aStringArray615[4] = "NeedAccount_Info2";
        aStringArray615[5] = "NeedAccount_Info1";
        aStringArray615[6] = "tf-background.gif";
        aStringArray615[7] = "Dialog";
        aColor600 = new Color(240, 240, 240);
        aColor601 = new Color(0, 0, 0);
        aColor602 = new Color(64, 64, 64);
        aColor603 = new Color(128, 255, 128);
        aColor604 = new Color(224, 224, 128);
        aColor605 = new Color(144, 208, 144);
        aFont606 = new Font("Dialog", 0, 14);
        aFont607 = new Font("Dialog", 0, 11);
    }
}
