package com.playray.credit;

import com.playray.client.ImageManager;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.credit.SPanel_Sub43;
import com.playray.tools.DelayRepaint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class SPanel_Sub44 extends SPanel implements MouseMotionListener, MouseListener {

    private static final int[] anIntArray4572;
    private static final int[] anIntArray4573;
    private static final String[] aStringArray4574;
    private static final Color[] aColorArray4575;
    private static final Color aColor4576;
    private static final Font aFont4577;
    private static final Font aFont4578;
    private ImageManager anImageManager4579;
    private SPanel_Sub43 aSPanel_Sub43_4580;
    private int anInt4581;
    private String aString4582;
    private boolean aBoolean4583;
    private boolean aBoolean4584;
    private boolean aBoolean4585;
    private long aLong4586;
    private static final String[] aStringArray4587 = new String[5];


    protected SPanel_Sub44(ImageManager var1, SPanel_Sub43 var2, int var3, String var4, boolean var5, boolean var6) {
        this.anImageManager4579 = var1;
        this.aSPanel_Sub43_4580 = var2;
        this.anInt4581 = var3;
        this.aString4582 = var4;
        this.aBoolean4583 = var5;
        this.setSize(anIntArray4572[var3], anIntArray4573[var3]);
        this.aLong4586 = System.currentTimeMillis() + (long) (var6 ? 1250 : 0);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean4584 = this.aBoolean4585 = false;
        this.repaint();
    }

    public void paintContent(Graphics2D var1) {
        boolean var2 = System.currentTimeMillis() >= this.aLong4586;
        boolean var3 = false;
        Image var4 = this.anImageManager4579.getShared("credit-background.jpg", true);
        if (var4 != null) {
            Point var5 = this.getLocation();
            var1.drawImage(var4, -var5.x, -var5.y, this);
        } else {
            var3 = true;
        }

        var4 = this.method2937();
        if (var2) {
            if (var4 != null) {
                var1.drawImage(var4, 0, 0, this);
            } else {
                Color var6 = aColorArray4575[this.anInt4581].brighter();
                if (this.aBoolean4584) {
                    var6 = var6.brighter();
                }

                var1.setColor(var6);
                var1.fillRect(0, 0, anIntArray4572[this.anInt4581], anIntArray4573[this.anInt4581]);
                var1.setColor(aColorArray4575[this.anInt4581]);
                var1.drawRect(0, 0, anIntArray4572[this.anInt4581] - 1, anIntArray4573[this.anInt4581] - 1);
                var3 = true;
            }
        }

        if (this.anInt4581 == 1) {
            var4 = this.anImageManager4579.getShared("credit-coins-btn.png", true);
            if (var2) {
                if (var4 != null) {
                    var1.drawImage(var4, 17, 3, this);
                } else {
                    var3 = true;
                }
            }
        }

        if (var2) {
            var1.setFont(this.anInt4581 == 3 ? aFont4578 : aFont4577);
            var1.setColor(aColor4576);
            StringDraw.drawOutlinedString(var1, aColorArray4575[this.anInt4581], this.aString4582, anIntArray4572[this.anInt4581] / 2 + (this.anInt4581 == 3 && this.aBoolean4583 ? 8 : 0), anIntArray4573[this.anInt4581] / 2 + 7, 0);
        }

        if (!var2 || var3) {
            new DelayRepaint(this);
        }

    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean4584 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean4584 = this.aBoolean4585 = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean4585 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean4585;
        this.aBoolean4585 = false;
        this.repaint();
        if (var2 && System.currentTimeMillis() >= this.aLong4586) {
            this.method2938();
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
    }

    protected int method2935() {
        return anIntArray4572[this.anInt4581];
    }

    protected int method2936() {
        return anIntArray4573[this.anInt4581];
    }

    private Image method2937() {
        String var1 = aStringArray4574[this.anInt4581];
        if (this.anInt4581 != 2) {
            var1 = var1 + "-" + (this.anInt4581 != 1 && this.aBoolean4583 ? "a" : "p");
        }

        if (this.aBoolean4584) {
            var1 = var1 + "-hl";
        }

        var1 = var1 + ".png";
        return this.anImageManager4579.getShared(var1, true);
    }

    private void method2938() {
        ActionEvent var1 = new ActionEvent(this, 1001, this.aString4582);
        this.aSPanel_Sub43_4580.actionPerformed(var1);
    }

    static {
        aStringArray4587[0] = "credit-background.jpg";
        aStringArray4587[1] = "credit-coins-btn.png";
        aStringArray4587[2] = "-hl";
        aStringArray4587[3] = ".png";
        aStringArray4587[4] = "Dialog";
        anIntArray4572 = new int[]{304, 304, 304, 170};
        anIntArray4573 = new int[]{42, 42, 42, 42};
        aStringArray4574 = new String[4];
        aStringArray4574[0] = "SOB6DE1[H\b(QOC";
        aStringArray4574[1] = "SOB6DE1[H\b(QOC";
        aStringArray4574[2] = "credit-btn-refresh";
        aStringArray4574[3] = "credit-btn-return";
        aColorArray4575 = new Color[]{new Color(7, 150, 6), new Color(7, 150, 6), new Color(54, 139, 128), new Color(191, 120, 14)};
        aColor4576 = new Color(255, 255, 255);
        aFont4577 = new Font("Dialog", 1, 20);
        aFont4578 = new Font("Dialog", 1, 16);
    }

    private static char[] method2939(String var0) {
        char[] var10000 = var0.toCharArray();
        char[] var10001 = var10000;

        while (true) {
            int var10002 = var10001.length;
            var10001 = var10000;
            int var4 = var10002;
            if (var10002 >= 2) {
                break;
            }

            char[] var1 = var10001;
            int var2 = var4;
            var10000 = var1;
            char[] var10003 = var1;
            var10002 = var2;
            var10001 = var10003;
            if (var10002 != 0) {
                var10001 = var10000;
                boolean var3 = false;
                var10003[0] = (char) (var10003[0] ^ 95);
                break;
            }
        }

        return var10001;
    }

    private static String method2940(char[] var0) {
        int var10000 = var0.length;
        int var1 = 0;
        char[] var10001 = var0;
        if (var10000 > 1) {
            var10001 = var0;
            if (var10000 <= var1) {
                return (new String(var0)).intern();
            }
        }

        do {
            char[] var10002 = var10001;
            int var10003 = var1;

            while (true) {
                char var10004 = var10002[var10003];
                byte var10005;
                switch (var1 % 5) {
                    case 0:
                        var10005 = 48;
                        break;
                    case 1:
                        var10005 = 61;
                        break;
                    case 2:
                        var10005 = 39;
                        break;
                    case 3:
                        var10005 = 122;
                        break;
                    default:
                        var10005 = 95;
                }

                var10002[var10003] = (char) (var10004 ^ var10005);
                ++var1;
                if (var10000 != 0) {
                    break;
                }

                var10003 = var10000;
                var10002 = var10001;
            }
        } while (var10000 > var1);

        return (new String(var10001)).intern();
    }
}
