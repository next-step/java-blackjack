package rentcompany.domain.car;

public abstract class PassengerCar implements Car {

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
