package agolf2;

import com.aapeli.applet.AApplet;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.SoundManager;

public class AApplet_Sub3_Sub1 extends AApplet_Sub3 {

    public static final String aString4749;
    public static final String aString4750 = "alltracks";
    public static final String aString4751 = "trackpublish";
    public static final int[] anIntArray4752;
    private SynchronizedBool aSynchronizedBool_4753;
    private Class58_Sub1 aClass58_Sub1_4754;
    private IPanel_Sub37 anIPanel_Sub37_4755;
    private IPanel_Sub7 anIPanel_Sub7_4756;
    private IPanel_Sub28_Sub1_Sub3 anIPanel_Sub28_Sub1_Sub3_4757;
    private IPanel_Sub28_Sub1_Sub1 anIPanel_Sub28_Sub1_Sub1_4758;
    private IPanel_Sub28_Sub1_Sub2 anIPanel_Sub28_Sub1_Sub2_4759;
    private Panel_Sub21 aPanel_Sub21_4760;
    private static final String[] aStringArray4761 = new String[29];


    public void initApplet(Parameters var1) {
        super.method51(var1, false);
        this.aClass58_Sub1_4754 = new Class58_Sub1(this, var1);
    }

    public void defineSounds(SoundManager var1) {
        super.defineSounds(var1);
        var1.defineSound("game_win.au");
        var1.defineSound("game_draw.au");
        var1.defineSound("game_lose.au");
    }

    public void defineImages(ImageManager var1, String var2) {
        super.defineImages(var1, var2);
        var1.defineImage("background_select.png");
    }

    public void createImages() {
        super.method52(this.aClass58_Sub1_4754);
    }

    public void defineSecImages(ImageManager var1, String var2) {
        super.defineSecImages(var1, var2);
        var1.defineImage("game_balls_normal.png");
        var1.defineImage("game_balls_big.png");
        var1.defineImage("game_balls_small.png");
        var1.defineImage("background_prevtrack.png");
        var1.defineImage("game_playericons.png");
        var1.defineImage("game_thumbs.png");
        var1.defineImage("editor_mouse.png");
        var1.defineImage("editor_swap.png");
        var1.defineImage("editor_paint_pencil.png");
        var1.defineImage("editor_paint_pencil_active.png");
        var1.defineImage("editor_paint_fill.png");
        var1.defineImage("editor_paint_fill_active.png");
        var1.defineImage("editor_paint_stamp.png");
        var1.defineImage("editor_paint_stamp_active.png");
        var1.defineImage("editor_mirror_hor.png");
        var1.defineImage("editor_mirror_ver.png");
        var1.defineImage("editor_move_up.png");
        var1.defineImage("editor_move_down.png");
        var1.defineImage("editor_move_left.png");
        var1.defineImage("editor_move_right.png");
    }

    public void connectToServer() {
        if (!this.aClass58_Sub1_4754.method1438()) {
            this.setEndState(AApplet.END_ERROR_CONNECTION);
        }

    }

    public void appletReady() {
        super.appletReady();
        this.method67((String) null, 0, 0, true, (String) null, 0, false, true);
        this.aClass58_Sub1_4754.method1439();
    }

    public void destroyApplet() {
        if (this.anIPanel_Sub28_Sub1_Sub3_4757 != null) {
            this.anIPanel_Sub28_Sub1_Sub3_4757.method682();
        }

        if (this.anIPanel_Sub28_Sub1_Sub1_4758 != null) {
            this.anIPanel_Sub28_Sub1_Sub1_4758.method682();
        }

        if (this.anIPanel_Sub28_Sub1_Sub2_4759 != null) {
            this.anIPanel_Sub28_Sub1_Sub2_4759.method682();
        }

        this.aClass58_Sub1_4754.method1440();
    }

    public boolean isDebug() {
        return false;
    }

