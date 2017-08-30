package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.PersonalScore;
import com.aapeli.client.PersonalScoreUnit;
import com.aapeli.client.StringDraw;
import com.aapeli.tools.Tools;

import java.awt.Graphics;
import java.awt.Image;

class IPanel_Sub18 extends IPanel {

    private Class58_Sub1 aClass58_Sub1_3009;
    private int anInt3010;
    private int anInt3011;
    private Class53 aClass53_3012;
    private PersonalScore aPersonalScore3013;
    private Image anImage3014;
    private Graphics aGraphics3015;
    private static final String[] aStringArray3016 = new String[7];


    protected IPanel_Sub18(Class58_Sub1 var1, int var2, int var3) {
        this.aClass58_Sub1_3009 = var1;
        this.anInt3010 = var2;
        this.anInt3011 = var3;
        this.setSize(var2, var3);
    }

    public void update(Graphics var1) {
        if (this.anImage3014 == null || this.aGraphics3015 == null) {
            this.anImage3014 = this.createImage(this.anInt3010, this.anInt3011);
            this.aGraphics3015 = this.anImage3014.getGraphics();
        }

        this.drawBackground(this.aGraphics3015);
        this.aGraphics3015.setColor(IPanel_Sub37.aColor2407);
        this.aGraphics3015.drawRect(0, 0, this.anInt3010 - 1, this.anInt3011 - 1);
        this.aGraphics3015.drawRect(1, 1, this.anInt3010 - 3, this.anInt3011 - 3);
        if (this.aClass53_3012 != null) {
            this.aGraphics3015.setColor(AApplet_Sub3.aColor3779);
            this.aGraphics3015.setFont(AApplet_Sub3.fontDialog14);
            StringDraw.drawString(this.aGraphics3015, this.aClass58_Sub1_3009.textManager.getGame("Lobby1_TopList_Title"), this.anInt3010 / 2, 30, 0);
            this.aGraphics3015.setFont(AApplet_Sub3.fontDialog24);
            StringDraw.drawString(this.aGraphics3015, this.aClass53_3012.method1413(), this.anInt3010 / 2, 55, 0);
            this.aGraphics3015.setFont(AApplet_Sub3.fontDialog12);
            this.method615(this.aGraphics3015, "AllTime", 95, this.aClass53_3012.method1414(0), true);
            this.method615(this.aGraphics3015, "Month", 145, this.aClass53_3012.method1414(1), true);
            this.method615(this.aGraphics3015, "Week", 195, this.aClass53_3012.method1414(2), true);
            this.method615(this.aGraphics3015, "Day", 245, this.aClass53_3012.method1414(3), false);
            this.method616(this.aGraphics3015, 295, this.aClass53_3012);
        }

        var1.drawImage(this.anImage3014, 0, 0, this);
    }

    protected void method613(PersonalScore var1) {
        this.aPersonalScore3013 = var1;
        this.repaint();
    }

    protected void method614(Class53 var1) {
        this.aClass53_3012 = var1;
        this.repaint();
    }

    private void method615(Graphics var1, String var2, int var3, Class55 var4, boolean var5) {
        var1.setColor(AApplet_Sub3.aColor3780);
        StringDraw.drawString(var1, this.aClass58_Sub1_3009.textManager.getGame("Lobby1_TopList_Best" + var2), this.anInt3010 / 2, var3, 0);
        if (!var4.method1419()) {
            var1.setColor(AApplet_Sub3.aColor3779);
            var3 += 25;
            var4.method1420().draw(var1, 30, var3 - 20, this);
            StringDraw.drawString(var1, var4.method1421(), 80, var3, -1);
            StringDraw.drawString(var1, "" + var4.method1422(), 200, var3, 1);
            String var6 = var5 ? this.aClass58_Sub1_3009.textManager.getDateWithTodayYesterday(var4.method1423()) : this.aClass58_Sub1_3009.textManager.getClock(var4.method1423(), true);
            StringDraw.drawString(var1, var6, 220, var3, -1);
        }
    }

    private void method616(Graphics var1, int var2, Class53 var3) {
        var1.setColor(AApplet_Sub3.aColor3780);
        StringDraw.drawString(var1, this.aClass58_Sub1_3009.textManager.getGame("Lobby1_TopList_BestPersonal"), this.anInt3010 / 2, var2, 0);
        if (this.aPersonalScore3013 != null) {
            PersonalScoreUnit var4 = this.aPersonalScore3013.getPersonalScore(var3.method1413());
            if (var4 != null) {
                var1.setColor(AApplet_Sub3.aColor3779);
                var2 += 25;
                StringDraw.drawString(var1, "" + this.method617(var4.getClientData()), 200, var2, 1);
                StringDraw.drawString(var1, this.aClass58_Sub1_3009.textManager.getDateWithTodayYesterday(var4.getTimeStamp()), 220, var2, -1);
            }
        }
    }

    private int method617(String var1) {
        int[] var2 = Tools.stringToIntArray(var1);
        int var3 = 0;

        for (int var4 = 0; var4 < var2.length; ++var4) {
            var3 += var2[var4];
        }

        return var3;
    }

    static {
        aStringArray3016[0] = "Day";
        aStringArray3016[1] = "AllTime";
        aStringArray3016[2] = "Month";
        aStringArray3016[3] = "Week";
        aStringArray3016[4] = "Lobby1_TopList_Title";
        aStringArray3016[5] = "Lobby1_TopList_BestPersonal";
        aStringArray3016[6] = "Lobby1_TopList_Best";
    }
}
