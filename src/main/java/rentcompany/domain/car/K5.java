package rentcompany.domain.car;

public class K5 extends PassengerCar {

    private static final int MILEAGE = 13;

    private final int distance;

    public K5(int distance) {
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
