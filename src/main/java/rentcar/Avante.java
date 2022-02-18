package rentcar;

public class Avante extends Car {

    private static final int DISTANCE_PER_LITER = 15;

    public Avante(double distance) {
        super(distance, "Avante");
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }
}
