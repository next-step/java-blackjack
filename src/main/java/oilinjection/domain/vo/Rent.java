package oilinjection.domain.vo;

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
}
