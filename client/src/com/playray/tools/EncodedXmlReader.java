package com.playray.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.net.URL;
import java.util.LinkedList;

public class EncodedXmlReader {

    private static final String defaultEncoding = "UTF-8";
    private String fileUrl;
    private boolean debug;


    public EncodedXmlReader(String fileUrl) {
        this(fileUrl, false);
    }

    public EncodedXmlReader(String fileUrl, boolean debug) {
        this.fileUrl = fileUrl;
        this.debug = debug;
    }

    public XmlUnit readXmlUnit(LinkedList var1) {
        try {
            var1.addLast("EXR.readXmlUnit(...) started");
            String var2 = this.method2261(var1);
            var1.addLast("EXR.readXmlUnit(...) content" + (var2 != null ? "!=" : "=") + "null");
            return XmlUnit.parseString(var2, true, true);
        } catch (Exception var3) {
            if (this.debug) {
                System.out.println("EncodedXmlReader.readXmlUnit(): Failed to read or parse xml-file \"" + this.fileUrl + "\"");
                var3.printStackTrace();
            }

            return null;
        }
    }

    private String method2261(LinkedList var1) throws Exception {
        String encoding = defaultEncoding;
        URL var3 = new URL(this.fileUrl);
        var1.addLast("EXR.readContent(...) url=\'" + var3 + "\'");
        InputStream var4 = var3.openStream();
        var1.addLast("EXR.readContent(...) input=" + var4);
        PushbackInputStream var5 = new PushbackInputStream(var4, 3);
        var1.addLast("EXR.readContent(...) pushback=" + var5);
        int var6 = var5.read();
        int var7 = var5.read();
        int var8 = var5.read();
        var1.addLast("EXR.readContent(...) 1=" + var6 + " 2=" + var7 + " 3=" + var8);
        if (var6 == 239 && var7 == 187 && var8 == 191) {
            var1.addLast("EXR.readContent(...) BOM read");
            encoding = defaultEncoding;
        } else {
            var1.addLast("EXR.readContent(...) No BOM read");
            var5.unread(var8);
            var5.unread(var7);
            var5.unread(var6);
        }

        this.method2262(var5);
        var6 = var5.read();
        var7 = var5.read();
        if (var6 == 60 && var7 == 63) {
            String var9 = this.method2263(var5);
            if (var9 != null) {
                encoding = var9;
            }

            this.method2262(var5);
        } else {
            var5.unread(var7);
            var5.unread(var6);
        }

        InputStreamReader in = new InputStreamReader(var5, encoding);
        var1.addLast("EXR.readContent(...) reader=" + in);
        String var10 = this.method2264(in, var1);
        in.close();
        return var10;
    }

    private void method2262(PushbackInputStream var1) throws Exception {
        int var2;
        do {
            var2 = var1.read();
            if (var2 == -1) {
                throw new Exception("End of stream when reading out XML white spaces");
            }
        } while (var2 <= 32);

        var1.unread(var2);
    }

    private String method2263(PushbackInputStream var1) throws Exception {
        StringBuffer var2 = new StringBuffer(50);

        while (true) {
            int var3 = var1.read();
            if (var3 == -1) {
                throw new Exception("End of stream before XML header was finished");
            }

            if (var3 == 62) {
                String var4 = var2.toString();
                int var5 = var4.toLowerCase().indexOf("encoding=");
                if (var5 == -1) {
                    return null;
                }

                int var6 = var5 + 9;
                char var7 = var4.charAt(var6);
                int var8 = var4.indexOf(var7, var6 + 1);
                if (var8 == -1) {
                    return null;
                }

                return var4.substring(var6 + 1, var8);
            }

            var2.append((char) var3);
        }
    }

    private String method2264(InputStreamReader var1, LinkedList var2) throws IOException {
        BufferedReader var3 = new BufferedReader(var1);
        var2.addLast("EXR.readContent(...,...) input=" + var3);

        StringBuffer var4;
        String var5;
        for (var4 = new StringBuffer(4096); (var5 = var3.readLine()) != null; var4.append(var5)) {
            if (var4.length() == 0) {
                var2.addLast("EXR.readContent(...,...) Read first line, line=\'" + var5 + "\'");
            }
        }

        return var4.toString();
    }
}
