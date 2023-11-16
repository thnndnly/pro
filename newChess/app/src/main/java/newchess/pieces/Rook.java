package newchess.pieces;

import newchess.data.Color;
import newchess.data.Koordinates;
import newchess.data.MoveType;

import java.util.ArrayList;
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
        List<Koordinates> result = new ArrayList<>();
        for(int i = 1; i < 8; i++) {
            result.add(new Koordinates(position.getX(), position.getY() + i));
            result.add(new Koordinates(position.getX(), position.getY() - i));
            result.add(new Koordinates(position.getX() + i, position.getY()));
            result.add(new Koordinates(position.getX() - i, position.getY()));
        }
        return Koordinates.filterKoordinates(result);
    }
}
