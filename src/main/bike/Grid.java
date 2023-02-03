package main.bike;

/**
 * Class representing the n*m grid
 * with (0,0),(0,m-1),(n-1,0),(n-1,m-1) coordinates
 * being the four corners of the grid
 *
 */
public class Grid {
    static final int DEFAULT_ROWS = 7;
    static final int DEFAULT_COLUMNS = 7;

    // maximum number of rows in a grid
    private int rowsCount;
    // maximum number of columns in a grid
    private int columnsCount;

    /**
     * Creates a 7*7 Grid class instance
     */
    public Grid() {
        this.rowsCount = DEFAULT_ROWS;
        this.columnsCount = DEFAULT_COLUMNS;
    }

    /**
     * Creates a Grid class instance based on
     * specified maximum row and columns count
     *
     * @param rowsCount
     * @param columnsCount
     */
    public Grid(int rowsCount, int columnsCount) {
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
    }

    /**
     * Returns the maximum number of rows
     * @return
     */
    public int getRowsCount() {
        return rowsCount;
    }

    /**
     * Sets the maximum number of rows
     * @param rowsCount
     */
    public void setRowsCount(int rowsCount) {
        this.rowsCount = rowsCount;
    }

    /**
     * Returns the minimum number of columns
     * @return
     */
    public int getColumnsCount() {
        return columnsCount;
    }

    /**
     * Sets the maximum number of columns
     * @param columnsCount
     */
    public void setColumnsCount(int columnsCount) {
        this.columnsCount = columnsCount;
    }

    /**
     * Checks whether the specified (x,y) coordinate
     * is a valid point on the grid
     *
     * @param xCoord
     * @param yCoord
     * @return boolean
     */
    public boolean isValidPoint(int xCoord, int yCoord) {
        if(xCoord >= rowsCount || xCoord < 0 ||
               yCoord >= columnsCount ||
                yCoord < 0) {
            return false;
        }
        return true;
    }
}
