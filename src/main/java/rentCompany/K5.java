package rentCompany;

public class K5 implements Car{
    private final String name;
    private final int distance;
    private final int fuelEfficiency;

    public K5(int distance) {
        this.name = "K5";
        this.distance = distance;
        this.fuelEfficiency = 13;
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
