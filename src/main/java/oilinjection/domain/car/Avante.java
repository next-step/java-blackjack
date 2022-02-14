package oilinjection.domain.car;

public class Avante extends Car {

    private static final String CAR_NAME = "Avante";
    private static final double AVANTE_DISTANCE_PER_LITER = 15D;

    public Avante(double tripDistance) {
        super(tripDistance);
    }

    @Override
    double getDistancePerLiter() {
        return AVANTE_DISTANCE_PER_LITER;
    }

    @Override
    String getName() {
        return CAR_NAME;
    }
}
