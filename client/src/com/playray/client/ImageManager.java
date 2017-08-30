package com.playray.client;

import com.playray.tools.Tools;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JApplet;

public final class ImageManager {

    private static final String aString1840 = "picture/";
    private JApplet aJApplet1841;
    private URL codebaseURL;
    private String[][] aStringArrayArray1843;
    private Hashtable aHashtable1844;
    private Hashtable aHashtable1845;
    private boolean validImageDir;
    private boolean aBoolean1847;
    private Class115 aClass115_1848;
    private int[] anIntArray1849;
    private int[] anIntArray1850;
    private static final String[] aStringArray1851 = new String[11];


    public ImageManager(JApplet var1) {
        this(var1, "picture/", false);
    }

    public ImageManager(JApplet var1, boolean var2) {
        this(var1, "picture/", var2);
    }

    public ImageManager(JApplet var1, String var2) {
        this(var1, var2, false);
    }

    public ImageManager(JApplet var1, String imageDir, boolean var3) {
        this.aJApplet1841 = var1;
        this.aBoolean1847 = var3;
        this.validImageDir = true;
        if (imageDir != null && imageDir.length() > 0) {
            this.validImageDir = false;
        }

        String host = var1.getCodeBase().getHost();
        String URL = var1.getCodeBase().toString().replace("http://" + host, "res");
        try {
            codebaseURL = new File(URL).toURI().toURL();
        } catch(Exception ex) {
            System.err.println("playery.ImageManger: " + ex);
        }
        if (!this.validImageDir) {
            try {
                this.codebaseURL = new URL(this.codebaseURL, imageDir);
            } catch (MalformedURLException var5) {
                ;
            }
        }

        this.aHashtable1844 = new Hashtable();
        this.aHashtable1845 = new Hashtable();
        this.aClass115_1848 = new Class115(var1, var3);
    }

    public void setImageAliases(String[][] var1) {
        this.aStringArrayArray1843 = var1;
    }

    public String defineImage(String var1) {
        return this.defineImage(this.method1986(var1), var1);
    }

    public String defineImage(String var1, String var2) {
        if (this.aBoolean1847) {
            System.out.println("ImageManager.defineImage(\"" + var1 + "\",\"" + var2 + "\")");
        }

        //todo Image var3 = this.aJApplet1841.getImage(this.anURL1842, this.method1987(var2));
        URL url = codebaseURL;
        try {
            url = new URL(codebaseURL, method1987(var2));
        } catch (Exception ex) {
        }
        Image var3 = Toolkit.getDefaultToolkit().createImage(url);
        this.aClass115_1848.method1946(var1, var3);
        return var1;
    }

    public void unDefineImage(String var1) {
        this.aClass115_1848.method1959(var1);
    }

    public void defineAlias(String var1, String var2) {
        if (this.aBoolean1847) {
            System.out.println("ImageManager.defineAlias(\"" + var1 + "\",\"" + var2 + "\")");
        }

        this.aHashtable1844.put(var1, var2);
    }

    public void startLoadingImages() {
        this.aClass115_1848.method1949();
    }

    public boolean isLoadingFinished() {
        return this.aClass115_1848.method1960() == 0;
    }

    public int getPercentOfImagesLoaded() {
        if (this.aClass115_1848.method1960() == 0) {
            return 100;
        } else {
            int var1 = (int) (100.0D * this.getImageLoadProgress() + 0.5D);
            if (var1 == 0 && this.aClass115_1848.method1961() > 0) {
                var1 = 1;
            } else if (var1 == 100) {
                var1 = 99;
            }

            return var1;
        }
    }

    public double getImageLoadProgress() {
        int var1 = this.aClass115_1848.method1960();
        if (var1 == 0) {
            return 1.0D;
        } else {
            int var2 = this.aClass115_1848.method1961();
            int var3 = var2 + var1;
            return 1.0D * (double) var2 / (double) var3;
        }
    }

    public Image method1983(String var1) {
        return this.aClass115_1848.method1950(this.method1988(var1));
    }

    public boolean isDefined(String var1) {
        return this.aClass115_1848.method1956(this.method1988(var1));
    }

    public Image getIfAvailable(String var1) {
        return this.aClass115_1848.method1951(this.method1988(var1));
    }

    public Image getEvenNotLoaded(String var1) {
        return this.aClass115_1848.method1952(this.method1988(var1));
    }

    public Image getShared(String var1) {
        return this.getShared(var1, false);
    }

