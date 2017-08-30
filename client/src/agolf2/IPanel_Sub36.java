package agolf2;

import com.aapeli.client.CharacterImage;
import com.aapeli.client.IPanel;
import com.aapeli.client.ImageManager;
import com.aapeli.tools.Tools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class IPanel_Sub36 extends IPanel {

    private ImageManager anImageManager3189;
    private GamePersonalSettings aGamePersonalSettings_3190;
    private Interface5 anInterface5_3191;
    protected int anInt3192;
    protected int anInt3193;
    private boolean aBoolean3194;
    private Class52 aClass52_3195;
    private Class43_Sub1 aClass43_Sub1_3196;
    private boolean aBoolean3197;
    private boolean aBoolean3198;
    private boolean aBoolean3199;
    protected Canvas_Sub6_Sub2 aCanvas_Sub6_Sub2_3200;
    protected CharacterImage[] aCharacterImageArray3201;
    protected String[] aStringArray3202;
    private Object anObject3203;
    private static final String[] aStringArray3204 = new String[4];


    protected IPanel_Sub36(ImageManager var1, GamePersonalSettings var2, Interface5 var3, int var4, int var5, boolean var6) {
        this.anImageManager3189 = var1;
        this.aGamePersonalSettings_3190 = var2;
        this.anInterface5_3191 = var3;
        this.anInt3192 = var4;
        this.anInt3193 = var5;
        this.setSize(var4, var5);
        this.aBoolean3194 = var6;
        this.anObject3203 = new Object();
    }

    public Canvas_Sub6_Sub2 method767() {
        return this.aCanvas_Sub6_Sub2_3200;
    }

    public void method768(String[] var1, String[] var2) {
        this.aCharacterImageArray3201 = new CharacterImage[var1.length];

        for (int var3 = 0; var3 < var1.length; ++var3) {
            this.aCharacterImageArray3201[var3] = new CharacterImage(this.anImageManager3189, var1[var3], 1);
        }

        this.aStringArray3202 = var2;
        this.repaint();
    }

    public void method769() {
        Object var1 = this.anObject3203;
        synchronized (this.anObject3203) {
            this.method770();
            Tools.forcedRepaint(this);
        }
    }

    public void method770() {
        Object var1 = this.anObject3203;
        synchronized (this.anObject3203) {
            if (this.aCanvas_Sub6_Sub2_3200 != null) {
                this.remove(this.aCanvas_Sub6_Sub2_3200);
                this.aCanvas_Sub6_Sub2_3200.method174();
                this.aCanvas_Sub6_Sub2_3200 = null;
            }

        }
    }

    public void method771(Class52 var1, Class43_Sub1 var2, boolean var3) {
        this.aClass52_3195 = var1;
        this.aClass43_Sub1_3196 = var2;
        this.aBoolean3197 = this.aGamePersonalSettings_3190.smoothGraphics;
        this.aBoolean3198 = this.aGamePersonalSettings_3190.threedeeLights;
        this.aBoolean3199 = this.aGamePersonalSettings_3190.threedeeBall;
        this.method780();
    }

    public void method772() {
        if (this.aGamePersonalSettings_3190.smoothGraphics == this.aBoolean3197 && this.aGamePersonalSettings_3190.threedeeLights == this.aBoolean3198) {
            if (this.aGamePersonalSettings_3190.threedeeBall != this.aBoolean3199) {
                this.aBoolean3199 = this.aGamePersonalSettings_3190.threedeeBall;
                this.aCanvas_Sub6_Sub2_3200.method199(this.aBoolean3199);
            }
        } else {
            this.aBoolean3197 = this.aGamePersonalSettings_3190.smoothGraphics;
            this.aBoolean3198 = this.aGamePersonalSettings_3190.threedeeLights;
            this.aClass52_3195.method1406();
            this.method780();
        }

    }

    protected void method773(BufferedImage var1, int var2, int var3, int var4, int var5) {
    }

    protected double method774() {
        return 1.0D;
    }

    protected void method775() {
    }

    protected void method776() {
    }

    protected boolean method777() {
        return false;
    }

    public abstract void method778(Graphics var1, int var2, GameBall_Sub1 var3);

    public abstract void method779(Graphics var1);

    private void method780() {
        Object var1 = this.anObject3203;
        synchronized (this.anObject3203) {
            if (this.aBoolean3194) {
                System.out.println("PlayView.setView(): mem_gfxblur=" + this.aBoolean3197 + ", " + "mem_gfxlight=" + this.aBoolean3198 + ", " + "mem_gfxball=" + this.aBoolean3199);
            }

            if (this.aCanvas_Sub6_Sub2_3200 != null) {
                this.remove(this.aCanvas_Sub6_Sub2_3200);
                this.aCanvas_Sub6_Sub2_3200.method174();
                System.gc();
            }

            Canvas_Sub6_Sub2 var2 = new Canvas_Sub6_Sub2(this.aClass52_3195, this.aBoolean3197, this.aBoolean3198, this.aBoolean3199, this.aClass43_Sub1_3196, this.anInterface5_3191, this);
            this.aClass43_Sub1_3196.method1323(var2);
            var2.setLocation(this.anInt3192 - 2 - 780, 2);
            this.aCanvas_Sub6_Sub2_3200 = var2;
            this.add(this.aCanvas_Sub6_Sub2_3200);
        }
    }

    static {
        aStringArray3204[0] = ", ";
        aStringArray3204[1] = "PlayView.setView(): mem_gfxblur=";
        aStringArray3204[2] = "mem_gfxball=";
        aStringArray3204[3] = "mem_gfxlight=";
    }
}
