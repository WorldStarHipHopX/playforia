package com.aapeli.client;

import com.aapeli.applet.AApplet;
import com.aapeli.client.Badge;
import com.aapeli.tools.Sort;

import java.util.StringTokenizer;
import java.util.Vector;

public class BadgeHandler {

    public static final int VALUE_LOWEREQUAL = 1;
    public static final int VALUE_HIGHEREQUAL = 2;
    private AApplet anAApplet1332;
    private Badge[] aBadgeArray1333;
    private static final String[] aStringArray1334 = new String[2];


    public BadgeHandler(AApplet var1, String var2) {
        this.anAApplet1332 = var1;
        if (var2.equals("-")) {
            this.aBadgeArray1333 = new Badge[0];
        } else {
            StringTokenizer var3 = new StringTokenizer(var2, "^");
            int var4 = var3.countTokens();
            this.aBadgeArray1333 = new Badge[var4];

            for (int var5 = 0; var5 < var4; ++var5) {
                this.aBadgeArray1333[var5] = new Badge(var3.nextToken());
            }

        }
    }

    public BadgeHandler(String var1) {
        this((AApplet) null, var1);
    }

    public Badge awardBadge(String var1) {
        Badge var2 = this.getBadge(var1);
        if (var2 == null) {
            return null;
        } else if (var2.isActive() && !var2.isOwned()) {
            this.method1565(var2);
            return var2;
        } else {
            return null;
        }
    }

    public Badge[] awardBadges(String var1, int var2, int var3) {
        Vector var4 = this.method1564(var1);
        int var5 = var4.size();
        if (var5 == 0) {
            return null;
        } else {
            for (int var9 = 0; var9 < var5; ++var9) {
                Badge var8 = (Badge) ((Badge) var4.elementAt(var9));
                boolean var6 = false;
                if (var8.isActive() && !var8.isOwned()) {
                    int var7 = var8.getThreshold();
                    if (var3 == 1 && var2 <= var7 || var3 == 2 && var2 >= var7) {
                        this.method1565(var8);
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

    public Badge getBadge(String var1) {
        for (int var2 = 0; var2 < this.aBadgeArray1333.length; ++var2) {
            if (this.aBadgeArray1333[var2].getLabel().equalsIgnoreCase(var1)) {
                return this.aBadgeArray1333[var2];
            }
        }

        return null;
    }

    private Vector method1564(String var1) {
        Vector var2 = new Vector();

        for (int var3 = 0; var3 < this.aBadgeArray1333.length; ++var3) {
            if (this.aBadgeArray1333[var3].getLabel().equalsIgnoreCase(var1)) {
                var2.addElement(this.aBadgeArray1333[var3]);
            }
        }

        return Sort.quickSort(var2);
    }

    private void method1565(Badge var1) {
        if (this.anAApplet1332 != null) {
            this.anAApplet1332.callJavaScriptJSON("{\"badgenotify\":{\"id\":\"" + var1.getBadgeId() + "\"}}");
        }

        var1.method1563();
    }

    static {
        aStringArray1334[0] = "\"}}";
        aStringArray1334[1] = "{\"badgenotify\":{\"id\":\"";
    }
}
