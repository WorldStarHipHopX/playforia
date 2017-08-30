package agolf2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

class Class54 {

    private Image anImage1154;
    private Graphics aGraphics1155;
    private Graphics aGraphics1156;
    private int anInt1157;
    private int anInt1158;
    private int anInt1159;
    private int anInt1160;


    protected Class54(Canvas_Sub6_Sub2 var1) {
        this.anImage1154 = var1.createImage(780, 420);
        this.aGraphics1155 = this.anImage1154.getGraphics();
        this.aGraphics1156 = var1.getGraphics();
    }

    protected Graphics method1415() {
        return this.aGraphics1155;
    }

    protected void method1416() {
        this.anInt1157 = Integer.MAX_VALUE;
        this.anInt1158 = Integer.MAX_VALUE;
        this.anInt1159 = Integer.MIN_VALUE;
        this.anInt1160 = Integer.MIN_VALUE;
    }

    protected void method1417(int var1, int var2, int var3, int var4) {
        if (var1 < this.anInt1157) {
            this.anInt1157 = var1;
        }

        if (var3 > this.anInt1159) {
            this.anInt1159 = var3;
        }

        if (var2 < this.anInt1158) {
            this.anInt1158 = var2;
        }

        if (var4 > this.anInt1160) {
            this.anInt1160 = var4;
        }

    }

    protected void method1418() {
        if (this.anInt1157 < 0) {
            this.anInt1157 = 0;
        }

        if (this.anInt1158 < 0) {
            this.anInt1158 = 0;
        }

        if (this.anInt1159 >= 780) {
            this.anInt1159 = 779;
        }

        if (this.anInt1160 >= 420) {
            this.anInt1160 = 419;
        }

        this.aGraphics1156.drawImage(this.anImage1154, this.anInt1157, this.anInt1158, this.anInt1159, this.anInt1160, this.anInt1157, this.anInt1158, this.anInt1159, this.anInt1160, (ImageObserver) null);
    }
}
