package main.commands;

import main.bike.BikeRider;

public class TurnLeftCommand extends Command{
    public TurnLeftCommand(BikeRider bikeRider) {
        super(bikeRider);
    }

    @Override
    public boolean execute() {
        bikeRider.turnLeft();
        return true;
    }
}
