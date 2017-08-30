package com.playray.singleclient;

import com.playray.applet.AApplet;
import com.playray.client.AutoPopups;
import com.playray.client.Badge;
import com.playray.client.BadgeHandler;
import com.playray.client.PersonalScore;
import com.playray.client.PersonalScoreUnit;
import com.playray.client.Tournament;
import com.playray.connection.ConnListener;
import com.playray.connection.Connection;
import com.playray.credit.Product;
import com.playray.credit.ProductHandler;
import com.playray.singleclient.Class146;
import com.playray.singleclient.Class147;
import com.playray.singleclient.SingleGame;
import com.playray.singleclient.TopListUnit;
import com.playray.tools.Tools;

import java.util.StringTokenizer;
import java.util.Vector;

public class SingleClient implements ConnListener {

    public static final int anInt2640 = 1;
    public static final int ERROR = 10;
    public static final int ERROR_STATUS = 11;
    public static final int ERROR_DISCONNECTED = 12;
    public static final int ERROR_VERSIONCONFLICT = 20;
    public static final int ERROR_SERVERFULL = 21;
    public static final int ERROR_REGLOGINFAILED = 30;
    public static final int ERROR_NICKTOOSHORT = 40;
    public static final int ERROR_NICKTOOLONG = 41;
    public static final int ERROR_FORBIDDENNICK = 42;
    public static final int ERROR_NICKINUSE = 43;
    public static final int ERROR_UNBUYABLE = 50;
    public static final int ERROR_NOBALANCE = 51;
    public static final int ERROR_BUYFAILED = 52;
    public static final int LISTTYPE_REGISTERED = 0;
    public static final int LISTTYPE_ALLTIME = 1;
    public static final int LISTTYPE_MONTH = 2;
    public static final int LISTTYPE_WEEK = 3;
    public static final int LISTTYPE_DAY = 4;
    public static final int LISTTYPE_COUNT = 5;
    public static final int USERLEVEL_UNREG = 0;
    public static final int USERLEVEL_REG = 1;
    public static final int USERLEVEL_VIP = 2;
    public static final int FINISHED_NOTIME = 0;
    public static final int FINISHED_NOTSTARTED = -1;
    public static final int FINISHED_OVERFLOW = -2;
    public static final int FINISHED_INVALIDSTATUS = -3;
    public static final int FINISHED_SERVERERROR = -4;
    private AApplet anAApplet2641;
    private Tournament aTournament2642;
    private Class147 aClass147_2643;
    private SingleGame aSingleGame2644;
    private String aString2645;
    private int anInt2646;
    private Connection aConnection2647;
    private Vector aVector2648;
    private PersonalScore aPersonalScore2649;
    private Class146 aClass146_2650;
    private BadgeHandler aBadgeHandler2651;
    private ProductHandler aProductHandler2652;
    private String aString2653;
    private String aString2654;
    private int anInt2655;
    private boolean aBoolean2656;
    private String aString2657;
    private String aString2658;
    private String aString2659;
    private String aString2660;
    private int anInt2661;
    private int anInt2662;
    private int anInt2663;
    private AutoPopups anAutoPopups2664;
    private static final String[] aStringArray2665 = new String[81];


    public SingleClient(AApplet var1, SingleGame var2, String var3, int var4, String[] var5) {
        this.anAApplet2641 = var1;
        this.aSingleGame2644 = var2;
        this.aString2645 = var3;
        this.anInt2646 = var4;
        this.aPersonalScore2649 = new PersonalScore();
        this.aClass146_2650 = new Class146();
        this.aVector2648 = new Vector();
        this.aString2657 = this.aString2658 = this.aString2653 = this.aString2654 = null;
        this.anInt2661 = 0;
        this.anInt2662 = 0;
        this.anInt2663 = 0;
        this.aString2659 = this.aString2660 = "-";
        this.anInt2655 = 1;
        this.aBoolean2656 = false;
        this.aTournament2642 = Tournament.getTournament(var1.param, var5);
        this.aClass147_2643 = new Class147("DolphinTherapy");
    }

