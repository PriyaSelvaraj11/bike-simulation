package bike.movement;

import bike.Bike;
import bike.Position;
import bike.Direction;

public class ForwardMovement extends Movement{
    public Position getNextPosition(Bike bike) {
        Position newPosition = bike.getPosition();
        Direction direction = bike.getDirection();
        switch (direction) {
            case NORTH:
                newPosition = computeNextPosition(bike, 0, 1);
                break;
            case EAST:
                newPosition = computeNextPosition(bike, 1, 0);
                break;
            case SOUTH:
                newPosition = computeNextPosition(bike, 0, -1);
                break;
            case WEST:
                newPosition = computeNextPosition(bike, -1, 0);
                break;
        }
        return newPosition;
    }
}
