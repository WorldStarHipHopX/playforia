package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.Badge;
import com.playray.tools.Sort;

import java.util.StringTokenizer;
import java.util.Vector;

public class BadgeHandler {

    public static final int VALUE_LOWEREQUAL = 1;
    public static final int VALUE_HIGHEREQUAL = 2;
    private AApplet anAApplet1781;
    private Badge[] aBadgeArray1782;
    private static final String[] aStringArray1783 = new String[2];


    public BadgeHandler(AApplet var1, String var2) {
        this.anAApplet1781 = var1;
        if (var2.equals("-")) {
            this.aBadgeArray1782 = new Badge[0];
        } else {
            StringTokenizer var3 = new StringTokenizer(var2, "^");
            int var4 = var3.countTokens();
            this.aBadgeArray1782 = new Badge[var4];

            for (int var5 = 0; var5 < var4; ++var5) {
                this.aBadgeArray1782[var5] = new Badge(var3.nextToken());
            }

        }
    }

    public Badge awardBadge(String var1) {
        Badge var2 = this.method1906(var1);
        if (var2 == null) {
            return null;
        } else if (var2.isActive() && !var2.method1904()) {
            this.method1908(var2);
            return var2;
        } else {
            return null;
        }
    }

    public Badge[] awardBadges(String var1, int var2, int var3) {
        Vector var4 = this.method1907(var1);
        int var5 = var4.size();
        if (var5 == 0) {
            return null;
        } else {
            for (int var9 = 0; var9 < var5; ++var9) {
                Badge var8 = (Badge) ((Badge) var4.elementAt(var9));
                boolean var6 = false;
                if (var8.isActive() && !var8.method1904()) {
                    int var7 = var8.getThreshold();
                    if (var3 == 1 && var2 <= var7 || var3 == 2 && var2 >= var7) {
                        this.method1908(var8);
                        var6 = true;
                    }
                }

                if (!var6) {
                    var4.removeElementAt(var9);
                    --var9;
                    --var5;
                }
            }

            if (var5 == 0) {
                return null;
            } else {
                Badge[] var11 = new Badge[var5];

                for (int var10 = 0; var10 < var5; ++var10) {
                    var11[var10] = (Badge) ((Badge) var4.elementAt(var10));
                }

                return var11;
            }
        }
    }

    private Badge method1906(String var1) {
        for (int var2 = 0; var2 < this.aBadgeArray1782.length; ++var2) {
            if (this.aBadgeArray1782[var2].getLabel().equalsIgnoreCase(var1)) {
                return this.aBadgeArray1782[var2];
            }
        }

        return null;
    }

    private Vector method1907(String var1) {
        Vector var2 = new Vector();

        for (int var3 = 0; var3 < this.aBadgeArray1782.length; ++var3) {
            if (this.aBadgeArray1782[var3].getLabel().equalsIgnoreCase(var1)) {
                var2.addElement(this.aBadgeArray1782[var3]);
            }
        }

        return Sort.quickSort(var2);
    }

    private void method1908(Badge var1) {
        this.anAApplet1781.callJavaScriptJSON("{\"badgenotify\":{\"id\":\"" + var1.getBadgeId() + "\"}}");
        var1.method1905();
    }

    static {
        aStringArray1783[0] = "{\"badgenotify\":{\"id\":\"";
        aStringArray1783[1] = "\"}}";
    }
}
