package com.aapeli.settingsgui;

import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;
import com.aapeli.settingsgui.GuiListener;
import com.aapeli.settingsgui.GuiListenerExt;
import com.aapeli.settingsgui.Rule;
import com.aapeli.settingsgui.Unit;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

public final class LobbyRoomSettingsPanel extends IPanel {

    private static final Font[] aFontArray3506 = new Font[]{new Font("Dialog", 0, 11), new Font("Dialog", 0, 12), new Font("Dialog", 1, 12), new Font("Dialog", 1, 15)};
    private Vector aVector3507 = new Vector();
    private Vector aVector3508 = new Vector();
    private boolean aBoolean3509 = false;
    private int anInt3510;
    private int anInt3511;
    private Unit[] anUnitArray3512;
    private Rule[] aRuleArray3513;
    private int anInt3514;
    private int anInt3515;
    private int anInt3516;
    private int anInt3517;
    private int anInt3518;
    private Vector aVector3519 = new Vector();
    private Vector aVector3520 = new Vector();
    private Color aColor3521;
    private Image anImage3522;
    private int anInt3523;
    private int anInt3524;
    private Image anImage3525;
    private Graphics aGraphics3526;
    private static final String aString3527 = "Dialog";


    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.aBoolean3509) {
            if (this.anImage3525 == null) {
                this.anImage3525 = this.createImage(this.anInt3514, this.anInt3515);
                this.aGraphics3526 = this.anImage3525.getGraphics();
            }

            if (this.anImage3522 != null) {
                this.aGraphics3526.drawImage(this.anImage3522, 0, 0, this.anInt3514, this.anInt3515, this.anInt3523, this.anInt3524, this.anInt3523 + this.anInt3514, this.anInt3524 + this.anInt3515, this);
            } else {
                this.drawBackground(this.aGraphics3526);
            }

            this.aGraphics3526.setColor(this.getForeground());
            int var2 = this.anInt3518;

            for (int var7 = 0; var7 < this.anInt3510; ++var7) {
                int var3 = this.anUnitArray3512[var7].method1833();
                if (this.anUnitArray3512[var7].method1831()) {
                    int var4 = this.anUnitArray3512[var7].method1839();
                    if (var4 != 0) {
                        this.aGraphics3526.setFont(aFontArray3506[this.anUnitArray3512[var7].method1840()]);
                        String var6 = this.anUnitArray3512[var7].method1838();
                        int var5 = var2 + var3 / 2 + 4;
                        if (var4 == 1) {
                            StringDraw.drawOutlinedStringWithMaxWidth(this.aGraphics3526, this.aColor3521, var6, this.anInt3517, var5, 0, this.anInt3514 - this.anInt3516 * 2);
                        }

                        if (var4 == 2) {
                            StringDraw.drawOutlinedString(this.aGraphics3526, this.aColor3521, var6, this.anInt3517 - this.anInt3516 / 2, var5, 1);
                        }

                        if (var4 == 3) {
                            StringDraw.drawOutlinedString(this.aGraphics3526, this.aColor3521, var6, this.anInt3517 + this.anInt3516 / 2, var5, -1);
                        }
                    }
                }

                var2 += var3 + this.anInt3518;
            }

            var1.drawImage(this.anImage3525, 0, 0, this);
        }
    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        this.anImage3522 = var1;
        this.anInt3523 = var2;
        this.anInt3524 = var3;
        if (this.aBoolean3509) {
            this.method943();
        }

        this.repaint();
    }

    public void setOutlineColor(Color var1) {
        this.aColor3521 = var1;
    }

    public void addUnit(Unit var1) {
        if (!this.aBoolean3509) {
            var1.method1829(this);
            this.aVector3507.addElement(var1);
        }
    }

    public void addRule(Rule var1) {
        if (!this.aBoolean3509) {
            this.aVector3508.addElement(var1);
        }
    }

    public void ready() {
        if (!this.aBoolean3509) {
            this.aBoolean3509 = true;
            this.anInt3510 = this.aVector3507.size();
            this.anUnitArray3512 = new Unit[this.anInt3510];

            int var1;
            for (var1 = 0; var1 < this.anInt3510; ++var1) {
                this.anUnitArray3512[var1] = (Unit) ((Unit) this.aVector3507.elementAt(var1));
            }

            this.aVector3507 = null;
            this.anInt3511 = this.aVector3508.size();
            this.aRuleArray3513 = new Rule[this.anInt3511];

            for (var1 = 0; var1 < this.anInt3511; ++var1) {
                this.aRuleArray3513[var1] = (Rule) ((Rule) this.aVector3508.elementAt(var1));
            }

            this.aVector3508 = null;
            Dimension var9 = this.getSize();
            this.anInt3514 = var9.width;
            this.anInt3515 = var9.height;
            double var2 = this.method941();
            this.anInt3516 = 6;
            this.anInt3517 = this.anInt3514 / 2;
            this.anInt3518 = (int) (5.0D * var2 + 0.1D);
            this.setLayout((LayoutManager) null);
            Color var4 = this.getBackground();
            Color var5 = this.getForeground();
            int var6 = this.anInt3518;

            for (int var8 = 0; var8 < this.anInt3510; ++var8) {
                int var7 = this.anUnitArray3512[var8].method1836();
                if (!this.anUnitArray3512[var8].method1837()) {
                    var7 = (int) ((double) var7 * var2 + 0.1D);
                }

                this.anUnitArray3512[var8].method1846(var4, var5);
                this.method942(this.anUnitArray3512[var8], var6, var7);
                this.anUnitArray3512[var8].method1832(var7);
                var6 += var7 + this.anInt3518;
            }

            if (this.anImage3522 != null) {
                this.method943();
            }

            this.repaint();
        }
    }

    public void addGuiListener(GuiListener var1) {
        this.aVector3519.addElement(var1);
    }

    public void removeGuiListener(GuiListener var1) {
        this.aVector3519.removeElement(var1);
    }

    public void addGuiListenerExt(GuiListenerExt var1) {
        this.aVector3520.addElement(var1);
    }

    public void removeGuiListenerExt(GuiListenerExt var1) {
        this.aVector3520.removeElement(var1);
    }

    public String getSaveableData() {
        String var1 = "";
        boolean var3 = true;

        for (int var4 = 0; var4 < this.anInt3510; ++var4) {
            String var2 = this.anUnitArray3512[var4].method1844();
            if (var2 != null) {
                if (!var3) {
                    var1 = var1 + "^";
                } else {
                    var3 = false;
                }

                var1 = var1 + var2;
            }
        }

        return var1;
    }

    public void setSaveableData(String var1) {
        if (var1 != null) {
            StringTokenizer var2 = new StringTokenizer(var1, "^");

            for (int var3 = 0; var3 < this.anInt3510; ++var3) {
                if (this.anUnitArray3512[var3].method1843()) {
                    this.anUnitArray3512[var3].method1845(var2.nextToken());
                }
            }
        }

        this.checkAllRules();
    }

    public void checkAllRules() {
        int var1 = 0;

        boolean var2;
        do {
            var2 = false;

            for (int var3 = 0; var3 < this.anInt3511; ++var3) {
                if (this.aRuleArray3513[var3].method1827()) {
                    var2 = true;
                }
            }

            ++var1;
        } while (var2 && var1 < this.anInt3510);

        this.repaint();
    }

    protected void method938(Unit var1) {
        this.checkAllRules();
        this.method939(var1);
    }

    protected void method939(Unit var1) {
        Enumeration var2 = this.aVector3519.elements();

        while (var2.hasMoreElements()) {
            ((GuiListener) ((GuiListener) var2.nextElement())).unitValueChanged();
        }

        var2 = this.aVector3520.elements();

        while (var2.hasMoreElements()) {
            ((GuiListenerExt) ((GuiListenerExt) var2.nextElement())).unitValueChanged(var1);
        }

    }

    protected void method940(Unit var1) {
        Enumeration var2 = this.aVector3519.elements();

        while (var2.hasMoreElements()) {
            ((GuiListener) ((GuiListener) var2.nextElement())).unitButtonClicked();
        }

        var2 = this.aVector3520.elements();

        while (var2.hasMoreElements()) {
            ((GuiListenerExt) ((GuiListenerExt) var2.nextElement())).unitButtonClicked(var1);
        }

    }

    private double method941() {
        int var1 = 0;
        int var2 = 0;

        for (int var4 = 0; var4 < this.anInt3510; ++var4) {
            int var3 = this.anUnitArray3512[var4].method1836();
            if (this.anUnitArray3512[var4].method1837()) {
                var1 += var3;
            } else {
                var2 += var3;
            }

            if (var4 < this.anInt3510 - 1) {
                var2 += 5;
            }
        }

        if (var1 + var2 <= this.anInt3515) {
            return 1.0D;
        } else {
            double var6 = 1.0D * (double) (this.anInt3515 - var1) / (double) var2;
            if (var6 < 0.5D) {
                var6 = 0.5D;
            }

            return var6;
        }
    }

    private void method942(Unit var1, int var2, int var3) {
        Component var4 = var1.method1841();
        if (var4 != null) {
            var4.setBounds(this.anInt3517 + this.anInt3516 / 2, var2, (int) ((double) (this.anInt3514 - this.anInt3516 - this.anInt3516 / 2 - this.anInt3517) * var1.method1834() + 0.5D), var3);
            this.add(var4);
        } else {
            Component[] var5 = var1.method1842();
            if (var5 != null) {
                int var6 = var5.length;
                int var7 = this.anInt3517 + this.anInt3516 / 2;
                int var8 = (int) ((double) (this.anInt3514 - this.anInt3516 - this.anInt3516 / 2 - this.anInt3517) * var1.method1834() + 0.5D);
                int var9 = var8 / var6;

                for (int var10 = 0; var10 < var6; ++var10) {
                    var5[var10].setBounds(var7 + var10 * var9, var2, var9 - 5, var3);
                    this.add(var5[var10]);
                }
            }

        }
    }

    private void method943() {
        for (int var1 = 0; var1 < this.anInt3510; ++var1) {
            this.anUnitArray3512[var1].method1835(this.anImage3522, this.anInt3523, this.anInt3524);
        }

    }

}
