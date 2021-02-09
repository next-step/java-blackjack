package oilInjection.model;

public class Avante extends Car {

    private Avante(Distance tripDistance) {
        this.tripDistance = tripDistance;
        this.distancePerLiter = 15;
        this.name = "Avante";
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
    public String getName() {
        return this.name;
    }

    @Override
    public void registerTripDistance(Distance tripDistance) {
        this.tripDistance = tripDistance;
    }

    public static Avante of(final double distance) {
        return new Avante(Distance.of(distance));
    }
}
