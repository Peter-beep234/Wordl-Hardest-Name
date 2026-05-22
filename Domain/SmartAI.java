package Domain;

public class SmartAI extends AIPlayer {

    public SmartAI(String name, double x, double y) {
        super(name, x, y, 30, 30, 2.5);
    }

    public void updateAI(Level level, Player target) {

        if (target.getX() < x) setDirection(Direction.WEST);
        else setDirection(Direction.EAST);

        if (target.getY() < y) setDirection(Direction.NORTH);
        else setDirection(Direction.SOUTH);

        move();
    }
}