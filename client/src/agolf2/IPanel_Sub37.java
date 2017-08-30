package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.TabBar;
import com.aapeli.credit.Product;
import com.aapeli.credit.PurchaseFrame;
import com.aapeli.credit.PurchaseHandler;
import com.aapeli.tools.Tools;

import java.awt.Color;
import java.awt.LayoutManager;

public abstract class IPanel_Sub37 extends IPanel implements PurchaseHandler {

    public static final Color aColor2407;
    public static final int[] anIntArray2408;
    public static final int[] anIntArray2409;
    public static final int[] anIntArray2410;
    public static final int[] anIntArray2411;
    public static final int[] anIntArray2412;
    public static final int[] anIntArray2413;
    public static final int[] anIntArray2414;
    public static final int[] anIntArray2415;
    public static final int[] anIntArray2416;
    public static int anInt2417;
    public static int anInt2418;
    private static final String[] aStringArray2419;
    public static final String[] aStringArray2420;
    public static final String[] aStringArray2421;
    public static final String[] aStringArray2422;
    public static final String[] aStringArray2423;
    protected Class58_Sub1 aClass58_Sub1_2424;
    private String aString2425;
    protected int anInt2426;
    protected int anInt2427;
    public ChatLobby_Sub3 aChatLobby_Sub3_2428;
    private PurchaseFrame aPurchaseFrame2429;
    private boolean aBoolean2430;
    private String aString2431;
    public static int anInt2432;
    private static final String[] aStringArray2433 = new String[14];


    public IPanel_Sub37(Class58_Sub1 var1, int var2, int var3, String var4) {
        this.aClass58_Sub1_2424 = var1;
        this.aString2425 = var4;
        this.anInt2426 = var2;
        this.anInt2427 = var3;
        this.setSize(var2, var3);
        this.setLayout((LayoutManager) null);
        this.setBackground(var1.imageManager.getImage("background"));
    }

    public int refreshCredits() {
        this.aBoolean2430 = false;
        this.method791("credits");
        int var1 = 0;

        do {
            Tools.sleep(100L);
            ++var1;
        } while (!this.aBoolean2430 && var1 < 42);

        return this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567.method62();
    }

    public int userBuyProduct(Product var1, Object var2) {
        if (this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567.method62() < var1.getProductPrice()) {
            return 0;
        } else {
            this.aString2431 = null;
            this.method791("buy\t" + var1.getProductName());
            int var3 = 0;

            do {
                Tools.sleep(100L);
                ++var3;
            } while (this.aString2431 == null && var3 < 500);

            String var4 = this.aString2431;
            if (var4 == null) {
                return -1;
            } else if (var4.equals("nobalance")) {
                return 0;
            } else if (!var4.equals("ok")) {
                return -1;
            } else {
                var1.userBoughtProduct();
                this.method794();
                this.method783();
                return 1;
            }
        }
    }

    public void userCanceled() {
        this.method794();
        if (this.aClass58_Sub1_2424.aTournament3568 != null) {
            this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567.method64(false);
        }

    }

    public abstract boolean method782(String[] var1);

    protected abstract void method783();

    public void method784(String var1) {
        this.aChatLobby_Sub3_2428.broadcastMessage(var1);
    }

    public void method785(String[] var1) {
        if (var1[1].equals("credits")) {
            this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567.method63(Integer.parseInt(var1[2]));
            this.aBoolean2430 = true;
        } else if (var1[1].equals("buy")) {
            if (var1[2].equals("ok")) {
                this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567.method63(Integer.parseInt(var1[3]));
            }

            this.aString2431 = var1[2];
        } else if (var1[1].equals("banned")) {
            this.aChatLobby_Sub3_2428.addHighlightMessage(this.aClass58_Sub1_2424.textManager.getGame("Lobby_BannedFromGame"));
        } else if (!this.aChatLobby_Sub3_2428.method910(var1)) {
            if (this.method782(var1)) {
                ;
            }

        }
    }

    protected TabBar method786(int var1, int var2, int var3) {
        TabBar var4 = new TabBar(var1 + 5, var2 + 35);
        var4.setBackground(AApplet_Sub3.aColor3778);
        var4.setBorderColor(aColor2407);
        var4.setButtonFont(AApplet_Sub3.fontDialog14);
        var4.setButtonBackground(AApplet_Sub3.aColor3778);
        var4.setButtonForeground(AApplet_Sub3.aColor3779);
        var4.setLocation(5, 5 + var3 + 5);
        return var4;
    }

