package oilInjection.model;

import java.util.Objects;

public class Distance {
    private final double distance;

    private Distance(final double distance){
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public static Distance of (double distance) {
        return new Distance(distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return Double.compare(distance1.distance, distance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
