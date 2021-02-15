package fuel.domain;

public class Sonata implements Car {
    private final int distance;
    private final double DISTANCE_PER_LITER = 10.0;
    private final String NAME = "Sonata";

    public Sonata(final int distance) {
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