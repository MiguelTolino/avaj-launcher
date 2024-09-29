package com.weather_simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
import java.util.ArrayList;
import simulation.*;
import aircraft.*;
import utilities.*;

public class Simulator {

  private int triggers;
  private ArrayList<Flyable> aircrafts;
  private File file;
  private static final String FILENAME = "simulation.txt";

  public Simulator() {
    triggers = 0;
    aircrafts = new ArrayList<Flyable>();
    file = CreateFile();
  }

  private File CreateFile() {
    try {
      File myObj = new File(FILENAME);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
      return myObj;
    } catch (IOException e) {
      System.out.println("An error occurred:" + e.getMessage());
      e.printStackTrace();
    }
    return null;
  }

  public void setScenario(String filename) {
    try {
      ArrayList<String> data = new ArrayList<String>();
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
      parseScenario(myReader);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  // TODO: Implement parseScenario method and handle exceptions and errors
  private boolean parseScenario(Scanner myReader) {
    boolean firstLine = true;

    while (myReader.hasNextLine()) {
      if (firstLine) {
        firstLine = false;
        triggers = myReader.nextInt();
        myReader.nextLine(); // Move to the next line after reading the integer
      }
      String[] data = myReader.nextLine().split(" ");
      System.out.println(data);
      aircrafts.add(AircraftFactory.getInstance().newAircraft(data[0], data[1],
          new Coordinates(Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]))));
    }
    return true;
  }

  // TODO: Implement runSimulation method
  public void runSimulation() {
    for (int i = 0; i < triggers; i++) {
      for (Flyable aircraft : aircrafts) {
        aircraft.updateConditions();
      }
    }
  }

  public static void main(String[] args) {
    try {
      if (args.length != 1) {
        System.out.println("Usage: java Simulator <filename>");
        System.exit(1);
      }
      Simulator sim = new Simulator();
      sim.setScenario(args[0]);
      sim.runSimulation();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}