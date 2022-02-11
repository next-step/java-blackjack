package rentcar.domain;

public class Avante extends Car {

    private static final String CAR_NAME = "Avante";
    private static final double DISTANCE_PER_LITER = 15;
    private final double distance;

    public Avante(final double distance) {
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
