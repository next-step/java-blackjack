package fuel.domain;

public class Avante extends Car{

    private static final int FUEL_EFFICIENCY = 15;
    private final String carName;
    private final double distance;

    public Avante(double distance) {
        this.distance = distance;
        this.carName = "Avante";
    }

    @Override
    double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }

    @Override
    double getTripDistance() {
        return distance;
    }

    @Override
    double getChargeQuantity() {
        return distance / FUEL_EFFICIENCY;
    }

    @Override
    String getName() {
        return carName;
    }
}
