package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.ColorCheckbox;
import com.aapeli.colorgui.RoundButton;
import com.aapeli.multiuser.NoChallCheckbox;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class IPanel_Sub6 extends IPanel implements ActionListener, ItemListener {

    private Class58_Sub1 aClass58_Sub1_2956;
    private LobbyMultiContentPanel anLobbyMultiContentPanel__2957;
    private int anInt2958;
    private int anInt2959;
    private boolean aBoolean2960;
    private String aString2961;
    private LobbyGameInfo aLobbyGameInfo_2962;
    private RoundButton aRoundButton2963;
    private RoundButton aRoundButton2964;
    private NoChallCheckbox aNoChallCheckbox2965;
    private ColorCheckbox aColorCheckbox2966;
    private Object anObject2967;
    private static final String[] aStringArray2968 = new String[11];


    protected IPanel_Sub6(Class58_Sub1 var1, LobbyMultiContentPanel var2, int var3, int var4) {
        this.aClass58_Sub1_2956 = var1;
        this.anLobbyMultiContentPanel__2957 = var2;
        this.anObject2967 = new Object();
        this.anInt2958 = var3;
        this.anInt2959 = var4;
        this.setSize(var3, var4);
        this.method521();
        this.method525();
        this.aBoolean2960 = false;
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        var1.setColor(IPanel_Sub37.aColor2407);
        var1.drawRect(0, 0, this.anInt2958 - 1, this.anInt2959 - 1);
        var1.drawRect(1, 1, this.anInt2958 - 3, this.anInt2959 - 3);
        var1.setColor(AApplet_Sub3.aColor3779);
        if (this.aBoolean2960) {
            var1.setFont(AApplet_Sub3.fontDialog12);
            StringDraw.drawStringWithMaxWidth(var1, this.aClass58_Sub1_2956.textManager.getGame("Lobby2_Invite_WaitStateInfo"), this.anInt2958 / 2, 50, 0, this.anInt2958 - 70);
        } else {
            if (this.aString2961 != null) {
                var1.setFont(AApplet_Sub3.fontDialog12b);
                StringDraw.drawStringWithMaxWidth(var1, this.aClass58_Sub1_2956.textManager.getGame("Lobby2_Invite_" + (IPanel_Sub37.anIntArray2408[this.aLobbyGameInfo_2962.getNumPlayersIndex()] == 2 ? "Challenged" : "Invited"), this.aString2961), this.anInt2958 / 2, 35, 0, this.anInt2958 - 30);
                var1.setFont(AApplet_Sub3.fontDialog12);
                this.anLobbyMultiContentPanel__2957.method797(this.aLobbyGameInfo_2962, var1, 30, this.anInt2958 - 30, 80, true, true);
            }

        }
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = this.anObject2967;
        synchronized (this.anObject2967) {
            Object var3 = var1.getSource();
            if (var3 == this.aRoundButton2963) {
                if (this.aLobbyGameInfo_2962.getTracksTypeIndex() != IPanel_Sub37.anInt2417) {
                    if (this.aClass58_Sub1_2956.anAApplet_Sub3_Sub1_3567.method58() == 0) {
                        this.anLobbyMultiContentPanel__2957.aChatLobby_Sub3_2428.addPlainMessage(this.aClass58_Sub1_2956.textManager.getGame("Lobby2_Join_WormCantJoinNonFreeTrackGame"));
                        return;
                    }

                    if (!this.anLobbyMultiContentPanel__2957.method789()) {
                        this.anLobbyMultiContentPanel__2957.method788();
                        return;
                    }
                }

                this.method524();
                this.anLobbyMultiContentPanel__2957.method791("waitaccept");
            } else if (var3 == this.aRoundButton2964) {
                this.method523();
            }

        }
    }

    public void itemStateChanged(ItemEvent var1) {
        Object var2 = this.anObject2967;
        synchronized (this.anObject2967) {
            Object var3 = var1.getSource();
            if (var3 == this.aNoChallCheckbox2965) {
                this.aClass58_Sub1_2956.aClass59_Sub1_3569.aBoolean3587 = this.aNoChallCheckbox2965.getState();
                this.anLobbyMultiContentPanel__2957.method799();
                if (this.method517() && this.aNoChallCheckbox2965.getState()) {
                    this.method523();
                } else {
                    this.method525();
                }
            } else if (var3 == this.aColorCheckbox2966) {
                this.aClass58_Sub1_2956.aClass59_Sub1_3569.aBoolean3588 = this.aColorCheckbox2966.getState();
            }

        }
    }

    protected void method516(String var1, LobbyGameInfo var2) {
        Object var3 = this.anObject2967;
        synchronized (this.anObject2967) {
            this.aString2961 = var1;
            this.aLobbyGameInfo_2962 = var2;
            this.method525();
        }

        this.repaint();
    }

    protected boolean method517() {
        Object var1 = this.anObject2967;
        synchronized (this.anObject2967) {
            return this.aString2961 != null && this.aLobbyGameInfo_2962 != null;
        }
    }

    protected void method518(int var1, LobbyGameInfo var2) {
        if (this.aLobbyGameInfo_2962 != null) {
            if (this.aLobbyGameInfo_2962.method1350() == var1) {
                if (var2.method1351()) {
                    this.method524();
                } else {
                    this.aLobbyGameInfo_2962 = var2;
                    this.repaint();
                }
            }
        }
    }

    protected void method519(boolean var1) {
        this.aBoolean2960 = var1;
        this.method525();
        this.repaint();
    }

    protected boolean method520() {
        return this.aBoolean2960;
    }

    private void method521() {
        this.setLayout((LayoutManager) null);
        this.aRoundButton2963 = new RoundButton(this.aClass58_Sub1_2956.textManager.getGame("Lobby2_Invite_Accept"));
        this.aRoundButton2963.setBounds(30, this.anInt2959 - 10 - 20 - 5 - 20 - 15 - 25, 100, 25);
        this.aRoundButton2963.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton2963.addActionListener(this);
        this.add(this.aRoundButton2963);
        this.aRoundButton2964 = new RoundButton(this.aClass58_Sub1_2956.textManager.getGame("Lobby2_Invite_Reject"));
        this.aRoundButton2964.setBounds(this.anInt2958 - 30 - 100, this.anInt2959 - 10 - 20 - 5 - 20 - 15 - 25, 100, 25);
        this.aRoundButton2964.setBackground(AApplet_Sub3.aColor3783);
        this.aRoundButton2964.addActionListener(this);
        this.add(this.aRoundButton2964);
        this.aNoChallCheckbox2965 = new NoChallCheckbox(this.aClass58_Sub1_2956.textManager.getGame("Lobby2_Invite_NoInvitesToMe"), this.aClass58_Sub1_2956.aClass59_Sub1_3569.aBoolean3587);
        this.method522(this.aNoChallCheckbox2965, false, 10, this.anInt2959 - 10 - 18 - 4 - 18, this.anInt2958 - 20, 18);
        this.aColorCheckbox2966 = new ColorCheckbox(this.aClass58_Sub1_2956.textManager.getGame("Lobby2_Invite_BeepOnInvite"), this.aClass58_Sub1_2956.aClass59_Sub1_3569.aBoolean3588);
        this.method522(this.aColorCheckbox2966, true, 10, this.anInt2959 - 10 - 18, this.anInt2958 - 20, 18);
    }

    private void method522(ColorCheckbox var1, boolean var2, int var3, int var4, int var5, int var6) {
        var1.setBounds(var3, var4, var5, var6);
        var1.setForeground(AApplet_Sub3.aColor3779);
        var1.addItemListener(this);
        this.add(var1);
    }

    private void method523() {
        this.method524();
        this.anLobbyMultiContentPanel__2957.method791("waitreject");
    }

    private void method524() {
        this.aString2961 = null;
        this.aLobbyGameInfo_2962 = null;
        this.method525();
        this.repaint();
    }

    private void method525() {
        boolean var1 = !this.aBoolean2960 && this.method517();
        this.aRoundButton2963.setVisible(var1);
        this.aRoundButton2964.setVisible(var1);
        this.aNoChallCheckbox2965.setVisible(!this.aBoolean2960);
        this.aColorCheckbox2966.setVisible(!this.aBoolean2960 && !this.aClass58_Sub1_2956.aClass59_Sub1_3569.aBoolean3587);
    }

    static {
        aStringArray2968[0] = "Lobby2_Invite_";
        aStringArray2968[1] = "Challenged";
        aStringArray2968[2] = "Lobby2_Invite_WaitStateInfo";
        aStringArray2968[3] = "Invited";
        aStringArray2968[4] = "waitreject";
        aStringArray2968[5] = "Lobby2_Invite_Accept";
        aStringArray2968[6] = "Lobby2_Invite_BeepOnInvite";
        aStringArray2968[7] = "Lobby2_Invite_Reject";
        aStringArray2968[8] = "Lobby2_Invite_NoInvitesToMe";
        aStringArray2968[9] = "Lobby2_Join_WormCantJoinNonFreeTrackGame";
        aStringArray2968[10] = "waitaccept";
    }
}
