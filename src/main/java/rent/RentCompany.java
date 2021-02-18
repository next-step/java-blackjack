package rent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {

    private final List<Car> cars;

    private RentCompany() {
        cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        return cars.stream().map(
            car -> car.generateReport()
        ).collect(
            Collectors.joining("")
        );
    }
}
