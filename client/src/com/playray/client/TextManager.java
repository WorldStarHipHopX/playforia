package com.playray.client;

import com.playray.tools.EncodedXmlReader;
import com.playray.tools.Tools;
import com.playray.tools.XmlUnit;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JApplet;

public final class TextManager implements Runnable {

    private Parameters aParameters1943;
    private Thread aThread1944;
    private String aString1945;
    private Hashtable aHashtable1946;
    private Hashtable aHashtable1947;
    private String aString1948;
    private boolean aBoolean1949;
    private LinkedList aLinkedList1950;
    public static int anInt1951;
    private static final String[] aStringArray1952 = new String[57];


    public TextManager(Parameters var1) {
        this(var1, false, false);
    }

    public TextManager(Parameters var1, boolean var2) {
        this(var1, false, var2);
    }

    public TextManager(Parameters var1, boolean var2, boolean var3) {
        this(var3);
        this.aParameters1943 = var1;
        this.aString1945 = var1.getTranslationLang();
        if (this.aString1945 == null) {
            this.aString1945 = var1.getLocale();
        }

        this.aLinkedList1950 = new LinkedList();
        if (var2) {
            this.aThread1944 = new Thread(this);
            this.aThread1944.start();
        } else {
            this.readTexts(var1.getApplet());
        }

    }

    private TextManager(boolean var1) {
        this.aBoolean1949 = var1;
        this.aHashtable1946 = new Hashtable();
        this.aHashtable1947 = new Hashtable();
        this.aString1948 = null;
        this.aThread1944 = null;
    }

    public void run() {
        if (this.aBoolean1949) {
            System.out.println("TextManager.run(): Start loading texts");
        }

        this.readTexts(this.aParameters1943.getApplet());
        this.aThread1944 = null;
        if (this.aBoolean1949) {
            System.out.println("TextManager.run(): Finished loading texts");
        }

    }

    public String method2039(String var1) {
        return this.method2050(var1, (String[]) null);
    }

    public boolean isAvailable(String var1) {
        return this.method2060(var1, 1) != null;
    }

    public String getIfAvailable(String var1) {
        return this.getIfAvailable(var1, (String) null);
    }

    public String getIfAvailable(String var1, String var2) {
        String var3 = this.method2060(var1, 1);
        return var3 != null ? var3 : var2;
    }

    public String method2040(String var1, String var2) {
        String[] var3 = new String[]{var2};
        return this.method2050(var1, var3);
    }

    public String method2041(String var1, String var2, String var3) {
        String[] var4 = new String[]{var2, var3};
        return this.method2050(var1, var4);
    }

    public String method2042(String var1, String var2, String var3, String var4) {
        String[] var5 = new String[]{var2, var3, var4};
        return this.method2050(var1, var5);
    }

    public String method2043(String var1, String var2, String var3, String var4, String var5) {
        String[] var6 = new String[]{var2, var3, var4, var5};
        return this.method2050(var1, var6);
    }

    public String method2044(String var1, String var2, String var3, String var4, String var5, String var6) {
        String[] var7 = new String[]{var2, var3, var4, var5, var6};
        return this.method2050(var1, var7);
    }

    public String method2045(String var1, int var2) {
        String[] var3 = new String[]{"" + var2};
        return this.method2050(var1, var3);
    }

    public String method2046(String var1, int var2, int var3) {
        String[] var4 = new String[]{"" + var2, "" + var3};
        return this.method2050(var1, var4);
    }

    public String method2047(String var1, int var2, int var3, int var4) {
        String[] var5 = new String[]{"" + var2, "" + var3, "" + var4};
        return this.method2050(var1, var5);
    }

    public String method2048(String var1, int var2, int var3, int var4, int var5) {
        String[] var6 = new String[]{"" + var2, "" + var3, "" + var4, "" + var5};
        return this.method2050(var1, var6);
    }

    public String getNumber(long var1) {
        return this.method2057(var1, true);
    }

