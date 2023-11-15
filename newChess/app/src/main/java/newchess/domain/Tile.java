package newchess.domain;

import newchess.data.Color;
import newchess.data.Koordinates;
import newchess.pieces.Piece;

import java.util.List;

public class Tile {
    Piece piece;

    public Tile(Piece piece) {
        this.piece = piece;
    }

    public Color getColor() {
        return piece.getColor();
    }

    public Piece getPiece() { return piece;}

    @Override
    public String toString() {
        return piece.toString();
    }

    public String print() {
        if (piece != null) {
            return piece.toString();
        }
        return "- ";
    }

    public List<Koordinates> getMoves(Koordinates position) {
        return piece.possibleMoves(position);
    }
}
