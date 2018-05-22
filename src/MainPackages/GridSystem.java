package MainPackages;

public class GridSystem {
    final GamePanel gamePanel;
    final int height;
    final int width;

    /**
     *
     * @param p The GamePanel created in the MainFrame.
     * @param h The height of the panel.
     * @param w The width of the panel.
     */
    public GridSystem( GamePanel p, int h, int w ) {
        gamePanel = p;
        height = h;
        width = w;
    }
}
