package MainPackages;

import java.awt.*;

public class Grid {

    private final Tile[][] allTiles;

    public Grid() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int scrHeight = (int) screenSize.getHeight();
        int scrWidth = (int) screenSize.getWidth();
        allTiles = new Tile[(scrWidth / 96) + 1][(scrHeight / 96) + 1];
        for (Tile[] allTile : allTiles) {
            for (int k = 0; k < allTile.length; k++) {
                allTile[k] = new Tile();
            }
        }
    }

    public void addTile(int gridX, int gridY) {
        if (gridX >= allTiles.length || gridY >= allTiles[0].length) {
            return;
        }
        Tile t = new Tile(96 * gridX, 96 * gridY, 96, 96);
        allTiles[gridX][gridY] = t;
    }

    public void addTiles(int gridStartX, int gridStartY, int gridEndX, int gridEndY) {
        for (int k = gridStartX; k <= gridEndX; k++) {
            for (int i = gridStartY; i <= gridEndY; i++) {
                addTile( k, i );
            }
        }
    }

    public Tile[][] getTiles() {
        return allTiles;
    }

    public void update(Graphics g) {
        for (Tile[] t1 : allTiles) {
            for (Tile t2 : t1) {
                if (!(t2.isNull())) {
                    t2.update();
                    t2.draw(g);
                }
            }
        }
    }

}
