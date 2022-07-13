/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author hadys
 */
public class Pacman {
    
    PacmanGame Game;
    
    
    protected final int PACMAN_SPEED = 6;
    protected Image pacman1, pacman2up, pacman2left, pacman2right, pacman2down;
    protected Image pacman3up, pacman3down, pacman3left, pacman3right;
    protected Image pacman4up, pacman4down, pacman4left, pacman4right;

    public Pacman() {
        loadImages();
    }
    
    
    

    
    private void loadImages() {

        pacman1 = new ImageIcon("src/res/pacman_0_0.png").getImage();
        pacman2up = new ImageIcon("src/res/pacman_3_1.png").getImage();
        pacman3up = new ImageIcon("src/res/pacman_3_2.png").getImage();
        pacman4up = new ImageIcon("src/res/pacman_3_3.png").getImage();
        pacman2down = new ImageIcon("src/res/pacman_1_1.png").getImage();
        pacman3down = new ImageIcon("src/res/pacman_1_2.png").getImage();
        pacman4down = new ImageIcon("src/res/pacman_1_3.png").getImage();
        pacman2left = new ImageIcon("src/res/pacman_2_1.png").getImage();
        pacman3left = new ImageIcon("src/res/pacman_2_2.png").getImage();
        pacman4left = new ImageIcon("src/res/pacman_2_3.png").getImage();
        pacman2right = new ImageIcon("src/res/pacman_0_1.png").getImage();
        pacman3right = new ImageIcon("src/res/pacman_0_2.png").getImage();
        pacman4right = new ImageIcon("src/res/pacman_0_3.png").getImage();

    }
    
    

    protected void movePacman() {
        
        int pos;
        short ch;
        
        System.out.println(Game.req_dx);
        
        if (Game.req_dx == -Game.pacmand_x && Game.req_dy == -Game.pacmand_y) {
            Game.pacmand_x = Game.req_dx;
            Game.pacmand_y = Game.req_dy;
            Game.view_dx = Game.pacmand_x;
            Game.view_dy = Game.pacmand_y;
        }

        if (Game.pacman_x % Game.BLOCK_SIZE == 0 && Game.pacman_y % Game.BLOCK_SIZE == 0) {
            pos = Game.pacman_x / Game.BLOCK_SIZE + Game.N_BLOCKS * (int) (Game.pacman_y / Game.BLOCK_SIZE);
            ch = Game.screenData[pos];

            if ((ch & 16) != 0) {
                Game.screenData[pos] = (short) (ch & 15);
                //score++;
            }

            if (Game.req_dx != 0 || Game.req_dy != 0) {
                if (!((Game.req_dx == -1 && Game.req_dy == 0 && (ch & 1) != 0)
                        || (Game.req_dx == 1 && Game.req_dy == 0 && (ch & 4) != 0)
                        || (Game.req_dx == 0 && Game.req_dy == -1 && (ch & 2) != 0)
                        || (Game.req_dx == 0 && Game.req_dy == 1 && (ch & 8) != 0))) {
                    Game.pacmand_x = Game.req_dx;
                    Game.pacmand_y = Game.req_dy;
                    Game.view_dx = Game.pacmand_x;
                    Game.view_dy = Game.pacmand_y;
                }
            }

            // Check for standstill
            if ((Game.pacmand_x == -1 && Game.pacmand_y == 0 && (ch & 1) != 0)
                    || (Game.pacmand_x == 1 && Game.pacmand_y == 0 && (ch & 4) != 0)
                    || (Game.pacmand_x == 0 && Game.pacmand_y == -1 && (ch & 2) != 0)
                    || (Game.pacmand_x == 0 && Game.pacmand_y == 1 && (ch & 8) != 0)) {
                Game.pacmand_x = 0;
                Game.pacmand_y = 0;
            }
        }
        Game.pacman_x = Game.pacman_x + PACMAN_SPEED * Game.pacmand_x;
        Game.pacman_y = Game.pacman_y + PACMAN_SPEED * Game.pacmand_y;
    }

    protected void drawPacman(Graphics2D g2d) {

        if (Game.view_dx == -1) {
            drawPacnanLeft(g2d);
        } else if (Game.view_dx == 1) {
            drawPacmanRight(g2d);
        } else if (Game.view_dy == -1) {
            drawPacmanUp(g2d);
        } else {
            drawPacmanDown(g2d);
        }
    }

    private void drawPacmanUp(Graphics2D g2d) {

        switch (Game.pacmanAnimPos) {
            case 1:
                g2d.drawImage(pacman2up, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            case 2:
                g2d.drawImage(pacman3up, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            case 3:
                g2d.drawImage(pacman4up, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            default:
                g2d.drawImage(pacman1, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
        }
    }

    private void drawPacmanDown(Graphics2D g2d) {

        switch (Game.pacmanAnimPos) {
            case 1:
                g2d.drawImage(pacman2down, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            case 2:
                g2d.drawImage(pacman3down, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            case 3:
                g2d.drawImage(pacman4down, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            default:
                g2d.drawImage(pacman1, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
        }
    }

    private void drawPacnanLeft(Graphics2D g2d) {

        switch (Game.pacmanAnimPos) {
            case 1:
                g2d.drawImage(pacman2left, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            case 2:
                g2d.drawImage(pacman3left, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            case 3:
                g2d.drawImage(pacman4left, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            default:
                g2d.drawImage(pacman1, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
        }
    }

    private void drawPacmanRight(Graphics2D g2d) {

        switch (Game.pacmanAnimPos) {
            case 1:
                g2d.drawImage(pacman2right, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            case 2:
                g2d.drawImage(pacman3right, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            case 3:
                g2d.drawImage(pacman4right, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
            default:
                g2d.drawImage(pacman1, Game.pacman_x + 1, Game.pacman_y + 1, Game);
                break;
        }
    }

    
    
}
