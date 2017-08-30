package com.aapeli.multiuser;

import com.aapeli.client.InputTextField;
import com.aapeli.client.StringDraw;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;
import com.aapeli.colorgui.ColorCheckbox;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class StaffActionFrame extends Frame implements WindowListener, ItemListener, KeyListener, ActionListener {

    private static final Color colourBackground = new Color(224, 224, 224);
    private static final Color colourBackground2 = new Color(208, 208, 208);
    private static final Color colourText = new Color(0, 0, 0);
    private static final String[] banPresetOptions = {"Presets...", "1 hour", "2 hours", "3 hours", "6 hours",
            "12 hours", "1 day", "2 days", "4 days", "~1 week"};
    private static final int[] banPresetTimes = new int[]{0, 60, 120, 180, 360, 720, 1440, 2880, 5760, 9999};
    private static final int banPresetTimesCount = banPresetOptions.length;
    private int width;
    private int height;
    private Insets insets;
    private TextManager textManager;
    private UserListHandler userListHandler;
    private int actionType;
    private String targetNick;
    private InputTextField textFieldNickname;
    private InputTextField textFieldMessage;
    private InputTextField textFieldBanTime;
    private ColorCheckbox cboxBan;
    private ColorCheckbox cboxAddIP;
    private Choice choiceDefaultMessages;
    private Choice choiceBanPresets;
    private ColorButton btnAction;
    private ColorButton btnCancel;


    protected StaffActionFrame(TextManager tm, UserListHandler ulh, int action, String tar) {
        this.textManager = tm;
        this.userListHandler = ulh;
        this.actionType = action;
        this.targetNick = tar;
        this.width = 420;
        this.height = 190;
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics g) {
        this.update(g);
    }

    public void update(Graphics g) {
        g.setColor(colourBackground);
        g.fillRect(0, 0, this.width, this.height);
        if (this.insets != null) {
            g.setColor(colourBackground2);
            g.fillRect(this.insets.left, this.insets.top, 420, 45);
            g.fillRect(this.insets.left, this.insets.top + 190 - 10 - 25 - 10, 420, 45);
        }

        g.setColor(colourText);
        if (this.actionType == 3) {
            StringDraw.drawStringWithMaxWidth(g, "Mute target user so none of his messages are visible to others. Muted user is not notified about this, therefore user may think that other people still see his messages. Mute will stay until user leave this gameserver and returns.", this.insets.left + 10, 100, -1, this.width - this.insets.right - 10 - this.insets.left - 10);
        }

        if (this.actionType == 4) {
            StringDraw.drawStringWithMaxWidth(g, "(Message is displayed to all users after chat is cleared. To avoid any confusion, it\'s highly recommended that some message is provided.)", this.insets.left + 10, 135, -1, this.width - this.insets.right - 10 - this.insets.left - 10);
        }

    }

    public void windowOpened(WindowEvent evt) {
    }

    public void windowClosed(WindowEvent evt) {
    }

    public void windowClosing(WindowEvent evt) {
        this.destroy();
    }

    public void windowActivated(WindowEvent evt) {
    }

    public void windowDeactivated(WindowEvent evt) {
    }

    public void windowIconified(WindowEvent evt) {
    }

    public void windowDeiconified(WindowEvent evt) {
    }

    public void itemStateChanged(ItemEvent evt) {
        Object evtSource = evt.getSource();
        if (evtSource == this.cboxBan) {
            this.btnAction.setLabel(this.cboxBan.getState() ? "Ban" : "Kick");
        } else {
            int selected;
            if (evtSource == this.choiceDefaultMessages) {
                selected = this.choiceDefaultMessages.getSelectedIndex();
                if (selected == 0) {
                    return;
                }

                String message = this.getDefaultMessages(selected);
                if (message != null) {
                    this.textFieldMessage.setText(message);
                }

                this.choiceDefaultMessages.select(0);
            } else if (evtSource == this.choiceBanPresets) {
                selected = this.choiceBanPresets.getSelectedIndex();
                if (selected == 0) {
                    return;
                }

                this.textFieldBanTime.setText("" + banPresetTimes[selected]);
                this.cboxBan.setState(true);
            }
        }

    }

    public void keyPressed(KeyEvent evt) {
        if (evt.getSource() == this.textFieldMessage && evt.getKeyCode() == 10) {
            this.sendAction();
        }

    }

    public void keyReleased(KeyEvent evt) {
    }

    public void keyTyped(KeyEvent evt) {
    }

    public void actionPerformed(ActionEvent evt) {
        Object var2 = evt.getSource();
        if (var2 == this.btnAction) {
            this.sendAction();
        }

        if (var2 == this.btnCancel) {
            this.destroy();
        }

    }

    protected void method251(Component var1, boolean var2) {
        String var3 = null;
        if (this.actionType == 1) {
            var3 = "Admin: Remove user";
        } else if (this.actionType == 2) {
            var3 = "Sheriff: Send message to user";
        } else if (this.actionType == 3) {
            var3 = "Sheriff: Mute user";
        } else if (this.actionType == 4) {
            var3 = "Sheriff: Clear chat of every user";
        } else if (this.actionType == 5) {
            var3 = "Admin: Broadcast message to all users";
        }

        this.setTitle(var3);
        this.setVisible(true);
        this.insets = this.getInsets();
        this.width = this.insets.left + 420 + this.insets.right;
        this.height = this.insets.top + 190 + this.insets.bottom;
        this.setSize(this.width, this.height);
        this.setResizable(false);
        Point var4 = var1.getLocationOnScreen();
        Dimension var5 = var1.getSize();
        this.setLocation(var4.x + var5.width / 2 - this.width / 2, var4.y + var5.height / 2 - this.height / 2);
        this.method252(this, true);
        this.setLayout((LayoutManager) null);
        String var6 = null;
        Label var7 = new Label("Target user:");
        var7.setBounds(this.insets.left + 10, this.insets.top + 10, 80, 25);
        this.method252(var7, false);
        this.add(var7);
        if (this.actionType == 1 || this.actionType == 2 || this.actionType == 3) {
            this.textFieldNickname = new InputTextField(this.targetNick, 32);
            this.textFieldNickname.setBounds(this.insets.left + 10 + 80 + 5, this.insets.top + 10, 150, 25);
            this.textFieldNickname.noClearOnFirstFocus();
            this.add(this.textFieldNickname);
        }

        Label var8;
        if (this.actionType == 4 || this.actionType == 5) {
            var8 = new Label(this.actionType == 4 ? "EVERY user in this lobby" : "All");
            var8.setBounds(this.insets.left + 10 + 80 + 5, this.insets.top + 10, 160, 25);
            this.method252(var8, false);
            this.add(var8);
        }

        if (this.actionType == 1) {
            this.cboxBan = new ColorCheckbox("Ban user, minutes:");
            int var10 = this.cboxBan.getPreferredSize().width;
            this.cboxBan.setBounds(this.insets.left + 10, this.insets.top + 10 + 25 + 20, var10, 20);
            this.method252(this.cboxBan, true);
            this.add(this.cboxBan);
            this.textFieldBanTime = new InputTextField("" + (var2 ? 360 : 180), 4);
            this.textFieldBanTime.setBounds(this.insets.left + 10 + var10 + 5, this.insets.top + 10 + 25 + 20, 50, 20);
            this.textFieldBanTime.noClearOnFirstFocus();
            this.add(this.textFieldBanTime);
            this.choiceBanPresets = new Choice();

            for (int var9 = 0; var9 < banPresetTimesCount; ++var9) {
                this.choiceBanPresets.addItem(banPresetOptions[var9]);
            }

            this.choiceBanPresets.setBounds(this.width - this.insets.right - 15 - 100, this.insets.top + 10 + 25 + 20, 100, 20);
            this.choiceBanPresets.setBackground(Color.white);
            this.choiceBanPresets.setForeground(Color.black);
            this.choiceBanPresets.select(0);
            this.choiceBanPresets.addItemListener(this);
            this.add(this.choiceBanPresets);
            var6 = "Kick";
        }

        if (this.actionType == 4 || this.actionType == 2 || this.actionType == 5) {
            var8 = new Label("Message:");
            var8.setBounds(this.insets.left + 10, this.insets.top + 10 + 25 + 20, 80, 25);
            this.method252(var8, true);
            this.add(var8);
            this.textFieldMessage = new InputTextField(var2 ? (this.actionType == 5 ? 1000 : 1500) : 500);
            this.textFieldMessage.setBounds(this.insets.left + 10 + 80 + 5, this.insets.top + 10 + 25 + 20, 315, 25);
            if (this.actionType == 4) {
                this.textFieldMessage.setText(this.textManager.getShared("SDM_ChatCleared"));
            }

            this.add(this.textFieldMessage);
        }

        if (this.actionType == 2) {
            var8 = new Label("Default messages:");
            var8.setBounds(this.insets.left + 10 + 80 + 5, this.insets.top + 10 + 25 + 20 + 5 + 25, 140, 23);
            this.method252(var8, true);
            this.add(var8);
            this.choiceDefaultMessages = new Choice();
            this.choiceDefaultMessages.addItem("Choose...");
            this.choiceDefaultMessages.addItem("Bad nickname");
            this.choiceDefaultMessages.addItem("Sex messages");
            this.choiceDefaultMessages.addItem("Cursing/Flooding");
            this.choiceDefaultMessages.setBounds(this.insets.left + 10 + 80 + 5 + 140 + 5, this.insets.top + 10 + 25 + 20 + 25 + 5, 170, 23);
            this.choiceDefaultMessages.setBackground(Color.white);
            this.choiceDefaultMessages.setForeground(Color.black);
            this.choiceDefaultMessages.select(0);
            this.choiceDefaultMessages.addItemListener(this);
            this.add(this.choiceDefaultMessages);
            this.cboxAddIP = new ColorCheckbox("Add target user IP to message");
            this.cboxAddIP.setBounds(this.insets.left + 10, this.insets.top + 10 + 25 + 20 + 25 + 5 + 25 + 5, 400, 20);
            this.method252(this.cboxAddIP, true);
            this.add(this.cboxAddIP);
            var6 = "Send";
        }

        if (this.actionType == 3) {
            var6 = "Mute";
        }

        if (this.actionType == 4) {
            var6 = "Clear";
        }

        if (this.actionType == 5) {
            var6 = "Broadcast";
        }

        this.btnAction = new ColorButton(var6);
        this.btnAction.setBounds(this.insets.left + 420 - 10 - 90 - 5 - 90, this.insets.top + 190 - 10 - 25, 90, 25);
        this.btnAction.setBackground(new Color(160, 160, 224));
        this.add(this.btnAction);
        this.btnCancel = new ColorButton("Cancel");
        this.btnCancel.setBounds(this.insets.left + 420 - 10 - 90, this.insets.top + 190 - 10 - 25, 90, 25);
        this.add(this.btnCancel);
        if (this.actionType == 1) {
            this.cboxBan.addItemListener(this);
        }

        if (this.actionType == 2 || this.actionType == 5) {
            this.textFieldMessage.addKeyListener(this);
        }

        this.btnAction.addActionListener(this);
        this.btnCancel.addActionListener(this);
        this.addWindowListener(this);
        this.toFront();
        this.requestFocus();
        this.repaint();
    }

    private void method252(Component var1, boolean var2) {
        var1.setBackground(var2 ? colourBackground : colourBackground2);
        var1.setForeground(colourText);
    }

    private String getDefaultMessages(int var1) {
        if (var1 == 1) {
            boolean var2 = false;
            String var3 = this.textFieldNickname.getInputText(false);
            if (var3.length() > 0 && var3.charAt(0) != 126) {
                var2 = true;
            }

            return this.textManager.getShared("SDM_BadNick" + (var2 ? "Reg" : "Worm"));
        } else {
            return var1 == 2 ? this.textManager.getShared("SDM_SexMessages") : (var1 == 3 ? this.textManager.getShared("SDM_BadMessages") : null);
        }
    }

    private void sendAction() {
        String targetNick;
        if (this.actionType == 1) {
            targetNick = this.textFieldNickname.getInputText(false);
            if (targetNick.length() > 0) {
                if (!this.cboxBan.getState()) {
                    this.userListHandler.adminCommand("kick", targetNick);
                } else {
                    int banTime;
                    try {
                        banTime = Integer.parseInt(this.textFieldBanTime.getInputText(false));
                    } catch (NumberFormatException var4) {
                        banTime = 0;
                    }

                    if (banTime <= 0) {
                        this.userListHandler.adminCommand("ban", targetNick);
                    } else {
                        this.userListHandler.adminCommand("ban", targetNick, "" + banTime);
                    }
                }
            }
        } else if (this.actionType == 2) {
            targetNick = this.textFieldNickname.getInputText(false);
            String message = this.textFieldMessage.getInputText(false);
            if (targetNick.length() > 0 && message.length() > 0) {
                this.userListHandler.adminCommand("message" + (this.cboxAddIP.getState() ? "ip" : ""), targetNick, message);
            }
        } else if (this.actionType == 3) {
            targetNick = this.textFieldNickname.getInputText(false);
            if (targetNick.length() > 0) {
                this.userListHandler.adminCommand("mute", targetNick);
            }
        } else if (this.actionType == 4) {
            targetNick = this.textFieldMessage.getInputText(false);
            if (targetNick.length() > 0) {
                this.userListHandler.adminCommand("clear", targetNick);
            }
        } else if (this.actionType == 5) {
            targetNick = this.textFieldMessage.getInputText(false);
            if (targetNick.length() > 0) {
                this.userListHandler.adminCommand("broadcast", targetNick);
            }
        }

        this.dispose();
    }

    private void destroy() {
        this.dispose();
    }
}
