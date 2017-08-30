package acannons;

import com.playray.bigtext.BigText;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.GlossyButton;
import com.playray.tools.DelayTimer;
import com.playray.tools.QuickTimer;
import com.playray.tools.QuickTimerListener;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;

public class GameAreaPanel extends SPanel implements Runnable, MouseMotionListener, MouseListener, ActionListener, QuickTimerListener {

    public static final Color[] aColorArray2699;
    protected static final Color[] aColorArray2700;
    private static final Color[] aColorArray2701;
    private static final Color[] aColorArray2702;
    private static final Color[] aColorArray2703;
    private static final Color[] aColorArray2704;
    private static final Color[] aColorArray2705;
    private static final Color[] aColorArray2706;
    private static final Color[] aColorArray2707;
    private static final Color[] aColorArray2708;
    private static final Color aColor2709;
    private static final Color aColor2710;
    private static final Color aColor2711;
    private static final Color aColor2712;
    private static final Color aColor2713;
    private static final Color aColor2714;
    private static final Color aColor2715;
    private static final Color aColor2716;
    private static final Cursor aCursor2717;
    private static final Cursor aCursor2718;
    protected static final int[] anIntArray2719;
    private static int anInt2720;
    private ClientSettings aClientSettings_2721;
    private GamePanel aSPanel__2722;
    private int anInt2723;
    private int anInt2724;
    private int anInt2725;
    private int anInt2726;
    private int anInt2727;
    private int anInt2728;
    private boolean aBoolean2729;
    private Class7 aClass7_2730;
    private Class15[] aClass15Array2731;
    private Gamesomething[] aGamesomethingArray2732;
    private LinkedList aLinkedList2733;
    private Class14 aClass14_2734;
    private int[] anIntArray2735;
    private byte[][] aByteArrayArray2736;
    private BufferedImage aBufferedImage2737;
    private BufferedImage aBufferedImage2738;
    private Graphics2D aGraphics2D2739;
    private int[] anIntArray2740;
    private Image anImage2741;
    private int anInt2742;
    private int anInt2743;
    private int anInt2744;
    private int anInt2745;
    private int anInt2746;
    private BigText aBigText2747;
    private Object anObject2748;
    private Class7[] aClass7Array2749;
    private GameWeaponPanel aSPanel__2750;
    private Object anObject2751;
    private GameSomethingrunnable aGameSomethingrunnable_2752;
    private Class7 aClass7_2753;
    private Class3 aClass3_2754;
    private Thread aThread2755;
    private GlossyButton aGlossyButton2756;
    private GlossyButton aGlossyButton2757;
    private int anInt2758;
    private int anInt2759;
    private int anInt2760;
    public static boolean aBoolean2761;
    private static final String[] aStringArray2762 = new String[36];


    public GameAreaPanel(ClientSettings var1, GamePanel var2) {
        this.aClientSettings_2721 = var1;
        this.aSPanel__2722 = var2;
        this.setSize(760, 400);
        this.anObject2751 = new Object();
        this.aClass7_2730 = new Class7();
        this.aClass7_2753 = new Class7();
        this.anObject2748 = new Object();
        this.anInt2723 = 0;
        this.aLinkedList2733 = new LinkedList();
        this.aByteArrayArray2736 = new byte[760][400];
        this.aClass7Array2749 = new Class7[18];

        for (int var3 = 0; var3 < 18; ++var3) {
            this.aClass7Array2749[var3] = new Class7();
        }

        this.aBigText2747 = null;
        this.anInt2758 = this.anInt2759 = -1;
        this.anInt2760 = 0;
        this.setBackground(var1.imageManager.method1983("sky"));
        this.aGlossyButton2756 = new GlossyButton(var1.textManager.method2039("GameReal_WeaponButton"), 3);
        this.aGlossyButton2756.setBounds(10, 5, 90, 19);
        this.aGlossyButton2756.setCursor(aCursor2717);
        this.aGlossyButton2756.addActionListener(this);
        this.aGlossyButton2756.setVisible(false);
        this.add(this.aGlossyButton2756);
        this.aGlossyButton2757 = new GlossyButton(var1.textManager.method2039("GameReal_SkipButton"), 4);
        this.aGlossyButton2757.setBounds(690, 5, 60, 19);
        this.aGlossyButton2757.setCursor(aCursor2717);
        this.aGlossyButton2757.addActionListener(this);
        this.aGlossyButton2757.setVisible(false);
        this.add(this.aGlossyButton2757);
    }

    public void repaint() {
        if (this.anInt2723 != 3) {
            super.repaint();
        }
    }

    public void paintComponent(Graphics var1) {
        if (this.anInt2723 != 3) {
            super.paintComponent(var1);
        }
    }

    public void paintContent(Graphics2D var1) {
        var1.setColor(GameApplet.aColor4781);
        var1.fillRect(0, 0, 760, 400);
        if (this.anInt2723 == 1 || this.anInt2723 == 2 || this.anInt2723 == 4) {
            var1.drawImage(this.aBufferedImage2738, 0, 0, this);
            this.method2385(var1, true);
            this.method2387(var1);
            this.method2388(var1);
            if (this.anInt2744 != 0) {
                this.method2393(var1);
            }

            if (this.anInt2723 == 2) {
                int[] var2 = this.aGamesomethingArray2732[this.anInt2743].method1064();
                if (var2 != null) {
                    this.method2389(var1, var2[0], var2[1]);
                }

                int var3 = this.aGamesomethingArray2732[this.anInt2743].method1056();
                var2 = this.aGamesomethingArray2732[this.anInt2743].method1063();
                if (var2 != null) {
                    this.method2390(var1, var2[0], var2[1], var3);
                }

                int var4 = this.aClass7_2753.method1016();
                int var5;
                if (var4 > 0 && (this.aClass7_2730.method1016() > 0 || this.aClass7_2730.method1016() == 0 && var4 <= 30)) {
                    var5 = this.method2381();
                    boolean var6 = var5 < 30 ? var4 <= 5 : var4 <= 10;
                    var1.setColor(!var6 ? aColor2714 : aColor2715);
                    var1.setFont(!var6 ? GameApplet.fontDialog18 : GameApplet.fontDialog22);
                    StringDraw.drawOutlinedString(var1, aColorArray2699[this.aClientSettings_2721.useWinterGraphics], "" + var4, 750, !var6 ? 42 : 45, 1);
                }

                if (var3 >= 0) {
                    var1.setColor(GameApplet.aColor4782);
                    var1.setFont(GameApplet.fontDialog14b);
                    var5 = StringDraw.drawOutlinedString(var1, aColorArray2699[this.aClientSettings_2721.useWinterGraphics], this.aClientSettings_2721.textManager.method2039("GameReal_WeaponName_" + var3), 10, 41, -1);
                    if (this.aClass7Array2749[var3].method1016() >= 0) {
                        var1.setFont(GameApplet.fontDialog14);
                        StringDraw.drawOutlinedString(var1, aColorArray2699[this.aClientSettings_2721.useWinterGraphics], this.aClientSettings_2721.textManager.method2045("GameReal_WeaponLeft", this.aClass7Array2749[var3].method1016()), 10 + var5 + 10, 41, -1);
                    }

                    var1.setFont(GameApplet.fontDialog12);
                    if ((anIntArray2719[var3] == 1 || anIntArray2719[var3] == 3) && this.aGamesomethingArray2732[this.anInt2743].method1063() == null) {
                        StringDraw.drawOutlinedString(var1, aColorArray2699[this.aClientSettings_2721.useWinterGraphics], this.aClientSettings_2721.textManager.method2039("GameReal_SelectTarget"), 12, 58, -1);
                        if (var3 == 13) {
                            this.method2391(var1, var3);
                        } else {
                            this.method2390(var1, this.anInt2758, this.anInt2759, var3);
                        }
                    } else {
                        int var8 = this.aGamesomethingArray2732[this.anInt2743].method1057();
                        if (var8 >= 0) {
                            int var7 = (int) (this.method2399(this.anInt2743, this.aGamesomethingArray2732[this.anInt2743].method1056())[2] + 0.5D);
                            if (var7 >= 20) {
                                StringDraw.drawOutlinedString(var1, aColorArray2699[this.aClientSettings_2721.useWinterGraphics], this.aClientSettings_2721.textManager.method2045("GameReal_Angle", var8), 15, 59, -1);
                                StringDraw.drawOutlinedString(var1, aColorArray2699[this.aClientSettings_2721.useWinterGraphics], this.aClientSettings_2721.textManager.method2045("GameReal_Power", var7), 15, 74, -1);
                                this.method2391(var1, var3);
                            }
                        }
                    }
                }
            } else if (this.anInt2760 == 2) {
                var1.setColor(aColor2714);
                var1.setFont(GameApplet.fontDialog12);
                StringDraw.drawOutlinedStringWithMaxWidth(var1, aColorArray2699[this.aClientSettings_2721.useWinterGraphics], this.aClientSettings_2721.textManager.method2039("GameReal_WaitingOtherPlayers"), 750, 20, 1, 253);
            }

            if (this.anInt2742 >= 0) {
                this.method2386(var1, true, this.anInt2742);
            }

            if (this.anInt2723 == 4 && this.aBigText2747 != null) {
                if (this.aBigText2747.getWidth() < 740) {
                    this.aBigText2747.drawText(var1, 380, 190, 0, 1);
                } else {
                    var1.setFont(GameApplet.fontDialog22);
                    var1.setColor(GameApplet.aColor4782);
                    StringDraw.drawOutlinedStringWithMaxWidth(var1, Color.black, this.aBigText2747.getOriginalText(), 380, 190, 0, 740);
                }
            }
        }

    }

