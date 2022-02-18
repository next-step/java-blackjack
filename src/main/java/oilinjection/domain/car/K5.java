package oilinjection.domain.car;

public class K5 extends Car {

    private static final String CAR_TYPE = "K5";
    private static final double K5_DISTANCE_PER_LITER = 13D;

    public K5(final double tripDistance) {
        super(tripDistance);
    }

    @Override
    double getDistancePerLiter() {
        return K5_DISTANCE_PER_LITER;
    }

    @Override
    public String getType() {
        return CAR_TYPE;
    }
}
