package com.playray.client;

import com.playray.client.SPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JApplet;

public class UrlLabel extends SPanel implements MouseListener {

    public static final int ALIGN_LEFT = -1;
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_RIGHT = 1;
    public static final int TARGET_SAME = 0;
    public static final int TARGET_NEW = 1;
    private static final String[] aStringArray4324 = new String[2];
    private static final Cursor aCursor4325;
    private static final Cursor aCursor4326;
    private static final Font aFont4327;
    private JApplet aJApplet4328;
    private Font aFont4329;
    private URL anURL4330;
    private String aString4331;
    private String aString4332;
    private String aString4333;
    private int anInt4334;
    private int anInt4335;
    private int anInt4336;
    private int anInt4337;
    private Color aColor4338;
    private Color aColor4339;
    private Color aColor4340;
    private Image anImage4341;
    private int anInt4342;
    private int anInt4343;
    private String aString4344;
    private static final String aString4345 = "Dialog";


    public UrlLabel(JApplet var1) {
        this(var1, aFont4327, (String) null, (String) null);
    }

    public UrlLabel(JApplet var1, String var2, String var3) {
        this(var1, aFont4327, var2, var3);
    }

    public UrlLabel(JApplet var1, Font var2, String var3, String var4) {
        this.aJApplet4328 = var1;
        this.aColor4338 = null;
        this.aColor4339 = Color.black;
        this.aColor4340 = Color.blue;
        this.anImage4341 = null;
        this.anInt4337 = -1;
        this.aString4344 = "_blank";
        this.aFont4329 = var2;
        this.setText(var3, var4);
    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (this.anImage4341 != null) {
            var1.drawImage(this.anImage4341, 0, 0, var3, var4, this.anInt4342, this.anInt4343, this.anInt4342 + var3, this.anInt4343 + var4, this);
        } else if (!this.drawBackgroundImage(var1)) {
            var1.setColor(this.aColor4338 != null ? this.aColor4338 : this.getBackground());
            var1.fillRect(0, 0, var3, var4);
        }

        if (this.aString4331 != null) {
            int var5 = 2;
            int var6 = this.aFont4329.getSize();
            int var7 = var4 / 2 + var6 * 3 / 8;
            int var8 = var4 / 2 + var6 / 2;
            if (this.anInt4337 == 0) {
                var5 = var3 / 2 - this.anInt4336 / 2;
            }

            if (this.anInt4337 == 1) {
                var5 = var3 - 2 - this.anInt4336;
            }

            if (this.aString4332 != null && this.aString4333 != null) {
                var1.setColor(this.aColor4340);
                var1.drawLine(var5 + this.anInt4334, var8, var5 + this.anInt4334 + this.anInt4335, var8);
            }

            var1.setFont(this.aFont4329);
            var1.setColor(this.aColor4339);
            var1.drawString(this.aString4331, var5, var7);
            if (this.aString4332 != null && this.aString4333 != null) {
                var1.setColor(this.aColor4340);
                var1.drawString(this.aString4332, var5 + this.anInt4334, var7);
                var1.setColor(this.aColor4339);
                var1.drawString(this.aString4333, var5 + this.anInt4334 + this.anInt4335, var7);
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
        this.aJApplet4328.getAppletContext().showDocument(this.anURL4330, this.aString4344);
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void setText(String var1, String var2) {
        if (var1 == null) {
            this.aString4331 = this.aString4332 = this.aString4333 = null;
            this.anURL4330 = null;
            this.setCursor(aCursor4325);
            this.repaint();
        } else {
            this.anURL4330 = null;
            if (var2 != null) {
                try {
                    this.anURL4330 = new URL(var2);
                } catch (MalformedURLException var6) {
                    ;
                }
            }

            FontMetrics var3 = this.aJApplet4328.getFontMetrics(this.aFont4329);
            int var4 = var1.indexOf(60);
            int var5 = var1.indexOf(62);
            if (this.anURL4330 != null && var4 != -1 && var5 >= var4) {
                this.aString4331 = var1.substring(0, var4);
                this.aString4332 = var1.substring(var4 + 1, var5);
                this.aString4333 = var1.substring(var5 + 1);
                this.anInt4334 = var3.stringWidth(this.aString4331);
                this.anInt4335 = var3.stringWidth(this.aString4332);
                this.anInt4336 = this.anInt4334 + this.anInt4335 + var3.stringWidth(this.aString4333);
                this.setCursor(aCursor4326);
                this.removeMouseListener(this);
                this.addMouseListener(this);
                this.repaint();
            } else {
                this.aString4331 = var1;
                this.anInt4336 = var3.stringWidth(this.aString4331);
                this.aString4332 = this.aString4333 = null;
                this.setCursor(aCursor4325);
                this.repaint();
            }
        }
    }

    public void setAlign(int var1) {
        this.anInt4337 = var1;
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
        this.aColor4339 = var1;
        this.aColor4340 = var2;
        this.repaint();
    }

    public void setBackground(Color var1) {
        this.aColor4338 = var1;
        this.repaint();
    }

    public void setTarget(int var1) {
        this.setTarget(aStringArray4324[var1]);
    }

    public void setTarget(String var1) {
        this.aString4344 = var1;
    }

    static {
        aStringArray4324[0] = "_top";
        aStringArray4324[1] = "_blank";
        aCursor4325 = new Cursor(0);
        aCursor4326 = new Cursor(12);
        aFont4327 = new Font("Dialog", 0, 11);
    }

    private static char[] method2820(String var0) {
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
                var10003[0] = (char) (var10003[0] ^ 53);
                break;
            }
        }

        return var10001;
    }

    private static String method2821(char[] var0) {
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
                        var10005 = 42;
                        break;
                    case 1:
                        var10005 = 22;
                        break;
                    case 2:
                        var10005 = 74;
                        break;
                    case 3:
                        var10005 = 16;
                        break;
                    default:
                        var10005 = 53;
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
