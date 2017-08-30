package apool;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.GlossyButton;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SPanel_Sub23 extends SPanel implements ActionListener, MouseListener {

    private Class60 aClass60_4061;
    private LobbySelectHeaderPanel aSPanel__4062;
    private GlossyButton aGlossyButton4063;
    private GlossyButton aGlossyButton4064;
    private GlossyButton_Sub2_Sub1[] aGlossyButton_Sub2_Sub1Array4065;
    private GlossyButton_Sub2_Sub1[] aGlossyButton_Sub2_Sub1Array4066;
    private LobbySelectRNOPSpammer aLobbySelectRNOPSpammer_4067;
    private static final String[] aStringArray4068 = new String[14];


    public SPanel_Sub23(Class60 var1, LobbySelectHeaderPanel var2) {
        this.aClass60_4061 = var1;
        this.aSPanel__4062 = var2;
        this.method2599();
        this.addMouseListener(this);
    }

    public void paintContent(Graphics2D var1) {
        boolean var2 = !this.aClass60_4061.gameApplet.method2309();
        var1.setFont(GameApplet.aFont4813);
        var1.setColor(GameApplet.aColor4808);
        StringDraw.drawString(var1, this.aClass60_4061.textManager.method2039("LobbySelect_MpTitle"), this.aClass60_4061.anInt1201 / 2, 65 - (var2 ? 40 : 0), 0);
        if (var2) {
            var1.setFont(GameApplet.aFont4816);
            var1.setColor(GameApplet.aColor4810);
            StringDraw.drawString(var1, this.aClass60_4061.textManager.method2039("LobbySelect_Mp_NoAccount"), this.aClass60_4061.anInt1201 / 2, 54, 0);
            StringDraw.drawString(var1, this.aClass60_4061.textManager.method2039("LobbySelect_Mp_AccountInfo"), this.aClass60_4061.anInt1201 / 2, 70, 0);
        }

        var1.setFont(LobbySelectHeaderPanel.aFont4040);
        var1.setColor(Color.white);
        short var3 = 140;
        byte var4 = 10;
        int var5 = this.aClass60_4061.anInt1201 / 2 - var3 / 2 - var4 - var3 - var4 - var3;
        byte var6 = 120;

        for (int var7 = 0; var7 < 5; ++var7) {
            var1.drawImage(this.aClass60_4061.imageManager.method1983("lobbyselect_mp-" + var7), var5, var6, this);
            StringDraw.drawString(var1, this.aClass60_4061.textManager.method2039("GameName_" + GameApplet.aStringArray4805[var7]), var5 + var3 / 2, var6 + 140 - 13, 0);
            var5 += var4 + var3;
        }

    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aGlossyButton4063) {
            this.method2598();
            this.aClass60_4061.gameApplet.method2326();
        } else if (var2 == this.aGlossyButton4064) {
            this.method2598();
            this.aClass60_4061.gameApplet.method2325(false);
        } else {
            for (int var3 = 0; var3 < this.aGlossyButton_Sub2_Sub1Array4065.length; ++var3) {
                if (var2 == this.aGlossyButton_Sub2_Sub1Array4065[var3]) {
                    this.aSPanel__4062.method2591(this.aGlossyButton_Sub2_Sub1Array4065[var3]);
                }
            }
        }

    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        short var2 = 140;
        byte var3 = 10;
        int var4 = this.aClass60_4061.anInt1201 / 2 - var2 / 2 - var3 - var2 - var3 - var2;
        byte var5 = 120;
        int var6 = var1.getX();
        int var7 = var1.getY();
        if (var7 >= var5 && var7 < var5 + var2) {
            for (int var8 = 0; var8 < 5; ++var8) {
                if (var6 >= var4 && var6 < var4 + var2) {
                    this.aSPanel__4062.method2591(this.aGlossyButton_Sub2_Sub1Array4066[var8]);
                    return;
                }

                var4 += var3 + var2;
            }
        }

    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    protected void method2596(String[] var1) {
        int var2;
        if (var1[1].equals("lobbylist")) {
            var2 = var1.length - 2;
            String[] var3 = new String[var2];
            int[] var4 = new int[var2];
            int[] var5 = new int[var2];
            boolean[] var6 = new boolean[var2];
            boolean[] var7 = new boolean[var2];

            for (int var8 = 0; var8 < var2; ++var8) {
                int var9 = var1[var8 + 2].indexOf(44);
                int var10 = var1[var8 + 2].indexOf(44, var9 + 1);
                int var11 = var1[var8 + 2].indexOf(44, var10 + 1);
                int var12 = var1[var8 + 2].indexOf(44, var11 + 1);
                var3[var8] = var1[var8 + 2].substring(0, var9);
                var4[var8] = Integer.parseInt(var1[var8 + 2].substring(var9 + 1, var10));
                var6[var8] = var1[var8 + 2].substring(var10 + 1, var11).equals("t");
                var5[var8] = Integer.parseInt(var1[var8 + 2].substring(var11 + 1, var12));
                var7[var8] = var1[var8 + 2].substring(var12 + 1).equals("t");
            }

            this.method2600(var2, var3, var4, var6, var5, var7);
        } else {
            if (var1[1].equals("nop")) {
                for (var2 = 0; var2 < this.aGlossyButton_Sub2_Sub1Array4065.length; ++var2) {
                    this.aGlossyButton_Sub2_Sub1Array4065[var2].method2877(Integer.parseInt(var1[2 + var2]));
                }
            }

        }
    }

    protected void method2597() {
        this.method2598();
        this.aLobbySelectRNOPSpammer_4067 = new LobbySelectRNOPSpammer(this);
    }

    protected void method2598() {
        if (this.aLobbySelectRNOPSpammer_4067 != null) {
            this.aLobbySelectRNOPSpammer_4067.method1546();
            this.aLobbySelectRNOPSpammer_4067 = null;
        }

    }

    private void method2599() {
        if (!this.aClass60_4061.gameApplet.method2309()) {
            this.aGlossyButton4063 = new GlossyButton(this.aClass60_4061.textManager.method2039("LobbySelect_Mp_CreateAccountButton"), 3);
            this.aGlossyButton4063.setBounds(this.aClass60_4061.anInt1201 / 2 - 15 - 150, 85, 150, 25);
            this.aGlossyButton4063.addActionListener(this);
            this.add(this.aGlossyButton4063);
            this.aGlossyButton4064 = new GlossyButton(this.aClass60_4061.textManager.method2039("LobbySelect_Mp_LoginButton"), 3);
            this.aGlossyButton4064.setBounds(this.aClass60_4061.anInt1201 / 2 + 15, 85, 150, 25);
            this.aGlossyButton4064.addActionListener(this);
            this.add(this.aGlossyButton4064);
        }
    }

    private void method2600(int var1, String[] var2, int[] var3, boolean[] var4, int[] var5, boolean[] var6) {
        short var7 = 140;
        byte var8 = 10;
        byte var9 = 30;
        int[] var10 = new int[5];
        int[] var11 = new int[5];

        int var12;
        for (var12 = 0; var12 < 5; ++var12) {
            var10[var12] = this.aClass60_4061.anInt1201 / 2 - var7 / 2 - var8 - var7 - var8 - var7 + (var7 + var8) * var12;
            var11[var12] = 267;
        }

        this.aGlossyButton_Sub2_Sub1Array4065 = new GlossyButton_Sub2_Sub1[var1];
        this.aGlossyButton_Sub2_Sub1Array4066 = new GlossyButton_Sub2_Sub1[5];

        for (var12 = 0; var12 < var1; ++var12) {
            this.aGlossyButton_Sub2_Sub1Array4065[var12] = new GlossyButton_Sub2_Sub1(this.aClass60_4061, this.method2601(var2[var12], var3[var12]), var12, var4[var12], var5[var12]);
            this.aGlossyButton_Sub2_Sub1Array4065[var12].setBounds(var10[var3[var12]], var11[var3[var12]], var7, 28);
            this.aGlossyButton_Sub2_Sub1Array4065[var12].addActionListener(this);
            this.add(this.aGlossyButton_Sub2_Sub1Array4065[var12]);
            var11[var3[var12]] += var9;
            if (this.aGlossyButton_Sub2_Sub1Array4066[var3[var12]] == null) {
                this.aGlossyButton_Sub2_Sub1Array4066[var3[var12]] = this.aGlossyButton_Sub2_Sub1Array4065[var12];
            }
        }

    }

    private String method2601(String var1, int var2) {
        String var3 = GameApplet.aStringArray4805[var2];
        String var4 = var1.substring(var3.length());
        return var4.length() > 0 ? (this.aClass60_4061.params.getSiteName().equalsIgnoreCase("facebook") && var4.equalsIgnoreCase("reg") ? this.aClass60_4061.textManager.method2039("LSB_Text_OpenToAll") : this.aClass60_4061.textManager.method2039("LSB_Text_" + var4)) : this.aClass60_4061.textManager.method2039("LSB_Text_OpenToAll");
    }

    protected void method2602() {
        this.aSPanel__4062.method2592("rnop");
    }

    static {
        aStringArray4068[0] = "reg";
        aStringArray4068[1] = "facebook";
        aStringArray4068[2] = "LSB_Text_";
        aStringArray4068[3] = "LSB_Text_OpenToAll";
        aStringArray4068[4] = "rnop";
        aStringArray4068[5] = "LobbySelect_Mp_LoginButton";
        aStringArray4068[6] = "LobbySelect_Mp_CreateAccountButton";
        aStringArray4068[7] = "LobbySelect_MpTitle";
        aStringArray4068[8] = "LobbySelect_Mp_AccountInfo";
        aStringArray4068[9] = "LobbySelect_Mp_NoAccount";
        aStringArray4068[10] = "lobbyselect_mp-";
        aStringArray4068[11] = "GameName_";
        aStringArray4068[12] = "nop";
        aStringArray4068[13] = "lobbylist";
    }
}
