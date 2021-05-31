package RentCompany;

public class Avante extends AbstractCar {
    public final double FUEL_EFFICIENCY = 15;
    public final String CAR_KIND_NAME = "Avante";
    public double travel_distance;

    public Avante(double travel_distance) {
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
