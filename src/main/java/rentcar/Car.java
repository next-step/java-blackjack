package rentcar;

public abstract class Car implements MotorVehicle {

    protected final double distance;
    protected final String name;

    public Car(double distance, String name) {
        this.distance = distance;
        this.name = name;
    }

    @Override
    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    public double getTripDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
