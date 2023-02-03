package main.commands;

import main.bike.BikeRider;

/**
 * Class executing the GPS_REPORT command
 * that prints the bike position
 */
public class GPSReportCommand extends Command{
    public GPSReportCommand(BikeRider bikeRider) {
        super(bikeRider);
    }

    /**
     * Invokes the printCurrentBikeAttributes function of
     * the bikeRider instance and returns true if successful
     * @return boolean
     */
    @Override
    public boolean execute() {
        bikeRider.printCurrentBikeAttributes();
        return true;
    }
}
