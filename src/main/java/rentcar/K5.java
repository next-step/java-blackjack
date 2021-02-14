package rentcar;

public class K5 extends Car {
    private static final  String CAR_NAME = "K5";
    private static final  int DISTANCE_PER_LITER = 13;
    private final double tripDistance;

    public K5(double tripDistance) {
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
