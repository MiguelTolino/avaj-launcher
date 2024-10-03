package exceptions;

import java.lang.Exception;

public class AircraftException {
    public static class InvalidAircraftNameException extends Exception {
        public InvalidAircraftNameException(String message) {
        super(message);
        }
    }

    public static class InvalidAircraftCoordinatesException extends Exception {
        public InvalidAircraftCoordinatesException(String message) {
        super(message);
        }
    }
}
