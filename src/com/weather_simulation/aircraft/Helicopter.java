package aircraft;

import simulation.WeatherProvider;
import utilities.Coordinates;

public class Helicopter extends Aircraft {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getCurrentWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 10,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() + 2);
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 5,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() + 0);
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 1,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() + 0);
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() - 12);
                break;
            default:
                break;
        }
        this.logMessage(getWeatherMessage(weather));
    }
}
