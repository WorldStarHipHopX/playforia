package acannons;

import acannons.ClientSettings;
import com.playray.client.SPanel;
import com.playray.colorgui.GlossyButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LobbyControlPanel extends SPanel implements ActionListener {

    private ClientSettings aClientSettings_3919;
    private int height;
    private int width;
    private GlossyButton buttonQuit;
    private static final String aString3923 = "LobbyControl_QuitButton";


    protected LobbyControlPanel(ClientSettings var1, int var2, int var3) {
        super(false);
        this.aClientSettings_3919 = var1;
        this.height = var2;
        this.width = var3;
        this.setSize(var2, var3);
        this.create();
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == this.buttonQuit) {
            this.aClientSettings_3919.gameApplet.method2296();
        }

    }

    protected void create() {
        this.buttonQuit = new GlossyButton(this.aClientSettings_3919.textManager.method2039("LobbyControl_QuitButton"), 2);
        this.buttonQuit.setBounds(0, this.width - 20, this.height, 20);
        this.buttonQuit.addActionListener(this);
        this.add(this.buttonQuit);
    }

}
