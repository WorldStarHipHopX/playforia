package acannons;

import com.playray.client.CharacterImage;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.GlossyButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameWaitPanel extends SPanel implements ActionListener {

    private static final Color aColor3905;
    private ClientSettings aClientSettings_3906;
    private GamePanel aSPanel__3907;
    private GlossyButton aGlossyButton3908;
    private boolean aBoolean3909;
    private boolean aBoolean3910;
    private int anInt3911;
    private int anInt3912;
    private int anInt3913;
    private String[] aStringArray3914;
    private String[] aStringArray3915;
    private CharacterImage[] aCharacterImageArray3916;
    private boolean[] aBooleanArray3917;
    private static final String[] aStringArray3918 = new String[14];


    protected GameWaitPanel(ClientSettings var1, GamePanel var2) {
        this.aClientSettings_3906 = var1;
        this.aSPanel__3907 = var2;
        this.setSize(720, 360);
        this.aBoolean3909 = false;
        this.aBoolean3910 = false;
        this.method2449();
    }

    public void paintContent(Graphics2D var1) {
        if (this.aBoolean3909) {
            byte var2 = 30;
            byte var3 = 40;
            var1.setFont(GameApplet.fontDialog12);
            var1.setColor(GameApplet.aColor4782);
            StringDraw.drawStringWithMaxWidth(var1, this.anInt3911 == 2 ? this.aClientSettings_3906.textManager.method2039("GameWait_Info2") : this.aClientSettings_3906.textManager.method2045("GameWait_InfoX", this.anInt3911), var2, var3, -1, 660);
            int var9 = var3 + 80;
            var1.setFont(GameApplet.fontDialog12);
            var1.setColor(GameApplet.aColor4782);
            int var8 = var2 + StringDraw.drawString(var1, this.aClientSettings_3906.textManager.method2039("GameWait_Players"), var2, var9, -1) + 40;
            int var4 = 0;
            byte var5 = 33;
            if (this.anInt3911 == 7) {
                var5 = 28;
            } else if (this.anInt3911 == 8) {
                var5 = 24;
            } else if (this.anInt3911 >= 9) {
                var5 = 20;
            }

            int var6;
            for (var6 = 0; var6 < this.anInt3911; ++var6) {
                var1.setFont(GameApplet.fontDialog12);
                var1.setColor(GameApplet.aColor4782);
                StringDraw.drawString(var1, var6 + 1 + ".", var8, var9 + var6 * var5, 1);
                int var7;
                if (this.aStringArray3914[var6] != null) {
                    var1.setFont(GameApplet.fontDialog14b);
                    var7 = StringDraw.drawString(var1, this.aStringArray3914[var6], var8 + 15 + 30 + 5 + 30 + 15, var9 + var6 * var5, -1);
                    if (this.aStringArray3915[var6] != null) {
                        var1.setFont(GameApplet.fontDialog14);
                        var7 += 15 + StringDraw.drawString(var1, this.aClientSettings_3906.textManager.method2040("GameWait_Clan", this.aStringArray3915[var6]), var8 + 15 + 30 + 5 + 30 + 15 + var7 + 15, var9 + var6 * var5, -1);
                    }

                    this.aCharacterImageArray3916[var6].draw(var1, var8 + 15 + var6 % 2 * 35, var9 + var6 * var5 - 20, this);
                } else {
                    var1.setFont(GameApplet.fontDialog14);
                    var1.setColor(aColor3905);
                    var7 = StringDraw.drawString(var1, this.aClientSettings_3906.textManager.method2039("GameWait_Waiting"), var8 + 15 + 30 + 5 + 30 + 15, var9 + var6 * var5, -1);
                }

                if (var7 > var4) {
                    var4 = var7;
                }
            }

            for (var6 = 0; var6 < this.anInt3911; ++var6) {
                var1.setFont(GameApplet.fontDialog12);
                var1.setColor(GameApplet.aColor4782);
                if (this.aBooleanArray3917[var6]) {
                    var1.drawString(this.aClientSettings_3906.textManager.method2039("GameWait_ReadyWithThesePlayers"), var8 + 15 + 30 + 5 + 30 + 15 + var4 + 20, var9 + var6 * var5);
                }
            }

            if (this.aGlossyButton3908.isVisible()) {
                var1.setFont(GameApplet.fontDialog12);
                var1.setColor(GameApplet.aColor4782);
                var1.drawString(this.aClientSettings_3906.textManager.method2039("GameWait_ClickToStart"), 30, 335);
            }
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (this.anInt3912 >= 2 && !this.aBoolean3910) {
            this.aSPanel__3907.method2424("readytostart");
            this.aBooleanArray3917[this.anInt3913] = true;
            this.aBoolean3910 = true;
            this.method2450();
        }
    }

    protected boolean handlePacket(String[] var1) {
        int var5;
        if (var1[1].equals("gameinfo")) {
            this.anInt3911 = Integer.parseInt(var1[2]);
            this.aStringArray3914 = new String[this.anInt3911];
            this.aStringArray3915 = new String[this.anInt3911];
            this.aCharacterImageArray3916 = new CharacterImage[this.anInt3911];
            this.aBooleanArray3917 = new boolean[this.anInt3911];

            for (var5 = 0; var5 < this.anInt3911; ++var5) {
                this.aStringArray3914[var5] = this.aStringArray3915[var5] = null;
                this.aCharacterImageArray3916[var5] = null;
                this.aBooleanArray3917[var5] = false;
            }

            return true;
        } else {
            int var3;
            if (var1[1].equals("players")) {
                this.anInt3912 = (var1.length - 2) / 4;

                for (var5 = 0; var5 < this.anInt3912; ++var5) {
                    var3 = Integer.parseInt(var1[2 + var5 * 4]);
                    this.aStringArray3914[var3] = var1[3 + var5 * 4];
                    this.aStringArray3915[var3] = this.aSPanel__3907.method2432(var1[4 + var5 * 4]);
                    this.aCharacterImageArray3916[var3] = this.aClientSettings_3906.gameApplet.method2285(var1[5 + var5 * 4]);
                }

                return true;
            } else {
                boolean var2 = var1[1].equals("owninfo");
                if (!var2 && !var1[1].equals("join")) {
                    if (!var1[1].equals("part")) {
                        if (var1[1].equals("readytostart")) {
                            this.aBooleanArray3917[Integer.parseInt(var1[2])] = true;
                            this.repaint();
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        var3 = Integer.parseInt(var1[2]);
                        this.aStringArray3914[var3] = this.aStringArray3915[var3] = null;
                        this.aCharacterImageArray3916[var3] = null;

                        for (int var4 = 0; var4 < this.anInt3911; ++var4) {
                            this.aBooleanArray3917[var4] = false;
                        }

                        --this.anInt3912;
                        this.aBoolean3910 = false;
                        this.method2450();
                        return true;
                    }
                } else {
                    var3 = Integer.parseInt(var1[2]);
                    if (var2) {
                        this.anInt3913 = var3;
                    }

                    this.aStringArray3914[var3] = var1[3];
                    this.aStringArray3915[var3] = this.aSPanel__3907.method2432(var1[4]);
                    this.aCharacterImageArray3916[var3] = this.aClientSettings_3906.gameApplet.method2285(var1[5]);
                    this.aBooleanArray3917[var3] = false;
                    ++this.anInt3912;
                    this.aBoolean3909 = true;
                    this.method2450();
                    return true;
                }
            }
        }
    }

    private void method2449() {
        this.aGlossyButton3908 = new GlossyButton(this.aClientSettings_3906.textManager.method2039("GameWait_ReadyToStart"), 3);
        this.aGlossyButton3908.setBounds(30 + StringDraw.getStringWidth((Component) this.aClientSettings_3906.gameApplet, GameApplet.fontDialog12, this.aClientSettings_3906.textManager.method2039("GameWait_ClickToStart")) + 15, 320, 120, 20);
        this.aGlossyButton3908.addActionListener(this);
        this.aGlossyButton3908.setVisible(false);
        this.add(this.aGlossyButton3908);
    }

    private void method2450() {
        boolean var1 = this.anInt3912 >= 2 && !this.aBoolean3910;
        if (var1 != this.aGlossyButton3908.isVisible()) {
            this.aGlossyButton3908.setVisible(var1);
        }

        this.repaint();
    }

    static {
        aStringArray3918[0] = "join";
        aStringArray3918[1] = "owninfo";
        aStringArray3918[2] = "part";
        aStringArray3918[3] = "readytostart";
        aStringArray3918[4] = "players";
        aStringArray3918[5] = "gameinfo";
        aStringArray3918[6] = "GameWait_Waiting";
        aStringArray3918[7] = "GameWait_Players";
        aStringArray3918[8] = "GameWait_ClickToStart";
        aStringArray3918[9] = "GameWait_InfoX";
        aStringArray3918[10] = "GameWait_Info2";
        aStringArray3918[11] = "GameWait_Clan";
        aStringArray3918[12] = "GameWait_ReadyWithThesePlayers";
        aStringArray3918[13] = "GameWait_ReadyToStart";
        aColor3905 = new Color(160, 160, 160);
    }
}
