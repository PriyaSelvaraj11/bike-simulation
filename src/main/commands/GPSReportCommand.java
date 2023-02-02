package main.commands;

import main.bike.BikeRider;

public class GPSReportCommand extends Command{
    public GPSReportCommand(BikeRider bikeRider) {
        super(bikeRider);
    }

    @Override
    public boolean execute() {
        bikeRider.printCurrentBikePosition();
        return true;
    }
}
