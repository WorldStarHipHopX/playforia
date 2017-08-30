package agolf2;

import java.awt.Image;

public class TrackBallOverlays extends TrackTileOverlays {

    private boolean imagesLoaded = false;
    private Image[] imagesBallsNormal;
    private Image[] imagesBallsBig;
    private Image[] imagesBallsSmall;
    private Image[][] imagesBalls = new Image[6][];


    protected TrackBallOverlays(Class58 var1) {
        super(var1);
    }

    public Image[] getImagesBalls(int index) {//todo ???????
        if (!this.imagesLoaded) {
            this.imagesBallsNormal = this.aClass58_3549.imageManager.separateImages("game_balls_normal", 6);
            this.imagesBallsBig = this.aClass58_3549.imageManager.separateImages("game_balls_big", 6);
            this.imagesBallsSmall = this.aClass58_3549.imageManager.separateImages("game_balls_small", 6);
            this.imagesLoaded = true;
        }

        if (this.imagesBalls[index] == null) {
            this.imagesBalls[index] = new Image[3];
            this.imagesBalls[index][0] = this.imagesBallsNormal[index];
            this.imagesBalls[index][1] = this.imagesBallsBig[index];
            this.imagesBalls[index][2] = this.imagesBallsSmall[index];
        }

        return this.imagesBalls[index];
    }
}
