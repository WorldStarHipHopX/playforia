package agolf2;

import agolf2.Class55;
import agolf2.Class58_Sub1;

import java.util.StringTokenizer;

class Class53 {

    private String aString1152;
    private Class55[] aClass55Array1153;


    protected Class53(Class58_Sub1 var1, String var2, String var3) {
        this.aString1152 = var2;
        StringTokenizer var4 = new StringTokenizer(var3, ";");
        this.aClass55Array1153 = new Class55[4];

        for (int var5 = 0; var5 < 4; ++var5) {
            this.aClass55Array1153[var5] = new Class55(var1, var4);
        }

    }

    protected String method1413() {
        return this.aString1152;
    }

    protected Class55 method1414(int var1) {
        return this.aClass55Array1153[var1];
    }
}