    public Image getShared(String var1, boolean var2) {
        String var3 = this.method1986(var1);
        Image var4 = this.aClass115_1848.method1954(var3);
        if (var4 != null) {
            return var4;
        } else {
            synchronized (this) {
                if (!this.aClass115_1848.method1957(var3)) {
                    URL var6 = this.aJApplet1841.getCodeBase();

                    try {
                        if (var6.getProtocol().equalsIgnoreCase("file")) {
                            var6 = new URL(var6, "/Shared/Client2/src/picture/");
                        } else {
                            var6 = new URL(var6, "../Shared/picture/");
                        }
                    } catch (MalformedURLException var9) {
                        ;
                    }

                    //todo var4 = this.aJApplet1841.getImage(var6, var1);
                    URL url = var6;
                    try {
                        url = new URL(var6, var1);
                    } catch (Exception ex) {
                    }
                    var4 = Toolkit.getDefaultToolkit().createImage(url);
                    this.aClass115_1848.method1947(var3, var4);
                }
            }

            return var2 ? null : this.aClass115_1848.method1953(var3);
        }
    }

    public int getWidth(Image var1) {
        return var1.getWidth(this.aJApplet1841);
    }

    public int getHeight(Image var1) {
        return var1.getHeight(this.aJApplet1841);
    }

    public int[] getPixels(Image var1) {
        return this.getPixels(var1, 0, 0, this.getWidth(var1), this.getHeight(var1));
    }

    public int[] getPixels(Image var1, int var2, int var3) {
        return this.getPixels(var1, 0, 0, var2, var3);
    }

    public int[] getPixels(Image var1, int var2, int var3, int var4, int var5) {
        int[] var6 = new int[var4 * var5];
        PixelGrabber var7 = new PixelGrabber(var1, var2, var3, var4, var5, var6, 0, var4);

        try {
            var7.grabPixels();
        } catch (InterruptedException var9) {
            ;
        }

        return var6;
    }

    public Image createImage(int[] var1, int var2, int var3) {
        return this.createImage(var1, var2, var3, (Component) null);
    }

    public Image createImage(int[] var1, int var2, int var3, Component var4) {
        if (var4 == null) {
            var4 = this.aJApplet1841;
        }

        Image var5 = ((Component) var4).createImage(new MemoryImageSource(var2, var3, var1, 0, var2));

        while (!((Component) var4).prepareImage(var5, (ImageObserver) var4)) {
            Tools.sleep(20L);
        }

        return var5;
    }

    public Image[] separateImages(Image var1, int var2) {
        return this.separateImages(var1, var2, 1)[0];
    }

    public Image[][] separateImages(Image var1, int var2, int var3) {
        if (this.aBoolean1847) {
            System.out.println("ImageManager.separateImages(...," + var2 + "," + var3 + ")");
        }

        int var4 = this.getWidth(var1);
        int var5 = this.getHeight(var1);
        int var6 = var4 / var2;
        int var7 = var5 / var3;
        if (this.aBoolean1847 && (var4 % var2 > 0 || var5 % var3 > 0)) {
            System.out.println("ImageManager.separateImages(...," + var2 + "," + var3 + "): Warning! Source image can not be divided to " + var2 + "*" + var3 + " blocks");
            Thread.dumpStack();
        }

        int[] var8 = this.getPixels(var1, var4, var5);
        Image[][] var10 = new Image[var3][var2];

        for (int var11 = 0; var11 < var3; ++var11) {
            for (int var12 = 0; var12 < var2; ++var12) {
                int[] var9 = new int[var6 * var7];

                for (int var13 = 0; var13 < var7; ++var13) {
                    for (int var14 = 0; var14 < var6; ++var14) {
                        var9[var13 * var6 + var14] = var8[var11 * var4 * var7 + var13 * var4 + var12 * var6 + var14];
                    }
                }

                var10[var11][var12] = this.createImage(var9, var6, var7);
            }
        }

        return var10;
    }

    public Image[][] separateImages(String var1, int var2, int var3) {
        String var4 = var1 + ":" + var2 + "*" + var3;
        Image[][] var5 = (Image[][]) ((Image[][]) this.aHashtable1845.get(var4));
        if (var5 != null) {
            return var5;
        } else {
            Hashtable var6 = this.aHashtable1845;
            synchronized (this.aHashtable1845) {
                var5 = (Image[][]) ((Image[][]) this.aHashtable1845.get(var4));
                if (var5 == null) {
                    Image var7 = this.method1983(var1);
                    this.unDefineImage(var1);
                    var5 = this.separateImages(var7, var2, var3);
                    this.aHashtable1845.put(var4, var5);
                }

                return var5;
            }
        }
    }

