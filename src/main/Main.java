package main;

import java.util.Scanner;
import main.simulation.SimulationHelper;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bike Simulator");
        System.out.println("Please enter one of the following commands:");
        System.out.println("PLACE X,Y,Direction (NORTH,SOUTH,EAST,WEST)\nFORWARD\nTURN_LEFT\nTURN_RIGHT\nGPS_REPORT\nEXIT");

        SimulationHelper simulator = new SimulationHelper();
        boolean simulation = true;

        while (simulation) {
            String input = scanner.nextLine();
            if (input.equals("EXIT")) {
                System.out.println("You have exit the simulator");
                simulation = false;
            } else {
                simulator.executeUserInput(input);
            }
        }
    }
}