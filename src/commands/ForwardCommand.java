package commands;

import bike.BikeRider;

public class ForwardCommand extends Command{
    public ForwardCommand(BikeRider bikeRider) {
        super(bikeRider);
    }

    @Override
    public boolean execute() {
        bikeRider.moveForward();
        return true;
    }
}
