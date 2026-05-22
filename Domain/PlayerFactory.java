package Domain;

public class PlayerFactory {

    public static Player create(CharacterType type) {

        return switch (type) {
            case BLUE -> new BluePlayer("Blue", 100, 100);
            case RED -> new RedPlayer("Red", 100, 100);
            case GREEN -> new GreenPlayer("Green", 100, 100);
        };
    }
}