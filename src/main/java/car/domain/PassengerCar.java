package car.domain;

public abstract class PassengerCar implements Car {

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
