package fuel.domain;

public class Sonata extends Car {

    private static final int FUEL_EFFICIENCY = 10;

    private final String carName;
    private final double distance;

    public Sonata(double distance) {
        this.carName = "Sonata";
        this.distance = distance;
    }

    @Override
    String getName() {
        return carName;
    }

    @Override
    double getChargeQuantity() {
        return distance / FUEL_EFFICIENCY;
    }

    @Override
    double getTripDistance() {
        return distance;
    }

    @Override
    double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }
}
