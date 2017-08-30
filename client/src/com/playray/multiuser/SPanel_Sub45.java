package com.playray.multiuser;

import com.playray.client.InputTextField;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.client.TextManager;
import com.playray.colorgui.ColorButton;
import com.playray.colorgui.ColorCheckbox;
import com.playray.multiuser.JFrame_Sub6;
import com.playray.multiuser.UserListHandler;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;

class SPanel_Sub45 extends SPanel implements ItemListener, KeyListener, ActionListener {

    private static final Color aColor4588;
    private static final Color aColor4589;
    private static final Color aColor4590;
    private static final String[] aStringArray4591;
    private static final int[] anIntArray4592;
    private static final int anInt4593;
    private TextManager aTextManager4594;
    private UserListHandler anUserListHandler4595;
    private int anInt4596;
    private String aString4597;
    private JFrame_Sub6 aJFrame_Sub6_4598;
    private InputTextField anInputTextField4599;
    private InputTextField anInputTextField4600;
    private InputTextField anInputTextField4601;
    private ColorCheckbox aColorCheckbox4602;
    private ColorCheckbox aColorCheckbox4603;
    private JComboBox aJComboBox4604;
    private JComboBox aJComboBox4605;
    private ColorButton aColorButton4606;
    private ColorButton aColorButton4607;
    private static final String[] aStringArray4608 = new String[33];


    protected SPanel_Sub45(TextManager var1, UserListHandler var2, int var3, String var4, JFrame_Sub6 var5) {
        this.aTextManager4594 = var1;
        this.anUserListHandler4595 = var2;
        this.anInt4596 = var3;
        this.aString4597 = var4;
        this.aJFrame_Sub6_4598 = var5;
        this.setMainBackgroundColor(aColor4588);
        this.setSize(420, 190);
    }

    public void paintContent(Graphics2D var1) {
        var1.setColor(aColor4588);
        var1.fillRect(0, 0, 420, 190);
        var1.setColor(aColor4589);
        var1.fillRect(0, 0, 420, 45);
        var1.fillRect(0, 145, 420, 45);
        var1.setColor(aColor4590);
        if (this.anInt4596 == 3) {
            StringDraw.drawStringWithMaxWidth(var1, "Mute target user so none of his messages are visible to others. Muted user is not notified about this, therefore user may think that other people still see his messages. Mute will stay until user leave this gameserver and returns.", 10, 75, -1, 400);
        }

        if (this.anInt4596 == 4) {
            StringDraw.drawStringWithMaxWidth(var1, "(Message is displayed to all users after chat is cleared. To avoid any confusion, it\'s highly recommended that some message is provided.)", 10, 135, -1, 400);
        }

    }

    public Dimension getPreferredSize() {
        return new Dimension(420, 190);
    }

    public Dimension getMinimumSize() {
        return this.getPreferredSize();
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.method2946();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    public void itemStateChanged(ItemEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aColorCheckbox4602) {
            this.aColorButton4606.setLabel(this.aColorCheckbox4602.getState() ? "Ban" : "Kick");
        } else {
            int var3;
            if (var2 == this.aJComboBox4604) {
                var3 = this.aJComboBox4604.getSelectedIndex();
                if (var3 == 0) {
                    return;
                }

                String var4 = this.method2944(var3);
                if (var4 != null) {
                    this.anInputTextField4600.getTextField().setText(var4);
                }

                this.aJComboBox4604.setSelectedIndex(0);
            } else if (var2 == this.aJComboBox4605) {
                var3 = this.aJComboBox4605.getSelectedIndex();
                if (var3 == 0) {
                    return;
                }

                this.anInputTextField4601.getTextField().setText("" + anIntArray4592[var3]);
                this.aColorCheckbox4602.setState(true);
            }
        }

    }

    public void keyPressed(KeyEvent var1) {
        if (var1.getSource() == this.anInputTextField4600 && var1.getKeyCode() == 10) {
            this.method2945();
        }

    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyTyped(KeyEvent var1) {
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aColorButton4606) {
            this.method2945();
        } else if (var2 == this.aColorButton4607) {
            this.method2946();
        }

    }

