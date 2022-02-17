package rentcompany;

public class Avante extends Car{

    private static final String NAME = "Avante";
    private static final double DISTANCE_PER_LITER = 15;
    private double distance;

    public Avante(double distance) {
        this.distance = distance;
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return this.distance;
    }

    @Override
    String getName() {
        return NAME;
    }
}
