package utilities;


public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        if (longitude < 0) {
            this.longitude = 0;
        } else {
            this.longitude = longitude;
        }
        if (latitude < 0) {
            this.latitude = 0;
        } else {
            this.latitude = latitude;
        }
        if (height < 0) {
            this.height = 0;
        } else if (height > 100) {
            this.height = 100;
        } else {
            this.height = height;
        }
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return "Coordinates: Longitude = " + longitude + ", Latitude = " + latitude + ", Height = " + height;
    }
}
