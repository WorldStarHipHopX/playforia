package com.aapeli.singleclient;

import com.aapeli.applet.AApplet;
import com.aapeli.client.AutoPopups;
import com.aapeli.client.Badge;
import com.aapeli.client.BadgeHandler;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.PersonalScore;
import com.aapeli.client.PersonalScoreUnit;
import com.aapeli.client.TextManager;
import com.aapeli.client.Tournament;
import com.aapeli.connection.ConnListener;
import com.aapeli.connection.Connection;
import com.aapeli.credit.Product;
import com.aapeli.credit.ProductHandler;
import com.aapeli.tools.Tools;

import java.util.StringTokenizer;
import java.util.Vector;

public class SingleClient implements ConnListener {

    public static final int anInt2380 = 1;
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
    public static final int USERLEVEL_ADMIN = 3;
    public static final int FINISHED_NOTIME = 0;
    public static final int FINISHED_NOTSTARTED = -1;
    public static final int FINISHED_OVERFLOW = -2;
    public static final int FINISHED_INVALIDSTATUS = -3;
    public static final int FINISHED_SERVERERROR = -4;
    private AApplet gameApplet;
    private Parameters aParameters2382;
    private Tournament aTournament2383;
    private Class105 aClass105_2384;
    private SingleGame singleGame;
    private String aString2386;
    private int anInt2387;
    private Connection aConnection2388;
    private Vector aVector2389;
    private PersonalScore aPersonalScore2390;
    private HashtableContainer aHashtableContainer_2391;
    private BadgeHandler aBadgeHandler2392;
    private ProductHandler aProductHandler2393;
    private String aString2394;
    private String aString2395;
    private int anInt2396;
    private boolean aBoolean2397;
    private String aString2398;
    private String aString2399;
    private String aString2400;
    private String aString2401;
    private int anInt2402;
    private int anInt2403;
    private int anInt2404;
    private AutoPopups autoPopups;
    private static final String[] aStringArray2406 = new String[81];


    public SingleClient(Parameters var1, SingleGame var2, String var3, int var4, String[] var5) {
        this((AApplet) null, var1, var2, var3, var4, var5);
    }

    public SingleClient(AApplet var1, SingleGame var2, String var3, int var4, String[] var5) {
        this(var1, var1.param, var2, var3, var4, var5);
    }

    private SingleClient(AApplet var1, Parameters var2, SingleGame var3, String var4, int var5, String[] var6) {
        this.gameApplet = var1;
        this.aParameters2382 = var2;
        this.singleGame = var3;
        this.aString2386 = var4;
        this.anInt2387 = var5;
        this.aPersonalScore2390 = new PersonalScore();
        this.aHashtableContainer_2391 = new HashtableContainer();
        this.aVector2389 = new Vector();
        this.aString2398 = this.aString2399 = this.aString2394 = this.aString2395 = null;
        this.anInt2402 = 0;
        this.anInt2403 = 0;
        this.anInt2404 = 0;
        this.aString2400 = this.aString2401 = "-";
        this.anInt2396 = 1;
        this.aBoolean2397 = false;
        this.aTournament2383 = Tournament.getTournament(var2, var6);
        this.aClass105_2384 = new Class105("DolphinTherapy");
    }

    public void dataReceived(String var1) {
        try {
            if (this.anInt2396 <= 4) {
                if (this.singleGame.isDebugMode()) {
                    System.out.println("C <= " + var1);
                }

                var1 = this.aClass105_2384.method1852(var1);
                if (this.singleGame.isDebugMode()) {
                    System.out.println("C <- " + var1);
                }

                this.method1860(var1);
                this.aString2395 = var1;
            }
        } catch (Exception var5) {
            Exception var2 = var5;
            if (this.anInt2396 <= 4) {
                this.anInt2396 = 5;
                if (this.singleGame.isDebugMode()) {
                    System.out.println("SingleClient.run(): e=\"" + var5 + "\"");
                    var5.printStackTrace();
                }

                try {
                    this.method1858("error-debug\t" + var2.toString().trim() + "\t" + var1.replace('\t', '\\') + "\t" + this.aString2395.replace('\t', '\\') + "\t" + this.aString2394.replace('\t', '\\'));
                } catch (Exception var4) {
                    ;
                }
            }
        }

    }

