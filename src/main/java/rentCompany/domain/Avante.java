package rentCompany.domain;

public class Avante extends Car {

    private static final String CAR_NAME = "Avante";
    private static final double FUEL_EFFICIENCY = 15;

    public Avante(int tripDistance) {
        super(CAR_NAME, tripDistance);
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
