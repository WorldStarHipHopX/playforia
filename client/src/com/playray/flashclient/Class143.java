package com.playray.flashclient;

import com.playray.flashclient.FlashClient;
import com.playray.flashclient.MessageOut;

import java.security.MessageDigest;

class Class143 {

    private FlashClient aFlashClient2107;
    private boolean aBoolean2108;
    private String aString2109;
    private int anInt2110;
    private MessageDigest aMessageDigest2111;
    private static final String[] aStringArray2112 = new String[9];


    protected Class143(FlashClient var1) {
        this.aFlashClient2107 = var1;
        this.aBoolean2108 = false;
        this.aString2109 = null;
        this.anInt2110 = 0;
        this.aMessageDigest2111 = null;
    }

    protected void method2160(String var1) {
        synchronized (this) {
            this.aBoolean2108 = true;
            this.aString2109 = var1;
            if (this.aFlashClient2107.isRegistered()) {
                if (this.anInt2110 != 0 && this.anInt2110 != 2) {
                    if (this.anInt2110 == 1) {
                        ;
                    }
                } else {
                    MessageOut var3 = new MessageOut("user", "preparesetuserdata");
                    this.aFlashClient2107.sendMessage(var3);
                    this.anInt2110 = 1;
                }
            }

        }
    }

    protected void method2161(String var1) {
        synchronized (this) {
            if (this.anInt2110 == 1) {
                if (var1 != null) {
                    MessageOut var3 = new MessageOut("user", "setuserdata");
                    var3.putData("userdata", this.aString2109);
                    var3.putData("checksum", this.method2165(this.aString2109 + "," + var1 + ",notmhkjkepot"));
                    this.aFlashClient2107.sendMessage(var3);
                }

                this.anInt2110 = 0;
            }

        }
    }

    protected boolean method2162() {
        if (this.aFlashClient2107.isRegistered()) {
            synchronized (this) {
                if (this.anInt2110 == 0 && !this.aBoolean2108) {
                    MessageOut var2 = new MessageOut("user", "getuserdata");
                    this.aFlashClient2107.sendMessage(var2);
                    this.anInt2110 = 2;
                    return false;
                }
            }
        }

        return true;
    }

    protected void method2163(String var1) {
        synchronized (this) {
            if (this.anInt2110 == 2 && !this.aBoolean2108) {
                this.aBoolean2108 = true;
                this.aString2109 = var1;
            }

            this.anInt2110 = 0;
        }
    }

    protected String method2164() {
        return this.aBoolean2108 ? this.aString2109 : null;
    }

    private String method2165(String var1) {
        if (this.aMessageDigest2111 == null) {
            try {
                this.aMessageDigest2111 = MessageDigest.getInstance("MD5");
            } catch (Exception var3) {
                ;
            } catch (Error var4) {
                ;
            }
        }

        return this.aMessageDigest2111 == null ? "0000" : this.method2167(this.method2166(var1));
    }

    private byte[] method2166(String var1) {
        this.aMessageDigest2111.reset();
        this.aMessageDigest2111.update(var1.getBytes());
        return this.aMessageDigest2111.digest();
    }

    private String method2167(byte[] var1) {
        int var2 = var1.length;
        StringBuffer var3 = new StringBuffer(var2 * 2);

        for (int var4 = 0; var4 < var2; ++var4) {
            int var5 = var1[var4] >= 0 ? var1[var4] : 256 + var1[var4];
            if (var5 < 16) {
                var3.append('0');
            }

            var3.append(Integer.toHexString(var5));
        }

        return var3.toString();
    }

    static {
        aStringArray2112[0] = "preparesetuserdata";
        aStringArray2112[1] = "user";
        aStringArray2112[2] = "checksum";
        aStringArray2112[3] = "setuserdata";
        aStringArray2112[4] = "userdata";
        aStringArray2112[5] = ",notmhkjkepot";
        aStringArray2112[6] = "0000";
        aStringArray2112[7] = "MD5";
        aStringArray2112[8] = "getuserdata";
    }
}
