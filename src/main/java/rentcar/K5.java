package rentcar;

public class K5 extends Car {

    private static final int DISTANCE_PER_LITER = 13;

    public K5(double distance) {
        super(distance);
    }

    @Override
    public String getName() {
        return "K5";
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }
}
