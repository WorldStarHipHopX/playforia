package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

class IPanel_Sub31 extends IPanel {

    protected static final Color[] aColorArray3108;
    public static final Font[][] aFontArrayArray3109;
    private Class58_Sub1 aClass58_Sub1_3110;
    private IPanel_Sub28_Sub1 anIPanel_Sub28_Sub1_3111;
    private int anInt3112;
    private int anInt3113;
    private Class44[] aClass44Array3114;
    private SynchronizedInteger aSynchronizedInteger_3115;
    private SynchronizedInteger aSynchronizedInteger_3116;
    private SynchronizedInteger aSynchronizedInteger_3117;
    private boolean aBoolean3118;
    private boolean aBoolean3119;
    private boolean aBoolean3120;
    private Image[] anImageArray3121;
    private Image anImage3122;
    private Graphics aGraphics3123;
    private static final String[] aStringArray3124 = new String[2];


    protected IPanel_Sub31(Class58_Sub1 var1, IPanel_Sub28_Sub1 var2, int var3) {
        this.aClass58_Sub1_3110 = var1;
        this.anIPanel_Sub28_Sub1_3111 = var2;
        this.anInt3112 = 540;
        this.anInt3113 = var3;
        this.setSize(this.anInt3112, var3);
        this.anImageArray3121 = var1.imageManager.separateImages("game_playericons", 5);
        this.aSynchronizedInteger_3117 = new SynchronizedInteger(-1);
        this.aBoolean3118 = false;
        this.aBoolean3119 = false;
        this.aBoolean3120 = false;
    }

    public void update(Graphics var1) {
        if (this.anImage3122 == null || this.aGraphics3123 == null) {
            if (this.anImage3122 == null) {
                this.anImage3122 = this.aClass58_Sub1_3110.anAApplet_Sub3_Sub1_3567.createImage(this.anInt3112, this.anInt3113);
            }

            this.aGraphics3123 = this.anImage3122.getGraphics();
        }

        this.drawBackground(this.aGraphics3123);
        if (this.aBoolean3118) {
            int var2 = this.aBoolean3120 ? 1 : 0;
            int[] var3 = this.method748(this.aGraphics3123, var2);
            int var4 = (this.anInt3113 - 4) / 6;

            for (int var5 = 0; var5 < this.aSynchronizedInteger_3115.method1174(); ++var5) {
                this.method749(this.aGraphics3123, var2, var5, 2 + var4 * var5 + var4 / 2 - 7, 2 + var4 * var5 + var4 * 3 / 4, var3);
            }

            if (var2 == 0 && this.aBoolean3120) {
                this.update(var1);
                return;
            }
        }

        var1.drawImage(this.anImage3122, 0, 0, this);
    }

    protected void method727(int var1, String[] var2) {
        this.aSynchronizedInteger_3116 = new SynchronizedInteger(var1);
        this.aSynchronizedInteger_3115 = new SynchronizedInteger(var2.length);
        this.aClass44Array3114 = new Class44[this.aSynchronizedInteger_3115.method1174()];

        for (int var3 = 0; var3 < this.aSynchronizedInteger_3115.method1174(); ++var3) {
            this.aClass44Array3114[var3] = new Class44(var2[var3], var1);
        }

        this.aBoolean3118 = true;
        this.repaint();
    }

    protected void method728() {
        for (int var1 = 0; var1 < this.aSynchronizedInteger_3115.method1174(); ++var1) {
            this.aClass44Array3114[var1].method1326(this.aSynchronizedInteger_3116.method1174());
        }

        this.aBoolean3120 = false;
        this.repaint();
    }

    protected void method729() {
        this.aBoolean3119 = true;
    }

    protected void method730(int var1) {
        this.aSynchronizedInteger_3117.set(var1);
        this.repaint();
    }

    protected void method731() {
        for (int var1 = 0; var1 < this.aSynchronizedInteger_3115.method1174(); ++var1) {
            this.aClass44Array3114[var1].method1328(false);
        }

    }

    protected void method732(int var1, boolean var2) {
        this.aClass44Array3114[var1].method1328(var2);
        this.repaint();
    }

    protected void method733(int var1) {
        this.aClass44Array3114[var1].method1338(this.aSynchronizedInteger_3117.method1174());
        this.repaint();
    }

    protected void method734(int var1) {
        this.aClass44Array3114[var1].method1330();
        this.repaint();
    }

    protected boolean[] method735() {
        boolean[] var1 = new boolean[this.aSynchronizedInteger_3115.method1174()];

        for (int var2 = 0; var2 < this.aSynchronizedInteger_3115.method1174(); ++var2) {
            var1[var2] = !this.aClass44Array3114[var2].method1331();
        }

        return var1;
    }

    protected void method736() {
        for (int var1 = 0; var1 < this.aSynchronizedInteger_3115.method1174(); ++var1) {
            this.aClass44Array3114[var1].method1336(false);
        }

    }

    protected void method737(int var1) {
        this.aClass44Array3114[var1].method1336(true);
        this.repaint();
    }

    protected void method738() {
        for (int var1 = 0; var1 < this.aSynchronizedInteger_3115.method1174(); ++var1) {
            this.aClass44Array3114[var1].method1336(false);
        }

        this.repaint();
    }

    protected void method739(int var1) {
        this.aClass44Array3114[var1].method1334(true);
        this.repaint();
    }

    protected void method740() {
        for (int var1 = 0; var1 < this.aSynchronizedInteger_3115.method1174(); ++var1) {
            this.aClass44Array3114[var1].method1334(false);
        }

        this.repaint();
    }

    protected void method741() {
        for (int var1 = 0; var1 < this.aClass44Array3114.length; ++var1) {
            this.aClass44Array3114[var1].method1339(this.aSynchronizedInteger_3117.method1174());
        }

        this.repaint();
    }

