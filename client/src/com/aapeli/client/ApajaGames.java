package com.aapeli.client;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

public class ApajaGames extends Canvas implements MouseListener {

    public static final int anInt144 = 33;
    public static final int anInt145 = 13;
    private static final int[] anIntArray146;
    private static final int[] anIntArray147;
    private Applet anApplet148;
    private URL anURL149;
    private Image anImage150;
    private static final String[] aStringArray151 = new String[2];


    public ApajaGames(Applet var1) {
        this.anApplet148 = var1;
        this.setSize(33, 13);

        try {
            this.anURL149 = new URL("http://www.apaja.com/");
        } catch (MalformedURLException var3) {
            ;
        }

        this.setCursor(new Cursor(12));
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.anImage150 == null) {
            this.anImage150 = this.method222();
        }

        var1.drawImage(this.anImage150, 0, 0, this);
    }

    public void mouseEntered(MouseEvent var1) {
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.anApplet148.getAppletContext().showDocument(this.anURL149, "_blank");
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    private Image method222() {
        Color[] var1 = new Color[16];

        for (int var2 = 0; var2 < 16; ++var2) {
            var1[var2] = new Color(anIntArray146[var2]);
        }

        Image var10 = this.createImage(33, 13);
        Graphics var3 = var10.getGraphics();
        int var4 = 0;
        int var5 = 7;

        for (int var7 = 0; var7 < 13; ++var7) {
            for (int var8 = 0; var8 < 33; ++var8) {
                int var6 = anIntArray147[var4];

                for (int var9 = 0; var9 < var5; ++var9) {
                    var6 >>= 4;
                }

                var6 &= 15;
                var3.setColor(var1[var6]);
                var3.fillRect(var8, var7, 1, 1);
                --var5;
                if (var5 == -1) {
                    ++var4;
                    var5 = 7;
                }
            }
        }

        return var10;
    }

    static {
        aStringArray151[0] = "http://www.apaja.com/";
        aStringArray151[1] = "_blank";
        anIntArray146 = new int[]{0, 16762624, 16752640, 16777215, 16448250, 16250871, 15987700, 15724527, 15461355, 15066597, 14803425, 14671582, 14342874, 13948116, 16742144, 13619151};
        anIntArray147 = new int[]{0, 0, 0, 0, 1118481, 590558003, 860116327, 2022288332, -805240832, 33554435, 1382, 2013855744, 218107921, 551564080, 808730710, 2004914364, -1060110080, 917504, 50331654, 1736968448, 851984, 304144435, 858801216, 1610612896, -859779071, 305065523, 858993733, 1719175578, -1127358720, 805306432, 12356, 1348468736, -1342177040, 50541363, 53674752, 1342638233, -1425220097, 3158016, 805306416, 1080061952, 179306496, -268238848, 50541315, 84281088, 786432, 251671347, 858993459, 1146513288, -1715745571, -1048576, 0, 0, 0, 0};
    }
}
