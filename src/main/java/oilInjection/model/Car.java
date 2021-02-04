package oilInjection.model;

public abstract class Car {
    protected double distancePerLiter;
    protected Distance tripDistance;
    protected String name;

    abstract double getDistancePerLiter();
    abstract Distance getTripDistance();
    abstract String getName();

    double getChargeQuantity() {
        return getTripDistance().getDistance() / getDistancePerLiter();
    }
}
