package oilinjection.domain.car;

public class Sonata extends Car {

    private static final String CAR_NAME = "Sonata";
    private static final double SONATA_DISTANCE_PER_LITER = 10D;

    private final double tripDistance;

    public Sonata(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    double getDistancePerLiter() {
        return SONATA_DISTANCE_PER_LITER;
    }

    @Override
    String getName() {
        return CAR_NAME;
    }

    @Override
    double getTripDistance() {
        return this.tripDistance;
    }
}
