package main.bike;

import main.bike.movement.ForwardMovement;
import main.bike.movement.Movement;

/**
 * A service class managing and orchestrating
 * the bike riding on the grid
 */
public class BikeRider {
    private Bike bike;
    private Grid grid;

    /**
     * Creates a instance of BikeRider class
     * by creating a default bike and default grid instance
     */
    public BikeRider() {
        this.bike = new Bike();
        this.grid = new Grid();
    }

    /**
     * Creates a instance of BikeRider class
     * by creating bike and grid instance
     * based on specified values.
     *
     * @param bike
     * @param grid
     */
    public BikeRider(Bike bike, Grid grid) {
        this();
        this.bike = bike;
        this.grid = grid;
    }

    /**
     * Returns the current bike placed on the grid
     * @return bike
     */
    public Bike getBike() {
        return bike;
    }

    /**
     * Changes the current bike to specified bike
     * @param bike
     */
    public void setBike(Bike bike) {
        this.bike = bike;
    }

    /**
     * Returns the current grid of the bike
     * @return grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Changes the current grid to specified grid
     * @param grid
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * Validates and changes the current bike position and direction
     * to specified (x,y) coordinates and direction.
     *
     * Validation failure will result in no change to bike position and direction
     *
     * @param xCoord
     * @param yCoord
     * @param direction
     */
    public void placeBike(int xCoord, int yCoord, String direction) {
        // if (x,y) coord exists on the grid, change the bike attributes
        if(grid.isValidPoint(xCoord, yCoord)) {
            bike.setPositionByCoord(xCoord, yCoord);
            bike.setDirection(Direction.valueOf(direction));
        }
    }

    /**
     * Invokes turnLeft function of Bike class
     */
    public void turnLeft() {
        bike.turnLeft();
    }

    /**
     * Invokes turnRight function of Bike class
     */
    public void turnRight() {
        bike.turnRight();
    }

    /**
     * Validates and sets the next forward position of the bike
     * to the current position
     *
     * Validation failure will result in no change to bike position
     */
    public void moveForward() {
        Movement forwardMovement = new ForwardMovement();

        // get the next forward (x,y) coordinates
        Position nextForwardPosition = bike.getNextPosition(forwardMovement);

        // if (x,y) coord exists on the grid, change the bike position
        if(grid.isValidPoint(nextForwardPosition.getXCoord(), nextForwardPosition.getYCoord())) {
            bike.setPosition(nextForwardPosition);
        }
    }

    /**
     * Print the current bike position and direction
     * in the format (x,y),directionName
     */
    public void printCurrentBikeAttributes() {
        Position bikePosition = bike.getPosition();
        System.out.println("("+ bikePosition.getXCoord() + "," + bikePosition.getYCoord()+"),"+
                bike.getDirection());
    }
}
