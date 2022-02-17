package fuel.domain;

public abstract class Car {

    private final double distance;
    private final String carName;

    public Car(final double distance, final String carName) {
        this.distance = distance;
        this.carName = carName;
    }

    abstract double getDistancePerLiter();

    protected double getTripDistance() {
        return distance;
    }

    protected String getName() {
        return carName;
    }

    protected double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
