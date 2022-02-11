package rentcar;

public abstract class Car implements MotorVehicle {

    public final double distance;
    public final String name;

    public Car(double distance, String name) {
        this.distance = distance;
        this.name = name;
    }

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
