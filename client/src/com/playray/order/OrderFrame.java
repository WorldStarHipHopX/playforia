package com.playray.order;

import com.playray.client.ImageManager;
import com.playray.client.TextManager;
import com.playray.order.OrderHandler;
import com.playray.order.SPanel_Sub49;
import com.playray.singleclient.SingleClient;
import com.playray.tools.Tools;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class OrderFrame extends JFrame implements Runnable, WindowListener {

    private Insets anInsets2272;
    private int anInt2273;
    private int anInt2274;
    private OrderHandler anOrderHandler2275;
    private TextManager aTextManager2276;
    private String aString2277;
    private SingleClient aSingleClient2278;
    private SPanel_Sub49 aSPanel_Sub49_2279;
    private int anInt2280;
    private Object anObject2281;
    public static int anInt2282;
    private static final String[] aStringArray2283 = new String[3];


    public OrderFrame(OrderHandler var1, TextManager var2, ImageManager var3, String var4, SingleClient var5) {
        this.setResizable(false);
        this.anOrderHandler2275 = var1;
        this.aTextManager2276 = var2;
        this.aString2277 = var4;
        this.aSingleClient2278 = var5;
        this.anObject2281 = new Object();
        this.setIconImage(var3.getShared("icon.png"));
        this.aSPanel_Sub49_2279 = new SPanel_Sub49(var2, var3);
        this.anInt2280 = 0;
    }

    public void run() {
        this.requestFocus();
        String[] var1 = this.aSingleClient2278.createOrderCode(this.aString2277);
        if (var1 == null) {
            this.aSPanel_Sub49_2279.method3001();
            Object var11 = this.anObject2281;
            synchronized (this.anObject2281) {
                this.anInt2280 = 4;
            }
        } else {
            String var2 = var1[0];
            String var3 = this.aTextManager2276.getShared("OrderFrame_Instructions", var1[1], var1[2], var1[3], var1[4]);
            this.aSPanel_Sub49_2279.method2999(var3);
            if (this.anInt2280 == 1) {
                boolean var9 = true;

                do {
                    Tools.sleep(2000L);
                    if (this.anInt2280 == 1 && !this.method2356(var2) && this.aSPanel_Sub49_2279.method3002()) {
                        var9 = false;
                    }
                } while (this.anInt2280 == 1 && var9);
            }

            if (this.anInt2280 == 1) {
                long var10 = System.currentTimeMillis() + 30000L;

                do {
                    Tools.sleep(2000L);
                    if (this.anInt2280 == 1 && !this.method2356(var2) && System.currentTimeMillis() > var10) {
                        Object var5 = this.anObject2281;
                        synchronized (this.anObject2281) {
                            this.anInt2280 = 3;
                        }
                    }
                } while (this.anInt2280 == 1);
            }

            if (this.anInt2280 == 3) {
                this.aSingleClient2278.cancelOrderCode(var2);
            }

        }
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.close();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    public void open(Component var1) {
        this.open(var1, this.aTextManager2276.getShared("OrderFrame_Title"));
    }

    public void open(Component var1, String var2) {
        this.setTitle(var2);
        this.setVisible(true);
        this.anInsets2272 = this.getInsets();
        this.anInt2273 = this.anInsets2272.left + 500 + this.anInsets2272.right;
        this.anInt2274 = this.anInsets2272.top + 280 + this.anInsets2272.bottom;
        this.setSize(this.anInt2273, this.anInt2274);
        Point var3 = var1.getLocationOnScreen();
        Dimension var4 = var1.getSize();
        this.setLocation(var3.x + var4.width / 2 - this.anInt2273 / 2, var3.y + var4.height / 2 - this.anInt2274 / 2);
        this.setBackground(SPanel_Sub49.aColor4669);
        this.setLayout((LayoutManager) null);
        this.aSPanel_Sub49_2279.setLocation(this.anInsets2272.left, this.anInsets2272.top);
        this.add(this.aSPanel_Sub49_2279);
        this.addWindowListener(this);
        this.toFront();
        this.requestFocus();
        Object var5 = this.anObject2281;
        synchronized (this.anObject2281) {
            this.anInt2280 = 1;
        }

        Thread var8 = new Thread(this);
        var8.setDaemon(true);
        var8.start();
    }

    public void close() {
        this.method2357();
        this.dispose();
    }

    private boolean method2356(String var1) {
        boolean var2 = this.aSingleClient2278.pollOrderCode(var1);
        if (!var2) {
            return false;
        } else {
            Object var3 = this.anObject2281;
            synchronized (this.anObject2281) {
                this.anInt2280 = 2;
            }

            this.aSPanel_Sub49_2279.method3000();
            Tools.sleep(2000L);
            this.anOrderHandler2275.orderCompleted();
            return true;
        }
    }

    private void method2357() {
        Object var1 = this.anObject2281;
        synchronized (this.anObject2281) {
            if (this.anInt2280 == 1) {
                this.anInt2280 = 3;
                this.anOrderHandler2275.orderCanceled(false);
            }

        }
    }

    static {
        aStringArray2283[0] = "OrderFrame_Title";
        aStringArray2283[1] = "icon.png";
        aStringArray2283[2] = "OrderFrame_Instructions";
    }
}
