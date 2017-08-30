package acannons;

import com.playray.client.CharacterImage;
import com.playray.client.StringDraw;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Gamesomething {

    private static final Color aColor868;
    private static final Color aColor869;
    private static final Color aColor870;
    private static final Color aColor871;
    private static final Color aColor872;
    private static final Color aColor873;
    private static final Color aColor874;
    private static final Color aColor875;
    private static final Color aColor876;
    private static final Color aColor877;
    private static final Font aFont878;
    private static final Font aFont879;
    private FontMetrics aFontMetrics880;
    private ClientSettings aClientSettings_881;
    private GameAreaPanel aSPanel__882;
    private SynchronizedBool aSynchronizedBool_883;
    private SynchronizedBool aSynchronizedBool_884;
    private boolean aBoolean885;
    private boolean aBoolean886;
    private Class7 aClass7_887;
    private Class7 aClass7_888;
    private Class7 aClass7_889;
    private Class7 aClass7_890;
    private Class7 aClass7_891;
    private double aDouble892;
    private double aDouble893;
    private int anInt894;
    private int anInt895;
    private int anInt896;
    private int anInt897;
    private int anInt898;
    private int anInt899;
    private int anInt900;
    private int anInt901;
    private int anInt902;
    private int anInt903;
    private int anInt904;
    private double aDouble905;
    private String aString906;
    private String aString907;
    private String aString908;
    private String aString909;
    private CharacterImage aCharacterImage910;
    private Object anObject911;
    private Class18 aClass18_912;
    private String aString913;
    private Color aColor914;
    private int anInt915;
    private int anInt916;
    private static final String[] aStringArray917 = new String[5];


    protected Gamesomething(ClientSettings var1, GameAreaPanel var2) {
        this.aClientSettings_881 = var1;
        this.aSPanel__882 = var2;
        this.aFontMetrics880 = var1.gameApplet.getFontMetrics(aFont879);
        this.anObject911 = new Object();
        this.aBoolean886 = false;
        this.aSynchronizedBool_883 = new SynchronizedBool(false);
        this.aSynchronizedBool_884 = new SynchronizedBool(true);
        this.aClass7_887 = new Class7();
        this.aClass7_888 = new Class7();
        this.aClass7_889 = new Class7();
        this.aClass7_890 = new Class7();
        this.aClass7_891 = new Class7();
        this.method1077();
    }

    protected void method1053(int var1, int var2) {
        int var3 = GameAreaPanel.anIntArray2719[this.aClass7_889.method1016()];
        this.anInt896 = var1;
        this.anInt897 = var2;
        if (var3 == 1 && (this.anInt894 == -1 || this.anInt895 == -1)) {
            this.anInt896 = this.aClass7_887.method1016();
            this.anInt897 = this.aClass7_888.method1016();
        }

        if (var3 == 2) {
            if (this.anInt896 == this.aClass7_887.method1016()) {
                this.anInt896 = this.aClass7_887.method1016() + 1;
            }

            this.anInt897 = this.aClass7_888.method1016();
        }

        if (var3 == 3) {
            this.anInt896 = this.aClass7_887.method1016();
            this.anInt897 = this.aClass7_888.method1016();
        }

    }

    protected void method1054() {
        this.anInt896 = this.anInt897 = this.anInt900 = -1;
    }

    protected boolean method1055(int var1, int var2) {
        int var3 = GameAreaPanel.anIntArray2719[this.aClass7_889.method1016()];
        this.anInt896 = var1;
        this.anInt897 = var2;
        if (var3 == 1 && (this.anInt894 == -1 || this.anInt895 == -1)) {
            this.anInt894 = this.anInt896;
            this.anInt895 = this.anInt897;
            return false;
        } else {
            if (var3 == 2) {
                if (this.anInt896 == this.aClass7_887.method1016()) {
                    this.anInt896 = this.aClass7_887.method1016() + 1;
                }

                this.anInt897 = this.aClass7_888.method1016();
            }

            if (var3 == 3) {
                this.anInt894 = this.anInt896;
                this.anInt895 = this.anInt897;
            }

            if (this.anInt896 == this.aClass7_887.method1016() && this.anInt897 == this.aClass7_888.method1016()) {
                --this.anInt897;
            }

            return true;
        }
    }

    protected int method1056() {
        return this.aClass7_889.method1016();
    }

    protected int method1057() {
        return this.anInt900;
    }

    protected double method1058() {
        return this.aDouble892;
    }

    protected int method1059() {
        if (this.aDouble892 <= 0.0D) {
            return 0;
        } else {
            int var1 = (int) (this.aDouble892 + 0.99D);
            return var1 <= 0 ? 1 : var1;
        }
    }

    protected int[] method1060() {
        int[] var1 = new int[]{this.aClass7_887.method1016(), this.aClass7_888.method1016()};
        return var1;
    }

    protected int[] method1061() {
        int[] var1 = new int[]{this.anInt896, this.anInt897};
        return var1;
    }

    protected int[] method1062() {
        int[] var1 = this.method1063();
        this.anInt894 = this.anInt895 = -1;
        return var1;
    }

    protected int[] method1063() {
        if (this.anInt894 != -1 && this.anInt895 != -1) {
            int[] var1 = new int[]{this.anInt894, this.anInt895};
            return var1;
        } else {
            return null;
        }
    }

    protected int[] method1064() {
        if (this.anInt898 != -1 && this.anInt899 != -1) {
            int[] var1 = new int[]{this.anInt898, this.anInt899};
            return var1;
        } else {
            return null;
        }
    }

    protected boolean method1065(int var1, int var2) {
        int var3 = this.aClass7_887.method1016() - 12;
        int var4 = this.aClass7_888.method1016() - 7;
        return var1 >= var3 && var1 <= var3 + 25 && var2 >= var4 && var2 <= var4 + 15 ? (var2 >= var4 + 10 + 1 ? true : (var2 >= var4 + 5 + 1 && var1 > var3 + 3 && var1 < var3 + 21 ? true : var1 > var3 + 8 && var1 < var3 + 16)) : false;
    }

    protected boolean method1066(double var1, double var3, double var5) {
        double var7 = Math.abs(var1 - (double) this.aClass7_887.method1016()) - 12.0D;
        double var9 = Math.abs(var3 - (double) this.aClass7_888.method1016()) - 7.0D;
        if (var7 < 0.0D) {
            var7 = 0.0D;
        }

        if (var9 < 0.0D) {
            var9 = 0.0D;
        }

        return Math.sqrt(var7 * var7 + var9 * var9) <= var5;
    }

    protected int[] method1067() {
        this.anInt898 = this.anInt896;
        this.anInt899 = this.anInt897;
        int[] var1 = new int[]{this.aClass7_889.method1016(), this.anInt896, this.anInt897, this.anInt894, this.anInt895};
        return var1;
    }

    protected boolean method1068() {
        return this.aSynchronizedBool_884.method1008();
    }

    protected int method1069() {
        return this.anInt916;
    }

    protected void method1070() {
        this.aDouble905 = 0.0D;
    }

    protected boolean method1071() {
        if (this.aDouble905 == 0.0D && !this.aSPanel__882.method2378(this.aClass7_887.method1016(), this.aClass7_888.method1016())) {
            this.aDouble905 = 1.0D;
            return true;
        } else if (this.aDouble905 > 0.0D) {
            this.method1085((int) (this.aDouble905 + 0.5D));
            this.aDouble905 += 0.02D;
            return true;
        } else {
            return false;
        }
    }

    protected double method1072() {
        return this.aDouble905;
    }

    protected void method1073() {
        this.aSynchronizedBool_883.method1007(true);
    }

    protected void method1074(String var1) {
        this.aString906 = var1;
    }

    protected void method1075(String var1) {
        this.aString907 = var1;
    }

    protected void method1076(String var1) {
        this.aCharacterImage910 = this.aClientSettings_881.gameApplet.method2285(var1);
    }

    protected void method1077() {
        this.aDouble892 = this.aSynchronizedBool_884.method1008() ? 100.0D : 0.0D;
        this.method1080(-1);
        this.anInt896 = this.anInt897 = this.anInt898 = this.anInt899 = this.anInt900 = this.anInt916 = -1;
        this.method1088((String) null, false);
    }

    protected void method1078() {
        this.aBoolean885 = this.aSynchronizedBool_884.method1008() && this.aDouble892 > 0.0D;
        this.aDouble893 = 0.0D;
    }

    protected boolean method1079(boolean var1) {
        this.aBoolean886 = var1;
        return this.aDouble893 > 0.0D;
    }

    protected void method1080(int var1) {
        this.aClass7_889.method1012(var1);
        this.anInt894 = this.anInt895 = -1;
        if (var1 == -1 || var1 == 16) {
            this.anInt896 = this.anInt897 = -1;
        }

    }

    protected boolean method1081() {
        if (this.aClass7_889.method1016() != 17) {
            if (this.aClass7_891.method1016() > 0) {
                double var3 = (double) this.aClass7_891.method1016() / 100.0D;
                int var5 = this.anInt903 - this.anInt901;
                int var6 = this.anInt904 - this.anInt902;
                this.aClass7_887.method1012((int) ((double) this.anInt901 + (double) var5 * var3));
                this.aClass7_888.method1012((int) ((double) this.anInt902 + (double) var6 * var3));
                this.aClass7_891.method1014();
                if (this.aClass7_891.method1016() < 100) {
                    return true;
                }

                this.aClass7_887.method1012(this.anInt903);
                this.aClass7_888.method1012(this.anInt904);
                this.aClass7_891.method1012(0);
            }

            return false;
        } else {
            int var1 = this.anInt894;
            int var2 = this.anInt895;
            if (var1 < 20) {
                var1 = 20;
            } else if (var1 >= 740) {
                var1 = 739;
            }

            if (var2 < 10) {
                var2 = 10;
            } else if (var2 >= 390) {
                var2 = 379;
            }

            while (this.aSPanel__882.method2378(var1, var2)) {
                --var2;
            }

            ++var2;
            this.anInt901 = this.aClass7_887.method1016();
            this.anInt902 = this.aClass7_888.method1016();
            this.anInt903 = var1;
            this.anInt904 = var2;
            this.aClass7_889.method1012(-1);
            this.aClass7_891.method1012(1);
            return true;
        }
    }

    protected boolean method1082(double var1, int var3) {
        if (this.aClass7_890.method1016() > 0) {
            return false;
        } else {
            if (this.aBoolean885) {
                this.aDouble893 += var1;
            }

            if (this.aDouble892 <= 0.0D) {
                return false;
            } else {
                this.aDouble892 -= var1;
                if (this.aDouble892 < 0.0D) {
                    this.aDouble892 = 0.0D;
                }

                if (var3 != -1) {
                    this.anInt916 = var3;
                }

                return this.aDouble892 == 0.0D;
            }
        }
    }

    protected void method1083(int var1) {
        this.aClass7_887.method1012(var1);
    }

    protected void method1084(int var1) {
        this.aClass7_888.method1012(var1);
    }

    protected void method1085(int var1) {
        this.aClass7_888.method1013(var1);
    }

    protected void method1086(int var1, int var2, int var3, int var4, int var5) {
        this.aClass7_889.method1012(var1);
        this.anInt896 = var2;
        this.anInt897 = var3;
        this.anInt894 = var4;
        this.anInt895 = var5;
    }

    protected void method1087(boolean var1) {
        this.aClass7_890.method1012(var1 ? 1 : 0);
    }

    protected void method1088(String var1, boolean var2) {
        Object var3 = this.anObject911;
        synchronized (this.anObject911) {
            if (this.aClass18_912 != null) {
                this.aClass18_912.method1096();
                this.aClass18_912 = null;
            }

            this.aString913 = var1;
            if (this.aString913 != null) {
                if (var2) {
                    this.aColor914 = aColor876;
                } else {
                    this.aColor914 = aColor877;
                    if (this.aFontMetrics880.stringWidth(this.aString913) > 120) {
                        this.aString913 = this.aString913 + "...";

                        do {
                            this.aString913 = this.aString913.substring(0, this.aString913.length() - 4) + "...";
                        } while (this.aFontMetrics880.stringWidth(this.aString913) > 120);
                    }
                }

                this.anInt915 = 0;
                this.aClass18_912 = new Class18(this);
                Thread var4 = new Thread(this.aClass18_912);
                var4.setDaemon(true);
                var4.start();
            }
        }

        this.aSPanel__882.repaint();
    }

    protected void method1089(String var1) {
        this.aString908 = var1;
        this.aSPanel__882.repaint();
    }

    protected void method1090(String var1) {
        this.aString909 = var1;
        this.aSPanel__882.repaint();
    }

    protected void method1091() {
        this.aSynchronizedBool_884.method1007(false);
    }

    protected void method1092(Graphics var1, boolean var2, boolean var3) {
        int var4;
        if (this.aClass7_891.method1016() > 0) {
            var1.setColor(Color.white);

            for (var4 = 0; var4 < 10; ++var4) {
                double var5 = Math.random() * 9.0D;
                double var7 = Math.random() * 18.0D;
                var1.drawLine((int) ((double) this.aClass7_887.method1016() + var5 + 0.5D), (int) ((double) this.aClass7_888.method1016() - 9.0D + var7 + 0.5D), (int) ((double) this.aClass7_887.method1016() - var5 + 0.5D), (int) ((double) this.aClass7_888.method1016() + 9.0D - var7 + 0.5D));
            }

        } else {
            var4 = this.aClass7_889.method1016();
            int var9 = var4 >= 0 ? GameAreaPanel.anIntArray2719[var4] : -1;
            int var10;
            int var11;
            if (var2 && var9 != 3 && var9 != -1) {
                var10 = this.anInt896;
                var11 = this.anInt897;
                if (var10 >= 0 && var11 >= 0) {
                    if (var11 > this.aClass7_888.method1016()) {
                        var11 = this.aClass7_888.method1016();
                    }

                    if (var10 != this.aClass7_887.method1016() || var11 != this.aClass7_888.method1016()) {
                        int var12 = var10 - this.aClass7_887.method1016();
                        int var13 = var11 - this.aClass7_888.method1016();
                        double var14 = Math.sqrt((double) (var12 * var12 + var13 * var13));
                        this.anInt900 = (int) (-Math.asin((double) var13 / var14) * 90.0D * 2.0D / 3.141592653589793D + 0.5D);
                        var14 = 15.0D / var14;
                        var12 = (int) ((double) var12 * var14 + 0.5D);
                        var13 = (int) ((double) var13 * var14 + 0.5D);
                        var1.setColor(aColor869);
                        var1.drawLine(this.aClass7_887.method1016() - 1, this.aClass7_888.method1016(), this.aClass7_887.method1016() + var12 - 1, this.aClass7_888.method1016() + var13);
                        var1.drawLine(this.aClass7_887.method1016() + 1, this.aClass7_888.method1016(), this.aClass7_887.method1016() + var12 + 1, this.aClass7_888.method1016() + var13);
                        var1.drawLine(this.aClass7_887.method1016(), this.aClass7_888.method1016() - 1, this.aClass7_887.method1016() + var12, this.aClass7_888.method1016() + var13 - 1);
                        var1.drawLine(this.aClass7_887.method1016(), this.aClass7_888.method1016() + 1, this.aClass7_887.method1016() + var12, this.aClass7_888.method1016() + var13 + 1);
                        var1.setColor(aColor868);
                        var1.drawLine(this.aClass7_887.method1016(), this.aClass7_888.method1016(), this.aClass7_887.method1016() + var12, this.aClass7_888.method1016() + var13);
                    }
                }
            }

            var1.drawImage(this.aSynchronizedBool_883.method1008() ? this.aClientSettings_881.aGameSpriteManager_771.imageOwnCannon : this.aClientSettings_881.aGameSpriteManager_771.imageCannon, this.aClass7_887.method1016() - 12, this.aClass7_888.method1016() - 7, this.aSPanel__882);
            var10 = this.aClass7_890.method1016();
            if (var10 > 0) {
                var11 = Math.min(var10, 20);
                var1.setColor(Color.white);
                var1.drawOval(this.aClass7_887.method1016() - var11, this.aClass7_888.method1016() - var11, var11 * 2, var11 * 2);
                if (var10 > 20) {
                    double var16 = (double) var10 / 10.0D % 10.0D / 10.0D;
                    int var18 = (int) ((double) var11 + 10.0D * var16);
                    int var19 = (int) (255.0D - 255.0D * var16 + 0.5D);
                    var1.setColor(new Color(255, 255, 255, var19));
                    var1.drawOval(this.aClass7_887.method1016() - var18, this.aClass7_888.method1016() - var18, var18 * 2, var18 * 2);
                }

                this.aClass7_890.method1014();
            }

            if (var3) {
                Color var26 = this.aSynchronizedBool_883.method1008() ? aColor872 : aColor871;
                var1.setFont(GameApplet.fontDialog11);
                if (this.aString906 != null) {
                    this.method1093(var1, var26, this.aString907 == null ? this.aClientSettings_881.textManager.method2040("GameRealPlayer_Nick", this.aString906) : this.aClientSettings_881.textManager.method2041("GameRealPlayer_NickClan", this.aString906, this.aString907), this.aClass7_887.method1016(), this.aClass7_888.method1016() + 7 + 12);
                }

                String var27 = this.aString908;
                String var28 = this.aString909;
                if (this.aSynchronizedBool_884.method1008()) {
                    if (this.aDouble892 <= 0.0D && var28 == null) {
                        var26 = aColor873;
                        var27 = this.aClientSettings_881.textManager.method2039("GameRealPlayer_InfoDead");
                    }
                } else {
                    var26 = aColor874;
                    var28 = this.aClientSettings_881.textManager.method2039("GameRealPlayer_InfoQuit");
                }

                if (var28 != null) {
                    var27 = var28;
                }

                boolean var30 = var27 != null;
                if (var30) {
                    this.method1093(var1, var26, var27, this.aClass7_887.method1016(), this.aClass7_888.method1016() + 7 + 12 + 11);
                }

                boolean var29 = this.aSynchronizedBool_884.method1008() && this.aDouble892 > 0.0D;
                int var22;
                if (var29) {
                    byte var20 = 34;
                    byte var21 = 7;
                    var22 = this.aClass7_887.method1016() - var20 / 2;
                    int var23 = this.aClass7_888.method1016() + 7 + 12 + (var30 ? 13 : 0) + 3;
                    var1.setColor(Color.black);
                    var1.fillRect(var22, var23, var20, var21);
                    SPanel_Sub7.method2438(var1, var22, var23, var20, var21, this.aDouble892);
                    var1.setColor(Color.black);
                    var1.drawRect(var22, var23, var20 - 1, var21 - 1);
                }

                if (this.aBoolean886 && this.aDouble893 > 0.0D) {
                    var1.setFont(aFont878);
                    this.method1093(var1, aColor875, (int) (this.aDouble893 * 100.0D / 100.0D + 0.5D) + "%", this.aClass7_887.method1016(), this.aClass7_888.method1016() - 7 - 8);
                }

                if (this.aClientSettings_881.aPlayerInfo_764.anInt785 > 0) {
                    int var32 = CharacterImage.IMAGE_WIDTH[0];
                    int var33 = this.aClass7_887.method1016() - var32 / 2;
                    var22 = this.aClientSettings_881.aPlayerInfo_764.anInt785 == 1 ? this.aClass7_888.method1016() - 55 : this.aClass7_888.method1016() + 7 + 31 + (var30 ? 13 : 0) + (var29 ? 0 : -9);
                    this.aCharacterImage910.draw(var1, var33, var22, this.aSPanel__882);
                }

                Object var31 = this.anObject911;
                synchronized (this.anObject911) {
                    if (this.aString913 != null) {
                        var1.setFont(aFont879);
                        this.method1093(var1, this.aColor914, this.aString913, this.aClass7_887.method1016(), this.aClass7_888.method1016() - 7 - 6 - this.anInt915);
                    }
                }
            }

        }
    }

    private void method1093(Graphics var1, Color var2, String var3, int var4, int var5) {
        var1.setColor(var2);
        StringDraw.drawOutlinedString(var1, aColor870, var3, var4, var5, 0);
    }

    protected void method1094() {
        Object var1 = this.anObject911;
        synchronized (this.anObject911) {
            ++this.anInt915;
        }

        this.aSPanel__882.repaint();
    }

    protected void method1095() {
        Object var1 = this.anObject911;
        synchronized (this.anObject911) {
            this.aString913 = null;
            this.aClass18_912 = null;
        }

        this.aSPanel__882.repaint();
    }

    static {
        aStringArray917[0] = "...";
        aStringArray917[1] = "GameRealPlayer_InfoQuit";
        aStringArray917[2] = "GameRealPlayer_NickClan";
        aStringArray917[3] = "GameRealPlayer_Nick";
        aStringArray917[4] = "GameRealPlayer_InfoDead";
        aColor868 = new Color(0, 0, 0);
        aColor869 = new Color(16, 16, 64);
        aColor870 = new Color(0, 0, 0);
        aColor871 = new Color(255, 255, 255);
        aColor872 = new Color(192, 192, 255);
        aColor873 = new Color(255, 160, 32);
        aColor874 = new Color(255, 32, 32);
        aColor875 = new Color(255, 48, 16);
        aColor876 = new Color(128, 255, 255);
        aColor877 = new Color(255, 255, 128);
        aFont878 = GameApplet.fontDialog11;
        aFont879 = GameApplet.fontDialog11;
    }
}