    public String getDecimalNumber(double var1) {
        if (var1 == 0.0D) {
            return "0";
        } else {
            double var3 = var1 < 0.0D ? -var1 : var1;

            int var5;
            for (var5 = 0; var3 < 100.0D; ++var5) {
                var3 *= 10.0D;
            }

            return this.getNumber(var1, var5);
        }
    }

    public String getNumber(double var1, int var3) {
        return this.getNumber(var1, true, var3);
    }

    public String getNumber(double var1, boolean var3, int var4) {
        if (var4 <= 0) {
            return this.method2057((long) var1, var3);
        } else {
            boolean var5 = var1 < 0.0D;
            if (var5) {
                var1 = -var1;
            }

            long var6 = 1L;

            for (int var8 = 0; var8 < var4; ++var8) {
                var6 *= 10L;
            }

            long var17 = (long) (var1 * (double) var6 + 0.5D);
            long var10 = var17 / var6;
            long var12 = var17 % var6;
            String var14 = "" + var12;
            int var15 = var4 - var14.length();

            for (int var16 = 0; var16 < var15; ++var16) {
                var14 = "0" + var14;
            }

            String var18 = var5 ? "-" : "";
            var18 = var18 + this.method2057(var10, var3);
            var18 = var18 + this.getShared("SeparatorDecimal");
            var18 = var18 + var14;
            return var18;
        }
    }

    public String getTime(long var1) {
        return this.getTime(var1 * 1000L, false);
    }

    public String getTime(long var1, boolean var3) {
        boolean var4 = var1 < 0L;
        if (var4) {
            var1 = -var1;
        }

        int var5 = (int) ((var1 % 1000L + 5L) / 10L);
        if (!var3) {
            var1 += 500L;
        }

        var1 /= 1000L;
        int var6 = (int) (var1 % 60L);
        var1 /= 60L;
        int var7 = (int) (var1 % 60L);
        int var8 = (int) (var1 / 60L);
        int var9 = 0;
        if (var8 >= 24) {
            var9 = var8 / 24;
            var8 -= var9 * 24;
        }

        boolean var10 = var9 > 0;
        boolean var11 = var10 || var8 > 0;
        boolean var12 = var11 || var7 > 0 || !var3;
        boolean var13 = var3 && var8 == 0;
        String var14 = var4 ? "-" : "";
        if (var10) {
            var14 = var14 + var9;
        }

        if (var10 && var11) {
            var14 = var14 + this.getShared("SeparatorDayHour").replace('_', ' ');
        }

        if (var11) {
            var14 = var14 + var8;
        }

        if (var11 && var12) {
            var14 = var14 + this.getShared("SeparatorHourMinute") + (var7 < 10 ? "0" : "");
        }

        if (var12) {
            var14 = var14 + var7 + this.getShared("SeparatorMinuteSecond") + (var6 < 10 ? "0" : "");
        }

        var14 = var14 + var6;
        if (var13) {
            var14 = var14 + this.getShared("SeparatorSecondFraction") + (var5 < 10 ? "0" : "") + var5;
        }

        return var14;
    }

    public String getDate(long var1, boolean var3) {
        return this.method2058(var1, var3 ? 1 : 0);
    }

    public String getClock(long var1, boolean var3) {
        return this.method2059(var1, var3 ? 1 : 0);
    }

    public String getCurrentDateAndClock(boolean var1) {
        long var2 = System.currentTimeMillis();
        String var4 = this.getDate(var2, var1) + " " + this.getClock(var2, var1);
        return var4;
    }

    public String getDateWithTodayYesterday(long var1) {
        return this.method2058(var1, 2);
    }

    public char getDecimalSeparator() {
        String var1 = this.getShared("SeparatorDecimal");
        return var1.charAt(0);
    }

    public String getShared(String var1) {
        return this.method2054(var1, (String[]) null);
    }

