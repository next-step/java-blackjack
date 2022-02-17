package fuel.domain;

public class Avante extends Car{
    private static final int FUEL_EFFICIENCY = 15;

    public Avante(double distance) {
        super(distance, "Avante");
    }

    @Override
    double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }
}
