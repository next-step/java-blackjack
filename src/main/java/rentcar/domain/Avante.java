package rentcar.domain;

public class Avante implements Car {

    private static final String AVANTE_NAME = "AVANTE";
    private static final double DISTANCE_PER_LITER = 15;
    private double distance;

    public Avante(double distance) {
        this.distance = distance;
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return this.distance;
    }

    @Override
    public String getName() {
        return AVANTE_NAME;
    }
}
