package fuel.domain;

public class Avante implements Car {
    private final int distance;
    private final double DISTANCE_PER_LITER = 15.0;
    private final String NAME = "Avante";

    public Avante(final int distance) {
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