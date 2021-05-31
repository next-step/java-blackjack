package RentCompany;

public class K5 extends Car{
    public final double FUEL_EFFICIENCY = 13;
    public final String CAR_KIND_NAME = "K5";
    public double travel_distance;

    public K5(double travel_distance) {
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
