package bike;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

import main.bike.*;

public class BikeRiderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void testCreateAndModifyBikeRider() {
        Bike bike = new Bike(1,2,Direction.NORTH);
        Grid grid = new Grid(7,7);
        BikeRider bikeRider = new BikeRider(bike, grid);

        assertEquals(7,bikeRider.getGrid().getColumnsCount());
        assertEquals(7,bikeRider.getGrid().getRowsCount());

        Bike newBike = new Bike(3,2,Direction.NORTH);
        bikeRider.setBike(newBike);

        assertEquals(3, bikeRider.getBike().getPosition().getXCoord());

        Grid newGrid = new Grid(6,5);
        bikeRider.setGrid(newGrid);

        assertEquals(5,bikeRider.getGrid().getColumnsCount());
        assertEquals(6,bikeRider.getGrid().getRowsCount());
    }
    @Test
    public void testPlaceBike() {
        BikeRider bikeRider = new BikeRider();
        int bikeXCoord = 1;
        int bikeYCoord = 2;
        String bikeDirection = "NORTH";

        bikeRider.placeBike(bikeXCoord,bikeYCoord,bikeDirection);

        String newBikeDirection = bikeRider.getBike().getDirection().name();
        Position bikePosition = bikeRider.getBike().getPosition();

        // assert direction
        assertEquals(bikeDirection, newBikeDirection);

        // assert position
        assertEquals(1, bikePosition.getXCoord());
        assertEquals(2, bikePosition.getYCoord());
    }

    @Test
    public void testPlaceBikeOutsideGrid() {
        BikeRider bikeRider = new BikeRider();
        int bikeXCoord = 8;
        int bikeYCoord = 8;
        String bikeDirection = "NORTH";

        bikeRider.placeBike(bikeXCoord,bikeYCoord,bikeDirection);

        String newBikeDirection = bikeRider.getBike().getDirection().name();
        Position bikePosition = bikeRider.getBike().getPosition();

        // assert direction
        assertEquals(bikeDirection, newBikeDirection);

        // assert position
        assertEquals(0, bikePosition.getXCoord());
        assertEquals(0, bikePosition.getYCoord());
    }

    @TestFactory
    Stream<DynamicTest> testTurnRight() {

        BikeRider bikeRider = new BikeRider();
        int initialBikeXCoord = 1;
        int initialBikeYCoord = 2;

        List<String> initialBikeDirections = Arrays.asList(
            "NORTH", "SOUTH", "EAST", "WEST");
        List<String> outputBikeDirection = Arrays.asList(
            "EAST", "WEST", "SOUTH","NORTH");

        return initialBikeDirections.stream()
            .map(initialDirection -> DynamicTest.dynamicTest("Turning right with initial direction: " + initialDirection,
                () -> {
                    int id = initialBikeDirections.indexOf(initialDirection);
                    bikeRider.placeBike(initialBikeXCoord,initialBikeYCoord,initialDirection);
                    bikeRider.turnRight();

                    String newBikeDirection = bikeRider.getBike().getDirection().name();
                    Position bikePosition = bikeRider.getBike().getPosition();

                    // assert changed direction
                    assertEquals(outputBikeDirection.get(id), newBikeDirection);

                    // assert no change in position
                    assertEquals(initialBikeXCoord, bikePosition.getXCoord());
                    assertEquals(initialBikeYCoord, bikePosition.getYCoord());
                }));
    }

    @TestFactory
    Stream<DynamicTest> testTurnLeft() {

        BikeRider bikeRider = new BikeRider();
        int initialBikeXCoord = 1;
        int initialBikeYCoord = 2;

        List<String> initialBikeDirections = Arrays.asList(
                "NORTH", "SOUTH", "EAST", "WEST");
        List<String> outputBikeDirection = Arrays.asList(
                "WEST", "EAST","NORTH", "SOUTH");

        return initialBikeDirections.stream()
                .map(initialDirection -> DynamicTest.dynamicTest("Turning left with initial direction: " + initialDirection,
                    () -> {
                        int id = initialBikeDirections.indexOf(initialDirection);
                        bikeRider.placeBike(initialBikeXCoord,initialBikeYCoord,initialDirection);
                        bikeRider.turnLeft();

                        String newBikeDirection = bikeRider.getBike().getDirection().name();
                        Position bikePosition = bikeRider.getBike().getPosition();

                        // assert changed direction
                        assertEquals(outputBikeDirection.get(id), newBikeDirection);

                        // assert no change in position
                        assertEquals(initialBikeXCoord, bikePosition.getXCoord());
                        assertEquals(initialBikeYCoord, bikePosition.getYCoord());
                    }));
    }

    @TestFactory
    Stream<DynamicTest> testMoveForward() {

        BikeRider bikeRider = new BikeRider();
        int initialBikeXCoord = 1;
        int initialBikeYCoord = 2;

        List<String> initialBikeDirections = Arrays.asList(
                "NORTH", "SOUTH", "EAST", "WEST");
        List<String> outputBikePosition = Arrays.asList(
                "1,3", "1,1","2,2", "0,2");

        return initialBikeDirections.stream()
            .map(initialDirection -> DynamicTest.dynamicTest("Turning left with initial direction: " + initialDirection,
                () -> {
                    int id = initialBikeDirections.indexOf(initialDirection);
                    bikeRider.placeBike(initialBikeXCoord,initialBikeYCoord,initialDirection);
                    bikeRider.moveForward();

                    String newBikeDirection = bikeRider.getBike().getDirection().name();
                    Position bikePosition = bikeRider.getBike().getPosition();
                    String bikePositionAssertString = bikePosition.getXCoord()
                        + "," + bikePosition.getYCoord();

                    // assert no change in direction
                    assertEquals(initialDirection, newBikeDirection);

                    // assert changed position
                    assertEquals(outputBikePosition.get(id),bikePositionAssertString);
                }));
    }

    @Test
    public void testGpsReport() {
        System.setOut(new PrintStream(outContent));

        BikeRider bikeRider = new BikeRider();
        int bikeXCoord = 1;
        int bikeYCoord = 2;
        String bikeDirection = "NORTH";

        bikeRider.placeBike(bikeXCoord,bikeYCoord,bikeDirection);
        bikeRider.printCurrentBikePosition();

        assertEquals("(1,2),NORTH\n", outContent.toString());

        System.setOut(originalOut);
    }
}
