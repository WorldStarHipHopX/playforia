package apool;

import com.playray.applet.AApplet;
import com.playray.client.AutoPopups;
import com.playray.client.ImageManager;
import com.playray.client.Parameters;
import com.playray.client.SPanel;
import com.playray.client.SoundManager;
import com.playray.client.TextManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

public class GameApplet extends AApplet {

    public SynchronizedBool aSynchronizedBool_4803;
    public static final String[] aStringArray4805 = {"EightBall", "NineBall", "StraightPool", "Rotation", "Snooker"};
    public static final Color aColor4807 = new Color(3829301);
    public static final Color aColor4808 = new Color(255, 255, 255);
    public static final Color aColor4809 = new Color(160, 255, 160);
    public static final Color aColor4810 = new Color(255, 144, 144);
    public static final Color aColor4811 = new Color(255, 255, 192);
    public static final Font aFont4813 = new Font("Dialog", Font.BOLD, 28);
    public static final Font aFont4814 = new Font("Dialog", Font.PLAIN, 20);
    public static final Font aFont4815 = new Font("Dialog", Font.BOLD, 12);
    public static final Font aFont4816 = new Font("Dialog", Font.PLAIN, 12);
    public static final Font aFont4817 = new Font("Dialog", Font.PLAIN, 11);
    private Class60 aClass60_4818;
    private int anInt4819;
    private SynchronizedInt aSynchronizedInt_4820;
    private SynchronizedInt aSynchronizedInt_4821;
    private SynchronizedBool aSynchronizedBool_4822;
    private SynchronizedBool aSynchronizedBool_4823;
    private SynchronizedBool aSynchronizedBool_4824;
    private AutoPopups autoPopups;
    private boolean aBoolean4826;
    private LobbySelectHeaderPanel aSPanel__4827;
    private SPanel_Sub21 aSPanel_Sub21_4828;
    private Image[][] imagePoolBalls;
    private Image[][] imageSnookerBalls;
    public static boolean aBoolean4831;


    public void initApplet(Parameters params) {
        this.aSynchronizedBool_4803 = new SynchronizedBool(this.method2328());
        this.setBackground(aColor4807);
        this.setForeground(aColor4808);
        this.aClass60_4818 = new Class60(this, params);
    }

    public void textsLoadedNotify(TextManager textManager) {
        this.aClass60_4818.textManager = textManager;
    }

    public void defineSounds(SoundManager soundManager) {
        this.aClass60_4818.soundManager = soundManager;

        int i;
        for (i = 0; i < 4; ++i) {
            soundManager.defineSound("strike-" + i + ".au");
        }

        for (i = 0; i < 10; ++i) {
            soundManager.defineSound("collision-" + i + ".au");
        }

        for (i = 0; i < 3; ++i) {
            soundManager.defineSound("wall-" + i + ".au");
        }

        soundManager.defineSound("pocket.au");
        soundManager.defineSound("game-win.au");
        soundManager.defineSound("game-draw.au");
        soundManager.defineSound("game-lose.au");
    }

    public void defineImages(ImageManager imageManager, String hohoho) {
        this.aClass60_4818.imageManager = imageManager;
        imageManager.defineImage("bg-multi.jpg");
        imageManager.defineImage("game_pool-balls", "game/pool-balls.png");
        imageManager.defineImage("game_snooker-balls", "game/snooker-balls.png");
    }

