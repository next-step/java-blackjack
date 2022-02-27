package rentcompany.domain.car;

public class Avante extends PassengerCar {

    private static final int MILEAGE = 15;

    public Avante(final int distance) {
        super(distance);
    }

    @Override
    public double getDistancePerLiter() {
        return MILEAGE;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
