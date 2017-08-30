package com.playray.order;

import com.playray.client.HtmlText;
import com.playray.client.ImageManager;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.client.TextManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

class SPanel_Sub49 extends SPanel {

    protected static final Color aColor4669 = new Color(255, 231, 212);
    private static final Font aFont4670 = new Font("Dialog", 1, 18);
    private static final Font aFont4671 = new Font("Dialog", 0, 14);
    private static final Font aFont4672 = new Font("Dialog", 0, 13);
    private static final Color aColor4673 = Color.black;
    private static final Color aColor4674 = Color.gray;
    private TextManager aTextManager4675;
    private int state;
    private String aString4677;
    private long aLong4678;
    private HtmlText aHtmlText4679;


    protected SPanel_Sub49(TextManager var1, ImageManager var2) {
        this.aTextManager4675 = var1;
        this.setBackground(aColor4669);
        this.setSize(500, 280);
        this.state = 0;
    }

    public void paintContent(Graphics2D var1) {
        var1.setColor(aColor4673);
        if (this.state == 1) {
            int var2 = this.method3003(var1, 20, 45, 460, this.aString4677);
            var1.setColor(aColor4674);
            var1.setFont(aFont4672);
            StringDraw.drawStringWithMaxWidth(var1, this.aTextManager4675.getShared("OrderFrame_AfterOrderInstructions"), 20, var2 + 20, -1, 460);
            int var3 = (int) ((this.aLong4678 - System.currentTimeMillis() + 500L) / 1000L);
            if (var3 >= 0 && var3 <= 120) {
                StringDraw.drawStringWithMaxWidth(var1, this.aTextManager4675.getShared("OrderFrame_TimeOutNote", this.aTextManager4675.getTime((long) var3)), 20, var2 + 20 + 50, -1, 460);
            }
        } else {
            String title = null;
            String text = null;
            if (this.state == 0) {
                title = this.aTextManager4675.getShared("OrderFrame_Wait");
            } else if (this.state == 2) {
                title = this.aTextManager4675.getShared("OrderFrame_Bought");
            } else if (this.state == 3) {
                title = this.aTextManager4675.getShared("OrderFrame_TimeOut");
                text = this.aTextManager4675.getShared("OrderFrame_TimeOut_Info");
            } else if (this.state == 4) {
                title = this.aTextManager4675.getShared("OrderFrame_Error");
                text = this.aTextManager4675.getShared("OrderFrame_Error_Info");
            }

            if (title != null) {
                var1.setFont(aFont4670);
                StringDraw.drawStringWithMaxWidth(var1, title, 250, 110, 0, 460);
                if (text != null) {
                    var1.setFont(aFont4672);
                    StringDraw.drawStringWithMaxWidth(var1, text, 250, 140, 0, 460);
                }
            }
        }

    }

    protected void method2999(String var1) {
        this.aString4677 = var1;
        this.aLong4678 = System.currentTimeMillis() + 900000L;
        this.state = 1;
        this.repaint();
    }

    protected void method3000() {
        this.state = 2;
        this.repaint();
    }

    protected void method3001() {
        this.state = 4;
        this.repaint();
    }

    protected boolean method3002() {
        if (this.state != 1) {
            return true;
        } else {
            if (System.currentTimeMillis() >= this.aLong4678) {
                this.state = 3;
            }

            this.repaint();
            return this.state == 3;
        }
    }

    private int method3003(Graphics var1, int var2, int var3, int var4, String var5) {
        if (this.aHtmlText4679 == null) {
            var1.setFont(aFont4671);
            this.aHtmlText4679 = new HtmlText(var1, var4, var5);
        }

        return this.aHtmlText4679.print(var1, var2, var3);
    }
}
