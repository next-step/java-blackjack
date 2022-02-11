package domain;

public class K5 extends Car {

    private static final int DISTANCE_PER_LITER = 13;

    private final int distance;

    public K5(final int distance) {
        this.distance = distance;
    }

    @Override
    double getTripDistance() {
        return this.distance;
    }

    @Override
    double getDistancePerLiter() {
        return this.DISTANCE_PER_LITER;
    }
}
