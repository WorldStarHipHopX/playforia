package com.playray.json;

import com.playray.json.Class144;
import com.playray.json.ParseException;
import com.playray.json.Value;

public class VNull extends Value {

    private static final String[] aStringArray3613 = new String[3];


    public String toString() {
        return "null";
    }

    protected static Value method2201(Class144 var0) throws ParseException {
        char var1 = var0.method2187();
        String var2 = var0.method2189(3);
        if (var1 == 110 && var2.equals("ull")) {
            return new VNull();
        } else {
            throw new ParseException("Unexpected null string \"" + var1 + var2 + "\"");
        }
    }

    protected void toString(StringBuffer var1) {
        var1.append("null");
    }

    static {
        aStringArray3613[0] = "null";
        aStringArray3613[1] = "ull";
        aStringArray3613[2] = "Unexpected null string \"";
    }
}
