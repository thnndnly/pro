package newchess.data;

public class Move {
    public final Koordinates startingTile;
    public final Koordinates endingTile;

    public Move(Koordinates startingTile, Koordinates endingTile) {
        this.startingTile = startingTile;
        this.endingTile = endingTile;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Move move) {
            return move.startingTile.equals(this.startingTile) && move.endingTile.equals(this.endingTile);
        }
        return false;
    }
}
