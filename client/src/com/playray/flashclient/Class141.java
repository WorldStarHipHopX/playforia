package com.playray.flashclient;

import com.playray.client.Parameters;
import com.playray.flashclient.Class142;
import com.playray.flashclient.Crypt;
import com.playray.flashclient.FlashClient;
import com.playray.flashclient.MessageIn;
import com.playray.flashclient.MessageOut;
import com.playray.json.JSON;
import com.playray.tools.Tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;

class Class141 implements Runnable {

    private FlashClient aFlashClient2091;
    private Socket aSocket2092;
    private Class142 aClass142_2093;
    private BufferedWriter aBufferedWriter2094;
    private Crypt aCrypt2095;
    private LinkedList aLinkedList2096;
    private static final String[] aStringArray2097 = new String[20];


    protected Class141(FlashClient var1) {
        this.aFlashClient2091 = var1;
    }

    public void run() {
        try {
            this.method2148(new MessageOut("conn", "hello"));

            int var1;
            do {
                do {
                    while (!this.aLinkedList2096.isEmpty()) {
                        this.method2148((MessageOut) ((MessageOut) this.aLinkedList2096.removeFirst()));
                    }

                    MessageIn var2 = this.method2149();
                    if (var2 != null) {
                        this.method2151(var2);
                    } else {
                        Tools.sleep(50L);
                    }

                    var1 = this.aFlashClient2091.method2169();
                } while (var1 == 2);
            } while (var1 == 3);
        } catch (Exception var3) {
            this.aFlashClient2091.method2174();
        }

    }

    protected boolean method2144() {
        Parameters var1 = this.aFlashClient2091.method2168().param;

        try {
            if (this.aFlashClient2091.method2168().isDebug()) {
                System.out.println("Connection: Connecting");
            }

            this.aSocket2092 = new Socket(var1.getServerIp(), var1.getServerPort());
            this.aClass142_2093 = new Class142(new BufferedReader(new InputStreamReader(this.aSocket2092.getInputStream(), "UTF-8")));
            this.aBufferedWriter2094 = new BufferedWriter(new OutputStreamWriter(this.aSocket2092.getOutputStream(), "UTF-8"));
            this.aLinkedList2096 = new LinkedList();
            return true;
        } catch (Exception var3) {
            if (this.aFlashClient2091.method2168().isDebug()) {
                System.out.println("Connection: Connecting failed");
            }

            return false;
        }
    }

    protected void method2145() {
        if (this.aFlashClient2091.method2168().isDebug()) {
            System.out.println("Connection: Starting");
        }

        Thread var1 = new Thread(this);
        var1.setDaemon(true);
        var1.start();
    }

    protected void method2146(MessageOut var1) {
        this.aLinkedList2096.addLast(var1);
    }

    protected void method2147() {
        this.method2148(new MessageOut("conn", "disconnect"));
    }

    private void method2148(MessageOut var1) {
        String var2 = var1.method2184();
        if (this.aFlashClient2091.method2168().isDebug()) {
            System.out.println("C -> S : " + var2);
        }

        if (this.aCrypt2095 != null) {
            var2 = this.aCrypt2095.encrypt(var2);
        }

        try {
            this.aBufferedWriter2094.write(var2 + "\n");
            this.aBufferedWriter2094.flush();
        } catch (IOException var4) {
            this.aFlashClient2091.method2174();
        }

    }

    private MessageIn method2149() {
        String var1 = this.method2150();
        return var1 == null ? null : new MessageIn(var1);
    }

    private String method2150() {
        try {
            String var1 = this.aClass142_2093.method2153();
            if (var1 == null) {
                return null;
            } else {
                if (this.aCrypt2095 != null) {
                    var1 = this.aCrypt2095.decrypt(var1);
                }

                if (this.aFlashClient2091.method2168().isDebug()) {
                    System.out.println("C <- S : " + var1);
                }

                return var1;
            }
        } catch (Exception var2) {
            this.aFlashClient2091.method2174();
            return null;
        }
    }

    private void method2151(MessageIn var1) {
        if (var1.method2183("conn")) {
            this.method2152(var1);
        } else if (var1.method2183("user")) {
            this.aFlashClient2091.method2170(var1);
        } else if (var1.method2183("action")) {
            this.aFlashClient2091.method2172(var1);
        }

    }

    private void method2152(MessageIn var1) {
        JSON var2 = var1.getData();
        if (var1.isCommand("ping")) {
            this.method2146(new MessageOut("conn", "pong"));
        } else if (var1.isCommand("welcome")) {
            int var3 = var2.getInt("cryptkey");
            this.aCrypt2095 = new Crypt(var3);
            this.aFlashClient2091.method2171();
        } else if (var1.isCommand("jsontowww")) {
            JSON var5 = var2.getJSON("json");
            String var4 = var5.toString();
            this.aFlashClient2091.method2168().param.callJavaScriptJSON(var4);
        } else if (var1.isCommand("disconnect")) {
            this.aFlashClient2091.method2173(var2.getInt("code"), var2.getString("reason"), var2.contains("message") ? var2.getString("message") : null);
        }

    }

    static {
        aStringArray2097[0] = "conn";
        aStringArray2097[1] = "action";
        aStringArray2097[2] = "user";
        aStringArray2097[3] = "code";
        aStringArray2097[4] = "reason";
        aStringArray2097[5] = "ping";
        aStringArray2097[6] = "welcome";
        aStringArray2097[7] = "json";
        aStringArray2097[8] = "jsontowww";
        aStringArray2097[9] = "message";
        aStringArray2097[10] = "cryptkey";
        aStringArray2097[11] = "pong";
        aStringArray2097[12] = "disconnect";
        aStringArray2097[13] = "Connection: Connecting";
        aStringArray2097[14] = "Connection: Connecting failed";
        aStringArray2097[15] = "UTF-8";
        aStringArray2097[16] = "C <- S : ";
        aStringArray2097[17] = "C -> S : ";
        aStringArray2097[18] = "hello";
        aStringArray2097[19] = "Connection: Starting";
    }
}
