package rentCompany.domain;

public class Sonata extends Car {

    private static final double FUEL_EFFICIENCY = 10;

    public Sonata(int tripDistance) {
        super("Sonata", tripDistance);
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
