package Domain;

public class BluePlayer extends Player {
    public static final double BIG_SIZE = 40.0;
    public static final double FAST_SPEED = 3.0;
    public BluePlayer(String name, double x, double y) {
        super(name, x, y, BIG_SIZE, BIG_SIZE, FAST_SPEED);
    }
}