    public String getShared(String var1, String var2) {
        String[] var3 = new String[]{var2};
        return this.method2054(var1, var3);
    }

    public String getShared(String var1, String var2, String var3) {
        String[] var4 = new String[]{var2, var3};
        return this.method2054(var1, var4);
    }

    public String getShared(String var1, String var2, String var3, String var4) {
        String[] var5 = new String[]{var2, var3, var4};
        return this.method2054(var1, var5);
    }

    public String getShared(String var1, String var2, String var3, String var4, String var5) {
        String[] var6 = new String[]{var2, var3, var4, var5};
        return this.method2054(var1, var6);
    }

    public String getWithQuantity(String var1, int var2) {
        return this.method2051(var1, new String[]{"" + var2}, var2);
    }

    public String getWithQuantity(String var1, String[] var2, int var3) {
        return this.method2051(var1, var2, var3);
    }

    public boolean isLoadingFinished() {
        return this.aThread1944 == null;
    }

    public void waitLoadingFinished() {
        while (!this.isLoadingFinished()) {
            Tools.sleep(50L);
        }

    }

    public Parameters getParameters() {
        return this.aParameters1943;
    }

    public String getFuzzyTimeAgo(long var1) {
        long var3 = System.currentTimeMillis() - var1;
        if (var3 < 0L) {
            return this.getDate(var1, true);
        } else {
            int var5 = (int) ((var3 + 500L) / 1000L);
            if (var5 < 5) {
                return this.method2054("FuzzyTime_FewSecondsAgo", (String[]) null);
            } else if (var5 < 10) {
                return this.method2055("FuzzyTime_SecondsAgo", 5);
            } else if (var5 < 15) {
                return this.method2055("FuzzyTime_SecondsAgo", 10);
            } else if (var5 < 20) {
                return this.method2055("FuzzyTime_SecondsAgo", 15);
            } else if (var5 < 30) {
                return this.method2055("FuzzyTime_SecondsAgo", 20);
            } else if (var5 < 40) {
                return this.method2055("FuzzyTime_SecondsAgo", 30);
            } else if (var5 < 50) {
                return this.method2055("FuzzyTime_SecondsAgo", 40);
            } else if (var5 < 60) {
                return this.method2055("FuzzyTime_SecondsAgo", 50);
            } else {
                int var6 = var5 / 60;
                if (var6 <= 10) {
                    return this.method2055("FuzzyTime_MinutesAgo", var6);
                } else if (var6 <= 12) {
                    return this.method2055("FuzzyTime_AboutMinutesAgo", 10);
                } else if (var6 <= 17) {
                    return this.method2055("FuzzyTime_AboutMinutesAgo", 15);
                } else if (var6 <= 25) {
                    return this.method2055("FuzzyTime_AboutMinutesAgo", 20);
                } else if (var6 <= 35) {
                    return this.method2055("FuzzyTime_AboutMinutesAgo", 30);
                } else if (var6 <= 45) {
                    return this.method2055("FuzzyTime_AboutMinutesAgo", 40);
                } else if (var6 <= 55) {
                    return this.method2055("FuzzyTime_AboutMinutesAgo", 50);
                } else if (var6 <= 75) {
                    return this.method2055("FuzzyTime_AboutHoursAgo", 1);
                } else if (var6 <= 105) {
                    return this.method2056("FuzzyTime_AboutHoursAgo", new String[]{"1½"}, 2);
                } else if (var6 <= 135) {
                    return this.method2055("FuzzyTime_AboutHoursAgo", 2);
                } else if (var6 <= 165) {
                    return this.method2056("FuzzyTime_AboutHoursAgo", new String[]{"2½"}, 3);
                } else {
                    int var7 = (var6 + 30) / 60;
                    if (var7 <= 23) {
                        return this.method2055("FuzzyTime_AboutHoursAgo", var7);
                    } else if (var7 <= 30) {
                        return this.method2055("FuzzyTime_AboutDaysAgo", 1);
                    } else if (var7 <= 42) {
                        return this.method2056("FuzzyTime_AboutDaysAgo", new String[]{"1½"}, 2);
                    } else if (var7 <= 54) {
                        return this.method2055("FuzzyTime_AboutDaysAgo", 2);
                    } else if (var7 <= 66) {
                        return this.method2056("FuzzyTime_AboutDaysAgo", new String[]{"2½"}, 3);
                    } else {
                        int var8 = (var7 + 12) / 24;
                        if (var8 <= 6) {
                            return this.method2055("FuzzyTime_AboutDaysAgo", var8);
                        } else if (var8 <= 9) {
                            return this.method2055("FuzzyTime_AboutWeeksAgo", 1);
                        } else if (var8 <= 11) {
                            return this.method2056("FuzzyTime_AboutWeeksAgo", new String[]{"1½"}, 2);
                        } else if (var8 <= 16) {
                            return this.method2055("FuzzyTime_AboutWeeksAgo", 2);
                        } else if (var8 <= 18) {
                            return this.method2056("FuzzyTime_AboutWeeksAgo", new String[]{"2½"}, 3);
                        } else if (var8 <= 23) {
                            return this.method2055("FuzzyTime_AboutWeeksAgo", 3);
                        } else if (var8 <= 25) {
                            return this.method2056("FuzzyTime_AboutWeeksAgo", new String[]{"3½"}, 4);
                        } else {
                            int var9 = (var8 + 2) / 7;
                            if (var9 <= 5) {
                                return this.method2055("FuzzyTime_AboutMonthsAgo", 1);
                            } else if (var9 <= 7) {
                                return this.method2056("FuzzyTime_AboutMonthsAgo", new String[]{"1½"}, 2);
                            } else {
                                int var10 = (int) ((double) (var8 + 10) / 30.4375D);
                                return var10 <= 11 ? this.method2055("FuzzyTime_AboutMonthsAgo", var10) : (var10 <= 13 ? this.method2055("FuzzyTime_AboutYearsAgo", 1) : (var10 <= 21 ? this.method2055("FuzzyTime_MoreThanYearsAgo", 1) : (var10 <= 26 ? this.method2055("FuzzyTime_AboutYearsAgo", 2) : (var10 <= 33 ? this.method2055("FuzzyTime_MoreThanYearsAgo", 2) : this.method2054("FuzzyTime_ManyYearsAgo", (String[]) null)))));
                            }
                        }
                    }
                }
            }
        }
    }

