package com.playray.connection;

import com.playray.connection.ConnListener;
import com.playray.connection.Connection;
import com.playray.tools.Tools;

import java.util.Vector;

class Class132 implements Runnable {

    private Connection aConnection2029;
    private ConnListener aConnListener2030;
    private Vector aVector2031;
    private boolean aBoolean2032;
    private Thread aThread2033;


    protected Class132(Connection var1, ConnListener var2) {
        this.aConnection2029 = var1;
        this.aConnListener2030 = var2;
        this.aVector2031 = new Vector();
        this.aBoolean2032 = true;
        this.aThread2033 = new Thread(this);
        this.aThread2033.start();
    }

    public void run() {
        while (true) {
            try {
                Tools.sleep(50L);

                String var1;
                while ((var1 = this.method2093()) != null) {
                    this.aConnListener2030.dataReceived(var1);
                }

                if (this.aBoolean2032) {
                    continue;
                }
            } catch (Exception var2) {
                this.aBoolean2032 = false;
                this.aConnection2029.method2106();
            }

            return;
        }
    }

    protected synchronized void method2091(String var1) {
        this.aVector2031.addElement(var1);
    }

    protected void method2092() {
        this.aBoolean2032 = false;
    }

    private synchronized String method2093() {
        if (!this.aVector2031.isEmpty() && this.aBoolean2032) {
            String var1 = (String) ((String) this.aVector2031.elementAt(0));
            this.aVector2031.removeElementAt(0);
            return var1;
        } else {
            return null;
        }
    }
}
