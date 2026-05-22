package Domain;

public class SafeZone extends Entity {
    private boolean isFinalZone;
    public SafeZone(double x, double y, double width, double height, boolean isFinalZone) {
        super(x, y, width, height);
        this.isFinalZone = isFinalZone;
    }
    public boolean isFinalZone() {
        return isFinalZone;
    }
}
