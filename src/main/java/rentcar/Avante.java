package rentcar;

public class Avante extends Car {
    private final static String CAR_NAME = "아반떼";
    private final static int DISTANCE_PER_LITER = 15;
    private final double tripDistance;

    public Avante(double tripDistance) {
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