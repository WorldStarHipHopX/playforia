package agolf2;

import com.aapeli.client.PersonalScore;
import com.aapeli.colorgui.TabBar;
import com.aapeli.colorgui.TabBarListener;

public class LobbySingleContentPanel extends IPanel_Sub37 implements TabBarListener {

    private static int anInt3683;
    private IPanel_Sub16 anIPanel_Sub16_3684;
    private TabBar tabBar;
    private IPanel_Sub22 anIPanel_Sub22_3686;
    private IPanel_Sub14 anIPanel_Sub14_3687;
    private IPanel_Sub24 anIPanel_Sub24_3688;
    private IPanel_Sub18 anIPanel_Sub18_3689;
    public static boolean aBoolean3690;
    private static final String[] aStringArray3691 = new String[13];


    public LobbySingleContentPanel(Class58_Sub1 var1, boolean var2, int var3, int var4) {
        super(var1, var3, var4, "lobby1");
        this.create(var2);
    }

    public void selectedTabChanged(int var1) {
        anInt3683 = var1;
        if (var1 != 1) {
            this.anIPanel_Sub18_3689.method614((Class53) null);
        }

    }

    public boolean method782(String[] var1) {
        if (var1[1].equals("tracksets")) {
            this.anIPanel_Sub14_3687.method594(var1);
            this.method807();
            return true;
        } else if (var1[1].equals("ps")) {
            this.anIPanel_Sub18_3689.method613(new PersonalScore(var1[2]));
            return true;
        } else {
            if (var1[1].equals("gamelist")) {
                if (var1[2].equals("full")) {
                    this.method808(var1);
                    return true;
                }

                if (var1[2].equals("add")) {
                    this.method809(var1, 3, true);
                    return true;
                }

                if (var1[2].equals("remove")) {
                    this.method810(var1);
                    return true;
                }
            }

            if (var1[1].equals("trackreq")) {
                this.anIPanel_Sub22_3686.method633(var1);
                return true;
            } else if (var1[1].equals("trackerror")) {
                this.aChatLobby_Sub3_2428.addPlainMessage(this.aClass58_Sub1_2424.textManager.getGame("Lobby_TrackSelect_TrackError", var1[2]));
                return true;
            } else {
                return false;
            }
        }
    }

    protected void method783() {
        this.anIPanel_Sub14_3687.method595();
    }

    public void method792() {
        super.method792();
        this.anIPanel_Sub22_3686.method634();
    }

    private void create(boolean var1) {
        byte var2 = 25;
        this.anIPanel_Sub16_3684 = new IPanel_Sub16(this.aClass58_Sub1_2424, this, this.anInt2426 - 10, var2);
        this.anIPanel_Sub16_3684.setLocation(5, 5);
        if (this.aClass58_Sub1_2424.aTournament3568 == null) {
            this.add(this.anIPanel_Sub16_3684);
        }

        this.anIPanel_Sub18_3689 = new IPanel_Sub18(this.aClass58_Sub1_2424, this.anInt2426 - 5 - 520, 337);
        this.anIPanel_Sub18_3689.setLocation(520, 5 + var2 + 5 + 28);
        if (this.aClass58_Sub1_2424.aTournament3568 == null) {
            this.add(this.anIPanel_Sub18_3689);
        }

        this.tabBar = this.method786(500, 330, var2);
        this.anIPanel_Sub22_3686 = new IPanel_Sub22(this.aClass58_Sub1_2424, this, 500, 330);
        this.tabBar.addTab(this.aClass58_Sub1_2424.textManager.getGame("Lobby1_Training_Title"), this.anIPanel_Sub22_3686);
        this.anIPanel_Sub14_3687 = new IPanel_Sub14(this.aClass58_Sub1_2424, this, this.anIPanel_Sub18_3689, 500, 330);
        this.tabBar.addTab(this.aClass58_Sub1_2424.textManager.getGame("Lobby1_Championship_Title"), this.anIPanel_Sub14_3687);
        this.anIPanel_Sub24_3688 = new IPanel_Sub24(this.aClass58_Sub1_2424, this, 500, 330);
        this.tabBar.addTab(this.aClass58_Sub1_2424.textManager.getGame("Lobby1_Watch_Title", "-"), this.anIPanel_Sub24_3688);
        this.tabBar.setSelectedIndex(anInt3683);
        this.tabBar.addTabBarListener(this);
        if (this.aClass58_Sub1_2424.aTournament3568 == null) {
            this.add(this.tabBar);
        }

        int var3 = this.anInt2427 - 5 - 5 - 365 - 5 - var2 - 5;
        this.method787(var3, !var1);
    }

    private void method807() {
        if (this.aClass58_Sub1_2424.aTournament3568 != null) {
            this.tabBar.setSelectedIndex(1);
            this.anIPanel_Sub14_3687.method596();
        }
    }

    private void method808(String[] var1) {
        this.anIPanel_Sub24_3688.method649();
        int var2 = Integer.parseInt(var1[3]);

        for (int var3 = 0; var3 < var2; ++var3) {
            this.method809(var1, 5 * var3 + 4, false);
        }

        this.method811();
    }

    private Class51 method809(String[] var1, int var2, boolean var3) {
        int var4 = Integer.parseInt(var1[var2]);
        String var5 = var1[var2 + 1];
        String var6 = var1[var2 + 2];
        boolean var7 = var1[var2 + 3].equals("t");
        String var8 = var1[var2 + 4];
        Class51 var9 = new Class51(var4, var5, var6.equals("-") ? null : var6, var7, var8);
        this.anIPanel_Sub24_3688.method650(var9);
        if (var3) {
            this.method811();
        }

        return var9;
    }

    private int method810(String[] var1) {
        int var2 = Integer.parseInt(var1[3]);
        this.anIPanel_Sub24_3688.method651(var2);
        this.method811();
        return var2;
    }

    private void method811() {
        this.tabBar.setTabTitle(2, this.aClass58_Sub1_2424.textManager.getGame("Lobby1_Watch_Title", this.anIPanel_Sub24_3688.method652()));
    }

    static {
        aStringArray3691[0] = "trackreq";
        aStringArray3691[1] = "remove";
        aStringArray3691[2] = "gamelist";
        aStringArray3691[3] = "add";
        aStringArray3691[4] = "full";
        aStringArray3691[5] = "trackerror";
        aStringArray3691[6] = "ps";
        aStringArray3691[7] = "Lobby_TrackSelect_TrackError";
        aStringArray3691[8] = "tracksets";
        aStringArray3691[9] = "Lobby1_Watch_Title";
        aStringArray3691[10] = "lobby1";
        aStringArray3691[11] = "Lobby1_Championship_Title";
        aStringArray3691[12] = "Lobby1_Training_Title";
        anInt3683 = 0;
    }
}
