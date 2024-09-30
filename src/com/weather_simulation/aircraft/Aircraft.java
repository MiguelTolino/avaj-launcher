package aircraft;

import utilities.Coordinates;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected final String[] weatherMessages = {
        "Sunshine makes me feel like I can fly forever!",
        "Rain, rain, go away, or at least don't make me sway!",
        "Fog's thick today, hope I don't lose my way!",
        "Snow is silent, but it makes my journey quite vibrant!"
    };

    protected Aircraft(long id, String name, Coordinates coordinates) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Aircraft name cannot be null or empty.");
        }
        if (coordinates == null) {
            throw new IllegalArgumentException("Aircraft coordinates cannot be null.");
        }
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

    public void updateConditions() {
        // Implementation here
    }

    protected String getWeatherMessage(String weather) {
        switch (weather) {
            case "SUN":
                return weatherMessages[0];
            case "RAIN":
                return weatherMessages[1];
            case "FOG":
                return weatherMessages[2];
            case "SNOW":
                return weatherMessages[3];
            default:
                return "";
        }
    }
}
