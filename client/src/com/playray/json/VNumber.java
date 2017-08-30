package com.playray.json;

import com.playray.json.Class144;
import com.playray.json.ParseException;
import com.playray.json.Value;

public class VNumber extends Value {

    private boolean aBoolean3614;
    private long aLong3615;
    private double aDouble3616;
    private static final String[] aStringArray3617 = new String[3];


    public VNumber(long var1) {
        this.aLong3615 = var1;
        this.aBoolean3614 = true;
    }

    public VNumber(double var1) {
        this.aDouble3616 = var1;
        this.aBoolean3614 = false;
    }

    public String toString() {
        return this.aBoolean3614 ? "" + this.aLong3615 : "" + this.aDouble3616;
    }

    public int getIntValue() {
        return this.aBoolean3614 ? (int) this.aLong3615 : (int) this.aDouble3616;
    }

    public long getLongValue() {
        return this.aBoolean3614 ? this.aLong3615 : (long) this.aDouble3616;
    }

    public double getDoubleValue() {
        return this.aBoolean3614 ? (double) this.aLong3615 : this.aDouble3616;
    }

    protected static Value method2202(Class144 var0) throws ParseException {
        StringBuffer var1 = new StringBuffer();
        char var2 = var0.method2187();
        if (!method2203(var2)) {
            throw new ParseException("Unexpected start \'" + var2 + "\' of number string");
        } else {
            var1.append(var2);

            while (method2203(var0.method2186())) {
                var1.append(var0.method2185());
            }

            String var3 = var1.toString();

            try {
                long var8 = Long.parseLong(var3);
                return new VNumber(var8);
            } catch (NumberFormatException var7) {
                try {
                    double var4 = Double.parseDouble(var3);
                    return new VNumber(var4);
                } catch (NumberFormatException var6) {
                    throw new ParseException("Invalid number format \"" + var3 + "\"");
                }
            }
        }
    }

    protected void toString(StringBuffer var1) {
        if (this.aBoolean3614) {
            var1.append(this.aLong3615);
        } else {
            var1.append(this.aDouble3616);
        }

    }

    private static boolean method2203(char var0) {
        return var0 != 45 && var0 != 43 ? (var0 >= 48 && var0 <= 57 ? true : (var0 == 46 ? true : var0 == 101 || var0 == 69)) : true;
    }

    static {
        aStringArray3617[0] = "Invalid number format \"";
        aStringArray3617[1] = "Unexpected start \'";
        aStringArray3617[2] = "\' of number string";
    }
}
