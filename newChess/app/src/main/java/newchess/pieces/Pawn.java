package newchess.pieces;

import newchess.data.*;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Color color) {
        this.color = color;
        name = "Pawn";
        symbol = "P";
        moveType = MoveType.JUICER;
    }

    @Override
    public List<Koordinates> possibleMoves(Koordinates position) {
        return null;
    }
}