    public void destroy() {
        if (this.aThread1944 == null) {
            if (this.aHashtable1946 != null) {
                this.aHashtable1946.clear();
                this.aHashtable1946 = null;
            }

            if (this.aHashtable1947 != null) {
                this.aHashtable1947.clear();
                this.aHashtable1947 = null;
            }

            this.aParameters1943 = null;
            this.aString1945 = null;
            this.aString1948 = null;
        }
    }

    protected String method2049() {
        return this.aString1945;
    }

    private String method2050(String var1, String[] var2) {
        return this.method2051(var1, var2, 1);
    }

    private String method2051(String var1, String[] var2, int var3) {
        String var4 = this.method2052(var1, var2, var3);
        if (var4 != null) {
            return var4;
        } else {
            var4 = this.method2060(var1, var3);
            if (var2 != null) {
                int var5 = var2.length;

                for (int var6 = 0; var6 < var5; ++var6) {
                    var4 = Tools.replaceFirst(var4, "%" + (var6 + 1), var2[var6]);
                }
            }

            return var4;
        }
    }

    private String method2052(String var1, String[] var2, int var3) {
        if (this.aThread1944 != null) {
            return "[Loading texts...]";
        } else if (this.aHashtable1946 == null && this.aString1948 != null) {
            return "[" + this.aString1948 + "]";
        } else {
            String var4 = this.method2060(var1, var3);
            if (var4 == null) {
                if (this.aBoolean1949) {
                    System.out.println("TextManager.getText(\"" + var1 + "\"): Key not found");
                }

                return this.method2053(var1, var2);
            } else {
                return null;
            }
        }
    }

