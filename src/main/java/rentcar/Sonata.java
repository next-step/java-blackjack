package rentcar;

public class Sonata extends Car {

    private static final int DISTANCE_PER_LITER = 10;

    public Sonata(double distance) {
        super(distance, "Sonata");
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }
}
