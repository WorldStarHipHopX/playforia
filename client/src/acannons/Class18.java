package acannons;

import com.playray.tools.Tools;

class Class18 implements Runnable {

    private boolean aBoolean918;
    private final Gamesomething aGamesomething_919;


    protected Class18(Gamesomething var1) {
        this.aGamesomething_919 = var1;
        this.aBoolean918 = true;
    }

    public void run() {
        short var1 = 466;

        for (int var2 = 0; var2 < 15; ++var2) {
            Tools.sleep((long) var1);
            if (!this.aBoolean918) {
                var2 = 15;
            }

            if (var2 < 14) {
                this.aGamesomething_919.method1094();
            }
        }

        if (this.aBoolean918) {
            this.aGamesomething_919.method1095();
        }

    }

    protected void method1096() {
        this.aBoolean918 = false;
    }
}
