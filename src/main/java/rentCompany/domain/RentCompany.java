package rentCompany.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private static List<Car> cars;

    private RentCompany() {
        cars = new ArrayList<>();
    }

    public static RentCompany create() {

        return new RentCompany();
    }

    public String generateReport() {

        return "";
    }

    public void addCar(Car car) {
        cars.add(car);
    }

}
