package bike;

import main.bike.Grid;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridTest {
    @Test
    public void testDefaultGrid() {
        Grid grid = new Grid();
        assertEquals(7, grid.getRowsCount());
        assertEquals(7, grid.getColumnsCount());
    }

    @Test
    public void testGridWithDimensions() {
        Grid grid = new Grid(10,60);
        assertEquals(10, grid.getRowsCount());
        assertEquals(60, grid.getColumnsCount());
    }

    @Test
    public void testSetGridDimensions() {
        Grid grid = new Grid();
        grid.setRowsCount(10);
        grid.setColumnsCount(50);
        assertEquals(10, grid.getRowsCount());
        assertEquals(50, grid.getColumnsCount());
    }

    @Test
    public void testIsValidPoint() {
        Grid grid = new Grid();
        assertFalse( grid.isValidPoint(10,10));
        assertFalse( grid.isValidPoint(7,7));
        assertFalse( grid.isValidPoint(-1,0));
        assertFalse( grid.isValidPoint(1,-1));
        assertTrue(grid.isValidPoint(6,6));
    }
}
