package Domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Level> levels = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private int currentLevelIndex;

    public void addPlayer(Player p) {
        players.add(p);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public void loadLevel(Level level) {
        levels.clear();
        levels.add(level);
        currentLevelIndex = 0;
    }

    public void startLevel(int index) throws HardestGameException {

        if (levels.isEmpty()) {
            throw new HardestGameException(HardestGameException.LEVEL_NOT_FOUND);
        }

        if (index < 0 || index >= levels.size()) {
            throw new HardestGameException(HardestGameException.LEVEL_NOT_FOUND);
        }

        currentLevelIndex = index;

        Level l = levels.get(currentLevelIndex);

        for (Player p : players) {
            p.setRespawnPoint(l.getStartX(), l.getStartY());
            p.respawn();
        }
    }

    public void update(double dt) {
        if (levels.isEmpty()) return;

        Level l = levels.get(currentLevelIndex);
        l.update(players);
    }
}