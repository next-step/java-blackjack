package injection;

public class Sonata extends Car{
    private static final double DISTANCE_PER_LITER = 10;
    private static final String NAME = "Sonata";
    private double tripDistance ;

    public Sonata(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    public double getTripDistance() {
        return tripDistance;
    }

    public String getName() {
        return NAME;
    }
}
