package newchess.data;

import java.util.List;
import java.util.stream.Collectors;

public class Koordinates {

    private final int x;
    private final int y;

    public Koordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Koordinates koordinates) {
            return koordinates.getX() == this.getX() && koordinates.getY() == this.getY();
        }
        return false;
    }

    /**
     * returns all Koordinates that are within the range of the board array
     * @param koordinatesList the list of Koordinates to filter
     * @return the filtered list of Koordinates
     */
    public static List<Koordinates> filterKoordinates(List<Koordinates> koordinatesList) {
        return koordinatesList.stream().filter(koordinates -> koordinates.getX() >= 0 && koordinates.getX() <= 7 && koordinates.getY() >= 0 && koordinates.getY() <= 7).collect(Collectors.toList());
    }
}
