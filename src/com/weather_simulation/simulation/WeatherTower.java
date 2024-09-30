package simulation;

import utilities.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        this.conditionChanged();
    }
}
