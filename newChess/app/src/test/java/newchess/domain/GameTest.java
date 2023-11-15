package newchess.domain;

import newchess.data.Color;
import newchess.data.Koordinates;
import newchess.pieces.Bishop;
import newchess.pieces.Pawn;
import newchess.pieces.Piece;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    @DisplayName("correctly identifies a piece that doesnt need freeway")
    public void correctlyIdentifiesAPieceThatDoesntNeedFreeway() {
        Piece piece = new Bishop(Color.WHITE);
        Game game = new Game();
        assertTrue(game.doesPieceMovingRequireFreeway(piece));
    }

    @Test
    @DisplayName("correctly identifies a piece that needs freeway")
    public void correctlyIdentifiesAPieceThatNeedsFreeway() {
        Piece piece = new Pawn(Color.WHITE);
        Game game = new Game();
        assertFalse(game.doesPieceMovingRequireFreeway(piece));
    }

    @Test
    @DisplayName("correctly identifies the piece of the player")
    public void correctlyIdentifiesThePieceOfThePlayer() {
        Game game = new Game();
        assertTrue(game.isMovingFigurePlayersFigure(new Koordinates(6, 4)));
    }

    @Test
    @DisplayName("correctly identifies that the piece is not of the turning player")
    public void correctlyIdentifiesThatThePieceIsNotOfTheTurningPlayer() {
        Game game = new Game();
        assertFalse(game.isMovingFigurePlayersFigure(new Koordinates(1, 4)));
    }

    @Test
    @DisplayName("retruns false is the piece is of neither player")
    public void retrunsFalseIsThePieceIsOfNeitherPlayer() {
        Game game = new Game();
        assertFalse(game.isMovingFigurePlayersFigure(new Koordinates(3, 4)));
    }
}