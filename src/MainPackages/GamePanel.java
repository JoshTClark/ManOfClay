package MainPackages;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.util.logging.Logger;

import javax.swing.*;

public class GamePanel extends JPanel {

    private final Player player;
    private final KeyLsn keylsn;
    private final javax.swing.Timer timer;
    private final Thread movementThread;
    /**
     * [0] Jump - Space bar pressed.
     *
     * [1] Move right - "A" or right arrow pressed.
     *
     * [2] Move left - "D" or left arrow pressed.
     */
    private final boolean[] movement;

    public GamePanel() {
        setFocusable(true);
        requestFocusInWindow();
        player = new Player(100, 100);
        keylsn = new KeyLsn();
        addKeyListener(keylsn);
        movement = new boolean[]{false, false, false};
        timer = new javax.swing.Timer(5, new TimerListener());
        timer.start();
        movementThread = new Thread(new Runner());
        movementThread.start();
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
                case KeyEvent.VK_SPACE:
                    movement[0] = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    movement[1] = true;
                    break;
                case KeyEvent.VK_LEFT:
                    movement[2] = true;
                    break;
                default:
                    player.move(2, 2);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    movement[0] = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    movement[1] = false;
                    break;
                case KeyEvent.VK_LEFT:
                    movement[2] = false;
                    break;
                default:
                    break;
            }
        }
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (movement[0]) {
                player.jump();
            } else if (movement[1]) {
                player.changeSpeedHorz(1);
            } else if (movement[2]) {
                player.changeSpeedHorz(-1);
            }
            requestFocusInWindow();
            player.move();
            repaint();
        }
    }

    private class Runner extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sprite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }
}
