package aircraft;

import utilities.Coordinates;
import aircraft.Flyable;

public class Helicopter extends Aircraft implements Flyable {

    public Helicopter(String name, Coordinates coordinates, int coordinates) {
        super(name, coordinates, coordinates);
    }

    @Override
    public void updateConditions() {
        // Implementation here
    }
}
