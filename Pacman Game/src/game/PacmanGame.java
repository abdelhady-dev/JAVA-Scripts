/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author hadys
 */
public class PacmanGame extends JPanel implements ActionListener {
    Pacman pacman;
    ///// pzcman
     final int PACMAN_ANIM_COUNT = 4;
     final int PAC_ANIM_DELAY = 2;
     int pacman_x, pacman_y, pacmand_x, pacmand_y;
     int req_dx, req_dy, view_dx, view_dy;
    
     int pacAnimCount = PAC_ANIM_DELAY;
     int pacAnimDir = 1;
     int pacmanAnimPos = 0;
    ///// 
    
    
    ////// maze
     Color mazeColor;
     final Color dotColor = new Color(192, 192, 0);
    
     final int BLOCK_SIZE = 24;
     final int N_BLOCKS = 15;
     final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
     short[] screenData;
    
     final short levelData[] = {
        19, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 22,
        17, 18, 26, 26, 26, 18, 26, 26, 26, 18, 26, 26, 26, 18, 20,
        21, 21, 19, 18, 18, 20,  0,  0,  0, 17, 18, 18, 22, 21, 21,
        21, 21, 17, 16, 16, 16, 18, 18, 18, 16, 16, 16, 20, 21, 21,
        21, 21, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, 21, 21,
        21, 17, 24, 16, 16, 24, 24, 24, 24, 24, 16, 16, 24, 20, 21,
        21, 21,  0, 17, 20,  0,  0,  0,  0,  0, 17, 20,  0, 21, 21,
        21, 21,  0, 17, 16, 18, 22,  0, 19, 18, 16, 20,  0, 21, 21,
        21, 21,  0, 17, 16, 16, 20,  0, 17, 16, 16, 20,  0, 21, 21,
        21, 17, 18, 16, 16, 16, 20,  0, 17, 16, 16, 16, 18, 20, 21,
        21, 21, 17, 16, 16, 16, 16, 18, 16, 16, 16, 16, 20, 21, 21,
        21, 21, 17, 16, 16, 16, 24,  8, 24, 16, 16, 16, 20, 21, 21,
        21, 21, 25, 24, 24, 20,  0,  0,  0, 17, 24, 24, 28, 21, 21,
        17, 24, 26, 26, 26, 24, 26, 26, 26, 24, 26, 26, 26, 24, 20,
        25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 28
    };
    /////
    
    protected boolean inGame = false;
    protected boolean dying = false;

    private Dimension d;
    protected Timer timer;
    
    public PacmanGame() {
        pacman = new Pacman();
        initVariables();
        initPacmanGame();
    }
    
    private void initPacmanGame() {
        addKeyListener(new KeyboardAdapter());
        setFocusable(true);
        setBackground(Color.black);
    }
    
    private void initVariables() {
        ///// maze
        screenData = new short[N_BLOCKS * N_BLOCKS];
        mazeColor = new Color(5,5,240);
        /////
        d = new Dimension(400, 400);
        
        timer = new Timer(30, this);
        timer.start();
    }
    
    @Override
    public void addNotify() { 
        super.addNotify();

        initGame();
    }
    protected void initGame() {
        initLevel();
    }
    
    private void initLevel() {
        //// maze
        System.arraycopy(levelData, 0, screenData, 0, N_BLOCKS * N_BLOCKS);
        ////
        continueLevel();
    }

    private void continueLevel() {
        
        
        pacman_x = 7 * BLOCK_SIZE;
        pacman_y = 11 * BLOCK_SIZE;
        pacmand_x = 0;
        pacmand_y = 0;
        req_dx = 0;
        req_dy = 0;
        view_dx = 0;
        view_dy = 1;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, d.width, d.height);

        drawMaze(g2d);
        
        doAnim();
        
        playGame(g2d);
    }
    
    protected void doAnim() {

        pacAnimCount--;

        if (pacAnimCount <= 0) {
            pacAnimCount = PAC_ANIM_DELAY;
            pacmanAnimPos = pacmanAnimPos + pacAnimDir;

            if (pacmanAnimPos == (PACMAN_ANIM_COUNT - 1) || pacmanAnimPos == 0) {
                pacAnimDir = -pacAnimDir;
            }
        }
    }
    
    void drawMaze(Graphics2D g2d) {
        short i = 0;
        int x, y;

        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                g2d.setColor(mazeColor);
                g2d.setStroke(new BasicStroke(4));

                if ((screenData[i] & 1) != 0) { 
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 2) != 0) { 
                    g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                }

                if ((screenData[i] & 4) != 0) { 
                    g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 8) != 0) { 
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 16) != 0) { 
                    g2d.setColor(dotColor);
                    g2d.fillRect(x + 11, y + 11, 2, 2);
                }
                i++;
            }
        }
    }

    private void playGame(Graphics2D g2d) {
        pacman.movePacman();
        pacman.drawPacman(g2d);
    }
}
