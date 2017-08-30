package com.playray.multiuser;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.client.TextManager;
import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.QuitHandler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SPanel_Sub47 extends SPanel implements ActionListener {

    private static final Font aFont4609;
    private static final Color aColor4610;
    private TextManager aTextManager4611;
    private QuitHandler aQuitHandler4612;
    private GlossyButton aGlossyButton4613;
    private GlossyButton aGlossyButton4614;
    private boolean aBoolean4615;
    private static final String[] aStringArray4616 = new String[4];


    protected SPanel_Sub47(TextManager var1, QuitHandler var2) {
        this.aTextManager4611 = var1;
        this.aQuitHandler4612 = var2;
        this.setSize(250, 125);
        this.method2981();
        this.aBoolean4615 = false;
    }

    public Dimension getPreferredSize() {
        return new Dimension(250, 125);
    }

    public Dimension getMinimumSize() {
        return this.getPreferredSize();
    }

    public void paintContent(Graphics2D var1) {
        double var2 = 0.512D;
        double var4 = var2 * 125.0D * 0.5D;

        for (int var6 = 0; var6 < 125; ++var6) {
            var1.setColor(this.method2982(216.0D + var4 - var2 * (double) var6, 208.0D + var4 - var2 * (double) var6, 208.0D + var4 - var2 * (double) var6));
            var1.drawLine(0, var6, 250, var6);
        }

        if (!this.aBoolean4615) {
            this.setBackground(this.getBufferImage());
            this.aBoolean4615 = true;
        }

        var1.setFont(aFont4609);
        var1.setColor(aColor4610);
        StringDraw.drawStringWithMaxWidth(var1, this.aTextManager4611.getShared("QuitConfirm_Text"), 10, 30, -1, 230);
    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aGlossyButton4613) {
            this.aQuitHandler4612.userQuit();
        } else {
            this.aQuitHandler4612.userCancel();
        }

    }

    private void method2981() {
        this.aGlossyButton4613 = new GlossyButton(this.aTextManager4611.getShared("QuitConfirm_ButtonYes"), 4);
        this.aGlossyButton4613.setBounds(10, 90, 100, 25);
        this.aGlossyButton4613.addActionListener(this);
        this.add(this.aGlossyButton4613);
        this.aGlossyButton4614 = new GlossyButton(this.aTextManager4611.getShared("QuitConfirm_ButtonNo"), 4);
        this.aGlossyButton4614.setBounds(140, 90, 100, 25);
        this.aGlossyButton4614.addActionListener(this);
        this.add(this.aGlossyButton4614);
    }

    private Color method2982(double var1, double var3, double var5) {
        int var7 = (int) (var1 + 0.5D);
        int var8 = (int) (var3 + 0.5D);
        int var9 = (int) (var5 + 0.5D);
        if (var7 < 0) {
            var7 = 0;
        }

        if (var7 > 255) {
            var7 = 255;
        }

        if (var8 < 0) {
            var8 = 0;
        }

        if (var8 > 255) {
            var8 = 255;
        }

        if (var9 < 0) {
            var9 = 0;
        }

        if (var9 > 255) {
            var9 = 255;
        }

        return new Color(var7, var8, var9);
    }

    static {
        aStringArray4616[0] = "QuitConfirm_Text";
        aStringArray4616[1] = "QuitConfirm_ButtonYes";
        aStringArray4616[2] = "QuitConfirm_ButtonNo";
        aStringArray4616[3] = "Dialog";
        aFont4609 = new Font("Dialog", 0, 14);
        aColor4610 = new Color(64, 0, 0);
    }
}
