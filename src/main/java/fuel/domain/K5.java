package fuel.domain;

public class K5 implements Car {
    private final double distance;
    private final double DISTANCE_PER_LITER = 13.0;
    private final String NAME = "K5";

    public K5(final double distance) {
        this.distance = distance;
    }

    @Override
    public String getName() {
        return this.NAME;
    }

    @Override
    public double getChargeQuantity() {
        return getDistance() / getDISTANCE_PER_LITER();
    }

    private double getDistance() {
        return this.distance;
    }

    private double getDISTANCE_PER_LITER() {
        return this.DISTANCE_PER_LITER;
    }
}