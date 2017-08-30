package com.aapeli.tools;

import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

public class XmlUnit {

    private static final String aString1735 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
    private static final String aString1736 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-:";
    private String name;
    private String value;
    private Vector children;
    private Hashtable attributes;


    private XmlUnit(String var1) {
        this.name = var1;
        this.value = null;
        this.children = new Vector();
        this.attributes = new Hashtable();
    }

    public static XmlUnit parseString(String declarationTag, boolean var1, boolean var2) throws Exception {
        declarationTag = declarationTag.trim();
        if (declarationTag.startsWith("<?xml")) {
            declarationTag = declarationTag.substring(declarationTag.indexOf('>') + 1).trim();
        }

        return method1876(declarationTag, var2);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public XmlUnit getChild(String name) {
        synchronized (this.children) {
            int childrenCount = this.children.size();

            for (int index = 0; index < childrenCount; ++index) {
                XmlUnit child = (XmlUnit) this.children.elementAt(index);
                if (child.getName().equals(name)) {
                    return child;
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
        synchronized (this.children) {
            int childrenCount = this.children.size();
            XmlUnit[] childrenArray = new XmlUnit[childrenCount];

            for (int index = 0; index < childrenCount; ++index) {
                childrenArray[index] = (XmlUnit) this.children.elementAt(index);
            }

            return childrenArray;
        }
    }

    public XmlUnit[] getChildren(String name) {
        XmlUnit[] children = this.getChildren();
        int childrenCount = children.length;
        int var4 = 0;

        for (int index = 0; index < childrenCount; ++index) {
            if (children[index].getName().equals(name)) {
                ++var4;
            }
        }

        XmlUnit[] childrenArray = new XmlUnit[var4];
        int var6 = 0;

        for (int index = 0; index < childrenCount; ++index) {
            if (children[index].getName().equals(name)) {
                childrenArray[var6] = children[index];
                ++var6;
            }
        }

        return childrenArray;
    }

    public String getAttribute(String var1) {
        synchronized (this.attributes) {
            return (String) this.attributes.get(var1);
        }
    }

    private static XmlUnit method1876(String var0, boolean var1) throws Exception {
        Stack var2 = new Stack();
        StringBuffer tagEnd = null;
        StringBuffer var4 = null;
        XmlUnit tagStart = null;
        byte var7 = 0;
        int var8 = var0.length();

        for (int var12 = 0; var12 < var8; ++var12) {
            char var9 = var0.charAt(var12);
            boolean var11 = false;
            boolean var10 = false;
            if (var7 == 0) {
                if (var9 <= ' ') {
                    var10 = true;
                } else if (var9 == '<') {
                    var7 = 1;
                    tagEnd = new StringBuffer();
                    var10 = true;
                }
            } else if (var7 == 1) {
                if (aString1735.indexOf(var9) >= 0) {
                    tagEnd.append(var9);
                    var10 = true;
                } else if (var9 == '>' || var9 == '/' || var9 <= ' ') {
                    if (tagEnd.length() == 0) {
                        throw new Exception("Empty tag name");
                    }

                    tagStart = new XmlUnit(tagEnd.toString());
                    if (var9 <= ' ') {
                        var12 = method1877(tagStart, var0, var12, var8);
                        var9 = var0.charAt(var12);
                    }

                    if (var9 == '>') {
                        var7 = 2;
                        var4 = new StringBuffer();
                    } else {
                        var7 = 6;
                    }

                    var10 = true;
                }
            } else if (var7 == 2) {
                if (var9 == '<') {
                    if (var0.startsWith("<![CDATA[", var12)) {
                        var7 = 3;
                        var12 += 8;
                    } else {
                        if (var4.length() > 0 || var1) {
                            tagStart.appendValue(var4.toString(), var1);
                        }

                        if (var0.startsWith("</", var12)) {
                            var7 = 4;
                            ++var12;
                            tagEnd = new StringBuffer();
                        } else {
                            var2.push(tagStart);
                            var7 = 1;
                            tagEnd = new StringBuffer();
                        }
                    }
                } else if (var9 == '&') {
                    var12 = method1878(var4, var0, var12);
                } else {
                    var4.append(var9);
                }

                var10 = true;
            } else if (var7 == 3) {
                if (var9 == ']') {
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
                if (aString1735.indexOf(var9) >= 0) {
                    tagEnd.append(var9);
                    var10 = true;
                } else if (var9 == '>') {
                    if (tagEnd.length() == 0) {
                        throw new Exception("Empty end tag name");
                    }

                    if (!tagStart.getName().equals(tagEnd.toString())) {
                        throw new Exception("End tag name (" + tagEnd + ") is different than start tag (" + tagStart.getName() + ")");
                    }

                    var11 = true;
                    var10 = true;
                }
            } else if (var7 == 5) {
                if (var9 <= ' ') {
                    var10 = true;
                }
            } else if (var7 == 6 && var9 == '>') {
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
                    var6.addChild(tagStart);
                    tagStart = var6;
                    var7 = 2;
                    var4 = new StringBuffer();
                }
            }
        }

        if (var7 != 5) {
            throw new Exception("Premature end of xml data");
        } else {
            return tagStart;
        }
    }

    private static int method1877(XmlUnit var0, String var1, int var2, int var3) throws Exception {
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
                if (aString1736.indexOf(var8) >= 0) {
                    var6 = 1;
                    var4 = new StringBuffer();
                    var4.append(var8);
                    var9 = true;
                } else if (var8 == ' ') {
                    var9 = true;
                } else if (var8 == '/' || var8 == '>') {
                    return var2;
                }
            } else if (var6 == 1) {
                if (aString1736.indexOf(var8) >= 0) {
                    var4.append(var8);
                    var9 = true;
                }

                if (var8 == '=') {
                    var6 = 2;
                    var9 = true;
                }
            } else if (var6 == 2) {
                if (var8 == '"' || var8 == '\'') {
                    var6 = 3;
                    var7 = var8;
                    var5 = new StringBuffer();
                    var9 = true;
                }
            } else if (var6 == 3) {
                if (var8 != var7) {
                    if (var8 == '&') {
                        var2 = method1878(var5, var1, var2);
                    } else {
                        var5.append(var8);
                    }
                } else {
                    var6 = 0;
                    var0.addAttribute(var4.toString(), var5.toString());
                }

                var9 = true;
            }
        } while (var9);

        throw new Exception("Unexpected character \'" + var8 + "\' in attributes");
    }

    private static int method1878(StringBuffer var0, String var1, int var2) {
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
            if (var1.charAt(var2 + 2) == 'x') {
                var3 = var2 + 3;
                var4 = 16;
            } else {
                var3 = var2 + 2;
                var4 = 10;
            }

            int var5 = var1.indexOf(';', var3);
            var0.append((char) Integer.parseInt(var1.substring(var3, var5), var4));
            return var5;
        } else {
            var0.append('&');
            return var2;
        }
    }

    private XmlUnit appendValue(String value, boolean dontTrim) {
        if (!dontTrim) {
            value = value.trim();
            if (value.length() == 0) {
                return this;
            }
        }

        if (this.value == null) {
            this.value = value;
        } else {
            this.value = this.value + " " + value;
        }

        return this;
    }

    private XmlUnit addChild(XmlUnit var1) {
        synchronized (this.children) {
            this.children.addElement(var1);
            return this;
        }
    }

    private XmlUnit addAttribute(String key, String value) {
        if (key.indexOf(' ') >= 0) {
            return this;
        } else {
            int var3 = value.indexOf('\'');
            int var4 = value.indexOf('"');
            if (var3 >= 0 && var4 >= 0) {
                return this;
            } else {
                synchronized (this.attributes) {
                    this.attributes.put(key, value);
                    return this;
                }
            }
        }
    }
}
