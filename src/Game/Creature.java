/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

/**
 *
 * @author Home-PC
 */
public class Creature {

    public int X, Y, Speed;
    public int Size;
    public Direction direction = Direction.DOWN;
    public boolean moving = false;
    public boolean animation = false;
    public BufferedImage image;
    public Map map;
    public Collision col;
    public Creature(int x, int y, int speed, Map map, int size) {
        this.X = x;
        this.Y = y;
        this.Size = size;
        this.Speed = speed;
    }

    public void update() {

    }
    public BufferedImage getImage(){
        return image;
    }
 

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
    
    public int getSpeed() {
        return Speed;
    }

    public void move() {
        moving = true;
    }
    public int getSize(){
        return this.Size;
    }
    public void stop() {
        moving = false;
    }
}
