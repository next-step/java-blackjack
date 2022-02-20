package oilinjection.domain.car;

public abstract class Car {

    final double tripDistance;

    Car(final double tripDistance) {
        this.tripDistance = tripDistance;
    }

    abstract double getDistancePerLiter();

    public abstract String getType();

    public double getChargeQuantity() {
        return Math.ceil(tripDistance / getDistancePerLiter());
    }
}