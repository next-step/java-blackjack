package oilInjection.model;

public abstract class Car {
    protected double distancePerLiter;
    protected double tripDistance;
    protected String name;

    abstract double getDistancePerLiter();
    abstract double getTripDistance();
    abstract String getName();

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
