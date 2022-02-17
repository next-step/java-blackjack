package rentcar.domain;

public class Avante extends Car {

    private static final String NAME = "Avante";
    private static final double DISTANCE_PER_LITER = 15;
    private static final String VALIDATE_TRIP_DISTANCE_MESSAGE = "[ERROR] 여행거리는 0 이상입니다.";

    private double tripDistance;

    public Avante(double tripDistance) {
        validateTripDistance(tripDistance);
        this.tripDistance = tripDistance;
    }

    private void validateTripDistance(double tripDistance) {
        if (tripDistance < 0) {
            throw new IllegalArgumentException(VALIDATE_TRIP_DISTANCE_MESSAGE);
        }
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return NAME;
    }
}
