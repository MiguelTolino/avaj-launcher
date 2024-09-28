public class WeatherProvider {

    private static WeatherProvider instance;
    private String[] weather;

    private WeatherProvider() {
        // Constructor implementation
    }

    public static WeatherProvider getInstance() {
        // Singleton instance
        return instance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        // Implementation here
        return null;
    }
}
