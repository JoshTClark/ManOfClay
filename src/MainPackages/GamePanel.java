package MainPackages;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel {
    //Hello this is test
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
}
