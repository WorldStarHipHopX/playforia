package com.playray.json;

import com.playray.json.Class144;
import com.playray.json.Class145;
import com.playray.json.ParseException;
import com.playray.json.VArray;
import com.playray.json.VBoolean;
import com.playray.json.VNull;
import com.playray.json.VNumber;
import com.playray.json.VString;
import com.playray.json.Value;

import java.util.LinkedList;

public class Pair implements Comparable {

    private String aString2154;
    private Value aValue2155;
    private static final String[] aStringArray2156 = new String[2];


    public Pair(String var1, Object var2) {
        this.aString2154 = var1;
        if (var2 == null) {
            this.aValue2155 = new VNull();
        } else if (var2 instanceof Value) {
            this.aValue2155 = (Value) ((Value) var2);
        } else if (var2 instanceof String) {
            this.aValue2155 = new VString((String) ((String) var2));
        } else if (var2 instanceof Integer) {
            this.aValue2155 = new VNumber((long) ((Integer) ((Integer) var2)).intValue());
        } else if (var2 instanceof Long) {
            this.aValue2155 = new VNumber(((Long) ((Long) var2)).longValue());
        } else if (var2 instanceof Double) {
            this.aValue2155 = new VNumber(((Double) ((Double) var2)).doubleValue());
        } else if (var2 instanceof Float) {
            this.aValue2155 = new VNumber((double) ((Float) ((Float) var2)).floatValue());
        } else if (var2 instanceof Boolean) {
            this.aValue2155 = new VBoolean(((Boolean) ((Boolean) var2)).booleanValue());
        } else if (var2 instanceof Value[]) {
            this.aValue2155 = new VArray((Value[]) ((Value[]) var2));
        } else if (var2 instanceof String[]) {
            this.aValue2155 = new VArray((String[]) ((String[]) var2));
        } else if (var2 instanceof int[]) {
            this.aValue2155 = new VArray((int[]) ((int[]) var2));
        } else if (var2 instanceof long[]) {
            this.aValue2155 = new VArray((long[]) ((long[]) var2));
        } else if (var2 instanceof LinkedList) {
            this.aValue2155 = new VArray((LinkedList) ((LinkedList) var2));
        } else {
            this.aValue2155 = new VString(var2.toString());
        }

    }

    public Pair(String var1, long var2) {
        this.aString2154 = var1;
        this.aValue2155 = new VNumber(var2);
    }

    public Pair(String var1, double var2) {
        this.aString2154 = var1;
        this.aValue2155 = new VNumber(var2);
    }

    public Pair(String var1, boolean var2) {
        this.aString2154 = var1;
        this.aValue2155 = new VBoolean(var2);
    }

    public int compareTo(Object var1) {
        if (var1 == null) {
            return -1;
        } else if (!(var1 instanceof Pair)) {
            return -1;
        } else {
            Pair var2 = (Pair) ((Pair) var1);
            return this.getKey().compareTo(var2.getKey());
        }
    }

    public String getKey() {
        return this.aString2154;
    }

    public Value getValue() {
        return this.aValue2155;
    }

    protected static Pair method2193(Class144 var0) throws ParseException {
        byte var1 = 0;
        String var2 = null;

        while (true) {
            while (var1 != 0) {
                if (var1 == 1) {
                    char var3 = var0.method2187();
                    if (var3 != 58) {
                        throw new ParseException("Unexpected character \'" + var3 + "\', was expecting \':\'");
                    }

                    var1 = 2;
                } else if (var1 == 2) {
                    Value var5 = Value.method2195(var0);
                    Pair var4 = new Pair(var2, var5);
                    return var4;
                }
            }

            var2 = Class145.method2192(var0);
            var1 = 1;
        }
    }

    protected void method2194(StringBuffer var1) {
        Class145.method2191(this.aString2154, var1);
        var1.append(':');
        this.aValue2155.toString(var1);
    }

    static {
        aStringArray2156[0] = "\', was expecting \':\'";
        aStringArray2156[1] = "Unexpected character \'";
    }
}
