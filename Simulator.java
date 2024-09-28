import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import src.com.weather_simulation.aircraft.*;
import src.com.weather_simulation.utilities.Coordinates;

public class Simulator {

  private int triggers;
  private ArrayList<Aircraft> aircrafts;

  private enum Weather {
    RAIN,
    FOG,
    SUN,
    SNOW
  }

  Simulator() {
    triggers = 0;
    aircrafts = new ArrayList<Aircraft>();
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

  public static void main(String[] args) {
    try {
      if (args.length != 1) {
        System.out.println("Usage: java Simulator <filename>");
        System.exit(1);
      }
      Simulator sim = new Simulator();
      sim.setScenario(args[0]);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}