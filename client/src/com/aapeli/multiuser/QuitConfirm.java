package com.aapeli.multiuser;

import com.aapeli.client.StringDraw;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;
import com.aapeli.colorgui.RoundButton;
import com.aapeli.multiuser.QuitHandler;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class QuitConfirm extends Frame implements WindowListener, ActionListener {

    private static final Font aFont216;
    private static final Color aColor217;
    private static final Color aColor218;
    private static final Color aColor219;
    private TextManager aTextManager220;
    private QuitHandler aQuitHandler221;
    private Insets anInsets222;
    private int anInt223;
    private int anInt224;
    private Component aComponent225;
    private Component aComponent226;
    private static final String[] aStringArray227 = new String[5];


    public QuitConfirm(TextManager var1, QuitHandler var2) {
        this.aTextManager220 = var1;
        this.aQuitHandler221 = var2;
        this.anInt223 = 250;
        this.anInt224 = 125;
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        double var2 = 64.0D / (double) this.anInt224;
        double var4 = var2 * (double) this.anInt224 * 0.5D;

        for (int var6 = 0; var6 < this.anInt224; ++var6) {
            var1.setColor(this.method258(216.0D + var4 - var2 * (double) var6, 208.0D + var4 - var2 * (double) var6, 208.0D + var4 - var2 * (double) var6));
            var1.drawLine(0, var6, this.anInt223, var6);
        }

        if (this.anInsets222 != null) {
            var1.setFont(aFont216);
            var1.setColor(aColor217);
            StringDraw.drawStringWithMaxWidth(var1, this.aTextManager220.getShared("QuitConfirm_Text"), this.anInsets222.left + 10, this.anInsets222.top + 30, -1, 230);
        }

    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.aQuitHandler221.userCancel();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aComponent225) {
            this.aQuitHandler221.userQuit();
        } else {
            this.aQuitHandler221.userCancel();
        }

    }

    public void open(Component var1) {
        this.open(var1, false);
    }

    public void open(Component var1, boolean var2) {
        this.setTitle(this.aTextManager220.getShared("QuitConfirm_Title"));
        this.setVisible(true);
        this.anInsets222 = this.getInsets();
        this.anInt223 = this.anInsets222.left + 250 + this.anInsets222.right;
        this.anInt224 = this.anInsets222.top + 125 + this.anInsets222.bottom;
        this.setSize(this.anInt223, this.anInt224);
        this.setResizable(false);
        Point var3 = var1.getLocationOnScreen();
        Dimension var4 = var1.getSize();
        this.setLocation(var3.x + var4.width / 2 - this.anInt223 / 2, var3.y + var4.height / 2 - this.anInt224 / 2);
        this.setBackground(aColor219);
        this.setLayout((LayoutManager) null);
        if (var2) {
            RoundButton var5 = new RoundButton(this.aTextManager220.getShared("QuitConfirm_ButtonYes"));
            RoundButton var6 = new RoundButton(this.aTextManager220.getShared("QuitConfirm_ButtonNo"));
            var5.addActionListener(this);
            var6.addActionListener(this);
            this.aComponent225 = var5;
            this.aComponent226 = var6;
        } else {
            ColorButton var7 = new ColorButton(this.aTextManager220.getShared("QuitConfirm_ButtonYes"));
            ColorButton var8 = new ColorButton(this.aTextManager220.getShared("QuitConfirm_ButtonNo"));
            var7.addActionListener(this);
            var8.addActionListener(this);
            this.aComponent225 = var7;
            this.aComponent226 = var8;
        }

        this.aComponent225.setBounds(this.anInsets222.left + 10, this.anInsets222.top + 125 - 10 - 25, 100, 25);
        this.aComponent225.setBackground(aColor218);
        this.aComponent226.setBounds(this.anInsets222.left + 250 - 10 - 100, this.anInsets222.top + 125 - 10 - 25, 100, 25);
        this.aComponent226.setBackground(aColor218);
        this.add(this.aComponent225);
        this.add(this.aComponent226);
        this.addWindowListener(this);
        this.toFront();
        this.requestFocus();
    }

    public void close() {
        this.dispose();
    }

    private Color method258(double var1, double var3, double var5) {
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
        aStringArray227[0] = "QuitConfirm_Text";
        aStringArray227[1] = "QuitConfirm_Title";
        aStringArray227[2] = "QuitConfirm_ButtonYes";
        aStringArray227[3] = "QuitConfirm_ButtonNo";
        aStringArray227[4] = "Dialog";
        aFont216 = new Font("Dialog", 0, 14);
        aColor217 = new Color(64, 0, 0);
        aColor218 = new Color(208, 208, 16);
        aColor219 = new Color(12827579);
    }
}
