package RentCompany;

public class Sonata extends Car {
    public final double FUEL_EFFICIENCY = 10;
    public final String CAR_KIND_NAME = "Sonata";
    public double travel_distance;

    public Sonata(double travel_distance) {
        this.travel_distance = travel_distance;
    }

    @Override
    double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }

    @Override
    double getTripDistance() {
        return 0;
    }

    @Override
    String getName() {
        return CAR_KIND_NAME;
    }
}
