package simulation;

import java.util.ArrayList;
import java.util.List;

import aircraft.Aircraft;
import aircraft.Flyable;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        // Constructor implementation
        observers = new ArrayList<Flyable>();
    }

    public void register(Flyable flyable) {
        if (!observers.contains(flyable) && flyable != null) {
            Aircraft a = (Aircraft) flyable;
            if (a.getCoordinates().getHeight() > 0) {
                a.logMessage("Registered to weather tower.");
                observers.add(flyable);
            }
            else {
                a.logMessage("Cannot register to weather tower. Aircraft is already on the ground.");
            }
        }
    }

    public void unregister(Flyable flyable) {
        if (observers.contains(flyable)) {
            observers.remove(flyable);
        }
    }

    protected void conditionChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}