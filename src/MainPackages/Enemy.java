package MainPackages;

/**
 * This class makes an Enemy object that engages in combat with the Player and attempts to prevent the
 * Player from being victorious.
 * 
 * @author (Abe) 
 */
public class Enemy extends Interactable {
    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(int x, int y) {
        super(x, y, 32, 32, 10, 10, 50, new Sprite("TestSprite.png", 3, 32, 32, 64, 64, 4));
    }
}
