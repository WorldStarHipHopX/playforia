package com.aapeli.client;

import com.aapeli.applet.AApplet;
import com.aapeli.tools.Tools;

import java.applet.Applet;
import java.awt.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class ImageTracker implements Runnable {

    private static final String aString1393 = "N\t";
    private static final String aString1394 = "S\t";
    private static final String aString1395 = "C\t";
    private Applet anApplet1396;
    private boolean aBoolean1397;

    private Vector imageResourceTable;
    private Hashtable imageTable;
    private AApplet anAApplet1400;
    private Thread aThread1401;
    private boolean aBoolean1402;
    private static final String[] aStringArray1403 = new String[4];


    protected ImageTracker(Applet var1, boolean var2) {
        this.anApplet1396 = var1;
        this.aBoolean1397 = var2;
        this.imageResourceTable = new Vector();
        this.imageTable = new Hashtable();
        this.anAApplet1400 = null;
        this.aBoolean1402 = false;
    }

    public void run() {
        while (!this.aBoolean1402 && this.method1645()) {
            Tools.sleep(10L);
        }

        synchronized (this) {
            this.aThread1401 = null;
        }
    }

    protected void registerImage(String imageAlias, Image image) {
        imageAlias = "N\t" + imageAlias;
        synchronized (this) {
            if (!this.containsResource(imageAlias)) {
                this.imageResourceTable.addElement(new ImageResource(this, imageAlias, image));
            }
        }
    }

    protected void method1624(String var1, Image var2) {
        var1 = "S\t" + var1;
        synchronized (this) {
            if (!this.containsResource(var1)) {
                this.imageResourceTable.insertElementAt(new ImageResource(this, var1, var2), 0);
            }
        }
    }

    protected void method1625(String var1, Image var2) {
        var1 = "C\t" + var1;
        synchronized (this) {
            if (!this.containsResource(var1)) {
                this.imageResourceTable.addElement(new ImageResource(this, var1, var2));
            }
        }
    }

    protected synchronized void method1626() {
        if (this.aThread1401 == null) {
            if (!this.imageResourceTable.isEmpty()) {
                if (!this.aBoolean1402) {
                    this.aThread1401 = new Thread(this);
                    this.aThread1401.start();
                }
            }
        }
    }

    protected Image getNImage(String var1) {
        return this.getImage("N\t" + var1, false);
    }

    protected Image getNImageFromTable(String var1) {
        return this.getImageFromTable("N\t" + var1);
    }

    protected Image method1629(String var1) {
        return this.getImage("N\t" + var1, true);
    }

    protected Image method1630(String var1) {
        return this.getImage("S\t" + var1, false);
    }

    protected Image method1631(String var1) {
        return this.getImageFromTable("S\t" + var1);
    }

    protected Image method1632(String var1) {
        return this.getImageFromTable("C\t" + var1);
    }

    protected boolean containsNImage(String var1) {
        return this.containsResource("N\t" + var1);
    }

    protected boolean containsSImage(String var1) {
        return this.containsResource("S\t" + var1);
    }

    protected boolean containsCImage(String var1) {
        return this.containsResource("C\t" + var1);
    }

    protected void method1636(String var1) {
        var1 = "N\t" + var1;
        synchronized (this) {
            if (this.imageTable.remove(var1) == null) {
                this.method1646(var1);
            }

        }
    }

    protected int numberOfImages() {
        return this.imageResourceTable.size();
    }

    protected int method1638() {
        return this.imageTable.size();
    }

    protected void removeAllImageResources() {
        this.aBoolean1402 = true;
        if (this.aThread1401 != null) {
            int var1 = 500;
            byte var2 = 50;

            while (this.aThread1401 != null && var1 > 0) {
                var1 -= var2;
                Tools.sleep((long) var2);
            }
        }

        Enumeration var6 = this.imageTable.elements();

        while (var6.hasMoreElements()) {
            try {
                ((Image) ((Image) var6.nextElement())).flush();
            } catch (Exception var5) {
                ;
            }
        }

        this.imageTable.clear();
        this.imageTable = null;
        Enumeration var7 = this.imageResourceTable.elements();

        while (var7.hasMoreElements()) {
            try {
                ((ImageResource) ((ImageResource) var7.nextElement())).method1652();
            } catch (Exception var4) {
                ;
            }
        }

        this.imageResourceTable.removeAllElements();
        this.imageResourceTable = null;
        this.anApplet1396 = null;
    }

    protected void method1640(AApplet var1) {
        this.anAApplet1400 = var1;
    }

    private Image getImage(String var1, boolean var2) {
        Image var3;
        ImageResource var4;
        synchronized (this) {
            var3 = this.getImageFromTable(var1);
            if (var3 != null) {
                return var3;
            }

            var4 = this.getImageResource(var1);
            if (var4 == null) {
                return null;
            }
        }

        this.method1626();
        if (var2) {
            return var4.method1649();
        } else {
            do {
                Tools.sleep(100L);
                var3 = (Image) ((Image) this.imageTable.get(var1));
            } while (var3 == null);

            return var3;
        }
    }

    private Image getImageFromTable(String var1) {
        Image var2 = (Image) ((Image) this.imageTable.get(var1));
        if (var2 != null) {
            return var2;
        } else {
            this.method1626();
            return null;
        }
    }

    private synchronized boolean containsResource(String imageAlias) {
        return this.imageTable.containsKey(imageAlias) ? true : this.getImageResource(imageAlias) != null;
    }

    private synchronized ImageResource getImageResource(String var1) {
        int var2 = this.imageResourceTable.size();

        for (int var3 = 0; var3 < var2; ++var3) {
            ImageResource var4 = (ImageResource) ((ImageResource) this.imageResourceTable.elementAt(var3));
            if (var4.method1648().equals(var1)) {
                return var4;
            }
        }

        return null;
    }

    private boolean method1645() {
        ImageResource var1;
        synchronized (this) {
            if (this.imageResourceTable.isEmpty()) {
                return false;
            }

            var1 = (ImageResource) ((ImageResource) this.imageResourceTable.elementAt(0));
        }

        String imageAlias = var1.method1648();
        Image imageToLoad = var1.method1649();
        var1.method1650();
        if (this.anAApplet1400 != null) {
            this.anAApplet1400.printSUD("ImageTracker: Start loading image \"" + imageAlias + "\"");
        }

        int var4 = 5000;
        byte var5 = 10;

        while (!this.anApplet1396.prepareImage(imageToLoad, this.anApplet1396)) {
            if (this.aBoolean1402) {
                return false;
            }

            var4 -= var5;
            if (var4 <= 0) {
                this.method1647(imageAlias);
                return true;
            }

            Tools.sleep((long) var5);
        }

        if (this.anAApplet1400 != null) {
            this.anAApplet1400.printSUD("ImageTracker: Finished loading image \"" + imageAlias + "\"");
        }

        if (this.aBoolean1397) {
            System.out.println("ImageTracker: Loaded image \"" + imageAlias + "\", moving from \'notloaded\' to \'loaded\'");
        }

        synchronized (this) {
            this.method1646(imageAlias);
            this.imageTable.put(imageAlias, imageToLoad);
            return true;
        }
    }

    private synchronized ImageResource method1646(String var1) {
        int var2 = this.imageResourceTable.size();

        for (int var3 = 0; var3 < var2; ++var3) {
            ImageResource var4 = (ImageResource) ((ImageResource) this.imageResourceTable.elementAt(var3));
            if (var4.method1648().equals(var1)) {
                this.imageResourceTable.removeElementAt(var3);
                return var4;
            }
        }

        return null;
    }

    private synchronized void method1647(String var1) {
        ImageResource var2 = this.method1646(var1);
        if (var2 != null && !var2.method1651()) {
            this.imageResourceTable.addElement(var2);
        }

    }

    static {
        aStringArray1403[0] = "\", moving from \'notloaded\' to \'loaded\'";
        aStringArray1403[1] = "ImageTracker: Loaded image \"";
        aStringArray1403[2] = "ImageTracker: Start loading image \"";
        aStringArray1403[3] = "ImageTracker: Finished loading image \"";
    }
}
