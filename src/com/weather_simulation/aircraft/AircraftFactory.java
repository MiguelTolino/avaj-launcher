import com.weather_simulation.aircraft.Flyable;
import com.weather_simulation.utilites.Coordinates;

public class AircraftFactory {

    private static AircraftFactory instance;
    private static int id;

    private AircraftFactory() {
        id = 0;
    }

    public static AircraftFactory getInstance() {
        // Singleton instance
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates) {
        // Implementation here
        return null;
    }

    // Method to generate the next unique ID
    public static int generateUniqueId() {
        return id++;  // Increment and return the id
    }
}
