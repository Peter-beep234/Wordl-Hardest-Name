package Domain;

public class HardestGameException extends Exception {
    
    public static final String LEVEL_NOT_FOUND = "El nivel solicitado no existe.";
    public static final String INVALID_MOVEMENT = "Movimiento inválido.";
    public static final String GAME_OVER = "El juego ha terminado.";
    
    public HardestGameException(String message) {
        super(message);
    }
}
