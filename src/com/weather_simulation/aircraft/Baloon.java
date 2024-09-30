package aircraft;

import simulation.WeatherProvider;
import utilities.Coordinates;

public class Baloon extends Aircraft {

    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getCurrentWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 2,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() + 4);
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() - 5);
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() - 3);
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() - 15);
                break;
            default:
                break;
        }
        if (this.getCoordinates().getHeight() <= 0) {
            this.logMessage("Landing.");
            this.weatherTower.unregister(this);
        } else {
            this.logMessage(getWeatherMessage(weather));
        }
    }
}