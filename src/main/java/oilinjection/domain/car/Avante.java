package oilinjection.domain.car;

public class Avante extends Car {

    private static final String CAR_TYPE = "Avante";
    private static final double AVANTE_DISTANCE_PER_LITER = 15D;

    public Avante(final double tripDistance) {
        super(tripDistance);
    }

    @Override
    double getDistancePerLiter() {
        return AVANTE_DISTANCE_PER_LITER;
    }

    @Override
    public String getType() {
        return CAR_TYPE;
    }
}
