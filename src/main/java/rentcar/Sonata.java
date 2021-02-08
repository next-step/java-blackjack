package rentcar;

public class Sonata extends Car {
    private final static String CAR_NAME = "소나타";
    private final static int DISTANCE_PER_LITER = 10;
    private final double tripDistance;

    public Sonata(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return CAR_NAME;
    }

    @Override
    public String report() {
        return getName() + " : " + getChargeQuantity() + "리터";
    }
}