    protected int method742() {
        return this.aSynchronizedInteger_3115.method1174();
    }

    protected int method743() {
        int var1 = 0;

        for (int var2 = 0; var2 < this.aSynchronizedInteger_3115.method1174(); ++var2) {
            if (this.aClass44Array3114[var2].method1331()) {
                ++var1;
            }
        }

        return var1;
    }

    protected Class44 method744(int var1) {
        return this.aClass44Array3114[var1];
    }

    protected void method745(int var1, String[] var2) {
        this.aClass44Array3114[var1].method1341(var2);
        this.repaint();
    }

    protected void method746(int var1, boolean var2) {
        this.aClass44Array3114[var1].method1332(var2);
    }

    protected void method747() {
        for (int var1 = 0; var1 < this.aSynchronizedInteger_3115.method1174(); ++var1) {
            this.aClass44Array3114[var1].method1343();
        }

        this.repaint();
    }

    private int[] method748(Graphics var1, int var2) {
        int[] var3 = new int[this.aSynchronizedInteger_3116.method1174()];

        for (int var4 = 0; var4 < this.aSynchronizedInteger_3116.method1174(); ++var4) {
            var3[var4] = 0;

            for (int var5 = 0; var5 < this.aSynchronizedInteger_3115.method1174(); ++var5) {
                String var6 = this.aClass44Array3114[var5].method1344(var4, this.aSynchronizedInteger_3117.method1174(), this.aBoolean3119);
                Font var7 = var4 == this.aSynchronizedInteger_3117.method1174() ? aFontArrayArray3109[var2][0] : (this.aClass44Array3114[var5].method1340(var4) ? aFontArrayArray3109[var2][1] : aFontArrayArray3109[var2][2]);
                int var8 = StringDraw.getStringWidth(var1, var7, var6);
                if (var8 > var3[var4]) {
                    var3[var4] = var8;
                }
            }
        }

        return var3;
    }

    private void method749(Graphics var1, int var2, int var3, int var4, int var5, int[] var6) {
        var1.setColor(this.aClass44Array3114[var3].method1331() ? aColorArray3108[var3] : this.method750(aColorArray3108[var3]));
        var1.setFont(!this.aBoolean3120 ? AApplet_Sub3.fontDialog12 : AApplet_Sub3.fontDialog11);
        var1.drawString(this.aClass44Array3114[var3].method1327(), 5, var5);
        int var7 = !this.aBoolean3120 ? 85 : 80;
        byte var8 = -1;
        byte var9 = -1;
        if (this.aClass44Array3114[var3].method1337()) {
            var8 = 2;
        } else if (this.aClass44Array3114[var3].method1333()) {
            var8 = 4;
        }

        if (!this.aClass44Array3114[var3].method1331()) {
            var9 = 0;
        } else if (this.aClass44Array3114[var3].method1329()) {
            var9 = 1;
        } else if (this.aClass44Array3114[var3].method1335()) {
            var9 = 3;
        }

        if (var8 != -1) {
            var1.drawImage(this.anImageArray3121[var8], var7, var4, this);
        }

        if (var9 != -1) {
            var1.drawImage(this.anImageArray3121[var9], var7 + 14 + 1, var4, this);
        }

        if (this.anIPanel_Sub28_Sub1_3111.method702()) {
            StringDraw.drawString(var1, this.aClass44Array3114[var3].method1346(), var7 + 14 + 1 + 14 + 7, var5, -1);
        }

        var7 = !this.aBoolean3120 ? 160 : 150;

        for (int var10 = 0; var10 < this.aSynchronizedInteger_3116.method1174(); ++var10) {
            var1.setFont(var10 == this.aSynchronizedInteger_3117.method1174() ? aFontArrayArray3109[var2][0] : (this.aClass44Array3114[var3].method1340(var10) ? aFontArrayArray3109[var2][1] : aFontArrayArray3109[var2][2]));
            StringDraw.drawString(var1, this.aClass44Array3114[var3].method1344(var10, this.aSynchronizedInteger_3117.method1174(), this.aBoolean3119), var7 + var6[var10], var5, 1);
            var7 += var6[var10] + (!this.aBoolean3120 ? 10 : 9);
        }

        var1.setFont(aFontArrayArray3109[var2][1]);
        var7 += StringDraw.drawString(var1, this.aClass44Array3114[var3].method1345(this.aSynchronizedInteger_3117.method1174(), this.aBoolean3119), var7, var5, -1);
        if (!this.aBoolean3120 && var7 >= 540) {
            this.aBoolean3120 = true;
        }

    }

    private Color method750(Color var1) {
        int var2 = var1.getRed();
        int var3 = var1.getGreen();
        int var4 = var1.getBlue();
        int var5 = AApplet_Sub3.aColor3778.getRed();
        int var6 = AApplet_Sub3.aColor3778.getGreen();
        int var7 = AApplet_Sub3.aColor3778.getBlue();
        return new Color((var2 * 2 + var5) / 3, (var3 * 2 + var6) / 3, (var4 * 2 + var7) / 3);
    }

    static {
        aStringArray3124[0] = "game_playericons";
        aStringArray3124[1] = "Dialog";
        aColorArray3108 = new Color[]{new Color(224, 224, 255), new Color(255, 160, 160), new Color(255, 255, 160), new Color(160, 255, 160), new Color(255, 160, 255), new Color(160, 255, 255)};
        aFontArrayArray3109 = new Font[][]{{new Font("Dialog", 1, 12), new Font("Dialog", 0, 12), new Font("Dialog", 0, 11)}, {new Font("Dialog", 1, 10), new Font("Dialog", 0, 10), new Font("Dialog", 0, 9)}};
    }
}
