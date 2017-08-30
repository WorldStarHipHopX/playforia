package org.moparforia.editor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.File;

/**
 * Mainly just LEECHEDDDDDDDD da source from the client, rofl hacker plaregiser!1!!!1!11!cos2pi!!
 */
public class SpriteManager {

    JFrame frame;
    private Image[] shapes;
    public Image[] elements;
    private Image[] specials;
    private Image[] balls;
    private int[][][] pixelshapeMasks;
    private int[][][] specialPixelMasks;
    private int[][] anIntArrayArray968;

    public SpriteManager(JFrame j) {
        this.frame = j;
        this.shapes = this.parseSpriteSheet("shapes", 28, 4, 15, 15);
        this.elements = this.parseSpriteSheet("elements", 24, 4, 15, 15);
        this.specials = this.parseSpriteSheet("special", 28, 4, 15, 15);
        this.balls = this.parseSpriteSheet("balls", 8, 4, 13, 13);
        this.pixelshapeMasks = new int[28][][];
        this.specialPixelMasks = new int[28][][];
    }

    public Image[][] getSprites() {
        return new Image[][]{this.shapes,this.elements,this.specials,this.balls};
    }

    public int[] getPixelsFromTileCode(int tileCode) {
       if(tileCode == 0) {
          return null;
       } else {
          int isNoSpecial = tileCode / 16777216;
          int shapeIndex = tileCode / 65536 % 256; // Becomes the SpecialIndex if isNoSpecial==2
          int foregroundElementIndex = tileCode / 256 % 256;
          int backgroundElementIndex = tileCode % 256;
           /**
            * element index's
            * 0=grass, 1=dirt, 2=mud, 3=ice, 4=speed-n, 5=speed-ne,  6=speed-e, 7=speed-se
            * 8=speed-s, 9=speed-sw,  10=speed-w, 11=speed-nw
            * 12=water, 13=piss, 14=grass+water, 15=grass+piss, 16=block, 17=sticky-block
            * 18=bouncy-block,  19=hackblock?!? 20=solid-n, 21=solid-e 22=solid-s 23=solid-w
            *
            *
            * special index's
            * 0=blank, 1=hole, 2=hole, 3=moveable-block, 4=mine, 5=blowmine, 6=BIGmine, 7=blownmine2
            * 8=blue-T-source, 9= blue-T-destination, 10=red-T-source, 11= red-T-destination,
            * 12=yellow-T-source, 13= yellow-T-destination, 14=green-T-source, 15= green-T-destination,
            * 16=fullbricks, 17=threequarterbricks, 18=halfbricks, 19=quarterbricks,
            * 20=magnet-attract, 21=magnet-repel, 22=moveableblock?, 23= greenmoveableblock
            */

           // first check if we're combining 2 elements, then element+special.
          return isNoSpecial == 1?this.combineElementAndElement(shapeIndex, foregroundElementIndex, backgroundElementIndex):(isNoSpecial == 2?this.combineElementAndSpecial(shapeIndex, foregroundElementIndex):null);
       }
    }

    private int[] combineElementAndElement(int shapeMaskIndex, int firstElementIndex, int secondElementIndex) {
       int[][] shapeMask = this.getShapePixelMask(shapeMaskIndex);
       int[] foregroundElement = getPixels(this.elements[firstElementIndex], 15, 15);
       int[] backgroundElement = getPixels(this.elements[secondElementIndex], 15, 15);
       return this.combineShapeAndTwoElements(shapeMask, foregroundElement, backgroundElement);
    }

    private int[] combineElementAndSpecial(int specialIndex, int backgroundIndex) {
       int[][] specialMask = this.getSpecialPixels(specialIndex);
       int[] backgroundElement = getPixels(this.elements[backgroundIndex], 15, 15);
       int[] specialPixels = getPixels(this.specials[specialIndex], 15, 15);
       return this.combineShapeAndTwoElements(specialMask, backgroundElement, specialPixels);
    }

    /**
     * Creates a pixel mask, 1=white, 2=black as shown
     * @param pixelMaskIndex Index of the Shape
     * @return 2d array of 1's and 2's representing the pixel mask
     */
   private int[][] getShapePixelMask(int pixelMaskIndex) {
      if(this.pixelshapeMasks[pixelMaskIndex] == null) {
         int[] var2 = getPixels(this.shapes[pixelMaskIndex], 15, 15);
         this.pixelshapeMasks[pixelMaskIndex] = this.createShapeMask(var2);
          }

      return this.pixelshapeMasks[pixelMaskIndex];
   }

