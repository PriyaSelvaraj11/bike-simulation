package simulation;

import main.simulation.SimulationHelper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationHelperTest {
    private SimulationHelper simulationHelper;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUp() {
        simulationHelper =  new SimulationHelper();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(new PrintStream(originalOut));
        System.setErr(new PrintStream(originalErr));
    }

    @Test
    public void testNoCommand() {
        String noInputString = "";
        simulationHelper.executeUserInput(noInputString);
        assertEquals("Error: Invalid command\n", outContent.toString());
    }

    @Test
    public void testInvalidCommand() {
        String invalidInput = "CMD";
        simulationHelper.executeUserInput(invalidInput);
        assertEquals("Error: Invalid command - CMD\n", outContent.toString());
    }

    @Test
    public void testInvalidPlaceCommand() {
        String invalidInput = "PLACE";
        simulationHelper.executeUserInput(invalidInput);
        assertEquals("Error: Invalid parameters for the command!\n", outContent.toString());
    }

    @Test
    public void testInvalidPlaceCommandParameters() {
        String invalidInput = "PLACE x,y,EAST";
        simulationHelper.executeUserInput(invalidInput);
        assertEquals("Error: Invalid parameters for the place command!\n", outContent.toString());
    }

    @Test
    public void testInvalidCommandParameters() {
        simulationHelper.executeUserInput("PLACE 1,2,NORTH");
        String invalidInput = "TURN_LEFT x,y,EAST";
        simulationHelper.executeUserInput(invalidInput);
        assertEquals("Error: Invalid parameters for the command!\n", outContent.toString());
    }

    @Test
    public void testInputsBeforeFirstPlaceCommand() {
        simulationHelper.executeUserInput("TURN_LEFT");
        assertEquals("Error: Place the bike on the grid!\n", outContent.toString());
    }

    @Test
    public void testPlaceCommand() {
        simulationHelper.executeUserInput("PLACE 0,1,NORTH");
        simulationHelper.executeUserInput("GPS_REPORT");
        assertEquals("(0,1),NORTH\n", outContent.toString());
    }

    @Test
    public void testTurnLeftCommand() {
        simulationHelper.executeUserInput("PLACE 0,1,NORTH");
        simulationHelper.executeUserInput("TURN_LEFT");
        simulationHelper.executeUserInput("GPS_REPORT");
        assertEquals("(0,1),WEST\n", outContent.toString());
    }

    @Test
    public void testTurnRightCommand() {
        simulationHelper.executeUserInput("PLACE 0,1,NORTH");
        simulationHelper.executeUserInput("TURN_RIGHT");
        simulationHelper.executeUserInput("GPS_REPORT");
        assertEquals("(0,1),EAST\n", outContent.toString());
    }

    @Test
    public void testForwardCommand() {
        simulationHelper.executeUserInput("PLACE 0,1,NORTH");
        simulationHelper.executeUserInput("FORWARD");
        simulationHelper.executeUserInput("GPS_REPORT");
        assertEquals("(0,2),NORTH\n", outContent.toString());
    }
}
