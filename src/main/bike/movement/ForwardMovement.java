package main.bike.movement;

import main.bike.Bike;
import main.bike.Position;
import main.bike.Direction;

/**
 * Class used for the forward movement of the bike
 */
public class ForwardMovement extends Movement{
    /**
     * Compute and returns the next forward position of the bike
     * based on current position(x,y) and current direction.
     *
     * @param bike
     * @return Position
     */
    public Position getNextPosition(Bike bike) {
        Position newPosition = bike.getPosition();
        Direction direction = bike.getDirection();
        switch (direction) {
            // if NORTH , then only y coord increments by 1
            case NORTH:
                newPosition = computeNewCoord(bike, 0, 1);
                break;
            // if EAST , then only x coord increments by 1
            case EAST:
                newPosition = computeNewCoord(bike, 1, 0);
                break;
            // if SOUTH , then only y coord decrements by 1
            case SOUTH:
                newPosition = computeNewCoord(bike, 0, -1);
                break;
            // if WEST , then only x coord decrements by 1
            case WEST:
                newPosition = computeNewCoord(bike, -1, 0);
                break;
        }
        return newPosition;
    }
}
