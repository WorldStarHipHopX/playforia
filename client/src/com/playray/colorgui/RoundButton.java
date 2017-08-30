package com.playray.colorgui;

import com.playray.client.SPanel;
import com.playray.colorgui.Class131;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.util.Enumeration;
import java.util.Vector;

public class RoundButton extends SPanel implements MouseMotionListener, MouseListener {

    private static final Color aColor4507 = new Color(224, 224, 224);
    private static final Color aColor4508 = new Color(0, 0, 0);
    private static final Color aColor4509 = new Color(255, 255, 255);
    private static final Font aFont4510 = new Font("Dialog", 0, 12);
    private Color aColor4511;
    private Color aColor4512;
    private Color aColor4513;
    private Color aColor4514;
    private String aString4515;
    private Font aFont4516;
    private String aString4517;
    private Font aFont4518;
    private Image anImage4519;
    private Image anImage4520;
    private boolean aBoolean4521;
    private boolean aBoolean4522;
    private Vector aVector4523;
    private Class131 aClass131_4524;
    private boolean aBoolean4525;
    private Object anObject4526;
    private static final String aString4527 = "Dialog";


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
        this.anObject4526 = new Object();
        this.setBackground(aColor4507);
        this.setForeground(aColor4508);
        this.setBorderColor(aColor4509);
        this.setFont(aFont4510);
        this.setLabel(var1);
        this.setSecondaryFont(aFont4510);
        this.setSecondaryLabel((String) null);
        this.anImage4519 = var2;
        this.anImage4520 = var3;
        this.aBoolean4521 = this.aBoolean4522 = false;
        this.aVector4523 = new Vector();
        this.aClass131_4524 = null;
        this.aBoolean4525 = false;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean4521 = this.aBoolean4522 = false;
        this.repaint();
    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        boolean var5 = this.isEnabled();
        this.drawBackground(var1);
        if (this.anImage4519 == null) {
            Color var6 = this.aBoolean4521 && var5 ? this.aColor4513 : this.aColor4511;
            if (this.aClass131_4524 != null) {
                var6 = this.method2920(var6, this.aBoolean4525 ? 32 : -32);
            }

            this.method2916(var1, var6, var3, var4, var5);
        } else {
            var1.drawImage(this.aBoolean4521 && var5 ? this.anImage4520 : this.anImage4519, 0, 0, this);
        }

