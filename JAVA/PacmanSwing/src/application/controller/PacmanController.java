package application.controller;

import application.Settings;
import application.model.Game;
import application.view.PacmanView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PacmanController extends KeyAdapter {
    private final PacmanView pacmanView;

    public PacmanController(PacmanView pacmanView) {
        this.pacmanView = pacmanView;
    }

    public void keyPressed(KeyEvent e) {
        int direction = switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> Settings.MOVE_LEFT;
            case KeyEvent.VK_RIGHT -> Settings.MOVE_RIGHT;
            case KeyEvent.VK_UP -> Settings.MOVE_UP;
            case KeyEvent.VK_DOWN -> Settings.MOVE_DOWN;
            case KeyEvent.VK_ESCAPE -> Settings.EXIT;
            default -> Settings.NOT_MOVING;
        };
        if(direction == Settings.EXIT) {
            System.exit(0);
        }
        if(direction != Settings.NOT_MOVING) {          //  se si preme un tasto entra qui
            Game.getInstance().move(direction);     //chiama game.move che chiama world.movePacman
            pacmanView.setDirection(direction);         //cambia l'immagine di pacman per ruotarlo
            pacmanView.repaint();               //"ricostruisce" il mondo
        }
    }

}
