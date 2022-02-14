package oilinjection.domain.car;

public class K5 extends Car {

    private static final String CAR_NAME = "K5";
    private static final double K5_DISTANCE_PER_LITER = 13D;

    public K5(double tripDistance) {
        super(tripDistance);
    }

    @Override
    public double getDistancePerLiter() {
        return K5_DISTANCE_PER_LITER;
    }

    @Override
    public String getName() {
        return CAR_NAME;
    }
}
