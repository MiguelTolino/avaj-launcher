import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException; // Import the IOException class to handle errors
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;

import aircraft.*;
import utilities.*;

public class Simulator {

  private int triggers;
  private ArrayList<Flyable> aircrafts;
  private File outputfile;
  private static final String FILENAME = "simulation.txt";

  public Simulator() {
    triggers = 0;
    aircrafts = new ArrayList<Flyable>();
    outputfile = CreateOutputFile();
  }

  private File CreateOutputFile() {
    try {
      File myObj = new File(FILENAME);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists, leaving it blank.");
        // Clear the file if it exists
        new FileWriter(myObj, false).close();
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
  }

  public void setScenario(String filename) {
    try {
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
      parseScenario(myReader);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred." + e.getMessage());
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      System.out.println("An error occurred." + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("An error occurred." + e.getMessage());
      e.printStackTrace();
    }
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
          if (triggers < 0) {
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
      System.out.println("An error occurred: " + e.getMessage());
      System.exit(1);
    }
    return true;
  }

  // TODO: Implement runSimulation method
  public void runSimulation() {
    for (int i = 0; i < triggers; i++) {
      for (Flyable aircraft : aircrafts) {
        aircraft.updateConditions();
        Aircraft castedAircraft = (Aircraft) aircraft;
        castedAircraft.logMessage("Hola");
      }
    }
    printScenario();
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Error: Incorrect usage. Expected: java Simulator <filename>");
      System.exit(1);
    }
    try {
      Simulator sim = new Simulator();
      sim.setScenario(args[0]);
      sim.runSimulation();
    } catch (Exception e) {
      System.err.println("Simulation error: " + e.getMessage());
      System.exit(1);
    }
  }
}