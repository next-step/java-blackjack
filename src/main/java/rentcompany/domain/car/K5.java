package rentcompany.domain.car;

public class K5 extends PassengerCar {

    private static final int MILEAGE = 13;


    public K5(final int distance) {
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
