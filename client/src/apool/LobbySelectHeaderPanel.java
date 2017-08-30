package apool;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.GlossyButton;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D.Double;

public class LobbySelectHeaderPanel extends SPanel implements MouseListener, ActionListener {

    protected static final Font aFont4040;
    private static final int[] anIntArray4041;
    private long[] aLongArray4042;
    private int anInt4043;
    private Class60 aClass60_4044;
    private boolean aBoolean4045;
    private boolean aBoolean4046;
    private int anInt4047;
    private int anInt4048;
    private int anInt4049;
    private int anInt4050;
    private int anInt4051;
    private int anInt4052;
    private int anInt4053;
    private SPanel_Sub24 aSPanel_Sub24_4054;
    private SPanel_Sub23 aSPanel_Sub23_4055;
    private GlossyButton aGlossyButton4056;
    private GlossyButton aGlossyButton4057;
    private String aString4058;
    public static boolean aBoolean4059;
    private static final String[] aStringArray4060 = new String[18];


    public LobbySelectHeaderPanel(Class60 var1) {
        this.aClass60_4044 = var1;
        this.aBoolean4045 = var1.aBoolean1205;
        this.aBoolean4046 = var1.aBoolean1206;
        this.setSize(var1.anInt1201, var1.anInt1202);
        this.method2594();
        this.addMouseListener(this);
        this.anInt4047 = 0;
    }

    public void paintContent(Graphics2D var1) {
        if (!this.aBoolean4045) {
            var1.drawImage(this.aClass60_4044.imageManager.method1983("lobbyselect_header-0"), this.aClass60_4044.anInt1201 / 2 - 370, 0, this);
            var1.setFont(GameApplet.aFont4814);
            var1.setColor(Color.white);
            int var2 = Integer.MIN_VALUE;
            if (!this.aBoolean4046) {
                var2 = StringDraw.drawString(var1, this.aClass60_4044.textManager.method2039("LobbySelect_SpHeader"), 80, 34, -1);
            }

            int var3 = StringDraw.drawString(var1, this.aClass60_4044.textManager.method2039("LobbySelect_MpHeader"), this.aClass60_4044.anInt1201 - 83, 34, 1);
            this.anInt4048 = 24;
            this.anInt4049 = 80 + var2 + 15;
            this.anInt4050 = this.aClass60_4044.anInt1201 - 83 - var3 - 15;
            this.anInt4051 = this.aClass60_4044.anInt1201 - 25;
            this.anInt4052 = 7;
            this.anInt4053 = 47;
            int var4;
            int var5;
            if (this.anInt4047 == 1) {
                var4 = this.anInt4048;
                var5 = this.anInt4049;
            } else {
                var4 = this.anInt4050;
                var5 = this.anInt4051;
            }

            Shape var6 = var1.getClip();
            var1.setClip(new Double((double) var4, (double) this.anInt4052, (double) (var5 - var4), (double) (this.anInt4053 - this.anInt4052), 7.0D, 7.0D));
            var1.drawImage(this.aClass60_4044.imageManager.method1983("lobbyselect_header-1"), this.aClass60_4044.anInt1201 / 2 - 370, 0, this);
            var1.setColor(Color.black);
            if (!this.aBoolean4046) {
                StringDraw.drawString(var1, this.aClass60_4044.textManager.method2039("LobbySelect_SpHeader"), 80, 34, -1);
            }

            StringDraw.drawString(var1, this.aClass60_4044.textManager.method2039("LobbySelect_MpHeader"), this.aClass60_4044.anInt1201 - 83, 34, 1);
            var1.setClip(var6);
            var1.setFont(GameApplet.aFont4813);
            var1.setColor(GameApplet.aColor4808);
            StringDraw.drawString(var1, this.aClass60_4044.textManager.method2039("LobbySelect_" + (this.anInt4047 == 1 ? "Sp" : "Mp") + "Title"), this.aClass60_4044.anInt1201 / 2, 140, 0);
        }
    }

