import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; // Import the IOException class to handle errors
import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;

import aircraft.*;
import simulation.WeatherTower;
import utilities.*;

public class Simulator {

  private int triggers;
  private ArrayList<Flyable> aircrafts;
  private WeatherTower weatherTower;
  private File outputfile;
  private static final String FILENAME = "simulation.txt";

  private void redirectOutputToFile() {
    try {
      PrintStream fileOut = new PrintStream(new FileOutputStream(outputfile));
      System.setOut(fileOut);
    } catch (FileNotFoundException e) {
      System.err.println("Error al redirigir la salida al archivo: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public Simulator() {
    triggers = 0;
    aircrafts = new ArrayList<Flyable>();
    outputfile = CreateOutputFile();
    weatherTower = new WeatherTower();
    System.out.println("Weather Simulation: Starting...");
    System.out.println("Output file: " + FILENAME);
    redirectOutputToFile();
  }

  private File CreateOutputFile() {
    try {
      File myObj = new File(FILENAME);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        // Clear the file if it exists using try-with-resources to ensure proper closing
        try (FileWriter fileWriter = new FileWriter(myObj, false)) {
          // No need to explicitly call close here, as try-with-resources handles it
        }
      }
      return myObj;
    } catch (IOException e) {
      System.out.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
    }
    return null;
  }

  public void printScenario() {
    System.out.println("===== Scenario =====");
    System.out.println("Triggers: " + triggers);
    for (Flyable aircraft : aircrafts) {
      if (aircraft instanceof Aircraft) {
        Aircraft a = (Aircraft) aircraft;
        System.out.printf("%s, %s, ID: %d, %s%n",
            a.getClass().getSimpleName(),
            a.getName(),
            a.getId(),
            a.getCoordinates().toString());
      }
    }
    System.out.println("=====================");
  }

  public void setScenario(String filename) {
    try (Scanner myReader = new Scanner(new File(filename))) {
      if (!parseScenario(myReader)) {
        System.exit(1);
      }
    } catch (FileNotFoundException e) {
      handleException("File not found: " + filename, e);
    } catch (IllegalArgumentException e) {
      handleException("Invalid argument provided.", e);
    } catch (Exception e) {
      handleException("An unexpected error occurred.", e);
    }
  }

  private void handleException(String message, Exception e) {
    System.err.println(message + " " + e.getMessage());
    System.exit(1);
  }

  private boolean parseScenario(Scanner myReader) {
    boolean firstLine = true;

    try {
      if (!myReader.hasNextLine()) {
        throw new IllegalArgumentException("Empty file");
      }
      while (myReader.hasNextLine()) {
        if (firstLine) {
          firstLine = false;
          triggers = myReader.nextInt();
          if (triggers <= 0) {
            throw new IllegalArgumentException("Invalid number of triggers");
          }
          myReader.nextLine(); // Move to the next line after reading the integer
        }
        String[] data = myReader.nextLine().split(" ");
        if (data.length != 5) {
          throw new IllegalArgumentException("Invalid aircraft data");
        }
        aircrafts.add(AircraftFactory.newAircraft(data[0], data[1],
            new Coordinates(Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]))));
      }
    } catch (Exception e) {
      System.err.println("An error occurred: " + e.getMessage());
      System.exit(1);
    }
    return true;
  }

  public void runSimulation() {
    printScenario();
    for (Flyable aircraft : aircrafts) {
      aircraft.registerTower(weatherTower);
      weatherTower.register(aircraft);
    }
    for (int i = 0; i < triggers; i++) {
      System.out.println("--------------------");
      System.out.println("Trigger " + (i + 1) + " of " + triggers);
      System.out.println("--------------------");
      weatherTower.changeWeather();
    }
  }

  public static void main(String[] args) {
    try {
      if (args.length != 1) {
        System.out.println("Usage: java Simulator <filename>");
        throw new IllegalArgumentException("Invalid number of arguments");
      }
      Simulator sim = new Simulator();
      sim.setScenario(args[0]);
      sim.runSimulation();
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      System.err.println("Exiting...");
      System.exit(1);
    }
  }
}