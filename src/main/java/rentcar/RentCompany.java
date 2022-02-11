package rentcar;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private static final List<Car> cars = new ArrayList<>();
    private static final String NEWLINE = System.getProperty("line.separator");
    private static final String COLON = " : ";

    private RentCompany() {
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        final StringBuilder builder = new StringBuilder();
        cars.forEach(
            car -> builder.append(car.getName()).append(COLON).append((int) car.getChargeQuantity())
                .append("리터").append(NEWLINE));
        return builder.toString();
    }
}
