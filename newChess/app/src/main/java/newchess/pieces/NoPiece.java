package newchess.pieces;

import newchess.data.*;

import java.util.ArrayList;
import java.util.List;


public class NoPiece extends Piece {

    public NoPiece(){
        this.color = Color.NONE;
        this.name = "";
        this.symbol = "";
        this.moveType = MoveType.NONE;
    }
    @Override
    public List<Koordinates> possibleMoves(Koordinates position) {
        return new ArrayList<>();
    }
}
