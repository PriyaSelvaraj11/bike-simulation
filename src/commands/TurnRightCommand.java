package commands;

import bike.BikeRider;

public class TurnRightCommand extends Command{
    BikeRider bikeRider;
    public TurnRightCommand(BikeRider bikeRider) {
        super(bikeRider);
    }

    @Override
    public boolean execute() {
        bikeRider.turnRight();
        return true;
    }
}
