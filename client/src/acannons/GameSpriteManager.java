package acannons;

import com.playray.client.ImageManager;

import java.awt.Image;

public class GameSpriteManager {

    private ImageManager imageManager;
    protected Image[] imagesObjects;
    protected int[] widthsObjects;
    protected int[] heightsObjects;
    protected boolean[][][] aBooleanArrayArrayArray858;
    protected Image imageCannon;
    protected Image imageOwnCannon;
    protected Image[] imagesNapalm;
    protected Image[] imagesSS20Up;
    protected Image imageSS20Down;
    protected Image imageCloudPoison;
    protected Image imageCloudFallout;
    protected Image[] imageAds;

    public GameSpriteManager(ImageManager imageManager) {
        this.imageManager = imageManager;
        this.method1048();
        this.loadCannons();
        this.loadAmmo();
        this.loadClouds();
        this.loadAds();
    }

    private void method1048() {
        this.imagesObjects = new Image[6];
        this.widthsObjects = new int[6];
        this.heightsObjects = new int[6];
        this.aBooleanArrayArrayArray858 = new boolean[6][][];

        for (int var1 = 0; var1 < 6; ++var1) {
            this.imagesObjects[var1] = this.imageManager.method1983("object-" + var1);
            this.widthsObjects[var1] = this.imageManager.getWidth(this.imagesObjects[var1]);
            this.heightsObjects[var1] = this.imageManager.getHeight(this.imagesObjects[var1]);
            this.aBooleanArrayArrayArray858[var1] = new boolean[this.widthsObjects[var1]][this.heightsObjects[var1]];
            int[] imagePixels = this.imageManager.getPixels(this.imagesObjects[var1], this.widthsObjects[var1], this.heightsObjects[var1]);

            for (int var3 = 0; var3 < this.heightsObjects[var1]; ++var3) {
                for (int var4 = 0; var4 < this.widthsObjects[var1]; ++var4) {
                    this.aBooleanArrayArrayArray858[var1][var4][var3] = (imagePixels[var3 * this.widthsObjects[var1] + var4] & -0x1000000) != 0;
                }
            }
        }

    }

    private void loadCannons() {
        this.imageCannon = this.imageManager.method1983("cannon");
        this.imageOwnCannon = this.imageManager.method1983("cannon_own");
    }

    private void loadAmmo() {
        this.imageSS20Down = this.imageManager.method1983("ammo-ss20-down");
        this.imagesNapalm = this.imageManager.separateImages("ammo-napalm", 3);
        this.imagesSS20Up = this.imageManager.separateImages("ammo-ss20-up", 3);
    }

    private void loadClouds() {
        this.imageCloudPoison = this.imageManager.method1983("cloud-poisongas");
        this.imageCloudFallout = this.imageManager.method1983("cloud-fallout");
        this.imageCloudPoison = this.imageManager.setTransparency(this.imageCloudPoison, 0.5D);
        this.imageCloudFallout = this.imageManager.setTransparency(this.imageCloudFallout, 0.5D);
    }

    private void loadAds() {
        this.imageAds = new Image[2];
        this.imageAds[0] = this.imageManager.method1983("floating-ad-left");
        this.imageAds[1] = this.imageManager.method1983("floating-ad-right");
    }
}
