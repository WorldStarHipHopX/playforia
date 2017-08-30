package com.playray.credit;

import com.playray.applet.AApplet;
import com.playray.client.ImageManager;
import com.playray.client.Parameters;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.client.TextManager;
import com.playray.credit.Class140;
import com.playray.credit.Product;
import com.playray.credit.PurchaseFrame;
import com.playray.credit.SPanel_Sub44;
import com.playray.tools.DelayRepaint;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class SPanel_Sub43 extends SPanel implements ItemListener, ActionListener {

    protected static final Color aColor4548;
    private static final String aString4549 = "Product__";
    private static final Color aColor4550;
    private static final Color aColor4551;
    private static final Color aColor4552;
    private static final Font aFont4553;
    private static final Font aFont4554;
    private static final Font aFont4555;
    private PurchaseFrame aPurchaseFrame4556;
    private Parameters aParameters4557;
    private TextManager aTextManager4558;
    private ImageManager anImageManager4559;
    private Product aProduct4560;
    private String aString4561;
    private String aString4562;
    private String aString4563;
    private SPanel_Sub44 aSPanel_Sub44_4564;
    private SPanel_Sub44 aSPanel_Sub44_4565;
    private SPanel_Sub44 aSPanel_Sub44_4566;
    private SPanel_Sub44 aSPanel_Sub44_4567;
    private int anInt4568;
    private int anInt4569;
    private int anInt4570;
    private static final String[] aStringArray4571 = new String[17];


    protected SPanel_Sub43(PurchaseFrame var1, Parameters var2, TextManager var3, ImageManager var4, Product var5, String var6, String var7) {
        this.aPurchaseFrame4556 = var1;
        this.aParameters4557 = var2;
        this.aTextManager4558 = var3;
        this.anImageManager4559 = var4;
        this.aProduct4560 = var5;
        if (var5 != null) {
            String var8 = var5.getProductName();
            String var9 = aString4549 + var8;
            if (var3.isAvailable(var9)) {
                int var10 = var5.getProductPrice();
                int var11 = var5.getProductDuration();
                this.aString4561 = var3.getWithQuantity(var9, new String[]{"" + var10, "" + var11}, var10);
            } else {
                this.aString4561 = var3.getShared("PurchaseFrame_NoProductDescription", var8);
            }
        } else {
            this.aString4561 = null;
        }

        this.aString4562 = var6;
        this.aString4563 = var7;
        this.setBackground(aColor4548);
        this.setSharedBackground(var4, "credit-background.jpg", 0, 0);
        this.setSize(500, 280);
        this.anInt4570 = 0;
        this.anInt4568 = 0;
    }

    public void paintContent(Graphics2D var1) {
        String var2;
        if (this.anInt4568 == 2 || this.anInt4568 == 6 || this.anInt4568 == 3) {
            var1.setFont(aFont4555);
            var1.setColor(aColor4552);
            var2 = null;
            if (this.anInt4568 == 2) {
                var2 = "OpeningCreditPurchase";
            } else if (this.anInt4568 == 6) {
                var2 = "RefreshingCredits";
            } else if (this.anInt4568 == 3) {
                var2 = "ProductPurchase";
            }

            if (var2 != null) {
                StringDraw.drawStringWithMaxWidth(var1, this.aTextManager4558.getShared("PurchaseFrame_Action" + var2), 250, 140, 0, 460);
            }
        }

        if (this.anInt4568 == 4) {
            var1.setFont(aFont4555);
            var1.setColor(aColor4552);
            var2 = null;
            if (this.anInt4569 == 1) {
                var2 = "Ok";
            } else if (this.anInt4569 == 0) {
                var2 = "NoBalance";
            } else if (this.anInt4569 == -1) {
                var2 = "Failed";
            }

            if (var2 != null) {
                StringDraw.drawStringWithMaxWidth(var1, this.aTextManager4558.getShared("PurchaseFrame_Purchase" + var2), 250, 140, 0, 460);
            }
        }

        boolean var6 = false;
        if (this.anInt4568 == 1) {
            Image var3 = this.anImageManager4559.getShared("credit-coins-bg.png", true);
            if (var3 != null) {
                var1.drawImage(var3, 7, 3, this);
            } else {
                var6 = true;
            }

            var1.setColor(aColor4550);
            var1.setFont(aFont4553);
            StringDraw.drawOutlinedString(var1, aColor4551, this.aTextManager4558.getShared("PurchaseFrame_Credits"), 77, 36, -1);
            int var4 = this.aPurchaseFrame4556.method2346();
            var1.setFont(aFont4554);
            StringDraw.drawOutlinedString(var1, aColor4551, this.aTextManager4558.getNumber((long) var4), 480, 38, 1);
        }

        String var5 = null;
        if (this.anInt4568 == 1) {
            var5 = this.aString4561;
        } else if (this.anInt4568 == 5) {
            var5 = this.aTextManager4558.getShared("PurchaseFrame_RefreshAfterGet");
        } else if (this.anInt4568 == -1) {
            var5 = this.aTextManager4558.getShared("PurchaseFrame_Error_Message");
        }

        if (var5 != null) {
            var1.setFont(aFont4555);
            var1.setColor(aColor4552);
            StringDraw.drawStringWithMaxWidth(var1, var5, 20, 85, -1, 460);
        }

        if (var6) {
            new DelayRepaint(this);
        }

    }

    public Dimension getPreferredSize() {
        return this.getMinimumSize();
    }

    public Dimension getMinimumSize() {
        return new Dimension(500, 280);
    }

    public void itemStateChanged(ItemEvent var1) {
        this.method2931();
    }

    public void actionPerformed(ActionEvent var1) {
        byte var2 = 0;
        Object var3 = var1.getSource();
        if (var3 == this.aSPanel_Sub44_4564) {
            var2 = 1;
        } else if (var3 == this.aSPanel_Sub44_4565) {
            var2 = 2;
        } else if (var3 == this.aSPanel_Sub44_4566) {
            var2 = 3;
        } else if (var3 == this.aSPanel_Sub44_4567) {
            var2 = 4;
        }

        if (var2 > 0) {
            new Class140(this, this.aPurchaseFrame4556, this, var2);
        }

    }

    protected void method2927(boolean var1, boolean var2) {
        this.aSPanel_Sub44_4564 = new SPanel_Sub44(this.anImageManager4559, this, 1, this.aTextManager4558.getShared("PurchaseFrame_ButtonGetCredits"), var1, var2);
        this.aSPanel_Sub44_4564.setLocation(493 - this.aSPanel_Sub44_4564.method2935(), 270 - this.aSPanel_Sub44_4564.method2936());
        this.aSPanel_Sub44_4565 = new SPanel_Sub44(this.anImageManager4559, this, 2, this.aTextManager4558.getShared("PurchaseFrame_ButtonRefresh"), var1, var2);
        this.aSPanel_Sub44_4565.setLocation(250 - this.aSPanel_Sub44_4565.method2935() / 2, 270 - this.aSPanel_Sub44_4565.method2936());
        this.aSPanel_Sub44_4566 = new SPanel_Sub44(this.anImageManager4559, this, 0, this.aString4562, var1, var2);
        this.aSPanel_Sub44_4566.setLocation(493 - this.aSPanel_Sub44_4566.method2935(), 270 - this.aSPanel_Sub44_4566.method2936());
        this.aSPanel_Sub44_4567 = new SPanel_Sub44(this.anImageManager4559, this, 3, this.aString4563, var1, var2);
        this.aSPanel_Sub44_4567.setLocation(7, 270 - this.aSPanel_Sub44_4567.method2936());
    }

    protected void method2928() {
        if (this.aString4561 != null && this.aString4562 != null) {
            this.method2930(1);
        } else {
            this.method2930(-1);
        }

    }

    protected void method2929(boolean var1) {
        if (this.anInt4570 == 1) {
            AApplet var2 = this.aParameters4557.getAApplet();
            if (var2 != null) {
                var2.callJavaScriptJsonBuyConfirmAnswer(this.aProduct4560, var1);
            }

            this.anInt4570 = 2;
        }

    }

    private void method2930(int var1) {
        if (this.anInt4568 != var1) {
            this.anInt4568 = var1;
            this.setVisible(false);
            this.removeAll();
            if (var1 == 1) {
                this.add(this.aSPanel_Sub44_4566);
                this.add(this.aSPanel_Sub44_4564);
                this.method2931();
                this.add(this.aSPanel_Sub44_4567);
            } else if (var1 == 4) {
                this.add(this.aSPanel_Sub44_4567);
            } else {
                if (var1 == 5) {
                    this.add(this.aSPanel_Sub44_4565);
                }

                if (var1 == -1) {
                    this.add(this.aSPanel_Sub44_4567);
                }
            }

            this.setVisible(true);
            this.repaint();
        }
    }

    private void method2931() {
        boolean var1 = false;
        boolean var2 = false;
        if (this.aProduct4560 != null) {
            if (this.aPurchaseFrame4556.method2345(this.aProduct4560)) {
                var1 = true;
                if (this.anInt4570 == 0) {
                    AApplet var3 = this.aParameters4557.getAApplet();
                    if (var3 != null) {
                        var3.callJavaScriptJsonBuyConfirmNeeded(this.aProduct4560);
                    }

                    this.anInt4570 = 1;
                }
            } else {
                var2 = true;
            }
        }

        this.aSPanel_Sub44_4566.setVisible(var1);
        this.aSPanel_Sub44_4564.setVisible(var2);
    }

    protected void method2932() {
        if (!this.aPurchaseFrame4556.method2347()) {
            this.method2930(2);
            Tools.sleep(500L);
            this.aPurchaseFrame4556.method2348();
            Tools.sleep(1000L);
            this.method2930(5);
        }
    }

    protected void method2933() {
        this.method2930(6);
        Tools.sleep(500L);
        this.aPurchaseFrame4556.method2349();
        this.method2930(1);
    }

    protected void method2934() {
        this.method2930(3);
        this.method2929(true);
        Tools.sleep(500L);
        this.anInt4569 = this.aPurchaseFrame4556.method2350(this.aProduct4560);
        this.method2930(4);
    }

    static {
        aStringArray4571[0] = "PurchaseFrame_ButtonRefresh";
        aStringArray4571[1] = "PurchaseFrame_ButtonGetCredits";
        aStringArray4571[2] = "PurchaseFrame_NoProductDescription";
        aStringArray4571[3] = "credit-background.jpg";
        aStringArray4571[4] = "credit-coins-bg.png";
        aStringArray4571[5] = "ProductPurchase";
        aStringArray4571[6] = "Ok";
        aStringArray4571[7] = "RefreshingCredits";
        aStringArray4571[8] = "Failed";
        aStringArray4571[9] = "NoBalance";
        aStringArray4571[10] = "PurchaseFrame_Action";
        aStringArray4571[11] = "PurchaseFrame_Purchase";
        aStringArray4571[12] = "PurchaseFrame_Error_Message";
        aStringArray4571[13] = "PurchaseFrame_RefreshAfterGet";
        aStringArray4571[14] = "PurchaseFrame_Credits";
        aStringArray4571[15] = "OpeningCreditPurchase";
        aStringArray4571[16] = "Dialog";
        aColor4548 = new Color(246, 222, 178);
        aColor4550 = Color.white;
        aColor4551 = new Color(184, 92, 0);
        aColor4552 = Color.black;
        aFont4553 = new Font("Dialog", 1, 24);
        aFont4554 = new Font("Dialog", 1, 32);
        aFont4555 = new Font("Dialog", 1, 14);
    }
}
