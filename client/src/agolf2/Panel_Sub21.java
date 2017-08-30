package agolf2;

import com.aapeli.colorgui.ColorButton;
import com.aapeli.colorgui.MultiColorList;
import com.aapeli.colorgui.MultiColorListItem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.StringTokenizer;

class Panel_Sub21 extends Panel implements ItemListener, ActionListener {

    private static final String[] aStringArray567;
    private Class58_Sub1 aClass58_Sub1_568;
    private int anInt569;
    private int anInt570;
    private MultiColorList aMultiColorList571;
    private ColorButton aColorButton572;
    private ColorButton aColorButton573;
    private ColorButton aColorButton574;
    private ColorButton aColorButton575;
    private ColorButton aColorButton576;
    private static final String[] aStringArray577 = new String[20];


    public Panel_Sub21(Class58_Sub1 var1, int var2, int var3) {
        this.aClass58_Sub1_568 = var1;
        this.anInt569 = var2;
        this.anInt570 = var3;
        this.setSize(var2, var3);
        this.method456();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        var1.setColor(Color.BLACK);
        var1.fillRect(0, 0, this.anInt569, this.anInt570);
    }

    public void itemStateChanged(ItemEvent var1) {
        int var2 = -1;
        MultiColorListItem var3 = this.aMultiColorList571.getSelectedItem();
        if (var3 != null) {
            var2 = ((Integer) ((Integer) var3.getData())).intValue();
        }

        this.aColorButton575.setVisible(var2 >= 0 && var2 != 0);
        this.aColorButton574.setVisible(var2 >= 0 && var2 != 1);
        this.aColorButton573.setVisible(var2 >= 0 && var2 != 2);
        this.aColorButton572.setVisible(var2 >= 0 && var2 != 3);
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aColorButton576) {
            this.method459("back");
        } else {
            MultiColorListItem var3 = this.aMultiColorList571.getSelectedItem();
            if (var3 != null) {
                byte var4;
                if (var2 == this.aColorButton572) {
                    var4 = 3;
                } else if (var2 == this.aColorButton573) {
                    var4 = 2;
                } else if (var2 == this.aColorButton574) {
                    var4 = 1;
                } else {
                    var4 = 0;
                }

                this.method459("change\t" + var3.getString(0) + "\t" + var3.getString(1) + "\t" + var4);
                var3.setColor(AApplet_Sub3_Sub1.anIntArray4752[var4]);
                var3.setString(8, aStringArray567[var4]);
                var3.setData(new Integer(var4));
                this.aMultiColorList571.repaint();
            }
        }
    }

    public void method454(String var1) {
    }

    public void method455(String[] var1) {
        if (var1[1].equals("tracks")) {
            this.method458(var1);
        }

    }

    private void method456() {
        this.setLayout((LayoutManager) null);
        String[] var1 = new String[]{"Author", "Name", "Start", "Fin", "Fin-%", "S.Avg", "Rating", "R-count", "Status", "Trackset"};
        int[] var2 = new int[]{0, 0, 5, 5, 5, 5, 5, 5, 0, 0};
        this.aMultiColorList571 = new MultiColorList(var1, var2, 0, this.anInt569 - 10 - 10, this.anInt570 - 10 - 25 - 5 - 10);
        this.aMultiColorList571.setDecimalSeparator(this.aClass58_Sub1_568.textManager.getDecimalSeparator());
        this.aMultiColorList571.setLocation(10, 10);
        this.aMultiColorList571.setSelectable(1);
        this.aMultiColorList571.addItemListener(this);
        this.add(this.aMultiColorList571);
        this.aColorButton575 = this.method457("Set back to private", 10, this.anInt570 - 10 - 25, 120, 25, AApplet_Sub3.aColor3782, false);
        this.aColorButton574 = this.method457("Set to public", 135, this.anInt570 - 10 - 25, 120, 25, AApplet_Sub3.aColor3782, false);
        this.aColorButton573 = this.method457("Set to official", 260, this.anInt570 - 10 - 25, 120, 25, AApplet_Sub3.aColor3782, false);
        this.aColorButton572 = this.method457("Set to free official", 385, this.anInt570 - 10 - 25, 120, 25, AApplet_Sub3.aColor3782, false);
        this.aColorButton576 = this.method457("<- Back", this.anInt569 - 10 - 120, this.anInt570 - 10 - 25, 120, 25, AApplet_Sub3.aColor3783, true);
    }

    private ColorButton method457(String var1, int var2, int var3, int var4, int var5, Color var6, boolean var7) {
        ColorButton var8 = new ColorButton(var1);
        var8.setBounds(var2, var3, var4, var5);
        var8.setBackground(var6);
        var8.addActionListener(this);
        var8.setVisible(var7);
        this.add(var8);
        return var8;
    }

    private void method458(String[] var1) {
        for (int var2 = 2; var2 < var1.length; ++var2) {
            StringTokenizer var3 = new StringTokenizer(var1[var2], ";");
            String var4 = var3.nextToken();
            String var5 = var3.nextToken();
            int var6 = Integer.parseInt(var3.nextToken());
            int var7 = Integer.parseInt(var3.nextToken());
            double var8 = 100.0D * (double) var7 / (double) var6;
            long var10 = Long.parseLong(var3.nextToken());
            double var12 = 0.0D;
            if (var7 > 0) {
                var12 = 1.0D * (double) var10 / (double) var7;
            }

            double var14 = 0.0D;
            int var16 = Integer.parseInt(var3.nextToken());
            int var17 = Integer.parseInt(var3.nextToken());
            int var18 = var16 + var17;
            if (var18 > 0) {
                var14 = 1.0D * (double) (var16 - var17) / (double) var18;
            }

            int var19 = Integer.parseInt(var3.nextToken());
            String var20 = var3.nextToken();
            Integer var21 = new Integer(var20.length() <= 1 ? var19 : -1);
            MultiColorListItem var22 = new MultiColorListItem(AApplet_Sub3_Sub1.anIntArray4752[var19], new String[]{var4, var5, this.aClass58_Sub1_568.textManager.getNumber((long) var6), this.aClass58_Sub1_568.textManager.getNumber((long) var7), this.aClass58_Sub1_568.textManager.getNumber(var8, var8 >= 10.0D ? 0 : (var8 >= 1.0D ? 1 : 2)) + " %", this.aClass58_Sub1_568.textManager.getNumber(var12, var12 >= 100.0D ? 0 : (var12 >= 10.0D ? 1 : 2)), this.aClass58_Sub1_568.textManager.getNumber(var14, 2), var18 > 0 ? "" + var18 : "-", aStringArray567[var19], var20}, var21);
            this.aMultiColorList571.addItem(var22);
        }

    }

    private void method459(String var1) {
        this.aClass58_Sub1_568.aClass36_Sub1_3572.method1179("ta\t" + var1);
    }

    static {
        aStringArray577[0] = "ta\t";
        aStringArray577[1] = "Rating";
        aStringArray577[2] = "Status";
        aStringArray577[3] = "S.Avg";
        aStringArray577[4] = "Fin";
        aStringArray577[5] = "<- Back";
        aStringArray577[6] = "Set to free official";
        aStringArray577[7] = "Set back to private";
        aStringArray577[8] = "Author";
        aStringArray577[9] = "Trackset";
        aStringArray577[10] = "R-count";
        aStringArray577[11] = "Set to official";
        aStringArray577[12] = "Set to public";
        aStringArray577[13] = "Fin-%";
        aStringArray577[14] = "Name";
        aStringArray577[15] = "Start";
        aStringArray577[16] = " %";
        aStringArray577[17] = "tracks";
        aStringArray577[18] = "back";
        aStringArray577[19] = "change\t";
        aStringArray567 = new String[4];
        aStringArray567[0] = "Private (not visible)";
        aStringArray567[1] = "Public (not official)";
        aStringArray567[2] = "Official (=accepted)";
        aStringArray567[3] = "Free to all (also official)";
    }
}
