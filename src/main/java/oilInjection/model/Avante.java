package oilInjection.model;

public class Avante extends Car {
    public Avante(double tripDistance){
        this.tripDistance = tripDistance;
        this.distancePerLiter = 15;
        this.name = "Avante";
    }

    @Override
    double getDistancePerLiter() {
        return this.distancePerLiter;
    }

    @Override
    double getTripDistance() {
        return this.tripDistance;
    }

    @Override
    String getName() {
        return this.name;
    }
}
