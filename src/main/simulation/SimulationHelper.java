package main.simulation;

import main.bike.BikeRider;
import main.commands.*;

/**
 * Class used for
 * 1. parsing and validating user input
 * 2. managing the BikeRider class instance
 * 3. invoking the required Command class instance based on user input
 */
public class SimulationHelper {
    // list of valid command names
    private static enum CommandInput {
        PLACE,
        FORWARD,
        TURN_LEFT,
        TURN_RIGHT,
        GPS_REPORT;

        public static CommandInput lookup(String id) {
            try {
                return CommandInput.valueOf(id);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid command - " + id);
            }
        }
    }

    private BikeRider bikeRider;

    /**
     * Validate the command by command name and attribute length
     * @param parsedInputCommand
     * @return
     * @throws Exception
     */
    private boolean validateCommand(String[] parsedInputCommand) throws Exception {
        // throw exception for empty command
        if(parsedInputCommand.length < 0 || parsedInputCommand[0] == "") throw new Exception("Invalid command");

        CommandInput commandName = CommandInput.lookup(parsedInputCommand[0]);

        boolean isPlaceCommand = (commandName == CommandInput.PLACE);

        // throw exception for all commands issued before the first PLACE command
        if(bikeRider == null && !isPlaceCommand)
            throw new Exception("Place the bike on the grid!");

        // throw exception for empty or more than 1 parameter in PLACE command
        if(isPlaceCommand && parsedInputCommand.length != 2)
            throw new Exception("Invalid parameters for the command!");

        if(isPlaceCommand) {
            String placePattern = "^\\d+,\\d+,(?:NORTH|SOUTH|EAST|WEST)$";
            if(!parsedInputCommand[1].matches(placePattern))
                throw new Exception("Invalid parameters for the place command!");
        }

        return true;
    }

    /**
     * Creates the required Command class instance based specified command
     * and executes the command
     *
     * @param parsedInputCommand
     * @return
     * @throws Exception
     */
    private boolean executeCommand(String[] parsedInputCommand) throws Exception{
                CommandInput commandName = CommandInput.valueOf(parsedInputCommand[0]);
                Command command;
                switch(commandName) {
                    case PLACE:
                        String[] placeParams =  parsedInputCommand[1].split(",");
                        int xCoord = Integer.parseInt(placeParams[0]);
                        int yCoord = Integer.parseInt(placeParams[1]);
                        command = new PlaceCommand(bikeRider, xCoord , yCoord, placeParams[2]);
                        break;
                    case FORWARD:
                        command = new ForwardCommand(bikeRider);
                        break;
                    case TURN_LEFT:
                        command = new TurnLeftCommand(bikeRider);
                        break;
                    case TURN_RIGHT:
                        command = new TurnRightCommand(bikeRider);
                        break;
                    case GPS_REPORT:
                        command = new GPSReportCommand(bikeRider);
                        break;
                    default:
                        throw new Exception("Invalid command!");
                }
                return command.execute();
    }

    /**
     * Validates and executes the user command input
     * in the format <COMMAND_NAME><SPACE><OPTIONAL_INPUT_PARAMETERS>
     *
     * Prints the validation error message in the console.
     * @param input
     */
    public void executeUserInput(String input) {
        try {
            // parse the input string
            String[] parsedInput = input.split(" ");

            // validate command
            boolean isValidCommand = validateCommand(parsedInput);
            if(!isValidCommand) return;

            // create bike rider for the first valid command
            if(bikeRider == null) bikeRider = new BikeRider();

            // execute command
            executeCommand(parsedInput);

        } catch(Exception exception) {
            System.err.println("Error: "+ exception.getMessage());
        }
    }
}
