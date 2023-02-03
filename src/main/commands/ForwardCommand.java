package main.commands;

import main.bike.BikeRider;

/**
 * Class executing the FORWARD command
 * that moves the bike one step forward
 */
public class ForwardCommand extends Command{
    public ForwardCommand(BikeRider bikeRider) {
        super(bikeRider);
    }

    /**
     * Invokes the moveForward function of the bikeRider instance
     * returns true if successful
     * @return
     */
    @Override
    public boolean execute() {
        bikeRider.moveForward();
        return true;
    }
}
