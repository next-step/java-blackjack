package domain;

public abstract class Car {

    abstract double getTripDistance();

    abstract double getDistancePerLiter();

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
