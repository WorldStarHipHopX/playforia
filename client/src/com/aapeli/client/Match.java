package com.aapeli.client;

import com.aapeli.client.Parameters;

import java.applet.Applet;
import java.util.StringTokenizer;

public class Match {

    public static final int STATUS_NOMATCH = 0;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_MATCH = 2;
    public static final int ROLE_NONE = -1;
    public static final int ROLE_CHALLENGER = 1;
    public static final int ROLE_CHALLENGED = 0;
    private int anInt1383;
    private int anInt1384;
    private int anInt1385;
    private int anInt1386;
    private int anInt1387;
    private String aString1388;
    private String aString1389;
    private String aString1390;
    private int[] anIntArray1391;
    private static final String[] aStringArray1392 = new String[17];


    public Match(Parameters var1, int var2, int var3) {
        this(var1, 0, var2, var3);
    }

    public Match(Parameters var1, int var2, int var3, int var4) {
        this.anInt1383 = this.method1618(var1, var2, var3, var4);
    }

    public int getStatus() {
        return this.anInt1383;
    }

    public int getMatchId() {
        return this.anInt1384;
    }

    public int getSubGame() {
        return this.anInt1385;
    }

    public int getPlayerCount() {
        return this.anInt1386;
    }

    public boolean isChallengeGame() {
        return this.anInt1387 != -1 && this.aString1388 != null;
    }

    public boolean isChallenger() {
        return this.anInt1387 == 1;
    }

    public String getOpponent() {
        return this.aString1388;
    }

    public String getGameName() {
        return this.aString1389;
    }

    public String getGamePassword() {
        return this.aString1390;
    }

    public int[] getSettings() {
        return this.anIntArray1391;
    }

    public boolean isChallengeAcceptable(int var1, String var2) {
        return this.anInt1386 != 2 ? false : (this.anInt1387 != 0 ? false : (var1 != this.anInt1384 ? false : var2.equalsIgnoreCase(this.aString1388)));
    }

    public boolean isChallengeAcceptable(int var1, int var2, String var3) {
        return !this.isChallengeAcceptable(var1, var3) ? false : var2 == this.anInt1385;
    }

    private int method1618(Parameters var1, int var2, int var3, int var4) {
        Applet var5 = var1.getApplet();
        String var6 = var5.getParameter("match_data");
        String var7 = var5.getParameter("match_challenge");
        String var8 = var5.getParameter("match_string");
        String var9 = var5.getParameter("match_settings");
        if (var6 == null && var7 == null && var8 == null && var9 == null) {
            return 0;
        } else {
            try {
                if (var1.getSession() == null) {
                    throw new Exception("Match game without user session");
                } else {
                    this.method1619(var6, var2, var3);
                    this.method1620(var7);
                    this.method1621(var8);
                    this.method1622(var9, var4);
                    return 2;
                }
            } catch (Exception var11) {
                return 1;
            }
        }
    }

    private void method1619(String var1, int var2, int var3) throws Exception {
        StringTokenizer var4 = new StringTokenizer(var1, ",");
        this.anInt1384 = Integer.parseInt(var4.nextToken());
        if (this.anInt1384 <= 0) {
            throw new Exception("Invalid match id (" + this.anInt1384 + ")");
        } else {
            if (var2 > 0) {
                this.anInt1385 = Integer.parseInt(var4.nextToken());
                if (this.anInt1385 < 0 || this.anInt1385 >= var2) {
                    throw new Exception("Invalid subgame (" + this.anInt1385 + ")");
                }
            } else {
                this.anInt1385 = -1;
            }

            this.anInt1386 = Integer.parseInt(var4.nextToken());
            if (this.anInt1386 >= 2 && this.anInt1386 <= var3) {
                if (var4.hasMoreTokens()) {
                    throw new Exception("Too much data in \'match_data\' (\"" + var1 + "\")");
                }
            } else {
                throw new Exception("Invalid playercount (" + this.anInt1386 + ")");
            }
        }
    }

    private void method1620(String var1) throws Exception {
        if (this.anInt1386 > 2 && var1 != null) {
            throw new Exception("Challenge-data set in 3+ players game");
        } else if (this.anInt1386 <= 2 && var1 != null) {
            StringTokenizer var2 = new StringTokenizer(var1, ",");
            this.anInt1387 = Integer.parseInt(var2.nextToken());
            if (this.anInt1387 != 1 && this.anInt1387 != 0) {
                throw new Exception("Invalid role (" + this.anInt1387 + ")");
            } else {
                this.aString1388 = var2.nextToken();
                int var3 = this.aString1388.length();
                if (var3 >= 3 && var3 <= 15) {
                    if (var2.hasMoreTokens()) {
                        throw new Exception("Too much data in \'match_challenge\' (\"" + var1 + "\")");
                    }
                } else {
                    throw new Exception("Invalid opponent (\"" + this.aString1388 + "\")");
                }
            }
        } else {
            this.anInt1387 = -1;
            this.aString1388 = null;
        }
    }

    private void method1621(String var1) throws Exception {
        int var2 = var1.lastIndexOf(44);
        if (var2 == -1) {
            throw new Exception("Invalid match string (" + var1 + ")");
        } else {
            this.aString1389 = var1.substring(0, var2);
            this.aString1390 = var1.substring(var2 + 1);
        }
    }

    private void method1622(String var1, int var2) throws Exception {
        StringTokenizer var3 = new StringTokenizer(var1, ",");
        int var4 = var3.countTokens();
        if (var4 != var2) {
            throw new Exception("Invalid settingcount (" + var2 + ")");
        } else {
            this.anIntArray1391 = new int[var4];

            for (int var5 = 0; var5 < var4; ++var5) {
                this.anIntArray1391[var5] = Integer.parseInt(var3.nextToken());
                if (this.anIntArray1391[var5] < 0) {
                    throw new Exception("Invalid setting (" + this.anIntArray1391[var5] + ")");
                }
            }

        }
    }

    static {
        aStringArray1392[0] = "Too much data in \'match_challenge\' (\"";
        aStringArray1392[1] = "\")";
        aStringArray1392[2] = "Invalid opponent (\"";
        aStringArray1392[3] = "Invalid role (";
        aStringArray1392[4] = "Challenge-data set in 3+ players game";
        aStringArray1392[5] = "Invalid match string (";
        aStringArray1392[6] = "match_settings";
        aStringArray1392[7] = "match_string";
        aStringArray1392[8] = "Match game without user session";
        aStringArray1392[9] = "match_challenge";
        aStringArray1392[10] = "match_data";
        aStringArray1392[11] = "Invalid subgame (";
        aStringArray1392[12] = "Invalid match id (";
        aStringArray1392[13] = "Too much data in \'match_data\' (\"";
        aStringArray1392[14] = "Invalid playercount (";
        aStringArray1392[15] = "Invalid setting (";
        aStringArray1392[16] = "Invalid settingcount (";
    }
}
