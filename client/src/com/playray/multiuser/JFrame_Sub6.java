package com.playray.multiuser;

import com.playray.client.TextManager;
import com.playray.multiuser.SPanel_Sub45;
import com.playray.multiuser.UserListHandler;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

class JFrame_Sub6 extends JFrame implements WindowListener {

    private SPanel_Sub45 aSPanel_Sub45_2265;
    private static final String[] aStringArray2266 = new String[5];


    protected JFrame_Sub6(TextManager var1, UserListHandler var2, int var3, String var4) {
        this.aSPanel_Sub45_2265 = new SPanel_Sub45(var1, var2, var3, var4, this);
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.dispose();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    protected void method2355(Component var1, boolean var2) {
        String var3 = null;
        int var4 = this.aSPanel_Sub45_2265.method2942();
        if (var4 == 1) {
            var3 = "Admin: Remove user";
        } else if (var4 == 2) {
            var3 = "Sheriff: Send message to user";
        } else if (var4 == 3) {
            var3 = "Sheriff: Mute user";
        } else if (var4 == 4) {
            var3 = "Sheriff: Clear chat of every user";
        } else if (var4 == 5) {
            var3 = "Admin: Broadcast message to all users";
        }

        this.setTitle(var3);
        this.aSPanel_Sub45_2265.method2941(var2);
        this.setContentPane(this.aSPanel_Sub45_2265);
        this.pack();
        this.setResizable(false);
        Point var5 = var1.getLocationOnScreen();
        Dimension var6 = var1.getSize();
        Dimension var7 = this.aSPanel_Sub45_2265.getSize();
        this.setLocation(var5.x + var6.width / 2 - var7.width / 2, var5.y + var6.height / 2 - var7.height / 2);
        this.setVisible(true);
        this.addWindowListener(this);
        this.toFront();
        this.requestFocus();
        this.repaint();
    }

    static {
        aStringArray2266[0] = "Admin: Remove user";
        aStringArray2266[1] = "Admin: Broadcast message to all users";
        aStringArray2266[2] = "Sheriff: Mute user";
        aStringArray2266[3] = "Sheriff: Clear chat of every user";
        aStringArray2266[4] = "Sheriff: Send message to user";
    }
}
