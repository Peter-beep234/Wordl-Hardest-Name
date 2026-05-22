package Domain;

public abstract class MovableEntity extends Entity {
    protected double speed;
    protected double dx;
    protected double dy;
    public MovableEntity(double x, double y, double width, double height, double speed) {
        super(x, y, width, height);
        this.speed = speed;
        this.dx = 0;
        this.dy = 0;
    }
    public void setDirection(Direction dir) {
        dx = 0; 
        dy = 0;
        if (dir == null) {
            return;
        }
        
        switch (dir) {
            case NORTH: 
                dy = -speed; 
                break;
            case SOUTH: 
                dy = speed; 
                break;
            case EAST:  
                dx = speed; 
                break;
            case WEST:  
                dx = -speed; 
                break;
        }
    }
    
    public void stop() {
        dx = 0;
        dy = 0;
    }
    public void move() {
        this.x += dx;
        this.y += dy;
    }
    public void undoMove() {
        this.x -= dx;
        this.y -= dy;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}