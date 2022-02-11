package fuelInjection.domain;

import java.util.Objects;

public class K5 extends Car {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof K5)) {
            return false;
        }
        K5 k5 = (K5) o;
        return Double.compare(k5.tripDistance, tripDistance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripDistance);
    }
}
