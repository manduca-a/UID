package application.model;

import application.Settings;

public class Game {

    private final World world = new World();

    private Game() {
    }

    private static final Game instance = new Game();

    public static Game getInstance() {
        return instance;
    }

    private int collectedCoins = 0;

    public void move(int direction) {
        int x = world.getPacmanPositionX();
        int y = world.getPacmanPositionY();
        switch (direction) {
            case Settings.MOVE_LEFT -> x = (world.getSize()+x-1) % world.getSize();
            case Settings.MOVE_RIGHT -> x = (x+1) % world.getSize();
            case Settings.MOVE_UP -> y = (world.getSize()+y-1) % world.getSize();
            case Settings.MOVE_DOWN -> y = (y+1) % world.getSize();
            default -> { return; }
        }
        if(world.isCoin(x, y))
            collectedCoins++;
        world.movePacman(x, y);
    }

    public World getWorld() {
        return world;
    }
}
