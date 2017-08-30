package com.aapeli.order;

import com.aapeli.client.ImageManager;
import com.aapeli.client.TextManager;
import com.aapeli.singleclient.SingleClient;
import com.aapeli.tools.Tools;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class OrderFrame extends Frame implements Runnable, WindowListener {

    private Insets anInsets228;
    private int anInt229;
    private int anInt230;
    private OrderHandler anOrderHandler231;
    private TextManager aTextManager232;
    private String aString233;
    private SingleClient aSingleClient234;
    private OrderCanvas aOrderCanvas__235;
    private int anInt236;
    public static int anInt237;
    private static final String[] aStringArray238 = new String[2];


    public OrderFrame(OrderHandler var1, TextManager var2, ImageManager var3, String var4, SingleClient var5) {
        this.setResizable(false);
        this.anOrderHandler231 = var1;
        this.aTextManager232 = var2;
        this.aString233 = var4;
        this.aSingleClient234 = var5;
        this.aOrderCanvas__235 = new OrderCanvas(var2, var3);
        this.anInt236 = 0;
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        var1.setColor(OrderCanvas.aColor170);
        var1.fillRect(0, 0, this.anInt229, this.anInt230);
    }

    public void run() {
        this.requestFocus();
        String[] var1 = this.aSingleClient234.createOrderCode(this.aString233);
        if (var1 == null) {
            this.aOrderCanvas__235.method231();
            synchronized (this) {
                this.anInt236 = 4;
            }
        } else {
            String var2 = var1[0];
            String var3 = this.aTextManager232.getShared("OrderFrame_Instructions", var1[1], var1[2], var1[3], var1[4]);
            this.aOrderCanvas__235.method229(var3);
            if (this.anInt236 == 1) {
                boolean var9 = true;

                do {
                    Tools.sleep(2000L);
                    if (this.anInt236 == 1 && !this.method259(var2) && this.aOrderCanvas__235.method232()) {
                        var9 = false;
                    }
                } while (this.anInt236 == 1 && var9);
            }

            if (this.anInt236 == 1) {
                long var10 = System.currentTimeMillis() + 30000L;

                do {
                    Tools.sleep(2000L);
                    if (this.anInt236 == 1 && !this.method259(var2) && System.currentTimeMillis() > var10) {
                        synchronized (this) {
                            this.anInt236 = 3;
                        }
                    }
                } while (this.anInt236 == 1);
            }

            if (this.anInt236 == 3) {
                this.aSingleClient234.cancelOrderCode(var2);
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
        this.open(var1, this.aTextManager232.getShared("OrderFrame_Title"));
    }

    public void open(Component var1, String var2) {
        this.setTitle(var2);
        this.setVisible(true);
        this.anInsets228 = this.getInsets();
        this.anInt229 = this.anInsets228.left + 500 + this.anInsets228.right;
        this.anInt230 = this.anInsets228.top + 280 + this.anInsets228.bottom;
        this.setSize(this.anInt229, this.anInt230);
        Point var3 = var1.getLocationOnScreen();
        Dimension var4 = var1.getSize();
        this.setLocation(var3.x + var4.width / 2 - this.anInt229 / 2, var3.y + var4.height / 2 - this.anInt230 / 2);
        this.setBackground(OrderCanvas.aColor170);
        this.setLayout((LayoutManager) null);
        this.aOrderCanvas__235.setLocation(this.anInsets228.left, this.anInsets228.top);
        this.add(this.aOrderCanvas__235);
        this.addWindowListener(this);
        this.toFront();
        this.requestFocus();
        synchronized (this) {
            this.anInt236 = 1;
        }

        Thread var5 = new Thread(this);
        var5.setDaemon(true);
        var5.start();
    }

    public void close() {
        this.method260();
        this.dispose();
    }

    private boolean method259(String var1) {
        boolean var2 = this.aSingleClient234.pollOrderCode(var1);
        if (!var2) {
            return false;
        } else {
            synchronized (this) {
                this.anInt236 = 2;
            }

            this.aOrderCanvas__235.method230();
            Tools.sleep(2000L);
            this.anOrderHandler231.orderCompleted();
            return true;
        }
    }

    private void method260() {
        synchronized (this) {
            if (this.anInt236 == 1) {
                this.anInt236 = 3;
                this.anOrderHandler231.orderCanceled(false);
            }

        }
    }

    static {
        aStringArray238[0] = "OrderFrame_Title";
        aStringArray238[1] = "OrderFrame_Instructions";
    }
}
