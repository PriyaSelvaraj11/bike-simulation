package commands;

import bike.BikeRider;

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
