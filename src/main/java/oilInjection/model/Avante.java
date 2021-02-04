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
    String getName() {
        return this.name;
    }

    public static Avante of(final double distance) {
        return new Avante(new Distance(distance));
    }
}
