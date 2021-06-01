package blackjack;

public class K5 {
    private static final double DISTANCE_PER_LITER = 13;
    private static final String NAME = "k5";
    private double tripDistance;

    private double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    private double getTripDistance() {
        return tripDistance;
    }

    private String getName() {
        return NAME;
    }

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
