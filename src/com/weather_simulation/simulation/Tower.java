package simulation;

import java.util.ArrayList;
import java.util.List;

import aircraft.Aircraft;
import aircraft.Flyable;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        observers = new ArrayList<Flyable>();
    }

    public void register(Flyable flyable) {
        if (!observers.contains(flyable) && flyable != null) {
            Aircraft a = (Aircraft) flyable;
            System.out.print("Tower says: ");
            if (a.getCoordinates().getHeight() > 0) {
                a.logMessage("\u001B[32mRegistered to weather tower.\u001B[0m");
                observers.add(flyable);
            }
            else {
                a.logMessage("Cannot register to weather tower. Aircraft is already on the ground.");
            }
        }
    }

    public void unregister(Flyable flyable) {
        if (observers.contains(flyable)) {
            Aircraft a = (Aircraft) flyable;
            System.out.print("Tower says: ");
            a.logMessage("\u001B[31mUnregistered from weather tower.\u001B[0m");
            observers.remove(flyable);
        }
    }

    protected void conditionChanged() {
        List<Flyable> copyOfObservers = new ArrayList<>(observers);
        for (Flyable flyable : copyOfObservers) {
            if (observers.contains(flyable)) { // Check if the flyable is still registered
                flyable.updateConditions();
            }
        }
    }
}