package main.commands;

import main.bike.BikeRider;

/**
 * Class executing the TURN_LEFT command
 * that changes the bike direction by rotating to the left by 90 degrees.
 */
public class TurnLeftCommand extends Command{
    public TurnLeftCommand(BikeRider bikeRider) {
        super(bikeRider);
    }

    /**
     * Invokes the turnLeft function of
     * the bikeRider instance and returns true if successful
     * @return
     */
    @Override
    public boolean execute() {
        bikeRider.turnLeft();
        return true;
    }
}
