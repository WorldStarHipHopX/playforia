package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.NickTextField;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.RoundButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class IPanel_Sub33 extends IPanel implements KeyListener, ActionListener {

    private static final Color aColor3146;
    private Class58 aClass58_3147;
    private int anInt3148;
    private int anInt3149;
    private NickTextField aNickTextField3150;
    private RoundButton aRoundButton3151;
    private RoundButton aRoundButton3152;
    private int anInt3153;
    private Image anImage3154;
    private Graphics aGraphics3155;
    private static final String[] aStringArray3156 = new String[19];


    public IPanel_Sub33(Class58 var1, int var2, int var3, int var4) {
        this.aClass58_3147 = var1;
        this.anInt3153 = var4;
        this.anInt3148 = var2;
        this.anInt3149 = var3;
        this.setSize(var2, var3);
        this.method755();
        this.setBackground(var1.imageManager.getImage("background"));
    }

    public void update(Graphics var1) {
        if (this.anImage3154 == null) {
            this.anImage3154 = this.createImage(this.anInt3148, this.anInt3149);
            this.aGraphics3155 = this.anImage3154.getGraphics();
        }

        this.drawBackground(this.aGraphics3155);
        byte var2 = 120;
        byte var3 = 120;
        this.aGraphics3155.setColor(AApplet_Sub3.aColor3779);
        this.aGraphics3155.setFont(AApplet_Sub3.fontDialog12);
        this.aGraphics3155.drawString(this.aClass58_3147.textManager.getShared("Login_EnterNick1"), var2, var3);
        this.aGraphics3155.drawString(this.aClass58_3147.textManager.getShared("Login_EnterNick2"), var2, var3 + 30);
        this.aGraphics3155.drawString(this.aClass58_3147.textManager.getShared("Login_EnterNick3"), var2, var3 + 50);
        this.aGraphics3155.drawString(this.aClass58_3147.textManager.getShared("Login_WantRegister1"), var2, var3 + 140);
        this.aGraphics3155.drawString(this.aClass58_3147.textManager.getShared("Login_WantRegister2"), var2, var3 + 162);
        this.aGraphics3155.setFont(AApplet_Sub3.fontDialog11);
        this.aGraphics3155.drawString(this.aClass58_3147.textManager.getShared("Login_RegBenefits1"), var2, var3 + 208);
        this.aGraphics3155.drawString(this.aClass58_3147.textManager.getShared("Login_RegBenefits2"), var2, var3 + 225);
        this.aGraphics3155.drawString(this.aClass58_3147.textManager.getShared("Login_RegBenefits3"), var2, var3 + 240);
        this.aGraphics3155.drawString(this.aClass58_3147.textManager.getShared("Login_RegBenefits4"), var2, var3 + 255);
        this.aGraphics3155.drawString(this.aClass58_3147.textManager.getShared("Login_RegBenefits5"), var2, var3 + 270);
        if (this.anInt3153 > 0) {
            String var4 = null;
            if (this.anInt3153 == 1) {
                var4 = this.aClass58_3147.textManager.getShared("Login_NeedNick");
            }

            if (this.anInt3153 == 2) {
                var4 = this.aClass58_3147.textManager.getShared("Login_NickTooShort");
            }

            if (this.anInt3153 == 3) {
                var4 = this.aClass58_3147.textManager.getShared("Login_NickTooLong");
            }

            if (this.anInt3153 == 4) {
                var4 = this.aClass58_3147.textManager.getShared("Login_ForbiddenNick");
            }

            if (this.anInt3153 == 5) {
                var4 = this.aClass58_3147.textManager.getShared("Login_NickInUse");
            }

            if (this.anInt3153 == 6) {
                var4 = this.aClass58_3147.textManager.getShared("Login_RegLoginFailed");
            }

            this.aGraphics3155.setFont(AApplet_Sub3.fontDialog12);
            this.aGraphics3155.setColor(aColor3146);
            this.aGraphics3155.drawString(var4, var2 + 230, var3 + 87);
        }

        var1.drawImage(this.anImage3154, 0, 0, this);
    }

    public void keyPressed(KeyEvent var1) {
        if (var1.getSource() == this.aNickTextField3150 && var1.getKeyCode() == 10) {
            this.method756();
        }

    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyTyped(KeyEvent var1) {
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aRoundButton3151) {
            this.method756();
        }

        if (var2 == this.aRoundButton3152) {
            this.aClass58_3147.gameApplet.method64(false);
        }

    }

    protected abstract void method754(String var1);

    private void method755() {
        this.setLayout((LayoutManager) null);
        byte var1 = 120;
        byte var2 = 120;
        this.aNickTextField3150 = new NickTextField(this.aClass58_3147.textManager, this.aClass58_3147.gameApplet.isDebug());
        this.aNickTextField3150.setBounds(var1, var2 + 70, 150, 25);
        this.aNickTextField3150.addKeyListener(this);
        this.add(this.aNickTextField3150);
        this.aRoundButton3151 = new RoundButton(this.aClass58_3147.textManager.getShared("Login_Ok"));
        this.aRoundButton3151.setBounds(var1 + 150 + 10, var2 + 70, 50, 25);
        this.aRoundButton3151.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton3151.addActionListener(this);
        this.add(this.aRoundButton3151);
        this.aRoundButton3152 = new RoundButton(this.aClass58_3147.textManager.getShared("Login_Quit"));
        this.aRoundButton3152.setBounds(var1 + StringDraw.getStringWidth((Component) this, AApplet_Sub3.fontDialog12, this.aClass58_3147.textManager.getShared("Login_WantRegister2")) + 10, var2 + 150, 60, 15);
        this.aRoundButton3152.setBackground(AApplet_Sub3.aColor3783);
        this.aRoundButton3152.addActionListener(this);
        this.add(this.aRoundButton3152);
        this.aNickTextField3150.requestFocus();
        this.repaint();
    }

    private boolean method756() {
        String var1 = this.aNickTextField3150.getNick();
        this.anInt3153 = 0;
        if (var1 == null) {
            int var2 = this.aNickTextField3150.getLastError();
            if (var2 == 1) {
                this.anInt3153 = 1;
            }

            if (var2 == 2) {
                this.anInt3153 = 2;
            }

            if (var2 == 3) {
                this.anInt3153 = 3;
            }

            if (var2 == 4 || var2 == 5) {
                this.anInt3153 = 4;
            }

            this.repaint();
            return false;
        } else {
            this.aClass58_3147.gameApplet.method54(0);
            this.method754(var1);
            return true;
        }
    }

    static {
        aStringArray3156[0] = "Login_WantRegister2";
        aStringArray3156[1] = "Login_Ok";
        aStringArray3156[2] = "Login_Quit";
        aStringArray3156[3] = "background";
        aStringArray3156[4] = "Login_RegBenefits4";
        aStringArray3156[5] = "Login_WantRegister1";
        aStringArray3156[6] = "Login_RegBenefits2";
        aStringArray3156[7] = "Login_EnterNick1";
        aStringArray3156[8] = "Login_RegBenefits3";
        aStringArray3156[9] = "Login_NeedNick";
        aStringArray3156[10] = "Login_RegBenefits5";
        aStringArray3156[11] = "Login_EnterNick2";
        aStringArray3156[12] = "Login_ForbiddenNick";
        aStringArray3156[13] = "Login_RegLoginFailed";
        aStringArray3156[14] = "Login_RegBenefits1";
        aStringArray3156[15] = "Login_NickInUse";
        aStringArray3156[16] = "Login_NickTooLong";
        aStringArray3156[17] = "Login_NickTooShort";
        aStringArray3156[18] = "Login_EnterNick3";
        aColor3146 = Color.RED;
    }
}
