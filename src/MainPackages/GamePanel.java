package MainPackages;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel {

    private final Player player;
    private final KeyLsn keylsn;
    private final javax.swing.Timer timer;
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
        timer = new javax.swing.Timer(1, new TimerListener());
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
                case 32:
                    movement[0] = true;
                    break;
                case 39:
                case 65:
                    movement[1] = true;
                    break;
                case 37:
                case 68:
                    movement[2] = true;
                    break;
                default:
                    break;
            }
        }
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
}
