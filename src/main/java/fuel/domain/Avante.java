package fuel.domain;

public class Avante extends Car {

    private static final String NAME = "Avante";
    private static final int DISTANCE_PER_LITER = 15;

    public Avante(double tripDistance) {
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
