package newchess.data;

import java.util.Map;

public class InputData {

    private static final Map<Character, Integer> vertical = Map.of(
            '1', 7,
            '2', 6,
            '3', 5,
            '4', 4,
            '5', 3,
            '6', 2,
            '7', 1,
            '8', 0
    );
    private static final Map<Character, Integer> horizontal = Map.of(
            'A', 0,
            'B', 1,
            'C', 2,
            'D', 3,
            'E', 4,
            'F', 5,
            'G', 6,
            'H', 7
    );

    public static boolean isMoveValid(String startTileString, String endTileString) {
        char letter1 = startTileString.toUpperCase().charAt(0);
        char number1 = startTileString.toUpperCase().charAt(1);
        char letter2 = endTileString.toUpperCase().charAt(0);
        char number2 = endTileString.toUpperCase().charAt(1);
        return horizontal.containsKey(letter1) && vertical.containsKey(number1) && horizontal.containsKey(letter2) && vertical.containsKey(number2);
    };

    public static Move getMove(String startTileString, String endTileString) {
        if(!isMoveValid(startTileString, endTileString)) {throw new IllegalArgumentException();}
        else {
            char letter1 = startTileString.toUpperCase().charAt(0);
            char number1 = startTileString.toUpperCase().charAt(1);
            char letter2 = endTileString.toUpperCase().charAt(0);
            char number2 = endTileString.toUpperCase().charAt(1);
            return new Move(new Koordinates(horizontal.get(letter1), vertical.get(number1)), new Koordinates(horizontal.get(letter2), vertical.get(number2)));
        }
    }
}
