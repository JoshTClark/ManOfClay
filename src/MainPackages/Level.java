package MainPackages;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;
import javax.swing.*;
import java.lang.Object;

/**
 * Has everything in a level; can be saved to a file.
 * 
 * @author (Abe) 
 */
public class Level {
    private LevelGen lev;
    public enum LevelGen {EASY, HARD}
    
    public Level (String currentDifficulty) {
        if ("hard".equals(currentDifficulty.toLowerCase())) 
            lev = LevelGen.HARD;
        else
            lev = LevelGen.EASY;
    }

    public void loadLevel(int numLevel) {
        switch (lev) {
            case HARD:
                clearCurrentLevel();
            default:
                clearCurrentLevel()
            
        }
    }

    private void clearCurrentLevel() {
        
    }
}
