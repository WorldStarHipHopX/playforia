package apool;

import com.playray.client.SPanel;
import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.UserListItem;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SPanel_Sub26 extends SPanel implements ActionListener {

    private Class60 aClass60_4086;
    private SPanel_Sub20_Sub1 aSPanel_Sub20_Sub1_4087;
    private int anInt4088;
    private int anInt4089;
    private boolean aBoolean4090;
    private GlossyButton aGlossyButton4091;
    private SPanel_Sub27 aSPanel_Sub27_4092;
    private boolean aBoolean4093;


    protected SPanel_Sub26(Class60 var1, SPanel_Sub20_Sub1 var2, boolean var3, int var4, int var5) {
        this.aClass60_4086 = var1;
        this.aSPanel_Sub20_Sub1_4087 = var2;
        this.anInt4088 = var4;
        this.anInt4089 = var5;
        this.setSize(var4, var5);
        this.aBoolean4090 = var3;
        this.aBoolean4093 = true;
    }

    public void paintContent(Graphics2D var1) {
        if (this.aBoolean4093) {
            this.aBoolean4093 = false;
            GameApplet.method2302(var1, this.anInt4088, this.anInt4089, this);
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aGlossyButton4091) {
            this.remove(this.aGlossyButton4091);
            this.aGlossyButton4091 = null;
            this.repaint();
            this.aSPanel_Sub20_Sub1_4087.method2553();
        }

    }

    protected void method2614(boolean var1, boolean var2) {
        if (var1) {
            if (!var2) {
                this.method2621();
            } else {
                this.method2622(true);
            }
        } else {
            this.method2622(false);
        }

    }

    protected void method2615() {
        this.method2622(true);
    }

    protected void method2616() {
        if (this.aGlossyButton4091 != null) {
            this.remove(this.aGlossyButton4091);
        }
    }

    protected void method2617(String var1, boolean var2, boolean var3, boolean var4) {
        UserListItem var5 = new UserListItem(var1, var2, var3, var4, false);
        this.aSPanel_Sub27_4092.method2624(var5);
    }

    protected void method2618(String var1) {
        this.aSPanel_Sub27_4092.method2626(var1);
    }

    protected boolean method2619(String var1) {
        UserListItem var2 = this.aSPanel_Sub27_4092.method2625(var1);
        return var2 == null ? true : var2.isIgnore();
    }

    public void method2620(String var1) {
        this.aSPanel_Sub20_Sub1_4087.method2554(var1);
    }

    private void method2621() {
        this.aGlossyButton4091 = new GlossyButton(this.aClass60_4086.textManager.method2039("GameSpectator_Allow"), 1);
        this.aGlossyButton4091.setBounds(4, this.anInt4089 - 4 - 20, this.anInt4088 - 8, 20);
        this.aGlossyButton4091.addActionListener(this);
        this.add(this.aGlossyButton4091);
    }

    private void method2622(boolean var1) {
        this.aSPanel_Sub27_4092 = new SPanel_Sub27(this.aClass60_4086, var1 ? this : null, this.anInt4088 - 8, this.anInt4089 - 4 - 4);
        this.aSPanel_Sub27_4092.setLocation(4, 4);
        this.aSPanel_Sub27_4092.method2623(!this.aBoolean4090, var1 && !this.aBoolean4090);
        this.add(this.aSPanel_Sub27_4092);
        this.repaint();
    }

}
