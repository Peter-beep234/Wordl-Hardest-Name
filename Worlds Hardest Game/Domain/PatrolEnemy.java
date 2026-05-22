package Domain;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
public class PatrolEnemy extends Enemy {
    public static final double NORMAL_SPEED = 2.0;
    private List<Point> waypoints;
    private int currentWaypointIndex;
    public PatrolEnemy(double x, double y) {
        super(x, y, NORMAL_SPEED);
        this.waypoints = new ArrayList<>();
        this.currentWaypointIndex = 0;
    }
    
    public void addWaypoint(int px, int py) {
        waypoints.add(new Point(px, py));
    }
    @Override
    public void updateMovement(double boardWidth, double boardHeight) {
        if (waypoints.isEmpty()) {
            return;
        }
        
        Point target = waypoints.get(currentWaypointIndex);
        
        if (Math.abs(this.x - target.x) > speed) {
            this.x += (this.x < target.x) ? speed : -speed;
        } else {
            this.x = target.x;
        }
        
        if (Math.abs(this.y - target.y) > speed) {
            this.y += (this.y < target.y) ? speed : -speed;
        } else {
            this.y = target.y;
        }
        
        if (this.x == target.x && this.y == target.y) {
            currentWaypointIndex = (currentWaypointIndex + 1) % waypoints.size();
        }
    }
}