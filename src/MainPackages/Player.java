package MainPackages;

import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {

    private int x, y;
    private Sprite test;

    public Player(int x, int y) {
        test = new Sprite("Images/TestSprite.png", 2, 32, 32, 64, 64, 4);
        this.x = x;
        this.y = y;
        test.startAnimation();
    }

    public void draw(Graphics g) {
        g.drawImage(test.getImage(), x, y, null);
    }

    public void move() {
        x++;
        y++;
    }

}
