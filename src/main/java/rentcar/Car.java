package rentcar;

public abstract class Car implements MotorVehicle {
    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
