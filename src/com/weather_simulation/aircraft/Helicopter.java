import com.weather_simulation.aircraft.Aircraft;

public class Helicopter extends Aircraft implements Flyable {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        // Implementation here
    }
}
