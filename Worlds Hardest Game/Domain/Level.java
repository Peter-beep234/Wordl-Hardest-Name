package Domain;

import java.util.ArrayList;
import java.util.List;
public class Level {
    private List<Wall> walls = new ArrayList<>();
    private List<Coin> coins = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    private List<SafeZone> safeZones = new ArrayList<>();
    
    private double startX, startY, width, height;
    private int totalCoins = 0;
    public List<Enemy> getEnemies() {
        return enemies;
    }
    public List<SafeZone> getSafeZones() {
        return safeZones;
    }
    public List<Coin> getCoins() {
        return coins;
    }
    public List<Wall> getWalls() {
        return walls;
    }
    public Level(double width, double height, double startX, double startY) {
        this.width = width; 
        this.height = height;
        this.startX = startX; 
        this.startY = startY;
    }
    public void addWall(Wall w) {
        walls.add(w);
    }
    public void addCoin(Coin c) {
        coins.add(c);
        totalCoins++;
    }
    public void addEnemy(Enemy e) {
        enemies.add(e);
    }
    public void addSafeZone(SafeZone s) {
        safeZones.add(s);
    }
    public double getStartX() {
        return startX;
    }
    public double getStartY() {
        return startY;
    }
    public int getTotalCoins() {
        return totalCoins;
    }
    public void update(List<Player> players) {
        for (Enemy e : enemies) {
            e.updateMovement(width, height);
            for (Wall w : walls) {
                if (e.collidesWith(w)) {
                    if (e instanceof BasicEnemy) {
                        ((BasicEnemy) e).bounce();
                    } else if (e instanceof FastEnemy) {
                        ((FastEnemy) e).bounce();
                    }
                }
            }
        }
        for (Player p : players) {
            if (!p.isAlive()) {
                continue;
            }
            
            p.move();
            
            for (Wall w : walls) {
                if (p.collidesWith(w)) {
                    p.undoMove();
                }
            }
            
            if (p.getX() < 0 || p.getX() + p.getWidth() > width || 
                p.getY() < 0 || p.getY() + p.getHeight() > height) {
                p.undoMove();
            }
            for (Coin c : coins) {
                if (!c.isCollected() && p.collidesWith(c)) {
                    c.setCollected(true);
                }
            }
            for (Enemy e : enemies) {
                if (p.collidesWith(e)) {
                    if (p.takeDamage()) {
                        resetCoins();
                        p.respawn();
                    }
                    break; 
                }
            }
            
            for (SafeZone sz : safeZones) {
                if (p.collidesWith(sz)) {
                    if (!sz.isFinalZone()) {
                        p.setRespawnPoint(sz.getX(), sz.getY());
                    }
                }
            }
        }
    }
    
    public boolean allCoinsCollected() {
        for (Coin c : coins) {
            if (!c.isCollected()) {
                return false;
            }
        }
        return true;
    }
    
    public void resetCoins() {
        for (Coin c : coins) {
            c.setCollected(false);
        }
    }
}
