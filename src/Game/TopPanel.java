/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Home-PC
 */
public class TopPanel extends JPanel implements ActionListener{

    
    Timer timer;
    Player pacman;
    JLabel label = new JLabel();
    
    public TopPanel(JFrame frame, Timer t, Player p){
        this.setBounds(0, 0, 576, 150);
        this.setBackground(Color.BLACK);
        timer = t;
        pacman = p;
        timer.addActionListener(this);
         label.setVisible(true);
         label.setFont(new Font("Arial", 0, 35));
         label.setForeground(Color.YELLOW);
         label.setLocation(15, 20);
        this.add(label);
       
    } 
           
    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText(String.valueOf(pacman.getPoints()));
    }
    
    
    
}
