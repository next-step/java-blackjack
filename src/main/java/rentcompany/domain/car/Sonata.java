package rentcompany.domain.car;

public class Sonata extends PassengerCar {

    private static final int MILEAGE = 10;

    private final int distance;

    public Sonata(final int distance) {
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
