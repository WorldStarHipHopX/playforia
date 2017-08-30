package com.playray.settingsgui;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.settingsgui.GuiListener;
import com.playray.settingsgui.GuiListenerExt;
import com.playray.settingsgui.Rule;
import com.playray.settingsgui.Unit;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

public final class SPanel_Sub50 extends SPanel {

    private static final Font[] aFontArray4681 = new Font[]{new Font("Dialog", 0, 11), new Font("Dialog", 0, 12), new Font("Dialog", 1, 12), new Font("Dialog", 1, 15)};
    private Vector aVector4682 = new Vector();
    private Vector aVector4683 = new Vector();
    private boolean aBoolean4684 = false;
    private int anInt4685;
    private int anInt4686;
    private Unit[] anUnitArray4687;
    private Rule[] aRuleArray4688;
    private int anInt4689;
    private int anInt4690;
    private int anInt4691;
    private int anInt4692;
    private int anInt4693;
    private Vector aVector4694 = new Vector();
    private Vector aVector4695 = new Vector();
    private Color aColor4696;
    private static final String aString4697 = "Dialog";


    public void paintContent(Graphics2D var1) {
        if (this.aBoolean4684) {
            var1.setColor(this.getForeground());
            int var2 = this.anInt4693;

            for (int var7 = 0; var7 < this.anInt4685; ++var7) {
                int var3 = this.anUnitArray4687[var7].method2224();
                if (this.anUnitArray4687[var7].method2222()) {
                    int var4 = this.anUnitArray4687[var7].method2229();
                    if (var4 != 0) {
                        var1.setFont(aFontArray4681[this.anUnitArray4687[var7].method2230()]);
                        String var6 = this.anUnitArray4687[var7].method2228();
                        int var5 = var2 + var3 / 2 + 4;
                        if (var4 == 1) {
                            StringDraw.drawOutlinedStringWithMaxWidth(var1, this.aColor4696, var6, this.anInt4692, var5, 0, this.anInt4689 - this.anInt4691 * 2);
                        }

                        if (var4 == 2) {
                            StringDraw.drawOutlinedString(var1, this.aColor4696, var6, this.anInt4692 - this.anInt4691 / 2, var5, 1);
                        }

                        if (var4 == 3) {
                            StringDraw.drawOutlinedString(var1, this.aColor4696, var6, this.anInt4692 + this.anInt4691 / 2, var5, -1);
                        }
                    }
                }

                var2 += var3 + this.anInt4693;
            }

        }
    }

    public void setOutlineColor(Color var1) {
        this.aColor4696 = var1;
    }

    public void addUnit(Unit var1) {
        if (!this.aBoolean4684) {
            var1.method2221(this);
            this.aVector4682.addElement(var1);
        }
    }

    public void addRule(Rule var1) {
        if (!this.aBoolean4684) {
            this.aVector4683.addElement(var1);
        }
    }

    public void ready() {
        if (!this.aBoolean4684) {
            this.aBoolean4684 = true;
            this.anInt4685 = this.aVector4682.size();
            this.anUnitArray4687 = new Unit[this.anInt4685];

            int var1;
            for (var1 = 0; var1 < this.anInt4685; ++var1) {
                this.anUnitArray4687[var1] = (Unit) ((Unit) this.aVector4682.elementAt(var1));
            }

            this.aVector4682 = null;
            this.anInt4686 = this.aVector4683.size();
            this.aRuleArray4688 = new Rule[this.anInt4686];

            for (var1 = 0; var1 < this.anInt4686; ++var1) {
                this.aRuleArray4688[var1] = (Rule) ((Rule) this.aVector4683.elementAt(var1));
            }

            this.aVector4683 = null;
            Dimension var9 = this.getSize();
            this.anInt4689 = var9.width;
            this.anInt4690 = var9.height;
            double var2 = this.method3007();
            this.anInt4691 = 6;
            this.anInt4692 = this.anInt4689 / 2;
            this.anInt4693 = (int) (5.0D * var2 + 0.1D);
            Color var4 = this.getBackground();
            Color var5 = this.getForeground();
            int var6 = this.anInt4693;

            for (int var8 = 0; var8 < this.anInt4685; ++var8) {
                int var7 = this.anUnitArray4687[var8].method2226();
                if (!this.anUnitArray4687[var8].method2227()) {
                    var7 = (int) ((double) var7 * var2 + 0.1D);
                }

                this.anUnitArray4687[var8].method2236(var4, var5);
                this.method3008(this.anUnitArray4687[var8], var6, var7);
                this.anUnitArray4687[var8].method2223(var7);
                var6 += var7 + this.anInt4693;
            }

            this.repaint();
        }
    }

