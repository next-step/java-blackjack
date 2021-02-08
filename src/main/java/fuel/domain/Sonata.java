package fuel.domain;

public class Sonata implements Car {
    private final int distance;
    private final double distancePerLiter = 10.0;

    public Sonata(final int distance) {
        this.distance = distance;
    }

    @Override
    public String getName() {
        return "Sonata";
    }

    @Override
    public double getChargeQuantity() {
        return getDistance() / getDistancePerLiter();
    }

    private double getDistance() {
        return this.distance;
    }

    private double getDistancePerLiter() {
        return this.distancePerLiter;
    }
}