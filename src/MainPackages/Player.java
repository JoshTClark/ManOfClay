package MainPackages;

public class Player extends Interactable {

    public Player(int x, int y) {
        super(x, y, 32, 32, 8, 8, 50, new Sprite("Images/TestSprite.png", 3, 32, 32, 64, 64, 4));
    }

}
