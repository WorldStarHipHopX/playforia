package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.tools.Tools;

import java.applet.AppletContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.JApplet;

public final class Parameters {

    private static final String aString1879 = "127.0.0.1";
    private static final String aString1880 = "en";
    private static final String aString1881 = "playforia";
    private static final String aString1882 = "http://www.playforia.com/";
    private static final String aString1883 = "_top";
    private JApplet aJApplet1884;
    private AApplet anAApplet1885;
    private String aString1886;
    private String aString1887;
    private String aString1888;
    private String aString1889;
    private String aString1890;
    private String aString1891;
    private String aString1892;
    private String aString1893;
    private String aString1894;
    private String aString1895;
    private String aString1896;
    private String aString1897;
    private String aString1898;
    private String aString1899;
    private String aString1900;
    private String aString1901;
    private String aString1902;
    private String aString1903;
    private String aString1904;
    private String aString1905;
    private String aString1906;
    private String aString1907;
    private String aString1908;
    private boolean aBoolean1909;
    private boolean aBoolean1910;
    private boolean aBoolean1911;
    private int anInt1912;
    private URL anURL1913;
    private URL anURL1914;
    private String[][] aStringArrayArray1915;
    private int[] anIntArray1916;
    private int anInt1917;
    private String[] aStringArray1918;
    private String aString1919;
    private boolean aBoolean1920;
    private static final String[] aStringArray1921 = new String[68];


    public Parameters(JApplet var1) {
        this(var1, false);
    }

    public Parameters(JApplet var1, boolean var2) {
        this.aJApplet1884 = var1;
        if (var1 instanceof AApplet) {
            this.anAApplet1885 = (AApplet) ((AApplet) var1);
        }

        this.aString1886 = var1.getCodeBase().getHost().toLowerCase();
        this.aString1887 = var1.getDocumentBase().getHost().toLowerCase();
        this.anInt1917 = 0;
        this.aBoolean1920 = var2;
        this.method2008();
    }

    public String getParameter(String var1) {
        String var2 = this.aJApplet1884.getParameter(var1);
        if (var2 == null) {
            var2 = this.aJApplet1884.getParameter(var1.toLowerCase());
        }

        if (var2 == null) {
            var2 = this.aJApplet1884.getParameter(var1.toUpperCase());
        }

        if (var2 == null) {
            return null;
        } else {
            var2 = var2.trim();
            return var2.length() == 0 ? null : var2;
        }
    }

    public String getServerIp() {
        return this.aString1888;
    }

    public int getServerPort() {
        return this.anInt1912;
    }

    public String getLocale() {
        return this.aString1889;
    }

    public String getTranslationLang() {
        return this.aString1890;
    }

    public String getChatLang() {
        return this.aString1891 != null ? this.aString1891 : this.aString1890;
    }

    public String getLang() {
        return this.getChatLang();
    }

    public String getSiteName() {
        return this.aString1892;
    }

    public String getSessionLocale() {
        return this.aString1893;
    }

    public String getSession() {
        return this.aString1894;
    }

    public void removeSession() {
        this.aString1894 = null;
    }

    public String getWelcomeMessage() {
        return this.aString1895;
    }

    public void removeWelcomeMessage() {
        this.aString1895 = null;
    }

    public String getRegisterPage() {
        return this.aString1897;
    }

    public boolean showPlayerCard(String var1) {
        if (this.aBoolean1920) {
            System.out.println("Parameters.showPlayerCard(\"" + var1 + "\")");
        }

        try {
            if (this.aString1898 == null) {
                return false;
            }

            if (var1.charAt(0) == 126) {
                return false;
            }

            String var2 = this.aString1898.toLowerCase();
            if (var2.startsWith("http:")) {
                if (this.aString1899 == null) {
                    return false;
                }

                this.method2024(this.method2020(this.aString1898 + var1), this.aString1899);
                return true;
            }

            if (var2.startsWith("javascript:")) {
                URL var3 = this.method2020(Tools.replaceFirst(this.aString1898, "%n", var1));
                if (var3 == null) {
                    return false;
                }

                this.method2024(var3, this.aString1899);
                return true;
            }
        } catch (Exception var4) {
            ;
        }

        return false;
    }

