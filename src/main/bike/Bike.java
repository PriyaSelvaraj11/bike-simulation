package main.bike;

import main.bike.movement.Movement;

/**
 * Class defining the attributes(position and direction)
 * of bike
 */
public class Bike {
    private Position position;
    private Direction direction;

    /**
     * Creates a instance of Bike class
     * with position(0,0)
     * and default direction(NORTH)
     */
    public Bike() {
        position = new Position(0, 0);
        direction = Direction.NORTH;
    }

    /**
     * Creates a new instance of Bike class
     * with the specified (x,y) coordinate and direction
     *
     * @param xCoord x coordinate of the bike position
     * @param yCoord y coordinate of the bike position
     * @param direction direction of the bike position
     */
    public Bike(int xCoord, int yCoord, Direction direction) {
        position = new Position(xCoord, yCoord);
        this.direction = direction;
    }

    /**
     * Returns the current position of the bike
     * @return Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the position of the bike
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Returns the current direction of the bike
     * @return Direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Sets the direction of the bike
     * @param direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Sets the position of the bike
     * using the input coordinates(x,y)
     *
     * @param xCoord x coordinate of new position
     * @param yCoord y coordinate of new position
     */
    public void setPositionByCoord(int xCoord, int yCoord) {
        position.setXCoord(xCoord);
        position.setYCoord(yCoord);
    }

    /**
     * Changes the direction of the bike
     * by turning left based on
     * current direction
     */
    public void turnLeft() {
        this.direction = direction.rotateLeft();
    }

    /**
     * Changes the direction of the bike
     * by turning right based on
     * current direction
     */
    public void turnRight() {
        this.direction = direction.rotateRight();
    }

    /**
     * Computes the next position of the bike
     * based on the input movement type(forward)
     * without changing the current position of the bike
     *
     * @param movement
     * @return Position - computed position
     */
    public Position getNextPosition(Movement movement) {
        return movement.getNextPosition(this);
    }
}
