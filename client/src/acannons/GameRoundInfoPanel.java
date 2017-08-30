package acannons;

import acannons.ClientSettings;
import acannons.GameApplet;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;

import java.awt.Graphics2D;

class GameRoundInfoPanel extends SPanel {

    private ClientSettings aClientSettings_3871;
    private int anInt3872;
    private int anInt3873;
    private int anInt3874;
    private int anInt3875;
    private static final String[] aStringArray3876 = new String[6];


    protected GameRoundInfoPanel(ClientSettings var1, int var2, int var3) {
        this.aClientSettings_3871 = var1;
        this.anInt3872 = var2;
        this.anInt3873 = var3;
        this.setSize(var2, var3);
        this.anInt3874 = this.anInt3875 = 0;
    }

    public void paintContent(Graphics2D var1) {
        if (this.anInt3874 > 0) {
            String var2;
            String var3;
            if (this.anInt3875 == 0) {
                var2 = this.aClientSettings_3871.textManager.method2039("GameInfo_Rounds");
                var3 = "" + this.anInt3874;
            } else {
                var2 = this.aClientSettings_3871.textManager.method2039("GameInfo_Round");
                var3 = this.anInt3875 + " / " + this.anInt3874;
            }

            var1.setColor(GameApplet.aColor4782);
            var1.setFont(GameApplet.fontDialog11);
            StringDraw.drawString(var1, var2, this.anInt3872 / 2, 12, 0);
            var1.setFont(GameApplet.fontDialog18);
            StringDraw.drawString(var1, var3, this.anInt3872 / 2, this.anInt3873 - 5, 0);
        }

    }

    protected boolean handlePacket(String[] var1) {
        if (var1[1].equals("gameinfo")) {
            this.anInt3874 = Integer.parseInt(var1[3]);
            this.repaint();
            return true;
        } else if (var1[1].equals("startgame")) {
            this.anInt3875 = 0;
            this.repaint();
            return true;
        } else if (var1[1].equals("startround")) {
            ++this.anInt3875;
            this.repaint();
            return true;
        } else {
            return false;
        }
    }

    static {
        aStringArray3876[0] = "GameInfo_Rounds";
        aStringArray3876[1] = " / ";
        aStringArray3876[2] = "GameInfo_Round";
        aStringArray3876[3] = "startgame";
        aStringArray3876[4] = "gameinfo";
        aStringArray3876[5] = "startround";
    }
}
