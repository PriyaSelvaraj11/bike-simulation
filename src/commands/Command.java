package commands;

import bike.BikeRider;

public abstract class Command {
    BikeRider bikeRider;
    Command(BikeRider bikeRider) {
        this.bikeRider = bikeRider;
    }
    public abstract boolean execute();
}
