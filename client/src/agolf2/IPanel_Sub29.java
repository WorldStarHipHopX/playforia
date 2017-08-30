package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.RoundButton;
import com.aapeli.multiuser.QuitConfirm;
import com.aapeli.multiuser.QuitHandler;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IPanel_Sub29 extends IPanel implements ActionListener, QuitHandler {

    private Class58_Sub1 aClass58_Sub1_2434;
    private IPanel_Sub28_Sub1 anIPanel_Sub28_Sub1_2435;
    private int anInt2436;
    private int anInt2437;
    private RoundButton aRoundButton2438;
    private RoundButton aRoundButton2439;
    private RoundButton aRoundButton2440;
    private RoundButton aRoundButton2441;
    private boolean aBoolean2442;
    private QuitConfirm aQuitConfirm2443;
    private static final String[] aStringArray2444 = new String[11];


    protected IPanel_Sub29(Class58_Sub1 var1, IPanel_Sub28_Sub1 var2, int var3, int var4) {
        this.aClass58_Sub1_2434 = var1;
        this.anIPanel_Sub28_Sub1_2435 = var2;
        this.anInt2436 = 115;
        this.anInt2437 = var4;
        this.setSize(this.anInt2436, var4);
        this.method721(var3);
        this.setBackground(var1.imageManager.getImage("background"));
        this.aBoolean2442 = false;
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aRoundButton2438) {
            this.remove(this.aRoundButton2438);
            this.anIPanel_Sub28_Sub1_2435.method693();
        } else if (var2 == this.aRoundButton2439) {
            this.remove(this.aRoundButton2439);
            if (!this.method724()) {
                this.anIPanel_Sub28_Sub1_2435.method694();
            }
        } else if (var2 == this.aRoundButton2440) {
            this.anIPanel_Sub28_Sub1_2435.method686();
        } else if (var2 == this.aRoundButton2441) {
            if (this.aClass58_Sub1_2434.aTournament3568 != null) {
                this.anIPanel_Sub28_Sub1_2435.method697(false);
            } else if (this.anIPanel_Sub28_Sub1_2435.method685() && this.anIPanel_Sub28_Sub1_2435.anIPanel_Sub31_3643.method743() > 1 && this.aBoolean2442) {
                this.method722();
            } else {
                this.userQuit();
            }
        }

    }

    public void userQuit() {
        this.method723();
        this.anIPanel_Sub28_Sub1_2435.method697(true);
    }

    public void userCancel() {
        this.method723();
    }

    protected void method714() {
        this.remove(this.aRoundButton2439);
        this.aBoolean2442 = true;
    }

    protected void method715(boolean var1, boolean var2) {
        if (!var1 && var2) {
            this.add(this.aRoundButton2438);
        }

    }

    protected void method716() {
        this.remove(this.aRoundButton2438);
        this.method719();
        this.aBoolean2442 = false;
    }

    protected void method717() {
        this.add(this.aRoundButton2438);
    }

    protected void method718() {
        this.remove(this.aRoundButton2438);
    }

    protected void method719() {
        if (this.anIPanel_Sub28_Sub1_2435.method685() && (this.anIPanel_Sub28_Sub1_2435.anIPanel_Sub31_3643.method742() == 1 || this.anIPanel_Sub28_Sub1_2435.anIPanel_Sub31_3643.method743() > 1) && !this.method724()) {
            this.add(this.aRoundButton2439);
        }

    }

    protected void method720() {
        this.remove(this.aRoundButton2439);
    }

    private void method721(int var1) {
        this.setLayout((LayoutManager) null);
        String var2;
        if (var1 == 0) {
            var2 = "Restart";
        } else if (var1 == 1) {
            var2 = "NextTrack";
        } else {
            var2 = "VoteSkipTrack";
        }

        this.aRoundButton2438 = new RoundButton(this.aClass58_Sub1_2434.textManager.getGame("Game_Control_" + var2));
        this.aRoundButton2438.setBounds(5, 5, this.anInt2436 - 10, 20);
        this.aRoundButton2438.setBackground(var1 == 0 ? AApplet_Sub3.colourButtonGreen : AApplet_Sub3.aColor3782);
        this.aRoundButton2438.addActionListener(this);
        this.aRoundButton2439 = new RoundButton(this.aClass58_Sub1_2434.textManager.getGame("Game_Control_NewGame"));
        this.aRoundButton2439.setBounds(5, 5, this.anInt2436 - 10, 20);
        this.aRoundButton2439.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton2439.addActionListener(this);
        this.aRoundButton2440 = new RoundButton(this.aClass58_Sub1_2434.textManager.getGame("Game_Control_Settings"));
        this.aRoundButton2440.setBounds(5, this.anInt2437 / 2 - 12, this.anInt2436 - 10, 25);
        this.aRoundButton2440.setBackground(AApplet_Sub3.aColor3784);
        this.aRoundButton2440.addActionListener(this);
        this.add(this.aRoundButton2440);
        String var3;
        if (this.aClass58_Sub1_2434.aTournament3568 != null) {
            var3 = this.aClass58_Sub1_2434.textManager.getShared("Tournament_QuitGameButton");
        } else {
            var3 = this.aClass58_Sub1_2434.textManager.getGame("Game_Control_BackTo" + (var1 == 0 ? "Editor" : "Lobby"));
        }

        this.aRoundButton2441 = new RoundButton(var3);
        this.aRoundButton2441.setBounds(5, this.anInt2437 - 5 - 20, this.anInt2436 - 10, 20);
        this.aRoundButton2441.setBackground(var1 == 0 ? AApplet_Sub3.aColor3782 : AApplet_Sub3.aColor3783);
        this.aRoundButton2441.addActionListener(this);
        this.add(this.aRoundButton2441);
    }

    private void method722() {
        this.method723();
        this.aQuitConfirm2443 = new QuitConfirm(this.aClass58_Sub1_2434.textManager, this);
        this.aQuitConfirm2443.open(this.aClass58_Sub1_2434.anAApplet_Sub3_Sub1_3567, true);
    }

    private void method723() {
        if (this.aQuitConfirm2443 != null) {
            this.aQuitConfirm2443.close();
            this.aQuitConfirm2443 = null;
            this.aClass58_Sub1_2434.anAApplet_Sub3_Sub1_3567.requestFocus();
        }
    }

    private boolean method724() {
        return this.aClass58_Sub1_2434.aTournament3568 == null ? false : !this.aClass58_Sub1_2434.aTournament3568.isActive();
    }

    static {
        aStringArray2444[0] = "VoteSkipTrack";
        aStringArray2444[1] = "Game_Control_NewGame";
        aStringArray2444[2] = "Lobby";
        aStringArray2444[3] = "NextTrack";
        aStringArray2444[4] = "Restart";
        aStringArray2444[5] = "Editor";
        aStringArray2444[6] = "Game_Control_";
        aStringArray2444[7] = "Tournament_QuitGameButton";
        aStringArray2444[8] = "Game_Control_BackTo";
        aStringArray2444[9] = "Game_Control_Settings";
        aStringArray2444[10] = "background";
    }
}
