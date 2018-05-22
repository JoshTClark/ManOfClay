package MainPackages;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class will mainly be used as a superclass. Classes that extend it will
 * function together with collision and taking and dealing damage.
 */
public class Interactable {

    private static ArrayList<Interactable> allInteracts;
    /**
     * Index 0 = top of hitbox, Index 1 = right of hitbox, Index 2 = bottom of
     * hitbox, index 3 = left of hitbox
     */
    private Interactable[] collision;
    int x, y, h, w;

    /**
     * Initializes the instance variables and adds the new Interactable to the
     * static ArrayList.
     *
     * @param nx The x position of the Interactable.
     * @param ny The y position of the Interactable.
     * @param nw The width of the hitbox.
     * @param nh The height of the hitbox.
     */
    public Interactable(int nx, int ny, int nw, int nh) {
        collision = new Interactable[]{null, null, null, null};
        allInteracts.add(this);
        x = nx;
        y = ny;
        w = nw;
        h = nh;
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

}
