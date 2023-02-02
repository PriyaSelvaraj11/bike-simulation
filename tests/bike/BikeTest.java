package bike;

import main.bike.Bike;
import main.bike.Direction;
import main.bike.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BikeTest {
    @Test
    public void testDefaultBike() {
        Bike bike = new Bike();

        String newBikeDirection = bike.getDirection().name();
        Position bikePosition = bike.getPosition();

        // assert direction
        assertEquals("NORTH", newBikeDirection);

        // assert position
        assertEquals(0, bikePosition.getXCoord());
        assertEquals(0, bikePosition.getYCoord());
    }

    @Test
    public void testCreateBike() {
        Bike bike = new Bike(1,2, Direction.SOUTH);

        String newBikeDirection = bike.getDirection().name();
        Position bikePosition = bike.getPosition();

        // assert direction
        assertEquals("SOUTH", newBikeDirection);

        // assert position
        assertEquals(1, bikePosition.getXCoord());
        assertEquals(2, bikePosition.getYCoord());
    }
}
