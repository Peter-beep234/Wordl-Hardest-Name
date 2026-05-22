package Domain;

public class DumbAI extends AIPlayer {

    public DumbAI(String name, double x, double y) {
        super(name, x, y, 30, 30, 1.5);
    }

    public void updateAI(Level level, Player target) {
        double r = Math.random();

        if (r < 0.25) setDirection(Direction.NORTH);
        else if (r < 0.5) setDirection(Direction.SOUTH);
        else if (r < 0.75) setDirection(Direction.EAST);
        else setDirection(Direction.WEST);

        move();
    }
}