    public void addGuiListener(GuiListener var1) {
        this.aVector4694.addElement(var1);
    }

    public void removeGuiListener(GuiListener var1) {
        this.aVector4694.removeElement(var1);
    }

    public void addGuiListenerExt(GuiListenerExt var1) {
        this.aVector4695.addElement(var1);
    }

    public void removeGuiListenerExt(GuiListenerExt var1) {
        this.aVector4695.removeElement(var1);
    }

    public String getSaveableData() {
        String var1 = "";
        boolean var3 = true;

        for (int var4 = 0; var4 < this.anInt4685; ++var4) {
            String var2 = this.anUnitArray4687[var4].method2234();
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

            for (int var3 = 0; var3 < this.anInt4685; ++var3) {
                if (this.anUnitArray4687[var3].method2233()) {
                    this.anUnitArray4687[var3].method2235(var2.nextToken());
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

            for (int var3 = 0; var3 < this.anInt4686; ++var3) {
                if (this.aRuleArray4688[var3].method2219()) {
                    var2 = true;
                }
            }

            ++var1;
        } while (var2 && var1 < this.anInt4685);

        this.repaint();
    }

    protected void method3004(Unit var1) {
        this.checkAllRules();
        this.method3005(var1);
    }

    protected void method3005(Unit var1) {
        Enumeration var2 = this.aVector4694.elements();

        while (var2.hasMoreElements()) {
            ((GuiListener) ((GuiListener) var2.nextElement())).unitValueChanged();
        }

        var2 = this.aVector4695.elements();

        while (var2.hasMoreElements()) {
            ((GuiListenerExt) ((GuiListenerExt) var2.nextElement())).unitValueChanged(var1);
        }

    }

    protected void method3006(Unit var1) {
        Enumeration var2 = this.aVector4694.elements();

        while (var2.hasMoreElements()) {
            ((GuiListener) ((GuiListener) var2.nextElement())).unitButtonClicked();
        }

        var2 = this.aVector4695.elements();

        while (var2.hasMoreElements()) {
            ((GuiListenerExt) ((GuiListenerExt) var2.nextElement())).unitButtonClicked(var1);
        }

    }

    private double method3007() {
        int var1 = 0;
        int var2 = 0;

        for (int var4 = 0; var4 < this.anInt4685; ++var4) {
            int var3 = this.anUnitArray4687[var4].method2226();
            if (this.anUnitArray4687[var4].method2227()) {
                var1 += var3;
            } else {
                var2 += var3;
            }

            if (var4 < this.anInt4685 - 1) {
                var2 += 5;
            }
        }

        if (var1 + var2 <= this.anInt4690) {
            return 1.0D;
        } else {
            double var6 = 1.0D * (double) (this.anInt4690 - var1) / (double) var2;
            if (var6 < 0.5D) {
                var6 = 0.5D;
            }

            return var6;
        }
    }

    private void method3008(Unit var1, int var2, int var3) {
        Component var4 = var1.method2231();
        if (var4 != null) {
            var4.setBounds(this.anInt4692 + this.anInt4691 / 2, var2, (int) ((double) (this.anInt4689 - this.anInt4691 - this.anInt4691 / 2 - this.anInt4692) * var1.method2225() + 0.5D), var3);
            this.add(var4);
        } else {
            Component[] var5 = var1.method2232();
            if (var5 != null) {
                int var6 = var5.length;
                int var7 = this.anInt4692 + this.anInt4691 / 2;
                int var8 = (int) ((double) (this.anInt4689 - this.anInt4691 - this.anInt4691 / 2 - this.anInt4692) * var1.method2225() + 0.5D);
                int var9 = var8 / var6;

                for (int var10 = 0; var10 < var6; ++var10) {
                    var5[var10].setBounds(var7 + var10 * var9, var2, var9 - 5, var3);
                    this.add(var5[var10]);
                }
            }

        }
    }

}
