package Domain;

public class LevelFactory {

    public static Level create(int level) {

        return switch (level) {
            case 0 -> level1();
            case 1 -> level2();
            case 2 -> level3();
            default -> level1();
        };
    }

    private static Level level1() {

        Level level = new Level(800, 600, 100, 100);

        buildSquareWalls(level);
        addCenterCoins(level);
        addVerticalEnemies(level);

        return level;
    }

    private static void buildSquareWalls(Level level) {
        level.addWall(new Wall(200, 150, 400, 20)); 
        level.addWall(new Wall(200, 430, 400, 20)); 
        level.addWall(new Wall(200, 150, 20, 300)); 
        level.addWall(new Wall(580, 150, 20, 300)); 
    }

    private static void addCenterCoins(Level level) {
        level.addCoin(new Coin(380, 260, 20, 20));
        level.addCoin(new Coin(420, 260, 20, 20));
        level.addCoin(new Coin(380, 300, 20, 20));
        level.addCoin(new Coin(420, 300, 20, 20));
    }

    private static void addVerticalEnemies(Level level) {
        for (int i = 0; i < 4; i++) {
            FastEnemy e = new FastEnemy(240 + (i * 80), 170, Direction.SOUTH);
            level.addEnemy(e);
        }
    }

    private static Level level2() {

        Level level = new Level(1000, 700, 50, 50);

        for (int i = 0; i < 5; i++) {
            level.addWall(new Wall(150 + i * 150, 150, 20, 400));
        }
        for (int i = 0; i < 4; i++) {
            level.addWall(new Wall(150, 200 + i * 100, 600, 20));
        }

        level.addCoin(new Coin(850, 180, 25, 25));
        level.addCoin(new Coin(850, 450, 25, 25));
        level.addCoin(new Coin(850, 650, 25, 25));

        for (int i = 0; i < 3; i++) {
            FastEnemy e = new FastEnemy(250 + (i * 200), 180, Direction.SOUTH);
            level.addEnemy(e);
        }
        for (int i = 0; i < 3; i++) {
            FastEnemy e = new FastEnemy(150, 220 + (i * 150), Direction.EAST);
            level.addEnemy(e);
        }

        return level;
    }

    private static Level level3() {

        Level level = new Level(1200, 900, 50, 800);

        for (int i = 0; i < 6; i++) {
            level.addWall(new Wall(200 + i * 150, 100, 20, 600));
        }
        for (int i = 0; i < 5; i++) {
            level.addWall(new Wall(200, 200 + i * 120, 700, 20));
        }
        for (int i = 0; i < 10; i++) {
            level.addWall(new Wall(500, 100 + i * 70, 20, 500));
        }

        level.addCoin(new Coin(1100, 100, 25, 25));
        level.addCoin(new Coin(1100, 400, 25, 25));
        level.addCoin(new Coin(1100, 700, 25, 25));

        for (int i = 0; i < 4; i++) {
            FastEnemy e = new FastEnemy(250 + (i * 200), 120, Direction.SOUTH);
            level.addEnemy(e);
        }
        for (int i = 0; i < 4; i++) {
            FastEnemy e = new FastEnemy(150, 220 + (i * 150), Direction.EAST);
            level.addEnemy(e);
        }

        return level;
    }
}