    protected void method787(int var1, boolean var2) {
        this.aChatLobby_Sub3_2428 = new ChatLobby_Sub3(this.aClass58_Sub1_2424, this, 5, this.anInt2427 - 5 - var1, this.anInt2426 - 10, var1);
        if (var2) {
            this.add(this.aChatLobby_Sub3_2428);
        }

    }

    public void method788() {
        this.method794();
        Product var1 = this.aClass58_Sub1_2424.aProductHandler1192.getProduct("alltracks");
        this.aPurchaseFrame2429 = new PurchaseFrame(this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567, this, var1, this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567.method62(), this.aClass58_Sub1_2424.textManager.getGame("Lobby_Buy_FrameTitle"), this.aClass58_Sub1_2424.textManager.getGame("Lobby_Buy_FrameBuy"), this.aClass58_Sub1_2424.textManager.getGame("Lobby_Buy_FrameBack"));
        this.aPurchaseFrame2429.open(this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567);
    }

    public boolean method789() {
        Product var1 = this.method793();
        return var1 == null ? true : (!this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567.method60() ? false : (this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567.method69() ? true : var1.userHaveProduct()));
    }

    public String method790(int var1) {
        if (var1 == anInt2417) {
            Product var2 = this.method793();
            if (var2 == null) {
                return this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_TrackTypesBasicOfficial");
            }
        }

        return this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_TrackTypes" + aStringArray2419[var1]);
    }

    public void method791(String var1) {
        this.aClass58_Sub1_2424.aClass36_Sub1_3572.method1179(this.aString2425 + "\t" + var1);
    }

    public void method792() {
        this.method794();
    }

    private Product method793() {
        Product var1 = this.aClass58_Sub1_2424.aProductHandler1192.getProduct("alltracks");
        return var1 == null ? null : (var1.getProductPrice() <= 0 ? null : var1);
    }

    private void method794() {
        if (this.aPurchaseFrame2429 != null) {
            this.aPurchaseFrame2429.close();
            this.aPurchaseFrame2429 = null;
            this.aClass58_Sub1_2424.anAApplet_Sub3_Sub1_3567.requestFocus();
        }
    }

    static {
        aStringArray2433[0] = "Lobby_Settings_TrackTypes";
        aStringArray2433[1] = "Lobby_Settings_TrackTypesBasicOfficial";
        aStringArray2433[2] = "buy";
        aStringArray2433[3] = "credits";
        aStringArray2433[4] = "banned";
        aStringArray2433[5] = "ok";
        aStringArray2433[6] = "Lobby_BannedFromGame";
        aStringArray2433[7] = "background";
        aStringArray2433[8] = "buy\t";
        aStringArray2433[9] = "nobalance";
        aStringArray2433[10] = "Lobby_Buy_FrameBack";
        aStringArray2433[11] = "Lobby_Buy_FrameTitle";
        aStringArray2433[12] = "alltracks";
        aStringArray2433[13] = "Lobby_Buy_FrameBuy";
        aColor2407 = new Color(224, 224, 255);
        anIntArray2408 = new int[]{2, 3, 4, 5, 6};
        anIntArray2409 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        anIntArray2410 = new int[]{0, 1, 2, 3, 4};
        anIntArray2411 = new int[]{0, 1};
        anIntArray2412 = new int[]{5, 10, 15, 20, 25, 30, 40, 50};
        anIntArray2413 = new int[]{10, 15, 20, 30, 45, 60, 90, 120, 150, 180};
        anIntArray2414 = new int[]{0, 1};
        anIntArray2415 = new int[]{0, 1};
        anIntArray2416 = new int[]{0, 1};
        anInt2417 = 1;
        anInt2418 = 4;
        aStringArray2419 = new String[5];
        aStringArray2419[0] = "All";
        aStringArray2419[1] = "FreeOfficial";
        aStringArray2419[2] = "AllOfficial";
        aStringArray2419[3] = "User";
        aStringArray2419[4] = "OwnChoice";
        aStringArray2420 = new String[2];
        aStringArray2420[0] = "SameTime";
        aStringArray2420[1] = "InTurns";
        aStringArray2421 = new String[2];
        aStringArray2421[0] = "No";
        aStringArray2421[1] = "Yes";
        aStringArray2422 = new String[2];
        aStringArray2422[0] = "Strikes";
        aStringArray2422[1] = "Tracks";
        aStringArray2423 = new String[2];
        aStringArray2423[0] = "No";
        aStringArray2423[1] = "Yes";
    }
}
