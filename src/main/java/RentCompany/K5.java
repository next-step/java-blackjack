package RentCompany;

public class K5 extends Car{

    final static private String name = "K5";
    final static private int perLiter = 13;

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
