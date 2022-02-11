package rentcar;

public class K5 extends Car {

    private static final int DISTANCE_PER_LITER = 13;

    public K5(double distance) {
        super(distance, "K5");
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return distance;
    }

    @Override
    public String getName() {
        return name;
    }
}
