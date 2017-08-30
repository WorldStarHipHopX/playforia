package com.aapeli.client;

import com.aapeli.client.Parameters;

public class Tournament {

    private long aLong1522;
    private String aString1523;
    private int anInt1524;
    private String aString1525;
    private static final String[] aStringArray1526 = new String[7];


    private Tournament(long var1, String var3, int var4, String var5) {
        this.aLong1522 = var1;
        this.aString1523 = var3;
        this.anInt1524 = var4;
        this.aString1525 = var5;
    }

    public static Tournament getTournament(Parameters var0) {
        return getTournament(var0, (String[]) null);
    }

    public static Tournament getTournament(Parameters var0, String[] var1) {
        String var2 = var0.method1658();
        if (var2 == null) {
            return null;
        } else {
            int var3;
            try {
                var3 = Integer.parseInt(var2);
                if (var3 <= 0) {
                    throw new Exception();
                }
            } catch (Exception var8) {
                System.out.println("Tournament: Tournament round was defined but it wasn\'t a valid number");
                return null;
            }

            String var4 = var0.method1659();
            int var5 = -1;
            if (var1 != null) {
                if (var4 == null) {
                    System.out.println("Tournament: Tournament round was defined but \'subgame\' is not available");
                    return null;
                }

                var5 = method1736(var4, var1);
                if (var5 == -1) {
                    System.out.println("Tournament: Tournament \'subgame\' didn\'t match any subgame in this game");
                    return null;
                }
            } else if (var4 != null) {
                System.out.println("Tournament: Tournament without subgame was requested but \'subgame\' was defined in applet parameters");
                return null;
            }

            String var6 = var0.getTicket();
            if (var6 == null) {
                System.out.println("Tournament: Tournament round was defined but \'ticket\' is not available");
                return null;
            } else {
                Tournament var7 = new Tournament(System.currentTimeMillis() + (long) var3 * 1000L, var4, var5, var6);
                return var7;
            }
        }
    }

    public boolean isActive() {
        return System.currentTimeMillis() < this.aLong1522;
    }

    public int getSubGameId() {
        if (this.anInt1524 == -1) {
            System.out.println("Tournament: Method getSubGameId() was called when no subgames are available");
            return -1;
        } else {
            return this.anInt1524;
        }
    }

    public String getSubGame() {
        if (this.aString1523 == null) {
            System.out.println("Tournament: Method getSubGame() was called when no subgame is defined");
            return null;
        } else {
            return this.aString1523;
        }
    }

    public String getTicket() {
        return this.aString1525;
    }

    private static int method1736(String var0, String[] var1) {
        for (int var2 = 0; var2 < var1.length; ++var2) {
            if (var0.equalsIgnoreCase(var1[var2])) {
                return var2;
            }
        }

        return -1;
    }

    static {
        aStringArray1526[0] = "Tournament: Method getSubGame() was called when no subgame is defined";
        aStringArray1526[1] = "Tournament: Tournament without subgame was requested but \'subgame\' was defined in applet parameters";
        aStringArray1526[2] = "Tournament: Tournament round was defined but it wasn\'t a valid number";
        aStringArray1526[3] = "Tournament: Tournament round was defined but \'subgame\' is not available";
        aStringArray1526[4] = "Tournament: Tournament round was defined but \'ticket\' is not available";
        aStringArray1526[5] = "Tournament: Tournament \'subgame\' didn\'t match any subgame in this game";
        aStringArray1526[6] = "Tournament: Method getSubGameId() was called when no subgames are available";
    }
}
