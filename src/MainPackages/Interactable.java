package MainPackages;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * This class will mainly be used as a superclass. Classes that extend it will
 * function together with collision and taking and dealing damage.
 */
public class Interactable {

    private static ArrayList<Interactable> allInteracts;
    /**
     * [0] = top of hitbox.
     *
     * [1] = right of hitbox.
     *
     * [2] = bottom of hitbox.
     *
     * [3] = left of hitbox.
     */
    private Interactable[] collision;
    private int x, y, h, w, spdHorz, spdVert;
    private Sprite spr;

    /**
     * Initializes the instance variables and adds the new Interactable to the
     * static ArrayList.
     *
     * @param nx The x position of the Interactable.
     * @param ny The y position of the Interactable.
     * @param nw The width of the hitbox.
     * @param nh The height of the hitbox.
     * @param s The sprite of the Interactable.
     */
    public Interactable(int nx, int ny, int nw, int nh, Sprite s) {
        collision = new Interactable[]{null, null, null, null};
        allInteracts.add(this);
        x = nx;
        y = ny;
        w = nw;
        h = nh;
        spdHorz = 0;
        spdVert = 0;
        spr = s;
        spr.startAnimation();
    }

    /**
     * Returns the collision variable.
     *
     * @return An array of all the Interactables the instance is colliding with.
     */
    public Interactable[] checkCollision() {
        return collision;
    }

    /**
     *
     * @param i The Interactable the instance is colliding with.
     * @param side The numerical side of the instance (as described above the
     * collision variable) that the Interactable is colliding with.
     */
    public void changeCollision(Interactable i, int side) {
        collision[side] = i;
    }

    public static void updateCollision() {
        for (int i = 0; i < allInteracts.size(); i++) {
            for (int k = i; k < allInteracts.size(); k++) {
            }
        }
    }

    /**
     * Changes the sprite of the instance.
     * 
     * @param s The new sprite.
     */
    public void setSprite(Sprite s) {
        spr.stopAnimation();
        spr = s;
        spr.startAnimation();
    }

    /**
     * Draws the sprite.
     *
     * @param g Graphics object to draw stuff with.
     */
    public void draw(Graphics g) {
        g.drawImage(spr.getImage(), x, y, null);
    }

    /**
     * Moves the instance to a new location.
     *
     * @param nx The new x value.
     * @param ny the new y value.
     */
    public void relocate(int nx, int ny) {
        x = nx;
        y = ny;
    }

    /**
     * Moves the instance a certain amount of pixel dependent on it's speed.
     */
    public void move() {
        x += spdHorz;
        y += spdVert;
    }

    /**
     * Moves the instance a certain amount of pixels.
     *
     * @param cx
     * @param cy
     */
    public void move(int cx, int cy) {
        x += cx;
        y += cy;
    }

    /**
     * Changes the horizontal speed of the instance by a value.
     *
     * @param cSpd The change in the speed.
     */
    public void changeSpeedHorz(int cSpd) {
        spdHorz += cSpd;
    }

    /**
     * Changes the horizontal speed of the instance.
     *
     * @param nSpd The new speed.
     */
    public void setSpeedHorz(int nSpd) {
        spdHorz = nSpd;
    }

    /**
     * Changes the vertical speed of the instance by a value.
     *
     * @param cSpd The change in the speed.
     */
    public void changeSpeedVert(int cSpd) {
        spdVert += cSpd;
    }

    /**
     * Changes the vertical speed of the instance.
     *
     * @param nSpd The new speed.
     */
    public void setSpeedVert(int nSpd) {
        spdVert = nSpd;
    }
}
