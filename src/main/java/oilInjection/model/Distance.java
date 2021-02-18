package oilInjection.model;

import java.util.Objects;

public class Distance {
    private final double distance;

    private Distance(final double distance){
        this.distance = distance;
        validate();
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

    public void validate(){
        if(distance < 0){
            throw new IllegalArgumentException("거리의 값이 0보다 작을 수 없습니다.");
        }
    }
}
