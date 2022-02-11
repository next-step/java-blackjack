package rentCompany.domain;

public class K5 extends Car {

    private static final double FUEL_EFFICIENCY = 13;

    public K5(int tripDistance) {
        super("K5", tripDistance);
    }

    @Override
    double getDistancePerLiter() {
        return tripDistance / FUEL_EFFICIENCY;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return name;
    }
}
