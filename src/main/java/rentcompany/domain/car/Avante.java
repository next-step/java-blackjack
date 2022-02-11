package rentcompany.domain.car;

public class Avante extends PassengerCar {

    private static final int MILEAGE = 15;

    private final int distance;

    public Avante(final int distance) {
        this.distance = distance;
    }

    @Override
    public double getDistancePerLiter() {
        return MILEAGE;
    }

    @Override
    public double getTripDistance() {
        return distance;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
