package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.Class122;
import com.playray.client.InputTextField;
import com.playray.client.JFrame_Sub4_Sub2;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.GlossyButton;
import com.playray.tools.DelayRepaint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextArea;

class SPanel_Sub41 extends SPanel implements ActionListener, FocusListener {

    protected static final Color aColor4302;
    private static final Color aColor4303;
    private static final Color aColor4304;
    private static final Font aFont4305;
    private static final Font aFont4306;
    private static final Font aFont4307;
    private static final Font aFont4308;
    private static final Font aFont4309;
    private AApplet anAApplet4310;
    private Class122 aClass122_4311;
    private JFrame_Sub4_Sub2 aJFrame_Sub4_Sub2_4312;
    private InputTextField[] anInputTextFieldArray4313;
    private GlossyButton[] aGlossyButtonArray4314;
    private GlossyButton aGlossyButton4315;
    private JTextArea aJTextArea4316;
    private GlossyButton aGlossyButton4317;
    private GlossyButton aGlossyButton4318;
    private int anInt4319;
    private int anInt4320;
    private boolean aBoolean4321;
    private Object anObject4322;
    private static final String[] aStringArray4323 = new String[16];


    protected SPanel_Sub41(AApplet var1, Class122 var2, JFrame_Sub4_Sub2 var3) {
        this.anAApplet4310 = var1;
        this.aClass122_4311 = var2;
        this.aJFrame_Sub4_Sub2_4312 = var3;
        this.anObject4322 = new Object();
        this.setSize(500, 265);
        this.setBackground(aColor4302);
        this.method2815();
        this.anInt4319 = 0;
        this.aBoolean4321 = false;
        this.anInt4320 = 1;
        this.method2816((InputTextField) null);
    }

    public void paintContent(Graphics2D var1) {
        boolean var2 = false;
        Image var3 = this.anAApplet4310.anImageManager3822.getShared("background-light.png", true);
        if (var3 != null) {
            var1.drawImage(var3, 0, 0, this);
        } else {
            var1.setColor(aColor4302);
            var1.fillRect(0, 0, 500, 265);
            var2 = true;
        }

        var1.setColor(aColor4303);
        if (this.anInt4319 == 0) {
            var1.setFont(aFont4305);
            StringDraw.drawStringWithMaxWidth(var1, this.anAApplet4310.aTextManager3821.getShared("TellFriend_Info"), 10, 25, -1, 480);
            var1.setFont(aFont4306);
            StringDraw.drawStringWithMaxWidth(var1, this.anAApplet4310.aTextManager3821.getShared("TellFriend_EmailTitle"), 10, 90, -1, 480);
            var1.setFont(aFont4307);
            StringDraw.drawStringWithMaxWidth(var1, this.anAApplet4310.aTextManager3821.getShared("TellFriend_MessageTitle"), 200, 90, -1, 480);
        } else if (this.anInt4319 == 1) {
            var1.setFont(aFont4308);
            StringDraw.drawStringWithMaxWidth(var1, this.anAApplet4310.aTextManager3821.getShared("TellFriend_EmailSent"), 290, 122, 0, 340);
            var3 = this.anAApplet4310.anImageManager3822.getShared("tf-char-sent.gif", true);
            if (var3 != null) {
                var1.drawImage(var3, 40, 60, this);
            } else {
                var2 = true;
            }
        } else {
            var1.setFont(aFont4309);
            StringDraw.drawStringWithMaxWidth(var1, this.anAApplet4310.aTextManager3821.getShared("TellFriend_EmailNotSent"), 310, 92, 0, 340);
            var3 = this.anAApplet4310.anImageManager3822.getShared("tf-char-error.gif", true);
            if (var3 != null) {
                var1.drawImage(var3, 50, 120, this);
            } else {
                var2 = true;
            }
        }

        if (!this.aBoolean4321) {
            Image var4 = this.anAApplet4310.anImageManager3822.getShared("tf-btn-send.gif", true);
            Image var5 = this.anAApplet4310.anImageManager3822.getShared("tf-btn-close.gif", true);
            if (var4 != null && var5 != null) {
                this.aGlossyButton4317.setIconImage(var4);
                this.aGlossyButton4318.setIconImage(var5);
                this.aBoolean4321 = true;
            } else {
                var2 = true;
            }
        }

        if (var2) {
            new DelayRepaint(this);
        }

    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        Object var3 = this.anObject4322;
        synchronized (this.anObject4322) {
            if (var2 == this.aGlossyButton4315) {
                if (this.anInt4320 < 4) {
                    this.method2817(false);
                }

            } else {
                int var4;
                int var5;
                for (var4 = 0; var4 < 4; ++var4) {
                    if (var2 == this.anInputTextFieldArray4313[var4]) {
                        if (var4 < this.anInt4320) {
                            for (var5 = 0; var5 < this.anInt4320; ++var5) {
                                if (this.anInputTextFieldArray4313[var5].getInputText(false).length() == 0) {
                                    this.anInputTextFieldArray4313[var5].requestFocus();
                                    return;
                                }
                            }

                            if (this.anInt4320 < 4) {
                                this.method2817(true);
                            }
                        }

                        return;
                    }
                }

                int var6;
                for (var4 = 0; var4 < 4; ++var4) {
                    if (var2 == this.aGlossyButtonArray4314[var4]) {
                        if (this.anInt4320 > 1 && var4 < this.anInt4320) {
                            InputTextField var10 = this.anInputTextFieldArray4313[var4];

                            for (var6 = var4; var6 < 3; ++var6) {
                                this.anInputTextFieldArray4313[var6] = this.anInputTextFieldArray4313[var6 + 1];
                            }

                            this.anInputTextFieldArray4313[3] = this.method2818();
                            --this.anInt4320;
                            this.method2816(var10);
                        }

                        return;
                    }
                }

                if (var2 == this.aGlossyButton4317) {
                    String[] var9 = new String[this.anInt4320];
                    var5 = 0;

                    for (var6 = 0; var6 < this.anInt4320; ++var6) {
                        var9[var6] = this.anInputTextFieldArray4313[var6].getInputText(false);
                        if (this.method2819(var9[var6])) {
                            ++var5;
                        } else {
                            var9[var6] = null;
                        }
                    }

                    String var11 = this.aJTextArea4316.getText().trim();
                    if (var11.length() == 0) {
                        var11 = null;
                    }

                    if (var5 > 0) {
                        if (this.aClass122_4311.method1994(var9, var11, 79, 108, 97)) {
                            this.anInt4319 = 1;
                        } else {
                            this.anInt4319 = -1;
                        }

                        this.setVisible(false);
                        this.removeAll();
                        this.aGlossyButton4318.setColor(4);
                        this.add(this.aGlossyButton4318);
                        this.setVisible(true);
                        this.repaint();
                    }

                } else {
                    if (var2 == this.aGlossyButton4318) {
                        this.aJFrame_Sub4_Sub2_4312.close();
                    }

                }
            }
        }
    }

