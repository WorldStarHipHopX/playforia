package com.aapeli.colorgui;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.Class95;

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

public class RoundButton extends IPanel implements MouseMotionListener, MouseListener {

    private static final Color aColor3379 = new Color(224, 224, 224);
    private static final Color aColor3380 = new Color(0, 0, 0);
    private static final Color aColor3381 = new Color(255, 255, 255);
    private static final Font aFont3382 = new Font("Dialog", 0, 12);
    private Color aColor3383;
    private Color aColor3384;
    private Color aColor3385;
    private Color aColor3386;
    private String aString3387;
    private Font aFont3388;
    private String aString3389;
    private Font aFont3390;
    private Image anImage3391;
    private Image anImage3392;
    private boolean aBoolean3393;
    private boolean aBoolean3394;
    private Vector aVector3395;
    private Image anImage3396;
    private Graphics aGraphics3397;
    private int anInt3398;
    private int anInt3399;
    private Class95 aClass95_3400;
    private boolean aBoolean3401;
    private static final String aString3402 = "Dialog";


    public RoundButton() {
        this((String) null, (Image) null, (Image) null);
    }

    public RoundButton(String var1) {
        this(var1, (Image) null, (Image) null);
    }

    public RoundButton(String var1, Image var2) {
        this(var1, var2, (Image) null);
    }

    public RoundButton(String var1, Image var2, Image var3) {
        this.setBackground(aColor3379);
        this.setForeground(aColor3380);
        this.setBorderColor(aColor3381);
        this.setFont(aFont3382);
        this.setLabel(var1);
        this.setSecondaryFont(aFont3382);
        this.setSecondaryLabel((String) null);
        this.anImage3391 = var2;
        this.anImage3392 = var3;
        this.aBoolean3393 = this.aBoolean3394 = false;
        this.aVector3395 = new Vector();
        this.aClass95_3400 = null;
        this.aBoolean3401 = false;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean3393 = this.aBoolean3394 = false;
        this.repaint();
    }

    public void update(Graphics var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (this.anImage3396 == null || var3 != this.anInt3398 || var4 != this.anInt3399) {
            this.anImage3396 = this.createBuffer(var3, var4);
            this.aGraphics3397 = this.anImage3396.getGraphics();
            this.anInt3398 = var3;
            this.anInt3399 = var4;
        }

        boolean var5 = this.isEnabled();
        this.drawBackground(this.aGraphics3397);
        if (this.anImage3391 == null) {
            Color var6 = this.aBoolean3393 && var5 ? this.aColor3385 : this.aColor3383;
            if (this.aClass95_3400 != null) {
                var6 = this.method874(var6, this.aBoolean3401 ? 32 : -32);
            }

            this.method871(this.aGraphics3397, var6, var3, var4, var5);
        } else {
            this.aGraphics3397.drawImage(this.aBoolean3393 && var5 ? this.anImage3392 : this.anImage3391, 0, 0, this);
        }

        if (this.aString3387 != null) {
            this.aGraphics3397.setColor(var5 ? this.aColor3384 : this.method873(this.aColor3384, this.aColor3383, 0.25D));
            Font var11 = this.method875(this.aFont3388, this.aString3387, var3 - 2);
            Font var7 = null;
            int var8 = var4 / 2 + var11.getSize() * 3 / 8 + 1;
            int var9 = -1;
            if (this.aString3389 != null) {
                var7 = this.method875(this.aFont3390, this.aString3389, var3 - 2);
                int var10 = (var4 - var11.getSize() - var7.getSize()) / 3;
                var8 = var10 + var11.getSize();
                var9 = var4 - var10 - var7.getSize() / 8 - 1;
            }

            this.aGraphics3397.setFont(var11);
            this.drawText(this.aGraphics3397, this.aString3387, var3 / 2 - this.getFontMetrics(var11).stringWidth(this.aString3387) / 2, var8);
            if (this.aString3389 != null) {
                this.aGraphics3397.setFont(var7);
                this.drawText(this.aGraphics3397, this.aString3389, var3 / 2 - this.getFontMetrics(var7).stringWidth(this.aString3389) / 2, var9);
            }
        }

        var1.drawImage(this.anImage3396, 0, 0, this);
    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean3393 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean3393 = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean3394 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean3394;
        this.aBoolean3394 = false;
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
            var1 = aColor3379;
        }

