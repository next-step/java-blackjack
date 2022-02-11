package rentcar.domain;


import static rentcar.util.Constant.AVANTE_DISTANCE_PER_LITER;
import static rentcar.util.Constant.AVANTE_NAME;

public class Avante extends Car {

    private final double tripDistance;

    public Avante(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    double getDistancePerLiter() {
        return AVANTE_DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return AVANTE_NAME;
    }
}
