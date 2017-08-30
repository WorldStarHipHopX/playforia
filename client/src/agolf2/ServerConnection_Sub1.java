package agolf2;

import com.aapeli.applet.AApplet;

public class ServerConnection_Sub1 extends ServerConnection {

    private static final String[] aStringArray3692 = new String[104];
    private Class58_Sub1 aClass58_Sub1_3693;
    private IPanel_Sub7 anIPanel_Sub7_3694;
    private LobbySingleContentPanel anLobbySingleContentPanel__3695;
    private LobbyMultiContentPanel anLobbyMultiContentPanel__3696;
    private IPanel_Sub28_Sub1_Sub1 anIPanel_Sub28_Sub1_Sub1_3697;
    private IPanel_Sub28_Sub1_Sub2 anIPanel_Sub28_Sub1_Sub2_3698;
    private Panel_Sub21 aPanel_Sub21_3699;
    private static final String[] aStringArray3700 = new String[24];


    protected ServerConnection_Sub1(Class58_Sub1 var1) {
        super(var1);
        this.aClass58_Sub1_3693 = var1;
    }

    protected boolean method1184() {
        return super.method1177(aStringArray3692);
    }

    protected void method1185() {
        super.method1178(14);
    }

    protected void method1186(IPanel_Sub7 var1) {
        this.anIPanel_Sub7_3694 = var1;
    }

    protected void method1187(LobbySingleContentPanel var1) {
        this.anLobbySingleContentPanel__3695 = var1;
    }

    protected void method1188(LobbyMultiContentPanel var1) {
        this.anLobbyMultiContentPanel__3696 = var1;
    }

    protected synchronized void method1189(IPanel_Sub28_Sub1_Sub1 var1) {
        this.anIPanel_Sub28_Sub1_Sub1_3697 = var1;
    }

    protected synchronized void method1190() {
        this.anIPanel_Sub28_Sub1_Sub1_3697 = null;
    }

    protected synchronized void method1191(IPanel_Sub28_Sub1_Sub2 var1) {
        this.anIPanel_Sub28_Sub1_Sub2_3698 = var1;
    }

    protected synchronized void method1192() {
        this.anIPanel_Sub28_Sub1_Sub2_3698 = null;
    }

    protected synchronized void method1193(Panel_Sub21 var1) {
        this.aPanel_Sub21_3699 = var1;
    }

    protected synchronized void method1194() {
        this.aPanel_Sub21_3699 = null;
    }

