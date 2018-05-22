package MainPackages;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.util.*;
import java.util.logging.*;

/**
 * This class makes a sprite object with has an image that is either a sprite or
 * a sprite sheet. It reads a sprite sheet from left to right and top to bottom.
 * It also controls animating that sprite using a timer with the speed given in
 * the parameter of the constructor.
 *
 * @author Josh Clark
 */
public class Sprite {

    private BufferedImage sprite;
    private final ArrayList<BufferedImage> spriteSheet;
    private BufferedImage curImage;
    private int curImgNum;
    private final boolean isSpriteSheet;
    private int speed;
    private Thread anim;
    private int scale;

    /**
     * This is the constructor used for a non-animated sprite.
     *
     * This first assigns all the variables values (the variables not being used
     * are assigned null, false, or 0). Then it looks for the file specified in
     * path and assigns it to the sprite variable. Next if the scale does not
     * equal 1 it resizes the image to the correct scale. It then assigns
     * curImage the sprite.
     *
     * @param path The path name of the image.
     * @param scl The scale of the image.
     * @param width The width of the image.
     * @param height The height of the image.
     */
    public Sprite(String path, int scl, int width, int height) {
        // Initializing all the instance variables
        scale = scl;
        speed = 0;
        isSpriteSheet = false;
        spriteSheet = null;
        anim = null;
        curImgNum = 0;
        try {
            sprite = ImageIO.read(new File(path));
        } catch (IOException ex) {
            Logger.getLogger(Sprite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (scale != 1) {
            BufferedImage resized = new BufferedImage(width * scale, height * scale, sprite.getType());
            Graphics2D g = resized.createGraphics();
            g.drawImage(sprite, 0, 0, width * scale, height * scale, 0, 0, sprite.getWidth(), sprite.getHeight(), null);
            g.dispose();
            sprite = resized;
        }
        curImage = sprite;
    }

    /**
     * This is the constructor used for an animated sprite.
     *
     * This first assigns all the variables values. Then it looks for the file
     * specified in path and assigns it to the sprite variable. Next it adds
     * each sprite in the sprite sheet to the spriteSheet array list. Lastly it
     * assigns the first image of the sprite sheet to the curImage
     *
     * @param path The path name of the image.
     * @param scl The scale of the image.
     * @param sprWidth The width of a single sprite.
     * @param sprHeight The height of a single sprite.
     * @param width The width of the image.
     * @param height The height of the image.
     * @param spd The target frames per second.
     */
    public Sprite(String path, int scl, int sprWidth, int sprHeight, int width, int height, int spd) {
        // Initializing all the instance variables
        scale = scl;
        speed = (int) (1000 / spd);
        isSpriteSheet = true;
        spriteSheet = new ArrayList<>();
        anim = new Thread(new AnimThread());
        curImgNum = 0;
        try {
            sprite = ImageIO.read(new File(path));
        } catch (IOException ex) {
            Logger.getLogger(Sprite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (scale != 1) {
            BufferedImage resized = new BufferedImage(width * scale, height * scale, sprite.getType());
            Graphics2D g = resized.createGraphics();
            g.drawImage(sprite, 0, 0, width * scale, height * scale, 0, 0, sprite.getWidth(), sprite.getHeight(), null);
            g.dispose();
            sprite = resized;
            sprWidth *= scale;
            sprHeight *= scale;
            width *= scale;
            height *= scale;
        }

        // This goes through the entire sprite sheet and makes a new image out of every sprite on it
        for (int i = 0; i < (height / sprHeight); i++) {
            for (int k = 0; k < (width / sprWidth); k++) {
                spriteSheet.add(sprite.getSubimage(k * sprWidth, i * sprHeight, sprWidth, sprHeight));
            }
        }
        curImage = spriteSheet.get(0);
    }

    // Sets the speed of the animation
    public void setSpeed(int s) {
        if (isSpriteSheet) {
            speed = (int) (1000 / s);
        }
    }

    // Starts animating the sprite
    public void startAnimation() {
        if (isSpriteSheet) {
            anim.start();
        }
    }

    // Stops animating the sprite
    public void stopAnimation() {
        if (isSpriteSheet) {
            anim.interrupt();
        }
    }

    // Returns the curent sprite
    public BufferedImage getImage() {
        return curImage;
    }

    private class AnimThread extends Thread {

        @Override
        public void run() {
            while (true) {
                curImgNum++;
                if (curImgNum >= spriteSheet.size()) {
                    curImgNum = 0;
                }
                curImage = spriteSheet.get(curImgNum);
                try {
                    sleep(speed);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sprite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }

}