    public void showPlayerList(String[] var1) {
        this.showPlayerList(var1, (String) null);
    }

    public void showPlayerList(String[] var1, String var2) {
        try {
            if (var1 == null) {
                if (this.aBoolean1920) {
                    System.out.println("Parameters.showPlayerList(null,...)");
                }

                this.removePlayerList();
                return;
            }

            if (this.aBoolean1920) {
                System.out.println("Parameters.showPlayerList(...): nicks.length=" + var1.length);
            }

            if (this.method2023(var1, var2)) {
                return;
            }

            this.method2021(var1, (boolean[]) null, var2);
            this.aStringArray1918 = var1;
            this.aString1919 = var2;
            this.anInt1917 = 1;
        } catch (Exception var4) {
            ;
        }

    }

    public void showPlayerListWinners(boolean[] var1) {
        try {
            if (var1 == null) {
                if (this.aBoolean1920) {
                    System.out.println("Parameters.showPlayerListWinners(null)");
                }

                this.removePlayerListWinners();
                return;
            }

            if (this.aBoolean1920) {
                System.out.println("Parameters.showPlayerListWinners(...): winners.length=" + var1.length);
            }

            int var2 = var1.length;
            boolean var3 = false;

            for (int var4 = 0; var4 < var2; ++var4) {
                if (var1[var4]) {
                    var3 = true;
                }
            }

            if (!var3) {
                this.removePlayerListWinners();
                return;
            }

            if (this.anInt1917 == 0) {
                return;
            }

            this.method2021(this.aStringArray1918, var1, this.aString1919);
            this.anInt1917 = 2;
        } catch (Exception var5) {
            ;
        }

    }

    public void removePlayerListWinners() {
        this.showPlayerList(this.aStringArray1918, this.aString1919);
    }

    public void removePlayerList() {
        try {
            if (this.anInt1917 == 0) {
                return;
            }

            this.method2021((String[]) null, (boolean[]) null, (String) null);
            this.anInt1917 = 0;
        } catch (Exception var2) {
            ;
        }

    }

    public boolean showRegisterPage() {
        return this.method2024(this.method2020(this.aString1897), (String) null);
    }

    public void showCreditPurchasePage() {
        this.showCreditPurchasePage(true);
    }

    public void showCreditPurchasePage(boolean var1) {
        this.method2024(this.anURL1913, var1 ? "_blank" : null);
    }

    public boolean isCreditPurchasePageAvailable() {
        return this.anURL1913 != null;
    }

    public void showQuitPage() {
        this.method2024(this.anURL1914, this.aString1896);
    }

    public String[][] getImageAliases() {
        return this.aStringArrayArray1915;
    }

    public boolean isGuestAutoLogin() {
        return this.aBoolean1910;
    }

    public void noGuestAutoLogin() {
        this.aBoolean1910 = false;
    }

    public boolean isGuestLobbyChattingDisabled() {
        return this.aBoolean1911;
    }

    public String getTicket() {
        return this.aString1907;
    }

    public boolean callJavaScriptJSON(String var1) {
        if (this.aBoolean1920) {
            System.out.println("Parameters.callJavaScriptJSON(\"" + var1 + "\")");
        }

        if (this.aString1908 == null) {
            return false;
        } else {
            try {
                var1 = Tools.replaceAll(var1, "\'", "\\\'");
                String var2 = Tools.replaceFirst(this.aString1908, "%o", "\'" + var1 + "\'");
                URL var3 = this.method2020(var2);
                if (var3 == null) {
                    return false;
                } else {
                    this.method2024(var3, (String) null);
                    return true;
                }
            } catch (Exception var4) {
                return false;
            }
        }
    }

