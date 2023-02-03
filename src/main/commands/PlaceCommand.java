package main.commands;

import main.bike.BikeRider;

/**
 * Class executing the PLACE command
 * that positions the bike on the grid
 */
public class PlaceCommand extends Command{
    private int xCoord;
    private int yCoord;
    private String direction;

    /**
     * Create a PlaceCommand class instance with specified
     * bikeRider, xCoord, yCoord and direction values.
     *
     * @param bikeRider
     * @param xCoord
     * @param yCoord
     * @param direction
     */
    public PlaceCommand(BikeRider bikeRider, int xCoord, int yCoord, String direction) {
        super(bikeRider);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.direction = direction;
    }

    /**
     * Invokes the placeBike function of
     * the bikeRider instance and returns true if successful
     * @return boolean
     */
    @Override
    public boolean execute() {
        bikeRider.placeBike(xCoord, yCoord, direction);
        return true;
    }
}