    public void updateUI(Object var1) {
        if (this.aSPanel__2750 != null) {
            this.remove(this.aSPanel__2750);
            this.aSPanel__2750 = null;
        }

    }

    public void run() {
        this.method2397();
        this.aThread2755 = null;
    }

    public void mouseMoved(MouseEvent var1) {
        if (this.aSPanel__2750 == null) {
            Object var2 = this.anObject2748;
            synchronized (this.anObject2748) {
                if (this.anInt2723 != 2) {
                    return;
                }

                this.anInt2758 = var1.getX();
                this.anInt2759 = var1.getY();
                this.aGamesomethingArray2732[this.anInt2743].method1053(this.anInt2758, this.anInt2759);
            }

            this.repaint();
        }
    }

    public void mouseDragged(MouseEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
        this.mouseMoved(var1);
    }

    public void mouseExited(MouseEvent var1) {
        if (this.aSPanel__2750 == null) {
            Object var2 = this.anObject2748;
            synchronized (this.anObject2748) {
                if (this.anInt2723 != 2) {
                    return;
                }

                this.anInt2758 = this.anInt2759 = -1;
                this.aGamesomethingArray2732[this.anInt2743].method1054();
            }

            this.repaint();
        }
    }

    public void mousePressed(MouseEvent var1) {
        if (this.anInt2723 == 2) {
            if (var1.isMetaDown()) {
                this.method2394();
            } else if (this.aSPanel__2750 == null) {
                boolean var2 = false;
                int[] var3 = null;
                Object var4 = this.anObject2748;
                synchronized (this.anObject2748) {
                    if (this.anInt2723 != 2) {
                        return;
                    }

                    this.anInt2758 = var1.getX();
                    this.anInt2759 = var1.getY();
                    if (!this.aGamesomethingArray2732[this.anInt2743].method1055(this.anInt2758, this.anInt2759)) {
                        this.repaint();
                        return;
                    }

                    if (this.method2399(this.anInt2743, this.aGamesomethingArray2732[this.anInt2743].method1056())[2] < 20.0D) {
                        var2 = true;
                    } else {
                        var3 = this.aGamesomethingArray2732[this.anInt2743].method1067();
                        this.method2380(1);
                    }
                }

                if (var2) {
                    this.method2394();
                } else {
                    this.method2400();
                    this.aSPanel__2722.method2424("action\t" + var3[0] + "\t" + var3[1] + "\t" + var3[2] + "\t" + var3[3] + "\t" + var3[4]);
                    this.aGamesomethingArray2732[this.anInt2743].method1089((String) null);
                    if (this.anInt2760 == 1) {
                        this.anInt2760 = 2;
                        this.repaint();
                    }

                    if (this.anInt2727 == 0) {
                        this.method2396();
                    }

                }
            }
        }
    }

