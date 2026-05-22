package Domain;

import java.util.List;

public class GameStateManager {

    public enum Screen {
        MENU,
        LEVEL_SELECT,
        PLAYING
    }

    public enum GameDifficulty {
        EASY,
        MEDIUM,
        HARD
    }

    private Screen screen = Screen.MENU;
    private GameDifficulty selectedDifficulty = GameDifficulty.EASY;

    private final Game game;
    private Level currentLevel;
    private Player selectedPlayer;
    private GameMode selectedMode;
    
    public enum GameMode {
        CLASSIC,
        TIME_ATTACK,
        SURVIVAL,
        PACIFIST
    }
    
    public Player getSelectedPlayer() {
        return selectedPlayer;
    }
    
    public GameMode getSelectedMode() {
        return selectedMode;
    }
    
    public void selectPlayer(Player player) {
        selectedPlayer = player;
    }
    
    public void selectGameMode(GameMode mode) {
        selectedMode = mode;
    }
    public GameStateManager(Game game) {
        this.game = game;
    }

    public Screen getScreen() {
        return screen;
    }

    public GameDifficulty getSelectedDifficulty() {
        return selectedDifficulty;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public List<Player> getPlayers() {
        return game.getPlayers();
    }

    public void clickPlay() {
        screen = Screen.LEVEL_SELECT;
    }

    public void goToMenu() {
        screen = Screen.MENU;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.selectedDifficulty = difficulty;
    }

    public void selectLevel(int levelIndex) {
        currentLevel = LevelFactory.create(levelIndex);

        if (currentLevel == null) {
            throw new IllegalStateException("LevelFactory returned null");
        }

        for (Player p : getPlayers()) {
            p.setRespawnPoint(currentLevel.getStartX(), currentLevel.getStartY());
            p.respawn();
        }

        screen = Screen.PLAYING;
    }

    public void update(double dt) {
        if (screen != Screen.PLAYING || currentLevel == null) return;

        currentLevel.update(getPlayers());
    }
}