    public void connectionLost(int var1) {
        if (var1 == 2 || var1 == 3) {
            this.singleGame.connectionError();
        }

        this.anInt2396 = 7;
    }

    public void notifyConnectionDown() {
    }

    public void notifyConnectionUp() {
    }

    public void simulateServerConnection() {
        if (this.anInt2396 == 1) {
            this.aBoolean2397 = true;
        }
    }

    public void enableAutoPopups() {
        if (this.gameApplet != null) {
            this.autoPopups = new AutoPopups(this.gameApplet);
        }

    }

    public void enableAutoPopups(Parameters var1, TextManager var2, ImageManager var3) {
        this.autoPopups = new AutoPopups(var1, var2, var3);
    }

    public synchronized int connect(boolean var1) {
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.openConnection(" + var1 + ")");
        }

        if (this.anInt2396 != 1) {
            return 11;
        } else if (this.aBoolean2397) {
            this.anInt2396 = var1 ? 2 : 3;
            return 1;
        } else {
            String[] var2 = new String[]{"version\t"};
            if (this.gameApplet != null) {
                this.aConnection2388 = new Connection(this.gameApplet, this, var2);
            } else {
                this.aConnection2388 = new Connection(this.aParameters2382, this, var2);
            }

            if (!this.aConnection2388.openConnection()) {
                this.method1859();
                return 10;
            } else {
                this.method1858("version\t20");
                String var3 = this.method1861();
                if (var3 == null) {
                    return 12;
                } else if (!var3.equals("versionok")) {
                    this.method1859();
                    return 20;
                } else {
                    this.method1858("gamename\t" + this.aString2386 + "\t" + this.anInt2387);
                    var3 = this.method1861();
                    if (var3 == null) {
                        return 12;
                    } else if (!var3.equals("ok")) {
                        this.method1859();
                        return var3.equals("error") ? 20 : 10;
                    } else {
                        if (var1) {
                            this.method1858("logintype\treg");
                            this.anInt2396 = 2;
                        } else {
                            this.method1858("logintype\tnr");
                            this.anInt2396 = 3;
                        }

                        var3 = this.method1861();
                        if (!var3.equals("ok")) {
                            this.method1859();
                            return var3.equals("serverfull") ? 21 : 10;
                        } else {
                            String var4 = null;
                            if (this.aTournament2383 != null) {
                                var4 = this.aTournament2383.getTicket();
                            } else {
                                var4 = this.aParameters2382.getTicket();
                            }

                            if (var4 != null) {
                                this.method1858("ticket\t" + var4);
                                var3 = this.method1861();
                                if (!var3.equals("ok")) {
                                    this.method1859();
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
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.loginAsRegistered(\"" + var1 + "\")");
        }

        if (this.anInt2396 != 2) {
            return 11;
        } else if (this.aBoolean2397) {
            this.aString2398 = "Simulation";
            this.anInt2402 = 1;
            this.anInt2403 = 0;
            this.anInt2404 = 0;
            this.method1866((String) null);
            this.anInt2396 = 4;
            return 1;
        } else {
            this.method1858("reglogin\t" + var1);
            String var2 = this.method1861();
            if (var2 == null) {
                return 12;
            } else if (!var2.startsWith("ok\t")) {
                if (var2.equals("failed")) {
                    this.anInt2396 = 3;
                    return 30;
                } else if (var2.equals("serverfull")) {
                    this.method1859();
                    return 21;
                } else {
                    this.method1859();
                    return 10;
                }
            } else {
                StringTokenizer var3 = new StringTokenizer(var2, "\t");
                var3.nextToken();
                this.aString2398 = var3.nextToken();
                String var4 = var3.nextToken();
                this.anInt2402 = 1;
                if (var4.indexOf(86) >= 0) {
                    this.anInt2402 = 2;
                }

                this.anInt2403 = 0;
                if (var4.indexOf(83) >= 0) {
                    this.anInt2403 = 1;
                }

                if (var4.indexOf(65) >= 0) {
                    this.anInt2403 = 2;
                }

                this.anInt2404 = Integer.parseInt(var3.nextToken());
                if (var3.hasMoreTokens()) {
                    this.aString2399 = var3.nextToken();
                }

                var2 = this.method1861();
                if (var2 == null) {
                    return 12;
                } else if (!var2.startsWith("bitmaps\t")) {
                    return 10;
                } else {
                    var3 = new StringTokenizer(var2, "\t");
                    var3.nextToken();
                    this.aString2400 = var3.nextToken();
                    this.aString2401 = var3.nextToken();
                    var2 = this.method1861();
                    if (var2 == null) {
                        return 12;
                    } else if (!var2.startsWith("ps\t")) {
                        return 10;
                    } else {
                        this.method1866(var2.substring(3));
                        var2 = this.method1861();
                        if (var2 == null) {
                            return 12;
                        } else if (!var2.startsWith("badges\t")) {
                            return 10;
                        } else {
                            this.method1868(var2.substring(7));
                            var2 = this.method1861();
                            if (var2 == null) {
                                return 12;
                            } else {
                                if (var2.startsWith("products\t")) {
                                    this.method1869(var2.substring(9));
                                }

                                this.anInt2396 = 4;
                                return 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized int autoLoginAsGuest() {
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.autoLoginAsGuest()");
        }

        if (this.anInt2396 != 3) {
            return 11;
        } else if (this.aBoolean2397) {
            this.aString2398 = "~Simulation";
            this.anInt2402 = 0;
            this.anInt2403 = 0;
            this.anInt2404 = 0;
            this.anInt2396 = 4;
            return 1;
        } else {
            this.method1858("autologin");
            String var1 = this.method1861();
            if (var1 == null) {
                return 12;
            } else if (!var1.startsWith("ok\t")) {
                this.method1859();
                return 10;
            } else {
                this.aString2398 = var1.substring(3);
                var1 = this.method1861();
                if (var1 == null) {
                    return 12;
                } else if (!var1.startsWith("badges\t")) {
                    return 10;
                } else {
                    this.method1868(var1.substring(7));
                    var1 = this.method1861();
                    if (var1 == null) {
                        return 12;
                    } else {
                        if (var1.startsWith("products\t")) {
                            this.method1869(var1.substring(9));
                        }

                        this.anInt2402 = 0;
                        this.anInt2403 = 0;
                        this.anInt2404 = 0;
                        this.anInt2396 = 4;
                        return 1;
                    }
                }
            }
        }
    }

    public synchronized int loginAsGuest(String var1) {
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.loginAsGuest(\"" + var1 + "\")");
        }

        if (this.anInt2396 != 3) {
            return 11;
        } else if (this.aBoolean2397) {
            this.aString2398 = "~Simulation";
            this.anInt2402 = 0;
            this.anInt2403 = 0;
            this.anInt2404 = 0;
            this.anInt2396 = 4;
            return 1;
        } else {
            this.method1858("login\t" + var1);
            String var2 = this.method1861();
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
                    this.method1859();
                    return 10;
                }
            } else {
                this.aString2398 = var2.substring(3);
                var2 = this.method1861();
                if (var2 == null) {
                    return 12;
                } else if (!var2.startsWith("badges\t")) {
                    return 10;
                } else {
                    this.method1868(var2.substring(7));
                    var2 = this.method1861();
                    if (var2 == null) {
                        return 12;
                    } else {
                        if (var2.startsWith("products\t")) {
                            this.method1869(var2.substring(9));
                        }

                        this.anInt2402 = 0;
                        this.anInt2403 = 0;
                        this.anInt2404 = 0;
                        this.anInt2396 = 4;
                        return 1;
                    }
                }
            }
        }
    }

    public String getNick() {
        return this.aString2398;
    }

    public int getUserLevel() {
        return this.anInt2402;
    }

    public boolean isRegistered() {
        return this.anInt2402 >= 1;
    }

    public boolean isVip() {
        return this.anInt2402 >= 2;
    }

    public boolean isSheriff() {
        return this.anInt2403 >= 1;
    }

    public boolean isAdmin() {
        return this.anInt2403 >= 2;
    }

    public PersonalScoreUnit getPersonalScore() {
        return this.aPersonalScore2390.getPersonalScore();
    }

    public PersonalScoreUnit getPersonalScore(String var1) {
        return this.aPersonalScore2390.getPersonalScore(var1);
    }

    public synchronized int requestPlayerData(String[] var1) {
        if (this.anInt2396 != 4) {
            return 11;
        } else if (this.aBoolean2397) {
            return 1;
        } else {
            String var2 = "reqpd";

            for (int var3 = 0; var3 < var1.length; ++var3) {
                var2 = var2 + "\t" + var1[var3];
            }

            this.method1858(var2);

            while (true) {
                var2 = this.method1861();
                if (var2 == null) {
                    return 12;
                }

                if (var2.equals("endpd")) {
                    return 1;
                }

                if (!var2.startsWith("pd\t")) {
                    return 10;
                }

                this.method1867(var2.substring(3));
            }
        }
    }

    public String getPlayerData(String var1) {
        return this.aHashtableContainer_2391.get(var1);
    }

    public int getCredits() {
        return this.anInt2404;
    }

    public int refreshCredits() {
        if (this.anInt2396 != 4) {
            return -1;
        } else if (this.aBoolean2397) {
            return this.anInt2404;
        } else {
            this.method1858("credits");
            String var1 = this.method1861();
            if (var1 == null) {
                return -1;
            } else if (!var1.startsWith("credits\t")) {
                return -1;
            } else {
                this.anInt2404 = Integer.parseInt(var1.substring(8));
                this.aParameters2382.updateWebPageInfoBox(this.anInt2404, -1, -1);
                return this.anInt2404;
            }
        }
    }

    public String getBitmapUrlSmall() {
        return this.aString2400;
    }

    public String getBitmapUrlMedium() {
        return this.aString2401;
    }

    public void gameStarted() {
        if (this.anInt2396 == 4) {
            if (!this.aBoolean2397) {
                this.method1858("started");
            }
        }
    }

    public int gameNormallyFinished() {
        return this.gameNormallyFinished(false);
    }

    public int gameNormallyFinished(boolean var1) {
        if (this.anInt2396 != 4) {
            return -3;
        } else if (this.aBoolean2397) {
            return var1 ? 1 : 0;
        } else if (!var1) {
            this.method1858("finished");
            if (this.autoPopups != null) {
                this.autoPopups.gameFinished(false);
            }

            return 0;
        } else {
            String var2;
            synchronized (this) {
                this.method1858("finished\ttime");
                var2 = this.method1861();
            }

            if (var2 == null) {
                return -4;
            } else if (!var2.startsWith("ok\t")) {
                if (var2.equals("notstarted")) {
                    return -1;
                } else if (var2.equals("overflow")) {
                    return -2;
                } else {
                    this.method1859();
                    return -4;
                }
            } else {
                if (this.autoPopups != null) {
                    this.autoPopups.gameFinished(false);
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
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.addScore(\"" + var1 + "\"," + var2 + ",...)");
        }

        if (this.anInt2396 != 4) {
            return null;
        } else {
            if (this.gameApplet != null) {
                this.gameApplet.callJavaScriptJSON("{\"scorenotify\":{\"subgame\":\"" + var1 + "\",\"compscore\":\"" + var2 + "\"}}");
            }

            int var9;
            if (this.aBoolean2397) {
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
                var8 = this.method1862(var8, true);
                this.method1858("score\t" + var8);
                var8 = this.method1861();
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
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.addPersonalScore(\"" + var1 + "\"," + var2 + "," + "\"" + var4 + "\")");
        }

        if (this.aPersonalScore2390.newScore(var1, var2, var4) && this.autoPopups != null) {
            this.autoPopups.personalRecord();
        }

    }

    public boolean setPlayerData(String var1, String var2) {
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.setPlayerData(\"" + var1 + "\",\"" + var2 + "\")");
        }

        if (this.anInt2396 != 4) {
            return false;
        } else {
            boolean var3 = this.aHashtableContainer_2391.contains(var1, var2);
            if (!var3) {
                return true;
            } else if (this.aBoolean2397) {
                return true;
            } else {
                this.method1858("savepd\t" + var1 + "\t" + var2);
                return true;
            }
        }
    }

    public String[][] getTopList(String var1, int var2) {
        return this.getTopList(var1, 1, var2);
    }

    public synchronized String[][] getTopList(String var1, int var2, int var3) {
        if (this.aBoolean2397) {
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
                    int var6 = var4[0].getExtraColumnsCount();
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
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.getTopListUnits(\"" + var1 + "\"," + var2 + "," + var3 + ")");
        }

        if (this.anInt2396 != 4) {
            return null;
        } else if (this.aBoolean2397) {
            return new TopListUnit[0];
        } else {
            this.method1858("toplist\t" + var1 + "\t" + var2 + "\t" + var3);
            String var4 = this.method1861();
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
        if (this.anInt2396 == 4) {
            this.aString2399 = var1;
            if (!this.aBoolean2397) {
                this.method1858("userdata\t" + var1);
            }
        }
    }

    public String getUserData() {
        return this.aString2399;
    }

    public Product getProduct(String var1) {
        return !this.isRegistered() ? null : (this.aProductHandler2393 == null ? null : this.aProductHandler2393.getProduct(var1));
    }

    public Product getProductForAnyOne(String var1) {
        return this.aProductHandler2393 == null ? null : this.aProductHandler2393.getProduct(var1);
    }

    public Product[] getMultipleProducts(String var1) {
        return !this.isRegistered() ? null : (this.aProductHandler2393 == null ? null : this.aProductHandler2393.getMultipleProducts(var1));
    }

    public boolean userHaveAnyProduct(String var1) {
        return !this.isRegistered() ? false : (this.aProductHandler2393 == null ? false : this.aProductHandler2393.userHaveAnyProduct(var1));
    }

    public synchronized int buyProduct(Product var1) {
        String var2 = var1.getProductName();
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.buyProduct(...): \"" + var2 + "\"");
        }

        if (this.anInt2396 != 4) {
            return 11;
        } else if (this.aBoolean2397) {
            return 1;
        } else if (this.anInt2404 < var1.getProductPrice()) {
            return 51;
        } else {
            this.method1858("buy\t" + var2);
            String var3 = this.method1861();
            if (var3 == null) {
                return 12;
            } else if (!var3.startsWith("ok\t")) {
                if (var3.equals("nobalance")) {
                    return 51;
                } else if (var3.equals("failed")) {
                    return 52;
                } else {
                    this.method1859();
                    return 10;
                }
            } else {
                var1.userBoughtProduct();
                this.anInt2404 = Integer.parseInt(var3.substring(3));
                this.aParameters2382.updateWebPageInfoBox(this.anInt2404, -1, -1);
                return 1;
            }
        }
    }

    public boolean awardBadge(String var1) {
        if (this.anInt2396 != 4) {
            return false;
        } else if (this.aBadgeHandler2392 == null) {
            return false;
        } else {
            Badge var2 = this.aBadgeHandler2392.awardBadge(var1);
            if (var2 == null) {
                return false;
            } else if (this.aBoolean2397) {
                return true;
            } else {
                this.method1858("ab\t" + this.method1862(var1, false));
                return true;
            }
        }
    }

    public boolean awardBadges(String var1, int var2, int var3) {
        if (this.anInt2396 != 4) {
            return false;
        } else if (this.aBadgeHandler2392 == null) {
            return false;
        } else {
            Badge[] var4 = this.aBadgeHandler2392.awardBadges(var1, var2, var3);
            if (var4 == null) {
                return false;
            } else if (this.aBoolean2397) {
                return true;
            } else {
                this.method1858("ab\t" + this.method1862(var1 + "\t" + var2 + "\t" + var3, false));
                return true;
            }
        }
    }

    public Badge getBadge(String var1) {
        return this.aBadgeHandler2392 == null ? null : this.aBadgeHandler2392.getBadge(var1);
    }

    public Tournament getTournament() {
        return this.aTournament2383;
    }

    public void quit() {
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.quit()");
        }

        if (this.anInt2396 != 7) {
            if (this.autoPopups != null) {
                this.autoPopups.close();
            }

            if (this.aBoolean2397) {
                this.anInt2396 = 7;
            } else {
                this.method1858("quit");
                this.method1859();
            }
        }
    }

    public String[] createOrderCode(String var1) {
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.createOrderCode(\"" + var1 + "\")");
        }

        if (this.anInt2396 != 4) {
            return null;
        } else if (this.aBoolean2397) {
            return new String[]{"1234", "Sim: Instructions here (code=\"%1\")"};
        } else {
            this.method1858("occreate\t" + var1);
            String var2 = this.method1861();
            if (var2 == null) {
                return null;
            } else if (!var2.startsWith("ok\t")) {
                if (var2.equals("noproduct")) {
                    return null;
                } else if (var2.equals("error")) {
                    return null;
                } else {
                    this.method1859();
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
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.pollOrderCode(\"" + var1 + "\")");
        }

        if (this.anInt2396 != 4) {
            return false;
        } else if (this.aBoolean2397) {
            return Math.random() < 0.1D;
        } else {
            this.method1858("ocpoll\t" + var1);
            String var2 = this.method1861();
            return var2 == null ? false : var2.equals("paid");
        }
    }

    public void cancelOrderCode(String var1) {
        if (this.singleGame.isDebugMode()) {
            System.out.println("SingleClient.cancelOrderCode(\"" + var1 + "\")");
        }

        if (this.anInt2396 == 4) {
            if (!this.aBoolean2397) {
                this.method1858("occancel\t" + var1);
                this.method1861();
            }
        }
    }

    private void method1858(String var1) {
        if (this.aConnection2388 != null) {
            if (this.singleGame.isDebugMode()) {
                System.out.println("C -> " + var1);
            }

            var1 = this.aClass105_2384.method1851(var1);
            this.aClass105_2384.method1850();
            if (this.singleGame.isDebugMode()) {
                System.out.println("C => " + var1);
            }

            this.aString2394 = var1;
            this.aConnection2388.writeData(var1);
        }
    }

    private void method1859() {
        if (this.anInt2396 < 6) {
            this.anInt2396 = 6;
            if (this.aConnection2388 != null) {
                this.aConnection2388.closeConnection();
            }

        }
    }

    private void method1860(String var1) {
        Vector var2 = this.aVector2389;
        synchronized (this.aVector2389) {
            this.aVector2389.addElement(var1);
        }
    }

    private String method1861() {
        while (this.aVector2389.size() == 0 && this.anInt2396 <= 4) {
            Tools.sleep(100L);
        }

        if (this.anInt2396 >= 5) {
            this.method1859();
            return null;
        } else {
            Vector var1 = this.aVector2389;
            synchronized (this.aVector2389) {
                String var2 = (String) ((String) this.aVector2389.elementAt(0));
                this.aVector2389.removeElementAt(0);
                return var2;
            }
        }
    }

    private String method1862(String var1, boolean var2) {
        char var3 = this.method1863(var1, '\t');
        char var4 = this.method1863(var1, var3);
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
        if (this.singleGame.isDebugMode()) {
            System.out.println("LightObfuscate1: \"" + var1 + "\" -> \"" + var5 + "\"");
        }

        return var2 ? this.method1865(var5) : var5;
    }

    private char method1863(String var1, char var2) {
        char var3;
        for (var3 = (char) (35 + (int) (Math.random() * 10.0D)); var3 == var2 || !this.method1864(var1, var3); ++var3) {
            ;
        }

        return var3;
    }

    private boolean method1864(String var1, char var2) {
        int var3 = var1.length();

        for (int var4 = 0; var4 < var3; ++var4) {
            if (var1.charAt(var4) == var2) {
                return false;
            }
        }

        return true;
    }

    private String method1865(String var1) {
        int var2 = 2 + (int) (Math.random() * 10.0D);
        int var3 = var1.length();
        StringBuffer var4 = new StringBuffer(var3 + 1);
        var4.append((char) (43 + var2));

        for (int var5 = 0; var5 < var3; ++var5) {
            var4.append((char) (var1.charAt(var5) + var2));
        }

        String var6 = var4.toString();
        if (this.singleGame.isDebugMode()) {
            System.out.println("LightObfuscate2: \"" + var1 + "\" -> \"" + var6 + "\"");
        }

        return var6;
    }

    private void method1866(String var1) {
        this.aPersonalScore2390 = new PersonalScore(var1);
    }

    private void method1867(String var1) {
        int var2 = var1.indexOf(9);
        this.aHashtableContainer_2391.contains(var1.substring(0, var2), var1.substring(var2 + 1));
    }

    private void method1868(String var1) {
        this.aBadgeHandler2392 = new BadgeHandler(this.gameApplet, var1);
    }

    private void method1869(String var1) {
        this.aProductHandler2393 = new ProductHandler();
        StringTokenizer var2 = new StringTokenizer(var1, "\t");
        int var3 = Integer.parseInt(var2.nextToken());

        for (int var5 = 0; var5 < var3; ++var5) {
            Product var4 = new Product(var2.nextToken(), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()), Integer.parseInt(var2.nextToken()));
            this.aProductHandler2393.addProduct(var4);
        }

    }

    static {
        aStringArray2406[0] = "\")";
        aStringArray2406[1] = "SingleClient.addPersonalScore(\"";
        aStringArray2406[2] = "\",";
        aStringArray2406[3] = "paid";
        aStringArray2406[4] = "SingleClient.pollOrderCode(\"";
        aStringArray2406[5] = "ocpoll\t";
        aStringArray2406[6] = "\"}}";
        aStringArray2406[7] = "{\"scorenotify\":{\"subgame\":\"";
        aStringArray2406[8] = "SingleClient.addScore(\"";
        aStringArray2406[9] = "score\t";
        aStringArray2406[10] = "\",\"compscore\":\"";
        aStringArray2406[11] = ",...)";
        aStringArray2406[12] = "ok\t";
        aStringArray2406[13] = "started";
        aStringArray2406[14] = "SingleClient.quit()";
        aStringArray2406[15] = "quit";
        aStringArray2406[16] = "savepd\t";
        aStringArray2406[17] = "\",\"";
        aStringArray2406[18] = "SingleClient.setPlayerData(\"";
        aStringArray2406[19] = "versionok";
        aStringArray2406[20] = "ok";
        aStringArray2406[21] = "logintype\treg";
        aStringArray2406[22] = "logintype\tnr";
        aStringArray2406[23] = "error";
        aStringArray2406[24] = "SingleClient.openConnection(";
        aStringArray2406[25] = "version\t";
        aStringArray2406[26] = "version\t20";
        aStringArray2406[27] = "ticket\t";
        aStringArray2406[28] = "serverfull";
        aStringArray2406[29] = "gamename\t";
        aStringArray2406[30] = "failed";
        aStringArray2406[31] = "nobalance";
        aStringArray2406[32] = "buy\t";
        aStringArray2406[33] = "SingleClient.buyProduct(...): \"";
        aStringArray2406[34] = "finished";
        aStringArray2406[35] = "notstarted";
        aStringArray2406[36] = "finished\ttime";
        aStringArray2406[37] = "overflow";
        aStringArray2406[38] = "\" -> \"";
        aStringArray2406[39] = "LightObfuscate1: \"";
        aStringArray2406[40] = "ab\t";
        aStringArray2406[41] = "autologin";
        aStringArray2406[42] = "~Simulation";
        aStringArray2406[43] = "products\t";
        aStringArray2406[44] = "badges\t";
        aStringArray2406[45] = "SingleClient.autoLoginAsGuest()";
        aStringArray2406[46] = "login\t";
        aStringArray2406[47] = "toolong";
        aStringArray2406[48] = "forbidden";
        aStringArray2406[49] = "inuse";
        aStringArray2406[50] = "SingleClient.loginAsGuest(\"";
        aStringArray2406[51] = "tooshort";
        aStringArray2406[52] = "C -> ";
        aStringArray2406[53] = "C => ";
        aStringArray2406[54] = "Simulation";
        aStringArray2406[55] = "ps\t";
        aStringArray2406[56] = "SingleClient.loginAsRegistered(\"";
        aStringArray2406[57] = "bitmaps\t";
        aStringArray2406[58] = "reglogin\t";
        aStringArray2406[59] = "reqpd";
        aStringArray2406[60] = "endpd";
        aStringArray2406[61] = "pd\t";
        aStringArray2406[62] = "SingleClient.getTopListUnits(\"";
        aStringArray2406[63] = "nolist";
        aStringArray2406[64] = "toplist\t";
        aStringArray2406[65] = "C <- ";
        aStringArray2406[66] = "C <= ";
        aStringArray2406[67] = "SingleClient.run(): e=\"";
        aStringArray2406[68] = "error-debug\t";
        aStringArray2406[69] = "occancel\t";
        aStringArray2406[70] = "SingleClient.cancelOrderCode(\"";
        aStringArray2406[71] = "credits\t";
        aStringArray2406[72] = "credits";
        aStringArray2406[73] = "LightObfuscate2: \"";
        aStringArray2406[74] = "userdata\t";
        aStringArray2406[75] = "1234";
        aStringArray2406[76] = "SingleClient.createOrderCode(\"";
        aStringArray2406[77] = "Sim: Instructions here (code=\"%1\")";
        aStringArray2406[78] = "occreate\t";
        aStringArray2406[79] = "noproduct";
        aStringArray2406[80] = "DolphinTherapy";
    }
}
