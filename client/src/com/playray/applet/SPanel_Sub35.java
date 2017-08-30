package com.playray.applet;

import com.playray.applet.AApplet;
import com.playray.applet.Class109;
import com.playray.client.Parameters;
import com.playray.client.SPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.Vector;

final class SPanel_Sub35 extends SPanel implements MouseListener {

    private static final String aString4207 = "_blank";
    private AApplet anAApplet4208;
    private URL anURL4209;
    private Vector aVector4210;
    private URL anURL4211;
    private String aString4212;
    private int anInt4213;
    private Image anImage4214;
    private boolean aBoolean4215;
    private long aLong4216;
    private boolean aBoolean4217;
    private long aLong4218;
    private static final String[] aStringArray4219 = new String[8];


    private SPanel_Sub35(AApplet var1, URL var2, Vector var3, URL var4, String var5, int var6) {
        this.anAApplet4208 = var1;
        this.anURL4209 = var2;
        this.aVector4210 = var3;
        this.anURL4211 = var4;
        this.aString4212 = var5;
        this.anInt4213 = var6;
        this.aLong4216 = 0L;
        this.aBoolean4217 = false;
        this.anImage4214 = null;
        this.aBoolean4215 = false;
    }

    public void paintContent(Graphics2D var1) {
        if (this.aBoolean4215) {
            if (!this.aBoolean4217) {
                var1.drawImage(this.anImage4214, 0, 0, (ImageObserver) null);
                int var2 = this.aVector4210.size();

                for (int var3 = 0; var3 < var2; ++var3) {
                    Class109 var4 = (Class109) ((Class109) this.aVector4210.elementAt(var3));
                    var4.method1883(var1);
                }
            } else {
                var1.setColor(Color.white);
                var1.fillRect(0, 0, 20, 20);
                var1.setColor(Color.red);
                var1.drawRect(0, 0, 19, 19);
                var1.drawLine(0, 0, 19, 19);
                var1.drawLine(0, 19, 19, 0);
            }
        }

    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        this.anAApplet4208.getAppletContext().showDocument(this.anURL4211, this.aString4212);
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    protected static SPanel_Sub35 method2775(AApplet var0, Parameters var1) {
        try {
            String var2 = var1.getParameter("ad_image");
            URL var3 = new URL(var0.getCodeBase(), var2);
            Vector var4 = new Vector();

            String var6;
            for (int var5 = 1; (var6 = var1.getParameter("ad_text-" + var5)) != null; ++var5) {
                Class109 var7 = Class109.method1882(var6);
                if (var7 != null) {
                    var4.addElement(var7);
                }
            }

            String var14 = var1.getParameter("ad_page");
            URL var8 = var14 != null ? new URL(var14) : null;
            String var9 = var1.getParameter("ad_target");
            if (var9 == null) {
                var9 = aString4207;
            }

            int var10 = 10;
            String var11 = var1.getParameter("ad_mintime");
            if (var11 != null) {
                var10 = Integer.parseInt(var11);
            }

            SPanel_Sub35 var12 = new SPanel_Sub35(var0, var3, var4, var8, var9, var10);
            return var12;
        } catch (Exception var13) {
            return null;
        }
    }

    protected void method2776() {
        this.anImage4214 = Toolkit.getDefaultToolkit().createImage(anURL4209);//this.anAApplet4208.getImage(this.anURL4209);
    }

    protected boolean method2777() {
        if (this.aLong4216 <= 0L) {
            this.aLong4216 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() > this.aLong4216 + 15000L) {
            this.aBoolean4217 = true;
        }

        if (!this.aBoolean4217 && !this.anAApplet4208.prepareImage(this.anImage4214, (ImageObserver) null)) {
            return false;
        } else {
            if (!this.aBoolean4217) {
                int var1 = this.anImage4214.getWidth((ImageObserver) null);
                int var2 = this.anImage4214.getHeight((ImageObserver) null);
                this.setSize(var1, var2);
            } else {
                this.setSize(20, 20);
            }

            if (this.anURL4211 != null) {
                this.addMouseListener(this);
                this.setCursor(new Cursor(12));
            }

            this.aBoolean4215 = true;
            return true;
        }
    }

    protected void method2778() {
        this.aLong4218 = System.currentTimeMillis();
        this.repaint();
    }

    protected int method2779() {
        if (this.aBoolean4217) {
            return 0;
        } else {
            int var1 = (int) (System.currentTimeMillis() - this.aLong4218);
            int var2 = this.anInt4213 * 1000 - var1;
            return var2 < 0 ? 0 : var2;
        }
    }

    protected boolean method2780() {
        if (this.anURL4211 == null) {
            return false;
        } else {
            String var1 = this.aString4212.toLowerCase();
            return var1.equals("_self") ? false : (var1.equals("_parent") ? false : !var1.equals("_top"));
        }
    }

    protected void method2781() {
        this.aBoolean4215 = false;
        this.removeMouseListener(this);
        if (this.anImage4214 != null) {
            this.anImage4214.flush();
            this.anImage4214 = null;
        }

        this.anURL4209 = this.anURL4211 = null;
        this.aString4212 = null;
        this.anAApplet4208 = null;
    }

    static {
        aStringArray4219[0] = "_top";
        aStringArray4219[1] = "_self";
        aStringArray4219[2] = "_parent";
        aStringArray4219[3] = "ad_mintime";
        aStringArray4219[4] = "ad_page";
        aStringArray4219[5] = "ad_text-";
        aStringArray4219[6] = "ad_target";
        aStringArray4219[7] = "ad_image";
    }
}
