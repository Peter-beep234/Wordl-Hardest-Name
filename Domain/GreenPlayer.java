package Domain;


public class GreenPlayer extends Player {
    public static final double DEFAULT_SIZE = 30.0;
    public static final double DEFAULT_SPEED = 2.0;
    private boolean hasShield;
    public GreenPlayer(String name, double x, double y) {
        super(name, x, y, DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SPEED);
        this.hasShield = true;
    }
    @Override
    public boolean takeDamage() {
        if (hasShield) {
            hasShield = false;
            this.speed = DEFAULT_SPEED * 0.7; 
            return false; // No muere
        } else {
            die();
            return true; // Muere
        }
    }
    
    @Override
    public void resetAbilities() {
        this.hasShield = true;
        this.speed = DEFAULT_SPEED; 
    }
    
    public boolean hasShield() {
        return hasShield;
    }
}