package simulation;

import utilities.Coordinates;

public class WeatherProvider {

    private static WeatherProvider instance;
    private String[] weather;

    private WeatherProvider() {
        // Constructor implementation
        this.weather = new String[] {"RAIN", "FOG", "SUN", "SNOW"};
    }

    public static WeatherProvider getInstance() {
        // Singleton instance
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int randomNumber = (int) (Math.random() * 4); // 0 to 3
        return weather[randomNumber];
    }
}
