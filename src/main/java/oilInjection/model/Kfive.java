package oilInjection.model;

public class Kfive extends Car{
    public Kfive(double tripDistance){
        this.tripDistance = tripDistance;
        this.distancePerLiter = 13;
        this.name = "Kfive";
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
