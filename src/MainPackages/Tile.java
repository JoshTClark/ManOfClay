package MainPackages;

import java.awt.*;
import java.awt.geom.*;

public class Tile {

    private double x, y, w, h;
    private final Rectangle2D hitbox, colored;
    private final boolean isNull;

    public Tile(int nx, int ny, int width, int height) {
        x = nx;
        y = ny;
        w = width;
        h = height;
        hitbox = new Rectangle2D.Double(x, y, h, w);
        colored = new Rectangle2D.Double(x + 5, y + 5, h - 10, w - 10);
        isNull = false;
    }

    public Tile() {
        x = 0;
        y = 0;
        w = 0;
        h = 0;
        hitbox = new Rectangle2D.Double(x, y, h, w);
        colored = new Rectangle2D.Double(x, y, h, w );
        isNull = true;
    }

    public Rectangle2D getHitbox() {
        return hitbox;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLACK);
        g2d.fill(hitbox);
        g2d.setPaint(Color.RED);
        g2d.fill(colored);
    }

    public void update() {
        if (!(isNull)) {
            hitbox.setFrame(x, y, w, h);
            colored.setFrame(x + 5, y + 5, w-10, h-10);
        }
    }

    public boolean isNull() {
        return isNull;
    }
}
