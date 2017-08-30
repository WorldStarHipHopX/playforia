package com.playray.client;

import com.playray.client.Class116;
import com.playray.tools.Tools;

import java.awt.Image;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.JApplet;

class Class115 implements Runnable {

    private static final String aString1814 = "N\t";
    private static final String aString1815 = "S\t";
    private static final String aString1816 = "C\t";
    private JApplet aJApplet1817;
    private boolean aBoolean1818;
    private Vector aVector1819;
    private Hashtable aHashtable1820;
    private Thread aThread1821;
    private boolean aBoolean1822;
    private static final String[] aStringArray1823 = new String[4];


    protected Class115(JApplet var1, boolean var2) {
        this.aJApplet1817 = var1;
        this.aBoolean1818 = var2;
        this.aVector1819 = new Vector();
        this.aHashtable1820 = new Hashtable();
        this.aBoolean1822 = false;
    }

    public void run() {
        while (!this.aBoolean1822 && this.method1967()) {
            Tools.sleep(10L);
        }

        synchronized (this) {
            this.aThread1821 = null;
        }
    }

    protected void method1946(String var1, Image var2) {
        var1 = "N\t" + var1;
        synchronized (this) {
            if (!this.method1965(var1)) {
                this.aVector1819.addElement(new Class116(this, var1, var2));
            }
        }
    }

    protected void method1947(String var1, Image var2) {
        var1 = "S\t" + var1;
        synchronized (this) {
            if (!this.method1965(var1)) {
                this.aVector1819.insertElementAt(new Class116(this, var1, var2), 0);
            }
        }
    }

    protected void method1948(String var1, Image var2) {
        var1 = "C\t" + var1;
        synchronized (this) {
            if (!this.method1965(var1)) {
                this.aVector1819.addElement(new Class116(this, var1, var2));
            }
        }
    }

    protected synchronized void method1949() {
        if (this.aThread1821 == null) {
            if (!this.aVector1819.isEmpty()) {
                if (!this.aBoolean1822) {
                    this.aThread1821 = new Thread(this);
                    this.aThread1821.start();
                }
            }
        }
    }

    protected Image method1950(String var1) {
        return this.method1963("N\t" + var1, false);
    }

    protected Image method1951(String var1) {
        return this.method1964("N\t" + var1);
    }

    protected Image method1952(String var1) {
        return this.method1963("N\t" + var1, true);
    }

    protected Image method1953(String var1) {
        return this.method1963("S\t" + var1, false);
    }

    protected Image method1954(String var1) {
        return this.method1964("S\t" + var1);
    }

    protected Image method1955(String var1) {
        return this.method1964("C\t" + var1);
    }

    protected boolean method1956(String var1) {
        return this.method1965("N\t" + var1);
    }

    protected boolean method1957(String var1) {
        return this.method1965("S\t" + var1);
    }

    protected boolean method1958(String var1) {
        return this.method1965("C\t" + var1);
    }

    protected void method1959(String var1) {
        var1 = "N\t" + var1;
        synchronized (this) {
            if (this.aHashtable1820.remove(var1) == null) {
                this.method1968(var1);
            }

        }
    }

    protected int method1960() {
        return this.aVector1819.size();
    }

    protected int method1961() {
        return this.aHashtable1820.size();
    }

    protected void method1962() {
        this.aBoolean1822 = true;
        if (this.aThread1821 != null) {
            int var1 = 500;
            byte var2 = 50;

            while (this.aThread1821 != null && var1 > 0) {
                var1 -= var2;
                Tools.sleep((long) var2);
            }
        }

        Enumeration var6 = this.aHashtable1820.elements();

        while (var6.hasMoreElements()) {
            try {
                ((Image) ((Image) var6.nextElement())).flush();
            } catch (Exception var5) {
                ;
            }
        }

        this.aHashtable1820.clear();
        this.aHashtable1820 = null;
        Enumeration var7 = this.aVector1819.elements();

        while (var7.hasMoreElements()) {
            try {
                ((Class116) ((Class116) var7.nextElement())).method1974();
            } catch (Exception var4) {
                ;
            }
        }

        this.aVector1819.removeAllElements();
        this.aVector1819 = null;
    }

    private Image method1963(String var1, boolean var2) {
        Image var3;
        Class116 var4;
        synchronized (this) {
            var3 = this.method1964(var1);
            if (var3 != null) {
                return var3;
            }

            var4 = this.method1966(var1);
            if (var4 == null) {
                return null;
            }
        }

        this.method1949();
        if (var2) {
            return var4.method1971();
        } else {
            do {
                Tools.sleep(100L);
                var3 = (Image) ((Image) this.aHashtable1820.get(var1));
            } while (var3 == null);

            return var3;
        }
    }

    private Image method1964(String var1) {
        Image var2 = (Image) ((Image) this.aHashtable1820.get(var1));
        if (var2 != null) {
            return var2;
        } else {
            this.method1949();
            return null;
        }
    }

    private synchronized boolean method1965(String var1) {
        return this.aHashtable1820.containsKey(var1) ? true : this.method1966(var1) != null;
    }

    private synchronized Class116 method1966(String var1) {
        int var2 = this.aVector1819.size();

        for (int var3 = 0; var3 < var2; ++var3) {
            Class116 var4 = (Class116) ((Class116) this.aVector1819.elementAt(var3));
            if (var4.method1970().equals(var1)) {
                return var4;
            }
        }

        return null;
    }

    private boolean method1967() {
        Class116 var1;
        synchronized (this) {
            if (this.aVector1819.isEmpty()) {
                return false;
            }

            var1 = (Class116) ((Class116) this.aVector1819.elementAt(0));
        }

        var1.method1972();
        String var2 = var1.method1970();
        if (this.aBoolean1818) {
            System.out.println("ImageTracker: Start loading image \"" + var2 + "\"");
        }

        int var3 = 5000;
        byte var4 = 10;
        Image var5 = var1.method1971();

        while (!this.aJApplet1817.prepareImage(var5, this.aJApplet1817)) {
            if (this.aBoolean1822) {
                return false;
            }

            var3 -= var4;
            if (var3 <= 0) {
                this.method1969(var2);
                return true;
            }

            Tools.sleep((long) var4);
        }

        if (this.aBoolean1818) {
            System.out.println("ImageTracker: Finished loading image \"" + var2 + "\"");
        }

        if (this.aBoolean1818) {
            System.out.println("ImageTracker: Loaded image \"" + var2 + "\", moving from \'notloaded\' to \'loaded\'");
        }

        synchronized (this) {
            this.method1968(var2);
            this.aHashtable1820.put(var2, var5);
            return true;
        }
    }

    private synchronized Class116 method1968(String var1) {
        int var2 = this.aVector1819.size();

        for (int var3 = 0; var3 < var2; ++var3) {
            Class116 var4 = (Class116) ((Class116) this.aVector1819.elementAt(var3));
            if (var4.method1970().equals(var1)) {
                this.aVector1819.removeElementAt(var3);
                return var4;
            }
        }

        return null;
    }

    private synchronized void method1969(String var1) {
        Class116 var2 = this.method1968(var1);
        if (var2 != null && !var2.method1973()) {
            this.aVector1819.addElement(var2);
        }

    }

    static {
        aStringArray1823[0] = "ImageTracker: Finished loading image \"";
        aStringArray1823[1] = "ImageTracker: Start loading image \"";
        aStringArray1823[2] = "\", moving from \'notloaded\' to \'loaded\'";
        aStringArray1823[3] = "ImageTracker: Loaded image \"";
    }
}
