package Domain;

public abstract class Player extends MovableEntity {
    protected String name;
    protected int deaths;
    protected double respawnX;
    protected double respawnY;
    protected boolean isAlive;
    public Player(String name, double x, double y, double width, double height, double speed) {
        super(x, y, width, height, speed);
        this.name = name;
        this.respawnX = x;
        this.respawnY = y;
        this.deaths = 0;
        this.isAlive = true;
    }
    public void setRespawnPoint(double x, double y) {
        this.respawnX = x; 
        this.respawnY = y;
    }
    public void die() {
        this.deaths++;
        this.isAlive = false;
    }
    
    public void respawn() {
        this.x = respawnX; 
        this.y = respawnY;
        this.isAlive = true;
        resetAbilities();
    }
    
    public void resetAbilities() {
        // Por defecto no hace nada
    }
    public boolean takeDamage() {
        die();
        return true; 
    }
    public int getDeaths() {
        return deaths;
    }
    public String getName() {
        return name;
    }
    public boolean isAlive() {
        return isAlive;
    }
}