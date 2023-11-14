package newchess.data;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

public class InputDataTest extends TestCase {

    @DisplayName("should declare right input as valid")
    public void testIsMoveValid() {
        assertTrue(InputData.isMoveValid("A1", "A2"));
        assertTrue(InputData.isMoveValid("E2", "E4"));
    }

    @DisplayName("should declare wrong input as invalid")
    public void testIsMoveInvalid() {
        assertFalse(InputData.isMoveValid("K1", "A3"));
    }

    @DisplayName("letter input should not me case-insensitive")
    public void testIsCastlingValid() {
        assertTrue(InputData.isMoveValid("e1", "e2"));
    }

    @DisplayName("move is correctly parsed from input")
    public void testGetMove() {
        assertEquals(new Move(new Koordinates(4, 6), new Koordinates(4, 4)), InputData.getMove("E2", "E4"));
    }
}