    protected void method1181(String[] var1, String var2) throws Exception {
        if (var1[0].equals(aStringArray3700[5])) {
            if (var1[1].equals(aStringArray3700[23])) {
                this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.setEndState(AApplet.END_ERROR_VERSION);
            } else if (var1[1].equals(aStringArray3700[14])) {
                this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.setEndState(AApplet.END_ERROR_SERVERFULL);
            }

            this.aConnection2376.closeConnection();
        } else if (var1[0].equals(aStringArray3700[2])) {
            this.method1195();
            this.method1179(aStringArray3700[7] + (this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method68() ? aStringArray3700[8] : aStringArray3700[12]));
        } else if (var1[0].equals(aStringArray3700[15])) {
            this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method67(var1[1], Integer.parseInt(var1[2]), Integer.parseInt(var1[3]), var1[4].equals("t"), var1[5], Integer.parseInt(var1[6]), var1[7].equals("t"), var1[8].equals("t"));
        } else if (var1[0].equals(aStringArray3700[20])) {
            this.aClass58_Sub1_3693.method1435(var1[1]);
        } else if (var1[0].equals(aStringArray3700[11])) {
            this.aClass58_Sub1_3693.aClass59_Sub1_3569.method1441(var1[1]);
        } else if (var1[0].equals(aStringArray3700[1])) {
            if (this.anIPanel_Sub7_3694 != null) {
                this.anIPanel_Sub7_3694.method527(var1[1]);
            }

            if (this.anLobbySingleContentPanel__3695 != null) {
                this.anLobbySingleContentPanel__3695.method784(var1[1]);
            }

            if (this.anLobbyMultiContentPanel__3696 != null) {
                this.anLobbyMultiContentPanel__3696.method784(var1[1]);
            }

            synchronized (this) {
                if (this.anIPanel_Sub28_Sub1_Sub1_3697 != null) {
                    this.anIPanel_Sub28_Sub1_Sub1_3697.method698(var1[1]);
                }

                if (this.anIPanel_Sub28_Sub1_Sub2_3698 != null) {
                    this.anIPanel_Sub28_Sub1_Sub2_3698.method698(var1[1]);
                }

                if (this.aPanel_Sub21_3699 != null) {
                    this.aPanel_Sub21_3699.method454(var1[1]);
                }

            }
        } else {
            if (var1[0].equals(aStringArray3700[17])) {
                if (var1[1].equals(aStringArray3700[6])) {
                    if (var1.length == 2) {
                        this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method54(1);
                    } else {
                        byte var3 = 0;
                        if (var1[2].equals(aStringArray3700[22])) {
                            var3 = 4;
                        } else if (var1[2].equals(aStringArray3700[21])) {
                            var3 = 5;
                        } else if (var1[2].equals(aStringArray3700[10])) {
                            var3 = 6;
                        }

                        this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method55(1, var3);
                    }

                    return;
                }

                if (var1[1].equals(aStringArray3700[13])) {
                    this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method54(2);
                    return;
                }

                if (var1[1].equals(aStringArray3700[3])) {
                    this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method55(3, Integer.parseInt(var1[2]));
                    return;
                }

                if (var1[1].equals(aStringArray3700[4])) {
                    this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method55(4, var1[2].equals("t") ? 1 : 0);
                    return;
                }

                if (var1[1].equals(aStringArray3700[9])) {
                    this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method54(5);
                    return;
                }

                if (var1[1].equals(aStringArray3700[16])) {
                    this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method55(6, Integer.parseInt(var1[2]));
                    return;
                }

                if (var1[1].equals(aStringArray3700[18])) {
                    this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method55(7, Integer.parseInt(var1[2]));
                    return;
                }

                if (var1[1].equals(aStringArray3700[19])) {
                    this.aClass58_Sub1_3693.anAApplet_Sub3_Sub1_3567.method54(8);
                    return;
                }
            }

            if (var1[0].equals(aStringArray3700[3])) {
                if (this.anIPanel_Sub7_3694 != null) {
                    this.anIPanel_Sub7_3694.method528(var1);
                }
            } else if (var1[0].equals(aStringArray3700[4])) {
                if (this.anLobbySingleContentPanel__3695 != null) {
                    this.anLobbySingleContentPanel__3695.method785(var1);
                }
            } else if (var1[0].equals(aStringArray3700[9])) {
                if (this.anLobbyMultiContentPanel__3696 != null) {
                    this.anLobbyMultiContentPanel__3696.method785(var1);
                }
            } else if (var1[0].equals(aStringArray3700[16])) {
                synchronized (this) {
                    if (this.anIPanel_Sub28_Sub1_Sub1_3697 != null) {
                        this.anIPanel_Sub28_Sub1_Sub1_3697.method699(var1);
                    }

                }
            } else if (var1[0].equals(aStringArray3700[18])) {
                synchronized (this) {
                    if (this.anIPanel_Sub28_Sub1_Sub2_3698 != null) {
                        this.anIPanel_Sub28_Sub1_Sub2_3698.method699(var1);
                    }

                }
            } else {
                if (var1[0].equals(aStringArray3700[19])) {
                    synchronized (this) {
                        if (this.aPanel_Sub21_3699 != null) {
                            this.aPanel_Sub21_3699.method455(var1);
                        }
                    }
                }

            }
        }
    }

