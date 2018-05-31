package MainPackages;

import java.awt.Graphics;
import java.awt.geom.*;

public class Player {

    private final Sprite spr;
    private double x, y, curJumpSpeed, curFallSpeed;
    private final double jumpSpeed, fallAccel, jumpDecel;
    private boolean right, left, isJumping, isFalling;
    private final Rectangle2D hitbox;
    public Tile test;

    public Player(int nx, int ny) {
        x = nx;
        y = ny;
        spr = new Sprite("Images/TestSprite.png", 3, 32, 32, 64, 64, 5);
        spr.startAnimation();
        right = false;
        left = false;
        isJumping = false;
        jumpSpeed = 7;
        jumpDecel = 0.2;
        curJumpSpeed = jumpSpeed;
        isFalling = false;
        fallAccel = 0.2;
        curJumpSpeed = 0;
        hitbox = new Rectangle2D.Double(x, y, spr.getWidth(), spr.getHeight());
        test = new Tile(100, 400, 96, 96);
    }

    public void draw(Graphics g) {
        spr.draw(g, x, y);
        test.draw(g);
    }

    public void move(boolean b1, boolean b2) {
        right = b1;
        left = b2;
    }

    public void jump() {
        if (!(isFalling)) {
            isJumping = true;
        }
    }

    public void update() {
        if (hitbox.intersects(test.getHitbox())) {
            isFalling = false;
        } else {
            isFalling = true;
        }
        if (right) {
            x += 2;
        } else if (left) {
            x -= 2;
        }
        if (isJumping) {
            if (curJumpSpeed > 0) {
                curJumpSpeed -= jumpDecel;
                y -= curJumpSpeed;
            } else {
                curJumpSpeed = jumpSpeed;
                isFalling = true;
                isJumping = false;
            }
        } else if (isFalling) {
            curFallSpeed += fallAccel;
            y += curFallSpeed;
        }
        if( !(isFalling)){
            curFallSpeed = 0;
        }
        hitbox.setFrame(x, y, 96, 96);
    }
}
