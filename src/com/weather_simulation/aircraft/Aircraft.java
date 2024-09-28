import com.weather_simulation.aircraft.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    public void logMessage(String message) {
        System.out.println("[" + this.getClass().getSimpleName() + "] " + this.name + " (" + this.id + "): " + message);
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}
