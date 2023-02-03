package main.commands;

import main.bike.BikeRider;

/**
 * Base class to execute command issued to BikeRider instance
 */
public abstract class Command {
    protected BikeRider bikeRider;

    /**
     * Creates a Command class instance with
     * specified BikeRider instance
     *
     * @param bikeRider
     */
    Command(BikeRider bikeRider) {
        this.bikeRider = bikeRider;
    }

    /**
     * Executes the command on the BikeRider instance
     * and returns true if command execution is successful.
     * @return boolean
     */
    public abstract boolean execute();
}
