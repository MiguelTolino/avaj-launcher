package simulation;

import utilities.Coordinates;

public class WeatherProvider {

    private static WeatherProvider instance;
    private final static String[] types = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
        // Constructor implementation

    }

    public static WeatherProvider getInstance() {
        // Singleton instance
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public static String getCurrentWeather(Coordinates coordinates) {
        int randomNumber = (int) (Math.random() * 4); // 0 to 3
        return types[randomNumber];
    }
}
