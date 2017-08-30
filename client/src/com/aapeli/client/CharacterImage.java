package com.aapeli.client;

import com.aapeli.client.ImageManager;
import com.aapeli.tools.QuickTimer;
import com.aapeli.tools.QuickTimerListener;
import com.aapeli.tools.Tools;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;

public class CharacterImage implements QuickTimerListener {

    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_NORMAL = 1;
    public static final int[] IMAGE_WIDTH;
    public static final int[] IMAGE_HEIGHT;
    private static final String[] aStringArray2567;
    private static Image[][] anImageArrayArray2568;
    private Applet anApplet2569;
    private ImageManager anImageManager2570;
    private URL anURL2571;
    private int anInt2572;
    private int anInt2573;
    private long aLong2574;
    private Image anImage2575;
    private Component aComponent2576;
    private QuickTimer aQuickTimer2577;
    private static final String[] aStringArray2578 = new String[5];


    public CharacterImage(ImageManager var1, String var2, int var3) {
        this.anImageManager2570 = var1;
        this.anApplet2569 = var1.getApplet();
        this.anInt2573 = var3;
        this.anInt2572 = 0;
        if (var2 != null) {
            if (!var2.equals("-")) {
                if (var2.equals("?")) {
                    this.anInt2572 = 3;
                } else {
                    this.anURL2571 = method1586(this.anApplet2569.getCodeBase(), var2);
                    if (this.anURL2571 != null) {
                        this.method1578(this.anURL2571);
                    } else {
                        this.anInt2572 = 3;
                    }

                }
            }
        }
    }

    public CharacterImage(ImageManager var1, int var2) {
        this(var1, (String) null, var2);
    }

    public synchronized void qtFinished() {
        this.aQuickTimer2577 = null;
        if (this.aComponent2576 != null) {
            this.aComponent2576.repaint();
        }

    }

    public synchronized void draw(Graphics var1, int var2, int var3, Component var4) {
        if (this.aQuickTimer2577 != null) {
            this.aQuickTimer2577.removeListener(this);
            this.aQuickTimer2577 = null;
        }

        this.aComponent2576 = var4;
        this.method1579(var1, var2, var3);
    }

    public Image getImage() {
        this.method1580();
        return this.anImage2575;
    }

    public int getSize() {
        return this.anInt2573;
    }

    private void method1578(URL var1) {
        this.anImageManager2570.method1594(var1);
        this.anInt2572 = 1;
        this.aLong2574 = System.currentTimeMillis();
    }

    private void method1579(Graphics var1, int var2, int var3) {
        this.method1580();
        boolean var4 = false;

        try {
            if (this.anInt2572 == 2) {
                var1.drawImage(this.anImage2575, var2, var3, (ImageObserver) null);
                return;
            }

            if (this.anInt2572 == 0) {
                var4 = this.method1581(var1, var2, var3);
            } else {
                if (this.anInt2572 == 1) {
                    if (System.currentTimeMillis() <= this.aLong2574 + 17000L) {
                        this.method1582(var1, var2, var3);
                        var4 = true;
                    } else {
                        this.anInt2572 = 3;
                    }
                }

                if (this.anInt2572 == 3) {
                    var4 = this.method1583(var1, var2, var3);
                }
            }
        } catch (Exception var6) {
            this.aComponent2576 = null;
            return;
        }

        if (var4 && this.aComponent2576 != null) {
            this.aQuickTimer2577 = new QuickTimer(1000, this);
        }

    }

    private void method1580() {
        if (this.anInt2572 == 1) {
            this.anImage2575 = this.anImageManager2570.method1595(this.anURL2571.toString());
            if (this.anImage2575 != null) {
                this.anInt2572 = 2;
                this.anURL2571 = null;
            }
        }

    }

    private boolean method1581(Graphics var1, int var2, int var3) {
        if (this.method1584(var1, var2, var3, 0)) {
            return false;
        } else {
            Color var4 = var1.getColor();
            var1.setColor(Color.lightGray);
            var1.fillRect(var2, var3, IMAGE_WIDTH[this.anInt2573], IMAGE_HEIGHT[this.anInt2573]);
            var1.setColor(Color.black);
            var1.drawRect(var2, var3, IMAGE_WIDTH[this.anInt2573] - 1, IMAGE_HEIGHT[this.anInt2573] - 1);
            var1.setColor(var4);
            return true;
        }
    }

