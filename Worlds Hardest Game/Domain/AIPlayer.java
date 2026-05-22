package Domain;

public abstract class AIPlayer extends Player {

    public AIPlayer(String name, double x, double y, double w, double h, double s) {
        super(name, x, y, w, h, s);
    }

    public abstract void updateAI(Level level, Player target);
}