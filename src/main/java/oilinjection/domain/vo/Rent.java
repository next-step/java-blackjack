package oilinjection.domain.vo;

import java.util.Objects;

public class Rent {

    private final String name;
    private final double tripDistance;

    public Rent(String name, double tripDistance) {
        this.name = name;
        this.tripDistance = tripDistance;
    }

    public String getName() {
        return name;
    }

    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rent rent = (Rent) o;
        return Double.compare(rent.tripDistance, tripDistance) == 0
            && Objects.equals(name, rent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tripDistance);
    }
}
