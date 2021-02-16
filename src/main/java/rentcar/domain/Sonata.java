package rentcar.domain;

public class Sonata implements Car {

    private static final String SONATA_NAME = "Sonata";
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
        return SONATA_NAME;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
