package MainPackages;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Player {

    private final Sprite spr;
    private double x, y;
    private boolean right, left, isJumping, isFalling;
    private final Rectangle2D rec;

    public Player(int nx, int ny) {
        x = nx;
        y = ny;
        spr = new Sprite("Images/TestSprite.png", 3, 32, 32, 64, 64, 5);
        spr.startAnimation();
        right = false;
        left = false;
        isJumping = false;
        isFalling = false;
        rec = new Rectangle2D.Double(32, 32, x, y);
    }

    public void draw(Graphics g) {
    }

    public void move(boolean b1, boolean b2) {
        right = b1;
        left = b2;
    }

    public void jump() {
        isJumping = true;
    }

    public void update() {
        if (right) {
            x += 2;
        } else if (left) {
            x -= 2;
        }
        if (isJumping) {

        }
    }
}
