package aircraft;

import utilities.Coordinates;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

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
}