    protected void method55(int var1, int var2) {
        if (var1 != this.anInt3792 && this.aSynchronizedBool_3777.method1168()) {
            this.anInt3792 = var1;
            if (this.anIPanel_Sub37_4755 != null) {
                this.anIPanel_Sub37_4755.method792();
            }

            if (this.anIPanel_Sub28_Sub1_Sub1_4758 != null) {
                this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1190();
                this.anIPanel_Sub28_Sub1_Sub1_4758 = null;
            }

            if (this.anIPanel_Sub28_Sub1_Sub2_4759 != null) {
                this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1192();
                this.anIPanel_Sub28_Sub1_Sub2_4759 = null;
            }

            if (this.aPanel_Sub21_4760 != null) {
                this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1194();
                this.aPanel_Sub21_4760 = null;
            }

            this.clearContent();
            if (var1 == 1) {
                if (this.aBoolean3798) {
                    this.aClass58_Sub1_4754.aParameters1186.removeSession();
                } else {
                    this.aBoolean3798 = true;
                }

                if (this.method68()) {
                    this.aClass58_Sub1_4754.aParameters1186.noGuestAutoLogin();
                    this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1179("login\t~\t" + this.aClass58_Sub1_4754.aParameters1186.getSession());
                    this.anInt3792 = 0;
                } else if (this.aClass58_Sub1_4754.aParameters1186.isGuestAutoLogin()) {
                    this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1179("login");
                    this.anInt3792 = 0;
                } else {
                    IPanel_Sub33_Sub1 var3 = new IPanel_Sub33_Sub1(this.aClass58_Sub1_4754, this.appletWidth, this.appletHeight, var2);
                    var3.setLocation(0, 0);
                    this.addToContent(var3);
                }
            }

            if (var1 == 2) {
                if (this.aClass58_Sub1_4754.aTournament3568 == null) {
                    IPanel_Sub26 var4 = new IPanel_Sub26(this.aClass58_Sub1_4754, this.appletWidth, this.appletHeight);
                    var4.setLocation(0, 0);
                    this.addToContent(var4);
                } else {
                    this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1179("select\tsingle\tt");
                }
            }

            if (var1 == 3) {
                if (this.anIPanel_Sub7_4756 == null) {
                    this.anIPanel_Sub7_4756 = new IPanel_Sub7(this.aClass58_Sub1_4754, this.appletWidth, this.appletHeight);
                    this.anIPanel_Sub7_4756.setLocation(0, 0);
                    this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1186(this.anIPanel_Sub7_4756);
                }

                if (var2 == 1) {
                    this.anIPanel_Sub7_4756.method526();
                }

                this.addToContent(this.anIPanel_Sub7_4756);
            }

            if (var1 == 4) {
                LobbySingleContentPanel var5 = new LobbySingleContentPanel(this.aClass58_Sub1_4754, var2 == 1, this.appletWidth, this.appletHeight);
                var5.setLocation(0, 0);
                this.addToContent(var5);
                this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1187(var5);
                this.anIPanel_Sub37_4755 = var5;
            }

            if (var1 == 5) {
                LobbyMultiContentPanel var6 = new LobbyMultiContentPanel(this.aClass58_Sub1_4754, this.appletWidth, this.appletHeight);
                var6.setLocation(0, 0);
                this.addToContent(var6);
                this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1188(var6);
                this.anIPanel_Sub37_4755 = var6;
            }

            if (var1 == 6) {
                this.anIPanel_Sub28_Sub1_Sub1_4758 = new IPanel_Sub28_Sub1_Sub1(this.aClass58_Sub1_4754, this.appletWidth, this.appletHeight, var2 == 1);
                this.anIPanel_Sub28_Sub1_Sub1_4758.setLocation(0, 0);
                this.addToContent(this.anIPanel_Sub28_Sub1_Sub1_4758);
                this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1189(this.anIPanel_Sub28_Sub1_Sub1_4758);
            }

            if (var1 == 7) {
                this.anIPanel_Sub28_Sub1_Sub2_4759 = new IPanel_Sub28_Sub1_Sub2(this.aClass58_Sub1_4754, this.appletWidth, this.appletHeight, var2 == 1);
                this.anIPanel_Sub28_Sub1_Sub2_4759.setLocation(0, 0);
                this.addToContent(this.anIPanel_Sub28_Sub1_Sub2_4759);
                this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1191(this.anIPanel_Sub28_Sub1_Sub2_4759);
            }

            if (var1 == 8) {
                this.aPanel_Sub21_4760 = new Panel_Sub21(this.aClass58_Sub1_4754, this.appletWidth, this.appletHeight);
                this.aPanel_Sub21_4760.setLocation(0, 0);
                this.addToContent(this.aPanel_Sub21_4760);
                this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1193(this.aPanel_Sub21_4760);
            }

            if (var1 == 9) {
                this.aClass58_Sub1_4754.aParameters1186.showQuitPage();
            } else {
                this.contentReady();
            }
        }
    }

