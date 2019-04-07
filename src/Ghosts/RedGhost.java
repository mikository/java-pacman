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
public class RedGhost extends Ghost {
    
    public RedGhost(int x, int y, int speed, Map map, Player p, int size, int tick) {
        super(x, y, speed, map, p, size, tick);
        
    }

    @Override
    protected void SetTarget() {
        if(isRunning){
            target[0] = 2000;
            target[1] = 2000;
            return;
        }
        target[0] = pacman.getX();
        target[1] = pacman.getY();
    }
    
    protected void updateImage(){
        try {
            image = ImageIO.read(new File("src/Game/Images/sprites.png"));
            //BufferedImage image = (BufferedImage) img;
               if(!isRunning)
            image = image.getSubimage(2 + (animation ? 17 : 0), 4 + 15*4, 15, 17);
               else
                   image = image.getSubimage(2 + (animation? 9* 16: 10*16), 4 + 15*4, 15, 17);
            animation = !animation;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
