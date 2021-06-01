package blackjack;

public class Sonata {
    private static final double DISTANCE_PER_LITER = 10;
    private static final String NAME = "Sonata";
    private double tripDistance ;

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
        return getTripDistance()/getDistancePerLiter();
    }
}
