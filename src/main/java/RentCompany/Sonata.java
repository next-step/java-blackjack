package RentCompany;

public class Sonata extends Car{

    final static private String name = "Sonata";
    final static private int perLiter = 10;

    @Override
    double getDistancePerLiter() {
        return perLiter;
    }

    @Override
    double getTripDistance() {
        return 0;
    }

    @Override
    String getName() {
        return name;
    }
}
