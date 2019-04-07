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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Home-PC
 */
public class Main extends Universe implements ActionListener {

    
    protected int StartUpHeight;
    
    
    protected static final int TIMER_SPEED = 75;
    
    Timer timer = new Timer(TIMER_SPEED, this);
    JFrame frame;

    boolean moving = false;

    //@Override

    public void actionPerformed(ActionEvent e) {

        // TODO Auto-generated method stub
        repaint();
        //playerCol.checkCollision();
        if(isLoss() && !red.isRunning){
           timer.stop();
       }
         
        
        if(!map.poitsLeft())
            timer.stop();
       pacman.update();
       red.update();
       pinky.update();
       inky.update();
       clyde.update();
       
       
    }
    
    private void setUpPanel(){
        this.setBounds(0, 100, 576, 660);
        
    }
    
   
    public Main(JFrame frame) {
        super();
        
        frame.setLayout(null);
        //frame.getContentPane().setLayout(null);
        this.setBackground(Color.BLACK);
        this.map = new Map();
        StartUpHeight = 100;
        this.Size = 30;
        //this.playerCol = new Collision(map, pacman, Size);
        pacman = new Player(1*Size, 4*Size, Size / 5, map, this.Size, this);
        
        red = new RedGhost(9*Size, 8*Size, Size / 6, map, pacman, this.Size,TIMER_SPEED);
        pinky = new PinkGhost(8*Size, 10*Size, Size / 6, map, pacman, this.Size,TIMER_SPEED);
        inky = new BlueGhost(9*Size, 10*Size, Size / 6, map, pacman, this.Size, red,TIMER_SPEED);
        clyde = new YellowGhost(10*Size, 10*Size, Size/6, map, pacman, this.Size,TIMER_SPEED);
        frame.add(new TopPanel(frame, timer, pacman));
        this.frame = frame;
        
        this.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                    
                pacman.keyPressed(e, Size);
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                pacman.keyReleased(e);
            }
        });
        timer.start();
        frame.repaint();
        setUpPanel();
    }

    @Override
    public void paint(Graphics g) {
        //Image image = new ImageIcon("src/Game/Images/1.png").getImage();
        g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
        //drawing map
        
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                        g.drawImage(map.getTile(j, i), j * Size, i * Size, Size, Size, null);

                
            }
        }
        //drawing pacman
        g.drawImage(pacman.getSprite(), pacman.getX(), pacman.getY(), Size, Size, null);
        //drawing ghosts
        g.drawImage(red.getImage(), red.getX(), red.getY(), Size, Size, null);
        g.drawImage(pinky.getImage(), pinky.getX(), pinky.getY(), Size, Size, null);
        g.drawImage(inky.getImage(), inky.getX(), inky.getY(), Size, Size, null);
        g.drawImage(clyde.getImage(), clyde.getX(), clyde.getY(), Size, Size, null);
    }
    
    private boolean isLoss(){
        boolean res = red.pacmanCaugth() || inky.pacmanCaugth() || inky.pacmanCaugth() || clyde.pacmanCaugth();
        return res;
        
    }

}
