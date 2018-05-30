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

    public GamePanel(int w, int h) {
        height = h;
        width = w;
        setFocusable(true);
        requestFocusInWindow();
        player = new Player(100, 100);
        keylsn = new KeyLsn();
        addKeyListener(keylsn);
        jumping = false;
        right = false;
        left = false;
        timer = new javax.swing.Timer(5, new TimerListener());
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
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
                    left = true;
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
            player.update();
            repaint();
        }
    }
}
