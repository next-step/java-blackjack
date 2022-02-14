package domain;

import javax.print.attribute.standard.MediaSize.NA;

public class Sonata extends Car {

    private static final String NAME = "Sonata";
    private static final int DISTANCE_PER_LITER = 10;

    public Sonata(final int distance) {
        super(distance);
    }

    @Override
    double getTripDistance() {
        return this.distance;
    }

    @Override
    double getDistancePerLiter() {
        return this.DISTANCE_PER_LITER;
    }

    @Override
    String getCarName() {
        return NAME;
    }
}
