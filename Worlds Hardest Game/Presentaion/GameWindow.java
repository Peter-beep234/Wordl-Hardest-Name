package Presentaion;

import Domain.*;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(GameStateManager gsm) {

        setTitle("Hardest Game");

        GamePanel panel = new GamePanel(gsm);

        add(panel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);

        pack();

        setLocationRelativeTo(null);

        setVisible(true);

        panel.requestFocusInWindow();
    }

    public static void main(String[] args) {

        Game game = new Game();

        GameStateManager gsm = new GameStateManager(game);

        new GameWindow(gsm);
    }
}