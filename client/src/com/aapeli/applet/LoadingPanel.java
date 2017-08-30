package com.aapeli.applet;

import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.RoundButton;
import com.aapeli.tools.Tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoadingPanel extends Panel implements Runnable, ActionListener {

    private static final Font fontDialog14 = new Font("Dialog", 0, 14);
    private static final Font fontDialog20b = new Font("Dialog", 1, 20);
    private AApplet gameApplet;
    private Parameters aParameters581;
    private TextManager aTextManager582;
    private String loadingMessage;
    private double aDouble584;
    private double aDouble585;
    private double aDouble586;
    private int anInt587;
    private boolean aBoolean588;
    private boolean aBoolean589;
    private boolean aBoolean590;
    private boolean destroyed;
    private Image panelImage;
    private Graphics panelGraphics;
    private AdCanvas adCanvas;
    private boolean aBoolean595;
    private RoundButton aRoundButton596;
    private RoundButton aRoundButton597;
    private int anInt598;


    protected LoadingPanel(AApplet var1) {
        this.gameApplet = var1;
        this.loadingMessage = null;
        this.aDouble584 = this.aDouble585 = 0.0D;
        this.aDouble586 = 0.0018D;
        this.anInt587 = 50;
        this.aBoolean590 = false;
        this.destroyed = false;
        this.aBoolean588 = true;
        this.aBoolean589 = true;
        this.anInt598 = -1;
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public synchronized void update(Graphics var1) {
        if (!this.destroyed) {
            AApplet var2 = this.gameApplet;
            if (var2 != null) {
                int var3 = var2.appletWidth;
                int var4 = var2.appletHeight;
                if (this.panelImage == null) {
                    this.panelImage = this.createImage(var3, var4);
                    this.panelGraphics = this.panelImage.getGraphics();
                    this.aBoolean588 = true;
                }

                Color var5 = this.getBackground();
                if (var5.equals(Color.black)) {
                    var5 = new Color(24, 24, 24);
                }

                boolean var6 = this.aBoolean588;
                this.aBoolean588 = false;
                if (var6) {
                    this.drawGradient(this.panelGraphics, var5, 0, 32, 0, var4, 0, var3, this.aBoolean589);
                    this.aBoolean589 = false;
                    if (this.loadingMessage != null && this.anInt598 == -1) {
                        this.panelGraphics.setColor(this.getForeground());
                        this.drawLoadingMessage(this.panelGraphics, fontDialog14, this.loadingMessage);
                    }

                    if (this.adCanvas != null) {
                        this.adCanvas.repaint();
                    }
                }

                if (this.anInt598 == -1) {
                    this.drawGradient(this.panelGraphics, Color.white, 0, 48, 25, 40, 5, var3 - 5, true);
                    int var7 = (int) ((double) (var3 - 10) * this.aDouble585);
                    if (var7 > 0) {
                        this.drawGradient(this.panelGraphics, Color.green, 144, 144, 25, 40, 5, 5 + var7, true);
                    }

                    this.panelGraphics.setColor(Color.black);
                    this.panelGraphics.drawRect(5, 25, var3 - 10 - 1, 14);
                }

                var1.drawImage(this.panelImage, 0, 0, this);
            }
        }
    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        this.aBoolean588 = true;
        this.repaint();
    }

    public void run() {
        do {
            try {
                Thread.sleep((long) this.anInt587);
            } catch (InterruptedException var3) {
                ;
            }

            if (this.destroyed) {
                return;
            }

            boolean var1 = false;
            if (this.aDouble585 < this.aDouble584) {
                this.aDouble585 += this.method478();
                if (this.aDouble585 > 1.0D) {
                    this.aDouble585 = 1.0D;
                }

                var1 = true;
            }

            if (this.aDouble584 >= 1.0D && this.gameApplet.isDebug()) {
                this.aDouble585 = 1.0D;
                var1 = true;
            }

            if (var1) {
                this.repaint();
            }
        } while (this.aDouble585 < 1.0D);

        this.aBoolean590 = true;
    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aRoundButton596) {
            this.anInt598 = 1;
        } else {
            this.gameApplet.setEndState(AApplet.END_QUIT_BUYCOINS);
            this.aParameters581.showCreditPurchasePage(false);
        }

    }

    protected void method462(Parameters var1, TextManager var2) {
        this.aParameters581 = var1;
        this.aTextManager582 = var2;
    }

    protected void method463() {
        Thread var1 = new Thread(this);
        var1.start();
    }

    protected void setLoadingMessage(String var1) {
        this.loadingMessage = var1;
        this.aBoolean588 = true;
        this.repaint();
    }

    protected void method465(double var1) {
        this.aDouble584 += var1;
    }

    protected void method466(AdCanvas var1, boolean var2) {
        this.setLayout((LayoutManager) null);
        int var3 = this.gameApplet.appletWidth - 5 - 5;
        int var4 = this.gameApplet.appletHeight - 5 - 5 - 40;
        Dimension var5 = var1.getSize();
        var1.setLocation(5 + var3 / 2 - var5.width / 2, 45 + var4 / 2 - var5.height / 2);
        this.add(var1);
        var1.method214(this);
        this.adCanvas = var1;
        this.aBoolean595 = var2;
    }

    protected void method467(double var1) {
        this.aDouble584 = var1;
    }

    protected void method468(double var1) {
        this.aDouble586 *= var1;
    }

    protected Image method469() {
        return this.panelImage;
    }

    protected void method470() {
        this.anInt587 = 25;
    }

    protected boolean method471() {
        return this.aBoolean590;
    }

    protected void method472() {
        if (this.adCanvas != null) {
            if (this.aBoolean595) {
                this.anInt598 = 0;
                this.aBoolean588 = true;
                this.repaint();
                short var1 = 300;
                int var2 = (this.gameApplet.appletWidth - 25 - 15 - 15 - 25) / 2;
                int var3 = Math.min(var1, var2);
                this.aRoundButton596 = new RoundButton(this.aTextManager582.getShared("Loader_Button_StartGame"));
                this.aRoundButton596.setBounds(this.gameApplet.appletWidth / 2 + 15, 10, var3, 35);
                this.aRoundButton596.setBackground(new Color(96, 224, 96));
                this.aRoundButton596.setForeground(Color.black);
                this.aRoundButton596.setFont(fontDialog20b);
                this.aRoundButton596.addActionListener(this);
                this.add(this.aRoundButton596);
                if (this.aParameters581.isCreditPurchasePageAvailable()) {
                    this.aRoundButton597 = new RoundButton(this.aTextManager582.getShared("Loader_Button_MorePaymentOptions"));
                    this.aRoundButton597.setBounds(this.gameApplet.appletWidth / 2 - 15 - var3, 10, var3, 35);
                    this.aRoundButton597.setBackground(new Color(96, 96, 255));
                    this.aRoundButton597.setForeground(Color.black);
                    this.aRoundButton597.setFont(fontDialog20b);
                    this.aRoundButton597.addActionListener(this);
                    this.add(this.aRoundButton597);
                }

                do {
                    Tools.sleep(25L);
                } while (this.anInt598 == 0 && !this.destroyed);

                this.remove(this.aRoundButton596);
            }
        }
    }

    protected synchronized void destroy() {
        this.destroyed = true;
        if (this.adCanvas != null) {
            this.remove(this.adCanvas);
            this.adCanvas.method217();
            this.adCanvas = null;
        }

        this.loadingMessage = null;
        if (this.panelGraphics != null) {
            this.panelGraphics.dispose();
            this.panelGraphics = null;
        }

        if (this.panelImage != null) {
            this.panelImage.flush();
            this.panelImage = null;
        }

        this.gameApplet = null;
    }

    private void drawGradient(Graphics var1, Color color, int top, int bottom, int var5, int var6, int var7, int var8, boolean var9) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        int topRed = red + top;
        int topGreen = green + top;
        int topBlue = blue + top;
        int btmRed = red - bottom;
        int btmGreen = green - bottom;
        int btmBlue = blue - bottom;
        if (topRed > 255) {
            topRed = 255;
        }

        if (topGreen > 255) {
            topGreen = 255;
        }

        if (topBlue > 255) {
            topBlue = 255;
        }

        if (btmRed < 0) {
            btmRed = 0;
        }

        if (btmGreen < 0) {
            btmGreen = 0;
        }

        if (btmBlue < 0) {
            btmBlue = 0;
        }

        if (var9) {
            this.drawGradient(var1, var5, var6, var7, var8, topRed, btmRed, topGreen, btmGreen, topBlue, btmBlue);
        } else {
            this.drawGradient2(var1, var5, var6, var7, var8, topRed, btmRed, topGreen, btmGreen, topBlue, btmBlue);
        }

    }

    private void drawGradient(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
        for (int var17 = var2; var17 < var3; ++var17) {
            double var12 = 1.0D * (double) (var17 - var2) / (double) (var3 - var2);
            int var14 = (int) ((double) var6 + (double) (var7 - var6) * var12);
            int var15 = (int) ((double) var8 + (double) (var9 - var8) * var12);
            int var16 = (int) ((double) var10 + (double) (var11 - var10) * var12);
            var1.setColor(new Color(var14, var15, var16));
            var1.drawLine(var4, var17, var5 - 1, var17);
        }

    }

    private void drawGradient2(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
        int var20 = -1;

        for (int var21 = var2; var21 < var3; ++var21) {
            double var12 = 1.0D * (double) (var21 - var2) / (double) (var3 - var2);

            for (int var22 = var4; var22 < var5; ++var22) {
                double var14;
                if (var22 == var4) {
                    var14 = 0.0D;
                } else {
                    var14 = Math.random() * 1.98D - 0.99D;
                }

                int var16 = (int) ((double) var6 + (double) (var7 - var6) * var12 + var14);
                int var17 = (int) ((double) var8 + (double) (var9 - var8) * var12 + var14);
                int var18 = (int) ((double) var10 + (double) (var11 - var10) * var12 + var14);
                int var19 = var16 * 256 * 256 + var17 * 256 + var18;
                if (var22 == var4) {
                    var20 = var19;
                    var1.setColor(new Color(var19));
                    var1.drawLine(var4, var21, var5, var21);
                } else if (var19 != var20) {
                    var1.setColor(new Color(var19));
                    var1.fillRect(var22, var21, 1, 1);
                }
            }
        }

    }

    private void drawLoadingMessage(Graphics g, Font font, String s) {
        while (this.getFontMetrics(font).stringWidth(s) > this.gameApplet.appletWidth - 12) {
            font = new Font(font.getName(), font.getStyle(), font.getSize() - 1);
        }

        g.setFont(font);
        g.drawString(this.loadingMessage, 6, 19);
    }

    private double method478() {
        if (this.adCanvas == null) {
            return this.aDouble586;
        } else {
            int var1 = this.adCanvas.method215();
            if (var1 <= 0) {
                return this.aDouble586;
            } else {
                double var2 = 1.0D - this.aDouble585;
                double var4 = var2 * (double) this.anInt587 / (double) var1;
                return var4 > this.aDouble586 ? this.aDouble586 : var4;
            }
        }
    }
}
