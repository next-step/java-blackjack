package oilinjection.domain.vo;

import java.util.Objects;

public class RentInfo {

    private final String type;
    private final double tripDistance;

    public RentInfo(final String type, final double tripDistance) {
        this.type = type;
        this.tripDistance = tripDistance;
    }

    public String getType() {
        return type;
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
        RentInfo rent = (RentInfo) o;
        return Double.compare(rent.tripDistance, tripDistance) == 0
            && Objects.equals(type, rent.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, tripDistance);
    }
}
