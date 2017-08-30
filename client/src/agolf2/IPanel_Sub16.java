package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.RoundButton;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IPanel_Sub16 extends IPanel implements ActionListener {

    private Class58_Sub1 aClass58_Sub1_3001;
    private LobbySingleContentPanel anLobbySingleContentPanel__3002;
    private int anInt3003;
    private int anInt3004;
    private RoundButton aRoundButton3005;
    private RoundButton aRoundButton3006;
    private RoundButton aRoundButton3007;
    private static final String[] aStringArray3008 = new String[6];


    public IPanel_Sub16(Class58_Sub1 var1, LobbySingleContentPanel var2, int var3, int var4) {
        this.aClass58_Sub1_3001 = var1;
        this.anLobbySingleContentPanel__3002 = var2;
        this.anInt3003 = var3;
        this.anInt3004 = var4;
        this.setSize(var3, var4);
        this.method607();
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aRoundButton3005) {
            if (this.aClass58_Sub1_3001.anAApplet_Sub3_Sub1_3567.method60()) {
                this.aClass58_Sub1_3001.anAApplet_Sub3_Sub1_3567.method54(0);
                this.anLobbySingleContentPanel__3002.method791("toeditor");
            } else {
                this.aClass58_Sub1_3001.aSoundManager1189.playIllegal();
            }
        } else {
            this.aClass58_Sub1_3001.anAApplet_Sub3_Sub1_3567.method54(0);
            if (var2 == this.aRoundButton3006) {
                this.anLobbySingleContentPanel__3002.method791("tomulti");
            } else if (var2 == this.aRoundButton3007) {
                this.aClass58_Sub1_3001.anAApplet_Sub3_Sub1_3567.method64(true);
            }
        }

    }

    private void method607() {
        this.setLayout((LayoutManager) null);
        this.aRoundButton3005 = this.method608("ToEditor", this.anInt3003 - 100 - 10 - 100 - 10 - 100, this.aClass58_Sub1_3001.anAApplet_Sub3_Sub1_3567.method60() ? AApplet_Sub3.aColor3784 : AApplet_Sub3.aColor3785);
        this.aRoundButton3006 = this.method608("ToMultiLobby", this.anInt3003 - 100 - 10 - 100, AApplet_Sub3.aColor3784);
        this.aRoundButton3007 = this.method608("Quit", this.anInt3003 - 100, AApplet_Sub3.aColor3783);
    }

    private RoundButton method608(String var1, int var2, Color var3) {
        RoundButton var4 = new RoundButton(this.aClass58_Sub1_3001.textManager.getGame("Lobby1_Header_" + var1));
        var4.setBounds(var2, 0, 100, this.anInt3004);
        var4.setBackground(var3);
        var4.addActionListener(this);
        this.add(var4);
        return var4;
    }

    static {
        aStringArray3008[0] = "ToMultiLobby";
        aStringArray3008[1] = "ToEditor";
        aStringArray3008[2] = "Quit";
        aStringArray3008[3] = "toeditor";
        aStringArray3008[4] = "tomulti";
        aStringArray3008[5] = "Lobby1_Header_";
    }
}
