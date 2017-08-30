package acannons;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

class GameSettingsFrame extends JFrame implements WindowListener {

    private ClientSettings clientSettings;
    private GamePanel gamePanel;
    private GameSettingsPanel gameSettingsPanel;
    private boolean aBoolean2250;
    private int anInt2251;

    protected GameSettingsFrame(ClientSettings var1, GamePanel var2, GameAreaPanel var3) {
        this.clientSettings = var1;
        this.gamePanel = var2;
        this.setIconImage(var1.imageManager.getShared("icon.png"));
        this.setTitle(var1.textManager.method2040("GameSettings_WindowTitle", var1.textManager.method2039("Localized_GameClientName")));
        this.gameSettingsPanel = new GameSettingsPanel(var1, this, var3);
        this.aBoolean2250 = true;
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.hideFrame();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    protected boolean handlePacket(String[] args) {
        if (args[1].equals("owninfo")) {
            this.anInt2251 = Integer.parseInt(args[2]);
            return true;
        } else if (args[1].equals("startgame")) {
            if (this.clientSettings.aPlayerInfo_764.aBoolean781) {
                this.gamePanel.method2430();
            }

            this.anInt2251 = Integer.parseInt(args[2]);
            return true;
        } else if (args[1].equals("startround")) {
            if (this.clientSettings.aPlayerInfo_764.aBoolean782) {
                this.gamePanel.method2430();
            }

            return true;
        } else if (args[1].equals("startturn")) {
            if (this.clientSettings.aPlayerInfo_764.aBoolean783 && Integer.parseInt(args[6]) == this.anInt2251) {
                this.gamePanel.method2430();
            }

            return true;
        } else {
            return false;
        }
    }

    protected void method2337() {
        if (this.isVisible()) {
            this.toFront();
        } else {
            this.setVisible(true);
            if (this.aBoolean2250) {
                this.aBoolean2250 = true;
                this.setBackground(GameApplet.aColor4781);
                this.setContentPane(this.gameSettingsPanel);
                this.pack();
                this.setResizable(false);
                Point var1 = this.clientSettings.gameApplet.getLocationOnScreen();
                Dimension var2 = this.clientSettings.gameApplet.getSize();
                this.setLocation(var1.x + var2.width / 2 - 150, var1.y + var2.height / 2 - 152 - 30);
                this.addWindowListener(this);
            }

            this.requestFocus();
        }
    }

    protected void hideFrame() {
        this.setVisible(false);
    }
}
