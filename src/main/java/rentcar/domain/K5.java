package rentcar.domain;

import static rentcar.util.Constant.K5_DISTANCE_PER_LITER;

public class K5 extends Car {

    public K5(double tripDistance) {
    }

    @Override
    double getDistancePerLiter() {
        return K5_DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return 0;
    }

    @Override
    String getName() {
        return "0";
    }
}
