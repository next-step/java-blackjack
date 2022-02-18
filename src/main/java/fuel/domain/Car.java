package fuel.domain;

abstract public class Car {

    protected final double tripDistance;

    protected Car(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    final double calculateChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    abstract double getDistancePerLiter();

    abstract double getTripDistance();

    abstract String getName();
}
