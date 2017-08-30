package com.aapeli.credit;

import com.aapeli.applet.AApplet;
import com.aapeli.bigtext.BigText;
import com.aapeli.client.IPanel;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.StringDraw;
import com.aapeli.client.TextManager;
import com.aapeli.credit.Canvas_Sub9;
import com.aapeli.credit.Product;
import com.aapeli.credit.PurchaseFrame;
import com.aapeli.tools.DelayRepaint;
import com.aapeli.tools.Tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class IPanel_Sub42 extends IPanel implements ItemListener, ActionListener {

    protected static final Color aColor3426;
    private static final String aString3427 = "Product__";
    private static final Color aColor3428;
    private static final Color aColor3429;
    private static final Color aColor3430;
    private static final Font aFont3431;
    private static final Font aFont3432;
    private PurchaseFrame aPurchaseFrame3433;
    private Parameters aParameters3434;
    private TextManager aTextManager3435;
    private ImageManager anImageManager3436;
    private Product aProduct3437;
    private String aString3438;
    private String aString3439;
    private String aString3440;
    private Canvas_Sub9 aCanvas_Sub9_3441;
    private Canvas_Sub9 aCanvas_Sub9_3442;
    private Canvas_Sub9 aCanvas_Sub9_3443;
    private Canvas_Sub9 aCanvas_Sub9_3444;
    private int anInt3445;
    private int anInt3446;
    private BigText aBigText3447;
    private int anInt3448;
    private int anInt3449;
    private Image anImage3450;
    private Graphics aGraphics3451;
    private static final String[] aStringArray3452 = new String[17];


    protected IPanel_Sub42(PurchaseFrame var1, Parameters var2, TextManager var3, ImageManager var4, Product var5, String var6, String var7) {
        this.aPurchaseFrame3433 = var1;
        this.aParameters3434 = var2;
        this.aTextManager3435 = var3;
        this.anImageManager3436 = var4;
        this.aProduct3437 = var5;
        if (var5 != null) {
            String var8 = var5.getProductName();
            String var9 = aString3427 + var8;
            if (var3.isAvailable(var9)) {
                int var10 = var5.getProductPrice();
                int var11 = var5.getProductDuration();
                this.aString3438 = var3.getWithQuantity(var9, new String[]{"" + var10, "" + var11}, var10);
            } else {
                this.aString3438 = var3.getShared("PurchaseFrame_NoProductDescription", var8);
            }
        } else {
            this.aString3438 = null;
        }

        this.aString3439 = var6;
        this.aString3440 = var7;
        this.setBackground(aColor3426);
        this.setSharedBackground(var4, "credit-background.jpg", 0, 0);
        this.setSize(500, 280);
        BigText.initialize(var4);
        this.aBigText3447 = null;
        this.anInt3448 = -1;
        this.anInt3449 = 0;
        this.anInt3445 = 0;
    }

    public void update(Graphics var1) {
        if (this.anImage3450 == null) {
            this.anImage3450 = this.createImage(500, 280);
            this.aGraphics3451 = this.anImage3450.getGraphics();
        }

        this.drawBackground(this.aGraphics3451);
        String var2;
        if (this.anInt3445 == 2 || this.anInt3445 == 6 || this.anInt3445 == 3) {
            this.aGraphics3451.setFont(aFont3432);
            this.aGraphics3451.setColor(aColor3430);
            var2 = null;
            if (this.anInt3445 == 2) {
                var2 = "OpeningCreditPurchase";
            } else if (this.anInt3445 == 6) {
                var2 = "RefreshingCredits";
            } else if (this.anInt3445 == 3) {
                var2 = "ProductPurchase";
            }

            if (var2 != null) {
                StringDraw.drawStringWithMaxWidth(this.aGraphics3451, this.aTextManager3435.getShared("PurchaseFrame_Action" + var2), 250, 140, 0, 460);
            }
        }

        if (this.anInt3445 == 4) {
            this.aGraphics3451.setFont(aFont3432);
            this.aGraphics3451.setColor(aColor3430);
            var2 = null;
            if (this.anInt3446 == 1) {
                var2 = "Ok";
            } else if (this.anInt3446 == 0) {
                var2 = "NoBalance";
            } else if (this.anInt3446 == -1) {
                var2 = "Failed";
            }

            if (var2 != null) {
                StringDraw.drawStringWithMaxWidth(this.aGraphics3451, this.aTextManager3435.getShared("PurchaseFrame_Purchase" + var2), 250, 140, 0, 460);
            }
        }

        boolean var6 = false;
        if (this.anInt3445 == 1) {
            Image var3 = this.anImageManager3436.getShared("credit-coins-bg.png", true);
            if (var3 != null) {
                this.aGraphics3451.drawImage(var3, 7, 3, this);
            } else {
                var6 = true;
            }

            this.aGraphics3451.setFont(aFont3431);
            this.aGraphics3451.setColor(aColor3428);
            StringDraw.drawOutlinedString(this.aGraphics3451, aColor3429, this.aTextManager3435.getShared("PurchaseFrame_Credits"), 77, 35, -1);
            int var4 = this.aPurchaseFrame3433.method243();
            if (var4 != this.anInt3448) {
                this.aBigText3447 = null;
            }

            if (this.aBigText3447 == null) {
                this.aBigText3447 = new BigText("" + this.aPurchaseFrame3433.method243(), Color.white, 255);
                this.anInt3448 = var4;
            }

            this.aBigText3447.drawText(this.aGraphics3451, 480, 47, 1, 1);
        }

        String var5 = null;
        if (this.anInt3445 == 1) {
            var5 = this.aString3438;
        } else if (this.anInt3445 == 5) {
            var5 = this.aTextManager3435.getShared("PurchaseFrame_RefreshAfterGet");
        } else if (this.anInt3445 == -1) {
            var5 = this.aTextManager3435.getShared("PurchaseFrame_Error_Message");
        }

        if (var5 != null) {
            this.aGraphics3451.setFont(aFont3432);
            this.aGraphics3451.setColor(aColor3430);
            StringDraw.drawStringWithMaxWidth(this.aGraphics3451, var5, 20, 85, -1, 460);
        }

        var1.drawImage(this.anImage3450, 0, 0, this);
        if (var6) {
            new DelayRepaint(this);
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        this.method885();
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aCanvas_Sub9_3441) {
            this.method886();
        } else if (var2 == this.aCanvas_Sub9_3442) {
            this.method887();
        } else if (var2 == this.aCanvas_Sub9_3443) {
            this.method888();
        } else if (var2 == this.aCanvas_Sub9_3444) {
            this.aPurchaseFrame3433.method248();
        }

    }

    protected void method881(boolean var1, boolean var2) {
        this.setLayout((LayoutManager) null);
        this.aCanvas_Sub9_3441 = new Canvas_Sub9(this.anImageManager3436, this, 1, this.aTextManager3435.getShared("PurchaseFrame_ButtonGetCredits"), var1, var2);
        this.aCanvas_Sub9_3441.setLocation(493 - this.aCanvas_Sub9_3441.method223(), 270 - this.aCanvas_Sub9_3441.method224());
        this.aCanvas_Sub9_3442 = new Canvas_Sub9(this.anImageManager3436, this, 2, this.aTextManager3435.getShared("PurchaseFrame_ButtonRefresh"), var1, var2);
        this.aCanvas_Sub9_3442.setLocation(250 - this.aCanvas_Sub9_3442.method223() / 2, 270 - this.aCanvas_Sub9_3442.method224());
        this.aCanvas_Sub9_3443 = new Canvas_Sub9(this.anImageManager3436, this, 0, this.aString3439, var1, var2);
        this.aCanvas_Sub9_3443.setLocation(493 - this.aCanvas_Sub9_3443.method223(), 270 - this.aCanvas_Sub9_3443.method224());
        this.aCanvas_Sub9_3444 = new Canvas_Sub9(this.anImageManager3436, this, 3, this.aString3440, var1, var2);
        this.aCanvas_Sub9_3444.setLocation(7, 270 - this.aCanvas_Sub9_3444.method224());
    }

    protected void method882() {
        if (this.aString3438 != null && this.aString3439 != null) {
            this.method884(1);
        } else {
            this.method884(-1);
        }

    }

    protected void method883(boolean var1) {
        if (this.anInt3449 == 1) {
            AApplet var2 = this.aParameters3434.getAApplet();
            if (var2 != null) {
                var2.callJavaScriptJsonBuyConfirmAnswer(this.aProduct3437, var1);
            }

            this.anInt3449 = 2;
        }

    }

    private void method884(int var1) {
        if (this.anInt3445 != var1) {
            this.anInt3445 = var1;
            this.setVisible(false);
            this.removeAll();
            if (var1 == 1) {
                this.add(this.aCanvas_Sub9_3443);
                this.add(this.aCanvas_Sub9_3441);
                this.method885();
                this.add(this.aCanvas_Sub9_3444);
            } else if (var1 == 4) {
                this.add(this.aCanvas_Sub9_3444);
            } else {
                if (var1 == 5) {
                    this.add(this.aCanvas_Sub9_3442);
                }

                if (var1 == -1) {
                    this.add(this.aCanvas_Sub9_3444);
                }
            }

            this.setVisible(true);
            if (var1 != 2 && var1 != 6 && var1 != 3) {
                this.repaint();
            } else {
                Tools.forcedRepaint(this);
            }

        }
    }

    private void method885() {
        boolean var1 = false;
        boolean var2 = false;
        if (this.aProduct3437 != null) {
            if (this.aPurchaseFrame3433.method242(this.aProduct3437)) {
                var1 = true;
                if (this.anInt3449 == 0) {
                    AApplet var3 = this.aParameters3434.getAApplet();
                    if (var3 != null) {
                        var3.callJavaScriptJsonBuyConfirmNeeded(this.aProduct3437);
                    }

                    this.anInt3449 = 1;
                }
            } else {
                var2 = true;
            }
        }

        this.aCanvas_Sub9_3443.setVisible(var1);
        this.aCanvas_Sub9_3441.setVisible(var2);
    }

    private void method886() {
        if (!this.aPurchaseFrame3433.method244()) {
            this.method884(2);
            Tools.sleep(500L);
            this.aPurchaseFrame3433.method245();
            Tools.sleep(1000L);
            this.method884(5);
        }
    }

    private void method887() {
        this.method884(6);
        Tools.sleep(500L);
        this.aPurchaseFrame3433.method246();
        this.method884(1);
    }

    private void method888() {
        this.method884(3);
        this.method883(true);
        Tools.sleep(500L);
        this.anInt3446 = this.aPurchaseFrame3433.method247(this.aProduct3437);
        this.method884(4);
    }

    static {
        aStringArray3452[0] = "PurchaseFrame_NoProductDescription";
        aStringArray3452[1] = "credit-background.jpg";
        aStringArray3452[2] = "PurchaseFrame_ButtonGetCredits";
        aStringArray3452[3] = "PurchaseFrame_ButtonRefresh";
        aStringArray3452[4] = "Ok";
        aStringArray3452[5] = "OpeningCreditPurchase";
        aStringArray3452[6] = "PurchaseFrame_Credits";
        aStringArray3452[7] = "NoBalance";
        aStringArray3452[8] = "PurchaseFrame_Error_Message";
        aStringArray3452[9] = "Failed";
        aStringArray3452[10] = "credit-coins-bg.png";
        aStringArray3452[11] = "PurchaseFrame_Purchase";
        aStringArray3452[12] = "RefreshingCredits";
        aStringArray3452[13] = "PurchaseFrame_RefreshAfterGet";
        aStringArray3452[14] = "ProductPurchase";
        aStringArray3452[15] = "PurchaseFrame_Action";
        aStringArray3452[16] = "Dialog";
        aColor3426 = new Color(246, 222, 178);
        aColor3428 = Color.white;
        aColor3429 = new Color(184, 92, 0);
        aColor3430 = Color.black;
        aFont3431 = new Font("Dialog", 1, 24);
        aFont3432 = new Font("Dialog", 1, 14);
    }
}
