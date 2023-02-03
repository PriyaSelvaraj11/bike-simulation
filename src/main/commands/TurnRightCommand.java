package main.commands;

import main.bike.BikeRider;

/**
 * Class executing the TURN_RIGHT command
 * that changes the bike direction by rotating to the right by 90 degrees.
 */
public class TurnRightCommand extends Command{
    public TurnRightCommand(BikeRider bikeRider) {
        super(bikeRider);
    }
    /**
     * Invokes the turnRight function of
     * the bikeRider instance and returns true if successful
     * @return
     */
    @Override
    public boolean execute() {
        bikeRider.turnRight();
        return true;
    }
}
