package agolf2;

import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.ColorButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

class Panel_Sub20 extends Panel implements ActionListener {

    private static final Color aColor552;
    private static final Color aColor553;
    private Class58_Sub1 aClass58_Sub1_554;
    private IPanel_Sub28_Sub1 anIPanel_Sub28_Sub1_555;
    private TrackAdminFrame aTrackAdminFrame__556;
    private String aString557;
    private String aString558;
    private Image anImage559;
    private double aDouble560;
    private boolean aBoolean561;
    private int anInt562;
    private ColorButton aColorButton563;
    private ColorButton aColorButton564;
    private ColorButton aColorButton565;
    private static final String[] aStringArray566 = new String[12];


    public Panel_Sub20(Class58_Sub1 var1, IPanel_Sub28_Sub1 var2, TrackAdminFrame var3, String var4, String var5, Image var6, double var7, boolean var9, int var10) {
        this.aClass58_Sub1_554 = var1;
        this.anIPanel_Sub28_Sub1_555 = var2;
        this.aTrackAdminFrame__556 = var3;
        this.aString557 = var4;
        this.aString558 = var5;
        this.anImage559 = var6;
        this.aDouble560 = var7;
        this.aBoolean561 = var9;
        this.anInt562 = var10;
        this.setSize(200, 280);
        this.setBackground(aColor552);
        if (var10 == 1) {
            this.method453();
        }

    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        var1.setColor(aColor552);
        var1.fillRect(0, 0, 200, 280);
        var1.setColor(aColor553);
        var1.setFont(AApplet_Sub3.fontDialog14);
        StringDraw.drawString(var1, this.aString557, 100, 27, 0);
        var1.setFont(AApplet_Sub3.fontDialog11);
        StringDraw.drawString(var1, "(" + this.aString558 + ")", 100, 45, 0);
        var1.drawImage(this.anImage559, 100 - this.anImage559.getWidth((ImageObserver) null) / 2, 58, this);
        var1.setFont(AApplet_Sub3.fontDialog12);
        StringDraw.drawString(var1, "Rating: " + this.aClass58_Sub1_554.textManager.getNumber(this.aDouble560, 2), 100, 144, 0);
        var1.setFont(AApplet_Sub3.fontDialog11);
        StringDraw.drawString(var1, "(" + (this.aBoolean561 ? "singleplayer only" : "single and multiplayer") + ")", 100, 162, 0);
        if (this.anInt562 != 1) {
            String var2 = null;
            if (this.anInt562 == 0) {
                var2 = "This track is already removed from public user tracks";
            } else if (this.anInt562 == 2) {
                var2 = "This track is already changed to official track";
            } else if (this.anInt562 == 3) {
                var2 = "This track is official free track";
            }

            var1.setFont(AApplet_Sub3.fontDialog12);
            StringDraw.drawStringWithMaxWidth(var1, var2, 100, 200, 0, 160);
        }

    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aColorButton563) {
            this.anIPanel_Sub28_Sub1_555.method695("ta\t" + this.aString558 + "\t" + this.aString557 + "\tofficial");
        } else if (var2 == this.aColorButton564) {
            this.anIPanel_Sub28_Sub1_555.method695("ta\t" + this.aString558 + "\t" + this.aString557 + "\tprivate");
        }

        this.aTrackAdminFrame__556.destroy();
    }

    private void method453() {
        this.setLayout((LayoutManager) null);
        this.aColorButton563 = new ColorButton("Set to official");
        this.aColorButton563.setBounds(25, 185, 150, 20);
        this.aColorButton563.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aColorButton563.addActionListener(this);
        this.add(this.aColorButton563);
        this.aColorButton564 = new ColorButton("Remove track");
        this.aColorButton564.setBounds(25, 215, 150, 20);
        this.aColorButton564.setBackground(AApplet_Sub3.aColor3783);
        this.aColorButton564.addActionListener(this);
        this.add(this.aColorButton564);
        this.aColorButton565 = new ColorButton("Cancel");
        this.aColorButton565.setBounds(50, 245, 100, 20);
        this.aColorButton565.setBackground(AApplet_Sub3.aColor3784);
        this.aColorButton565.addActionListener(this);
        this.add(this.aColorButton565);
    }

    static {
        aStringArray566[0] = "This track is already changed to official track";
        aStringArray566[1] = "Rating: ";
        aStringArray566[2] = "singleplayer only";
        aStringArray566[3] = "single and multiplayer";
        aStringArray566[4] = "This track is already removed from public user tracks";
        aStringArray566[5] = "This track is official free track";
        aStringArray566[6] = "Remove track";
        aStringArray566[7] = "Set to official";
        aStringArray566[8] = "Cancel";
        aStringArray566[9] = "ta\t";
        aStringArray566[10] = "\tofficial";
        aStringArray566[11] = "\tprivate";
        aColor552 = new Color(13421772);
        aColor553 = new Color(0);
    }
}
