package rentcar.domain;

public class Sonata extends Car {

    private static final String NAME = "Sonata";
    private static final double DISTANCE_PER_LITER = 10;
    private static final String VALIDATE_TRIP_DISTANCE_MESSAGE = "[ERROR] 여행거리는 0 이상입니다.";

    private double tripDistance;

    public Sonata(double tripDistance) {
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
