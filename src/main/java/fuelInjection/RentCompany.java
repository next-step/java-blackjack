package fuelInjection;

import fuelInjection.domain.Car;
import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private static final String NEWLINE = System.getProperty("line.separator");
    private static final String REPORT_FORM = "%s : %.0f리터";
    private final List<Car> rentCars;

    private RentCompany() {
        this.rentCars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public List<Car> getRentCars() {
        return rentCars;
    }

    public void addCar(Car car) {
        rentCars.add(car);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();

        rentCars.forEach(
            car -> report.append(String.format(REPORT_FORM, car.getName(), car.getChargeQuantity()))
                .append(NEWLINE)
        );

        return report.toString();
    }
}
