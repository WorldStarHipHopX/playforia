package com.playray.flashclient;

import java.io.BufferedReader;
import java.io.IOException;

class Class142 {

    private BufferedReader aBufferedReader2098;
    private StringBuffer aStringBuffer2099;
    private static final String aString2100 = "End of input stream";


    protected Class142(BufferedReader var1) {
        this.aBufferedReader2098 = var1;
        this.method2154();
    }

    protected String method2153() throws IOException {
        while (this.aBufferedReader2098.ready()) {
            int var1 = this.aBufferedReader2098.read();
            if (var1 == -1) {
                throw new IOException("End of input stream");
            }

            if (this.method2155(var1)) {
                String var2 = this.method2156(this.aStringBuffer2099.toString());
                if (var2 != null) {
                    this.method2154();
                    return var2;
                }

                this.aStringBuffer2099.setLength(0);
            } else {
                this.aStringBuffer2099.append((char) var1);
            }
        }

        return null;
    }

    private void method2154() {
        this.aStringBuffer2099 = new StringBuffer(64);
    }

    private boolean method2155(int var1) {
        return var1 == 0 || var1 == 10 || var1 == 13;
    }

    private String method2156(String var1) {
        int var2 = var1.length();
        if (var2 == 0) {
            return null;
        } else {
            do {
                if (!this.method2155(var1.charAt(0))) {
                    do {
                        if (!this.method2155(var1.charAt(var2 - 1))) {
                            return var1;
                        }

                        var1 = var1.substring(0, var2 - 1);
                        --var2;
                    } while (var2 != 0);

                    return null;
                }

                var1 = var1.substring(1);
                --var2;
            } while (var2 != 0);

            return null;
        }
    }

}
