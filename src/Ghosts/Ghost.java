/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ghosts;

import Game.Collision;
import Game.Creature;
import Game.Direction;
import Game.Map;
import Game.Player;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Home-PC
 */
public class Ghost extends Creature {

    protected int[] target = new int[2];

    protected int runtime;
    protected int timertick;

    public boolean isRunning = false;

    Player pacman;

    public Ghost(int x, int y, int speed, Map map, Player p, int size, int tick) {
        super(x, y, speed, map, size);
        timertick = tick;
        runtime = 0;
        col = new Collision(map, this, size);
        pacman = p;
        moving = true;
        this.map = map;
        SetTarget();

    }

    protected void updateImage() {

    }

    public void update() {

        if (isRunning && runtime >= 5000) {
            isRunning = false;
            runtime = 0;
        }
        if (isRunning) {
            runtime += timertick;
        }

        if (isRunning && pacmanCaugth()) {

            
            pacman.setPoints(pacman.getPoints() + 200);
            this.X = 9 * Size;
            this.Y = 10 * Size;
            return;
        }

        updateImage();

        int[] rightExit = map.getRightExitCoords();
        int[] leftExit = map.getLeftExitCoords();

        if (this.X == rightExit[1] * Size && this.Y == rightExit[0] * Size) {
            this.X = leftExit[1] * Size;
            this.Y = leftExit[0] * Size;
        } else if (this.X == leftExit[1] * Size && this.Y == leftExit[0] * Size) {
            this.X = rightExit[1] * Size;
            this.Y = rightExit[0] * Size;
        } else if (this.X % Size == 0 && this.Y % Size == 0) {
            SetTarget();
            setNextStepDirection(target[0], target[1]);
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
        }
    }

    private boolean isTurn() {

        return false;
    }

    private double getDistance(int targetX, int targetY, Direction d) {
        int xDif;
        int yDif;
        //Math.abs(this.X - targetX);
        // Math.abs(this.Y - targetY);
        switch (d) {
            case DOWN:
                xDif = Math.abs(this.X - targetX);
                yDif = Math.abs(this.Y + Size - targetY);
                break;
            case UP:
                xDif = Math.abs(this.X - targetX);
                yDif = Math.abs(this.Y - Size - targetY);
                break;
            case LEFT:
                xDif = Math.abs(this.X - Size - targetX);
                yDif = Math.abs(this.Y - targetY);
                break;
            case RIGHT:
                xDif = Math.abs(this.X + Size - targetX);
                yDif = Math.abs(this.Y - targetY);
                break;
            default:
                xDif = Math.abs(this.X - targetX);
                yDif = Math.abs(this.Y - targetY);
                break;
        }

        return Math.sqrt(xDif * xDif + yDif * yDif);
    }

    private void setNextStepDirection(int x, int y) {

        if (col.isEmptyNear(this.X, this.Y, direction)) {
            List<Direction> dirs = col.getTurns(this.X, this.Y, direction);
            int xDif = Math.abs(this.X - x);
            int yDif = Math.abs(this.Y - y);
            if (!dirs.isEmpty()) {
                //ashtable<Direction, Double> lengths = new Hashtable<Direction, Double>();
                double min = getDistance(x, y, dirs.get(0));
                Direction d = dirs.get(0);

                for (int i = 1; i < dirs.size(); i++) {
                    double temp = getDistance(x, y, dirs.get(i));
                    if (temp < min) {
                        min = temp;
                        d = dirs.get(i);
                    }

                }
                direction = d;
            }

        }
    }

    protected void SetTarget() {
    }

    public boolean pacmanCaugth() {
        int px = pacman.getX(), py = pacman.getY();
        int pxx = px + Size, pyy = py + Size;

        boolean first = this.X >= px && this.X <= pxx && this.Y >= py && this.Y <= pyy;
        boolean second = this.X + Size >= px && this.X + Size <= pxx && this.Y + Size >= py && this.Y + Size <= pyy;

        boolean top = this.X + Size > px && this.X < px && this.Y - this.Y % Size == py - py % Size;
        boolean bottom = this.X < px + Size && this.X > px + Size && this.Y - this.Y % Size == py - py % Size;
        boolean right = this.Y < py + Size && this.Y > py && this.X - this.X % Size == px - px % Size;
        boolean left = this.Y + Size > py && this.Y < py && this.X - this.X % Size == px - px % Size;
        return first || second;
    }

}