    public void createImages() {
        Image[] ballSheet = this.aClass60_4818.imageManager.separateImages("game_pool-balls", 16);
        this.imagePoolBalls = new Image[2][16];

        int i;
        for (i = 0; i < 16; ++i) {
            Image[] var3 = this.method2330(ballSheet[i], 20);
            this.imagePoolBalls[0][i] = var3[0];
            this.imagePoolBalls[1][i] = var3[1];
        }

        ballSheet = this.aClass60_4818.imageManager.separateImages("game_snooker-balls", 8);
        this.imageSnookerBalls = new Image[2][22];

        int var6;
        for (i = 0; i < 22; ++i) {
            var6 = i == 0 ? 0 : (i <= 15 ? 1 : i - 14);
            Image[] var4 = this.method2330(ballSheet[var6], 12);
            this.imageSnookerBalls[0][i] = var4[0];
            this.imageSnookerBalls[1][i] = var4[1];
        }

        try {
            int[] var7 = new int[121];

            for (var6 = 0; var6 < var7.length; ++var6) {
                var7[var6] = 0;
            }

            this.aClass60_4818.anImage1213 = this.aClass60_4818.imageManager.createImage(var7, 11, 11);
        } catch (Exception var5) {
            ;
        }

    }

    public void defineSecImages(ImageManager imageManager, String var2) {
        imageManager.defineImage("bg-single.jpg");
        imageManager.defineImage("lobbyselect_header-0", "lobbyselect/header-0.png");
        imageManager.defineImage("lobbyselect_header-1", "lobbyselect/header-1.png");
        imageManager.defineImage("lobby_header", "lobby/header.png");
        imageManager.defineImage("lobby_coin-pile", "lobby/coin-pile.png");

        int i;
        for (i = 0; i < 5; ++i) {
            imageManager.defineImage("lobbyselect_sp-" + i, "lobbyselect/sp-" + i + ".png");
            imageManager.defineImage("lobbyselect_mp-" + i, "lobbyselect/mp-" + i + ".png");
        }

        imageManager.defineImage("game_bg-top", "game/bg-top.png");
        imageManager.defineImage("game_bg-score", "game/bg-score.png");
        imageManager.defineImage("game_pool-bg", "game/pool-bg.jpg");
        imageManager.defineImage("game_pool-table", "game/pool-table.png");
        imageManager.defineImage("game_pool-table-mask", "game/pool-table-mask.gif");
        imageManager.defineImage("game_pool-stick-0", "game/pool-stick-0.png");
        imageManager.defineImage("game_pool-stick-1", "game/pool-stick-1.png");
        imageManager.defineImage("game_pool-cgreen", "game/pool-cgreen.png");
        imageManager.defineImage("game_pool-cred", "game/pool-cred.png");
        imageManager.defineImage("game_pool-ballshadow", "game/pool-ballshadow.png");
        imageManager.defineImage("game_snooker-bg", "game/snooker-bg.jpg");
        imageManager.defineImage("game_snooker-table", "game/snooker-table.png");
        imageManager.defineImage("game_snooker-table-mask", "game/snooker-table-mask.gif");
        imageManager.defineImage("game_snooker-values", "game/snooker-values.png");
        imageManager.defineImage("game_snooker-stick-0", "game/snooker-stick-0.png");
        imageManager.defineImage("game_snooker-stick-1", "game/snooker-stick-1.png");
        imageManager.defineImage("game_snooker-ballshadow", "game/snooker-ballshadow.png");
        imageManager.defineImage("game_spinball", "game/spinball.png");
        imageManager.defineImage("game_timer_box-bg", "game/timer/box-bg.png");
        imageManager.defineImage("game_timer_box-turn", "game/timer/box-turn.png");
        imageManager.defineImage("game_timer_sep", "game/timer/sep.png");

        for (i = 0; i < 10; ++i) {
            imageManager.defineImage("game_timer_" + i, "game/timer/" + i + ".png");
        }

        imageManager.defineImage("coin-icon.png");
    }

    public void connectToServer() {
        if (!this.aClass60_4818.method1450()) {
            this.setEndState(2);
        }

    }

    public void appletReady() {
        this.setBackground("bg-multi", -20, 0);
        this.autoPopups = new AutoPopups(this);
        this.method2307(false, 0, false, true);
        this.method2308(0, false, false);
        this.aBoolean4826 = false;
        this.aClass60_4818.method1451();
    }

