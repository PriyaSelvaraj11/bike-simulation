package simulation;

import bike.BikeRider;
import commands.*;

import javax.activation.CommandMap;

public class SimulationHelper {
    private static enum CommandInput {
        PLACE,
        FORWARD,
        TURN_LEFT,
        TURN_RIGHT,
        GPS_REPORT
    }

    private static enum DirectionInput {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }
    private BikeRider bikeRider;

    private boolean validateCommand(String[] parsedInputCommand) throws Exception {
            if(parsedInputCommand.length < 0) throw new Exception("Invalid command");

            CommandInput commandName = CommandInput.valueOf(parsedInputCommand[0]);
            if(commandName == null)
                throw new Exception("Invalid command!");

            boolean isPlaceCommand = (commandName == CommandInput.PLACE);
            if(bikeRider == null && !isPlaceCommand)
                throw new Exception("Place the bike on the grid!");

            if(isPlaceCommand && parsedInputCommand.length != 2)
                throw new Exception("Invalid parameters for the command!");

            return true;
    }

    private boolean executeCommand(String[] parsedInputCommand) {
                CommandInput commandName = CommandInput.valueOf(parsedInputCommand[0]);
                Command command;
                switch(commandName) {
                    case PLACE:
                        String[] placeParams =  parsedInputCommand[1].split(",");
                        int rowIndex = Integer.parseInt(placeParams[0]);
                        int columnIndex = Integer.parseInt(placeParams[1]);
                        command = new PlaceCommand(bikeRider,rowIndex , columnIndex, placeParams[2]);
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
                        command = null;
                }
                if(command == null) return false;
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
