package newchess.pieces;

import newchess.data.Color;
import newchess.data.Koordinates;
import newchess.data.MoveType;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("Test Pawn constructor")
    public void testPawnConstructor() {
        Pawn pawn = new Pawn(Color.WHITE);
        assertEquals(Color.WHITE, pawn.getColor());
        assertEquals("Pawn", pawn.name);
        assertEquals("P", pawn.symbol);
        assertEquals(MoveType.JUICER, pawn.moveType);
    }

    @Test
    @DisplayName("Test Pawn getMoves method")
    public void testPawnMove() {
        Pawn pawn = new Pawn(Color.WHITE);
        List<Koordinates> moves = pawn.possibleMoves(new Koordinates(6, 4));
        assertEquals(4, moves.size());
        List<Koordinates> expectedMoves = List.of(new Koordinates(4, 4), new Koordinates(5, 4), new Koordinates(5, 3), new Koordinates(5, 5));
        for(Koordinates koordinates : expectedMoves) {
            assertTrue(moves.contains(koordinates));
        }
    }

    @Test
    @DisplayName("Test Pawn getMoves after already been moved")
    public void testPawnMoveAfterAlreadyMoved() {
        Pawn pawn = new Pawn(Color.WHITE);
        pawn.setMoved();
        List<Koordinates> moves = pawn.possibleMoves(new Koordinates(6, 4));
        assertEquals(3, moves.size());
        List<Koordinates> expectedMoves = List.of(new Koordinates(5, 4), new Koordinates(5, 3), new Koordinates(5, 5));
        for(Koordinates koordinates : expectedMoves) {
            assertTrue(moves.contains(koordinates));
        }
    }

    @Test
    @DisplayName("getMoves correctly fiters Koordinates that are out of bounds")
    public void testPawnToString() {
        Pawn pawn = new Pawn(Color.WHITE);
        List<Koordinates> moves = pawn.possibleMoves(new Koordinates(6, 0));
        assertEquals(3, moves.size());
        List<Koordinates> expectedMoves = List.of(new Koordinates(4, 0), new Koordinates(5, 0), new Koordinates(5, 1));
        for (Koordinates koordinates : expectedMoves) {
            assertTrue(moves.contains(koordinates));
        }
    }
}