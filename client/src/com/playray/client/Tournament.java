package com.playray.client;

import com.playray.client.Parameters;

public class Tournament {

    private long aLong1953;
    private String aString1954;
    private int anInt1955;
    private String aString1956;
    private static final String[] aStringArray1957 = new String[7];


    private Tournament(long var1, String var3, int var4, String var5) {
        this.aLong1953 = var1;
        this.aString1954 = var3;
        this.anInt1955 = var4;
        this.aString1956 = var5;
    }

    public static Tournament getTournament(Parameters var0) {
        return getTournament(var0, (String[]) null);
    }

    public static Tournament getTournament(Parameters var0, String[] var1) {
        String var2 = var0.method2006();
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

            String var4 = var0.method2007();
            int var5 = -1;
            if (var1 != null) {
                if (var4 == null) {
                    System.out.println("Tournament: Tournament round was defined but \'subgame\' is not available");
                    return null;
                }

                var5 = method2064(var4, var1);
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
        return System.currentTimeMillis() < this.aLong1953;
    }

    public int getSubGameId() {
        if (this.anInt1955 == -1) {
            System.out.println("Tournament: Method getSubGameId() was called when no subgames are available");
            return -1;
        } else {
            return this.anInt1955;
        }
    }

    public String getSubGame() {
        if (this.aString1954 == null) {
            System.out.println("Tournament: Method getSubGame() was called when no subgame is defined");
            return null;
        } else {
            return this.aString1954;
        }
    }

    public String getTicket() {
        return this.aString1956;
    }

    private static int method2064(String var0, String[] var1) {
        for (int var2 = 0; var2 < var1.length; ++var2) {
            if (var0.equalsIgnoreCase(var1[var2])) {
                return var2;
            }
        }

        return -1;
    }

    static {
        aStringArray1957[0] = "Tournament: Method getSubGameId() was called when no subgames are available";
        aStringArray1957[1] = "Tournament: Tournament round was defined but it wasn\'t a valid number";
        aStringArray1957[2] = "Tournament: Tournament round was defined but \'subgame\' is not available";
        aStringArray1957[3] = "Tournament: Tournament without subgame was requested but \'subgame\' was defined in applet parameters";
        aStringArray1957[4] = "Tournament: Tournament round was defined but \'ticket\' is not available";
        aStringArray1957[5] = "Tournament: Tournament \'subgame\' didn\'t match any subgame in this game";
        aStringArray1957[6] = "Tournament: Method getSubGame() was called when no subgame is defined";
    }
}
