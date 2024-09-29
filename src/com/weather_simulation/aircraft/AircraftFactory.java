package aircraft;

import aircraft.*;
import utilities.Coordinates;

public class AircraftFactory {

    private static AircraftFactory instance;
    private static int id;

    private AircraftFactory() {
        id = 0; // Initialize the id
    }

    public static AircraftFactory getInstance() {
        // Singleton instance
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates) {
        if (type.equals("Baloon")) {
            return new Baloon(name, coordinates, generateUniqueId());
        } else if (type.equals("JetPlane")) {
            return new JetPlane(name, coordinates, generateUniqueId());
        } else if (type.equals("Helicopter")) {
            return new Helicopter(name, coordinates, generateUniqueId());
        }
        return null;
    }

    // Method to generate the next unique ID
    public static int generateUniqueId() {
        return id++;  // Increment and return the id
    }
}
