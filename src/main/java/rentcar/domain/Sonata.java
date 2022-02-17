package rentcar.domain;

import static rentcar.util.Constant.SONATA_DISTANCE_PER_LITER;
import static rentcar.util.Constant.SONATA_NAME;

public class Sonata extends RentCar {

    private final double tripDistance;
    public Sonata(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return SONATA_DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return SONATA_NAME;
    }
}
