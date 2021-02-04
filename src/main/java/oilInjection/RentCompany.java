package oilInjection;

import oilInjection.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final List<Car> carList = new ArrayList<>();

    private RentCompany() {
    }

    public void addCar(final Car car) {
        carList.add(car);
    }

    public String generateReport () {
        String report = "";
        return report;
    }

    public static RentCompany create () {
        return new RentCompany();
    }
}
