package com.playray.flashclient;

import com.playray.json.JSON;
import com.playray.json.ParseException;

public final class MessageIn {

    private String aString2138;
    private JSON aJSON2139;
    private String aString2140;
    private String aString2141;
    private long aLong2142;
    private static final String[] aStringArray2143 = new String[9];


    protected MessageIn(String var1) {
        try {
            JSON var2 = JSON.parse(var1);
            this.aString2138 = var2.getString("type");
            this.aJSON2139 = var2.getJSON("data");
            this.aString2140 = this.aJSON2139.getString("cmd");
        } catch (ParseException var3) {
            this.aString2141 = var1;
        }

        this.aLong2142 = System.currentTimeMillis();
    }

    public String toString() {
        return this.aString2141 != null ? "[MessageIn: nonjson=\"" + this.aString2141 + "\"]" : "[MessageIn: type=\"" + this.aString2138 + "\", data=" + this.aJSON2139.toString() + "]";
    }

    protected boolean method2183(String var1) {
        return this.aString2138.equals(var1);
    }

    public String getCommand() {
        return this.aString2140;
    }

    public boolean isCommand(String var1) {
        return this.aString2140.equals(var1);
    }

    public JSON getData() {
        return this.aJSON2139;
    }

    public long getReceiveTime() {
        return this.aLong2142;
    }

    static {
        aStringArray2143[0] = "\", data=";
        aStringArray2143[1] = "[nonjson=\"";
        aStringArray2143[2] = "[type=\"";
        aStringArray2143[3] = "\"]";
        aStringArray2143[4] = "[MessageIn: nonjson=\"";
        aStringArray2143[5] = "[MessageIn: type=\"";
        aStringArray2143[6] = "data";
        aStringArray2143[7] = "type";
        aStringArray2143[8] = "cmd";
    }
}
