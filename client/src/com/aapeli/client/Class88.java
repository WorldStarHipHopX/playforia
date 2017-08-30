package com.aapeli.client;

import com.aapeli.client.Frame_Sub3_Sub3;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.security.MessageDigest;

class Class88 implements ActionListener {

    private static final Color aColor1499;
    private Parameters aParameters1500;
    private TextManager aTextManager1501;
    private ImageManager anImageManager1502;
    private MessageDigest aMessageDigest1503;
    private String aString1504;
    private String aString1505;
    private int anInt1506;
    private int anInt1507;
    private Frame_Sub3_Sub3 aFrame_Sub3_Sub3_1508;
    private static final String[] aStringArray1509 = new String[11];


    protected Class88(Parameters var1, TextManager var2, ImageManager var3) {
        this.aParameters1500 = var1;
        this.aTextManager1501 = var2;
        this.anImageManager1502 = var3;
        this.anInt1506 = var1.method1655() ? 1 : 2;
        this.anInt1507 = 0;

        try {
            this.aMessageDigest1503 = MessageDigest.getInstance("MD5");
        } catch (Exception var5) {
            this.anInt1506 = 0;
        } catch (Error var6) {
            this.anInt1506 = 0;
        }

        this.aString1504 = var1.method1656();
        this.aString1505 = var1.method1657();
        if (this.aString1504 == null || this.aString1505 == null) {
            this.anInt1506 = 0;
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (this.aFrame_Sub3_Sub3_1508 == null) {
            this.method1704();
        } else {
            this.aFrame_Sub3_Sub3_1508.toFront();
        }

    }

    protected ColorButton method1699() {
        if (this.anInt1506 != 0 && this.aParameters1500.getSession() == null) {
            this.anInt1506 = 0;
        }

        if (this.anInt1506 == 0) {
            return null;
        } else {
            ColorButton var1 = new ColorButton(this.aTextManager1501.getShared("TellFriend_ExtButton"));
            var1.setBackground(aColor1499);
            var1.setForeground(Color.black);
            var1.setSize(90, 20);
            var1.addActionListener(this);
            return var1;
        }
    }

    protected boolean method1700() {
        if (this.anInt1506 != 1) {
            return false;
        } else if (this.aParameters1500.getSession() == null) {
            this.anInt1506 = 0;
            return false;
        } else {
            ++this.anInt1507;
            if (this.anInt1507 == 3) {
                try {
                    this.method1704();
                    return true;
                } catch (Exception var2) {
                    ;
                }
            }

            return false;
        }
    }

    protected void method1701() {
        try {
            if (this.aFrame_Sub3_Sub3_1508 != null) {
                this.aFrame_Sub3_Sub3_1508.close();
            }
        } catch (Exception var2) {
            ;
        }

    }

    protected boolean method1702(String[] var1, String var2, int var3, int var4, int var5) {
        try {
            int var6 = var2.length();
            if (var6 > 1500) {
                var2 = var2.substring(0, 1497).trim() + "...";
            }

            String var7 = this.method1705(var1, var2);
            var7 = method1708(var7 + "Voi");
            byte[] var8 = this.method1706(var7 + (char) var3 + (char) var4 + (char) var4 + (char) var5);
            String var9 = this.method1707(var8);
            String var10 = "session=" + method1708(this.aParameters1500.getSession()) + "&";
            var6 = var1.length;

            for (int var11 = 0; var11 < var6; ++var11) {
                if (var1[var11] != null) {
                    var10 = var10 + "emails[]=" + method1708(var1[var11]) + "&";
                }
            }

            if (var2 != null) {
                var10 = var10 + "message=" + method1708(var2) + "&";
            }

            var10 = var10 + "hash=" + var9;
            URL var14 = new URL(this.aString1504 + "?" + var10);
            this.aParameters1500.method1654().showDocument(var14, this.aString1505);
            return true;
        } catch (Exception var12) {
            ;
        } catch (Error var13) {
            ;
        }

        return false;
    }

    protected void method1703() {
        this.aFrame_Sub3_Sub3_1508 = null;
    }

    private void method1704() {
        this.aFrame_Sub3_Sub3_1508 = new Frame_Sub3_Sub3(this.aTextManager1501, this.anImageManager1502, this);
        this.aFrame_Sub3_Sub3_1508.method241(this.aParameters1500.getApplet());
        this.anInt1506 = 2;
    }

    private String method1705(String[] var1, String var2) {
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

    private byte[] method1706(String var1) {
        this.aMessageDigest1503.reset();
        this.aMessageDigest1503.update((var1 + "Perjantai").getBytes());
        return this.aMessageDigest1503.digest();
    }

    private String method1707(byte[] var1) {
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

    private static String method1708(String var0) {
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
        aStringArray1509[0] = "MD5";
        aStringArray1509[1] = "TellFriend_ExtButton";
        aStringArray1509[2] = "Voi";
        aStringArray1509[3] = "...";
        aStringArray1509[4] = "message=";
        aStringArray1509[5] = "session=";
        aStringArray1509[6] = "hash=";
        aStringArray1509[7] = "emails[]=";
        aStringArray1509[8] = "Miksei";
        aStringArray1509[9] = "Aita";
        aStringArray1509[10] = "Perjantai";
        aColor1499 = new Color(64, 160, 255);
    }
}
