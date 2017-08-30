package com.playray.flashclient;

import com.playray.applet.AApplet;
import com.playray.client.Parameters;
import com.playray.flashclient.Class141;
import com.playray.flashclient.Class143;
import com.playray.flashclient.FlashGame;
import com.playray.flashclient.Friend;
import com.playray.flashclient.Friends;
import com.playray.flashclient.MessageIn;
import com.playray.flashclient.MessageOut;
import com.playray.json.JSON;
import com.playray.tools.Tools;

import java.util.LinkedList;

public class FlashClient implements Runnable {

    public static final int STARTUP_OK = 0;
    public static final int STARTUP_JOINZONE_FAILED = 1;
    public static final int STARTUP_LOGIN_FAILED = 2;
    private FlashGame aFlashGame2113;
    private int anInt2114;
    private Class141 aClass141_2115;
    private LinkedList aLinkedList2116;
    private boolean aBoolean2117;
    private boolean aBoolean2118;
    private String aString2119;
    private boolean aBoolean2120;
    private Class143 aClass143_2121;
    private Friends aFriends2122;
    private static final String[] aStringArray2123 = new String[23];


    public FlashClient(FlashGame var1) {
        this.aFlashGame2113 = var1;
        this.anInt2114 = 0;
        this.aBoolean2117 = false;
        this.aBoolean2118 = true;
        this.aString2119 = null;
        this.aBoolean2120 = false;
    }

    public void run() {
        while (true) {
            if (!this.aLinkedList2116.isEmpty()) {
                this.aFlashGame2113.actionCommandReceived((MessageIn) ((MessageIn) this.aLinkedList2116.removeFirst()));
            } else {
                Tools.sleep(50L);
                if (this.anInt2114 != 3) {
                    return;
                }
            }
        }
    }

    public static MessageOut getActionMessageOut(String var0) {
        MessageOut var1 = new MessageOut("action", var0);
        return var1;
    }

    public boolean connectToServer() {
        if (this.anInt2114 != 0) {
            System.out.println("FlashClient.connectToServer() called when state is " + this.anInt2114);
            return false;
        } else {
            this.anInt2114 = 1;
            this.aClass141_2115 = new Class141(this);
            if (!this.aClass141_2115.method2144()) {
                this.anInt2114 = 4;
                return false;
            } else {
                return true;
            }
        }
    }

    public void startUp() {
        if (this.anInt2114 != 1) {
            System.out.println("FlashClient.startUp() called when state is " + this.anInt2114);
        } else {
            this.anInt2114 = 2;
            this.aClass141_2115.method2145();
        }
    }

    public boolean sendMessage(MessageOut var1) {
        if (this.anInt2114 != 3) {
            return false;
        } else {
            this.aClass141_2115.method2146(var1);
            return true;
        }
    }

    public boolean isRegistered() {
        return this.aBoolean2117;
    }

    public boolean isEmailUnconfirmed() {
        return this.aBoolean2118;
    }

    public String getOwnNick() {
        return this.aString2119;
    }

    public boolean isBadWordFilter() {
        return this.aBoolean2120;
    }

    public void setUserData(String var1) {
        if (this.anInt2114 == 3) {
            this.aClass143_2121.method2160(var1);
        }
    }

    public boolean requestUserData() {
        return this.aClass143_2121.method2162();
    }

    public String getUserData() {
        return this.anInt2114 != 3 ? null : this.aClass143_2121.method2164();
    }

    public boolean requestFriendList(int var1) {
        return this.aFriends2122.method2177(var1);
    }

    public Friend[] getFriendList() {
        return this.anInt2114 != 3 ? null : this.aFriends2122.method2179();
    }

    public void disconnectFromServer() {
        if (this.anInt2114 != 3) {
            if (this.aFlashGame2113.getAApplet().isDebug()) {
                System.out.println("FlashClient.disconnectFromServer() called when state is " + this.anInt2114);
            }

        } else {
            this.anInt2114 = 4;
            this.aClass141_2115.method2147();
        }
    }

    protected AApplet method2168() {
        return this.aFlashGame2113.getAApplet();
    }

    protected int method2169() {
        return this.anInt2114;
    }

