package main.bike;

public class Grid {
    static final int DEFAULT_ROWS = 7;
    static final int DEFAULT_COLUMNS = 7;
    private int rowsCount;
    private int columnsCount;

    public Grid() {
        this.rowsCount = DEFAULT_ROWS;
        this.columnsCount = DEFAULT_COLUMNS;
    }
    public Grid(int rowsCount, int columnsCount) {
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
    }

    public int getRowsCount() {
        return rowsCount;
    }

    public void setRowsCount(int rowsCount) {
        this.rowsCount = rowsCount;
    }

    public int getColumnsCount() {
        return columnsCount;
    }

    public void setColumnsCount(int columnsCount) {
        this.columnsCount = columnsCount;
    }

    public boolean isValidPoint(int xCoord, int yCoord) {
        if(xCoord >= rowsCount || xCoord < 0 ||
               yCoord >= columnsCount ||
                yCoord < 0) {
            return false;
        }
        return true;
    }
}
