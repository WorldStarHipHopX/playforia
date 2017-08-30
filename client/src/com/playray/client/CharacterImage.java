package com.playray.client;

import com.playray.client.ImageManager;
import com.playray.tools.QuickTimer;
import com.playray.tools.QuickTimerListener;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JApplet;

public class CharacterImage implements QuickTimerListener {

    public static final int TYPE_SMALL = 0;
    public static final int TYPE_MEDIUM = 1;
    public static final int TYPE_BIGHEAD = 2;
    public static final int TYPE_CHAR = 3;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_MEDIUM = 1;
    public static final int[] IMAGE_WIDTH;
    public static final int[] IMAGE_HEIGHT;
    private static final String[] aStringArray2768;
    private static Image[][] anImageArrayArray2769;
    private JApplet aJApplet2770;
    private ImageManager anImageManager2771;
    private URL anURL2772;
    private int anInt2773;
    private int anInt2774;
    private long aLong2775;
    private Image anImage2776;
    private Component aComponent2777;
    private QuickTimer aQuickTimer2778;
    private static final String[] aStringArray2779 = new String[5];


    public CharacterImage(ImageManager var1, String var2, int var3) {
        this.anImageManager2771 = var1;
        this.aJApplet2770 = var1.getApplet();
        this.anInt2774 = var3;
        this.anInt2773 = 0;
        if (var2 != null) {
            if (!var2.equals("-")) {
                if (var2.equals("?")) {
                    this.anInt2773 = 3;
                } else {
                    this.anURL2772 = method1934(this.aJApplet2770.getCodeBase(), var2);
                    if (this.anURL2772 != null) {
                        this.method1926(this.anURL2772);
                    } else {
                        this.anInt2773 = 3;
                    }

                }
            }
        }
    }

    public CharacterImage(ImageManager var1, int var2) {
        this(var1, (String) null, var2);
    }

    public synchronized void qtFinished() {
        this.aQuickTimer2778 = null;
        if (this.aComponent2777 != null) {
            this.aComponent2777.repaint();
        }

    }

    public synchronized void draw(Graphics var1, int var2, int var3, Component var4) {
        if (this.aQuickTimer2778 != null) {
            this.aQuickTimer2778.removeListener(this);
            this.aQuickTimer2778 = null;
        }

        this.aComponent2777 = var4;
        this.method1927(var1, var2, var3);
    }

    public Image getImage() {
        this.method1928();
        return this.anImage2776;
    }

    public int getType() {
        return this.anInt2774;
    }

    public int getSize() {
        return this.getType();
    }

    private void method1926(URL var1) {
        this.anImageManager2771.method1984(var1);
        this.anInt2773 = 1;
        this.aLong2775 = System.currentTimeMillis();
    }

    private void method1927(Graphics var1, int var2, int var3) {
        this.method1928();
        boolean var4 = false;

        try {
            if (this.anInt2773 == 2) {
                var1.drawImage(this.anImage2776, var2, var3, (ImageObserver) null);
                return;
            }

            if (this.anInt2773 == 0) {
                var4 = this.method1929(var1, var2, var3);
            } else {
                if (this.anInt2773 == 1) {
                    if (System.currentTimeMillis() <= this.aLong2775 + 17000L) {
                        this.method1930(var1, var2, var3);
                        var4 = true;
                    } else {
                        this.anInt2773 = 3;
                    }
                }

                if (this.anInt2773 == 3) {
                    var4 = this.method1931(var1, var2, var3);
                }
            }
        } catch (Exception var6) {
            this.aComponent2777 = null;
            return;
        }

        if (var4 && this.aComponent2777 != null) {
            this.aQuickTimer2778 = new QuickTimer(1000, this);
        }

    }

    private void method1928() {
        if (this.anInt2773 == 1) {
            this.anImage2776 = this.anImageManager2771.method1985(this.anURL2772.toString());
            if (this.anImage2776 != null) {
                this.anInt2773 = 2;
                this.anURL2772 = null;
            }
        }

    }

