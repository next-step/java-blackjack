package fuel.domain;

public class K5 extends Car {
    private static final int FUEL_EFFICIENCY = 13;

    public K5(final double distance) {
        super(distance, "K5");
    }

    @Override
    double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }
}
