package com.playray.json;

import com.playray.json.Class144;
import com.playray.json.ParseException;

class Class145 {

    private static final String[] aStringArray2153 = new String[10];


    protected static void method2191(String var0, StringBuffer var1) {
        var1.append('\"');
        char[] var2 = var0.toCharArray();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3] == 34) {
                var1.append("\\\"");
            } else if (var2[var3] == 92) {
                var1.append("\\\\");
            } else if (var2[var3] == 8) {
                var1.append("\\b");
            } else if (var2[var3] == 12) {
                var1.append("\\f");
            } else if (var2[var3] == 10) {
                var1.append("\\n");
            } else if (var2[var3] == 13) {
                var1.append("\\r");
            } else if (var2[var3] == 9) {
                var1.append("\\t");
            } else {
                var1.append(var2[var3]);
            }
        }

        var1.append('\"');
    }

    protected static String method2192(Class144 var0) throws ParseException {
        StringBuffer var1 = null;
        boolean var2 = false;

        while (true) {
            char var3;
            while (var2) {
                if (var2) {
                    var3 = var0.method2185();
                    if (var3 == 34) {
                        return var1.toString();
                    }

                    if (var3 == 92) {
                        char var4 = var0.method2185();
                        if (var4 == 34) {
                            var3 = 34;
                        } else if (var4 == 92) {
                            var3 = 92;
                        } else if (var4 == 47) {
                            var3 = 47;
                        } else if (var4 == 98) {
                            var3 = 8;
                        } else if (var4 == 102) {
                            var3 = 12;
                        } else if (var4 == 110) {
                            var3 = 10;
                        } else if (var4 == 114) {
                            var3 = 13;
                        } else if (var4 == 116) {
                            var3 = 9;
                        } else {
                            if (var4 != 117) {
                                throw new ParseException("Unexpected character \'" + var3 + "\' after \'\\\'");
                            }

                            String var5 = var0.method2189(4);
                            int var6 = Integer.parseInt(var5, 16);
                            var3 = (char) var6;
                        }
                    }

                    var1.append(var3);
                }
            }

            var3 = var0.method2187();
            if (var3 != 34) {
                throw new ParseException("Unexpected character \'" + var3 + "\', was expecting \'\"\'");
            }

            var1 = new StringBuffer();
            var2 = true;
        }
    }

    static {
        aStringArray2153[0] = "\\n";
        aStringArray2153[1] = "\\f";
        aStringArray2153[2] = "\\t";
        aStringArray2153[3] = "\\r";
        aStringArray2153[4] = "\\\"";
        aStringArray2153[5] = "\\\\";
        aStringArray2153[6] = "\\b";
        aStringArray2153[7] = "\' after \'\\\'";
        aStringArray2153[8] = "\', was expecting \'\"\'";
        aStringArray2153[9] = "Unexpected character \'";
    }
}
