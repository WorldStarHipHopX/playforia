package com.aapeli.colorgui;

import com.aapeli.client.IPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;

public final class KeyboardButton extends IPanel implements MouseListener {

    private static final Color aColor3354 = new Color(168, 168, 168);
    private static final Color aColor3355 = new Color(208, 208, 208);
    private static final Color aColor3356 = new Color(128, 128, 128);
    private static final Color aColor3357 = new Color(0, 0, 0);
    private String aString3358;
    private boolean aBoolean3359;
    private Vector aVector3360;
    private Image anImage3361;
    private Graphics aGraphics3362;
    private int anInt3363;
    private int anInt3364;
    private static final String aString3365 = "Dialog";


    public KeyboardButton() {
        this((String) null);
    }

    public KeyboardButton(String var1) {
        this.setLabel(var1);
        this.aBoolean3359 = false;
        this.aVector3360 = new Vector();
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean3359 = false;
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (this.anImage3361 == null || this.aGraphics3362 == null || var3 != this.anInt3363 || var4 != this.anInt3364) {
            this.anImage3361 = this.createImage(var3, var4);
            this.aGraphics3362 = this.anImage3361.getGraphics();
            this.anInt3363 = var3;
            this.anInt3364 = var4;
        }

        boolean var5 = this.isEnabled();
        this.drawBackground(this.aGraphics3362);
        this.method864(this.aGraphics3362, var3, var4, var5);
        if (this.aString3358 != null) {
            this.aGraphics3362.setColor(this.method865(aColor3357, var5));
            int var6 = Math.max(var4 - 8, 9);
            Font var7 = new Font("Dialog", 0, var6);
            this.aGraphics3362.setFont(var7);
            this.aGraphics3362.drawString(this.aString3358, var3 / 2 - this.getFontMetrics(var7).stringWidth(this.aString3358) / 2, var4 / 2 + var6 * 3 / 8 + 1);
        }

        var1.drawImage(this.anImage3361, 0, 0, this);
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean3359 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean3359;
        this.aBoolean3359 = false;
        this.repaint();
        if (var2) {
            this.method863();
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void setLabel(String var1) {
        this.aString3358 = var1;
        this.repaint();
    }

    public String getLabel() {
        return this.aString3358;
    }

    public void addActionListener(ActionListener var1) {
        Vector var2 = this.aVector3360;
        synchronized (this.aVector3360) {
            this.aVector3360.addElement(var1);
        }
    }

    public void removeActionListener(ActionListener var1) {
        Vector var2 = this.aVector3360;
        synchronized (this.aVector3360) {
            this.aVector3360.removeElement(var1);
        }
    }

    public void setEnabled(boolean var1) {
        super.setEnabled(var1);
        this.repaint();
    }

    protected void method863() {
        Vector var1 = this.aVector3360;
        synchronized (this.aVector3360) {
            if (this.aVector3360.size() != 0) {
                ActionEvent var2 = new ActionEvent(this, 1001, this.aString3358);
                Enumeration var3 = this.aVector3360.elements();

                while (var3.hasMoreElements()) {
                    ((ActionListener) ((ActionListener) var3.nextElement())).actionPerformed(var2);
                }

            }
        }
    }

    private void method864(Graphics var1, int var2, int var3, boolean var4) {
        var1.setColor(this.method865(aColor3354, var4));
        var1.fillRect(1, 1, var2 - 2, var3 - 2);
        var1.setColor(this.method865(!this.aBoolean3359 ? aColor3355 : aColor3356, var4));
        var1.drawLine(1, 0, var2 - 2, 0);
        var1.drawLine(0, 1, var2 - 2, 1);
        var1.drawLine(0, 1, 0, var3 - 2);
        var1.drawLine(1, 0, 1, var3 - 3);
        var1.fillRect(2, 2, 1, 1);
        var1.fillRect(var2 - 3, 2, 1, 1);
        var1.setColor(this.method865(!this.aBoolean3359 ? aColor3356 : aColor3355, var4));
        var1.drawLine(1, var3 - 1, var2 - 2, var3 - 1);
        var1.drawLine(1, var3 - 2, var2 - 1, var3 - 2);
        var1.drawLine(var2 - 1, 1, var2 - 1, var3 - 2);
        var1.drawLine(var2 - 2, 2, var2 - 2, var3 - 1);
        var1.fillRect(2, var3 - 3, 1, 1);
        var1.fillRect(var2 - 3, var3 - 3, 1, 1);
    }

    private Color method865(Color var1, boolean var2) {
        if (var2) {
            return var1;
        } else {
            int var3 = var1.getRed();
            int var4 = var1.getGreen();
            int var5 = var1.getBlue();
            int var6 = aColor3354.getRed();
            int var7 = aColor3354.getGreen();
            int var8 = aColor3354.getBlue();
            int var9 = (var3 + var6) / 2;
            int var10 = (var4 + var7) / 2;
            int var11 = (var5 + var8) / 2;
            return new Color(var9, var10, var11);
        }
    }

}
