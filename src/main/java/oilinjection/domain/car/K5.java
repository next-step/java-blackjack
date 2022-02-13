package oilinjection.domain.car;

public class K5 extends Car {

    private static final String CAR_NAME = "K5";
    private static final double K5_DISTANCE_PER_LITER = 13D;

    private final double tripDistance;

    public K5(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    double getDistancePerLiter() {
        return K5_DISTANCE_PER_LITER;
    }

    @Override
    String getName() {
        return CAR_NAME;
    }

    @Override
    double getTripDistance() {
        return this.tripDistance;
    }
}
