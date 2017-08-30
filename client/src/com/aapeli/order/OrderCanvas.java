package com.aapeli.order;

import com.aapeli.client.HtmlText;
import com.aapeli.client.ImageManager;
import com.aapeli.client.StringDraw;
import com.aapeli.client.TextManager;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

class OrderCanvas extends Canvas {

    protected static final Color aColor170 = new Color(255, 231, 212);
    private static final Font fontDialog18b = new Font("Dialog", Font.BOLD, 18);
    private static final Font fontDialog14 = new Font("Dialog", Font.PLAIN, 14);
    private static final Font fontDialog13 = new Font("Dialog", Font.PLAIN, 13);
    private static final Color aColor174 = Color.black;
    private static final Color aColor175 = Color.gray;
    private TextManager textManager;
    private int anInt177;
    private String aString178;
    private long aLong179;
    private HtmlText htmlText;
    private Image image;
    private Graphics graphics;


    protected OrderCanvas(TextManager var1, ImageManager var2) {
        this.textManager = var1;
        this.setBackground(aColor170);
        this.setSize(500, 280);
        this.anInt177 = 0;
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.image == null) {
            this.image = this.createImage(500, 280);
            this.graphics = this.image.getGraphics();
        }

        this.graphics.setColor(aColor170);
        this.graphics.fillRect(0, 0, 500, 280);
        this.graphics.setColor(aColor174);
        if (this.anInt177 == 1) {
            int var2 = this.method233(this.graphics, 20, 45, 460, this.aString178);
            this.graphics.setColor(aColor175);
            this.graphics.setFont(fontDialog13);
            StringDraw.drawStringWithMaxWidth(this.graphics, this.textManager.getShared("OrderFrame_AfterOrderInstructions"), 20, var2 + 20, -1, 460);
            int var3 = (int) ((this.aLong179 - System.currentTimeMillis() + 500L) / 1000L);
            if (var3 >= 0 && var3 <= 120) {
                StringDraw.drawStringWithMaxWidth(this.graphics, this.textManager.getShared("OrderFrame_TimeOutNote", this.textManager.getTime((long) var3)), 20, var2 + 20 + 50, -1, 460);
            }
        } else {
            String var4 = null;
            String var5 = null;
            if (this.anInt177 == 0) {
                var4 = this.textManager.getShared("OrderFrame_Wait");
            } else if (this.anInt177 == 2) {
                var4 = this.textManager.getShared("OrderFrame_Bought");
            } else if (this.anInt177 == 3) {
                var4 = this.textManager.getShared("OrderFrame_TimeOut");
                var5 = this.textManager.getShared("OrderFrame_TimeOut_Info");
            } else if (this.anInt177 == 4) {
                var4 = this.textManager.getShared("OrderFrame_Error");
                var5 = this.textManager.getShared("OrderFrame_Error_Info");
            }

            if (var4 != null) {
                this.graphics.setFont(fontDialog18b);
                StringDraw.drawStringWithMaxWidth(this.graphics, var4, 250, 110, 0, 460);
                if (var5 != null) {
                    this.graphics.setFont(fontDialog13);
                    StringDraw.drawStringWithMaxWidth(this.graphics, var5, 250, 140, 0, 460);
                }
            }
        }

        var1.drawImage(this.image, 0, 0, this);
    }

    protected void method229(String var1) {
        this.aString178 = var1;
        this.aLong179 = System.currentTimeMillis() + 900000L;
        this.anInt177 = 1;
        this.repaint();
    }

    protected void method230() {
        this.anInt177 = 2;
        this.repaint();
    }

    protected void method231() {
        this.anInt177 = 4;
        this.repaint();
    }

    protected boolean method232() {
        if (this.anInt177 != 1) {
            return true;
        } else {
            if (System.currentTimeMillis() >= this.aLong179) {
                this.anInt177 = 3;
            }

            this.repaint();
            return this.anInt177 == 3;
        }
    }

    private int method233(Graphics var1, int var2, int var3, int var4, String var5) {
        if (this.htmlText == null) {
            var1.setFont(fontDialog14);
            this.htmlText = new HtmlText(var1, var4, var5);
        }

        return this.htmlText.print(var1, var2, var3);
    }
}
