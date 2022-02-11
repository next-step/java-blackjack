package rentcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {

    private static final String DELIMITER = " : ";
    private static final String LITER = "리터";
    private static final String NEW_LINE = "\n";

    private final List<Car> cars;

    private RentCompany() {
        this.cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        return cars.stream()
            .map(this::getCarInfo)
            .collect(Collectors.joining(NEW_LINE));
    }

    public String getCarInfo(Car car) {
        return car.getName() + DELIMITER + (int) car.getChargeQuantity() + LITER;
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }
}
