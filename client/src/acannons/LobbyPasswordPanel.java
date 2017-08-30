package acannons;

import com.playray.client.InputTextField;
import com.playray.client.InputTextFieldListener;
import com.playray.client.SPanel;
import com.playray.colorgui.GlossyButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LobbyPasswordPanel extends SPanel implements InputTextFieldListener, ActionListener {

    private ClientSettings aClientSettings_3801;
    private LobbyCreateGamePanel aSPanel__3802;
    private int anInt3803;
    private InputTextField textFieldPassword;
    private GlossyButton buttonOk;
    private GlossyButton buttonCancel;

    protected LobbyPasswordPanel(ClientSettings var1, LobbyCreateGamePanel var2, int var3) {
        super(false);
        this.aClientSettings_3801 = var1;
        this.aSPanel__3802 = var2;
        this.anInt3803 = var3;
        this.setSize(200, 60);
        this.setBackground(var1.imageManager.method1983("bg-password"));
        this.create();
    }

    public void startedTyping() {
    }

    public void clearedField() {
    }

    public void enterPressed() {
        this.method2474();
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.buttonOk) {
            this.method2474();
        } else if (var2 == this.buttonCancel) {
            this.method2475();
        }

    }

    private void create() {
        this.textFieldPassword = new InputTextField(this.aClientSettings_3801.textManager.method2039("LobbyRealPassword_EnterPassword"), 15);
        this.textFieldPassword.setBounds(25, 7, 150, 22);
        this.textFieldPassword.addInputTextFieldListener(this);
        this.add(this.textFieldPassword);
        this.buttonOk = new GlossyButton(this.aClientSettings_3801.textManager.method2039("LobbyRealPassword_Ok"), 1);
        this.buttonOk.setBounds(25, 33, 50, 20);
        this.buttonOk.addActionListener(this);
        this.add(this.buttonOk);
        this.buttonCancel = new GlossyButton(this.aClientSettings_3801.textManager.method2039("LobbyRealPassword_Cancel"), 2);
        this.buttonCancel.setBounds(125, 33, 50, 20);
        this.buttonCancel.addActionListener(this);
        this.add(this.buttonCancel);
    }

    private void method2474() {
        String var1 = this.textFieldPassword.getTextField().getText().trim();
        if (var1.length() == 0) {
            this.method2475();
        } else {
            this.aSPanel__3802.method2458(this.anInt3803, var1);
        }
    }

    private void method2475() {
        this.aSPanel__3802.method2458(this.anInt3803, (String) null);
    }
}
