package com.playray.multiuser;

import com.playray.client.ImageManager;
import com.playray.client.TextManager;
import com.playray.multiuser.QuitHandler;
import com.playray.multiuser.SPanel_Sub47;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class QuitConfirm extends JFrame implements WindowListener {

    private TextManager aTextManager2267;
    private QuitHandler aQuitHandler2268;
    private int anInt2269;
    private int anInt2270;
    private static final String[] aStringArray2271 = new String[2];


    public QuitConfirm(TextManager var1, ImageManager var2, QuitHandler var3) {
        this.aTextManager2267 = var1;
        this.aQuitHandler2268 = var3;
        Image var4 = var2.getShared("icon.png", true);
        if (var4 != null) {
            this.setIconImage(var4);
        }

    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.aQuitHandler2268.userCancel();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    public void open(Component var1) {
        this.setTitle(this.aTextManager2267.getShared("QuitConfirm_Title"));
        this.setVisible(true);
        Point var2 = var1.getLocationOnScreen();
        Dimension var3 = var1.getSize();
        this.setLocation(var2.x + var3.width / 2 - this.anInt2269 / 2, var2.y + var3.height / 2 - this.anInt2270 / 2);
        SPanel_Sub47 var4 = new SPanel_Sub47(this.aTextManager2267, this.aQuitHandler2268);
        this.setContentPane(var4);
        this.pack();
        this.setResizable(false);
        this.addWindowListener(this);
        this.toFront();
        this.requestFocus();
    }

    public void close() {
        this.dispose();
    }

    static {
        aStringArray2271[0] = "icon.png";
        aStringArray2271[1] = "QuitConfirm_Title";
    }
}
