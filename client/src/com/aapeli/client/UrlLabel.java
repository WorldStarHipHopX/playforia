package com.aapeli.client;

import com.aapeli.client.IPanel;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlLabel extends IPanel implements MouseListener {

    public static final int ALIGN_LEFT = -1;
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_RIGHT = 1;
    public static final int TARGET_SAME = 0;
    public static final int TARGET_NEW = 1;
    private static final String[] aStringArray3226 = new String[2];
    private static final Cursor aCursor3227;
    private static final Cursor aCursor3228;
    private static final Font aFont3229;
    private Applet anApplet3230;
    private Font aFont3231;
    private URL anURL3232;
    private String aString3233;
    private String aString3234;
    private String aString3235;
    private int anInt3236;
    private int anInt3237;
    private int anInt3238;
    private int anInt3239;
    private Color aColor3240;
    private Color aColor3241;
    private Color aColor3242;
    private Image anImage3243;
    private int anInt3244;
    private int anInt3245;
    private String aString3246;
    private static final String aString3247 = "Dialog";


    public UrlLabel(Applet var1) {
        this(var1, aFont3229, (String) null, (String) null);
    }

    public UrlLabel(Applet var1, String var2, String var3) {
        this(var1, aFont3229, var2, var3);
    }

    public UrlLabel(Applet var1, Font var2, String var3, String var4) {
        this.anApplet3230 = var1;
        this.aColor3240 = null;
        this.aColor3241 = Color.black;
        this.aColor3242 = Color.blue;
        this.anImage3243 = null;
        this.anInt3239 = -1;
        this.aString3246 = "_blank";
        this.aFont3231 = var2;
        this.setText(var3, var4);
    }

    public UrlLabel(Applet var1, String var2, String var3, int var4, int var5) {
        this(var1, aFont3229, var2, var3);
        this.setSize(var4, var5);
    }

    public void update(Graphics var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (this.anImage3243 != null) {
            var1.drawImage(this.anImage3243, 0, 0, var3, var4, this.anInt3244, this.anInt3245, this.anInt3244 + var3, this.anInt3245 + var4, this);
        } else if (!this.drawBackgroundImage(var1)) {
            var1.setColor(this.aColor3240 != null ? this.aColor3240 : this.getBackground());
            var1.fillRect(0, 0, var3, var4);
        }

        if (this.aString3233 != null) {
            int var5 = 2;
            int var6 = this.aFont3231.getSize();
            int var7 = var4 / 2 + var6 * 3 / 8;
            int var8 = var4 / 2 + var6 / 2;
            if (this.anInt3239 == 0) {
                var5 = var3 / 2 - this.anInt3238 / 2;
            }

            if (this.anInt3239 == 1) {
                var5 = var3 - 2 - this.anInt3238;
            }

            if (this.aString3234 != null && this.aString3235 != null) {
                var1.setColor(this.aColor3242);
                var1.drawLine(var5 + this.anInt3236, var8, var5 + this.anInt3236 + this.anInt3237, var8);
            }

            var1.setFont(this.aFont3231);
            var1.setColor(this.aColor3241);
            var1.drawString(this.aString3233, var5, var7);
            if (this.aString3234 != null && this.aString3235 != null) {
                var1.setColor(this.aColor3242);
                var1.drawString(this.aString3234, var5 + this.anInt3236, var7);
                var1.setColor(this.aColor3241);
                var1.drawString(this.aString3235, var5 + this.anInt3236 + this.anInt3237, var7);
            }

        }
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
    }

    public void mouseReleased(MouseEvent var1) {
        this.anApplet3230.getAppletContext().showDocument(this.anURL3232, this.aString3246);
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void setText(String var1, String var2) {
        if (var1 == null) {
            this.aString3233 = this.aString3234 = this.aString3235 = null;
            this.anURL3232 = null;
            this.setCursor(aCursor3227);
            this.repaint();
        } else {
            this.anURL3232 = null;
            if (var2 != null) {
                try {
                    this.anURL3232 = new URL(var2);
                } catch (MalformedURLException var6) {
                    ;
                }
            }

            FontMetrics var3 = this.anApplet3230.getFontMetrics(this.aFont3231);
            int var4 = var1.indexOf(60);
            int var5 = var1.indexOf(62);
            if (this.anURL3232 != null && var4 != -1 && var5 >= var4) {
                this.aString3233 = var1.substring(0, var4);
                this.aString3234 = var1.substring(var4 + 1, var5);
                this.aString3235 = var1.substring(var5 + 1);
                this.anInt3236 = var3.stringWidth(this.aString3233);
                this.anInt3237 = var3.stringWidth(this.aString3234);
                this.anInt3238 = this.anInt3236 + this.anInt3237 + var3.stringWidth(this.aString3235);
                this.setCursor(aCursor3228);
                this.removeMouseListener(this);
                this.addMouseListener(this);
                this.repaint();
            } else {
                this.aString3233 = var1;
                this.anInt3238 = var3.stringWidth(this.aString3233);
                this.aString3234 = this.aString3235 = null;
                this.setCursor(aCursor3227);
                this.repaint();
            }
        }
    }

    public void setAlign(int var1) {
        this.anInt3239 = var1;
        this.repaint();
    }

    public void setForeground(Color var1) {
        if (var1 != null) {
            int var2 = var1.getRed();
            int var3 = var1.getGreen();
            int var4 = var1.getBlue();
            Color var5 = new Color((var2 * 3 + 0) / 4, (var3 * 3 + 0) / 4, (var4 * 3 + 255) / 4);
            this.setForeground(var1, var5);
        }
    }

    public void setForeground(Color var1, Color var2) {
        this.aColor3241 = var1;
        this.aColor3242 = var2;
        this.repaint();
    }

    public void setBackground(Color var1) {
        this.aColor3240 = var1;
        this.repaint();
    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        this.anImage3243 = var1;
        this.anInt3244 = var2;
        this.anInt3245 = var3;
        this.repaint();
    }

    public void setTarget(int var1) {
        this.setTarget(aStringArray3226[var1]);
    }

    public void setTarget(String var1) {
        this.aString3246 = var1;
    }

    static {
        aStringArray3226[0] = "_top";
        aStringArray3226[1] = "_blank";
        aCursor3227 = new Cursor(0);
        aCursor3228 = new Cursor(12);
        aFont3229 = new Font("Dialog", 0, 11);
    }

    private static char[] method822(String var0) {
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
                var10003[0] = (char) (var10003[0] ^ 54);
                break;
            }
        }

        return var10001;
    }

    private static String method823(char[] var0) {
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
                        var10005 = 41;
                        break;
                    case 1:
                        var10005 = 61;
                        break;
                    case 2:
                        var10005 = 79;
                        break;
                    case 3:
                        var10005 = 79;
                        break;
                    default:
                        var10005 = 54;
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
