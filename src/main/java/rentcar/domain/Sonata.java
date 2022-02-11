package rentcar.domain;

public class Sonata extends Car {

    private static final String CAR_NAME = "sonata";
    private static final double DISTANCE_PER_LITER = 10;
    private final double distance;

    public Sonata(final double distance) {
        this.distance = distance;
    }

    @Override
    double getDistancePerLiter() {
        return 0;
    }

    @Override
    double getTripDistance() {
        return 0;
    }

    @Override
    String getName() {
        return null;
    }
}
