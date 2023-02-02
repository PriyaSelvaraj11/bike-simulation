package main.simulation;

import main.bike.BikeRider;
import main.commands.*;

public class SimulationHelper {
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

    private boolean validateCommand(String[] parsedInputCommand) throws Exception {
            if(parsedInputCommand.length < 0 || parsedInputCommand[0] == "") throw new Exception("Invalid command");

            CommandInput commandName = CommandInput.lookup(parsedInputCommand[0]);

            boolean isPlaceCommand = (commandName == CommandInput.PLACE);
            if(bikeRider == null && !isPlaceCommand)
                throw new Exception("Place the main.bike on the grid!");

            if(isPlaceCommand && parsedInputCommand.length != 2)
                throw new Exception("Invalid parameters for the command!");

            return true;
    }

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

    public void executeUserInput(String input) {
        try {
            String[] parsedInput = input.split(" ");

            boolean isValidCommand = validateCommand(parsedInput);
            if(!isValidCommand) return;

            if(bikeRider == null) bikeRider = new BikeRider();
            executeCommand(parsedInput);

        } catch(Exception exception) {
            System.err.println("Error: "+ exception.getMessage());
        }
    }
}
