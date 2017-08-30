package com.playray.flashclient;

import com.playray.flashclient.FlashClient;
import com.playray.flashclient.Friend;
import com.playray.flashclient.MessageOut;
import com.playray.json.JSON;
import com.playray.json.VArray;
import com.playray.json.Value;

public class Friends {

    public static final int BITMAPS_NONE = 0;
    public static final int BITMAPS_SMALL_ONLY = 1;
    public static final int BITMAPS_MEDIUM_ONLY = 2;
    public static final int BITMAPS_BOTH = 3;
    private static final String[] aStringArray2132;
    private FlashClient aFlashClient2133;
    private int anInt2134;
    private Friend[] aFriendArray2135;
    private Friend[] aFriendArray2136;
    private static final String[] aStringArray2137 = new String[3];


    protected Friends(FlashClient var1) {
        this.aFlashClient2133 = var1;
        this.anInt2134 = var1.isRegistered() ? 0 : 2;
        this.aFriendArray2135 = this.aFriendArray2136 = null;
    }

    protected synchronized boolean method2177(int var1) {
        if (this.anInt2134 == 0) {
            MessageOut var2 = new MessageOut("user", "friends");
            if (var1 != 0) {
                var2.putData("bitmaps", aStringArray2132[var1]);
            }

            this.aFlashClient2133.sendMessage(var2);
            this.anInt2134 = 1;
            return false;
        } else {
            return this.anInt2134 != 1;
        }
    }

    protected synchronized void method2178(VArray var1, VArray var2) {
        this.aFriendArray2135 = this.method2180(var1);
        this.aFriendArray2136 = this.method2180(var2);
        this.anInt2134 = 2;
    }

    protected Friend[] method2179() {
        return this.aFriendArray2135;
    }

    private Friend[] method2180(VArray var1) {
        if (var1 == null) {
            return null;
        } else {
            Value[] var2 = var1.getValues();
            Friend[] var3 = new Friend[var2.length];

            for (int var4 = 0; var4 < var3.length; ++var4) {
                var3[var4] = new Friend(this.aFlashClient2133, (JSON) ((JSON) var2[var4]));
            }

            return var3;
        }
    }

    static {
        aStringArray2137[0] = "bitmaps";
        aStringArray2137[1] = "friends";
        aStringArray2137[2] = "user";
        aStringArray2132 = new String[]{null, method2182(method2181("hi(")), method2182(method2181("`l1")), method2182(method2181("j|"))};
    }

    private static char[] method2181(String var0) {
        char[] var10000 = var0.toCharArray();
        char[] var10001 = var10000;

        while (true) {
            int var10002 = var10001.length;
            var10001 = var10000;
            int var4 = var10002;
            if (var10002 >= 2) {
                break;
            }

            char[] var1 = var10001;
            int var2 = var4;
            var10000 = var1;
            char[] var10003 = var1;
            var10002 = var2;
            var10001 = var10003;
            if (var10002 != 0) {
                var10001 = var10000;
                boolean var3 = false;
                var10003[0] = (char) (var10003[0] ^ 68);
                break;
            }
        }

        return var10001;
    }

    private static String method2182(char[] var0) {
        int var10000 = var0.length;
        int var1 = 0;
        char[] var10001 = var0;
        if (var10000 > 1) {
            var10001 = var0;
            if (var10000 <= var1) {
                return (new String(var0)).intern();
            }
        }

        do {
            char[] var10002 = var10001;
            int var10003 = var1;

            while (true) {
                char var10004 = var10002[var10003];
                byte var10005;
                switch (var1 % 5) {
                    case 0:
                        var10005 = 105;
                        break;
                    case 1:
                        var10005 = 5;
                        break;
                    case 2:
                        var10005 = 8;
                        break;
                    case 3:
                        var10005 = 118;
                        break;
                    default:
                        var10005 = 68;
                }

                var10002[var10003] = (char) (var10004 ^ var10005);
                ++var1;
                if (var10000 != 0) {
                    break;
                }

                var10003 = var10000;
                var10002 = var10001;
            }
        } while (var10000 > var1);

        return (new String(var10001)).intern();
    }
}
