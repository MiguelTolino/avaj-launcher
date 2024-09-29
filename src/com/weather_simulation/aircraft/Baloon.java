package aircraft;

import utilities.Coordinates;
import aircraft.Aircraft;

public class Baloon extends Aircraft {

    public Baloon(String name, Coordinates coordinates, long id) {
        super(name, coordinates, id);
    }

    @Override
    public void updateConditions() {
        // Implementation here
    }
}