    public void dataReceived(String var1) {
        try {
            if (this.anInt2655 <= 4) {
                if (this.aSingleGame2644.isDebugMode()) {
                    System.out.println("C <= " + var1);
                }

                var1 = this.aClass147_2643.method2242(var1);
                if (this.aSingleGame2644.isDebugMode()) {
                    System.out.println("C <- " + var1);
                }

                this.method2250(var1);
                this.aString2654 = var1;
            }
        } catch (Exception var5) {
            Exception var2 = var5;
            if (this.anInt2655 <= 4) {
                this.anInt2655 = 5;
                if (this.aSingleGame2644.isDebugMode()) {
                    System.out.println("SingleClient.run(): e=\"" + var5 + "\"");
                    var5.printStackTrace();
                }

                try {
                    this.method2248("error-debug\t" + var2.toString().trim() + "\t" + var1.replace('\t', '\\') + "\t" + this.aString2654.replace('\t', '\\') + "\t" + this.aString2653.replace('\t', '\\'));
                } catch (Exception var4) {
                    ;
                }
            }
        }

    }

    public void connectionLost(int var1) {
        if (var1 == 2 || var1 == 3) {
            this.aSingleGame2644.connectionError();
        }

        this.anInt2655 = 7;
    }

    public void notifyConnectionDown() {
    }

    public void notifyConnectionUp() {
    }

    public void simulateServerConnection() {
        if (this.anInt2655 == 1) {
            this.aBoolean2656 = true;
        }
    }

    public void enableAutoPopups() {
        this.anAutoPopups2664 = new AutoPopups(this.anAApplet2641);
    }

    public synchronized int connect(boolean var1) {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.openConnection(" + var1 + ")");
        }

