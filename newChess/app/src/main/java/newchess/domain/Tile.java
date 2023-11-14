package newchess.domain;

import newchess.data.Color;
import newchess.pieces.Piece;

public class Tile {
    Piece piece;

    public Tile(Piece piece) {
        this.piece = piece;
    }

    public Color getColor() {
        return piece.getColor();
    }

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
}
