package aircraft;

import simulation.WeatherProvider;
import utilities.Coordinates;

public class Baloon extends Aircraft {

    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (WeatherProvider.getCurrentWeather(this.coordinates)) {
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
    }
}