    public void updateWebPageInfoBox(int var1, int var2, int var3) {
        if (this.aString1908 != null) {
            if (var1 >= 0 || var2 >= 0 || var3 >= 0) {
                String var4 = "{info:{";
                if (var1 >= 0) {
                    var4 = var4 + "credits:" + var1;
                }

                if (var2 >= 0) {
                    if (var1 >= 0) {
                        var4 = var4 + ',';
                    }

                    var4 = var4 + "chips:" + var2;
                }

                if (var3 >= 0) {
                    if (var1 >= 0 || var2 >= 0) {
                        var4 = var4 + ',';
                    }

                    var4 = var4 + "ranking:" + var3;
                }

                var4 = var4 + "}}";
                this.callJavaScriptJSON(var4);
            }
        }
    }

    public JApplet getApplet() {
        return this.aJApplet1884;
    }

    public AApplet getAApplet() {
        return this.anAApplet1885;
    }

    public void destroy() {
        this.aString1888 = null;
        this.aString1889 = null;
        this.aString1890 = null;
        this.aString1891 = null;
        this.aString1892 = null;
        this.aString1893 = null;
        this.aString1894 = null;
        this.aString1895 = null;
        this.aString1896 = null;
        this.aString1897 = null;
        this.aString1898 = null;
        this.aString1899 = null;
        this.aString1900 = null;
        this.aString1901 = null;
        this.aString1902 = null;
        this.aString1903 = null;
        this.aString1904 = null;
        this.aString1905 = null;
        this.aString1906 = null;
        this.aString1907 = null;
        this.aString1908 = null;
        this.anURL1913 = null;
        this.aStringArrayArray1915 = (String[][]) null;
        this.anIntArray1916 = null;
        this.aStringArray1918 = null;
        this.aString1919 = null;
        this.aString1887 = null;
        this.aString1886 = null;
    }

    protected AppletContext method2002() {
        return this.aJApplet1884.getAppletContext();
    }

    protected boolean method2003() {
        return this.aBoolean1909;
    }

    protected String method2004() {
        return this.aString1902;
    }

    protected String method2005() {
        return this.aString1903;
    }

    protected String method2006() {
        return this.aString1905;
    }

    protected String method2007() {
        return this.aString1906;
    }

    private void method2008() {
        this.aString1888 = this.method2009();
        this.anInt1912 = this.method2010();
        this.aString1889 = this.method2011();
        this.aString1890 = this.method2012();
        this.aString1891 = this.method2013();
        this.aString1892 = this.method2014();
        this.aString1893 = this.getParameter("sessionlocale");
        this.aString1894 = this.getParameter("session");
        this.aString1895 = this.getParameter("welcomemessage");
        if (this.aString1895 == null) {
            this.aString1895 = this.getParameter("gamewelcome");
        }

        this.anURL1914 = this.method2015();
        this.aString1896 = this.method2016();
        this.aString1897 = this.getParameter("registerpage");
        this.anURL1913 = this.method2020(this.getParameter("creditpage"));
        this.aString1898 = this.getParameter("userinfopage");
        this.aString1899 = this.getParameter("userinfotarget");
        this.aString1900 = this.getParameter("userlistpage");
        this.aString1901 = this.getParameter("userlisttarget");
        this.aBoolean1909 = Tools.getBoolean(this.getParameter("tellfriend"));
        this.aString1902 = this.getParameter("tellfriendpage");
        this.aString1903 = this.getParameter("tellfriendtarget");
        this.anIntArray1916 = this.method2019();
        this.aString1904 = this.getParameter("characterimagedir");
        this.aStringArrayArray1915 = this.method2017();
        this.aBoolean1910 = Tools.getBoolean(this.getParameter("guestautologin"));
        this.aBoolean1911 = Tools.getBoolean(this.getParameter("disableguestlobbychat"));
        this.aString1905 = this.getParameter("tournamentround");
        this.aString1906 = this.getParameter("subgame");
        this.aString1907 = this.getParameter("ticket");
        this.aString1908 = this.getParameter("json");
        if (this.aString1908 != null) {
            this.aString1908 = Tools.replaceFirst(this.aString1908, "\'%o\'", "%o");
            if (!this.aString1908.toLowerCase().startsWith("javascript:")) {
                this.aString1908 = "javascript:" + this.aString1908;
            }
        }

    }