    protected void method67(String var1, int var2, int var3, boolean var4, String var5, int var6, boolean var7, boolean var8) {
        super.setGameSettings(var1, var2, var3, var6, var8);
        if (var4) {
            this.aClass58_Sub1_4754.method1437();
        }

        this.aSynchronizedBool_4753 = new SynchronizedBool(var7);
    }

    protected boolean method68() {
        return this.aClass58_Sub1_4754.aParameters1186.getSession() != null;
    }

    public boolean method69() {
        return !this.method60() ? false : this.aSynchronizedBool_4753.method1168();
    }

    public String method70() {
        String var1 = this.aClass58_Sub1_4754.aParameters1186.getWelcomeMessage();
        this.aClass58_Sub1_4754.aParameters1186.removeWelcomeMessage();
        return var1;
    }

    public void method64(boolean var1) {
        this.setEndState(AApplet.END_QUIT);
        if (var1 && this.method58() >= 1) {
            String var2 = this.aClass58_Sub1_4754.aClass59_Sub1_3569.method1442();
            if (var2 != null) {
                this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1179("userdata\t" + var2);
            }
        }

        this.aClass58_Sub1_4754.aClass36_Sub1_3572.method1179("quit");
        this.method54(9);
    }

    public void method71(String var1) {
        this.clearContent();
        this.anIPanel_Sub28_Sub1_Sub3_4757 = new IPanel_Sub28_Sub1_Sub3(this.aClass58_Sub1_4754, this.appletWidth, this.appletHeight);
        this.anIPanel_Sub28_Sub1_Sub3_4757.setLocation(0, 0);
        this.addToContent(this.anIPanel_Sub28_Sub1_Sub3_4757);
        this.contentReady();
        this.anIPanel_Sub28_Sub1_Sub3_4757.method711(this.getUsername(), var1);
    }

    public void method72(boolean var1) {
        this.clearContent();
        if (var1) {
            this.anIPanel_Sub7_4756.method533();
        }

        this.addToContent(this.anIPanel_Sub7_4756);
        this.contentReady();
    }

    static {
        aStringArray4761[0] = "login\t~\t";
        aStringArray4761[1] = "login";
        aStringArray4761[2] = "select\tsingle\tt";
        aStringArray4761[3] = "editor_move_left.png";
        aStringArray4761[4] = "editor_move_down.png";
        aStringArray4761[5] = "editor_mirror_hor.png";
        aStringArray4761[6] = "game_balls_big.png";
        aStringArray4761[7] = "editor_swap.png";
        aStringArray4761[8] = "editor_paint_pencil_active.png";
        aStringArray4761[9] = "editor_paint_fill_active.png";
        aStringArray4761[10] = "background_prevtrack.png";
        aStringArray4761[11] = "editor_move_up.png";
        aStringArray4761[12] = "editor_mouse.png";
        aStringArray4761[13] = "editor_paint_pencil.png";
        aStringArray4761[14] = "editor_paint_stamp.png";
        aStringArray4761[15] = "game_playericons.png";
        aStringArray4761[16] = "game_balls_normal.png";
        aStringArray4761[17] = "editor_paint_fill.png";
        aStringArray4761[18] = "editor_paint_stamp_active.png";
        aStringArray4761[19] = "editor_move_right.png";
        aStringArray4761[20] = "game_thumbs.png";
        aStringArray4761[21] = "editor_mirror_ver.png";
        aStringArray4761[22] = "game_balls_small.png";
        aStringArray4761[23] = "quit";
        aStringArray4761[24] = "userdata\t";
        aStringArray4761[25] = "background_select.png";
        aStringArray4761[26] = "game_win.au";
        aStringArray4761[27] = "game_lose.au";
        aStringArray4761[28] = "game_draw.au";
        aString4749 = null;
        anIntArray4752 = new int[]{1, 4, 2, 3};
    }
}