    private void method1195() {
        String var1;
        if (this.aClass58_Sub1_3693.aTournament3568 != null) {
            var1 = this.aClass58_Sub1_3693.aTournament3568.getTicket();
        } else {
            var1 = this.aClass58_Sub1_3693.aParameters1186.getTicket();
        }

        if (var1 != null) {
            this.method1179(aStringArray3700[0] + var1);
        }

    }

    static {
        aStringArray3700[0] = "ticket\t";
        aStringArray3700[1] = "broadcast";
        aStringArray3700[2] = "versok";
        aStringArray3700[3] = "editor";
        aStringArray3700[4] = "lobby1";
        aStringArray3700[5] = "error";
        aStringArray3700[6] = "login";
        aStringArray3700[7] = "logintype\t";
        aStringArray3700[8] = "reg";
        aStringArray3700[9] = "lobby2";
        aStringArray3700[10] = "rlf";
        aStringArray3700[11] = "userdata";
        aStringArray3700[12] = "nr";
        aStringArray3700[13] = "select";
        aStringArray3700[14] = "serverfull";
        aStringArray3700[15] = "basicinfo";
        aStringArray3700[16] = "game1";
        aStringArray3700[17] = "status";
        aStringArray3700[18] = "game2";
        aStringArray3700[19] = "ta";
        aStringArray3700[20] = "products";
        aStringArray3700[21] = "nickinuse";
        aStringArray3700[22] = "invalidnick";
        aStringArray3700[23] = "vernotok";

        aStringArray3692[0] = "basicinfo\t";
        aStringArray3692[1] = "editor\tback";
        aStringArray3692[2] = "editor\tpublish\t";
        aStringArray3692[3] = "editor\treply\t";
        aStringArray3692[4] = "editor\tsave\t";
        aStringArray3692[5] = "editor\ttracks";
        aStringArray3692[6] = "game1\taimready\t";
        aStringArray3692[7] = "game1\taimstart\t";
        aStringArray3692[8] = "game1\tballdata\t";
        aStringArray3692[9] = "game1\tgameinfo\t";
        aStringArray3692[10] = "game1\tgameover\t";
        aStringArray3692[11] = "game1\tgamestart";
        aStringArray3692[12] = "game1\tlocal\t";
        aStringArray3692[13] = "game1\tnewgame";
        aStringArray3692[14] = "game1\tnextnote";
        aStringArray3692[15] = "game1\tnext";
        aStringArray3692[16] = "game1\tplayerdata\t";
        aStringArray3692[17] = "game1\tplayers\t";
        aStringArray3692[18] = "game1\tquit";
        aStringArray3692[19] = "game1\trate\t";
        aStringArray3692[20] = "game1\tstrikeready";
        aStringArray3692[21] = "game1\tstrikestart\t";
        aStringArray3692[22] = "game1\ttrackend\t";
        aStringArray3692[23] = "game1\ttrackready";
        aStringArray3692[24] = "game1\ttrackstart\t";
        aStringArray3692[25] = "game1\tta";
        aStringArray3692[26] = "game2\taimready\t";
        aStringArray3692[27] = "game2\taimstart\t";
        aStringArray3692[28] = "game2\tballdata\t";
        aStringArray3692[29] = "game2\tban\t";
        aStringArray3692[30] = "game2\tcancelaim";
        aStringArray3692[31] = "game2\tclearnext";
        aStringArray3692[32] = "game2\tgameinfo\t";
        aStringArray3692[33] = "game2\tgameover\t";
        aStringArray3692[34] = "game2\tgamestart";
        aStringArray3692[35] = "game2\tkick\t";
        aStringArray3692[36] = "game2\tlocal\t";
        aStringArray3692[37] = "game2\tnewgamenote";
        aStringArray3692[38] = "game2\tnewgame";
        aStringArray3692[39] = "game2\tnextnote";
        aStringArray3692[40] = "game2\tnext";
        aStringArray3692[41] = "game2\tojoin\t";
        aStringArray3692[42] = "game2\tpart\t";
        aStringArray3692[43] = "game2\tplayerdata\t";
        aStringArray3692[44] = "game2\tplayers\t";
        aStringArray3692[45] = "game2\tquit";
        aStringArray3692[46] = "game2\tsay\t";
        aStringArray3692[47] = "game2\tsjoin\t";
        aStringArray3692[48] = "game2\tspart\t";
        aStringArray3692[49] = "game2\tstrikeready";
        aStringArray3692[50] = "game2\tstrikestart\t";
        aStringArray3692[51] = "game2\ttrackend\t";
        aStringArray3692[52] = "game2\ttrackready";
        aStringArray3692[53] = "game2\ttrackstart\t";
        aStringArray3692[54] = "game2\tusers\t";
        aStringArray3692[55] = "lobby1\tbuy\t";
        aStringArray3692[56] = "lobby1\tgamelist\tadd\t";
        aStringArray3692[57] = "lobby1\tgamelist\tfull\t";
        aStringArray3692[58] = "lobby1\tgamelist\tremove\t";
        aStringArray3692[59] = "lobby1\townjoin\t";
        aStringArray3692[60] = "lobby1\tps\t";
        aStringArray3692[61] = "lobby1\tsay\t";
        aStringArray3692[62] = "lobby1\tsayp\t";
        aStringArray3692[63] = "lobby1\tstart\t";
        aStringArray3692[64] = "lobby1\ttoeditor";
        aStringArray3692[65] = "lobby1\ttomulti";
        aStringArray3692[66] = "lobby1\ttracksets\t";
        aStringArray3692[67] = "lobby1\tusers";
        aStringArray3692[68] = "lobby1\ttrackreq\t";
        aStringArray3692[69] = "lobby1\ttrackerror\t";
        aStringArray3692[70] = "lobby2\tcreate\t";
        aStringArray3692[71] = "lobby2\tgamelist\tadd\t";
        aStringArray3692[72] = "lobby2\tgamelist\tchange\t";
        aStringArray3692[73] = "lobby2\tgamelist\tfull\t";
        aStringArray3692[74] = "lobby2\tgamelist\tremove\t";
        aStringArray3692[75] = "lobby2\tgotowait\t";
        aStringArray3692[76] = "lobby2\tjoin\t";
        aStringArray3692[77] = "lobby2\townjoin\t";
        aStringArray3692[78] = "lobby2\tpart\t";
        aStringArray3692[79] = "lobby2\treturn\t";
        aStringArray3692[80] = "lobby2\tsay\t";
        aStringArray3692[81] = "lobby2\tsayp\t";
        aStringArray3692[82] = "lobby2\ttoeditor";
        aStringArray3692[83] = "lobby2\ttosingle";
        aStringArray3692[84] = "lobby2\tusers";
        aStringArray3692[85] = "lobby2\twaitifail\t";
        aStringArray3692[86] = "lobby2\twaitinvite\t";
        aStringArray3692[87] = "lobby2\twaitrts";
        aStringArray3692[88] = "lobby2\twaitsetfree";
        aStringArray3692[89] = "lobby2\twatch\t";
        aStringArray3692[90] = "localip\t";
        aStringArray3692[91] = "login\t";
        aStringArray3692[92] = "logintype\t";
        aStringArray3692[93] = "products\t";
        aStringArray3692[94] = "quit";
        aStringArray3692[95] = "select\teditor";
        aStringArray3692[96] = "select\tmulti";
        aStringArray3692[97] = "select\tsingle";
        aStringArray3692[98] = "status\teditor";
        aStringArray3692[99] = "status\tgame";
        aStringArray3692[100] = "status\tlobby";
        aStringArray3692[101] = "status\tlogin";
        aStringArray3692[102] = "status\tselect";
        aStringArray3692[103] = "userdata\t";
    }
}
