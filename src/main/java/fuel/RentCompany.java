package fuel;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private static final String NEWLINE = "\n";
    private static final String REPORT_VIEW = "%s : %d리터" + NEWLINE;

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
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            stringBuilder.append(String.format(REPORT_VIEW, car.getName(), (int) car.getChargeQuantity()));
        }

        return stringBuilder.toString();
    }
}
