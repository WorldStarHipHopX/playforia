package com.playray.applet;

import com.playray.applet.AApplet;
import com.playray.applet.SPanel_Sub35;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.GlossyButton;
import com.playray.colorgui.ProgressBarGlossy;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class SPanel_Sub37 extends SPanel implements Runnable, ActionListener {

    private static final Font aFont4220;
    private static final Font aFont4221;
    private AApplet anAApplet4222;
    private ProgressBarGlossy aProgressBarGlossy4223;
    private SPanel_Sub35 aSPanel_Sub35_4224;
    private String aString4225;
    private double aDouble4226;
    private double aDouble4227;
    private double aDouble4228;
    private int anInt4229;
    private boolean aBoolean4230;
    private boolean aBoolean4231;
    private boolean aBoolean4232;
    private boolean aBoolean4233;
    private GlossyButton aGlossyButton4234;
    private GlossyButton aGlossyButton4235;
    private int anInt4236;
    private Object anObject4237;
    private static final String[] aStringArray4238 = new String[3];


    protected SPanel_Sub37(AApplet var1) {
        this.anAApplet4222 = var1;
        this.aString4225 = null;
        this.aDouble4226 = this.aDouble4227 = 0.0D;
        this.aDouble4228 = 0.0018D;
        this.anInt4229 = 50;
        this.aBoolean4230 = true;
        this.aBoolean4231 = false;
        this.aBoolean4232 = false;
        this.anInt4236 = -1;
        this.anObject4237 = new Object();
        this.aProgressBarGlossy4223 = new ProgressBarGlossy(1);
        int var2 = Math.min(450, var1.anInt2601 - 5 - 5);
        this.aProgressBarGlossy4223.setBounds(var1.anInt2601 / 2 - var2 / 2, var1.anInt2602 / 2 - 40, var2, 40);
        this.add(this.aProgressBarGlossy4223);
    }

    public void paintContent(Graphics2D var1) {
        Object var2 = this.anObject4237;
        synchronized (this.anObject4237) {
            if (!this.aBoolean4232) {
                Color var3 = this.anAApplet4222.getBackground();
                if (var3.equals(Color.black)) {
                    var3 = new Color(24, 24, 24);
                }

                this.method2794(var1, var3, 0, 32, 0, this.anAApplet4222.anInt2602, 0, this.anAApplet4222.anInt2601);
                if (this.aBoolean4230) {
                    this.setBackground(this.getBufferImage());
                    this.aBoolean4230 = false;
                }

                if (this.aString4225 != null && this.anInt4236 == -1) {
                    var1.setFont(aFont4220);
                    var1.setColor(this.getForeground());
                    Point var4 = this.aProgressBarGlossy4223.getLocation();
                    StringDraw.drawString(var1, this.aString4225, var4.x + this.aProgressBarGlossy4223.getSize().width / 2, var4.y - (this.aSPanel_Sub35_4224 == null ? 10 : 6), 0);
                }

                if (this.aSPanel_Sub35_4224 != null) {
                    this.aSPanel_Sub35_4224.repaint();
                }

            }
        }
    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        this.repaint();
    }

    public void updateUI(Object var1) {
        int var2 = ((Integer) ((Integer) var1)).intValue();
        int var4;
        int var5;
        if (var2 == 1) {
            this.aProgressBarGlossy4223.setBounds(this.aProgressBarGlossy4223.getLocation().x, 25, this.aProgressBarGlossy4223.getSize().width, 17);
            Dimension var3 = this.aSPanel_Sub35_4224.getSize();
            var4 = this.anAApplet4222.anInt2601 - 5 - 5;
            var5 = this.anAApplet4222.anInt2602 - 5 - 5 - 42;
            this.aSPanel_Sub35_4224.setLocation(5 + var4 / 2 - var3.width / 2, 47 + var5 / 2 - var3.height / 2);
            this.add(this.aSPanel_Sub35_4224);
        } else if (var2 == 2) {
            this.remove(this.aProgressBarGlossy4223);
            short var6 = 300;
            var4 = (this.anAApplet4222.anInt2601 - 25 - 15 - 15 - 25) / 2;
            var5 = Math.min(var6, var4);
            this.aGlossyButton4234 = new GlossyButton(this.anAApplet4222.aTextManager3821.getShared("Loader_Button_StartGame"), 1);
            this.aGlossyButton4234.setBounds(this.anAApplet4222.anInt2601 / 2 + 15, 10, var5, 35);
            this.aGlossyButton4234.setFont(aFont4221);
            this.aGlossyButton4234.addActionListener(this);
            this.add(this.aGlossyButton4234);
            if (this.anAApplet4222.param.isCreditPurchasePageAvailable()) {
                this.aGlossyButton4235 = new GlossyButton(this.anAApplet4222.aTextManager3821.getShared("Loader_Button_MorePaymentOptions"), 3);
                this.aGlossyButton4235.setBounds(this.anAApplet4222.anInt2601 / 2 - 15 - var5, 10, var5, 35);
                this.aGlossyButton4235.setFont(aFont4221);
                this.aGlossyButton4235.addActionListener(this);
                this.add(this.aGlossyButton4235);
            }
        } else if (var2 == 3) {
            this.remove(this.aGlossyButton4234);
        }

    }

    public void run() {
        long var1 = System.currentTimeMillis();
        boolean var3 = false;

        do {
            try {
                Thread.sleep((long) this.anInt4229);
            } catch (InterruptedException var6) {
                ;
            }

            if (this.aBoolean4232) {
                return;
            }

            boolean var4 = false;
            if (this.aDouble4227 < this.aDouble4226) {
                this.aDouble4227 += this.method2796();
                if (this.aDouble4227 > 1.0D) {
                    this.aDouble4227 = 1.0D;
                }

                var4 = true;
            }

            if (this.aDouble4226 >= 1.0D && this.anAApplet4222.isDebug()) {
                ;
            }

            if (!var3 && System.currentTimeMillis() > var1 + 5000L) {
                this.aProgressBarGlossy4223.startGlowIndicator();
                var3 = true;
            }

            if (var4) {
                this.aProgressBarGlossy4223.setProgress(this.aDouble4227);
            }
        } while (this.aDouble4227 < 1.0D);

        this.aProgressBarGlossy4223.stopGlowIndicator();
        this.aBoolean4231 = true;
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aGlossyButton4234) {
            this.anInt4236 = 1;
        } else if (var2 == this.aGlossyButton4235) {
            this.anAApplet4222.setEndState(8);
            this.anAApplet4222.param.showCreditPurchasePage(false);
        }

    }

    protected void method2784() {
        Thread var1 = new Thread(this);
        var1.start();
    }

    protected void method2785(String var1) {
        this.aString4225 = var1;
        this.repaint();
    }

    protected void method2786(double var1) {
        this.aDouble4226 += var1;
    }

    protected void method2787(SPanel_Sub35 var1, boolean var2) {
        this.aSPanel_Sub35_4224 = var1;
        this.aBoolean4233 = var2;
        this.callUpdateUI(new Integer(1));
        var1.method2778();
        this.repaint();
    }

    protected void method2788(double var1) {
        this.aDouble4226 = var1;
    }

    protected void method2789(double var1) {
        this.aDouble4228 *= var1;
    }

    protected void method2790() {
        this.anInt4229 = 25;
    }

    protected boolean method2791() {
        return this.aBoolean4231;
    }

    protected void method2792() {
        if (this.aSPanel_Sub35_4224 != null) {
            if (this.aBoolean4233) {
                this.callUpdateUI(new Integer(2));
                this.anInt4236 = 0;
                this.repaint();

                do {
                    Tools.sleep(25L);
                } while (this.anInt4236 == 0 && !this.aBoolean4232);

                this.callUpdateUI(new Integer(3));
            }
        }
    }

    protected void method2793() {
        Object var1 = this.anObject4237;
        synchronized (this.anObject4237) {
            this.aBoolean4232 = true;
            if (this.aSPanel_Sub35_4224 != null) {
                this.remove(this.aSPanel_Sub35_4224);
                this.aSPanel_Sub35_4224.method2781();
                this.aSPanel_Sub35_4224 = null;
            }

            this.aString4225 = null;
        }
    }

    private void method2794(Graphics var1, Color var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = var2.getRed();
        int var10 = var2.getGreen();
        int var11 = var2.getBlue();
        int var12 = var9 + var3;
        int var13 = var10 + var3;
        int var14 = var11 + var3;
        int var15 = var9 - var4;
        int var16 = var10 - var4;
        int var17 = var11 - var4;
        if (var12 > 255) {
            var12 = 255;
        }

        if (var13 > 255) {
            var13 = 255;
        }

        if (var14 > 255) {
            var14 = 255;
        }

        if (var15 < 0) {
            var15 = 0;
        }

        if (var16 < 0) {
            var16 = 0;
        }

        if (var17 < 0) {
            var17 = 0;
        }

        this.method2795(var1, var5, var6, var7, var8, var12, var15, var13, var16, var14, var17);
    }

    private void method2795(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
        int var20 = -1;

        for (int var21 = var2; var21 < var3; ++var21) {
            double var12 = 1.0D * (double) (var21 - var2) / (double) (var3 - var2);

            for (int var22 = var4; var22 < var5; ++var22) {
                double var14;
                if (var22 == var4) {
                    var14 = 0.0D;
                } else {
                    var14 = Math.random() * 1.98D - 0.99D;
                }

                int var16 = (int) ((double) var6 + (double) (var7 - var6) * var12 + var14);
                int var17 = (int) ((double) var8 + (double) (var9 - var8) * var12 + var14);
                int var18 = (int) ((double) var10 + (double) (var11 - var10) * var12 + var14);
                int var19 = var16 * 256 * 256 + var17 * 256 + var18;
                if (var22 == var4) {
                    var20 = var19;
                    var1.setColor(new Color(var19));
                    var1.drawLine(var4, var21, var5, var21);
                } else if (var19 != var20) {
                    var1.setColor(new Color(var19));
                    var1.fillRect(var22, var21, 1, 1);
                }
            }
        }

    }

    private double method2796() {
        if (this.aSPanel_Sub35_4224 == null) {
            return this.aDouble4228;
        } else {
            int var1 = this.aSPanel_Sub35_4224.method2779();
            if (var1 <= 0) {
                return this.aDouble4228;
            } else {
                double var2 = 1.0D - this.aDouble4227;
                double var4 = var2 * (double) this.anInt4229 / (double) var1;
                return var4 > this.aDouble4228 ? this.aDouble4228 : var4;
            }
        }
    }

    static {
        aStringArray4238[0] = "Loader_Button_MorePaymentOptions";
        aStringArray4238[1] = "Loader_Button_StartGame";
        aStringArray4238[2] = "Dialog";
        aFont4220 = new Font("Dialog", 0, 14);
        aFont4221 = new Font("Dialog", 1, 20);
    }
}
