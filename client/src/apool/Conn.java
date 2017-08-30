package apool;

import com.playray.connection.ConnListener;
import com.playray.connection.Connection;
import com.playray.tools.Tools;

public class Conn implements ConnListener {

    private static final String[] aStringArray2631 = new String[64];
    private Class60 aClass60_2632;
    private Connection aConnection2633;
    private LobbySelectHeaderPanel aSPanel__2634;
    private SPanel_Sub21 aSPanel_Sub21_2635;
    private SPanel_Sub20 aSPanel_Sub20_2636;
    private String aString2637;
    private String aString2638;
    private static final String[] aStringArray2639 = new String[28];


    protected Conn(Class60 var1) {
        this.aClass60_2632 = var1;
        this.aString2637 = this.aString2638 = null;
    }

    public void dataReceived(String var1) {
        try {
            this.method1477(var1);
            this.aString2638 = var1;
        } catch (Exception var5) {
            var5.printStackTrace();
            Exception var2 = var5;

            try {
                this.method1475("error-debug\t" + this.aClass60_2632.gameApplet.method2303() + "\t" + var2.toString().trim() + "\t" + var1.replace('\t', '\\') + "\t" + this.aString2638.replace('\t', '\\') + "\t" + this.aString2637.replace('\t', '\\'));
            } catch (Exception var4) {
                ;
            }

            this.aClass60_2632.gameApplet.setEndState((Throwable) var5);
            this.aConnection2633.disconnect();
        }

    }

    public void connectionLost(int var1) {
        if (var1 != 2 && var1 != 3) {
            if (var1 == 4) {
                this.aClass60_2632.gameApplet.setEndState(3);
            }
        } else {
            this.aClass60_2632.gameApplet.setEndState(2);
        }

    }

    public void notifyConnectionDown() {
    }

    public void notifyConnectionUp() {
    }

    protected boolean method1470() {
        this.aConnection2633 = new Connection(this.aClass60_2632.gameApplet, this, aStringArray2631);
        return this.aConnection2633.connect();
    }

    protected void method1471() {
        this.aClass60_2632.gameApplet.method2304(0);
        this.method1475("version\t41");
    }

    protected void method1472(LobbySelectHeaderPanel var1) {
        this.aSPanel__2634 = var1;
    }

    protected void method1473(SPanel_Sub21 var1) {
        this.aSPanel_Sub21_2635 = var1;
    }

    protected void method1474(SPanel_Sub20 var1) {
        this.aSPanel_Sub20_2636 = var1;
    }

    public void method1475(String var1) {
        this.aString2637 = var1;
        this.aConnection2633.writeData(var1);
    }

    protected void method1476() {
        try {
            this.method1475("quit");
        } catch (Exception var2) {
            ;
        }

        if (this.aConnection2633 != null) {
            this.aConnection2633.disconnect();
        }

    }

    private void method1477(String var1) throws Exception {
        String[] var2 = Tools.separateString(var1, "\t");
        if (var2[0].equals("error")) {
            if (var2[1].equals("vernotok")) {
                this.aClass60_2632.gameApplet.setEndState(3);
            } else if (var2[1].equals("serverfull")) {
                this.aClass60_2632.gameApplet.setEndState(4);
            }

            this.aConnection2633.disconnect();
        } else if (var2[0].equals("versok")) {
            this.method1478();
            this.method1475("language\t" + this.aClass60_2632.params.getChatLang());
            String var7 = this.aClass60_2632.params.getSessionLocale();
            if (var7 != null) {
                this.method1475("sessionlocale\t" + var7);
            }

            this.method1475("logintype\t" + (this.aClass60_2632.gameApplet.method2317() ? "reg" : "nr"));
        } else if (var2[0].equals("basicinfo")) {
            this.aClass60_2632.gameApplet.method2307(var2[1].equals("t"), Integer.parseInt(var2[2]), var2[3].equals("t"), var2[4].equals("t"));
        } else if (var2[0].equals("coininfo")) {
            this.aClass60_2632.gameApplet.method2308(Integer.parseInt(var2[1]), var2[2].equals("t"), var2[3].equals("t"));
        } else if (var2[0].equals("userdata")) {
            this.aClass60_2632.aClass61_1207.method1454(var2[1]);
        } else {
            LobbySelectHeaderPanel var3 = this.aSPanel__2634;
            SPanel_Sub21 var4 = this.aSPanel_Sub21_2635;
            SPanel_Sub20 var5 = this.aSPanel_Sub20_2636;
            if (var2[0].equals("broadcast")) {
                if (var3 != null) {
                    var3.method2593(var2[1]);
                }

                if (var4 != null) {
                    var4.method2578(var2[1]);
                }

                if (var5 != null) {
                    var5.method2526(var2[1]);
                }

            } else {
                if (var2[0].equals("status")) {
                    if (var2[1].equals("login")) {
                        if (var2.length == 2) {
                            this.aClass60_2632.gameApplet.method2304(1);
                        } else {
                            byte var6 = 0;
                            if (var2[2].equals("nickinuse")) {
                                var6 = 4;
                            } else if (var2[2].equals("rlf")) {
                                var6 = 5;
                            } else if (var2[2].equals("invalidnick")) {
                                var6 = 6;
                            } else if (var2[2].equals("forbiddennick")) {
                                var6 = 7;
                            }

                            this.aClass60_2632.gameApplet.method2305(1, var6);
                        }

                        return;
                    }

                    if (var2[1].equals("lobbyselect")) {
                        this.aClass60_2632.gameApplet.method2304(2);
                        return;
                    }

                    if (var2[1].equals("lobby")) {
                        this.aClass60_2632.gameApplet.method2304(3);
                        return;
                    }

                    if (var2[1].equals("game")) {
                        this.aClass60_2632.gameApplet.method2306(4, var2[2].equals("sp") ? 1 : 2, Integer.parseInt(var2[3]));
                        return;
                    }
                }

                if (var2[0].equals("lobbyselect")) {
                    if (var3 != null) {
                        var3.method2590(var2);
                    }

                } else if (var2[0].equals("lobby")) {
                    if (var4 != null) {
                        var4.method2575(var2);
                    }

                } else if (var2[0].equals("game")) {
                    if (var5 != null) {
                        var5.method2522(var2);
                    }

                } else {
                    if (var2[0].equals("rankingchangenote")) {
                        this.aClass60_2632.gameApplet.method2324(Integer.parseInt(var2[1]), Integer.parseInt(var2[2]), Integer.parseInt(var2[3]));
                    }

                }
            }
        }
    }