    public void updateUI(Object var1) {
        Integer[] var2 = (Integer[]) ((Integer[]) var1);
        int var3 = var2[0].intValue();
        int var4 = var2[1].intValue();
        this.clearContent();
        if (this.anInt4819 == 1) {
            if (this.aBoolean4826) {
                super.param.removeSession();
            } else {
                this.aBoolean4826 = true;
            }

            if (this.method2317()) {
                super.param.noGuestAutoLogin();
                this.aClass60_4818.connection.method1475("login\t~\t" + super.param.getSession());
                this.anInt4819 = 0;
            } else if (this.aClass60_4818.aString1204 != null) {
                this.anInt4819 = 0;
                this.aClass60_4818.connection.method1475("login\tReplay {cmp}");
            } else {
                this.aClass60_4818.connection.method1475("login");
                this.anInt4819 = 0;
            }
        } else if (this.anInt4819 == 2) {
            if (this.aSPanel__4827 == null) {
                this.aSPanel__4827 = new LobbySelectHeaderPanel(this.aClass60_4818);
                this.aSPanel__4827.setLocation(0, 0);
            }

            this.aClass60_4818.connection.method1472(this.aSPanel__4827);
            if (this.aClass60_4818.aString1203 != null) {
                this.aSPanel__4827.method2587(this.aClass60_4818.aString1203);
                this.aClass60_4818.aString1203 = null;
            }

            this.addToContent(this.aSPanel__4827);
            this.aSPanel__4827.method2588();
        } else if (this.anInt4819 == 3) {
            this.aSPanel_Sub21_4828 = new SPanel_Sub21(this.aClass60_4818);
            this.aClass60_4818.connection.method1473(this.aSPanel_Sub21_4828);
            this.aSPanel_Sub21_4828.setLocation(0, 0);
            this.addToContent(this.aSPanel_Sub21_4828);
            this.aSPanel_Sub21_4828.method2573();
        } else if (this.anInt4819 == 4) {
            GameReplay var5 = null;
            if (this.aClass60_4818.aString1204 != null) {
                var5 = new GameReplay(this.aClass60_4818.aString1204);
            }

            Object var6 = null;
            if (var3 == 1) {
                if (var4 != 5) {
                    var6 = new SPanel_Sub20_Sub2_Sub1(this.aClass60_4818, var4, var5);
                } else {
                    var6 = new SPanel_Sub20_Sub2_Sub2(this.aClass60_4818);
                }
            }

            if (var3 == 2) {
                int var7 = var4 / 10000000;
                int var8 = var4 / 10000 % 1000;
                int var9 = var4 / 10 % 1000;
                boolean var10 = var4 % 10 == 1;
                if (var7 != 4) {
                    var6 = new SPanel_Sub20_Sub1_Sub1(this.aClass60_4818, var7, var8, var9, var10);
                } else {
                    var6 = new SPanel_Sub20_Sub1_Sub2(this.aClass60_4818, var8, var10);
                }
            }

            this.aClass60_4818.connection.method1474((SPanel_Sub20) var6);
            ((Component) var6).setLocation(0, 0);
            this.addToContent((Component) var6);
        }

        this.contentReady();
    }

    public void destroyApplet() {
        if (this.autoPopups != null) {
            this.autoPopups.close();
        }

        this.aClass60_4818.method1452();
    }

    public boolean isDebug() {
        return false;
    }

    public static void method2302(Graphics2D var0, int var1, int var2, SPanel var3) {
        var0.setColor(new Color(0, 48, 0, 128));
        var0.fillRoundRect(0, 0, var1 - 1, var2 - 1, 10, 10);
        var0.setColor(new Color(0, 128, 0, 192));
        var0.drawRoundRect(0, 0, var1 - 1, var2 - 1, 10, 10);
        var3.useCurrentBufferAsBackground();
    }

    protected int method2303() {
        return this.anInt4819;
    }

