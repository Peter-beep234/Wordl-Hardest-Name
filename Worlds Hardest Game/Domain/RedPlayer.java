package Domain;

public class RedPlayer extends Player {
    public static final double DEFAULT_SIZE = 30.0;
    public static final double DEFAULT_SPEED = 2.0;
    public RedPlayer(String name, double x, double y) {
        super(name, x, y, DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SPEED);
    }
}