    protected void method2941(boolean var1) {
        String var2 = null;
        Label var3 = new Label("Target user:");
        var3.setBounds(10, 10, 80, 25);
        this.method2943(var3, false);
        this.add(var3);
        if (this.anInt4596 == 1 || this.anInt4596 == 2 || this.anInt4596 == 3) {
            this.anInputTextField4599 = new InputTextField(this.aString4597, 32);
            this.anInputTextField4599.setBounds(95, 10, 150, 25);
            this.anInputTextField4599.noClearOnFirstFocus();
            this.add(this.anInputTextField4599);
        }

        Label var4;
        if (this.anInt4596 == 4 || this.anInt4596 == 5) {
            var4 = new Label(this.anInt4596 == 4 ? "EVERY user in this lobby" : "All");
            var4.setBounds(95, 10, 160, 25);
            this.method2943(var4, false);
            this.add(var4);
        }

        if (this.anInt4596 == 1) {
            this.aColorCheckbox4602 = new ColorCheckbox("Ban user, minutes:");
            int var6 = this.aColorCheckbox4602.getPreferredSize().width;
            this.aColorCheckbox4602.setBounds(10, 55, var6, 20);
            this.method2943(this.aColorCheckbox4602, true);
            this.add(this.aColorCheckbox4602);
            this.anInputTextField4601 = new InputTextField("" + (var1 ? 360 : 180), 4);
            this.anInputTextField4601.setBounds(10 + var6 + 5, 55, 50, 20);
            this.anInputTextField4601.noClearOnFirstFocus();
            this.add(this.anInputTextField4601);
            this.aJComboBox4605 = new JComboBox();

            for (int var5 = 0; var5 < anInt4593; ++var5) {
                this.aJComboBox4605.addItem(aStringArray4591[var5]);
            }

            this.aJComboBox4605.setBounds(305, 55, 100, 20);
            this.aJComboBox4605.setBackground(Color.white);
            this.aJComboBox4605.setForeground(Color.black);
            this.aJComboBox4605.setSelectedIndex(0);
            this.aJComboBox4605.addItemListener(this);
            this.add(this.aJComboBox4605);
            var2 = "Kick";
        }

        if (this.anInt4596 == 4 || this.anInt4596 == 2 || this.anInt4596 == 5) {
            var4 = new Label("Message:");
            var4.setBounds(10, 55, 80, 25);
            this.method2943(var4, true);
            this.add(var4);
            this.anInputTextField4600 = new InputTextField(var1 ? (this.anInt4596 == 5 ? 1000 : 1500) : 500);
            this.anInputTextField4600.setBounds(95, 55, 315, 25);
            if (this.anInt4596 == 4) {
                this.anInputTextField4600.getTextField().setText(this.aTextManager4594.getShared("SDM_ChatCleared"));
            }

            this.add(this.anInputTextField4600);
        }

        if (this.anInt4596 == 2) {
            var4 = new Label("Default messages:");
            var4.setBounds(95, 85, 140, 23);
            this.method2943(var4, true);
            this.add(var4);
            this.aJComboBox4604 = new JComboBox();
            this.aJComboBox4604.addItem("Choose...");
            this.aJComboBox4604.addItem("Bad nickname");
            this.aJComboBox4604.addItem("Sex messages");
            this.aJComboBox4604.addItem("Cursing/Flooding");
            this.aJComboBox4604.setBounds(240, 85, 170, 23);
            this.aJComboBox4604.setBackground(Color.white);
            this.aJComboBox4604.setForeground(Color.black);
            this.aJComboBox4604.setSelectedIndex(0);
            this.aJComboBox4604.addItemListener(this);
            this.add(this.aJComboBox4604);
            this.aColorCheckbox4603 = new ColorCheckbox("Add target user IP to message");
            this.aColorCheckbox4603.setBounds(10, 115, 400, 20);
            this.method2943(this.aColorCheckbox4603, true);
            this.add(this.aColorCheckbox4603);
            var2 = "Send";
        }

        if (this.anInt4596 == 3) {
            var2 = "Mute";
        }

        if (this.anInt4596 == 4) {
            var2 = "Clear";
        }

        if (this.anInt4596 == 5) {
            var2 = "Broadcast";
        }

        this.aColorButton4606 = new ColorButton(var2);
        this.aColorButton4606.setBounds(225, 155, 90, 25);
        this.aColorButton4606.setBackground(new Color(160, 160, 224));
        this.add(this.aColorButton4606);
        this.aColorButton4607 = new ColorButton("Cancel");
        this.aColorButton4607.setBounds(320, 155, 90, 25);
        this.add(this.aColorButton4607);
        if (this.anInt4596 == 1) {
            this.aColorCheckbox4602.addItemListener(this);
        }

        if (this.anInt4596 == 2 || this.anInt4596 == 5) {
            this.anInputTextField4600.addKeyListener(this);
        }

        this.aColorButton4606.addActionListener(this);
        this.aColorButton4607.addActionListener(this);
        this.repaint();
    }

