package newchess.ui;

import newchess.data.Koordinates;
import newchess.data.Move;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class CommandLineInputParserTest {

    InputParser clui = new CommandLineInputParser();
    @Test
    @DisplayName("returns true when input format is correct")
    public void testInputFormat() {
        assertTrue(clui.isInputCorrect("A1 to B2"));
    }

    @Test
    @DisplayName("returns false when input format is incorrect")
    public void testInputFormatIncorrect() {
        assertFalse(clui.isInputCorrect("A1 to Ba2"));
    }

    @Test
    @DisplayName("retruns correct move when input format is correct")
    public void testParseInput() {
        Move move = clui.parseInput("A1 to B2");
        assertEquals(new Move(new Koordinates(0, 7), new Koordinates(1, 6)), move);
    }
}