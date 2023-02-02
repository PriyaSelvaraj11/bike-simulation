package commands;

import bike.BikeRider;

public class PlaceCommand extends Command{
    private int rowIndex;
    private int columnIndex;
    private String direction;

    public PlaceCommand(BikeRider bikeRider, int rowIndex, int columnIndex, String direction) {
        super(bikeRider);
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.direction = direction;
    }

    @Override
    public boolean execute() {
        bikeRider.placeBike(rowIndex, columnIndex, direction);
        return true;
    }
}