    public void focusGained(FocusEvent var1) {
    }

    public void focusLost(FocusEvent var1) {
        Object var2 = this.anObject4322;
        synchronized (this.anObject4322) {
            for (int var3 = 0; var3 < this.anInt4320; ++var3) {
                String var4 = this.anInputTextFieldArray4313[var3].getInputText(false);
                if (var4.length() > 0) {
                    this.anInputTextFieldArray4313[var3].setBackground(this.method2819(var4) ? Color.white : aColor4304);
                }
            }

        }
    }

    private void method2815() {
        this.anInputTextFieldArray4313 = new InputTextField[4];

        int var1;
        for (var1 = 0; var1 < 4; ++var1) {
            this.anInputTextFieldArray4313[var1] = this.method2818();
        }

        this.aGlossyButtonArray4314 = new GlossyButton[4];

        for (var1 = 0; var1 < 4; ++var1) {
            this.aGlossyButtonArray4314[var1] = new GlossyButton(this.anAApplet4310.aTextManager3821.getShared("TellFriend_EmailRemove"), 7);
            this.aGlossyButtonArray4314[var1].setSize(17, 17);
            this.aGlossyButtonArray4314[var1].addActionListener(this);
        }

        this.aGlossyButton4315 = new GlossyButton(this.anAApplet4310.aTextManager3821.getShared("TellFriend_EmailAdd"), 3);
        this.aGlossyButton4315.setSize(110, 20);
        this.aGlossyButton4315.addActionListener(this);
        this.aJTextArea4316 = new JTextArea("", 1, 1);
        this.aJTextArea4316.setBounds(200, 100, 290, 115);
        this.aJTextArea4316.setEditable(true);
        this.aJTextArea4316.setBackground(Color.white);
        this.aJTextArea4316.setForeground(Color.black);
        this.add(this.aJTextArea4316);
        this.aGlossyButton4317 = new GlossyButton(this.anAApplet4310.aTextManager3821.getShared("TellFriend_ButtonSend"), 1);
        this.aGlossyButton4317.setBounds(300, 230, 100, 25);
        this.aGlossyButton4317.addActionListener(this);
        this.add(this.aGlossyButton4317);
        this.aGlossyButton4318 = new GlossyButton(this.anAApplet4310.aTextManager3821.getShared("TellFriend_ButtonClose"), 2);
        this.aGlossyButton4318.setBounds(410, 230, 80, 25);
        this.aGlossyButton4318.addActionListener(this);
        this.add(this.aGlossyButton4318);
    }

