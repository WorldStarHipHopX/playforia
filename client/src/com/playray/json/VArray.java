package com.playray.json;

import com.playray.json.Class144;
import com.playray.json.ParseException;
import com.playray.json.VNumber;
import com.playray.json.VString;
import com.playray.json.Value;

import java.util.LinkedList;

public class VArray extends Value {

    private Value[] aValueArray3609;
    private static final String[] aStringArray3610 = new String[3];


    public VArray() {
        this.aValueArray3609 = new VArray[0];
    }

    public VArray(Value[] var1) {
        this.aValueArray3609 = var1;
    }

    public VArray(LinkedList var1) {
        this.aValueArray3609 = new Value[var1.size()];
        var1.toArray(this.aValueArray3609);
    }

    public VArray(String[] var1) {
        this.aValueArray3609 = new Value[var1.length];

        for (int var2 = 0; var2 < var1.length; ++var2) {
            this.aValueArray3609[var2] = new VString(var1[var2]);
        }

    }

    public VArray(int[] var1) {
        this.aValueArray3609 = new Value[var1.length];

        for (int var2 = 0; var2 < var1.length; ++var2) {
            this.aValueArray3609[var2] = new VNumber((long) var1[var2]);
        }

    }

    public VArray(long[] var1) {
        this.aValueArray3609 = new Value[var1.length];

        for (int var2 = 0; var2 < var1.length; ++var2) {
            this.aValueArray3609[var2] = new VNumber(var1[var2]);
        }

    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        this.toString(var1);
        return var1.toString();
    }

    public Value[] getValues() {
        return this.aValueArray3609;
    }

    public int getLength() {
        return this.aValueArray3609.length;
    }

    public String[] getValuesAsStringArray() {
        String[] var1 = new String[this.aValueArray3609.length];

        for (int var2 = 0; var2 < this.aValueArray3609.length; ++var2) {
            var1[var2] = ((VString) ((VString) this.aValueArray3609[var2])).getValue();
        }

        return var1;
    }

    public int[] getValuesAsIntArray() {
        int[] var1 = new int[this.aValueArray3609.length];

        for (int var2 = 0; var2 < this.aValueArray3609.length; ++var2) {
            var1[var2] = ((VNumber) ((VNumber) this.aValueArray3609[var2])).getIntValue();
        }

        return var1;
    }

    public long[] getValuesAsLongArray() {
        long[] var1 = new long[this.aValueArray3609.length];

        for (int var2 = 0; var2 < this.aValueArray3609.length; ++var2) {
            var1[var2] = ((VNumber) ((VNumber) this.aValueArray3609[var2])).getLongValue();
        }

        return var1;
    }

    protected static Value method2199(Class144 var0) throws ParseException {
        LinkedList var1 = new LinkedList();
        byte var2 = 0;

        while (true) {
            char var4;
            while (var2 != 0) {
                if (var2 == 1) {
                    if (var0.method2188() == 93) {
                        var0.method2187();
                        return new VArray(var1);
                    }

                    var2 = 2;
                } else if (var2 == 2) {
                    Value var3 = Value.method2195(var0);
                    var1.add(var3);
                    var2 = 3;
                } else if (var2 == 3) {
                    var4 = var0.method2187();
                    if (var4 == 93) {
                        return new VArray(var1);
                    }

                    if (var4 != 44) {
                        throw new ParseException("Unexpected character \'" + var4 + "\', was expecting \']\' or \',\'");
                    }

                    var2 = 2;
                }
            }

            var4 = var0.method2187();
            if (var4 != 91) {
                throw new ParseException("Unexpected character \'" + var4 + "\', was expecting \'[\'");
            }

            var2 = 1;
        }
    }

    protected void toString(StringBuffer var1) {
        var1.append('[');

        for (int var2 = 0; var2 < this.aValueArray3609.length; ++var2) {
            this.aValueArray3609[var2].toString(var1);
            if (var2 < this.aValueArray3609.length - 1) {
                var1.append(',');
            }
        }

        var1.append(']');
    }

    static {
        aStringArray3610[0] = "\', was expecting \']\' or \',\'";
        aStringArray3610[1] = "\', was expecting \'[\'";
        aStringArray3610[2] = "Unexpected character \'";
    }
}
