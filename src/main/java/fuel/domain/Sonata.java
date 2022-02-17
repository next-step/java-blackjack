package fuel.domain;

public class Sonata extends Car {
    private static final int FUEL_EFFICIENCY = 10;

    public Sonata(double distance) {
       super(distance, "Sonata");
    }

    @Override
    double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }
}