        super.setBackground(var1);
        this.aColor3383 = var1;
        this.aColor3385 = this.method874(var1, 32);
        this.repaint();
    }

    public void setForeground(Color var1) {
        if (var1 == null) {
            var1 = aColor3380;
        }

        super.setForeground(var1);
        this.aColor3384 = var1;
        this.repaint();
    }

    public void setFont(Font var1) {
        super.setFont(var1);
        this.aFont3388 = var1;
        this.repaint();
    }

    public void setLabel(String var1) {
        this.aString3387 = var1;
        this.repaint();
    }

    public String getLabel() {
        return this.aString3387;
    }

    public void setSecondaryFont(Font var1) {
        this.aFont3390 = var1;
        this.repaint();
    }

    public void setSecondaryLabel(String var1) {
        this.aString3389 = var1;
        this.repaint();
    }

    public void setBorderColor(Color var1) {
        this.aColor3386 = var1;
        this.repaint();
    }

    public Dimension getPreferredSize() {
        return this.anImage3391 == null ? new Dimension(13 + this.getFontMetrics(this.aFont3388).stringWidth(this.aString3387) + 13, 5 + this.aFont3388.getSize() + 5) : new Dimension(this.anImage3391.getWidth((ImageObserver) null), this.anImage3391.getHeight((ImageObserver) null));
    }

    public void addActionListener(ActionListener var1) {
        Vector var2 = this.aVector3395;
        synchronized (this.aVector3395) {
            this.aVector3395.addElement(var1);
        }
    }

    public void removeActionListener(ActionListener var1) {
        Vector var2 = this.aVector3395;
        synchronized (this.aVector3395) {
            this.aVector3395.removeElement(var1);
        }
    }

    public void setEnabled(boolean var1) {
        super.setEnabled(var1);
        this.repaint();
    }

    public void setFlashing(boolean var1) {
        if (var1) {
            if (this.aClass95_3400 != null) {
                return;
            }

            this.aClass95_3400 = new Class95(this, this);
            Thread var2 = new Thread(this.aClass95_3400);
            var2.setDaemon(true);
            var2.start();
        } else {
            if (this.aClass95_3400 == null) {
                return;
            }

            this.aClass95_3400.method1755();
            this.aClass95_3400 = null;
            this.aBoolean3401 = false;
            this.repaint();
        }

    }

    public void processActionEvent() {
        Vector var1 = this.aVector3395;
        synchronized (this.aVector3395) {
            if (this.aVector3395.size() != 0) {
                ActionEvent var2 = new ActionEvent(this, 1001, this.aString3387);
                Enumeration var3 = this.aVector3395.elements();

                while (var3.hasMoreElements()) {
                    ((ActionListener) ((ActionListener) var3.nextElement())).actionPerformed(var2);
                }

            }
        }
    }

    public Image createBuffer(int var1, int var2) {
        return this.createImage(var1, var2);
    }

    public void drawText(Graphics var1, String var2, int var3, int var4) {
        var1.drawString(var2, var3, var4);
    }

    public boolean isHighlighted() {
        return this.aBoolean3393;
    }

    private void method871(Graphics var1, Color var2, int var3, int var4, boolean var5) {
        int var6 = (int) (Math.sqrt((double) var4) + 1.8D);
        double var7 = Math.sqrt(Math.sqrt((double) var4)) - 0.34D;
        Color var9 = this.getParent().getBackground();
        Color var10 = this.aColor3386;
        if (!var5) {
            var10 = this.method873(var10, var9, 0.5D);
        }

        for (int var12 = 0; var12 < var4; ++var12) {
            Color var11 = this.method872(var2, var12, var4);
            if (!var5) {
                var11 = this.method873(var11, var9, 0.5D);
            }

            for (int var13 = 0; var13 < var3; ++var13) {
                int var14 = var13;
                int var15 = var12;
                if (var12 < var6) {
                    var15 = var6;
                } else if (var12 >= var4 - var6) {
                    var15 = var4 - var6 - 1;
                }

                if (var13 < var6) {
                    var14 = var6;
                } else if (var13 >= var3 - var6) {
                    var14 = var3 - var6 - 1;
                }

                double var16 = (double) (var13 - var14);
                double var18 = (double) (var12 - var15);
                double var20 = Math.sqrt(var16 * var16 + var18 * var18);
                if (var20 <= (double) var6 + 1.0D && var20 <= (double) var6) {
                    if (var20 > (double) var6 - var7) {
                        if (var20 <= (double) var6 - var7 + 0.5D) {
                            var1.setColor(this.method873(var10, var11, 0.5D));
                        } else if (var20 > (double) var6 - 0.5D) {
                            var1.setColor(this.method873(var10, var9, 0.5D));
                        } else {
                            var1.setColor(var10);
                        }
                    } else {
                        var1.setColor(var11);
                    }

                    var1.fillRect(var13, var12, 1, 1);
                }
            }
        }

    }

    private Color method872(Color var1, int var2, int var3) {
        double var6 = 1.0D * (double) var2 / (double) var3;
        Color var4;
        Color var5;
        if (var2 < var3 / 2) {
            var4 = var1.brighter();
            var5 = var1;
            var6 *= 2.0D;
        } else {
            var4 = var1;
            var5 = var1.darker();
            var6 = (var6 - 0.5D) * 2.0D;
        }

        if (var6 < 0.0D) {
            var6 = 0.0D;
        } else if (var6 > 1.0D) {
            var6 = 1.0D;
        }

        return this.method873(var4, var5, var6);
    }

    private Color method873(Color var1, Color var2, double var3) {
        int var5 = var1.getRed();
        int var6 = var1.getGreen();
        int var7 = var1.getBlue();
        int var8 = var2.getRed();
        int var9 = var2.getGreen();
        int var10 = var2.getBlue();
        int var11 = var8 - var5;
        int var12 = var9 - var6;
        int var13 = var10 - var7;
        int var14 = (int) ((double) var5 + (double) var11 * var3 + 0.5D);
        int var15 = (int) ((double) var6 + (double) var12 * var3 + 0.5D);
        int var16 = (int) ((double) var7 + (double) var13 * var3 + 0.5D);
        return new Color(var14, var15, var16);
    }

    private Color method874(Color var1, int var2) {
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

    private Font method875(Font var1, String var2, int var3) {
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
        this.aBoolean3401 = var1;
        this.repaint();
    }

}
