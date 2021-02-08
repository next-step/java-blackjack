package fuel.domain;

public class K5 implements Car {
    private final double distance;
    private final double distancePerLiter = 13.0;

    public K5(final double distance) {
        this.distance = distance;
    }

    @Override
    public String getName() {
        return "K5";
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