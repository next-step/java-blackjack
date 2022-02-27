package rentcar.domain;

public class Sonata extends Car {

    private static final String CAR_NAME = "Sonata";
    private static final double DISTANCE_PER_LITER = 10;
    private final double distance;

    public Sonata(final double distance) {
        this.distance = distance;
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return distance;
    }

    @Override
    String getName() {
        return CAR_NAME;
    }
}
