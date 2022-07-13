/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author hadys
 * 
 */
public class Main extends JFrame {
    
    public Main() {
        init();
    }
    
    private void init() {
        
        add(new PacmanGame());
        
        setTitle("PacMan V 1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 450);
        setLocationRelativeTo(null);
    }
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }
    
}
