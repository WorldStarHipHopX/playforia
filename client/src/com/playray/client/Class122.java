package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.JFrame_Sub4_Sub2;
import com.playray.colorgui.ColorButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.security.MessageDigest;

class Class122 implements ActionListener {

    private static final Color aColor1864;
    private AApplet anAApplet1865;
    private MessageDigest aMessageDigest1866;
    private String aString1867;
    private String aString1868;
    private int anInt1869;
    private int anInt1870;
    private JFrame_Sub4_Sub2 aJFrame_Sub4_Sub2_1871;
    private static final String[] aStringArray1872 = new String[11];


    protected Class122(AApplet var1) {
        this.anAApplet1865 = var1;
        this.anInt1869 = var1.param.method2003() ? 1 : 2;
        this.anInt1870 = 0;

        try {
            this.aMessageDigest1866 = MessageDigest.getInstance("MD5");
        } catch (Exception var3) {
            this.anInt1869 = 0;
        } catch (Error var4) {
            this.anInt1869 = 0;
        }

        this.aString1867 = var1.param.method2004();
        this.aString1868 = var1.param.method2005();
        if (this.aString1867 == null || this.aString1868 == null) {
            this.anInt1869 = 0;
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (this.aJFrame_Sub4_Sub2_1871 == null) {
            this.method1996();
        } else {
            this.aJFrame_Sub4_Sub2_1871.toFront();
        }

    }

    protected ColorButton method1991() {
        if (this.anInt1869 != 0 && this.anAApplet1865.param.getSession() == null) {
            this.anInt1869 = 0;
        }

        if (this.anInt1869 == 0) {
            return null;
        } else {
            ColorButton var1 = new ColorButton(this.anAApplet1865.aTextManager3821.getShared("TellFriend_ExtButton"));
            var1.setBackground(aColor1864);
            var1.setForeground(Color.black);
            var1.setSize(90, 20);
            var1.addActionListener(this);
            return var1;
        }
    }

    protected boolean method1992() {
        if (this.anInt1869 != 1) {
            return false;
        } else if (this.anAApplet1865.param.getSession() == null) {
            this.anInt1869 = 0;
            return false;
        } else {
            ++this.anInt1870;
            if (this.anInt1870 == 3) {
                try {
                    this.method1996();
                    return true;
                } catch (Exception var2) {
                    ;
                }
            }

            return false;
        }
    }

    protected void method1993() {
        try {
            if (this.aJFrame_Sub4_Sub2_1871 != null) {
                this.aJFrame_Sub4_Sub2_1871.close();
            }
        } catch (Exception var2) {
            ;
        }

    }

    protected boolean method1994(String[] var1, String var2, int var3, int var4, int var5) {
        try {
            int var6 = var2.length();
            if (var6 > 1500) {
                var2 = var2.substring(0, 1497).trim() + "...";
            }

            String var7 = this.method1997(var1, var2);
            var7 = method2000(var7 + "Voi");
            byte[] var8 = this.method1998(var7 + (char) var3 + (char) var4 + (char) var4 + (char) var5);
            String var9 = this.method1999(var8);
            String var10 = "session=" + method2000(this.anAApplet1865.param.getSession()) + "&";
            var6 = var1.length;

            for (int var11 = 0; var11 < var6; ++var11) {
                if (var1[var11] != null) {
                    var10 = var10 + "emails[]=" + method2000(var1[var11]) + "&";
                }
            }

            if (var2 != null) {
                var10 = var10 + "message=" + method2000(var2) + "&";
            }

            var10 = var10 + "hash=" + var9;
            URL var14 = new URL(this.aString1867 + "?" + var10);
            this.anAApplet1865.param.method2002().showDocument(var14, this.aString1868);
            return true;
        } catch (Exception var12) {
            ;
        } catch (Error var13) {
            ;
        }

        return false;
    }

    protected void method1995() {
        this.aJFrame_Sub4_Sub2_1871 = null;
    }

    private void method1996() {
        this.aJFrame_Sub4_Sub2_1871 = new JFrame_Sub4_Sub2(this.anAApplet1865, this);
        this.aJFrame_Sub4_Sub2_1871.method2344(this.anAApplet1865);
        this.anInt1869 = 2;
    }

    private String method1997(String[] var1, String var2) {
        String var3 = "";
        int var4 = var1.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            if (var1[var5] != null) {
                var3 = var3 + var1[var5];
            }
        }

        if (var2 != null) {
            var3 = var3 + var2;
        }

        var3 = var3 + "Miksei";
        return var3 + "Aita".replace('t', 'n');
    }

    private byte[] method1998(String var1) {
        this.aMessageDigest1866.reset();
        this.aMessageDigest1866.update((var1 + "Perjantai").getBytes());
        return this.aMessageDigest1866.digest();
    }

    private String method1999(byte[] var1) {
        int var2 = var1.length;
        StringBuffer var3 = new StringBuffer(var2 * 2);

        for (int var4 = 0; var4 < var2; ++var4) {
            int var5 = var1[var4] >= 0 ? var1[var4] : 256 + var1[var4];
            if (var5 < 16) {
                var3.append('0');
            }

            var3.append(Integer.toHexString(var5));
        }

        return var3.toString();
    }

    private static String method2000(String var0) {
        char[] var1 = var0.toCharArray();
        StringBuffer var2 = new StringBuffer(var1.length);

        for (int var3 = 0; var3 < var1.length; ++var3) {
            if ((var1[var3] < 97 || var1[var3] > 122) && (var1[var3] < 65 || var1[var3] > 90) && (var1[var3] < 48 || var1[var3] > 57)) {
                char var4 = var1[var3];
                if (var4 > 255) {
                    var4 = 255;
                }

                var2.append('%');
                var2.append(Integer.toHexString(var4 / 16));
                var2.append(Integer.toHexString(var4 % 16));
            } else {
                var2.append(var1[var3]);
            }
        }

        return var2.toString();
    }

    static {
        aStringArray1872[0] = "Perjantai";
        aStringArray1872[1] = "TellFriend_ExtButton";
        aStringArray1872[2] = "Miksei";
        aStringArray1872[3] = "Aita";
        aStringArray1872[4] = "MD5";
        aStringArray1872[5] = "session=";
        aStringArray1872[6] = "hash=";
        aStringArray1872[7] = "emails[]=";
        aStringArray1872[8] = "Voi";
        aStringArray1872[9] = "...";
        aStringArray1872[10] = "message=";
        aColor1864 = new Color(64, 160, 255);
    }
}
