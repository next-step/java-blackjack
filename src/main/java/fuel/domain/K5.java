package fuel.domain;

public class K5 extends Car {

    private static final int FUEL_EFFICIENCY = 13;
    private final String carName;
    private final double distance;

    public K5(double distance) {
        this.distance = distance;
        this.carName = "K5";
    }

    @Override
    double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }

    @Override
    double getTripDistance() {
        return distance;
    }

    @Override
    double getChargeQuantity() {
        return distance / FUEL_EFFICIENCY;
    }

    @Override
    String getName() {
        return carName;
    }
}