    private void method2816(InputTextField var1) {
        this.setVisible(false);

        int var2;
        for (var2 = 0; var2 < 4; ++var2) {
            this.remove(this.anInputTextFieldArray4313[var2]);
            this.remove(this.aGlossyButtonArray4314[var2]);
        }

        this.remove(this.aGlossyButton4315);
        if (var1 != null) {
            this.remove(var1);
        }

        for (var2 = 0; var2 < this.anInt4320; ++var2) {
            this.anInputTextFieldArray4313[var2].setLocation(10, 100 + var2 * 30);
            this.add(this.anInputTextFieldArray4313[var2]);
        }

        if (this.anInt4320 > 1) {
            for (var2 = 0; var2 < this.anInt4320; ++var2) {
                this.aGlossyButtonArray4314[var2].setLocation(165, 100 + var2 * 30);
                this.add(this.aGlossyButtonArray4314[var2]);
            }
        }

        if (this.anInt4320 < 4) {
            this.aGlossyButton4315.setLocation(10, 100 + this.anInt4320 * 30);
            this.add(this.aGlossyButton4315);
        }

        this.setVisible(true);
    }

    private void method2817(boolean var1) {
        ++this.anInt4320;
        this.method2816((InputTextField) null);
        if (var1) {
            this.anInputTextFieldArray4313[this.anInt4320 - 1].requestFocus();
        }

    }

    private InputTextField method2818() {
        InputTextField var1 = new InputTextField(this.anAApplet4310.aTextManager3821.getShared("TellFriend_EmailHelp"), 60);
        var1.setBorderColor(Color.black);
        var1.setSize(150, 25);
        var1.addFocusListener(this);
        var1.addActionListener(this);
        return var1;
    }

    private boolean method2819(String var1) {
        int var2 = var1.indexOf(64);
        if (var2 == -1) {
            return false;
        } else {
            String var3 = var1.substring(0, var2);
            if (var3.length() == 0) {
                return false;
            } else {
                String var4 = var1.substring(var2 + 1);
                if (var4.indexOf(64) >= 0) {
                    return false;
                } else {
                    var2 = var4.lastIndexOf(46);
                    if (var2 == -1) {
                        return false;
                    } else {
                        var4 = var4.substring(var2 + 1);
                        int var5 = var4.length();
                        return var5 >= 2 && var5 <= 6;
                    }
                }
            }
        }
    }

    static {
        aStringArray4323[0] = "TellFriend_EmailHelp";
        aStringArray4323[1] = "tf-btn-close.gif";
        aStringArray4323[2] = "tf-char-error.gif";
        aStringArray4323[3] = "TellFriend_EmailNotSent";
        aStringArray4323[4] = "TellFriend_EmailSent";
        aStringArray4323[5] = "tf-char-sent.gif";
        aStringArray4323[6] = "TellFriend_Info";
        aStringArray4323[7] = "TellFriend_EmailTitle";
        aStringArray4323[8] = "tf-btn-send.gif";
        aStringArray4323[9] = "background-light.png";
        aStringArray4323[10] = "TellFriend_MessageTitle";
        aStringArray4323[11] = "TellFriend_ButtonClose";
        aStringArray4323[12] = "TellFriend_ButtonSend";
        aStringArray4323[13] = "TellFriend_EmailAdd";
        aStringArray4323[14] = "TellFriend_EmailRemove";
        aStringArray4323[15] = "Dialog";
        aColor4302 = new Color(240, 240, 240);
        aColor4303 = Color.black;
        aColor4304 = new Color(255, 224, 224);
        aFont4305 = new Font("Dialog", 0, 12);
        aFont4306 = new Font("Dialog", 0, 14);
        aFont4307 = new Font("Dialog", 0, 11);
        aFont4308 = new Font("Dialog", 0, 18);
        aFont4309 = new Font("Dialog", 0, 16);
    }
}
