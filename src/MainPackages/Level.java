package MainPackages;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;
import javax.swing.*;
import java.lang.Object;
import java.util.ArrayList;

/**
 * Has everything in a level; can be saved to a file.
 * 
 * @author (Abe) 
 */
public class Level {
    private LevelGen lev;
    private ArrayList<GeneratePanel> list = new ArrayList<GeneratePanel>();
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
                clearCurrentLevel(0);
                updateHardLevel(1);
            default:
                clearCurrentLevel(1);
                updateEasyLevel(0);
        }
    }

    private void clearCurrentLevel(int whatLevel) {
        //list.removeAll(list);
        list.remove(whatLevel);
    }
    
    private void updateEasyLevel(int whichLevel) {
        
    }
    
    private void updateHardLevel(int whichLevel) {
        
    }
    
    private class GeneratePanel{
        private GeneratePanel() {
            
        }
    }
}
