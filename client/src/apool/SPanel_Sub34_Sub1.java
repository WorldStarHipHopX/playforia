package apool;

import com.playray.client.CharacterImage;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class SPanel_Sub34_Sub1 extends SPanel_Sub34 implements MouseMotionListener, MouseListener {

    private static final Cursor aCursor4896;
    private static final Cursor aCursor4897;
    private SPanel_Sub20_Sub2 aSPanel_Sub20_Sub2_4898;
    private int anInt4899;
    private boolean aBoolean4900;
    private String aString4901;
    private CharacterImage aCharacterImage4902;
    private SynchronizedInt aSynchronizedInt_4903;
    private SynchronizedInt aSynchronizedInt_4904;
    private boolean[] aBooleanArray4905;
    private Image[][] anImageArrayArray4906;
    private SynchronizedBool aSynchronizedBool_4907;
    private static final String[] aStringArray4908 = new String[9];


    protected SPanel_Sub34_Sub1(Class60 var1, SPanel_Sub20_Sub2 var2, int var3, int var4, int var5) {
        super(var1, var4, var5);
        this.aSPanel_Sub20_Sub2_4898 = var2;
        this.anInt4899 = var3;
        this.aBoolean4900 = var3 == 5;
        this.aSynchronizedInt_4903 = new SynchronizedInt();
        this.aSynchronizedInt_4904 = new SynchronizedInt();
        this.anImageArrayArray4906 = this.aBoolean4900 ? var1.gameApplet.method2315() : var1.gameApplet.method2314();
        this.aBooleanArray4905 = new boolean[this.aBoolean4900 ? 22 : 16];
        this.aSynchronizedBool_4907 = new SynchronizedBool();
    }

    public void method2738(Graphics2D var1) {
        if (this.aString4901 != null) {
            if (this.aCharacterImage4902 != null) {
                this.aCharacterImage4902.draw(var1, 10, 9, this);
            }

            var1.setColor(SPanel_Sub34.aColor4201);
            var1.setFont(SPanel_Sub34.aFont4199);
            var1.drawString(this.aString4901, 100, 28);
            int var2 = this.aBooleanArray4905.length;
            int var3 = 100;
            int var4 = this.aBoolean4900 ? 14 : 23;
            int var5 = 45 + (this.aBoolean4900 ? 4 : 0);

            for (int var6 = 1; var6 < var2; ++var6) {
                var1.drawImage(this.anImageArrayArray4906[this.aBooleanArray4905[var6] ? 0 : 1][var6], var3, var5, this);
                var3 += var4;
            }

            String var8 = null;
            var3 += 40;
            int var7;
            if (!this.aBoolean4900) {
                var7 = this.aSynchronizedInt_4904.method1467();
                if (this.anInt4899 != 3) {
                    if (var7 == 0) {
                        var8 = super.aClass60_4202.textManager.method2039("GamePlayerInfo_Balls0");
                    } else if (var7 == 1) {
                        var8 = super.aClass60_4202.textManager.method2039("GamePlayerInfo_Balls1");
                    } else if (var7 > 1) {
                        var8 = super.aClass60_4202.textManager.method2045("GamePlayerInfo_BallsX", var7);
                    }
                } else if (var7 == 0) {
                    var8 = super.aClass60_4202.textManager.method2045("GamePlayerInfo_Balls0PerX", 99);
                } else if (var7 == 1) {
                    var8 = super.aClass60_4202.textManager.method2045("GamePlayerInfo_Balls1PerX", 99);
                } else if (var7 > 1) {
                    var8 = super.aClass60_4202.textManager.method2046("GamePlayerInfo_BallsXPerX", var7, 99);
                }

                var1.setFont(SPanel_Sub34.aFont4200);
                var1.drawString(var8, var3, 60);
            }

            var7 = this.aSynchronizedInt_4903.method1467();
            if (var7 == 0) {
                var8 = super.aClass60_4202.textManager.method2039("GamePlayerInfo_Strokes0");
            } else if (var7 == 1) {
                var8 = super.aClass60_4202.textManager.method2039("GamePlayerInfo_Strokes1");
            } else if (var7 > 1) {
                var8 = super.aClass60_4202.textManager.method2045("GamePlayerInfo_StrokesX", var7);
            }

            var1.setFont(SPanel_Sub34.aFont4199);
            var1.drawString(var8, var3, 28);
        }
    }

    public void mouseMoved(MouseEvent var1) {
        if (this.aSynchronizedBool_4907.method1460()) {
            int var2 = var1.getX();
            int var3 = var1.getY();
            int var4 = this.aBooleanArray4905.length;
            int var5 = 100;
            int var6 = this.aBoolean4900 ? 14 : 23;
            int var7 = 45 + (this.aBoolean4900 ? 4 : 0);
            int var8 = this.aBoolean4900 ? 12 : 20;
            if (var3 >= var7 && var3 < var7 + var8) {
                for (int var9 = 1; var9 < var4; ++var9) {
                    if (var2 >= var5 && var2 < var5 + var8 && this.aBooleanArray4905[var9]) {
                        this.setCursor(aCursor4897);
                        return;
                    }

                    var5 += var6;
                }
            }

            this.setCursor(aCursor4896);
        }

    }

    public void mouseDragged(MouseEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        if (this.aSynchronizedBool_4907.method1460()) {
            int var2 = var1.getX();
            int var3 = var1.getY();
            int var4 = this.aBooleanArray4905.length;
            int var5 = 100;
            int var6 = this.aBoolean4900 ? 14 : 23;
            int var7 = 45 + (this.aBoolean4900 ? 4 : 0);
            int var8 = this.aBoolean4900 ? 12 : 20;
            if (var3 >= var7 && var3 < var7 + var8) {
                for (int var9 = 1; var9 < var4; ++var9) {
                    if (var2 >= var5 && var2 < var5 + var8 && this.aBooleanArray4905[var9]) {
                        this.aSPanel_Sub20_Sub2_4898.method2568(var9);
                        return;
                    }

                    var5 += var6;
                }
            }
        }

    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    protected void method2739(String var1, String var2) {
        this.aString4901 = var1;
        this.aCharacterImage4902 = new CharacterImage(super.aClass60_4202.imageManager, var2, 1);
        this.repaint();
    }

    protected void method2740() {
        this.aSynchronizedInt_4903.method1463(0);
        this.aSynchronizedInt_4904.method1463(0);
        this.method2745();
    }

    protected void method2741() {
        this.aSynchronizedInt_4903.method1464();
        this.repaint();
    }

    protected void method2742(int var1, boolean var2) {
        if (this.aBoolean4900 && var1 <= 15) {
            int var3;
            if (var2) {
                for (var3 = 1; var3 <= 15; ++var3) {
                    if (!this.aBooleanArray4905[var3]) {
                        var1 = var3;
                        var3 = 15;
                    }
                }
            } else {
                for (var3 = 15; var3 >= 1; --var3) {
                    if (this.aBooleanArray4905[var3]) {
                        var1 = var3;
                        var3 = 1;
                    }
                }
            }
        }

        this.aBooleanArray4905[var1] = var2;
        this.aSynchronizedInt_4904.method1466(var2 ? 1 : -1);
        this.repaint();
    }

    protected int method2743() {
        return this.aSynchronizedInt_4903.method1467();
    }

    protected int method2744() {
        return this.aSynchronizedInt_4904.method1467();
    }

    protected void method2745() {
        int var1 = this.aBooleanArray4905.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            this.aBooleanArray4905[var2] = false;
        }

        this.repaint();
    }

    protected boolean method2746(boolean var1) {
        this.aSynchronizedBool_4907.method1459(var1);
        this.removeMouseMotionListener(this);
        this.removeMouseListener(this);
        if (var1) {
            this.addMouseMotionListener(this);
            this.addMouseListener(this);
        }

        return var1;
    }

    protected boolean[] method2747() {
        boolean[] var1 = new boolean[this.aBooleanArray4905.length];

        for (int var2 = 0; var2 < this.aBooleanArray4905.length; ++var2) {
            var1[var2] = this.aBooleanArray4905[var2];
        }

        return var1;
    }

    protected void method2748(SynchronizedInt var1, SynchronizedInt var2, boolean[] var3) {
        this.aSynchronizedInt_4903.method1463(var1.method1467());
        this.aSynchronizedInt_4904.method1463(var2.method1467());

        for (int var4 = 0; var4 < this.aBooleanArray4905.length; ++var4) {
            this.aBooleanArray4905[var4] = var3[var4];
        }

        this.repaint();
    }

    static {
        aStringArray4908[0] = "GamePlayerInfo_Balls0";
        aStringArray4908[1] = "GamePlayerInfo_Strokes0";
        aStringArray4908[2] = "GamePlayerInfo_BallsX";
        aStringArray4908[3] = "GamePlayerInfo_Balls1PerX";
        aStringArray4908[4] = "GamePlayerInfo_Balls1";
        aStringArray4908[5] = "GamePlayerInfo_Balls0PerX";
        aStringArray4908[6] = "GamePlayerInfo_StrokesX";
        aStringArray4908[7] = "GamePlayerInfo_BallsXPerX";
        aStringArray4908[8] = "GamePlayerInfo_Strokes1";
        aCursor4896 = new Cursor(0);
        aCursor4897 = new Cursor(12);
    }
}
