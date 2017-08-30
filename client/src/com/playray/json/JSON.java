package com.playray.json;

import com.playray.json.Class144;
import com.playray.json.Pair;
import com.playray.json.ParseException;
import com.playray.json.VArray;
import com.playray.json.VBoolean;
import com.playray.json.VNumber;
import com.playray.json.Value;

import java.util.Enumeration;
import java.util.Hashtable;

public class JSON extends Value {

    private Hashtable aHashtable3606 = new Hashtable();
    private boolean aBoolean3607 = false;
    private static final String[] aStringArray3608 = new String[6];


    public String toString() {
        StringBuffer var1 = new StringBuffer();
        this.toString(var1);
        return var1.toString();
    }

    public static JSON parse(String var0) throws ParseException {
        Class144 var1 = new Class144(var0);
        return (JSON) ((JSON) method2196(var1));
    }

    protected static Value method2196(Class144 var0) throws ParseException {
        JSON var1 = new JSON();
        byte var2 = 0;

        while (true) {
            char var4;
            while (var2 != 0) {
                if (var2 == 1) {
                    if (var0.method2188() == 125) {
                        var0.method2187();
                        return var1;
                    }

                    var2 = 2;
                } else if (var2 == 2) {
                    Pair var3 = Pair.method2193(var0);
                    var1.method2197(var3);
                    var2 = 3;
                } else if (var2 == 3) {
                    var4 = var0.method2187();
                    if (var4 == 125) {
                        return var1;
                    }

                    if (var4 != 44) {
                        throw new ParseException("Unexpected character \'" + var4 + "\', was expecting \'}\' or \',\' (PS=\"" + var0.method2190() + "\")");
                    }

                    var2 = 2;
                }
            }

            var4 = var0.method2187();
            if (var4 != 123) {
                throw new ParseException("Unexpected character \'" + var4 + "\', was expecting \'{\'");
            }

            var2 = 1;
        }
    }

    public void toString(StringBuffer var1) {
        var1.append('{');
        synchronized (this) {
            Enumeration var3 = this.aHashtable3606.elements();

            while (true) {
                if (!var3.hasMoreElements()) {
                    break;
                }

                Pair var4 = (Pair) ((Pair) var3.nextElement());
                var4.method2194(var1);
                if (var3.hasMoreElements()) {
                    var1.append(',');
                }
            }
        }

        var1.append('}');
    }

    public void setPutSafeMode(boolean var1) {
        this.aBoolean3607 = var1;
    }

    public void method2197(Pair var1) {
        String var2 = var1.getKey();
        synchronized (this) {
            if (this.aBoolean3607 && this.aHashtable3606.containsKey(var2)) {
                throw new IllegalArgumentException("Trying to put Pair with key \"" + var2 + "\" to JSON (with \'put safe mode\' enabled) that already contains same key");
            } else {
                this.aHashtable3606.put(var2, var1);
            }
        }
    }

    public void remove(String var1) {
        synchronized (this) {
            this.aHashtable3606.remove(var1);
        }
    }

    public boolean contains(String var1) {
        return this.aHashtable3606.containsKey(var1);
    }

    public Pair method2198(String var1) {
        return (Pair) ((Pair) this.aHashtable3606.get(var1));
    }

    public Pair[] getAll() {
        synchronized (this) {
            int var3 = this.aHashtable3606.size();
            Pair[] var1 = new Pair[var3];
            if (var3 > 0) {
                Enumeration var4 = this.aHashtable3606.elements();

                for (int var5 = 0; var5 < var3; ++var5) {
                    var1[var5] = (Pair) ((Pair) var4.nextElement());
                }
            }

            return var1;
        }
    }

    public boolean isEmpty() {
        return this.aHashtable3606.isEmpty();
    }

    public Value getValue(String var1) {
        Pair var2 = this.method2198(var1);
        return var2 == null ? null : var2.getValue();
    }

    public JSON getJSON(String var1) {
        Value var2 = this.getValue(var1);
        if (var2 == null) {
            return null;
        } else {
            JSON var3 = (JSON) ((JSON) var2);
            return var3;
        }
    }

    public String getString(String var1) {
        Value var2 = this.getValue(var1);
        return var2 == null ? null : var2.toString();
    }

    public int getInt(String var1) {
        Value var2 = this.getValue(var1);
        if (var2 == null) {
            return 0;
        } else {
            VNumber var3 = (VNumber) ((VNumber) var2);
            return var3.getIntValue();
        }
    }

    public long getLong(String var1) {
        Value var2 = this.getValue(var1);
        if (var2 == null) {
            return 0L;
        } else {
            VNumber var3 = (VNumber) ((VNumber) var2);
            return var3.getLongValue();
        }
    }

    public double getDouble(String var1) {
        Value var2 = this.getValue(var1);
        if (var2 == null) {
            return Double.NaN;
        } else {
            VNumber var3 = (VNumber) ((VNumber) var2);
            return var3.getDoubleValue();
        }
    }

    public boolean getBoolean(String var1) {
        Value var2 = this.getValue(var1);
        if (var2 == null) {
            return false;
        } else {
            VBoolean var3 = (VBoolean) ((VBoolean) var2);
            return var3.getValue();
        }
    }

    public VArray getArray(String var1) {
        Value var2 = this.getValue(var1);
        if (var2 == null) {
            return null;
        } else {
            VArray var3 = (VArray) ((VArray) var2);
            return var3;
        }
    }

    static {
        aStringArray3608[0] = "\" to JSON (with \'put safe mode\' enabled) that already contains same key";
        aStringArray3608[1] = "Trying to put Pair with key \"";
        aStringArray3608[2] = "\")";
        aStringArray3608[3] = "Unexpected character \'";
        aStringArray3608[4] = "\', was expecting \'{\'";
        aStringArray3608[5] = "\', was expecting \'}\' or \',\' (PS=\"";
    }
}
