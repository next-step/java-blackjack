package oilInjection.model;

public abstract class Car {
    protected double distancePerLiter;
    protected Distance tripDistance;
    protected String name;
    protected Oil oil;

    abstract double getDistancePerLiter();
    abstract Distance getTripDistance();
    public abstract String getName();
    public abstract void registerTripDistance(Distance tripDistance);

    public void injectOil() {
        double oilAmountNeeded = getTripDistance().getDistance() / getDistancePerLiter();
        oil = Oil.of(oilAmountNeeded);
    }

    public Oil getOil() {
        return oil;
    }
}