    public void method2304(int var1) {
        this.method2306(var1, 0, 0);
    }

    protected void method2305(int var1, int var2) {
        this.method2306(var1, var2, 0);
    }

    protected void method2306(int var1, int var2, int var3) {
        if (var1 != this.anInt4819 && this.aSynchronizedBool_4803.method1460()) {
            if (this.anInt4819 == 3) {
                this.aSPanel_Sub21_4828.method2581();
            }

            if (this.anInt4819 == 4 && var1 == 3) {
                this.method2333();
            }

            this.anInt4819 = var1;
            if (this.aSPanel__4827 != null) {
                this.aSPanel__4827.method2589();
                if (this.aClass60_4818.connection != null) {
                    this.aClass60_4818.connection.method1472((LobbySelectHeaderPanel) null);
                }
            }

            if (this.aSPanel_Sub21_4828 != null) {
                this.aSPanel_Sub21_4828.method2574(false);
                this.aSPanel_Sub21_4828 = null;
                if (this.aClass60_4818.connection != null) {
                    this.aClass60_4818.connection.method1473((SPanel_Sub21) null);
                }
            }

            if (this.aClass60_4818.connection != null) {
                this.aClass60_4818.connection.method1474((SPanel_Sub20) null);
            }

            this.callUpdateUI(new Integer[]{new Integer(var2), new Integer(var3)});
        }
    }

    protected void method2307(boolean var1, int var2, boolean var3, boolean var4) {
        this.aSynchronizedBool_4822 = new SynchronizedBool(var1);
        this.aSynchronizedInt_4820 = new SynchronizedInt(var2);
        if (var3) {
            this.aClass60_4818.method1449();
        }

        this.aSynchronizedBool_4823 = new SynchronizedBool(var4);
    }

    protected void method2308(int var1, boolean var2, boolean var3) {
        if (this.aSynchronizedInt_4821 == null) {
            this.aSynchronizedInt_4821 = new SynchronizedInt();
        }

        this.aSynchronizedInt_4821.method1463(var1);
        if (this.aSynchronizedBool_4824 == null) {
            this.aSynchronizedBool_4824 = new SynchronizedBool();
        }

        this.aSynchronizedBool_4824.method1459(var2);
        if (var3) {
            super.param.updateWebPageInfoBox(var1, -1, -1);
        }

    }

    public boolean method2309() {
        return this.aSynchronizedBool_4822.method1460();
    }

    public int method2310() {
        return this.aSynchronizedInt_4820.method1467();
    }

    public boolean method2311() {
        return this.aSynchronizedBool_4823.method1460();
    }

    public int method2312() {
        return this.aSynchronizedInt_4821.method1467();
    }

    public boolean method2313() {
        return this.aSynchronizedBool_4824.method1460();
    }

    public Image[][] method2314() {
        return this.imagePoolBalls;
    }

    public Image[][] method2315() {
        return this.imageSnookerBalls;
    }

    public String method2316() {
        String var1 = super.param.getWelcomeMessage();
        super.param.removeWelcomeMessage();
        return var1;
    }

    protected boolean method2317() {
        return super.param.getSession() != null;
    }

    public boolean method2318(String var1) {
        return super.param.showPlayerCard(var1);
    }

    public void method2319(String[] var1, String var2) {
        super.param.showPlayerList(var1, var2);
    }

    public void method2320(boolean[] var1) {
        super.param.showPlayerListWinners(var1);
    }

    public void method2321() {
        super.param.removePlayerListWinners();
    }

    public void method2322() {
        super.param.removePlayerList();
    }

    public void method2323(boolean var1) {
        this.autoPopups.gameFinished(var1);
    }

    protected void method2324(int var1, int var2, int var3) {
        this.autoPopups.rankingChanged(var2, var3);
    }

    public void method2325(boolean var1) {
        this.setEndState(5);
        this.method2332(var1);
        this.aClass60_4818.method1452();
        super.param.showQuitPage();
    }

