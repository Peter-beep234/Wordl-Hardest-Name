package Presentaion;

import Domain.*;
import java.awt.*;

public class Renderer {

    private static final int WIDTH = GameConfig.WIDTH;
    private static final int HEIGHT = GameConfig.HEIGHT;

    private static Rectangle playArea;
    private static Rectangle loadArea;
    private static Rectangle scoreArea;

    public static boolean isPlayClicked(int x, int y) {
        return playArea != null && playArea.contains(x, y);
    }

    public static boolean isLoadClicked(int x, int y) {
        return loadArea != null && loadArea.contains(x, y);
    }

    public static boolean isScoreClicked(int x, int y) {
        return scoreArea != null && scoreArea.contains(x, y);
    }

    private static void drawMenu(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        int centerX = WIDTH / 2 + 40;

        playArea = new Rectangle(centerX - 150, 320, 300, 90);
        loadArea = new Rectangle(centerX - 150, 430, 300, 90);
        scoreArea = new Rectangle(centerX - 150, 540, 300, 90);

        g.drawImage(SpriteLoader.load("Titulo.png"),
                centerX - 350, 60, 700, 240, null);

        g.drawImage(SpriteLoader.load("jugar.png"),
                playArea.x, playArea.y, playArea.width, playArea.height, null);

        g.drawImage(SpriteLoader.load("cargar.png"),
                loadArea.x, loadArea.y, loadArea.width, loadArea.height, null);

        g.drawImage(SpriteLoader.load("score.png"),
                scoreArea.x, scoreArea.y, scoreArea.width, scoreArea.height, null);
    }

    private static void drawLevelSelect(Graphics g, GameStateManager gsm) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        int centerX = WIDTH / 2 + 40;

        g.drawImage(SpriteLoader.load("selectlevel.png"),
                centerX - 250, 40, 500, 140, null);

        g.drawImage(SpriteLoader.load("level1.png"),
                centerX - 380, 220, 220, 140, null);

        g.drawImage(SpriteLoader.load("level2.png"),
                centerX - 110, 220, 220, 140, null);

        g.drawImage(SpriteLoader.load("level3.png"),
                centerX + 160, 220, 220, 140, null);

        g.drawImage(SpriteLoader.load("dificultad.png"),
                centerX - 250, 450, 500, 120, null);

        GameStateManager.GameDifficulty d = gsm.getSelectedDifficulty();

        g.drawImage(SpriteLoader.load(
                d == GameStateManager.GameDifficulty.EASY ? "facilS.png" : "facil.png"
        ), centerX - 300, 600, 200, 110, null);

        g.drawImage(SpriteLoader.load(
                d == GameStateManager.GameDifficulty.MEDIUM ? "medioS.png" : "medio.png"
        ), centerX - 100, 600, 200, 110, null);

        g.drawImage(SpriteLoader.load(
                d == GameStateManager.GameDifficulty.HARD ? "dificilS.png" : "dificil.png"
        ), centerX + 100, 600, 200, 110, null);
    }

    private static void drawPlaying(Graphics g, GameStateManager gsm) {

        Level level = gsm.getCurrentLevel();
        if (level == null) return;

        Image bg = SpriteLoader.load("fondo.png");

        double scaleX = (double) WIDTH / bg.getWidth(null);
        double scaleY = (double) HEIGHT / bg.getHeight(null);
        double scale = Math.max(scaleX, scaleY);

        int newW = (int) (bg.getWidth(null) * scale);
        int newH = (int) (bg.getHeight(null) * scale);

        int x = (WIDTH - newW) / 2;
        int y = (HEIGHT - newH) / 2;

        g.drawImage(bg, x, y, newW, newH, null);

        for (Wall w : level.getWalls()) {
            g.drawImage(SpriteLoader.load("wall.png"),
                    (int) w.getX(), (int) w.getY(),
                    (int) w.getWidth(), (int) w.getHeight(), null);
        }

        for (Coin c : level.getCoins()) {
            if (!c.isCollected()) {
                g.drawImage(SpriteLoader.load("Coin.png"),
                        (int) c.getX(), (int) c.getY(),
                        (int) c.getWidth(), (int) c.getHeight(), null);
            }
        }

        for (Enemy e : level.getEnemies()) {
            g.drawImage(SpriteLoader.load("enemy.png"),
                    (int) e.getX(), (int) e.getY(),
                    (int) e.getWidth(), (int) e.getHeight(), null);
        }

        for (Player p : gsm.getPlayers()) {
            String img = "BluePlayer.png";
            if (p instanceof RedPlayer) img = "RedPlayer.png";
            if (p instanceof GreenPlayer) img = "GreenPlayer.png";

            g.drawImage(SpriteLoader.load(img),
                    (int) p.getX(), (int) p.getY(),
                    (int) p.getWidth(), (int) p.getHeight(), null);
        }
    }

    public static void drawGame(Graphics g, GameStateManager gsm) {
        switch (gsm.getScreen()) {
            case MENU -> drawMenu(g);
            case LEVEL_SELECT -> drawLevelSelect(g, gsm);
            case PLAYING -> drawPlaying(g, gsm);
        }
    }
}