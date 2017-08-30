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

public class SPanel_Sub24 extends SPanel implements ActionListener, MouseListener {

    private Class60 aClass60_4069;
    private LobbySelectHeaderPanel aSPanel__4070;
    private GlossyButton aGlossyButton4071;
    private GlossyButton aGlossyButton4072;
    private GlossyButton_Sub2_Sub2[] aGlossyButton_Sub2_Sub2Array4073;


    public SPanel_Sub24(Class60 var1, LobbySelectHeaderPanel var2) {
        this.aClass60_4069 = var1;
        this.aSPanel__4070 = var2;
        this.method2603();
        this.addMouseListener(this);
    }

    public void paintContent(Graphics2D var1) {
        boolean var2 = !this.aClass60_4069.gameApplet.method2309();
        var1.setFont(GameApplet.aFont4813);
        var1.setColor(GameApplet.aColor4808);
        StringDraw.drawString(var1, this.aClass60_4069.textManager.method2039("LobbySelect_SpTitle"), this.aClass60_4069.anInt1201 / 2, 65 - (var2 ? 40 : 0), 0);
        if (var2) {
            var1.setFont(GameApplet.aFont4816);
            var1.setColor(GameApplet.aColor4810);
            StringDraw.drawString(var1, this.aClass60_4069.textManager.method2039("LobbySelect_Sp_NoAccount"), this.aClass60_4069.anInt1201 / 2, 54, 0);
            StringDraw.drawString(var1, this.aClass60_4069.textManager.method2039("LobbySelect_Mp_AccountInfo"), this.aClass60_4069.anInt1201 / 2, 70, 0);
        }

        var1.setFont(LobbySelectHeaderPanel.aFont4040);
        var1.setColor(Color.white);
        short var3 = 140;
        byte var4 = 10;
        int var5 = this.aClass60_4069.anInt1201 / 2 - var3 / 2 - var4 - var3 - var4 - var3;
        byte var6 = 120;

        for (int var7 = 0; var7 < 5; ++var7) {
            var1.drawImage(this.aClass60_4069.imageManager.method1983("lobbyselect_sp-" + var7), var5, var6, this);
            StringDraw.drawString(var1, this.aClass60_4069.textManager.method2039("LSB_SpGame" + var7), var5 + var3 / 2, var6 + 140 - 13, 0);
            var5 += var4 + var3;
        }

    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aGlossyButton4071) {
            this.aClass60_4069.gameApplet.method2326();
        } else if (var2 == this.aGlossyButton4072) {
            this.aClass60_4069.gameApplet.method2325(false);
        } else {
            for (int var3 = 0; var3 < this.aGlossyButton_Sub2_Sub2Array4073.length; ++var3) {
                if (var2 == this.aGlossyButton_Sub2_Sub2Array4073[var3]) {
                    this.aSPanel__4070.method2591(this.aGlossyButton_Sub2_Sub2Array4073[var3]);
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
        int var4 = this.aClass60_4069.anInt1201 / 2 - var2 / 2 - var3 - var2 - var3 - var2;
        byte var5 = 120;
        int var6 = var1.getX();
        int var7 = var1.getY();
        if (var7 >= var5 && var7 < var5 + var2) {
            for (int var8 = 0; var8 < 5; ++var8) {
                if (var6 >= var4 && var6 < var4 + var2) {
                    this.aSPanel__4070.method2591(this.aGlossyButton_Sub2_Sub2Array4073[var8]);
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

    private void method2603() {
        boolean var1 = !this.aClass60_4069.gameApplet.method2309();
        short var2 = 140;
        byte var3 = 10;
        int var4 = this.aClass60_4069.anInt1201 / 2 - var2 / 2 - var3 - var2 - var3 - var2;
        int var5 = var4;
        int var6 = 267;
        this.aGlossyButton_Sub2_Sub2Array4073 = new GlossyButton_Sub2_Sub2[6];

        for (int var7 = 0; var7 < 6; ++var7) {
            String var8 = "LSB_Text_";
            if (var7 == 0) {
                var8 = var8 + "Pool";
            } else if (var7 == 5) {
                var8 = var8 + "Snooker";
            } else {
                var8 = var8 + "Start";
            }

            this.aGlossyButton_Sub2_Sub2Array4073[var7] = new GlossyButton_Sub2_Sub2(this.aClass60_4069.textManager.method2039(var8), var7);
            this.aGlossyButton_Sub2_Sub2Array4073[var7].setBounds(var5, var6, var2, 28);
            this.aGlossyButton_Sub2_Sub2Array4073[var7].addActionListener(this);
            if (var7 == 5 && var1) {
                this.aGlossyButton_Sub2_Sub2Array4073[var7].setEnabled(false);
            }

            this.add(this.aGlossyButton_Sub2_Sub2Array4073[var7]);
            var5 += var3 + var2;
            if (var7 == 4) {
                var5 = var4;
                var6 += 30;
            }
        }

        if (var1) {
            this.aGlossyButton4071 = new GlossyButton(this.aClass60_4069.textManager.method2039("LobbySelect_Mp_CreateAccountButton"), 3);
            this.aGlossyButton4071.setBounds(this.aClass60_4069.anInt1201 / 2 - 15 - 150, 85, 150, 25);
            this.aGlossyButton4071.addActionListener(this);
            this.add(this.aGlossyButton4071);
            this.aGlossyButton4072 = new GlossyButton(this.aClass60_4069.textManager.method2039("LobbySelect_Mp_LoginButton"), 3);
            this.aGlossyButton4072.setBounds(this.aClass60_4069.anInt1201 / 2 + 15, 85, 150, 25);
            this.aGlossyButton4072.addActionListener(this);
            this.add(this.aGlossyButton4072);
        }
    }
}
