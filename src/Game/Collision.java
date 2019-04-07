/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home-PC
 */
public class Collision {

    Map map;
    Creature player;
    int size;

    public Collision(Map m, Creature p, int tileSize) {
        map = m;
        player = p;
        size = tileSize;
    }

    public boolean checkCollision(Creature cr, Direction d) {
        //return true;

        int y = cr.getY();
        int x = cr.getX();
        int c1;
        int c;
        switch (d) {

            case UP:

                c = map.getIntAt(y - player.getSpeed(), x, size);
                //c = map.getIntAt(y - y%size, x - player.getSpeed(), size);
                c1 = 1;
                if (x % size != 0) {
                    c1 = map.getIntAt(y - player.getSpeed(), x - (x - x % size), size);
                }

                if (c > 3 || c1 > 3) {
                    return false;
                } else {
                    return true;
                }
            case DOWN:
                c = map.getIntAt(y + size, x, size);
                //c = map.getIntAt(y - y%size, x - player.getSpeed(), size);
                c1 = 1;
                if (x % size != 0) {
                    c1 = map.getIntAt(y + size, x - (x - x % size), size);
                }

                if (c > 3 || c1 > 3) {
                    return false;
                } else {
                    return true;
                }
            case LEFT:
                c = map.getIntAt(y - y % size, x - player.getSpeed(), size);
                c1 = 1;
                if (y % size != 0) {
                    c1 = map.getIntAt(y - y % size + size, x - player.getSpeed(), size);
                }

                if (c > 3 || c1 > 3) {
                    return false;
                } else {
                    return true;
                }
            case RIGHT:
                c = map.getIntAt(y + y % size, x + size, size);
                c1 = 1;
                if (y % size != 0) {
                    c1 = map.getIntAt(y + y % size - size, x + size, size);
                }

                if (c > 3 || c1 > 3) {
                    return false;
                } else {
                    return true;
                }
            default:
                return true;
            //break;
        }
    }


    public boolean isEmptyAt(int x, int y, Direction d) {
        return false;
    }

    public boolean isEmptyNear(int x, int y, Direction d) {
        
        if(d == Direction.DOWN || d == Direction.UP){
            if (map.getIntAt(y, x + size, size) < 3 || map.getIntAt(y, x - size, size) < 3) {
                
            return true;
        } else {
            return false;
        }
        }else{
            if (map.getIntAt(y + size, x, size) < 3 || map.getIntAt(y - size, x, size) < 3) {
            return true;
        } else {
            return false;
        }
        }
        
    
    }

    public List<Direction> getTurns(int x, int y, Direction d) {
        List<Direction> res = new ArrayList<Direction>();
        if (isEmptyNear(x, y, d)) {
            
            if (map.getIntAt(y + size, x, size) < 3 && d != Direction.UP) {
                res.add(Direction.DOWN);
            }
            if (map.getIntAt(y - size, x, size) < 3 && d != Direction.DOWN) {
                res.add(Direction.UP);
            }
            if (map.getIntAt(y, x + size, size) < 3 && d != Direction.LEFT) {
                res.add(Direction.RIGHT);
            }
            if (map.getIntAt(y, x - size, size) < 3 && d != Direction.RIGHT) {
                res.add(Direction.LEFT);
            }
        }
        return res;
    }
}
