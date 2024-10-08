package aircraft;

import utilities.Coordinates;

public class AircraftFactory {

    private static AircraftFactory instance;
    private static int id;

    private AircraftFactory() {
        id = 1;
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public static Flyable newAircraft(String type, String name, Coordinates coordinates) {
        if (type.equals("Baloon")) {
            return new Baloon(generateUniqueId(), name, coordinates);
        } else if (type.equals("JetPlane")) {
            return new JetPlane(generateUniqueId(), name, coordinates);
        } else if (type.equals("Helicopter")) {
            return new Helicopter(generateUniqueId(), name, coordinates);
        } else {
            throw new IllegalArgumentException("Unknown aircraft type: " + type);
        }
    }

    public static int generateUniqueId() {
        return id++;
    }
}
