import com.weather_simulation.aircraft.Flyable;
import com.weather_simulation.utilites.Coordinates;

public class AircraftFactory {

    private static AircraftFactory instance;

    private AircraftFactory() {
        // Constructor implementation
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
}
