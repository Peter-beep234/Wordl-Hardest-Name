package Domain;


public class BasicEnemy extends Enemy {
    public static final double NORMAL_SPEED = 2.0;
    public BasicEnemy(double x, double y, Direction initialDir) {
        super(x, y, NORMAL_SPEED);
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