    private void method1478() {
        String var1 = this.aClass60_2632.params.getTicket();
        if (var1 != null) {
            this.method1475("ticket\t" + var1);
        }

    }

    static {
        aStringArray2639[0] = "nickinuse";
        aStringArray2639[1] = "logintype\t";
        aStringArray2639[2] = "nr";
        aStringArray2639[3] = "language\t";
        aStringArray2639[4] = "vernotok";
        aStringArray2639[5] = "error";
        aStringArray2639[6] = "status";
        aStringArray2639[7] = "lobby";
        aStringArray2639[8] = "coininfo";
        aStringArray2639[9] = "basicinfo";
        aStringArray2639[10] = "rlf";
        aStringArray2639[11] = "lobbyselect";
        aStringArray2639[12] = "invalidnick";
        aStringArray2639[13] = "sp";
        aStringArray2639[14] = "forbiddennick";
        aStringArray2639[15] = "sessionlocale\t";
        aStringArray2639[16] = "game";
        aStringArray2639[17] = "serverfull";
        aStringArray2639[18] = "versok";
        aStringArray2639[19] = "rankingchangenote";
        aStringArray2639[20] = "userdata";
        aStringArray2639[21] = "login";
        aStringArray2639[22] = "broadcast";
        aStringArray2639[23] = "reg";
        aStringArray2639[24] = "quit";
        aStringArray2639[25] = "error-debug\t";
        aStringArray2639[26] = "version\t41";
        aStringArray2639[27] = "ticket\t";

        aStringArray2631[0] = "basicinfo\t";
        aStringArray2631[1] = "userdata\t";
        aStringArray2631[2] = "answeringother";
        aStringArray2631[3] = "game\tcurrentmouse\t";
        aStringArray2631[4] = "game\tbeginstroke\t";
        aStringArray2631[5] = "game\tendstroke\t";
        aStringArray2631[6] = "game\tsetwhiteball\t";
        aStringArray2631[7] = "game\tstart\t";
        aStringArray2631[8] = "game\tpass";
        aStringArray2631[9] = "game\tconcede";
        aStringArray2631[10] = "game\treadyfornewgame";
        aStringArray2631[11] = "game\tnewgame";
        aStringArray2631[12] = "game\tturn\t";
        aStringArray2631[13] = "game\tturn";
        aStringArray2631[14] = "challenge\t";
        aStringArray2631[15] = "accept\t";
        aStringArray2631[16] = "cancel\t";
        aStringArray2631[17] = "refuse\t";
        aStringArray2631[18] = "game\t";
        aStringArray2631[19] = "gamelist\t";
        aStringArray2631[20] = "gameid\t";
        aStringArray2631[21] = "gamestartnotify\t";
        aStringArray2631[22] = "bannedfromgame";
        aStringArray2631[23] = "game";
        aStringArray2631[24] = "hide";
        aStringArray2631[25] = "logintype\t";
        aStringArray2631[26] = "login\t";
        aStringArray2631[27] = "login";
        aStringArray2631[28] = "nochallenges";
        aStringArray2631[29] = "nosuchuser";
        aStringArray2631[30] = "oaspec";
        aStringArray2631[31] = "aspec";
        aStringArray2631[32] = "ownjoin\t";
        aStringArray2631[33] = "spart\t";
        aStringArray2631[34] = "part\t";
        aStringArray2631[35] = "players\t";
        aStringArray2631[36] = "player\t";
        aStringArray2631[37] = "lobbyselect\t";
        aStringArray2631[38] = "lobbyselect";
        aStringArray2631[39] = "lobby\tcfail";
        aStringArray2631[40] = "lobby\tnc\t";
        aStringArray2631[41] = "lobby\tcg\t";
        aStringArray2631[42] = "lobby\t";
        aStringArray2631[43] = "lobbylist\t";
        aStringArray2631[44] = "lobby";
        aStringArray2631[45] = "say\t";
        aStringArray2631[46] = "sayoo\t";
        aStringArray2631[47] = "spselected\t";
        aStringArray2631[48] = "mpselected\t";
        aStringArray2631[49] = "sjoin\t";
        aStringArray2631[50] = "slist\t";
        aStringArray2631[51] = "specball\t";
        aStringArray2631[52] = "specdata\t";
        aStringArray2631[53] = "specwinner\t";
        aStringArray2631[54] = "specscore\t";
        aStringArray2631[55] = "status\t";
        aStringArray2631[56] = "waitingreply";
        aStringArray2631[57] = "quit";
        aStringArray2631[58] = "toplist\t";
        aStringArray2631[59] = "back";
        aStringArray2631[60] = "skickban\t";
        aStringArray2631[61] = "watchcantstart";
        aStringArray2631[62] = "bet\t";
        aStringArray2631[63] = "betwin\t";
    }
}