        if (this.anInt2655 != 1) {
            return 11;
        } else if (this.aBoolean2656) {
            this.anInt2655 = var1 ? 2 : 3;
            return 1;
        } else {
            String[] var2 = new String[]{"version\t"};
            this.aConnection2647 = new Connection(this.anAApplet2641, this, var2);
            if (!this.aConnection2647.connect()) {
                this.method2249();
                return 10;
            } else {
                this.method2248("version\t20");
                String var3 = this.method2251();
                if (var3 == null) {
                    return 12;
                } else if (!var3.equals("versionok")) {
                    this.method2249();
                    return 20;
                } else {
                    this.method2248("gamename\t" + this.aString2645 + "\t" + this.anInt2646);
                    var3 = this.method2251();
                    if (var3 == null) {
                        return 12;
                    } else if (!var3.equals("ok")) {
                        this.method2249();
                        return var3.equals("error") ? 20 : 10;
                    } else {
                        if (var1) {
                            this.method2248("logintype\treg");
                            this.anInt2655 = 2;
                        } else {
                            this.method2248("logintype\tnr");
                            this.anInt2655 = 3;
                        }

                        var3 = this.method2251();
                        if (!var3.equals("ok")) {
                            this.method2249();
                            return var3.equals("serverfull") ? 21 : 10;
                        } else {
                            String var4 = null;
                            if (this.aTournament2642 != null) {
                                var4 = this.aTournament2642.getTicket();
                            } else {
                                var4 = this.anAApplet2641.param.getTicket();
                            }

                            if (var4 != null) {
                                this.method2248("ticket\t" + var4);
                                var3 = this.method2251();
                                if (!var3.equals("ok")) {
                                    this.method2249();
                                    return 10;
                                }
                            }

                            return 1;
                        }
                    }
                }
            }
        }
    }

    public synchronized int loginAsRegistered(String var1) {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.loginAsRegistered(\"" + var1 + "\")");
        }

        if (this.anInt2655 != 2) {
            return 11;
        } else if (this.aBoolean2656) {
            this.aString2657 = "Simulation";
            this.anInt2661 = 1;
            this.anInt2662 = 0;
            this.anInt2663 = 0;
            this.method2256((String) null);
            this.anInt2655 = 4;
            return 1;
        } else {
            this.method2248("reglogin\t" + var1);
            String var2 = this.method2251();
            if (var2 == null) {
                return 12;
            } else if (!var2.startsWith("ok\t")) {
                if (var2.equals("failed")) {
                    this.anInt2655 = 3;
                    return 30;
                } else if (var2.equals("serverfull")) {
                    this.method2249();
                    return 21;
                } else {
                    this.method2249();
                    return 10;
                }
            } else {
                StringTokenizer var3 = new StringTokenizer(var2, "\t");
                var3.nextToken();
                this.aString2657 = var3.nextToken();
                String var4 = var3.nextToken();
                this.anInt2661 = 1;
                if (var4.indexOf(86) >= 0) {
                    this.anInt2661 = 2;
                }

                this.anInt2662 = 0;
                if (var4.indexOf(83) >= 0) {
                    this.anInt2662 = 1;
                }

                if (var4.indexOf(65) >= 0) {
                    this.anInt2662 = 2;
                }

                this.anInt2663 = Integer.parseInt(var3.nextToken());
                if (var3.hasMoreTokens()) {
                    this.aString2658 = var3.nextToken();
                }

                var2 = this.method2251();
                if (var2 == null) {
                    return 12;
                } else if (!var2.startsWith("bitmaps\t")) {
                    return 10;
                } else {
                    var3 = new StringTokenizer(var2, "\t");
                    var3.nextToken();
                    this.aString2659 = var3.nextToken();
                    this.aString2660 = var3.nextToken();
                    var2 = this.method2251();
                    if (var2 == null) {
                        return 12;
                    } else if (!var2.startsWith("ps\t")) {
                        return 10;
                    } else {
                        this.method2256(var2.substring(3));
                        var2 = this.method2251();
                        if (var2 == null) {
                            return 12;
                        } else if (!var2.startsWith("badges\t")) {
                            return 10;
                        } else {
                            this.method2258(var2.substring(7));
                            var2 = this.method2251();
                            if (var2 == null) {
                                return 12;
                            } else {
                                if (var2.startsWith("products\t")) {
                                    this.method2259(var2.substring(9));
                                }

                                this.anInt2655 = 4;
                                return 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized int autoLoginAsGuest() {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.autoLoginAsGuest()");
        }

        if (this.anInt2655 != 3) {
            return 11;
        } else if (this.aBoolean2656) {
            this.aString2657 = "~Simulation";
            this.anInt2661 = 0;
            this.anInt2662 = 0;
            this.anInt2663 = 0;
            this.anInt2655 = 4;
            return 1;
        } else {
            this.method2248("autologin");
            String var1 = this.method2251();
            if (var1 == null) {
                return 12;
            } else if (!var1.startsWith("ok\t")) {
                this.method2249();
                return 10;
            } else {
                this.aString2657 = var1.substring(3);
                var1 = this.method2251();
                if (var1 == null) {
                    return 12;
                } else if (!var1.startsWith("badges\t")) {
                    return 10;
                } else {
                    this.method2258(var1.substring(7));
                    var1 = this.method2251();
                    if (var1 == null) {
                        return 12;
                    } else {
                        if (var1.startsWith("products\t")) {
                            this.method2259(var1.substring(9));
                        }

                        this.anInt2661 = 0;
                        this.anInt2662 = 0;
                        this.anInt2663 = 0;
                        this.anInt2655 = 4;
                        return 1;
                    }
                }
            }
        }
    }

    public synchronized int loginAsGuest(String var1) {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.loginAsGuest(\"" + var1 + "\")");
        }

        if (this.anInt2655 != 3) {
            return 11;
        } else if (this.aBoolean2656) {
            this.aString2657 = "~Simulation";
            this.anInt2661 = 0;
            this.anInt2662 = 0;
            this.anInt2663 = 0;
            this.anInt2655 = 4;
            return 1;
        } else {
            this.method2248("login\t" + var1);
            String var2 = this.method2251();
            if (var2 == null) {
                return 12;
            } else if (!var2.startsWith("ok\t")) {
                if (var2.equals("tooshort")) {
                    return 40;
                } else if (var2.equals("toolong")) {
                    return 41;
                } else if (var2.equals("forbidden")) {
                    return 42;
                } else if (var2.equals("inuse")) {
                    return 43;
                } else {
                    this.method2249();
                    return 10;
                }
            } else {
                this.aString2657 = var2.substring(3);
                var2 = this.method2251();
                if (var2 == null) {
                    return 12;
                } else if (!var2.startsWith("badges\t")) {
                    return 10;
                } else {
                    this.method2258(var2.substring(7));
                    var2 = this.method2251();
                    if (var2 == null) {
                        return 12;
                    } else {
                        if (var2.startsWith("products\t")) {
                            this.method2259(var2.substring(9));
                        }

                        this.anInt2661 = 0;
                        this.anInt2662 = 0;
                        this.anInt2663 = 0;
                        this.anInt2655 = 4;
                        return 1;
                    }
                }
            }
        }
    }

    public String getNick() {
        return this.aString2657;
    }

    public int getUserLevel() {
        return this.anInt2661;
    }

    public boolean isRegistered() {
        return this.anInt2661 >= 1;
    }

    public boolean isVip() {
        return this.anInt2661 >= 2;
    }

    public boolean isSheriff() {
        return this.anInt2662 >= 1;
    }

    public boolean isAdmin() {
        return this.anInt2662 >= 2;
    }

    public PersonalScoreUnit getPersonalScore() {
        return this.aPersonalScore2649.getPersonalScore();
    }

    public PersonalScoreUnit getPersonalScore(String var1) {
        return this.aPersonalScore2649.getPersonalScore(var1);
    }

    public synchronized int requestPlayerData(String[] var1) {
        if (this.anInt2655 != 4) {
            return 11;
        } else if (this.aBoolean2656) {
            return 1;
        } else {
            String var2 = "reqpd";

            for (int var3 = 0; var3 < var1.length; ++var3) {
                var2 = var2 + "\t" + var1[var3];
            }

            this.method2248(var2);

            while (true) {
                var2 = this.method2251();
                if (var2 == null) {
                    return 12;
                }

                if (var2.equals("endpd")) {
                    return 1;
                }

                if (!var2.startsWith("pd\t")) {
                    return 10;
                }

                this.method2257(var2.substring(3));
            }
        }
    }

    public String getPlayerData(String var1) {
        return this.aClass146_2650.method2239(var1);
    }

    public int getCredits() {
        return this.anInt2663;
    }

    public int refreshCredits() {
        if (this.anInt2655 != 4) {
            return -1;
        } else if (this.aBoolean2656) {
            return this.anInt2663;
        } else {
            this.method2248("credits");
            String var1 = this.method2251();
            if (var1 == null) {
                return -1;
            } else if (!var1.startsWith("credits\t")) {
                return -1;
            } else {
                this.anInt2663 = Integer.parseInt(var1.substring(8));
                this.anAApplet2641.param.updateWebPageInfoBox(this.anInt2663, -1, -1);
                return this.anInt2663;
            }
        }
    }

    public String getBitmapUrlSmall() {
        return this.aString2659;
    }

    public String getBitmapUrlMedium() {
        return this.aString2660;
    }

    public void gameStarted() {
        if (this.anInt2655 == 4) {
            if (!this.aBoolean2656) {
                this.method2248("started");
            }
        }
    }

    public int gameNormallyFinished() {
        return this.gameNormallyFinished(false);
    }

    public int gameNormallyFinished(boolean var1) {
        if (this.anInt2655 != 4) {
            return -3;
        } else if (this.aBoolean2656) {
            return var1 ? 1 : 0;
        } else if (!var1) {
            this.method2248("finished");
            if (this.anAutoPopups2664 != null) {
                this.anAutoPopups2664.gameFinished(false);
            }

            return 0;
        } else {
            String var2;
            synchronized (this) {
                this.method2248("finished\ttime");
                var2 = this.method2251();
            }

            if (var2 == null) {
                return -4;
            } else if (!var2.startsWith("ok\t")) {
                if (var2.equals("notstarted")) {
                    return -1;
                } else if (var2.equals("overflow")) {
                    return -2;
                } else {
                    this.method2249();
                    return -4;
                }
            } else {
                if (this.anAutoPopups2664 != null) {
                    this.anAutoPopups2664.gameFinished(false);
                }

                return Integer.parseInt(var2.substring(3));
            }
        }
    }

    public int[] addScore(String var1, long var2, String[] var4) {
        return this.addScore(var1, var2, var4, (String) null, (String) null, false);
    }

    public int[] addScore(String var1, long var2, String[] var4, String var5) {
        return this.addScore(var1, var2, var4, var5, (String) null, false);
    }

    public int[] addScore(String var1, long var2, String[] var4, String var5, boolean var6) {
        return this.addScore(var1, var2, var4, var5, (String) null, var6);
    }

    public int[] addScore(String var1, long var2, String[] var4, String var5, String var6) {
        return this.addScore(var1, var2, var4, var5, var6, false);
    }

    public synchronized int[] addScore(String var1, long var2, String[] var4, String var5, String var6, boolean var7) {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.addScore(\"" + var1 + "\"," + var2 + ",...)");
        }

        if (this.anInt2655 != 4) {
            return null;
        } else {
            if (this.anAApplet2641 != null) {
                this.anAApplet2641.callJavaScriptJSON("{\"scorenotify\":{\"subgame\":\"" + var1 + "\",\"compscore\":\"" + var2 + "\"}}");
            }

            int var9;
            if (this.aBoolean2656) {
                int[] var13 = new int[5];

                for (var9 = 0; var9 < 5; ++var9) {
                    var13[var9] = Integer.MAX_VALUE;
                }

                return var13;
            } else {
                if (var6 != null) {
                    this.addPersonalScore(var1, var2, var6);
                }

                String var8 = var1 + "\t" + var2;
                var9 = var4.length;

                for (int var10 = 0; var10 < var9; ++var10) {
                    var8 = var8 + "\t" + var4[var10];
                }

                var8 = var8 + "\t" + (var5 != null ? var5 : "-");
                var8 = var8 + "\t" + (var6 != null ? var6 : "-");
                var8 = var8 + "\t" + (var7 ? "t" : "f");
                var8 = this.method2252(var8, true);
                this.method2248("score\t" + var8);
                var8 = this.method2251();
                if (var8 == null) {
                    return null;
                } else if (!var8.startsWith("ok\t")) {
                    return null;
                } else {
                    int[] var14 = new int[5];
                    StringTokenizer var11 = new StringTokenizer(var8, "\t");
                    var11.nextToken();

                    for (int var12 = 0; var12 < 5; ++var12) {
                        var14[var12] = Integer.parseInt(var11.nextToken());
                    }

                    return var14;
                }
            }
        }
    }

    public synchronized void addPersonalScore(String var1, long var2, String var4) {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.addPersonalScore(\"" + var1 + "\"," + var2 + "," + "\"" + var4 + "\")");
        }

        if (this.aPersonalScore2649.newScore(var1, var2, var4) && this.anAutoPopups2664 != null) {
            this.anAutoPopups2664.personalRecord();
        }

    }

    public boolean setPlayerData(String var1, String var2) {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.setPlayerData(\"" + var1 + "\",\"" + var2 + "\")");
        }

        if (this.anInt2655 != 4) {
            return false;
        } else {
            boolean var3 = this.aClass146_2650.method2238(var1, var2);
            if (!var3) {
                return true;
            } else if (this.aBoolean2656) {
                return true;
            } else {
                this.method2248("savepd\t" + var1 + "\t" + var2);
                return true;
            }
        }
    }

    public String[][] getTopList(String var1, int var2) {
        return this.getTopList(var1, 1, var2);
    }

    public synchronized String[][] getTopList(String var1, int var2, int var3) {
        if (this.aBoolean2656) {
            return new String[0][0];
        } else {
            TopListUnit[] var4 = this.getTopListUnits(var1, var2, var3);
            if (var4 == null) {
                return (String[][]) null;
            } else {
                int var5 = var4.length;
                if (var5 == 0) {
                    return new String[0][0];
                } else {
                    int var6 = var4[0].method2260();
                    String[][] var7 = new String[var5][1 + var6];

                    for (int var8 = 0; var8 < var5; ++var8) {
                        var7[var8][0] = var4[var8].getName();

                        for (int var9 = 0; var9 < var6; ++var9) {
                            var7[var8][1 + var9] = var4[var8].getColumn(var9);
                        }
                    }

                    return var7;
                }
            }
        }
    }

    public TopListUnit[] getTopListUnits(String var1, int var2) {
        return this.getTopListUnits(var1, 1, var2);
    }

    public synchronized TopListUnit[] getTopListUnits(String var1, int var2, int var3) {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.getTopListUnits(\"" + var1 + "\"," + var2 + "," + var3 + ")");
        }

        if (this.anInt2655 != 4) {
            return null;
        } else if (this.aBoolean2656) {
            return new TopListUnit[0];
        } else {
            this.method2248("toplist\t" + var1 + "\t" + var2 + "\t" + var3);
            String var4 = this.method2251();
            if (var4 == null) {
                return null;
            } else if (var4.equals("nolist")) {
                return new TopListUnit[0];
            } else if (!var4.startsWith("ok\t")) {
                return null;
            } else {
                StringTokenizer var5 = new StringTokenizer(var4, "\t");
                var5.nextToken();
                int var6 = Integer.parseInt(var5.nextToken());
                int var7 = Integer.parseInt(var5.nextToken()) - 4;
                TopListUnit[] var8 = new TopListUnit[var6];

                for (int var9 = 0; var9 < var6; ++var9) {
                    var8[var9] = new TopListUnit(var5, var7);
                }

                return var8;
            }
        }
    }

    public void setUserData(String var1) {
        if (this.anInt2655 == 4) {
            this.aString2658 = var1;
            if (!this.aBoolean2656) {
                this.method2248("userdata\t" + var1);
            }
        }
    }

    public String getUserData() {
        return this.aString2658;
    }

    public Product getProduct(String var1) {
        return !this.isRegistered() ? null : (this.aProductHandler2652 == null ? null : this.aProductHandler2652.getProduct(var1));
    }

    public Product getProductForAnyOne(String var1) {
        return this.aProductHandler2652 == null ? null : this.aProductHandler2652.getProduct(var1);
    }

    public boolean userHaveAnyProduct(String var1) {
        return !this.isRegistered() ? false : (this.aProductHandler2652 == null ? false : this.aProductHandler2652.userHaveAnyProduct(var1));
    }

    public synchronized int buyProduct(Product var1) {
        String var2 = var1.getProductName();
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.buyProduct(...): \"" + var2 + "\"");
        }

        if (this.anInt2655 != 4) {
            return 11;
        } else if (this.aBoolean2656) {
            return 1;
        } else if (this.anInt2663 < var1.getProductPrice()) {
            return 51;
        } else {
            this.method2248("buy\t" + var2);
            String var3 = this.method2251();
            if (var3 == null) {
                return 12;
            } else if (!var3.startsWith("ok\t")) {
                if (var3.equals("nobalance")) {
                    return 51;
                } else if (var3.equals("failed")) {
                    return 52;
                } else {
                    this.method2249();
                    return 10;
                }
            } else {
                var1.userBoughtProduct();
                this.anInt2663 = Integer.parseInt(var3.substring(3));
                this.anAApplet2641.param.updateWebPageInfoBox(this.anInt2663, -1, -1);
                return 1;
            }
        }
    }

    public boolean awardBadge(String var1) {
        if (this.anInt2655 != 4) {
            return false;
        } else if (this.aBadgeHandler2651 == null) {
            return false;
        } else {
            Badge var2 = this.aBadgeHandler2651.awardBadge(var1);
            if (var2 == null) {
                return false;
            } else if (this.aBoolean2656) {
                return true;
            } else {
                this.method2248("ab\t" + this.method2252(var1, false));
                return true;
            }
        }
    }

    public boolean awardBadges(String var1, int var2, int var3) {
        if (this.anInt2655 != 4) {
            return false;
        } else if (this.aBadgeHandler2651 == null) {
            return false;
        } else {
            Badge[] var4 = this.aBadgeHandler2651.awardBadges(var1, var2, var3);
            if (var4 == null) {
                return false;
            } else if (this.aBoolean2656) {
                return true;
            } else {
                this.method2248("ab\t" + this.method2252(var1 + "\t" + var2 + "\t" + var3, false));
                return true;
            }
        }
    }

    public Tournament getTournament() {
        return this.aTournament2642;
    }

    public void quit() {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.quit()");
        }

        if (this.anInt2655 != 7) {
            if (this.anAutoPopups2664 != null) {
                this.anAutoPopups2664.close();
            }

            if (this.aBoolean2656) {
                this.anInt2655 = 7;
            } else {
                this.method2248("quit");
                this.method2249();
            }
        }
    }

    public String[] createOrderCode(String var1) {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.createOrderCode(\"" + var1 + "\")");
        }

        if (this.anInt2655 != 4) {
            return null;
        } else if (this.aBoolean2656) {
            return new String[]{"1234", "Sim: Instructions here (code=\"%1\")"};
        } else {
            this.method2248("occreate\t" + var1);
            String var2 = this.method2251();
            if (var2 == null) {
                return null;
            } else if (!var2.startsWith("ok\t")) {
                if (var2.equals("noproduct")) {
                    return null;
                } else if (var2.equals("error")) {
                    return null;
                } else {
                    this.method2249();
                    return null;
                }
            } else {
                var2 = var2.substring(3);
                String[] var3 = Tools.separateString(var2, "\t");
                return var3;
            }
        }
    }

    public boolean pollOrderCode(String var1) {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.pollOrderCode(\"" + var1 + "\")");
        }

        if (this.anInt2655 != 4) {
            return false;
        } else if (this.aBoolean2656) {
            return Math.random() < 0.1D;
        } else {
            this.method2248("ocpoll\t" + var1);
            String var2 = this.method2251();
            return var2 == null ? false : var2.equals("paid");
        }
    }

    public void cancelOrderCode(String var1) {
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("SingleClient.cancelOrderCode(\"" + var1 + "\")");
        }

        if (this.anInt2655 == 4) {
            if (!this.aBoolean2656) {
                this.method2248("occancel\t" + var1);
                this.method2251();
            }
        }
    }

    private void method2248(String var1) {
        if (this.aConnection2647 != null) {
            if (this.aSingleGame2644.isDebugMode()) {
                System.out.println("C -> " + var1);
            }

            var1 = this.aClass147_2643.method2241(var1);
            this.aClass147_2643.method2240();
            if (this.aSingleGame2644.isDebugMode()) {
                System.out.println("C => " + var1);
            }

            this.aString2653 = var1;
            this.aConnection2647.writeData(var1);
        }
    }

    private void method2249() {
        if (this.anInt2655 < 6) {
            this.anInt2655 = 6;
            if (this.aConnection2647 != null) {
                this.aConnection2647.disconnect();
            }

        }
    }

    private void method2250(String var1) {
        Vector var2 = this.aVector2648;
        synchronized (this.aVector2648) {
            this.aVector2648.addElement(var1);
        }
    }

    private String method2251() {
        while (this.aVector2648.size() == 0 && this.anInt2655 <= 4) {
            Tools.sleep(100L);
        }

        if (this.anInt2655 >= 5) {
            this.method2249();
            return null;
        } else {
            Vector var1 = this.aVector2648;
            synchronized (this.aVector2648) {
                String var2 = (String) ((String) this.aVector2648.elementAt(0));
                this.aVector2648.removeElementAt(0);
                return var2;
            }
        }
    }

    private String method2252(String var1, boolean var2) {
        char var3 = this.method2253(var1, '\t');
        char var4 = this.method2253(var1, var3);
        String var5 = var1.replace('\t', var3);
        var5 = var5.replace('1', var4);
        int var6 = 1 + (int) (Math.random() * 9.0D);
        int var7 = var5.length();
        StringBuffer var8 = new StringBuffer(var7 + 3);

        int var9;
        for (var9 = 1; var9 < var7; var9 += 2) {
            var8.append((char) (var5.charAt(var9) + var6));
        }

        for (var9 = 0; var9 < var7; var9 += 2) {
            var8.append((char) (var5.charAt(var9) + var6));
        }

        var8.append(var3);
        var8.append(var4);
        var8.append((char) (34 + var6));
        var5 = var8.toString();
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("LightObfuscate1: \"" + var1 + "\" -> \"" + var5 + "\"");
        }

        return var2 ? this.method2255(var5) : var5;
    }

    private char method2253(String var1, char var2) {
        char var3;
        for (var3 = (char) (35 + (int) (Math.random() * 10.0D)); var3 == var2 || !this.method2254(var1, var3); ++var3) {
            ;
        }

        return var3;
    }

    private boolean method2254(String var1, char var2) {
        int var3 = var1.length();

        for (int var4 = 0; var4 < var3; ++var4) {
            if (var1.charAt(var4) == var2) {
                return false;
            }
        }

        return true;
    }

    private String method2255(String var1) {
        int var2 = 2 + (int) (Math.random() * 10.0D);
        int var3 = var1.length();
        StringBuffer var4 = new StringBuffer(var3 + 1);
        var4.append((char) (43 + var2));

        for (int var5 = 0; var5 < var3; ++var5) {
            var4.append((char) (var1.charAt(var5) + var2));
        }

        String var6 = var4.toString();
        if (this.aSingleGame2644.isDebugMode()) {
            System.out.println("LightObfuscate2: \"" + var1 + "\" -> \"" + var6 + "\"");
        }

        return var6;
    }

    private void method2256(String var1) {
        this.aPersonalScore2649 = new PersonalScore(var1);
    }

    private void method2257(String var1) {
        int var2 = var1.indexOf(9);
        this.aClass146_2650.method2238(var1.substring(0, var2), var1.substring(var2 + 1));
    }

    private void method2258(String var1) {
        this.aBadgeHandler2651 = new BadgeHandler(this.anAApplet2641, var1);
    }

    private void method2259(String var1) {
        this.aProductHandler2652 = new ProductHandler();
        StringTokenizer var2 = new StringTokenizer(var1, "\t");
        int var3 = Integer.parseInt(var2.nextToken());

        for (int var5 = 0; var5 < var3; ++var5) {
            Product var4 = new Product(var2.nextToken(), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()));
            this.aProductHandler2652.addProduct(var4);
        }

    }
}
