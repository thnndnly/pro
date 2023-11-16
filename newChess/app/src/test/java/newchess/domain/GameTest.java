package newchess.domain;

import newchess.data.Color;
import newchess.data.Koordinates;
import newchess.data.Move;
import newchess.pieces.*;
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
    @DisplayName("returns false is the piece is of neither player")
    public void returnsFalseIsThePieceIsOfNeitherPlayer() {
        Game game = new Game();
        assertFalse(game.isMovingFigurePlayersFigure(new Koordinates(3, 4)));
    }

    @Test
    @DisplayName("does isPieceInWay return true if no is in the way for straight moves")
    public void trueIfFreewayStraight() {
        Game game = new Game();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                game.board[i][j] = new Tile(new NoPiece());
            }
        }
        game.board[6][0] = new Tile(new Rook(Color.WHITE));
        assertTrue(game.isFreeway(new Move(new Koordinates(6, 0), new Koordinates(6, 7))));
    }

    @Test
    @DisplayName("does isPieceInWay return false if a piece is in the way for straight moves")
    public void falseIfNoFreewayStraight() {
        Game game = new Game();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                game.board[i][j] = new Tile(new NoPiece());
            }
        }
        game.board[6][0] = new Tile(new Rook(Color.WHITE));
        game.board[6][4] = new Tile(new Rook(Color.WHITE));
        assertFalse(game.isFreeway(new Move(new Koordinates(6, 0), new Koordinates(6, 7))));
    }

    @Test
    @DisplayName("does isPieceInWay return true if no is in the way for diagonal moves")
    public void trueIfFreewayDiagonal() {
        Game game = new Game();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                game.board[i][j] = new Tile(new NoPiece());
            }
        }
        game.board[6][0] = new Tile(new Bishop(Color.WHITE));
        assertTrue(game.isFreeway(new Move(new Koordinates(6, 0), new Koordinates(3, 3))));
    }

    @Test
    @DisplayName("does isPieceInWay return true if no is in the way")
    public void falseIfNoFreewayDiagonal() {
        Game game = new Game();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                game.board[i][j] = new Tile(new NoPiece());
            }
        }
        game.board[6][0] = new Tile(new Bishop(Color.WHITE));
        game.board[4][2] = new Tile(new Bishop(Color.BLACK));
        assertFalse(game.isFreeway(new Move(new Koordinates(6, 0), new Koordinates(3, 3))));
    }

    @Test
    @DisplayName("does the game changes successfully to the next players turn")
    public void gameChangesSuccessfullyToTheNextPlayersTurn() {
        Game game = new Game();
        game.nextPlayersTurn();
        assertEquals(game.turn, Color.BLACK);
    }

    @Test
    @DisplayName("does the game changes successfully to the next players turn a multiple of 2 times")
    public void gameChangesSuccessfullyToTheNextPlayersTurnMultiple() {
        Game game = new Game();
        for (int i = 0; i < 10; i++) {
            game.nextPlayersTurn();
        }
        assertEquals(game.turn, Color.WHITE);
    }

    @Test
    @DisplayName("does the game detects friendly pieces on the endTile and returns true")
    public void gameDetectsFriendlyPiecesOnTheEndTileAndReturnsTrue() {
        Game game = new Game();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                game.board[i][j] = new Tile(new NoPiece());
            }
        }
        game.board[6][4] = new Tile(new Rook(Color.WHITE));
        assertTrue(game.isEndTileAllay(new Koordinates(6, 4)));
    }

    @Test
    @DisplayName("does the game detects enemy pieces on the endTile and returns false")
    public void gameDetectsEnemyPiecesOnTheEndTileAndReturnsFalse() {
        Game game = new Game();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                game.board[i][j] = new Tile(new NoPiece());
            }
        }
        game.board[6][4] = new Tile(new Rook(Color.BLACK));
        assertFalse(game.isEndTileAllay(new Koordinates(6, 4)));
    }
}