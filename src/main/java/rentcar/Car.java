package rentcar;

public abstract class Car implements MotorVehicle {

    protected final double distance;

    public Car(double distance) {
        this.distance = distance;
    }

    @Override
    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    public double getTripDistance() {
        return distance;
    }

    public abstract String getName();
}
