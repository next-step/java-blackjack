package rentCompany;

public class Avante implements Car {
    private final String name;
    private final int distance;
    private final int fuelEfficiency;

    public Avante(int distance) {
        this.name = "avante";
        this.distance = distance;
        this.fuelEfficiency = 15;

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
