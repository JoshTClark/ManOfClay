package MainPackages;

public class Player  extends Interactable {

    public Player(int x, int y){
        super(x, y, 32, 32, new Sprite("Images/TestSprite.png", 2, 32, 32, 64, 64, 4));
    }

}