    protected int method2942() {
        return this.anInt4596;
    }

    private void method2943(Component var1, boolean var2) {
        var1.setBackground(var2 ? aColor4588 : aColor4589);
        var1.setForeground(aColor4590);
    }

    private String method2944(int var1) {
        if (var1 == 1) {
            boolean var2 = false;
            String var3 = this.anInputTextField4599.getInputText(false);
            if (var3.length() > 0 && var3.charAt(0) != 126) {
                var2 = true;
            }

            return this.aTextManager4594.getShared("SDM_BadNick" + (var2 ? "Reg" : "Worm"));
        } else {
            return var1 == 2 ? this.aTextManager4594.getShared("SDM_SexMessages") : (var1 == 3 ? this.aTextManager4594.getShared("SDM_BadMessages") : null);
        }
    }

    private void method2945() {
        String var1;
        if (this.anInt4596 == 1) {
            var1 = this.anInputTextField4599.getInputText(false);
            if (var1.length() > 0) {
                if (!this.aColorCheckbox4602.getState()) {
                    this.anUserListHandler4595.adminCommand("kick", var1);
                } else {
                    int var2;
                    try {
                        var2 = Integer.parseInt(this.anInputTextField4601.getInputText(false));
                    } catch (NumberFormatException var4) {
                        var2 = 0;
                    }

                    if (var2 <= 0) {
                        this.anUserListHandler4595.adminCommand("ban", var1);
                    } else {
                        this.anUserListHandler4595.adminCommand("ban", var1, "" + var2);
                    }
                }
            }
        } else if (this.anInt4596 == 2) {
            var1 = this.anInputTextField4599.getInputText(false);
            String var5 = this.anInputTextField4600.getInputText(false);
            if (var1.length() > 0 && var5.length() > 0) {
                this.anUserListHandler4595.adminCommand("message" + (this.aColorCheckbox4603.getState() ? "ip" : ""), var1, var5);
            }
        } else if (this.anInt4596 == 3) {
            var1 = this.anInputTextField4599.getInputText(false);
            if (var1.length() > 0) {
                this.anUserListHandler4595.adminCommand("mute", var1);
            }
        } else if (this.anInt4596 == 4) {
            var1 = this.anInputTextField4600.getInputText(false);
            if (var1.length() > 0) {
                this.anUserListHandler4595.adminCommand("clear", var1);
            }
        } else if (this.anInt4596 == 5) {
            var1 = this.anInputTextField4600.getInputText(false);
            if (var1.length() > 0) {
                this.anUserListHandler4595.adminCommand("broadcast", var1);
            }
        }

        this.aJFrame_Sub6_4598.windowClosing((WindowEvent) null);
    }

    private void method2946() {
        this.aJFrame_Sub6_4598.windowClosing((WindowEvent) null);
    }

