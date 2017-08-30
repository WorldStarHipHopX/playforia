package agolf2;

import com.aapeli.applet.AApplet;
import com.aapeli.connection.ConnListener;
import com.aapeli.connection.Connection;
import com.aapeli.tools.Tools;

public abstract class ServerConnection implements ConnListener {

    private Class58 aClass58_2375;
    protected Connection aConnection2376;
    private String aString2377;
    private String aString2378;


    protected ServerConnection(Class58 var1) {
        this.aClass58_2375 = var1;
        this.aString2377 = this.aString2378 = null;
    }

    public void dataReceived(String var1) {
        long var2 = System.currentTimeMillis();

        try {
            this.method1182(var1);
            this.aString2378 = var2 + ": " + var1;
        } catch (Exception var7) {
            Exception var4 = var7;
            if (this.aClass58_2375.gameApplet.isDebug()) {
                System.out.println("ServerConnection.run(): e=\"" + var7 + "\"");
                var7.printStackTrace();
            }

            try {
                this.method1179("error-debug\t" + this.aClass58_2375.gameApplet.method53() + "\t" + this.method1183(var4) + "\t" + var2 + ": " + var1.replace('\t', '\\') + "\t" + this.aString2378.replace('\t', '\\') + "\t" + this.aString2377.replace('\t', '\\'));
            } catch (Exception var6) {
                ;
            }

            this.aClass58_2375.gameApplet.setEndState(var7);
            this.aConnection2376.closeConnection();
        }

    }

    public void connectionLost(int var1) {
        if (var1 != 2 && var1 != 3) {
            if (var1 == 4) {
                this.aClass58_2375.gameApplet.setEndState(AApplet.END_ERROR_VERSION);
            }
        } else {
            this.aClass58_2375.gameApplet.setEndState(AApplet.END_ERROR_CONNECTION);
        }

    }

    public void notifyConnectionDown() {
    }

    public void notifyConnectionUp() {
    }

    protected boolean method1177(String[] var1) {
        this.aConnection2376 = new Connection(this.aClass58_2375.gameApplet, this, var1);
        return this.aConnection2376.openConnection();
    }

    protected void method1178(int var1) {
        this.aClass58_2375.gameApplet.method54(0);
        this.method1179("version\t" + var1);
    }

    public void method1179(String var1) {
        if (this.aClass58_2375.gameApplet.isDebug()) {
            System.out.println("C -> " + var1);
        }

        this.aString2377 = System.currentTimeMillis() + ": " + var1;
        this.aConnection2376.writeData(var1);
    }

    public void method1180() {
        if (this.aConnection2376 != null) {
            this.aConnection2376.closeConnection();
        }

    }

    protected abstract void method1181(String[] var1, String var2) throws Exception;

    private void method1182(String var1) throws Exception {
        if (this.aClass58_2375.gameApplet.isDebug()) {
            System.out.println("C <- " + var1);
        }

        String[] var2 = Tools.separateString(var1, "\t");
        this.method1181(var2, var1);
    }

    private String method1183(Exception var1) {
        String var2 = var1.toString().trim();
        StackTraceElement[] var3 = var1.getStackTrace();

        for (int var4 = 0; var4 < var3.length; ++var4) {
            var2 = var2 + "\\" + var3[var4].toString().trim();
        }

        return var2;
    }
}