    public void mouseReleased(MouseEvent var1) {
        if (this.anInt2723 == 2) {
            var1.consume();
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void actionPerformed(ActionEvent var1) {
        if (this.anInt2723 == 2) {
            Object var2 = var1.getSource();
            if (var2 == this.aGlossyButton2756) {
                this.method2394();
            } else if (var2 == this.aGlossyButton2757) {
                Object var3 = this.anObject2748;
                synchronized (this.anObject2748) {
                    if (this.aSPanel__2750 != null) {
                        this.method2361(-1);
                    }
                }

                this.method2401(true);
            }

        }
    }

    public void qtFinished() {
        this.aBigText2747 = null;
        this.repaint();
    }

    public boolean handlePacket(String[] var1) {
        if (this.aSPanel__2750 != null && this.aSPanel__2750.method2403(var1)) {
            return true;
        } else {
            int var2;
            if (var1[1].equals("gameinfo")) {
                this.anInt2725 = this.anInt2726 = Integer.parseInt(var1[2]);
                this.aGamesomethingArray2732 = new Gamesomething[this.anInt2725];

                for (var2 = 0; var2 < this.anInt2725; ++var2) {
                    this.aGamesomethingArray2732[var2] = new Gamesomething(this.aClientSettings_2721, this);
                }

                this.anIntArray2735 = new int[this.anInt2725];
                this.anInt2727 = Integer.parseInt(var1[8]);
                this.aClass7_2730.method1011(var1[9]);
                this.aBoolean2729 = var1[11].equals("t");
                this.anInt2728 = Integer.parseInt(var1[12]);
                return true;
            } else if (var1[1].equals("owninfo")) {
                this.anInt2742 = Integer.parseInt(var1[2]);
                this.aGamesomethingArray2732[this.anInt2742].method1073();
                return true;
            } else {
                int var3;
                String[] var6;
                if (var1[1].equals("startgame")) {
                    this.anInt2725 = this.anInt2726 = Integer.parseInt(var1[3]);
                    this.aGamesomethingArray2732 = new Gamesomething[this.anInt2725];

                    for (var2 = 0; var2 < this.anInt2725; ++var2) {
                        this.aGamesomethingArray2732[var2] = new Gamesomething(this.aClientSettings_2721, this);
                    }

                    this.anIntArray2735 = new int[this.anInt2725];
                    this.anInt2742 = Integer.parseInt(var1[2]);
                    this.aGamesomethingArray2732[this.anInt2742].method1073();
                    this.aBigText2747 = null;
                    var6 = new String[this.anInt2725];

                    for (var3 = 0; var3 < this.anInt2725; ++var3) {
                        var6[var3] = var1[4 + var3 * 3];
                        this.aGamesomethingArray2732[var3].method1074(var6[var3]);
                        this.aGamesomethingArray2732[var3].method1075(this.aSPanel__2722.method2432(var1[5 + var3 * 3]));
                        this.aGamesomethingArray2732[var3].method1076(var1[6 + var3 * 3]);
                        this.aGamesomethingArray2732[var3].method1090((String) null);
                    }

                    this.aClientSettings_2721.gameApplet.method2289(var6);
                    return true;
                } else if (var1[1].equals("startround")) {
                    this.method2382(new Class3(Long.parseLong(var1[2])), var1[3].equals("t"));
                    this.aSPanel__2722.method2425();
                    this.method2380(1);
                    this.anInt2746 = 1;
                    this.method2360(this.anInt2742, this.aClientSettings_2721.textManager.method2039("GameReal_AutoShout_YouAreHere"));
                    return true;
                } else if (var1[1].equals("startturn")) {
                    this.aClass3_2754 = new Class3(Long.parseLong(var1[2]));
                    this.anInt2744 = Integer.parseInt(var1[3]);
                    this.anInt2745 = Integer.parseInt(var1[4]);
                    var2 = Integer.parseInt(var1[5]);
                    this.anInt2743 = Integer.parseInt(var1[6]);

                    int var9;
                    for (var9 = 0; var9 < this.anInt2725; ++var9) {
                        this.aGamesomethingArray2732[var9].method1078();
                        this.aGamesomethingArray2732[var9].method1080(-1);
                        String var8 = null;
                        if (var2 == 0) {
                            if (var9 == this.anInt2743) {
                                if (var9 == this.anInt2742) {
                                    var8 = this.aClientSettings_2721.textManager.method2039("GameRealPlayer_InfoPlay");
                                } else {
                                    var8 = this.aClientSettings_2721.textManager.method2039("GameRealPlayer_InfoPlaying");
                                }
                            }
                        } else if (var9 == this.anInt2742) {
                            var8 = this.aClientSettings_2721.textManager.method2039("GameRealPlayer_InfoPlay");
                        } else {
                            var8 = this.aClientSettings_2721.textManager.method2039("GameRealPlayer_InfoThinking");
                        }

                        this.aGamesomethingArray2732[var9].method1089(var8);
                        this.anIntArray2735[var9] = 0;
                    }

                    this.aClass7_2753.method1011("0");
                    this.anInt2760 = 0;
                    if (this.anInt2743 == this.anInt2742) {
                        if (var2 == 1) {
                            this.anInt2760 = 1;
                        }

                        for (var9 = 0; var9 < 18; ++var9) {
                            this.aClass7Array2749[var9].method1012(Integer.parseInt(var1[7 + var9]));
                        }

                        var9 = this.anInt2746;
                        if (var9 != 0 && var9 != 1 && var9 != 2 && var9 != 3) {
                            var9 = 0;
                        }

                        if (this.aClass7Array2749[var9].method1016() == 0) {
                            var9 = 0;
                        }

                        this.aGamesomethingArray2732[this.anInt2743].method1080(var9);
                        this.aGamesomethingArray2732[this.anInt2743].method1054();
                        this.method2380(2);
                        if (anInt2720 == 0) {
                            anInt2720 = 1;
                        } else if (anInt2720 == 1) {
                            anInt2720 = 2;
                            this.aGlossyButton2756.setFlashing(true);
                            this.method2360(this.anInt2742, this.aClientSettings_2721.textManager.method2039("GameReal_AutoShout_WeaponMenuHelp"));
                        }
                    } else {
                        this.method2380(1);
                    }

                    return true;
                } else if (var1[1].equals("ready")) {
                    this.aGamesomethingArray2732[Integer.parseInt(var1[2])].method1089((String) null);
                    return true;
                } else if (var1[1].equals("action")) {
                    var2 = Integer.parseInt(var1[2]);
                    var3 = Integer.parseInt(var1[3]);
                    if (var3 == 16) {
                        this.aGamesomethingArray2732[var2].method1080(var3);
                    } else if (var3 >= 0) {
                        this.aGamesomethingArray2732[var2].method1086(var3, Integer.parseInt(var1[4]), Integer.parseInt(var1[5]), Integer.parseInt(var1[6]), Integer.parseInt(var1[7]));
                    }

                    if (this.anInt2727 == 0) {
                        this.aGamesomethingArray2732[this.anInt2743].method1089((String) null);
                        this.method2396();
                    }

                    return true;
                } else if (var1[1].equals("startaction")) {
                    this.method2400();
                    this.repaint();
                    Tools.sleep((long) ((this.anInt2726 + 1) * 150));
                    this.method2396();
                    return true;
                } else if (var1[1].equals("endround")) {
                    this.repaint();
                    if (this.anInt2726 >= 2) {
                        Tools.sleep(2500L);
                    }

                    return true;
                } else if (!var1[1].equals("endgame")) {
                    if (var1[1].equals("wantnewgame")) {
                        this.aGamesomethingArray2732[Integer.parseInt(var1[2])].method1090(this.aClientSettings_2721.textManager.method2039("GameRealPlayer_InfoWantNewGame"));
                        return true;
                    } else if (var1[1].equals("part")) {
                        if (Integer.parseInt(var1[3]) != 3) {
                            this.aGamesomethingArray2732[Integer.parseInt(var1[2])].method1091();
                            --this.anInt2726;
                            this.repaint();
                        }

                        return true;
                    } else if (var1[1].equals("shout")) {
                        String var7 = var1[3];
                        if (this.aClientSettings_2721.badWordFilter != null) {
                            var7 = this.aClientSettings_2721.badWordFilter.filter(var7);
                        }

                        this.aGamesomethingArray2732[Integer.parseInt(var1[2])].method1088(var7, false);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    this.method2380(4);

                    for (var2 = 0; var2 < this.anInt2725; ++var2) {
                        this.aGamesomethingArray2732[var2].method1089((String) null);
                    }

                    var6 = this.aSPanel__2722.method2431();
                    var3 = var6.length;
                    String var4 = "";

                    for (int var5 = 0; var5 < var3; ++var5) {
                        var4 = var4 + var6[var5];
                        if (var5 < var3 - 1) {
                            var4 = var4 + ", ";
                        }
                    }

                    String var10;
                    if (var3 == 1) {
                        var10 = this.aClientSettings_2721.textManager.method2040("GameReal_Winner", var4);
                    } else if (var3 < this.anInt2725) {
                        var10 = this.aClientSettings_2721.textManager.method2040("GameReal_Winners", var4);
                    } else {
                        var10 = this.aClientSettings_2721.textManager.method2039("GameReal_Draw");
                    }

                    this.aBigText2747 = new BigText(this.aClientSettings_2721.imageManager, var10, aColor2716, 176);
                    this.repaint();
                    new QuickTimer(10000, this);
                    this.aClientSettings_2721.gameApplet.method2293();
                    return true;
                }
            }
        }
    }

    public void method2360(int var1, String var2) {
        if (var1 >= 0) {
            this.aGamesomethingArray2732[var1].method1088(var2, true);
        }

    }

    protected void method2361(int var1) {
        this.callUpdateUI((Object) null);
        if (var1 == 16) {
            this.method2400();
            this.method2380(1);
            this.aGamesomethingArray2732[this.anInt2743].method1080(var1);
            this.anInt2746 = -1;
            this.aSPanel__2722.method2424("action\t" + var1);
            this.aGamesomethingArray2732[this.anInt2743].method1089((String) null);
            if (this.anInt2760 == 1) {
                this.anInt2760 = 2;
            }

            if (this.anInt2727 == 0) {
                this.method2396();
            }

            this.repaint();
        } else {
            this.setCursor(aCursor2718);
            if (var1 >= 0) {
                this.aGamesomethingArray2732[this.anInt2743].method1080(var1);
                this.anInt2746 = var1;
            }

            this.repaint();
        }
    }

    public double[] method2362() {
        if (this.anInt2725 == 0) {
            return null;
        } else {
            try {
                double[] var1 = new double[this.anInt2725];

                for (int var2 = 0; var2 < this.anInt2725; ++var2) {
                    var1[var2] = this.aGamesomethingArray2732[var2].method1058();
                }

                return var1;
            } catch (NullPointerException var3) {
                return null;
            }
        }
    }

    public void method2363(String var1) {
        this.aGamesomethingArray2732[this.anInt2742].method1088(var1, false);
    }

    public void method2364() {
        this.aGamesomethingArray2732[this.anInt2742].method1090(this.aClientSettings_2721.textManager.method2039("GameRealPlayer_InfoWantNewGame"));
    }

    protected void method2365(LinkedList var1, int var2, double var3, double var5, double var7, double var9, int var11, int var12) {
        GameLogic var13 = new GameLogic(this.aClientSettings_2721, this, var2, var3, var5, var7, var9, 0, 0, var11, true, var12);
        var1.add(var13);
    }

    protected void method2366(LinkedList var1, int var2, double var3, int var5, int var6, int var7, int var8, int var9, int var10, boolean var11) {
        if (var2 <= 0) {
            var2 = 1;
        }

        Class13 var12 = new Class13(this.aClientSettings_2721, this, var2, var3, var5, var6, var7, var8, var9, var10, var11);
        var1.add(var12);
    }

    protected void method2367(int var1, int var2, int var3, int var4, int var5) {
        int var6 = this.aClass3_2754.method991(6, 9);
        int var7 = 0;

        while (var7 < var6) {
            while (true) {
                int var8 = this.aClass3_2754.method991(var1 - var3, var1 + var3);
                if (var8 >= 0 && var8 < 760) {
                    int var9;
                    do {
                        do {
                            var9 = this.aClass3_2754.method991(var2 - var3, var2 + var3);
                        } while (var9 < 0);
                    } while (var9 >= this.anIntArray2740[var8] - 10);

                    double var10 = (double) (var1 - var8);
                    double var12 = (double) (var2 - var9);
                    if (Math.sqrt(var10 * var10 + var12 * var12) <= (double) var3) {
                        int var14 = this.aClass3_2754.method991(var4 == 1 ? 1500 : 3000, var4 == 1 ? 3500 : 5000);
                        Class12 var15 = new Class12(this.aClientSettings_2721, this, (double) var8, (double) var9, var4, var14, var5);
                        this.aLinkedList2733.add(var15);
                        ++var7;
                        break;
                    }
                }
            }
        }

    }

    protected int method2368(int var1, int var2) {
        for (int var3 = 0; var3 < this.anInt2725; ++var3) {
            if (this.aGamesomethingArray2732[var3].method1065(var1, var2)) {
                return var3;
            }
        }

        return -1;
    }

    protected void method2369(LinkedList var1, LinkedList var2, double var3, double var5, double var7, int var9, int var10) {
        int var11;
        for (var11 = 0; var11 < this.anInt2725; ++var11) {
            if (this.aGamesomethingArray2732[var11].method1066(var3, var5, var7) && this.aGamesomethingArray2732[var11].method1082((double) (var9 * this.anInt2745) / 1000.0D, var10) && (this.anInt2728 == 1 || this.anInt2728 == 2)) {
                if (var11 != var10) {
                    ++this.anIntArray2735[var10];
                    this.aSPanel__2722.method2428(var10, 1);
                } else {
                    --this.anIntArray2735[var10];
                    this.aSPanel__2722.method2428(var10, -1);
                }
            }
        }

        if (var2 != null) {
            for (var11 = 0; var11 < this.anInt2724; ++var11) {
                if (this.aClass15Array2731[var11] != null && !this.aClass15Array2731[var11].method1046(this.aClass3_2754, var1, var2, var3, var5, var7, var10)) {
                    this.aClass15Array2731[var11] = null;
                }
            }
        }

    }

    protected boolean method2370(int var1, int var2) {
        return var1 >= 0 && var1 < 760 && var2 >= 0 && var2 < 400 ? this.aByteArrayArray2736[var1][var2] == 1 : false;
    }

    protected void method2371(int var1, int var2, int var3, byte var4) {
        for (int var5 = var1 - var3; var5 <= var1 + var3; ++var5) {
            if (var5 >= 0 && var5 < 760) {
                for (int var6 = var2 - var3; var6 <= var2 + var3; ++var6) {
                    if (var6 >= 0 && var6 < this.anIntArray2740[var5] && (this.aByteArrayArray2736[var5][var6] != -1 || var4 != 0)) {
                        int var7 = var1 - var5;
                        int var8 = var2 - var6;
                        if (Math.sqrt((double) (var7 * var7 + var8 * var8)) <= (double) var3) {
                            this.aByteArrayArray2736[var5][var6] = var4;
                        }
                    }
                }
            }
        }

    }

    protected void method2372(Graphics2D var1) {
        var1.drawImage(this.anImage2741, 0, 360, this);
    }

    protected BufferedImage method2373() {
        return this.aBufferedImage2737;
    }

    protected int[] method2374() {
        return this.aGamesomethingArray2732[this.anInt2742].method1060();
    }

    protected int method2375(int var1) {
        return this.aClass7Array2749[var1].method1016();
    }

    protected void method2376(int var1, int var2) {
        this.aClass7Array2749[var1].method1012(var2);
    }

    private boolean method2377(int var1) {
        int[] var2 = this.aGamesomethingArray2732[var1].method1060();
        return this.method2378(var2[0], var2[1]);
    }

    protected boolean method2378(int var1, int var2) {
        return this.aByteArrayArray2736[var1 - 6 + 1][var2 + 3 + 1] != -1 || this.aByteArrayArray2736[var1 + 6 - 1][var2 + 3 + 1] != -1;
    }

    public void method2379() {
        this.method2400();
        this.aThread2755 = null;
        this.removeMouseListener(this);
        this.removeMouseMotionListener(this);
        this.setCursor(aCursor2717);
    }

    private void method2380(int var1) {
        if (var1 == this.anInt2723) {
            this.repaint();
        } else {
            this.aGlossyButton2756.setVisible(false);
            this.aGlossyButton2757.setVisible(false);
            this.removeMouseListener(this);
            this.removeMouseMotionListener(this);
            this.setCursor(aCursor2717);
            this.anInt2723 = var1;
            if (var1 == 2) {
                int var2 = this.method2381();
                if (var2 > 0) {
                    this.aClass7_2753.method1012(var2);
                    Object var3 = this.anObject2751;
                    synchronized (this.anObject2751) {
                        this.aGameSomethingrunnable_2752 = new GameSomethingrunnable(this);
                        Thread var4 = new Thread(this.aGameSomethingrunnable_2752);
                        var4.setDaemon(true);
                        var4.start();
                    }
                }

                this.addMouseMotionListener(this);
                this.addMouseListener(this);
                this.setCursor(aCursor2718);
                this.aGlossyButton2756.setVisible(true);
                this.aGlossyButton2757.setVisible(true);
            }

            this.repaint();
        }
    }

    private int method2381() {
        int var1 = this.aClass7_2730.method1016();
        return var1 > 0 ? var1 : 180;
    }

    private void method2382(Class3 var1, boolean var2) {
        this.aLinkedList2733.clear();
        this.aClass14_2734 = null;
        this.method2384(var1);

        for (int var3 = 0; var3 < this.anInt2725; ++var3) {
            this.aGamesomethingArray2732[var3].method1077();
        }

        boolean[] var44 = new boolean[760];

        for (int var4 = 0; var4 < 760; ++var4) {
            var44[var4] = false;
        }

        int[] var45 = new int[this.anInt2725];
        int var5 = 760 / this.anInt2725;

        for (int var6 = 0; var6 < this.anInt2725; ++var6) {
            var45[var6] = var6 % 2 == 0 ? var5 / 2 + var5 * (var6 / 2) : 760 - var5 / 2 - var5 * ((var6 - 1) / 2);

            for (int var7 = var45[var6] - 12; var7 < var45[var6] + 12; ++var7) {
                var44[var7] = true;
            }
        }

        boolean[] var46 = new boolean[this.anInt2725];
        boolean[] var47 = new boolean[this.anInt2725];
        int var8 = 0;

        int var9;
        for (var9 = 0; var9 < this.anInt2725; ++var9) {
            var46[var9] = this.aGamesomethingArray2732[var9].method1068();
            if (!var46[var9]) {
                ++var8;
            }

            var47[var9] = false;
        }

        int var10;
        for (var10 = 0; var10 < this.anInt2725; ++var10) {
            if (var8 > 0) {
                do {
                    do {
                        var9 = var1.method991(0, this.anInt2725 - 1);
                    } while (var46[var9]);
                } while (var47[var9]);

                --var8;
            } else {
                do {
                    do {
                        var9 = var1.method991(0, this.anInt2725 - 1);
                    } while (!var46[var9]);
                } while (var47[var9]);
            }

            this.aGamesomethingArray2732[var9].method1083(var45[var10]);
            var47[var9] = true;
        }

        for (var10 = 0; var10 < 760; ++var10) {
            for (int var11 = 0; var11 < 400; ++var11) {
                this.aByteArrayArray2736[var10][var11] = -1;
            }
        }

        int[] var48 = new int[760];
        double var12 = (double) var1.method991(100, 300);
        double var14 = 1.5D - var1.method992() * 3.0D;

        for (int var16 = 0; var16 < 760; ++var16) {
            var48[var16] = (int) (var12 + 0.5D);

            for (int var17 = var48[var16]; var17 < 400; ++var17) {
                this.aByteArrayArray2736[var16][var17] = 1;
            }

            if (var16 >= 1 && var16 <= 758 && !var44[var16 - 1] && !var44[var16] && !var44[var16 + 1]) {
                var12 += var14;
                var14 += 0.15D - var1.method992() * 0.3D;
            }

            if (var14 < -1.5D) {
                var14 = -1.5D;
            } else if (var14 > 1.5D) {
                var14 = 1.5D;
            }

            if (var12 < 100.0D) {
                var14 += 0.1D;
                if (var12 < 90.0D) {
                    var14 += 0.2D;
                }
            }

            if (var12 > 300.0D) {
                var14 -= 0.1D;
                if (var12 > 310.0D) {
                    var14 -= 0.2D;
                }
            }
        }

        this.aBufferedImage2738 = new BufferedImage(760, 400, 1);
        this.aGraphics2D2739 = this.aBufferedImage2738.createGraphics();
        Tools.setBestRendering(this.aGraphics2D2739);
        this.method2383();
        this.aGraphics2D2739.drawImage(this.aBufferedImage2737, 0, 0, this);
        this.anInt2724 = 8 - this.anInt2725;
        if (this.anInt2724 <= 0) {
            this.anInt2724 = 1;
        }

        byte var49 = 0;
        if (var1.method991(0, 20) == 1) {
            this.anInt2724 *= 5;
            var49 = 1;
        } else if (var1.method991(0, 20) == 1) {
            this.anInt2724 *= 3;
        } else if (var2 && var1.method991(0, 100) == 1) {
            this.anInt2724 *= 8;
            var49 = -1;
        }

        this.aClass15Array2731 = new Class15[this.anInt2724];

        int var18;
        int var23;
        int var29;
        for (var18 = 0; var18 < this.anInt2724; ++var18) {
            Class15 var50 = Class15.method1040(this.aClientSettings_2721, this, var1, var49);
            int var19 = var50.method1042();
            int var20 = 0;

            int var21;
            boolean var22;
            do {
                var21 = var1.method990() % (760 - var19);
                var22 = false;

                for (var23 = var21; var23 < var21 + var19 && !var22; ++var23) {
                    if (var44[var23]) {
                        var22 = true;
                    }
                }

                ++var20;
            } while (var22 && var20 < 1000);

            int var24 = var21 + var19 / 2 - 3;
            int var25 = var21 + var19 / 2 + 3;
            int var26 = var50.method1043();
            int var27 = (var48[var24] > var48[var25] ? var48[var24] : var48[var25]) - var26;
            var50.method1041(var21 + var19 / 2, var27 + var26 / 2);
            var50.method1047(this.aGraphics2D2739);
            boolean[][] var28 = var50.method1044();

            for (var23 = 0; var23 < var26; ++var23) {
                for (var29 = 0; var29 < var19; ++var29) {
                    if (var28[var29][var23]) {
                        this.aByteArrayArray2736[var21 + var29][var27 + var23] = 1;
                    }
                }
            }

            if (var50.method1045()) {
                this.aClass15Array2731[var18] = var50;
            }
        }

        var18 = aColorArray2704[this.aClientSettings_2721.useWinterGraphics].getRed();
        var23 = aColorArray2704[this.aClientSettings_2721.useWinterGraphics].getGreen();
        var29 = aColorArray2704[this.aClientSettings_2721.useWinterGraphics].getBlue();
        int var30 = aColorArray2705[this.aClientSettings_2721.useWinterGraphics].getRed();
        int var31 = aColorArray2705[this.aClientSettings_2721.useWinterGraphics].getGreen();
        int var32 = aColorArray2705[this.aClientSettings_2721.useWinterGraphics].getBlue();

        int var33;
        int var36;
        for (var33 = 0; var33 < 760; ++var33) {
            int var34 = 10 + (int) (Math.random() * 2.0D);
            int var35 = 15 + (int) (Math.random() * 2.0D);
            this.aGraphics2D2739.setColor(aColorArray2701[this.aClientSettings_2721.useWinterGraphics]);
            this.aGraphics2D2739.drawLine(var33, var48[var33], var33, 399);
            this.aGraphics2D2739.setColor(aColorArray2702[this.aClientSettings_2721.useWinterGraphics]);
            this.aGraphics2D2739.drawLine(var33, var48[var33] + 1, var33, 399);
            this.aGraphics2D2739.setColor(aColorArray2703[this.aClientSettings_2721.useWinterGraphics]);
            this.aGraphics2D2739.drawLine(var33, var48[var33] + var34 + 1, var33, 399);
            var48[var33] += var34 + var35 + 1;

            for (var36 = 0; var36 < 64; ++var36) {
                int var37 = var18 + (var30 - var18) * var36 / 64;
                int var38 = var23 + (var31 - var23) * var36 / 64;
                int var39 = var29 + (var32 - var29) * var36 / 64;
                this.aGraphics2D2739.setColor(new Color(var37, var38, var39));
                this.aGraphics2D2739.drawLine(var33, var48[var33] + (380 - var48[var33]) * var36 / 64, var33, 399);
            }
        }

        this.method2372(this.aGraphics2D2739);

        for (var33 = 0; var33 < this.anInt2725; ++var33) {
            this.aGamesomethingArray2732[var33].method1084(0);

            while (!this.method2377(var33)) {
                this.aGamesomethingArray2732[var33].method1085(1);
            }
        }

        var33 = 760;
        var36 = 0;
        int var40 = 0;
        int var41 = 0;

        for (int var42 = 0; var42 < this.anInt2725; ++var42) {
            int[] var43 = this.aGamesomethingArray2732[var42].method1060();
            if (var43[0] < var33) {
                var33 = var43[0];
                var36 = var43[1];
            }

            if (var43[0] > var40) {
                var40 = var43[0];
                var41 = var43[1];
            }
        }

        int[] var51 = this.method2374();
        this.aClientSettings_2721.aSoundManager_770.method974(var51[0], var51[1], Tools.getDistance((double) var33, (double) var36, (double) var40, (double) var41));
        this.aClass14_2734 = new Class14(this.aClientSettings_2721, this);
        this.repaint();
    }

    private void method2383() {
        this.aBufferedImage2737 = new BufferedImage(760, 400, 1);
        Graphics2D var1 = this.aBufferedImage2737.createGraphics();
        int var2 = (int) (Math.random() * 760.0D);
        var1.drawImage(this.aClientSettings_2721.imageManager.method1983("sky"), var2, 0, this);
        if (var2 != 0) {
            var1.drawImage(this.aClientSettings_2721.imageManager.method1983("sky"), var2 - 760, 0, this);
        }

    }

    private void method2384(Class3 var1) {
        this.anIntArray2740 = new int[760];
        double var2 = (double) var1.method991(2, 9);
        double var4 = 0.3D - var1.method992() * 0.6D;

        for (int var6 = 0; var6 < 760; ++var6) {
            this.anIntArray2740[var6] = (int) (var2 + 0.5D);
            var2 += var4;
            var4 += 0.05D - var1.method992() * 0.1D;
            if (var2 < 0.0D) {
                var2 = 0.0D;
            }

            if (var4 < -0.3D) {
                var4 = -0.3D;
            } else if (var4 > 0.3D) {
                var4 = 0.3D;
            }

            if (var2 < 3.0D) {
                var4 += 0.03D;
                if (var2 < 2.0D) {
                    var4 += 0.05D;
                }
            }

            if (var2 > 17.0D) {
                var4 -= 0.03D;
                if (var2 > 18.0D) {
                    var4 -= 0.05D;
                }
            }
        }

        int[] var10 = new int[30400];

        for (int var7 = 0; var7 < 760; ++var7) {
            int var8;
            for (var8 = 0; var8 < this.anIntArray2740[var7]; ++var8) {
                var10[var8 * 760 + var7] = 16777215;
            }

            var8 = 1 + (int) (Math.random() * 2.0D);

            int var9;
            for (var9 = this.anIntArray2740[var7]; var9 < this.anIntArray2740[var7] + var8; ++var9) {
                var10[var9 * 760 + var7] = aColorArray2706[this.aClientSettings_2721.useWinterGraphics].getRGB();
            }

            for (var9 = this.anIntArray2740[var7] + var8; var9 < 40; ++var9) {
                var10[var9 * 760 + var7] = aColorArray2707[this.aClientSettings_2721.useWinterGraphics].getRGB();
            }

            this.anIntArray2740[var7] += 360;
        }

        this.anImage2741 = this.aClientSettings_2721.imageManager.createImage(var10, 760, 40);
    }

    private void method2385(Graphics2D var1, boolean var2) {
        for (int var3 = 0; var3 < this.anInt2725; ++var3) {
            this.method2386(var1, var2, var3);
        }

    }

    private void method2386(Graphics2D var1, boolean var2, int var3) {
        boolean var4 = true;
        if (var3 == this.anInt2742 && var3 == this.anInt2743 && this.method2399(var3, this.aGamesomethingArray2732[var3].method1056())[2] < 20.0D) {
            var4 = false;
        }

        this.aGamesomethingArray2732[var3].method1092(var1, var4, var2);
    }

    private void method2387(Graphics2D var1) {
        Iterator var2 = this.aLinkedList2733.iterator();

        while (var2.hasNext()) {
            ((Class12) ((Class12) var2.next())).method1035(var1);
        }

    }

    private void method2388(Graphics2D var1) {
        if (this.aClass14_2734 != null) {
            this.aClass14_2734.method1039(var1);
        }

    }

    private void method2389(Graphics2D var1, int var2, int var3) {
        var1.setColor(aColor2710);
        var1.drawLine(var2 - 5, var3, var2 + 5, var3);
        var1.drawLine(var2, var3 - 5, var2, var3 + 5);
    }

    private void method2390(Graphics2D var1, int var2, int var3, int var4) {
        if (var2 >= 0 && var2 < 760 && var3 >= 0 && var3 < 400) {
            var1.setColor(var4 == 17 ? aColor2713 : aColor2712);
            var1.drawLine(var2 - 19, var3, var2 + 19, var3);
            var1.drawLine(var2, var3 - 19, var2, var3 + 19);
            var1.drawOval(var2 - 15, var3 - 15, 30, 30);
        }
    }

    private void method2391(Graphics2D var1, int var2) {
        if (this.aClientSettings_2721.aPlayerInfo_764.aBoolean786) {
            int[] var3 = this.aGamesomethingArray2732[this.anInt2743].method1060();
            int[] var4 = this.aGamesomethingArray2732[this.anInt2743].method1061();
            int var5 = var3[0];
            int var6 = var3[1];
            int var7 = var4[0];
            int var8 = var4[1];
            if (var7 >= 0 && var7 < 760 && var8 >= 0 && var8 < 400) {
                if (var2 == 6) {
                    if (var7 < var5) {
                        this.method2392(var1, var5, var6, var5 - 30, var6);
                    } else if (var7 > var5) {
                        this.method2392(var1, var5, var6, var5 + 30, var6);
                    }

                } else if (var2 != 13) {
                    if (var8 > var6) {
                        var8 = var6;
                    }

                    double var10 = (double) (var7 - var5);
                    double var12 = (double) (var8 - var6);
                    double var14 = Math.sqrt(var10 * var10 + var12 * var12);
                    if (var14 > 100.0D) {
                        double var16 = 100.0D / var14;
                        var10 *= var16;
                        var12 *= var16;
                    }

                    this.method2392(var1, var5, var6, (int) ((double) var5 + var10 + 0.5D), (int) ((double) var6 + var12 + 0.5D));
                } else {
                    var7 = this.anInt2758;
                    if (var7 >= 0 && var7 < 760) {
                        int var9;
                        for (var9 = 16; this.aByteArrayArray2736[var7][var9] == -1; ++var9) {
                            ;
                        }

                        var9 -= 16;
                        this.method2392(var1, var7, 0, var7, var9);
                    }
                }
            }
        }
    }

    private void method2392(Graphics2D var1, int var2, int var3, int var4, int var5) {
        var1.setColor(aColor2711);
        double var6 = (double) (var4 - var2) / 5.0D;
        double var8 = (double) (var5 - var3) / 5.0D;
        double var10 = Math.sqrt(var6 * var6 + var8 * var8);
        double var12;
        if (var10 < 7.5D) {
            var12 = 7.5D / var10;
            var6 *= var12;
            var8 *= var12;
        } else if (var10 > 30.0D) {
            var12 = 30.0D / var10;
            var6 *= var12;
            var8 *= var12;
        }

        var12 = (double) var4 - var6;
        double var14 = (double) var5 - var8;
        double var16 = (double) var4 - var12;
        double var18 = (double) var5 - var14;
        double var20 = var18 * 0.75D;
        double var22 = -var16 * 0.75D;
        int var24 = (int) (var12 + var20 / 2.0D + 0.5D);
        int var25 = (int) (var14 + var22 / 2.0D + 0.5D);
        int var26 = (int) (var12 - var20 / 2.0D + 0.5D);
        int var27 = (int) (var14 - var22 / 2.0D + 0.5D);
        var1.drawLine(var2, var3, (int) (var12 + 0.5D), (int) (var14 + 0.5D));
        var1.drawLine(var24, var25, var26, var27);
        var1.drawLine(var24, var25, var4, var5);
        var1.drawLine(var26, var27, var4, var5);
    }

    private void method2393(Graphics2D var1) {
        int var2 = Math.abs(this.anInt2744);
        short var3 = 380;
        var1.setFont(GameApplet.fontDialog9);
        var1.setColor(aColor2709);
        StringDraw.drawString(var1, this.aClientSettings_2721.textManager.method2039("GameReal_Wind"), var3, 11, 0);
        if (var2 > 0) {
            int[] var4 = new int[]{var3, var3, var3 + this.anInt2744};
            int[] var5 = new int[]{20, 34, 27};
            var1.setColor(new Color(var2 * 255 / 100, 255 - var2 * 255 / 100, 0));
            var1.fillPolygon(var4, var5, 3);
            var1.setColor(aColorArray2708[this.aClientSettings_2721.useWinterGraphics]);
            var1.drawPolygon(var4, var5, 3);
        }

        var1.setColor(aColorArray2708[this.aClientSettings_2721.useWinterGraphics]);
        var1.drawLine(var3, 14, var3, 38);
    }

    private void method2394() {
        if (this.aSPanel__2750 == null) {
            this.method2395();
        } else {
            this.method2361(-1);
        }

    }

    private void method2395() {
        this.setCursor(aCursor2717);
        this.aSPanel__2750 = new GameWeaponPanel(this.aClientSettings_2721, this.aSPanel__2722, this);
        this.aSPanel__2750.setLocation(65, 80);
        this.add(this.aSPanel__2750);
        anInt2720 = 3;
        this.aGlossyButton2756.setFlashing(false);
        this.repaint();
    }

    private void method2396() {
        this.method2380(3);
        this.anInt2760 = 0;
        this.aThread2755 = new Thread(this);
        this.aThread2755.start();
    }

    private void method2397() {
        BufferedImage var1 = new BufferedImage(760, 400, 1);
        Graphics2D var2 = var1.createGraphics();
        Tools.setBestRendering(var2);
        Graphics var3 = null;
        boolean var4 = true;
        LinkedList var5 = new LinkedList();
        LinkedList var6 = new LinkedList();
        this.method2398(var5);

        for (int var7 = 0; var7 < this.anInt2725; ++var7) {
            this.aGamesomethingArray2732[var7].method1070();
        }

        DelayTimer var15 = new DelayTimer(200);
        int var8 = 0;

        int var9;
        int var10;
        boolean var14;
        int var18;
        do {
            var9 = var5.size();

            for (var10 = 0; var10 < var9; ++var10) {
                GameLogic var11 = (GameLogic) ((GameLogic) var5.get(var10));
                if (var11.method1030(this.aClass3_2754, var5, var6, this.anInt2744)) {
                    if (!var11.method1031(this.aClass3_2754, var5, var6, this.aBoolean2729)) {
                        var5.remove(var10);
                        --var10;
                        --var9;
                    }
                } else {
                    var5.remove(var10);
                    --var10;
                    --var9;
                }
            }

            var9 = var6.size();

            for (var10 = 0; var10 < var9; ++var10) {
                Class13 var16 = (Class13) ((Class13) var6.get(var10));
                if (!var16.method1036(this.aClass3_2754, var5, var6, this.aGraphics2D2739)) {
                    var6.remove(var10);
                    --var10;
                    --var9;
                }
            }

            for (var10 = 0; var10 < this.anInt2725; ++var10) {
                boolean var17 = this.aGamesomethingArray2732[var10].method1081();
                if (!var17) {
                    boolean var12 = this.aGamesomethingArray2732[var10].method1071();
                    if (var12 && this.method2377(var10)) {
                        if (this.aGamesomethingArray2732[var10].method1082((this.aGamesomethingArray2732[var10].method1072() - 1.0D) * 10.0D * (double) this.anInt2745 / 1000.0D, -1) && (this.anInt2728 == 1 || this.anInt2728 == 2)) {
                            int var13 = this.aGamesomethingArray2732[var10].method1069();
                            if (var10 != var13) {
                                ++this.anIntArray2735[var13];
                                this.aSPanel__2722.method2428(var13, 1);
                            } else {
                                --this.anIntArray2735[var13];
                                this.aSPanel__2722.method2428(var13, -1);
                            }
                        }

                        this.aGamesomethingArray2732[var10].method1070();
                    }
                }
            }

            Iterator var19 = this.aLinkedList2733.iterator();

            while (var19.hasNext()) {
                if (!((Class12) ((Class12) var19.next())).method1034(this.aClass3_2754, this.anIntArray2740, this.anInt2744)) {
                    var19.remove();
                }
            }

            if (this.aClass14_2734 != null && !this.aClass14_2734.method1038(this.aClass3_2754, this.anInt2744)) {
                this.aClass14_2734 = null;
            }

            if (var4) {
                var2.drawImage(this.aBufferedImage2738, 0, 0, this);
                this.method2385(var2, false);
                this.method2387(var2);
                var19 = var5.iterator();

                while (var19.hasNext()) {
                    ((GameLogic) ((GameLogic) var19.next())).method1029(var2);
                }

                var19 = var6.iterator();

                while (var19.hasNext()) {
                    ((Class13) ((Class13) var19.next())).method1037(var2);
                }

                this.method2388(var2);
                if (var3 == null) {
                    var3 = this.getGraphics();
                }

                if (var3 != null) {
                    var3.drawImage(var1, 0, 0, this);
                }
            }

            var4 = var15.doDelay();
            ++var8;
            if (var8 < 400) {
                var14 = false;
            } else {
                var14 = var5.isEmpty() && var6.isEmpty();

                for (var18 = 0; var18 < this.anInt2725 && var14; ++var18) {
                    if (this.aGamesomethingArray2732[var18].method1072() > 0.0D) {
                        var14 = false;
                    }
                }
            }

            if (this.aThread2755 == null) {
                return;
            }
        } while (!var14);

        for (var9 = 0; var9 < this.anInt2725; ++var9) {
            this.aGamesomethingArray2732[var9].method1087(false);
        }

        this.aSPanel__2722.method2425();
        var9 = 0;

        for (var10 = 0; var10 < this.anInt2725; ++var10) {
            if (this.aGamesomethingArray2732[var10].method1079(true)) {
                ++var9;
            }
        }

        this.method2380(4);
        Tools.sleep((long) (400 + (var9 + 1) * 250));
        if (this.aThread2755 != null) {
            for (var10 = 0; var10 < this.anInt2725; ++var10) {
                this.aGamesomethingArray2732[var10].method1079(false);
            }

            this.repaint();
            String var20 = "result";

            for (var18 = 0; var18 < this.anInt2725; ++var18) {
                var20 = var20 + "\t" + this.aGamesomethingArray2732[var18].method1059();
            }

            if (this.anInt2728 == 1 || this.anInt2728 == 2) {
                for (var18 = 0; var18 < this.anInt2725; ++var18) {
                    var20 = var20 + "\t" + this.anIntArray2735[var18];
                }
            }

            this.aSPanel__2722.method2424(var20);
        }
    }

    private void method2398(LinkedList var1) {
        for (int var2 = 0; var2 < this.anInt2725; ++var2) {
            int var3 = this.aGamesomethingArray2732[var2].method1056();
            if (var3 == 16) {
                this.aGamesomethingArray2732[var2].method1087(true);
            } else if (var3 != 17 && var3 >= 0) {
                double[] var4 = this.method2399(var2, var3);
                double var5 = 0.0D;
                double var7 = 0.0D;
                if (var3 != 6 && var3 != 13) {
                    var4[2] = 0.0325D;
                    var5 = var4[0] * var4[2];
                    var7 = var4[1] * var4[2];
                }

                if (var3 == 6) {
                    var5 = var4[0] < 0.0D ? -1.0D : 1.0D;
                }

                if (var3 == 13) {
                    var5 = 0.0D;
                    var7 = -0.01D;
                }

                int[] var9 = this.aGamesomethingArray2732[var2].method1060();
                int[] var10 = this.aGamesomethingArray2732[var2].method1062();
                double var11 = 16.0D / Math.sqrt(var5 * var5 + var7 * var7);
                double var13 = (double) var9[0] + var5 * var11;
                double var15 = (double) var9[1] + var7 * var11;
                GameLogic var17 = new GameLogic(this.aClientSettings_2721, this, var3, var13, var15, var5, var7, var10 != null ? var10[0] : -1, var10 != null ? var10[1] : -1, 0, false, var2);
                var1.add(var17);
                this.aClientSettings_2721.aSoundManager_770.method975(var13, var15);
            }
        }

    }

    private double[] method2399(int var1, int var2) {
        double var3 = 0.0D;
        double var5 = 0.0D;
        double var7 = 100.0D;
        if (var2 != 13) {
            int[] var9 = this.aGamesomethingArray2732[var1].method1061();
            int[] var10 = this.aGamesomethingArray2732[var1].method1060();
            var3 = (double) (var9[0] - var10[0]);
            if (var2 != 6) {
                var5 = (double) (var9[1] - var10[1]);
                if (var5 > 0.0D) {
                    var5 = 0.0D;
                }

                var7 = Math.sqrt(var3 * var3 + var5 * var5);
                if (var7 > 100.0D) {
                    var7 = 100.0D / var7;
                    var3 *= var7;
                    var5 *= var7;
                    var7 = 100.0D;
                }
            }
        }

        double[] var11 = new double[]{var3, var5, var7};
        return var11;
    }

    private void method2400() {
        Object var1 = this.anObject2751;
        synchronized (this.anObject2751) {
            if (this.aGameSomethingrunnable_2752 != null) {
                this.aGameSomethingrunnable_2752.method1033();
                this.aGameSomethingrunnable_2752 = null;
            }

        }
    }

    private void method2401(boolean var1) {
        if (var1) {
            this.method2400();
            this.method2380(1);
        }

        this.aGamesomethingArray2732[this.anInt2743].method1080(-1);
        this.aSPanel__2722.method2424("action\t-1");
        this.aGamesomethingArray2732[this.anInt2743].method1089((String) null);
        this.anInt2760 = 0;
        if (this.anInt2727 == 0) {
            this.method2396();
        }

    }

    protected boolean method2402() {
        int var1 = this.aClass7_2753.method1015();
        this.repaint();
        if (var1 > 0 && var1 <= 5 && this.aClientSettings_2721.aPlayerInfo_764.aBoolean784) {
            this.aClientSettings_2721.soundManager.playTimeLow();
        }

        if (var1 <= 0) {
            Object var2 = this.anObject2748;
            synchronized (this.anObject2748) {
                if (this.aSPanel__2750 != null) {
                    this.method2361(-1);
                }

                if (this.anInt2723 != 2) {
                    return true;
                }

                this.method2380(1);
            }

            this.method2401(false);
            return true;
        } else {
            return false;
        }
    }

    static {
        aStringArray2762[0] = "GameReal_WeaponLeft";
        aStringArray2762[1] = "GameReal_WeaponName_";
        aStringArray2762[2] = "GameReal_Power";
        aStringArray2762[3] = "GameReal_WaitingOtherPlayers";
        aStringArray2762[4] = "GameReal_Angle";
        aStringArray2762[5] = "GameReal_SelectTarget";
        aStringArray2762[6] = "GameReal_Wind";
        aStringArray2762[7] = "action\t-1";
        aStringArray2762[8] = "GameRealPlayer_InfoWantNewGame";
        aStringArray2762[9] = "action\t";
        aStringArray2762[10] = ", ";
        aStringArray2762[11] = "GameReal_Winner";
        aStringArray2762[12] = "GameRealPlayer_InfoPlay";
        aStringArray2762[13] = "action";
        aStringArray2762[14] = "wantnewgame";
        aStringArray2762[15] = "GameReal_Winners";
        aStringArray2762[16] = "gameinfo";
        aStringArray2762[17] = "shout";
        aStringArray2762[18] = "startturn";
        aStringArray2762[19] = "startgame";
        aStringArray2762[20] = "GameRealPlayer_InfoThinking";
        aStringArray2762[21] = "startround";
        aStringArray2762[22] = "GameReal_Draw";
        aStringArray2762[23] = "GameRealPlayer_InfoPlaying";
        aStringArray2762[24] = "ready";
        aStringArray2762[25] = "startaction";
        aStringArray2762[26] = "endround";
        aStringArray2762[27] = "owninfo";
        aStringArray2762[28] = "GameReal_AutoShout_YouAreHere";
        aStringArray2762[29] = "endgame";
        aStringArray2762[30] = "GameReal_AutoShout_WeaponMenuHelp";
        aStringArray2762[31] = "part";
        aStringArray2762[32] = "result";
        aStringArray2762[33] = "GameReal_WeaponButton";
        aStringArray2762[34] = "sky";
        aStringArray2762[35] = "GameReal_SkipButton";
        aColorArray2699 = new Color[]{new Color(92, 173, 254), new Color(1139379)};
        aColorArray2700 = new Color[]{new Color(48, 144, 0), new Color(15658734)};
        aColorArray2701 = new Color[]{new Color(8, 0, 2), new Color(16, 8, 8)};
        aColorArray2702 = new Color[]{new Color(53, 153, 1), new Color(16777215)};
        aColorArray2703 = new Color[]{new Color(103, 51, 1), new Color(13167103)};
        aColorArray2704 = new Color[]{new Color(168, 129, 61), new Color(6589866)};
        aColorArray2705 = new Color[]{new Color(102, 63, 53), new Color(4811646)};
        aColorArray2706 = new Color[]{new Color(130, 110, 105), new Color(130, 110, 120)};
        aColorArray2707 = new Color[]{new Color(160, 160, 160), new Color(160, 160, 176)};
        aColorArray2708 = new Color[]{new Color(46, 86, 127), new Color(0)};
        aColor2709 = new Color(0, 0, 64);
        aColor2710 = new Color(46, 86, 127);
        aColor2711 = new Color(224, 224, 255);
        aColor2712 = new Color(128, 0, 0);
        aColor2713 = aColor2711;
        aColor2714 = new Color(255, 255, 255);
        aColor2715 = new Color(160, 0, 0);
        aColor2716 = new Color(208, 208, 255);
        aCursor2717 = new Cursor(0);
        aCursor2718 = new Cursor(1);
        anIntArray2719 = new int[]{0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0, 0, 3, 0, 0, -1, 3};
        anInt2720 = 0;
    }
}
