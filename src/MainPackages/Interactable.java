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
    private final Interactable[] collision;
    private final int h, w;
    private int x, y, spdHorz, spdVert, maxSpdHorz, maxSpdVert, accel, maxGravSpd, curGravSpd, maxJump;
    private Sprite spr;
    private boolean gravity;

    /**
     * Initializes the instance variables and adds the new Interactable to the
     * static ArrayList.
     *
     * @param nx The x position of the instance.
     * @param ny The y position of the instance.
     * @param nw The width of the hitbox.
     * @param nh The height of the hitbox.
     * @param mxSpdH The maximum horizontal speed the instance can move.
     * @param mnSpdV The maximum vertical speed the instance can move.
     * @param maxJ The maximum jump height of the instance.
     * @param s The sprite of the instance.
     */
    public Interactable(int nx, int ny, int nw, int nh, int mxSpdH, int mnSpdV, int maxJ, Sprite s) {
        collision = new Interactable[]{null, null, null, null};
        x = nx;
        y = ny;
        w = nw;
        h = nh;
        spdHorz = 0;
        spdVert = 0;
        spr = s;
        spr.startAnimation();
        gravity = false;
        accel = 0;
        maxGravSpd = 0;
        maxJump = maxJ;
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
     * Changes the object the instance is colliding with on a specific side.
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
     * Returns the collision array that has a reference to every object the
     * instance is colliding with.
     *
     * @return The array of all the Interactables the instance is colliding
     * with. In the array [0] = the top of the hitbox, [1] = the right of the
     * hitbox, [2] = the bottom of the hitbox, and [3] = the left of the hitbox.
     */
    public Interactable[] getCollision() {
        return collision;
    }

    /**
     * This returns the Interactable that is colliding with the player on a
     * specific side.
     *
     * @param side The side of the instance to check where [0] = the top of the
     * hitbox, [1] = the right of the hitbox, [2] = the bottom of the hitbox,
     * and [3] = the left of the hitbox.
     *
     * @return The Interactable colliding with the instance on the specific
     * side.
     */
    public Interactable getCollision(int side) {
        return collision[side];
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
     * Sets the properties of gravity for an instance.
     *
     * @param a This is the acceleration of gravity. A positive value means
     * gravity effects the instance more. A negative value means the move
     * upwards.
     * @param max This is the maximum speed achieved by the instance because of
     * gravity.
     * @param g This is true if gravity effects the instance.
     */
    public void setGravity(int a, int max, boolean g) {
        accel = a;
        maxGravSpd = max;
        gravity = g;
    }

    /**
     * Updates the effects of gravity on the instance.
     */
    public void updateGravity() {
        if (getCollision(2) instanceof Interactable) {
            curGravSpd = 0;
        } else {
            curGravSpd += accel;
            if (curGravSpd >= maxGravSpd) {
                curGravSpd = maxGravSpd;
            }
            move(0, -1 * curGravSpd);
        }

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
        if (Math.abs(spdHorz) >= maxSpdHorz) {
            spdHorz = maxSpdHorz;
        }
        spdHorz += cSpd;
    }

    /**
     * Changes the horizontal speed of the instance.
     *
     * @param nSpd The new speed.
     */
    public void setSpeedHorz(int nSpd) {
        spdHorz = nSpd;
        if (Math.abs(spdHorz) >= maxSpdHorz) {
            spdHorz = maxSpdHorz;
        }
    }

    /**
     * Changes the vertical speed of the instance by a value.
     *
     * @param cSpd The change in the speed.
     */
    public void changeSpeedVert(int cSpd) {
        if (Math.abs(spdVert) >= maxSpdVert) {
            spdVert = maxSpdVert;
        }
        spdVert += cSpd;
    }

    /**
     * Changes the vertical speed of the instance.
     *
     * @param nSpd The new speed.
     */
    public void setSpeedVert(int nSpd) {
        spdVert = nSpd;
        if (Math.abs(spdVert) >= maxSpdVert) {
            spdVert = maxSpdVert;
        }
    }

    public void jump() {
        changeSpeedVert(-5);
    }
}
