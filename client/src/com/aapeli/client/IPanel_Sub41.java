package com.aapeli.client;

import com.aapeli.client.Frame_Sub3_Sub2;
import com.aapeli.client.IPanel;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.StringDraw;
import com.aapeli.client.TextManager;
import com.aapeli.client.UrlLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class IPanel_Sub41 extends IPanel implements MouseListener {

    private static final Color aColor3219;
    private static final Color aColor3220;
    private static final Font aFont3221;
    private static final Font aFont3222;
    private TextManager aTextManager3223;
    private Frame_Sub3_Sub2 aFrame_Sub3_Sub2_3224;
    private static final String[] aStringArray3225 = new String[4];


    protected IPanel_Sub41(Parameters var1, TextManager var2, ImageManager var3, Frame_Sub3_Sub2 var4) {
        this.aTextManager3223 = var2;
        this.aFrame_Sub3_Sub2_3224 = var4;
        this.setSize(310, 160);
        this.setBackground(aColor3219);
        this.setLayout((LayoutManager) null);
        UrlLabel var5 = new UrlLabel(var1.getApplet(), aFont3222, var2.getShared("RegRemind_ClickHere"), var1.getRegisterPage());
        var5.setTarget(0);
        var5.setBounds(20, 110, 270, 30);
        var5.setBackground(aColor3219);
        var5.setForeground(aColor3220);
        var5.addMouseListener(this);
        this.add(var5);
        this.setSharedBackground(var3, "tf-background.gif", 0, 0);
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        var1.setFont(aFont3221);
        var1.setColor(aColor3220);
        StringDraw.drawStringWithMaxWidth(var1, this.aTextManager3223.getShared("RegRemind_GameOver"), 20, 35, -1, 270);
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
    }

    public void mouseReleased(MouseEvent var1) {
        this.aFrame_Sub3_Sub2_3224.close();
    }

    public void mouseClicked(MouseEvent var1) {
    }

    static {
        aStringArray3225[0] = "tf-background.gif";
        aStringArray3225[1] = "RegRemind_ClickHere";
        aStringArray3225[2] = "RegRemind_GameOver";
        aStringArray3225[3] = "Dialog";
        aColor3219 = new Color(240, 240, 240);
        aColor3220 = Color.black;
        aFont3221 = new Font("Dialog", 0, 14);
        aFont3222 = new Font("Dialog", 0, 16);
    }
}
