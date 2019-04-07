/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import Game.Main;
import Game.Universe;
import UI.Menu;
import UI.Scores;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Home-PC
 */
public class Display {
    public static void main(String[] args){
        JFrame frame = new JFrame("MyGame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(576, 795);
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        //frame.setUndecorated(true);
        //set layout here to start normaly
        frame.add(new Menu(frame));
        
        frame.setVisible(true);
        
    }
}
