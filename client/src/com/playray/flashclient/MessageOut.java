package com.playray.flashclient;

import com.playray.json.JSON;
import com.playray.json.Pair;
import com.playray.json.VArray;
import com.playray.json.Value;

public final class MessageOut {

    private String aString2144;
    private JSON aJSON2145;
    private JSON aJSON2146;
    public static boolean aBoolean2147;
    private static final String[] aStringArray2148 = new String[6];


    protected MessageOut(String var1, String var2) {
        this.aString2144 = var1;
        this.aJSON2145 = new JSON();
        this.aJSON2145.method2197(new Pair("type", var1));
        this.aJSON2146 = new JSON();
        this.aJSON2145.method2197(new Pair("data", this.aJSON2146));
        this.aJSON2146.method2197(new Pair("cmd", var2));
    }

    public String toString() {
        return "[MessageOut: json=" + this.aJSON2145.toString() + "]";
    }

    public void putData(String var1, String var2) {
        this.aJSON2146.method2197(new Pair(var1, var2));
    }

    public void putData(String var1, int var2) {
        this.aJSON2146.method2197(new Pair(var1, (long) var2));
    }

    public void putData(String var1, boolean var2) {
        this.aJSON2146.method2197(new Pair(var1, var2));
    }

    public void putData(String var1, Value var2) {
        this.aJSON2146.method2197(new Pair(var1, var2));
    }

    public void putData(String var1, Value[] var2) {
        this.putData(var1, (Value) (new VArray(var2)));
    }

    public void putData(String var1, int[] var2) {
        this.putData(var1, (Value) (new VArray(var2)));
    }

    protected String method2184() {
        StringBuffer var1 = new StringBuffer();
        this.aJSON2145.toString(var1);
        return var1.toString();
    }

    static {
        aStringArray2148[0] = "[MessageOut: json=";
        aStringArray2148[1] = "[type=\"";
        aStringArray2148[2] = "\", data=";
        aStringArray2148[3] = "cmd";
        aStringArray2148[4] = "data";
        aStringArray2148[5] = "type";
    }
}
