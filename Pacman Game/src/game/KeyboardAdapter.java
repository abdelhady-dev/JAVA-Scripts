/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author hadys
 */
public class KeyboardAdapter implements KeyListener {
    PacmanGame Game;
    Pacman pacman;
    public KeyboardAdapter() {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (Game.inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    Game.req_dx = -1;
                    Game.req_dy = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    Game.req_dx = 1;
                    Game.req_dy = 0;
                } else if (key == KeyEvent.VK_UP) {
                    Game.req_dx = 0;
                    Game.req_dy = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    Game.req_dx = 0;
                    Game.req_dy = 1;
                } else if (key == KeyEvent.VK_ESCAPE && Game.timer.isRunning()) {
                    Game.inGame = false;
                } else if (key == KeyEvent.VK_PAUSE) {
                    if (Game.timer.isRunning()) {
                        Game.timer.stop();
                    } else {
                        Game.timer.start();
                    }
                }
            } else {
                if (key == 's' || key == 'S') {
                    Game.inGame = true;
                    Game.initGame();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == Event.LEFT || key == Event.RIGHT
                    || key == Event.UP || key == Event.DOWN) {
                Game.req_dx = 0;
                Game.req_dy = 0;
            }
        }
    
}
