package domain;

public class Avante extends Car {

    private static final int DISTANCE_PER_LITER = 15;

    private final int distance;

    public Avante(final int distance) {
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
