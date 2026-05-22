package Presentaion;

import Domain.*;
import java.awt.Rectangle;
import java.awt.event.*;
import java.util.List;

public class InputHandler implements KeyListener, MouseListener {

    private GameStateManager gsm;

    public InputHandler(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        GameStateManager.Screen screen = gsm.getScreen();

        if (screen == GameStateManager.Screen.LEVEL_SELECT) {

            int centerX = GameConfig.WIDTH / 2 + 40;

            Rectangle level1 = new Rectangle(centerX - 380, 220, 220, 140);
            Rectangle level2 = new Rectangle(centerX - 110, 220, 220, 140);
            Rectangle level3 = new Rectangle(centerX + 160, 220, 220, 140);

            Rectangle easy = new Rectangle(centerX - 300, 600, 200, 110);
            Rectangle medium = new Rectangle(centerX - 100, 600, 200, 110);
            Rectangle hard = new Rectangle(centerX + 100, 600, 200, 110);

            List<Player> players = gsm.getPlayers();

            if (level1.contains(x, y)) gsm.selectLevel(0);
            else if (level2.contains(x, y)) gsm.selectLevel(1);
            else if (level3.contains(x, y)) gsm.selectLevel(2);

            if (easy.contains(x, y)) gsm.setDifficulty(GameStateManager.GameDifficulty.EASY);
            else if (medium.contains(x, y)) gsm.setDifficulty(GameStateManager.GameDifficulty.MEDIUM);
            else if (hard.contains(x, y)) gsm.setDifficulty(GameStateManager.GameDifficulty.HARD);

            return;
        }

        if (screen == GameStateManager.Screen.MENU) {
            if (Renderer.isPlayClicked(x, y)) gsm.clickPlay();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        List<Player> players = gsm.getPlayers();
        if (players.isEmpty()) return;

        Player p = players.get(0);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> p.setDirection(Direction.NORTH);
            case KeyEvent.VK_S -> p.setDirection(Direction.SOUTH);
            case KeyEvent.VK_A -> p.setDirection(Direction.WEST);
            case KeyEvent.VK_D -> p.setDirection(Direction.EAST);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        List<Player> players = gsm.getPlayers();
        if (players.isEmpty()) return;

        players.get(0).stop();
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}