package main.commands;

import main.bike.BikeRider;

public class PlaceCommand extends Command{
    private int xCoord;
    private int yCoord;
    private String direction;

    public PlaceCommand(BikeRider bikeRider, int xCoord, int yCoord, String direction) {
        super(bikeRider);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.direction = direction;
    }

    @Override
    public boolean execute() {
        bikeRider.placeBike(xCoord, yCoord, direction);
        return true;
    }
}
