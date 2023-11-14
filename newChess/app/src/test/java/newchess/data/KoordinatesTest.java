package newchess.data;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class KoordinatesTest {

    @Test
    @DisplayName("test koordinates equals")
    public void testKoordinatesEquals() {
        assertEquals(new Koordinates(3, 4), new Koordinates(3, 4));
    }

    @Test
    @DisplayName("test koordinates not equals")
    public void testKoordinatesNotEquals() {
        assertNotEquals(new Koordinates(3, 4), new Koordinates(3, 5));
    }

    @Test
    @DisplayName("should correctly filter koordinates")
    public void shouldCorrectlyFilterKoordinates() {
        List<Koordinates> expected = List.of(
                new Koordinates(1, 2),
                new Koordinates(2, 3),
                new Koordinates(3, 4),
                new Koordinates(4, 5),
                new Koordinates(5, 6),
                new Koordinates(6, 7)
        );

        List<Koordinates> input = List.of(
                new Koordinates(-1,2),
                new Koordinates(1, 2),
                new Koordinates(2, 3),
                new Koordinates(3, 4),
                new Koordinates(4, 5),
                new Koordinates(5, 6),
                new Koordinates(6, 7),
                new Koordinates(7, 8)
        );

        assertEquals(expected, Koordinates.filterKoordinates(input));
    }
}