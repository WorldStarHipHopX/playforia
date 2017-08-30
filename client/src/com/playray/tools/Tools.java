package com.playray.tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;

public class Tools {

    private static long aLong2234;
    private static long aLong2235;
    public static boolean aBoolean2236;
    private static final String[] aStringArray2237 = new String[12];


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

    public static String changeToSaveable(String var0) {
        int var1 = var0.length();
        StringBuffer var2 = new StringBuffer(var1 * 2);

        for (int var4 = 0; var4 < var1; ++var4) {
            char var3 = var0.charAt(var4);
            if (var3 == 94) {
                var2.append("$p");
            } else if (var3 == 36) {
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
            if (var3 == 36) {
                ++var4;
                var3 = var0.charAt(var4);
                if (var3 == 112) {
                    var2.append('^');
                } else {
                    if (var3 != 100) {
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
            if (var1 == 116 || var1 == 121 || var0.equals("on") || var1 == 49) {
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

    public static void printTimeElapsed(String var0) {
        StringBuffer var1 = new StringBuffer();
        var1.append('[');
        Calendar var2 = Calendar.getInstance();
        int var3 = var2.get(11);
        int var4 = var2.get(12);
        int var5 = var2.get(13);
        int var6 = var2.get(14);
        if (var3 < 10) {
            var1.append(0);
        }

        var1.append(var3).append(':');
        if (var4 < 10) {
            var1.append(0);
        }

        var1.append(var4).append(':');
        if (var5 < 10) {
            var1.append(0);
        }

        var1.append(var5).append(':');
        if (var6 < 100) {
            var1.append(0);
            if (var6 < 10) {
                var1.append(0);
            }
        }

        var1.append(var6).append(' ');
        if (aLong2234 < 0L) {
            aLong2234 = aLong2235 = System.currentTimeMillis();
            var1.append("00:00:000 00:00:000");
        } else {
            long var7 = System.currentTimeMillis();
            int var9 = (int) (var7 - aLong2234);
            int var10 = (int) (var7 - aLong2235);
            aLong2235 = var7;
            method2265(var1, var9);
            var1.append(' ');
            method2265(var1, var10);
        }

        var1.append("] ").append(var0);
        System.out.println(var1.toString());
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

    public static void setBestRendering(Graphics2D var0) {
        var0.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        var0.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);
        var0.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        var0.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        var0.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private static void method2265(StringBuffer var0, int var1) {
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

    static {
        aStringArray2237[0] = "Total zero possibility";
        aStringArray2237[1] = "Negative possibility";
        aStringArray2237[2] = "00:00:000 00:00:000";
        aStringArray2237[3] = "] ";
        aStringArray2237[4] = "Program error: Tools.changeFromSaveable(\"";
        aStringArray2237[5] = "\' after \'$\'";
        aStringArray2237[6] = "\"), ";
        aStringArray2237[7] = "unexpected character \'";
        aStringArray2237[8] = "0x";
        aStringArray2237[9] = "on";
        aStringArray2237[10] = "$d";
        aStringArray2237[11] = "$p";
        aLong2234 = -1L;
        aLong2235 = -1L;
    }
}
