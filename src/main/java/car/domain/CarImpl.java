package car.domain;

public abstract class CarImpl implements Car {

    abstract double getDistancePerLiter();

    abstract double getTripDistance();

    abstract String getName();

    @Override
    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
