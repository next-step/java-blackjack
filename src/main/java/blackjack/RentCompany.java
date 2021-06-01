package blackjack;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    private List<Car> cars = new ArrayList<>();

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.getName() + " : " + (int) car.getChargeQuantity() + "리터" + NEWLINE);
        }
        return result.toString();
    }

    public List<Car> getCars() {
        return this.cars;
    }
}


