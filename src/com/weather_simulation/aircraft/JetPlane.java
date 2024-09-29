package aircraft;

import utilities.Coordinates;
import aircraft.*;

public class JetPlane extends Aircraft implements Flyable {

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        // Implementation here
    }
}
