/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Home-PC
 */
public class Player extends Creature {

    private int Points;
    private final Main main;

    public int getPoints() {
        return Points;
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }
    
    
    Direction nextDir;

    public Player(int x, int y, int speed, Map map, int size, Main m) {
        super(x, y, speed, map, size);
        main = m;
        this.map = map;
        col = new Collision(map, this, size);
        this.move();
    }

    short count = 0;

    public int getAbsX() {
        switch (direction) {
            case LEFT:
                return X + X % 24;
            case RIGHT:
                return X - X % 24;
            default:
                return X;
        }

    }

    public void keyPressed(KeyEvent e, int tileSize) {
        
        Direction d;
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            d = Direction.UP;
        } else if (key == KeyEvent.VK_S) {
            d = Direction.DOWN;
        } else if (key == KeyEvent.VK_A) {
            d = Direction.LEFT;
        } else if (key == KeyEvent.VK_D) {
            d = Direction.RIGHT;
        } else {
            return;
        }
        //direction = d;

        if (direction == d) {
            return;
        }

        if (this.col.checkCollision((Creature) this, d)) {
            direction = d;

            nextDir = null;
        } else {
            nextDir = d;
        }
        
    }

    public void keyReleased(KeyEvent e) {
        
    }

    public BufferedImage getSprite() {
        return image;
    }

    @Override
    public void update() {

        int[] rightExit = map.getRightExitCoords();
        int[] leftExit = map.getLeftExitCoords();

        if (this.X == rightExit[1] * Size && this.Y == rightExit[0] * Size) {
            this.X = leftExit[1] * Size;
            this.Y = leftExit[0] * Size;
        } else if (this.X == leftExit[1] * Size && this.Y == leftExit[0] * Size) {
            this.X = rightExit[1] * Size;
            this.Y = rightExit[0] * Size;
        } else if (nextDir != null && col.checkCollision(this, nextDir)) {
            direction = nextDir;
            nextDir = null;
        }

        if (col.checkCollision(this, direction)) {
            this.move();
        } else {
            this.stop();
        }
        if (moving) {
            switch (direction) {
                case UP:

                    Y -= Speed;
                    break;
                case DOWN:
                    Y += Speed;
                    break;
                case LEFT:
                    X -= Speed;
                    break;
                case RIGHT:
                    X += Speed;
                    break;
                default:

                    break;
            }
            
            if(map.getIntAt(Y, X, Size) == 1){
                Points+=1;
                map.removeAt(X, Y, Size);
            }
            else if(map.getIntAt(Y, X, Size) == 2){
                main.ghostRunAway(true);
                map.removeAt(X, Y, Size);
            }
        }

        try {
            image = ImageIO.read(new File("src/Game/Images/sprites.png"));
            //BufferedImage image = (BufferedImage) img;

            image = image.getSubimage(2 + (animation ? 17 : 0), 1 + (15 + 1) * direction.ordinal(), 15, 15);
            animation = !animation;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void draw() {

    }

}
