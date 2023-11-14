package newchess.data;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class MoveTest {

    @Test
    @DisplayName("test move equals")
    public void testMoveEquals() {
        assertEquals(new Move(new Koordinates(3, 4), new Koordinates(3, 6)), new Move(new Koordinates(3, 4), new Koordinates(3, 6)));
    }

    @Test
    @DisplayName("test move not equals")
    public void testMoveNotEquals() {
        assertNotEquals(new Move(new Koordinates(3, 4), new Koordinates(3, 6)), new Move(new Koordinates(3, 4), new Koordinates(3, 5)));
    }
}