        if (this.aString4515 != null) {
            var1.setColor(var5 ? this.aColor4512 : this.method2918(this.aColor4512, this.aColor4511, 0.25D));
            Font var11 = this.method2921(this.aFont4516, this.aString4515, var3 - 2);
            Font var7 = null;
            int var8 = var4 / 2 + var11.getSize() * 3 / 8 + 1;
            int var9 = -1;
            if (this.aString4517 != null) {
                var7 = this.method2921(this.aFont4518, this.aString4517, var3 - 2);
                int var10 = (var4 - var11.getSize() - var7.getSize()) / 3;
                var8 = var10 + var11.getSize();
                var9 = var4 - var10 - var7.getSize() / 8 - 1;
            }

            var1.setFont(var11);
            var1.drawString(this.aString4515, var3 / 2 - this.getFontMetrics(var11).stringWidth(this.aString4515) / 2, var8);
            if (this.aString4517 != null) {
                var1.setFont(var7);
                var1.drawString(this.aString4517, var3 / 2 - this.getFontMetrics(var7).stringWidth(this.aString4517) / 2, var9);
            }
        }

    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean4521 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean4521 = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean4522 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean4522;
        this.aBoolean4522 = false;
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
            var1 = aColor4507;
        }

        super.setBackground(var1);
        this.aColor4511 = var1;
        this.aColor4513 = this.method2920(var1, 32);
        this.repaint();
    }

    public void setForeground(Color var1) {
        if (var1 == null) {
            var1 = aColor4508;
        }

        super.setForeground(var1);
        this.aColor4512 = var1;
        this.repaint();
    }

    public void setFont(Font var1) {
        super.setFont(var1);
        this.aFont4516 = var1;
        this.repaint();
    }

    public void setLabel(String var1) {
        this.aString4515 = var1;
        this.repaint();
    }

    public String getLabel() {
        return this.aString4515;
    }

    public void setSecondaryFont(Font var1) {
        this.aFont4518 = var1;
        this.repaint();
    }

    public void setSecondaryLabel(String var1) {
        this.aString4517 = var1;
        this.repaint();
    }

    public void setBorderColor(Color var1) {
        this.aColor4514 = var1;
        this.repaint();
    }

    public Dimension getPreferredSize() {
        return this.anImage4519 == null ? new Dimension(13 + this.getFontMetrics(this.aFont4516).stringWidth(this.aString4515) + 13, 5 + this.aFont4516.getSize() + 5) : new Dimension(this.anImage4519.getWidth((ImageObserver) null), this.anImage4519.getHeight((ImageObserver) null));
    }

    public void addActionListener(ActionListener var1) {
        Object var2 = this.anObject4526;
        synchronized (this.anObject4526) {
            this.aVector4523.addElement(var1);
        }
    }

    public void removeActionListener(ActionListener var1) {
        Object var2 = this.anObject4526;
        synchronized (this.anObject4526) {
            this.aVector4523.removeElement(var1);
        }
    }

    public void setEnabled(boolean var1) {
        super.setEnabled(var1);
        this.repaint();
    }

    public void setFlashing(boolean var1) {
        if (var1) {
            if (this.aClass131_4524 != null) {
                return;
            }

            this.aClass131_4524 = new Class131(this, this);
            Thread var2 = new Thread(this.aClass131_4524);
            var2.setDaemon(true);
            var2.start();
        } else {
            if (this.aClass131_4524 == null) {
                return;
            }

            this.aClass131_4524.method2084();
            this.aClass131_4524 = null;
            this.aBoolean4525 = false;
            this.repaint();
        }

    }

    public void processActionEvent() {
        Object var1 = this.anObject4526;
        synchronized (this.anObject4526) {
            if (this.aVector4523.size() != 0) {
                ActionEvent var2 = new ActionEvent(this, 1001, this.aString4515);
                Enumeration var3 = this.aVector4523.elements();

                while (var3.hasMoreElements()) {
                    ((ActionListener) ((ActionListener) var3.nextElement())).actionPerformed(var2);
                }

            }
        }
    }

    private void method2916(Graphics2D var1, Color var2, int var3, int var4, boolean var5) {
        int var6 = (int) (Math.sqrt((double) var4) + 1.8D);
        double var7 = Math.sqrt(Math.sqrt((double) var4)) - 0.34D;
        Color var9 = this.aColor4514;
        if (!var5) {
            var9 = this.method2919(var9, 0.5D);
        }

        for (int var11 = 0; var11 < var4; ++var11) {
            Color var10 = this.method2917(var2, var11, var4);
            if (!var5) {
                var10 = this.method2919(var10, 0.5D);
            }

            for (int var12 = 0; var12 < var3; ++var12) {
                int var13 = var12;
                int var14 = var11;
                if (var11 < var6) {
                    var14 = var6;
                } else if (var11 >= var4 - var6) {
                    var14 = var4 - var6 - 1;
                }

                if (var12 < var6) {
                    var13 = var6;
                } else if (var12 >= var3 - var6) {
                    var13 = var3 - var6 - 1;
                }

                double var15 = (double) (var12 - var13);
                double var17 = (double) (var11 - var14);
                double var19 = Math.sqrt(var15 * var15 + var17 * var17);
                if (var19 <= (double) var6 + 1.0D) {
                    if (var19 <= (double) var6) {
                        if (var19 > (double) var6 - var7) {
                            if (var19 <= (double) var6 - var7 + 0.5D) {
                                var1.setColor(this.method2918(var9, var10, 0.5D));
                            } else if (var19 > (double) var6 - 0.5D) {
                                var1.setColor(this.method2919(var9, 0.5D));
                            } else {
                                var1.setColor(var9);
                            }
                        } else {
                            var1.setColor(var10);
                        }
                    } else {
                        var1.setColor(this.method2919(var9, var19 <= (double) var6 + 0.5D ? 0.2D : 0.1D));
                    }

                    var1.fillRect(var12, var11, 1, 1);
                }
            }
        }

    }

    private Color method2917(Color var1, int var2, int var3) {
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

        return this.method2918(var4, var5, var6);
    }

    private Color method2918(Color var1, Color var2, double var3) {
        int var5 = var1.getRed();
        int var6 = var1.getGreen();
        int var7 = var1.getBlue();
        int var8 = var1.getAlpha();
        int var9 = var2.getRed();
        int var10 = var2.getGreen();
        int var11 = var2.getBlue();
        int var12 = var2.getAlpha();
        int var13 = var9 - var5;
        int var14 = var10 - var6;
        int var15 = var11 - var7;
        int var16 = var12 - var8;
        int var17 = (int) ((double) var5 + (double) var13 * var3 + 0.5D);
        int var18 = (int) ((double) var6 + (double) var14 * var3 + 0.5D);
        int var19 = (int) ((double) var7 + (double) var15 * var3 + 0.5D);
        int var20 = (int) ((double) var8 + (double) var16 * var3 + 0.5D);
        return new Color(var17, var18, var19, var20);
    }

    private Color method2919(Color var1, double var2) {
        int var4 = var1.getRed();
        int var5 = var1.getGreen();
        int var6 = var1.getBlue();
        int var7 = var1.getAlpha();
        var7 = (int) ((double) var7 * var2 + 0.5D);
        return new Color(var4, var5, var6, var7);
    }

    private Color method2920(Color var1, int var2) {
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

    private Font method2921(Font var1, String var2, int var3) {
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
        this.aBoolean4525 = var1;
        this.repaint();
    }

}