    public void mousePressed(MouseEvent var1) {
        if (this.anInt4052 > 0) {
            int var2 = var1.getY();
            if (var2 >= this.anInt4052 && var2 <= this.anInt4053) {
                int var3 = var1.getX();
                if (var3 >= this.anInt4048 && var3 <= this.anInt4049 && this.anInt4047 != 1) {
                    this.method2595(1);
                } else if (var3 >= this.anInt4050 && var3 <= this.anInt4051 && this.anInt4047 != 2) {
                    this.method2595(2);
                }
            }
        }

    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aGlossyButton4056) {
            this.method2595(this.anInt4047 == 1 ? 2 : 1);
        } else if (var2 == this.aGlossyButton4057) {
            this.aClass60_4044.gameApplet.method2325(true);
        }

    }

    public void method2587(String var1) {
        this.aString4058 = var1;
    }

    public void method2588() {
        this.aSPanel_Sub23_4055.method2597();
    }

    public void method2589() {
        this.aSPanel_Sub23_4055.method2598();
    }

    public void method2590(String[] var1) {
        this.aSPanel_Sub23_4055.method2596(var1);
        if (var1[1].equals("lobbylist")) {
            byte var2 = 2;
            if (!this.aBoolean4046 && this.aString4058 != null && this.aString4058.equals("_singleplayer")) {
                var2 = 1;
            }

            this.method2595(var2);
        }

    }

    protected boolean method2591(GlossyButton_Sub2 var1) {
        if (!var1.method2881()) {
            return false;
        } else {
            boolean var2 = var1.method2880();
            int var3 = var1.method2882();
            this.aClass60_4044.gameApplet.method2304(0);
            if (var2) {
                this.method2592("spselected\t" + var3);
            } else {
                if (this.aLongArray4042 == null) {
                    this.aLongArray4042 = new long[anIntArray4041.length];

                    for (int var4 = 0; var4 < anIntArray4041.length; ++var4) {
                        this.aLongArray4042[var4] = 0L;
                    }
                }

                long var5 = System.currentTimeMillis();
                long var7 = 0L;

                int var9;
                for (var9 = 0; var9 < anIntArray4041.length; ++var9) {
                    long var10 = this.aLongArray4042[var9] + (long) (anIntArray4041[var9] * (var3 == this.anInt4043 ? 2 : 1)) - var5;
                    if (var10 > var7) {
                        var7 = var10;
                    }
                }

                for (var9 = anIntArray4041.length - 1; var9 >= 1; --var9) {
                    this.aLongArray4042[var9] = this.aLongArray4042[var9 - 1];
                }

                this.aLongArray4042[0] = var5 + var7;
                this.anInt4043 = var3;
                Tools.sleep(var7);
                this.method2592("mpselected\t" + var3);
            }

            return true;
        }
    }

    protected void method2592(String var1) {
        Conn var2 = this.aClass60_4044.connection;
        if (var2 != null) {
            var2.method1475("lobbyselect\t" + var1);
        }

    }

    public void method2593(String var1) {
    }

    private void method2594() {
        this.aSPanel_Sub24_4054 = new SPanel_Sub24(this.aClass60_4044, this);
        this.aSPanel_Sub24_4054.setBounds(0, 75, this.aClass60_4044.anInt1201, this.aClass60_4044.anInt1202 - 50 - 75);
        this.aSPanel_Sub23_4055 = new SPanel_Sub23(this.aClass60_4044, this);
        this.aSPanel_Sub23_4055.setBounds(0, 75, this.aClass60_4044.anInt1201, this.aClass60_4044.anInt1202 - 50 - 75);
        this.aGlossyButton4056 = new GlossyButton(this.aClass60_4044.textManager.method2039("LobbySelect_ChangeButton"), 4);
        this.aGlossyButton4056.setBounds(this.aClass60_4044.anInt1201 / 2 - 40, 20, 80, 20);
        this.aGlossyButton4056.setBackground(this.aClass60_4044.imageManager.method1983("lobbyselect_header-0"), -330, -20);
        this.aGlossyButton4056.addActionListener(this);
        this.add(this.aGlossyButton4056);
        this.aGlossyButton4057 = new GlossyButton(this.aClass60_4044.textManager.method2039("LobbySelect_Quit"), 2);
        this.aGlossyButton4057.setBounds(this.aClass60_4044.anInt1201 - 20 - 100, this.aClass60_4044.anInt1202 - 10 - 20, 100, 20);
        this.aGlossyButton4057.addActionListener(this);
        this.add(this.aGlossyButton4057);
    }

    private void method2595(int var1) {
        if (!this.aBoolean4045 && var1 != this.anInt4047) {
            if (this.anInt4047 == 1) {
                this.remove(this.aSPanel_Sub24_4054);
            }

            if (this.anInt4047 == 2) {
                this.remove(this.aSPanel_Sub23_4055);
            }

            this.anInt4047 = var1;
            if (var1 == 1) {
                this.setBackground(this.aClass60_4044.imageManager.method1983("bg-single"), -20, 0);
                this.add(this.aSPanel_Sub24_4054);
            }

            if (var1 == 2) {
                this.setBackground(this.aClass60_4044.imageManager.method1983("bg-multi"), -20, 0);
                this.add(this.aSPanel_Sub23_4055);
            }

        }
    }

    static {
        aStringArray4060[0] = "mpselected\t";
        aStringArray4060[1] = "spselected\t";
        aStringArray4060[2] = "lobbyselect\t";
        aStringArray4060[3] = "bg-single";
        aStringArray4060[4] = "bg-multi";
        aStringArray4060[5] = "Title";
        aStringArray4060[6] = "Mp";
        aStringArray4060[7] = "lobbyselect_header-1";
        aStringArray4060[8] = "LobbySelect_MpHeader";
        aStringArray4060[9] = "LobbySelect_";
        aStringArray4060[10] = "lobbyselect_header-0";
        aStringArray4060[11] = "Sp";
        aStringArray4060[12] = "LobbySelect_SpHeader";
        aStringArray4060[13] = "LobbySelect_Quit";
        aStringArray4060[14] = "LobbySelect_ChangeButton";
        aStringArray4060[15] = "lobbylist";
        aStringArray4060[16] = "_singleplayer";
        aStringArray4060[17] = "Dialog";
        aFont4040 = new Font("Dialog", 1, 14);
        anIntArray4041 = new int[]{2000, 5000, 12000};
    }
}
