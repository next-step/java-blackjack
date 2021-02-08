package fuel.domain;

public class Avante implements Car {
    private final int distance;
    private final double distancePerLiter = 15.0;

    public Avante(final int distance) {
        this.distance = distance;
    }

    @Override
    public String getName() {
        return "Avante";
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