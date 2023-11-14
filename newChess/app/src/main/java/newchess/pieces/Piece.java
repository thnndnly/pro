package newchess.pieces;

import newchess.data.*;
import java.util.List;

public abstract class Piece {
    protected Color color;
    protected String name;
    protected String symbol;
    protected MoveType moveType;

    public abstract List<Koordinates> possibleMoves(Koordinates position);
    public Color getColor(){
        return color;
    };

    @Override
    public String toString() {
        if(!color.equals(Color.NONE)) {
            return color.equals(Color.WHITE)? symbol.toUpperCase() + " ": symbol.toLowerCase() + " ";
        }
        else{
            return "* ";
        }
    }
}
