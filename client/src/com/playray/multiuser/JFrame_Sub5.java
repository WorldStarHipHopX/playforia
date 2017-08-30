package com.playray.multiuser;

import com.playray.colorgui.ColorTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class JFrame_Sub5 extends JFrame implements WindowListener {

    private static final String[] aStringArray2264 = new String[4];


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

    protected void method2352(Component var1, ColorTextArea var2) {
        this.setTitle("Sheriff: Copy of chat");
        this.setSize(600, 400);
        this.setResizable(true);
        JTextArea var3 = this.method2353(var2);
        Point var4 = var1.getLocationOnScreen();
        Dimension var5 = var1.getSize();
        this.setLocation(var4.x + var5.width / 2 - 300, var4.y + var5.height / 2 - 200);
        this.setVisible(true);
        this.addWindowListener(this);
        this.toFront();
        var3.requestFocus();
    }

    private JTextArea method2353(ColorTextArea var1) {
        Container var2 = this.getContentPane();
        var2.setLayout(new BorderLayout(5, 5));
        JLabel var3 = new JLabel("Select all text: press <Ctrl> + <A>  ---  Copy selected text to clipboard: press <Ctrl> + <C>", (Icon) null, 0);
        var3.setBackground(Color.lightGray);
        var3.setForeground(Color.black);
        var3.setBorder(BorderFactory.createEmptyBorder(5, 5, 3, 5));
        var2.add(var3, "North");
        JTextArea var4 = new JTextArea(this.method2354(var1));
        var4.setEditable(false);
        var4.setBackground(Color.white);
        var4.setForeground(Color.black);
        JScrollPane var5 = new JScrollPane(var4);
        var5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5), BorderFactory.createLineBorder(Color.black, 1)));
        var2.add(var5, "Center");
        return var4;
    }

    private String method2354(ColorTextArea var1) {
        String[] var2 = var1.getTimeStampedCache();
        int var3 = var2.length;
        StringBuffer var4 = new StringBuffer(var3 * 20);

        for (int var5 = 0; var5 < var3; ++var5) {
            int var6 = var2[var5].length();

            for (int var7 = 0; var7 < var6; ++var7) {
                char var8 = var2[var5].charAt(var7);
                if (var8 == 60) {
                    var8 = 123;
                } else if (var8 == 62) {
                    var8 = 125;
                }

                var4.append(var8);
            }

            var4.append('\n');
        }

        return var4.toString();
    }

    static {
        aStringArray2264[0] = "Sheriff: Copy of chat";
        aStringArray2264[1] = "Center";
        aStringArray2264[2] = "North";
        aStringArray2264[3] = "Select all text: press <Ctrl> + <A>  ---  Copy selected text to clipboard: press <Ctrl> + <C>";
    }
}
