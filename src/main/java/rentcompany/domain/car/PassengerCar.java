package rentcompany.domain.car;

public abstract class PassengerCar implements Car {

    private final int distance;

    protected PassengerCar(final int distance) {
        this.distance = distance;
    }

    @Override
    public double getTripDistance() {
        return distance;
    }

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
