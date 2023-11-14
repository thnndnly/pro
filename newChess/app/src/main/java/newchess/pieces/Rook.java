package newchess.pieces;

import newchess.data.Color;
import newchess.data.Koordinates;
import newchess.data.MoveType;

import java.util.List;

public class Rook extends Piece{

    public Rook(Color color) {
        this.color = color;
        this.name = "Rook";
        this.symbol = "T";
        this.moveType = MoveType.STRAIGHT;
    }
    @Override
    public List<Koordinates> possibleMoves(Koordinates position) {
        return null;
    }
}