    private int[][] getSpecialPixels(int specialIndex) {
       if(this.specialPixelMasks[specialIndex] == null) {
          int[] specialPixels = getPixels(this.specials[specialIndex], 15, 15);
          this.specialPixelMasks[specialIndex] = this.createShapeMask(specialPixels);
       }

       return this.specialPixelMasks[specialIndex];
    }

    private int[][] createShapeMask(int[] var1) {
       int[][] result = new int[15][15];

       for(int y = 0; y < 15; ++y) {
          for(int x = 0; x < 15; ++x) {
             int currentPixel = var1[y * 15 + x] & 16777215;
             result[x][y] = currentPixel == 13421823?1:2;
          }
       }

       return result;
    }

    private int[] combineShapeAndTwoElements(int[][] var1, int[] var2, int[] var3) {
       int[] var4 = new int[225];

       for(int var5 = 0; var5 < 15; ++var5) {
          for(int var6 = 0; var6 < 15; ++var6) {
             int var7 = 16777215;
             if(var1[var6][var5] == 1) {
                var7 = var2[var5 * 15 + var6];
             }

             if(var1[var6][var5] == 2) {
                var7 = var3[var5 * 15 + var6];
             }

             var4[var5 * 15 + var6] = var7;
          }
       }

       return var4;
    }


    public int getWidth(Image var1) {
        return var1.getWidth(frame);
    }

    public int getHeight(Image var1) {
        return var1.getHeight(frame);
    }

    public int[] getPixels(Image var1) {
        return this.getPixels(var1, 0, 0, this.getWidth(var1), this.getHeight(var1));
    }

    public int[] getPixels(Image var1, int var2, int var3) {
        return this.getPixels(var1, 0, 0, var2, var3);
    }

    public int[] getPixels(Image var1, int var2, int var3, int var4, int var5) {
        int[] var6 = new int[var4 * var5];
        PixelGrabber var7 = new PixelGrabber(var1, var2, var3, var4, var5, var6, 0, var4);

        try {
            var7.grabPixels();
        } catch (InterruptedException var9) {
            ;
        }

        return var6;
    }

    public Image getImage(String var1) {
        Image result = null;
        try {
            result = ImageIO.read(getClass().getResourceAsStream("/" + var1 + ".gif"));
        } catch (Exception e) {
         e.printStackTrace();
        }
        return result;
    }

    public Image createImage(int[] var1, int var2, int var3) {
        return this.createImage(var1, var2, var3, (Component) null);
    }

    public Image createImage(int[] imageData, int width, int heigh, Component var4) {
        if (var4 == null) {
            var4 = frame;
        }

        Image var5 = ((Component) var4).createImage(new MemoryImageSource(width, heigh, imageData, 0, width));

        /*
        while (!((Component) var4).prepareImage(var5, (ImageObserver) var4)) {
            Tools.sleep(20L);
        }
        */

        return var5;
    }


    private Image[] parseSpriteSheet(String spriteSheetName, int spriteCount, int spritesPerRow, int spriteWidth, int spriteHeight) {
        Image spriteSheet = getImage(spriteSheetName);
        int sheetWidth = getWidth(spriteSheet);
        int sheetHeight = getHeight(spriteSheet);

        int[] var9 = getPixels(spriteSheet, sheetWidth, sheetHeight);
        spriteSheet = null;
        Image[] var10 = new Image[spriteCount];

        for (int var11 = 0; var11 < spriteCount; ++var11) {
            int var12 = var11 / spritesPerRow;
            int var13 = var11 % spritesPerRow;
            int[] var14 = new int[spriteWidth * spriteHeight];

            for (int var15 = 0; var15 < spriteHeight; ++var15) {
                for (int var16 = 0; var16 < spriteWidth; ++var16) {
                    var14[var15 * spriteWidth + var16] = var9[(var12 * spriteHeight + var12 + 1 + var15) * sheetWidth + var13 * spriteWidth + var13 + 1 + var16];
                }
            }

            var10[var11] = createImage(var14, spriteWidth, spriteHeight);
        }

        return var10;
    }
}
