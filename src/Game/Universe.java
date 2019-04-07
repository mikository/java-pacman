/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Ghosts.RedGhost;
import Ghosts.PinkGhost;
import Ghosts.BlueGhost;
import Ghosts.YellowGhost;
import javax.swing.JPanel;

/**
 *
 * @author Home-PC
 */
public class Universe extends JPanel  {

    protected Map map;
    protected int Size;
    protected Player pacman;
    protected RedGhost red;
    protected PinkGhost pinky;
    protected BlueGhost inky;
    protected YellowGhost clyde;
    protected int StartAtWidth;
    Collision playerCol;

    public Universe() {
        
        
    }
    
    public void ghostRunAway(boolean f){
        pinky.isRunning = true;
        red.isRunning = true;
        clyde.isRunning = true;
        inky.isRunning = true;
        
    }
}
