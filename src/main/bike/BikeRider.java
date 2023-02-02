package main.bike;

import main.bike.movement.ForwardMovement;
import main.bike.movement.Movement;

public class BikeRider {
    private Bike bike;
    private Grid grid;

    public BikeRider() {
        this.bike = new Bike();
        this.grid = new Grid();
    }

    public BikeRider(Bike bike, Grid grid) {
        this();
        this.bike = bike;
        this.grid = grid;
    }


    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void placeBike(int xCoord, int yCoord, String direction) {
        if(grid.isValidPoint(xCoord, yCoord)) {
            bike.setPositionByIndex(xCoord, yCoord);
            bike.setDirection(Direction.valueOf(direction));
        }
    }

    public void turnLeft() {
        bike.turnLeft();
    }

    public void turnRight() {
        bike.turnRight();
    }

    public void moveForward() {
        Movement forwardMovement = new ForwardMovement();
        Position nextForwardPosition = bike.getNextPosition(forwardMovement);
        if(grid.isValidPoint(nextForwardPosition.getXCoord(), nextForwardPosition.getYCoord())) {
            bike.setPosition(nextForwardPosition);
        }
    }

    public void printCurrentBikePosition() {
        Position bikePosition = bike.getPosition();
        System.out.println("("+ bikePosition.getXCoord() + "," + bikePosition.getYCoord()+"),"+
                bike.getDirection());
    }
}
