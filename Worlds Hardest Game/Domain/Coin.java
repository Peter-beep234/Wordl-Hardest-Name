package Domain;

public class Coin extends Entity {
    private boolean collected;
    public Coin(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.collected = false;
    }
    public boolean isCollected() {
        return collected;
    }
    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
