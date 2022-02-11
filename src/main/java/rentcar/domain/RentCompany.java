package rentcar.domain;

import static rentcar.util.Constant.NEWLINE;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private static List<Car> rentCars;

    private RentCompany() {
        rentCars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        rentCars.add(car);
    }

    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : rentCars) {
            stringBuilder.append(car.toString()).append(NEWLINE);
        }
        return stringBuilder.toString();
    }
}
