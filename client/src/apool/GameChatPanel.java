package apool;

import com.playray.client.InputTextField;
import com.playray.client.SPanel;
import com.playray.client.UrlLabel;
import com.playray.colorgui.ColorCheckbox;
import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.ChatBase;
import com.playray.multiuser.ChatTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class GameChatPanel extends SPanel implements MouseListener, ActionListener {

    private Class60 aClass60_4075;
    private SPanel_Sub20_Sub1 aSPanel_Sub20_Sub1_4076;
    private boolean aBoolean4077;
    private int anInt4078;
    private int anInt4079;
    private ChatTextArea aChatTextArea4080;
    private InputTextField anInputTextField4081;
    private GlossyButton aGlossyButton4082;
    private ColorCheckbox aColorCheckbox4083;
    private long aLong4084;


    protected GameChatPanel(Class60 var1, SPanel_Sub20_Sub1 var2, boolean var3, int var4, int var5) {
        super(false);
        this.aClass60_4075 = var1;
        this.aSPanel_Sub20_Sub1_4076 = var2;
        this.aBoolean4077 = var3;
        this.anInt4078 = var4;
        this.anInt4079 = var5;
        this.setSize(var4, var5);
        this.setBackground(GameApplet.aColor4807);
        this.setForeground(GameApplet.aColor4808);
        this.addMouseListener(this);
        this.aLong4084 = 0L;
    }

    public void mouseEntered(MouseEvent var1) {
        long var2 = System.currentTimeMillis();
        if (var2 > this.aLong4084 + 100L && this.anInputTextField4081 != null) {
            this.anInputTextField4081.getTextField().requestFocus();
        }

        this.aLong4084 = var2;
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.anInputTextField4081 || var2 == this.aGlossyButton4082) {
            this.method2612();
        }

    }

    protected void method2604(boolean var1, boolean var2) {
        if (!this.aBoolean4077) {
            this.aChatTextArea4080 = new ChatTextArea(this.aClass60_4075.textManager, this.aClass60_4075.badWordFilter, this.anInt4078, this.anInt4079 - 22 - 1);
            this.aChatTextArea4080.setLocation(0, 0);
        } else {
            this.aChatTextArea4080 = new ChatTextArea(this.aClass60_4075.textManager, this.aClass60_4075.badWordFilter, this.anInt4078, this.anInt4079);
            this.aChatTextArea4080.setLocation(0, 0);
            this.method2607(this.aClass60_4075.textManager.method2039("GameChatMute_Reminder"));
            this.method2607(this.aClass60_4075.textManager.method2039("GameChatMute_NoteTextArea"));
            this.aChatTextArea4080.addLine();
        }

        this.aChatTextArea4080.setAlpha(208);
        this.add(this.aChatTextArea4080);
        if (!this.aBoolean4077) {
            this.anInputTextField4081 = new InputTextField(200, true);
            this.anInputTextField4081.setBounds(0, this.anInt4079 - 22, this.anInt4078 - 70 - 1, 22);
            this.anInputTextField4081.addActionListener(this);
            this.add(this.anInputTextField4081);
            this.aGlossyButton4082 = new GlossyButton(this.aClass60_4075.textManager.method2039("GameChat_Say"), 3);
            this.aGlossyButton4082.setBounds(this.anInt4078 - 70, this.anInt4079 - 22, 70, 22);
            this.aGlossyButton4082.addActionListener(this);
            this.add(this.aGlossyButton4082);
            this.method2605();
        }

        if (var2) {
            this.method2606();
        }

    }

    private void method2605() {
        byte var1 = 0;
        if (!this.aClass60_4075.gameApplet.method2309()) {
            var1 = 1;
        } else if (this.aClass60_4075.gameApplet.method2311()) {
            var1 = 2;
        }

        if (var1 != 0) {
            ChatBase.setInputByCIDR(var1, this, this.anInputTextField4081, this.aGlossyButton4082, (UrlLabel) null, this.aClass60_4075.textManager, this.aClass60_4075.params);
        }

    }

    protected void method2606() {
        if (!this.aBoolean4077) {
            this.anInputTextField4081.setBounds(0, this.anInt4079 - 22, this.anInt4078 - 130 - 2 - 70 - 1, 22);
            this.aGlossyButton4082.setBounds(this.anInt4078 - 130 - 2 - 70, this.anInt4079 - 22, 70, 22);
            this.aColorCheckbox4083 = new ColorCheckbox(this.aClass60_4075.textManager.method2039("GameChat_ToOpponentOnly"));
            this.aColorCheckbox4083.setBounds(this.anInt4078 - 130, this.anInt4079 - 21, 130, 20);
            this.aColorCheckbox4083.setForeground(GameApplet.aColor4808);
            this.add(this.aColorCheckbox4083);
        }
    }

    protected void method2607(String var1) {
        this.method2608(7, var1);
    }

    protected void method2608(int var1, String var2) {
        this.method2613(var1, this.aClass60_4075.textManager.method2040("GameChat_SystemMessage", var2));
    }

    protected void method2609(int var1, String var2, String var3, boolean var4) {
        if (this.aClass60_4075.badWordFilter != null && !var4) {
            var3 = this.aClass60_4075.badWordFilter.filter(var3);
        }

        if (var3.length() > 4 && var3.toLowerCase().startsWith("/me ")) {
            this.method2613(var1, this.aClass60_4075.textManager.method2041("GameChat_UserAction", var2, var3.substring(4)));
        } else {
            this.method2613(var1, this.aClass60_4075.textManager.method2041("GameChat_UserSay", var2, var3));
        }

    }

    protected void method2610(int var1, String var2, String var3, String var4, boolean var5) {
        if (this.aClass60_4075.badWordFilter != null && !var5) {
            var4 = this.aClass60_4075.badWordFilter.filter(var4);
        }

        this.method2613(var1, this.aClass60_4075.textManager.method2042("GameChat_UserSayPrivate", var2, var3, var4));
    }

    protected void method2611(String var1) {
        this.aChatTextArea4080.addBroadcastMessage(var1);
    }

    private void method2612() {
        String var1 = this.aSPanel_Sub20_Sub1_4076.method2551();
        String var2 = this.anInputTextField4081.getInputText();
        if (var1 != null && var2.length() > 0) {
            if (this.aColorCheckbox4083 != null && this.aColorCheckbox4083.getState()) {
                this.aSPanel_Sub20_Sub1_4076.method2524("sayoo\t" + var2);
                this.method2610(3, var1, this.aSPanel_Sub20_Sub1_4076.method2552(), var2, true);
                return;
            }

            this.aSPanel_Sub20_Sub1_4076.method2523("say\t" + var2);
            this.method2609(3, var1, var2, true);
        }

    }

    private void method2613(int var1, String var2) {
        this.aChatTextArea4080.addLine(var1, var2);
    }
}
