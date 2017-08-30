package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.RoundButton;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IPanel_Sub5 extends IPanel implements ActionListener {

    private Class58_Sub1 aClass58_Sub1_2948;
    private LobbyMultiContentPanel anLobbyMultiContentPanel__2949;
    private int anInt2950;
    private int anInt2951;
    private RoundButton aRoundButton2952;
    private RoundButton aRoundButton2953;
    private RoundButton aRoundButton2954;
    private static final String[] aStringArray2955 = new String[6];


    protected IPanel_Sub5(Class58_Sub1 var1, LobbyMultiContentPanel var2, int var3, int var4) {
        this.aClass58_Sub1_2948 = var1;
        this.anLobbyMultiContentPanel__2949 = var2;
        this.anInt2950 = var3;
        this.anInt2951 = var4;
        this.setSize(var3, var4);
        this.method514();
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aRoundButton2952) {
            if (this.aClass58_Sub1_2948.anAApplet_Sub3_Sub1_3567.method60()) {
                this.aClass58_Sub1_2948.anAApplet_Sub3_Sub1_3567.method54(0);
                this.anLobbyMultiContentPanel__2949.method791("toeditor");
            } else {
                this.aClass58_Sub1_2948.aSoundManager1189.playIllegal();
            }
        } else {
            this.aClass58_Sub1_2948.anAApplet_Sub3_Sub1_3567.method54(0);
            if (var2 == this.aRoundButton2953) {
                this.anLobbyMultiContentPanel__2949.method791("tosingle");
            } else if (var2 == this.aRoundButton2954) {
                this.aClass58_Sub1_2948.anAApplet_Sub3_Sub1_3567.method64(true);
            }
        }

    }

    private void method514() {
        this.setLayout((LayoutManager) null);
        this.aRoundButton2952 = this.method515("ToEditor", this.anInt2950 - 100 - 10 - 100 - 10 - 100, this.aClass58_Sub1_2948.anAApplet_Sub3_Sub1_3567.method60() ? AApplet_Sub3.aColor3784 : AApplet_Sub3.aColor3785);
        this.aRoundButton2953 = this.method515("ToSingleLobby", this.anInt2950 - 100 - 10 - 100, AApplet_Sub3.aColor3784);
        this.aRoundButton2954 = this.method515("Quit", this.anInt2950 - 100, AApplet_Sub3.aColor3783);
    }

    private RoundButton method515(String var1, int var2, Color var3) {
        RoundButton var4 = new RoundButton(this.aClass58_Sub1_2948.textManager.getGame("Lobby2_Header_" + var1));
        var4.setBounds(var2, 0, 100, this.anInt2951);
        var4.setBackground(var3);
        var4.addActionListener(this);
        this.add(var4);
        return var4;
    }

    static {
        aStringArray2955[0] = "tosingle";
        aStringArray2955[1] = "toeditor";
        aStringArray2955[2] = "Quit";
        aStringArray2955[3] = "ToSingleLobby";
        aStringArray2955[4] = "ToEditor";
        aStringArray2955[5] = "Lobby2_Header_";
    }
}
