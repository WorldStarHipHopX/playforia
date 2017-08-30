package agolf2;

import com.aapeli.client.ImageManager;

import java.awt.Image;

public class TileOverlays {

    public static final String imagenameShapes = "track_shapes";
    public static final String filenameShapes = "track_shapes.png";
    public static final String imagenameElements = "track_elements";
    public static final String filenameElements = "track_elements.png";
    public static final String imagenameObjects = "track_objects";
    public static final String filenameObjects = "track_objects.png";
    public static final String imagenameSlopes = "track_slopes";
    public static final String filenameSlopes = "track_slopes.png";
    private ImageManager imageManager;
    private int[][] pixelsShapes;// not sure if should be `` pixels '', todo refactor getTiles
    private int[][] pixelsElements;
    private int[][] pixelsObjects;
    private int[][] pixelsSlopes;
    private Image[] imagesShapes;
    private Image[] imagesElements;
    private Image[] imagesObjects;
    private Image[] imagesSlopes;


    public TileOverlays(ImageManager imageManager) {
        this.imageManager = imageManager;
    }

    public void load() {
        Object[] var1 = this.getTiles(imagenameShapes, 9, 8);
        this.pixelsShapes = (int[][]) var1[0];
        this.imagesShapes = (Image[]) var1[1];
        var1 = this.getTiles(imagenameElements, 4, 7);
        this.pixelsElements = (int[][]) var1[0];
        this.imagesElements = (Image[]) var1[1];
        var1 = this.getTiles(imagenameObjects, 9, 9);
        this.pixelsObjects = (int[][]) var1[0];
        this.imagesObjects = (Image[]) var1[1];
        var1 = this.getTiles(imagenameSlopes, 3, 3);
        this.pixelsSlopes = (int[][]) var1[0];
        this.imagesSlopes = (Image[]) var1[1];
    }

    public int[] getElement(int index) {
        return this.pixelsElements[index];
    }

    public int[] getObject(int index) {
        return this.pixelsObjects[index];
    }

    public int[] getSlope(int index) {
        return this.pixelsSlopes[index];
    }

    private Object[] getTiles(String imageName, int numHoriz, int numVert) {
        Image image = this.imageManager.getImage(imageName);
        int imageWidth = this.imageManager.getWidth(image);
        int imageHeight = this.imageManager.getHeight(image);
        int var7 = imageWidth - (numHoriz + 1);
        int var8 = imageHeight - (numVert + 1);
        int var9 = var7 / numHoriz;
        int var10 = var8 / numVert;
        int[] var11 = this.imageManager.getPixels(image, imageWidth, imageHeight);
        int var12 = numVert * numHoriz;
        int[][] var13 = new int[var12][var9 * var10];
        Image[] var14 = new Image[var12];

        for (int var15 = 0; var15 < var12; ++var15) {
            int var16 = var15 / numHoriz;
            int var17 = var15 % numHoriz;

            for (int var18 = 0; var18 < var10; ++var18) {
                for (int var19 = 0; var19 < var9; ++var19) {
                    var13[var15][var18 * var9 + var19] = var11[(var16 * var10 + var16 + 1 + var18) * imageWidth + var17 * var9 + var17 + 1 + var19];
                    System.out.println(var13[var15][var18 * var9 + var19]);
                }
            }

            var14[var15] = this.imageManager.createImage(var13[var15], var9, var10);
        }

        return new Object[]{var13, var14};
    }

}
