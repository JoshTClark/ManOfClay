package MainPackages;

import java.awt.Graphics;

/**
 * This class will mainly be used as a superclass. Classes that extend it will
 * function together with collision and taking and dealing damage.
 */
public class Interactable {

    private final int h, w;
    private int x, y, spdHorz, spdVert, jumpSpeed, currentJumpSpd, fallSpeed, currentFallSpd;
    private Sprite spr;

    /**
     * Initializes the instance variables and adds the new Interactable to the
     * static ArrayList.
     *
     * @param nx The x position of the instance.
     * @param ny The y position of the instance.
     * @param nw The width of the hitbox.
     * @param nh The height of the hitbox.
     * @param jumpS The max speed at which the instance jumps.
     * @param fallS The max speed at which the instance falls.
     * @param s The sprite of the instance.
     */
    public Interactable(int nx, int ny, int nw, int nh, int jumpS, int fallS, Sprite s) {
        x = nx;
        y = ny;
        w = nw;
        h = nh;
        spdHorz = 0;
        spdVert = 0;
        spr = s;
        jumpSpeed = jumpS;
        currentJumpSpd = jumpSpeed;
        fallSpeed = fallS;
        currentFallSpd = 0;
        spr.startAnimation();
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

    public void jump() {
        move(0, currentJumpSpd);
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

    public void setSpeed(int horz, int vert) {
        spdHorz = horz;
        spdVert = vert;
    }

    public void adjustSpeed(int horz, int vert) {
        spdHorz += horz;
        spdVert += vert;
    }

    public int getSpeedHorz() {
        return spdHorz;
    }

    public int getSpeedVert() {
        return spdVert;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return w * spr.getScale();
    }

    public int getHeight() {
        return h * spr.getScale();
    }
}
