package com.aapeli.multiuser;

import com.aapeli.colorgui.ColorTextArea;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class CopyChatFrame extends Frame implements ComponentListener, WindowListener {

    private TextArea textArea;


    public void componentHidden(ComponentEvent var1) {
    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Dimension d = this.getSize();
        Insets i = this.getInsets();
        this.textArea.setBounds(i.left, i.top, d.width - i.left - i.right, d.height - i.top - i.bottom);
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

    protected void create(Component parent, ColorTextArea colorTextArea) {
        this.setTitle("Sheriff: Copy of chat");
        this.setSize(420, 190);
        this.setResizable(true);
        Point var3 = parent.getLocationOnScreen();
        Dimension dimensions = parent.getSize();
        this.setLocation(var3.x + dimensions.width / 2 - 210, var3.y + dimensions.height / 2 - 95);
        this.setVisible(true);
        Insets insets = this.getInsets();
        this.setLayout(null);
        this.textArea = new TextArea(this.getChatText(colorTextArea));
        this.textArea.setBounds(insets.left, insets.top, 420, 190);
        this.textArea.setEditable(false);
        this.textArea.setBackground(Color.white);
        this.textArea.setForeground(Color.black);
        this.add(this.textArea);
        this.addWindowListener(this);
        this.addComponentListener(this);
        this.toFront();
        this.requestFocus();
    }

    private String getChatText(ColorTextArea colorTextArea) {
        String[] lines = colorTextArea.getTimeStampedCache();
        int linesCount = lines.length;
        StringBuffer sb = new StringBuffer(linesCount * 20);

        for (int i = 0; i < linesCount; ++i) {
            int lineLength = lines[i].length();

            for (int j = 0; j < lineLength; ++j) {
                char chr = lines[i].charAt(j);
                if (chr == '<') {
                    chr = '{';
                } else if (chr == '>') {
                    chr = '}';
                }

                sb.append(chr);
            }

            sb.append('\n');
        }

        return sb.toString();
    }

}
