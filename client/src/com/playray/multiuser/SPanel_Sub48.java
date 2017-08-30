package com.playray.multiuser;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.multiuser.UserList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

final class SPanel_Sub48 extends SPanel implements MouseMotionListener, MouseListener {

    private static final Font aFont4617 = new Font("Dialog", 0, 10);
    private UserList anUserList4618;
    private String aString4619;
    private boolean aBoolean4620;
    private boolean aBoolean4621;
    private boolean aBoolean4622;
    private int anInt4623;
    private static final String aString4624 = "Dialog";


    protected SPanel_Sub48(UserList var1, String var2) {
        this.anUserList4618 = var1;
        this.aString4619 = var2;
        this.aBoolean4620 = this.aBoolean4621 = this.aBoolean4622 = false;
        this.anInt4623 = 255;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean4620 = this.aBoolean4621 = false;
        this.repaint();
    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (this.aBoolean4622) {
            var1.setColor(new Color(208, 208, 255, (this.aBoolean4620 ? 255 : 224) * this.anInt4623 / 255));
        } else {
            var1.setColor(new Color(224, 224, 255, (this.aBoolean4620 ? 224 : 160) * this.anInt4623 / 255));
        }

        var1.fillRoundRect(0, 1, var3, var4 + 8, 6, 6);
        var1.setColor(new Color(255, 255, 255, this.anInt4623));
        var1.drawRoundRect(0, 1, var3 - (var3 > 25 ? 1 : 0), var4 + 8 - 1, 6, 6);
        var1.setFont(aFont4617);
        var1.setColor(Color.black);
        StringDraw.drawString(var1, this.aString4619, var3 / 2, var4 / 2 + 3 + 1, 0);
    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean4620 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean4620 = this.aBoolean4621 = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean4621 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean4621;
        this.aBoolean4621 = false;
        this.repaint();
        if (var2) {
            this.anUserList4618.ulbClicked(this);
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
    }

    protected void method2983(boolean var1) {
        this.aBoolean4622 = var1;
        this.repaint();
    }

    protected void method2984(int var1) {
        this.anInt4623 = var1;
        this.repaint();
    }

}
