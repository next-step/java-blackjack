package blackjack;

public class K5 extends Car{
    private static final double DISTANCE_PER_LITER = 13;
    private static final String NAME = "k5";
    private double tripDistance;

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
