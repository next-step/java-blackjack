package rentCompany;

public class Avante implements Car {
    public static final int INIT_DISTANCE = 0;
    private static final int FUEL_EFFICIENCY = 15;

    private final String name;
    private final int distance;
    private final int fuelEfficiency;

    public Avante() {
        this.name = "avante";
        this.distance = INIT_DISTANCE;
        this.fuelEfficiency = FUEL_EFFICIENCY;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public int getFuelEfficiency() {
        return this.fuelEfficiency;
    }
}
