package com.aapeli.applet;

import com.aapeli.client.Parameters;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.Vector;

class AdCanvas extends Canvas implements MouseListener {

    private static final String linkTarget = "_blank";
    private AApplet gameApplet;
    private LoadingPanel aLoadingPanel__116;
    private URL anURL117;
    private Vector aVector118;
    private URL anURL119;
    private String aString120;
    private int anInt121;
    private Image anImage122;
    private boolean aBoolean123;
    private long aLong124;
    private boolean aBoolean125;
    private long aLong126;


    private AdCanvas(AApplet var1, URL var2, Vector var3, URL var4, String var5, int var6) {
        this.gameApplet = var1;
        this.anURL117 = var2;
        this.aVector118 = var3;
        this.anURL119 = var4;
        this.aString120 = var5;
        this.anInt121 = var6;
        this.aLong124 = 0L;
        this.aBoolean125 = false;
        this.anImage122 = null;
        this.aBoolean123 = false;
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.aBoolean123) {
            if (!this.aBoolean125) {
                if (this.aLoadingPanel__116 != null) {
                    Image var2 = this.aLoadingPanel__116.method469();
                    if (var2 != null) {
                        Point var3 = this.getLocation();
                        var1.drawImage(var2, -var3.x, -var3.y, this);
                    }
                }

                var1.drawImage(this.anImage122, 0, 0, (ImageObserver) null);
                int var5 = this.aVector118.size();

                for (int var6 = 0; var6 < var5; ++var6) {
                    AdCanvasText var4 = (AdCanvasText) ((AdCanvasText) this.aVector118.elementAt(var6));
                    var4.method1548(var1);
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
        this.gameApplet.getAppletContext().showDocument(this.anURL119, this.aString120);
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    protected static AdCanvas method211(AApplet var0, Parameters var1) {
        try {
            String var2 = var1.getParameter("ad_image");
            URL var3 = new URL(var0.getCodeBase(), var2);
            Vector var4 = new Vector();

            String var6;
            for (int var5 = 1; (var6 = var1.getParameter("ad_text-" + var5)) != null; ++var5) {
                AdCanvasText var7 = AdCanvasText.method1547(var6);
                if (var7 != null) {
                    var4.addElement(var7);
                }
            }

            String var14 = var1.getParameter("ad_page");
            URL var8 = var14 != null ? new URL(var14) : null;
            String var9 = var1.getParameter("ad_target");
            if (var9 == null) {
                var9 = linkTarget;
            }

            int var10 = 10;
            String var11 = var1.getParameter("ad_mintime");
            if (var11 != null) {
                var10 = Integer.parseInt(var11);
            }

            AdCanvas var12 = new AdCanvas(var0, var3, var4, var8, var9, var10);
            return var12;
        } catch (Exception var13) {
            return null;
        }
    }

    protected void method212() {
        this.anImage122 = Toolkit.getDefaultToolkit().createImage(anURL117);//this.gameApplet.getImage(this.anURL117);
    }

    protected boolean method213() {
        if (this.aLong124 <= 0L) {
            this.aLong124 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() > this.aLong124 + 15000L) {
            this.aBoolean125 = true;
        }

        if (!this.aBoolean125 && !this.gameApplet.prepareImage(this.anImage122, (ImageObserver) null)) {
            return false;
        } else {
            if (!this.aBoolean125) {
                int var1 = this.anImage122.getWidth((ImageObserver) null);
                int var2 = this.anImage122.getHeight((ImageObserver) null);
                this.setSize(var1, var2);
            } else {
                this.setSize(20, 20);
            }

            if (this.anURL119 != null) {
                this.addMouseListener(this);
                this.setCursor(new Cursor(12));
            }

            this.aBoolean123 = true;
            return true;
        }
    }

    protected void method214(LoadingPanel var1) {
        this.aLoadingPanel__116 = var1;
        this.aLong126 = System.currentTimeMillis();
        this.repaint();
    }

    protected int method215() {
        if (this.aBoolean125) {
            return 0;
        } else {
            int var1 = (int) (System.currentTimeMillis() - this.aLong126);
            int var2 = this.anInt121 * 1000 - var1;
            return var2 < 0 ? 0 : var2;
        }
    }

    protected boolean method216() {
        if (this.anURL119 == null) {
            return false;
        } else {
            String var1 = this.aString120.toLowerCase();
            return var1.equals("_self") ? false : (var1.equals("_parent") ? false : !var1.equals("_top"));
        }
    }

    protected void method217() {
        this.aBoolean123 = false;
        this.removeMouseListener(this);
        if (this.anImage122 != null) {
            this.anImage122.flush();
            this.anImage122 = null;
        }

        this.anURL117 = this.anURL119 = null;
        this.aString120 = null;
        this.aLoadingPanel__116 = null;
        this.gameApplet = null;
    }
}
