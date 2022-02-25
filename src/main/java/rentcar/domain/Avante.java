package rentcar.domain;

public class Avante extends Car {

    private static final String NAME = "Avante";
    private static final int DISTANCE_PER_LITER = 15;

    public Avante(final int distance) {
        super(distance);
    }

    @Override
    double getTripDistance() {
        return this.distance;
    }

    @Override
    double getDistancePerLiter() {
        return this.DISTANCE_PER_LITER;
    }

    @Override
    String getCarName() {
        return NAME;
    }
}