    private boolean method1929(Graphics var1, int var2, int var3) {
        if (this.method1932(var1, var2, var3, 0)) {
            return false;
        } else {
            Color var4 = var1.getColor();
            var1.setColor(Color.lightGray);
            var1.fillRect(var2, var3, IMAGE_WIDTH[this.anInt2774], IMAGE_HEIGHT[this.anInt2774]);
            var1.setColor(Color.black);
            var1.drawRect(var2, var3, IMAGE_WIDTH[this.anInt2774] - 1, IMAGE_HEIGHT[this.anInt2774] - 1);
            var1.setColor(var4);
            return true;
        }
    }

    private void method1930(Graphics var1, int var2, int var3) {
        if (!this.method1932(var1, var2, var3, 1)) {
            Color var4 = var1.getColor();
            var1.setColor(Color.white);
            var1.fillRect(var2, var3, IMAGE_WIDTH[this.anInt2774], IMAGE_HEIGHT[this.anInt2774]);
            var1.setColor(Color.lightGray);
            var1.drawRect(var2, var3, IMAGE_WIDTH[this.anInt2774] - 1, IMAGE_HEIGHT[this.anInt2774] - 1);
            var1.setColor(var4);
        }
    }

    private boolean method1931(Graphics var1, int var2, int var3) {
        if (this.method1932(var1, var2, var3, 2)) {
            return false;
        } else {
            Color var4 = var1.getColor();
            var1.setColor(Color.white);
            var1.fillRect(var2, var3, IMAGE_WIDTH[this.anInt2774], IMAGE_HEIGHT[this.anInt2774]);
            var1.setColor(Color.red);
            var1.drawRect(var2, var3, IMAGE_WIDTH[this.anInt2774] - 1, IMAGE_HEIGHT[this.anInt2774] - 1);
            var1.drawLine(var2, var3, var2 + IMAGE_WIDTH[this.anInt2774] - 1, var3 + IMAGE_HEIGHT[this.anInt2774] - 1);
            var1.drawLine(var2 + IMAGE_WIDTH[this.anInt2774] - 1, var3, var2, var3 + IMAGE_HEIGHT[this.anInt2774] - 1);
            var1.setColor(var4);
            return true;
        }
    }

    private boolean method1932(Graphics var1, int var2, int var3, int var4) {
        Image var5 = this.method1933(var4);
        if (var5 == null) {
            return false;
        } else {
            var1.drawImage(var5, var2, var3, (ImageObserver) null);
            return true;
        }
    }

    private Image method1933(int var1) {
        if (anImageArrayArray2769[var1][this.anInt2774] != null) {
            return anImageArrayArray2769[var1][this.anInt2774];
        } else {
            Image var2 = anImageArrayArray2769[var1][1];
            if (var2 == null) {
                var2 = this.anImageManager2771.getShared("char_" + aStringArray2768[var1] + ".png", true);
            }

            if (var2 == null) {
                return null;
            } else {
                if (this.anInt2774 != 1) {
                    var2 = var2.getScaledInstance(IMAGE_WIDTH[this.anInt2774], IMAGE_HEIGHT[this.anInt2774], 4);

                    for (int var3 = 0; !this.aJApplet2770.prepareImage(var2, this.aJApplet2770) && var3 < 50; ++var3) {
                        Tools.sleep(10L);
                    }
                }

                anImageArrayArray2769[var1][this.anInt2774] = var2;
                return var2;
            }
        }
    }

    private static URL method1934(URL var0, String var1) {
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
        aStringArray2779[0] = "http";
        aStringArray2779[1] = "file";
        aStringArray2779[2] = "http://";
        aStringArray2779[3] = ".png";
        aStringArray2779[4] = "char_";
        IMAGE_WIDTH = new int[]{30, 60, 40, 128};
        IMAGE_HEIGHT = new int[]{30, 60, 50, 188};
        aStringArray2768 = new String[3];
        aStringArray2768[0] = "unreg";
        aStringArray2768[1] = "loading";
        aStringArray2768[2] = "invalid";
        anImageArrayArray2769 = new Image[3][2];
    }

    private static char[] method1935(String var0) {
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
                var10003[0] = (char) (var10003[0] ^ 17);
                break;
            }
        }

        return var10001;
    }

    private static String method1936(char[] var0) {
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
                        var10005 = 112;
                        break;
                    case 1:
                        var10005 = 98;
                        break;
                    case 2:
                        var10005 = 56;
                        break;
                    case 3:
                        var10005 = 79;
                        break;
                    default:
                        var10005 = 17;
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
