package fuelInjection.domain;

public class K5 {

    private static final String NAME = "K5";
    private static final double DISTANCE_PER_LITER = 13;
    private static final double TRIP_DISTANCE_MIN = 0;

    private final double tripDistance;

    public K5(double tripDistance) {
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

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    private void validTripDistance() {
        if (isInvalidTripDistance()) {
            throw new IllegalArgumentException("[ERROR] 거리 값을 0 이상 양수값을 입력해주세요.");
        }
    }

    private boolean isInvalidTripDistance() {
        return tripDistance < TRIP_DISTANCE_MIN;
    }
}
