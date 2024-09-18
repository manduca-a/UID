package application.model;

import application.Settings;

import java.util.Random;

public class World {

    enum Block { COIN, EMPTY, PACMAN, WALL}

    private final Block[][] world = new Block[Settings.WORLD_SIZE][Settings.WORLD_SIZE];
    private int pacmanPositionX = 0;
    private int pacmanPositionY = 0;

    World() {
        generateWorld();
    }

    int getPacmanPositionX() {
        return pacmanPositionX;
    }

    int getPacmanPositionY() {
        return pacmanPositionY;
    }

    public int getSize() {
        return world.length;
    }

    private void generateWorld() {
        Random random = new Random();
        for(int i = 0; i < world.length; i++) {
            for(int j = 0; j < world[i].length; j++) {
                int value = random.nextInt(100);                    //per generare interi casuali
                if(value <= 10)                         //  rarità di essere muro
                    world[i][j] = Block.WALL;
                else if(value <= 50)                    //  rarità di essere moneta
                    world[i][j] = Block.COIN;
                else                                    // altri casi spazio libero
                    world[i][j] = Block.EMPTY;
            }
        }
        world[pacmanPositionX][pacmanPositionY] = Block.PACMAN;
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < Settings.WORLD_SIZE && y >= 0 && y < Settings.WORLD_SIZE;
    }

    private boolean isType(int x, int y, Block b) {
        if(isValidPosition(x, y))
            return world[x][y] == b;
        return false;
    }

    void movePacman(int x, int y) {
        if(isValidPosition(x, y) && !isWall(x, y)) {
            world[pacmanPositionX][pacmanPositionY] = Block.EMPTY;
            pacmanPositionX = x;
            pacmanPositionY = y;
            world[x][y] = Block.PACMAN;
        }
    }

    public boolean isWall(int x, int y) {
        return isType(x, y, Block.WALL);
    }

    public boolean isCoin(int x, int y) {
        return isType(x, y, Block.COIN);
    }

    public boolean isPacman(int x, int y) {
        return isType(x, y, Block.PACMAN);
    }
}