    private String method2009() {
        try {
            String var1 = this.getParameter("server");
            int var2 = var1.indexOf(58);
            return var1.substring(0, var2);
        } catch (Exception var3) {
            return this.aString1886.length() > 0 ? this.aString1886 : aString1879;
        }
    }

    private int method2010() {
        try {
            String var1 = this.getParameter("server");
            int var2 = var1.indexOf(58);
            return Integer.parseInt(var1.substring(var2 + 1));
        } catch (Exception var4) {
            try {
                return Integer.parseInt(this.getParameter("port"));
            } catch (Exception var3) {
                return 4200;
            }
        }
    }

    private String method2011() {
        String var1;
        try {
            var1 = this.getParameter("locale");
            if (var1 != null) {
                return var1;
            }
        } catch (Exception var4) {
            ;
        }

        if (this.aString1886.endsWith("aapeli.com")) {
            return "fi";
        } else if (this.aString1886.endsWith("playray.com")) {
            return aString1880;
        } else {
            if (this.aString1886.endsWith(".playforia.com")) {
                try {
                    var1 = this.aString1886.substring(0, this.aString1886.indexOf(46));
                    if (var1.length() > 0 && !var1.equals("www")) {
                        return var1;
                    }
                } catch (Exception var3) {
                    ;
                }
            }

            if (this.aString1886.indexOf("playray") >= 0) {
                try {
                    var1 = this.aString1886.substring(this.aString1886.lastIndexOf(46) + 1);
                    if (var1.length() > 0) {
                        return var1;
                    }
                } catch (Exception var2) {
                    ;
                }
            }

            return aString1880;
        }
    }

    private String method2012() {
        try {
            String var1 = this.getParameter("lang");
            if (var1 != null) {
                return var1;
            }

            var1 = this.getParameter("language");
            if (var1 != null) {
                return var1;
            }
        } catch (Exception var2) {
            ;
        }

        return null;
    }

    private String method2013() {
        try {
            String var1 = this.getParameter("chatlang");
            if (var1 != null) {
                return var1;
            }

            var1 = this.getParameter("serverlang");
            if (var1 != null) {
                return var1;
            }
        } catch (Exception var2) {
            ;
        }

        return null;
    }

    private String method2014() {
        try {
            String var1 = this.getParameter("sitename");
            if (var1 != null) {
                return var1;
            }
        } catch (Exception var2) {
            ;
        }

        return this.aString1887.indexOf("aapeli.") >= 0 ? "aapeli" : (this.aString1887.indexOf("playforia.") >= 0 ? aString1881 : (this.aString1887.indexOf("playray.") >= 0 ? "playray" : aString1881));
    }

    private URL method2015() {
        URL var1 = this.method2020(this.getParameter("quitpage"));
        if (var1 != null) {
            return var1;
        } else {
            var1 = this.method2020(this.aString1887);
            return var1 != null ? var1 : this.method2020(aString1882);
        }
    }

    private String method2016() {
        String var1 = this.getParameter("quittarget");
        return var1 != null ? var1 : aString1883;
    }

    private String[][] method2017() {
        String var1 = this.getParameter("imagealias");
        if (var1 == null) {
            return (String[][]) null;
        } else {
            StringTokenizer var2 = new StringTokenizer(var1, " ");
            int var3 = var2.countTokens();
            if (var3 == 0) {
                return (String[][]) null;
            } else {
                String[][] var4 = new String[var3][2];

                for (int var5 = 0; var5 < var3; ++var5) {
                    String var6 = var2.nextToken();
                    int var7 = var6.indexOf(58);
                    if (var7 <= 0 || var7 == var6.length() - 1) {
                        return (String[][]) null;
                    }

                    var4[var5][0] = var6.substring(0, var7);
                    var4[var5][1] = this.method2018(var6.substring(var7 + 1));
                }

                return var4;
            }
        }
    }

