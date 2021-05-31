package RentCompany;

public class Avante extends Car {
    public final double FUEL_EFFICIENCY = 15;
    public final String CAR_KIND_NAME = "Avante";
    public double travel_distance;

    public Avante(double travel_distance) {
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
