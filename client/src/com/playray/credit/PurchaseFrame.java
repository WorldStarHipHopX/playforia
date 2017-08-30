package com.playray.credit;

import com.playray.applet.AApplet;
import com.playray.client.ImageManager;
import com.playray.client.Parameters;
import com.playray.client.TextManager;
import com.playray.credit.BuyCreditsHandler;
import com.playray.credit.Class139;
import com.playray.credit.Product;
import com.playray.credit.PurchaseHandler;
import com.playray.credit.SPanel_Sub43;
import com.playray.tools.QuickTimer;
import com.playray.tools.QuickTimerListener;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public final class PurchaseFrame extends JFrame implements WindowListener, QuickTimerListener {

    public static final int BUY_OK = 1;
    public static final int BUY_NOBALANCE = 0;
    public static final int BUY_FAILED = -1;
    private AApplet anAApplet2780;
    private PurchaseHandler aPurchaseHandler2781;
    private SPanel_Sub43 aSPanel_Sub43_2782;
    private Parameters aParameters2783;
    private Class139 aClass139_2784;
    private Object anObject2785;
    private boolean aBoolean2786;
    private BuyCreditsHandler aBuyCreditsHandler2787;
    private int anInt2788;
    private static final String[] aStringArray2789 = new String[10];


    public PurchaseFrame(PurchaseHandler var1, Parameters var2, TextManager var3, ImageManager var4, Product var5, int var6, Object var7) {
        this((AApplet) null, var1, var2, var3, var4, var5, var6, (String) null, (String) null, (String) null, var7);
    }

    public PurchaseFrame(AApplet var1, PurchaseHandler var2, Product var3, int var4, Object var5) {
        this(var1, var2, var1.param, var1.aTextManager3821, var1.anImageManager3822, var3, var4, (String) null, (String) null, (String) null, var5);
    }

    public PurchaseFrame(PurchaseHandler var1, Parameters var2, TextManager var3, ImageManager var4, Product var5, int var6, String var7, String var8, String var9) {
        this((AApplet) null, var1, var2, var3, var4, var5, var6, var7, var8, var9, (Object) null);
    }

    public PurchaseFrame(AApplet var1, PurchaseHandler var2, Product var3, int var4, String var5, String var6, String var7) {
        this(var1, var2, var1.param, var1.aTextManager3821, var1.anImageManager3822, var3, var4, var5, var6, var7, (Object) null);
    }

    private PurchaseFrame(AApplet var1, PurchaseHandler var2, Parameters var3, TextManager var4, ImageManager var5, Product var6, int var7, String var8, String var9, String var10, Object var11) {
        this.anAApplet2780 = var1;
        this.aPurchaseHandler2781 = var2;
        this.aParameters2783 = var3;
        this.aClass139_2784 = new Class139(this, var7);
        this.anInt2788 = this.aClass139_2784.method2141();
        if (var8 == null) {
            var8 = var4.getShared("PurchaseFrame_Default_FrameTitle");
        }

        if (var9 == null) {
            var9 = var4.getShared("PurchaseFrame_Default_ButtonContinue");
        }

        if (var10 == null) {
            var10 = var4.getShared("PurchaseFrame_Default_ButtonBack");
        }

        this.anObject2785 = var11;
        if (var6 != null) {
            this.aSPanel_Sub43_2782 = new SPanel_Sub43(this, var3, var4, var5, var6, var9, var10);
        } else {
            var8 = var4.getShared("PurchaseFrame_Error_FrameTitle");
            this.aSPanel_Sub43_2782 = new SPanel_Sub43(this, var3, var4, var5, (Product) null, (String) null, var10);
        }

        this.setTitle(var8);
        this.setIconImage(var5.getShared("icon.png"));
        this.setBackground(SPanel_Sub43.aColor4548);
        this.setContentPane(this.aSPanel_Sub43_2782);
        this.pack();
        this.aBoolean2786 = true;
        this.aBuyCreditsHandler2787 = null;
        if (var1 != null) {
            var1.writeThriftLog("buywinopen", "productlabel:s:" + var6.getProductName() + "^coins:i:" + var7);
        }

    }

    public void qtFinished() {
        this.requestFocus();
        this.toFront();
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.method2351();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    public void disableButtonArrows() {
        this.aBoolean2786 = false;
    }

    public void open(Component var1) {
        this.open(var1, false);
    }

    public void open(Component var1, boolean var2) {
        this.aSPanel_Sub43_2782.method2927(this.aBoolean2786, var2);
        this.aSPanel_Sub43_2782.method2928();
        Dimension var3 = this.getSize();
        int var4 = var3.width;
        int var5 = var3.height;
        if (var4 < 500 || var5 < 280) {
            var4 = 500;
            var5 = 280;
            this.setSize(var4, var5);
        }

        Point var6 = var1.getLocationOnScreen();
        Dimension var7 = var1.getSize();
        this.setLocation(var6.x + var7.width / 2 - var4 / 2, var6.y + var7.height / 2 - var5 / 2);
        this.setVisible(true);
        this.addWindowListener(this);
        this.toFront();
        this.requestFocus();
        new QuickTimer(500, this);
    }

    public void close() {
        this.dispose();
    }

    public void setBuyCreditsHandler(BuyCreditsHandler var1) {
        this.aBuyCreditsHandler2787 = var1;
    }

    protected boolean method2345(Product var1) {
        return this.aClass139_2784.method2140() >= var1.getProductPrice();
    }

    protected int method2346() {
        return this.aClass139_2784 != null ? this.aClass139_2784.method2140() : this.anInt2788;
    }

    protected boolean method2347() {
        if (this.aBuyCreditsHandler2787 != null) {
            this.aBuyCreditsHandler2787.quitToBuyCredits();
            return true;
        } else {
            return false;
        }
    }

    protected void method2348() {
        this.aParameters2783.showCreditPurchasePage();
    }

    protected void method2349() {
        this.aClass139_2784.method2139(this.aPurchaseHandler2781.refreshCredits());
    }

    protected int method2350(Product var1) {
        if (this.anAApplet2780 != null) {
            this.anAApplet2780.writeThriftLog("buywinok", (String) null);
            this.anAApplet2780.callJavaScriptJsonBuyStarted(var1);
        }

        int var2 = this.aPurchaseHandler2781.userBuyProduct(var1, this.anObject2785);
        if (this.anAApplet2780 != null) {
            this.anAApplet2780.callJavaScriptJsonBuyFinished(var1, var2);
        }

        return var2;
    }

    protected void method2351() {
        if (this.anAApplet2780 != null) {
            this.anAApplet2780.writeThriftLog("buywincancel", (String) null);
        }

        this.aSPanel_Sub43_2782.method2929(false);
        this.aPurchaseHandler2781.userCanceled();
    }

    static {
        aStringArray2789[0] = "PurchaseFrame_Error_FrameTitle";
        aStringArray2789[1] = "PurchaseFrame_Default_ButtonContinue";
        aStringArray2789[2] = "buywinopen";
        aStringArray2789[3] = "PurchaseFrame_Default_ButtonBack";
        aStringArray2789[4] = "productlabel:s:";
        aStringArray2789[5] = "icon.png";
        aStringArray2789[6] = "PurchaseFrame_Default_FrameTitle";
        aStringArray2789[7] = "^coins:i:";
        aStringArray2789[8] = "buywincancel";
        aStringArray2789[9] = "buywinok";
    }
}
