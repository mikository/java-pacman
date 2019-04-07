/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ghosts;

import Game.Map;
import Game.Player;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Home-PC
 */
public class BlueGhost extends Ghost{
    protected RedGhost blinky;
    public BlueGhost(int x, int y, int speed, Map map, Player p, int size, RedGhost red, int tick) {
        super(x, y, speed, map, p, size, tick);
        blinky = red;

    }
    
    protected void SetTarget(){
        if(isRunning){
            target[0] = 0;
            target[1] = 0;
            return;
        }
        
        
        if(blinky != null)
        {
        int tx = 0, ty = 0;
        switch(pacman.getDirection()){
            case DOWN:
                tx = pacman.getX();
                ty = pacman.getY() + 2 * Size;
                break;
                case UP:
                tx = pacman.getX();
                ty = pacman.getY() - 2 * Size;
                break;
                case RIGHT:
                tx = pacman.getX() + 2 * Size;
                ty = pacman.getY();
                break;
                case LEFT:
                tx = pacman.getX() - 2 * Size;
                ty = pacman.getY();
                break;
                
        }
        
        int resx, resy;
        resx = blinky.getX() + ((tx - blinky.getX()) * 2);
        resy = blinky.getY() + ((tx - blinky.getY()) * 2);
        target[0] = resx;
        target[1] = resy;
            
        }
    }
    protected void updateImage(){
        try {
            image = ImageIO.read(new File("src/Game/Images/sprites.png"));
            //BufferedImage image = (BufferedImage) img;
            
            if(!isRunning)
            image = image.getSubimage(2 + (animation ? 17 : 0), 7 + 15*6, 15, 17);
             else
                   image = image.getSubimage(2 + (animation? 9* 16: 10*16), 4 + 15*4, 15, 17);
            animation = !animation;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
