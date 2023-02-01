package bike.movement;

import bike.Bike;
import bike.Position;
import bike.Direction;

public class ForwardMovement extends Movement{
    public ForwardMovement(Bike bike) {
        super(bike);
    }

    public Position computeNextPosition(int rowChangeValue, int colChangeValue) {
        int newRow = rowChangeValue + bike.getPosition().getRowIndex();
        int newColumn = colChangeValue + bike.getPosition().getColumnIndex();
        return new Position(newRow, newColumn);
    }
    public Position getNextPosition() {
        Position newPosition = bike.getPosition();
        Direction direction = bike.getDirection();
        switch (direction) {
            case NORTH:
                newPosition = computeNextPosition(0, 1);
                break;
            case EAST:
                newPosition = computeNextPosition(1, 0);
                break;
            case SOUTH:
                newPosition = computeNextPosition(0, -1);
                break;
            case WEST:
                newPosition = computeNextPosition(-1, 0);
                break;
        }
        return newPosition;
    }
}