    private String method2053(String var1, String[] var2) {
        String var3 = "{" + var1 + "}";
        if (var2 != null) {
            int var4 = var2.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                var3 = var3 + " (" + var2[var5] + ")";
            }
        }

        return var3;
    }

    private String method2054(String var1, String[] var2) {
        return this.method2056(var1, var2, 1);
    }

    private String method2055(String var1, int var2) {
        return this.method2056(var1, new String[]{"" + var2}, var2);
    }

    private String method2056(String var1, String[] var2, int var3) {
        if (this.aThread1944 != null) {
            return "[Loading texts...]";
        } else if (this.aHashtable1947 == null && this.aString1948 != null) {
            return "[" + this.aString1948 + "]";
        } else {
            String var4 = this.method2061(var1, var3);
            if (var4 == null) {
                return this.method2053(var1, var2);
            } else {
                if (var2 != null) {
                    int var5 = var2.length;

                    for (int var6 = 0; var6 < var5; ++var6) {
                        var4 = Tools.replaceFirst(var4, "%" + (var6 + 1), var2[var6]);
                    }
                }

                return var4;
            }
        }
    }

    private String method2057(long var1, boolean var3) {
        if ((var1 <= -1000L || var1 >= 1000L) && var3) {
            boolean var4 = var1 < 0L;
            if (var4) {
                var1 = -var1;
            }

            String var5 = "";
            String var6 = this.getShared("SeparatorThousand");

            do {
                int var7 = (int) (var1 % 1000L);
                var5 = var7 + var5;
                var1 /= 1000L;
                if (var1 > 0L) {
                    if (var7 < 10) {
                        var5 = "00" + var5;
                    } else if (var7 < 100) {
                        var5 = "0" + var5;
                    }

                    var5 = var6 + var5;
                }
            } while (var1 > 0L);

            if (var4) {
                var5 = "-" + var5;
            }

            return var5;
        } else {
            return "" + var1;
        }
    }

    private String method2058(long var1, int var3) {
        Calendar var4 = Calendar.getInstance();
        var4.setTime(new Date(var1));
        int var5 = var4.get(1);
        int var6 = var4.get(2) + 1;
        int var7 = var4.get(5);
        if (var3 == 0) {
            return var5 + "-" + (var6 < 10 ? "0" : "") + var6 + "-" + (var7 < 10 ? "0" : "") + var7;
        } else {
            String var8 = this.getShared("DateFormat");
            var8 = Tools.replaceFirst(var8, "%1", "" + var7);
            var8 = Tools.replaceFirst(var8, "%2", this.getShared("DateMonth" + var6));
            var8 = Tools.replaceFirst(var8, "%3", "" + var5);
            if (var3 == 1) {
                return var8;
            } else {
                try {
                    Calendar var9 = Calendar.getInstance();
                    var9.set(11, 0);
                    var9.set(12, 0);
                    var9.set(13, 0);
                    var9.set(14, 0);
                    long var10 = var9.getTime().getTime();
                    long var12 = var10 - 86400000L;
                    long var14 = var10 + 86400000L;
                    if (var1 >= var12 && var1 < var10) {
                        var8 = this.getShared("DateYesterday");
                    }

                    if (var1 >= var10 && var1 < var14) {
                        var8 = this.getShared("DateToday");
                    }
                } catch (Exception var16) {
                    ;
                }

                return var8;
            }
        }
    }

    private String method2059(long var1, int var3) {
        Calendar var4 = Calendar.getInstance();
        var4.setTime(new Date(var1));
        boolean var5 = true;
        if (var3 == 1 && this.getShared("ClockHours").equals("12")) {
            var5 = false;
        }

        int var6 = var4.get(var5 ? 11 : 10);
        int var7 = var4.get(12);
        String var8 = "";
        if (!var5) {
            if (var6 == 0) {
                var6 = 12;
            }

            int var9 = var4.get(9);
            if (var9 == 0) {
                var8 = this.getShared("ClockAM");
            } else if (var9 == 1) {
                var8 = this.getShared("ClockPM");
            }
        }

        if (var3 == 0) {
            return (var6 < 10 ? "0" : "") + var6 + "-" + (var7 < 10 ? "0" : "") + var7;
        } else {
            String var10 = this.getShared("ClockFormat");
            var10 = Tools.replaceFirst(var10, "%1", "" + var6);
            var10 = Tools.replaceFirst(var10, "%2", (var7 < 10 ? "0" : "") + var7);
            if (!var5) {
                var10 = Tools.replaceFirst(var10, "%3", var8);
            }

            return var10;
        }
    }

    protected String method2060(String var1, int var2) {
        Class123 var3 = (Class123) ((Class123) this.aHashtable1946.get(var1.toLowerCase()));
        return var3 == null ? null : var3.method2001(var2);
    }

    protected String method2061(String var1, int var2) {
        Class123 var3 = (Class123) ((Class123) this.aHashtable1947.get(var1.toLowerCase()));
        return var3 == null ? null : var3.method2001(var2);
    }

    private void readTexts(JApplet var1) {
        this.aLinkedList1950.addLast("TM.readTexts(" + var1 + ") called");
        URL var2 = var1.getCodeBase();
        String var5 = null;
        int var6 = this.aString1945.indexOf(47);
        if (var6 > 0) {
            var5 = this.aString1945.substring(var6 + 1);
            this.aString1945 = this.aString1945.substring(0, var6);
        }

        String var3;
        String var4;
        String var7;
        int var8;
        if (Class110.method1896(var2)) {
            var7 = var2.toString();
            var8 = var7.indexOf(58, var7.indexOf(58) + 1) + 2;
            int var9 = var7.indexOf(47, var8);

            try {
                URL var10 = new URL(var2, "/L10N/");
                var10 = new URL(var10, this.aString1945 + "/");
                var3 = var10.toExternalForm();
            } catch (MalformedURLException var11) {
                var3 = "file:/L10N/" + this.aString1945 + "/";
            }

            var4 = var7.substring(var8, var9);
        } else {
            var7 = var2.toString();
            var8 = var7.length();
            if (var7.charAt(var8 - 1) == 47) {
                var7 = var7.substring(0, var8 - 1);
                --var8;
            }

            var6 = var7.lastIndexOf(47);
            var3 = var7.substring(0, var6 + 1) + "l10n/" + this.aString1945 + "/";
            var4 = var7.substring(var6 + 1);
        }

        if (var5 != null) {
            var4 = var5;
        }
        try {
            URL url = new URL(var3);
            var3 = new File(url.toString().replace("http://" + url.getHost(), "res")).toURI().toURL().toString();
        } catch(Exception ex) {
            System.err.println("playray.TextManager: " + ex);
        }

        this.aHashtable1946 = this.method2063(var3 + var4 + ".xml");
        this.aHashtable1947 = this.method2063(var3 + "Shared.xml");
    }

    private Hashtable method2063(String var1) {
        this.aLinkedList1950.addLast("TM.readXmlTexts(\'" + var1 + "\') called");
        EncodedXmlReader var2 = new EncodedXmlReader(var1, this.aBoolean1949);
        this.aLinkedList1950.addLast("TM.readXmlTexts() reader=" + var2);
        XmlUnit var3 = var2.readXmlUnit(this.aLinkedList1950);
        if (var3 == null) {
            this.aLinkedList1950.addLast("TM.readXmlTexts() xml=null");
            System.out.println("Failed to read localization file \'" + var1 + "\'");
            this.aString1948 = "XML read error";
            System.out.println("\nXML read error:");

            while (!this.aLinkedList1950.isEmpty()) {
                System.out.println(this.aLinkedList1950.removeFirst());
            }

            System.out.println("---");
            return null;
        } else {
            XmlUnit[] var4 = var3.getChildren("str");
            int var5 = var4.length;
            Hashtable var6 = new Hashtable();

            for (int var7 = 0; var7 < var5; ++var7) {
                var6.put(var4[var7].getAttribute("key").toLowerCase(), new Class123(this, this.aString1945, var4[var7], Tools.getBoolean(var4[var7].getAttribute("reverse"))));
            }

            return var6;
        }
    }

    static {
        aStringArray1952[0] = "SeparatorThousand";
        aStringArray1952[1] = "00";
        aStringArray1952[2] = "SeparatorHourMinute";
        aStringArray1952[3] = "SeparatorDayHour";
        aStringArray1952[4] = "SeparatorSecondFraction";
        aStringArray1952[5] = "SeparatorMinuteSecond";
        aStringArray1952[6] = "[Loading texts...]";
        aStringArray1952[7] = " (";
        aStringArray1952[8] = "FuzzyTime_ManyYearsAgo";
        aStringArray1952[9] = "FuzzyTime_AboutYearsAgo";
        aStringArray1952[10] = "FuzzyTime_AboutMinutesAgo";
        aStringArray1952[11] = "2½";
        aStringArray1952[12] = "FuzzyTime_AboutWeeksAgo";
        aStringArray1952[13] = "FuzzyTime_AboutMonthsAgo";
        aStringArray1952[14] = "FuzzyTime_SecondsAgo";
        aStringArray1952[15] = "3½";
        aStringArray1952[16] = "FuzzyTime_MoreThanYearsAgo";
        aStringArray1952[17] = "FuzzyTime_FewSecondsAgo";
        aStringArray1952[18] = "1½";
        aStringArray1952[19] = "FuzzyTime_AboutDaysAgo";
        aStringArray1952[20] = "FuzzyTime_MinutesAgo";
        aStringArray1952[21] = "FuzzyTime_AboutHoursAgo";
        aStringArray1952[22] = "TextManager.run(): Finished loading texts";
        aStringArray1952[23] = "TextManager.run(): Start loading texts";
        aStringArray1952[24] = "file:/L10N/";
        aStringArray1952[25] = "TM.readTexts(";
        aStringArray1952[26] = "Shared.xml";
        aStringArray1952[27] = "l10n/";
        aStringArray1952[28] = ".xml";
        aStringArray1952[29] = "/L10N/";
        aStringArray1952[30] = ") called";
        aStringArray1952[31] = "DateYesterday";
        aStringArray1952[32] = "DateToday";
        aStringArray1952[33] = "DateMonth";
        aStringArray1952[34] = "%2";
        aStringArray1952[35] = "%1";
        aStringArray1952[36] = "DateFormat";
        aStringArray1952[37] = "%3";
        aStringArray1952[38] = "ClockFormat";
        aStringArray1952[39] = "ClockHours";
        aStringArray1952[40] = "ClockPM";
        aStringArray1952[41] = "ClockAM";
        aStringArray1952[42] = "12";
        aStringArray1952[43] = "SeparatorDecimal";
        aStringArray1952[44] = "\"): Key not found";
        aStringArray1952[45] = "TextManager.getText(\"";
        aStringArray1952[46] = "TM.readXmlTexts(\'";
        aStringArray1952[47] = "reverse";
        aStringArray1952[48] = "\') called";
        aStringArray1952[49] = "TM.readXmlTexts() reader=";
        aStringArray1952[50] = "Failed to read localization file \'";
        aStringArray1952[51] = "---";
        aStringArray1952[52] = "\nXML read error:";
        aStringArray1952[53] = "TM.readXmlTexts() xml=null";
        aStringArray1952[54] = "str";
        aStringArray1952[55] = "XML read error";
        aStringArray1952[56] = "key";
    }
}
