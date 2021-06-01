package blackjack;

public class Avante {
    private double distancePerLiter;
    private double tripDistance;
    private String name;

    public double getDistancePerLiter() {
        return distancePerLiter;
    }

    public double getTripDistance() {
        return tripDistance;
    }

    public String getName() {
        return name;
    }

    public double getChargeQuantity() {
        return getTripDistance()/getDistancePerLiter();
    }
}
