package agolf2;

import agolf2.AApplet_Sub3;
import agolf2.Class58_Sub1;
import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

class IPanel_Sub34 extends IPanel {

    private static final Font aFont3157;
    private static final Font aFont3158;
    private static final Font aFont3159;
    private static final Font aFont3160;
    private static final Font aFont3161;
    private Class58_Sub1 aClass58_Sub1_3162;
    private int anInt3163;
    private int anInt3164;
    private int anInt3165;
    private int anInt3166;
    private String aString3167;
    private String aString3168;
    private String aString3169;
    private boolean aBoolean3170;
    private int anInt3171;
    private long aLong3172;
    private int anInt3173;
    private int anInt3174;
    private String aString3175;
    private String aString3176;
    private long aLong3177;
    private long aLong3178;
    private Image anImage3179;
    private Graphics aGraphics3180;
    private static final String[] aStringArray3181 = new String[13];


    protected IPanel_Sub34(Class58_Sub1 var1, int var2, int var3) {
        this.aClass58_Sub1_3162 = var1;
        this.anInt3163 = var2;
        this.anInt3164 = var3;
        this.setSize(var2, var3);
        this.anInt3165 = this.anInt3166 = -1;
        this.anInt3171 = 0;
    }

    public void update(Graphics var1) {
        if (this.anImage3179 == null || this.aGraphics3180 == null) {
            if (this.anImage3179 == null) {
                this.anImage3179 = this.aClass58_Sub1_3162.anAApplet_Sub3_Sub1_3567.createImage(this.anInt3163, this.anInt3164);
            }

            this.aGraphics3180 = this.anImage3179.getGraphics();
        }

        this.drawBackground(this.aGraphics3180);
        if (this.anInt3165 > 0) {
            this.aGraphics3180.setColor(AApplet_Sub3.aColor3779);
            this.aGraphics3180.setFont(aFont3157);
            byte var2 = 16;
            if (this.anInt3166 >= 0) {
                StringDraw.drawString(this.aGraphics3180, this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_TrackNumber", this.anInt3166 + 1, this.anInt3165), this.anInt3163 / 4, var2, 0);
                this.aGraphics3180.setFont(aFont3158);
                StringDraw.drawString(this.aGraphics3180, this.aString3168, this.anInt3163 / 4, var2 + 23, 0);
                this.aGraphics3180.setFont(aFont3159);
                StringDraw.drawString(this.aGraphics3180, this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_TrackAuthor", this.aString3167), this.anInt3163 / 4, var2 + 43, 0);
                StringDraw.drawString(this.aGraphics3180, this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_TrackDate", this.aString3169), this.anInt3163 / 4, var2 + 57, 0);
            } else {
                StringDraw.drawString(this.aGraphics3180, this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_TrackCount", this.anInt3165), this.anInt3163 / 4, var2, 0);
            }
        }

        if (this.anInt3171 > 0) {
            this.aGraphics3180.setColor(AApplet_Sub3.aColor3780);
            this.aGraphics3180.setFont(aFont3160);
            double var3 = 1.0D * (double) this.aLong3172 / (double) this.anInt3171;
            StringDraw.drawString(this.aGraphics3180, this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_AverageResult", this.aClass58_Sub1_3162.textManager.getNumber(var3, 1)), this.anInt3163 / 4, this.anInt3164 - 5, 0);
            byte var5 = 17;
            this.aGraphics3180.setFont(aFont3161);
            StringDraw.drawString(this.aGraphics3180, this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_BestResult"), this.anInt3163 / 2 + 2, var5 + 1, -1);
            String var6;
            if (this.anInt3174 == 1) {
                var6 = this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_BestResultUnique", this.anInt3173);
            } else {
                double var7 = 100.0D * (double) this.anInt3174 / (double) this.anInt3171;
                var6 = this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_BestResultMultiple", "" + this.anInt3173, this.aClass58_Sub1_3162.textManager.getNumber(var7, 1));
            }

            this.aGraphics3180.setFont(aFont3160);
            StringDraw.drawString(this.aGraphics3180, var6, this.anInt3163 - 1, var5 + 15, 1);
            this.aGraphics3180.setFont(aFont3161);
            StringDraw.drawString(this.aGraphics3180, this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_BestResultFirst1"), this.anInt3163 / 2 + 2, var5 + 31, -1);
            this.aGraphics3180.setFont(aFont3160);
            StringDraw.drawString(this.aGraphics3180, this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_BestResultFirst2", this.aString3175, this.aClass58_Sub1_3162.textManager.getDate(this.aLong3177, false)), this.anInt3163 - 1, var5 + 45, 1);
            if (this.anInt3174 > 1) {
                this.aGraphics3180.setFont(aFont3161);
                StringDraw.drawString(this.aGraphics3180, this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_BestResultLast1"), this.anInt3163 / 2 + 2, var5 + 61, -1);
                this.aGraphics3180.setFont(aFont3160);
                StringDraw.drawString(this.aGraphics3180, this.aClass58_Sub1_3162.textManager.getGame("Game_TrackInfo_BestResultLast2", this.aString3176, this.aClass58_Sub1_3162.textManager.getDate(this.aLong3178, false)), this.anInt3163 - 1, var5 + 75, 1);
            }
        }

        var1.drawImage(this.anImage3179, 0, 0, this);
    }

    protected void method757(int var1) {
        this.anInt3165 = var1;
    }

    protected int method758() {
        return this.anInt3165;
    }

    protected void method759(int var1, String var2, String var3, long var4, boolean var6, int var7, long var8, int var10, int var11, String var12, long var13, String var15, long var16) {
        this.anInt3166 = var1;
        this.aString3168 = var2;
        this.aString3167 = var3;
        this.aString3169 = this.aClass58_Sub1_3162.textManager.getDate(var4, true);
        this.aBoolean3170 = var6;
        this.anInt3171 = var7;
        this.aLong3172 = var8;
        this.anInt3173 = var10;
        this.anInt3174 = var11;
        this.aString3175 = var12;
        this.aLong3177 = var13;
        this.aString3176 = var15;
        this.aLong3178 = var16;
        this.repaint();
    }

    protected String method760() {
        return this.aString3167;
    }

    protected String method761() {
        return this.aString3168;
    }

    protected boolean method762() {
        return this.aBoolean3170;
    }

    static {
        aStringArray3181[0] = "Game_TrackInfo_BestResultLast1";
        aStringArray3181[1] = "Game_TrackInfo_BestResult";
        aStringArray3181[2] = "Game_TrackInfo_TrackNumber";
        aStringArray3181[3] = "Game_TrackInfo_BestResultUnique";
        aStringArray3181[4] = "Game_TrackInfo_TrackAuthor";
        aStringArray3181[5] = "Game_TrackInfo_BestResultLast2";
        aStringArray3181[6] = "Game_TrackInfo_AverageResult";
        aStringArray3181[7] = "Game_TrackInfo_BestResultFirst2";
        aStringArray3181[8] = "Game_TrackInfo_TrackDate";
        aStringArray3181[9] = "Game_TrackInfo_BestResultFirst1";
        aStringArray3181[10] = "Game_TrackInfo_TrackCount";
        aStringArray3181[11] = "Game_TrackInfo_BestResultMultiple";
        aStringArray3181[12] = "Dialog";
        aFont3157 = new Font("Dialog", 0, 10);
        aFont3158 = new Font("Dialog", 0, 18);
        aFont3159 = new Font("Dialog", 0, 11);
        aFont3160 = aFont3159;
        aFont3161 = aFont3157;
    }
}
