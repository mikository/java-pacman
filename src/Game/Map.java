/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Home-PC
 */
public class Map {

    public Map() {
        this.width = Map[0].length ;
        this.height = Map.length ;
        try{
        spritesheet = ImageIO.read(new File("src/Game/Images/mapsprites.png"));
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    private int width;
    private int height;
    private BufferedImage spritesheet; 
    public int getHeight() {
        return height;
    }

    public int[] getLeftExitCoords(){
        return new int[]{10, 0};
    }
    
    public int[] getRightExitCoords(){
        return new int[]{10, 18};
    }
    
    public void removeAt(int x, int y, int tileSize){
        Map[y/tileSize][x/tileSize] = 0;
    }
    
    public boolean poitsLeft(){
        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++){
                if(Map[i][j] == 1 || Map[i][j] == 2)
                    return true;
            }
        return false;
    }
    
    public int getWidth() {
        return width;
    }
    
    public BufferedImage getTile(int x, int y){
        int temp = Map[y][x];
        
        if(temp < 4){
            if(temp == 1)
                return spritesheet.getSubimage(3 + 3* 22 + 24* 22, 3, 24, 24);
            else if (temp == 2)
                return spritesheet.getSubimage(3 + 3* 23 + 24* 23, 3, 24, 24);
            return spritesheet.getSubimage(4, 100, 24, 24);
        }
        else{
            temp -= 4;
            return spritesheet.getSubimage(3 + 3* temp + 24* temp, 3, 24, 24);
        }
        
    }
    
    
    
    public int getIntAt(int h, int w){
        return Map[h][w];
    }
    
    public int getIntAt(int y, int x, int tileSize){
        return Map[y/tileSize][x/tileSize];
    }

    public char getCharAt(int y, int x, int tileSize) {
        return map[y / tileSize].charAt(x  / tileSize* 2);
    }

    public char getCharAt(int h, int w) {
        return map[h].charAt(w * 2);
    }
    
    int[][] Map = new int[][]{
       {10, 5, 5, 5, 5, 5, 5, 5, 5,23, 5, 5, 5, 5, 5, 5, 5, 5,11},
        {4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4},
        {4, 2,10,11, 1,10, 5,11, 1, 4, 1,10, 5,11, 1,10,11, 2, 4},
	{4, 1, 6, 7, 1, 6, 5, 7, 1, 8, 1, 6, 5, 7, 1, 6, 7, 1, 4},
	{4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4},
	{4, 1, 9,17, 1,16, 1, 9, 5,23, 5,17, 1,16, 1, 9,17, 1, 4},
	{4, 1, 1, 1, 1, 4, 1, 1, 1, 4, 1, 1, 1, 4, 1, 1, 1, 1, 4},
	{6, 5, 5,11, 1,24, 5,17, 0, 8, 0, 9, 5,25, 1,10, 5, 5, 7},
	{ 0, 0, 0,4, 1, 4, 0, 0, 0, 0, 0, 0, 0, 4, 1, 4, 0, 0, 0},
        {5, 5, 5, 7, 1, 8, 0,10, 5, 3, 5,11, 0, 8, 1, 6, 5, 5, 5},
	{0, 0, 0, 0, 1, 0, 0, 4, 3, 3, 3, 4, 0, 0, 1, 0, 0, 0, 0},
	{5, 5, 5,11, 1,16, 0, 6, 5, 5, 5, 7, 0,16, 1,10, 5, 5, 5},
	{0, 0, 0, 4, 1, 4, 0, 0, 0, 0, 0, 0, 0, 4, 1, 4, 0, 0, 0},
       {10, 5, 5, 7, 1, 8, 0, 9, 5,23, 5,17, 0, 8, 1, 6, 5, 5,11},
	{4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4},
	{4, 1, 9,11, 1, 9, 5,17, 1, 8, 1, 9, 5,17, 1,10,17, 1, 4},
	{4, 2, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 2, 4},
       {24,17, 1, 8, 1,16, 1, 9, 5,23, 5,17, 1,16, 1, 8, 1, 9,25},
	{4, 1, 1, 1, 1, 4, 1, 1, 1, 4, 1, 1, 1, 4, 1, 1, 1, 1, 4},
	{4, 1, 9, 5, 5,22, 5,17, 1, 8, 1, 9, 5,22, 5, 5,17, 1, 4},
	{4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4},
	{6, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7}
};

    String[] map = new String[]{
        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
        "0 + - - - - + - - - - - + 0 0 + - - - - - + - - - - + 0",
        "0 | 0 0 0 0 | 0 0 0 0 0 | 0 0 | 0 0 0 0 0 | 0 0 0 0 | 0",
        "0 | 0 0 0 0 | 0 0 0 0 0 | 0 0 | 0 0 0 0 0 | 0 0 0 0 | 0",
        "0 | 0 0 0 0 | 0 0 0 0 0 | 0 0 | 0 0 0 0 0 | 0 0 0 0 | 0",
        "0 + - - - - + - - + - - + - - + - - + - - + - - - - + 0",
        "0 | 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 | 0",
        "0 | 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 | 0",
        "0 + - - - - + 0 0 + - - + 0 0 + - - + 0 0 + - - - - + 0",
        "0 0 0 0 0 0 | 0 0 0 0 0 | 0 0 | 0 0 0 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 0 0 0 | 0 0 | 0 0 0 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 + - - + - - + - - + 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 | 0 0 0     0 0 0 | 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 | 0             0 | 0 0 | 0 0 0 0 0 0",
        "+ - - - - - + - - + 0             0 + - - + - - - - - +",
        "0 0 0 0 0 0 | 0 0 | 0             0 | 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 + - - - - - - - - + 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0",
        "0 + - - - - + - - + - - + 0 0 + - - + - - + - - - - + 0",
        "0 | 0 0 0 0 | 0 0 0 0 0 | 0 0 | 0 0 0 0 0 | 0 0 0 0 | 0",
        "0 | 0 0 0 0 | 0 0 0 0 0 | 0 0 | 0 0 0 0 0 | 0 0 0 0 | 0",
        "0 + - + 0 0 + - - + - - + - - + - - + - - + 0 0 + - + 0",
        "0 0 0 | 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 | 0 0 0",
        "0 0 0 | 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 | 0 0 0",
        "0 + - + - - + 0 0 + - - + 0 0 + - - + 0 0 + - - + - + 0",
        "0 | 0 0 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 0 0 | 0",
        "0 | 0 0 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 0 0 | 0",
        "0 + - - - - - - - - - - + - - + - - - - - - - - - - + 0",
        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"
    };
    /* 
    char[][] map =  new char[][]{
        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
        {'0', '+', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '0', '0', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '+', '0'},
        {'0', '|', '0', '0', '0', '|','0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '|', '0', '0', '0', '|', '0'},
        {'0', '|', '0', '0', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '0', '0', '|', '0'},
        {'0', '|', '0', '0', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '0', '0', '|', '0'},
        {'0', '+', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '0', '0', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '+', '0'},
        {'0', '|', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '|', '0'},
        {'0', '|', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '|', '0'},
        {'0', '+', '-', '-', '-', '-', '+', '-', '-', '-', '|', '-', '+', '0', '0', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '+', '0'},
        {'0', '0', '0', '0', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '|', '0', '0', '+', '|', '|', '+', '|', '|', '+', '|', '|', '+', '0', '0', '|', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0', '0', '0', '|', '0', '0',  '|', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0'},
        {'+', '-', '-', '-', '-', '-', '+', '-', '-', '+', '0', '0', '0', '0', '0', '0', '0', '0', '+', '-', '-', '+', '-', '-', '-', '-', '-', '+'},
        {'0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '|', '0', '0', '+', '-', '-', '-', '-', '-', '-', '-', '-', '+', '0', '0', '|', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '0'},
        {'0', '+', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '0', '0', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '+', '0'},
        {'0', '|', '0', '0', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '0', '0', '|', '0'},
        {'0', '|', '0', '0', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '0', '0', '0', '|', '0'},
        {'0', '+', '-', '+', '0', '0', '+', '-', '-', '+', '-', '-', '+', '-', '-', '+', '-', '-', '+', '-', '-', '+', '0', '0', '+', '-', '+', '0'},
        {'0','0','0', '|', '0','0', '|', '0','0', '|', '0','0','0','0','0','0','0','0', '|', '0','0', '|', '0','0', '|', '0','0','0'},
        {'0','0','0', '|', '0','0', '|', '0','0', '|', '0','0','0','0','0','0','0','0', '|', '0','0', '|', '0','0', '|', '0','0','0'},
        {'0', + - + - - + '0', '0', + - - + '0','0', + - - + '0','0', + - - + - + '0',},
        {'0', |'0','0','0','0','0','0','0','0','0','0', | '0','0', | '0','0','0','0','0','0','0','0','0','0', | '0',},
        {'0', |'0','0','0','0','0','0','0','0','0','0', | '0','0', | '0','0','0','0','0','0','0','0','0','0', | '0',},
        {'0', + - - - - - - - - - - + - - + - - - - - - - - - - + '0'},
        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}
    };*/
}


/*

        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
        "0 + - - + - - - + 0 0 + - - - + - - + 0",
        "0 | 0 0 | 0 0 0 | 0 0 | 0 0 0 | 0 0 | 0",
        "0 | 0 0 | 0 0 0 | 0 0 | 0 0 0 | 0 0 | 0",
        "0 + - - + - + - - - - - + - - + - - + 0",
        "0 | 0 0 | 0 | 0 0 0 0 0 | 0 0 | 0 0 | 0",
        "0 + - - + 0 + - - + 0 0 + - - + 0 0 + - - - - + 0",
        "0 0 0 0 | 0 0 0 | 0 0 | 0 0 0 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 + - - + - - + - - + 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 | 0 0 0     0 0 0 | 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 | 0             0 | 0 0 | 0 0 0 0 0 0",
        "+ - - - - - + - - + 0             0 + - - + - - - - - +",
        "0 0 0 0 0 0 | 0 0 | 0             0 | 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 + - - - - - - - - + 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0",
        "0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0",
        "0 + - - - - + - - + - - + 0 0 + - - + - - + - - - - + 0",
        "0 | 0 0 0 0 | 0 0 0 0 0 | 0 0 | 0 0 0 0 0 | 0 0 0 0 | 0",
        "0 | 0 0 0 0 | 0 0 0 0 0 | 0 0 | 0 0 0 0 0 | 0 0 0 0 | 0",
        "0 + - + 0 0 + - - + - - + - - + - - + - - + 0 0 + - + 0",
        "0 0 0 | 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 | 0 0 0",
        "0 0 0 | 0 0 | 0 0 | 0 0 0 0 0 0 0 0 | 0 0 | 0 0 | 0 0 0",
        "0 + - + - - + 0 0 + - - + 0 0 + - - + 0 0 + - - + - + 0",
        "0 | 0 0 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 0 0 | 0",
        "0 | 0 0 0 0 0 0 0 0 0 0 | 0 0 | 0 0 0 0 0 0 0 0 0 0 | 0",
        "0 + - - - - - - - - - - + - - + - - - - - - - - - - + 0",
        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"
*/