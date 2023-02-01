package bike;

public class BikeRider {
    Bike bike;
    Grid grid;

    public BikeRider() {
        this.bike = new Bike();
        this.grid = new Grid();
    }

    public BikeRider(Bike bike, Grid grid) {
        this();
        this.bike = bike;
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void placeBike(int rowIndex, int columnIndex, String direction) {
        if(grid.isValidPoint(rowIndex, columnIndex)) {
            bike.setPositionByIndex(rowIndex, columnIndex);
            bike.setDirection(Direction.valueOf(direction));
        }
    }
    public void turnLeft() {
        bike.turnLeft();
    }
    public void turnRight() {
        bike.turnRight();
    }
    public void moveForward() {
        Position nextForwardPosition = bike.getNextPosition();
        if(grid.isValidPoint(nextForwardPosition.getRowIndex(), nextForwardPosition.getColumnIndex())) {
            bike.setPosition(nextForwardPosition);
        }
    }

    public void printCurrentBikePosition() {
        Position bikePosition = bike.getPosition();
        System.out.println("("+ bikePosition.getRowIndex() + "," + bikePosition.getColumnIndex()+"),"+
                bike.getDirection());
    }
}
