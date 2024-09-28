package com.weather_simulation.aircraft;

import src.com.weather_simulation.aircraft.Aircraft;

public class JetPlane extends Aircraft implements Flyable {

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        // Implementation here
    }
}
