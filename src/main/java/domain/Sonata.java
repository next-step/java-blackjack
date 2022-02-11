package domain;

public class Sonata extends Car {

    private static final int DISTANCE_PER_LITER = 10;

    private final int distance;

    public Sonata(final int distance) {
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
