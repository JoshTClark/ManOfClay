package MainPackages;

import java.awt.*;
import java.awt.geom.*;

public class Player {

    private final Sprite spr;
    private double x, y, curJumpSpeed, curFallSpeed, curRunSpeed, lastPressed;
    private final double jumpSpeed, fallAccel, jumpDecel, runSpeed, runAccel, runDecel;
    private boolean right, left, isJumping, isFalling;
    private final Rectangle2D hitbox, bottomHitbox;
    private final Grid grid;

    public Player(int nx, int ny, Grid g) {
        x = nx;
        y = ny;
        grid = g;
        spr = new Sprite("Images/TestSprite.png", 3, 32, 32, 64, 64, 5);
        spr.startAnimation();
        right = false;
        left = false;
        isJumping = false;
        jumpSpeed = 9.5;
        jumpDecel = 0.4;
        curJumpSpeed = jumpSpeed;
        isFalling = true;
        fallAccel = 0.35;
        runSpeed = 8;
        runAccel = 0.3;
        runDecel = 0.3;
        lastPressed = -1;
        hitbox = new Rectangle2D.Double(x, y, spr.getWidth(), spr.getHeight());
        bottomHitbox = new Rectangle2D.Double(x, y + spr.getHeight(), spr.getWidth(), 3.5);
    }

    public void draw(Graphics g) {
        spr.draw(g, x, y);
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

    public void updateCollision() {
        boolean brk = false;
        for (Tile[] tile : grid.getTiles()) {
            for (Tile tile1 : tile) {
                if (!(tile1.isNull())) {
                    if (hitbox.intersects(tile1.getHitbox())) {
                        isFalling = false;
                        brk = true;
                        y = tile1.getHitbox().getMinY()-tile1.getHitbox().getHeight();
                    }
                }
                if (brk == true) {
                    break;
                }
            }
            if (brk == true) {
                break;
            }
            isFalling = true;
        }
    }

    public void update() {
        if (right) {
            if (curRunSpeed <= runSpeed) {
                curRunSpeed += runAccel;
            }
            x += curRunSpeed;
            lastPressed = 0;
        } else if (left) {
            if (curRunSpeed >= -1 * runSpeed) {
                curRunSpeed -= runAccel;
            }
            x += curRunSpeed;
            lastPressed = 1;
        } else {
            if (curRunSpeed <= 0.4 && curRunSpeed >= -0.4) {
                curRunSpeed = 0;
            } else if (curRunSpeed > 0) {
                curRunSpeed -= runDecel;
            } else if (curRunSpeed < 0) {
                curRunSpeed += runDecel;
            }
            x += curRunSpeed;
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
        if (!(isFalling)) {
            curFallSpeed = 0;
        }
        hitbox.setFrame(x, y, spr.getWidth(), spr.getHeight());
    }
}
