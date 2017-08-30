package acannons;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SPanel_Sub7 extends SPanel implements MouseListener {

    private static final Color aColor3877;
    private static final Color aColor3878;
    private static final Color aColor3879;
    private static final Color aColor3880;
    private static final Color aColor3881;
    private ClientSettings aClientSettings_3882;
    private GamePanel aSPanel__3883;
    private GameAreaPanel aSPanel__3884;
    private int anInt3885;
    private int anInt3886;
    private int anInt3887;
    private Class2[] aClass2Array3888;
    private int anInt3889;
    private boolean aBoolean3890;
    private static final String[] aStringArray3891 = new String[11];


    protected SPanel_Sub7(ClientSettings var1, GamePanel var2, GameAreaPanel var3, int var4, int var5) {
        this.aClientSettings_3882 = var1;
        this.aSPanel__3883 = var2;
        this.aSPanel__3884 = var3;
        this.anInt3885 = var4;
        this.anInt3886 = var5;
        this.setSize(var4, var5);
        this.aBoolean3890 = false;
        this.anInt3887 = 0;
    }

    public void paintContent(Graphics2D var1) {
        var1.setColor(aColor3877);
        var1.fillRect(0, 0, this.anInt3885, this.anInt3886);
        if (this.anInt3887 != 0) {
            double[] var2 = this.aSPanel__3883.method2426();
            if (var2 != null) {
                int var3 = this.anInt3886 / this.anInt3887;
                int[] var4 = this.method2445(var2);

                int var5;
                for (var5 = 0; var5 < this.anInt3887; ++var5) {
                    method2438(var1, 0, var5 * var3, this.anInt3885, var3, var2[var4[var5]]);
                }

                var1.setColor(aColor3878);
                var1.drawLine(0, 0, 0, this.anInt3886 - 1);
                var1.drawLine(this.anInt3885 - 1, 0, this.anInt3885 - 1, this.anInt3886 - 1);

                for (var5 = 0; var5 < this.anInt3887; ++var5) {
                    var1.drawLine(0, var5 * var3, this.anInt3885 - 1, var5 * var3);
                }

                var1.drawLine(0, this.anInt3886 - 1, this.anInt3885 - 1, this.anInt3886 - 1);
                boolean var10 = false;

                int var6;
                for (var6 = 0; var6 < this.anInt3887 && !var10; ++var6) {
                    if (this.aClass2Array3888[var6].method986() != 0) {
                        var10 = true;
                    }
                }

                for (var6 = 0; var6 < this.anInt3887; ++var6) {
                    Font var7 = var4[var6] == this.anInt3889 ? GameApplet.fontDialog12b : GameApplet.fontDialog12;
                    var1.setFont(var7);
                    int var8 = var6 * var3 + var3 / 2 + 6;
                    if (this.aClass2Array3888[var4[var6]].method985() != null) {
                        var1.setColor(this.aClass2Array3888[var4[var6]].method987() ? aColor3879 : aColor3881);
                        byte var9 = 10;
                        StringDraw.drawString(var1, this.aClass2Array3888[var4[var6]].method985(), var9, var8, -1);
                        if (var10) {
                            StringDraw.drawString(var1, "" + this.aClass2Array3888[var4[var6]].method986(), this.anInt3885 - 10, var8, 1);
                        }
                    } else {
                        var1.setColor(aColor3880);
                        var1.drawString(this.aClientSettings_3882.textManager.method2039("GamePlayerInfo_WaitingPlayer"), 10, var8);
                    }
                }

            }
        }
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        if (var1.getClickCount() == 2) {
            int var2 = var1.getY();
            int var3 = this.anInt3886 / this.anInt3887;

            for (int var4 = 0; var4 < this.anInt3887; ++var4) {
                if (this.aClass2Array3888[var4].method985() != null && var2 >= var4 * var3 && var2 < var4 * var3 + var3) {
                    this.aClientSettings_3882.gameApplet.method2288(this.aClass2Array3888[var4].method985());
                }
            }

        }
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public static void method2438(Graphics var0, int var1, int var2, int var3, int var4, double var5) {
        if (var5 == 50.0D) {
            var0.setColor(new Color(255, 255, 0));
        } else if (var5 < 50.0D) {
            var0.setColor(new Color(255, (int) (255.0D - (50.0D - var5) * 5.0D + 0.5D), 0));
        } else if (var5 > 50.0D) {
            var0.setColor(new Color((int) (0.0D + (100.0D - var5) * 5.0D + 0.5D), 255, 0));
        }

        int var7 = (int) ((double) var3 * var5 / 100.0D + 0.5D);
        if (var5 > 0.0D && var7 <= 1) {
            var7 = 2;
        }

        var0.fillRect(var1, var2, var7, var4);
    }

    protected boolean handlePacket(String[] var1) {
        int var2;
        if (var1[1].equals("gameinfo")) {
            this.anInt3887 = Integer.parseInt(var1[2]);
            this.aClass2Array3888 = new Class2[this.anInt3887];

            for (var2 = 0; var2 < this.anInt3887; ++var2) {
                this.aClass2Array3888[var2] = new Class2(this, var2);
            }

            this.repaint();
            return true;
        } else if (var1[1].equals("startgame")) {
            this.anInt3887 = Integer.parseInt(var1[3]);
            this.aClass2Array3888 = new Class2[this.anInt3887];

            for (var2 = 0; var2 < this.anInt3887; ++var2) {
                this.aClass2Array3888[var2] = new Class2(this, var2);
                this.aClass2Array3888[var2].method981(var1[4 + var2 * 3], this.aSPanel__3883.method2432(var1[5 + var2 * 3]));
            }

            this.method2444();
            this.anInt3889 = Integer.parseInt(var1[2]);
            return true;
        } else {
            int var3;
            if (var1[1].equals("players")) {
                var2 = (var1.length - 2) / 4;

                for (var3 = 0; var3 < var2; ++var3) {
                    int var4 = Integer.parseInt(var1[2 + var3 * 4]);
                    this.aClass2Array3888[var4].method981(var1[3 + var3 * 4], this.aSPanel__3883.method2432(var1[4 + var3 * 4]));
                }

                this.method2444();
                return true;
            } else if (!var1[1].equals("score")) {
                boolean var5 = var1[1].equals("owninfo");
                if (!var5 && !var1[1].equals("join")) {
                    if (var1[1].equals("part")) {
                        var3 = Integer.parseInt(var1[2]);
                        this.aClass2Array3888[var3].method982(Integer.parseInt(var1[3]) == 3);
                        this.repaint();
                        return true;
                    } else if (var1[1].equals("startround")) {
                        this.aBoolean3890 = true;
                        this.repaint();
                        return true;
                    } else if (var1[1].equals("endround")) {
                        this.aBoolean3890 = false;
                        this.repaint();
                        return true;
                    } else if (var1[1].equals("endgame")) {
                        this.aClientSettings_3882.gameApplet.method2290(this.method2446());
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    var3 = Integer.parseInt(var1[2]);
                    this.aClass2Array3888[var3].method981(var1[3], this.aSPanel__3883.method2432(var1[4]));
                    if (var5) {
                        this.anInt3889 = var3;
                    }

                    this.repaint();
                    return true;
                }
            } else {
                for (var2 = 0; var2 < this.anInt3887; ++var2) {
                    this.aClass2Array3888[var2].method983(Integer.parseInt(var1[2 + var2]));
                }

                this.repaint();
                return true;
            }
        }
    }

    protected String method2440(int var1) {
        return this.aClass2Array3888[var1].method985();
    }

    protected void method2441(int var1, int var2) {
        this.aClass2Array3888[var1].method984(var2);
    }

    protected void method2442(int var1, int var2) {
        if (this.aClientSettings_3882.aPlayerInfo_764.aBoolean787) {
            String var3 = var2 > 0 ? "+" + var2 : "" + var2;
            this.aSPanel__3884.method2360(var1, var3);
        }

    }

    protected String[] method2443() {
        boolean[] var1 = this.method2446();
        int var2 = 0;

        for (int var3 = 0; var3 < this.anInt3887; ++var3) {
            if (var1[var3]) {
                ++var2;
            }
        }

        String[] var6 = new String[var2];
        int var4 = 0;

        for (int var5 = 0; var5 < this.anInt3887; ++var5) {
            if (var1[var5]) {
                var6[var4] = this.aClass2Array3888[var5].method985();
                ++var4;
            }
        }

        return var6;
    }

    private void method2444() {
        this.removeMouseListener(this);
        this.addMouseListener(this);
        this.repaint();
    }

    private int[] method2445(double[] var1) {
        int[] var2 = new int[this.anInt3887];
        String[] var3 = new String[this.anInt3887];

        int var4;
        for (var4 = 0; var4 < this.anInt3887; ++var4) {
            var2[var4] = this.aClass2Array3888[var4].method988(this.aBoolean3890, var1[var4]);
            var3[var4] = this.aClass2Array3888[var4].method989();
        }

        int var5;
        for (var4 = 0; var4 < this.anInt3887; ++var4) {
            for (var5 = 0; var5 < this.anInt3887; ++var5) {
                if (var4 != var5 && var3[var4].compareTo(var3[var5]) < 0) {
                    ++var2[var4];
                }
            }
        }

        int[] var8 = new int[this.anInt3887];

        for (int var6 = 0; var6 < this.anInt3887; ++var6) {
            var5 = 0;

            for (int var7 = 1; var7 < this.anInt3887; ++var7) {
                if (var2[var7] > var2[var5]) {
                    var5 = var7;
                }
            }

            var8[var6] = var5;
            var2[var5] = -1;
        }

        return var8;
    }

    private boolean[] method2446() {
        int var1 = -1;

        for (int var2 = 0; var2 < this.anInt3887; ++var2) {
            if (this.aClass2Array3888[var2].method987() && this.aClass2Array3888[var2].method986() > var1) {
                var1 = this.aClass2Array3888[var2].method986();
            }
        }

        boolean[] var4 = new boolean[this.anInt3887];

        for (int var3 = 0; var3 < this.anInt3887; ++var3) {
            var4[var3] = this.aClass2Array3888[var3].method987() && this.aClass2Array3888[var3].method986() == var1;
        }

        return var4;
    }

    static {
        aStringArray3891[0] = "GamePlayerInfo_WaitingPlayer";
        aStringArray3891[1] = "gameinfo";
        aStringArray3891[2] = "join";
        aStringArray3891[3] = "part";
        aStringArray3891[4] = "players";
        aStringArray3891[5] = "score";
        aStringArray3891[6] = "owninfo";
        aStringArray3891[7] = "startround";
        aStringArray3891[8] = "endround";
        aStringArray3891[9] = "endgame";
        aStringArray3891[10] = "startgame";
        aColor3877 = new Color(160, 160, 160);
        aColor3878 = Color.black;
        aColor3879 = Color.black;
        aColor3880 = new Color(0, 128, 0);
        aColor3881 = new Color(144, 0, 0);
    }
}
