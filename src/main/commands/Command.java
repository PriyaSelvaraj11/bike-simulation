package main.commands;

import main.bike.BikeRider;

public abstract class Command {
    protected BikeRider bikeRider;
    Command(BikeRider bikeRider) {
        this.bikeRider = bikeRider;
    }
    public abstract boolean execute();
}
