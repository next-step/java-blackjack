package rentcar.domain;


import static rentcar.util.Constant.AVANTE_DISTANCE_PER_LITER;
import static rentcar.util.Constant.AVANTE_NAME;

public class Avante extends RentCar {

    private final double tripDistance;

    public Avante(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return AVANTE_DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return AVANTE_NAME;
    }
}
