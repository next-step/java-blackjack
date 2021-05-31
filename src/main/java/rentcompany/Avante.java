package rentcompany;

public class Avante extends Car{

    final static private String name = "Avante";
    final static private int perLiter = 15;
    public double tripDistance;
    public Avante(int tripDistance){
        this.tripDistance = tripDistance;
    }
    @Override
    double getDistancePerLiter() {
        return perLiter;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return name;
    }
}
