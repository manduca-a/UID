package application.view;

import application.Settings;
import application.model.Game;
import application.model.World;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PacmanView extends JPanel {

    private int direction = Settings.MOVE_RIGHT;        //Mette pacman girato a destra all'inizio
    private final Image[] images = new Image[4];            // crea un array di immagini per le direzioni di pacman
    public PacmanView() {               //costruttore
        setBackground(Color.BLACK);                         //  mette lo sfondo nero
        try {           //carica le immagini nell'array
            images[Settings.MOVE_LEFT] = ImageIO.read(getClass().getResourceAsStream("/application/resources/pacman_left.png"));
            images[Settings.MOVE_RIGHT] = ImageIO.read(getClass().getResourceAsStream("/application/resources/pacman_right.png"));
            images[Settings.MOVE_UP] = ImageIO.read(getClass().getResourceAsStream("/application/resources/pacman_up.png"));
            images[Settings.MOVE_DOWN] = ImageIO.read(getClass().getResourceAsStream("/application/resources/pacman_down.png"));
            for(int i = 0; i < 4; i++)
                images[i] = images[i].getScaledInstance(Settings.CELL_SIZE, Settings.CELL_SIZE, Image.SCALE_SMOOTH);        //  scala le immagini a seconda della dimensione settata
        } catch (IOException e) {
            System.exit(1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {     //quando si chiama repaint() viene qui
        super.paintComponent(g);
        World world = Game.getInstance().getWorld();        //collega il mondo al gioco
        for(int i = 0; i < world.getSize(); i++) {
            int x = i * Settings.CELL_SIZE;
            for(int j = 0; j < world.getSize(); j++) {
                int y = j * Settings.CELL_SIZE;
                if(world.isCoin(i, j)) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x + Settings.CELL_SIZE/4, y + Settings.CELL_SIZE/4, Settings.CELL_SIZE/2, Settings.CELL_SIZE/2); //crea un cerchio per la moneta
                }
                else if(world.isWall(i, j)) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, Settings.CELL_SIZE, Settings.CELL_SIZE);   //crea un rettangolo per il muro
                }
                else if(world.isPacman(i, j)) {
                    g.drawImage(images[direction], x, y, null);         //  mette l'immagine di pacman
                }
            }
        }
    }

    public void setDirection(int direction) {
        if(direction >= 0 && direction < images.length)
            this.direction = direction;
    }
}
