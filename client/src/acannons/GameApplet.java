package acannons;

import com.playray.applet.AApplet;
import com.playray.client.AutoPopups;
import com.playray.client.CharacterImage;
import com.playray.client.ImageManager;
import com.playray.client.Parameters;
import com.playray.client.TextManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class GameApplet extends AApplet {

    public SynchronizedBool aSynchronizedBool_4779;
    public static final Color aColor4781 = new Color(102, 102, 102);
    public static final Color aColor4782 = new Color(255, 255, 255);
    public static final Font fontDialog22 = new Font("Dialog", Font.PLAIN, 22);
    public static final Font fontDialog18 = new Font("Dialog", Font.PLAIN, 18);
    public static final Font fontDialog14b = new Font("Dialog", Font.BOLD, 14);
    public static final Font fontDialog14 = new Font("Dialog", Font.PLAIN, 14);
    public static final Font fontDialog12b = new Font("Dialog", Font.BOLD, 12);
    public static final Font fontDialog12 = new Font("Dialog", Font.PLAIN, 12);
    public static final Font fontDialog11 = new Font("Dialog", Font.PLAIN, 11);
    public static final Font fontDialog9 = new Font("Dialog", Font.PLAIN, 9);
    private static final String[] aStringArray4792;
    private SynchronizedBool aSynchronizedBool_4793;
    private Class7 aClass7_4794;
    private Class7 aClass7_4795;
    private SynchronizedBool aSynchronizedBool_4796;
    private ClientSettings aClientSettings_4797;
    private int gameState;
    private AutoPopups anAutoPopups4799;
    private boolean aBoolean4800;
    public static boolean aBoolean4801;
    private static final String[] aStringArray4802 = new String[74];


    public void initApplet(Parameters var1) {
        this.aSynchronizedBool_4779 = new SynchronizedBool(this.method2297());
        this.setBackground(aColor4781);
        this.setForeground(aColor4782);
        this.aClientSettings_4797 = new ClientSettings(this, var1);
        Dimension var2 = this.getSize();
        this.aClientSettings_4797.anInt774 = var2.width;
        this.aClientSettings_4797.anInt775 = var2.height;
        this.anAutoPopups4799 = new AutoPopups(this);
        this.gameState = 0;
    }

    public void textsLoadedNotify(TextManager var1) {
        this.aClientSettings_4797.textManager = var1;
    }

    public void defineSounds(com.playray.client.SoundManager var1) {
        this.aClientSettings_4797.soundManager = var1;
        this.aClientSettings_4797.aSoundManager_770 = new SoundManager(this.aClientSettings_4797);
    }

    public void defineImages(ImageManager var1, String var2) {
        this.aClientSettings_4797.imageManager = var1;
        var1.defineImage("bg-lobby.png");
        var1.defineImage("bg-password.png");

        for (int var3 = 0; var3 < 6; ++var3) {
            var1.defineImage(aStringArray4792[this.aClientSettings_4797.useWinterGraphics] + "object-" + var3 + ".png");
        }

        var1.defineImage("cannon.png");
        var1.defineImage("cannon_own.png");
        var1.defineImage("ammo-napalm.png");
        var1.defineImage("ammo-ss20-up.png");
        var1.defineImage("ammo-ss20-down.png");
        var1.defineImage("cloud-poisongas.png");
        var1.defineImage("cloud-fallout.png");
        if (!var2.equals("aapeli")) {
            var2 = "playforia";
        }

        var1.defineImage("floating-ad-left", "floating-ad-left_" + var2 + ".png");
        var1.defineImage("floating-ad-right", "floating-ad-right_" + var2 + ".png");
    }

    public void createImages() {
        this.aClientSettings_4797.aGameSpriteManager_771 = new GameSpriteManager(this.anImageManager3822);
    }

    public void defineSecImages(ImageManager var1, String var2) {
        var1.defineImage("bg-game.png");
        var1.defineImage("bg-weaponmenu.png");
        var1.defineImage(aStringArray4792[this.aClientSettings_4797.useWinterGraphics] + "sky.jpg");
    }

    public void connectToServer() {
        if (!this.aClientSettings_4797.method995()) {
            this.setEndState(2);
        }

    }

    public void appletReady() {
        this.setGameSettings(false, 0, 0, true, true);
        this.aBoolean4800 = false;
        this.aClientSettings_4797.method996();
    }

    public void destroyApplet() {
        if (this.anAutoPopups4799 != null) {
            this.anAutoPopups4799.close();
        }

        this.aClientSettings_4797.method998();
    }

    public boolean isDebug() {
        return false;
    }

    protected int method2278() {
        return this.gameState;
    }

    public void setGameState(int var1) {
        this.setGameState(var1, 0);
    }

    protected void setGameState(int state, int var2) {
        if (state != this.gameState && this.aSynchronizedBool_4779.method1008()) {
            this.gameState = state;
            this.callUpdateUI(new Integer(var2));
        }
    }

    public void updateUI(Object var1) {
        int var2 = ((Integer) ((Integer) var1)).intValue();
        this.clearContent();
        this.aClientSettings_4797.aConnection_772.setGamePanel((GamePanel) null);
        if (this.gameState == 1) {
            if (this.aBoolean4800) {
                this.param.removeSession();
            } else {
                this.aBoolean4800 = true;
            }

            if (this.hasSession()) {
                this.param.noGuestAutoLogin();
                this.aClientSettings_4797.aConnection_772.writeData("login\t" + this.param.getSession());
                this.gameState = 0;
            } else {
                this.aClientSettings_4797.aConnection_772.writeData("login");
                this.gameState = 0;
            }
        }

        if (this.gameState == 2) {
            if (this.aClientSettings_4797.lobbyPanel == null) {
                this.aClientSettings_4797.lobbyPanel = new LobbyPanel(this.aClientSettings_4797);
                this.aClientSettings_4797.lobbyPanel.setLocation(0, 0);
            } else {
                this.method2299();
            }

            if (var2 >= 0) {
                this.aClientSettings_4797.lobbyPanel.method2452(var2);
            }

            this.addToContent(this.aClientSettings_4797.lobbyPanel);
        }

        if (this.gameState == 3) {
            GamePanel var3 = new GamePanel(this.aClientSettings_4797);
            this.aClientSettings_4797.aConnection_772.setGamePanel(var3);
            var3.setLocation(0, 0);
            this.addToContent(var3);
        }

        if (this.gameState == 4) {
            this.param.showQuitPage();
        } else {
            this.contentReady();
        }
    }

    protected void setGameSettings(boolean var1, int var2, int var3, boolean var4, boolean var5) {
        this.aSynchronizedBool_4793 = new SynchronizedBool(var1);
        this.aClass7_4794 = new Class7(var2);
        this.aClass7_4795 = new Class7(var3);
        if (var4) {
            this.aClientSettings_4797.initBadWordFilter();
        }

        this.aSynchronizedBool_4796 = new SynchronizedBool(var5);
    }

    public boolean method2282() {
        return this.aSynchronizedBool_4793.method1008();
    }

    public int method2283() {
        return this.aClass7_4794.method1016();
    }

    public boolean method2284() {
        return this.aSynchronizedBool_4796.method1008();
    }

    public CharacterImage method2285(String var1) {
        return new CharacterImage(this.anImageManager3822, var1, 0);
    }

    public String method2286() {
        String var1 = this.param.getWelcomeMessage();
        this.param.removeWelcomeMessage();
        return var1;
    }

    protected boolean hasSession() {
        return this.param.getSession() != null;
    }

    public boolean method2288(String var1) {
        return this.param.showPlayerCard(var1);
    }

    public void method2289(String[] var1) {
        this.param.showPlayerList(var1);
    }

    public void method2290(boolean[] var1) {
        this.param.showPlayerListWinners(var1);
    }

    public void method2291() {
        this.param.removePlayerList();
    }

    protected void setUserData(String var1) {
        this.aClientSettings_4797.aPlayerInfo_764.setUserData(var1);
    }

    public void method2293() {
        this.anAutoPopups4799.gameFinished(true);
    }

    public int method2294() {
        return this.aClass7_4795.method1016();
    }

    public void method2295(int var1) {
        this.aClass7_4795.method1012(var1);
        this.param.updateWebPageInfoBox(var1, -1, -1);
    }

    public void method2296() {
        this.setEndState(5);
        this.method2299();
        this.aClientSettings_4797.aConnection_772.writeData("quit");
        this.setGameState(4);
    }

    private boolean method2297() {
        String var1 = "aapeli";
        String var2 = "playray";
        String var3 = "playforia";
        String[] var4 = new String[]{"com", "net", "fi"};
        String[] var5 = new String[]{"com", "net", "org", "fi", "de", "se", "co.uk", "dk", "be", "nl", "ru", "ch", "at", "es", "no", "fr", "it", "ee", "co.ee", "jp", "be", "co.nz", "pl", "pt", "com.pt", "cz", "gr", "hu", "co.hu", "li", "lt", "lu", "md", "mobi", "ro", "sk", "li", "am", "by", "gs", "lv", "ie", "cl", "com.br", "com.ve", "co.ve", "com.tr", "web.tr", "com.co", "com.ar", "com.mx"};
        String[] var6 = new String[]{"com", "net"};
        String var7 = this.getCodeBase().getHost().toLowerCase();
        String var8 = this.getDocumentBase().getHost().toLowerCase();
        boolean var9 = this.method2298(var7, var1, var4) || this.method2298(var7, var2, var5) || this.method2298(var7, var3, var6);
        boolean var10 = this.method2298(var8, var1, var4) || this.method2298(var8, var2, var5) || this.method2298(var8, var3, var6);
        return var9 && var10;
    }

    private boolean method2298(String var1, String var2, String[] var3) {
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

    private void method2299() {
        if (this.method2282()) {
            String var1 = this.aClientSettings_4797.aPlayerInfo_764.method1000();
            if (var1 != null) {
                this.aClientSettings_4797.aConnection_772.writeData("userdata\t" + var1);
            }
        }

    }

    static {
        aStringArray4802[0] = "aapeli";
        aStringArray4802[1] = "cannon.png";
        aStringArray4802[2] = "ammo-ss20-up.png";
        aStringArray4802[3] = "object-";
        aStringArray4802[4] = "cloud-poisongas.png";
        aStringArray4802[5] = "floating-ad-left_";
        aStringArray4802[6] = "floating-ad-left";
        aStringArray4802[7] = "cannon_own.png";
        aStringArray4802[8] = "floating-ad-right";
        aStringArray4802[9] = "ammo-napalm.png";
        aStringArray4802[10] = ".png";
        aStringArray4802[11] = "playforia";
        aStringArray4802[12] = "cloud-fallout.png";
        aStringArray4802[13] = "ammo-ss20-down.png";
        aStringArray4802[14] = "bg-password.png";
        aStringArray4802[15] = "floating-ad-right_";
        aStringArray4802[16] = "bg-lobby.png";
        aStringArray4802[17] = "co.hu";
        aStringArray4802[18] = "playray";
        aStringArray4802[19] = "com.co";
        aStringArray4802[20] = "ch";
        aStringArray4802[21] = "hu";
        aStringArray4802[22] = "no";
        aStringArray4802[23] = "fi";
        aStringArray4802[24] = "pt";
        aStringArray4802[25] = "cz";
        aStringArray4802[26] = "dk";
        aStringArray4802[27] = "se";
        aStringArray4802[28] = "com.pt";
        aStringArray4802[29] = "pl";
        aStringArray4802[30] = "ru";
        aStringArray4802[31] = "it";
        aStringArray4802[32] = "at";
        aStringArray4802[33] = "li";
        aStringArray4802[34] = "mobi";
        aStringArray4802[35] = "com.br";
        aStringArray4802[36] = "web.tr";
        aStringArray4802[37] = "sk";
        aStringArray4802[38] = "com.tr";
        aStringArray4802[39] = "be";
        aStringArray4802[40] = "md";
        aStringArray4802[41] = "am";
        aStringArray4802[42] = "gr";
        aStringArray4802[43] = "by";
        aStringArray4802[44] = "com.mx";
        aStringArray4802[45] = "co.ve";
        aStringArray4802[46] = "co.ee";
        aStringArray4802[47] = "fr";
        aStringArray4802[48] = "com";
        aStringArray4802[49] = "lu";
        aStringArray4802[50] = "cl";
        aStringArray4802[51] = "es";
        aStringArray4802[52] = "co.nz";
        aStringArray4802[53] = "ie";
        aStringArray4802[54] = "com.ar";
        aStringArray4802[55] = "net";
        aStringArray4802[56] = "lv";
        aStringArray4802[57] = "jp";
        aStringArray4802[58] = "de";
        aStringArray4802[59] = "ee";
        aStringArray4802[60] = "ro";
        aStringArray4802[61] = "com.ve";
        aStringArray4802[62] = "nl";
        aStringArray4802[63] = "org";
        aStringArray4802[64] = "lt";
        aStringArray4802[65] = "co.uk";
        aStringArray4802[66] = "gs";
        aStringArray4802[67] = "quit";
        aStringArray4802[68] = "login";
        aStringArray4802[69] = "login\t";
        aStringArray4802[70] = "bg-weaponmenu.png";
        aStringArray4802[71] = "sky.jpg";
        aStringArray4802[72] = "bg-game.png";
        aStringArray4802[73] = "userdata\t";
        aStringArray4792 = new String[2];
        aStringArray4792[0] = "summer/";
        aStringArray4792[1] = "winter/";
    }
}
