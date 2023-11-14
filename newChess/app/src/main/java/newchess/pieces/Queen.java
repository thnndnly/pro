package newchess.pieces;

import newchess.data.Color;
import newchess.data.Koordinates;
import newchess.data.MoveType;

import java.util.List;

public class Queen extends Piece {

    public Queen(Color color){
        this.color = color;
        this.name = "Queen";
        this.symbol = "Q";
        this.moveType = MoveType.QUEEN;
    }
    @Override
    public List<Koordinates> possibleMoves(Koordinates position) {
        return null;
    }
}
