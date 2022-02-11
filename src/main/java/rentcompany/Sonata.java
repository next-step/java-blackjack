package rentcompany;

public class Sonata extends Car {

    private static final String NAME = "Sonata";
    private static final double DISTANCE_PER_LITER = 10;
    private double distance;

    public Sonata(double distance) {
        this.distance = distance;
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return this.distance;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
