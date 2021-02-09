package oilInjection.model;

public abstract class Car {
    protected double distancePerLiter;
    protected Distance tripDistance;
    protected String name;

    abstract double getDistancePerLiter();
    abstract Distance getTripDistance();
    public abstract String getName();
    abstract void registerTripDistance(Distance tripDistance);

    double getChargeQuantity() {
        return getTripDistance().getDistance() / getDistancePerLiter();
    }
}
