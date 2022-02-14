package rentcar.domain;

import static rentcar.util.Constant.K5_DISTANCE_PER_LITER;
import static rentcar.util.Constant.K5_NAME;

public class K5 extends RentCar {

    private final double tripDistance;

    public K5(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return K5_DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return K5_NAME;
    }
}
