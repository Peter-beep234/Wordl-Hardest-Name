package Domain;

public class FastEnemy extends Enemy {
    public static final double FAST_SPEED = 4.0;
    public FastEnemy(double x, double y, Direction initialDir) {
        super(x, y, FAST_SPEED);
        setDirection(initialDir);
    }
    @Override
    public void updateMovement(double boardWidth, double boardHeight) {
        move();
        if (x <= 0 || x + width >= boardWidth) {
            dx = -dx;
        }
        
        if (y <= 0 || y + height >= boardHeight) {
            dy = -dy;
        }
    }
    
    public void bounce() {
        dx = -dx;
        dy = -dy;
    }
}