    public void method2326() {
        this.setEndState(7);
        this.aClass60_4818.method1452();
        super.param.showRegisterPage();
    }

    public void method2327() {
        this.setEndState(8);
        this.method2332(true);
        this.aClass60_4818.method1452();
        super.param.showCreditPurchasePage(false);
    }

    private boolean method2328() {
        String var1 = "aapeli";
        String var2 = "playray";
        String var3 = "playforia";
        String[] var4 = new String[]{"com", "net", "fi"};
        String[] var5 = new String[]{"com", "net", "org", "fi", "de", "se", "co.uk", "dk", "be", "nl", "ru", "ch", "at", "es", "no", "fr", "it", "ee", "co.ee", "jp", "be", "co.nz", "pl", "pt", "com.pt", "cz", "gr", "hu", "co.hu", "li", "lt", "lu", "md", "mobi", "ro", "sk", "li", "am", "by", "gs", "lv", "ie", "cl", "com.br", "com.ve", "co.ve", "com.tr", "web.tr", "com.co", "com.ar", "com.mx"};
        String[] var6 = new String[]{"com", "net"};
        String var7 = this.getCodeBase().getHost().toLowerCase();
        String var8 = this.getDocumentBase().getHost().toLowerCase();
        boolean var9 = this.method2329(var7, var1, var4) || this.method2329(var7, var2, var5) || this.method2329(var7, var3, var6);
        boolean var10 = this.method2329(var8, var1, var4) || this.method2329(var8, var2, var5) || this.method2329(var8, var3, var6);
        return var9 && var10;
    }

    private boolean method2329(String var1, String var2, String[] var3) {
        for (int var4 = 0; var4 < var3.length; ++var4) {
            if (var1.equals(var2 + "." + var3[var4])) {
                return true;
            }

            if (var1.endsWith("." + var2 + "." + var3[var4])) {
                return true;
            }
        }

        return false;
    }

    private Image[] method2330(Image var1, int var2) {
        int[] var3 = this.aClass60_4818.imageManager.getPixels(var1, var2, var2);
        this.method2331(var3);
        Image[] var4 = new Image[]{this.aClass60_4818.imageManager.createImage(var3, var2, var2), this.aClass60_4818.imageManager.createImage(this.aClass60_4818.imageManager.setTransparency(var3, 0.2D), var2, var2)};
        return var4;
    }

    private void method2331(int[] var1) {
        double var2 = Math.random() * 21.0D - 10.0D;
        double var4 = Math.random() * 21.0D - 10.0D;
        double var6 = Math.random() * 21.0D - 10.0D;

        for (int var8 = 0; var8 < var1.length; ++var8) {
            long var9 = ((long) var1[var8] & 4278190080L) >> 24;
            if (var9 > 0L) {
                long var11 = ((long) var1[var8] & 16711680L) >> 16;
                long var13 = ((long) var1[var8] & 65280L) >> 8;
                long var15 = (long) var1[var8] & 255L;
                var11 = Math.min(Math.max(0L, (long) ((double) var11 + var2 + 0.5D)), 255L);
                var13 = Math.min(Math.max(0L, (long) ((double) var13 + var4 + 0.5D)), 255L);
                var15 = Math.min(Math.max(0L, (long) ((double) var15 + var6 + 0.5D)), 255L);
                var1[var8] = (int) (var9 * 256L * 256L * 256L + var11 * 256L * 256L + var13 * 256L + var15);
            }
        }

    }

    private void method2332(boolean var1) {
        if (var1) {
            this.method2333();
        }

        this.aClass60_4818.connection.method1475("quit");
    }

    private void method2333() {
        if (this.method2309()) {
            String var1 = this.aClass60_4818.aClass61_1207.method1455();
            if (var1 != null) {
                this.aClass60_4818.connection.method1475("userdata\t" + var1);
            }
        }
    }
}
