package blackjack;

public class K5 extends Car{
    private static final double DISTANCE_PER_LITER = 13;
    private static final String NAME = "K5";
    private double tripDistance;

    public K5(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    public double getTripDistance() {
        return (int) tripDistance;
    }

    public String getName() {
        return NAME;
    }
}
