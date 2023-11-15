package newchess.data;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    @Test
    @DisplayName("genereates the correct Koordinates for needToBeEmpty Koordinates for a straight move with no movement on the x axis")
    public void testNeedToBeEmptyStraightX() {
        Move move = new Move(new Koordinates(3, 4), new Koordinates(3, 7));
        List<Koordinates> actual = move.getNeedToBeEmpty();
        List<Koordinates> expected = List.of(new Koordinates(3, 5), new Koordinates(3, 6));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("genereates the correct Koordinates for needToBeEmpty Koordinates for a straight move with no movement on the y axis")
    public void testNeedToBeEmptyStraightY() {
        Move move = new Move(new Koordinates(1, 4), new Koordinates(7, 4));
        List<Koordinates> actual = move.getNeedToBeEmpty();
        List<Koordinates> expected = List.of(new Koordinates(2, 4), new Koordinates(3, 4), new Koordinates(4, 4), new Koordinates(5, 4), new Koordinates(6, 4));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("genereates the correct Koordinates for needToBeEmpty Koordinates for a diagonal move with no delta difference")
    public void testNeedToBeEmptyDiagonalWithoutDifference() {
        Move move = new Move(new Koordinates(1, 1), new Koordinates(3, 3));
        List<Koordinates> actual = move.getNeedToBeEmpty();
        List<Koordinates> expected = List.of(new Koordinates(2, 2));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("genereates the correct Koordinates for needToBeEmpty Koordinates for a diagonal move with a delta difference")
    public void testNeedToBeEmptyDiagonalWithDeltaDifference() {
        Move move = new Move(new Koordinates(4, 3), new Koordinates(1, 6));
        List<Koordinates> actual = move.getNeedToBeEmpty();
        List<Koordinates> expected = new ArrayList<>(List.of(new Koordinates(3, 4), new Koordinates(2, 5)));
        for(Koordinates koordinates : expected) {
            assertTrue(actual.contains(koordinates));
        }
    }
}