    private void method1582(Graphics var1, int var2, int var3) {
        if (!this.method1584(var1, var2, var3, 1)) {
            Color var4 = var1.getColor();
            var1.setColor(Color.white);
            var1.fillRect(var2, var3, IMAGE_WIDTH[this.anInt2573], IMAGE_HEIGHT[this.anInt2573]);
            var1.setColor(Color.lightGray);
            var1.drawRect(var2, var3, IMAGE_WIDTH[this.anInt2573] - 1, IMAGE_HEIGHT[this.anInt2573] - 1);
            var1.setColor(var4);
        }
    }

    private boolean method1583(Graphics var1, int var2, int var3) {
        if (this.method1584(var1, var2, var3, 2)) {
            return false;
        } else {
            Color var4 = var1.getColor();
            var1.setColor(Color.white);
            var1.fillRect(var2, var3, IMAGE_WIDTH[this.anInt2573], IMAGE_HEIGHT[this.anInt2573]);
            var1.setColor(Color.red);
            var1.drawRect(var2, var3, IMAGE_WIDTH[this.anInt2573] - 1, IMAGE_HEIGHT[this.anInt2573] - 1);
            var1.drawLine(var2, var3, var2 + IMAGE_WIDTH[this.anInt2573] - 1, var3 + IMAGE_HEIGHT[this.anInt2573] - 1);
            var1.drawLine(var2 + IMAGE_WIDTH[this.anInt2573] - 1, var3, var2, var3 + IMAGE_HEIGHT[this.anInt2573] - 1);
            var1.setColor(var4);
            return true;
        }
    }

    private boolean method1584(Graphics var1, int var2, int var3, int var4) {
        Image var5 = this.method1585(var4);
        if (var5 == null) {
            return false;
        } else {
            var1.drawImage(var5, var2, var3, (ImageObserver) null);
            return true;
        }
    }

    private Image method1585(int var1) {
        if (anImageArrayArray2568[var1][this.anInt2573] != null) {
            return anImageArrayArray2568[var1][this.anInt2573];
        } else {
            Image var2 = anImageArrayArray2568[var1][1];
            if (var2 == null) {
                var2 = this.anImageManager2570.getShared("char_" + aStringArray2567[var1] + ".png", true);
            }

            if (var2 == null) {
                return null;
            } else {
                if (this.anInt2573 != 1) {
                    var2 = var2.getScaledInstance(IMAGE_WIDTH[this.anInt2573], IMAGE_HEIGHT[this.anInt2573], 4);

                    for (int var3 = 0; !this.anApplet2569.prepareImage(var2, this.anApplet2569) && var3 < 50; ++var3) {
                        Tools.sleep(10L);
                    }
                }

                anImageArrayArray2568[var1][this.anInt2573] = var2;
                return var2;
            }
        }
    }

    private static URL method1586(URL var0, String var1) {
        try {
            URL var2 = new URL(var0, var1);
            if (var0.getProtocol().equalsIgnoreCase("file")) {
                return var2;
            } else {
                if (var2.getProtocol().equalsIgnoreCase("http")) {
                    String var3 = var0.getHost();
                    String var4 = var2.getHost();
                    if (!var4.equals(var3)) {
                        String var5 = var2.getFile();
                        if (var5.charAt(0) != 47) {
                            var5 = "/" + var5;
                        }

                        var2 = new URL("http://" + var3 + var5);
                    }
                }

                return var2;
            }
        } catch (MalformedURLException var6) {
            return null;
        }
    }

    static {
        aStringArray2578[0] = ".png";
        aStringArray2578[1] = "char_";
        aStringArray2578[2] = "http://";
        aStringArray2578[3] = "file";
        aStringArray2578[4] = "http";
        IMAGE_WIDTH = new int[]{30, 60};
        IMAGE_HEIGHT = new int[]{30, 60};
        aStringArray2567 = new String[3];
        aStringArray2567[0] = "unreg";
        aStringArray2567[1] = "loading";
        aStringArray2567[2] = "invalid";
        anImageArrayArray2568 = new Image[3][2];
    }

    private static char[] method1587(String var0) {
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
                var10003[0] = (char) (var10003[0] ^ 36);
                break;
            }
        }

        return var10001;
    }

    private static String method1588(char[] var0) {
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
                        var10005 = 126;
                        break;
                    case 1:
                        var10005 = 2;
                        break;
                    case 2:
                        var10005 = 101;
                        break;
                    case 3:
                        var10005 = 126;
                        break;
                    default:
                        var10005 = 36;
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
