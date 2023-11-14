package newchess.pieces;

import newchess.data.Color;
import newchess.data.Koordinates;
import newchess.data.MoveType;

import java.util.List;

public class Knight extends Piece {

    public Knight(Color color) {
        this.color = color;
        this.name = "Knight";
        this.symbol = "K";
        this.moveType = MoveType.PONY;
    }
    @Override
    public List<Koordinates> possibleMoves(Koordinates position) {
        return null;
    }
}