    protected void method2170(MessageIn var1) {
        JSON var2 = var1.getData();
        if (var1.isCommand("joinzone")) {
            this.method2175(var2.getBoolean("success"));
        } else if (var1.isCommand("login")) {
            this.method2176(var2);
        } else if (var1.isCommand("preparesetuserdata")) {
            this.aClass143_2121.method2161(var2.getBoolean("success") ? var2.getString("key") : null);
        } else if (var1.isCommand("getuserdata")) {
            this.aClass143_2121.method2163(var2.getBoolean("success") ? var2.getString("userdata") : null);
            this.aFlashGame2113.userDataReady();
        } else if (var1.isCommand("friends")) {
            boolean var3 = var2.getBoolean("success");
            this.aFriends2122.method2178(var3 ? var2.getArray("list") : null, var3 ? var2.getArray("requestlist") : null);
            this.aFlashGame2113.friendListReady();
        }

    }

    protected void method2171() {
        MessageOut var1 = new MessageOut("user", "joinzone");
        var1.putData("zone", this.aFlashGame2113.getZoneName());
        this.aClass141_2115.method2146(var1);
    }

    protected void method2172(MessageIn var1) {
        this.aLinkedList2116.addLast(var1);
    }

    protected void method2173(int var1, String var2, String var3) {
        this.anInt2114 = 4;
        AApplet var4 = this.aFlashGame2113.getAApplet();
        if (var1 == 1) {
            var4.setEndState(4);
        } else if (var1 == 2) {
            var4.setEndState(13);
        } else if (var1 == 3) {
            var4.setEndState(11);
        } else if (var1 == 8) {
            var4.setEndState(9);
        } else {
            var4.setEndState(var2);
        }

        this.aFlashGame2113.notifyServerDisconnecting(var1);
    }

    protected void method2174() {
        this.anInt2114 = 4;
        this.aFlashGame2113.connectionError();
    }

    private void method2175(boolean var1) {
        if (!var1) {
            this.anInt2114 = 4;
            this.aFlashGame2113.startUpResult(1);
        } else {
            MessageOut var2 = new MessageOut("user", "login");
            Parameters var3 = this.aFlashGame2113.getAApplet().param;
            String var4 = var3.getSession();
            if (var4 != null) {
                var2.putData("session", var4);
            }

            String var5 = var3.getSessionLocale();
            if (var5 != null) {
                var2.putData("sessionlocale", var5);
            }

            String var6 = var3.getChatLang();
            if (var6 != null) {
                var2.putData("lang", var6);
            }

            this.aClass141_2115.method2146(var2);
        }
    }

    private void method2176(JSON var1) {
        if (!var1.getBoolean("success")) {
            this.anInt2114 = 4;
            this.aFlashGame2113.startUpResult(2);
        } else {
            JSON var2 = var1.getJSON("user");
            this.aBoolean2117 = var2.getBoolean("reg");
            this.aBoolean2118 = var2.getBoolean("emailunconfirmed");
            this.aString2119 = var2.getString("nick");
            this.aBoolean2120 = var2.getBoolean("badwordfilter");
            this.aClass143_2121 = new Class143(this);
            this.aFriends2122 = new Friends(this);
            this.anInt2114 = 3;
            this.aLinkedList2116 = new LinkedList();
            Thread var3 = new Thread(this);
            var3.setDaemon(true);
            var3.start();
            this.aFlashGame2113.startUpResult(0);
        }
    }

    static {
        aStringArray2123[0] = "action";
        aStringArray2123[1] = "nick";
        aStringArray2123[2] = "reg";
        aStringArray2123[3] = "badwordfilter";
        aStringArray2123[4] = "success";
        aStringArray2123[5] = "emailunconfirmed";
        aStringArray2123[6] = "user";
        aStringArray2123[7] = "preparesetuserdata";
        aStringArray2123[8] = "getuserdata";
        aStringArray2123[9] = "joinzone";
        aStringArray2123[10] = "friends";
        aStringArray2123[11] = "login";
        aStringArray2123[12] = "userdata";
        aStringArray2123[13] = "key";
        aStringArray2123[14] = "requestlist";
        aStringArray2123[15] = "list";
        aStringArray2123[16] = "FlashClient.disconnectFromServer() called when state is ";
        aStringArray2123[17] = "FlashClient.startUp() called when state is ";
        aStringArray2123[18] = "zone";
        aStringArray2123[19] = "FlashClient.connectToServer() called when state is ";
        aStringArray2123[20] = "session";
        aStringArray2123[21] = "lang";
        aStringArray2123[22] = "sessionlocale";
    }
}
