package blackjack;

public class Avante {
    private static final double DISTANCE_PER_LITER = 15;
    private static final String NAME = "Avante";
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

    public double getChargeQuantity() {
        return getTripDistance()/getDistancePerLiter();
    }
}
