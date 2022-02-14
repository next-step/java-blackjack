package domain;

public abstract class Car {

    protected final int distance;

    public Car(int distance) {
        this.distance = distance;
    }

    abstract double getTripDistance();

    abstract double getDistancePerLiter();

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
