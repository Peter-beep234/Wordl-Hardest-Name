package Domain;

import java.io.Serializable;
import java.awt.Rectangle;

public abstract class Entity implements Serializable {
    protected double x;
    protected double y;
    protected double width;
    protected double height;
    public Entity(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
    
    public boolean collidesWith(Entity other) {
        return this.getBounds().intersects(other.getBounds());
    }
}