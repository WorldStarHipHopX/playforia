package com.playray.applet;

import com.playray.client.SwingUpdateTarget;
import com.playray.client.SwingUpdateUI;

import javax.swing.JApplet;

public abstract class UIApplet extends JApplet implements SwingUpdateTarget {

    public int anInt2601;
    public int anInt2602;
    public static boolean aBoolean2603;


    public void callUpdateUI(Object var1) {
        SwingUpdateUI.callUpdateUI(this, var1);
    }

    public void updateUI(Object var1) {
    }
}
