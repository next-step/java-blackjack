package rentcar;

public abstract class Car implements MotorVehicle {
    private final int distance;

    public Car (int distance) {
        this.distance = distance;
    }

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
