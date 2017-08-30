package agolf2;

import com.aapeli.bigtext.BigText;
import com.aapeli.client.CharacterImage;
import com.aapeli.client.StringDraw;
import com.aapeli.tools.QuickTimer;
import com.aapeli.tools.QuickTimerListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class GameOverPanel extends IPanel_Sub36 implements QuickTimerListener {

    private static final Color aColor3718;
    private static final Color aColor3719;
    private Class58_Sub1 aClass58_Sub1_3720;
    private IPanel_Sub28_Sub1 anIPanel_Sub28_Sub1_3721;
    private IPanel_Sub31 anIPanel_Sub31_3722;
    private BigText aBigText3723;
    private String aString3724;
    private static final String[] aStringArray3725 = new String[6];


    protected GameOverPanel(Class58_Sub1 var1, IPanel_Sub28_Sub1 var2, IPanel_Sub31 var3, int var4, int var5) {
        super(var1.imageManager, var1.aClass59_Sub1_3569, var2, var4, var5, false);
        this.aClass58_Sub1_3720 = var1;
        this.anIPanel_Sub28_Sub1_3721 = var2;
        this.anIPanel_Sub31_3722 = var3;
        this.aBigText3723 = null;
        this.aString3724 = null;
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        var1.setColor(AApplet_Sub3.aColor3779);
        if (this.aCanvas_Sub6_Sub2_3200 == null) {
            var1.setFont(AApplet_Sub3.fontDialog14);
            StringDraw.drawString(var1, this.aClass58_Sub1_3720.textManager.getGame("Game_PlayView_PreparingTrack"), this.anInt3192 / 2, this.anInt3193 / 2, 0);
        }

        if (this.aCharacterImageArray3201 != null) {
            var1.setFont(AApplet_Sub3.fontDialog11);

            for (int var2 = 0; var2 < this.aCharacterImageArray3201.length; ++var2) {
                if (this.aCharacterImageArray3201[var2] != null) {
                    int var3 = 2 + var2 * (CharacterImage.IMAGE_HEIGHT[1] + 12);
                    this.aCharacterImageArray3201[var2].draw(var1, 4, var3, this);
                    var1.setColor(IPanel_Sub31.aColorArray3108[var2]);
                    StringDraw.drawOutlinedString(var1, AApplet_Sub3.aColor3778, this.aStringArray3202[var2], 4 + CharacterImage.IMAGE_WIDTH[1] / 2, var3 + CharacterImage.IMAGE_HEIGHT[1] + 3, 0);
                }
            }
        }

    }

    public void qtFinished() {
        this.aBigText3723 = null;
        this.aString3724 = null;
        Canvas_Sub6_Sub2 var1 = this.aCanvas_Sub6_Sub2_3200;
        if (var1 != null) {
            var1.repaint();
        }

    }

    public void method769() {
        this.aBigText3723 = null;
        this.aString3724 = null;
        super.method769();
    }

    protected void method781(int var1, String var2, boolean var3) {
        try {
            if (var3) {
                this.aBigText3723 = new BigText(this.aClass58_Sub1_3720.textManager.getGame("Game_PlayView_GameFinished"), aColor3718, 176);
            } else {
                this.aBigText3723 = new BigText(this.aClass58_Sub1_3720.textManager.getGame("Game_PlayView_GameOver"), aColor3719, 176);
            }
        } catch (NullPointerException var5) {
            this.aBigText3723 = null;
        }

        if (var1 == 0) {
            this.aString3724 = null;
        } else if (var2 != null) {
            this.aString3724 = this.aClass58_Sub1_3720.textManager.getGame("Game_PlayView_Winner" + (var1 > 1 ? "s" : "")) + " " + var2;
        } else {
            this.aString3724 = this.aClass58_Sub1_3720.textManager.getGame("Game_PlayView_Draw");
        }

        this.aCanvas_Sub6_Sub2_3200.repaint();
        if (this.aBigText3723 != null) {
            new QuickTimer(var1 > 0 ? 10000 : 5000, this);
        }

    }

    public void method778(Graphics var1, int var2, GameBall_Sub1 var3) {
        if (this.anIPanel_Sub28_Sub1_3721.method702()) {
            Class44 var4 = this.anIPanel_Sub31_3722.method744(var2);
            if (var4.method1329()) {
                int[] var5 = var3.method1240();
                var1.setFont(AApplet_Sub3.fontDialog11);
                var1.setColor(IPanel_Sub31.aColorArray3108[var2]);
                String var6 = this.aClass58_Sub1_3720.textManager.getGame("Game_PlayView_Playing") + " " + var4.method1346();
                int var7 = StringDraw.getStringWidth(var1, AApplet_Sub3.fontDialog11, var6);
                int var8 = var5[0] - var7 / 2;
                int var9 = var5[0] + var7 / 2;
                if (var8 <= 0) {
                    var8 += 1 - var8;
                } else if (var9 >= 779) {
                    var8 += 778 - var9;
                }

                StringDraw.drawOutlinedString(var1, AApplet_Sub3.aColor3778, var6, var8, var5[1] + 20, -1);
            }
        }

    }

    public void method779(Graphics var1) {
        if (this.aBigText3723 != null) {
            Point var2 = this.aCanvas_Sub6_Sub2_3200.getLocation();
            this.aBigText3723.drawText(var1, this.anInt3192 / 2 - var2.x, this.anInt3193 / 2 - (this.aString3724 != null ? 30 : 0), 0, 1);
            if (this.aString3724 != null) {
                var1.setFont(AApplet_Sub3.fontDialog24);
                var1.setColor(AApplet_Sub3.aColor3779);
                StringDraw.drawOutlinedString(var1, Color.black, this.aString3724, this.anInt3192 / 2 - var2.x, this.anInt3193 / 2 + 10, 0);
            }
        }

    }

    static {
        aStringArray3725[0] = "Game_PlayView_PreparingTrack";
        aStringArray3725[1] = "Game_PlayView_Playing";
        aStringArray3725[2] = "Game_PlayView_Draw";
        aStringArray3725[3] = "Game_PlayView_GameOver";
        aStringArray3725[4] = "Game_PlayView_GameFinished";
        aStringArray3725[5] = "Game_PlayView_Winner";
        aColor3718 = new Color(208, 255, 208);
        aColor3719 = new Color(255, 208, 208);
    }
}
