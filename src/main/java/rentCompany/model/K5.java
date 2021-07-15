package rentCompany.model;

public class K5 implements Car {
    private static final int FUEL_EFFICIENCY = 13;

    private final String name;
    private final int distance;
    private final int fuelEfficiency;

    public K5(int distance) {
        this.name = "K5";
        this.distance = distance;
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

    @Override
    public int getFuelRequiredAmount() {
        return distance / fuelEfficiency;
    }
}
