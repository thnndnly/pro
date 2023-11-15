package newchess.pieces;

import newchess.data.Color;
import newchess.data.Koordinates;
import newchess.data.MoveType;

import java.util.List;

public class King extends Piece {

    public King(Color color) {
        this.color = color;
        name = "King";
        symbol = "K";
        moveType = MoveType.KING;
    }

    @Override
    public List<Koordinates> possibleMoves(Koordinates position) {
        return null;
    }
}