    private String method2018(String var1) {
        StringTokenizer var2 = new StringTokenizer(var1, ",");
        int var3 = var2.countTokens();
        if (var3 <= 1) {
            return var1;
        } else {
            int var4 = (int) (Math.random() * (double) var3);

            while (true) {
                var1 = var2.nextToken();
                if (var4 == 0) {
                    return var1;
                }

                --var4;
            }
        }
    }

    private int[] method2019() {
        String var1 = this.getParameter("regremindshowtime");
        if (var1 == null) {
            return null;
        } else {
            StringTokenizer var2 = new StringTokenizer(var1, ",");
            int var3 = var2.countTokens();
            if (var3 == 0) {
                return null;
            } else {
                int[] var4 = new int[var3];

                for (int var5 = 0; var5 < var3; ++var5) {
                    try {
                        var4[var5] = Integer.parseInt(var2.nextToken());
                    } catch (NumberFormatException var7) {
                        return null;
                    }

                    if (var4[var5] <= 0) {
                        return null;
                    }

                    if (var5 > 0 && var4[var5] <= var4[var5 - 1]) {
                        return null;
                    }
                }

                return var4;
            }
        }
    }

    private URL method2020(String var1) {
        try {
            return new URL(var1);
        } catch (MalformedURLException var3) {
            return null;
        }
    }

    private void method2021(String[] var1, boolean[] var2, String var3) {
        if (this.aBoolean1920) {
            System.out.println("Parameters.showPlayerList(...): " + (var1 != null ? "nicks.length=" + var1.length : "null") + ", " + (var2 != null ? "winners.length=" + var2.length : "null"));
        }

        if (this.aString1900 != null) {
            String var4 = this.aString1900.toLowerCase();
            String var5 = null;
            if (var1 != null) {
                var5 = "";
                int var6 = var1.length;

                for (int var7 = 0; var7 < var6; ++var7) {
                    var5 = var5 + var1[var7];
                    if (var2 != null) {
                        var5 = var5 + (var2[var7] ? "*" : "");
                    }

                    if (var7 < var6 - 1) {
                        var5 = var5 + ',';
                    }
                }

                var5 = this.method2022(var5);
            }

            String var8;
            if (var4.startsWith("http:")) {
                if (this.aString1901 != null) {
                    var8 = this.aString1900;
                    if (var5 != null) {
                        var8 = var8 + var5;
                        if (var3 != null) {
                            var8 = var8 + "&subgame=" + var3;
                        }
                    }

                    this.method2024(this.method2020(var8), this.aString1901);
                }
            } else {
                if (var4.startsWith("javascript:")) {
                    var8 = this.aString1900;
                    var8 = Tools.replaceFirst(var8, "%n", var5 != null ? var5 : "");
                    var8 = Tools.replaceFirst(var8, "%s", var3 != null ? var3 : "");
                    URL var9 = this.method2020(var8);
                    if (var9 == null) {
                        return;
                    }

                    this.method2024(var9, this.aString1901);
                }

            }
        }
    }

    private String method2022(String var1) {
        int var2 = var1.length();
        StringBuffer var3 = new StringBuffer(var2 * 3);

        for (int var4 = 0; var4 < var2; ++var4) {
            char var5 = var1.charAt(var4);
            if ((var5 < 65 || var5 > 90) && (var5 < 97 || var5 > 122) && (var5 < 48 || var5 > 57) && var5 != 45 && var5 != 126 && var5 != 44) {
                String var6 = Integer.toHexString(var5 & 255);
                var3.append('%');
                if (var6.length() < 2) {
                    var3.append(0);
                }

                var3.append(var6);
            } else {
                var3.append(var5);
            }
        }

        return var3.toString();
    }

