package RentCompany;

public class Sonata extends AbstractCar {
    public final double FUEL_EFFICIENCY = 10;
    public final String CAR_KIND_NAME = "Sonata";
    public double travel_distance;

    public Sonata(double travel_distance) {
        this.travel_distance = travel_distance;
    }

    @Override
    public double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }

    @Override
    public double getTripDistance() {
        return travel_distance;
    }

    @Override
    public String getName() {
        return CAR_KIND_NAME;
    }
}
