package com.aapeli.credit;

import com.aapeli.applet.AApplet;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;
import com.aapeli.tools.QuickTimer;
import com.aapeli.tools.QuickTimerListener;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public final class PurchaseFrame extends Frame implements WindowListener, QuickTimerListener {

    public static final int BUY_OK = 1;
    public static final int BUY_NOBALANCE = 0;
    public static final int BUY_FAILED = -1;
    private Insets anInsets2579;
    private int anInt2580;
    private int anInt2581;
    private AApplet anAApplet2582;
    private PurchaseHandler aPurchaseHandler2583;
    private IPanel_Sub42 anIPanel_Sub42_2584;
    private Parameters aParameters2585;
    private Class103 aClass103_2586;
    private String aString2587;
    private Object anObject2588;
    private boolean aBoolean2589;
    private BuyCreditsHandler aBuyCreditsHandler2590;
    private int anInt2591;
    private static final String[] aStringArray2592 = new String[9];


    public PurchaseFrame(PurchaseHandler var1, Parameters var2, TextManager var3, ImageManager var4, Product var5, int var6, Object var7) {
        this((AApplet) null, var1, var2, var3, var4, var5, var6, (String) null, (String) null, (String) null, var7);
    }

    public PurchaseFrame(AApplet var1, PurchaseHandler var2, Product var3, int var4, Object var5) {
        this(var1, var2, var1.param, var1.textManager, var1.imageManager, var3, var4, (String) null, (String) null, (String) null, var5);
    }

    public PurchaseFrame(PurchaseHandler var1, Parameters var2, TextManager var3, ImageManager var4, Product var5, int var6, String var7, String var8, String var9) {
        this((AApplet) null, var1, var2, var3, var4, var5, var6, var7, var8, var9, (Object) null);
    }

    public PurchaseFrame(PurchaseHandler var1, Parameters var2, TextManager var3, ImageManager var4, Product var5, int var6, String var7, String var8, String var9, Object var10) {
        this((AApplet) null, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
    }

    public PurchaseFrame(AApplet var1, PurchaseHandler var2, Product var3, int var4, String var5, String var6, String var7) {
        this(var1, var2, var1.param, var1.textManager, var1.imageManager, var3, var4, var5, var6, var7, (Object) null);
    }

    private PurchaseFrame(AApplet var1, PurchaseHandler var2, Parameters var3, TextManager var4, ImageManager var5, Product var6, int var7, String var8, String var9, String var10, Object var11) {
        this.anAApplet2582 = var1;
        this.aPurchaseHandler2583 = var2;
        this.aParameters2585 = var3;
        this.aClass103_2586 = new Class103(this, var7);
        this.anInt2591 = this.aClass103_2586.method1810();
        if (var8 == null) {
            var8 = var4.getShared("PurchaseFrame_Default_FrameTitle");
        }

        if (var9 == null) {
            var9 = var4.getShared("PurchaseFrame_Default_ButtonContinue");
        }

        if (var10 == null) {
            var10 = var4.getShared("PurchaseFrame_Default_ButtonBack");
        }

        this.aString2587 = var8;
        this.anObject2588 = var11;
        if (var6 != null) {
            this.anIPanel_Sub42_2584 = new IPanel_Sub42(this, var3, var4, var5, var6, var9, var10);
        } else {
            this.aString2587 = var4.getShared("PurchaseFrame_Error_FrameTitle");
            this.anIPanel_Sub42_2584 = new IPanel_Sub42(this, var3, var4, var5, (Product) null, (String) null, var10);
        }

        this.aBoolean2589 = true;
        this.aBuyCreditsHandler2590 = null;
        this.anInt2580 = 500;
        this.anInt2581 = 280;
        if (var1 != null) {
            var1.writeThriftLog("buywinopen", "productlabel:s:" + var6.getProductName() + "^coins:i:" + var7);
        }

    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        var1.setColor(IPanel_Sub42.aColor3426);
        var1.fillRect(0, 0, this.anInt2580, this.anInt2581);
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.method248();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    public void qtFinished() {
        this.setSize(this.anInt2580, this.anInt2581);
        this.requestFocus();
    }

    public void disableButtonArrows() {
        this.aBoolean2589 = false;
    }

    public void open(Component var1) {
        this.open(var1, false);
    }

    public void open(Component var1, boolean var2) {
        this.setTitle(this.aString2587);
        this.setVisible(true);
        this.anInsets2579 = this.getInsets();
        this.anInt2580 = this.anInsets2579.left + 500 + this.anInsets2579.right;
        this.anInt2581 = this.anInsets2579.top + 280 + this.anInsets2579.bottom;
        this.setSize(this.anInt2580, this.anInt2581);
        Point var3 = var1.getLocationOnScreen();
        Dimension var4 = var1.getSize();
        this.setLocation(var3.x + var4.width / 2 - this.anInt2580 / 2, var3.y + var4.height / 2 - this.anInt2581 / 2);
        this.setBackground(IPanel_Sub42.aColor3426);
        this.anIPanel_Sub42_2584.method881(this.aBoolean2589, var2);
        this.setLayout((LayoutManager) null);
        this.anIPanel_Sub42_2584.setLocation(this.anInsets2579.left, this.anInsets2579.top);
        this.add(this.anIPanel_Sub42_2584);
        this.anIPanel_Sub42_2584.method882();
        this.addWindowListener(this);
        this.toFront();
        this.requestFocus();
        new QuickTimer(250, this);
    }

    public void close() {
        this.dispose();
    }

    public void setBuyCreditsHandler(BuyCreditsHandler var1) {
        this.aBuyCreditsHandler2590 = var1;
    }

    protected boolean method242(Product var1) {
        return this.aClass103_2586.method1809() >= var1.getProductPrice();
    }

    protected int method243() {
        return this.aClass103_2586 != null ? this.aClass103_2586.method1809() : this.anInt2591;
    }

    protected boolean method244() {
        if (this.aBuyCreditsHandler2590 != null) {
            this.aBuyCreditsHandler2590.quitToBuyCredits();
            return true;
        } else {
            return false;
        }
    }

    protected void method245() {
        this.aParameters2585.showCreditPurchasePage();
    }

    protected void method246() {
        this.aClass103_2586.method1808(this.aPurchaseHandler2583.refreshCredits());
    }

    protected int method247(Product var1) {
        if (this.anAApplet2582 != null) {
            this.anAApplet2582.writeThriftLog("buywinok", (String) null);
            this.anAApplet2582.callJavaScriptJsonBuyStarted(var1);
        }

        int var2 = this.aPurchaseHandler2583.userBuyProduct(var1, this.anObject2588);
        if (this.anAApplet2582 != null) {
            this.anAApplet2582.callJavaScriptJsonBuyFinished(var1, var2);
        }

        return var2;
    }

    protected void method248() {
        if (this.anAApplet2582 != null) {
            this.anAApplet2582.writeThriftLog("buywincancel", (String) null);
        }

        this.anIPanel_Sub42_2584.method883(false);
        this.aPurchaseHandler2583.userCanceled();
    }

    static {
        aStringArray2592[0] = "productlabel:s:";
        aStringArray2592[1] = "PurchaseFrame_Default_ButtonContinue";
        aStringArray2592[2] = "PurchaseFrame_Default_ButtonBack";
        aStringArray2592[3] = "buywinopen";
        aStringArray2592[4] = "PurchaseFrame_Default_FrameTitle";
        aStringArray2592[5] = "PurchaseFrame_Error_FrameTitle";
        aStringArray2592[6] = "^coins:i:";
        aStringArray2592[7] = "buywincancel";
        aStringArray2592[8] = "buywinok";
    }
}
