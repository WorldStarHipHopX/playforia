package com.playray.colorgui;

import com.playray.client.SPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;

public final class KeyboardButton extends SPanel implements MouseListener {

    private static final Color aColor4463 = new Color(168, 168, 168);
    private static final Color aColor4464 = new Color(208, 208, 208);
    private static final Color aColor4465 = new Color(128, 128, 128);
    private static final Color aColor4466 = new Color(0, 0, 0);
    private String aString4467;
    private boolean aBoolean4468;
    private Vector aVector4469;
    private Object anObject4470;
    private static final String aString4471 = "Dialog";


    public KeyboardButton() {
        this((String) null);
    }

    public KeyboardButton(String var1) {
        this.anObject4470 = new Object();
        this.setLabel(var1);
        this.aBoolean4468 = false;
        this.aVector4469 = new Vector();
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean4468 = false;
        this.repaint();
    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        boolean var5 = this.isEnabled();
        this.method2891(var1, var3, var4, var5);
        if (this.aString4467 != null) {
            var1.setColor(this.method2892(aColor4466, var5));
            int var6 = Math.max(var4 - 8, 9);
            Font var7 = new Font("Dialog", 0, var6);
            var1.setFont(var7);
            var1.drawString(this.aString4467, var3 / 2 - this.getFontMetrics(var7).stringWidth(this.aString4467) / 2, var4 / 2 + var6 * 3 / 8 + 1);
        }

    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean4468 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean4468;
        this.aBoolean4468 = false;
        this.repaint();
        if (var2) {
            this.method2890();
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void setLabel(String var1) {
        this.aString4467 = var1;
        this.repaint();
    }

    public String getLabel() {
        return this.aString4467;
    }

    public void addActionListener(ActionListener var1) {
        Object var2 = this.anObject4470;
        synchronized (this.anObject4470) {
            this.aVector4469.addElement(var1);
        }
    }

    public void removeActionListener(ActionListener var1) {
        Object var2 = this.anObject4470;
        synchronized (this.anObject4470) {
            this.aVector4469.removeElement(var1);
        }
    }

    public void setEnabled(boolean var1) {
        super.setEnabled(var1);
        this.repaint();
    }

    protected void method2890() {
        Object var1 = this.anObject4470;
        synchronized (this.anObject4470) {
            if (this.aVector4469.size() != 0) {
                ActionEvent var2 = new ActionEvent(this, 1001, this.aString4467);
                Enumeration var3 = this.aVector4469.elements();

                while (var3.hasMoreElements()) {
                    ((ActionListener) ((ActionListener) var3.nextElement())).actionPerformed(var2);
                }

            }
        }
    }

    private void method2891(Graphics var1, int var2, int var3, boolean var4) {
        var1.setColor(this.method2892(aColor4463, var4));
        var1.fillRect(1, 1, var2 - 2, var3 - 2);
        var1.setColor(this.method2892(!this.aBoolean4468 ? aColor4464 : aColor4465, var4));
        var1.drawLine(1, 0, var2 - 2, 0);
        var1.drawLine(0, 1, var2 - 2, 1);
        var1.drawLine(0, 1, 0, var3 - 2);
        var1.drawLine(1, 0, 1, var3 - 3);
        var1.fillRect(2, 2, 1, 1);
        var1.fillRect(var2 - 3, 2, 1, 1);
        var1.setColor(this.method2892(!this.aBoolean4468 ? aColor4465 : aColor4464, var4));
        var1.drawLine(1, var3 - 1, var2 - 2, var3 - 1);
        var1.drawLine(1, var3 - 2, var2 - 1, var3 - 2);
        var1.drawLine(var2 - 1, 1, var2 - 1, var3 - 2);
        var1.drawLine(var2 - 2, 2, var2 - 2, var3 - 1);
        var1.fillRect(2, var3 - 3, 1, 1);
        var1.fillRect(var2 - 3, var3 - 3, 1, 1);
    }

    private Color method2892(Color var1, boolean var2) {
        if (var2) {
            return var1;
        } else {
            int var3 = var1.getRed();
            int var4 = var1.getGreen();
            int var5 = var1.getBlue();
            int var6 = aColor4463.getRed();
            int var7 = aColor4463.getGreen();
            int var8 = aColor4463.getBlue();
            int var9 = (var3 + var6) / 2;
            int var10 = (var4 + var7) / 2;
            int var11 = (var5 + var8) / 2;
            return new Color(var9, var10, var11);
        }
    }

}