    private boolean method2023(String[] var1, String var2) {
        if (this.anInt1917 != 1) {
            return false;
        } else if (var2 == null && this.aString1919 != null) {
            return false;
        } else if (var2 != null && this.aString1919 == null) {
            return false;
        } else if (var2 != null && this.aString1919 != null && !var2.equals(this.aString1919)) {
            return false;
        } else {
            int var3 = var1.length;
            if (var3 != this.aStringArray1918.length) {
                return false;
            } else {
                for (int var4 = 0; var4 < var3; ++var4) {
                    if (!var1[var4].equals(this.aStringArray1918[var4])) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    private boolean method2024(URL var1, String var2) {
        if (var1 == null) {
            return false;
        } else {
            AppletContext var3 = this.aJApplet1884.getAppletContext();
            if (var2 != null) {
                var3.showDocument(var1, var2);
            } else {
                var3.showDocument(var1);
            }

            return true;
        }
    }

    static {
        aStringArray1921[0] = "port";
        aStringArray1921[1] = "server";
        aStringArray1921[2] = "regremindshowtime";
        aStringArray1921[3] = "playray";
        aStringArray1921[4] = "www";
        aStringArray1921[5] = "locale";
        aStringArray1921[6] = "playray.com";
        aStringArray1921[7] = ".playforia.com";
        aStringArray1921[8] = "fi";
        aStringArray1921[9] = "aapeli.com";
        aStringArray1921[10] = "%n";
        aStringArray1921[11] = "http:";
        aStringArray1921[12] = "javascript:";
        aStringArray1921[13] = "\")";
        aStringArray1921[14] = "Parameters.showPlayerCard(\"";
        aStringArray1921[15] = "tournamentround";
        aStringArray1921[16] = "registerpage";
        aStringArray1921[17] = "sessionlocale";
        aStringArray1921[18] = "creditpage";
        aStringArray1921[19] = "gamewelcome";
        aStringArray1921[20] = "userinfotarget";
        aStringArray1921[21] = "tellfriendpage";
        aStringArray1921[22] = "userinfopage";
        aStringArray1921[23] = "ticket";
        aStringArray1921[24] = "disableguestlobbychat";
        aStringArray1921[25] = "userlisttarget";
        aStringArray1921[26] = "welcomemessage";
        aStringArray1921[27] = "session";
        aStringArray1921[28] = "\'%o\'";
        aStringArray1921[29] = "userlistpage";
        aStringArray1921[30] = "tellfriendtarget";
        aStringArray1921[31] = "subgame";
        aStringArray1921[32] = "characterimagedir";
        aStringArray1921[33] = "guestautologin";
        aStringArray1921[34] = "%o";
        aStringArray1921[35] = "json";
        aStringArray1921[36] = "tellfriend";
        aStringArray1921[37] = "language";
        aStringArray1921[38] = "lang";
        aStringArray1921[39] = "Parameters.callJavaScriptJSON(\"";
        aStringArray1921[40] = "\\\'";
        aStringArray1921[41] = "_blank";
        aStringArray1921[42] = "chips:";
        aStringArray1921[43] = "ranking:";
        aStringArray1921[44] = "}}";
        aStringArray1921[45] = "{info:{";
        aStringArray1921[46] = "credits:";
        aStringArray1921[47] = "Parameters.showPlayerListWinners(...): winners.length=";
        aStringArray1921[48] = "Parameters.showPlayerListWinners(null)";
        aStringArray1921[49] = ", ";
        aStringArray1921[50] = "&subgame=";
        aStringArray1921[51] = "null";
        aStringArray1921[52] = "winners.length=";
        aStringArray1921[53] = "Parameters.showPlayerList(...): ";
        aStringArray1921[54] = "%s";
        aStringArray1921[55] = "nicks.length=";
        aStringArray1921[56] = "playray.";
        aStringArray1921[57] = "sitename";
        aStringArray1921[58] = "aapeli.";
        aStringArray1921[59] = "playforia.";
        aStringArray1921[60] = "aapeli";
        aStringArray1921[61] = "Parameters.showPlayerList(null,...)";
        aStringArray1921[62] = "Parameters.showPlayerList(...): nicks.length=";
        aStringArray1921[63] = "quittarget";
        aStringArray1921[64] = "chatlang";
        aStringArray1921[65] = "serverlang";
        aStringArray1921[66] = "imagealias";
        aStringArray1921[67] = "quitpage";
    }
}