    static {
        aStringArray4608[0] = "Ban";
        aStringArray4608[1] = "Kick";
        aStringArray4608[2] = "kick";
        aStringArray4608[3] = "clear";
        aStringArray4608[4] = "mute";
        aStringArray4608[5] = "ban";
        aStringArray4608[6] = "broadcast";
        aStringArray4608[7] = "message";
        aStringArray4608[8] = "ip";
        aStringArray4608[9] = "Reg";
        aStringArray4608[10] = "SDM_BadNick";
        aStringArray4608[11] = "SDM_BadMessages";
        aStringArray4608[12] = "SDM_SexMessages";
        aStringArray4608[13] = "Worm";
        aStringArray4608[14] = "(Message is displayed to all users after chat is cleared. To avoid any confusion, it\'s highly recommended that some message is provided.)";
        aStringArray4608[15] = "Mute target user so none of his messages are visible to others. Muted user is not notified about this, therefore user may think that other people still see his messages. Mute will stay until user leave this gameserver and returns.";
        aStringArray4608[16] = "Ban user, minutes:";
        aStringArray4608[17] = "Clear";
        aStringArray4608[18] = "Add target user IP to message";
        aStringArray4608[19] = "Bad nickname";
        aStringArray4608[20] = "EVERY user in this lobby";
        aStringArray4608[21] = "Cancel";
        aStringArray4608[22] = "Mute";
        aStringArray4608[23] = "Message:";
        aStringArray4608[24] = "SDM_ChatCleared";
        aStringArray4608[25] = "Broadcast";
        aStringArray4608[26] = "Cursing/Flooding";
        aStringArray4608[27] = "Sex messages";
        aStringArray4608[28] = "All";
        aStringArray4608[29] = "Send";
        aStringArray4608[30] = "Target user:";
        aStringArray4608[31] = "Default messages:";
        aStringArray4608[32] = "Choose...";
        aColor4588 = new Color(208, 208, 208);
        aColor4589 = new Color(176, 176, 176);
        aColor4590 = new Color(0, 0, 0);
        aStringArray4591 = new String[10];
        aStringArray4591[0] = "Presets...";
        aStringArray4591[1] = "1 hour";
        aStringArray4591[2] = "2 hours";
        aStringArray4591[3] = "3 hours";
        aStringArray4591[4] = "6 hours";
        aStringArray4591[5] = "12 hours";
        aStringArray4591[6] = "1 day";
        aStringArray4591[7] = "2 days";
        aStringArray4591[8] = "4 days";
        aStringArray4591[9] = "~1 week";
        anIntArray4592 = new int[]{0, 60, 120, 180, 360, 720, 1440, 2880, 5760, 9999};
        anInt4593 = aStringArray4591.length;
    }

    private static char[] method2947(String var0) {
        char[] var10000 = var0.toCharArray();
        char[] var10001 = var10000;

        while (true) {
            int var10002 = var10001.length;
            var10001 = var10000;
            int var4 = var10002;
            if (var10002 >= 2) {
                break;
            }

            char[] var1 = var10001;
            int var2 = var4;
            var10000 = var1;
            char[] var10003 = var1;
            var10002 = var2;
            var10001 = var10003;
            if (var10002 != 0) {
                var10001 = var10000;
                boolean var3 = false;
                var10003[0] = (char) (var10003[0] ^ 33);
                break;
            }
        }

        return var10001;
    }

    private static String method2948(char[] var0) {
        int var10000 = var0.length;
        int var1 = 0;
        char[] var10001 = var0;
        if (var10000 > 1) {
            var10001 = var0;
            if (var10000 <= var1) {
                return (new String(var0)).intern();
            }
        }

        do {
            char[] var10002 = var10001;
            int var10003 = var1;

            while (true) {
                char var10004 = var10002[var10003];
                byte var10005;
                switch (var1 % 5) {
                    case 0:
                        var10005 = 31;
                        break;
                    case 1:
                        var10005 = 96;
                        break;
                    case 2:
                        var10005 = 59;
                        break;
                    case 3:
                        var10005 = 25;
                        break;
                    default:
                        var10005 = 33;
                }

                var10002[var10003] = (char) (var10004 ^ var10005);
                ++var1;
                if (var10000 != 0) {
                    break;
                }

                var10003 = var10000;
                var10002 = var10001;
            }
        } while (var10000 > var1);

        return (new String(var10001)).intern();
    }
}
