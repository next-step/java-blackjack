package rentcompany.domain.car;

public class Sonata extends PassengerCar {

    private static final int MILEAGE = 10;

    public Sonata(final int distance) {
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
