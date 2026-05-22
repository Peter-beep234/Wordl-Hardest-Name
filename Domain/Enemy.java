package Domain;


public abstract class Enemy extends MovableEntity {
    public static final double DEFAULT_SIZE = 15.0;
    public Enemy(double x, double y, double speed) {
        super(x, y, DEFAULT_SIZE, DEFAULT_SIZE, speed);
    }
    
    public abstract void updateMovement(double boardWidth, double boardHeight);
}