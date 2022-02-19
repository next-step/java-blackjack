package rentcar;

public class Avante extends Car {

    private static final int DISTANCE_PER_LITER = 15;

    public Avante(double distance) {
        super(distance);
    }

    @Override
    public String getName() {
        return "Avante";
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }
}
