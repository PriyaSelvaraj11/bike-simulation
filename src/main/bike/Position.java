package main.bike;

/**
 * Class denoting (x,y) coordinate position
 */
public class Position {
    private int xCoord;
    private int yCoord;

    /**
     * Creates a Position class instance
     * with specified (x,y) coordinates
     *
     * @param xCoord x coordinate of position
     * @param yCoord y coordinate of position
     */
    public Position(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    /**
     * Returns the x coordinate of position
     * @return xcoord
     */
    public int getXCoord() {
        return xCoord;
    }

    /**
     * Returns the y coordinate of position
     * @return ycoord
     */
    public int getYCoord() {
        return yCoord;
    }

    /**
     * Sets the x coordinate of position
     * @param xCoord
     */
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     * Sets the y coordinate of position
     * @param yCoord
     */
    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }


}
