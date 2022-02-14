package oilinjection.domain.car;

public class Sonata extends Car {

    private static final String CAR_TYPE = "Sonata";
    private static final double SONATA_DISTANCE_PER_LITER = 10D;

    public Sonata(final double tripDistance) {
        super(tripDistance);
    }

    @Override
    double getDistancePerLiter() {
        return SONATA_DISTANCE_PER_LITER;
    }

    @Override
    public String getType() {
        return CAR_TYPE;
    }
}
