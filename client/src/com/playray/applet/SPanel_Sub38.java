package com.playray.applet;

import com.playray.applet.AApplet;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.ColorButton;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

final class SPanel_Sub38 extends SPanel implements ActionListener {

    private static final Font aFont4239;
    private static final Font aFont4240;
    private static final Font aFont4241;
    private static final Font aFont4242;
    private AApplet anAApplet4243;
    private int anInt4244;
    private boolean aBoolean4245;
    private boolean aBoolean4246;
    private String aString4247;
    private Throwable aThrowable4248;
    private Image anImage4249;
    private long aLong4250;
    private ColorButton aColorButton4251;
    private static final String[] aStringArray4252 = new String[42];


    protected SPanel_Sub38(AApplet var1) {
        this.anAApplet4243 = var1;
        this.setBackground(var1.getBackground());
        this.setForeground(var1.getForeground());
        this.anInt4244 = 0;
        this.aBoolean4245 = false;
        this.aBoolean4246 = false;
        this.aString4247 = null;
        this.aThrowable4248 = null;
    }

    public void paintContent(Graphics2D var1) {
        if (!this.anAApplet4243.isDestroy()) {
            if (this.anImage4249 != null) {
                var1.drawImage(this.anImage4249, 0, 0, this);
            } else if (this.anAApplet4243.aTextManager3821 != null) {
                var1.setColor(this.getForeground());
                Color var2 = this.aBoolean4245 ? this.getBackground() : null;
                int var3 = this.anAApplet4243.getEndState();
                if (var3 == 2) {
                    byte var4 = -20;
                    var1.setFont(aFont4239);
                    StringDraw.drawOutlinedString(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_CE_ConnectionError"), 40, 80 + var4, -1);
                    var1.setFont(aFont4241);
                    StringDraw.drawOutlinedString(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_CE_PossibleReasons"), 40, 125 + var4, -1);
                    if (!this.aBoolean4246) {
                        var1.setFont(aFont4241);
                        StringDraw.drawOutlinedString(var1, var2, "- " + this.anAApplet4243.aTextManager3821.getShared("Message_CE0_1_Short"), 40, 160 + var4, -1);
                        var1.setFont(aFont4242);
                        StringDraw.drawOutlinedStringWithMaxWidth(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_CE0_1_Long", this.anAApplet4243.param.getServerIp(), "" + this.anAApplet4243.param.getServerPort()), 50, 180 + var4, -1, this.anAApplet4243.anInt2601 - 50 - 50);
                        var1.setFont(aFont4241);
                        StringDraw.drawOutlinedString(var1, var2, "- " + this.anAApplet4243.aTextManager3821.getShared("Message_CE0_2_Short"), 40, 245 + var4, -1);
                        var1.setFont(aFont4242);
                        StringDraw.drawOutlinedStringWithMaxWidth(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_CE0_2_Long"), 50, 265 + var4, -1, this.anAApplet4243.anInt2601 - 50 - 50);
                        var1.setFont(aFont4241);
                        StringDraw.drawOutlinedString(var1, var2, "- " + this.anAApplet4243.aTextManager3821.getShared("Message_CE0_3_Short"), 40, 305 + var4, -1);
                        var1.setFont(aFont4242);
                        StringDraw.drawOutlinedStringWithMaxWidth(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_CE0_3_Long"), 50, 325 + var4, -1, this.anAApplet4243.anInt2601 - 50 - 50);
                    } else {
                        var1.setFont(aFont4241);
                        StringDraw.drawOutlinedString(var1, var2, "- " + this.anAApplet4243.aTextManager3821.getShared("Message_CE1_1_Short"), 40, 160 + var4, -1);
                        var1.setFont(aFont4242);
                        StringDraw.drawOutlinedStringWithMaxWidth(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_CE1_1_Long"), 50, 180 + var4, -1, this.anAApplet4243.anInt2601 - 50 - 50);
                        var1.setFont(aFont4241);
                        StringDraw.drawOutlinedString(var1, var2, "- " + this.anAApplet4243.aTextManager3821.getShared("Message_CE1_2_Short"), 40, 235 + var4, -1);
                        var1.setFont(aFont4242);
                        StringDraw.drawOutlinedStringWithMaxWidth(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_CE1_2_Long"), 50, 255 + var4, -1, this.anAApplet4243.anInt2601 - 50 - 50);
                        var1.setFont(aFont4241);
                        StringDraw.drawOutlinedString(var1, var2, "- " + this.anAApplet4243.aTextManager3821.getShared("Message_CE1_3_Short"), 40, 305 + var4, -1);
                        var1.setFont(aFont4242);
                        StringDraw.drawOutlinedStringWithMaxWidth(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_CE1_3_Long"), 50, 325 + var4, -1, this.anAApplet4243.anInt2601 - 50 - 50);
                    }
                } else if (var3 == 14) {
                    var1.setFont(aFont4239);
                    StringDraw.drawOutlinedString(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_PE_ProgramError"), 50, 100, -1);
                    var1.setFont(aFont4241);
                    StringDraw.drawOutlinedStringWithMaxWidth(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_PE_GameClosed"), 50, 150, -1, this.anAApplet4243.anInt2601 - 70 - 50);
                    var1.setFont(aFont4240);
                    StringDraw.drawOutlinedString(var1, var2, this.anAApplet4243.aTextManager3821.getShared("Message_PE_ErrorDesc", this.aThrowable4248.toString()), 50, 235, -1);
                } else {
                    String var6 = this.anAApplet4243.aTextManager3821.getShared("Message_WaitWhile");
                    String var5 = null;
                    if (var3 == 1) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Match_MessageError");
                        var5 = this.anAApplet4243.aTextManager3821.getShared("Match_MessageErrorHelp");
                    } else if (var3 == 3) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Message_VersionError");
                        var5 = this.anAApplet4243.aTextManager3821.getShared("Message_VersionErrorHelp");
                    } else if (var3 == 4) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Message_ServerFullError");
                        var5 = this.anAApplet4243.aTextManager3821.getShared("Message_ServerFullErrorHelp");
                    } else if (var3 == 5) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Message_QuitGame");
                    } else if (var3 == 7) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Message_QuitGame_ToRegister");
                    } else if (var3 == 8) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Message_QuitGame_ToBuyCoins");
                    } else if (var3 == 6) {
                        var6 = this.aString4247;
                    } else if (var3 == 9) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Message_KickedNow");
                        var5 = this.anAApplet4243.aTextManager3821.getShared("Message_KickedNowHelp");
                    } else if (var3 == 10) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Message_BannedNow");
                        var5 = this.anAApplet4243.aTextManager3821.getShared("Message_BannedNowHelp");
                    } else if (var3 == 11) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Message_BannedInitially");
                        var5 = this.anAApplet4243.aTextManager3821.getShared("Message_BannedInitiallyHelp");
                    } else if (var3 == 12) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Message_LoginFailedReg");
                        var5 = this.anAApplet4243.aTextManager3821.getShared("Message_LoginFailedRegHelp");
                    } else if (var3 == 13) {
                        var6 = this.anAApplet4243.aTextManager3821.getShared("Message_TooManySameIP");
                        var5 = this.anAApplet4243.aTextManager3821.getShared("Message_TooManySameIPHelp");
                    }

                    var1.setFont(aFont4239);
                    if (this.anInt4244 == 0) {
                        StringDraw.drawOutlinedString(var1, var2, var6, this.anAApplet4243.anInt2601 / 2, this.anAApplet4243.anInt2602 / 2 - 10, 0);
                    } else if (this.anInt4244 == 1) {
                        StringDraw.drawOutlinedString(var1, var2, var6, this.anAApplet4243.anInt2601 / 12, this.anAApplet4243.anInt2602 - 120, -1);
                    } else if (this.anInt4244 == 2) {
                        StringDraw.drawOutlinedString(var1, var2, var6, this.anAApplet4243.anInt2601 / 2, this.anAApplet4243.anInt2602 - 120, 0);
                    }

                    if (var5 != null) {
                        var1.setFont(aFont4241);
                        if (this.anInt4244 == 0) {
                            StringDraw.drawOutlinedStringWithMaxWidth(var1, var2, var5, this.anAApplet4243.anInt2601 / 2, this.anAApplet4243.anInt2602 / 2 + 30, 0, (int) ((double) this.anAApplet4243.anInt2601 * 0.8D));
                        } else if (this.anInt4244 == 1) {
                            StringDraw.drawOutlinedStringWithMaxWidth(var1, var2, var5, this.anAApplet4243.anInt2601 / 12, this.anAApplet4243.anInt2602 - 80, -1, (int) ((double) this.anAApplet4243.anInt2601 * 0.6D));
                        } else if (this.anInt4244 == 2) {
                            StringDraw.drawOutlinedStringWithMaxWidth(var1, var2, var5, this.anAApplet4243.anInt2601 / 2, this.anAApplet4243.anInt2602 - 80, 0, (int) ((double) this.anAApplet4243.anInt2601 * 0.5D));
                        }
                    }
                }
            }

        }
    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aColorButton4251) {
            try {
                String var2 = this.anAApplet4243.getDocumentBase().toString();
                if (var2.indexOf(63) == -1) {
                    var2 = var2 + "?retry=1";
                } else if (var2.indexOf("retry=") == -1) {
                    var2 = var2 + "&retry=1";
                }

                this.anAApplet4243.getAppletContext().showDocument(new URL(var2));
            } catch (Exception var3) {
                this.aColorButton4251.setVisible(false);
            }
        }

    }

    protected void method2797(int var1) {
        this.anInt4244 = var1;
        this.repaint();
    }

    public void setTextOutline(boolean var1) {
        this.aBoolean4245 = var1;
        this.repaint();
    }

    protected void method2798() {
        this.aBoolean4246 = true;
    }

    protected void method2799(String var1) {
        this.aString4247 = var1;
        this.repaint();
    }

    protected void method2800(Throwable var1) {
        this.aThrowable4248 = var1;
        this.repaint();
    }

    protected void method2801(Image var1) {
        this.anImage4249 = var1;
        this.aLong4250 = System.currentTimeMillis();
    }

    protected void method2802(int var1, boolean var2) {
        if (this.anImage4249 != null) {
            long var3 = this.aLong4250 + (long) var1;

            while (System.currentTimeMillis() < var3) {
                Tools.sleep(100L);
            }

            this.anImage4249 = null;
            if (!var2) {
                this.repaint();
            }

        }
    }

    protected void method2803() {
        this.anImage4249 = null;
        this.repaint();
    }

    protected void method2804(String var1, int var2) {
        this.aColorButton4251 = new ColorButton(this.anAApplet4243.aTextManager3821.getShared(var1));
        this.aColorButton4251.setBounds(var2, 360, 120, 20);
        this.aColorButton4251.addActionListener(this);
        this.add(this.aColorButton4251);
        this.repaint();
    }

    static {
        aStringArray4252[0] = "retry=";
        aStringArray4252[1] = "?retry=1";
        aStringArray4252[2] = "&retry=1";
        aStringArray4252[3] = "Message_CE1_3_Long";
        aStringArray4252[4] = "Message_CE0_1_Long";
        aStringArray4252[5] = "Message_VersionError";
        aStringArray4252[6] = "Message_BannedInitiallyHelp";
        aStringArray4252[7] = "Message_KickedNowHelp";
        aStringArray4252[8] = "Message_VersionErrorHelp";
        aStringArray4252[9] = "Message_CE0_2_Long";
        aStringArray4252[10] = "Message_QuitGame_ToBuyCoins";
        aStringArray4252[11] = "Message_TooManySameIPHelp";
        aStringArray4252[12] = "Message_CE1_3_Short";
        aStringArray4252[13] = "Message_LoginFailedReg";
        aStringArray4252[14] = "Message_KickedNow";
        aStringArray4252[15] = "Message_LoginFailedRegHelp";
        aStringArray4252[16] = "Message_ServerFullErrorHelp";
        aStringArray4252[17] = "Message_CE1_2_Long";
        aStringArray4252[18] = "- ";
        aStringArray4252[19] = "Message_PE_ErrorDesc";
        aStringArray4252[20] = "Message_CE_PossibleReasons";
        aStringArray4252[21] = "Message_QuitGame";
        aStringArray4252[22] = "Message_CE0_3_Short";
        aStringArray4252[23] = "Message_TooManySameIP";
        aStringArray4252[24] = "Message_CE1_1_Long";
        aStringArray4252[25] = "Message_CE0_1_Short";
        aStringArray4252[26] = "Message_WaitWhile";
        aStringArray4252[27] = "Message_QuitGame_ToRegister";
        aStringArray4252[28] = "Match_MessageErrorHelp";
        aStringArray4252[29] = "Match_MessageError";
        aStringArray4252[30] = "Message_BannedInitially";
        aStringArray4252[31] = "Message_CE_ConnectionError";
        aStringArray4252[32] = "Message_CE1_1_Short";
        aStringArray4252[33] = "Message_ServerFullError";
        aStringArray4252[34] = "Message_PE_GameClosed";
        aStringArray4252[35] = "Message_BannedNowHelp";
        aStringArray4252[36] = "Message_BannedNow";
        aStringArray4252[37] = "Message_CE1_2_Short";
        aStringArray4252[38] = "Message_CE0_3_Long";
        aStringArray4252[39] = "Message_PE_ProgramError";
        aStringArray4252[40] = "Message_CE0_2_Short";
        aStringArray4252[41] = "Dialog";
        aFont4239 = new Font("Dialog", 0, 15);
        aFont4240 = new Font("Dialog", 1, 12);
        aFont4241 = new Font("Dialog", 0, 12);
        aFont4242 = new Font("Dialog", 0, 11);
    }
}
