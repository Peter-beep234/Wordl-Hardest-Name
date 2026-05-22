package Presentaion;


public class GameConfig {
    
    public static final int BASE_WIDTH = 900;
    public static final int BASE_HEIGHT = 700;
    
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 900;
    
    public static double scaleX() {
        return (double) WIDTH / BASE_WIDTH;
    }
    
    public static double scaleY() {
        return (double) HEIGHT / BASE_HEIGHT;
    }
}