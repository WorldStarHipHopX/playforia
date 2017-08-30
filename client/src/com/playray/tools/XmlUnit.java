package com.playray.tools;

import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

public class XmlUnit {

    private static final String aString2238 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
    private static final String aString2239 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-:";
    private String aString2240;
    private String aString2241;
    private Vector aVector2242;
    private Hashtable aHashtable2243;
    private static final String[] aStringArray2244 = new String[18];


    private XmlUnit(String var1) {
        this.aString2240 = var1;
        this.aString2241 = null;
        this.aVector2242 = new Vector();
        this.aHashtable2243 = new Hashtable();
    }

    public static XmlUnit parseString(String var0, boolean var1, boolean var2) throws Exception {
        var0 = var0.trim();
        if (var0.startsWith("<?xml")) {
            var0 = var0.substring(var0.indexOf(62) + 1).trim();
        }

        return method2266(var0, var2);
    }

    public String getName() {
        return this.aString2240;
    }

    public String getValue() {
        return this.aString2241;
    }

    public XmlUnit getChild(String var1) {
        Vector var2 = this.aVector2242;
        synchronized (this.aVector2242) {
            int var3 = this.aVector2242.size();

            for (int var5 = 0; var5 < var3; ++var5) {
                XmlUnit var4 = (XmlUnit) ((XmlUnit) this.aVector2242.elementAt(var5));
                if (var4.getName().equals(var1)) {
                    return var4;
                }
            }

            return null;
        }
    }

    public String getChildValue(String var1) {
        XmlUnit var2 = this.getChild(var1);
        return var2 == null ? null : var2.getValue();
    }

    public XmlUnit[] getChildren() {
        Vector var2 = this.aVector2242;
        synchronized (this.aVector2242) {
            int var3 = this.aVector2242.size();
            XmlUnit[] var1 = new XmlUnit[var3];

            for (int var4 = 0; var4 < var3; ++var4) {
                var1[var4] = (XmlUnit) ((XmlUnit) this.aVector2242.elementAt(var4));
            }

            return var1;
        }
    }

    public XmlUnit[] getChildren(String var1) {
        XmlUnit[] var2 = this.getChildren();
        int var3 = var2.length;
        int var4 = 0;

        for (int var5 = 0; var5 < var3; ++var5) {
            if (var2[var5].getName().equals(var1)) {
                ++var4;
            }
        }

        XmlUnit[] var8 = new XmlUnit[var4];
        int var6 = 0;

        for (int var7 = 0; var7 < var3; ++var7) {
            if (var2[var7].getName().equals(var1)) {
                var8[var6] = var2[var7];
                ++var6;
            }
        }

        return var8;
    }

    public String getAttribute(String var1) {
        Hashtable var2 = this.aHashtable2243;
        synchronized (this.aHashtable2243) {
            return (String) ((String) this.aHashtable2243.get(var1));
        }
    }

    private static XmlUnit method2266(String var0, boolean var1) throws Exception {
        Stack var2 = new Stack();
        StringBuffer var3 = null;
        StringBuffer var4 = null;
        XmlUnit var5 = null;
        byte var7 = 0;
        int var8 = var0.length();

        for (int var12 = 0; var12 < var8; ++var12) {
            char var9 = var0.charAt(var12);
            boolean var11 = false;
            boolean var10 = false;
            if (var7 == 0) {
                if (var9 <= 32) {
                    var10 = true;
                } else if (var9 == 60) {
                    var7 = 1;
                    var3 = new StringBuffer();
                    var10 = true;
                }
            } else if (var7 == 1) {
                if (aString2238.indexOf(var9) >= 0) {
                    var3.append(var9);
                    var10 = true;
                } else if (var9 == 62 || var9 == 47 || var9 <= 32) {
                    if (var3.length() == 0) {
                        throw new Exception("Empty tag name");
                    }

                    var5 = new XmlUnit(var3.toString());
                    if (var9 <= 32) {
                        var12 = method2267(var5, var0, var12, var8);
                        var9 = var0.charAt(var12);
                    }

                    if (var9 == 62) {
                        var7 = 2;
                        var4 = new StringBuffer();
                    } else {
                        var7 = 6;
                    }

                    var10 = true;
                }
            } else if (var7 == 2) {
                if (var9 == 60) {
                    if (var0.startsWith("<![CDATA[", var12)) {
                        var7 = 3;
                        var12 += 8;
                    } else {
                        if (var4.length() > 0 || var1) {
                            var5.method2269(var4.toString(), var1);
                        }

                        if (var0.startsWith("</", var12)) {
                            var7 = 4;
                            ++var12;
                            var3 = new StringBuffer();
                        } else {
                            var2.push(var5);
                            var7 = 1;
                            var3 = new StringBuffer();
                        }
                    }
                } else if (var9 == 38) {
                    var12 = method2268(var4, var0, var12);
                } else {
                    var4.append(var9);
                }

                var10 = true;
            } else if (var7 == 3) {
                if (var9 == 93) {
                    if (var0.startsWith("]]>", var12)) {
                        var7 = 2;
                        var12 += 2;
                    } else {
                        var4.append(var9);
                    }
                } else {
                    var4.append(var9);
                }

                var10 = true;
            } else if (var7 == 4) {
                if (aString2238.indexOf(var9) >= 0) {
                    var3.append(var9);
                    var10 = true;
                } else if (var9 == 62) {
                    if (var3.length() == 0) {
                        throw new Exception("Empty end tag name");
                    }

                    if (!var5.getName().equals(var3.toString())) {
                        throw new Exception("End tag name (" + var3 + ") is different than start tag (" + var5.getName() + ")");
                    }

                    var11 = true;
                    var10 = true;
                }
            } else if (var7 == 5) {
                if (var9 <= 32) {
                    var10 = true;
                }
            } else if (var7 == 6 && var9 == 62) {
                var11 = true;
                var10 = true;
            }

            if (!var10) {
                throw new Exception("Unexpected character \'" + var9 + "\'");
            }

            if (var11) {
                if (var2.empty()) {
                    var7 = 5;
                } else {
                    XmlUnit var6 = (XmlUnit) ((XmlUnit) var2.pop());
                    var6.method2270(var5);
                    var5 = var6;
                    var7 = 2;
                    var4 = new StringBuffer();
                }
            }
        }

        if (var7 != 5) {
            throw new Exception("Premature end of xml data");
        } else {
            return var5;
        }
    }

