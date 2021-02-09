package oilInjection.model;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final List<Car> carList;

    private RentCompany() {
        carList = new ArrayList<>();
        addCar(Sonata.of(0));
        addCar(K5.of(0));
        addCar(Sonata.of(0));
        addCar(Avante.of(0));
        addCar(K5.of(0));
    }

    public void addCar(final Car car) {
        carList.add(car);
    }

    public String generateReport () {
        String report = "";
        return report;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public static RentCompany create () {
        return new RentCompany();
    }
}
