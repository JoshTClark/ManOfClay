package MainPackages;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class GamePanel extends JPanel {

    private final Player player;
    private final KeyLsn keylsn;
    private final int height, width;
    private final javax.swing.Timer timer;
    private boolean left, right, jumping;
    private final Grid grid;

    public GamePanel(int w, int h) {
        height = h;
        width = w;
        setFocusable(true);
        requestFocusInWindow();
        grid = new Grid();
        player = new Player(100, 100, grid);
        keylsn = new KeyLsn();
        addKeyListener(keylsn);
        jumping = false;
        right = false;
        left = false;
        grid.addTiles(0, 6, 10, 6);
        timer = new javax.swing.Timer(1, new TimerListener());
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        grid.update(g);
    }

    private class KeyLsn extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_SPACE:
                    jumping = true;
                    break;
                default:
                    break;
            }
            player.move(right, left);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    right = false;
                    break;
                case KeyEvent.VK_LEFT:
                    left = false;
                    break;
                case KeyEvent.VK_SPACE:
                    jumping = false;
                    break;
                default:
                    break;
            }
            player.move(right, left);
        }
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            requestFocusInWindow();
            if (jumping) {
                player.jump();
            }
            repaint();
            player.updateCollision();
            player.update();
        }
    }
}