    private static int method2267(XmlUnit var0, String var1, int var2, int var3) throws Exception {
        StringBuffer var4 = null;
        StringBuffer var5 = null;
        byte var6 = 0;
        char var7 = 0;

        char var8;
        boolean var9;
        do {
            ++var2;
            if (var2 == var3) {
                throw new Exception("Premature end of attribute data");
            }

            var8 = var1.charAt(var2);
            var9 = false;
            if (var6 == 0) {
                if (aString2239.indexOf(var8) >= 0) {
                    var6 = 1;
                    var4 = new StringBuffer();
                    var4.append(var8);
                    var9 = true;
                } else if (var8 == 32) {
                    var9 = true;
                } else if (var8 == 47 || var8 == 62) {
                    return var2;
                }
            } else if (var6 == 1) {
                if (aString2239.indexOf(var8) >= 0) {
                    var4.append(var8);
                    var9 = true;
                }

                if (var8 == 61) {
                    var6 = 2;
                    var9 = true;
                }
            } else if (var6 == 2) {
                if (var8 == 34 || var8 == 39) {
                    var6 = 3;
                    var7 = var8;
                    var5 = new StringBuffer();
                    var9 = true;
                }
            } else if (var6 == 3) {
                if (var8 != var7) {
                    if (var8 == 38) {
                        var2 = method2268(var5, var1, var2);
                    } else {
                        var5.append(var8);
                    }
                } else {
                    var6 = 0;
                    var0.method2271(var4.toString(), var5.toString());
                }

                var9 = true;
            }
        } while (var9);

        throw new Exception("Unexpected character \'" + var8 + "\' in attributes");
    }

    private static int method2268(StringBuffer var0, String var1, int var2) {
        if (var1.startsWith("&amp;", var2)) {
            var0.append('&');
            return var2 + 4;
        } else if (var1.startsWith("&lt;", var2)) {
            var0.append('<');
            return var2 + 3;
        } else if (var1.startsWith("&gt;", var2)) {
            var0.append('>');
            return var2 + 3;
        } else if (var1.startsWith("&quot;", var2)) {
            var0.append('\"');
            return var2 + 5;
        } else if (var1.startsWith("&apos;", var2)) {
            var0.append('\'');
            return var2 + 5;
        } else if (var1.startsWith("&#", var2)) {
            int var3;
            byte var4;
            if (var1.charAt(var2 + 2) == 120) {
                var3 = var2 + 3;
                var4 = 16;
            } else {
                var3 = var2 + 2;
                var4 = 10;
            }

            int var5 = var1.indexOf(59, var3);
            var0.append((char) Integer.parseInt(var1.substring(var3, var5), var4));
            return var5;
        } else {
            var0.append('&');
            return var2;
        }
    }

    private XmlUnit method2269(String var1, boolean var2) {
        if (!var2) {
            var1 = var1.trim();
            if (var1.length() == 0) {
                return this;
            }
        }

        if (this.aString2241 == null) {
            this.aString2241 = var1;
        } else {
            this.aString2241 = this.aString2241 + " " + var1;
        }

        return this;
    }

    private XmlUnit method2270(XmlUnit var1) {
        Vector var2 = this.aVector2242;
        synchronized (this.aVector2242) {
            this.aVector2242.addElement(var1);
            return this;
        }
    }

    private XmlUnit method2271(String var1, String var2) {
        if (var1.indexOf(32) >= 0) {
            return this;
        } else {
            int var3 = var2.indexOf(39);
            int var4 = var2.indexOf(34);
            if (var3 >= 0 && var4 >= 0) {
                return this;
            } else {
                Hashtable var5 = this.aHashtable2243;
                synchronized (this.aHashtable2243) {
                    this.aHashtable2243.put(var1, var2);
                    return this;
                }
            }
        }
    }

    static {
        aStringArray2244[0] = ") is different than start tag (";
        aStringArray2244[1] = "Unexpected character \'";
        aStringArray2244[2] = "]]>";
        aStringArray2244[3] = "Premature end of xml data";
        aStringArray2244[4] = "Empty end tag name";
        aStringArray2244[5] = "End tag name (";
        aStringArray2244[6] = "</";
        aStringArray2244[7] = "<![CDATA[";
        aStringArray2244[8] = "Empty tag name";
        aStringArray2244[9] = "&gt;";
        aStringArray2244[10] = "&apos;";
        aStringArray2244[11] = "&#";
        aStringArray2244[12] = "&quot;";
        aStringArray2244[13] = "&amp;";
        aStringArray2244[14] = "&lt;";
        aStringArray2244[15] = "Premature end of attribute data";
        aStringArray2244[16] = "\' in attributes";
        aStringArray2244[17] = "<?xml";
    }
}
