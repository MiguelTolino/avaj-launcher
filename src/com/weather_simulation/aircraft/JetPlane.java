package aircraft;

import simulation.WeatherProvider;
import utilities.Coordinates;

public class JetPlane extends Aircraft{

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getCurrentWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 10,
                        coordinates.getHeight() + 2);
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 5,
                        coordinates.getHeight() + 0);
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 1,
                        coordinates.getHeight() + 0);
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        coordinates.getLongitude() + 0,
                        coordinates.getLatitude() + 0,
                        coordinates.getHeight() - 7);
                break;
            default:
                break;
        }
    }
}
