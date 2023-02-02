package main.bike;

import main.bike.movement.Movement;

public class Bike {
    private Position position;
    private Direction direction;

    public Bike() {
        position = new Position(0, 0);
        direction = Direction.NORTH;
    }

    public Bike(int xCoord, int yCoord, Direction direction) {
        position = new Position(xCoord, yCoord);
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setPositionByIndex(int xCoord, int yCoord) {
        position.setXCoord(xCoord);
        position.setYCoord(yCoord);
    }

    public void turnLeft() {
        this.direction = direction.rotateLeft();
    }

    public void turnRight() {
        this.direction = direction.rotateRight();
    }

    public Position getNextPosition(Movement movement) {
        return movement.getNextPosition(this);
    }
}
