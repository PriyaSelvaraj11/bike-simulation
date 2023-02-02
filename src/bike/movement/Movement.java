package bike.movement;

import bike.Bike;
import bike.Position;

public abstract class Movement {
    protected Position computeNextPosition(Bike bike, int rowChangeValue, int colChangeValue) {
        int newRow = rowChangeValue + bike.getPosition().getRowIndex();
        int newColumn = colChangeValue + bike.getPosition().getColumnIndex();
        return new Position(newRow, newColumn);
    }
    public abstract Position getNextPosition(Bike bike);
}
