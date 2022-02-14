package oilinjection.domain.car;

public abstract class Car {

    final double tripDistance;

    public Car(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    abstract double getDistancePerLiter();

    abstract String getName();

    double getTripDistance() {
        return this.tripDistance;
    }

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}