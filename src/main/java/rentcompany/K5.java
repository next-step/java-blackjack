package rentcompany;

public class K5 extends Car{
    final static private String name = "K5";
    final static private int perLiter = 13;
    public  double tripDistance;

    public K5(int tripDistance){
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
