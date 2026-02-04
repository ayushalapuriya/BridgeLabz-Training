package aero_vigil;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightUtil flightUtil = new FlightUtil();

        System.out.println("Enter flight details");
        String input = sc.nextLine();

        try {
            String[] parts = input.split(":");
            if (parts.length != 4) {
                System.out.println("Invalid input format");
                return;
            }

            String flightNumber = parts[0];
            String flightName = parts[1];
            int passengerCount = Integer.parseInt(parts[2]);
            double currentFuelLevel = Double.parseDouble(parts[3]);

            flightUtil.validateFlightNumber(flightNumber);
            flightUtil.validateFlightName(flightName);
            flightUtil.validatePassengerCount(passengerCount, flightName);

            double fuelRequired = flightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);
            System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input");
        }
    }
}
