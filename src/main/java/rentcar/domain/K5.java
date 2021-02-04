package rentcar.domain;

public class K5 implements Car {

    private static final String K5_NAME = "K5";
    private static final double DISTANCE_PER_LITER = 13;
    private double distance;

    public K5(double distance) {
        this.distance = distance;
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return this.distance;
    }

    @Override
    public String getName() {
        return K5_NAME;
    }
}
