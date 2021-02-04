package oilInjection.model;

public class K5 extends Car {
    private K5(Distance tripDistance) {
        this.tripDistance = tripDistance;
        this.distancePerLiter = 13;
        this.name = "Kfive";
    }

    @Override
    double getDistancePerLiter() {
        return this.distancePerLiter;
    }

    @Override
    Distance getTripDistance() {
        return this.tripDistance;
    }

    @Override
    String getName() {
        return this.name;
    }

    @Override
    void registerTripDistance(Distance tripDistance) {
        this.tripDistance = tripDistance;
    }

    public static K5 of(final double distance) {
        return new K5(new Distance(distance));
    }
}
