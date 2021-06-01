package blackjack;

public class Avante {
    private static final double DISTANCE_PER_LITER = 15;
    private static final String NAME = "Avante";
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
        return getTripDistance()/getDistancePerLiter();
    }
}
