package com.aapeli.colorgui;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.Class90;
import com.aapeli.colorgui.Class94;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.util.Enumeration;
import java.util.Vector;

public class ColorButton extends IPanel implements MouseMotionListener, MouseListener {

    public static final int BORDER_NONE = 0;
    public static final int BORDER_NORMAL = 1;
    public static final int BORDER_THICK = 2;
    private static final Color aColor3253;
    private Color aColor3254;
    private Color aColor3255;
    private Color aColor3256;
    private Color aColor3257;
    private Color aColor3258;
    private Color aColor3259;
    private Image anImage3260;
    private Image anImage3261;
    private Image anImage3262;
    private Image anImage3263;
    private Image anImage3264;
    private int anInt3265;
    private int anInt3266;
    private int anInt3267;
    private int anInt3268;
    private int anInt3269;
    private int anInt3270;
    private boolean aBoolean3271;
    private String aString3272;
    private String aString3273;
    private Font aFont3274;
    private Font aFont3275;
    private boolean aBoolean3276;
    private boolean aBoolean3277;
    private boolean aBoolean3278;
    private int anInt3279;
    private Vector aVector3280;
    private Image anImage3281;
    private Graphics aGraphics3282;
    private int anInt3283;
    private int anInt3284;
    private Class90 aClass90_3285;
    private boolean aBoolean3286;
    public static boolean aBoolean3287;
    private static final String[] aStringArray3288 = new String[2];


    public ColorButton() {
        this((String) null);
    }

    public ColorButton(String var1) {
        this.setBackground(aColor3253);
        this.setForeground(Class94.aColor1576);
        this.setFont(Class94.aFont1575);
        this.setLabel(var1);
        this.setSecondaryFont(new Font("Dialog", 0, 11));
        this.setSecondaryLabel((String) null);
        this.aBoolean3276 = true;
        this.aBoolean3277 = this.aBoolean3278 = false;
        this.anInt3279 = 1;
        this.aVector3280 = new Vector();
        this.aClass90_3285 = null;
        this.aBoolean3286 = false;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean3277 = this.aBoolean3278 = false;
        this.repaint();
    }

