package fuel.domain;

abstract public class Car {

    protected final double tripDistance;

    protected Car(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    abstract double getDistancePerLiter();

    abstract double getTripDistance();

    abstract String getName();

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
