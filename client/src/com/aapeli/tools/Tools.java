package com.aapeli.tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;

public class Tools {

    private static long aLong1731 = -1L;
    private static long aLong1732 = -1L;


    public static boolean sleep(long var0) {
        if (var0 <= 0L) {
            return true;
        } else {
            try {
                Thread.sleep(var0);
                return true;
            } catch (InterruptedException var3) {
                return false;
            }
        }
    }

    public static boolean forcedRepaint(Component target) {
        try {
            Graphics graphics = target.getGraphics();
            if (graphics != null) {
                target.update(graphics);
                return true;
            }

            target.repaint();
        } catch (Exception var2) {
            ;
        }

        return false;
    }

    public static String changeToSaveable(String var0) {
        int var1 = var0.length();
        StringBuffer var2 = new StringBuffer(var1 * 2);

        for (int var4 = 0; var4 < var1; ++var4) {
            char var3 = var0.charAt(var4);
            if (var3 == '^') {
                var2.append("$p");
            } else if (var3 == '$') {
                var2.append("$d");
            } else {
                var2.append(var3);
            }
        }

        return var2.toString();
    }

    public static String changeFromSaveable(String var0) {
        int var1 = var0.length();
        StringBuffer var2 = new StringBuffer(var1);

        for (int var4 = 0; var4 < var1; ++var4) {
            char var3 = var0.charAt(var4);
            if (var3 == '$') {
                ++var4;
                var3 = var0.charAt(var4);
                if (var3 == 'p') {
                    var2.append('^');
                } else {
                    if (var3 != 'd') {
                        System.out.println("Program error: Tools.changeFromSaveable(\"" + var0 + "\"), " + "unexpected character \'" + var3 + "\' after \'$\'");
                        return null;
                    }

                    var2.append('$');
                }
            } else {
                var2.append(var3);
            }
        }

        return var2.toString();
    }

    public static int getRandomByPossibility(double[] var0) {
        int var1 = var0.length;
        double[] var2 = new double[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            if (var0[var3] < 0.0D) {
                throw new IllegalArgumentException("Negative possibility");
            }

            var2[var3] = var3 == 0 ? var0[0] : var2[var3 - 1] + var0[var3];
        }

        if (var2[var1 - 1] == 0.0D) {
            throw new IllegalArgumentException("Total zero possibility");
        } else {
            double var6 = Math.random() * var2[var1 - 1];

            for (int var5 = 0; var5 < var1; ++var5) {
                if (var6 < var2[var5]) {
                    return var5;
                }
            }

            return -1;
        }
    }

    public static String[] vectorToStringArray(Vector var0) {
        if (var0 == null) {
            return null;
        } else {
            int var1 = var0.size();
            String[] var2 = new String[var1];

            for (int var3 = 0; var3 < var1; ++var3) {
                var2[var3] = var0.elementAt(var3).toString();
            }

            return var2;
        }
    }

    public static int[] stringToIntArray(String var0) {
        try {
            StringTokenizer var1 = new StringTokenizer(var0, ",");
            int var2 = var1.countTokens();
            int[] var3 = new int[var2];

            for (int var4 = 0; var4 < var2; ++var4) {
                var3[var4] = Integer.parseInt(var1.nextToken());
            }

            return var3;
        } catch (Exception var5) {
            return null;
        }
    }

    public static String[] separateString(String var0, String var1) {
        StringTokenizer var2 = new StringTokenizer(var0, var1);
        int var3 = var2.countTokens();
        String[] var4 = new String[var3];

        for (int var5 = 0; var5 < var3; ++var5) {
            var4[var5] = var2.nextToken();
        }

        return var4;
    }

    public static double getDistance(double var0, double var2, double var4, double var6) {
        double var8 = var4 - var0;
        double var10 = var6 - var2;
        return Math.sqrt(var8 * var8 + var10 * var10);
    }

    public static String replaceFirst(String var0, String var1, String var2) {
        int var3 = var0.indexOf(var1);
        if (var3 == -1) {
            return var0;
        } else {
            var0 = var0.substring(0, var3) + var2 + var0.substring(var3 + var1.length());
            return var0;
        }
    }

    public static String replaceAll(String var0, String var1, String var2) {
        int var3 = var1.length();
        int var4 = var2.length();

        int var6;
        for (int var5 = 0; (var6 = var0.indexOf(var1, var5)) >= 0; var5 = var6 + var4) {
            var0 = var0.substring(0, var6) + var2 + var0.substring(var6 + var3);
        }

        return var0;
    }

    public static boolean getBoolean(String var0) {
        if (var0 != null && var0.length() > 0) {
            var0 = var0.toLowerCase();
            char var1 = var0.charAt(0);
            if (var1 == 't' || var1 == 'y' || var0.equals("on") || var1 == '1') {
                return true;
            }
        }

        return false;
    }

    public static Color getColor(String var0, Color var1) {
        if (var0 == null) {
            return var1;
        } else {
            var0 = var0.trim();
            if (var0.startsWith("#")) {
                var0 = var0.substring(1).trim();
            } else if (var0.startsWith("0x")) {
                var0 = var0.substring(2).trim();
            }

            if (var0.length() == 0) {
                return var1;
            } else {
                try {
                    return new Color(Integer.parseInt(var0, 16));
                } catch (Exception var3) {
                    return var1;
                }
            }
        }
    }

    public static String reverse(String var0) {
        if (var0 == null) {
            return null;
        } else {
            int var1 = var0.length();
            if (var1 == 0) {
                return var0;
            } else {
                StringBuffer var2 = new StringBuffer(var1);

                for (int var3 = 0; var3 < var1; ++var3) {
                    var2.append(var0.charAt(var1 - 1 - var3));
                }

                return var2.toString();
            }
        }
    }

    public static void printTimeElapsed(String message) {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int ms = cal.get(Calendar.MILLISECOND);
        if (hour < 10) {
            sb.append(0);
        }

        sb.append(hour).append(':');
        if (min < 10) {
            sb.append(0);
        }

        sb.append(min).append(':');
        if (sec < 10) {
            sb.append(0);
        }

        sb.append(sec).append(':');
        if (ms < 100) {
            sb.append(0);
        }

        if (ms < 10) {
            sb.append(0);
        }

        sb.append(ms).append(' ');
        if (aLong1731 < 0L) {
            aLong1731 = aLong1732 = System.currentTimeMillis();
            sb.append("00:00:000 00:00:000");
        } else {
            long var7 = System.currentTimeMillis();
            int var9 = (int) (var7 - aLong1731);
            int var10 = (int) (var7 - aLong1732);
            aLong1732 = var7;
            method1875(sb, var9);
            sb.append(' ');
            method1875(sb, var10);
        }

        sb.append("] ").append(message);
        System.out.println(sb.toString());
    }

    public static String arrayToString(Object[] var0, char var1) {
        StringBuffer var2 = new StringBuffer();
        int var3 = var0.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            var2.append(var0[var4].toString());
            if (var4 < var3 - 1) {
                var2.append(var1);
            }
        }

        return var2.toString();
    }

    private static void method1875(StringBuffer var0, int var1) {
        int var2 = var1 / '\uea60';
        var1 -= var2 * '\uea60';
        int var3 = var1 / 1000;
        int var4 = var1 - var3 * 1000;
        if (var2 < 10) {
            var0.append(0);
        }

        var0.append(var2).append(':');
        if (var3 < 10) {
            var0.append(0);
        }

        var0.append(var3).append(':');
        if (var4 < 100) {
            var0.append(0);
            if (var4 < 10) {
                var0.append(0);
            }
        }

        var0.append(var4);
    }
}
