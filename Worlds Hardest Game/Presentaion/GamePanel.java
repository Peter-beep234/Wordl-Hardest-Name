package Presentaion;

import Domain.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private final GameStateManager gsm;
    private final InputHandler input;

    private Thread gameThread;

    private static final int FPS = 60;
    private static final double DT = 1.0 / FPS;

    public GamePanel(GameStateManager gsm) {

        this.gsm = gsm;
        this.input = new InputHandler(gsm);

        setPreferredSize(new Dimension(GameConfig.WIDTH, GameConfig.HEIGHT));

        setFocusable(true);

        addKeyListener(input);
        addMouseListener(input);

        startGameLoop();
    }

    private void startGameLoop() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000.0 / FPS;

        long lastTime = System.nanoTime();

        while (true) {

            long currentTime = System.nanoTime();

            if (currentTime - lastTime >= drawInterval) {

                updateGame();

                repaint();

                lastTime = currentTime;
            }
        }
    }

    private void updateGame() {

        try {
            gsm.update(DT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Renderer.drawGame(g, gsm);
    }
}