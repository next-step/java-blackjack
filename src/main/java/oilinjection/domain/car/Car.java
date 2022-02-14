package oilinjection.domain.car;

import java.util.Objects;

public abstract class Car {

    final double tripDistance;

    public Car(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    abstract double getDistancePerLiter();

    abstract String getName();

    double getTripDistance() {
        return this.tripDistance;
    }

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Double.compare(car.tripDistance, tripDistance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripDistance);
    }
}