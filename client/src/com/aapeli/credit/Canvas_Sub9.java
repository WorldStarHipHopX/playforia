package com.aapeli.credit;

import com.aapeli.client.ImageManager;
import com.aapeli.client.StringDraw;
import com.aapeli.credit.IPanel_Sub42;
import com.aapeli.tools.DelayRepaint;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class Canvas_Sub9 extends Canvas implements MouseMotionListener, MouseListener {

    private static final int[] anIntArray152;
    private static final int[] anIntArray153;
    private static final String[] aStringArray154;
    private static final Color[] aColorArray155;
    private static final Color aColor156;
    private static final Font aFont157;
    private static final Font aFont158;
    private ImageManager anImageManager159;
    private IPanel_Sub42 anIPanel_Sub42_160;
    private int anInt161;
    private String aString162;
    private boolean aBoolean163;
    private boolean aBoolean164;
    private boolean aBoolean165;
    private long aLong166;
    private Image anImage167;
    private Graphics aGraphics168;
    private static final String[] aStringArray169 = new String[5];


    protected Canvas_Sub9(ImageManager var1, IPanel_Sub42 var2, int var3, String var4, boolean var5, boolean var6) {
        this.anImageManager159 = var1;
        this.anIPanel_Sub42_160 = var2;
        this.anInt161 = var3;
        this.aString162 = var4;
        this.aBoolean163 = var5;
        this.setSize(anIntArray152[var3], anIntArray153[var3]);
        this.aLong166 = System.currentTimeMillis() + (long) (var6 ? 1250 : 0);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean164 = this.aBoolean165 = false;
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.anImage167 == null) {
            this.anImage167 = this.createImage(anIntArray152[this.anInt161], anIntArray153[this.anInt161]);
            this.aGraphics168 = this.anImage167.getGraphics();
        }

        boolean var2 = System.currentTimeMillis() >= this.aLong166;
        boolean var3 = false;
        Image var4 = this.anImageManager159.getShared("credit-background.jpg", true);
        if (var4 != null) {
            Point var5 = this.getLocation();
            this.aGraphics168.drawImage(var4, -var5.x, -var5.y, this);
        } else {
            var3 = true;
        }

        var4 = this.method225();
        if (var2) {
            if (var4 != null) {
                this.aGraphics168.drawImage(var4, 0, 0, this);
            } else {
                Color var6 = aColorArray155[this.anInt161].brighter();
                if (this.aBoolean164) {
                    var6 = var6.brighter();
                }

                this.aGraphics168.setColor(var6);
                this.aGraphics168.fillRect(0, 0, anIntArray152[this.anInt161], anIntArray153[this.anInt161]);
                this.aGraphics168.setColor(aColorArray155[this.anInt161]);
                this.aGraphics168.drawRect(0, 0, anIntArray152[this.anInt161] - 1, anIntArray153[this.anInt161] - 1);
                var3 = true;
            }
        }

        if (this.anInt161 == 1) {
            var4 = this.anImageManager159.getShared("credit-coins-btn.png", true);
            if (var2) {
                if (var4 != null) {
                    this.aGraphics168.drawImage(var4, 17, 3, this);
                } else {
                    var3 = true;
                }
            }
        }

        if (var2) {
            this.aGraphics168.setFont(this.anInt161 == 3 ? aFont158 : aFont157);
            this.aGraphics168.setColor(aColor156);
            StringDraw.drawOutlinedString(this.aGraphics168, aColorArray155[this.anInt161], this.aString162, anIntArray152[this.anInt161] / 2 + (this.anInt161 == 3 && this.aBoolean163 ? 8 : 0), anIntArray153[this.anInt161] / 2 + 7, 0);
        }

        var1.drawImage(this.anImage167, 0, 0, this);
        if (!var2 || var3) {
            new DelayRepaint(this);
        }

    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean164 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean164 = this.aBoolean165 = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean165 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean165;
        this.aBoolean165 = false;
        this.repaint();
        if (var2 && System.currentTimeMillis() >= this.aLong166) {
            this.method226();
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
    }

    protected int method223() {
        return anIntArray152[this.anInt161];
    }

    protected int method224() {
        return anIntArray153[this.anInt161];
    }

    private Image method225() {
        String var1 = aStringArray154[this.anInt161];
        if (this.anInt161 != 2) {
            var1 = var1 + "-" + (this.anInt161 != 1 && this.aBoolean163 ? "a" : "p");
        }

        if (this.aBoolean164) {
            var1 = var1 + "-hl";
        }

        var1 = var1 + ".png";
        return this.anImageManager159.getShared(var1, true);
    }

    private void method226() {
        ActionEvent var1 = new ActionEvent(this, 1001, this.aString162);
        this.anIPanel_Sub42_160.actionPerformed(var1);
    }

    static {
        aStringArray169[0] = ".png";
        aStringArray169[1] = "-hl";
        aStringArray169[2] = "credit-background.jpg";
        aStringArray169[3] = "credit-coins-btn.png";
        aStringArray169[4] = "Dialog";
        anIntArray152 = new int[]{304, 304, 304, 170};
        anIntArray153 = new int[]{42, 42, 42, 42};
        aStringArray154 = new String[4];
        aStringArray154[0] = "u wAbpF;4}_w v";
        aStringArray154[1] = "u wAbpF;4}_w v";
        aStringArray154[2] = "credit-btn-refresh";
        aStringArray154[3] = "credit-btn-return";
        aColorArray155 = new Color[]{new Color(7, 150, 6), new Color(7, 150, 6), new Color(54, 139, 128), new Color(191, 120, 14)};
        aColor156 = new Color(255, 255, 255);
        aFont157 = new Font("Dialog", 1, 20);
        aFont158 = new Font("Dialog", 1, 16);
    }

    private static char[] method227(String var0) {
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
                var10003[0] = (char) (var10003[0] ^ 40);
                break;
            }
        }

        return var10001;
    }

    private static String method228(char[] var0) {
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
                        var10005 = 22;
                        break;
                    case 1:
                        var10005 = 82;
                        break;
                    case 2:
                        var10005 = 18;
                        break;
                    case 3:
                        var10005 = 111;
                        break;
                    default:
                        var10005 = 40;
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