    public Image[] separateImages(String var1, int var2) {
        String var3 = var1 + ":" + var2;
        Image[] var4 = (Image[]) ((Image[]) this.aHashtable1845.get(var3));
        if (var4 != null) {
            return var4;
        } else {
            Hashtable var5 = this.aHashtable1845;
            synchronized (this.aHashtable1845) {
                var4 = (Image[]) ((Image[]) this.aHashtable1845.get(var3));
                if (var4 == null) {
                    Image var6 = this.method1983(var1);
                    this.unDefineImage(var1);
                    var4 = this.separateImages(var6, var2, 1)[0];
                    this.aHashtable1845.put(var3, var4);
                }

                return var4;
            }
        }
    }

    public Image setBrightness(Image var1, double var2) {
        if (var2 == 0.0D) {
            return var1;
        } else {
            int var4 = this.getWidth(var1);
            int var5 = this.getHeight(var1);
            int[] var6 = this.getPixels(var1, var4, var5);
            return this.createImage(this.setBrightness(var6, var2), var4, var5);
        }
    }

    public int[] setBrightness(int[] var1, double var2) {
        int var4 = var1.length;
        int[] var8 = new int[var4];

        for (int var9 = 0; var9 < var4; ++var9) {
            int var5 = (var1[var9] & 16711680) >> 16;
            int var6 = (var1[var9] & '\uff00') >> 8;
            int var7 = var1[var9] & 255;
            if (var2 > 0.0D) {
                var5 = (int) ((double) var5 + (255.0D - (double) var5) * var2 + 0.5D);
                var6 = (int) ((double) var6 + (255.0D - (double) var6) * var2 + 0.5D);
                var7 = (int) ((double) var7 + (255.0D - (double) var7) * var2 + 0.5D);
            } else {
                var5 = (int) ((double) var5 + (double) var5 * var2 + 0.5D);
                var6 = (int) ((double) var6 + (double) var6 * var2 + 0.5D);
                var7 = (int) ((double) var7 + (double) var7 * var2 + 0.5D);
            }

            var8[var9] = (int) (((long) var1[var9] & 4278190080L) + (long) (var5 << 16) + (long) (var6 << 8) + (long) var7);
        }

        return var8;
    }

    public Image setTransparency(Image var1, double var2) {
        int var4 = this.getWidth(var1);
        int var5 = this.getHeight(var1);
        int[] var6 = this.getPixels(var1, var4, var5);
        return this.createImage(this.setTransparency(var6, var2), var4, var5);
    }

    public int[] setTransparency(int[] var1, double var2) {
        int var4 = var1.length;
        int[] var5 = new int[var4];

        for (int var9 = 0; var9 < var4; ++var9) {
            long var6 = ((long) var1[var9] & 4278190080L) >> 24;
            if (var6 == 0L) {
                var5[var9] = var1[var9];
            } else {
                int var8 = (int) ((double) var6 * var2 + 0.5D);
                var5[var9] = (int) ((long) (var8 << 24) + ((long) var1[var9] & 16777215L));
            }
        }

        return var5;
    }

    public Image getAlphaMultipliedImage(Image var1, double var2) {
        int var4 = this.getWidth(var1);
        int var5 = this.getHeight(var1);
        int[] var6 = this.getPixels(var1, var4, var5);
        return this.createImage(this.multiplyAlpha(var6, var2), var4, var5);
    }

    public int[] multiplyAlpha(int[] var1, double var2) {
        int var4 = var1.length;
        int[] var5 = new int[var4];

        for (int var8 = 0; var8 < var4; ++var8) {
            long var6 = ((long) var1[var8] & 4278190080L) >> 24;
            var6 = (long) ((double) var6 * var2);
            if (var6 < 0L) {
                var6 = 0L;
            } else if (var6 > 255L) {
                var6 = 255L;
            }

            var5[var8] = (int) ((var6 << 24) + ((long) var1[var8] & 16777215L));
        }

        return var5;
    }

    public void destroy() {
        this.aClass115_1848.method1962();
        Enumeration var1 = this.aHashtable1845.elements();

        while (var1.hasMoreElements()) {
            try {
                Object var2 = var1.nextElement();
                int var4;
                if (var2 instanceof Image[]) {
                    Image[] var7 = (Image[]) ((Image[]) var2);

                    for (var4 = 0; var4 < var7.length; ++var4) {
                        var7[var4].flush();
                        var7[var4] = null;
                    }
                } else if (var2 instanceof Image[][]) {
                    Image[][] var3 = (Image[][]) ((Image[][]) var2);

                    for (var4 = 0; var4 < var3.length; ++var4) {
                        for (int var5 = 0; var5 < var3[var4].length; ++var5) {
                            var3[var4][var5].flush();
                            var3[var4][var5] = null;
                        }
                    }
                }
            } catch (Exception var6) {
                ;
            }
        }

        this.aHashtable1845.clear();
        this.aHashtable1845 = null;
        this.aHashtable1844.clear();
        this.aHashtable1844 = null;
        this.aStringArrayArray1843 = (String[][]) null;
        this.codebaseURL = null;
        this.aJApplet1841 = null;
    }

