package rentCompany.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String COLON = " : ";
    private static final String LITTER="리터\n";

    private static List<Car> cars;

    private RentCompany() {
        cars = new ArrayList<>();
    }

    public static RentCompany create() {

        return new RentCompany();
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for (Car car : cars) {
            report.append(car.getName());
            report.append(COLON);
            report.append((int) (car.getDistancePerLiter()));
            report.append(LITTER);
        }
        return report.toString();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

}
