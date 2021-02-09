package oilInjection.model;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final List<Car> carList;
    private final String reportForm = "%s : %f \n";

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

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for (Car car : carList) {
            report.append(String.format(reportForm, car.getName(), car.getOil().getAmount()));
        }
        return report.toString();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public static RentCompany create() {
        return new RentCompany();
    }
}
