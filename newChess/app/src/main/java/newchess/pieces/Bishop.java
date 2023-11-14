package newchess.pieces;

import newchess.data.*;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(Color color) {
        this.color = color;
        this.name = "Bishop";
        this.symbol = "B";
        this.moveType = MoveType.DIAGONAL;
    }
    @Override
    public List<Koordinates> possibleMoves(Koordinates position) {
        return null;
    }
}
