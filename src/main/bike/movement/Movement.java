package main.bike.movement;

import main.bike.Bike;
import main.bike.Position;

public abstract class Movement {
    protected Position computeNextPosition(Bike bike, int xCoordChangeValue, int yCoordChangeValue) {
        int newRow = xCoordChangeValue + bike.getPosition().getXCoord();
        int newColumn = yCoordChangeValue + bike.getPosition().getYCoord();
        return new Position(newRow, newColumn);
    }
    public abstract Position getNextPosition(Bike bike);
}
