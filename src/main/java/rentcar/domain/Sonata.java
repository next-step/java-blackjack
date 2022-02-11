package rentcar.domain;

import static rentcar.util.Constant.SONATA_DISTANCE_PER_LITER;

public class Sonata extends Car {

    private final double tripDistance;
    public Sonata(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    double getDistancePerLiter() {
        return SONATA_DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return null;
    }
}
