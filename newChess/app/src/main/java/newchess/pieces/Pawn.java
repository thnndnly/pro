package newchess.pieces;

import newchess.data.*;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    boolean hasAlreadyMoved;
    public Pawn(Color color) {
        this.color = color;
        name = "Pawn";
        symbol = "P";
        moveType = MoveType.JUICER;
        hasAlreadyMoved = false;
    }

    @Override
    public List<Koordinates> possibleMoves(Koordinates position) {
        List<Koordinates> result = new ArrayList<>();
        if(!hasAlreadyMoved){
            if(color.equals(Color.WHITE)){
                result.add(new Koordinates(position.getX() - 2, position.getY()));
            }
            else{
                result.add(new Koordinates(position.getX() + 2, position.getY()));
            }
        }
        if(color.equals(Color.WHITE)){
            result.add(new Koordinates(position.getX() - 1, position.getY()));
            result.add(new Koordinates(position.getX() - 1, position.getY() + 1));
            result.add(new Koordinates(position.getX() - 1, position.getY() - 1));
        }
        else{
            result.add(new Koordinates(position.getX() + 1, position.getY()));
            result.add(new Koordinates(position.getX() + 1, position.getY() + 1));
            result.add(new Koordinates(position.getX() + 1, position.getY() - 1));
        }
        return Koordinates.filterKoordinates(result);
    }

    public void setMoved(){
        hasAlreadyMoved = true;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pawn pawn){
            return this.color.equals(pawn.getColor()) && this.name.equals(pawn.name) && this.symbol.equals(pawn.symbol) && this.moveType.equals(pawn.moveType);
        }
        else {
            return false;
        }
    }
}
