package rentcar.domain;

public abstract class Car {

    protected final int distance;

    public Car(int distance) {
        this.distance = distance;
    }

    public double getTripDistance() {
        return this.distance;
    }

    abstract double getDistancePerLiter();

    abstract String getCarName();

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
