package newchess.pieces;

import newchess.data.Color;
import newchess.data.Koordinates;
import newchess.data.MoveType;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {

    @Test
    @DisplayName("Test Rook constructor")
    public void testRookConstructor() {
        Rook rook = new Rook(Color.WHITE);
        assertEquals(Color.WHITE, rook.getColor());
        assertEquals("Rook", rook.name);
        assertEquals("T", rook.symbol);
        assertEquals(MoveType.STRAIGHT, rook.moveType);
    }

    @Test
    @DisplayName("Test Rook getMoves method")
    public void testRookMove() {
        Rook pawn = new Rook(Color.WHITE);
        List<Koordinates> moves = pawn.possibleMoves(new Koordinates(6, 4));
        assertEquals(14, moves.size());
        List<Koordinates> expectedMoves = List.of(
            new Koordinates(6, 0),
            new Koordinates(6, 1),
            new Koordinates(6, 2),
            new Koordinates(6, 3),
            new Koordinates(6, 5),
            new Koordinates(6, 6),
            new Koordinates(6, 7),
            new Koordinates(0, 4),
            new Koordinates(1, 4),
            new Koordinates(2, 4),
            new Koordinates(3, 4),
            new Koordinates(4, 4),
            new Koordinates(5, 4),
            new Koordinates(7, 4)
        );
        for(Koordinates koordinates : expectedMoves) {
            assertTrue(moves.contains(koordinates));
        }
    }
}