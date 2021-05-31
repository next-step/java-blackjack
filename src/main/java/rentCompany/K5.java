package rentCompany;

import static rentCompany.Avante.INIT_DISTANCE;

public class K5 implements Car{
    private static final int FUEL_EFFICIENCY = 13;

    private final String name;
    private final int distance;
    private final int fuelEfficiency;

    public K5( ) {
        this.name = "K5";
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