    public void update(Graphics var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (this.anImage3281 == null || var3 != this.anInt3283 || var4 != this.anInt3284) {
            this.anImage3281 = this.createBuffer(var3, var4);
            this.aGraphics3282 = this.anImage3281.getGraphics();
            this.graphicsCreated(this.aGraphics3282);
            this.anInt3283 = var3;
            this.anInt3284 = var4;
        }

        this.drawBackground(this.aGraphics3282);
        this.baseBackgroundDrawn(this.aGraphics3282);
        boolean var5 = this.isHighlighted();
        if (this.anImage3260 != null && this.anImage3261 != null) {
            Image var17 = var5 ? this.anImage3261 : this.anImage3260;
            if (!this.aBoolean3271) {
                this.aGraphics3282.drawImage(var17, 0, 0, var3, var4, this.anInt3265, this.anInt3266, this.anInt3265 + var3, this.anInt3266 + var4, this);
            } else {
                this.aGraphics3282.drawImage(var17, 0, 0, var3, var4, this);
            }
        } else {
            Color var6 = var5 ? this.aColor3256 : this.aColor3254;
            if (this.aBoolean3276) {
                this.method827(this.aGraphics3282, var6, var3, var4);
            } else {
                this.aGraphics3282.setColor(var6);
                this.clearBackground(this.aGraphics3282, var3, var4);
            }
        }

        if (this.aColor3259 != null) {
            this.aGraphics3282.setColor(this.aColor3259);
        }

        this.drawBorder(this.aGraphics3282, var3, var4);
        if (this.anImage3262 != null) {
            this.aGraphics3282.drawImage(this.isNormalState() ? this.anImage3262 : this.anImage3263, this.anInt3267 > 0 ? var3 / 2 - this.anInt3267 / 2 : 0, this.anInt3268 > 0 ? var4 / 2 - this.anInt3268 / 2 : 0, this);
        }

        int var16 = var3 / 2;
        int var7 = 0;
        int var8;
        int var9;
        if (this.anImage3264 != null) {
            var8 = (var4 - this.anInt3270) / 2;
            var9 = this.drawIcon(this.aGraphics3282, this.anImage3264, var8);
            var16 = var3 / 2 + var8 + this.anInt3269 / 2 - 1;
            var7 = var9 + this.anInt3269 + 1;
        }

        if (this.aString3272 != null) {
            this.aGraphics3282.setColor(this.aColor3255);
            if (this.aString3273 == null) {
                Font var18 = this.method830(this.method829(this.aFont3274), this.aString3272, var3 - 2);
                this.aGraphics3282.setFont(var18);
                var9 = var16 - this.getFontMetrics(var18).stringWidth(this.aString3272) / 2;
                if (var9 < var7) {
                    var9 = var7;
                }

                this.aGraphics3282.drawString(this.aString3272, var9, var4 / 2 + var18.getSize() * 3 / 8 + 1);
            } else {
                var8 = this.aFont3274.getSize();
                var9 = this.aFont3275.getSize();
                if (var9 > var8) {
                    var8 = var9;
                }

                String var10 = this.aString3272 + "  ";
                String var11 = "  " + this.aString3273;
                Font var12 = this.method830(this.method829(this.aFont3274), var10 + var11, var3 - 2);
                Font var13 = this.method830(this.method829(this.aFont3275), var10 + var11, var3 - 2);
                int var14 = this.getFontMetrics(var12).stringWidth(var10);
                int var15 = this.getFontMetrics(var13).stringWidth(var11);
                this.aGraphics3282.setFont(var12);
                this.aGraphics3282.drawString(var10, var16 - (var14 + var15) / 2, var4 / 2 + var8 * 3 / 8 + 1);
                this.aGraphics3282.setFont(var13);
                this.aGraphics3282.drawString(var11, var16 - (var14 + var15) / 2 + var14, var4 / 2 + var8 * 3 / 8 + 1);
            }
        }

        var1.drawImage(this.anImage3281, 0, 0, this);
    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean3277 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean3277 = this.aBoolean3278 = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean3278 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean3278;
        this.aBoolean3278 = false;
        this.repaint();
        if (var2) {
            this.processActionEvent();
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
    }

    public void setBackground(Color var1) {
        if (var1 == null) {
            var1 = aColor3253;
        }

        super.setBackground(var1);
        this.aColor3254 = var1;
        this.aColor3256 = this.method826(var1, 32);
        this.aColor3257 = this.method826(var1, 48);
        this.aColor3258 = this.method826(var1, -48);
        this.repaint();
    }

    public void setBackgroundFade(boolean var1) {
        this.aBoolean3276 = var1;
    }

    public void setForeground(Color var1) {
        if (var1 == null) {
            var1 = Class94.aColor1576;
        }

        this.aColor3255 = var1;
        this.repaint();
    }

    public void setBackgroundImage(Image var1) {
        this.setBackgroundImage(var1, var1, 0, 0);
    }

    public void setBackgroundImage(Image var1, Image var2) {
        this.setBackgroundImage(var1, var2, 0, 0);
    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        this.setBackgroundImage(var1, var1, var2, var3);
    }

    public void setBackgroundImage(Image var1, Image var2, int var3, int var4) {
        this.anImage3260 = var1;
        this.anImage3261 = var2;
        this.anInt3265 = var3;
        this.anInt3266 = var4;
        this.aBoolean3271 = false;
        this.repaint();
    }

    public void setFittedBackgroundImage(Image var1, Image var2) {
        this.anImage3260 = var1;
        this.anImage3261 = var2;
        this.aBoolean3271 = true;
        this.repaint();
    }

    public void setForegroundImage(Image var1) {
        this.setForegroundImage(var1, var1, 0, 0);
    }

    public void setForegroundImage(Image var1, Image var2) {
        this.setForegroundImage(var1, var2, 0, 0);
    }

    public void setForegroundImage(Image var1, int var2, int var3) {
        this.setForegroundImage(var1, var1, var2, var3);
    }

    public void setForegroundImage(Image var1, Image var2, int var3, int var4) {
        this.anImage3262 = var1;
        this.anImage3263 = var2;
        this.anInt3267 = var3;
        this.anInt3268 = var4;
        this.repaint();
    }

    public void setIconImage(Image var1) {
        if (var1 != null) {
            this.setIconImage(var1, var1.getWidth((ImageObserver) null), var1.getHeight((ImageObserver) null));
        } else {
            this.setIconImage((Image) null, -1, -1);
        }

    }

    public void setIconImage(Image var1, int var2, int var3) {
        this.anImage3264 = var1;
        this.anInt3269 = var2;
        this.anInt3270 = var3;
        this.repaint();
    }

    public void setFont(Font var1) {
        this.aFont3274 = var1;
        this.repaint();
    }

    public void setLabel(String var1) {
        this.aString3272 = var1;
        this.repaint();
    }

    public String getLabel() {
        return this.aString3272;
    }

    public void setSecondaryFont(Font var1) {
        this.aFont3275 = var1;
        this.repaint();
    }

    public void setSecondaryLabel(String var1) {
        if (var1 != this.aString3273) {
            this.aString3273 = var1;
            this.repaint();
        }
    }

    public String getSecondaryLabel() {
        return this.aString3273;
    }

    public void setBorder(int var1) {
        this.anInt3279 = var1;
    }

    public int getBorder() {
        return this.anInt3279;
    }

    public void setBorderColor(Color var1) {
        this.aColor3259 = var1;
        this.repaint();
    }

    public void click() {
        this.aBoolean3278 = true;
        this.mouseReleased((MouseEvent) null);
    }

    public Dimension getPreferredSize() {
        return new Dimension(13 + this.getFontMetrics(this.aFont3274).stringWidth(this.aString3272) + 13, 5 + this.aFont3274.getSize() + 5);
    }

    public void addActionListener(ActionListener var1) {
        Vector var2 = this.aVector3280;
        synchronized (this.aVector3280) {
            this.aVector3280.addElement(var1);
        }
    }

    public void removeActionListener(ActionListener var1) {
        Vector var2 = this.aVector3280;
        synchronized (this.aVector3280) {
            this.aVector3280.removeElement(var1);
        }
    }

    public void setFlashing(boolean var1) {
        if (var1) {
            if (this.aClass90_3285 != null) {
                return;
            }

            this.aClass90_3285 = new Class90(this, this);
            Thread var2 = new Thread(this.aClass90_3285);
            var2.setDaemon(true);
            var2.start();
        } else {
            if (this.aClass90_3285 == null) {
                return;
            }

            this.aClass90_3285.method1738();
            this.aClass90_3285 = null;
            this.aBoolean3286 = false;
            this.repaint();
        }

    }

    public Image createBuffer(int var1, int var2) {
        return this.createImage(var1, var2);
    }

    public void graphicsCreated(Graphics var1) {
    }

    public void baseBackgroundDrawn(Graphics var1) {
    }

    public boolean isNormalState() {
        return !this.aBoolean3278;
    }

    public void processActionEvent() {
        Vector var1 = this.aVector3280;
        synchronized (this.aVector3280) {
            if (this.aVector3280.size() != 0) {
                ActionEvent var2 = new ActionEvent(this, 1001, this.aString3272);
                Enumeration var3 = this.aVector3280.elements();

                while (var3.hasMoreElements()) {
                    ((ActionListener) ((ActionListener) var3.nextElement())).actionPerformed(var2);
                }

            }
        }
    }

    public boolean isHighlighted() {
        boolean var1 = this.aBoolean3277;
        if (this.aClass90_3285 != null && this.aBoolean3286) {
            var1 = !var1;
        }

        return var1;
    }

    public boolean isBolded() {
        return false;
    }

    public void clearBackground(Graphics var1, int var2, int var3) {
        var1.fillRect(0, 0, var2, var3);
    }

    public void drawBorder(Graphics var1, int var2, int var3) {
        if (this.anInt3279 != 0) {
            boolean var4 = this.isNormalState();
            boolean var5 = this.anInt3279 == 1;
            if (this.aColor3259 == null) {
                var1.setColor(var4 ? this.aColor3258 : this.aColor3257);
            }

            if (var5) {
                var1.drawRect(0, 0, var2 - 1, var3 - 1);
            } else {
                var1.drawRect(0, 0, var2 - 1, var3 - 1);
                var1.drawRect(1, 1, var2 - 3, var3 - 3);
            }

            if (this.aColor3259 == null) {
                var1.setColor(var4 ? this.aColor3257 : this.aColor3258);
            }

            if (var5) {
                var1.drawLine(0, 0, var2 - 1, 0);
                var1.drawLine(0, 0, 0, var3 - 1);
            } else {
                var1.drawLine(0, 0, var2 - 2, 0);
                var1.drawLine(0, 1, var2 - 3, 1);
                var1.drawLine(0, 0, 0, var3 - 1);
                var1.drawLine(1, 0, 1, var3 - 2);
            }

        }
    }

    public int drawIcon(Graphics var1, Image var2, int var3) {
        var1.drawImage(var2, var3, var3, this);
        return var3;
    }

    public Color[] getLightAndDarkBorderColors() {
        return new Color[]{this.aColor3257, this.aColor3258};
    }

    private Color method826(Color var1, int var2) {
        int var3 = var1.getRed() + var2;
        int var4 = var1.getGreen() + var2;
        int var5 = var1.getBlue() + var2;
        if (var3 < 0) {
            var3 = 0;
        } else if (var3 > 255) {
            var3 = 255;
        }

        if (var4 < 0) {
            var4 = 0;
        } else if (var4 > 255) {
            var4 = 255;
        }

        if (var5 < 0) {
            var5 = 0;
        } else if (var5 > 255) {
            var5 = 255;
        }

        return new Color(var3, var4, var5);
    }

    private void method827(Graphics var1, Color var2, int var3, int var4) {
        byte var5 = 0;
        if (this.anInt3279 != 0) {
            var5 = 1;
        }

        int var6 = var2.getRed();
        int var7 = var2.getGreen();
        int var8 = var2.getBlue();
        int var9 = var6;
        int var10 = var7;
        int var11 = var8;

        int var12;
        for (var12 = var4 / 2; var12 >= var5; --var12) {
            var1.setColor(new Color(var9, var10, var11));
            var1.drawLine(var5, var12, var3 - 1 - var5, var12);
            var9 = this.method828(var9, 3);
            var10 = this.method828(var10, 3);
            var11 = this.method828(var11, 3);
        }

        var9 = var6;
        var10 = var7;
        var11 = var8;

        for (var12 = var4 / 2 + 1; var12 < var4 - var5; ++var12) {
            var9 = this.method828(var9, -3);
            var10 = this.method828(var10, -3);
            var11 = this.method828(var11, -3);
            var1.setColor(new Color(var9, var10, var11));
            var1.drawLine(var5, var12, var3 - 1 - var5, var12);
        }

    }

    private int method828(int var1, int var2) {
        var1 += var2;
        if (var1 < 0) {
            var1 = 0;
        } else if (var1 > 255) {
            var1 = 255;
        }

        return var1;
    }

    private Font method829(Font var1) {
        return this.isBolded() ? new Font(var1.getName(), 1, var1.getSize()) : var1;
    }

    private Font method830(Font var1, String var2, int var3) {
        int var4 = this.getFontMetrics(var1).stringWidth(var2);
        if (var4 <= var3) {
            return var1;
        } else {
            int var7 = var1.getSize();

            do {
                Font var5 = var1;
                int var6 = var4;
                --var7;
                var1 = new Font(var1.getName(), var1.getStyle(), var7);
                var4 = this.getFontMetrics(var1).stringWidth(var2);
                if (var4 >= var6) {
                    return var5;
                }
            } while (var4 > var3 && var7 > 9);

            return var1;
        }
    }

    public void innerSetFlashState(boolean var1) {
        this.aBoolean3286 = var1;
        this.repaint();
    }

    static {
        aStringArray3288[0] = "Dialog";
        aStringArray3288[1] = "  ";
        aColor3253 = new Color(192, 192, 192);
    }
}
