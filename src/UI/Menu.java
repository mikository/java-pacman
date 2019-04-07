/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Game.Main;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Home-PC
 */
public class Menu extends JPanel{

    protected JFrame frame;
    JButton btnStart = new JButton();
    JButton btnScores = new JButton();

    public Menu(JFrame j) {
        
        super();
        frame = j;
        this.setLayout(null);
        SetUpStartButton();
        SetUpScoresButton();
        repaint();
        //btnStart.setVisible(true);
        
    }
    
    private void SetUpScoresButton(){
        btnScores.setText("High Scores");
        btnScores.setFont(new Font("Arial", Font.PLAIN, 55));
        
        btnScores.setFocusable(false);
        
        btnScores.setVisible(true);
        
        
        
        //btnStart.setOpaque(false);
        //btnStart.setContentAreaFilled(false);
        //btnStart.setBorderPainted(false);
        
        btnScores.setBorder(null);
        btnScores.setMargin(new Insets(0, 0, 0, 0));
        btnScores.setBounds(88, 270, 400, 100);
        
        this.add(btnScores);
        //frame.removeAll();
        btnScores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnScores.setBackground(Color.GREEN);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnScores.setBackground(Color.BLUE);
            }
        });
        
        btnScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowScores();
            }
        });
        btnScores.setForeground(Color.RED);
        btnScores.setBackground(Color.BLUE);
    }
    
    private void ShowScores(){
        frame.remove(this);
        frame.add(new Scores(frame));
        frame.revalidate();
        frame.repaint();
    }
    
    private void SetUpStartButton(){
        btnStart.setText("Start Game");
        btnStart.setFont(new Font("Arial", Font.PLAIN, 55));
        
        btnStart.setFocusable(false);
        btnStart.setForeground(Color.RED);
        btnStart.setBackground(Color.BLUE);
        
        
        
        
        //btnStart.setOpaque(false);
        //btnStart.setContentAreaFilled(false);
        //btnStart.setBorderPainted(false);
        
        btnStart.setBorder(null);
        btnStart.setMargin(new Insets(0, 0, 0, 0));
        btnStart.setBounds(88, 150, 400, 100);
        
        this.add(btnStart);
        //frame.removeAll();
        btnStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStart.setBackground(Color.GREEN);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStart.setBackground(Color.BLUE);
            }
        });
        
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartGame();
            }
        });
    }


    private void StartGame(){
        frame.remove(this);
        frame.add(new Main(frame));
        
        
    }

    public void paint(Graphics g) {
        try {
            g.drawImage(ImageIO.read(new File("src/Game/Images/pacman.jpg")), 0, -50, 576, 270, null);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
