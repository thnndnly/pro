package newchess.data;

import newchess.domain.Tile;

import java.util.ArrayList;
import java.util.List;

public class Move {
    public final Koordinates startingTile;
    public final Koordinates endingTile;

    public Move(Koordinates startingTile, Koordinates endingTile) {
        this.startingTile = startingTile;
        this.endingTile = endingTile;
    }

    public Koordinates getStartingTile() {
        return startingTile;
    }

    public Koordinates getEndingTile() {
        return endingTile;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Move move) {
            return move.startingTile.equals(this.startingTile) && move.endingTile.equals(this.endingTile);
        }
        return false;
    }

    public List<Koordinates> getNeedToBeEmpty() {
        List<Koordinates> result = new ArrayList<Koordinates>();
        int differenceX = startingTile.getX() - endingTile.getX();
        int differenceY = startingTile.getY() - endingTile.getY();
        if((differenceX == 0)){
            for(int i = Math.min(startingTile.getY(), endingTile.getY()) + 1; i < Math.max(startingTile.getY(), endingTile.getY()); i++) {
                result.add(new Koordinates(startingTile.getX(), i));
            }
        }
        else if((differenceY == 0)){
            for(int i = Math.min(startingTile.getX(), endingTile.getX()) + 1; i < Math.max(startingTile.getX(), endingTile.getX()); i++) {
                result.add(new Koordinates(i, startingTile.getY()));
            }
        }
        else if((differenceX == differenceY)) {
            for(int i = Math.min(startingTile.getX(), endingTile.getX()) + 1; i < Math.max(startingTile.getX(), endingTile.getX()); i++) {
                for(int j = Math.min(startingTile.getY(), endingTile.getY()) + 1; j < Math.max(startingTile.getY(), endingTile.getY()); j++) {
                    result.add(new Koordinates(i, j));
                }
            }
        }
        else {
            for(int i = Math.min(startingTile.getX(), endingTile.getX()) + 1; i < Math.max(startingTile.getX(), endingTile.getX()); i++) {
                for(int j = Math.max(startingTile.getY(), endingTile.getY()) - 1; j > Math.min(startingTile.getY(), endingTile.getY()); j--) {
                    result.add(new Koordinates(i, j));
                }
            }
        }
        return result;
    }
}