    public JApplet getApplet() {
        return this.aJApplet1841;
    }

    public void prepareBigText() {
        this.getShared("bigtext.gif", true);
    }

    public int[] getBigTextPixels() {
        if (this.anIntArray1849 == null) {
            Image var1 = this.getShared("bigtext.gif", true);
            if (var1 == null) {
                return null;
            }

            this.anIntArray1849 = this.getPixels(var1);
        }

        return this.anIntArray1849;
    }

    public int[] getMediumTextPixels() {
        if (this.anIntArray1850 == null) {
            this.getBigTextPixels();
            if (this.anIntArray1849 == null) {
                return null;
            }

            short var1 = 716;
            byte var2 = 25;
            this.anIntArray1850 = new int[var1 * var2];

            for (int var3 = 0; var3 < var2; ++var3) {
                for (int var4 = 0; var4 < var1; ++var4) {
                    this.anIntArray1850[var3 * var1 + var4] = method1989(this.anIntArray1849, var4 * 2, var3 * 2);
                }
            }
        }

        return this.anIntArray1850;
    }

    protected void method1984(URL var1) {
        String var2 = var1.toString();
        synchronized (this) {
            if (!this.aClass115_1848.method1958(var2)) {
                //Image var4 = this.aJApplet1841.getImage(var1);
                Image var4 = Toolkit.getDefaultToolkit().createImage(var1);
                this.aClass115_1848.method1948(var2, var4);
            }

        }
    }

    protected Image method1985(String var1) {
        return this.aClass115_1848.method1955(var1);
    }

    private String method1986(String var1) {
        int var2 = var1.lastIndexOf(46);
        if (var2 == -1) {
            var2 = var1.length();
        }

        if (this.validImageDir) {
            return var1.substring(0, var2);
        } else {
            int var3 = var1.lastIndexOf(47);
            return var1.substring(var3 + 1, var2);
        }
    }

    private String method1987(String var1) {
        if (this.aStringArrayArray1843 != null) {
            int var2 = this.aStringArrayArray1843.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                if (var1.equals(this.aStringArrayArray1843[var3][0])) {
                    return this.aStringArrayArray1843[var3][1];
                }
            }
        }

        return var1;
    }

    private String method1988(String var1) {
        String var2 = (String) ((String) this.aHashtable1844.get(var1));
        return var2 != null ? var2 : var1;
    }

    private static int method1989(int[] var0, int var1, int var2) {
        long var3 = (long) var0[var2 * 1432 + var1];
        long var5 = (long) var0[var2 * 1432 + var1 + 1];
        long var7 = (long) var0[(var2 + 1) * 1432 + var1];
        long var9 = (long) var0[(var2 + 1) * 1432 + var1 + 1];
        long var11 = ((var3 & 4278190080L) >> 24) + ((var5 & 4278190080L) >> 24) + ((var7 & 4278190080L) >> 24) + ((var9 & 4278190080L) >> 24);
        long var13 = ((var3 & 16711680L) >> 16) + ((var5 & 16711680L) >> 16) + ((var7 & 16711680L) >> 16) + ((var9 & 16711680L) >> 16);
        long var15 = ((var3 & 65280L) >> 8) + ((var5 & 65280L) >> 8) + ((var7 & 65280L) >> 8) + ((var9 & 65280L) >> 8);
        long var17 = (var3 & 255L) + (var5 & 255L) + (var7 & 255L) + (var9 & 255L);
        long var19 = (var11 + 2L) / 4L;
        long var21 = (var13 + 2L) / 4L;
        long var23 = (var15 + 2L) / 4L;
        long var25 = (var17 + 2L) / 4L;
        return (int) ((var19 << 24) + (var21 << 16) + (var23 << 8) + var25);
    }

    static {
        aStringArray1851[0] = "bigtext.gif";
        aStringArray1851[1] = "ImageManager.separateImages(...,";
        aStringArray1851[2] = "): Warning! Source image can not be divided to ";
        aStringArray1851[3] = " blocks";
        aStringArray1851[4] = "../Shared/picture/";
        aStringArray1851[5] = "/Shared/Client2/src/picture/";
        aStringArray1851[6] = "file";
        aStringArray1851[7] = "\",\"";
        aStringArray1851[8] = "ImageManager.defineAlias(\"";
        aStringArray1851[9] = "\")";
        aStringArray1851[10] = "ImageManager.defineImage(\"";
    }
}
