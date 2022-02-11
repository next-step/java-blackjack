package fuel.domain;

public class Sonata extends Car {

    private static final String NAME = "Sonata";
    private static final int DISTANCE_PER_LITER = 10;

    public Sonata(double tripDistance) {
        super(tripDistance);
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return NAME;
    }
}
