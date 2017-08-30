package com.playray.json;

import com.playray.json.ParseException;

class Class144 {

    private String aString2149;
    private int anInt2150;
    private int anInt2151;
    private static final String aString2152 = "Unexpected end of string";


    protected Class144(String var1) {
        this.aString2149 = var1;
        this.anInt2150 = var1.length();
        this.anInt2151 = 0;
    }

    protected char method2185() throws ParseException {
        if (this.anInt2151 >= this.anInt2150) {
            throw new ParseException("Unexpected end of string");
        } else {
            char var1 = this.aString2149.charAt(this.anInt2151);
            ++this.anInt2151;
            return var1;
        }
    }

    protected char method2186() throws ParseException {
        int var1 = this.anInt2151;
        char var2 = this.method2185();
        this.anInt2151 = var1;
        return var2;
    }

    protected char method2187() throws ParseException {
        char var1;
        do {
            var1 = this.method2185();
        } while (Character.isWhitespace(var1));

        return var1;
    }

    protected char method2188() throws ParseException {
        int var1 = this.anInt2151;
        char var2 = this.method2187();
        this.anInt2151 = var1;
        return var2;
    }

    protected String method2189(int var1) throws ParseException {
        StringBuffer var2 = new StringBuffer(var1);

        for (int var3 = 0; var3 < var1; ++var3) {
            var2.append(this.method2185());
        }

        return var2.toString();
    }

    protected String method2190() {
        int var1 = this.anInt2151 - 11;
        int var2 = this.anInt2151 + 10;
        if (var1 < 0) {
            var1 = 0;
        }

        if (var2 >= this.anInt2150) {
            var2 = this.anInt2150 - 1;
        }

        return this.aString2149.substring(var1, this.anInt2151 - 1) + " " + this.aString2149.charAt(this.anInt2151 - 1) + " " + this.aString2149.substring(this.anInt2151, var2);
    }

}
