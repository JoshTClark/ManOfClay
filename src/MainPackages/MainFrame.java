package MainPackages;

import java.awt.*;
import javax.swing.*;

/**
 * This is the MainFrame of the game. The main method is here as well as the
 * GamePanel, GridSystem, and Level objects.
 */
public class MainFrame extends JFrame {

    private final int width;
    private final int height;
    private final GamePanel gamePanel;
    private final GridSystem grid;
    private final Level lvlTest, lvl1, lvl2, lvl3;

    /**
     * Initializes the instance variables and sets up the frame.
     */
    public MainFrame() {
        // Setting up the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Man Of Clay");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);

        // Dimension object used to find the screen width and height
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // The screen height
        height = (int) screenSize.getHeight();
        // The screen width
        width = (int) screenSize.getWidth();

        // The panel where all the game stuff goes
        gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(width, height));
        gamePanel.setLayout(null);

        // Setting up the grid system
        grid = new GridSystem(gamePanel, height, width);

        // Setting up the levels
        lvlTest = new Level();
        lvl1 = new Level();
        lvl2 = new Level();
        lvl3 = new Level();

        // Adding the GamePanel and packing
        getContentPane().add(gamePanel);
        pack();
    }

    /**
     * The main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        MainFrame f = new MainFrame();
        f.display();
    }

    /**
     * The display method simply displays everything.
     */
    public void display() {
        EventQueue.invokeLater(() -> {
            setVisible(true);
        });
    }
}
