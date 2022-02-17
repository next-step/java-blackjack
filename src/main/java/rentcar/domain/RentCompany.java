package rentcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {

    private final List<Car> rentCars;

    private RentCompany() {
        this.rentCars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public String generateReport() {
        return rentCars.stream()
            .map(Car::generateReport)
            .collect(Collectors.joining("\n"));
    }

    public void addCar(Car car) {
        rentCars.add(car);
    }
}
