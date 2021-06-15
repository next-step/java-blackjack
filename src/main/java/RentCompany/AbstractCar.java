package RentCompany;

public abstract class AbstractCar implements Car {

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
