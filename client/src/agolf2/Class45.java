package agolf2;

import com.aapeli.tools.Tools;

class Class45 implements Runnable {

    private IPanel_Sub28_Sub1 anIPanel_Sub28_Sub1_1109;
    private boolean aBoolean1110;


    protected Class45(IPanel_Sub28_Sub1 var1) {
        this.anIPanel_Sub28_Sub1_1109 = var1;
        this.aBoolean1110 = true;
        Thread var2 = new Thread(this);
        var2.setDaemon(true);
        var2.start();
    }

    public void run() {
        long var1 = System.currentTimeMillis();
        long var3 = var1 + 1000L;

        do {
            do {
                Tools.sleep(50L);
            } while (this.aBoolean1110 && System.currentTimeMillis() < var3);

            var3 += 1000L;
            if (this.aBoolean1110) {
                this.anIPanel_Sub28_Sub1_1109.method703();
            }
        } while (this.aBoolean1110);

    }

    protected void method1347() {
        this.aBoolean1110 = false;
    }
}
