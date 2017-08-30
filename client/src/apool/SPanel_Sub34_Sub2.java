package apool;

import com.playray.client.CharacterImage;
import com.playray.client.StringDraw;
import com.playray.multiuser.Languages;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class SPanel_Sub34_Sub2 extends SPanel_Sub34 implements MouseListener {

    private SPanel_Sub30 aSPanel_Sub30_4909;
    private int anInt4910;
    private Image[] anImageArray4911;
    private String aString4912;
    private CharacterImage aCharacterImage4913;
    private Image anImage4914;
    private int anInt4915;
    private int anInt4916;
    private boolean aBoolean4917;
    private boolean[] aBooleanArray4918;
    private static final String[] aStringArray4919 = new String[4];


    protected SPanel_Sub34_Sub2(Class60 var1, SPanel_Sub30 var2, int var3, int var4, int var5) {
        super(var1, var4, var5);
        this.aSPanel_Sub30_4909 = var2;
        this.anInt4910 = var3;
        this.anImageArray4911 = var1.gameApplet.method2314()[0];
        this.aBooleanArray4918 = new boolean[16];
    }

    public void method2738(Graphics2D var1) {
        if (this.aSPanel_Sub30_4909.method2632() > -2) {
            this.method2761(var1, this.aSPanel_Sub30_4909.method2632() == this.anInt4910, this.aSPanel_Sub30_4909.method2633() == this.anInt4910, this.aSPanel_Sub30_4909.method2634() == this.anInt4910);
        }

    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        if (var1.getClickCount() == 2) {
            super.aClass60_4202.gameApplet.method2318(this.aString4912);
        }

    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    protected void method2749(String var1, String var2) {
        this.aString4912 = var1;
        int var3 = var2.indexOf(94);
        String var4;
        String var5;
        if (var3 > 0) {
            var4 = var2.substring(0, var3);
            var5 = var2.substring(var3 + 1);
        } else {
            var4 = var2;
            var5 = null;
        }

        this.aCharacterImage4913 = new CharacterImage(super.aClass60_4202.imageManager, var4, 1);
        if (var5 != null) {
            int var6 = Languages.getLanguageIdByString(var5);
            if (super.aClass60_4202.language == null) {
                super.aClass60_4202.language = new Languages(super.aClass60_4202.textManager, super.aClass60_4202.imageManager);
            }

            this.anImage4914 = super.aClass60_4202.language.getFlag(var6);
        }

        this.removeMouseListener(this);
        this.addMouseListener(this);
    }

    protected void method2750() {
        this.anInt4916 = this.aSPanel_Sub30_4909.method2630() > 0 ? 0 : 999;
        this.method2751();
    }

    protected void method2751() {
        this.anInt4915 = -1;

        for (int var1 = 0; var1 < 16; ++var1) {
            this.aBooleanArray4918[var1] = false;
        }

        this.repaint();
    }

    protected void method2752(int var1) {
        this.anInt4915 = var1;
        this.repaint();
    }

    protected void method2753(int var1) {
        this.aBooleanArray4918[var1] = true;
        this.repaint();
    }

    protected void method2754(int var1) {
        if (this.anInt4916 == 999) {
            this.anInt4916 = 0;
        }

        this.anInt4916 += var1;
        this.repaint();
    }

    protected int method2755() {
        return this.anInt4916 == 999 ? 0 : this.anInt4916;
    }

    protected String method2756(int var1) {
        String var2 = "";
        if (var1 < 4) {
            for (int var3 = 0; var3 < 16; ++var3) {
                var2 = var2 + (this.aBooleanArray4918[var3] ? 't' : 'f');
            }
        }

        if (var1 >= 2) {
            String var4;
            for (var4 = Integer.toString(this.anInt4916 + 8517, 22); var4.length() < 3; var4 = "0" + var4) {
                ;
            }

            var2 = var2 + var4;
        }

        return var2;
    }

    protected void method2757(int var1, String var2) {
        int var3 = 0;
        if (var1 < 4) {
            for (int var4 = 0; var4 < 16; ++var4) {
                this.aBooleanArray4918[var4] = var2.charAt(var4) == 116;
            }

            var3 += 16;
        }

        if (var1 >= 2) {
            this.anInt4916 = Integer.parseInt(var2.substring(var3, var3 + 3), 22) - 8517;
        }

        this.repaint();
    }

    protected void method2758() {
        this.aBoolean4917 = true;
        this.repaint();
    }

    protected boolean[] method2759() {
        boolean[] var1 = this.aBooleanArray4918;
        this.aBooleanArray4918 = this.method2760();
        this.repaint();
        return var1;
    }

    private boolean[] method2760() {
        boolean[] var1 = new boolean[16];

        for (int var2 = 0; var2 < 16; ++var2) {
            var1[var2] = false;
        }

        return var1;
    }

    private void method2761(Graphics2D var1, boolean var2, boolean var3, boolean var4) {
        this.aCharacterImage4913.draw(var1, 10, 9, this);
        if (this.anImage4914 != null) {
            var1.drawImage(this.anImage4914, 4, 4, this);
        }

        var1.setColor(this.aBoolean4917 ? GameApplet.aColor4810 : GameApplet.aColor4808);
        var1.setFont(SPanel_Sub34.aFont4199);
        int var5 = 80;
        int var6 = StringDraw.drawString(var1, this.aString4912, var5, 28, -1);
        if (this.anInt4915 >= 0 && !var4) {
            var1.setFont(SPanel_Sub34.aFont4200);
            var6 += StringDraw.drawString(var1, super.aClass60_4202.textManager.method2039("GamePlayerInfo_Color" + this.anInt4915), var5 + var6 + 10, 28, -1);
        }

        int var7 = 0;

        int var8;
        for (var8 = 0; var8 < 16; ++var8) {
            if (this.aBooleanArray4918[var8]) {
                ++var7;
            }
        }

        if (var7 > 0) {
            for (var8 = 0; var8 < 16; ++var8) {
                if (this.aBooleanArray4918[var8]) {
                    var1.drawImage(this.anImageArray4911[var8], var5, 45, this);
                    var5 += 19 - var7 * 3 / 4;
                }
            }
        }

        var1.setFont(SPanel_Sub34.aFont4200);
        String var9;
        if (this.anInt4916 != 999) {
            var9 = "" + this.anInt4916;
            if (!this.aSPanel_Sub30_4909.method2631()) {
                var9 = "= " + var9;
                if (this.aSPanel_Sub30_4909.method2630() > 0) {
                    var9 = var9 + " / " + this.aSPanel_Sub30_4909.method2630();
                }

                var5 += 10;
            }

            var1.drawString(var9, var5 + 10, 60);
        }

        if (var4) {
            var9 = super.aClass60_4202.textManager.method2039("GamePlayerInfo_Winner");
            if (!this.aSPanel_Sub30_4909.method2631()) {
                var1.setFont(SPanel_Sub34.aFont4199);
                StringDraw.drawString(var1, var9, super.anInt4203 - 15, 28, 1);
            } else {
                var1.setFont(SPanel_Sub34.aFont4200);
                StringDraw.drawString(var1, var9, super.anInt4203 - 15, 60, 1);
            }
        }

    }

    static {
        aStringArray4919[0] = " / ";
        aStringArray4919[1] = "= ";
        aStringArray4919[2] = "GamePlayerInfo_Winner";
        aStringArray4919[3] = "GamePlayerInfo_Color";
    }
}
