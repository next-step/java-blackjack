package fuelInjection.domain;

public class Sonata extends Car {

    private static final String NAME = "Sonata";
    private static final int DISTANCE_PER_LITER = 10;
    private static final int TRIP_DISTANCE_MIN = 1;

    private final int tripDistance;

    public Sonata(int tripDistance) {
        this.tripDistance = tripDistance;

        validTripDistance();
    }

    public String getName() {
        return NAME;
    }

    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    public double getTripDistance() {
        return tripDistance;
    }

    private void validTripDistance() {
        if (isInvalidTripDistance()) {
            throw new IllegalArgumentException("[ERROR] 거리 값을 1이상 정수값을 입력해주세요.");
        }
    }

    private boolean isInvalidTripDistance() {
        return tripDistance < TRIP_DISTANCE_MIN;
    }
}
