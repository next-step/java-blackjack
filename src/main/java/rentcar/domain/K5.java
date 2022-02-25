package rentcar.domain;

public class K5 extends Car {

    private static final String NAME = "K5";
    private static final int DISTANCE_PER_LITER = 13;

    public K5(final int distance) {
        super(distance);
    }

    @Override
    double getTripDistance() {
        return this.distance;
    }

    @Override
    double getDistancePerLiter() {
        return this.DISTANCE_PER_LITER;
    }

    @Override
    String getCarName() {
        return NAME;
    }
}
