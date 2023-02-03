package main.bike.movement;

import main.bike.Bike;
import main.bike.Position;

/**
 * Base strategy class used for
 * different movements(forward) of the bike
 */
public abstract class Movement {
    /**
     * Adds the xCoordChangeValue to xCoord of given bike position and
     * yCoordChangeValue to yCoord of given bike position
     *
     * @param bike
     * @param xCoordChangeValue
     * @param yCoordChangeValue
     * @return Position
     */
    protected Position computeNewCoord(Bike bike, int xCoordChangeValue, int yCoordChangeValue) {
        int newRow = xCoordChangeValue + bike.getPosition().getXCoord();
        int newColumn = yCoordChangeValue + bike.getPosition().getYCoord();
        return new Position(newRow, newColumn);
    }

    /**
     * Compute and returns the next position of the bike
     * based on current position(x,y), current direction.
     * and movement type
     *
     * @param bike
     * @return Position
     */
    public abstract Position getNextPosition(Bike bike);
}

