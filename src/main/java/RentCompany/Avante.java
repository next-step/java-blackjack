package RentCompany;

public class Avante extends Car{

    final static private String name = "Avante";
    final static private int perLiter = 15;

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
