package apool;

import com.playray.client.SPanel;
import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.UserList;
import com.playray.multiuser.UserListHandler;
import com.playray.multiuser.UserListItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SPanel_Sub27 extends SPanel implements UserListHandler, ActionListener {

    private Class60 aClass60_2692;
    private SPanel_Sub26 aSPanel_Sub26_2693;
    private int anInt2694;
    private int anInt2695;
    private UserList anUserList2696;
    private GlossyButton aGlossyButton2697;


    protected SPanel_Sub27(Class60 var1, SPanel_Sub26 var2, int var3, int var4) {
        super(false);
        this.aClass60_2692 = var1;
        this.aSPanel_Sub26_2693 = var2;
        this.anInt2694 = var3;
        this.anInt2695 = var4;
        this.setSize(var3, var4);
    }

    public void openPlayerCard(String var1) {
        this.aClass60_2692.gameApplet.method2318(var1);
    }

    public void adminCommand(String var1, String var2) {
    }

    public void adminCommand(String var1, String var2, String var3) {
    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aGlossyButton2697) {
            UserListItem var2 = this.anUserList2696.getSelectedUser();
            if (var2 != null) {
                this.aSPanel_Sub26_2693.method2620(var2.getNick());
            }
        }

    }

    protected void method2623(boolean var1, boolean var2) {
        this.anUserList2696 = new UserList(this, this.aClass60_2692.textManager, this.aClass60_2692.imageManager, false, false, var1, this.anInt2694, this.anInt2695 - (var2 ? 22 : 0));
        this.anUserList2696.setLocation(0, 0);
        this.anUserList2696.setForeground(GameApplet.aColor4808);
        this.anUserList2696.enablePopUp(false, false);
        this.anUserList2696.setNickListTitle(this.aClass60_2692.textManager.method2039("GameSpectator_ListTitle"));
        this.anUserList2696.setAlpha(208);
        this.add(this.anUserList2696);
        if (var2) {
            this.aGlossyButton2697 = new GlossyButton(this.aClass60_2692.textManager.method2039("GameSpectator_KickBan"), 7);
            this.aGlossyButton2697.setBounds(0, this.anInt2695 - 20, this.anInt2694, 20);
            this.aGlossyButton2697.addActionListener(this);
            this.add(this.aGlossyButton2697);
        }

    }

    protected void method2624(UserListItem var1) {
        this.anUserList2696.addUser(var1);
    }

    protected UserListItem method2625(String var1) {
        return this.anUserList2696.getUser(var1);
    }

    protected void method2626(String var1) {
        this.anUserList2696.removeUser(var1);
    }
}
