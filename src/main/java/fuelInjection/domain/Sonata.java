package fuelInjection.domain;

public class Sonata extends Car {

    private static final String NAME = "Sonata";

    private static final int DISTANCE_PER_LITER = 10;

    public Sonata () {
    }

    public String getName() {
        return NAME;
    };

    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    };
}
